// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Window$Callback;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.content.res.Configuration;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.ComponentName;
import android.app.Activity;
import android.view.Window;
import android.content.Context;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11
{
    private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private boolean mApplyDayNightCalled;
    private AppCompatDelegateImplV14$AutoNightModeManager mAutoNightModeManager;
    private boolean mHandleNativeActionModes;
    private int mLocalNightMode;
    
    AppCompatDelegateImplV14(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.mLocalNightMode = -100;
        this.mHandleNativeActionModes = true;
    }
    
    private void ensureAutoNightModeManager() {
        if (this.mAutoNightModeManager == null) {
            this.mAutoNightModeManager = new AppCompatDelegateImplV14$AutoNightModeManager(this, TwilightManager.getInstance(this.mContext));
        }
    }
    
    private int getNightMode() {
        int n = this.mLocalNightMode;
        if (n == -100) {
            n = AppCompatDelegate.getDefaultNightMode();
        }
        return n;
    }
    
    private boolean shouldRecreateOnNightModeChange() {
        final boolean mApplyDayNightCalled = this.mApplyDayNightCalled;
        boolean b = false;
        if (mApplyDayNightCalled && this.mContext instanceof Activity) {
            final PackageManager packageManager = this.mContext.getPackageManager();
            final boolean b2 = true;
            try {
                try {
                    final Context mContext = this.mContext;
                    try {
                        final Context mContext2 = this.mContext;
                        try {
                            final ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(mContext, (Class)mContext2.getClass()), 0);
                            try {
                                if ((activityInfo.configChanges & 0x200) == 0x0) {
                                    b = true;
                                }
                                return b;
                            }
                            catch (PackageManager$NameNotFoundException ex) {
                                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", (Throwable)ex);
                                return b2;
                            }
                        }
                        catch (PackageManager$NameNotFoundException ex2) {}
                    }
                    catch (PackageManager$NameNotFoundException ex3) {}
                }
                catch (PackageManager$NameNotFoundException ex4) {}
            }
            catch (PackageManager$NameNotFoundException ex5) {}
        }
        return false;
    }
    
    private boolean updateForNightMode(final int n) {
        final Resources resources = this.mContext.getResources();
        final Configuration configuration = resources.getConfiguration();
        final int n2 = configuration.uiMode & 0x30;
        int n3;
        if (n == 2) {
            n3 = 32;
        }
        else {
            n3 = 16;
        }
        if (n2 != n3) {
            if (this.shouldRecreateOnNightModeChange()) {
                ((Activity)this.mContext).recreate();
            }
            else {
                final Configuration configuration2 = new Configuration(configuration);
                final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration2.uiMode = ((configuration2.uiMode & 0xFFFFFFCF) | n3);
                resources.updateConfiguration(configuration2, displayMetrics);
                ResourcesFlusher.flush(resources);
            }
            return true;
        }
        return false;
    }
    
    public boolean applyDayNight() {
        boolean updateForNightMode = false;
        final int nightMode = this.getNightMode();
        final int mapNightMode = this.mapNightMode(nightMode);
        if (mapNightMode != -1) {
            updateForNightMode = this.updateForNightMode(mapNightMode);
        }
        if (nightMode == 0) {
            this.ensureAutoNightModeManager();
            this.mAutoNightModeManager.setup();
        }
        this.mApplyDayNightCalled = true;
        return updateForNightMode;
    }
    
    final AppCompatDelegateImplV14$AutoNightModeManager getAutoNightModeManager() {
        this.ensureAutoNightModeManager();
        return this.mAutoNightModeManager;
    }
    
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }
    
    int mapNightMode(final int n) {
        if (n == -100) {
            return -1;
        }
        if (n != 0) {
            return n;
        }
        this.ensureAutoNightModeManager();
        return this.mAutoNightModeManager.getApplyableNightMode();
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            final int mLocalNightMode = this.mLocalNightMode;
            final int n = -100;
            if (mLocalNightMode == n) {
                this.mLocalNightMode = bundle.getInt("appcompat:local_night_mode", n);
            }
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        final AppCompatDelegateImplV14$AutoNightModeManager mAutoNightModeManager = this.mAutoNightModeManager;
        if (mAutoNightModeManager != null) {
            mAutoNightModeManager.cleanup();
        }
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final int mLocalNightMode = this.mLocalNightMode;
        if (mLocalNightMode != -100) {
            bundle.putInt("appcompat:local_night_mode", mLocalNightMode);
        }
    }
    
    public void onStart() {
        super.onStart();
        this.applyDayNight();
    }
    
    public void onStop() {
        super.onStop();
        final AppCompatDelegateImplV14$AutoNightModeManager mAutoNightModeManager = this.mAutoNightModeManager;
        if (mAutoNightModeManager != null) {
            mAutoNightModeManager.cleanup();
        }
    }
    
    public void setHandleNativeActionModesEnabled(final boolean mHandleNativeActionModes) {
        this.mHandleNativeActionModes = mHandleNativeActionModes;
    }
    
    public void setLocalNightMode(final int mLocalNightMode) {
        switch (mLocalNightMode) {
            default: {
                Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                break;
            }
            case -1:
            case 0:
            case 1:
            case 2: {
                if (this.mLocalNightMode == mLocalNightMode) {
                    break;
                }
                this.mLocalNightMode = mLocalNightMode;
                if (this.mApplyDayNightCalled) {
                    this.applyDayNight();
                    break;
                }
                break;
            }
        }
    }
    
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatDelegateImplV14$AppCompatWindowCallbackV14(this, window$Callback);
    }
}
