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
import java.util.Iterator;
import okhttp3.internal.Internal;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.Util;
import java.util.concurrent.TimeUnit;
import java.util.Collection;
import okhttp3.internal.tls.OkHostnameVerifier;
import java.util.ArrayList;
import javax.net.ssl.SSLSocketFactory;
import javax.net.SocketFactory;
import java.net.ProxySelector;
import java.net.Proxy;
import okhttp3.internal.cache.InternalCache;
import javax.net.ssl.HostnameVerifier;
import java.util.List;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class OkHttpClient$Builder
{
    Authenticator authenticator;
    Cache cache;
    CertificateChainCleaner certificateChainCleaner;
    CertificatePinner certificatePinner;
    int connectTimeout;
    ConnectionPool connectionPool;
    List connectionSpecs;
    CookieJar cookieJar;
    Dispatcher dispatcher;
    Dns dns;
    boolean followRedirects;
    boolean followSslRedirects;
    HostnameVerifier hostnameVerifier;
    final List interceptors;
    InternalCache internalCache;
    final List networkInterceptors;
    List protocols;
    Proxy proxy;
    Authenticator proxyAuthenticator;
    ProxySelector proxySelector;
    int readTimeout;
    boolean retryOnConnectionFailure;
    SocketFactory socketFactory;
    SSLSocketFactory sslSocketFactory;
    int writeTimeout;
    
    public OkHttpClient$Builder() {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.dispatcher = new Dispatcher();
        this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
        this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
        this.proxySelector = ProxySelector.getDefault();
        this.cookieJar = CookieJar.NO_COOKIES;
        this.socketFactory = SocketFactory.getDefault();
        this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
        this.certificatePinner = CertificatePinner.DEFAULT;
        this.proxyAuthenticator = Authenticator.NONE;
        this.authenticator = Authenticator.NONE;
        this.connectionPool = new ConnectionPool();
        this.dns = Dns.SYSTEM;
        final boolean retryOnConnectionFailure = true;
        this.followSslRedirects = retryOnConnectionFailure;
        this.followRedirects = retryOnConnectionFailure;
        this.retryOnConnectionFailure = retryOnConnectionFailure;
        final int writeTimeout = 10000;
        this.connectTimeout = writeTimeout;
        this.readTimeout = writeTimeout;
        this.writeTimeout = writeTimeout;
    }
    
    OkHttpClient$Builder(final OkHttpClient okHttpClient) {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.dispatcher = okHttpClient.dispatcher;
        this.proxy = okHttpClient.proxy;
        this.protocols = okHttpClient.protocols;
        this.connectionSpecs = okHttpClient.connectionSpecs;
        this.interceptors.addAll(okHttpClient.interceptors);
        this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
        this.proxySelector = okHttpClient.proxySelector;
        this.cookieJar = okHttpClient.cookieJar;
        this.internalCache = okHttpClient.internalCache;
        this.cache = okHttpClient.cache;
        this.socketFactory = okHttpClient.socketFactory;
        this.sslSocketFactory = okHttpClient.sslSocketFactory;
        this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
        this.hostnameVerifier = okHttpClient.hostnameVerifier;
        this.certificatePinner = okHttpClient.certificatePinner;
        this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
        this.authenticator = okHttpClient.authenticator;
        this.connectionPool = okHttpClient.connectionPool;
        this.dns = okHttpClient.dns;
        this.followSslRedirects = okHttpClient.followSslRedirects;
        this.followRedirects = okHttpClient.followRedirects;
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient.connectTimeout;
        this.readTimeout = okHttpClient.readTimeout;
        this.writeTimeout = okHttpClient.writeTimeout;
    }
    
    public OkHttpClient$Builder addInterceptor(final Interceptor interceptor) {
        this.interceptors.add(interceptor);
        return this;
    }
    
    public OkHttpClient$Builder addNetworkInterceptor(final Interceptor interceptor) {
        this.networkInterceptors.add(interceptor);
        return this;
    }
    
    public OkHttpClient$Builder authenticator(final Authenticator authenticator) {
        if (authenticator != null) {
            this.authenticator = authenticator;
            return this;
        }
        throw new NullPointerException("authenticator == null");
    }
    
    public OkHttpClient build() {
        return new OkHttpClient(this, null);
    }
    
    public OkHttpClient$Builder cache(final Cache cache) {
        this.cache = cache;
        this.internalCache = null;
        return this;
    }
    
    public OkHttpClient$Builder certificatePinner(final CertificatePinner certificatePinner) {
        if (certificatePinner != null) {
            this.certificatePinner = certificatePinner;
            return this;
        }
        throw new NullPointerException("certificatePinner == null");
    }
    
    public OkHttpClient$Builder connectTimeout(final long n, final TimeUnit timeUnit) {
        final long n2 = 0L;
        if (n < n2) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        final long millis = timeUnit.toMillis(n);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == n2 && n > n2) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.connectTimeout = (int)millis;
        return this;
    }
    
    public OkHttpClient$Builder connectionPool(final ConnectionPool connectionPool) {
        if (connectionPool != null) {
            this.connectionPool = connectionPool;
            return this;
        }
        throw new NullPointerException("connectionPool == null");
    }
    
    public OkHttpClient$Builder connectionSpecs(final List list) {
        this.connectionSpecs = Util.immutableList(list);
        return this;
    }
    
    public OkHttpClient$Builder cookieJar(final CookieJar cookieJar) {
        if (cookieJar != null) {
            this.cookieJar = cookieJar;
            return this;
        }
        throw new NullPointerException("cookieJar == null");
    }
    
    public OkHttpClient$Builder dispatcher(final Dispatcher dispatcher) {
        if (dispatcher != null) {
            this.dispatcher = dispatcher;
            return this;
        }
        throw new IllegalArgumentException("dispatcher == null");
    }
    
    public OkHttpClient$Builder dns(final Dns dns) {
        if (dns != null) {
            this.dns = dns;
            return this;
        }
        throw new NullPointerException("dns == null");
    }
    
    public OkHttpClient$Builder followRedirects(final boolean followRedirects) {
        this.followRedirects = followRedirects;
        return this;
    }
    
    public OkHttpClient$Builder followSslRedirects(final boolean followSslRedirects) {
        this.followSslRedirects = followSslRedirects;
        return this;
    }
    
    public OkHttpClient$Builder hostnameVerifier(final HostnameVerifier hostnameVerifier) {
        if (hostnameVerifier != null) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }
        throw new NullPointerException("hostnameVerifier == null");
    }
    
    public List interceptors() {
        return this.interceptors;
    }
    
    public List networkInterceptors() {
        return this.networkInterceptors;
    }
    
    public OkHttpClient$Builder protocols(List immutableList) {
        immutableList = Util.immutableList(immutableList);
        if (!immutableList.contains(Protocol.HTTP_1_1)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("protocols doesn't contain http/1.1: ");
            sb.append(immutableList);
            throw new IllegalArgumentException(sb.toString());
        }
        if (immutableList.contains(Protocol.HTTP_1_0)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("protocols must not contain http/1.0: ");
            sb2.append(immutableList);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!immutableList.contains(null)) {
            this.protocols = Util.immutableList(immutableList);
            return this;
        }
        throw new IllegalArgumentException("protocols must not contain null");
    }
    
    public OkHttpClient$Builder proxy(final Proxy proxy) {
        this.proxy = proxy;
        return this;
    }
    
    public OkHttpClient$Builder proxyAuthenticator(final Authenticator proxyAuthenticator) {
        if (proxyAuthenticator != null) {
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }
        throw new NullPointerException("proxyAuthenticator == null");
    }
    
    public OkHttpClient$Builder proxySelector(final ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }
    
    public OkHttpClient$Builder readTimeout(final long n, final TimeUnit timeUnit) {
        final long n2 = 0L;
        if (n < n2) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        final long millis = timeUnit.toMillis(n);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == n2 && n > n2) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.readTimeout = (int)millis;
        return this;
    }
    
    public OkHttpClient$Builder retryOnConnectionFailure(final boolean retryOnConnectionFailure) {
        this.retryOnConnectionFailure = retryOnConnectionFailure;
        return this;
    }
    
    void setInternalCache(final InternalCache internalCache) {
        this.internalCache = internalCache;
        this.cache = null;
    }
    
    public OkHttpClient$Builder socketFactory(final SocketFactory socketFactory) {
        if (socketFactory != null) {
            this.socketFactory = socketFactory;
            return this;
        }
        throw new NullPointerException("socketFactory == null");
    }
    
    public OkHttpClient$Builder sslSocketFactory(final SSLSocketFactory sslSocketFactory) {
        if (sslSocketFactory == null) {
            throw new NullPointerException("sslSocketFactory == null");
        }
        final X509TrustManager trustManager = Platform.get().trustManager(sslSocketFactory);
        if (trustManager != null) {
            this.sslSocketFactory = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.get(trustManager);
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to extract the trust manager on ");
        sb.append(Platform.get());
        sb.append(", sslSocketFactory is ");
        sb.append(sslSocketFactory.getClass());
        throw new IllegalStateException(sb.toString());
    }
    
    public OkHttpClient$Builder sslSocketFactory(final SSLSocketFactory sslSocketFactory, final X509TrustManager x509TrustManager) {
        if (sslSocketFactory == null) {
            throw new NullPointerException("sslSocketFactory == null");
        }
        if (x509TrustManager != null) {
            this.sslSocketFactory = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }
        throw new NullPointerException("trustManager == null");
    }
    
    public OkHttpClient$Builder writeTimeout(final long n, final TimeUnit timeUnit) {
        final long n2 = 0L;
        if (n < n2) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        final long millis = timeUnit.toMillis(n);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (millis == n2 && n > n2) {
            throw new IllegalArgumentException("Timeout too small.");
        }
        this.writeTimeout = (int)millis;
        return this;
    }
}
