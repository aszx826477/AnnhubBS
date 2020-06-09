// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.List;

public final class CertificatePinner$Builder
{
    private final List pins;
    
    public CertificatePinner$Builder() {
        this.pins = new ArrayList();
    }
    
    public CertificatePinner$Builder add(final String s, final String... array) {
        if (s != null) {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.pins.add(new CertificatePinner$Pin(s, array[i]));
            }
            return this;
        }
        throw new NullPointerException("pattern == null");
    }
    
    public CertificatePinner build() {
        return new CertificatePinner(Util.immutableList(this.pins), null, null);
    }
}
