.class Lcom/coolweather/android/ChooseAreaFragment$3$2;
.super Ljava/lang/Object;
.source "ChooseAreaFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/ChooseAreaFragment$3;->onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
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

    .line 243
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment$3$2;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 246
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$2;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$900(Lcom/coolweather/android/ChooseAreaFragment;)V

    .line 247
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3$2;->this$1:Lcom/coolweather/android/ChooseAreaFragment$3;

    iget-object v0, v0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v0}, Lcom/coolweather/android/ChooseAreaFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "\u52a0\u8f7d\u5931\u8d25"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 248
    return-void
.end method
