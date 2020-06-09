.class public Lcom/coolweather/android/WeatherActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WeatherActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/coolweather/android/WeatherActivity$MyLocationListener;
    }
.end annotation


# instance fields
.field alertLocation:Landroid/support/v7/app/AlertDialog;

.field private aqiText:Landroid/widget/TextView;

.field private bingPicImg:Landroid/widget/ImageView;

.field private carWashText:Landroid/widget/TextView;

.field private comfortText:Landroid/widget/TextView;

.field private degreeText:Landroid/widget/TextView;

.field public districtCode:Ljava/lang/String;

.field public drawerLayout:Landroid/support/v4/widget/DrawerLayout;

.field private forecastLayout:Landroid/widget/LinearLayout;

.field public mLocationClient:Lcom/baidu/location/LocationClient;

.field private mWeatherId:Ljava/lang/String;

.field private navButton:Landroid/widget/Button;

.field private pm25Text:Landroid/widget/TextView;

.field private positionText:Landroid/widget/TextView;

.field private sportText:Landroid/widget/TextView;

.field public swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

.field private titleCity:Landroid/widget/TextView;

.field private titleUpdateTime:Landroid/widget/TextView;

.field private weatherInfoText:Landroid/widget/TextView;

.field private weatherLayout:Landroid/widget/ScrollView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 53
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 96
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/coolweather/android/WeatherActivity;->districtCode:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/coolweather/android/WeatherActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;

    .line 53
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity;->mWeatherId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$002(Lcom/coolweather/android/WeatherActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .line 53
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity;->mWeatherId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$100(Lcom/coolweather/android/WeatherActivity;Lcom/baidu/location/BDLocation;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;
    .param p1, "x1"    # Lcom/baidu/location/BDLocation;

    .line 53
    invoke-direct {p0, p1}, Lcom/coolweather/android/WeatherActivity;->getDistrictCode(Lcom/baidu/location/BDLocation;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/coolweather/android/WeatherActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;

    .line 53
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity;->positionText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/coolweather/android/WeatherActivity;Lcom/coolweather/android/gson/Weather;)V
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;
    .param p1, "x1"    # Lcom/coolweather/android/gson/Weather;

    .line 53
    invoke-direct {p0, p1}, Lcom/coolweather/android/WeatherActivity;->showWeatherInfo(Lcom/coolweather/android/gson/Weather;)V

    return-void
.end method

.method static synthetic access$400(Lcom/coolweather/android/WeatherActivity;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/WeatherActivity;

    .line 53
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity;->bingPicImg:Landroid/widget/ImageView;

    return-object v0
.end method

.method private getDistrictCode(Lcom/baidu/location/BDLocation;)Ljava/lang/String;
    .locals 24
    .param p1, "location"    # Lcom/baidu/location/BDLocation;

    .line 217
    const/4 v1, 0x0

    .line 218
    .local v1, "resultCode":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/baidu/location/BDLocation;->getProvince()Ljava/lang/String;

    move-result-object v2

    .line 219
    .local v2, "provinceNameR":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/baidu/location/BDLocation;->getCity()Ljava/lang/String;

    move-result-object v3

    .line 220
    .local v3, "cityNameR":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/baidu/location/BDLocation;->getDistrict()Ljava/lang/String;

    move-result-object v4

    .line 221
    .local v4, "districtNameR":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    const/4 v5, 0x0

    invoke-virtual {v2, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    .line 222
    .local v6, "provinceName":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v3, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    .line 223
    .local v7, "cityName":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v4, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    .line 228
    .local v8, "districtName":Ljava/lang/String;
    :try_start_0
    new-instance v0, Ljava/io/InputStreamReader;

    invoke-virtual/range {p0 .. p0}, Lcom/coolweather/android/WeatherActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v9

    const-string v10, "districtcode.json"

    invoke-virtual {v9, v10}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v9

    const-string v10, "UTF-8"

    invoke-direct {v0, v9, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 229
    .local v0, "isr":Ljava/io/InputStreamReader;
    new-instance v9, Ljava/io/BufferedReader;

    invoke-direct {v9, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 231
    .local v9, "br":Ljava/io/BufferedReader;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    .line 232
    .local v10, "builder":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v11
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7

    move-object v12, v11

    .local v12, "line":Ljava/lang/String;
    if-eqz v11, :cond_0

    .line 233
    :try_start_1
    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 277
    .end local v0    # "isr":Ljava/io/InputStreamReader;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v12    # "line":Ljava/lang/String;
    :catch_0
    move-exception v0

    move-object/from16 v17, v1

    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    goto/16 :goto_9

    .line 235
    .restart local v0    # "isr":Ljava/io/InputStreamReader;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v12    # "line":Ljava/lang/String;
    :cond_0
    :try_start_2
    invoke-virtual {v9}, Ljava/io/BufferedReader;->close()V

    .line 236
    invoke-virtual {v0}, Ljava/io/InputStreamReader;->close()V

    .line 239
    new-instance v11, Lorg/json/JSONObject;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v11, v13}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 240
    .local v11, "citycode":Lorg/json/JSONObject;
    const-string v13, "zone"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v13

    .line 241
    .local v13, "provinceArray":Lorg/json/JSONArray;
    nop

    move v14, v5

    .local v14, "i":I
    :goto_1
    nop

    invoke-virtual {v13}, Lorg/json/JSONArray;->length()I

    move-result v15

    nop

    if-ge v14, v15, :cond_9

    .line 242
    nop

    invoke-virtual {v13, v14}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v15

    nop

    .line 244
    .local v15, "province":Lorg/json/JSONObject;
    nop

    const-string v5, "name"

    nop

    invoke-virtual {v15, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    nop

    if-eqz v5, :cond_8

    .line 245
    nop

    const-string v5, "zone"

    nop

    invoke-virtual {v15, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_7

    nop

    .line 246
    .local v5, "cityArray":Lorg/json/JSONArray;
    nop

    nop

    const/16 v16, 0x0

    move/from16 v17, v16

    move-object/from16 v18, v0

    move/from16 v0, v17

    .local v0, "j":I
    .local v18, "isr":Ljava/io/InputStreamReader;
    :goto_2
    nop

    move-object/from16 v17, v1

    .end local v1    # "resultCode":Ljava/lang/String;
    .local v17, "resultCode":Ljava/lang/String;
    :try_start_3
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v1

    nop

    if-ge v0, v1, :cond_7

    .line 247
    nop

    invoke-virtual {v5, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    nop

    .line 249
    .local v1, "city":Lorg/json/JSONObject;
    nop

    move-object/from16 v19, v2

    .end local v2    # "provinceNameR":Ljava/lang/String;
    .local v19, "provinceNameR":Ljava/lang/String;
    :try_start_4
    const-string v2, "name"

    nop

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    nop

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    nop

    if-eqz v2, :cond_6

    .line 250
    nop

    const-string v2, "zone"

    nop

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_5

    nop

    .line 251
    .local v2, "districtArray":Lorg/json/JSONArray;
    nop

    nop

    const/16 v16, 0x0

    move/from16 v20, v16

    move-object/from16 v21, v1

    move/from16 v1, v20

    .local v1, "k":I
    .local v21, "city":Lorg/json/JSONObject;
    :goto_3
    nop

    move-object/from16 v20, v3

    .end local v3    # "cityNameR":Ljava/lang/String;
    .local v20, "cityNameR":Ljava/lang/String;
    :try_start_5
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    nop

    if-ge v1, v3, :cond_2

    .line 252
    nop

    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    nop

    .line 254
    .local v3, "district":Lorg/json/JSONObject;
    nop

    move-object/from16 v22, v4

    .end local v4    # "districtNameR":Ljava/lang/String;
    .local v22, "districtNameR":Ljava/lang/String;
    :try_start_6
    const-string v4, "name"

    nop

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    nop

    invoke-virtual {v4, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    nop

    if-eqz v4, :cond_1

    .line 255
    nop

    new-instance v4, Ljava/lang/StringBuilder;

    nop

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    nop

    move-object/from16 v23, v5

    .end local v5    # "cityArray":Lorg/json/JSONArray;
    .local v23, "cityArray":Lorg/json/JSONArray;
    const-string v5, "CN"

    nop

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    const-string v5, "code"

    nop

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    nop

    .line 256
    .end local v17    # "resultCode":Ljava/lang/String;
    .local v4, "resultCode":Ljava/lang/String;
    nop

    move-object v1, v4

    goto :goto_4

    .line 254
    .end local v4    # "resultCode":Ljava/lang/String;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .restart local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v17    # "resultCode":Ljava/lang/String;
    :cond_1
    move-object/from16 v23, v5

    .end local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    nop

    .line 251
    .end local v3    # "district":Lorg/json/JSONObject;
    nop

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v3, v20

    move-object/from16 v4, v22

    goto :goto_3

    .line 277
    .end local v0    # "j":I
    .end local v1    # "k":I
    .end local v2    # "districtArray":Lorg/json/JSONArray;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v21    # "city":Lorg/json/JSONObject;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    :catch_1
    move-exception v0

    goto/16 :goto_9

    .line 251
    .end local v22    # "districtNameR":Ljava/lang/String;
    .restart local v0    # "j":I
    .restart local v1    # "k":I
    .restart local v2    # "districtArray":Lorg/json/JSONArray;
    .local v4, "districtNameR":Ljava/lang/String;
    .restart local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    .restart local v21    # "city":Lorg/json/JSONObject;
    :cond_2
    move-object/from16 v22, v4

    move-object/from16 v23, v5

    .end local v4    # "districtNameR":Ljava/lang/String;
    .end local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    nop

    move-object/from16 v1, v17

    .line 260
    .end local v17    # "resultCode":Ljava/lang/String;
    .local v1, "resultCode":Ljava/lang/String;
    :goto_4
    nop

    if-nez v1, :cond_5

    .line 261
    nop

    nop

    const/4 v3, 0x0

    .local v3, "k":I
    :goto_5
    nop

    :try_start_7
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    nop

    if-ge v3, v4, :cond_4

    .line 262
    nop

    invoke-virtual {v2, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    nop

    .line 263
    .local v4, "district":Lorg/json/JSONObject;
    nop

    const-string v5, "name"

    nop

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    nop

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    nop

    if-eqz v5, :cond_3

    .line 264
    nop

    new-instance v5, Ljava/lang/StringBuilder;

    nop

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    nop

    move-object/from16 v16, v1

    .end local v1    # "resultCode":Ljava/lang/String;
    .local v16, "resultCode":Ljava/lang/String;
    :try_start_8
    const-string v1, "CN"

    nop

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    const-string v1, "code"

    nop

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    nop

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2

    nop

    .line 265
    .end local v16    # "resultCode":Ljava/lang/String;
    .restart local v1    # "resultCode":Ljava/lang/String;
    nop

    move-object/from16 v16, v1

    goto :goto_6

    .line 277
    .end local v0    # "j":I
    .end local v1    # "resultCode":Ljava/lang/String;
    .end local v2    # "districtArray":Lorg/json/JSONArray;
    .end local v3    # "k":I
    .end local v4    # "district":Lorg/json/JSONObject;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v21    # "city":Lorg/json/JSONObject;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .restart local v16    # "resultCode":Ljava/lang/String;
    :catch_2
    move-exception v0

    move-object/from16 v17, v16

    goto/16 :goto_9

    .line 263
    .end local v16    # "resultCode":Ljava/lang/String;
    .restart local v0    # "j":I
    .restart local v1    # "resultCode":Ljava/lang/String;
    .restart local v2    # "districtArray":Lorg/json/JSONArray;
    .restart local v3    # "k":I
    .restart local v4    # "district":Lorg/json/JSONObject;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    .restart local v21    # "city":Lorg/json/JSONObject;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    :cond_3
    move-object/from16 v16, v1

    .end local v1    # "resultCode":Ljava/lang/String;
    .restart local v16    # "resultCode":Ljava/lang/String;
    nop

    .line 261
    .end local v4    # "district":Lorg/json/JSONObject;
    nop

    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    .end local v16    # "resultCode":Ljava/lang/String;
    .restart local v1    # "resultCode":Ljava/lang/String;
    :cond_4
    move-object/from16 v16, v1

    .end local v1    # "resultCode":Ljava/lang/String;
    .restart local v16    # "resultCode":Ljava/lang/String;
    nop

    .end local v3    # "k":I
    :goto_6
    nop

    move-object/from16 v1, v16

    goto :goto_7

    .line 277
    .end local v0    # "j":I
    .end local v2    # "districtArray":Lorg/json/JSONArray;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v16    # "resultCode":Ljava/lang/String;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v21    # "city":Lorg/json/JSONObject;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .restart local v1    # "resultCode":Ljava/lang/String;
    :catch_3
    move-exception v0

    move-object/from16 v16, v1

    move-object/from16 v17, v16

    .end local v1    # "resultCode":Ljava/lang/String;
    .restart local v16    # "resultCode":Ljava/lang/String;
    goto/16 :goto_9

    .line 260
    .end local v16    # "resultCode":Ljava/lang/String;
    .restart local v0    # "j":I
    .restart local v1    # "resultCode":Ljava/lang/String;
    .restart local v2    # "districtArray":Lorg/json/JSONArray;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    .restart local v21    # "city":Lorg/json/JSONObject;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    :cond_5
    move-object/from16 v16, v1

    .end local v1    # "resultCode":Ljava/lang/String;
    .restart local v16    # "resultCode":Ljava/lang/String;
    nop

    goto :goto_7

    .line 277
    .end local v0    # "j":I
    .end local v2    # "districtArray":Lorg/json/JSONArray;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v16    # "resultCode":Ljava/lang/String;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v21    # "city":Lorg/json/JSONObject;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .local v4, "districtNameR":Ljava/lang/String;
    .restart local v17    # "resultCode":Ljava/lang/String;
    :catch_4
    move-exception v0

    move-object/from16 v22, v4

    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    goto/16 :goto_9

    .line 249
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .restart local v0    # "j":I
    .local v1, "city":Lorg/json/JSONObject;
    .local v3, "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    .restart local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    :cond_6
    move-object/from16 v21, v1

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    move-object/from16 v23, v5

    const/4 v3, 0x0

    .end local v1    # "city":Lorg/json/JSONObject;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .end local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v21    # "city":Lorg/json/JSONObject;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    nop

    .line 246
    .end local v21    # "city":Lorg/json/JSONObject;
    nop

    add-int/lit8 v0, v0, 0x1

    move-object/from16 v1, v17

    move-object/from16 v2, v19

    move-object/from16 v3, v20

    goto/16 :goto_2

    .line 277
    .end local v0    # "j":I
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    :catch_5
    move-exception v0

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    goto :goto_9

    .line 246
    .end local v19    # "provinceNameR":Ljava/lang/String;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .restart local v0    # "j":I
    .local v2, "provinceNameR":Ljava/lang/String;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    .restart local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    :cond_7
    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    move-object/from16 v23, v5

    .end local v2    # "provinceNameR":Ljava/lang/String;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .end local v5    # "cityArray":Lorg/json/JSONArray;
    .restart local v19    # "provinceNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    .restart local v23    # "cityArray":Lorg/json/JSONArray;
    nop

    move-object/from16 v1, v17

    .line 272
    .end local v0    # "j":I
    .end local v17    # "resultCode":Ljava/lang/String;
    .local v1, "resultCode":Ljava/lang/String;
    :goto_7
    nop

    move-object/from16 v17, v1

    goto :goto_8

    .line 277
    .end local v1    # "resultCode":Ljava/lang/String;
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v15    # "province":Lorg/json/JSONObject;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v19    # "provinceNameR":Ljava/lang/String;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .end local v23    # "cityArray":Lorg/json/JSONArray;
    .restart local v2    # "provinceNameR":Ljava/lang/String;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    .restart local v17    # "resultCode":Ljava/lang/String;
    :catch_6
    move-exception v0

    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    .end local v2    # "provinceNameR":Ljava/lang/String;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v19    # "provinceNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    goto :goto_9

    .line 244
    .end local v17    # "resultCode":Ljava/lang/String;
    .end local v19    # "provinceNameR":Ljava/lang/String;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .local v0, "isr":Ljava/io/InputStreamReader;
    .restart local v1    # "resultCode":Ljava/lang/String;
    .restart local v2    # "provinceNameR":Ljava/lang/String;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    .restart local v9    # "br":Ljava/io/BufferedReader;
    .restart local v10    # "builder":Ljava/lang/StringBuilder;
    .restart local v11    # "citycode":Lorg/json/JSONObject;
    .restart local v12    # "line":Ljava/lang/String;
    .restart local v13    # "provinceArray":Lorg/json/JSONArray;
    .restart local v14    # "i":I
    .restart local v15    # "province":Lorg/json/JSONObject;
    :cond_8
    move-object/from16 v18, v0

    move-object/from16 v17, v1

    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    const/4 v3, 0x0

    .end local v0    # "isr":Ljava/io/InputStreamReader;
    .end local v1    # "resultCode":Ljava/lang/String;
    .end local v2    # "provinceNameR":Ljava/lang/String;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v17    # "resultCode":Ljava/lang/String;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    .restart local v19    # "provinceNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    nop

    .line 241
    .end local v15    # "province":Lorg/json/JSONObject;
    nop

    add-int/lit8 v14, v14, 0x1

    move-object/from16 v3, v20

    const/4 v5, 0x0

    goto/16 :goto_1

    .end local v17    # "resultCode":Ljava/lang/String;
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    .end local v19    # "provinceNameR":Ljava/lang/String;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .restart local v0    # "isr":Ljava/io/InputStreamReader;
    .restart local v1    # "resultCode":Ljava/lang/String;
    .restart local v2    # "provinceNameR":Ljava/lang/String;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    :cond_9
    move-object/from16 v18, v0

    move-object/from16 v17, v1

    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    .end local v0    # "isr":Ljava/io/InputStreamReader;
    .end local v1    # "resultCode":Ljava/lang/String;
    .end local v2    # "provinceNameR":Ljava/lang/String;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v17    # "resultCode":Ljava/lang/String;
    .restart local v18    # "isr":Ljava/io/InputStreamReader;
    .restart local v19    # "provinceNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    nop

    .line 279
    .end local v9    # "br":Ljava/io/BufferedReader;
    .end local v10    # "builder":Ljava/lang/StringBuilder;
    .end local v11    # "citycode":Lorg/json/JSONObject;
    .end local v12    # "line":Ljava/lang/String;
    .end local v13    # "provinceArray":Lorg/json/JSONArray;
    .end local v14    # "i":I
    .end local v18    # "isr":Ljava/io/InputStreamReader;
    :goto_8
    nop

    goto :goto_a

    .line 277
    .end local v17    # "resultCode":Ljava/lang/String;
    .end local v19    # "provinceNameR":Ljava/lang/String;
    .end local v20    # "cityNameR":Ljava/lang/String;
    .end local v22    # "districtNameR":Ljava/lang/String;
    .restart local v1    # "resultCode":Ljava/lang/String;
    .restart local v2    # "provinceNameR":Ljava/lang/String;
    .restart local v3    # "cityNameR":Ljava/lang/String;
    .restart local v4    # "districtNameR":Ljava/lang/String;
    :catch_7
    move-exception v0

    move-object/from16 v17, v1

    move-object/from16 v19, v2

    move-object/from16 v20, v3

    move-object/from16 v22, v4

    .end local v1    # "resultCode":Ljava/lang/String;
    .end local v2    # "provinceNameR":Ljava/lang/String;
    .end local v3    # "cityNameR":Ljava/lang/String;
    .end local v4    # "districtNameR":Ljava/lang/String;
    .restart local v17    # "resultCode":Ljava/lang/String;
    .restart local v19    # "provinceNameR":Ljava/lang/String;
    .restart local v20    # "cityNameR":Ljava/lang/String;
    .restart local v22    # "districtNameR":Ljava/lang/String;
    :goto_9
    nop

    .line 278
    .local v0, "e":Ljava/lang/Exception;
    nop

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 280
    .end local v0    # "e":Ljava/lang/Exception;
    :goto_a
    nop

    return-object v17
.end method

.method private initLocation()V
    .locals 2

    .line 187
    new-instance v0, Lcom/baidu/location/LocationClientOption;

    invoke-direct {v0}, Lcom/baidu/location/LocationClientOption;-><init>()V

    .line 188
    .local v0, "option":Lcom/baidu/location/LocationClientOption;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/baidu/location/LocationClientOption;->setIsNeedAddress(Z)V

    .line 189
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity;->mLocationClient:Lcom/baidu/location/LocationClient;

    invoke-virtual {v1, v0}, Lcom/baidu/location/LocationClient;->setLocOption(Lcom/baidu/location/LocationClientOption;)V

    .line 190
    return-void
.end method

.method private loadBingPic()V
    .locals 2

    .line 396
    const-string v0, "http://guolin.tech/api/bing_pic"

    .line 397
    .local v0, "requestBingPic":Ljava/lang/String;
    new-instance v1, Lcom/coolweather/android/WeatherActivity$4;

    invoke-direct {v1, p0}, Lcom/coolweather/android/WeatherActivity$4;-><init>(Lcom/coolweather/android/WeatherActivity;)V

    invoke-static {v0, v1}, Lcom/coolweather/android/util/HttpUtil;->sendOkHttpRequest(Ljava/lang/String;Lokhttp3/Callback;)V

    .line 417
    return-void
.end method

.method private requestLocation()V
    .locals 1

    .line 182
    invoke-direct {p0}, Lcom/coolweather/android/WeatherActivity;->initLocation()V

    .line 183
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity;->mLocationClient:Lcom/baidu/location/LocationClient;

    invoke-virtual {v0}, Lcom/baidu/location/LocationClient;->start()V

    .line 184
    return-void
.end method

.method private showWeatherInfo(Lcom/coolweather/android/gson/Weather;)V
    .locals 12
    .param p1, "weather"    # Lcom/coolweather/android/gson/Weather;

    .line 423
    iget-object v0, p1, Lcom/coolweather/android/gson/Weather;->basic:Lcom/coolweather/android/gson/Basic;

    iget-object v0, v0, Lcom/coolweather/android/gson/Basic;->cityName:Ljava/lang/String;

    .line 424
    .local v0, "cityName":Ljava/lang/String;
    iget-object v1, p1, Lcom/coolweather/android/gson/Weather;->basic:Lcom/coolweather/android/gson/Basic;

    iget-object v1, v1, Lcom/coolweather/android/gson/Basic;->update:Lcom/coolweather/android/gson/Basic$Update;

    iget-object v1, v1, Lcom/coolweather/android/gson/Basic$Update;->updateTime:Ljava/lang/String;

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    aget-object v1, v1, v2

    .line 425
    .local v1, "updateTime":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p1, Lcom/coolweather/android/gson/Weather;->now:Lcom/coolweather/android/gson/Now;

    iget-object v3, v3, Lcom/coolweather/android/gson/Now;->temperature:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\u2103"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 426
    .local v2, "degree":Ljava/lang/String;
    iget-object v3, p1, Lcom/coolweather/android/gson/Weather;->now:Lcom/coolweather/android/gson/Now;

    iget-object v3, v3, Lcom/coolweather/android/gson/Now;->more:Lcom/coolweather/android/gson/Now$More;

    iget-object v3, v3, Lcom/coolweather/android/gson/Now$More;->info:Ljava/lang/String;

    .line 427
    .local v3, "weatherInfo":Ljava/lang/String;
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->titleCity:Landroid/widget/TextView;

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 428
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->titleUpdateTime:Landroid/widget/TextView;

    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 429
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->degreeText:Landroid/widget/TextView;

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 430
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->weatherInfoText:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 431
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->forecastLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 432
    iget-object v4, p1, Lcom/coolweather/android/gson/Weather;->forecastList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    const/4 v6, 0x0

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/coolweather/android/gson/Forecast;

    .line 433
    .local v5, "forecast":Lcom/coolweather/android/gson/Forecast;
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v7

    const v8, 0x7f090020

    iget-object v9, p0, Lcom/coolweather/android/WeatherActivity;->forecastLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v7, v8, v9, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 434
    .local v6, "view":Landroid/view/View;
    const v7, 0x7f070027

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 435
    .local v7, "dateText":Landroid/widget/TextView;
    const v8, 0x7f07003a

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 436
    .local v8, "infoText":Landroid/widget/TextView;
    const v9, 0x7f070040

    invoke-virtual {v6, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 437
    .local v9, "maxText":Landroid/widget/TextView;
    const v10, 0x7f070043

    invoke-virtual {v6, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/TextView;

    .line 438
    .local v10, "minText":Landroid/widget/TextView;
    iget-object v11, v5, Lcom/coolweather/android/gson/Forecast;->date:Ljava/lang/String;

    invoke-virtual {v7, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 439
    iget-object v11, v5, Lcom/coolweather/android/gson/Forecast;->more:Lcom/coolweather/android/gson/Forecast$More;

    iget-object v11, v11, Lcom/coolweather/android/gson/Forecast$More;->info:Ljava/lang/String;

    invoke-virtual {v8, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 440
    iget-object v11, v5, Lcom/coolweather/android/gson/Forecast;->temperature:Lcom/coolweather/android/gson/Forecast$Temperature;

    iget-object v11, v11, Lcom/coolweather/android/gson/Forecast$Temperature;->max:Ljava/lang/String;

    invoke-virtual {v9, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 441
    iget-object v11, v5, Lcom/coolweather/android/gson/Forecast;->temperature:Lcom/coolweather/android/gson/Forecast$Temperature;

    iget-object v11, v11, Lcom/coolweather/android/gson/Forecast$Temperature;->min:Ljava/lang/String;

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 442
    iget-object v11, p0, Lcom/coolweather/android/WeatherActivity;->forecastLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v11, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 443
    .end local v5    # "forecast":Lcom/coolweather/android/gson/Forecast;
    .end local v6    # "view":Landroid/view/View;
    .end local v7    # "dateText":Landroid/widget/TextView;
    .end local v8    # "infoText":Landroid/widget/TextView;
    .end local v9    # "maxText":Landroid/widget/TextView;
    .end local v10    # "minText":Landroid/widget/TextView;
    goto :goto_0

    .line 444
    :cond_0
    iget-object v4, p1, Lcom/coolweather/android/gson/Weather;->aqi:Lcom/coolweather/android/gson/AQI;

    if-eqz v4, :cond_1

    .line 445
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->aqiText:Landroid/widget/TextView;

    iget-object v5, p1, Lcom/coolweather/android/gson/Weather;->aqi:Lcom/coolweather/android/gson/AQI;

    iget-object v5, v5, Lcom/coolweather/android/gson/AQI;->city:Lcom/coolweather/android/gson/AQI$AQICity;

    iget-object v5, v5, Lcom/coolweather/android/gson/AQI$AQICity;->aqi:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 446
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->pm25Text:Landroid/widget/TextView;

    iget-object v5, p1, Lcom/coolweather/android/gson/Weather;->aqi:Lcom/coolweather/android/gson/AQI;

    iget-object v5, v5, Lcom/coolweather/android/gson/AQI;->city:Lcom/coolweather/android/gson/AQI$AQICity;

    iget-object v5, v5, Lcom/coolweather/android/gson/AQI$AQICity;->pm25:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 444
    :cond_1
    nop

    .line 448
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "\u8212\u9002\u5ea6\uff1a"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v5, p1, Lcom/coolweather/android/gson/Weather;->suggestion:Lcom/coolweather/android/gson/Suggestion;

    iget-object v5, v5, Lcom/coolweather/android/gson/Suggestion;->comfort:Lcom/coolweather/android/gson/Suggestion$Comfort;

    iget-object v5, v5, Lcom/coolweather/android/gson/Suggestion$Comfort;->info:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 449
    .local v4, "comfort":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "\u6d17\u8f66\u6307\u6570\uff1a"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v7, p1, Lcom/coolweather/android/gson/Weather;->suggestion:Lcom/coolweather/android/gson/Suggestion;

    iget-object v7, v7, Lcom/coolweather/android/gson/Suggestion;->carWash:Lcom/coolweather/android/gson/Suggestion$CarWash;

    iget-object v7, v7, Lcom/coolweather/android/gson/Suggestion$CarWash;->info:Ljava/lang/String;

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 450
    .local v5, "carWash":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "\u8fd0\u884c\u5efa\u8bae\uff1a"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v8, p1, Lcom/coolweather/android/gson/Weather;->suggestion:Lcom/coolweather/android/gson/Suggestion;

    iget-object v8, v8, Lcom/coolweather/android/gson/Suggestion;->sport:Lcom/coolweather/android/gson/Suggestion$Sport;

    iget-object v8, v8, Lcom/coolweather/android/gson/Suggestion$Sport;->info:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 451
    .local v7, "sport":Ljava/lang/String;
    iget-object v8, p0, Lcom/coolweather/android/WeatherActivity;->comfortText:Landroid/widget/TextView;

    invoke-virtual {v8, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 452
    iget-object v8, p0, Lcom/coolweather/android/WeatherActivity;->carWashText:Landroid/widget/TextView;

    invoke-virtual {v8, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 453
    iget-object v8, p0, Lcom/coolweather/android/WeatherActivity;->sportText:Landroid/widget/TextView;

    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 454
    iget-object v8, p0, Lcom/coolweather/android/WeatherActivity;->weatherLayout:Landroid/widget/ScrollView;

    invoke-virtual {v8, v6}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 455
    new-instance v6, Landroid/content/Intent;

    const-class v8, Lcom/coolweather/android/service/AutoUpdateService;

    invoke-direct {v6, p0, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 456
    .local v6, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v6}, Lcom/coolweather/android/WeatherActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 457
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 100
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 101
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x15

    if-lt v0, v2, :cond_0

    .line 102
    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 103
    .local v0, "decorView":Landroid/view/View;
    const/16 v2, 0x500

    invoke-virtual {v0, v2}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 105
    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/view/Window;->setStatusBarColor(I)V

    goto :goto_0

    .line 101
    .end local v0    # "decorView":Landroid/view/View;
    :cond_0
    nop

    .line 108
    :goto_0
    new-instance v0, Lcom/baidu/location/LocationClient;

    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/baidu/location/LocationClient;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/coolweather/android/WeatherActivity;->mLocationClient:Lcom/baidu/location/LocationClient;

    .line 109
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity;->mLocationClient:Lcom/baidu/location/LocationClient;

    new-instance v2, Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    invoke-direct {v2, p0, p0}, Lcom/coolweather/android/WeatherActivity$MyLocationListener;-><init>(Lcom/coolweather/android/WeatherActivity;Landroid/content/Context;)V

    invoke-virtual {v0, v2}, Lcom/baidu/location/LocationClient;->registerLocationListener(Lcom/baidu/location/BDLocationListener;)V

    .line 111
    const v0, 0x7f09001c

    invoke-virtual {p0, v0}, Lcom/coolweather/android/WeatherActivity;->setContentView(I)V

    .line 115
    const v0, 0x7f07004e

    invoke-virtual {p0, v0}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/coolweather/android/WeatherActivity;->positionText:Landroid/widget/TextView;

    .line 116
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 117
    .local v0, "permissionList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v2, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {p0, v2}, Landroid/support/v4/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    if-eqz v2, :cond_1

    .line 119
    const-string v2, "android.permission.ACCESS_FINE_LOCATION"

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 117
    :cond_1
    nop

    .line 122
    :goto_1
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    const/4 v3, 0x1

    if-nez v2, :cond_2

    .line 123
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    .line 124
    .local v2, "permissions":[Ljava/lang/String;
    invoke-static {p0, v2, v3}, Landroid/support/v4/app/ActivityCompat;->requestPermissions(Landroid/app/Activity;[Ljava/lang/String;I)V

    .line 125
    .end local v2    # "permissions":[Ljava/lang/String;
    goto :goto_2

    .line 126
    :cond_2
    invoke-direct {p0}, Lcom/coolweather/android/WeatherActivity;->requestLocation()V

    .line 131
    :goto_2
    const v2, 0x7f07001a

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->bingPicImg:Landroid/widget/ImageView;

    .line 132
    const v2, 0x7f070082

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ScrollView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->weatherLayout:Landroid/widget/ScrollView;

    .line 133
    const v2, 0x7f070079

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->titleCity:Landroid/widget/TextView;

    .line 134
    const v2, 0x7f07007c

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->titleUpdateTime:Landroid/widget/TextView;

    .line 135
    const v2, 0x7f07002a

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->degreeText:Landroid/widget/TextView;

    .line 136
    const v2, 0x7f070081

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->weatherInfoText:Landroid/widget/TextView;

    .line 137
    const v2, 0x7f070032

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->forecastLayout:Landroid/widget/LinearLayout;

    .line 138
    const v2, 0x7f070017

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->aqiText:Landroid/widget/TextView;

    .line 139
    const v2, 0x7f07004d

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->pm25Text:Landroid/widget/TextView;

    .line 140
    const v2, 0x7f070023

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->comfortText:Landroid/widget/TextView;

    .line 141
    const v2, 0x7f07001e

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->carWashText:Landroid/widget/TextView;

    .line 142
    const v2, 0x7f070069

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->sportText:Landroid/widget/TextView;

    .line 143
    const v2, 0x7f070070

    invoke-virtual {p0, v2}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v2, p0, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 144
    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    new-array v3, v3, [I

    const v4, 0x7f040028

    aput v4, v3, v1

    invoke-virtual {v2, v3}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 145
    const v1, 0x7f07002c

    invoke-virtual {p0, v1}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v4/widget/DrawerLayout;

    iput-object v1, p0, Lcom/coolweather/android/WeatherActivity;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 146
    const v1, 0x7f070045

    invoke-virtual {p0, v1}, Lcom/coolweather/android/WeatherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/coolweather/android/WeatherActivity;->navButton:Landroid/widget/Button;

    .line 147
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 148
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "weather"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 149
    .local v2, "weatherString":Ljava/lang/String;
    if-eqz v2, :cond_3

    .line 151
    invoke-static {v2}, Lcom/coolweather/android/util/Utility;->handleWeatherResponse(Ljava/lang/String;)Lcom/coolweather/android/gson/Weather;

    move-result-object v4

    .line 152
    .local v4, "weather":Lcom/coolweather/android/gson/Weather;
    iget-object v5, v4, Lcom/coolweather/android/gson/Weather;->basic:Lcom/coolweather/android/gson/Basic;

    iget-object v5, v5, Lcom/coolweather/android/gson/Basic;->weatherId:Ljava/lang/String;

    iput-object v5, p0, Lcom/coolweather/android/WeatherActivity;->mWeatherId:Ljava/lang/String;

    .line 153
    invoke-direct {p0, v4}, Lcom/coolweather/android/WeatherActivity;->showWeatherInfo(Lcom/coolweather/android/gson/Weather;)V

    .line 154
    .end local v4    # "weather":Lcom/coolweather/android/gson/Weather;
    goto :goto_3

    .line 156
    :cond_3
    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "weather_id"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/coolweather/android/WeatherActivity;->mWeatherId:Ljava/lang/String;

    .line 157
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->weatherLayout:Landroid/widget/ScrollView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 158
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->mWeatherId:Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/coolweather/android/WeatherActivity;->requestWeather(Ljava/lang/String;)V

    .line 160
    :goto_3
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    new-instance v5, Lcom/coolweather/android/WeatherActivity$1;

    invoke-direct {v5, p0}, Lcom/coolweather/android/WeatherActivity$1;-><init>(Lcom/coolweather/android/WeatherActivity;)V

    invoke-virtual {v4, v5}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 166
    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity;->navButton:Landroid/widget/Button;

    new-instance v5, Lcom/coolweather/android/WeatherActivity$2;

    invoke-direct {v5, p0}, Lcom/coolweather/android/WeatherActivity$2;-><init>(Lcom/coolweather/android/WeatherActivity;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    const-string v4, "bing_pic"

    invoke-interface {v1, v4, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 173
    .local v3, "bingPic":Ljava/lang/String;
    if-eqz v3, :cond_4

    .line 174
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroid/support/v4/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v4

    invoke-virtual {v4, v3}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v4

    iget-object v5, p0, Lcom/coolweather/android/WeatherActivity;->bingPicImg:Landroid/widget/ImageView;

    invoke-virtual {v4, v5}, Lcom/bumptech/glide/DrawableTypeRequest;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    goto :goto_4

    .line 176
    :cond_4
    invoke-direct {p0}, Lcom/coolweather/android/WeatherActivity;->loadBingPic()V

    .line 179
    :goto_4
    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
    .param p3, "grantResults"    # [I

    .line 194
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    goto :goto_1

    .line 196
    :cond_0
    array-length v0, p3

    const/4 v1, 0x0

    if-lez v0, :cond_3

    .line 197
    array-length v0, p3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_2

    aget v3, p3, v2

    .line 198
    .local v3, "result":I
    if-eqz v3, :cond_1

    .line 199
    const-string v0, "\u5fc5\u987b\u540c\u610f\u6240\u6709\u6743\u9650\u624d\u80fd\u4f7f\u7528\u672c\u7a0b\u5e8f"

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 200
    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->finish()V

    .line 201
    return-void

    .line 198
    :cond_1
    nop

    .line 197
    .end local v3    # "result":I
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 204
    :cond_2
    invoke-direct {p0}, Lcom/coolweather/android/WeatherActivity;->requestLocation()V

    goto :goto_1

    .line 206
    :cond_3
    const-string v0, "\u53d1\u751f\u672a\u77e5\u9519\u8bef"

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 207
    invoke-virtual {p0}, Lcom/coolweather/android/WeatherActivity;->finish()V

    .line 209
    nop

    .line 213
    :goto_1
    return-void
.end method

.method public requestWeather(Ljava/lang/String;)V
    .locals 2
    .param p1, "weatherId"    # Ljava/lang/String;

    .line 351
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://guolin.tech/api/weather?cityid="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "&key=c40f1cfbc5d4440194fd2edf7c3b3411"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 355
    .local v0, "weatherUrl":Ljava/lang/String;
    new-instance v1, Lcom/coolweather/android/WeatherActivity$3;

    invoke-direct {v1, p0}, Lcom/coolweather/android/WeatherActivity$3;-><init>(Lcom/coolweather/android/WeatherActivity;)V

    invoke-static {v0, v1}, Lcom/coolweather/android/util/HttpUtil;->sendOkHttpRequest(Ljava/lang/String;Lokhttp3/Callback;)V

    .line 389
    invoke-direct {p0}, Lcom/coolweather/android/WeatherActivity;->loadBingPic()V

    .line 390
    return-void
.end method
