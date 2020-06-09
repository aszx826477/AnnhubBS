.class final Landroid/support/v4/app/FragmentTransitionCompat21$5;
.super Ljava/lang/Object;
.source "FragmentTransitionCompat21.java"

# interfaces
.implements Landroid/transition/Transition$TransitionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/FragmentTransitionCompat21;->scheduleRemoveTargets(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$enterTransition:Ljava/lang/Object;

.field final synthetic val$enteringViews:Ljava/util/ArrayList;

.field final synthetic val$exitTransition:Ljava/lang/Object;

.field final synthetic val$exitingViews:Ljava/util/ArrayList;

.field final synthetic val$sharedElementTransition:Ljava/lang/Object;

.field final synthetic val$sharedElementsIn:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
    .locals 0

    .line 442
    iput-object p1, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$enterTransition:Ljava/lang/Object;

    iput-object p2, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$enteringViews:Ljava/util/ArrayList;

    iput-object p3, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$exitTransition:Ljava/lang/Object;

    iput-object p4, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$exitingViews:Ljava/util/ArrayList;

    iput-object p5, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$sharedElementTransition:Ljava/lang/Object;

    iput-object p6, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$sharedElementsIn:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTransitionCancel(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 462
    return-void
.end method

.method public onTransitionEnd(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 458
    return-void
.end method

.method public onTransitionPause(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 466
    return-void
.end method

.method public onTransitionResume(Landroid/transition/Transition;)V
    .locals 0
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 470
    return-void
.end method

.method public onTransitionStart(Landroid/transition/Transition;)V
    .locals 3
    .param p1, "transition"    # Landroid/transition/Transition;

    .line 445
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$enterTransition:Ljava/lang/Object;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 446
    iget-object v2, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$enteringViews:Ljava/util/ArrayList;

    invoke-static {v0, v2, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->replaceTargets(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 445
    :cond_0
    nop

    .line 448
    :goto_0
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$exitTransition:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 449
    iget-object v2, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$exitingViews:Ljava/util/ArrayList;

    invoke-static {v0, v2, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->replaceTargets(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    goto :goto_1

    .line 448
    :cond_1
    nop

    .line 451
    :goto_1
    iget-object v0, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$sharedElementTransition:Ljava/lang/Object;

    if-eqz v0, :cond_2

    .line 452
    iget-object v2, p0, Landroid/support/v4/app/FragmentTransitionCompat21$5;->val$sharedElementsIn:Ljava/util/ArrayList;

    invoke-static {v0, v2, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->replaceTargets(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    goto :goto_2

    .line 451
    :cond_2
    nop

    .line 454
    :goto_2
    return-void
.end method
