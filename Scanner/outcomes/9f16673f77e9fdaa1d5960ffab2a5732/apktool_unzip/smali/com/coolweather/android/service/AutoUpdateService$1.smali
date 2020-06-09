.class Lcom/coolweather/android/service/AutoUpdateService$1;
.super Ljava/lang/Object;
.source "AutoUpdateService.java"

# interfaces
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/service/AutoUpdateService;->updateWeather()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/service/AutoUpdateService;


# direct methods
.method constructor <init>(Lcom/coolweather/android/service/AutoUpdateService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/service/AutoUpdateService;

    .line 59
    iput-object p1, p0, Lcom/coolweather/android/service/AutoUpdateService$1;->this$0:Lcom/coolweather/android/service/AutoUpdateService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 0
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "e"    # Ljava/io/IOException;

    .line 73
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    .line 74
    return-void
.end method

.method public onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
    .locals 4
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "response"    # Lokhttp3/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 62
    invoke-virtual {p2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, "responseText":Ljava/lang/String;
    invoke-static {v0}, Lcom/coolweather/android/util/Utility;->handleWeatherResponse(Ljava/lang/String;)Lcom/coolweather/android/gson/Weather;

    move-result-object v1

    .line 64
    .local v1, "weather":Lcom/coolweather/android/gson/Weather;
    if-eqz v1, :cond_0

    const-string v2, "ok"

    iget-object v3, v1, Lcom/coolweather/android/gson/Weather;->status:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 65
    iget-object v2, p0, Lcom/coolweather/android/service/AutoUpdateService$1;->this$0:Lcom/coolweather/android/service/AutoUpdateService;

    invoke-static {v2}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 66
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v3, "weather"

    invoke-interface {v2, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 67
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto :goto_0

    .line 64
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    nop

    .line 69
    :goto_0
    return-void
.end method
