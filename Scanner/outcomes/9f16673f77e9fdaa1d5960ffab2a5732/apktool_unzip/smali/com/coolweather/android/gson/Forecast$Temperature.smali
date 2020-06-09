.class public Lcom/coolweather/android/gson/Forecast$Temperature;
.super Ljava/lang/Object;
.source "Forecast.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/gson/Forecast;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Temperature"
.end annotation


# instance fields
.field public max:Ljava/lang/String;

.field public min:Ljava/lang/String;

.field final synthetic this$0:Lcom/coolweather/android/gson/Forecast;


# direct methods
.method public constructor <init>(Lcom/coolweather/android/gson/Forecast;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/gson/Forecast;

    .line 15
    iput-object p1, p0, Lcom/coolweather/android/gson/Forecast$Temperature;->this$0:Lcom/coolweather/android/gson/Forecast;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
