// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.service;

import android.app.PendingIntent;
import android.os.SystemClock;
import android.app.AlarmManager;
import android.os.IBinder;
import android.content.Intent;
import com.coolweather.android.util.Utility;
import android.content.Context;
import android.preference.PreferenceManager;
import okhttp3.Callback;
import com.coolweather.android.util.HttpUtil;
import android.app.Service;

public class AutoUpdateService extends Service
{
    private void updateBingPic() {
        HttpUtil.sendOkHttpRequest("http://guolin.tech/api/bing_pic", new AutoUpdateService$2(this));
    }
    
    private void updateWeather() {
        final String string = PreferenceManager.getDefaultSharedPreferences((Context)this).getString("weather", (String)null);
        if (string != null) {
            final String weatherId = Utility.handleWeatherResponse(string).basic.weatherId;
            final StringBuilder sb = new StringBuilder();
            sb.append("http://guolin.tech/api/weather?cityid=");
            sb.append(weatherId);
            sb.append("&key=bc0418b57b2d4918819d3974ac1285d9");
            HttpUtil.sendOkHttpRequest(sb.toString(), new AutoUpdateService$1(this));
        }
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        this.updateWeather();
        this.updateBingPic();
        final AlarmManager alarmManager = (AlarmManager)this.getSystemService("alarm");
        final long n3 = SystemClock.elapsedRealtime() + 28800000;
        final PendingIntent service = PendingIntent.getService((Context)this, 0, new Intent((Context)this, (Class)AutoUpdateService.class), 0);
        alarmManager.cancel(service);
        alarmManager.set(2, n3, service);
        return super.onStartCommand(intent, n, n2);
    }
}
