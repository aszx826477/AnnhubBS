// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.appcompat.R$id;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.content.res.AppCompatResources;
import android.view.ViewParent;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.util.Log;
import android.view.Menu;
import android.content.Context;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.ViewGroup$LayoutParams;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$drawable;
import android.support.v7.appcompat.R$string;
import android.view.Window$Callback;
import android.widget.Spinner;
import android.graphics.drawable.Drawable;
import android.view.View;

public class ToolbarWidgetWrapper implements DecorToolbar
{
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200L;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window$Callback mWindowCallback;
    
    public ToolbarWidgetWrapper(final Toolbar toolbar, final boolean b) {
        this(toolbar, b, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }
    
    public ToolbarWidgetWrapper(final Toolbar mToolbar, final boolean b, final int defaultNavigationContentDescription, final int n) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = mToolbar;
        this.mTitle = mToolbar.getTitle();
        this.mSubtitle = mToolbar.getSubtitle();
        this.mTitleSet = (this.mTitle != null);
        this.mNavIcon = mToolbar.getNavigationIcon();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(mToolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_homeAsUpIndicator);
        if (b) {
            final CharSequence text = obtainStyledAttributes.getText(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.setTitle(text);
            }
            final CharSequence text2 = obtainStyledAttributes.getText(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.setSubtitle(text2);
            }
            final Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_logo);
            if (drawable != null) {
                this.setLogo(drawable);
            }
            final Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_icon);
            if (drawable2 != null) {
                this.setIcon(drawable2);
            }
            if (this.mNavIcon == null) {
                final Drawable mDefaultNavigationIcon = this.mDefaultNavigationIcon;
                if (mDefaultNavigationIcon != null) {
                    this.setNavigationIcon(mDefaultNavigationIcon);
                }
            }
            this.setDisplayOptions(obtainStyledAttributes.getInt(R$styleable.ActionBar_displayOptions, 0));
            final int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                this.setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, (ViewGroup)this.mToolbar, false));
                this.setDisplayOptions(this.mDisplayOpts | 0x10);
            }
            final int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                final ViewGroup$LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            final int actionBar_contentInsetStart = R$styleable.ActionBar_contentInsetStart;
            final int n2 = -1;
            final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(actionBar_contentInsetStart, n2);
            final int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetEnd, n2);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            final int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                final Toolbar mToolbar2 = this.mToolbar;
                mToolbar2.setTitleTextAppearance(mToolbar2.getContext(), resourceId2);
            }
            final int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                final Toolbar mToolbar3 = this.mToolbar;
                mToolbar3.setSubtitleTextAppearance(mToolbar3.getContext(), resourceId3);
            }
            final int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        }
        else {
            this.mDisplayOpts = this.detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        this.setDefaultNavigationContentDescription(defaultNavigationContentDescription);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener((View$OnClickListener)new ToolbarWidgetWrapper$1(this));
    }
    
    private int detectDisplayOptions() {
        int n = 11;
        if (this.mToolbar.getNavigationIcon() != null) {
            n |= 0x4;
            this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        }
        return n;
    }
    
    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(this.getContext(), null, R$attr.actionDropDownStyle);
            final int n = 8388627;
            final int n2 = -2;
            this.mSpinner.setLayoutParams((ViewGroup$LayoutParams)new Toolbar$LayoutParams(n2, n2, n));
        }
    }
    
    private void setTitleInt(final CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 0x8) != 0x0) {
            this.mToolbar.setTitle(charSequence);
        }
    }
    
    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 0x4) != 0x0) {
            if (TextUtils.isEmpty(this.mHomeDescription)) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
            else {
                this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
            }
        }
    }
    
    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 0x4) != 0x0) {
            final Toolbar mToolbar = this.mToolbar;
            Drawable navigationIcon = this.mNavIcon;
            if (navigationIcon == null) {
                navigationIcon = this.mDefaultNavigationIcon;
            }
            mToolbar.setNavigationIcon(navigationIcon);
        }
        else {
            this.mToolbar.setNavigationIcon(null);
        }
    }
    
    private void updateToolbarLogo() {
        Drawable mIcon = null;
        final int mDisplayOpts = this.mDisplayOpts;
        if ((mDisplayOpts & 0x2) != 0x0) {
            if ((mDisplayOpts & 0x1) != 0x0) {
                Drawable drawable = this.mLogo;
                if (drawable == null) {
                    drawable = this.mIcon;
                }
                mIcon = drawable;
            }
            else {
                mIcon = this.mIcon;
            }
        }
        this.mToolbar.setLogo(mIcon);
    }
    
    public void animateToVisibility(final int n) {
        final ViewPropertyAnimatorCompat setupAnimatorToVisibility = this.setupAnimatorToVisibility(n, 200L);
        if (setupAnimatorToVisibility != null) {
            setupAnimatorToVisibility.start();
        }
    }
    
    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }
    
    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }
    
    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }
    
    public Context getContext() {
        return this.mToolbar.getContext();
    }
    
    public View getCustomView() {
        return this.mCustomView;
    }
    
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }
    
    public int getDropdownItemCount() {
        final Spinner mSpinner = this.mSpinner;
        int count;
        if (mSpinner != null) {
            count = mSpinner.getCount();
        }
        else {
            count = 0;
        }
        return count;
    }
    
    public int getDropdownSelectedPosition() {
        final Spinner mSpinner = this.mSpinner;
        int selectedItemPosition;
        if (mSpinner != null) {
            selectedItemPosition = mSpinner.getSelectedItemPosition();
        }
        else {
            selectedItemPosition = 0;
        }
        return selectedItemPosition;
    }
    
    public int getHeight() {
        return this.mToolbar.getHeight();
    }
    
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }
    
    public int getNavigationMode() {
        return this.mNavigationMode;
    }
    
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }
    
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }
    
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }
    
    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }
    
    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }
    
    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }
    
    public boolean hasIcon() {
        return this.mIcon != null;
    }
    
    public boolean hasLogo() {
        return this.mLogo != null;
    }
    
    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }
    
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }
    
    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }
    
    public void restoreHierarchyState(final SparseArray sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }
    
    public void saveHierarchyState(final SparseArray sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }
    
    public void setBackgroundDrawable(final Drawable drawable) {
        ViewCompat.setBackground((View)this.mToolbar, drawable);
    }
    
    public void setCollapsible(final boolean collapsible) {
        this.mToolbar.setCollapsible(collapsible);
    }
    
    public void setCustomView(final View mCustomView) {
        final View mCustomView2 = this.mCustomView;
        if (mCustomView2 != null && (this.mDisplayOpts & 0x10) != 0x0) {
            this.mToolbar.removeView(mCustomView2);
        }
        if ((this.mCustomView = mCustomView) != null && (this.mDisplayOpts & 0x10) != 0x0) {
            this.mToolbar.addView(this.mCustomView);
        }
    }
    
    public void setDefaultNavigationContentDescription(final int mDefaultNavigationContentDescription) {
        if (mDefaultNavigationContentDescription == this.mDefaultNavigationContentDescription) {
            return;
        }
        this.mDefaultNavigationContentDescription = mDefaultNavigationContentDescription;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
            this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        }
    }
    
    public void setDefaultNavigationIcon(final Drawable mDefaultNavigationIcon) {
        if (this.mDefaultNavigationIcon != mDefaultNavigationIcon) {
            this.mDefaultNavigationIcon = mDefaultNavigationIcon;
            this.updateNavigationIcon();
        }
    }
    
    public void setDisplayOptions(final int mDisplayOpts) {
        final int n = this.mDisplayOpts ^ mDisplayOpts;
        this.mDisplayOpts = mDisplayOpts;
        if (n != 0) {
            if ((n & 0x4) != 0x0) {
                if ((mDisplayOpts & 0x4) != 0x0) {
                    this.updateHomeAccessibility();
                }
                this.updateNavigationIcon();
            }
            if ((n & 0x3) != 0x0) {
                this.updateToolbarLogo();
            }
            if ((n & 0x8) != 0x0) {
                if ((mDisplayOpts & 0x8) != 0x0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                }
                else {
                    this.mToolbar.setTitle(null);
                    this.mToolbar.setSubtitle(null);
                }
            }
            if ((n & 0x10) != 0x0) {
                final View mCustomView = this.mCustomView;
                if (mCustomView != null) {
                    if ((mDisplayOpts & 0x10) != 0x0) {
                        this.mToolbar.addView(mCustomView);
                    }
                    else {
                        this.mToolbar.removeView(mCustomView);
                    }
                }
            }
        }
    }
    
    public void setDropdownParams(final SpinnerAdapter adapter, final AdapterView$OnItemSelectedListener onItemSelectedListener) {
        this.ensureSpinner();
        this.mSpinner.setAdapter(adapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }
    
    public void setDropdownSelectedPosition(final int selection) {
        final Spinner mSpinner = this.mSpinner;
        if (mSpinner != null) {
            mSpinner.setSelection(selection);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }
    
    public void setEmbeddedTabView(final ScrollingTabContainerView mTabView) {
        final View mTabView2 = this.mTabView;
        if (mTabView2 != null) {
            final ViewParent parent = mTabView2.getParent();
            final Toolbar mToolbar = this.mToolbar;
            if (parent == mToolbar) {
                mToolbar.removeView(this.mTabView);
            }
        }
        if ((this.mTabView = (View)mTabView) != null && this.mNavigationMode == 2) {
            this.mToolbar.addView(this.mTabView, 0);
            final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mTabView.getLayoutParams();
            final int n = -2;
            toolbar$LayoutParams.width = n;
            toolbar$LayoutParams.height = n;
            toolbar$LayoutParams.gravity = 8388691;
            mTabView.setAllowCollapse(true);
        }
    }
    
    public void setHomeButtonEnabled(final boolean b) {
    }
    
    public void setIcon(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = AppCompatResources.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setIcon(drawable);
    }
    
    public void setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        this.updateToolbarLogo();
    }
    
    public void setLogo(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = AppCompatResources.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setLogo(drawable);
    }
    
    public void setLogo(final Drawable mLogo) {
        this.mLogo = mLogo;
        this.updateToolbarLogo();
    }
    
    public void setMenu(final Menu menu, final MenuPresenter$Callback callback) {
        if (this.mActionMenuPresenter == null) {
            (this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext())).setId(R$id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mToolbar.setMenu((MenuBuilder)menu, this.mActionMenuPresenter);
    }
    
    public void setMenuCallbacks(final MenuPresenter$Callback menuPresenter$Callback, final MenuBuilder$Callback menuBuilder$Callback) {
        this.mToolbar.setMenuCallbacks(menuPresenter$Callback, menuBuilder$Callback);
    }
    
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }
    
    public void setNavigationContentDescription(final int n) {
        CharSequence string;
        if (n == 0) {
            string = null;
        }
        else {
            string = this.getContext().getString(n);
        }
        this.setNavigationContentDescription(string);
    }
    
    public void setNavigationContentDescription(final CharSequence mHomeDescription) {
        this.mHomeDescription = mHomeDescription;
        this.updateHomeAccessibility();
    }
    
    public void setNavigationIcon(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = AppCompatResources.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setNavigationIcon(drawable);
    }
    
    public void setNavigationIcon(final Drawable mNavIcon) {
        this.mNavIcon = mNavIcon;
        this.updateNavigationIcon();
    }
    
    public void setNavigationMode(final int mNavigationMode) {
        final int mNavigationMode2 = this.mNavigationMode;
        if (mNavigationMode != mNavigationMode2) {
            switch (mNavigationMode2) {
                case 2: {
                    final View mTabView = this.mTabView;
                    if (mTabView != null) {
                        final ViewParent parent = mTabView.getParent();
                        final Toolbar mToolbar = this.mToolbar;
                        if (parent == mToolbar) {
                            mToolbar.removeView(this.mTabView);
                        }
                    }
                    break;
                }
                case 1: {
                    final Spinner mSpinner = this.mSpinner;
                    if (mSpinner == null) {
                        break;
                    }
                    final ViewParent parent2 = mSpinner.getParent();
                    final Toolbar mToolbar2 = this.mToolbar;
                    if (parent2 == mToolbar2) {
                        mToolbar2.removeView((View)this.mSpinner);
                        break;
                    }
                    break;
                }
            }
            switch (this.mNavigationMode = mNavigationMode) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid navigation mode ");
                    sb.append(mNavigationMode);
                    throw new IllegalArgumentException(sb.toString());
                }
                case 2: {
                    final View mTabView2 = this.mTabView;
                    if (mTabView2 != null) {
                        this.mToolbar.addView(mTabView2, 0);
                        final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mTabView.getLayoutParams();
                        final int n = -2;
                        toolbar$LayoutParams.width = n;
                        toolbar$LayoutParams.height = n;
                        toolbar$LayoutParams.gravity = 8388691;
                        break;
                    }
                    break;
                }
                case 1: {
                    this.ensureSpinner();
                    this.mToolbar.addView((View)this.mSpinner, 0);
                    break;
                }
                case 0: {
                    break;
                }
            }
        }
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 0x8) != 0x0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }
    
    public void setTitle(final CharSequence titleInt) {
        this.mTitleSet = true;
        this.setTitleInt(titleInt);
    }
    
    public void setVisibility(final int visibility) {
        this.mToolbar.setVisibility(visibility);
    }
    
    public void setWindowCallback(final Window$Callback mWindowCallback) {
        this.mWindowCallback = mWindowCallback;
    }
    
    public void setWindowTitle(final CharSequence titleInt) {
        if (!this.mTitleSet) {
            this.setTitleInt(titleInt);
        }
    }
    
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int n, final long duration) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate((View)this.mToolbar);
        float n2;
        if (n == 0) {
            n2 = 1.0f;
        }
        else {
            n2 = 0.0f;
        }
        return animate.alpha(n2).setDuration(duration).setListener(new ToolbarWidgetWrapper$2(this, n));
    }
    
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}
