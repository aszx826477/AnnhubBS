// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import java.lang.reflect.Method;

final class TrustRootIndex$AndroidTrustRootIndex extends TrustRootIndex
{
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;
    
    TrustRootIndex$AndroidTrustRootIndex(final X509TrustManager trustManager, final Method findByIssuerAndSignatureMethod) {
        this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        this.trustManager = trustManager;
    }
    
    public X509Certificate findByIssuerAndSignature(final X509Certificate x509Certificate) {
        X509Certificate trustedCert = null;
        try {
            final Method findByIssuerAndSignatureMethod = this.findByIssuerAndSignatureMethod;
            try {
                final Object invoke = findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                try {
                    final TrustAnchor trustAnchor = (TrustAnchor)invoke;
                    if (trustAnchor != null) {
                        trustedCert = trustAnchor.getTrustedCert();
                    }
                    return trustedCert;
                }
                catch (InvocationTargetException ex) {
                    return null;
                }
                catch (IllegalAccessException ex2) {
                    throw new AssertionError();
                }
            }
            catch (InvocationTargetException ex3) {}
            catch (IllegalAccessException ex4) {}
        }
        catch (InvocationTargetException ex5) {}
        catch (IllegalAccessException ex6) {}
    }
}
