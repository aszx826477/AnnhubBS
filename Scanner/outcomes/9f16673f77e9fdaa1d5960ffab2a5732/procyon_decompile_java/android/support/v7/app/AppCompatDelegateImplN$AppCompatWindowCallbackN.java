// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Menu;
import java.util.List;
import android.view.Window$Callback;

class AppCompatDelegateImplN$AppCompatWindowCallbackN extends AppCompatDelegateImplV23$AppCompatWindowCallbackV23
{
    final /* synthetic */ AppCompatDelegateImplN this$0;
    
    AppCompatDelegateImplN$AppCompatWindowCallbackN(final AppCompatDelegateImplN this$0, final Window$Callback window$Callback) {
        this.this$0 = this$0;
        super(this$0, window$Callback);
    }
    
    public void onProvideKeyboardShortcuts(final List list, final Menu menu, final int n) {
        final AppCompatDelegateImplV9$PanelFeatureState panelState = this.this$0.getPanelState(0, true);
        if (panelState != null && panelState.menu != null) {
            super.onProvideKeyboardShortcuts(list, (Menu)panelState.menu, n);
        }
        else {
            super.onProvideKeyboardShortcuts(list, menu, n);
        }
    }
}
