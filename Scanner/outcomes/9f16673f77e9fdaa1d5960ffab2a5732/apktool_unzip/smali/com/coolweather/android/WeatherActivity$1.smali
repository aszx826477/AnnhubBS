.class Lcom/coolweather/android/WeatherActivity$1;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity;->onCreate(Landroid/os/Bundle;)V
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

    .line 160
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$1;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh()V
    .locals 2

    .line 163
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$1;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v0}, Lcom/coolweather/android/WeatherActivity;->access$000(Lcom/coolweather/android/WeatherActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/coolweather/android/WeatherActivity;->requestWeather(Ljava/lang/String;)V

    .line 164
    return-void
.end method
