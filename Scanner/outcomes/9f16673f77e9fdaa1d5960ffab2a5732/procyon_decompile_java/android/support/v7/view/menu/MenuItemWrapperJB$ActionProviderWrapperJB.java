// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.View;
import android.view.MenuItem;
import android.view.ActionProvider;
import android.content.Context;
import android.view.ActionProvider$VisibilityListener;

class MenuItemWrapperJB$ActionProviderWrapperJB extends MenuItemWrapperICS$ActionProviderWrapper implements ActionProvider$VisibilityListener
{
    android.support.v4.view.ActionProvider$VisibilityListener mListener;
    final /* synthetic */ MenuItemWrapperJB this$0;
    
    public MenuItemWrapperJB$ActionProviderWrapperJB(final MenuItemWrapperJB this$0, final Context context, final android.view.ActionProvider actionProvider) {
        this.this$0 = this$0;
        super(this$0, context, actionProvider);
    }
    
    public boolean isVisible() {
        return this.mInner.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(final boolean b) {
        final android.support.v4.view.ActionProvider$VisibilityListener mListener = this.mListener;
        if (mListener != null) {
            mListener.onActionProviderVisibilityChanged(b);
        }
    }
    
    public View onCreateActionView(final MenuItem menuItem) {
        return this.mInner.onCreateActionView(menuItem);
    }
    
    public boolean overridesItemVisibility() {
        return this.mInner.overridesItemVisibility();
    }
    
    public void refreshVisibility() {
        this.mInner.refreshVisibility();
    }
    
    public void setVisibilityListener(final android.support.v4.view.ActionProvider$VisibilityListener mListener) {
        this.mListener = mListener;
        final android.view.ActionProvider mInner = this.mInner;
        Object visibilityListener;
        if (mListener != null) {
            visibilityListener = this;
        }
        else {
            visibilityListener = null;
        }
        mInner.setVisibilityListener((ActionProvider$VisibilityListener)visibilityListener);
    }
}
