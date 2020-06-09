.class public final Landroid/support/v4/util/ArraySet;
.super Ljava/lang/Object;
.source "ArraySet.java"

# interfaces
.implements Ljava/util/Collection;
.implements Ljava/util/Set;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Collection<",
        "TE;>;",
        "Ljava/util/Set<",
        "TE;>;"
    }
.end annotation


# static fields
.field private static final BASE_SIZE:I = 0x4

.field private static final CACHE_SIZE:I = 0xa

.field private static final DEBUG:Z = false

.field private static final INT:[I

.field private static final OBJECT:[Ljava/lang/Object;

.field private static final TAG:Ljava/lang/String; = "ArraySet"

.field static sBaseCache:[Ljava/lang/Object;

.field static sBaseCacheSize:I

.field static sTwiceBaseCache:[Ljava/lang/Object;

.field static sTwiceBaseCacheSize:I


# instance fields
.field mArray:[Ljava/lang/Object;

.field mCollections:Landroid/support/v4/util/MapCollections;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/MapCollections<",
            "TE;TE;>;"
        }
    .end annotation
.end field

.field mHashes:[I

.field final mIdentityHashCode:Z

.field mSize:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 49
    const/4 v0, 0x0

    new-array v1, v0, [I

    sput-object v1, Landroid/support/v4/util/ArraySet;->INT:[I

    .line 50
    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Landroid/support/v4/util/ArraySet;->OBJECT:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 236
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0}, Landroid/support/v4/util/ArraySet;-><init>(IZ)V

    .line 237
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "capacity"    # I

    .line 243
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/util/ArraySet;-><init>(IZ)V

    .line 244
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 1
    .param p1, "capacity"    # I
    .param p2, "identityHashCode"    # Z

    .line 247
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 248
    iput-boolean p2, p0, Landroid/support/v4/util/ArraySet;->mIdentityHashCode:Z

    .line 249
    if-nez p1, :cond_0

    .line 250
    sget-object v0, Landroid/support/v4/util/ArraySet;->INT:[I

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 251
    sget-object v0, Landroid/support/v4/util/ArraySet;->OBJECT:[Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    goto :goto_0

    .line 253
    :cond_0
    invoke-direct {p0, p1}, Landroid/support/v4/util/ArraySet;->allocArrays(I)V

    .line 255
    :goto_0
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 256
    return-void
.end method

.method public constructor <init>(Landroid/support/v4/util/ArraySet;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArraySet<",
            "TE;>;)V"
        }
    .end annotation

    .line 262
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "set":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-direct {p0}, Landroid/support/v4/util/ArraySet;-><init>()V

    .line 263
    if-eqz p1, :cond_0

    .line 264
    invoke-virtual {p0, p1}, Landroid/support/v4/util/ArraySet;->addAll(Landroid/support/v4/util/ArraySet;)V

    goto :goto_0

    .line 263
    :cond_0
    nop

    .line 266
    :goto_0
    return-void
.end method

.method public constructor <init>(Ljava/util/Collection;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "TE;>;)V"
        }
    .end annotation

    .line 270
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "set":Ljava/util/Collection;, "Ljava/util/Collection<TE;>;"
    invoke-direct {p0}, Landroid/support/v4/util/ArraySet;-><init>()V

    .line 271
    if-eqz p1, :cond_0

    .line 272
    invoke-virtual {p0, p1}, Landroid/support/v4/util/ArraySet;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 271
    :cond_0
    nop

    .line 274
    :goto_0
    return-void
.end method

.method private allocArrays(I)V
    .locals 6
    .param p1, "size"    # I

    .line 157
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x8

    if-ne p1, v3, :cond_1

    .line 158
    const-class v3, Landroid/support/v4/util/ArraySet;

    monitor-enter v3

    .line 159
    :try_start_0
    sget-object v4, Landroid/support/v4/util/ArraySet;->sTwiceBaseCache:[Ljava/lang/Object;

    if-eqz v4, :cond_0

    .line 160
    sget-object v4, Landroid/support/v4/util/ArraySet;->sTwiceBaseCache:[Ljava/lang/Object;

    .line 161
    .local v4, "array":[Ljava/lang/Object;
    iput-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 162
    aget-object v5, v4, v1

    check-cast v5, [Ljava/lang/Object;

    check-cast v5, [Ljava/lang/Object;

    sput-object v5, Landroid/support/v4/util/ArraySet;->sTwiceBaseCache:[Ljava/lang/Object;

    .line 163
    aget-object v5, v4, v2

    check-cast v5, [I

    check-cast v5, [I

    iput-object v5, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 164
    aput-object v0, v4, v2

    aput-object v0, v4, v1

    .line 165
    sget v0, Landroid/support/v4/util/ArraySet;->sTwiceBaseCacheSize:I

    sub-int/2addr v0, v2

    sput v0, Landroid/support/v4/util/ArraySet;->sTwiceBaseCacheSize:I

    .line 170
    monitor-exit v3

    return-void

    .line 172
    .end local v4    # "array":[Ljava/lang/Object;
    :cond_0
    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 173
    :cond_1
    const/4 v3, 0x4

    if-ne p1, v3, :cond_3

    .line 174
    const-class v3, Landroid/support/v4/util/ArraySet;

    monitor-enter v3

    .line 175
    :try_start_1
    sget-object v4, Landroid/support/v4/util/ArraySet;->sBaseCache:[Ljava/lang/Object;

    if-eqz v4, :cond_2

    .line 176
    sget-object v4, Landroid/support/v4/util/ArraySet;->sBaseCache:[Ljava/lang/Object;

    .line 177
    .restart local v4    # "array":[Ljava/lang/Object;
    iput-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 178
    aget-object v5, v4, v1

    check-cast v5, [Ljava/lang/Object;

    check-cast v5, [Ljava/lang/Object;

    sput-object v5, Landroid/support/v4/util/ArraySet;->sBaseCache:[Ljava/lang/Object;

    .line 179
    aget-object v5, v4, v2

    check-cast v5, [I

    check-cast v5, [I

    iput-object v5, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 180
    aput-object v0, v4, v2

    aput-object v0, v4, v1

    .line 181
    sget v0, Landroid/support/v4/util/ArraySet;->sBaseCacheSize:I

    sub-int/2addr v0, v2

    sput v0, Landroid/support/v4/util/ArraySet;->sBaseCacheSize:I

    .line 186
    monitor-exit v3

    return-void

    .line 188
    .end local v4    # "array":[Ljava/lang/Object;
    :cond_2
    monitor-exit v3

    goto :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v0

    .line 173
    :cond_3
    nop

    .line 191
    :goto_0
    new-array v0, p1, [I

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 192
    new-array v0, p1, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 193
    return-void
.end method

.method private static freeArrays([I[Ljava/lang/Object;I)V
    .locals 7
    .param p0, "hashes"    # [I
    .param p1, "array"    # [Ljava/lang/Object;
    .param p2, "size"    # I

    .line 196
    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x2

    const/4 v3, 0x0

    const/16 v4, 0xa

    const/4 v5, 0x1

    const/16 v6, 0x8

    if-ne v0, v6, :cond_2

    .line 197
    const-class v0, Landroid/support/v4/util/ArraySet;

    monitor-enter v0

    .line 198
    :try_start_0
    sget v6, Landroid/support/v4/util/ArraySet;->sTwiceBaseCacheSize:I

    if-ge v6, v4, :cond_1

    .line 199
    sget-object v4, Landroid/support/v4/util/ArraySet;->sTwiceBaseCache:[Ljava/lang/Object;

    aput-object v4, p1, v3

    .line 200
    aput-object p0, p1, v5

    .line 201
    add-int/lit8 v3, p2, -0x1

    .local v3, "i":I
    :goto_0
    if-lt v3, v2, :cond_0

    .line 202
    aput-object v1, p1, v3

    .line 201
    add-int/lit8 v3, v3, -0x1

    goto :goto_0

    .line 204
    .end local v3    # "i":I
    :cond_0
    sput-object p1, Landroid/support/v4/util/ArraySet;->sTwiceBaseCache:[Ljava/lang/Object;

    .line 205
    sget v1, Landroid/support/v4/util/ArraySet;->sTwiceBaseCacheSize:I

    add-int/2addr v1, v5

    sput v1, Landroid/support/v4/util/ArraySet;->sTwiceBaseCacheSize:I

    goto :goto_1

    .line 198
    :cond_1
    nop

    .line 211
    :goto_1
    monitor-exit v0

    goto :goto_4

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 212
    :cond_2
    array-length v0, p0

    const/4 v6, 0x4

    if-ne v0, v6, :cond_5

    .line 213
    const-class v0, Landroid/support/v4/util/ArraySet;

    monitor-enter v0

    .line 214
    :try_start_1
    sget v6, Landroid/support/v4/util/ArraySet;->sBaseCacheSize:I

    if-ge v6, v4, :cond_4

    .line 215
    sget-object v4, Landroid/support/v4/util/ArraySet;->sBaseCache:[Ljava/lang/Object;

    aput-object v4, p1, v3

    .line 216
    aput-object p0, p1, v5

    .line 217
    add-int/lit8 v3, p2, -0x1

    .restart local v3    # "i":I
    :goto_2
    if-lt v3, v2, :cond_3

    .line 218
    aput-object v1, p1, v3

    .line 217
    add-int/lit8 v3, v3, -0x1

    goto :goto_2

    .line 220
    .end local v3    # "i":I
    :cond_3
    sput-object p1, Landroid/support/v4/util/ArraySet;->sBaseCache:[Ljava/lang/Object;

    .line 221
    sget v1, Landroid/support/v4/util/ArraySet;->sBaseCacheSize:I

    add-int/2addr v1, v5

    sput v1, Landroid/support/v4/util/ArraySet;->sBaseCacheSize:I

    goto :goto_3

    .line 214
    :cond_4
    nop

    .line 227
    :goto_3
    monitor-exit v0

    goto :goto_4

    :catchall_1
    move-exception v1

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v1

    .line 212
    :cond_5
    nop

    .line 229
    :goto_4
    return-void
.end method

.method private getCollection()Landroid/support/v4/util/MapCollections;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/support/v4/util/MapCollections<",
            "TE;TE;>;"
        }
    .end annotation

    .line 659
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mCollections:Landroid/support/v4/util/MapCollections;

    if-nez v0, :cond_0

    .line 660
    new-instance v0, Landroid/support/v4/util/ArraySet$1;

    invoke-direct {v0, p0}, Landroid/support/v4/util/ArraySet$1;-><init>(Landroid/support/v4/util/ArraySet;)V

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mCollections:Landroid/support/v4/util/MapCollections;

    goto :goto_0

    .line 659
    :cond_0
    nop

    .line 707
    :goto_0
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mCollections:Landroid/support/v4/util/MapCollections;

    return-object v0
.end method

.method private indexOf(Ljava/lang/Object;I)I
    .locals 5
    .param p1, "key"    # Ljava/lang/Object;
    .param p2, "hash"    # I

    .line 81
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 84
    .local v0, "N":I
    if-nez v0, :cond_0

    .line 85
    const/4 v1, -0x1

    return v1

    .line 88
    :cond_0
    iget-object v1, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    invoke-static {v1, v0, p2}, Landroid/support/v4/util/ContainerHelpers;->binarySearch([III)I

    move-result v1

    .line 91
    .local v1, "index":I
    if-gez v1, :cond_1

    .line 92
    return v1

    .line 96
    :cond_1
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v2, v2, v1

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 97
    return v1

    .line 102
    :cond_2
    add-int/lit8 v2, v1, 0x1

    .local v2, "end":I
    :goto_0
    if-ge v2, v0, :cond_4

    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aget v3, v3, v2

    if-ne v3, p2, :cond_4

    .line 103
    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v3, v3, v2

    invoke-virtual {p1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    return v2

    .line 102
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 107
    :cond_4
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_1
    if-ltz v3, :cond_6

    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aget v4, v4, v3

    if-ne v4, p2, :cond_6

    .line 108
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v4, v4, v3

    invoke-virtual {p1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    return v3

    .line 107
    :cond_5
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 115
    .end local v3    # "i":I
    :cond_6
    xor-int/lit8 v3, v2, -0x1

    return v3
.end method

.method private indexOfNull()I
    .locals 5

    .line 119
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 122
    .local v0, "N":I
    if-nez v0, :cond_0

    .line 123
    const/4 v1, -0x1

    return v1

    .line 126
    :cond_0
    iget-object v1, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/support/v4/util/ContainerHelpers;->binarySearch([III)I

    move-result v1

    .line 129
    .local v1, "index":I
    if-gez v1, :cond_1

    .line 130
    return v1

    .line 134
    :cond_1
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v2, v2, v1

    if-nez v2, :cond_2

    .line 135
    return v1

    .line 140
    :cond_2
    add-int/lit8 v2, v1, 0x1

    .local v2, "end":I
    :goto_0
    if-ge v2, v0, :cond_4

    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aget v3, v3, v2

    if-nez v3, :cond_4

    .line 141
    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v3, v3, v2

    if-nez v3, :cond_3

    return v2

    .line 140
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 145
    :cond_4
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_1
    if-ltz v3, :cond_6

    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aget v4, v4, v3

    if-nez v4, :cond_6

    .line 146
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v4, v4, v3

    if-nez v4, :cond_5

    return v3

    .line 145
    :cond_5
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 153
    .end local v3    # "i":I
    :cond_6
    xor-int/lit8 v3, v2, -0x1

    return v3
.end method


# virtual methods
.method public add(Ljava/lang/Object;)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    .line 358
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "value":Ljava/lang/Object;, "TE;"
    if-nez p1, :cond_0

    .line 359
    const/4 v0, 0x0

    .line 360
    .local v0, "hash":I
    invoke-direct {p0}, Landroid/support/v4/util/ArraySet;->indexOfNull()I

    move-result v1

    goto :goto_1

    .line 362
    .end local v0    # "hash":I
    :cond_0
    iget-boolean v0, p0, Landroid/support/v4/util/ArraySet;->mIdentityHashCode:Z

    if-eqz v0, :cond_1

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 363
    .restart local v0    # "hash":I
    :goto_0
    invoke-direct {p0, p1, v0}, Landroid/support/v4/util/ArraySet;->indexOf(Ljava/lang/Object;I)I

    move-result v1

    .line 365
    .local v1, "index":I
    :goto_1
    const/4 v2, 0x0

    if-ltz v1, :cond_2

    .line 366
    return v2

    .line 369
    :cond_2
    xor-int/lit8 v1, v1, -0x1

    .line 370
    iget v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    array-length v4, v4

    if-lt v3, v4, :cond_6

    .line 371
    const/4 v4, 0x4

    const/16 v5, 0x8

    if-lt v3, v5, :cond_3

    shr-int/lit8 v4, v3, 0x1

    add-int/2addr v4, v3

    goto :goto_2

    :cond_3
    if-lt v3, v4, :cond_4

    const/16 v4, 0x8

    nop

    :cond_4
    :goto_2
    move v3, v4

    .line 376
    .local v3, "n":I
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 377
    .local v4, "ohashes":[I
    iget-object v5, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 378
    .local v5, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, v3}, Landroid/support/v4/util/ArraySet;->allocArrays(I)V

    .line 380
    iget-object v6, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    array-length v7, v6

    if-lez v7, :cond_5

    .line 382
    array-length v7, v4

    invoke-static {v4, v2, v6, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 383
    iget-object v6, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    array-length v7, v5

    invoke-static {v5, v2, v6, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_3

    .line 380
    :cond_5
    nop

    .line 386
    :goto_3
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    invoke-static {v4, v5, v2}, Landroid/support/v4/util/ArraySet;->freeArrays([I[Ljava/lang/Object;I)V

    goto :goto_4

    .line 370
    .end local v3    # "n":I
    .end local v4    # "ohashes":[I
    .end local v5    # "oarray":[Ljava/lang/Object;
    :cond_6
    nop

    .line 389
    :goto_4
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-ge v1, v2, :cond_7

    .line 393
    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    add-int/lit8 v4, v1, 0x1

    sub-int/2addr v2, v1

    invoke-static {v3, v1, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 394
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    add-int/lit8 v3, v1, 0x1

    iget v4, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    sub-int/2addr v4, v1

    invoke-static {v2, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_5

    .line 389
    :cond_7
    nop

    .line 397
    :goto_5
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aput v0, v2, v1

    .line 398
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aput-object p1, v2, v1

    .line 399
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    const/4 v3, 0x1

    add-int/2addr v2, v3

    iput v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 400
    return v3
.end method

.method public addAll(Landroid/support/v4/util/ArraySet;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArraySet<",
            "+TE;>;)V"
        }
    .end annotation

    .line 437
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "array":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<+TE;>;"
    iget v0, p1, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 438
    .local v0, "N":I
    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    add-int/2addr v1, v0

    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArraySet;->ensureCapacity(I)V

    .line 439
    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-nez v1, :cond_1

    .line 440
    if-lez v0, :cond_0

    .line 441
    iget-object v1, p1, Landroid/support/v4/util/ArraySet;->mHashes:[I

    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    const/4 v3, 0x0

    invoke-static {v1, v3, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 442
    iget-object v1, p1, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    invoke-static {v1, v3, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 443
    iput v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    goto :goto_1

    .line 440
    :cond_0
    goto :goto_1

    .line 446
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 447
    invoke-virtual {p1, v1}, Landroid/support/v4/util/ArraySet;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/support/v4/util/ArraySet;->add(Ljava/lang/Object;)Z

    .line 446
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 450
    .end local v1    # "i":I
    :cond_2
    :goto_1
    return-void
.end method

.method public addAll(Ljava/util/Collection;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "+TE;>;)Z"
        }
    .end annotation

    .line 745
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, Landroid/support/v4/util/ArraySet;->ensureCapacity(I)V

    .line 746
    const/4 v0, 0x0

    .line 747
    .local v0, "added":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 748
    .local v2, "value":Ljava/lang/Object;, "TE;"
    invoke-virtual {p0, v2}, Landroid/support/v4/util/ArraySet;->add(Ljava/lang/Object;)Z

    move-result v3

    or-int/2addr v0, v3

    .line 749
    .end local v2    # "value":Ljava/lang/Object;, "TE;"
    goto :goto_0

    .line 750
    :cond_0
    return v0
.end method

.method public append(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    .line 409
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "value":Ljava/lang/Object;, "TE;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 410
    .local v0, "index":I
    if-nez p1, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    iget-boolean v1, p0, Landroid/support/v4/util/ArraySet;->mIdentityHashCode:Z

    if-eqz v1, :cond_1

    .line 411
    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_0
    nop

    .line 412
    .local v1, "hash":I
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    array-length v3, v2

    if-ge v0, v3, :cond_3

    .line 415
    if-lez v0, :cond_2

    add-int/lit8 v3, v0, -0x1

    aget v2, v2, v3

    if-le v2, v1, :cond_2

    .line 424
    invoke-virtual {p0, p1}, Landroid/support/v4/util/ArraySet;->add(Ljava/lang/Object;)Z

    .line 425
    return-void

    .line 415
    :cond_2
    nop

    .line 427
    add-int/lit8 v2, v0, 0x1

    iput v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 428
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    aput v1, v2, v0

    .line 429
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aput-object p1, v2, v0

    .line 430
    return-void

    .line 413
    :cond_3
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Array is full"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public clear()V
    .locals 3

    .line 281
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-eqz v0, :cond_0

    .line 282
    iget-object v1, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    invoke-static {v1, v2, v0}, Landroid/support/v4/util/ArraySet;->freeArrays([I[Ljava/lang/Object;I)V

    .line 283
    sget-object v0, Landroid/support/v4/util/ArraySet;->INT:[I

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 284
    sget-object v0, Landroid/support/v4/util/ArraySet;->OBJECT:[Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 285
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    goto :goto_0

    .line 281
    :cond_0
    nop

    .line 287
    :goto_0
    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 314
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0, p1}, Landroid/support/v4/util/ArraySet;->indexOf(Ljava/lang/Object;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 730
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 731
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 732
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArraySet;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 733
    const/4 v1, 0x0

    return v1

    .line 732
    :cond_0
    goto :goto_0

    .line 736
    :cond_1
    const/4 v1, 0x1

    return v1
.end method

.method public ensureCapacity(I)V
    .locals 5
    .param p1, "minimumCapacity"    # I

    .line 294
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    array-length v0, v0

    if-ge v0, p1, :cond_1

    .line 295
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 296
    .local v0, "ohashes":[I
    iget-object v1, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 297
    .local v1, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, p1}, Landroid/support/v4/util/ArraySet;->allocArrays(I)V

    .line 298
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-lez v2, :cond_0

    .line 299
    iget-object v3, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    const/4 v4, 0x0

    invoke-static {v0, v4, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 300
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    iget v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    invoke-static {v1, v4, v2, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 298
    :cond_0
    nop

    .line 302
    :goto_0
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    invoke-static {v0, v1, v2}, Landroid/support/v4/util/ArraySet;->freeArrays([I[Ljava/lang/Object;I)V

    goto :goto_1

    .line 294
    .end local v0    # "ohashes":[I
    .end local v1    # "oarray":[Ljava/lang/Object;
    :cond_1
    nop

    .line 304
    :goto_1
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "object"    # Ljava/lang/Object;

    .line 584
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 585
    return v0

    .line 587
    :cond_0
    instance-of v1, p1, Ljava/util/Set;

    const/4 v2, 0x0

    if-eqz v1, :cond_4

    .line 588
    move-object v1, p1

    check-cast v1, Ljava/util/Set;

    .line 589
    .local v1, "set":Ljava/util/Set;, "Ljava/util/Set<*>;"
    invoke-virtual {p0}, Landroid/support/v4/util/ArraySet;->size()I

    move-result v3

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v4

    if-eq v3, v4, :cond_1

    .line 590
    return v2

    .line 594
    :cond_1
    nop

    move v3, v2

    .local v3, "i":I
    :goto_0
    nop

    :try_start_0
    iget v4, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    nop

    if-ge v3, v4, :cond_3

    .line 595
    nop

    invoke-virtual {p0, v3}, Landroid/support/v4/util/ArraySet;->valueAt(I)Ljava/lang/Object;

    move-result-object v4

    nop

    .line 596
    .local v4, "mine":Ljava/lang/Object;, "TE;"
    nop

    invoke-interface {v1, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    nop

    if-nez v5, :cond_2

    .line 597
    nop

    return v2

    .line 596
    :cond_2
    nop

    .line 594
    .end local v4    # "mine":Ljava/lang/Object;, "TE;"
    nop

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_3
    nop

    .line 604
    .end local v3    # "i":I
    nop

    .line 605
    nop

    return v0

    .line 602
    :catch_0
    move-exception v0

    nop

    .line 603
    .local v0, "ignored":Ljava/lang/ClassCastException;
    nop

    return v2

    .line 600
    .end local v0    # "ignored":Ljava/lang/ClassCastException;
    :catch_1
    move-exception v0

    nop

    .line 601
    .local v0, "ignored":Ljava/lang/NullPointerException;
    nop

    return v2

    .line 607
    .end local v0    # "ignored":Ljava/lang/NullPointerException;
    .end local v1    # "set":Ljava/util/Set;, "Ljava/util/Set<*>;"
    :cond_4
    nop

    return v2
.end method

.method public hashCode()I
    .locals 5

    .line 615
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 616
    .local v0, "hashes":[I
    const/4 v1, 0x0

    .line 617
    .local v1, "result":I
    const/4 v2, 0x0

    .local v2, "i":I
    iget v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .local v3, "s":I
    :goto_0
    if-ge v2, v3, :cond_0

    .line 618
    aget v4, v0, v2

    add-int/2addr v1, v4

    .line 617
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 620
    .end local v2    # "i":I
    .end local v3    # "s":I
    :cond_0
    return v1
.end method

.method public indexOf(Ljava/lang/Object;)I
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 324
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    if-nez p1, :cond_0

    invoke-direct {p0}, Landroid/support/v4/util/ArraySet;->indexOfNull()I

    move-result v0

    goto :goto_1

    :cond_0
    iget-boolean v0, p0, Landroid/support/v4/util/ArraySet;->mIdentityHashCode:Z

    if-eqz v0, :cond_1

    .line 325
    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_0
    invoke-direct {p0, p1, v0}, Landroid/support/v4/util/ArraySet;->indexOf(Ljava/lang/Object;I)I

    move-result v0

    :goto_1
    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .line 342
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "TE;>;"
        }
    .end annotation

    .line 719
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-direct {p0}, Landroid/support/v4/util/ArraySet;->getCollection()Landroid/support/v4/util/MapCollections;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/util/MapCollections;->getKeySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .line 460
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0, p1}, Landroid/support/v4/util/ArraySet;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 461
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 462
    invoke-virtual {p0, v0}, Landroid/support/v4/util/ArraySet;->removeAt(I)Ljava/lang/Object;

    .line 463
    const/4 v1, 0x1

    return v1

    .line 465
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method public removeAll(Landroid/support/v4/util/ArraySet;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArraySet<",
            "+TE;>;)Z"
        }
    .end annotation

    .line 533
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "array":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<+TE;>;"
    iget v0, p1, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 537
    .local v0, "N":I
    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 538
    .local v1, "originalSize":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_0

    .line 539
    invoke-virtual {p1, v2}, Landroid/support/v4/util/ArraySet;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v3}, Landroid/support/v4/util/ArraySet;->remove(Ljava/lang/Object;)Z

    .line 538
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 541
    .end local v2    # "i":I
    :cond_0
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-eq v1, v2, :cond_1

    const/4 v2, 0x1

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    :goto_1
    return v2
.end method

.method public removeAll(Ljava/util/Collection;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 760
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    const/4 v0, 0x0

    .line 761
    .local v0, "removed":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 762
    .local v2, "value":Ljava/lang/Object;
    invoke-virtual {p0, v2}, Landroid/support/v4/util/ArraySet;->remove(Ljava/lang/Object;)Z

    move-result v3

    or-int/2addr v0, v3

    .line 763
    .end local v2    # "value":Ljava/lang/Object;
    goto :goto_0

    .line 764
    :cond_0
    return v0
.end method

.method public removeAt(I)Ljava/lang/Object;
    .locals 7
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 474
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v1, v0, p1

    .line 475
    .local v1, "old":Ljava/lang/Object;
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-gt v2, v4, :cond_0

    .line 478
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    invoke-static {v4, v0, v2}, Landroid/support/v4/util/ArraySet;->freeArrays([I[Ljava/lang/Object;I)V

    .line 479
    sget-object v0, Landroid/support/v4/util/ArraySet;->INT:[I

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 480
    sget-object v0, Landroid/support/v4/util/ArraySet;->OBJECT:[Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 481
    iput v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    goto/16 :goto_3

    .line 483
    :cond_0
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    array-length v5, v0

    const/16 v6, 0x8

    if-le v5, v6, :cond_4

    array-length v0, v0

    div-int/lit8 v0, v0, 0x3

    if-ge v2, v0, :cond_4

    .line 487
    if-le v2, v6, :cond_1

    shr-int/lit8 v0, v2, 0x1

    add-int v6, v2, v0

    nop

    :cond_1
    move v0, v6

    .line 491
    .local v0, "n":I
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    .line 492
    .local v2, "ohashes":[I
    iget-object v5, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    .line 493
    .local v5, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, v0}, Landroid/support/v4/util/ArraySet;->allocArrays(I)V

    .line 495
    iget v6, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    sub-int/2addr v6, v4

    iput v6, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 496
    if-lez p1, :cond_2

    .line 498
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    invoke-static {v2, v3, v4, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 499
    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    invoke-static {v5, v3, v4, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 496
    :cond_2
    nop

    .line 501
    :goto_0
    iget v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-ge p1, v3, :cond_3

    .line 506
    add-int/lit8 v4, p1, 0x1

    iget-object v6, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    sub-int/2addr v3, p1

    invoke-static {v2, v4, v6, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 507
    add-int/lit8 v3, p1, 0x1

    iget-object v4, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    iget v6, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    sub-int/2addr v6, p1

    invoke-static {v5, v3, v4, p1, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_1

    .line 501
    :cond_3
    nop

    .line 509
    .end local v0    # "n":I
    .end local v2    # "ohashes":[I
    .end local v5    # "oarray":[Ljava/lang/Object;
    :goto_1
    goto :goto_3

    .line 483
    :cond_4
    nop

    .line 510
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    sub-int/2addr v0, v4

    iput v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    .line 511
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-ge p1, v0, :cond_5

    .line 515
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mHashes:[I

    add-int/lit8 v3, p1, 0x1

    sub-int/2addr v0, p1

    invoke-static {v2, v3, v2, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 516
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    add-int/lit8 v2, p1, 0x1

    iget v3, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    sub-int/2addr v3, p1

    invoke-static {v0, v2, v0, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_2

    .line 511
    :cond_5
    nop

    .line 518
    :goto_2
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    const/4 v3, 0x0

    aput-object v3, v0, v2

    .line 521
    :goto_3
    return-object v1
.end method

.method public retainAll(Ljava/util/Collection;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 775
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    const/4 v0, 0x0

    .line 776
    .local v0, "removed":Z
    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 777
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v2, v2, v1

    invoke-interface {p1, v2}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 778
    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArraySet;->removeAt(I)Ljava/lang/Object;

    .line 779
    const/4 v0, 0x1

    goto :goto_1

    .line 777
    :cond_0
    nop

    .line 776
    :goto_1
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 782
    .end local v1    # "i":I
    :cond_1
    return v0
.end method

.method public size()I
    .locals 1

    .line 549
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    return v0
.end method

.method public toArray()[Ljava/lang/Object;
    .locals 4

    .line 554
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    new-array v1, v0, [Ljava/lang/Object;

    .line 555
    .local v1, "result":[Ljava/lang/Object;
    iget-object v2, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 556
    return-object v1
.end method

.method public toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    .line 561
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "array":[Ljava/lang/Object;, "[TT;"
    array-length v0, p1

    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-ge v0, v1, :cond_0

    .line 562
    nop

    .line 563
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Object;

    .line 564
    .local v0, "newArray":[Ljava/lang/Object;, "[TT;"
    move-object p1, v0

    goto :goto_0

    .line 561
    .end local v0    # "newArray":[Ljava/lang/Object;, "[TT;"
    :cond_0
    nop

    .line 566
    :goto_0
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    const/4 v2, 0x0

    invoke-static {v0, v2, p1, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 567
    array-length v0, p1

    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-le v0, v1, :cond_1

    .line 568
    const/4 v0, 0x0

    aput-object v0, p1, v1

    goto :goto_1

    .line 567
    :cond_1
    nop

    .line 570
    :goto_1
    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .line 632
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0}, Landroid/support/v4/util/ArraySet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 633
    const-string v0, "{}"

    return-object v0

    .line 636
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget v1, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    mul-int/lit8 v1, v1, 0xe

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 637
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 638
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p0, Landroid/support/v4/util/ArraySet;->mSize:I

    if-ge v1, v2, :cond_3

    .line 639
    if-lez v1, :cond_1

    .line 640
    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 639
    :cond_1
    nop

    .line 642
    :goto_1
    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArraySet;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    .line 643
    .local v2, "value":Ljava/lang/Object;
    if-eq v2, p0, :cond_2

    .line 644
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 646
    :cond_2
    const-string v3, "(this Set)"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 638
    .end local v2    # "value":Ljava/lang/Object;
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 649
    .end local v1    # "i":I
    :cond_3
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 650
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public valueAt(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 334
    .local p0, "this":Landroid/support/v4/util/ArraySet;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/ArraySet;->mArray:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method
