// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.View$MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View$OnClickListener;
import android.support.v7.widget.ActionBarContextView$1;
import android.support.v7.widget.TintTypedArray;
import android.widget.LinearLayout;
import android.support.v7.widget.AbsActionBarView;
import android.support.v7.appcompat.R$color;
import android.view.ViewGroup$MarginLayoutParams;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.widget.ViewStubCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.AppCompatDrawableManager;
import android.content.res.Configuration;
import android.support.v4.view.LayoutInflaterCompat;
import android.app.Dialog;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import org.xmlpull.v1.XmlPullParser;
import android.view.LayoutInflater$Factory;
import android.util.AttributeSet;
import android.util.AndroidRuntimeException;
import android.view.KeyCharacterMap;
import android.view.ViewParent;
import android.view.Window$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager;
import android.view.Menu;
import android.util.Log;
import android.media.AudioManager;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import android.view.KeyEvent;
import android.content.res.Resources$Theme;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.text.TextUtils;
import android.support.v7.widget.ContentFrameLayout$OnAttachListener;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.support.v7.widget.ViewUtils;
import android.support.v7.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R$id;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.support.v7.appcompat.R$layout;
import android.view.LayoutInflater;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.widget.ContentFrameLayout;
import android.view.Window;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.TextView;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.ActionBarContextView;
import android.widget.PopupWindow;
import android.support.v7.view.ActionMode;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.view.menu.MenuBuilder$Callback;

class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements MenuBuilder$Callback, LayoutInflaterFactory
{
    private static final boolean IS_PRE_LOLLIPOP;
    private AppCompatDelegateImplV9$ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    private boolean mLongPressBackDown;
    private AppCompatDelegateImplV9$PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private AppCompatDelegateImplV9$PanelFeatureState[] mPanels;
    private AppCompatDelegateImplV9$PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private TextView mTitleView;
    
    static {
        IS_PRE_LOLLIPOP = (Build$VERSION.SDK_INT < 21);
    }
    
    AppCompatDelegateImplV9(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mFadeAnim = null;
        this.mInvalidatePanelMenuRunnable = new AppCompatDelegateImplV9$1(this);
    }
    
    private void applyFixedSizeWindow() {
        final ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
        final View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }
    
