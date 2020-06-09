.class Lcom/coolweather/android/WeatherActivity$4;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity;->loadBingPic()V
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

    .line 397
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$4;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 0
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "e"    # Ljava/io/IOException;

    .line 414
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    .line 415
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

    .line 400
    invoke-virtual {p2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object v0

    .line 401
    .local v0, "bingPic":Ljava/lang/String;
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$4;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 402
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "bing_pic"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 403
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 404
    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity$4;->this$0:Lcom/coolweather/android/WeatherActivity;

    new-instance v3, Lcom/coolweather/android/WeatherActivity$4$1;

    invoke-direct {v3, p0, v0}, Lcom/coolweather/android/WeatherActivity$4$1;-><init>(Lcom/coolweather/android/WeatherActivity$4;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/coolweather/android/WeatherActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 410
    return-void
.end method
