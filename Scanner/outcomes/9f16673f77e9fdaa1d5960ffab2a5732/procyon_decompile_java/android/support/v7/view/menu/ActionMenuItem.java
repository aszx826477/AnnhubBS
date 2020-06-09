// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.view.MenuItem$OnActionExpandListener;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.View;
import android.view.ActionProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.view.MenuItem$OnMenuItemClickListener;
import android.support.v4.internal.view.SupportMenuItem;

public class ActionMenuItem implements SupportMenuItem
{
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int NO_ICON;
    private final int mCategoryOrder;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    
    public ActionMenuItem(final Context mContext, final int mGroup, final int mId, final int mCategoryOrder, final int mOrdering, final CharSequence mTitle) {
        this.mIconResId = 0;
        this.mFlags = 16;
        this.mContext = mContext;
        this.mId = mId;
        this.mGroup = mGroup;
        this.mCategoryOrder = mCategoryOrder;
        this.mOrdering = mOrdering;
        this.mTitle = mTitle;
    }
    
    public boolean collapseActionView() {
        return false;
    }
    
    public boolean expandActionView() {
        return false;
    }
    
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }
    
    public View getActionView() {
        return null;
    }
    
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }
    
    public int getGroupId() {
        return this.mGroup;
    }
    
    public Drawable getIcon() {
        return this.mIconDrawable;
    }
    
    public Intent getIntent() {
        return this.mIntent;
    }
    
    public int getItemId() {
        return this.mId;
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return null;
    }
    
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }
    
    public int getOrder() {
        return this.mOrdering;
    }
    
    public SubMenu getSubMenu() {
        return null;
    }
    
    public android.support.v4.view.ActionProvider getSupportActionProvider() {
        return null;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            charSequence = this.mTitle;
        }
        return charSequence;
    }
    
    public boolean hasSubMenu() {
        return false;
    }
    
    public boolean invoke() {
        final MenuItem$OnMenuItemClickListener mClickListener = this.mClickListener;
        final boolean b = true;
        if (mClickListener != null && mClickListener.onMenuItemClick((MenuItem)this)) {
            return b;
        }
        final Intent mIntent = this.mIntent;
        if (mIntent != null) {
            this.mContext.startActivity(mIntent);
            return b;
        }
        return false;
    }
    
    public boolean isActionViewExpanded() {
        return false;
    }
    
    public boolean isCheckable() {
        final int mFlags = this.mFlags;
        boolean b = true;
        if ((mFlags & (b ? 1 : 0)) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public boolean isChecked() {
        return (this.mFlags & 0x2) != 0x0;
    }
    
    public boolean isEnabled() {
        return (this.mFlags & 0x10) != 0x0;
    }
    
    public boolean isVisible() {
        return (this.mFlags & 0x8) == 0x0;
    }
    
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }
    
    public SupportMenuItem setActionView(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public SupportMenuItem setActionView(final View view) {
        throw new UnsupportedOperationException();
    }
    
    public MenuItem setAlphabeticShortcut(final char mShortcutAlphabeticChar) {
        this.mShortcutAlphabeticChar = mShortcutAlphabeticChar;
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean b) {
        this.mFlags = ((this.mFlags & 0xFFFFFFFE) | (b ? 1 : 0));
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean b) {
        final int n = this.mFlags & 0xFFFFFFFD;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n | n2);
        return (MenuItem)this;
    }
    
    public MenuItem setEnabled(final boolean b) {
        final int n = this.mFlags & 0xFFFFFFEF;
        int n2;
        if (b) {
            n2 = 16;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n | n2);
        return (MenuItem)this;
    }
    
    public ActionMenuItem setExclusiveCheckable(final boolean b) {
        final int n = this.mFlags & 0xFFFFFFFB;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n | n2);
        return this;
    }
    
    public MenuItem setIcon(final int mIconResId) {
        this.mIconResId = mIconResId;
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, mIconResId);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable mIconDrawable) {
        this.mIconDrawable = mIconDrawable;
        this.mIconResId = 0;
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent mIntent) {
        this.mIntent = mIntent;
        return (MenuItem)this;
    }
    
    public MenuItem setNumericShortcut(final char mShortcutNumericChar) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        throw new UnsupportedOperationException();
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char mShortcutNumericChar, final char mShortcutAlphabeticChar) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mShortcutAlphabeticChar = mShortcutAlphabeticChar;
        return (MenuItem)this;
    }
    
    public void setShowAsAction(final int n) {
    }
    
    public SupportMenuItem setShowAsActionFlags(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    public SupportMenuItem setSupportActionProvider(final android.support.v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }
    
    public SupportMenuItem setSupportOnActionExpandListener(final MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        return this;
    }
    
    public MenuItem setTitle(final int n) {
        this.mTitle = this.mContext.getResources().getString(n);
        return (MenuItem)this;
    }
    
    public MenuItem setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence mTitleCondensed) {
        this.mTitleCondensed = mTitleCondensed;
        return (MenuItem)this;
    }
    
    public MenuItem setVisible(final boolean b) {
        final int mFlags = this.mFlags;
        int n = 8;
        final int n2 = mFlags & n;
        if (b) {
            n = 0;
        }
        this.mFlags = (n2 | n);
        return (MenuItem)this;
    }
}
