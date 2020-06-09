// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.content.Context;

class FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompat$FingerprintManagerCompatImpl
{
    public void authenticate(final Context context, final FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject, final int n, final CancellationSignal cancellationSignal, final FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback, final Handler handler) {
    }
    
    public boolean hasEnrolledFingerprints(final Context context) {
        return false;
    }
    
    public boolean isHardwareDetected(final Context context) {
        return false;
    }
}
