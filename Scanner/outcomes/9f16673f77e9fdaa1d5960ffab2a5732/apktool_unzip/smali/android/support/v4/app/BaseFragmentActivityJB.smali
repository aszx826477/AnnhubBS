.class abstract Landroid/support/v4/app/BaseFragmentActivityJB;
.super Landroid/support/v4/app/BaseFragmentActivityHoneycomb;
.source "BaseFragmentActivityJB.java"


# instance fields
.field mStartedActivityFromFragment:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .line 30
    invoke-direct {p0}, Landroid/support/v4/app/BaseFragmentActivityHoneycomb;-><init>()V

    return-void
.end method


# virtual methods
.method public startActivityForResult(Landroid/content/Intent;ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestCode"    # I
    .param p3, "options"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .line 45
    iget-boolean v0, p0, Landroid/support/v4/app/BaseFragmentActivityJB;->mStartedActivityFromFragment:Z

    if-nez v0, :cond_1

    .line 46
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 47
    invoke-static {p2}, Landroid/support/v4/app/BaseFragmentActivityJB;->checkForValidRequestCode(I)V

    goto :goto_0

    .line 46
    :cond_0
    goto :goto_0

    .line 45
    :cond_1
    nop

    .line 50
    :goto_0
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/BaseFragmentActivityHoneycomb;->startActivityForResult(Landroid/content/Intent;ILandroid/os/Bundle;)V

    .line 51
    return-void
.end method

.method public startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/IntentSender;
    .param p2, "requestCode"    # I
    .param p3, "fillInIntent"    # Landroid/content/Intent;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "flagsMask"    # I
    .param p5, "flagsValues"    # I
    .param p6, "extraFlags"    # I
    .param p7, "options"    # Landroid/os/Bundle;
    .annotation build Landroid/support/annotation/RequiresApi;
        value = 0x10
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/IntentSender$SendIntentException;
        }
    .end annotation

    .line 60
    iget-boolean v0, p0, Landroid/support/v4/app/BaseFragmentActivityJB;->mStartedIntentSenderFromFragment:Z

    if-nez v0, :cond_1

    .line 61
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 62
    invoke-static {p2}, Landroid/support/v4/app/BaseFragmentActivityJB;->checkForValidRequestCode(I)V

    goto :goto_0

    .line 61
    :cond_0
    goto :goto_0

    .line 60
    :cond_1
    nop

    .line 65
    :goto_0
    invoke-super/range {p0 .. p7}, Landroid/support/v4/app/BaseFragmentActivityHoneycomb;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V

    .line 67
    return-void
.end method
