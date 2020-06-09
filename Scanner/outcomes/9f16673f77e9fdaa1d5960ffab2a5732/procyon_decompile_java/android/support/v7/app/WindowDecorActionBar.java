// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.View$MeasureSpec;
import android.support.v7.widget.ViewUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View$OnClickListener;
import android.support.v7.widget.ActionBarContextView$1;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.TextUtils;
import android.support.v7.appcompat.R$layout;
import android.support.v7.widget.TintTypedArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.AbsActionBarView;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.appcompat.R$id;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewCompat;
import android.os.Build$VERSION;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.ActionBarOverlayLayout;
import java.util.ArrayList;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.app.Dialog;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionBarContextView;
import android.content.Context;
import android.view.View;
import android.support.v7.widget.ActionBarContainer;
import android.app.Activity;
import android.view.animation.Interpolator;
import android.support.v7.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback;

public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout$ActionBarVisibilityCallback
{
    private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS = false;
    private static final long FADE_IN_DURATION_MS = 200L;
    private static final long FADE_OUT_DURATION_MS = 100L;
    private static final int INVALID_POSITION = 255;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator;
    private static final Interpolator sShowInterpolator;
    WindowDecorActionBar$ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode$Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private boolean mNowShowing;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private WindowDecorActionBar$TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList mTabs;
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener;
    
    static {
        sHideInterpolator = (Interpolator)new AccelerateInterpolator();
        sShowInterpolator = (Interpolator)new DecelerateInterpolator();
    }
    
    public WindowDecorActionBar(final Activity mActivity, final boolean b) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        final boolean b2 = true;
        this.mContentAnimations = b2;
        this.mNowShowing = b2;
        this.mHideListener = new WindowDecorActionBar$1(this);
        this.mShowListener = new WindowDecorActionBar$2(this);
        this.mUpdateListener = new WindowDecorActionBar$3(this);
        this.mActivity = mActivity;
        final View decorView = mActivity.getWindow().getDecorView();
        this.init(decorView);
        if (!b) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }
    
    public WindowDecorActionBar(final Dialog mDialog) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        final boolean b = true;
        this.mContentAnimations = b;
        this.mNowShowing = b;
        this.mHideListener = new WindowDecorActionBar$1(this);
        this.mShowListener = new WindowDecorActionBar$2(this);
        this.mUpdateListener = new WindowDecorActionBar$3(this);
        this.mDialog = mDialog;
        this.init(mDialog.getWindow().getDecorView());
    }
    
    public WindowDecorActionBar(final View view) {
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        final boolean b = true;
        this.mContentAnimations = b;
        this.mNowShowing = b;
        this.mHideListener = new WindowDecorActionBar$1(this);
        this.mShowListener = new WindowDecorActionBar$2(this);
        this.mUpdateListener = new WindowDecorActionBar$3(this);
        this.init(view);
    }
    
    static boolean checkShowingFlags(final boolean b, final boolean b2, final boolean b3) {
        final boolean b4 = true;
        if (b3) {
            return b4;
        }
        return !b && !b2 && b4;
    }
    
    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            this.selectTab(null);
        }
        this.mTabs.clear();
        final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
        if (mTabScrollView != null) {
            mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }
    
    private void configureTab(final ActionBar$Tab actionBar$Tab, final int position) {
        final WindowDecorActionBar$TabImpl windowDecorActionBar$TabImpl = (WindowDecorActionBar$TabImpl)actionBar$Tab;
        if (windowDecorActionBar$TabImpl.getCallback() != null) {
            windowDecorActionBar$TabImpl.setPosition(position);
            this.mTabs.add(position, windowDecorActionBar$TabImpl);
            for (int size = this.mTabs.size(), i = position + 1; i < size; ++i) {
                ((WindowDecorActionBar$TabImpl)this.mTabs.get(i)).setPosition(i);
            }
            return;
        }
        throw new IllegalStateException("Action Bar Tab must have a Callback");
    }
    
    private void ensureTabsExist() {
        if (this.mTabScrollView != null) {
            return;
        }
        final ScrollingTabContainerView mTabScrollView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            mTabScrollView.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(mTabScrollView);
        }
        else {
            if (this.getNavigationMode() == 2) {
                mTabScrollView.setVisibility(0);
                final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
            else {
                mTabScrollView.setVisibility(8);
            }
            this.mContainerView.setTabContainer(mTabScrollView);
        }
        this.mTabScrollView = mTabScrollView;
    }
    
    private DecorToolbar getDecorToolbar(final View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        String simpleName;
        if (sb.toString() != null) {
            simpleName = view.getClass().getSimpleName();
        }
        else {
            simpleName = "null";
        }
        throw new IllegalStateException(simpleName);
    }
    
    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
            if (mOverlayLayout != null) {
                mOverlayLayout.setShowingForActionMode(false);
            }
            this.updateVisibility(false);
        }
    }
    
    private void init(final View view) {
        this.mOverlayLayout = (ActionBarOverlayLayout)view.findViewById(R$id.decor_content_parent);
        final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
        if (mOverlayLayout != null) {
            mOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.mDecorToolbar = this.getDecorToolbar(view.findViewById(R$id.action_bar));
        this.mContextView = (ActionBarContextView)view.findViewById(R$id.action_context_bar);
        this.mContainerView = (ActionBarContainer)view.findViewById(R$id.action_bar_container);
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        if (mDecorToolbar != null && this.mContextView != null && this.mContainerView != null) {
            this.mContext = mDecorToolbar.getContext();
            final int n = this.mDecorToolbar.getDisplayOptions() & 0x4;
            final boolean b = true;
            final boolean b2 = n != 0;
            if (b2) {
                this.mDisplayHomeAsUpSet = b;
            }
            final ActionBarPolicy value = ActionBarPolicy.get(this.mContext);
            this.setHomeButtonEnabled(value.enableHomeButtonByDefault() || b2);
            this.setHasEmbeddedTabs(value.hasEmbeddedTabs());
            final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet)null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
                this.setHideOnContentScrollEnabled(b);
            }
            final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                this.setElevation(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" can only be used ");
        sb.append("with a compatible window decor layout");
        throw new IllegalStateException(sb.toString());
    }
    
    private void setHasEmbeddedTabs(final boolean mHasEmbeddedTabs) {
        if (!(this.mHasEmbeddedTabs = mHasEmbeddedTabs)) {
            this.mDecorToolbar.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        else {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }
        final int navigationMode = this.getNavigationMode();
        final int n = 2;
        boolean hasNonEmbeddedTabs = true;
        final boolean b = navigationMode == n;
        final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
        if (mTabScrollView != null) {
            if (b) {
                mTabScrollView.setVisibility(0);
                final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
            else {
                mTabScrollView.setVisibility(8);
            }
        }
        this.mDecorToolbar.setCollapsible(!this.mHasEmbeddedTabs && b);
        final ActionBarOverlayLayout mOverlayLayout2 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !b) {
            hasNonEmbeddedTabs = false;
        }
        mOverlayLayout2.setHasNonEmbeddedTabs(hasNonEmbeddedTabs);
    }
    
    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut((View)this.mContainerView);
    }
    
    private void showForActionMode() {
        if (!this.mShowingForMode) {
            final boolean b = true;
            this.mShowingForMode = b;
            final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
            if (mOverlayLayout != null) {
                mOverlayLayout.setShowingForActionMode(b);
            }
            this.updateVisibility(false);
        }
    }
    
    private void updateVisibility(final boolean b) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                this.doShow(b);
            }
        }
        else if (this.mNowShowing) {
            this.mNowShowing = false;
            this.doHide(b);
        }
    }
    
    public void addOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(actionBar$OnMenuVisibilityListener);
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab) {
        this.addTab(actionBar$Tab, this.mTabs.isEmpty());
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n) {
        this.addTab(actionBar$Tab, n, this.mTabs.isEmpty());
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(actionBar$Tab, n, b);
        this.configureTab(actionBar$Tab, n);
        if (b) {
            this.selectTab(actionBar$Tab);
        }
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(actionBar$Tab, b);
        this.configureTab(actionBar$Tab, this.mTabs.size());
        if (b) {
            this.selectTab(actionBar$Tab);
        }
    }
    
    public void animateToMode(final boolean b) {
        if (b) {
            this.showForActionMode();
        }
        else {
            this.hideForActionMode();
        }
        final boolean shouldAnimateContextView = this.shouldAnimateContextView();
        final int visibility = 4;
        final int visibility2 = 8;
        if (shouldAnimateContextView) {
            final long n = 100;
            final long n2 = 200L;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
            if (b) {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(visibility, n);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(0, n2);
            }
            else {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(0, n2);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(visibility2, n);
            }
            final ViewPropertyAnimatorCompatSet set = new ViewPropertyAnimatorCompatSet();
            set.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            set.start();
        }
        else if (b) {
            this.mDecorToolbar.setVisibility(visibility);
            this.mContextView.setVisibility(0);
        }
        else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(visibility2);
        }
    }
    
    public boolean collapseActionView() {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        if (mDecorToolbar != null && mDecorToolbar.hasExpandedActionView()) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }
    
    void completeDeferredDestroyActionMode() {
        final ActionMode$Callback mDeferredModeDestroyCallback = this.mDeferredModeDestroyCallback;
        if (mDeferredModeDestroyCallback != null) {
            mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
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
    
    public void doHide(final boolean b) {
        final ViewPropertyAnimatorCompatSet mCurrentShowAnim = this.mCurrentShowAnim;
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
        }
        if (this.mCurWindowVisibility == 0 && WindowDecorActionBar.ALLOW_SHOW_HIDE_ANIMATIONS && (this.mShowHideAnimationEnabled || b)) {
            ViewCompat.setAlpha((View)this.mContainerView, 1.0f);
            final ActionBarContainer mContainerView = this.mContainerView;
            final int transitioning = 1;
            mContainerView.setTransitioning(transitioning != 0);
            final ViewPropertyAnimatorCompatSet mCurrentShowAnim2 = new ViewPropertyAnimatorCompatSet();
            float n = -this.mContainerView.getHeight();
            if (b) {
                final int[] array2;
                final int[] array = array2 = new int[2];
                array2[1] = (array2[0] = 0);
                this.mContainerView.getLocationInWindow(array);
                n -= array[transitioning];
            }
            final ViewPropertyAnimatorCompat translationY = ViewCompat.animate((View)this.mContainerView).translationY(n);
            translationY.setUpdateListener(this.mUpdateListener);
            mCurrentShowAnim2.play(translationY);
            if (this.mContentAnimations) {
                final View mContentView = this.mContentView;
                if (mContentView != null) {
                    mCurrentShowAnim2.play(ViewCompat.animate(mContentView).translationY(n));
                }
            }
            mCurrentShowAnim2.setInterpolator(WindowDecorActionBar.sHideInterpolator);
            mCurrentShowAnim2.setDuration(250L);
            mCurrentShowAnim2.setListener(this.mHideListener);
            (this.mCurrentShowAnim = mCurrentShowAnim2).start();
        }
        else {
            this.mHideListener.onAnimationEnd(null);
        }
    }
    
    public void doShow(final boolean b) {
        final ViewPropertyAnimatorCompatSet mCurrentShowAnim = this.mCurrentShowAnim;
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
        }
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0 && WindowDecorActionBar.ALLOW_SHOW_HIDE_ANIMATIONS && (this.mShowHideAnimationEnabled || b)) {
            ViewCompat.setTranslationY((View)this.mContainerView, 0.0f);
            float n = -this.mContainerView.getHeight();
            if (b) {
                final int[] array2;
                final int[] array = array2 = new int[2];
                array2[1] = (array2[0] = 0);
                this.mContainerView.getLocationInWindow(array);
                n -= array[1];
            }
            ViewCompat.setTranslationY((View)this.mContainerView, n);
            final ViewPropertyAnimatorCompatSet mCurrentShowAnim2 = new ViewPropertyAnimatorCompatSet();
            final ViewPropertyAnimatorCompat translationY = ViewCompat.animate((View)this.mContainerView).translationY(0.0f);
            translationY.setUpdateListener(this.mUpdateListener);
            mCurrentShowAnim2.play(translationY);
            if (this.mContentAnimations) {
                final View mContentView = this.mContentView;
                if (mContentView != null) {
                    ViewCompat.setTranslationY(mContentView, n);
                    mCurrentShowAnim2.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
                }
            }
            mCurrentShowAnim2.setInterpolator(WindowDecorActionBar.sShowInterpolator);
            mCurrentShowAnim2.setDuration(250L);
            mCurrentShowAnim2.setListener(this.mShowListener);
            (this.mCurrentShowAnim = mCurrentShowAnim2).start();
        }
        else {
            ViewCompat.setAlpha((View)this.mContainerView, 1.0f);
            ViewCompat.setTranslationY((View)this.mContainerView, 0.0f);
            if (this.mContentAnimations) {
                final View mContentView2 = this.mContentView;
                if (mContentView2 != null) {
                    ViewCompat.setTranslationY(mContentView2, 0.0f);
                }
            }
            this.mShowListener.onAnimationEnd(null);
        }
        final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
        if (mOverlayLayout != null) {
            ViewCompat.requestApplyInsets((View)mOverlayLayout);
        }
    }
    
    public void enableContentAnimations(final boolean mContentAnimations) {
        this.mContentAnimations = mContentAnimations;
    }
    
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }
    
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }
    
    public float getElevation() {
        return ViewCompat.getElevation((View)this.mContainerView);
    }
    
    public int getHeight() {
        return this.mContainerView.getHeight();
    }
    
    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }
    
    public int getNavigationItemCount() {
        switch (this.mDecorToolbar.getNavigationMode()) {
            default: {
                return 0;
            }
            case 2: {
                return this.mTabs.size();
            }
            case 1: {
                return this.mDecorToolbar.getDropdownItemCount();
            }
        }
    }
    
    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }
    
    public int getSelectedNavigationIndex() {
        final int navigationMode = this.mDecorToolbar.getNavigationMode();
        int position = -1;
        switch (navigationMode) {
            default: {
                return position;
            }
            case 2: {
                final WindowDecorActionBar$TabImpl mSelectedTab = this.mSelectedTab;
                if (mSelectedTab != null) {
                    position = mSelectedTab.getPosition();
                }
                return position;
            }
            case 1: {
                return this.mDecorToolbar.getDropdownSelectedPosition();
            }
        }
    }
    
    public ActionBar$Tab getSelectedTab() {
        return this.mSelectedTab;
    }
    
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }
    
    public ActionBar$Tab getTabAt(final int n) {
        return this.mTabs.get(n);
    }
    
    public int getTabCount() {
        return this.mTabs.size();
    }
    
    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            final TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            final int resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                this.mThemedContext = (Context)new ContextThemeWrapper(this.mContext, resourceId);
            }
            else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }
    
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }
    
    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }
    
    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }
    
    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            this.updateVisibility(false);
        }
    }
    
    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.updateVisibility(this.mHiddenBySystem = true);
        }
    }
    
    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }
    
    public boolean isShowing() {
        final int height = this.getHeight();
        return this.mNowShowing && (height == 0 || this.getHideOffset() < height);
    }
    
    public boolean isTitleTruncated() {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        return mDecorToolbar != null && mDecorToolbar.isTitleTruncated();
    }
    
    public ActionBar$Tab newTab() {
        return new WindowDecorActionBar$TabImpl(this);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }
    
    public void onContentScrollStarted() {
        final ViewPropertyAnimatorCompatSet mCurrentShowAnim = this.mCurrentShowAnim;
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
            this.mCurrentShowAnim = null;
        }
    }
    
    public void onContentScrollStopped() {
    }
    
    public void onWindowVisibilityChanged(final int mCurWindowVisibility) {
        this.mCurWindowVisibility = mCurWindowVisibility;
    }
    
    public void removeAllTabs() {
        this.cleanupTabs();
    }
    
    public void removeOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(actionBar$OnMenuVisibilityListener);
    }
    
    public void removeTab(final ActionBar$Tab actionBar$Tab) {
        this.removeTabAt(actionBar$Tab.getPosition());
    }
    
    public void removeTabAt(final int n) {
        if (this.mTabScrollView == null) {
            return;
        }
        final WindowDecorActionBar$TabImpl mSelectedTab = this.mSelectedTab;
        int n2;
        if (mSelectedTab != null) {
            n2 = mSelectedTab.getPosition();
        }
        else {
            n2 = this.mSavedTabPosition;
        }
        this.mTabScrollView.removeTabAt(n);
        final WindowDecorActionBar$TabImpl windowDecorActionBar$TabImpl = this.mTabs.remove(n);
        if (windowDecorActionBar$TabImpl != null) {
            windowDecorActionBar$TabImpl.setPosition(-1);
        }
        for (int size = this.mTabs.size(), i = n; i < size; ++i) {
            ((WindowDecorActionBar$TabImpl)this.mTabs.get(i)).setPosition(i);
        }
        if (n2 == n) {
            ActionBar$Tab actionBar$Tab;
            if (this.mTabs.isEmpty()) {
                actionBar$Tab = null;
            }
            else {
                actionBar$Tab = this.mTabs.get(Math.max(0, n - 1));
            }
            this.selectTab(actionBar$Tab);
        }
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
        final int navigationMode = this.getNavigationMode();
        int n = -1;
        if (navigationMode != 2) {
            if (actionBar$Tab != null) {
                n = actionBar$Tab.getPosition();
            }
            this.mSavedTabPosition = n;
            return;
        }
        FragmentTransaction disallowAddToBackStack;
        if (this.mActivity instanceof FragmentActivity && !this.mDecorToolbar.getViewGroup().isInEditMode()) {
            disallowAddToBackStack = ((FragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        else {
            disallowAddToBackStack = null;
        }
        final WindowDecorActionBar$TabImpl mSelectedTab = this.mSelectedTab;
        if (mSelectedTab == actionBar$Tab) {
            if (mSelectedTab != null) {
                mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, disallowAddToBackStack);
                this.mTabScrollView.animateToTab(actionBar$Tab.getPosition());
            }
        }
        else {
            final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
            if (actionBar$Tab != null) {
                n = actionBar$Tab.getPosition();
            }
            mTabScrollView.setTabSelected(n);
            final WindowDecorActionBar$TabImpl mSelectedTab2 = this.mSelectedTab;
            if (mSelectedTab2 != null) {
                mSelectedTab2.getCallback().onTabUnselected(this.mSelectedTab, disallowAddToBackStack);
            }
            this.mSelectedTab = (WindowDecorActionBar$TabImpl)actionBar$Tab;
            final WindowDecorActionBar$TabImpl mSelectedTab3 = this.mSelectedTab;
            if (mSelectedTab3 != null) {
                mSelectedTab3.getCallback().onTabSelected(this.mSelectedTab, disallowAddToBackStack);
            }
        }
        if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
            disallowAddToBackStack.commit();
        }
    }
    
    public void setBackgroundDrawable(final Drawable primaryBackground) {
        this.mContainerView.setPrimaryBackground(primaryBackground);
    }
    
    public void setCustomView(final int n) {
        this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(n, this.mDecorToolbar.getViewGroup(), false));
    }
    
    public void setCustomView(final View customView) {
        this.mDecorToolbar.setCustomView(customView);
    }
    
    public void setCustomView(final View customView, final ActionBar$LayoutParams layoutParams) {
        customView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.mDecorToolbar.setCustomView(customView);
    }
    
    public void setDefaultDisplayHomeAsUpEnabled(final boolean displayHomeAsUpEnabled) {
        if (!this.mDisplayHomeAsUpSet) {
            this.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        }
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
    
    public void setDisplayOptions(final int displayOptions) {
        if ((displayOptions & 0x4) != 0x0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(displayOptions);
    }
    
    public void setDisplayOptions(final int n, final int n2) {
        final int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((n2 & 0x4) != 0x0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((n & n2) | (~n2 & displayOptions));
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
        ViewCompat.setElevation((View)this.mContainerView, n);
    }
    
    public void setHideOffset(final int actionBarHideOffset) {
        if (actionBarHideOffset != 0 && !this.mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.mOverlayLayout.setActionBarHideOffset(actionBarHideOffset);
    }
    
    public void setHideOnContentScrollEnabled(final boolean b) {
        if (b && !this.mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.mHideOnContentScroll = b;
        this.mOverlayLayout.setHideOnContentScrollEnabled(b);
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
    
    public void setHomeButtonEnabled(final boolean homeButtonEnabled) {
        this.mDecorToolbar.setHomeButtonEnabled(homeButtonEnabled);
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
        final int navigationMode2 = this.mDecorToolbar.getNavigationMode();
        final int n = 2;
        if (navigationMode2 == n) {
            this.mSavedTabPosition = this.getSelectedNavigationIndex();
            this.selectTab(null);
            this.mTabScrollView.setVisibility(8);
        }
        if (navigationMode2 != navigationMode && !this.mHasEmbeddedTabs) {
            final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
            if (mOverlayLayout != null) {
                ViewCompat.requestApplyInsets((View)mOverlayLayout);
            }
        }
        this.mDecorToolbar.setNavigationMode(navigationMode);
        boolean hasNonEmbeddedTabs = false;
        if (navigationMode == n) {
            this.ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            final int mSavedTabPosition = this.mSavedTabPosition;
            final int mSavedTabPosition2 = -1;
            if (mSavedTabPosition != mSavedTabPosition2) {
                this.setSelectedNavigationItem(mSavedTabPosition);
                this.mSavedTabPosition = mSavedTabPosition2;
            }
        }
        this.mDecorToolbar.setCollapsible(navigationMode == n && !this.mHasEmbeddedTabs);
        final ActionBarOverlayLayout mOverlayLayout2 = this.mOverlayLayout;
        if (navigationMode == n && !this.mHasEmbeddedTabs) {
            hasNonEmbeddedTabs = true;
        }
        mOverlayLayout2.setHasNonEmbeddedTabs(hasNonEmbeddedTabs);
    }
    
    public void setSelectedNavigationItem(final int dropdownSelectedPosition) {
        switch (this.mDecorToolbar.getNavigationMode()) {
            default: {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            case 2: {
                this.selectTab(this.mTabs.get(dropdownSelectedPosition));
                break;
            }
            case 1: {
                this.mDecorToolbar.setDropdownSelectedPosition(dropdownSelectedPosition);
                break;
            }
        }
    }
    
    public void setShowHideAnimationEnabled(final boolean mShowHideAnimationEnabled) {
        if (!(this.mShowHideAnimationEnabled = mShowHideAnimationEnabled)) {
            final ViewPropertyAnimatorCompatSet mCurrentShowAnim = this.mCurrentShowAnim;
            if (mCurrentShowAnim != null) {
                mCurrentShowAnim.cancel();
            }
        }
    }
    
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    public void setStackedBackgroundDrawable(final Drawable stackedBackground) {
        this.mContainerView.setStackedBackground(stackedBackground);
    }
    
    public void setSubtitle(final int n) {
        this.setSubtitle(this.mContext.getString(n));
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        this.mDecorToolbar.setSubtitle(subtitle);
    }
    
    public void setTitle(final int n) {
        this.setTitle(this.mContext.getString(n));
    }
    
    public void setTitle(final CharSequence title) {
        this.mDecorToolbar.setTitle(title);
    }
    
    public void setWindowTitle(final CharSequence windowTitle) {
        this.mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    public void show() {
        if (this.mHiddenByApp) {
            this.updateVisibility(this.mHiddenByApp = false);
        }
    }
    
    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            this.updateVisibility(true);
        }
    }
    
    public ActionMode startActionMode(final ActionMode$Callback actionMode$Callback) {
        final WindowDecorActionBar$ActionModeImpl mActionMode = this.mActionMode;
        if (mActionMode != null) {
            mActionMode.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        final WindowDecorActionBar$ActionModeImpl mActionMode2 = new WindowDecorActionBar$ActionModeImpl(this, this.mContextView.getContext(), actionMode$Callback);
        if (mActionMode2.dispatchOnCreate()) {
            (this.mActionMode = mActionMode2).invalidate();
            this.mContextView.initForMode(mActionMode2);
            this.animateToMode(true);
            this.mContextView.sendAccessibilityEvent(32);
            return mActionMode2;
        }
        return null;
    }
}
