.class Lcom/coolweather/android/ChooseAreaFragment$3$1;
.super Ljava/lang/Object;
.source "ChooseAreaFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/ChooseAreaFragment$3;->onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/coolweather/android/ChooseAreaFragment$3;


# direct methods
.method constructor <init>(Lcom/coolweather/android/ChooseAreaFragment$3;)V
    .locals 0
    .param p1, "this$1"    # Lcom/coolweather/android/ChooseAreaFragment$3;

    .line 224
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 227
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$900(Lcom/coolweather/android/ChooseAreaFragment;)V

    .line 228
    const-string v0, "province"

    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v1, v1, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$800(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_0

    .line 230
    :cond_0
    const-string v0, "city"

    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v1, v1, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 231
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$300(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_0

    .line 232
    :cond_1
    const-string v0, "county"

    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v1, v1, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 233
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$1;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$600(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_0

    .line 232
    :cond_2
    nop

    .line 235
    :goto_0
    return-void
.end method
