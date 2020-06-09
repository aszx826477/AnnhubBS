// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okio.ByteString;
import java.security.cert.X509Certificate;
import java.security.cert.Certificate;
import java.util.List;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class CertificatePinner
{
    public static final CertificatePinner DEFAULT;
    private final CertificateChainCleaner certificateChainCleaner;
    private final List pins;
    
    static {
        DEFAULT = new CertificatePinner$Builder().build();
    }
    
    private CertificatePinner(final List pins, final CertificateChainCleaner certificateChainCleaner) {
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }
    
    public static String pin(final Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            final StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(sha256((X509Certificate)certificate).base64());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    
    static ByteString sha1(final X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }
    
    static ByteString sha256(final X509Certificate x509Certificate) {
        return Util.sha256(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }
    
    public void check(final String s, List clean) {
        final List matchingPins = this.findMatchingPins(s);
        if (matchingPins.isEmpty()) {
            return;
        }
        final CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            clean = certificateChainCleaner.clean(clean, s);
        }
        for (int i = 0; i < clean.size(); ++i) {
            final X509Certificate x509Certificate = clean.get(i);
            Object sha1 = null;
            Object sha2 = null;
            for (int j = 0; j < matchingPins.size(); ++j) {
                final CertificatePinner$Pin certificatePinner$Pin = matchingPins.get(j);
                if (certificatePinner$Pin.hashAlgorithm.equals("sha256/")) {
                    if (sha2 == null) {
                        sha2 = sha256(x509Certificate);
                    }
                    if (certificatePinner$Pin.hash.equals(sha2)) {
                        return;
                    }
                }
                else {
                    if (!certificatePinner$Pin.hashAlgorithm.equals("sha1/")) {
                        throw new AssertionError();
                    }
                    if (sha1 == null) {
                        sha1 = sha1(x509Certificate);
                    }
                    if (certificatePinner$Pin.hash.equals(sha1)) {
                        return;
                    }
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        final StringBuilder append = sb.append("\n  Peer certificate chain:");
        for (int k = 0; k < clean.size(); ++k) {
            final X509Certificate x509Certificate2 = clean.get(k);
            append.append("\n    ");
            append.append(pin(x509Certificate2));
            append.append(": ");
            append.append(x509Certificate2.getSubjectDN().getName());
        }
        append.append("\n  Pinned certificates for ");
        append.append(s);
        append.append(":");
        for (int l = 0; l < matchingPins.size(); ++l) {
            final CertificatePinner$Pin certificatePinner$Pin2 = matchingPins.get(l);
            append.append("\n    ");
            append.append(certificatePinner$Pin2);
        }
        throw new SSLPeerUnverifiedException(append.toString());
    }
    
    public void check(final String s, final Certificate... array) {
        this.check(s, Arrays.asList(array));
    }
    
    List findMatchingPins(final String s) {
        List<CertificatePinner$Pin> emptyList = Collections.emptyList();
        for (final CertificatePinner$Pin certificatePinner$Pin : this.pins) {
            if (certificatePinner$Pin.matches(s)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<CertificatePinner$Pin>();
                }
                emptyList.add(certificatePinner$Pin);
            }
        }
        return emptyList;
    }
    
    CertificatePinner withCertificateChainCleaner(final CertificateChainCleaner certificateChainCleaner) {
        CertificatePinner certificatePinner;
        if (this.certificateChainCleaner != certificateChainCleaner) {
            certificatePinner = new CertificatePinner(this.pins, certificateChainCleaner);
        }
        else {
            certificatePinner = this;
        }
        return certificatePinner;
    }
}
