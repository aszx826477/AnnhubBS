// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Window;
import android.content.Context;

class AppCompatDelegateImplN extends AppCompatDelegateImplV23
{
    AppCompatDelegateImplN(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }
    
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatDelegateImplN$AppCompatWindowCallbackN(this, window$Callback);
    }
}
