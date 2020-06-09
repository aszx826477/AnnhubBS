// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.util.concurrent.TimeUnit;
import okio.Source;
import okio.Okio;
import okhttp3.ResponseBody;
import okhttp3.Response;
import okio.Sink;
import okhttp3.internal.framed.ErrorCode;
import java.util.LinkedHashSet;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.internal.Internal;
import okhttp3.Headers$Builder;
import okhttp3.Response$Builder;
import okhttp3.Headers;
import java.util.Locale;
import java.util.ArrayList;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.framed.Header;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.OkHttpClient;
import java.util.List;
import okio.ByteString;

public final class Http2xStream implements HttpStream
{
    private static final ByteString CONNECTION;
    private static final ByteString ENCODING;
    private static final ByteString HOST;
    private static final List HTTP_2_SKIPPED_REQUEST_HEADERS;
    private static final List HTTP_2_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString KEEP_ALIVE;
    private static final ByteString PROXY_CONNECTION;
    private static final List SPDY_3_SKIPPED_REQUEST_HEADERS;
    private static final List SPDY_3_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString TE;
    private static final ByteString TRANSFER_ENCODING;
    private static final ByteString UPGRADE;
    private final OkHttpClient client;
    private final FramedConnection framedConnection;
    private FramedStream stream;
    private final StreamAllocation streamAllocation;
    
