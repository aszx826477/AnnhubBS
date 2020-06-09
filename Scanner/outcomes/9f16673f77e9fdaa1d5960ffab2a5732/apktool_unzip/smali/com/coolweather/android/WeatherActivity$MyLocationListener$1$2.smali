.class Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;)V
    .locals 0
    .param p1, "this$2"    # Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    .line 321
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;->this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .line 324
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;->this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity;->districtCode:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 325
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;->this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;->this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity;->districtCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/coolweather/android/WeatherActivity;->requestWeather(Ljava/lang/String;)V

    goto :goto_0

    .line 324
    :cond_0
    nop

    .line 328
    :goto_0
    return-void
.end method
