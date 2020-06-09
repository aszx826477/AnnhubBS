// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.support.v7.view.SupportMenuInflater;
import android.view.KeyEvent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.support.v7.widget.TintTypedArray;
import android.os.Build$VERSION;
import android.view.Window;
import android.view.MenuInflater;
import android.content.Context;
import android.view.Window$Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate
{
    static final boolean DEBUG = false;
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean SHOULD_INSTALL_EXCEPTION_HANDLER;
    private static boolean sInstalledExceptionHandler;
    private static final int[] sWindowBackgroundStyleable;
    ActionBar mActionBar;
    final AppCompatCallback mAppCompatCallback;
    final Window$Callback mAppCompatWindowCallback;
    final Context mContext;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    private boolean mIsStarted;
    MenuInflater mMenuInflater;
    final Window$Callback mOriginalWindowCallback;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private CharSequence mTitle;
    final Window mWindow;
    boolean mWindowNoTitle;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int sInstalledExceptionHandler = 1;
        SHOULD_INSTALL_EXCEPTION_HANDLER = (sdk_INT < 21);
        if (AppCompatDelegateImplBase.SHOULD_INSTALL_EXCEPTION_HANDLER && !AppCompatDelegateImplBase.sInstalledExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new AppCompatDelegateImplBase$1(Thread.getDefaultUncaughtExceptionHandler()));
            AppCompatDelegateImplBase.sInstalledExceptionHandler = (sInstalledExceptionHandler != 0);
        }
        final int[] sWindowBackgroundStyleable2 = new int[sInstalledExceptionHandler];
        sWindowBackgroundStyleable2[0] = 16842836;
        sWindowBackgroundStyleable = sWindowBackgroundStyleable2;
    }
    
    AppCompatDelegateImplBase(final Context mContext, final Window mWindow, final AppCompatCallback mAppCompatCallback) {
        this.mContext = mContext;
        this.mWindow = mWindow;
        this.mAppCompatCallback = mAppCompatCallback;
        this.mOriginalWindowCallback = this.mWindow.getCallback();
        final Window$Callback mOriginalWindowCallback = this.mOriginalWindowCallback;
        if (!(mOriginalWindowCallback instanceof AppCompatDelegateImplBase$AppCompatWindowCallbackBase)) {
            this.mAppCompatWindowCallback = this.wrapWindowCallback(mOriginalWindowCallback);
            this.mWindow.setCallback(this.mAppCompatWindowCallback);
            final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(mContext, null, AppCompatDelegateImplBase.sWindowBackgroundStyleable);
            final Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
            if (drawableIfKnown != null) {
                this.mWindow.setBackgroundDrawable(drawableIfKnown);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    
    public boolean applyDayNight() {
        return false;
    }
    
    abstract boolean dispatchKeyEvent(final KeyEvent p0);
    
    final Context getActionBarThemedContext() {
        Context context = null;
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            context = this.mContext;
        }
        return context;
    }
    
    public final ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return new AppCompatDelegateImplBase$ActionBarDrawableToggleImpl(this);
    }
    
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            this.initWindowDecorActionBar();
            final ActionBar mActionBar = this.mActionBar;
            Context context;
            if (mActionBar != null) {
                context = mActionBar.getThemedContext();
            }
            else {
                context = this.mContext;
            }
            this.mMenuInflater = new SupportMenuInflater(context);
        }
        return this.mMenuInflater;
    }
    
    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return this.mActionBar;
    }
    
    final CharSequence getTitle() {
        final Window$Callback mOriginalWindowCallback = this.mOriginalWindowCallback;
        if (mOriginalWindowCallback instanceof Activity) {
            return ((Activity)mOriginalWindowCallback).getTitle();
        }
        return this.mTitle;
    }
    
    final Window$Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }
    
    abstract void initWindowDecorActionBar();
    
    final boolean isDestroyed() {
        return this.mIsDestroyed;
    }
    
    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }
    
    final boolean isStarted() {
        return this.mIsStarted;
    }
    
    public void onDestroy() {
        this.mIsDestroyed = true;
    }
    
    abstract boolean onKeyShortcut(final int p0, final KeyEvent p1);
    
    abstract boolean onMenuOpened(final int p0, final Menu p1);
    
    abstract void onPanelClosed(final int p0, final Menu p1);
    
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    public void onStart() {
        this.mIsStarted = true;
    }
    
    public void onStop() {
        this.mIsStarted = false;
    }
    
    abstract void onTitleChanged(final CharSequence p0);
    
    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }
    
    public void setHandleNativeActionModesEnabled(final boolean b) {
    }
    
    public void setLocalNightMode(final int n) {
    }
    
    public final void setTitle(final CharSequence mTitle) {
        this.onTitleChanged(this.mTitle = mTitle);
    }
    
    abstract ActionMode startSupportActionModeFromWindow(final ActionMode$Callback p0);
    
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatDelegateImplBase$AppCompatWindowCallbackBase(this, window$Callback);
    }
}
