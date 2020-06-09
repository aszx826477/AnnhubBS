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
import okhttp3.HttpUrl;
import okio.Sink;
import okhttp3.Request;
import okhttp3.internal.connection.RealConnection;
import okio.Source;
import okhttp3.Response;
import okio.Timeout;
import okio.ForwardingTimeout;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.OkHttpClient;

public final class Http1xStream implements HttpStream
{
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private final StreamAllocation streamAllocation;
    
    public Http1xStream(final OkHttpClient client, final StreamAllocation streamAllocation, final BufferedSource source, final BufferedSink sink) {
        this.state = 0;
        this.client = client;
        this.streamAllocation = streamAllocation;
        this.source = source;
        this.sink = sink;
    }
    
    private void detachTimeout(final ForwardingTimeout forwardingTimeout) {
        final Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }
    
    private Source getTransferStream(final Response response) {
        if (!HttpHeaders.hasBody(response)) {
            return this.newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return this.newChunkedSource(response.request().url());
        }
        final long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return this.newFixedLengthSource(contentLength);
        }
        return this.newUnknownLengthSource();
    }
    
    public void cancel() {
        final RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }
    
    public Sink createRequestBody(final Request request, final long n) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return this.newChunkedSink();
        }
        if (n != -1) {
            return this.newFixedLengthSink(n);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }
    
    public void finishRequest() {
        this.sink.flush();
    }
    
    public boolean isClosed() {
        return this.state == 6;
    }
    
    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new Http1xStream$ChunkedSink(this, null);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public Source newChunkedSource(final HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new Http1xStream$ChunkedSource(this, httpUrl);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public Sink newFixedLengthSink(final long n) {
        if (this.state == 1) {
            this.state = 2;
            return new Http1xStream$FixedLengthSink(this, n, null);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public Source newFixedLengthSource(final long n) {
        if (this.state == 4) {
            this.state = 5;
            return new Http1xStream$FixedLengthSource(this, n);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public Source newUnknownLengthSource() {
        if (this.state != 4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        final StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            this.state = 5;
            streamAllocation.noNewStreams();
            return new Http1xStream$UnknownLengthSource(this, null);
        }
        throw new IllegalStateException("streamAllocation == null");
    }
    
    public ResponseBody openResponseBody(final Response response) {
        return new RealResponseBody(response.headers(), Okio.buffer(this.getTransferStream(response)));
    }
    
    public Headers readHeaders() {
        final Headers$Builder headers$Builder = new Headers$Builder();
        String utf8LineStrict;
        while ((utf8LineStrict = this.source.readUtf8LineStrict()).length() != 0) {
            Internal.instance.addLenient(headers$Builder, utf8LineStrict);
        }
        return headers$Builder.build();
    }
    
    public Response$Builder readResponse() {
        final int state = this.state;
        Label_0073: {
            if (state == 1) {
                break Label_0073;
            }
            if (state == 3) {
                break Label_0073;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
            try {
                while (true) {
                    final BufferedSource source = this.source;
                    try {
                        final String utf8LineStrict = source.readUtf8LineStrict();
                        try {
                            final StatusLine parse = StatusLine.parse(utf8LineStrict);
                            try {
                                try {
                                    final Response$Builder protocol = new Response$Builder().protocol(parse.protocol);
                                    try {
                                        final Response$Builder code = protocol.code(parse.code);
                                        try {
                                            final Response$Builder message = code.message(parse.message);
                                            try {
                                                final Response$Builder headers = message.headers(this.readHeaders());
                                                try {
                                                    if (parse.code != 100) {
                                                        this.state = 4;
                                                        return headers;
                                                    }
                                                    continue;
                                                }
                                                catch (EOFException ex2) {
                                                    final StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("unexpected end of stream on ");
                                                    sb2.append(this.streamAllocation);
                                                    final IOException ex = new IOException(sb2.toString());
                                                    ex.initCause(ex2);
                                                    throw ex;
                                                }
                                            }
                                            catch (EOFException ex3) {}
                                        }
                                        catch (EOFException ex4) {}
                                    }
                                    catch (EOFException ex5) {}
                                }
                                catch (EOFException ex6) {}
                            }
                            catch (EOFException ex7) {}
                        }
                        catch (EOFException ex8) {}
                    }
                    catch (EOFException ex9) {}
                }
            }
            catch (EOFException ex10) {}
        }
    }
    
    public Response$Builder readResponseHeaders() {
        return this.readResponse();
    }
    
    public void writeRequest(final Headers headers, final String s) {
        if (this.state == 0) {
            this.sink.writeUtf8(s).writeUtf8("\r\n");
            for (int i = 0; i < headers.size(); ++i) {
                this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.sink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public void writeRequestHeaders(final Request request) {
        this.writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }
}
