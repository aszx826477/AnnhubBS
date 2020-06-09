// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.service;

import android.content.SharedPreferences$Editor;
import android.content.Context;
import android.preference.PreferenceManager;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class AutoUpdateService$2 implements Callback
{
    final /* synthetic */ AutoUpdateService this$0;
    
    AutoUpdateService$2(final AutoUpdateService this$0) {
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
    }
}
