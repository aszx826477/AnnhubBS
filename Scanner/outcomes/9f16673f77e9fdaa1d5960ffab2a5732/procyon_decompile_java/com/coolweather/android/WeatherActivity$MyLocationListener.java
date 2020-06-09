// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import com.baidu.location.BDLocation;
import android.content.Context;
import com.baidu.location.BDLocationListener;

public class WeatherActivity$MyLocationListener implements BDLocationListener
{
    Context context;
    final /* synthetic */ WeatherActivity this$0;
    
    public WeatherActivity$MyLocationListener(final WeatherActivity this$0, final Context context) {
        this.this$0 = this$0;
        this.context = context;
    }
    
    public void onReceiveLocation(final BDLocation bdLocation) {
        this.this$0.runOnUiThread((Runnable)new WeatherActivity$MyLocationListener$1(this, bdLocation));
    }
}
