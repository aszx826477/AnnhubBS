.class Lcom/coolweather/android/ChooseAreaFragment$2;
.super Ljava/lang/Object;
.source "ChooseAreaFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/ChooseAreaFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/ChooseAreaFragment;


# direct methods
.method constructor <init>(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 127
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment$2;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 130
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$2;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$000(Lcom/coolweather/android/ChooseAreaFragment;)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 131
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$2;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$300(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_0

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$2;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$000(Lcom/coolweather/android/ChooseAreaFragment;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 133
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$2;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$800(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_0

    .line 132
    :cond_1
    nop

    .line 135
    :goto_0
    return-void
.end method
