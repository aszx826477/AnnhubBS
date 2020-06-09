.class Lcom/coolweather/android/WeatherActivity$3;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity;->requestWeather(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/WeatherActivity;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/WeatherActivity;

    .line 355
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 2
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "e"    # Ljava/io/IOException;

    .line 379
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    .line 380
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    new-instance v1, Lcom/coolweather/android/WeatherActivity$3$2;

    invoke-direct {v1, p0}, Lcom/coolweather/android/WeatherActivity$3$2;-><init>(Lcom/coolweather/android/WeatherActivity$3;)V

    invoke-virtual {v0, v1}, Lcom/coolweather/android/WeatherActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 387
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

    .line 358
    invoke-virtual {p2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object v0

    .line 359
    .local v0, "responseText":Ljava/lang/String;
    invoke-static {v0}, Lcom/coolweather/android/util/Utility;->handleWeatherResponse(Ljava/lang/String;)Lcom/coolweather/android/gson/Weather;

    move-result-object v1

    .line 360
    .local v1, "weather":Lcom/coolweather/android/gson/Weather;
    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    new-instance v3, Lcom/coolweather/android/WeatherActivity$3$1;

    invoke-direct {v3, p0, v1, v0}, Lcom/coolweather/android/WeatherActivity$3$1;-><init>(Lcom/coolweather/android/WeatherActivity$3;Lcom/coolweather/android/gson/Weather;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/coolweather/android/WeatherActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 375
    return-void
.end method
