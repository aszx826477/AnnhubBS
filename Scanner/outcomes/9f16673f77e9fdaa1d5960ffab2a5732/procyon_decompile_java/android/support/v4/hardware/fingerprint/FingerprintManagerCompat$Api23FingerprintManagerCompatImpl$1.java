// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

final class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1 extends FingerprintManagerCompatApi23$AuthenticationCallback
{
    final /* synthetic */ FingerprintManagerCompat$AuthenticationCallback val$callback;
    
    FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(final FingerprintManagerCompat$AuthenticationCallback val$callback) {
        this.val$callback = val$callback;
    }
    
    public void onAuthenticationError(final int n, final CharSequence charSequence) {
        this.val$callback.onAuthenticationError(n, charSequence);
    }
    
    public void onAuthenticationFailed() {
        this.val$callback.onAuthenticationFailed();
    }
    
    public void onAuthenticationHelp(final int n, final CharSequence charSequence) {
        this.val$callback.onAuthenticationHelp(n, charSequence);
    }
    
    public void onAuthenticationSucceeded(final FingerprintManagerCompatApi23$AuthenticationResultInternal fingerprintManagerCompatApi23$AuthenticationResultInternal) {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat$AuthenticationResult(FingerprintManagerCompat$Api23FingerprintManagerCompatImpl.unwrapCryptoObject(fingerprintManagerCompatApi23$AuthenticationResultInternal.getCryptoObject())));
    }
}
