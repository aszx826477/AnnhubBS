// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.content.Context;

class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl implements FingerprintManagerCompat$FingerprintManagerCompatImpl
{
    static FingerprintManagerCompat$CryptoObject unwrapCryptoObject(final FingerprintManagerCompatApi23$CryptoObject fingerprintManagerCompatApi23$CryptoObject) {
        if (fingerprintManagerCompatApi23$CryptoObject == null) {
            return null;
        }
        if (fingerprintManagerCompatApi23$CryptoObject.getCipher() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManagerCompatApi23$CryptoObject.getCipher());
        }
        if (fingerprintManagerCompatApi23$CryptoObject.getSignature() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManagerCompatApi23$CryptoObject.getSignature());
        }
        if (fingerprintManagerCompatApi23$CryptoObject.getMac() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManagerCompatApi23$CryptoObject.getMac());
        }
        return null;
    }
    
    private static FingerprintManagerCompatApi23$AuthenticationCallback wrapCallback(final FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback) {
        return new FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(fingerprintManagerCompat$AuthenticationCallback);
    }
    
    private static FingerprintManagerCompatApi23$CryptoObject wrapCryptoObject(final FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject) {
        if (fingerprintManagerCompat$CryptoObject == null) {
            return null;
        }
        if (fingerprintManagerCompat$CryptoObject.getCipher() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(fingerprintManagerCompat$CryptoObject.getCipher());
        }
        if (fingerprintManagerCompat$CryptoObject.getSignature() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(fingerprintManagerCompat$CryptoObject.getSignature());
        }
        if (fingerprintManagerCompat$CryptoObject.getMac() != null) {
            return new FingerprintManagerCompatApi23$CryptoObject(fingerprintManagerCompat$CryptoObject.getMac());
        }
        return null;
    }
    
    public void authenticate(final Context context, final FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject, final int n, final CancellationSignal cancellationSignal, final FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback, final Handler handler) {
        final FingerprintManagerCompatApi23$CryptoObject wrapCryptoObject = wrapCryptoObject(fingerprintManagerCompat$CryptoObject);
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
        }
        else {
            cancellationSignalObject = null;
        }
        FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject, n, cancellationSignalObject, wrapCallback(fingerprintManagerCompat$AuthenticationCallback), handler);
    }
    
    public boolean hasEnrolledFingerprints(final Context context) {
        return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
    }
    
    public boolean isHardwareDetected(final Context context) {
        return FingerprintManagerCompatApi23.isHardwareDetected(context);
    }
}
