// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import javax.security.auth.x500.X500Principal;
import java.security.cert.X509Certificate;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import okhttp3.internal.Util;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.util.List;

public final class Handshake
{
    private final CipherSuite cipherSuite;
    private final List localCertificates;
    private final List peerCertificates;
    private final TlsVersion tlsVersion;
    
    private Handshake(final TlsVersion tlsVersion, final CipherSuite cipherSuite, final List peerCertificates, final List localCertificates) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = peerCertificates;
        this.localCertificates = localCertificates;
    }
    
    public static Handshake get(final SSLSession sslSession) {
        final String cipherSuite = sslSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        final CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
        final String protocol = sslSession.getProtocol();
        if (protocol != null) {
            final TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
            Certificate[] peerCertificates;
            try {
                peerCertificates = sslSession.getPeerCertificates();
            }
            catch (SSLPeerUnverifiedException ex) {
                peerCertificates = null;
            }
            List<Object> list;
            if (peerCertificates != null) {
                list = (List<Object>)Util.immutableList((Object[])peerCertificates);
            }
            else {
                list = Collections.emptyList();
            }
            final Certificate[] localCertificates = sslSession.getLocalCertificates();
            List<Object> list2;
            if (localCertificates != null) {
                list2 = (List<Object>)Util.immutableList((Object[])localCertificates);
            }
            else {
                list2 = Collections.emptyList();
            }
            return new Handshake(forJavaName2, forJavaName, list, list2);
        }
        throw new IllegalStateException("tlsVersion == null");
    }
    
    public static Handshake get(final TlsVersion tlsVersion, final CipherSuite cipherSuite, final List list, final List list2) {
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }
    
    public CipherSuite cipherSuite() {
        return this.cipherSuite;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Handshake;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final Handshake handshake = (Handshake)o;
        if (Util.equal(this.cipherSuite, handshake.cipherSuite)) {
            if (this.cipherSuite.equals(handshake.cipherSuite)) {
                if (this.peerCertificates.equals(handshake.peerCertificates)) {
                    if (this.localCertificates.equals(handshake.localCertificates)) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public int hashCode() {
        final int n = 17 * 31;
        final TlsVersion tlsVersion = this.tlsVersion;
        int hashCode;
        if (tlsVersion != null) {
            hashCode = tlsVersion.hashCode();
        }
        else {
            hashCode = 0;
        }
        return (((n + hashCode) * 31 + this.cipherSuite.hashCode()) * 31 + this.peerCertificates.hashCode()) * 31 + this.localCertificates.hashCode();
    }
    
    public List localCertificates() {
        return this.localCertificates;
    }
    
    public Principal localPrincipal() {
        X500Principal subjectX500Principal;
        if (!this.localCertificates.isEmpty()) {
            subjectX500Principal = this.localCertificates.get(0).getSubjectX500Principal();
        }
        else {
            subjectX500Principal = null;
        }
        return subjectX500Principal;
    }
    
    public List peerCertificates() {
        return this.peerCertificates;
    }
    
    public Principal peerPrincipal() {
        X500Principal subjectX500Principal;
        if (!this.peerCertificates.isEmpty()) {
            subjectX500Principal = this.peerCertificates.get(0).getSubjectX500Principal();
        }
        else {
            subjectX500Principal = null;
        }
        return subjectX500Principal;
    }
    
    public TlsVersion tlsVersion() {
        return this.tlsVersion;
    }
}
