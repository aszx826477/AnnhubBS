// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedStream;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import okhttp3.internal.framed.FramedConnection$Builder;
import okhttp3.internal.Version;
import okhttp3.Request$Builder;
import okhttp3.Response;
import okhttp3.internal.http.HttpHeaders;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.Http1xStream;
import java.security.Principal;
import okio.Sink;
import okio.Source;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.ConnectionSpec;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.OkHostnameVerifier;
import java.security.cert.Certificate;
import okhttp3.CertificatePinner;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import java.net.ConnectException;
import okio.Okio;
import okhttp3.internal.platform.Platform;
import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.internal.Util;
import java.net.ProtocolException;
import java.util.ArrayList;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.Route;
import java.net.Socket;
import okhttp3.Protocol;
import okhttp3.Handshake;
import okhttp3.internal.framed.FramedConnection;
import java.util.List;
import okhttp3.Connection;
import okhttp3.internal.framed.FramedConnection$Listener;

public final class RealConnection extends FramedConnection$Listener implements Connection
{
    public int allocationLimit;
    public final List allocations;
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;
    
    public RealConnection(final Route route) {
        this.allocations = new ArrayList();
        this.idleAtNanos = Long.MAX_VALUE;
        this.route = route;
    }
    
    private void buildConnection(final int n, final int n2, final int n3, final ConnectionSpecSelector connectionSpecSelector) {
        this.connectSocket(n, n2);
        this.establishProtocol(n2, n3, connectionSpecSelector);
    }
    
