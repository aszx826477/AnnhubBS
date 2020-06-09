.class Lcom/coolweather/android/WeatherActivity$3$1;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity$3;->onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/coolweather/android/WeatherActivity$3;

.field final synthetic val$responseText:Ljava/lang/String;

.field final synthetic val$weather:Lcom/coolweather/android/gson/Weather;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity$3;Lcom/coolweather/android/gson/Weather;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$1"    # Lcom/coolweather/android/WeatherActivity$3;

    .line 360
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iput-object p2, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$weather:Lcom/coolweather/android/gson/Weather;

    iput-object p3, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$responseText:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 363
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$weather:Lcom/coolweather/android/gson/Weather;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    const-string v2, "ok"

    iget-object v0, v0, Lcom/coolweather/android/gson/Weather;->status:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 365
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "weather"

    iget-object v3, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$responseText:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 366
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 367
    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v2, v2, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v3, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$weather:Lcom/coolweather/android/gson/Weather;

    iget-object v3, v3, Lcom/coolweather/android/gson/Weather;->basic:Lcom/coolweather/android/gson/Basic;

    iget-object v3, v3, Lcom/coolweather/android/gson/Basic;->weatherId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/coolweather/android/WeatherActivity;->access$002(Lcom/coolweather/android/WeatherActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 368
    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v2, v2, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v3, p0, Lcom/coolweather/android/WeatherActivity$3$1;->val$weather:Lcom/coolweather/android/gson/Weather;

    invoke-static {v2, v3}, Lcom/coolweather/android/WeatherActivity;->access$300(Lcom/coolweather/android/WeatherActivity;Lcom/coolweather/android/gson/Weather;)V

    .line 369
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    goto :goto_0

    .line 363
    :cond_0
    nop

    .line 370
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    const-string v2, "\u83b7\u53d6\u5929\u6c14\u4fe1\u606f\u5931\u8d25"

    invoke-static {v0, v2, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 372
    :goto_0
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$1;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 373
    return-void
.end method
