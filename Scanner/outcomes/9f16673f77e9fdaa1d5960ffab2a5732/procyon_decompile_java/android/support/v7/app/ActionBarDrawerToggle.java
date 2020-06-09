// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.support.v7.widget.Toolbar;
import android.app.Activity;
import android.view.View$OnClickListener;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout$DrawerListener;

public class ActionBarDrawerToggle implements DrawerLayout$DrawerListener
{
    private final ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View$OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, final int n, final int n2) {
        this(activity, null, drawerLayout, null, n, n2);
    }
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, final Toolbar toolbar, final int n, final int n2) {
        this(activity, toolbar, drawerLayout, null, n, n2);
    }
    
    ActionBarDrawerToggle(final Activity activity, final Toolbar toolbar, final DrawerLayout mDrawerLayout, final DrawerArrowDrawable mSlider, final int mOpenDrawerContentDescRes, final int mCloseDrawerContentDescRes) {
        final boolean b = true;
        this.mDrawerSlideAnimationEnabled = b;
        this.mDrawerIndicatorEnabled = b;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new ActionBarDrawerToggle$ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener((View$OnClickListener)new ActionBarDrawerToggle$1(this));
        }
        else if (activity instanceof ActionBarDrawerToggle$DelegateProvider) {
            this.mActivityImpl = ((ActionBarDrawerToggle$DelegateProvider)activity).getDrawerToggleDelegate();
        }
        else if (Build$VERSION.SDK_INT >= 18) {
            this.mActivityImpl = new ActionBarDrawerToggle$JellybeanMr2Delegate(activity);
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            this.mActivityImpl = new ActionBarDrawerToggle$IcsDelegate(activity);
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            this.mActivityImpl = new ActionBarDrawerToggle$HoneycombDelegate(activity);
        }
        else {
            this.mActivityImpl = new ActionBarDrawerToggle$DummyDelegate(activity);
        }
        this.mDrawerLayout = mDrawerLayout;
        this.mOpenDrawerContentDescRes = mOpenDrawerContentDescRes;
        this.mCloseDrawerContentDescRes = mCloseDrawerContentDescRes;
        if (mSlider == null) {
            this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        }
        else {
            this.mSlider = mSlider;
        }
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
    }
    
    private void setPosition(final float progress) {
        if (progress == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        }
        else if (progress == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(progress);
    }
    
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }
    
    Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }
    
    public View$OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }
    
    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }
    
    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.syncState();
    }
    
    public void onDrawerClosed(final View view) {
        this.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }
    
    public void onDrawerOpened(final View view) {
        this.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }
    
    public void onDrawerSlide(final View view, final float n) {
        if (this.mDrawerSlideAnimationEnabled) {
            this.setPosition(Math.min(1.0f, Math.max(0.0f, n)));
        }
        else {
            this.setPosition(0.0f);
        }
    }
    
    public void onDrawerStateChanged(final int n) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            this.toggle();
            return true;
        }
        return false;
    }
    
    void setActionBarDescription(final int actionBarDescription) {
        this.mActivityImpl.setActionBarDescription(actionBarDescription);
    }
    
    void setActionBarUpIndicator(final Drawable drawable, final int n) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, n);
    }
    
    public void setDrawerArrowDrawable(final DrawerArrowDrawable mSlider) {
        this.mSlider = mSlider;
        this.syncState();
    }
    
    public void setDrawerIndicatorEnabled(final boolean mDrawerIndicatorEnabled) {
        if (mDrawerIndicatorEnabled != this.mDrawerIndicatorEnabled) {
            if (mDrawerIndicatorEnabled) {
                final DrawerArrowDrawable mSlider = this.mSlider;
                int n;
                if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                    n = this.mCloseDrawerContentDescRes;
                }
                else {
                    n = this.mOpenDrawerContentDescRes;
                }
                this.setActionBarUpIndicator(mSlider, n);
            }
            else {
                this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = mDrawerIndicatorEnabled;
        }
    }
    
    public void setDrawerSlideAnimationEnabled(final boolean mDrawerSlideAnimationEnabled) {
        if (!(this.mDrawerSlideAnimationEnabled = mDrawerSlideAnimationEnabled)) {
            this.setPosition(0.0f);
        }
    }
    
    public void setHomeAsUpIndicator(final int n) {
        Drawable drawable = null;
        if (n != 0) {
            drawable = this.mDrawerLayout.getResources().getDrawable(n);
        }
        this.setHomeAsUpIndicator(drawable);
    }
    
    public void setHomeAsUpIndicator(final Drawable mHomeAsUpIndicator) {
        if (mHomeAsUpIndicator == null) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        }
        else {
            this.mHomeAsUpIndicator = mHomeAsUpIndicator;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }
    
    public void setToolbarNavigationClickListener(final View$OnClickListener mToolbarNavigationClickListener) {
        this.mToolbarNavigationClickListener = mToolbarNavigationClickListener;
    }
    
    public void syncState() {
        final DrawerLayout mDrawerLayout = this.mDrawerLayout;
        final int n = 8388611;
        if (mDrawerLayout.isDrawerOpen(n)) {
            this.setPosition(1.0f);
        }
        else {
            this.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            final DrawerArrowDrawable mSlider = this.mSlider;
            int n2;
            if (this.mDrawerLayout.isDrawerOpen(n)) {
                n2 = this.mCloseDrawerContentDescRes;
            }
            else {
                n2 = this.mOpenDrawerContentDescRes;
            }
            this.setActionBarUpIndicator(mSlider, n2);
        }
    }
    
    void toggle() {
        final DrawerLayout mDrawerLayout = this.mDrawerLayout;
        final int n = 8388611;
        final int drawerLockMode = mDrawerLayout.getDrawerLockMode(n);
        if (this.mDrawerLayout.isDrawerVisible(n) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer(n);
        }
        else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer(n);
        }
    }
}
