// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.lang.reflect.Method;
import okhttp3.internal.tls.CertificateChainCleaner;

final class AndroidPlatform$AndroidCertificateChainCleaner extends CertificateChainCleaner
{
    private final Method checkServerTrusted;
    private final Object x509TrustManagerExtensions;
    
    AndroidPlatform$AndroidCertificateChainCleaner(final Object x509TrustManagerExtensions, final Method checkServerTrusted) {
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
        this.checkServerTrusted = checkServerTrusted;
    }
    
    public List clean(final List list, final String s) {
        try {
            final int size = list.size();
            try {
                final X509Certificate[] array = list.toArray(new X509Certificate[size]);
                try {
                    final X509Certificate[] array2 = array;
                    try {
                        final Method checkServerTrusted = this.checkServerTrusted;
                        try {
                            final Object invoke = checkServerTrusted.invoke(this.x509TrustManagerExtensions, array2, "RSA", s);
                            try {
                                return (List)invoke;
                            }
                            catch (IllegalAccessException ex) {
                                throw new AssertionError((Object)ex);
                            }
                            catch (InvocationTargetException ex3) {
                                final SSLPeerUnverifiedException ex2 = new SSLPeerUnverifiedException(ex3.getMessage());
                                ex2.initCause(ex3);
                                throw ex2;
                            }
                        }
                        catch (IllegalAccessException ex4) {}
                        catch (InvocationTargetException ex5) {}
                    }
                    catch (IllegalAccessException ex6) {}
                    catch (InvocationTargetException ex7) {}
                }
                catch (IllegalAccessException ex8) {}
                catch (InvocationTargetException ex9) {}
            }
            catch (IllegalAccessException ex10) {}
            catch (InvocationTargetException ex11) {}
        }
        catch (IllegalAccessException ex12) {}
        catch (InvocationTargetException ex13) {}
    }
}
