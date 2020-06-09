.class public Lcom/coolweather/android/WeatherActivity$MyLocationListener;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Lcom/baidu/location/BDLocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/WeatherActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyLocationListener"
.end annotation


# instance fields
.field context:Landroid/content/Context;

.field final synthetic this$0:Lcom/coolweather/android/WeatherActivity;


# direct methods
.method public constructor <init>(Lcom/coolweather/android/WeatherActivity;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/WeatherActivity;
    .param p2, "context"    # Landroid/content/Context;

    .line 286
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 287
    iput-object p2, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->context:Landroid/content/Context;

    .line 288
    return-void
.end method


# virtual methods
.method public onReceiveLocation(Lcom/baidu/location/BDLocation;)V
    .locals 2
    .param p1, "location"    # Lcom/baidu/location/BDLocation;

    .line 293
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    new-instance v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    invoke-direct {v1, p0, p1}, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;-><init>(Lcom/coolweather/android/WeatherActivity$MyLocationListener;Lcom/baidu/location/BDLocation;)V

    invoke-virtual {v0, v1}, Lcom/coolweather/android/WeatherActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 341
    return-void
.end method
