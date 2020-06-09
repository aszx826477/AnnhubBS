// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.security.PublicKey;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.security.cert.X509Certificate;
import java.util.Map;

final class TrustRootIndex$BasicTrustRootIndex extends TrustRootIndex
{
    private final Map subjectToCaCerts;
    
    public TrustRootIndex$BasicTrustRootIndex(final X509Certificate... array) {
        this.subjectToCaCerts = new LinkedHashMap();
        for (int length = array.length, i = 0; i < length; ++i) {
            final X509Certificate x509Certificate = array[i];
            final X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List<?> list = this.subjectToCaCerts.get(subjectX500Principal);
            if (list == null) {
                list = new ArrayList<Object>(1);
                this.subjectToCaCerts.put(subjectX500Principal, list);
            }
            list.add(x509Certificate);
        }
    }
    
    public X509Certificate findByIssuerAndSignature(final X509Certificate x509Certificate) {
        final List<X509Certificate> list = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (final X509Certificate x509Certificate2 : list) {
            final PublicKey publicKey = x509Certificate2.getPublicKey();
            try {
                x509Certificate.verify(publicKey);
                return x509Certificate2;
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
        return null;
    }
}
