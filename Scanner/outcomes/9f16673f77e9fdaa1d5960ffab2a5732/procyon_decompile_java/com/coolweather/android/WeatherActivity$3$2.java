// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.content.Context;
import android.widget.Toast;

class WeatherActivity$3$2 implements Runnable
{
    final /* synthetic */ WeatherActivity$3 this$1;
    
    WeatherActivity$3$2(final WeatherActivity$3 this$1) {
        this.this$1 = this$1;
    }
    
    public void run() {
        Toast.makeText((Context)this.this$1.this$0, (CharSequence)"\u83b7\u53d6\u5929\u6c14\u4fe1\u606f\u5931\u8d25", 0).show();
        this.this$1.this$0.swipeRefresh.setRefreshing(false);
    }
}
