// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import com.coolweather.android.util.Utility;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class WeatherActivity$3 implements Callback
{
    final /* synthetic */ WeatherActivity this$0;
    
    WeatherActivity$3(final WeatherActivity this$0) {
        this.this$0 = this$0;
    }
    
    public void onFailure(final Call call, final IOException ex) {
        ex.printStackTrace();
        this.this$0.runOnUiThread((Runnable)new WeatherActivity$3$2(this));
    }
    
    public void onResponse(final Call call, final Response response) {
        final String string = response.body().string();
        this.this$0.runOnUiThread((Runnable)new WeatherActivity$3$1(this, Utility.handleWeatherResponse(string), string));
    }
}
