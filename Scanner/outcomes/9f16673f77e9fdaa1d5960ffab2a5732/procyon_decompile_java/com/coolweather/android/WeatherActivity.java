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

public class WeatherActivity extends AppCompatActivity
{
    AlertDialog alertLocation;
    private TextView aqiText;
    private ImageView bingPicImg;
    private TextView carWashText;
    private TextView comfortText;
    private TextView degreeText;
    public String districtCode;
    public DrawerLayout drawerLayout;
    private LinearLayout forecastLayout;
    public LocationClient mLocationClient;
    private String mWeatherId;
    private Button navButton;
    private TextView pm25Text;
    private TextView positionText;
    private TextView sportText;
    public SwipeRefreshLayout swipeRefresh;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView weatherInfoText;
    private ScrollView weatherLayout;
    
    public WeatherActivity() {
        this.districtCode = null;
    }
    
    private String getDistrictCode(final BDLocation bdLocation) {
        Object o = bdLocation.getProvince();
        Object o2 = bdLocation.getCity();
        Object o3 = bdLocation.getDistrict();
        final String substring = ((String)o).substring(0, ((String)o).length() - 1);
        final String substring2 = ((String)o2).substring(0, ((String)o2).length() - 1);
        final String substring3 = ((String)o3).substring(0, ((String)o3).length() - 1);
        String s = null;
        Label_0838: {
            try {
                try {
                    final InputStreamReader inputStreamReader = new InputStreamReader(this.getAssets().open("districtcode.json"), "UTF-8");
                    final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        final StringBuilder sb = new StringBuilder();
                        while (true) {
                            final String line = bufferedReader.readLine();
                            if (line != null) {
                                final StringBuilder sb2 = sb;
                                try {
                                    sb2.append(line);
                                    continue;
                                }
                                catch (Exception ex) {
                                    s = null;
                                    break Label_0838;
                                }
                                break;
                            }
                            break;
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        try {
                            final JSONArray jsonArray = new JSONObject(sb.toString()).getJSONArray("zone");
                        Label_0770:
                            for (int i = 0; i < jsonArray.length(); ++i) {
                                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (jsonObject.getString("name").equals(substring)) {
                                    final JSONArray jsonArray2 = jsonObject.getJSONArray("zone");
                                    int n = 0;
                                    while (true) {
                                        s = null;
                                        try {
                                            String s6 = null;
                                            Label_0747: {
                                                if (n < jsonArray2.length()) {
                                                    final JSONObject jsonObject2 = jsonArray2.getJSONObject(n);
                                                    final String s2 = (String)o;
                                                    o = "name";
                                                    final JSONObject jsonObject3 = jsonObject2;
                                                    try {
                                                        o = jsonObject3.getString((String)o);
                                                        if (((String)o).equals(substring2)) {
                                                            o = "zone";
                                                            o = jsonObject2.getJSONArray((String)o);
                                                            int n2 = 0;
                                                            while (true) {
                                                                final String s3 = (String)o2;
                                                                try {
                                                                    Label_0522: {
                                                                        if (n2 < ((JSONArray)o).length()) {
                                                                            o2 = ((JSONArray)o).getJSONObject(n2);
                                                                            final String s4 = (String)o3;
                                                                            o3 = "name";
                                                                            final String s5 = (String)o2;
                                                                            try {
                                                                                o3 = ((JSONObject)s5).getString((String)o3);
                                                                                Label_0494: {
                                                                                    if (!((String)o3).equals(substring3)) {
                                                                                        break Label_0494;
                                                                                    }
                                                                                    o3 = new(java.lang.StringBuilder.class);
                                                                                    try {
                                                                                        new StringBuilder();
                                                                                        ((StringBuilder)o3).append("CN");
                                                                                        ((StringBuilder)o3).append(((JSONObject)o2).getString("code"));
                                                                                        o3 = (s6 = ((StringBuilder)o3).toString());
                                                                                        break Label_0522;
                                                                                        ++n2;
                                                                                        o2 = s3;
                                                                                        o3 = s4;
                                                                                    }
                                                                                    catch (Exception ex) {}
                                                                                }
                                                                            }
                                                                            catch (Exception ex2) {}
                                                                        }
                                                                        s6 = null;
                                                                    }
                                                                    if (s6 == null) {
                                                                        int n3 = 0;
                                                                        o2 = null;
                                                                        try {
                                                                            while (true) {
                                                                                Label_0655: {
                                                                                    if (n3 >= ((JSONArray)o).length()) {
                                                                                        break Label_0655;
                                                                                    }
                                                                                    o3 = ((JSONArray)o).getJSONObject(n3);
                                                                                    Label_0643: {
                                                                                        if (!((JSONObject)o3).getString("name").equals(substring2)) {
                                                                                            break Label_0643;
                                                                                        }
                                                                                        try {
                                                                                            final StringBuilder sb3 = new StringBuilder();
                                                                                            String string = s6;
                                                                                            s6 = "CN";
                                                                                            final StringBuilder sb4 = sb3;
                                                                                            Label_0658: {
                                                                                                try {
                                                                                                    sb4.append(s6);
                                                                                                    s6 = "code";
                                                                                                    s6 = ((JSONObject)o3).getString(s6);
                                                                                                    sb3.append(s6);
                                                                                                    s6 = (string = sb3.toString());
                                                                                                    break Label_0658;
                                                                                                }
                                                                                                catch (Exception ex) {
                                                                                                    s = string;
                                                                                                    break Label_0838;
                                                                                                }
                                                                                                ++n3;
                                                                                                continue;
                                                                                            }
                                                                                            s6 = string;
                                                                                            break;
                                                                                            string = s6;
                                                                                        }
                                                                                        catch (Exception ex) {
                                                                                            s = s6;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        catch (Exception ex3) {}
                                                                    }
                                                                    break Label_0747;
                                                                }
                                                                catch (Exception ex) {
                                                                    break Label_0838;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        ++n;
                                                        o = s2;
                                                        continue;
                                                    }
                                                    catch (Exception ex) {
                                                        break Label_0838;
                                                    }
                                                }
                                                s6 = null;
                                            }
                                            s = s6;
                                            break;
                                        }
                                        catch (Exception ex) {
                                            break Label_0838;
                                        }
                                        continue Label_0770;
                                    }
                                    return s;
                                }
                            }
                            s = null;
                        }
                        catch (Exception ex) {
                            s = null;
                        }
                    }
                    catch (Exception ex4) {}
                }
                catch (Exception ex5) {}
            }
            catch (Exception ex6) {}
        }
        final Exception ex;
        ex.printStackTrace();
        return s;
    }
    
    private void initLocation() {
        final LocationClientOption locOption = new LocationClientOption();
        locOption.setIsNeedAddress(true);
        this.mLocationClient.setLocOption(locOption);
    }
    
    private void loadBingPic() {
        HttpUtil.sendOkHttpRequest("http://guolin.tech/api/bing_pic", new WeatherActivity$4(this));
    }
    
    private void requestLocation() {
        this.initLocation();
        this.mLocationClient.start();
    }
    
    private void showWeatherInfo(final Weather weather) {
        final String cityName = weather.basic.cityName;
        final String text = weather.basic.update.updateTime.split(" ")[1];
        final StringBuilder sb = new StringBuilder();
        sb.append(weather.now.temperature);
        sb.append("\u2103");
        final String string = sb.toString();
        final String info = weather.now.more.info;
        this.titleCity.setText((CharSequence)cityName);
        this.titleUpdateTime.setText((CharSequence)text);
        this.degreeText.setText((CharSequence)string);
        this.weatherInfoText.setText((CharSequence)info);
        this.forecastLayout.removeAllViews();
        for (final Forecast forecast : weather.forecastList) {
            final View inflate = LayoutInflater.from((Context)this).inflate(2131296288, (ViewGroup)this.forecastLayout, false);
            final TextView textView = (TextView)inflate.findViewById(2131165223);
            final TextView textView2 = (TextView)inflate.findViewById(2131165242);
            final TextView textView3 = (TextView)inflate.findViewById(2131165248);
            final TextView textView4 = (TextView)inflate.findViewById(2131165251);
            textView.setText((CharSequence)forecast.date);
            textView2.setText((CharSequence)forecast.more.info);
            textView3.setText((CharSequence)forecast.temperature.max);
            textView4.setText((CharSequence)forecast.temperature.min);
            this.forecastLayout.addView(inflate);
        }
        if (weather.aqi != null) {
            this.aqiText.setText((CharSequence)weather.aqi.city.aqi);
            this.pm25Text.setText((CharSequence)weather.aqi.city.pm25);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("\u8212\u9002\u5ea6\uff1a");
        sb2.append(weather.suggestion.comfort.info);
        final String string2 = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("\u6d17\u8f66\u6307\u6570\uff1a");
        sb3.append(weather.suggestion.carWash.info);
        final String string3 = sb3.toString();
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("\u8fd0\u884c\u5efa\u8bae\uff1a");
        sb4.append(weather.suggestion.sport.info);
        final String string4 = sb4.toString();
        this.comfortText.setText((CharSequence)string2);
        this.carWashText.setText((CharSequence)string3);
        this.sportText.setText((CharSequence)string4);
        this.weatherLayout.setVisibility(0);
        this.startService(new Intent((Context)this, (Class)AutoUpdateService.class));
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (Build$VERSION.SDK_INT >= 21) {
            this.getWindow().getDecorView().setSystemUiVisibility(1280);
            this.getWindow().setStatusBarColor(0);
        }
        (this.mLocationClient = new LocationClient(this.getApplicationContext())).registerLocationListener(new WeatherActivity$MyLocationListener(this, (Context)this));
        this.setContentView(2131296284);
        this.positionText = (TextView)this.findViewById(2131165262);
        final ArrayList<String> list = new ArrayList<String>();
        if (ContextCompat.checkSelfPermission((Context)this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
        final boolean empty = list.isEmpty();
        final int n = 1;
        if (!empty) {
            ActivityCompat.requestPermissions(this, list.toArray(new String[list.size()]), n);
        }
        else {
            this.requestLocation();
        }
        this.bingPicImg = (ImageView)this.findViewById(2131165210);
        this.weatherLayout = (ScrollView)this.findViewById(2131165314);
        this.titleCity = (TextView)this.findViewById(2131165305);
        this.titleUpdateTime = (TextView)this.findViewById(2131165308);
        this.degreeText = (TextView)this.findViewById(2131165226);
        this.weatherInfoText = (TextView)this.findViewById(2131165313);
        this.forecastLayout = (LinearLayout)this.findViewById(2131165234);
        this.aqiText = (TextView)this.findViewById(2131165207);
        this.pm25Text = (TextView)this.findViewById(2131165261);
        this.comfortText = (TextView)this.findViewById(2131165219);
        this.carWashText = (TextView)this.findViewById(2131165214);
        this.sportText = (TextView)this.findViewById(2131165289);
        this.swipeRefresh = (SwipeRefreshLayout)this.findViewById(2131165296);
        final SwipeRefreshLayout swipeRefresh = this.swipeRefresh;
        final int[] colorSchemeResources = new int[n];
        colorSchemeResources[0] = 2130968616;
        swipeRefresh.setColorSchemeResources(colorSchemeResources);
        this.drawerLayout = (DrawerLayout)this.findViewById(2131165228);
        this.navButton = (Button)this.findViewById(2131165253);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this);
        final String string = defaultSharedPreferences.getString("weather", (String)null);
        if (string != null) {
            final Weather handleWeatherResponse = Utility.handleWeatherResponse(string);
            this.mWeatherId = handleWeatherResponse.basic.weatherId;
            this.showWeatherInfo(handleWeatherResponse);
        }
        else {
            this.mWeatherId = this.getIntent().getStringExtra("weather_id");
            this.weatherLayout.setVisibility(4);
            this.requestWeather(this.mWeatherId);
        }
        this.swipeRefresh.setOnRefreshListener(new WeatherActivity$1(this));
        this.navButton.setOnClickListener((View$OnClickListener)new WeatherActivity$2(this));
        final String string2 = defaultSharedPreferences.getString("bing_pic", (String)null);
        if (string2 != null) {
            Glide.with(this).load(string2).into(this.bingPicImg);
        }
        else {
            this.loadBingPic();
        }
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        if (n == 1) {
            if (array2.length > 0) {
                for (int length = array2.length, i = 0; i < length; ++i) {
                    if (array2[i] != 0) {
                        Toast.makeText((Context)this, (CharSequence)"\u5fc5\u987b\u540c\u610f\u6240\u6709\u6743\u9650\u624d\u80fd\u4f7f\u7528\u672c\u7a0b\u5e8f", 0).show();
                        this.finish();
                        return;
                    }
                }
                this.requestLocation();
            }
            else {
                Toast.makeText((Context)this, (CharSequence)"\u53d1\u751f\u672a\u77e5\u9519\u8bef", 0).show();
                this.finish();
            }
        }
    }
    
    public void requestWeather(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("http://guolin.tech/api/weather?cityid=");
        sb.append(s);
        sb.append("&key=c40f1cfbc5d4440194fd2edf7c3b3411");
        HttpUtil.sendOkHttpRequest(sb.toString(), new WeatherActivity$3(this));
        this.loadBingPic();
    }
}
