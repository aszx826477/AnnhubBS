// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.Collection;
import java.util.ArrayList;
import okio.Sink;
import java.io.InterruptedIOException;
import java.util.List;
import okio.Timeout;
import java.io.EOFException;
import okio.BufferedSource;
import java.io.IOException;
import okio.Buffer;
import okio.Source;

final class FramedStream$FramedDataSource implements Source
{
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer;
    private final Buffer receiveBuffer;
    final /* synthetic */ FramedStream this$0;
    
    private FramedStream$FramedDataSource(final FramedStream this$0, final long maxByteCount) {
        this.this$0 = this$0;
        this.receiveBuffer = new Buffer();
        this.readBuffer = new Buffer();
        this.maxByteCount = maxByteCount;
    }
    
    private void checkNotClosed() {
        if (this.closed) {
            throw new IOException("stream closed");
        }
        if (this.this$0.errorCode == null) {
            return;
        }
        throw new StreamResetException(this.this$0.errorCode);
    }
    
    private void waitUntilReadable() {
        this.this$0.readTimeout.enter();
        try {
            while (this.readBuffer.size() == 0L && !this.finished && !this.closed && this.this$0.errorCode == null) {
                this.this$0.waitForIo();
            }
        }
        finally {
            this.this$0.readTimeout.exitAndThrowIfTimedOut();
        }
    }
    
    public void close() {
        final FramedStream this$0 = this.this$0;
        // monitorenter(this$0)
        final boolean closed = true;
        try {
            this.closed = closed;
            this.readBuffer.clear();
            this.this$0.notifyAll();
            // monitorexit(this$0)
            this.this$0.cancelStreamIfNecessary();
        }
        finally {
        }
        // monitorexit(this$0)
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n >= n2) {
            Object o = this.this$0;
            synchronized (o) {
                this.waitUntilReadable();
                this.checkNotClosed();
                if (this.readBuffer.size() == n2) {
                    return -1;
                }
                final long read = this.readBuffer.read(buffer, Math.min(n, this.readBuffer.size()));
                final FramedStream this$0 = this.this$0;
                this$0.unacknowledgedBytesRead += read;
                final long unacknowledgedBytesRead = this.this$0.unacknowledgedBytesRead;
                final Settings okHttpSettings = this.this$0.connection.okHttpSettings;
                final int n3 = 65536;
                if (unacknowledgedBytesRead >= okHttpSettings.getInitialWindowSize(n3) / 2) {
                    this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
                    this.this$0.unacknowledgedBytesRead = n2;
                }
                // monitorexit(o)
                o = this.this$0;
                synchronized (((FramedStream)o).connection) {
                    o = this.this$0;
                    o = ((FramedStream)o).connection;
                    ((FramedConnection)o).unacknowledgedBytesRead += read;
                    o = this.this$0;
                    o = ((FramedStream)o).connection;
                    final long unacknowledgedBytesRead2 = ((FramedConnection)o).unacknowledgedBytesRead;
                    o = this.this$0;
                    o = ((FramedStream)o).connection;
                    o = ((FramedConnection)o).okHttpSettings;
                    if (unacknowledgedBytesRead2 >= ((Settings)o).getInitialWindowSize(n3) / 2) {
                        o = this.this$0;
                        o = ((FramedStream)o).connection;
                        ((FramedConnection)o).writeWindowUpdateLater(0, this.this$0.connection.unacknowledgedBytesRead);
                        o = this.this$0;
                        o = ((FramedStream)o).connection;
                        ((FramedConnection)o).unacknowledgedBytesRead = n2;
                    }
                    return read;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    void receive(final BufferedSource bufferedSource, long size) {
        while (true) {
            final long n = 0L;
            if (size > n) {
                Object o = this.this$0;
                synchronized (o) {
                    final boolean finished = this.finished;
                    final long n2 = this.readBuffer.size() + size;
                    final long maxByteCount = this.maxByteCount;
                    boolean b = true;
                    final boolean b2 = n2 > maxByteCount;
                    // monitorexit(o)
                    if (b2) {
                        bufferedSource.skip(size);
                        this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    }
                    if (finished) {
                        bufferedSource.skip(size);
                        return;
                    }
                    o = this.receiveBuffer;
                    final long read = bufferedSource.read((Buffer)o, size);
                    if (read != -1) {
                        final long n3 = size - read;
                        synchronized (this.this$0) {
                            size = this.readBuffer.size();
                            if (size != n) {
                                b = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (b) {
                                this.this$0.notifyAll();
                            }
                            // monitorexit(this.this$0)
                            size = n3;
                            continue;
                        }
                    }
                    throw new EOFException();
                }
                break;
            }
            break;
        }
    }
    
    public Timeout timeout() {
        return this.this$0.readTimeout;
    }
}
