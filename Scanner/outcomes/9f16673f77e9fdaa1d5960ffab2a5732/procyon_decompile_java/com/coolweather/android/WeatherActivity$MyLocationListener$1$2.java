// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

class WeatherActivity$MyLocationListener$1$2 implements DialogInterface$OnClickListener
{
    final /* synthetic */ WeatherActivity$MyLocationListener$1 this$2;
    
    WeatherActivity$MyLocationListener$1$2(final WeatherActivity$MyLocationListener$1 this$2) {
        this.this$2 = this$2;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        if (this.this$2.this$1.this$0.districtCode != null) {
            this.this$2.this$1.this$0.requestWeather(this.this$2.this$1.this$0.districtCode);
        }
    }
}
