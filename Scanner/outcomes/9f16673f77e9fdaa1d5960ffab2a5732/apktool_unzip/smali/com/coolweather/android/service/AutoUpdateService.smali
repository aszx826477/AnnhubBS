.class public Lcom/coolweather/android/service/AutoUpdateService;
.super Landroid/app/Service;
.source "AutoUpdateService.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method

.method private updateBingPic()V
    .locals 2

    .line 83
    const-string v0, "http://guolin.tech/api/bing_pic"

    .line 84
    .local v0, "requestBingPic":Ljava/lang/String;
    new-instance v1, Lcom/coolweather/android/service/AutoUpdateService$2;

    invoke-direct {v1, p0}, Lcom/coolweather/android/service/AutoUpdateService$2;-><init>(Lcom/coolweather/android/service/AutoUpdateService;)V

    invoke-static {v0, v1}, Lcom/coolweather/android/util/HttpUtil;->sendOkHttpRequest(Ljava/lang/String;Lokhttp3/Callback;)V

    .line 98
    return-void
.end method

.method private updateWeather()V
    .locals 6

    .line 52
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 53
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v1, "weather"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 54
    .local v1, "weatherString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 56
    invoke-static {v1}, Lcom/coolweather/android/util/Utility;->handleWeatherResponse(Ljava/lang/String;)Lcom/coolweather/android/gson/Weather;

    move-result-object v2

    .line 57
    .local v2, "weather":Lcom/coolweather/android/gson/Weather;
    iget-object v3, v2, Lcom/coolweather/android/gson/Weather;->basic:Lcom/coolweather/android/gson/Basic;

    iget-object v3, v3, Lcom/coolweather/android/gson/Basic;->weatherId:Ljava/lang/String;

    .line 58
    .local v3, "weatherId":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://guolin.tech/api/weather?cityid="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, "&key=bc0418b57b2d4918819d3974ac1285d9"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 59
    .local v4, "weatherUrl":Ljava/lang/String;
    new-instance v5, Lcom/coolweather/android/service/AutoUpdateService$1;

    invoke-direct {v5, p0}, Lcom/coolweather/android/service/AutoUpdateService$1;-><init>(Lcom/coolweather/android/service/AutoUpdateService;)V

    invoke-static {v4, v5}, Lcom/coolweather/android/util/HttpUtil;->sendOkHttpRequest(Ljava/lang/String;Lokhttp3/Callback;)V

    goto :goto_0

    .line 54
    .end local v2    # "weather":Lcom/coolweather/android/gson/Weather;
    .end local v3    # "weatherId":Ljava/lang/String;
    .end local v4    # "weatherUrl":Ljava/lang/String;
    :cond_0
    nop

    .line 77
    :goto_0
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .line 31
    const/4 v0, 0x0

    return-object v0
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .line 36
    invoke-direct {p0}, Lcom/coolweather/android/service/AutoUpdateService;->updateWeather()V

    .line 37
    invoke-direct {p0}, Lcom/coolweather/android/service/AutoUpdateService;->updateBingPic()V

    .line 38
    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/coolweather/android/service/AutoUpdateService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 39
    .local v0, "manager":Landroid/app/AlarmManager;
    const v1, 0x1b77400

    .line 40
    .local v1, "anHour":I
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    int-to-long v4, v1

    add-long/2addr v2, v4

    .line 41
    .local v2, "triggerAtTime":J
    new-instance v4, Landroid/content/Intent;

    const-class v5, Lcom/coolweather/android/service/AutoUpdateService;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 42
    .local v4, "i":Landroid/content/Intent;
    const/4 v5, 0x0

    invoke-static {p0, v5, v4, v5}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 43
    .local v5, "pi":Landroid/app/PendingIntent;
    invoke-virtual {v0, v5}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 44
    const/4 v6, 0x2

    invoke-virtual {v0, v6, v2, v3, v5}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 45
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    move-result v6

    return v6
.end method
