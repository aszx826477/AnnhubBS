// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

public final class FingerprintManagerCompatApi23$AuthenticationResultInternal
{
    private FingerprintManagerCompatApi23$CryptoObject mCryptoObject;
    
    public FingerprintManagerCompatApi23$AuthenticationResultInternal(final FingerprintManagerCompatApi23$CryptoObject mCryptoObject) {
        this.mCryptoObject = mCryptoObject;
    }
    
    public FingerprintManagerCompatApi23$CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }
}
