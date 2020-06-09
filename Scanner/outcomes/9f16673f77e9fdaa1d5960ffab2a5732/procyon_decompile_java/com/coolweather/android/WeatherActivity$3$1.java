// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.Glide;
import android.view.View$OnClickListener;
import android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener;
import com.coolweather.android.util.Utility;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import com.baidu.location.BDLocationListener;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import android.content.Intent;
import com.coolweather.android.service.AutoUpdateService;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.coolweather.android.gson.Forecast;
import okhttp3.Callback;
import com.coolweather.android.util.HttpUtil;
import com.baidu.location.LocationClientOption;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.baidu.location.BDLocation;
import android.widget.ScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Button;
import com.baidu.location.LocationClient;
import android.widget.LinearLayout;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences$Editor;
import android.widget.Toast;
import android.content.Context;
import android.preference.PreferenceManager;
import com.coolweather.android.gson.Weather;

class WeatherActivity$3$1 implements Runnable
{
    final /* synthetic */ WeatherActivity$3 this$1;
    final /* synthetic */ String val$responseText;
    final /* synthetic */ Weather val$weather;
    
    WeatherActivity$3$1(final WeatherActivity$3 this$1, final Weather val$weather, final String val$responseText) {
        this.this$1 = this$1;
        this.val$weather = val$weather;
        this.val$responseText = val$responseText;
    }
    
    public void run() {
        final Weather val$weather = this.val$weather;
        if (val$weather != null && "ok".equals(val$weather.status)) {
            final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences((Context)this.this$1.this$0).edit();
            edit.putString("weather", this.val$responseText);
            edit.apply();
            this.this$1.this$0.mWeatherId = this.val$weather.basic.weatherId;
            this.this$1.this$0.showWeatherInfo(this.val$weather);
        }
        else {
            Toast.makeText((Context)this.this$1.this$0, (CharSequence)"\u83b7\u53d6\u5929\u6c14\u4fe1\u606f\u5931\u8d25", 0).show();
        }
        this.this$1.this$0.swipeRefresh.setRefreshing(false);
    }
}
