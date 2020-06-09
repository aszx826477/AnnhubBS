.class public Lcom/coolweather/android/gson/Forecast$More;
.super Ljava/lang/Object;
.source "Forecast.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/gson/Forecast;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "More"
.end annotation


# instance fields
.field public info:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "txt_d"
    .end annotation
.end field

.field final synthetic this$0:Lcom/coolweather/android/gson/Forecast;


# direct methods
.method public constructor <init>(Lcom/coolweather/android/gson/Forecast;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/gson/Forecast;

    .line 23
    iput-object p1, p0, Lcom/coolweather/android/gson/Forecast$More;->this$0:Lcom/coolweather/android/gson/Forecast;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
