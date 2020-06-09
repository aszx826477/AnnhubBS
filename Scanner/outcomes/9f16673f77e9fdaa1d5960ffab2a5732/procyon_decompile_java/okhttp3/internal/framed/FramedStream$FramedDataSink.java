// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.AsyncTimeout;
import java.util.Collection;
import java.util.ArrayList;
import okio.BufferedSource;
import okio.Source;
import java.io.InterruptedIOException;
import java.io.IOException;
import java.util.List;
import okio.Timeout;
import okio.Buffer;
import okio.Sink;

final class FramedStream$FramedDataSink implements Sink
{
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer;
    final /* synthetic */ FramedStream this$0;
    
    FramedStream$FramedDataSink(final FramedStream this$0) {
        this.this$0 = this$0;
        this.sendBuffer = new Buffer();
    }
    
    private void emitDataFrame(final boolean b) {
        Object o = this.this$0;
        synchronized (o) {
            this.this$0.writeTimeout.enter();
            try {
                while (this.this$0.bytesLeftInWriteWindow <= 0L && !this.finished && !this.closed && this.this$0.errorCode == null) {
                    this.this$0.waitForIo();
                }
                this.this$0.writeTimeout.exitAndThrowIfTimedOut();
                this.this$0.checkOutNotClosed();
                final long min = Math.min(this.this$0.bytesLeftInWriteWindow, this.sendBuffer.size());
                final FramedStream this$0 = this.this$0;
                this$0.bytesLeftInWriteWindow -= min;
                // monitorexit(o)
                o = this.this$0.writeTimeout;
                ((AsyncTimeout)o).enter();
                try {
                    this.this$0.connection.writeData(this.this$0.id, b && min == this.sendBuffer.size(), this.sendBuffer, min);
                }
                finally {
                    this.this$0.writeTimeout.exitAndThrowIfTimedOut();
                }
            }
            finally {
                this.this$0.writeTimeout.exitAndThrowIfTimedOut();
            }
        }
    }
    
    public void close() {
        Object o = this.this$0;
        synchronized (o) {
            if (this.closed) {
                return;
            }
            // monitorexit(o)
            o = this.this$0.sink;
            final boolean finished = ((FramedStream$FramedDataSink)o).finished;
            final boolean closed = true;
            if (!finished) {
                o = this.sendBuffer;
                final long size = ((Buffer)o).size();
                final long n = 0L;
                if (size > n) {
                    while (true) {
                        o = this.sendBuffer;
                        if (((Buffer)o).size() <= n) {
                            break;
                        }
                        this.emitDataFrame(closed);
                    }
                }
                else {
                    final FramedConnection access$500 = this.this$0.connection;
                    o = this.this$0;
                    access$500.writeData(((FramedStream)o).id, true, null, 0L);
                }
            }
            synchronized (this.this$0) {
                this.closed = closed;
                // monitorexit(this.this$0)
                this.this$0.connection.flush();
                this.this$0.cancelStreamIfNecessary();
            }
        }
    }
    
    public void flush() {
        Object o = this.this$0;
        synchronized (o) {
            this.this$0.checkOutNotClosed();
            // monitorexit(o)
            while (true) {
                o = this.sendBuffer;
                if (((Buffer)o).size() <= 0L) {
                    break;
                }
                this.emitDataFrame(false);
                o = this.this$0.connection;
                ((FramedConnection)o).flush();
            }
        }
    }
    
    public Timeout timeout() {
        return this.this$0.writeTimeout;
    }
    
    public void write(final Buffer buffer, final long n) {
        this.sendBuffer.write(buffer, n);
        while (this.sendBuffer.size() >= 16384L) {
            this.emitDataFrame(false);
        }
    }
}
