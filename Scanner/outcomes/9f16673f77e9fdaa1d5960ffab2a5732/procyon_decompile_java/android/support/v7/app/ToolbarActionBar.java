// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.content.res.Resources$Theme;
import android.content.Context;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.appcompat.R$layout;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$style;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Window$Callback;
import java.util.ArrayList;
import android.support.v7.widget.Toolbar$OnMenuItemClickListener;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.widget.DecorToolbar;

class ToolbarActionBar extends ActionBar
{
    DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private ListMenuPresenter mListMenuPresenter;
    private boolean mMenuCallbackSet;
    private final Toolbar$OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList mMenuVisibilityListeners;
    boolean mToolbarMenuPrepared;
    Window$Callback mWindowCallback;
    
    ToolbarActionBar(final Toolbar toolbar, final CharSequence windowTitle, final Window$Callback window$Callback) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new ToolbarActionBar$1(this);
        this.mMenuClicker = new ToolbarActionBar$2(this);
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = (Window$Callback)new ToolbarActionBar$ToolbarCallbackWrapper(this, window$Callback);
        this.mDecorToolbar.setWindowCallback(this.mWindowCallback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    private void ensureListMenuPresenter(final Menu menu) {
        if (this.mListMenuPresenter == null && menu instanceof MenuBuilder) {
            final MenuBuilder menuBuilder = (MenuBuilder)menu;
            final Context context = this.mDecorToolbar.getContext();
            final TypedValue typedValue = new TypedValue();
            final Resources$Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
            final int actionBarPopupTheme = R$attr.actionBarPopupTheme;
            final boolean b = true;
            theme.resolveAttribute(actionBarPopupTheme, typedValue, b);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, b);
            }
            theme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, b);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, b);
            }
            else {
                theme.applyStyle(R$style.Theme_AppCompat_CompactMenu, b);
            }
            final Context context2;
            (context2 = (Context)new ContextThemeWrapper(context, 0)).getTheme().setTo(theme);
            (this.mListMenuPresenter = new ListMenuPresenter(context2, R$layout.abc_list_menu_item_layout)).setCallback(new ToolbarActionBar$PanelMenuPresenterCallback(this));
            menuBuilder.addMenuPresenter(this.mListMenuPresenter);
        }
    }
    
    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mDecorToolbar.setMenuCallbacks(new ToolbarActionBar$ActionMenuPresenterCallback(this), new ToolbarActionBar$MenuBuilderCallback(this));
            this.mMenuCallbackSet = true;
        }
        return this.mDecorToolbar.getMenu();
    }
    
    public void addOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(actionBar$OnMenuVisibilityListener);
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public boolean collapseActionView() {
        if (this.mDecorToolbar.hasExpandedActionView()) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }
    
    public void dispatchMenuVisibilityChanged(final boolean mLastMenuVisibility) {
        if (mLastMenuVisibility == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = mLastMenuVisibility;
        for (int size = this.mMenuVisibilityListeners.size(), i = 0; i < size; ++i) {
            ((ActionBar$OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(mLastMenuVisibility);
        }
    }
    
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }
    
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }
    
    public float getElevation() {
        return ViewCompat.getElevation((View)this.mDecorToolbar.getViewGroup());
    }
    
    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }
    
    View getListMenuView(final Menu menu) {
        this.ensureListMenuPresenter(menu);
        if (menu != null) {
            final ListMenuPresenter mListMenuPresenter = this.mListMenuPresenter;
            if (mListMenuPresenter != null) {
                if (mListMenuPresenter.getAdapter().getCount() > 0) {
                    return (View)this.mListMenuPresenter.getMenuView(this.mDecorToolbar.getViewGroup());
                }
                return null;
            }
        }
        return null;
    }
    
    public int getNavigationItemCount() {
        return 0;
    }
    
    public int getNavigationMode() {
        return 0;
    }
    
    public int getSelectedNavigationIndex() {
        return -1;
    }
    
    public ActionBar$Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }
    
    public ActionBar$Tab getTabAt(final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public int getTabCount() {
        return 0;
    }
    
    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }
    
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }
    
    public Window$Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }
    
    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }
    
    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation((View)this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }
    
    public boolean isShowing() {
        return this.mDecorToolbar.getVisibility() == 0;
    }
    
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }
    
    public ActionBar$Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
    
    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }
    
    public boolean onKeyShortcut(final int n, final KeyEvent keyEvent) {
        final Menu menu = this.getMenu();
        final boolean b = true;
        if (menu != null) {
            int deviceId;
            if (keyEvent != null) {
                deviceId = keyEvent.getDeviceId();
            }
            else {
                deviceId = -1;
            }
            menu.setQwertyMode(KeyCharacterMap.load(deviceId).getKeyboardType() != (b ? 1 : 0));
            menu.performShortcut(n, keyEvent, 0);
        }
        return b;
    }
    
    public boolean onMenuKeyEvent(final KeyEvent keyEvent) {
        final int action = keyEvent.getAction();
        final boolean b = true;
        if (action == (b ? 1 : 0)) {
            this.openOptionsMenu();
        }
        return b;
    }
    
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }
    
    void populateOptionsMenu() {
        final Menu menu = this.getMenu();
        MenuBuilder menuBuilder;
        if (menu instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder)menu;
        }
        else {
            menuBuilder = null;
        }
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.mWindowCallback.onCreatePanelMenu(0, menu) || !this.mWindowCallback.onPreparePanel(0, (View)null, menu)) {
                menu.clear();
            }
        }
        finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }
    
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void removeOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(actionBar$OnMenuVisibilityListener);
    }
    
    public void removeTab(final ActionBar$Tab actionBar$Tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void removeTabAt(final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public boolean requestFocus() {
        final ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup != null && !viewGroup.hasFocus()) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }
    
    public void selectTab(final ActionBar$Tab actionBar$Tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        this.mDecorToolbar.setBackgroundDrawable(backgroundDrawable);
    }
    
    public void setCustomView(final int n) {
        this.setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(n, this.mDecorToolbar.getViewGroup(), false));
    }
    
    public void setCustomView(final View view) {
        final int n = -2;
        this.setCustomView(view, new ActionBar$LayoutParams(n, n));
    }
    
    public void setCustomView(final View customView, final ActionBar$LayoutParams layoutParams) {
        if (customView != null) {
            customView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
        this.mDecorToolbar.setCustomView(customView);
    }
    
    public void setDefaultDisplayHomeAsUpEnabled(final boolean b) {
    }
    
    public void setDisplayHomeAsUpEnabled(final boolean b) {
        final int n = 4;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        this.setDisplayOptions(n2, n);
    }
    
    public void setDisplayOptions(final int n) {
        this.setDisplayOptions(n, -1);
    }
    
    public void setDisplayOptions(final int n, final int n2) {
        this.mDecorToolbar.setDisplayOptions((n & n2) | (~n2 & this.mDecorToolbar.getDisplayOptions()));
    }
    
    public void setDisplayShowCustomEnabled(final boolean b) {
        final int n = 16;
        int n2;
        if (b) {
            n2 = 16;
        }
        else {
            n2 = 0;
        }
        this.setDisplayOptions(n2, n);
    }
    
    public void setDisplayShowHomeEnabled(final boolean b) {
        final int n = 2;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.setDisplayOptions(n2, n);
    }
    
    public void setDisplayShowTitleEnabled(final boolean b) {
        final int n = 8;
        int n2;
        if (b) {
            n2 = 8;
        }
        else {
            n2 = 0;
        }
        this.setDisplayOptions(n2, n);
    }
    
    public void setDisplayUseLogoEnabled(final boolean b) {
        this.setDisplayOptions(b ? 1 : 0, 1);
    }
    
    public void setElevation(final float n) {
        ViewCompat.setElevation((View)this.mDecorToolbar.getViewGroup(), n);
    }
    
    public void setHomeActionContentDescription(final int navigationContentDescription) {
        this.mDecorToolbar.setNavigationContentDescription(navigationContentDescription);
    }
    
    public void setHomeActionContentDescription(final CharSequence navigationContentDescription) {
        this.mDecorToolbar.setNavigationContentDescription(navigationContentDescription);
    }
    
    public void setHomeAsUpIndicator(final int navigationIcon) {
        this.mDecorToolbar.setNavigationIcon(navigationIcon);
    }
    
    public void setHomeAsUpIndicator(final Drawable navigationIcon) {
        this.mDecorToolbar.setNavigationIcon(navigationIcon);
    }
    
    public void setHomeButtonEnabled(final boolean b) {
    }
    
    public void setIcon(final int icon) {
        this.mDecorToolbar.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        this.mDecorToolbar.setIcon(icon);
    }
    
    public void setListNavigationCallbacks(final SpinnerAdapter spinnerAdapter, final ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, (AdapterView$OnItemSelectedListener)new NavItemSelectedListener(actionBar$OnNavigationListener));
    }
    
    public void setLogo(final int logo) {
        this.mDecorToolbar.setLogo(logo);
    }
    
    public void setLogo(final Drawable logo) {
        this.mDecorToolbar.setLogo(logo);
    }
    
    public void setNavigationMode(final int navigationMode) {
        if (navigationMode != 2) {
            this.mDecorToolbar.setNavigationMode(navigationMode);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }
    
    public void setSelectedNavigationItem(final int dropdownSelectedPosition) {
        if (this.mDecorToolbar.getNavigationMode() == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(dropdownSelectedPosition);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }
    
    public void setShowHideAnimationEnabled(final boolean b) {
    }
    
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    public void setStackedBackgroundDrawable(final Drawable drawable) {
    }
    
    public void setSubtitle(final int n) {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        CharSequence text;
        if (n != 0) {
            text = mDecorToolbar.getContext().getText(n);
        }
        else {
            text = null;
        }
        mDecorToolbar.setSubtitle(text);
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        this.mDecorToolbar.setSubtitle(subtitle);
    }
    
    public void setTitle(final int n) {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        CharSequence text;
        if (n != 0) {
            text = mDecorToolbar.getContext().getText(n);
        }
        else {
            text = null;
        }
        mDecorToolbar.setTitle(text);
    }
    
    public void setTitle(final CharSequence title) {
        this.mDecorToolbar.setTitle(title);
    }
    
    public void setWindowTitle(final CharSequence windowTitle) {
        this.mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}
