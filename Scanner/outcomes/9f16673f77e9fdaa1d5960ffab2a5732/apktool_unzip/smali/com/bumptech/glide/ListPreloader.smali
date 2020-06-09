.class public Lcom/bumptech/glide/ListPreloader;
.super Ljava/lang/Object;
.source "ListPreloader.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/ListPreloader$PreloadTarget;,
        Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;,
        Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;,
        Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/widget/AbsListView$OnScrollListener;"
    }
.end annotation


# instance fields
.field private isIncreasing:Z

.field private lastEnd:I

.field private lastFirstVisible:I

.field private lastStart:I

.field private final maxPreload:I

.field private final preloadDimensionProvider:Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final preloadTargetQueue:Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

.field private totalItemCount:I


# direct methods
.method public constructor <init>(I)V
    .locals 2
    .param p1, "maxPreload"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 102
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/ListPreloader;->isIncreasing:Z

    .line 103
    new-instance v0, Lcom/bumptech/glide/ListPreloader$1;

    invoke-direct {v0, p0}, Lcom/bumptech/glide/ListPreloader$1;-><init>(Lcom/bumptech/glide/ListPreloader;)V

    iput-object v0, p0, Lcom/bumptech/glide/ListPreloader;->preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;

    .line 114
    new-instance v0, Lcom/bumptech/glide/ListPreloader$2;

    invoke-direct {v0, p0}, Lcom/bumptech/glide/ListPreloader$2;-><init>(Lcom/bumptech/glide/ListPreloader;)V

    iput-object v0, p0, Lcom/bumptech/glide/ListPreloader;->preloadDimensionProvider:Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;

    .line 121
    iput p1, p0, Lcom/bumptech/glide/ListPreloader;->maxPreload:I

    .line 122
    new-instance v0, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    add-int/lit8 v1, p1, 0x1

    invoke-direct {v0, v1}, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;-><init>(I)V

    iput-object v0, p0, Lcom/bumptech/glide/ListPreloader;->preloadTargetQueue:Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    .line 124
    return-void
.end method

.method public constructor <init>(Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;I)V
    .locals 2
    .param p3, "maxPreload"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider<",
            "TT;>;",
            "Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider<",
            "TT;>;I)V"
        }
    .end annotation

    .line 135
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    .local p1, "preloadModelProvider":Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;, "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider<TT;>;"
    .local p2, "preloadDimensionProvider":Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;, "Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/ListPreloader;->isIncreasing:Z

    .line 136
    iput-object p1, p0, Lcom/bumptech/glide/ListPreloader;->preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;

    .line 137
    iput-object p2, p0, Lcom/bumptech/glide/ListPreloader;->preloadDimensionProvider:Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;

    .line 138
    iput p3, p0, Lcom/bumptech/glide/ListPreloader;->maxPreload:I

    .line 139
    new-instance v0, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    add-int/lit8 v1, p3, 0x1

    invoke-direct {v0, v1}, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;-><init>(I)V

    iput-object v0, p0, Lcom/bumptech/glide/ListPreloader;->preloadTargetQueue:Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    .line 140
    return-void
.end method

.method private cancelAll()V
    .locals 3

    .line 276
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v1, p0, Lcom/bumptech/glide/ListPreloader;->maxPreload:I

    if-ge v0, v1, :cond_0

    .line 277
    iget-object v1, p0, Lcom/bumptech/glide/ListPreloader;->preloadTargetQueue:Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v2}, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;->next(II)Lcom/bumptech/glide/ListPreloader$PreloadTarget;

    move-result-object v1

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->clear(Lcom/bumptech/glide/request/target/Target;)V

    .line 276
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 279
    .end local v0    # "i":I
    :cond_0
    return-void
.end method

