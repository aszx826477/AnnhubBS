// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.widget.Toast;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.Glide;
import android.view.View$OnClickListener;
import android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener;
import com.coolweather.android.util.Utility;
import android.preference.PreferenceManager;
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
import android.content.Context;
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
import com.coolweather.android.gson.Weather;
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
import android.content.DialogInterface$OnClickListener;
import android.support.v7.app.AlertDialog$Builder;
import com.baidu.location.BDLocation;

class WeatherActivity$MyLocationListener$1 implements Runnable
{
    final /* synthetic */ WeatherActivity$MyLocationListener this$1;
    final /* synthetic */ BDLocation val$location;
    
    WeatherActivity$MyLocationListener$1(final WeatherActivity$MyLocationListener this$1, final BDLocation val$location) {
        this.this$1 = this$1;
        this.val$location = val$location;
    }
    
    public void run() {
        final StringBuilder text = new StringBuilder();
        text.append("\u7eac\u5ea6\uff1a");
        text.append(this.val$location.getLatitude());
        text.append("\n");
        text.append("\u7ecf\u5ea6\uff1a");
        text.append(this.val$location.getLongitude());
        text.append("\n");
        text.append("\u56fd\u5bb6\uff1a");
        text.append(this.val$location.getCountry());
        text.append("\n");
        text.append("\u7701\uff1a");
        text.append(this.val$location.getProvince());
        text.append("\n");
        text.append("\u5e02\uff1a");
        text.append(this.val$location.getCity());
        text.append("\n");
        text.append("\u533a\uff1a");
        text.append(this.val$location.getDistrict());
        text.append("\n");
        text.append("\u8857\u9053\uff1a");
        text.append(this.val$location.getStreet());
        text.append("\n");
        text.append("\u5b9a\u4f4d\u65b9\u5f0f\uff1a");
        if (this.val$location.getLocType() == 61) {
            text.append("GPS\n");
        }
        else if (this.val$location.getLocType() == 161) {
            text.append("\u7f51\u7edc\n");
        }
        this.this$1.this$0.districtCode = this.this$1.this$0.getDistrictCode(this.val$location);
        text.append("\u5730\u533a\u4ee3\u7801\uff1a");
        text.append(this.this$1.this$0.districtCode);
        this.this$1.this$0.positionText.setText((CharSequence)text);
        final WeatherActivity this$0 = this.this$1.this$0;
        final AlertDialog$Builder setTitle = new AlertDialog$Builder(this.this$1.context).setTitle("\u5c0f\u8d34\u58eb");
        final StringBuilder sb = new StringBuilder();
        sb.append("\u5b9a\u4f4d\u5230\u60a8\u76ee\u524d\u5728");
        sb.append(this.val$location.getProvince());
        sb.append(this.val$location.getCity());
        sb.append(this.val$location.getDistrict());
        sb.append("\uff0c\u662f\u5426\u9700\u8981\u5207\u6362\u5230\u8be5\u5730\uff1f");
        this$0.alertLocation = setTitle.setMessage(sb.toString()).setPositiveButton("\u786e\u5b9a", (DialogInterface$OnClickListener)new WeatherActivity$MyLocationListener$1$2(this)).setNegativeButton("\u53d6\u6d88", (DialogInterface$OnClickListener)new WeatherActivity$MyLocationListener$1$1(this)).create();
        this.this$1.this$0.alertLocation.setCancelable(false);
        this.this$1.this$0.alertLocation.show();
    }
}
