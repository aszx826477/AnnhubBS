// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.util.Iterator;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayDeque;
import java.util.List;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner
{
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;
    
    public BasicCertificateChainCleaner(final TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }
    
    private boolean verifySignature(final X509Certificate x509Certificate, final X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException ex) {
            return false;
        }
    }
    
    public List clean(final List list, final String s) {
        final ArrayDeque<X509Certificate> arrayDeque = new ArrayDeque<X509Certificate>(list);
        final ArrayList<X509Certificate> list2 = new ArrayList<X509Certificate>();
        list2.add(arrayDeque.removeFirst());
        boolean b = false;
    Label_0245:
        for (int i = 0; i < 9; ++i) {
            final int size = list2.size();
            final int n = 1;
            final X509Certificate x509Certificate = list2.get(size - n);
            final X509Certificate byIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (byIssuerAndSignature != null) {
                if (list2.size() > n || x509Certificate.equals(byIssuerAndSignature)) {
                    list2.add(byIssuerAndSignature);
                }
                if (this.verifySignature(byIssuerAndSignature, byIssuerAndSignature)) {
                    return list2;
                }
                b = true;
            }
            else {
                final Iterator<Object> iterator = arrayDeque.iterator();
                while (iterator.hasNext()) {
                    final X509Certificate x509Certificate2 = iterator.next();
                    if (this.verifySignature(x509Certificate, x509Certificate2)) {
                        iterator.remove();
                        list2.add(x509Certificate2);
                        continue Label_0245;
                    }
                }
                if (b) {
                    return list2;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to find a trusted cert that signed ");
                sb.append(x509Certificate);
                throw new SSLPeerUnverifiedException(sb.toString());
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate chain too long: ");
        sb2.append(list2);
        throw new SSLPeerUnverifiedException(sb2.toString());
    }
}
