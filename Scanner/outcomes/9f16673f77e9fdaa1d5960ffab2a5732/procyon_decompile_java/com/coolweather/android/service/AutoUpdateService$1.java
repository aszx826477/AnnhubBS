// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.service;

import android.content.SharedPreferences$Editor;
import com.coolweather.android.gson.Weather;
import android.content.Context;
import android.preference.PreferenceManager;
import com.coolweather.android.util.Utility;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class AutoUpdateService$1 implements Callback
{
    final /* synthetic */ AutoUpdateService this$0;
    
    AutoUpdateService$1(final AutoUpdateService this$0) {
        this.this$0 = this$0;
    }
    
    public void onFailure(final Call call, final IOException ex) {
        ex.printStackTrace();
    }
    
    public void onResponse(final Call call, final Response response) {
        final String string = response.body().string();
        final Weather handleWeatherResponse = Utility.handleWeatherResponse(string);
        if (handleWeatherResponse != null && "ok".equals(handleWeatherResponse.status)) {
            final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences((Context)this.this$0).edit();
            edit.putString("weather", string);
            edit.apply();
        }
    }
}
