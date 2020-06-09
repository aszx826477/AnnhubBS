// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;

class AppCompatDelegateImplV9$ActionModeCallbackWrapperV9 implements ActionMode$Callback
{
    private ActionMode$Callback mWrapped;
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    public AppCompatDelegateImplV9$ActionModeCallbackWrapperV9(final AppCompatDelegateImplV9 this$0, final ActionMode$Callback mWrapped) {
        this.this$0 = this$0;
        this.mWrapped = mWrapped;
    }
    
    public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }
    
    public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrapped.onCreateActionMode(actionMode, menu);
    }
    
    public void onDestroyActionMode(final ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        if (this.this$0.mActionModePopup != null) {
            this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        }
        if (this.this$0.mActionModeView != null) {
            this.this$0.endOnGoingFadeAnimation();
            final AppCompatDelegateImplV9 this$0 = this.this$0;
            this$0.mFadeAnim = ViewCompat.animate((View)this$0.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AppCompatDelegateImplV9$ActionModeCallbackWrapperV9$1(this));
        }
        if (this.this$0.mAppCompatCallback != null) {
            this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
        }
        this.this$0.mActionMode = null;
    }
    
    public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }
}
