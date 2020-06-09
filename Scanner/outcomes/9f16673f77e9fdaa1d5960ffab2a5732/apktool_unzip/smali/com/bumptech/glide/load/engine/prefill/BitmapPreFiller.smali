.class public final Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;
.super Ljava/lang/Object;
.source "BitmapPreFiller.java"


# instance fields
.field private final bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

.field private current:Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;

.field private final defaultFormat:Lcom/bumptech/glide/load/DecodeFormat;

.field private final handler:Landroid/os/Handler;

.field private final memoryCache:Lcom/bumptech/glide/load/engine/cache/MemoryCache;


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/engine/cache/MemoryCache;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/DecodeFormat;)V
    .locals 2
    .param p1, "memoryCache"    # Lcom/bumptech/glide/load/engine/cache/MemoryCache;
    .param p2, "bitmapPool"    # Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    .param p3, "defaultFormat"    # Lcom/bumptech/glide/load/DecodeFormat;

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->handler:Landroid/os/Handler;

    .line 29
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->memoryCache:Lcom/bumptech/glide/load/engine/cache/MemoryCache;

    .line 30
    iput-object p2, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    .line 31
    iput-object p3, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->defaultFormat:Lcom/bumptech/glide/load/DecodeFormat;

    .line 32
    return-void
.end method

.method private static getSizeInBytes(Lcom/bumptech/glide/load/engine/prefill/PreFillType;)I
    .locals 3
    .param p0, "size"    # Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    .line 79
    invoke-virtual {p0}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->getHeight()I

    move-result v1

    invoke-virtual {p0}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/bumptech/glide/util/Util;->getBitmapByteSize(IILandroid/graphics/Bitmap$Config;)I

    move-result v0

    return v0
.end method


# virtual methods
.method generateAllocationOrder([Lcom/bumptech/glide/load/engine/prefill/PreFillType;)Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;
    .locals 12
    .param p1, "preFillSizes"    # [Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    .line 58
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->memoryCache:Lcom/bumptech/glide/load/engine/cache/MemoryCache;

    invoke-interface {v0}, Lcom/bumptech/glide/load/engine/cache/MemoryCache;->getMaxSize()I

    move-result v0

    iget-object v1, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->memoryCache:Lcom/bumptech/glide/load/engine/cache/MemoryCache;

    invoke-interface {v1}, Lcom/bumptech/glide/load/engine/cache/MemoryCache;->getCurrentSize()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    invoke-interface {v1}, Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;->getMaxSize()I

    move-result v1

    add-int/2addr v0, v1

    .line 60
    .local v0, "maxSize":I
    const/4 v1, 0x0

    .line 61
    .local v1, "totalWeight":I
    move-object v2, p1

    .local v2, "arr$":[Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    array-length v3, v2

    .local v3, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v3, :cond_0

    aget-object v5, v2, v4

    .line 62
    .local v5, "size":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    invoke-virtual {v5}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->getWeight()I

    move-result v6

    add-int/2addr v1, v6

    .line 61
    .end local v5    # "size":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 65
    .end local v2    # "arr$":[Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    .end local v3    # "len$":I
    .end local v4    # "i$":I
    :cond_0
    int-to-float v2, v0

    int-to-float v3, v1

    div-float/2addr v2, v3

    .line 67
    .local v2, "bytesPerWeight":F
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 68
    .local v3, "attributeToCount":Ljava/util/Map;, "Ljava/util/Map<Lcom/bumptech/glide/load/engine/prefill/PreFillType;Ljava/lang/Integer;>;"
    move-object v4, p1

    .local v4, "arr$":[Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    array-length v5, v4

    .local v5, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_1
    if-ge v6, v5, :cond_1

    aget-object v7, v4, v6

    .line 69
    .local v7, "size":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    invoke-virtual {v7}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->getWeight()I

    move-result v8

    int-to-float v8, v8

    mul-float v8, v8, v2

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v8

    .line 70
    .local v8, "bytesForSize":I
    invoke-static {v7}, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->getSizeInBytes(Lcom/bumptech/glide/load/engine/prefill/PreFillType;)I

    move-result v9

    .line 71
    .local v9, "bytesPerBitmap":I
    div-int v10, v8, v9

    .line 72
    .local v10, "bitmapsForSize":I
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-interface {v3, v7, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    .end local v7    # "size":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    .end local v8    # "bytesForSize":I
    .end local v9    # "bytesPerBitmap":I
    .end local v10    # "bitmapsForSize":I
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 75
    .end local v4    # "arr$":[Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    .end local v5    # "len$":I
    .end local v6    # "i$":I
    :cond_1
    new-instance v4, Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;

    invoke-direct {v4, v3}, Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;-><init>(Ljava/util/Map;)V

    return-object v4
.end method

.method public varargs preFill([Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;)V
    .locals 5
    .param p1, "bitmapAttributeBuilders"    # [Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;

    .line 36
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->current:Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;

    if-eqz v0, :cond_0

    .line 37
    invoke-virtual {v0}, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;->cancel()V

    goto :goto_0

    .line 36
    :cond_0
    nop

    .line 40
    :goto_0
    array-length v0, p1

    new-array v0, v0, [Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    .line 41
    .local v0, "bitmapAttributes":[Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v2, p1

    if-ge v1, v2, :cond_4

    .line 42
    aget-object v2, p1, v1

    .line 43
    .local v2, "builder":Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
    invoke-virtual {v2}, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    if-nez v3, :cond_3

    .line 44
    iget-object v3, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->defaultFormat:Lcom/bumptech/glide/load/DecodeFormat;

    sget-object v4, Lcom/bumptech/glide/load/DecodeFormat;->ALWAYS_ARGB_8888:Lcom/bumptech/glide/load/DecodeFormat;

    if-eq v3, v4, :cond_2

    iget-object v3, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->defaultFormat:Lcom/bumptech/glide/load/DecodeFormat;

    sget-object v4, Lcom/bumptech/glide/load/DecodeFormat;->PREFER_ARGB_8888:Lcom/bumptech/glide/load/DecodeFormat;

    if-ne v3, v4, :cond_1

    goto :goto_2

    :cond_1
    sget-object v3, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    goto :goto_3

    :cond_2
    :goto_2
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    :goto_3
    invoke-virtual {v2, v3}, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->setConfig(Landroid/graphics/Bitmap$Config;)Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;

    goto :goto_4

    .line 43
    :cond_3
    nop

    .line 48
    :goto_4
    invoke-virtual {v2}, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->build()Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    move-result-object v3

    aput-object v3, v0, v1

    .line 41
    .end local v2    # "builder":Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 51
    .end local v1    # "i":I
    :cond_4
    invoke-virtual {p0, v0}, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->generateAllocationOrder([Lcom/bumptech/glide/load/engine/prefill/PreFillType;)Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;

    move-result-object v1

    .line 52
    .local v1, "allocationOrder":Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;
    new-instance v2, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;

    iget-object v3, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->bitmapPool:Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;

    iget-object v4, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->memoryCache:Lcom/bumptech/glide/load/engine/cache/MemoryCache;

    invoke-direct {v2, v3, v4, v1}, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;-><init>(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Lcom/bumptech/glide/load/engine/cache/MemoryCache;Lcom/bumptech/glide/load/engine/prefill/PreFillQueue;)V

    iput-object v2, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->current:Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;

    .line 53
    iget-object v2, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->handler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/bumptech/glide/load/engine/prefill/BitmapPreFiller;->current:Lcom/bumptech/glide/load/engine/prefill/BitmapPreFillRunner;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 54
    return-void
.end method
