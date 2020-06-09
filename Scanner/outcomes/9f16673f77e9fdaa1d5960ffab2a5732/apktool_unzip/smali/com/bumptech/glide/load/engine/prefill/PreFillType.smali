.class public final Lcom/bumptech/glide/load/engine/prefill/PreFillType;
.super Ljava/lang/Object;
.source "PreFillType.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
    }
.end annotation


# static fields
.field static final DEFAULT_CONFIG:Landroid/graphics/Bitmap$Config;


# instance fields
.field private final config:Landroid/graphics/Bitmap$Config;

.field private final height:I

.field private final weight:I

.field private final width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 11
    sget-object v0, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    sput-object v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->DEFAULT_CONFIG:Landroid/graphics/Bitmap$Config;

    return-void
.end method

.method constructor <init>(IILandroid/graphics/Bitmap$Config;I)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "config"    # Landroid/graphics/Bitmap$Config;
    .param p4, "weight"    # I

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    if-eqz p3, :cond_0

    .line 34
    iput p1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    .line 35
    iput p2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    .line 36
    iput-object p3, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    .line 37
    iput p4, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    .line 38
    return-void

    .line 31
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Config must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .line 70
    instance-of v0, p1, Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 71
    move-object v0, p1

    check-cast v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    .line 72
    .local v0, "other":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    iget v3, v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    if-ne v2, v3, :cond_0

    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    iget v3, v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    if-ne v2, v3, :cond_0

    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    iget v3, v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    iget-object v3, v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    if-ne v2, v3, :cond_0

    const/4 v1, 0x1

    nop

    :cond_0
    return v1

    .line 77
    .end local v0    # "other":Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    :cond_1
    return v1
.end method

.method getConfig()Landroid/graphics/Bitmap$Config;
    .locals 1

    .line 58
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method

.method getHeight()I
    .locals 1

    .line 51
    iget v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    return v0
.end method

.method getWeight()I
    .locals 1

    .line 65
    iget v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    return v0
.end method

.method getWidth()I
    .locals 1

    .line 44
    iget v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .line 82
    iget v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    .line 83
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    add-int/2addr v1, v2

    .line 84
    .end local v0    # "result":I
    .local v1, "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    invoke-virtual {v2}, Landroid/graphics/Bitmap$Config;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    .line 85
    .end local v1    # "result":I
    .restart local v0    # "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    add-int/2addr v1, v2

    .line 86
    .end local v0    # "result":I
    .restart local v1    # "result":I
    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "PreFillSize{width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->width:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", height="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->height:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", config="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->config:Landroid/graphics/Bitmap$Config;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", weight="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;->weight:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
