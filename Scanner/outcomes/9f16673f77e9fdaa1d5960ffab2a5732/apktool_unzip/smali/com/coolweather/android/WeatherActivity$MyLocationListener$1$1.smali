.class Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$1;
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

    .line 331
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$1;->this$2:Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .line 334
    return-void
.end method
