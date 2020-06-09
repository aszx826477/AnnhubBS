.class Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;
.super Ljava/util/concurrent/FutureTask;
.source "FifoPriorityThreadPoolExecutor.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LoadTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/FutureTask<",
        "TT;>;",
        "Ljava/lang/Comparable<",
        "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<",
        "*>;>;"
    }
.end annotation


# instance fields
.field private final order:I

.field private final priority:I


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;Ljava/lang/Object;I)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p3, "order"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Runnable;",
            "TT;I)V"
        }
    .end annotation

    .line 132
    .local p0, "this":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<TT;>;"
    .local p2, "result":Ljava/lang/Object;, "TT;"
    invoke-direct {p0, p1, p2}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/lang/Runnable;Ljava/lang/Object;)V

    .line 133
    instance-of v0, p1, Lcom/bumptech/glide/load/engine/executor/Prioritized;

    if-eqz v0, :cond_0

    .line 137
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/engine/executor/Prioritized;

    invoke-interface {v0}, Lcom/bumptech/glide/load/engine/executor/Prioritized;->getPriority()I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    .line 138
    iput p3, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    .line 139
    return-void

    .line 134
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public compareTo(Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<",
            "*>;)I"
        }
    .end annotation

    .line 160
    .local p0, "this":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<TT;>;"
    .local p1, "loadTask":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<*>;"
    iget v0, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    iget v1, p1, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    sub-int/2addr v0, v1

    .line 161
    .local v0, "result":I
    if-nez v0, :cond_0

    .line 162
    iget v1, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    iget v2, p1, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    sub-int v0, v1, v2

    goto :goto_0

    .line 161
    :cond_0
    nop

    .line 164
    :goto_0
    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .line 127
    .local p0, "this":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<TT;>;"
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->compareTo(Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;)I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .line 144
    .local p0, "this":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<TT;>;"
    instance-of v0, p1, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 145
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;

    .line 146
    .local v0, "other":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<Ljava/lang/Object;>;"
    iget v2, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    iget v3, v0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    if-ne v2, v3, :cond_0

    iget v2, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    iget v3, v0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    if-ne v2, v3, :cond_0

    const/4 v1, 0x1

    nop

    :cond_0
    return v1

    .line 148
    .end local v0    # "other":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<Ljava/lang/Object;>;"
    :cond_1
    return v1
.end method

.method public hashCode()I
    .locals 3

    .line 153
    .local p0, "this":Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;, "Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask<TT;>;"
    iget v0, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->priority:I

    .line 154
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/bumptech/glide/load/engine/executor/FifoPriorityThreadPoolExecutor$LoadTask;->order:I

    add-int/2addr v1, v2

    .line 155
    .end local v0    # "result":I
    .local v1, "result":I
    return v1
.end method
