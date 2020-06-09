// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.view.SupportActionModeWrapper$CallbackWrapper;
import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.Window$Callback;

class AppCompatDelegateImplV14$AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase$AppCompatWindowCallbackBase
{
    final /* synthetic */ AppCompatDelegateImplV14 this$0;
    
    AppCompatDelegateImplV14$AppCompatWindowCallbackV14(final AppCompatDelegateImplV14 this$0, final Window$Callback window$Callback) {
        this.this$0 = this$0;
        super(this$0, window$Callback);
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback) {
        if (this.this$0.isHandleNativeActionModesEnabled()) {
            return this.startAsSupportActionMode(actionMode$Callback);
        }
        return super.onWindowStartingActionMode(actionMode$Callback);
    }
    
    final ActionMode startAsSupportActionMode(final ActionMode$Callback actionMode$Callback) {
        final SupportActionModeWrapper$CallbackWrapper supportActionModeWrapper$CallbackWrapper = new SupportActionModeWrapper$CallbackWrapper(this.this$0.mContext, actionMode$Callback);
        final android.support.v7.view.ActionMode startSupportActionMode = this.this$0.startSupportActionMode(supportActionModeWrapper$CallbackWrapper);
        if (startSupportActionMode != null) {
            return supportActionModeWrapper$CallbackWrapper.getActionModeWrapper(startSupportActionMode);
        }
        return null;
    }
}
