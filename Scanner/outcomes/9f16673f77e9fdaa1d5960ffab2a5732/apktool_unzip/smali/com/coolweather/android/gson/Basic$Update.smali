.class public Lcom/coolweather/android/gson/Basic$Update;
.super Ljava/lang/Object;
.source "Basic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/gson/Basic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Update"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/gson/Basic;

.field public updateTime:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "loc"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/coolweather/android/gson/Basic;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/gson/Basic;

    .line 15
    iput-object p1, p0, Lcom/coolweather/android/gson/Basic$Update;->this$0:Lcom/coolweather/android/gson/Basic;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
