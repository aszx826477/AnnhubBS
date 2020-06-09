// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Iterator;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.io.FileSystem;
import java.io.File;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.DiskLruCache;
import java.io.Flushable;
import java.io.Closeable;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import java.security.cert.CertificateEncodingException;
import okio.BufferedSink;
import java.security.cert.CertificateException;
import okio.ByteString;
import okio.Buffer;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.security.cert.CertificateFactory;
import java.util.Collections;
import java.util.List;
import okio.BufferedSource;
import java.io.IOException;
import okhttp3.internal.http.StatusLine;
import okio.Okio;
import okio.Source;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;

final class Cache$Entry
{
    private static final String RECEIVED_MILLIS;
    private static final String SENT_MILLIS;
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final String url;
    private final Headers varyHeaders;
    
    static {
        final StringBuilder sb = new StringBuilder();
        sb.append(Platform.get().getPrefix());
        sb.append("-Sent-Millis");
        SENT_MILLIS = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(Platform.get().getPrefix());
        sb2.append("-Received-Millis");
        RECEIVED_MILLIS = sb2.toString();
    }
    
    public Cache$Entry(final Response response) {
        this.url = response.request().url().toString();
        this.varyHeaders = HttpHeaders.varyHeaders(response);
        this.requestMethod = response.request().method();
        this.protocol = response.protocol();
        this.code = response.code();
        this.message = response.message();
        this.responseHeaders = response.headers();
        this.handshake = response.handshake();
        this.sentRequestMillis = response.sentRequestAtMillis();
        this.receivedResponseMillis = response.receivedResponseAtMillis();
    }
    
    public Cache$Entry(final Source source) {
        try {
            final BufferedSource buffer = Okio.buffer(source);
            this.url = buffer.readUtf8LineStrict();
            this.requestMethod = buffer.readUtf8LineStrict();
            final Headers$Builder headers$Builder = new Headers$Builder();
            for (int access$1000 = readInt(buffer), i = 0; i < access$1000; ++i) {
                headers$Builder.addLenient(buffer.readUtf8LineStrict());
            }
            this.varyHeaders = headers$Builder.build();
            final StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
            this.protocol = parse.protocol;
            this.code = parse.code;
            this.message = parse.message;
            final Headers$Builder headers$Builder2 = new Headers$Builder();
            for (int access$1001 = readInt(buffer), j = 0; j < access$1001; ++j) {
                headers$Builder2.addLenient(buffer.readUtf8LineStrict());
            }
            final String value = headers$Builder2.get(Cache$Entry.SENT_MILLIS);
            final String value2 = headers$Builder2.get(Cache$Entry.RECEIVED_MILLIS);
            headers$Builder2.removeAll(Cache$Entry.SENT_MILLIS);
            headers$Builder2.removeAll(Cache$Entry.RECEIVED_MILLIS);
            long long1 = 0L;
            long long2;
            if (value != null) {
                long2 = Long.parseLong(value);
            }
            else {
                long2 = long1;
            }
            this.sentRequestMillis = long2;
            if (value2 != null) {
                long1 = Long.parseLong(value2);
            }
            this.receivedResponseMillis = long1;
            this.responseHeaders = headers$Builder2.build();
            final boolean https = this.isHttps();
            TlsVersion forJavaName = null;
            if (https) {
                final String utf8LineStrict = buffer.readUtf8LineStrict();
                if (utf8LineStrict.length() > 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("expected \"\" but was \"");
                    sb.append(utf8LineStrict);
                    sb.append("\"");
                    throw new IOException(sb.toString());
                }
                final CipherSuite forJavaName2 = CipherSuite.forJavaName(buffer.readUtf8LineStrict());
                final List certificateList = this.readCertificateList(buffer);
                final List certificateList2 = this.readCertificateList(buffer);
                if (!buffer.exhausted()) {
                    forJavaName = TlsVersion.forJavaName(buffer.readUtf8LineStrict());
                }
                this.handshake = Handshake.get(forJavaName, forJavaName2, certificateList, certificateList2);
            }
            else {
                this.handshake = null;
            }
        }
        finally {
            source.close();
        }
    }
    
