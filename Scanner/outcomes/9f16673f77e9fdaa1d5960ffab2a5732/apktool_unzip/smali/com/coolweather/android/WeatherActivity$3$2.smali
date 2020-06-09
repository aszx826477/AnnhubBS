.class Lcom/coolweather/android/WeatherActivity$3$2;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity$3;->onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/coolweather/android/WeatherActivity$3;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity$3;)V
    .locals 0
    .param p1, "this$1"    # Lcom/coolweather/android/WeatherActivity$3;

    .line 380
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$3$2;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 383
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$2;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    const-string v1, "\u83b7\u53d6\u5929\u6c14\u4fe1\u606f\u5931\u8d25"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 384
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$3$2;->this$1:Lcom/coolweather/android/WeatherActivity$3;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$3;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 385
    return-void
.end method