.method private preload(II)V
    .locals 5
    .param p1, "from"    # I
    .param p2, "to"    # I

    .line 227
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    if-ge p1, p2, :cond_0

    .line 228
    iget v0, p0, Lcom/bumptech/glide/ListPreloader;->lastEnd:I

    invoke-static {v0, p1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 229
    .local v0, "start":I
    move v1, p2

    goto :goto_0

    .line 231
    .end local v0    # "start":I
    :cond_0
    move v0, p2

    .line 232
    .restart local v0    # "start":I
    iget v1, p0, Lcom/bumptech/glide/ListPreloader;->lastStart:I

    invoke-static {v1, p1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 234
    .local v1, "end":I
    :goto_0
    iget v2, p0, Lcom/bumptech/glide/ListPreloader;->totalItemCount:I

    invoke-static {v2, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 235
    iget v2, p0, Lcom/bumptech/glide/ListPreloader;->totalItemCount:I

    const/4 v3, 0x0

    invoke-static {v3, v0}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-static {v2, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 237
    if-ge p1, p2, :cond_2

    .line 239
    move v2, v0

    .local v2, "i":I
    :goto_1
    if-ge v2, v1, :cond_1

    .line 240
    iget-object v3, p0, Lcom/bumptech/glide/ListPreloader;->preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;

    invoke-interface {v3, v2}, Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;->getPreloadItems(I)Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-direct {p0, v3, v2, v4}, Lcom/bumptech/glide/ListPreloader;->preloadAdapterPosition(Ljava/util/List;IZ)V

    .line 239
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_1
    goto :goto_3

    .line 244
    .end local v2    # "i":I
    :cond_2
    add-int/lit8 v2, v1, -0x1

    .restart local v2    # "i":I
    :goto_2
    if-lt v2, v0, :cond_3

    .line 245
    iget-object v4, p0, Lcom/bumptech/glide/ListPreloader;->preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;

    invoke-interface {v4, v2}, Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;->getPreloadItems(I)Ljava/util/List;

    move-result-object v4

    invoke-direct {p0, v4, v2, v3}, Lcom/bumptech/glide/ListPreloader;->preloadAdapterPosition(Ljava/util/List;IZ)V

    .line 244
    add-int/lit8 v2, v2, -0x1

    goto :goto_2

    .line 249
    .end local v2    # "i":I
    :cond_3
    :goto_3
    iput v0, p0, Lcom/bumptech/glide/ListPreloader;->lastStart:I

    .line 250
    iput v1, p0, Lcom/bumptech/glide/ListPreloader;->lastEnd:I

    .line 251
    return-void
.end method

.method private preload(IZ)V
    .locals 1
    .param p1, "start"    # I
    .param p2, "increasing"    # Z

    .line 217
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    iget-boolean v0, p0, Lcom/bumptech/glide/ListPreloader;->isIncreasing:Z

    if-eq v0, p2, :cond_0

    .line 218
    iput-boolean p2, p0, Lcom/bumptech/glide/ListPreloader;->isIncreasing:Z

    .line 219
    invoke-direct {p0}, Lcom/bumptech/glide/ListPreloader;->cancelAll()V

    goto :goto_0

    .line 217
    :cond_0
    nop

    .line 221
    :goto_0
    if-eqz p2, :cond_1

    iget v0, p0, Lcom/bumptech/glide/ListPreloader;->maxPreload:I

    goto :goto_1

    :cond_1
    iget v0, p0, Lcom/bumptech/glide/ListPreloader;->maxPreload:I

    neg-int v0, v0

    :goto_1
    add-int/2addr v0, p1

    invoke-direct {p0, p1, v0}, Lcom/bumptech/glide/ListPreloader;->preload(II)V

    .line 222
    return-void
.end method

.method private preloadAdapterPosition(Ljava/util/List;IZ)V
    .locals 3
    .param p2, "position"    # I
    .param p3, "isIncreasing"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "TT;>;IZ)V"
        }
    .end annotation

    .line 254
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    .line 255
    .local v0, "numItems":I
    if-eqz p3, :cond_1

    .line 256
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 257
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v2, p2, v1}, Lcom/bumptech/glide/ListPreloader;->preloadItem(Ljava/lang/Object;II)V

    .line 256
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    goto :goto_2

    .line 260
    .end local v1    # "i":I
    :cond_1
    add-int/lit8 v1, v0, -0x1

    .restart local v1    # "i":I
    :goto_1
    if-ltz v1, :cond_2

    .line 261
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v2, p2, v1}, Lcom/bumptech/glide/ListPreloader;->preloadItem(Ljava/lang/Object;II)V

    .line 260
    add-int/lit8 v1, v1, -0x1

    goto :goto_1

    .line 264
    .end local v1    # "i":I
    :cond_2
    :goto_2
    return-void
.end method

.method private preloadItem(Ljava/lang/Object;II)V
    .locals 5
    .param p2, "position"    # I
    .param p3, "i"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;II)V"
        }
    .end annotation

    .line 268
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/bumptech/glide/ListPreloader;->preloadDimensionProvider:Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;

    invoke-interface {v0, p1, p2, p3}, Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;->getPreloadSize(Ljava/lang/Object;II)[I

    move-result-object v0

    .line 269
    .local v0, "dimensions":[I
    if-eqz v0, :cond_0

    .line 270
    iget-object v1, p0, Lcom/bumptech/glide/ListPreloader;->preloadModelProvider:Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;

    invoke-interface {v1, p1}, Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;->getPreloadRequestBuilder(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;

    move-result-object v1

    .line 271
    .local v1, "preloadRequestBuilder":Lcom/bumptech/glide/GenericRequestBuilder;
    iget-object v2, p0, Lcom/bumptech/glide/ListPreloader;->preloadTargetQueue:Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;

    const/4 v3, 0x0

    aget v3, v0, v3

    const/4 v4, 0x1

    aget v4, v0, v4

    invoke-virtual {v2, v3, v4}, Lcom/bumptech/glide/ListPreloader$PreloadTargetQueue;->next(II)Lcom/bumptech/glide/ListPreloader$PreloadTarget;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/GenericRequestBuilder;->into(Lcom/bumptech/glide/request/target/Target;)Lcom/bumptech/glide/request/target/Target;

    goto :goto_0

    .line 269
    .end local v1    # "preloadRequestBuilder":Lcom/bumptech/glide/GenericRequestBuilder;
    :cond_0
    nop

    .line 273
    :goto_0
    return-void
.end method


# virtual methods
.method protected getDimensions(Ljava/lang/Object;)[I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)[I"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 173
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You must either provide a PreloadDimensionProvider or override getDimensions()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected getItems(II)Ljava/util/List;
    .locals 2
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 194
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You must either provide a PreloadModelProvider or override getItems()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected getRequestBuilder(Ljava/lang/Object;)Lcom/bumptech/glide/GenericRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/bumptech/glide/GenericRequestBuilder;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 212
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You must either provide a PreloadModelProvider, or override getRequestBuilder()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 2
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "firstVisible"    # I
    .param p3, "visibleCount"    # I
    .param p4, "totalCount"    # I

    .line 150
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    iput p4, p0, Lcom/bumptech/glide/ListPreloader;->totalItemCount:I

    .line 151
    iget v0, p0, Lcom/bumptech/glide/ListPreloader;->lastFirstVisible:I

    if-le p2, v0, :cond_0

    .line 152
    add-int v0, p2, p3

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/bumptech/glide/ListPreloader;->preload(IZ)V

    goto :goto_0

    .line 153
    :cond_0
    if-ge p2, v0, :cond_1

    .line 154
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/bumptech/glide/ListPreloader;->preload(IZ)V

    goto :goto_0

    .line 153
    :cond_1
    nop

    .line 156
    :goto_0
    iput p2, p0, Lcom/bumptech/glide/ListPreloader;->lastFirstVisible:I

    .line 157
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .line 145
    .local p0, "this":Lcom/bumptech/glide/ListPreloader;, "Lcom/bumptech/glide/ListPreloader<TT;>;"
    return-void
.end method
