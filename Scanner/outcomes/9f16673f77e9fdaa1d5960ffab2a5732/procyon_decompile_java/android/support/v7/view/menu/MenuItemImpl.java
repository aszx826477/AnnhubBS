// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.support.v4.view.ActionProvider$VisibilityListener;
import android.view.MenuItem$OnActionExpandListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.ActivityNotFoundException;
import android.util.Log;
import android.os.Build$VERSION;
import android.view.SubMenu;
import android.support.v7.content.res.AppCompatResources;
import android.view.MenuItem;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.View;
import android.support.v4.view.ActionProvider;
import android.support.v4.internal.view.SupportMenuItem;

public final class MenuItemImpl implements SupportMenuItem
{
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu$ContextMenuInfo mMenuInfo;
    private MenuItemCompat$OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    
    MenuItemImpl(final MenuBuilder mMenu, final int mGroup, final int mId, final int mCategoryOrder, final int mOrdering, final CharSequence mTitle, final int mShowAsAction) {
        this.mIconResId = 0;
        this.mFlags = 16;
        this.mShowAsAction = 0;
        this.mIsActionViewExpanded = false;
        this.mMenu = mMenu;
        this.mId = mId;
        this.mGroup = mGroup;
        this.mCategoryOrder = mCategoryOrder;
        this.mOrdering = mOrdering;
        this.mTitle = mTitle;
        this.mShowAsAction = mShowAsAction;
    }
    
    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }
    
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 0x8) == 0x0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        final MenuItemCompat$OnActionExpandListener mOnActionExpandListener = this.mOnActionExpandListener;
        return (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) && this.mMenu.collapseItemActionView(this);
    }
    
    public boolean expandActionView() {
        if (!this.hasCollapsibleActionView()) {
            return false;
        }
        final MenuItemCompat$OnActionExpandListener mOnActionExpandListener = this.mOnActionExpandListener;
        return (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionExpand((MenuItem)this)) && this.mMenu.expandItemActionView(this);
    }
    
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }
    
    public View getActionView() {
        final View mActionView = this.mActionView;
        if (mActionView != null) {
            return mActionView;
        }
        final ActionProvider mActionProvider = this.mActionProvider;
        if (mActionProvider != null) {
            return this.mActionView = mActionProvider.onCreateActionView((MenuItem)this);
        }
        return null;
    }
    
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }
    
    Runnable getCallback() {
        return this.mItemCallback;
    }
    
    public int getGroupId() {
        return this.mGroup;
    }
    
    public Drawable getIcon() {
        final Drawable mIconDrawable = this.mIconDrawable;
        if (mIconDrawable != null) {
            return mIconDrawable;
        }
        if (this.mIconResId != 0) {
            final Drawable drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
            this.mIconResId = 0;
            return this.mIconDrawable = drawable;
        }
        return null;
    }
    
    public Intent getIntent() {
        return this.mIntent;
    }
    
    public int getItemId() {
        return this.mId;
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }
    
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }
    
    public int getOrder() {
        return this.mCategoryOrder;
    }
    
    public int getOrdering() {
        return this.mOrdering;
    }
    
    char getShortcut() {
        char c;
        if (this.mMenu.isQwertyMode()) {
            c = this.mShortcutAlphabeticChar;
        }
        else {
            c = this.mShortcutNumericChar;
        }
        return c;
    }
    
    String getShortcutLabel() {
        final char shortcut = this.getShortcut();
        if (shortcut == '\0') {
            return "";
        }
        final StringBuilder sb = new StringBuilder(MenuItemImpl.sPrependShortcutLabel);
        if (shortcut != '\b') {
            if (shortcut != '\n') {
                if (shortcut != ' ') {
                    sb.append(shortcut);
                }
                else {
                    sb.append(MenuItemImpl.sSpaceShortcutLabel);
                }
            }
            else {
                sb.append(MenuItemImpl.sEnterShortcutLabel);
            }
        }
        else {
            sb.append(MenuItemImpl.sDeleteShortcutLabel);
        }
        return sb.toString();
    }
    
    public SubMenu getSubMenu() {
        return (SubMenu)this.mSubMenu;
    }
    
    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            charSequence = this.mTitle;
        }
        if (Build$VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            return charSequence.toString();
        }
        return charSequence;
    }
    
    CharSequence getTitleForItemView(final MenuView$ItemView menuView$ItemView) {
        CharSequence charSequence;
        if (menuView$ItemView != null && menuView$ItemView.prefersCondensedTitle()) {
            charSequence = this.getTitleCondensed();
        }
        else {
            charSequence = this.getTitle();
        }
        return charSequence;
    }
    
    public boolean hasCollapsibleActionView() {
        final int n = this.mShowAsAction & 0x8;
        boolean b = false;
        if (n != 0) {
            if (this.mActionView == null) {
                final ActionProvider mActionProvider = this.mActionProvider;
                if (mActionProvider != null) {
                    this.mActionView = mActionProvider.onCreateActionView((MenuItem)this);
                }
            }
            if (this.mActionView != null) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    public boolean hasSubMenu() {
        return this.mSubMenu != null;
    }
    
    public boolean invoke() {
        final MenuItem$OnMenuItemClickListener mClickListener = this.mClickListener;
        final boolean b = true;
        if (mClickListener != null && mClickListener.onMenuItemClick((MenuItem)this)) {
            return b;
        }
        final MenuBuilder mMenu = this.mMenu;
        if (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), (MenuItem)this)) {
            return b;
        }
        final Runnable mItemCallback = this.mItemCallback;
        if (mItemCallback != null) {
            mItemCallback.run();
            return b;
        }
        if (this.mIntent != null) {
            try {
                final MenuBuilder mMenu2 = this.mMenu;
                try {
                    final Context context = mMenu2.getContext();
                    try {
                        context.startActivity(this.mIntent);
                        return b;
                    }
                    catch (ActivityNotFoundException ex) {
                        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)ex);
                    }
                }
                catch (ActivityNotFoundException ex2) {}
            }
            catch (ActivityNotFoundException ex3) {}
        }
        final ActionProvider mActionProvider = this.mActionProvider;
        return mActionProvider != null && mActionProvider.onPerformDefaultAction() && b;
    }
    
    public boolean isActionButton() {
        final int mFlags = this.mFlags;
        final int n = 32;
        return (mFlags & n) == n;
    }
    
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }
    
    public boolean isCheckable() {
        final int mFlags = this.mFlags;
        boolean b = true;
        if ((mFlags & (b ? 1 : 0)) != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    public boolean isChecked() {
        final int mFlags = this.mFlags;
        final int n = 2;
        return (mFlags & n) == n;
    }
    
    public boolean isEnabled() {
        return (this.mFlags & 0x10) != 0x0;
    }
    
    public boolean isExclusiveCheckable() {
        return (this.mFlags & 0x4) != 0x0;
    }
    
    public boolean isVisible() {
        final ActionProvider mActionProvider = this.mActionProvider;
        boolean b = true;
        if (mActionProvider != null && mActionProvider.overridesItemVisibility()) {
            if ((this.mFlags & 0x8) != 0x0 || !this.mActionProvider.isVisible()) {
                b = false;
            }
            return b;
        }
        if ((this.mFlags & 0x8) != 0x0) {
            b = false;
        }
        return b;
    }
    
    public boolean requestsActionButton() {
        final int mShowAsAction = this.mShowAsAction;
        boolean b = true;
        if ((mShowAsAction & (b ? 1 : 0)) != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    public boolean requiresActionButton() {
        final int mShowAsAction = this.mShowAsAction;
        final int n = 2;
        return (mShowAsAction & n) == n;
    }
    
    public MenuItem setActionProvider(final android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }
    
    public SupportMenuItem setActionView(final int n) {
        final Context context = this.mMenu.getContext();
        this.setActionView(LayoutInflater.from(context).inflate(n, (ViewGroup)new LinearLayout(context), false));
        return this;
    }
    
    public SupportMenuItem setActionView(final View mActionView) {
        this.mActionView = mActionView;
        this.mActionProvider = null;
        if (mActionView != null && mActionView.getId() == -1) {
            final int mId = this.mId;
            if (mId > 0) {
                mActionView.setId(mId);
            }
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }
    
    public void setActionViewExpanded(final boolean mIsActionViewExpanded) {
        this.mIsActionViewExpanded = mIsActionViewExpanded;
        this.mMenu.onItemsChanged(false);
    }
    
    public MenuItem setAlphabeticShortcut(final char c) {
        if (this.mShortcutAlphabeticChar == c) {
            return (MenuItem)this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setCallback(final Runnable mItemCallback) {
        this.mItemCallback = mItemCallback;
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean b) {
        final int mFlags = this.mFlags;
        this.mFlags = ((this.mFlags & 0xFFFFFFFE) | (b ? 1 : 0));
        if (mFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean checkedInt) {
        if ((this.mFlags & 0x4) != 0x0) {
            this.mMenu.setExclusiveItemChecked((MenuItem)this);
        }
        else {
            this.setCheckedInt(checkedInt);
        }
        return (MenuItem)this;
    }
    
    void setCheckedInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = this.mFlags & 0xFFFFFFFD;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n | n2);
        if (mFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }
    
    public MenuItem setEnabled(final boolean b) {
        if (b) {
            this.mFlags |= 0x10;
        }
        else {
            this.mFlags &= 0xFFFFFFEF;
        }
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public void setExclusiveCheckable(final boolean b) {
        final int n = this.mFlags & 0xFFFFFFFB;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n | n2);
    }
    
    public MenuItem setIcon(final int mIconResId) {
        this.mIconDrawable = null;
        this.mIconResId = mIconResId;
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable mIconDrawable) {
        this.mIconResId = 0;
        this.mIconDrawable = mIconDrawable;
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent mIntent) {
        this.mIntent = mIntent;
        return (MenuItem)this;
    }
    
    public void setIsActionButton(final boolean b) {
        if (b) {
            this.mFlags |= 0x20;
        }
        else {
            this.mFlags &= 0xFFFFFFDF;
        }
    }
    
    void setMenuInfo(final ContextMenu$ContextMenuInfo mMenuInfo) {
        this.mMenuInfo = mMenuInfo;
    }
    
    public MenuItem setNumericShortcut(final char mShortcutNumericChar) {
        if (this.mShortcutNumericChar == mShortcutNumericChar) {
            return (MenuItem)this;
        }
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char mShortcutNumericChar, final char c) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public void setShowAsAction(final int mShowAsAction) {
        switch (mShowAsAction & 0x3) {
            default: {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
            case 0:
            case 1:
            case 2: {
                this.mShowAsAction = mShowAsAction;
                this.mMenu.onItemActionRequestChanged(this);
            }
        }
    }
    
    public SupportMenuItem setShowAsActionFlags(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    public void setSubMenu(final SubMenuBuilder mSubMenu) {
        (this.mSubMenu = mSubMenu).setHeaderTitle(this.getTitle());
    }
    
    public SupportMenuItem setSupportActionProvider(final ActionProvider mActionProvider) {
        final ActionProvider mActionProvider2 = this.mActionProvider;
        if (mActionProvider2 != null) {
            mActionProvider2.reset();
        }
        this.mActionView = null;
        this.mActionProvider = mActionProvider;
        this.mMenu.onItemsChanged(true);
        final ActionProvider mActionProvider3 = this.mActionProvider;
        if (mActionProvider3 != null) {
            mActionProvider3.setVisibilityListener(new MenuItemImpl$1(this));
        }
        return this;
    }
    
    public SupportMenuItem setSupportOnActionExpandListener(final MenuItemCompat$OnActionExpandListener mOnActionExpandListener) {
        this.mOnActionExpandListener = mOnActionExpandListener;
        return this;
    }
    
    public MenuItem setTitle(final int n) {
        return this.setTitle(this.mMenu.getContext().getString(n));
    }
    
    public MenuItem setTitle(final CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        final SubMenuBuilder mSubMenu = this.mSubMenu;
        if (mSubMenu != null) {
            mSubMenu.setHeaderTitle(charSequence);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(CharSequence mTitle) {
        this.mTitleCondensed = mTitle;
        if (mTitle == null) {
            mTitle = this.mTitle;
        }
        this.mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setVisible(final boolean visibleInt) {
        if (this.setVisibleInt(visibleInt)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return (MenuItem)this;
    }
    
    boolean setVisibleInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = this.mFlags & 0xFFFFFFF7;
        boolean b2 = false;
        int n2;
        if (b) {
            n2 = 0;
        }
        else {
            n2 = 8;
        }
        this.mFlags = (n | n2);
        if (mFlags != this.mFlags) {
            b2 = true;
        }
        return b2;
    }
    
    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }
    
    boolean shouldShowShortcut() {
        return this.mMenu.isShortcutsVisible() && this.getShortcut() != '\0';
    }
    
    public boolean showsTextAsAction() {
        final int mShowAsAction = this.mShowAsAction;
        final int n = 4;
        return (mShowAsAction & n) == n;
    }
    
    public String toString() {
        final CharSequence mTitle = this.mTitle;
        String string;
        if (mTitle != null) {
            string = mTitle.toString();
        }
        else {
            string = null;
        }
        return string;
    }
}
