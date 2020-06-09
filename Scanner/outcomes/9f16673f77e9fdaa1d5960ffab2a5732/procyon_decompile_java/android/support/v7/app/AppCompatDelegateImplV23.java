// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Window;
import android.content.Context;
import android.app.UiModeManager;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14
{
    private final UiModeManager mUiModeManager;
    
    AppCompatDelegateImplV23(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mUiModeManager = (UiModeManager)context.getSystemService("uimode");
    }
    
    int mapNightMode(final int n) {
        if (n == 0 && this.mUiModeManager.getNightMode() == 0) {
            return -1;
        }
        return super.mapNightMode(n);
    }
    
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatDelegateImplV23$AppCompatWindowCallbackV23(this, window$Callback);
    }
}
