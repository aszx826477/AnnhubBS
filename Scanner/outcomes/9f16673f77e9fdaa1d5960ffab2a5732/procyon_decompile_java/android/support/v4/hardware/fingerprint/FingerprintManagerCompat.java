// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import android.os.Build$VERSION;
import android.content.Context;

public final class FingerprintManagerCompat
{
    static final FingerprintManagerCompat$FingerprintManagerCompatImpl IMPL;
    private Context mContext;
    
    static {
        if (Build$VERSION.SDK_INT >= 23) {
            IMPL = new FingerprintManagerCompat$Api23FingerprintManagerCompatImpl();
        }
        else {
            IMPL = new FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl();
        }
    }
    
    private FingerprintManagerCompat(final Context mContext) {
        this.mContext = mContext;
    }
    
    public static FingerprintManagerCompat from(final Context context) {
        return new FingerprintManagerCompat(context);
    }
    
    public void authenticate(final FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject, final int n, final CancellationSignal cancellationSignal, final FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback, final Handler handler) {
        FingerprintManagerCompat.IMPL.authenticate(this.mContext, fingerprintManagerCompat$CryptoObject, n, cancellationSignal, fingerprintManagerCompat$AuthenticationCallback, handler);
    }
    
    public boolean hasEnrolledFingerprints() {
        return FingerprintManagerCompat.IMPL.hasEnrolledFingerprints(this.mContext);
    }
    
    public boolean isHardwareDetected() {
        return FingerprintManagerCompat.IMPL.isHardwareDetected(this.mContext);
    }
}
