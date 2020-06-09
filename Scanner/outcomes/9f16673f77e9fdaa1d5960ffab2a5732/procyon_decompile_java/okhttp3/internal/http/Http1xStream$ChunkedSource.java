// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.io.EOFException;
import java.io.IOException;
import okhttp3.Response$Builder;
import okhttp3.internal.Internal;
import okhttp3.Headers$Builder;
import okhttp3.Headers;
import okio.Okio;
import okhttp3.ResponseBody;
import okio.Sink;
import okhttp3.Request;
import okhttp3.internal.connection.RealConnection;
import okhttp3.Response;
import okio.Timeout;
import okio.ForwardingTimeout;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okhttp3.OkHttpClient;
import okio.Buffer;
import okio.Source;
import okhttp3.internal.Util;
import java.util.concurrent.TimeUnit;
import okio.BufferedSource;
import java.net.ProtocolException;
import okhttp3.HttpUrl;

class Http1xStream$ChunkedSource extends Http1xStream$AbstractSource
{
    private static final long NO_CHUNK_YET = 255L;
    private long bytesRemainingInChunk;
    private boolean hasMoreChunks;
    final /* synthetic */ Http1xStream this$0;
    private final HttpUrl url;
    
    Http1xStream$ChunkedSource(final Http1xStream this$0, final HttpUrl url) {
        this.this$0 = this$0;
        super(this$0, null);
        this.bytesRemainingInChunk = -1;
        this.hasMoreChunks = true;
        this.url = url;
    }
    
    private void readChunkSize() {
        if (this.bytesRemainingInChunk != -1) {
            this.this$0.source.readUtf8LineStrict();
        }
        try {
            final Http1xStream this$0 = this.this$0;
            try {
                final BufferedSource access$600 = this$0.source;
                try {
                    this.bytesRemainingInChunk = access$600.readHexadecimalUnsignedLong();
                    final Http1xStream this$2 = this.this$0;
                    try {
                        final BufferedSource access$601 = this$2.source;
                        try {
                            final String utf8LineStrict = access$601.readUtf8LineStrict();
                            try {
                                final String trim = utf8LineStrict.trim();
                                try {
                                    final long bytesRemainingInChunk = this.bytesRemainingInChunk;
                                    final long n = 0L;
                                    if (bytesRemainingInChunk >= n && (trim.isEmpty() || trim.startsWith(";"))) {
                                        if (this.bytesRemainingInChunk == n) {
                                            this.hasMoreChunks = false;
                                            HttpHeaders.receiveHeaders(this.this$0.client.cookieJar(), this.url, this.this$0.readHeaders());
                                            this.endOfInput(true);
                                        }
                                        return;
                                    }
                                    try {
                                        try {
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append("expected chunk size and optional extensions but was \"");
                                            sb.append(this.bytesRemainingInChunk);
                                            final StringBuilder sb2 = sb;
                                            try {
                                                sb2.append(trim);
                                                sb.append("\"");
                                                throw new ProtocolException(sb.toString());
                                            }
                                            catch (NumberFormatException ex) {
                                                throw new ProtocolException(ex.getMessage());
                                            }
                                        }
                                        catch (NumberFormatException ex2) {}
                                    }
                                    catch (NumberFormatException ex3) {}
                                }
                                catch (NumberFormatException ex4) {}
                            }
                            catch (NumberFormatException ex5) {}
                        }
                        catch (NumberFormatException ex6) {}
                    }
                    catch (NumberFormatException ex7) {}
                }
                catch (NumberFormatException ex8) {}
            }
            catch (NumberFormatException ex9) {}
        }
        catch (NumberFormatException ex10) {}
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.endOfInput(false);
        }
        this.closed = true;
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        final boolean hasMoreChunks = this.hasMoreChunks;
        final long n3 = -1;
        if (!hasMoreChunks) {
            return n3;
        }
        final long bytesRemainingInChunk = this.bytesRemainingInChunk;
        if (bytesRemainingInChunk == n2 || bytesRemainingInChunk == n3) {
            this.readChunkSize();
            if (!this.hasMoreChunks) {
                return n3;
            }
        }
        final long read = this.this$0.source.read(buffer, Math.min(n, this.bytesRemainingInChunk));
        if (read != n3) {
            this.bytesRemainingInChunk -= read;
            return read;
        }
        this.endOfInput(false);
        throw new ProtocolException("unexpected end of stream");
    }
}
