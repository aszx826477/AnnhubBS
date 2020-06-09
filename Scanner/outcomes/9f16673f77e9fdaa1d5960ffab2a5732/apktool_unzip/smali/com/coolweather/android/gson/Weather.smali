.class public Lcom/coolweather/android/gson/Weather;
.super Ljava/lang/Object;
.source "Weather.java"


# instance fields
.field public aqi:Lcom/coolweather/android/gson/AQI;

.field public basic:Lcom/coolweather/android/gson/Basic;

.field public forecastList:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "daily_forecast"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/coolweather/android/gson/Forecast;",
            ">;"
        }
    .end annotation
.end field

.field public now:Lcom/coolweather/android/gson/Now;

.field public status:Ljava/lang/String;

.field public suggestion:Lcom/coolweather/android/gson/Suggestion;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
