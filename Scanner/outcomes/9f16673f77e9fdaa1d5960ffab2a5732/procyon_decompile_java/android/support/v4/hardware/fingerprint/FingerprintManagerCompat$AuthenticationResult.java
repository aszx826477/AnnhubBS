// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

public final class FingerprintManagerCompat$AuthenticationResult
{
    private FingerprintManagerCompat$CryptoObject mCryptoObject;
    
    public FingerprintManagerCompat$AuthenticationResult(final FingerprintManagerCompat$CryptoObject mCryptoObject) {
        this.mCryptoObject = mCryptoObject;
    }
    
    public FingerprintManagerCompat$CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }
}
