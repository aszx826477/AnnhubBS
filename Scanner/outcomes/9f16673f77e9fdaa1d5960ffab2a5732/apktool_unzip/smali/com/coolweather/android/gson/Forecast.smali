.class public Lcom/coolweather/android/gson/Forecast;
.super Ljava/lang/Object;
.source "Forecast.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/coolweather/android/gson/Forecast$More;,
        Lcom/coolweather/android/gson/Forecast$Temperature;
    }
.end annotation


# instance fields
.field public date:Ljava/lang/String;

.field public more:Lcom/coolweather/android/gson/Forecast$More;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cond"
    .end annotation
.end field

.field public temperature:Lcom/coolweather/android/gson/Forecast$Temperature;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "tmp"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
