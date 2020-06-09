// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.Cipher;

public class FingerprintManagerCompat$CryptoObject
{
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public FingerprintManagerCompat$CryptoObject(final Signature mSignature) {
        this.mSignature = mSignature;
        this.mCipher = null;
        this.mMac = null;
    }
    
    public FingerprintManagerCompat$CryptoObject(final Cipher mCipher) {
        this.mCipher = mCipher;
        this.mSignature = null;
        this.mMac = null;
    }
    
    public FingerprintManagerCompat$CryptoObject(final Mac mMac) {
        this.mMac = mMac;
        this.mCipher = null;
        this.mSignature = null;
    }
    
    public Cipher getCipher() {
        return this.mCipher;
    }
    
    public Mac getMac() {
        return this.mMac;
    }
    
    public Signature getSignature() {
        return this.mSignature;
    }
}