    static {
        CONNECTION = ByteString.encodeUtf8("connection");
        HOST = ByteString.encodeUtf8("host");
        KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
        PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
        TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
        TE = ByteString.encodeUtf8("te");
        ENCODING = ByteString.encodeUtf8("encoding");
        UPGRADE = ByteString.encodeUtf8("upgrade");
        final int n = 11;
        final ByteString[] array = new ByteString[n];
        array[0] = Http2xStream.CONNECTION;
        final ByteString host = Http2xStream.HOST;
        final int n2 = 1;
        array[n2] = host;
        final ByteString keep_ALIVE = Http2xStream.KEEP_ALIVE;
        final int n3 = 2;
        array[n3] = keep_ALIVE;
        final ByteString proxy_CONNECTION = Http2xStream.PROXY_CONNECTION;
        final int n4 = 3;
        array[n4] = proxy_CONNECTION;
        final ByteString transfer_ENCODING = Http2xStream.TRANSFER_ENCODING;
        final int n5 = 4;
        array[n5] = transfer_ENCODING;
        final ByteString target_METHOD = Header.TARGET_METHOD;
        final int n6 = 5;
        array[n6] = target_METHOD;
        final ByteString target_PATH = Header.TARGET_PATH;
        final int n7 = 6;
        array[n7] = target_PATH;
        final ByteString target_SCHEME = Header.TARGET_SCHEME;
        final int n8 = 7;
        array[n8] = target_SCHEME;
        final ByteString target_AUTHORITY = Header.TARGET_AUTHORITY;
        final int n9 = 8;
        array[n9] = target_AUTHORITY;
        final ByteString target_HOST = Header.TARGET_HOST;
        final int n10 = 9;
        array[n10] = target_HOST;
        final ByteString version = Header.VERSION;
        final int n11 = 10;
        array[n11] = version;
        SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])array);
        final ByteString[] array2 = new ByteString[n6];
        array2[0] = Http2xStream.CONNECTION;
        array2[n2] = Http2xStream.HOST;
        array2[n3] = Http2xStream.KEEP_ALIVE;
        array2[n4] = Http2xStream.PROXY_CONNECTION;
        array2[n5] = Http2xStream.TRANSFER_ENCODING;
        SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])array2);
        final ByteString[] array3 = new ByteString[14];
        array3[0] = Http2xStream.CONNECTION;
        array3[n2] = Http2xStream.HOST;
        array3[n3] = Http2xStream.KEEP_ALIVE;
        array3[n4] = Http2xStream.PROXY_CONNECTION;
        array3[n5] = Http2xStream.TE;
        array3[n6] = Http2xStream.TRANSFER_ENCODING;
        array3[n7] = Http2xStream.ENCODING;
        array3[n8] = Http2xStream.UPGRADE;
        array3[n9] = Header.TARGET_METHOD;
        array3[n10] = Header.TARGET_PATH;
        array3[n11] = Header.TARGET_SCHEME;
        array3[n] = Header.TARGET_AUTHORITY;
        array3[12] = Header.TARGET_HOST;
        array3[13] = Header.VERSION;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])array3);
        final ByteString[] array4 = new ByteString[n9];
        array4[0] = Http2xStream.CONNECTION;
        array4[n2] = Http2xStream.HOST;
        array4[n3] = Http2xStream.KEEP_ALIVE;
        array4[n4] = Http2xStream.PROXY_CONNECTION;
        array4[n5] = Http2xStream.TE;
        array4[n6] = Http2xStream.TRANSFER_ENCODING;
        array4[n7] = Http2xStream.ENCODING;
        array4[n8] = Http2xStream.UPGRADE;
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])array4);
    }
    
    public Http2xStream(final OkHttpClient client, final StreamAllocation streamAllocation, final FramedConnection framedConnection) {
        this.client = client;
        this.streamAllocation = streamAllocation;
        this.framedConnection = framedConnection;
    }
    
    public static List http2HeadersList(final Request request) {
        final Headers headers = request.headers();
        final ArrayList list = new ArrayList<Header>(headers.size() + 4);
        list.add(new Header(Header.TARGET_METHOD, request.method()));
        list.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        list.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.url(), false)));
        list.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        for (int i = 0; i < headers.size(); ++i) {
            final ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!Http2xStream.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                list.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return list;
    }
    
    private static String joinOnNull(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder(s);
        sb.append('\0');
        sb.append(s2);
        return sb.toString();
    }
    
    public static Response$Builder readHttp2HeadersList(final List list) {
        String s = null;
        final Headers$Builder headers$Builder = new Headers$Builder();
        for (int i = 0; i < list.size(); ++i) {
            final ByteString name = list.get(i).name;
            final String utf8 = list.get(i).value.utf8();
            if (name.equals(Header.RESPONSE_STATUS)) {
                s = utf8;
            }
            else if (!Http2xStream.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Internal.instance.addLenient(headers$Builder, name.utf8(), utf8);
            }
        }
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("HTTP/1.1 ");
            sb.append(s);
            final StatusLine parse = StatusLine.parse(sb.toString());
            return new Response$Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(headers$Builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }
    
    public static Response$Builder readSpdy3HeadersList(final List list) {
        String s = null;
        String s2 = "HTTP/1.1";
        final Headers$Builder headers$Builder = new Headers$Builder();
        for (int i = 0; i < list.size(); ++i) {
            final ByteString name = list.get(i).name;
            final String utf8 = list.get(i).value.utf8();
            int n;
            for (int j = 0; j < utf8.length(); j = n + 1) {
                n = utf8.indexOf(0, j);
                if (n == -1) {
                    n = utf8.length();
                }
                final String substring = utf8.substring(j, n);
                if (name.equals(Header.RESPONSE_STATUS)) {
                    s = substring;
                }
                else if (name.equals(Header.VERSION)) {
                    s2 = substring;
                }
                else if (!Http2xStream.SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    Internal.instance.addLenient(headers$Builder, name.utf8(), substring);
                }
            }
        }
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append(" ");
            sb.append(s);
            final StatusLine parse = StatusLine.parse(sb.toString());
            return new Response$Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(headers$Builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }
    
    public static List spdy3HeadersList(final Request request) {
        final Headers headers = request.headers();
        final ArrayList list = new ArrayList<Object>(headers.size() + 5);
        list.add(new Header(Header.TARGET_METHOD, request.method()));
        list.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        list.add(new Header(Header.VERSION, "HTTP/1.1"));
        list.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.url(), false)));
        list.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        final LinkedHashSet<ByteString> set = new LinkedHashSet<ByteString>();
        for (int i = 0; i < headers.size(); ++i) {
            final ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!Http2xStream.SPDY_3_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                final String value = headers.value(i);
                if (set.add(encodeUtf8)) {
                    list.add(new Header(encodeUtf8, value));
                }
                else {
                    for (int j = 0; j < list.size(); ++j) {
                        if (((Header)list.get(j)).name.equals(encodeUtf8)) {
                            list.set(j, new Header(encodeUtf8, joinOnNull(((Header)list.get(j)).value.utf8(), value)));
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }
    
    public void cancel() {
        final FramedStream stream = this.stream;
        if (stream != null) {
            stream.closeLater(ErrorCode.CANCEL);
        }
    }
    
    public Sink createRequestBody(final Request request, final long n) {
        return this.stream.getSink();
    }
    
    public void finishRequest() {
        this.stream.getSink().close();
    }
    
    public ResponseBody openResponseBody(final Response response) {
        return new RealResponseBody(response.headers(), Okio.buffer(new Http2xStream$StreamFinishingSource(this, this.stream.getSource())));
    }
    
    public Response$Builder readResponseHeaders() {
        Response$Builder response$Builder;
        if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
            response$Builder = readHttp2HeadersList(this.stream.getResponseHeaders());
        }
        else {
            response$Builder = readSpdy3HeadersList(this.stream.getResponseHeaders());
        }
        return response$Builder;
    }
    
    public void writeRequestHeaders(final Request request) {
        if (this.stream != null) {
            return;
        }
        final boolean permitsRequestBody = HttpMethod.permitsRequestBody(request.method());
        List list;
        if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
            list = http2HeadersList(request);
        }
        else {
            list = spdy3HeadersList(request);
        }
        this.stream = this.framedConnection.newStream(list, permitsRequestBody, true);
        this.stream.readTimeout().timeout(this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.stream.writeTimeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }
}
