.class public Lcom/coolweather/android/gson/AQI$AQICity;
.super Ljava/lang/Object;
.source "AQI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/gson/AQI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "AQICity"
.end annotation


# instance fields
.field public aqi:Ljava/lang/String;

.field public pm25:Ljava/lang/String;

.field final synthetic this$0:Lcom/coolweather/android/gson/AQI;


# direct methods
.method public constructor <init>(Lcom/coolweather/android/gson/AQI;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/gson/AQI;

    .line 7
    iput-object p1, p0, Lcom/coolweather/android/gson/AQI$AQICity;->this$0:Lcom/coolweather/android/gson/AQI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