    private boolean isHttps() {
        return this.url.startsWith("https://");
    }
    
    private List readCertificateList(final BufferedSource bufferedSource) {
        final int access$1000 = readInt(bufferedSource);
        if (access$1000 == -1) {
            return Collections.emptyList();
        }
        final String s = "X.509";
        try {
            final CertificateFactory instance = CertificateFactory.getInstance(s);
            try {
                final ArrayList list = new ArrayList<Certificate>(access$1000);
                int n = 0;
                while (true) {
                    if (n >= access$1000) {
                        return list;
                    }
                    final String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                    try {
                        try {
                            final Buffer buffer = new Buffer();
                            buffer.write(ByteString.decodeBase64(utf8LineStrict));
                            list.add(instance.generateCertificate(buffer.inputStream()));
                            ++n;
                            continue;
                        }
                        catch (CertificateException ex) {
                            throw new IOException(ex.getMessage());
                        }
                    }
                    catch (CertificateException ex2) {}
                }
            }
            catch (CertificateException ex3) {}
        }
        catch (CertificateException ex4) {}
    }
    
    private void writeCertList(final BufferedSink bufferedSink, final List list) {
        try {
            final BufferedSink writeDecimalLong = bufferedSink.writeDecimalLong(list.size());
            final int n = 10;
            writeDecimalLong.writeByte(n);
            int n2 = 0;
            final int size = list.size();
            while (true) {
                if (n2 >= size) {
                    return;
                }
                final Certificate value = list.get(n2);
                try {
                    final Certificate certificate = value;
                    try {
                        final byte[] encoded = certificate.getEncoded();
                        try {
                            final ByteString of = ByteString.of(encoded);
                            try {
                                bufferedSink.writeUtf8(of.base64()).writeByte(n);
                                ++n2;
                                continue;
                            }
                            catch (CertificateEncodingException ex) {
                                throw new IOException(ex.getMessage());
                            }
                        }
                        catch (CertificateEncodingException ex2) {}
                    }
                    catch (CertificateEncodingException ex3) {}
                }
                catch (CertificateEncodingException ex4) {}
            }
        }
        catch (CertificateEncodingException ex5) {}
    }
    
    public boolean matches(final Request request, final Response response) {
        if (this.url.equals(request.url().toString())) {
            if (this.requestMethod.equals(request.method())) {
                if (HttpHeaders.varyMatches(response, this.varyHeaders, request)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Response response(final DiskLruCache$Snapshot diskLruCache$Snapshot) {
        return new Response$Builder().request(new Request$Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache$CacheResponseBody(diskLruCache$Snapshot, this.responseHeaders.get("Content-Type"), this.responseHeaders.get("Content-Length"))).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }
    
    public void writeTo(final DiskLruCache$Editor diskLruCache$Editor) {
        final BufferedSink buffer = Okio.buffer(diskLruCache$Editor.newSink(0));
        final BufferedSink writeUtf8 = buffer.writeUtf8(this.url);
        final int n = 10;
        writeUtf8.writeByte(n);
        buffer.writeUtf8(this.requestMethod).writeByte(n);
        buffer.writeDecimalLong(this.varyHeaders.size()).writeByte(n);
        for (int i = 0; i < this.varyHeaders.size(); ++i) {
            buffer.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(n);
        }
        buffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(n);
        buffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(n);
        for (int j = 0; j < this.responseHeaders.size(); ++j) {
            buffer.writeUtf8(this.responseHeaders.name(j)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(j)).writeByte(n);
        }
        buffer.writeUtf8(Cache$Entry.SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(n);
        buffer.writeUtf8(Cache$Entry.RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(n);
        if (this.isHttps()) {
            buffer.writeByte(n);
            buffer.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(n);
            this.writeCertList(buffer, this.handshake.peerCertificates());
            this.writeCertList(buffer, this.handshake.localCertificates());
            if (this.handshake.tlsVersion() != null) {
                buffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(n);
            }
        }
        buffer.close();
    }
}
