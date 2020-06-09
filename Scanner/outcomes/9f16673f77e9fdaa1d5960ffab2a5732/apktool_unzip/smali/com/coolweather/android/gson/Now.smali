.class public Lcom/coolweather/android/gson/Now;
.super Ljava/lang/Object;
.source "Now.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/coolweather/android/gson/Now$More;
    }
.end annotation


# instance fields
.field public more:Lcom/coolweather/android/gson/Now$More;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cond"
    .end annotation
.end field

.field public temperature:Ljava/lang/String;
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
