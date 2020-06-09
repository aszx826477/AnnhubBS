// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public abstract class TrustRootIndex
{
    public static TrustRootIndex get(final X509TrustManager x509TrustManager) {
        try {
            final Class<? extends X509TrustManager> class1 = x509TrustManager.getClass();
            final String s = "findTrustAnchorByIssuerAndSignature";
            final int accessible = 1;
            final Class[] array = new Class[accessible];
            array[0] = X509Certificate.class;
            final Method declaredMethod = class1.getDeclaredMethod(s, (Class<?>[])array);
            declaredMethod.setAccessible(accessible != 0);
            return new TrustRootIndex$AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        }
        catch (NoSuchMethodException ex) {
            return get(x509TrustManager.getAcceptedIssuers());
        }
    }
    
    public static TrustRootIndex get(final X509Certificate... array) {
        return new TrustRootIndex$BasicTrustRootIndex(array);
    }
    
    public abstract X509Certificate findByIssuerAndSignature(final X509Certificate p0);
}
