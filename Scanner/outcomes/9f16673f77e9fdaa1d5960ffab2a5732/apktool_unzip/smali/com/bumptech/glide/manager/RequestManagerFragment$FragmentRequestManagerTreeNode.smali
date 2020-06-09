.class Lcom/bumptech/glide/manager/RequestManagerFragment$FragmentRequestManagerTreeNode;
.super Ljava/lang/Object;
.source "RequestManagerFragment.java"

# interfaces
.implements Lcom/bumptech/glide/manager/RequestManagerTreeNode;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/manager/RequestManagerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FragmentRequestManagerTreeNode"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/bumptech/glide/manager/RequestManagerFragment;


# direct methods
.method private constructor <init>(Lcom/bumptech/glide/manager/RequestManagerFragment;)V
    .locals 0

    .line 169
    iput-object p1, p0, Lcom/bumptech/glide/manager/RequestManagerFragment$FragmentRequestManagerTreeNode;->this$0:Lcom/bumptech/glide/manager/RequestManagerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/bumptech/glide/manager/RequestManagerFragment;Lcom/bumptech/glide/manager/RequestManagerFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/bumptech/glide/manager/RequestManagerFragment;
    .param p2, "x1"    # Lcom/bumptech/glide/manager/RequestManagerFragment$1;

    .line 169
    invoke-direct {p0, p1}, Lcom/bumptech/glide/manager/RequestManagerFragment$FragmentRequestManagerTreeNode;-><init>(Lcom/bumptech/glide/manager/RequestManagerFragment;)V

    return-void
.end method


# virtual methods
.method public getDescendants()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Lcom/bumptech/glide/RequestManager;",
            ">;"
        }
    .end annotation

    .line 172
    iget-object v0, p0, Lcom/bumptech/glide/manager/RequestManagerFragment$FragmentRequestManagerTreeNode;->this$0:Lcom/bumptech/glide/manager/RequestManagerFragment;

    invoke-virtual {v0}, Lcom/bumptech/glide/manager/RequestManagerFragment;->getDescendantRequestManagerFragments()Ljava/util/Set;

    move-result-object v0

    .line 173
    .local v0, "descendantFragments":Ljava/util/Set;, "Ljava/util/Set<Lcom/bumptech/glide/manager/RequestManagerFragment;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/HashSet;-><init>(I)V

    .line 175
    .local v1, "descendants":Ljava/util/HashSet;, "Ljava/util/HashSet<Lcom/bumptech/glide/RequestManager;>;"
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bumptech/glide/manager/RequestManagerFragment;

    .line 176
    .local v3, "fragment":Lcom/bumptech/glide/manager/RequestManagerFragment;
    invoke-virtual {v3}, Lcom/bumptech/glide/manager/RequestManagerFragment;->getRequestManager()Lcom/bumptech/glide/RequestManager;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 177
    invoke-virtual {v3}, Lcom/bumptech/glide/manager/RequestManagerFragment;->getRequestManager()Lcom/bumptech/glide/RequestManager;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 176
    :cond_0
    nop

    .line 177
    .end local v3    # "fragment":Lcom/bumptech/glide/manager/RequestManagerFragment;
    :goto_1
    goto :goto_0

    .line 175
    :cond_1
    nop

    .line 180
    .end local v2    # "i$":Ljava/util/Iterator;
    return-object v1
.end method
