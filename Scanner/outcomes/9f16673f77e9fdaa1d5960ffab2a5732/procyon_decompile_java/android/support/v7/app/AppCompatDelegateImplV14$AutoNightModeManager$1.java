// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class AppCompatDelegateImplV14$AutoNightModeManager$1 extends BroadcastReceiver
{
    final /* synthetic */ AppCompatDelegateImplV14$AutoNightModeManager this$1;
    
    AppCompatDelegateImplV14$AutoNightModeManager$1(final AppCompatDelegateImplV14$AutoNightModeManager this$1) {
        this.this$1 = this$1;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        this.this$1.dispatchTimeChanged();
    }
}
