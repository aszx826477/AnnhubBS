// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import java.lang.ref.WeakReference;
import android.support.v7.view.ActionMode$Callback;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.ActionMode;

public class WindowDecorActionBar$ActionModeImpl extends ActionMode implements MenuBuilder$Callback
{
    private final Context mActionModeContext;
    private ActionMode$Callback mCallback;
    private WeakReference mCustomView;
    private final MenuBuilder mMenu;
    final /* synthetic */ WindowDecorActionBar this$0;
    
    public WindowDecorActionBar$ActionModeImpl(final WindowDecorActionBar this$0, final Context mActionModeContext, final ActionMode$Callback mCallback) {
        this.this$0 = this$0;
        this.mActionModeContext = mActionModeContext;
        this.mCallback = mCallback;
        (this.mMenu = new MenuBuilder(mActionModeContext).setDefaultShowAsAction(1)).setCallback(this);
    }
    
    public boolean dispatchOnCreate() {
        this.mMenu.stopDispatchingItemsChanged();
        try {
            return this.mCallback.onCreateActionMode(this, (Menu)this.mMenu);
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }
    
    public void finish() {
        if (this.this$0.mActionMode != this) {
            return;
        }
        if (!WindowDecorActionBar.checkShowingFlags(this.this$0.mHiddenByApp, this.this$0.mHiddenBySystem, false)) {
            final WindowDecorActionBar this$0 = this.this$0;
            this$0.mDeferredDestroyActionMode = this;
            this$0.mDeferredModeDestroyCallback = this.mCallback;
        }
        else {
            this.mCallback.onDestroyActionMode(this);
        }
        this.mCallback = null;
        this.this$0.animateToMode(false);
        this.this$0.mContextView.closeMode();
        this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
        this.this$0.mOverlayLayout.setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
        this.this$0.mActionMode = null;
    }
    
    public View getCustomView() {
        final WeakReference mCustomView = this.mCustomView;
        View view;
        if (mCustomView != null) {
            view = mCustomView.get();
        }
        else {
            view = null;
        }
        return view;
    }
    
    public Menu getMenu() {
        return (Menu)this.mMenu;
    }
    
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mActionModeContext);
    }
    
    public CharSequence getSubtitle() {
        return this.this$0.mContextView.getSubtitle();
    }
    
    public CharSequence getTitle() {
        return this.this$0.mContextView.getTitle();
    }
    
    public void invalidate() {
        if (this.this$0.mActionMode != this) {
            return;
        }
        this.mMenu.stopDispatchingItemsChanged();
        try {
            this.mCallback.onPrepareActionMode(this, (Menu)this.mMenu);
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }
    
    public boolean isTitleOptional() {
        return this.this$0.mContextView.isTitleOptional();
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        final ActionMode$Callback mCallback = this.mCallback;
        return mCallback != null && mCallback.onActionItemClicked(this, menuItem);
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (this.mCallback == null) {
            return;
        }
        this.invalidate();
        this.this$0.mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (this.mCallback == null) {
            return false;
        }
        final boolean hasVisibleItems = subMenuBuilder.hasVisibleItems();
        final boolean b = true;
        if (!hasVisibleItems) {
            return b;
        }
        new MenuPopupHelper(this.this$0.getThemedContext(), subMenuBuilder).show();
        return b;
    }
    
    public void setCustomView(final View customView) {
        this.this$0.mContextView.setCustomView(customView);
        this.mCustomView = new WeakReference((T)customView);
    }
    
    public void setSubtitle(final int n) {
        this.setSubtitle(this.this$0.mContext.getResources().getString(n));
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        this.this$0.mContextView.setSubtitle(subtitle);
    }
    
    public void setTitle(final int n) {
        this.setTitle(this.this$0.mContext.getResources().getString(n));
    }
    
    public void setTitle(final CharSequence title) {
        this.this$0.mContextView.setTitle(title);
    }
    
    public void setTitleOptionalHint(final boolean b) {
        super.setTitleOptionalHint(b);
        this.this$0.mContextView.setTitleOptional(b);
    }
}
