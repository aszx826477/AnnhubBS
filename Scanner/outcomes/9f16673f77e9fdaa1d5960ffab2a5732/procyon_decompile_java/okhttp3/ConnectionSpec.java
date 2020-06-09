// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String[] cipherSuites;
    private final boolean supportsTlsExtensions;
    private final boolean tls;
    private final String[] tlsVersions;
    
    static {
        final CipherSuite[] approved_CIPHER_SUITES = new CipherSuite[13];
        approved_CIPHER_SUITES[0] = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        final CipherSuite tls_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        final int n = 1;
        approved_CIPHER_SUITES[n] = tls_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        final CipherSuite tls_DHE_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
        final int n2 = 2;
        approved_CIPHER_SUITES[n2] = tls_DHE_RSA_WITH_AES_128_GCM_SHA256;
        final CipherSuite tls_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
        final int n3 = 3;
        approved_CIPHER_SUITES[n3] = tls_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
        approved_CIPHER_SUITES[4] = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
        approved_CIPHER_SUITES[5] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
        approved_CIPHER_SUITES[6] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
        approved_CIPHER_SUITES[7] = CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
        approved_CIPHER_SUITES[8] = CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
        approved_CIPHER_SUITES[9] = CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256;
        approved_CIPHER_SUITES[10] = CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA;
        approved_CIPHER_SUITES[11] = CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA;
        approved_CIPHER_SUITES[12] = CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA;
        APPROVED_CIPHER_SUITES = approved_CIPHER_SUITES;
        final ConnectionSpec$Builder cipherSuites = new ConnectionSpec$Builder(n != 0).cipherSuites(ConnectionSpec.APPROVED_CIPHER_SUITES);
        final TlsVersion[] array = new TlsVersion[n3];
        array[0] = TlsVersion.TLS_1_2;
        array[n] = TlsVersion.TLS_1_1;
        array[n2] = TlsVersion.TLS_1_0;
        MODERN_TLS = cipherSuites.tlsVersions(array).supportsTlsExtensions(n != 0).build();
        final ConnectionSpec$Builder connectionSpec$Builder = new ConnectionSpec$Builder(ConnectionSpec.MODERN_TLS);
        final TlsVersion[] array2 = new TlsVersion[n];
        array2[0] = TlsVersion.TLS_1_0;
        COMPATIBLE_TLS = connectionSpec$Builder.tlsVersions(array2).supportsTlsExtensions(n != 0).build();
        CLEARTEXT = new ConnectionSpec$Builder(false).build();
    }
    
    private ConnectionSpec(final ConnectionSpec$Builder connectionSpec$Builder) {
        this.tls = connectionSpec$Builder.tls;
        this.cipherSuites = connectionSpec$Builder.cipherSuites;
        this.tlsVersions = connectionSpec$Builder.tlsVersions;
        this.supportsTlsExtensions = connectionSpec$Builder.supportsTlsExtensions;
    }
    
    private static boolean nonEmptyIntersection(final String[] array, final String[] array2) {
        if (array != null && array2 != null && array.length != 0 && array2.length != 0) {
            for (int length = array.length, i = 0; i < length; ++i) {
                if (Util.indexOf(array2, array[i]) != -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    private ConnectionSpec supportedSpec(final SSLSocket sslSocket, final boolean b) {
        final String[] cipherSuites = this.cipherSuites;
        String[] array;
        if (cipherSuites != null) {
            array = (String[])Util.intersect(String.class, cipherSuites, sslSocket.getEnabledCipherSuites());
        }
        else {
            array = sslSocket.getEnabledCipherSuites();
        }
        final String[] tlsVersions = this.tlsVersions;
        String[] enabledProtocols;
        if (tlsVersions != null) {
            enabledProtocols = (String[])Util.intersect(String.class, tlsVersions, sslSocket.getEnabledProtocols());
        }
        else {
            enabledProtocols = sslSocket.getEnabledProtocols();
        }
        if (b && Util.indexOf(sslSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            array = Util.concat(array, "TLS_FALLBACK_SCSV");
        }
        return new ConnectionSpec$Builder(this).cipherSuites(array).tlsVersions(enabledProtocols).build();
    }
    
    void apply(final SSLSocket sslSocket, final boolean b) {
        final ConnectionSpec supportedSpec = this.supportedSpec(sslSocket, b);
        final String[] tlsVersions = supportedSpec.tlsVersions;
        if (tlsVersions != null) {
            sslSocket.setEnabledProtocols(tlsVersions);
        }
        final String[] cipherSuites = supportedSpec.cipherSuites;
        if (cipherSuites != null) {
            sslSocket.setEnabledCipherSuites(cipherSuites);
        }
    }
    
    public List cipherSuites() {
        final String[] cipherSuites = this.cipherSuites;
        if (cipherSuites == null) {
            return null;
        }
        final CipherSuite[] array = new CipherSuite[cipherSuites.length];
        int n = 0;
        while (true) {
            final String[] cipherSuites2 = this.cipherSuites;
            if (n >= cipherSuites2.length) {
                break;
            }
            array[n] = CipherSuite.forJavaName(cipherSuites2[n]);
            ++n;
        }
        return Util.immutableList((Object[])array);
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof ConnectionSpec)) {
            return false;
        }
        final boolean b = true;
        if (o == this) {
            return b;
        }
        final ConnectionSpec connectionSpec = (ConnectionSpec)o;
        final boolean tls = this.tls;
        if (tls != connectionSpec.tls) {
            return false;
        }
        if (tls) {
            if (!Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites)) {
                return false;
            }
            if (!Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions)) {
                return false;
            }
            if (this.supportsTlsExtensions != connectionSpec.supportsTlsExtensions) {
                return false;
            }
        }
        return b;
    }
    
    public int hashCode() {
        int n = 17;
        if (this.tls) {
            n = ((n * 31 + Arrays.hashCode(this.cipherSuites)) * 31 + Arrays.hashCode(this.tlsVersions)) * 31 + ((this.supportsTlsExtensions ^ true) ? 1 : 0);
        }
        return n;
    }
    
    public boolean isCompatible(final SSLSocket sslSocket) {
        if (!this.tls) {
            return false;
        }
        final String[] tlsVersions = this.tlsVersions;
        if (tlsVersions != null && !nonEmptyIntersection(tlsVersions, sslSocket.getEnabledProtocols())) {
            return false;
        }
        final String[] cipherSuites = this.cipherSuites;
        return cipherSuites == null || nonEmptyIntersection(cipherSuites, sslSocket.getEnabledCipherSuites());
    }
    
    public boolean isTls() {
        return this.tls;
    }
    
    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }
    
    public List tlsVersions() {
        final String[] tlsVersions = this.tlsVersions;
        if (tlsVersions == null) {
            return null;
        }
        final TlsVersion[] array = new TlsVersion[tlsVersions.length];
        int n = 0;
        while (true) {
            final String[] tlsVersions2 = this.tlsVersions;
            if (n >= tlsVersions2.length) {
                break;
            }
            array[n] = TlsVersion.forJavaName(tlsVersions2[n]);
            ++n;
        }
        return Util.immutableList((Object[])array);
    }
    
    public String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        String string;
        if (this.cipherSuites != null) {
            string = this.cipherSuites().toString();
        }
        else {
            string = "[all enabled]";
        }
        String string2;
        if (this.tlsVersions != null) {
            string2 = this.tlsVersions().toString();
        }
        else {
            string2 = "[all enabled]";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(string);
        sb.append(", tlsVersions=");
        sb.append(string2);
        sb.append(", supportsTlsExtensions=");
        sb.append(this.supportsTlsExtensions);
        sb.append(")");
        return sb.toString();
    }
}
