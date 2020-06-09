// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;
import javax.net.ssl.SSLSocketFactory;
import javax.net.SocketFactory;
import java.net.ProxySelector;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import java.util.List;

public final class Address
{
    final CertificatePinner certificatePinner;
    final List connectionSpecs;
    final Dns dns;
    final HostnameVerifier hostnameVerifier;
    final List protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final HttpUrl url;
    
    public Address(final String s, final int n, final Dns dns, final SocketFactory socketFactory, final SSLSocketFactory sslSocketFactory, final HostnameVerifier hostnameVerifier, final CertificatePinner certificatePinner, final Authenticator proxyAuthenticator, final Proxy proxy, final List list, final List list2, final ProxySelector proxySelector) {
        final HttpUrl$Builder httpUrl$Builder = new HttpUrl$Builder();
        String s2;
        if (sslSocketFactory != null) {
            s2 = "https";
        }
        else {
            s2 = "http";
        }
        this.url = httpUrl$Builder.scheme(s2).host(s).port(n).build();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.dns = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.socketFactory = socketFactory;
        if (proxyAuthenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.proxyAuthenticator = proxyAuthenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.protocols = Util.immutableList(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.connectionSpecs = Util.immutableList(list2);
        if (proxySelector != null) {
            this.proxySelector = proxySelector;
            this.proxy = proxy;
            this.sslSocketFactory = sslSocketFactory;
            this.hostnameVerifier = hostnameVerifier;
            this.certificatePinner = certificatePinner;
            return;
        }
        throw new NullPointerException("proxySelector == null");
    }
    
    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }
    
    public List connectionSpecs() {
        return this.connectionSpecs;
    }
    
    public Dns dns() {
        return this.dns;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Address;
        boolean b2 = false;
        if (b) {
            final Address address = (Address)o;
            if (this.url.equals(address.url)) {
                if (this.dns.equals(address.dns)) {
                    if (this.proxyAuthenticator.equals(address.proxyAuthenticator)) {
                        if (this.protocols.equals(address.protocols)) {
                            if (this.connectionSpecs.equals(address.connectionSpecs)) {
                                if (this.proxySelector.equals(address.proxySelector)) {
                                    if (Util.equal(this.proxy, address.proxy)) {
                                        if (Util.equal(this.sslSocketFactory, address.sslSocketFactory)) {
                                            if (Util.equal(this.hostnameVerifier, address.hostnameVerifier)) {
                                                if (Util.equal(this.certificatePinner, address.certificatePinner)) {
                                                    b2 = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        final int n = ((((((17 * 31 + this.url.hashCode()) * 31 + this.dns.hashCode()) * 31 + this.proxyAuthenticator.hashCode()) * 31 + this.protocols.hashCode()) * 31 + this.connectionSpecs.hashCode()) * 31 + this.proxySelector.hashCode()) * 31;
        final Proxy proxy = this.proxy;
        int hashCode = 0;
        int hashCode2;
        if (proxy != null) {
            hashCode2 = proxy.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final int n2 = (n + hashCode2) * 31;
        final SSLSocketFactory sslSocketFactory = this.sslSocketFactory;
        int hashCode3;
        if (sslSocketFactory != null) {
            hashCode3 = sslSocketFactory.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final int n3 = (n2 + hashCode3) * 31;
        final HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int hashCode4;
        if (hostnameVerifier != null) {
            hashCode4 = hostnameVerifier.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final int n4 = (n3 + hashCode4) * 31;
        final CertificatePinner certificatePinner = this.certificatePinner;
        if (certificatePinner != null) {
            hashCode = certificatePinner.hashCode();
        }
        return n4 + hashCode;
    }
    
    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
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
    
    public SocketFactory socketFactory() {
        return this.socketFactory;
    }
    
    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }
    
    public HttpUrl url() {
        return this.url;
    }
}
