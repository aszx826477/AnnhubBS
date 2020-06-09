// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.util.Log;
import android.view.SubMenu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;

public abstract class ActionProvider
{
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
    private ActionProvider$VisibilityListener mVisibilityListener;
    
    public ActionProvider(final Context mContext) {
        this.mContext = mContext;
    }
    
    public Context getContext() {
        return this.mContext;
    }
    
    public boolean hasSubMenu() {
        return false;
    }
    
    public boolean isVisible() {
        return true;
    }
    
    public abstract View onCreateActionView();
    
    public View onCreateActionView(final MenuItem menuItem) {
        return this.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction() {
        return false;
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
    }
    
    public boolean overridesItemVisibility() {
        return false;
    }
    
    public void refreshVisibility() {
        if (this.mVisibilityListener != null && this.overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
        }
    }
    
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }
    
    public void setSubUiVisibilityListener(final ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener) {
        this.mSubUiVisibilityListener = mSubUiVisibilityListener;
    }
    
    public void setVisibilityListener(final ActionProvider$VisibilityListener mVisibilityListener) {
        if (this.mVisibilityListener != null && mVisibilityListener != null) {
            final String s = "ActionProvider(support)";
            final StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(this.getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            Log.w(s, sb.toString());
        }
        this.mVisibilityListener = mVisibilityListener;
    }
    
    public void subUiVisibilityChanged(final boolean b) {
        final ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener = this.mSubUiVisibilityListener;
        if (mSubUiVisibilityListener != null) {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(b);
        }
    }
}
