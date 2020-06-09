// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Arrays;
import java.security.KeyStore;
import javax.net.ssl.TrustManagerFactory;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.util.Iterator;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import javax.net.ssl.SSLSocketFactory;
import javax.net.SocketFactory;
import java.net.ProxySelector;
import java.net.Proxy;
import okhttp3.internal.cache.InternalCache;
import javax.net.ssl.HostnameVerifier;
import okhttp3.internal.tls.CertificateChainCleaner;
import java.util.List;

public class OkHttpClient implements Cloneable, Call$Factory
{
    private static final List DEFAULT_CONNECTION_SPECS;
    private static final List DEFAULT_PROTOCOLS;
    final Authenticator authenticator;
    final Cache cache;
    final CertificateChainCleaner certificateChainCleaner;
    final CertificatePinner certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List connectionSpecs;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List interceptors;
    final InternalCache internalCache;
    final List networkInterceptors;
    final List protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    
    static {
        final int n = 3;
        final Protocol[] array = new Protocol[n];
        array[0] = Protocol.HTTP_2;
        final Protocol spdy_3 = Protocol.SPDY_3;
        final int n2 = 1;
        array[n2] = spdy_3;
        final Protocol http_1_1 = Protocol.HTTP_1_1;
        final int n3 = 2;
        array[n3] = http_1_1;
        DEFAULT_PROTOCOLS = Util.immutableList((Object[])array);
        final ConnectionSpec[] array2 = new ConnectionSpec[n];
        array2[0] = ConnectionSpec.MODERN_TLS;
        array2[n2] = ConnectionSpec.COMPATIBLE_TLS;
        array2[n3] = ConnectionSpec.CLEARTEXT;
        DEFAULT_CONNECTION_SPECS = Util.immutableList((Object[])array2);
        Internal.instance = new OkHttpClient$1();
    }
    
    public OkHttpClient() {
        this(new OkHttpClient$Builder());
    }
    
    private OkHttpClient(final OkHttpClient$Builder okHttpClient$Builder) {
        this.dispatcher = okHttpClient$Builder.dispatcher;
        this.proxy = okHttpClient$Builder.proxy;
        this.protocols = okHttpClient$Builder.protocols;
        this.connectionSpecs = okHttpClient$Builder.connectionSpecs;
        this.interceptors = Util.immutableList(okHttpClient$Builder.interceptors);
        this.networkInterceptors = Util.immutableList(okHttpClient$Builder.networkInterceptors);
        this.proxySelector = okHttpClient$Builder.proxySelector;
        this.cookieJar = okHttpClient$Builder.cookieJar;
        this.cache = okHttpClient$Builder.cache;
        this.internalCache = okHttpClient$Builder.internalCache;
        this.socketFactory = okHttpClient$Builder.socketFactory;
        boolean b = false;
        for (final ConnectionSpec connectionSpec : this.connectionSpecs) {
            b = (b || connectionSpec.isTls());
        }
        if (okHttpClient$Builder.sslSocketFactory == null && b) {
            final X509TrustManager systemDefaultTrustManager = this.systemDefaultTrustManager();
            this.sslSocketFactory = this.systemDefaultSslSocketFactory(systemDefaultTrustManager);
            this.certificateChainCleaner = CertificateChainCleaner.get(systemDefaultTrustManager);
        }
        else {
            this.sslSocketFactory = okHttpClient$Builder.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient$Builder.certificateChainCleaner;
        }
        this.hostnameVerifier = okHttpClient$Builder.hostnameVerifier;
        this.certificatePinner = okHttpClient$Builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = okHttpClient$Builder.proxyAuthenticator;
        this.authenticator = okHttpClient$Builder.authenticator;
        this.connectionPool = okHttpClient$Builder.connectionPool;
        this.dns = okHttpClient$Builder.dns;
        this.followSslRedirects = okHttpClient$Builder.followSslRedirects;
        this.followRedirects = okHttpClient$Builder.followRedirects;
        this.retryOnConnectionFailure = okHttpClient$Builder.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient$Builder.connectTimeout;
        this.readTimeout = okHttpClient$Builder.readTimeout;
        this.writeTimeout = okHttpClient$Builder.writeTimeout;
    }
    
    private SSLSocketFactory systemDefaultSslSocketFactory(final X509TrustManager x509TrustManager) {
        final String s = "TLS";
        try {
            final SSLContext instance = SSLContext.getInstance(s);
            instance.init(null, new TrustManager[] { x509TrustManager }, null);
            return instance.getSocketFactory();
        }
        catch (GeneralSecurityException ex) {
            throw new AssertionError();
        }
    }
    
    private X509TrustManager systemDefaultTrustManager() {
        try {
            final String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            try {
                final TrustManagerFactory instance = TrustManagerFactory.getInstance(defaultAlgorithm);
                final KeyStore keyStore = null;
                instance.init((KeyStore)null);
                final TrustManager[] trustManagers = instance.getTrustManagers();
                try {
                    Label_0071: {
                        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                            break Label_0071;
                        }
                        final TrustManager trustManager = trustManagers[0];
                        try {
                            return (X509TrustManager)trustManager;
                            try {
                                try {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Unexpected default trust managers:");
                                    sb.append(Arrays.toString(trustManagers));
                                    throw new IllegalStateException(sb.toString());
                                }
                                catch (GeneralSecurityException ex) {
                                    throw new AssertionError();
                                }
                            }
                            catch (GeneralSecurityException ex2) {}
                        }
                        catch (GeneralSecurityException ex3) {}
                    }
                }
                catch (GeneralSecurityException ex4) {}
            }
            catch (GeneralSecurityException ex5) {}
        }
        catch (GeneralSecurityException ex6) {}
    }
    
    public Authenticator authenticator() {
        return this.authenticator;
    }
    
    public Cache cache() {
        return this.cache;
    }
    
    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }
    
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }
    
    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }
    
    public List connectionSpecs() {
        return this.connectionSpecs;
    }
    
    public CookieJar cookieJar() {
        return this.cookieJar;
    }
    
    public Dispatcher dispatcher() {
        return this.dispatcher;
    }
    
    public Dns dns() {
        return this.dns;
    }
    
    public boolean followRedirects() {
        return this.followRedirects;
    }
    
    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }
    
    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }
    
    public List interceptors() {
        return this.interceptors;
    }
    
    InternalCache internalCache() {
        final Cache cache = this.cache;
        InternalCache internalCache;
        if (cache != null) {
            internalCache = cache.internalCache;
        }
        else {
            internalCache = this.internalCache;
        }
        return internalCache;
    }
    
    public List networkInterceptors() {
        return this.networkInterceptors;
    }
    
    public OkHttpClient$Builder newBuilder() {
        return new OkHttpClient$Builder(this);
    }
    
    public Call newCall(final Request request) {
        return new RealCall(this, request);
    }
    
    public List protocols() {
        return this.protocols;
    }
    
    public Proxy proxy() {
        return this.proxy;
    }
    
    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }
    
    public ProxySelector proxySelector() {
        return this.proxySelector;
    }
    
    public int readTimeoutMillis() {
        return this.readTimeout;
    }
    
    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }
    
    public SocketFactory socketFactory() {
        return this.socketFactory;
    }
    
    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }
    
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }
}
