// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.util.List;
import java.security.cert.X509Certificate;
import okhttp3.internal.platform.Platform;
import javax.net.ssl.X509TrustManager;

public abstract class CertificateChainCleaner
{
    public static CertificateChainCleaner get(final X509TrustManager x509TrustManager) {
        return Platform.get().buildCertificateChainCleaner(x509TrustManager);
    }
    
    public static CertificateChainCleaner get(final X509Certificate... array) {
        return new BasicCertificateChainCleaner(TrustRootIndex.get(array));
    }
    
    public abstract List clean(final List p0, final String p1);
}