    private ViewGroup createSubDecor() {
        final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        final boolean boolean1 = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false);
        final int n = 1;
        if (boolean1) {
            this.requestWindowFeature(n);
        }
        else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            this.requestWindowFeature(108);
        }
        final boolean boolean2 = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false);
        final int n2 = 109;
        if (boolean2) {
            this.requestWindowFeature(n2);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            this.requestWindowFeature(10);
        }
        this.mIsFloating = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        this.mWindow.getDecorView();
        final LayoutInflater from = LayoutInflater.from(this.mContext);
        Object contentView = null;
        if (!this.mWindowNoTitle) {
            if (this.mIsFloating) {
                contentView = from.inflate(R$layout.abc_dialog_title_material, (ViewGroup)null);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            }
            else if (this.mHasActionBar) {
                final TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, (boolean)(n != 0));
                Object mContext;
                if (typedValue.resourceId != 0) {
                    mContext = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                }
                else {
                    mContext = this.mContext;
                }
                contentView = LayoutInflater.from((Context)mContext).inflate(R$layout.abc_screen_toolbar, (ViewGroup)null);
                (this.mDecorContentParent = (DecorContentParent)((ViewGroup)contentView).findViewById(R$id.decor_content_parent)).setWindowCallback(this.getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(n2);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            }
        }
        else {
            if (this.mOverlayActionMode) {
                contentView = from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup)null);
            }
            else {
                contentView = from.inflate(R$layout.abc_screen_simple, (ViewGroup)null);
            }
            if (Build$VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener((View)contentView, new AppCompatDelegateImplV9$2(this));
            }
            else {
                ((FitWindowsViewGroup)contentView).setOnFitSystemWindowsListener(new AppCompatDelegateImplV9$3(this));
            }
        }
        if (contentView != null) {
            if (this.mDecorContentParent == null) {
                this.mTitleView = (TextView)((ViewGroup)contentView).findViewById(R$id.title);
            }
            ViewUtils.makeOptionalFitsSystemWindows((View)contentView);
            final ContentFrameLayout contentFrameLayout = (ContentFrameLayout)((ViewGroup)contentView).findViewById(R$id.action_bar_activity_content);
            final Window mWindow = this.mWindow;
            final int id = 16908290;
            final ViewGroup viewGroup = (ViewGroup)mWindow.findViewById(id);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    final View child = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(child);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(id);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout)viewGroup).setForeground((Drawable)null);
                }
            }
            this.mWindow.setContentView((View)contentView);
            contentFrameLayout.setAttachListener(new AppCompatDelegateImplV9$4(this));
            return (ViewGroup)contentView;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("AppCompat does not support the current theme features: { windowActionBar: ");
        sb.append(this.mHasActionBar);
        sb.append(", windowActionBarOverlay: ");
        sb.append(this.mOverlayActionBar);
        sb.append(", android:windowIsFloating: ");
        sb.append(this.mIsFloating);
        sb.append(", windowActionModeOverlay: ");
        sb.append(this.mOverlayActionMode);
        sb.append(", windowNoTitle: ");
        sb.append(this.mWindowNoTitle);
        sb.append(" }");
        throw new IllegalArgumentException(sb.toString());
    }
    
    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            this.mSubDecor = this.createSubDecor();
            final CharSequence title = this.getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.onTitleChanged(title);
            }
            this.applyFixedSizeWindow();
            this.onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(0, false);
            if (!this.isDestroyed() && (panelState == null || panelState.menu == null)) {
                this.invalidatePanelMenu(108);
            }
        }
    }
    
    private boolean initializePanelContent(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState) {
        final View createdPanelView = appCompatDelegateImplV9$PanelFeatureState.createdPanelView;
        boolean b = true;
        if (createdPanelView != null) {
            appCompatDelegateImplV9$PanelFeatureState.shownPanelView = appCompatDelegateImplV9$PanelFeatureState.createdPanelView;
            return b;
        }
        if (appCompatDelegateImplV9$PanelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new AppCompatDelegateImplV9$PanelMenuPresenterCallback(this);
        }
        appCompatDelegateImplV9$PanelFeatureState.shownPanelView = (View)appCompatDelegateImplV9$PanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
        if (appCompatDelegateImplV9$PanelFeatureState.shownPanelView == null) {
            b = false;
        }
        return b;
    }
    
    private boolean initializePanelDecor(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState) {
        appCompatDelegateImplV9$PanelFeatureState.setStyle(this.getActionBarThemedContext());
        appCompatDelegateImplV9$PanelFeatureState.decorView = (ViewGroup)new AppCompatDelegateImplV9$ListMenuDecorView(this, appCompatDelegateImplV9$PanelFeatureState.listPresenterContext);
        appCompatDelegateImplV9$PanelFeatureState.gravity = 81;
        return true;
    }
    
    private boolean initializePanelMenu(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState) {
        Object mContext = this.mContext;
        final int featureId = appCompatDelegateImplV9$PanelFeatureState.featureId;
        final boolean b = true;
        if ((featureId == 0 || appCompatDelegateImplV9$PanelFeatureState.featureId == 108) && this.mDecorContentParent != null) {
            final TypedValue typedValue = new TypedValue();
            final Resources$Theme theme = ((Context)mContext).getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, b);
            Resources$Theme to = null;
            if (typedValue.resourceId != 0) {
                to = ((Context)mContext).getResources().newTheme();
                to.setTo(theme);
                to.applyStyle(typedValue.resourceId, b);
                to.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, b);
            }
            else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, b);
            }
            if (typedValue.resourceId != 0) {
                if (to == null) {
                    to = ((Context)mContext).getResources().newTheme();
                    to.setTo(theme);
                }
                to.applyStyle(typedValue.resourceId, b);
            }
            if (to != null) {
                ((Context)(mContext = new ContextThemeWrapper((Context)mContext, 0))).getTheme().setTo(to);
            }
        }
        final MenuBuilder menu = new MenuBuilder((Context)mContext);
        menu.setCallback(this);
        appCompatDelegateImplV9$PanelFeatureState.setMenu(menu);
        return b;
    }
    
    private void invalidatePanelMenu(final int n) {
        final int mInvalidatePanelMenuFeatures = this.mInvalidatePanelMenuFeatures;
        final int mInvalidatePanelMenuPosted = 1;
        this.mInvalidatePanelMenuFeatures = (mInvalidatePanelMenuFeatures | mInvalidatePanelMenuPosted << n);
        if (!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = (mInvalidatePanelMenuPosted != 0);
        }
    }
    
    private boolean onKeyDownPanel(final int n, final KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(n, true);
            if (!panelState.isOpen) {
                return this.preparePanel(panelState, keyEvent);
            }
        }
        return false;
    }
    
    private boolean onKeyUpPanel(final int n, final KeyEvent keyEvent) {
        if (this.mActionMode != null) {
            return false;
        }
        boolean b = false;
        final boolean b2 = true;
        final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(n, b2);
        Label_0282: {
            if (n == 0) {
                final DecorContentParent mDecorContentParent = this.mDecorContentParent;
                if (mDecorContentParent != null) {
                    if (mDecorContentParent.canShowOverflowMenu()) {
                        if (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
                            if (this.mDecorContentParent.isOverflowMenuShowing()) {
                                b = this.mDecorContentParent.hideOverflowMenu();
                                break Label_0282;
                            }
                            if (!this.isDestroyed() && this.preparePanel(panelState, keyEvent)) {
                                b = this.mDecorContentParent.showOverflowMenu();
                            }
                            break Label_0282;
                        }
                    }
                }
            }
            if (!panelState.isOpen && !panelState.isHandled) {
                if (panelState.isPrepared) {
                    boolean preparePanel = true;
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        preparePanel = this.preparePanel(panelState, keyEvent);
                    }
                    if (preparePanel) {
                        this.openPanel(panelState, keyEvent);
                        b = true;
                    }
                }
            }
            else {
                b = panelState.isOpen;
                this.closePanel(panelState, b2);
            }
        }
        if (b) {
            final AudioManager audioManager = (AudioManager)this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            }
            else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return b;
    }
    
    private void openPanel(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState, final KeyEvent keyEvent) {
        if (appCompatDelegateImplV9$PanelFeatureState.isOpen || this.isDestroyed()) {
            return;
        }
        final int featureId = appCompatDelegateImplV9$PanelFeatureState.featureId;
        final boolean isOpen = true;
        if (featureId == 0) {
            final Context mContext = this.mContext;
            final boolean b = (mContext.getResources().getConfiguration().screenLayout & 0xF) == 0x4;
            final boolean b2 = mContext.getApplicationInfo().targetSdkVersion >= 11;
            if (b && b2) {
                return;
            }
        }
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null && !windowCallback.onMenuOpened(appCompatDelegateImplV9$PanelFeatureState.featureId, (Menu)appCompatDelegateImplV9$PanelFeatureState.menu)) {
            this.closePanel(appCompatDelegateImplV9$PanelFeatureState, isOpen);
            return;
        }
        final WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
        if (windowManager == null) {
            return;
        }
        if (!this.preparePanel(appCompatDelegateImplV9$PanelFeatureState, keyEvent)) {
            return;
        }
        int n = -2;
        if (appCompatDelegateImplV9$PanelFeatureState.decorView != null && !appCompatDelegateImplV9$PanelFeatureState.refreshDecorView) {
            if (appCompatDelegateImplV9$PanelFeatureState.createdPanelView != null) {
                final ViewGroup$LayoutParams layoutParams = appCompatDelegateImplV9$PanelFeatureState.createdPanelView.getLayoutParams();
                if (layoutParams != null && layoutParams.width == -1) {
                    n = -1;
                }
            }
        }
        else {
            if (appCompatDelegateImplV9$PanelFeatureState.decorView == null) {
                if (!this.initializePanelDecor(appCompatDelegateImplV9$PanelFeatureState) || appCompatDelegateImplV9$PanelFeatureState.decorView == null) {
                    return;
                }
            }
            else if (appCompatDelegateImplV9$PanelFeatureState.refreshDecorView && appCompatDelegateImplV9$PanelFeatureState.decorView.getChildCount() > 0) {
                appCompatDelegateImplV9$PanelFeatureState.decorView.removeAllViews();
            }
            if (!this.initializePanelContent(appCompatDelegateImplV9$PanelFeatureState) || !appCompatDelegateImplV9$PanelFeatureState.hasPanelItems()) {
                return;
            }
            ViewGroup$LayoutParams layoutParams2 = appCompatDelegateImplV9$PanelFeatureState.shownPanelView.getLayoutParams();
            if (layoutParams2 == null) {
                final int n2 = -2;
                layoutParams2 = new ViewGroup$LayoutParams(n2, n2);
            }
            appCompatDelegateImplV9$PanelFeatureState.decorView.setBackgroundResource(appCompatDelegateImplV9$PanelFeatureState.background);
            final ViewParent parent = appCompatDelegateImplV9$PanelFeatureState.shownPanelView.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(appCompatDelegateImplV9$PanelFeatureState.shownPanelView);
            }
            appCompatDelegateImplV9$PanelFeatureState.decorView.addView(appCompatDelegateImplV9$PanelFeatureState.shownPanelView, layoutParams2);
            if (!appCompatDelegateImplV9$PanelFeatureState.shownPanelView.hasFocus()) {
                appCompatDelegateImplV9$PanelFeatureState.shownPanelView.requestFocus();
            }
        }
        appCompatDelegateImplV9$PanelFeatureState.isHandled = false;
        final WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(n, -2, appCompatDelegateImplV9$PanelFeatureState.x, appCompatDelegateImplV9$PanelFeatureState.y, 1002, 8519680, -3);
        windowManager$LayoutParams.gravity = appCompatDelegateImplV9$PanelFeatureState.gravity;
        windowManager$LayoutParams.windowAnimations = appCompatDelegateImplV9$PanelFeatureState.windowAnimations;
        windowManager.addView((View)appCompatDelegateImplV9$PanelFeatureState.decorView, (ViewGroup$LayoutParams)windowManager$LayoutParams);
        appCompatDelegateImplV9$PanelFeatureState.isOpen = isOpen;
    }
    
    private boolean performPanelShortcut(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState, final int n, final KeyEvent keyEvent, final int n2) {
        if (keyEvent.isSystem()) {
            return false;
        }
        boolean performShortcut = false;
        if ((appCompatDelegateImplV9$PanelFeatureState.isPrepared || this.preparePanel(appCompatDelegateImplV9$PanelFeatureState, keyEvent)) && appCompatDelegateImplV9$PanelFeatureState.menu != null) {
            performShortcut = appCompatDelegateImplV9$PanelFeatureState.menu.performShortcut(n, keyEvent, n2);
        }
        if (performShortcut) {
            if ((n2 & 0x1) == 0x0 && this.mDecorContentParent == null) {
                this.closePanel(appCompatDelegateImplV9$PanelFeatureState, true);
            }
        }
        return performShortcut;
    }
    
    private boolean preparePanel(final AppCompatDelegateImplV9$PanelFeatureState mPreparedPanel, final KeyEvent keyEvent) {
        if (this.isDestroyed()) {
            return false;
        }
        final boolean isPrepared = mPreparedPanel.isPrepared;
        final boolean isPrepared2 = true;
        if (isPrepared) {
            return isPrepared2;
        }
        final AppCompatDelegateImplV9$PanelFeatureState mPreparedPanel2 = this.mPreparedPanel;
        if (mPreparedPanel2 != null && mPreparedPanel2 != mPreparedPanel) {
            this.closePanel(mPreparedPanel2, false);
        }
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null) {
            mPreparedPanel.createdPanelView = windowCallback.onCreatePanelView(mPreparedPanel.featureId);
        }
        final boolean b = mPreparedPanel.featureId == 0 || mPreparedPanel.featureId == 108;
        if (b) {
            final DecorContentParent mDecorContentParent = this.mDecorContentParent;
            if (mDecorContentParent != null) {
                mDecorContentParent.setMenuPrepared();
            }
        }
        if (mPreparedPanel.createdPanelView == null) {
            if (!b || !(this.peekSupportActionBar() instanceof ToolbarActionBar)) {
                if (mPreparedPanel.menu == null || mPreparedPanel.refreshMenuContent) {
                    if (mPreparedPanel.menu == null && (!this.initializePanelMenu(mPreparedPanel) || mPreparedPanel.menu == null)) {
                        return false;
                    }
                    if (b && this.mDecorContentParent != null) {
                        if (this.mActionMenuPresenterCallback == null) {
                            this.mActionMenuPresenterCallback = new AppCompatDelegateImplV9$ActionMenuPresenterCallback(this);
                        }
                        this.mDecorContentParent.setMenu((Menu)mPreparedPanel.menu, this.mActionMenuPresenterCallback);
                    }
                    mPreparedPanel.menu.stopDispatchingItemsChanged();
                    if (!windowCallback.onCreatePanelMenu(mPreparedPanel.featureId, (Menu)mPreparedPanel.menu)) {
                        mPreparedPanel.setMenu(null);
                        if (b) {
                            final DecorContentParent mDecorContentParent2 = this.mDecorContentParent;
                            if (mDecorContentParent2 != null) {
                                mDecorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                            }
                        }
                        return false;
                    }
                    mPreparedPanel.refreshMenuContent = false;
                }
                mPreparedPanel.menu.stopDispatchingItemsChanged();
                if (mPreparedPanel.frozenActionViewState != null) {
                    mPreparedPanel.menu.restoreActionViewStates(mPreparedPanel.frozenActionViewState);
                    mPreparedPanel.frozenActionViewState = null;
                }
                if (!windowCallback.onPreparePanel(0, mPreparedPanel.createdPanelView, (Menu)mPreparedPanel.menu)) {
                    if (b) {
                        final DecorContentParent mDecorContentParent3 = this.mDecorContentParent;
                        if (mDecorContentParent3 != null) {
                            mDecorContentParent3.setMenu(null, this.mActionMenuPresenterCallback);
                        }
                    }
                    mPreparedPanel.menu.startDispatchingItemsChanged();
                    return false;
                }
                int deviceId;
                if (keyEvent != null) {
                    deviceId = keyEvent.getDeviceId();
                }
                else {
                    deviceId = -1;
                }
                mPreparedPanel.qwertyMode = (KeyCharacterMap.load(deviceId).getKeyboardType() != (isPrepared2 ? 1 : 0));
                mPreparedPanel.menu.setQwertyMode(mPreparedPanel.qwertyMode);
                mPreparedPanel.menu.startDispatchingItemsChanged();
            }
        }
        mPreparedPanel.isPrepared = isPrepared2;
        mPreparedPanel.isHandled = false;
        this.mPreparedPanel = mPreparedPanel;
        return isPrepared2;
    }
    
    private void reopenMenu(final MenuBuilder menuBuilder, final boolean b) {
        final DecorContentParent mDecorContentParent = this.mDecorContentParent;
        final boolean refreshDecorView = true;
        if (mDecorContentParent != null && mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.mDecorContentParent.isOverflowMenuShowPending())) {
            final Window$Callback windowCallback = this.getWindowCallback();
            final boolean overflowMenuShowing = this.mDecorContentParent.isOverflowMenuShowing();
            final int n = 108;
            if (overflowMenuShowing && b) {
                this.mDecorContentParent.hideOverflowMenu();
                if (!this.isDestroyed()) {
                    windowCallback.onPanelClosed(n, (Menu)this.getPanelState(0, refreshDecorView).menu);
                }
            }
            else if (windowCallback != null && !this.isDestroyed()) {
                if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & (refreshDecorView ? 1 : 0)) != 0x0) {
                    this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                    this.mInvalidatePanelMenuRunnable.run();
                }
                final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(0, refreshDecorView);
                if (panelState.menu != null && !panelState.refreshMenuContent) {
                    if (windowCallback.onPreparePanel(0, panelState.createdPanelView, (Menu)panelState.menu)) {
                        windowCallback.onMenuOpened(n, (Menu)panelState.menu);
                        this.mDecorContentParent.showOverflowMenu();
                    }
                }
            }
            return;
        }
        final AppCompatDelegateImplV9$PanelFeatureState panelState2 = this.getPanelState(0, refreshDecorView);
        panelState2.refreshDecorView = refreshDecorView;
        this.closePanel(panelState2, false);
        this.openPanel(panelState2, null);
    }
    
    private int sanitizeWindowFeatureId(final int n) {
        if (n == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (n == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return n;
    }
    
    private boolean shouldInheritContext(ViewParent parent) {
        if (parent == null) {
            return false;
        }
        final View decorView = this.mWindow.getDecorView();
        while (parent != null) {
            if (parent == decorView || !(parent instanceof View) || ViewCompat.isAttachedToWindow((View)parent)) {
                return false;
            }
            parent = parent.getParent();
        }
        return true;
    }
    
    private void throwFeatureRequestIfSubDecorInstalled() {
        if (!this.mSubDecorInstalled) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
    
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.ensureSubDecor();
        ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(view, viewGroup$LayoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    View callActivityOnCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        if (this.mOriginalWindowCallback instanceof LayoutInflater$Factory) {
            final View onCreateView = ((LayoutInflater$Factory)this.mOriginalWindowCallback).onCreateView(s, context, set);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }
    
    void callOnPanelClosed(final int n, AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState, Menu menu) {
        if (menu == null) {
            if (appCompatDelegateImplV9$PanelFeatureState == null) {
                if (n >= 0) {
                    final AppCompatDelegateImplV9$PanelFeatureState[] mPanels = this.mPanels;
                    if (n < mPanels.length) {
                        appCompatDelegateImplV9$PanelFeatureState = mPanels[n];
                    }
                }
            }
            if (appCompatDelegateImplV9$PanelFeatureState != null) {
                menu = (Menu)appCompatDelegateImplV9$PanelFeatureState.menu;
            }
        }
        if (appCompatDelegateImplV9$PanelFeatureState != null && !appCompatDelegateImplV9$PanelFeatureState.isOpen) {
            return;
        }
        if (!this.isDestroyed()) {
            this.mOriginalWindowCallback.onPanelClosed(n, menu);
        }
    }
    
    void checkCloseActionMenu(final MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null && !this.isDestroyed()) {
            windowCallback.onPanelClosed(108, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }
    
    void closePanel(final int n) {
        final boolean b = true;
        this.closePanel(this.getPanelState(n, b), b);
    }
    
    void closePanel(final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState, final boolean b) {
        if (b && appCompatDelegateImplV9$PanelFeatureState.featureId == 0) {
            final DecorContentParent mDecorContentParent = this.mDecorContentParent;
            if (mDecorContentParent != null) {
                if (mDecorContentParent.isOverflowMenuShowing()) {
                    this.checkCloseActionMenu(appCompatDelegateImplV9$PanelFeatureState.menu);
                    return;
                }
            }
        }
        final WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
        if (windowManager != null && appCompatDelegateImplV9$PanelFeatureState.isOpen && appCompatDelegateImplV9$PanelFeatureState.decorView != null) {
            windowManager.removeView((View)appCompatDelegateImplV9$PanelFeatureState.decorView);
            if (b) {
                this.callOnPanelClosed(appCompatDelegateImplV9$PanelFeatureState.featureId, appCompatDelegateImplV9$PanelFeatureState, null);
            }
        }
        appCompatDelegateImplV9$PanelFeatureState.isPrepared = false;
        appCompatDelegateImplV9$PanelFeatureState.isHandled = false;
        appCompatDelegateImplV9$PanelFeatureState.isOpen = false;
        appCompatDelegateImplV9$PanelFeatureState.shownPanelView = null;
        appCompatDelegateImplV9$PanelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == appCompatDelegateImplV9$PanelFeatureState) {
            this.mPreparedPanel = null;
        }
    }
    
    public View createView(final View view, final String s, final Context context, final AttributeSet set) {
        if (this.mAppCompatViewInflater == null) {
            this.mAppCompatViewInflater = new AppCompatViewInflater();
        }
        boolean b = false;
        if (AppCompatDelegateImplV9.IS_PRE_LOLLIPOP) {
            final boolean b2 = set instanceof XmlPullParser;
            int shouldInheritContext = 1;
            if (b2) {
                if (((XmlPullParser)set).getDepth() <= shouldInheritContext) {
                    shouldInheritContext = 0;
                }
            }
            else {
                shouldInheritContext = (this.shouldInheritContext((ViewParent)view) ? 1 : 0);
            }
            b = (shouldInheritContext != 0);
        }
        return this.mAppCompatViewInflater.createView(view, s, context, set, b, AppCompatDelegateImplV9.IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    }
    
    void dismissPopups() {
        final DecorContentParent mDecorContentParent = this.mDecorContentParent;
        if (mDecorContentParent != null) {
            mDecorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    final PopupWindow mActionModePopup = this.mActionModePopup;
                    try {
                        mActionModePopup.dismiss();
                    }
                    catch (IllegalArgumentException ex) {}
                }
                catch (IllegalArgumentException ex2) {}
            }
            this.mActionModePopup = null;
        }
        this.endOnGoingFadeAnimation();
        final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(0, false);
        if (panelState != null && panelState.menu != null) {
            panelState.menu.close();
        }
    }
    
    boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        boolean b = true;
        if (keyCode == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(keyEvent)) {
            return b;
        }
        final int keyCode2 = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            b = false;
        }
        boolean b2;
        if (b) {
            b2 = this.onKeyDown(keyCode2, keyEvent);
        }
        else {
            b2 = this.onKeyUp(keyCode2, keyEvent);
        }
        return b2;
    }
    
    void doInvalidatePanelMenu(final int n) {
        final boolean b = true;
        final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(n, b);
        if (panelState.menu != null) {
            final Bundle frozenActionViewState = new Bundle();
            panelState.menu.saveActionViewStates(frozenActionViewState);
            if (frozenActionViewState.size() > 0) {
                panelState.frozenActionViewState = frozenActionViewState;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = b;
        panelState.refreshDecorView = b;
        if ((n == 108 || n == 0) && this.mDecorContentParent != null) {
            final AppCompatDelegateImplV9$PanelFeatureState panelState2 = this.getPanelState(0, false);
            if (panelState2 != null) {
                panelState2.isPrepared = false;
                this.preparePanel(panelState2, null);
            }
        }
    }
    
    void endOnGoingFadeAnimation() {
        final ViewPropertyAnimatorCompat mFadeAnim = this.mFadeAnim;
        if (mFadeAnim != null) {
            mFadeAnim.cancel();
        }
    }
    
    AppCompatDelegateImplV9$PanelFeatureState findMenuPanel(final Menu menu) {
        final AppCompatDelegateImplV9$PanelFeatureState[] mPanels = this.mPanels;
        int length;
        if (mPanels != null) {
            length = mPanels.length;
        }
        else {
            length = 0;
        }
        for (int i = 0; i < length; ++i) {
            final AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState = mPanels[i];
            if (appCompatDelegateImplV9$PanelFeatureState != null && appCompatDelegateImplV9$PanelFeatureState.menu == menu) {
                return appCompatDelegateImplV9$PanelFeatureState;
            }
        }
        return null;
    }
    
    public View findViewById(final int n) {
        this.ensureSubDecor();
        return this.mWindow.findViewById(n);
    }
    
    protected AppCompatDelegateImplV9$PanelFeatureState getPanelState(final int n, final boolean b) {
        AppCompatDelegateImplV9$PanelFeatureState[] mPanels;
        final AppCompatDelegateImplV9$PanelFeatureState[] array = mPanels = this.mPanels;
        if (array == null || array.length <= n) {
            final AppCompatDelegateImplV9$PanelFeatureState[] mPanels2 = new AppCompatDelegateImplV9$PanelFeatureState[n + 1];
            if (mPanels != null) {
                System.arraycopy(mPanels, 0, mPanels2, 0, mPanels.length);
            }
            mPanels = mPanels2;
            this.mPanels = mPanels2;
        }
        AppCompatDelegateImplV9$PanelFeatureState appCompatDelegateImplV9$PanelFeatureState = mPanels[n];
        if (appCompatDelegateImplV9$PanelFeatureState == null) {
            appCompatDelegateImplV9$PanelFeatureState = (mPanels[n] = new AppCompatDelegateImplV9$PanelFeatureState(n));
        }
        return appCompatDelegateImplV9$PanelFeatureState;
    }
    
    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }
    
    public boolean hasWindowFeature(int sanitizeWindowFeatureId) {
        sanitizeWindowFeatureId = this.sanitizeWindowFeatureId(sanitizeWindowFeatureId);
        switch (sanitizeWindowFeatureId) {
            default: {
                return false;
            }
            case 109: {
                return this.mOverlayActionBar;
            }
            case 108: {
                return this.mHasActionBar;
            }
            case 10: {
                return this.mOverlayActionMode;
            }
            case 5: {
                return this.mFeatureIndeterminateProgress;
            }
            case 2: {
                return this.mFeatureProgress;
            }
            case 1: {
                return this.mWindowNoTitle;
            }
        }
    }
    
    public void initWindowDecorActionBar() {
        this.ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            if (this.mOriginalWindowCallback instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
            }
            else if (this.mOriginalWindowCallback instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
            }
            if (this.mActionBar != null) {
                this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }
    
    public void installViewFactory() {
        final LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        }
        else if (!(LayoutInflaterCompat.getFactory(from) instanceof AppCompatDelegateImplV9)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }
    
    public void invalidateOptionsMenu() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null && supportActionBar.invalidateOptionsMenu()) {
            return;
        }
        this.invalidatePanelMenu(0);
    }
    
    boolean onBackPressed() {
        final ActionMode mActionMode = this.mActionMode;
        final boolean b = true;
        if (mActionMode != null) {
            mActionMode.finish();
            return b;
        }
        final ActionBar supportActionBar = this.getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView() && b;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (this.mHasActionBar && this.mSubDecorInstalled) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.applyDayNight();
    }
    
    public void onCreate(final Bundle bundle) {
        if (this.mOriginalWindowCallback instanceof Activity) {
            if (NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null) {
                final ActionBar peekSupportActionBar = this.peekSupportActionBar();
                final boolean b = true;
                if (peekSupportActionBar == null) {
                    this.mEnableDefaultActionBarUp = b;
                }
                else {
                    peekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(b);
                }
            }
        }
    }
    
    public final View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        final View callActivityOnCreateView = this.callActivityOnCreateView(view, s, context, set);
        if (callActivityOnCreateView != null) {
            return callActivityOnCreateView;
        }
        return this.createView(view, s, context, set);
    }
    
    public void onDestroy() {
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }
    
    boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        final int n2 = 4;
        boolean mLongPressBackDown = true;
        if (n != n2) {
            if (n == 82) {
                this.onKeyDownPanel(0, keyEvent);
                return mLongPressBackDown;
            }
        }
        else {
            if ((keyEvent.getFlags() & 0x80) == 0x0) {
                mLongPressBackDown = false;
            }
            this.mLongPressBackDown = mLongPressBackDown;
        }
        if (Build$VERSION.SDK_INT < 11) {
            this.onKeyShortcut(n, keyEvent);
        }
        return false;
    }
    
    boolean onKeyShortcut(final int n, final KeyEvent keyEvent) {
        final ActionBar supportActionBar = this.getSupportActionBar();
        final int isHandled = 1;
        if (supportActionBar != null && supportActionBar.onKeyShortcut(n, keyEvent)) {
            return isHandled != 0;
        }
        final AppCompatDelegateImplV9$PanelFeatureState mPreparedPanel = this.mPreparedPanel;
        if (mPreparedPanel != null && this.performPanelShortcut(mPreparedPanel, keyEvent.getKeyCode(), keyEvent, isHandled)) {
            final AppCompatDelegateImplV9$PanelFeatureState mPreparedPanel2 = this.mPreparedPanel;
            if (mPreparedPanel2 != null) {
                mPreparedPanel2.isHandled = (isHandled != 0);
            }
            return isHandled != 0;
        }
        if (this.mPreparedPanel == null) {
            final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(0, isHandled != 0);
            this.preparePanel(panelState, keyEvent);
            final boolean performPanelShortcut = this.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, isHandled);
            panelState.isPrepared = false;
            if (performPanelShortcut) {
                return isHandled != 0;
            }
        }
        return false;
    }
    
    boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        final int n2 = 4;
        final boolean b = true;
        if (n != n2) {
            if (n == 82) {
                this.onKeyUpPanel(0, keyEvent);
                return b;
            }
        }
        else {
            final boolean mLongPressBackDown = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(0, false);
            if (panelState != null && panelState.isOpen) {
                if (!mLongPressBackDown) {
                    this.closePanel(panelState, b);
                }
                return b;
            }
            if (this.onBackPressed()) {
                return b;
            }
        }
        return false;
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null && !this.isDestroyed()) {
            final AppCompatDelegateImplV9$PanelFeatureState menuPanel = this.findMenuPanel((Menu)menuBuilder.getRootMenu());
            if (menuPanel != null) {
                return windowCallback.onMenuItemSelected(menuPanel.featureId, menuItem);
            }
        }
        return false;
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.reopenMenu(menuBuilder, true);
    }
    
    boolean onMenuOpened(final int n, final Menu menu) {
        if (n == 108) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            final boolean b = true;
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(b);
            }
            return b;
        }
        return false;
    }
    
    void onPanelClosed(final int n, final Menu menu) {
        if (n == 108) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        }
        else if (n == 0) {
            final AppCompatDelegateImplV9$PanelFeatureState panelState = this.getPanelState(n, true);
            if (panelState.isOpen) {
                this.closePanel(panelState, false);
            }
        }
    }
    
    public void onPostCreate(final Bundle bundle) {
        this.ensureSubDecor();
    }
    
    public void onPostResume() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }
    
    public void onStop() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }
    
    void onSubDecorInstalled(final ViewGroup viewGroup) {
    }
    
    void onTitleChanged(final CharSequence text) {
        final DecorContentParent mDecorContentParent = this.mDecorContentParent;
        if (mDecorContentParent != null) {
            mDecorContentParent.setWindowTitle(text);
        }
        else if (this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(text);
        }
        else {
            final TextView mTitleView = this.mTitleView;
            if (mTitleView != null) {
                mTitleView.setText(text);
            }
        }
    }
    
    public boolean requestWindowFeature(int sanitizeWindowFeatureId) {
        sanitizeWindowFeatureId = this.sanitizeWindowFeatureId(sanitizeWindowFeatureId);
        if (this.mWindowNoTitle && sanitizeWindowFeatureId == 108) {
            return false;
        }
        final boolean mHasActionBar = this.mHasActionBar;
        final boolean b = true;
        if (mHasActionBar && sanitizeWindowFeatureId == (b ? 1 : 0)) {
            this.mHasActionBar = false;
        }
        switch (sanitizeWindowFeatureId) {
            default: {
                return this.mWindow.requestFeature(sanitizeWindowFeatureId);
            }
            case 109: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mOverlayActionBar = b;
            }
            case 108: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mHasActionBar = b;
            }
            case 10: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mOverlayActionMode = b;
            }
            case 5: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mFeatureIndeterminateProgress = b;
            }
            case 2: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mFeatureProgress = b;
            }
            case 1: {
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mWindowNoTitle = b;
            }
        }
    }
    
    public void setContentView(final int n) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(n, viewGroup);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    public void setContentView(final View view) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, viewGroup$LayoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    public void setSupportActionBar(final Toolbar toolbar) {
        if (!(this.mOriginalWindowCallback instanceof Activity)) {
            return;
        }
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (!(supportActionBar instanceof WindowDecorActionBar)) {
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                final ToolbarActionBar mActionBar = new ToolbarActionBar(toolbar, ((Activity)this.mOriginalWindowCallback).getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = mActionBar;
                this.mWindow.setCallback(mActionBar.getWrappedWindowCallback());
            }
            else {
                this.mActionBar = null;
                this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }
            this.invalidateOptionsMenu();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    
    final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled) {
            final ViewGroup mSubDecor = this.mSubDecor;
            if (mSubDecor != null && ViewCompat.isLaidOut((View)mSubDecor)) {
                return true;
            }
        }
        return false;
    }
    
    public ActionMode startSupportActionMode(final ActionMode$Callback actionMode$Callback) {
        if (actionMode$Callback != null) {
            final ActionMode mActionMode = this.mActionMode;
            if (mActionMode != null) {
                mActionMode.finish();
            }
            final AppCompatDelegateImplV9$ActionModeCallbackWrapperV9 appCompatDelegateImplV9$ActionModeCallbackWrapperV9 = new AppCompatDelegateImplV9$ActionModeCallbackWrapperV9(this, actionMode$Callback);
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                this.mActionMode = supportActionBar.startActionMode(appCompatDelegateImplV9$ActionModeCallbackWrapperV9);
                if (this.mActionMode != null && this.mAppCompatCallback != null) {
                    this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
                }
            }
            if (this.mActionMode == null) {
                this.mActionMode = this.startSupportActionModeFromWindow(appCompatDelegateImplV9$ActionModeCallbackWrapperV9);
            }
            return this.mActionMode;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    
    ActionMode startSupportActionModeFromWindow(ActionMode$Callback actionMode$Callback) {
        this.endOnGoingFadeAnimation();
        final ActionMode mActionMode = this.mActionMode;
        if (mActionMode != null) {
            mActionMode.finish();
        }
        if (!(actionMode$Callback instanceof AppCompatDelegateImplV9$ActionModeCallbackWrapperV9)) {
            actionMode$Callback = new AppCompatDelegateImplV9$ActionModeCallbackWrapperV9(this, actionMode$Callback);
        }
        ActionMode onWindowStartingSupportActionMode = null;
        if (this.mAppCompatCallback != null && !this.isDestroyed()) {
            try {
                onWindowStartingSupportActionMode = this.mAppCompatCallback.onWindowStartingSupportActionMode(actionMode$Callback);
            }
            catch (AbstractMethodError abstractMethodError) {}
        }
        if (onWindowStartingSupportActionMode != null) {
            this.mActionMode = onWindowStartingSupportActionMode;
        }
        else {
            final ActionBarContextView mActionModeView = this.mActionModeView;
            boolean b = true;
            if (mActionModeView == null) {
                if (this.mIsFloating) {
                    final TypedValue typedValue = new TypedValue();
                    final Resources$Theme theme = this.mContext.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, b);
                    Object mContext;
                    if (typedValue.resourceId != 0) {
                        final Resources$Theme theme2 = this.mContext.getResources().newTheme();
                        theme2.setTo(theme);
                        theme2.applyStyle(typedValue.resourceId, b);
                        mContext = new ContextThemeWrapper(this.mContext, 0);
                        ((Context)mContext).getTheme().setTo(theme2);
                    }
                    else {
                        mContext = this.mContext;
                    }
                    this.mActionModeView = new ActionBarContextView((Context)mContext);
                    PopupWindowCompat.setWindowLayoutType(this.mActionModePopup = new PopupWindow((Context)mContext, (AttributeSet)null, R$attr.actionModePopupWindowStyle), 2);
                    this.mActionModePopup.setContentView((View)this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    ((Context)mContext).getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, b);
                    this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, ((Context)mContext).getResources().getDisplayMetrics()));
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new AppCompatDelegateImplV9$5(this);
                }
                else {
                    final ViewStubCompat viewStubCompat = (ViewStubCompat)this.mSubDecor.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(this.getActionBarThemedContext()));
                        this.mActionModeView = (ActionBarContextView)viewStubCompat.inflate();
                    }
                }
            }
            if (this.mActionModeView != null) {
                this.endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                final Context context = this.mActionModeView.getContext();
                final ActionBarContextView mActionModeView2 = this.mActionModeView;
                if (this.mActionModePopup != null) {
                    b = false;
                }
                final StandaloneActionMode mActionMode2;
                if (actionMode$Callback.onCreateActionMode(mActionMode2, (mActionMode2 = new StandaloneActionMode(context, mActionModeView2, actionMode$Callback, b)).getMenu())) {
                    mActionMode2.invalidate();
                    this.mActionModeView.initForMode(mActionMode2);
                    this.mActionMode = mActionMode2;
                    final boolean shouldAnimateActionModeView = this.shouldAnimateActionModeView();
                    final float n = 1.0f;
                    if (shouldAnimateActionModeView) {
                        ViewCompat.setAlpha((View)this.mActionModeView, 0.0f);
                        (this.mFadeAnim = ViewCompat.animate((View)this.mActionModeView).alpha(n)).setListener(new AppCompatDelegateImplV9$6(this));
                    }
                    else {
                        ViewCompat.setAlpha((View)this.mActionModeView, n);
                        this.mActionModeView.setVisibility(0);
                        this.mActionModeView.sendAccessibilityEvent(32);
                        if (this.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
                        }
                    }
                    if (this.mActionModePopup != null) {
                        this.mWindow.getDecorView().post(this.mShowActionModePopup);
                    }
                }
                else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && this.mAppCompatCallback != null) {
            this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }
    
    int updateStatusGuard(int n) {
        boolean b = false;
        final ActionBarContextView mActionModeView = this.mActionModeView;
        int visibility = 0;
        if (mActionModeView != null) {
            if (mActionModeView.getLayoutParams() instanceof ViewGroup$MarginLayoutParams) {
                final ViewGroup$MarginLayoutParams layoutParams = (ViewGroup$MarginLayoutParams)this.mActionModeView.getLayoutParams();
                boolean b2 = false;
                if (this.mActionModeView.isShown()) {
                    if (this.mTempRect1 == null) {
                        this.mTempRect1 = new Rect();
                        this.mTempRect2 = new Rect();
                    }
                    final Rect mTempRect1 = this.mTempRect1;
                    final Rect mTempRect2 = this.mTempRect2;
                    mTempRect1.set(0, n, 0, 0);
                    ViewUtils.computeFitSystemWindows((View)this.mSubDecor, mTempRect1, mTempRect2);
                    int n2;
                    if (mTempRect2.top == 0) {
                        n2 = n;
                    }
                    else {
                        n2 = 0;
                    }
                    if (layoutParams.topMargin != n2) {
                        b2 = true;
                        layoutParams.topMargin = n;
                        final View mStatusGuard = this.mStatusGuard;
                        if (mStatusGuard == null) {
                            (this.mStatusGuard = new View(this.mContext)).setBackgroundColor(this.mContext.getResources().getColor(R$color.abc_input_method_navigation_guard));
                            final ViewGroup mSubDecor = this.mSubDecor;
                            final View mStatusGuard2 = this.mStatusGuard;
                            final int n3 = -1;
                            mSubDecor.addView(mStatusGuard2, n3, new ViewGroup$LayoutParams(n3, n));
                        }
                        else {
                            final ViewGroup$LayoutParams layoutParams2 = mStatusGuard.getLayoutParams();
                            if (layoutParams2.height != n) {
                                layoutParams2.height = n;
                                this.mStatusGuard.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                    b = (this.mStatusGuard != null);
                    if (!this.mOverlayActionMode && b) {
                        n = 0;
                    }
                }
                else if (layoutParams.topMargin != 0) {
                    b2 = true;
                    layoutParams.topMargin = 0;
                }
                if (b2) {
                    this.mActionModeView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                }
            }
        }
        final View mStatusGuard3 = this.mStatusGuard;
        if (mStatusGuard3 != null) {
            if (!b) {
                visibility = 8;
            }
            mStatusGuard3.setVisibility(visibility);
        }
        return n;
    }
}
