// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.content.SharedPreferences$Editor;
import android.content.Context;
import android.preference.PreferenceManager;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class WeatherActivity$4 implements Callback
{
    final /* synthetic */ WeatherActivity this$0;
    
    WeatherActivity$4(final WeatherActivity this$0) {
        this.this$0 = this$0;
    }
    
    public void onFailure(final Call call, final IOException ex) {
        ex.printStackTrace();
    }
    
    public void onResponse(final Call call, final Response response) {
        final String string = response.body().string();
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences((Context)this.this$0).edit();
        edit.putString("bing_pic", string);
        edit.apply();
        this.this$0.runOnUiThread((Runnable)new WeatherActivity$4$1(this, string));
    }
}
