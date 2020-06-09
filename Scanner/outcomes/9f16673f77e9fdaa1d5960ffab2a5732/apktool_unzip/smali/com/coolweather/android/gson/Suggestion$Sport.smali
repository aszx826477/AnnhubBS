.class public Lcom/coolweather/android/gson/Suggestion$Sport;
.super Ljava/lang/Object;
.source "Suggestion.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/coolweather/android/gson/Suggestion;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Sport"
.end annotation


# instance fields
.field public info:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "txt"
    .end annotation
.end field

.field final synthetic this$0:Lcom/coolweather/android/gson/Suggestion;


# direct methods
.method public constructor <init>(Lcom/coolweather/android/gson/Suggestion;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/gson/Suggestion;

    .line 29
    iput-object p1, p0, Lcom/coolweather/android/gson/Suggestion$Sport;->this$0:Lcom/coolweather/android/gson/Suggestion;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
