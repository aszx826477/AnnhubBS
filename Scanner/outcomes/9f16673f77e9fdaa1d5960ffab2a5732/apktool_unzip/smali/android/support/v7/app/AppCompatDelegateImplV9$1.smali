.class Landroid/support/v7/app/AppCompatDelegateImplV9$1;
.super Ljava/lang/Object;
.source "AppCompatDelegateImplV9.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/AppCompatDelegateImplV9;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;


# direct methods
.method constructor <init>(Landroid/support/v7/app/AppCompatDelegateImplV9;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/AppCompatDelegateImplV9;

    .line 133
    iput-object p1, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 136
    iget-object v0, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    iget v0, v0, Landroid/support/v7/app/AppCompatDelegateImplV9;->mInvalidatePanelMenuFeatures:I

    and-int/lit8 v0, v0, 0x1

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AppCompatDelegateImplV9;->doInvalidatePanelMenu(I)V

    goto :goto_0

    .line 136
    :cond_0
    nop

    .line 139
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    iget v0, v0, Landroid/support/v7/app/AppCompatDelegateImplV9;->mInvalidatePanelMenuFeatures:I

    and-int/lit16 v0, v0, 0x1000

    if-eqz v0, :cond_1

    .line 140
    iget-object v0, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    const/16 v2, 0x6c

    invoke-virtual {v0, v2}, Landroid/support/v7/app/AppCompatDelegateImplV9;->doInvalidatePanelMenu(I)V

    goto :goto_1

    .line 139
    :cond_1
    nop

    .line 142
    :goto_1
    iget-object v0, p0, Landroid/support/v7/app/AppCompatDelegateImplV9$1;->this$0:Landroid/support/v7/app/AppCompatDelegateImplV9;

    iput-boolean v1, v0, Landroid/support/v7/app/AppCompatDelegateImplV9;->mInvalidatePanelMenuPosted:Z

    .line 143
    iput v1, v0, Landroid/support/v7/app/AppCompatDelegateImplV9;->mInvalidatePanelMenuFeatures:I

    .line 144
    return-void
.end method
