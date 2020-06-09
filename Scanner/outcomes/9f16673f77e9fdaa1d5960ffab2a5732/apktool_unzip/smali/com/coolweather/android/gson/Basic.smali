.class public Lcom/coolweather/android/gson/Basic;
.super Ljava/lang/Object;
.source "Basic.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/coolweather/android/gson/Basic$Update;
    }
.end annotation


# instance fields
.field public cityName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "city"
    .end annotation
.end field

.field public update:Lcom/coolweather/android/gson/Basic$Update;

.field public weatherId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "id"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
