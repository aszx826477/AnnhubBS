// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager$CryptoObject;
import android.hardware.fingerprint.FingerprintManager$AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager$AuthenticationCallback;

final class FingerprintManagerCompatApi23$1 extends FingerprintManager$AuthenticationCallback
{
    final /* synthetic */ FingerprintManagerCompatApi23$AuthenticationCallback val$callback;
    
    FingerprintManagerCompatApi23$1(final FingerprintManagerCompatApi23$AuthenticationCallback val$callback) {
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
    
    public void onAuthenticationSucceeded(final FingerprintManager$AuthenticationResult fingerprintManager$AuthenticationResult) {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23$AuthenticationResultInternal(unwrapCryptoObject(fingerprintManager$AuthenticationResult.getCryptoObject())));
    }
}
