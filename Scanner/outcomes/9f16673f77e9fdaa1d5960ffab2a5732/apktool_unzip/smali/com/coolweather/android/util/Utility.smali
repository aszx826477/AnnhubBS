.class public Lcom/coolweather/android/util/Utility;
.super Ljava/lang/Object;
.source "Utility.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static handleCityResponse(Ljava/lang/String;I)Z
    .locals 6
    .param p0, "response"    # Ljava/lang/String;
    .param p1, "provinceId"    # I

    .line 43
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 45
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 46
    .local v0, "allCities":Lorg/json/JSONArray;
    nop

    move v2, v1

    .local v2, "i":I
    :goto_0
    nop

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    nop

    if-ge v2, v3, :cond_0

    .line 47
    nop

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    nop

    .line 48
    .local v3, "cityObject":Lorg/json/JSONObject;
    nop

    new-instance v4, Lcom/coolweather/android/db/City;

    nop

    invoke-direct {v4}, Lcom/coolweather/android/db/City;-><init>()V

    nop

    .line 49
    .local v4, "city":Lcom/coolweather/android/db/City;
    nop

    const-string v5, "name"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/City;->setCityName(Ljava/lang/String;)V

    .line 50
    nop

    const-string v5, "id"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/City;->setCityCode(I)V

    .line 51
    nop

    invoke-virtual {v4, p1}, Lcom/coolweather/android/db/City;->setProvinceId(I)V

    .line 52
    nop

    invoke-virtual {v4}, Lcom/coolweather/android/db/City;->save()Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    nop

    .end local v3    # "cityObject":Lorg/json/JSONObject;
    .end local v4    # "city":Lcom/coolweather/android/db/City;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    nop

    .line 54
    .end local v2    # "i":I
    nop

    const/4 v1, 0x1

    return v1

    .line 55
    .end local v0    # "allCities":Lorg/json/JSONArray;
    :catch_0
    move-exception v0

    nop

    .line 56
    .local v0, "e":Lorg/json/JSONException;
    nop

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 43
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    nop

    .line 59
    :goto_1
    nop

    return v1
.end method

.method public static handleCountyResponse(Ljava/lang/String;I)Z
    .locals 6
    .param p0, "response"    # Ljava/lang/String;
    .param p1, "cityId"    # I

    .line 66
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 68
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 69
    .local v0, "allCounties":Lorg/json/JSONArray;
    nop

    move v2, v1

    .local v2, "i":I
    :goto_0
    nop

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    nop

    if-ge v2, v3, :cond_0

    .line 70
    nop

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    nop

    .line 71
    .local v3, "countyObject":Lorg/json/JSONObject;
    nop

    new-instance v4, Lcom/coolweather/android/db/County;

    nop

    invoke-direct {v4}, Lcom/coolweather/android/db/County;-><init>()V

    nop

    .line 72
    .local v4, "county":Lcom/coolweather/android/db/County;
    nop

    const-string v5, "name"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/County;->setCountyName(Ljava/lang/String;)V

    .line 73
    nop

    const-string v5, "weather_id"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/County;->setWeatherId(Ljava/lang/String;)V

    .line 74
    nop

    invoke-virtual {v4, p1}, Lcom/coolweather/android/db/County;->setCityId(I)V

    .line 75
    nop

    invoke-virtual {v4}, Lcom/coolweather/android/db/County;->save()Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    nop

    .end local v3    # "countyObject":Lorg/json/JSONObject;
    .end local v4    # "county":Lcom/coolweather/android/db/County;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    nop

    .line 77
    .end local v2    # "i":I
    nop

    const/4 v1, 0x1

    return v1

    .line 78
    .end local v0    # "allCounties":Lorg/json/JSONArray;
    :catch_0
    move-exception v0

    nop

    .line 79
    .local v0, "e":Lorg/json/JSONException;
    nop

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 66
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    nop

    .line 82
    :goto_1
    nop

    return v1
.end method

.method public static handleProvinceResponse(Ljava/lang/String;)Z
    .locals 6
    .param p0, "response"    # Ljava/lang/String;

    .line 21
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 23
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 24
    .local v0, "allProvinces":Lorg/json/JSONArray;
    nop

    move v2, v1

    .local v2, "i":I
    :goto_0
    nop

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    nop

    if-ge v2, v3, :cond_0

    .line 25
    nop

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    nop

    .line 26
    .local v3, "provinceObject":Lorg/json/JSONObject;
    nop

    new-instance v4, Lcom/coolweather/android/db/Province;

    nop

    invoke-direct {v4}, Lcom/coolweather/android/db/Province;-><init>()V

    nop

    .line 27
    .local v4, "province":Lcom/coolweather/android/db/Province;
    nop

    const-string v5, "name"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/Province;->setProvinceName(Ljava/lang/String;)V

    .line 28
    nop

    const-string v5, "id"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    nop

    invoke-virtual {v4, v5}, Lcom/coolweather/android/db/Province;->setProvinceCode(I)V

    .line 29
    nop

    invoke-virtual {v4}, Lcom/coolweather/android/db/Province;->save()Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 24
    nop

    .end local v3    # "provinceObject":Lorg/json/JSONObject;
    .end local v4    # "province":Lcom/coolweather/android/db/Province;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    nop

    .line 31
    .end local v2    # "i":I
    nop

    const/4 v1, 0x1

    return v1

    .line 32
    .end local v0    # "allProvinces":Lorg/json/JSONArray;
    :catch_0
    move-exception v0

    nop

    .line 33
    .local v0, "e":Lorg/json/JSONException;
    nop

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 21
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    nop

    .line 36
    :goto_1
    nop

    return v1
.end method

.method public static handleWeatherResponse(Ljava/lang/String;)Lcom/coolweather/android/gson/Weather;
    .locals 5
    .param p0, "response"    # Ljava/lang/String;

    .line 90
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 91
    .local v0, "jsonObject":Lorg/json/JSONObject;
    const-string v1, "HeWeather"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 92
    .local v1, "jsonArray":Lorg/json/JSONArray;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    .line 93
    .local v2, "weatherContent":Ljava/lang/String;
    new-instance v3, Lcom/google/gson/Gson;

    invoke-direct {v3}, Lcom/google/gson/Gson;-><init>()V

    const-class v4, Lcom/coolweather/android/gson/Weather;

    invoke-virtual {v3, v2, v4}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/coolweather/android/gson/Weather;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v3

    .line 94
    .end local v0    # "jsonObject":Lorg/json/JSONObject;
    .end local v1    # "jsonArray":Lorg/json/JSONArray;
    .end local v2    # "weatherContent":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 95
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 97
    .end local v0    # "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    return-object v0
.end method
