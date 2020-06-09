// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.util;

import com.google.gson.Gson;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.db.Province;
import com.coolweather.android.db.County;
import org.json.JSONObject;
import org.json.JSONException;
import com.coolweather.android.db.City;
import org.json.JSONArray;
import android.text.TextUtils;

public class Utility
{
    public static boolean handleCityResponse(final String s, final int provinceId) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                final JSONArray jsonArray = new JSONArray(s);
                int n = 0;
                while (true) {
                    if (n >= jsonArray.length()) {
                        return true;
                    }
                    final JSONObject jsonObject = jsonArray.getJSONObject(n);
                    try {
                        try {
                            final City city = new City();
                            city.setCityName(jsonObject.getString("name"));
                            city.setCityCode(jsonObject.getInt("id"));
                            final City city2 = city;
                            try {
                                city2.setProvinceId(provinceId);
                                city.save();
                                ++n;
                                continue;
                            }
                            catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                        catch (JSONException ex2) {}
                    }
                    catch (JSONException ex3) {}
                }
            }
            catch (JSONException ex4) {}
        }
        return false;
    }
    
    public static boolean handleCountyResponse(final String s, final int cityId) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                final JSONArray jsonArray = new JSONArray(s);
                int n = 0;
                while (true) {
                    if (n >= jsonArray.length()) {
                        return true;
                    }
                    final JSONObject jsonObject = jsonArray.getJSONObject(n);
                    try {
                        try {
                            final County county = new County();
                            county.setCountyName(jsonObject.getString("name"));
                            county.setWeatherId(jsonObject.getString("weather_id"));
                            final County county2 = county;
                            try {
                                county2.setCityId(cityId);
                                county.save();
                                ++n;
                                continue;
                            }
                            catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                        catch (JSONException ex2) {}
                    }
                    catch (JSONException ex3) {}
                }
            }
            catch (JSONException ex4) {}
        }
        return false;
    }
    
    public static boolean handleProvinceResponse(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                final JSONArray jsonArray = new JSONArray(s);
                int n = 0;
                while (true) {
                    if (n >= jsonArray.length()) {
                        return true;
                    }
                    final JSONObject jsonObject = jsonArray.getJSONObject(n);
                    try {
                        try {
                            final Province province = new Province();
                            province.setProvinceName(jsonObject.getString("name"));
                            province.setProvinceCode(jsonObject.getInt("id"));
                            province.save();
                            ++n;
                            continue;
                        }
                        catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                    catch (JSONException ex2) {}
                }
            }
            catch (JSONException ex3) {}
        }
        return false;
    }
    
    public static Weather handleWeatherResponse(final String s) {
        try {
            final JSONObject jsonObject = new JSONObject(s).getJSONArray("HeWeather").getJSONObject(0);
            try {
                final String string = jsonObject.toString();
                try {
                    try {
                        final Object fromJson = new Gson().fromJson(string, Weather.class);
                        try {
                            return (Weather)fromJson;
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                            return null;
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
    }
}
