.class public Lcom/coolweather/android/gson/Suggestion;
.super Ljava/lang/Object;
.source "Suggestion.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/coolweather/android/gson/Suggestion$Sport;,
        Lcom/coolweather/android/gson/Suggestion$CarWash;,
        Lcom/coolweather/android/gson/Suggestion$Comfort;
    }
.end annotation


# instance fields
.field public carWash:Lcom/coolweather/android/gson/Suggestion$CarWash;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cw"
    .end annotation
.end field

.field public comfort:Lcom/coolweather/android/gson/Suggestion$Comfort;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "comf"
    .end annotation
.end field

.field public sport:Lcom/coolweather/android/gson/Suggestion$Sport;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
