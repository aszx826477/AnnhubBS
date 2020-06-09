// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.EOFException;
import okio.Buffer;
import java.util.Collection;
import java.util.ArrayList;
import okio.BufferedSource;
import okio.Timeout;
import okio.Source;
import okio.Sink;
import java.io.InterruptedIOException;
import java.io.IOException;
import java.util.List;

public final class FramedStream
{
    long bytesLeftInWriteWindow;
    private final FramedConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final FramedStream$StreamTimeout readTimeout;
    private final List requestHeaders;
    private List responseHeaders;
    final FramedStream$FramedDataSink sink;
    private final FramedStream$FramedDataSource source;
    long unacknowledgedBytesRead;
    private final FramedStream$StreamTimeout writeTimeout;
    
    FramedStream(final int id, final FramedConnection connection, final boolean b, final boolean b2, final List requestHeaders) {
        this.unacknowledgedBytesRead = 0L;
        this.readTimeout = new FramedStream$StreamTimeout(this);
        this.writeTimeout = new FramedStream$StreamTimeout(this);
        this.errorCode = null;
        if (connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (requestHeaders != null) {
            this.id = id;
            this.connection = connection;
            final Settings peerSettings = connection.peerSettings;
            final int n = 65536;
            this.bytesLeftInWriteWindow = peerSettings.getInitialWindowSize(n);
            this.source = new FramedStream$FramedDataSource(this, connection.okHttpSettings.getInitialWindowSize(n), null);
            this.sink = new FramedStream$FramedDataSink(this);
            this.source.finished = b2;
            this.sink.finished = b;
            this.requestHeaders = requestHeaders;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }
    
    private void cancelStreamIfNecessary() {
        synchronized (this) {
            final boolean b = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            final boolean open = this.isOpen();
            // monitorexit(this)
            if (b) {
                this.close(ErrorCode.CANCEL);
            }
            else if (!open) {
                this.connection.removeStream(this.id);
            }
        }
    }
    
    private void checkOutNotClosed() {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        }
        if (this.sink.finished) {
            throw new IOException("stream finished");
        }
        final ErrorCode errorCode = this.errorCode;
        if (errorCode == null) {
            return;
        }
        throw new StreamResetException(errorCode);
    }
    
    private boolean closeInternal(final ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            this.notifyAll();
            // monitorexit(this)
            this.connection.removeStream(this.id);
            return true;
        }
    }
    
    private void waitForIo() {
        try {
            this.wait();
        }
        catch (InterruptedException ex) {
            throw new InterruptedIOException();
        }
    }
    
    void addBytesToWriteWindow(final long n) {
        this.bytesLeftInWriteWindow += n;
        if (n > 0L) {
            this.notifyAll();
        }
    }
    
    public void close(final ErrorCode errorCode) {
        if (!this.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynReset(this.id, errorCode);
    }
    
    public void closeLater(final ErrorCode errorCode) {
        if (!this.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynResetLater(this.id, errorCode);
    }
    
    public FramedConnection getConnection() {
        return this.connection;
    }
    
    public ErrorCode getErrorCode() {
        synchronized (this) {
            return this.errorCode;
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public List getRequestHeaders() {
        return this.requestHeaders;
    }
    
    public List getResponseHeaders() {
        synchronized (this) {
            this.readTimeout.enter();
            try {
                while (this.responseHeaders == null && this.errorCode == null) {
                    this.waitForIo();
                }
                this.readTimeout.exitAndThrowIfTimedOut();
                if (this.responseHeaders != null) {
                    return this.responseHeaders;
                }
                throw new StreamResetException(this.errorCode);
            }
            finally {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
        }
    }
    
    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null && !this.isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.sink;
        }
    }
    
    public Source getSource() {
        return this.source;
    }
    
    public boolean isLocallyInitiated() {
        final int id = this.id;
        boolean b = true;
        if (this.connection.client != ((id & (b ? 1 : 0)) == (b ? 1 : 0))) {
            b = false;
        }
        return b;
    }
    
    public boolean isOpen() {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished || this.source.closed) {
                if ((this.sink.finished || this.sink.closed) && this.responseHeaders != null) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public Timeout readTimeout() {
        return this.readTimeout;
    }
    
    void receiveData(final BufferedSource bufferedSource, final int n) {
        this.source.receive(bufferedSource, n);
    }
    
    void receiveFin() {
        synchronized (this) {
            this.source.finished = true;
            final boolean open = this.isOpen();
            this.notifyAll();
            // monitorexit(this)
            if (!open) {
                this.connection.removeStream(this.id);
            }
        }
    }
    
    void receiveHeaders(final List responseHeaders, final HeadersMode headersMode) {
        ErrorCode errorCode = null;
        int open = 1;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                }
                else {
                    this.responseHeaders = responseHeaders;
                    open = (this.isOpen() ? 1 : 0);
                    this.notifyAll();
                }
            }
            else if (headersMode.failIfHeadersPresent()) {
                errorCode = ErrorCode.STREAM_IN_USE;
            }
            else {
                final ArrayList responseHeaders2 = new ArrayList();
                responseHeaders2.addAll(this.responseHeaders);
                responseHeaders2.addAll(responseHeaders);
                this.responseHeaders = responseHeaders2;
            }
            // monitorexit(this)
            if (errorCode != null) {
                this.closeLater(errorCode);
            }
            else if (open == 0) {
                this.connection.removeStream(this.id);
            }
        }
    }
    
    void receiveRstStream(final ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode == null) {
                this.errorCode = errorCode;
                this.notifyAll();
            }
        }
    }
    
    public void reply(final List responseHeaders, final boolean b) {
        boolean b2 = false;
        // monitorenter(this)
        Label_0116: {
            if (responseHeaders == null) {
                break Label_0116;
            }
            try {
                if (this.responseHeaders == null) {
                    this.responseHeaders = responseHeaders;
                    if (!b) {
                        this.sink.finished = true;
                        b2 = true;
                    }
                    // monitorexit(this)
                    this.connection.writeSynReply(this.id, b2, responseHeaders);
                    if (b2) {
                        this.connection.flush();
                    }
                    return;
                }
                throw new IllegalStateException("reply already sent");
            }
            finally {
                // monitorexit(this)
                throw new NullPointerException("responseHeaders == null");
            }
        }
    }
    
    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
