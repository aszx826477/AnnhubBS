// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.MenuItem;
import android.view.View;
import android.content.res.Configuration;
import android.support.v4.content.ContextCompat;
import android.content.Context;
import android.os.Build$VERSION;
import android.support.v4.widget.DrawerLayout;
import android.graphics.drawable.Drawable;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout$DrawerListener;

public class ActionBarDrawerToggle implements DrawerLayout$DrawerListener
{
    private static final int ID_HOME = 16908332;
    private static final ActionBarDrawerToggle$ActionBarDrawerToggleImpl IMPL;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private ActionBarDrawerToggle$SlideDrawable mSlider;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 18) {
            IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2();
        }
        else if (sdk_INT >= 11) {
            IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplHC();
        }
        else {
            IMPL = new ActionBarDrawerToggle$ActionBarDrawerToggleImplBase();
        }
    }
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, final int n, final int n2, final int n3) {
        this(activity, drawerLayout, assumeMaterial((Context)activity) ^ true, n, n2, n3);
    }
    
    public ActionBarDrawerToggle(final Activity mActivity, final DrawerLayout mDrawerLayout, final boolean b, final int mDrawerImageResource, final int mOpenDrawerContentDescRes, final int mCloseDrawerContentDescRes) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = mActivity;
        if (mActivity instanceof ActionBarDrawerToggle$DelegateProvider) {
            this.mActivityImpl = ((ActionBarDrawerToggle$DelegateProvider)mActivity).getDrawerToggleDelegate();
        }
        else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = mDrawerLayout;
        this.mDrawerImageResource = mDrawerImageResource;
        this.mOpenDrawerContentDescRes = mOpenDrawerContentDescRes;
        this.mCloseDrawerContentDescRes = mCloseDrawerContentDescRes;
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable((Context)mActivity, mDrawerImageResource);
        this.mSlider = new ActionBarDrawerToggle$SlideDrawable(this, this.mDrawerImage);
        final ActionBarDrawerToggle$SlideDrawable mSlider = this.mSlider;
        float offset;
        if (b) {
            offset = 0.33333334f;
        }
        else {
            offset = 0.0f;
        }
        mSlider.setOffset(offset);
    }
    
    private static boolean assumeMaterial(final Context context) {
        final int targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        final int n = 21;
        return targetSdkVersion >= n && Build$VERSION.SDK_INT >= n;
    }
    
    Drawable getThemeUpIndicator() {
        final ActionBarDrawerToggle$Delegate mActivityImpl = this.mActivityImpl;
        if (mActivityImpl != null) {
            return mActivityImpl.getThemeUpIndicator();
        }
        return ActionBarDrawerToggle.IMPL.getThemeUpIndicator(this.mActivity);
    }
    
    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable((Context)this.mActivity, this.mDrawerImageResource);
        this.syncState();
    }
    
    public void onDrawerClosed(final View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }
    
    public void onDrawerOpened(final View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }
    
    public void onDrawerSlide(final View view, final float n) {
        final float position = this.mSlider.getPosition();
        final float n2 = 2.0f;
        final float n3 = 0.5f;
        float position2;
        if (n > n3) {
            position2 = Math.max(position, Math.max(0.0f, n - n3) * n2);
        }
        else {
            position2 = Math.min(position, n2 * n);
        }
        this.mSlider.setPosition(position2);
    }
    
    public void onDrawerStateChanged(final int n) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            final DrawerLayout mDrawerLayout = this.mDrawerLayout;
            final int n = 8388611;
            if (mDrawerLayout.isDrawerVisible(n)) {
                this.mDrawerLayout.closeDrawer(n);
            }
            else {
                this.mDrawerLayout.openDrawer(n);
            }
            return true;
        }
        return false;
    }
    
    void setActionBarDescription(final int actionBarDescription) {
        final ActionBarDrawerToggle$Delegate mActivityImpl = this.mActivityImpl;
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarDescription(actionBarDescription);
            return;
        }
        this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, actionBarDescription);
    }
    
    void setActionBarUpIndicator(final Drawable drawable, final int n) {
        final ActionBarDrawerToggle$Delegate mActivityImpl = this.mActivityImpl;
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarUpIndicator(drawable, n);
            return;
        }
        this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable, n);
    }
    
    public void setDrawerIndicatorEnabled(final boolean mDrawerIndicatorEnabled) {
        if (mDrawerIndicatorEnabled != this.mDrawerIndicatorEnabled) {
            if (mDrawerIndicatorEnabled) {
                final ActionBarDrawerToggle$SlideDrawable mSlider = this.mSlider;
                int n;
                if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                    n = this.mCloseDrawerContentDescRes;
                }
                else {
                    n = this.mOpenDrawerContentDescRes;
                }
                this.setActionBarUpIndicator((Drawable)mSlider, n);
            }
            else {
                this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = mDrawerIndicatorEnabled;
        }
    }
    
    public void setHomeAsUpIndicator(final int n) {
        Drawable drawable = null;
        if (n != 0) {
            drawable = ContextCompat.getDrawable((Context)this.mActivity, n);
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
    
    public void syncState() {
        final DrawerLayout mDrawerLayout = this.mDrawerLayout;
        final int n = 8388611;
        if (mDrawerLayout.isDrawerOpen(n)) {
            this.mSlider.setPosition(1.0f);
        }
        else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            final ActionBarDrawerToggle$SlideDrawable mSlider = this.mSlider;
            int n2;
            if (this.mDrawerLayout.isDrawerOpen(n)) {
                n2 = this.mCloseDrawerContentDescRes;
            }
            else {
                n2 = this.mOpenDrawerContentDescRes;
            }
            this.setActionBarUpIndicator((Drawable)mSlider, n2);
        }
    }
}
