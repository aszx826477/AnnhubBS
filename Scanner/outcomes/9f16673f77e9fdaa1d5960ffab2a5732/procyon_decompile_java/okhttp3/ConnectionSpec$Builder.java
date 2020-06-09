// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec$Builder
{
    private String[] cipherSuites;
    private boolean supportsTlsExtensions;
    private boolean tls;
    private String[] tlsVersions;
    
    public ConnectionSpec$Builder(final ConnectionSpec connectionSpec) {
        this.tls = connectionSpec.tls;
        this.cipherSuites = connectionSpec.cipherSuites;
        this.tlsVersions = connectionSpec.tlsVersions;
        this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
    }
    
    ConnectionSpec$Builder(final boolean tls) {
        this.tls = tls;
    }
    
    public ConnectionSpec$Builder allEnabledCipherSuites() {
        if (this.tls) {
            this.cipherSuites = null;
            return this;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public ConnectionSpec$Builder allEnabledTlsVersions() {
        if (this.tls) {
            this.tlsVersions = null;
            return this;
        }
        throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public ConnectionSpec build() {
        return new ConnectionSpec(this, null);
    }
    
    public ConnectionSpec$Builder cipherSuites(final String... array) {
        if (!this.tls) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (array.length != 0) {
            this.cipherSuites = array.clone();
            return this;
        }
        throw new IllegalArgumentException("At least one cipher suite is required");
    }
    
    public ConnectionSpec$Builder cipherSuites(final CipherSuite... array) {
        if (this.tls) {
            final String[] array2 = new String[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = array[i].javaName;
            }
            return this.cipherSuites(array2);
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public ConnectionSpec$Builder supportsTlsExtensions(final boolean supportsTlsExtensions) {
        if (this.tls) {
            this.supportsTlsExtensions = supportsTlsExtensions;
            return this;
        }
        throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public ConnectionSpec$Builder tlsVersions(final String... array) {
        if (!this.tls) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (array.length != 0) {
            this.tlsVersions = array.clone();
            return this;
        }
        throw new IllegalArgumentException("At least one TLS version is required");
    }
    
    public ConnectionSpec$Builder tlsVersions(final TlsVersion... array) {
        if (this.tls) {
            final String[] array2 = new String[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = array[i].javaName;
            }
            return this.tlsVersions(array2);
        }
        throw new IllegalStateException("no TLS versions for cleartext connections");
    }
}
