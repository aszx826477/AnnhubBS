// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import java.util.Calendar;
import android.util.Log;
import android.support.v4.content.PermissionChecker;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;

class TwilightManager
{
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightManager$TwilightState mTwilightState;
    
    TwilightManager(final Context mContext, final LocationManager mLocationManager) {
        this.mTwilightState = new TwilightManager$TwilightState();
        this.mContext = mContext;
        this.mLocationManager = mLocationManager;
    }
    
    static TwilightManager getInstance(Context applicationContext) {
        if (TwilightManager.sInstance == null) {
            applicationContext = applicationContext.getApplicationContext();
            TwilightManager.sInstance = new TwilightManager(applicationContext, (LocationManager)applicationContext.getSystemService("location"));
        }
        return TwilightManager.sInstance;
    }
    
    private Location getLastKnownLocation() {
        Location lastKnownLocationForProvider = null;
        Location lastKnownLocationForProvider2 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            lastKnownLocationForProvider = this.getLastKnownLocationForProvider("network");
        }
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            lastKnownLocationForProvider2 = this.getLastKnownLocationForProvider("gps");
        }
        if (lastKnownLocationForProvider2 != null && lastKnownLocationForProvider != null) {
            Location location;
            if (lastKnownLocationForProvider2.getTime() > lastKnownLocationForProvider.getTime()) {
                location = lastKnownLocationForProvider2;
            }
            else {
                location = lastKnownLocationForProvider;
            }
            return location;
        }
        Location location2;
        if (lastKnownLocationForProvider2 != null) {
            location2 = lastKnownLocationForProvider2;
        }
        else {
            location2 = lastKnownLocationForProvider;
        }
        return location2;
    }
    
    private Location getLastKnownLocationForProvider(final String s) {
        final LocationManager mLocationManager = this.mLocationManager;
        if (mLocationManager != null) {
            final LocationManager locationManager = mLocationManager;
            try {
                if (locationManager.isProviderEnabled(s)) {
                    return this.mLocationManager.getLastKnownLocation(s);
                }
            }
            catch (Exception ex) {
                Log.d("TwilightManager", "Failed to get last known location", (Throwable)ex);
            }
        }
        return null;
    }
    
    private boolean isStateValid() {
        final TwilightManager$TwilightState mTwilightState = this.mTwilightState;
        return mTwilightState != null && mTwilightState.nextUpdate > System.currentTimeMillis();
    }
    
    static void setInstance(final TwilightManager sInstance) {
        TwilightManager.sInstance = sInstance;
    }
    
    private void updateState(final Location location) {
        final TwilightManager$TwilightState mTwilightState = this.mTwilightState;
        final long currentTimeMillis = System.currentTimeMillis();
        final TwilightCalculator instance = TwilightCalculator.getInstance();
        final long n = 86400000L;
        instance.calculateTwilight(currentTimeMillis - n, location.getLatitude(), location.getLongitude());
        final long sunset = instance.sunset;
        instance.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        final int state = instance.state;
        boolean b = true;
        if (state != (b ? 1 : 0)) {
            b = false;
        }
        final long sunrise = instance.sunrise;
        final long sunset2 = instance.sunset;
        final int n2 = (int)(n + currentTimeMillis);
        final double latitude = location.getLatitude();
        final double longitude = location.getLongitude();
        final long yesterdaySunset = sunset;
        final long todaySunset = sunset2;
        final int n3 = n2;
        final long todaySunrise = sunrise;
        final boolean isNight = b;
        instance.calculateTwilight(n3, latitude, longitude);
        final long sunrise2 = instance.sunrise;
        final long n4 = 0L;
        final long n5 = -1;
        long nextUpdate;
        if (sunrise != n5 && todaySunset != n5) {
            int n6;
            if (currentTimeMillis > todaySunset) {
                n6 = (int)(n4 + sunrise2);
            }
            else if (currentTimeMillis > sunrise) {
                n6 = (int)(n4 + todaySunset);
            }
            else {
                n6 = (int)(n4 + sunrise);
            }
            nextUpdate = n6 + 60000L;
        }
        else {
            nextUpdate = currentTimeMillis + 43200000L;
        }
        mTwilightState.isNight = isNight;
        mTwilightState.yesterdaySunset = yesterdaySunset;
        mTwilightState.todaySunrise = todaySunrise;
        mTwilightState.todaySunset = todaySunset;
        mTwilightState.tomorrowSunrise = sunrise2;
        mTwilightState.nextUpdate = nextUpdate;
    }
    
    boolean isNight() {
        final TwilightManager$TwilightState mTwilightState = this.mTwilightState;
        if (this.isStateValid()) {
            return mTwilightState.isNight;
        }
        final Location lastKnownLocation = this.getLastKnownLocation();
        if (lastKnownLocation != null) {
            this.updateState(lastKnownLocation);
            return mTwilightState.isNight;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        final int value = Calendar.getInstance().get(11);
        return value < 6 || value >= 22;
    }
}
