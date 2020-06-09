// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.IntentFilter;
import android.content.BroadcastReceiver;

final class AppCompatDelegateImplV14$AutoNightModeManager
{
    private BroadcastReceiver mAutoTimeChangeReceiver;
    private IntentFilter mAutoTimeChangeReceiverFilter;
    private boolean mIsNight;
    private TwilightManager mTwilightManager;
    final /* synthetic */ AppCompatDelegateImplV14 this$0;
    
    AppCompatDelegateImplV14$AutoNightModeManager(final AppCompatDelegateImplV14 this$0, final TwilightManager mTwilightManager) {
        this.this$0 = this$0;
        this.mTwilightManager = mTwilightManager;
        this.mIsNight = mTwilightManager.isNight();
    }
    
    final void cleanup() {
        if (this.mAutoTimeChangeReceiver != null) {
            this.this$0.mContext.unregisterReceiver(this.mAutoTimeChangeReceiver);
            this.mAutoTimeChangeReceiver = null;
        }
    }
    
    final void dispatchTimeChanged() {
        final boolean night = this.mTwilightManager.isNight();
        if (night != this.mIsNight) {
            this.mIsNight = night;
            this.this$0.applyDayNight();
        }
    }
    
    final int getApplyableNightMode() {
        this.mIsNight = this.mTwilightManager.isNight();
        int n;
        if (this.mIsNight) {
            n = 2;
        }
        else {
            n = 1;
        }
        return n;
    }
    
    final void setup() {
        this.cleanup();
        if (this.mAutoTimeChangeReceiver == null) {
            this.mAutoTimeChangeReceiver = new AppCompatDelegateImplV14$AutoNightModeManager$1(this);
        }
        if (this.mAutoTimeChangeReceiverFilter == null) {
            (this.mAutoTimeChangeReceiverFilter = new IntentFilter()).addAction("android.intent.action.TIME_SET");
            this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
        }
        this.this$0.mContext.registerReceiver(this.mAutoTimeChangeReceiver, this.mAutoTimeChangeReceiverFilter);
    }
}
