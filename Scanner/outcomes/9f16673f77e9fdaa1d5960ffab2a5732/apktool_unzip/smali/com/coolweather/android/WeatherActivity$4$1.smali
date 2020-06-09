.class Lcom/coolweather/android/WeatherActivity$4$1;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity$4;->onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/coolweather/android/WeatherActivity$4;

.field final synthetic val$bingPic:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity$4;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$1"    # Lcom/coolweather/android/WeatherActivity$4;

    .line 404
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$4$1;->this$1:Lcom/coolweather/android/WeatherActivity$4;

    iput-object p2, p0, Lcom/coolweather/android/WeatherActivity$4$1;->val$bingPic:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 407
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$4$1;->this$1:Lcom/coolweather/android/WeatherActivity$4;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity$4;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->with(Landroid/support/v4/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$4$1;->val$bingPic:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$4$1;->this$1:Lcom/coolweather/android/WeatherActivity$4;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$4;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v1}, Lcom/coolweather/android/WeatherActivity;->access$400(Lcom/coolweather/android/WeatherActivity;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 408
    return-void
.end method