    private void buildTunneledConnection(final int n, final int n2, final int n3, final ConnectionSpecSelector connectionSpecSelector) {
        Request request = this.createTunnelRequest();
        final HttpUrl url = request.url();
        int n4 = 0;
        final int n5 = 21;
        while (true) {
            ++n4;
            if (n4 > n5) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Too many tunnel connections attempted: ");
                sb.append(n5);
                throw new ProtocolException(sb.toString());
            }
            this.connectSocket(n, n2);
            request = this.createTunnel(n2, n3, request, url);
            if (request == null) {
                this.establishProtocol(n2, n3, connectionSpecSelector);
                return;
            }
            Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
        }
    }
    
    private void connectSocket(final int n, final int soTimeout) {
        final Proxy proxy = this.route.proxy();
        final Address address = this.route.address();
        Socket socket;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP) {
            socket = new Socket(proxy);
        }
        else {
            socket = address.socketFactory().createSocket();
        }
        (this.rawSocket = socket).setSoTimeout(soTimeout);
        try {
            final Platform value = Platform.get();
            try {
                final Socket rawSocket = this.rawSocket;
                try {
                    final Route route = this.route;
                    try {
                        value.connectSocket(rawSocket, route.socketAddress(), n);
                        this.source = Okio.buffer(Okio.source(this.rawSocket));
                        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
                    }
                    catch (ConnectException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Failed to connect to ");
                        sb.append(this.route.socketAddress());
                        throw new ConnectException(sb.toString());
                    }
                }
                catch (ConnectException ex2) {}
            }
            catch (ConnectException ex3) {}
        }
        catch (ConnectException ex4) {}
    }
    
    private void connectTls(final int n, final int n2, final ConnectionSpecSelector connectionSpecSelector) {
        final Address address = this.route.address();
        final SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        final SSLSocket sslSocket = null;
        try {
            final Socket rawSocket = this.rawSocket;
            try {
                final HttpUrl url = address.url();
                try {
                    final String host = url.host();
                    try {
                        final HttpUrl url2 = address.url();
                        try {
                            final Socket socket = sslSocketFactory.createSocket(rawSocket, host, url2.port(), true);
                            try {
                                final SSLSocket socket2;
                                final ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(socket2 = (SSLSocket)socket);
                                try {
                                    Label_0145: {
                                        if (!configureSecureSocket.supportsTlsExtensions()) {
                                            break Label_0145;
                                        }
                                        final Platform value = Platform.get();
                                        try {
                                            final HttpUrl url3 = address.url();
                                            try {
                                                final String host2 = url3.host();
                                                try {
                                                    value.configureTlsExtensions(socket2, host2, address.protocols());
                                                    socket2.startHandshake();
                                                    final SSLSession session = socket2.getSession();
                                                    try {
                                                        final Handshake value2 = Handshake.get(session);
                                                        try {
                                                            final HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                                                            try {
                                                                final HttpUrl url4 = address.url();
                                                                try {
                                                                    final String host3 = url4.host();
                                                                    try {
                                                                        Label_0409: {
                                                                            if (!hostnameVerifier.verify(host3, socket2.getSession())) {
                                                                                break Label_0409;
                                                                            }
                                                                            final CertificatePinner certificatePinner = address.certificatePinner();
                                                                            try {
                                                                                final HttpUrl url5 = address.url();
                                                                                try {
                                                                                    final String host4 = url5.host();
                                                                                    try {
                                                                                        certificatePinner.check(host4, value2.peerCertificates());
                                                                                        String selectedProtocol;
                                                                                        if (configureSecureSocket.supportsTlsExtensions()) {
                                                                                            selectedProtocol = Platform.get().getSelectedProtocol(socket2);
                                                                                        }
                                                                                        else {
                                                                                            selectedProtocol = null;
                                                                                        }
                                                                                        this.socket = socket2;
                                                                                        final Socket socket3 = this.socket;
                                                                                        try {
                                                                                            final Source source = Okio.source(socket3);
                                                                                            try {
                                                                                                this.source = Okio.buffer(source);
                                                                                                final Socket socket4 = this.socket;
                                                                                                try {
                                                                                                    final Sink sink = Okio.sink(socket4);
                                                                                                    try {
                                                                                                        this.sink = Okio.buffer(sink);
                                                                                                        try {
                                                                                                            this.handshake = value2;
                                                                                                            Protocol protocol;
                                                                                                            if (selectedProtocol != null) {
                                                                                                                protocol = Protocol.get(selectedProtocol);
                                                                                                            }
                                                                                                            else {
                                                                                                                protocol = Protocol.HTTP_1_1;
                                                                                                            }
                                                                                                            this.protocol = protocol;
                                                                                                            final boolean b = true;
                                                                                                            if (socket2 != null) {
                                                                                                                Platform.get().afterHandshake(socket2);
                                                                                                            }
                                                                                                            if (!b) {
                                                                                                                Util.closeQuietly(socket2);
                                                                                                            }
                                                                                                            return;
                                                                                                            final Object value3 = value2.peerCertificates().get(0);
                                                                                                            try {
                                                                                                                final X509Certificate x509Certificate = (X509Certificate)value3;
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            final StringBuilder sb = new StringBuilder();
                                                                                                                            sb.append("Hostname ");
                                                                                                                            final HttpUrl url6 = address.url();
                                                                                                                            try {
                                                                                                                                sb.append(url6.host());
                                                                                                                                sb.append(" not verified:\n    certificate: ");
                                                                                                                                sb.append(CertificatePinner.pin(x509Certificate));
                                                                                                                                sb.append("\n    DN: ");
                                                                                                                                final Principal subjectDN = x509Certificate.getSubjectDN();
                                                                                                                                try {
                                                                                                                                    sb.append(subjectDN.getName());
                                                                                                                                    sb.append("\n    subjectAltNames: ");
                                                                                                                                    sb.append(OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                                                                                                                                    throw new SSLPeerUnverifiedException(sb.toString());
                                                                                                                                }
                                                                                                                                catch (AssertionError assertionError) {
                                                                                                                                    if (Util.isAndroidGetsocknameError(assertionError)) {
                                                                                                                                        throw new IOException(assertionError);
                                                                                                                                    }
                                                                                                                                    throw assertionError;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            catch (AssertionError assertionError2) {}
                                                                                                                        }
                                                                                                                        catch (AssertionError assertionError3) {}
                                                                                                                    }
                                                                                                                    catch (AssertionError assertionError4) {}
                                                                                                                }
                                                                                                                catch (AssertionError assertionError5) {}
                                                                                                            }
                                                                                                            catch (AssertionError assertionError6) {}
                                                                                                        }
                                                                                                        catch (AssertionError assertionError7) {}
                                                                                                    }
                                                                                                    catch (AssertionError assertionError8) {}
                                                                                                }
                                                                                                catch (AssertionError assertionError9) {}
                                                                                            }
                                                                                            catch (AssertionError assertionError10) {}
                                                                                        }
                                                                                        catch (AssertionError assertionError11) {}
                                                                                    }
                                                                                    catch (AssertionError assertionError12) {}
                                                                                }
                                                                                catch (AssertionError assertionError13) {}
                                                                            }
                                                                            catch (AssertionError assertionError14) {}
                                                                        }
                                                                    }
                                                                    catch (AssertionError assertionError15) {}
                                                                }
                                                                catch (AssertionError assertionError16) {}
                                                            }
                                                            catch (AssertionError assertionError17) {}
                                                        }
                                                        catch (AssertionError assertionError18) {}
                                                    }
                                                    catch (AssertionError assertionError19) {}
                                                }
                                                catch (AssertionError assertionError20) {}
                                            }
                                            catch (AssertionError assertionError21) {}
                                        }
                                        catch (AssertionError assertionError22) {}
                                    }
                                }
                                catch (AssertionError assertionError23) {}
                            }
                            catch (AssertionError assertionError24) {}
                        }
                        catch (AssertionError assertionError25) {}
                    }
                    catch (AssertionError assertionError26) {}
                }
                catch (AssertionError assertionError27) {}
            }
            catch (AssertionError assertionError28) {}
        }
        catch (AssertionError assertionError29) {}
        finally {
            if (sslSocket != null) {
                Platform.get().afterHandshake(sslSocket);
            }
            if (!false) {
                Util.closeQuietly(sslSocket);
            }
        }
    }
    
    private Request createTunnel(final int n, final int n2, Request authenticate, final HttpUrl httpUrl) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(Util.hostHeader(httpUrl, true));
        sb.append(" HTTP/1.1");
        final String string = sb.toString();
        while (true) {
            final Http1xStream http1xStream = new Http1xStream(null, null, this.source, this.sink);
            this.source.timeout().timeout(n, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout(n2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(authenticate.headers(), string);
            http1xStream.finishRequest();
            final Response build = http1xStream.readResponse().request(authenticate).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0L;
            }
            final Source fixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(fixedLengthSource, -1 >>> 1, TimeUnit.MILLISECONDS);
            fixedLengthSource.close();
            final int code = build.code();
            if (code != 200) {
                if (code != 407) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unexpected response code for CONNECT: ");
                    sb2.append(build.code());
                    throw new IOException(sb2.toString());
                }
                authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(build.header("Connection"))) {
                    return authenticate;
                }
                continue;
            }
            else {
                if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }
    
    private Request createTunnelRequest() {
        return new Request$Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }
    
    private void establishProtocol(final int n, final int n2, final ConnectionSpecSelector connectionSpecSelector) {
        if (this.route.address().sslSocketFactory() != null) {
            this.connectTls(n, n2, connectionSpecSelector);
        }
        else {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
        }
        final Protocol protocol = this.protocol;
        final Protocol spdy_3 = Protocol.SPDY_3;
        final boolean allocationLimit = true;
        if (protocol != spdy_3 && this.protocol != Protocol.HTTP_2) {
            this.allocationLimit = (allocationLimit ? 1 : 0);
        }
        else {
            this.socket.setSoTimeout(0);
            final FramedConnection build = new FramedConnection$Builder(allocationLimit).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener(this).build();
            build.start();
            this.allocationLimit = build.maxConcurrentStreams();
            this.framedConnection = build;
        }
    }
    
    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }
    
    public void connect(final int n, final int n2, final int n3, final List list, final boolean b) {
        if (this.protocol == null) {
            RouteException ex = null;
            final ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
            if (this.route.address().sslSocketFactory() == null) {
                if (!list.contains(ConnectionSpec.CLEARTEXT)) {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
                final String host = this.route.address().url().host();
                if (!Platform.get().isCleartextTrafficPermitted(host)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("CLEARTEXT communication to ");
                    sb.append(host);
                    sb.append(" not permitted by network security policy");
                    throw new RouteException(new UnknownServiceException(sb.toString()));
                }
            }
            while (this.protocol == null) {
                try {
                    final Route route = this.route;
                    while (true) {
                        try {
                            if (route.requiresTunnel()) {
                                this.buildTunneledConnection(n, n2, n3, connectionSpecSelector);
                            }
                            else {
                                this.buildConnection(n, n2, n3, connectionSpecSelector);
                            }
                        }
                        catch (IOException ex2) {
                            Util.closeQuietly(this.socket);
                            Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            if (ex == null) {
                                ex = new RouteException(ex2);
                            }
                            else {
                                ex.addConnectException(ex2);
                            }
                            if (b && connectionSpecSelector.connectionFailed(ex2)) {
                                continue;
                            }
                            throw ex;
                        }
                        break;
                    }
                }
                catch (IOException ex3) {}
                break;
            }
            return;
        }
        throw new IllegalStateException("already connected");
    }
    
    public Handshake handshake() {
        return this.handshake;
    }
    
    public boolean isHealthy(final boolean b) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        final FramedConnection framedConnection = this.framedConnection;
        final int soTimeout = 1;
        if (framedConnection != null) {
            return soTimeout != 0;
        }
        if (b) {
            try {
                final Socket socket = this.socket;
                try {
                    final int soTimeout2 = socket.getSoTimeout();
                    try {
                        this.socket.setSoTimeout(soTimeout);
                        return !this.source.exhausted() && soTimeout;
                    }
                    finally {
                        this.socket.setSoTimeout(soTimeout2);
                    }
                }
                catch (IOException ex) {
                    return false;
                }
                catch (SocketTimeoutException ex2) {}
            }
            catch (IOException ex3) {}
            catch (SocketTimeoutException ex4) {}
        }
        return soTimeout != 0;
    }
    
    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }
    
    public void onSettings(final FramedConnection framedConnection) {
        this.allocationLimit = framedConnection.maxConcurrentStreams();
    }
    
    public void onStream(final FramedStream framedStream) {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }
    
    public Protocol protocol() {
        if (this.framedConnection == null) {
            Protocol protocol = this.protocol;
            if (protocol == null) {
                protocol = Protocol.HTTP_1_1;
            }
            return protocol;
        }
        return this.framedConnection.getProtocol();
    }
    
    public Route route() {
        return this.route;
    }
    
    public Socket socket() {
        return this.socket;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        final Handshake handshake = this.handshake;
        Object cipherSuite;
        if (handshake != null) {
            cipherSuite = handshake.cipherSuite();
        }
        else {
            cipherSuite = "none";
        }
        sb.append(cipherSuite);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
