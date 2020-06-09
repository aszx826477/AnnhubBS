.class public Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
.super Ljava/lang/Object;
.source "PreFillType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/engine/prefill/PreFillType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private config:Landroid/graphics/Bitmap$Config;

.field private final height:I

.field private weight:I

.field private final width:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .line 114
    invoke-direct {p0, p1, p1}, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;-><init>(II)V

    .line 115
    return-void
.end method

.method public constructor <init>(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 107
    const/4 v0, 0x1

    iput v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->weight:I

    .line 123
    if-lez p1, :cond_1

    .line 126
    if-lez p2, :cond_0

    .line 129
    iput p1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->width:I

    .line 130
    iput p2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->height:I

    .line 131
    return-void

    .line 127
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Height must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 124
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Width must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method build()Lcom/bumptech/glide/load/engine/prefill/PreFillType;
    .locals 5

    .line 169
    new-instance v0, Lcom/bumptech/glide/load/engine/prefill/PreFillType;

    iget v1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->width:I

    iget v2, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->height:I

    iget-object v3, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->config:Landroid/graphics/Bitmap$Config;

    iget v4, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->weight:I

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bumptech/glide/load/engine/prefill/PreFillType;-><init>(IILandroid/graphics/Bitmap$Config;I)V

    return-object v0
.end method

.method getConfig()Landroid/graphics/Bitmap$Config;
    .locals 1

    .line 147
    iget-object v0, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->config:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method

.method public setConfig(Landroid/graphics/Bitmap$Config;)Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
    .locals 0
    .param p1, "config"    # Landroid/graphics/Bitmap$Config;

    .line 139
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->config:Landroid/graphics/Bitmap$Config;

    .line 140
    return-object p0
.end method

.method public setWeight(I)Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;
    .locals 2
    .param p1, "weight"    # I

    .line 158
    if-lez p1, :cond_0

    .line 161
    iput p1, p0, Lcom/bumptech/glide/load/engine/prefill/PreFillType$Builder;->weight:I

    .line 162
    return-object p0

    .line 159
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Weight must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
