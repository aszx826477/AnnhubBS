// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;
import android.support.v7.view.menu.MenuBuilder;
import java.lang.ref.WeakReference;
import android.support.v7.widget.ActionBarContextView;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder$Callback;

public class StandaloneActionMode extends ActionMode implements MenuBuilder$Callback
{
    private ActionMode$Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;
    
    public StandaloneActionMode(final Context mContext, final ActionBarContextView mContextView, final ActionMode$Callback mCallback, final boolean mFocusable) {
        this.mContext = mContext;
        this.mContextView = mContextView;
        this.mCallback = mCallback;
        (this.mMenu = new MenuBuilder(mContextView.getContext()).setDefaultShowAsAction(1)).setCallback(this);
        this.mFocusable = mFocusable;
    }
    
    public void finish() {
        if (this.mFinished) {
            return;
        }
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
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
        return new SupportMenuInflater(this.mContextView.getContext());
    }
    
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }
    
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }
    
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, (Menu)this.mMenu);
    }
    
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }
    
    public boolean isUiFocusable() {
        return this.mFocusable;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.invalidate();
        this.mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        final boolean hasVisibleItems = subMenuBuilder.hasVisibleItems();
        final boolean b = true;
        if (!hasVisibleItems) {
            return b;
        }
        new MenuPopupHelper(this.mContextView.getContext(), subMenuBuilder).show();
        return b;
    }
    
    public void setCustomView(final View customView) {
        this.mContextView.setCustomView(customView);
        WeakReference mCustomView;
        if (customView != null) {
            mCustomView = new WeakReference((T)customView);
        }
        else {
            mCustomView = null;
        }
        this.mCustomView = mCustomView;
    }
    
    public void setSubtitle(final int n) {
        this.setSubtitle(this.mContext.getString(n));
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        this.mContextView.setSubtitle(subtitle);
    }
    
    public void setTitle(final int n) {
        this.setTitle(this.mContext.getString(n));
    }
    
    public void setTitle(final CharSequence title) {
        this.mContextView.setTitle(title);
    }
    
    public void setTitleOptionalHint(final boolean b) {
        super.setTitleOptionalHint(b);
        this.mContextView.setTitleOptional(b);
    }
}
