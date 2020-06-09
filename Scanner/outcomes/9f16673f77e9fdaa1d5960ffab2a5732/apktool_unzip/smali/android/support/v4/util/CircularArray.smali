.class public final Landroid/support/v4/util/CircularArray;
.super Ljava/lang/Object;
.source "CircularArray.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mCapacityBitmask:I

.field private mElements:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TE;"
        }
    .end annotation
.end field

.field private mHead:I

.field private mTail:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 47
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    const/16 v0, 0x8

    invoke-direct {p0, v0}, Landroid/support/v4/util/CircularArray;-><init>(I)V

    .line 48
    return-void
.end method

.method public constructor <init>(I)V
    .locals 2
    .param p1, "minCapacity"    # I

    .line 56
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    const/4 v0, 0x1

    if-lt p1, v0, :cond_2

    .line 60
    const/high16 v1, 0x40000000    # 2.0f

    if-gt p1, v1, :cond_1

    .line 67
    invoke-static {p1}, Ljava/lang/Integer;->bitCount(I)I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 68
    add-int/lit8 v1, p1, -0x1

    invoke-static {v1}, Ljava/lang/Integer;->highestOneBit(I)I

    move-result v1

    shl-int/lit8 v0, v1, 0x1

    goto :goto_0

    .line 70
    :cond_0
    move v0, p1

    .line 73
    .local v0, "arrayCapacity":I
    :goto_0
    add-int/lit8 v1, v0, -0x1

    iput v1, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    .line 74
    new-array v1, v0, [Ljava/lang/Object;

    check-cast v1, [Ljava/lang/Object;

    iput-object v1, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    .line 75
    return-void

    .line 61
    .end local v0    # "arrayCapacity":I
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "capacity must be <= 2^30"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "capacity must be >= 1"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private doubleCapacity()V
    .locals 7

    .line 28
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    array-length v1, v0

    .line 29
    .local v1, "n":I
    iget v2, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    sub-int v3, v1, v2

    .line 30
    .local v3, "r":I
    shl-int/lit8 v4, v1, 0x1

    .line 31
    .local v4, "newCapacity":I
    if-ltz v4, :cond_0

    .line 34
    new-array v5, v4, [Ljava/lang/Object;

    .line 35
    .local v5, "a":[Ljava/lang/Object;
    const/4 v6, 0x0

    invoke-static {v0, v2, v5, v6, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 36
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    iget v2, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    invoke-static {v0, v6, v5, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 37
    move-object v0, v5

    check-cast v0, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    .line 38
    iput v6, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    .line 39
    iput v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    .line 40
    add-int/lit8 v0, v4, -0x1

    iput v0, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    .line 41
    return-void

    .line 32
    .end local v5    # "a":[Ljava/lang/Object;
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v2, "Max array capacity exceeded"

    invoke-direct {v0, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public addFirst(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    .line 82
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    .local p1, "e":Ljava/lang/Object;, "TE;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v0, v1

    iput v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    .line 83
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    aput-object p1, v0, v1

    .line 84
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-ne v1, v0, :cond_0

    .line 85
    invoke-direct {p0}, Landroid/support/v4/util/CircularArray;->doubleCapacity()V

    goto :goto_0

    .line 84
    :cond_0
    nop

    .line 87
    :goto_0
    return-void
.end method

.method public addLast(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    .line 94
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    .local p1, "e":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    aput-object p1, v0, v1

    .line 95
    add-int/lit8 v1, v1, 0x1

    iget v0, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v0, v1

    iput v0, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    .line 96
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    if-ne v0, v1, :cond_0

    .line 97
    invoke-direct {p0}, Landroid/support/v4/util/CircularArray;->doubleCapacity()V

    goto :goto_0

    .line 96
    :cond_0
    nop

    .line 99
    :goto_0
    return-void
.end method

.method public clear()V
    .locals 1

    .line 136
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    invoke-virtual {p0}, Landroid/support/v4/util/CircularArray;->size()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/support/v4/util/CircularArray;->removeFromStart(I)V

    .line 137
    return-void
.end method

.method public get(I)Ljava/lang/Object;
    .locals 3
    .param p1, "n"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 238
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Landroid/support/v4/util/CircularArray;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 241
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    add-int/2addr v1, p1

    iget v2, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v1, v2

    aget-object v0, v0, v1

    return-object v0

    .line 238
    :cond_0
    nop

    .line 239
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public getFirst()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 213
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-eq v0, v1, :cond_0

    .line 216
    iget-object v1, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aget-object v0, v1, v0

    return-object v0

    .line 214
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public getLast()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 225
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-eq v0, v1, :cond_0

    .line 228
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    add-int/lit8 v1, v1, -0x1

    iget v2, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v1, v2

    aget-object v0, v0, v1

    return-object v0

    .line 226
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public isEmpty()Z
    .locals 2

    .line 257
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public popFirst()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 107
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-eq v0, v1, :cond_0

    .line 110
    iget-object v1, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aget-object v2, v1, v0

    .line 111
    .local v2, "result":Ljava/lang/Object;, "TE;"
    const/4 v3, 0x0

    aput-object v3, v1, v0

    .line 112
    add-int/lit8 v0, v0, 0x1

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v0, v1

    iput v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    .line 113
    return-object v2

    .line 108
    .end local v2    # "result":Ljava/lang/Object;, "TE;"
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public popLast()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 122
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-eq v0, v1, :cond_0

    .line 125
    add-int/lit8 v1, v1, -0x1

    iget v0, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v0, v1

    .line 126
    .local v0, "t":I
    iget-object v1, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aget-object v2, v1, v0

    .line 127
    .local v2, "result":Ljava/lang/Object;, "TE;"
    const/4 v3, 0x0

    aput-object v3, v1, v0

    .line 128
    iput v0, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    .line 129
    return-object v2

    .line 123
    .end local v0    # "t":I
    .end local v2    # "result":Ljava/lang/Object;, "TE;"
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public removeFromEnd(I)V
    .locals 6
    .param p1, "numOfElements"    # I

    .line 180
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    if-gtz p1, :cond_0

    .line 181
    return-void

    .line 183
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/util/CircularArray;->size()I

    move-result v0

    if-gt p1, v0, :cond_5

    .line 186
    const/4 v0, 0x0

    .line 187
    .local v0, "start":I
    iget v1, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-ge p1, v1, :cond_1

    .line 188
    sub-int v0, v1, p1

    goto :goto_0

    .line 187
    :cond_1
    nop

    .line 190
    :goto_0
    move v1, v0

    .local v1, "i":I
    :goto_1
    iget v2, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    const/4 v3, 0x0

    if-ge v1, v2, :cond_2

    .line 191
    iget-object v2, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aput-object v3, v2, v1

    .line 190
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 193
    .end local v1    # "i":I
    :cond_2
    sub-int v1, v2, v0

    .line 194
    .local v1, "removed":I
    sub-int/2addr p1, v1

    .line 195
    sub-int/2addr v2, v1

    iput v2, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    .line 196
    if-lez p1, :cond_4

    .line 198
    iget-object v2, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    array-length v2, v2

    iput v2, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    .line 199
    iget v2, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    sub-int/2addr v2, p1

    .line 200
    .local v2, "newTail":I
    move v4, v2

    .local v4, "i":I
    :goto_2
    iget v5, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    if-ge v4, v5, :cond_3

    .line 201
    iget-object v5, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aput-object v3, v5, v4

    .line 200
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 203
    .end local v4    # "i":I
    :cond_3
    iput v2, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    goto :goto_3

    .line 196
    .end local v2    # "newTail":I
    :cond_4
    nop

    .line 205
    :goto_3
    return-void

    .line 184
    .end local v0    # "start":I
    .end local v1    # "removed":I
    :cond_5
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    return-void
.end method

.method public removeFromStart(I)V
    .locals 5
    .param p1, "numOfElements"    # I

    .line 147
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    if-gtz p1, :cond_0

    .line 148
    return-void

    .line 150
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/util/CircularArray;->size()I

    move-result v0

    if-gt p1, v0, :cond_5

    .line 153
    iget-object v0, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    array-length v0, v0

    .line 154
    .local v0, "end":I
    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    sub-int v2, v0, v1

    if-ge p1, v2, :cond_1

    .line 155
    add-int v0, v1, p1

    goto :goto_0

    .line 154
    :cond_1
    nop

    .line 157
    :goto_0
    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    .local v1, "i":I
    :goto_1
    const/4 v2, 0x0

    if-ge v1, v0, :cond_2

    .line 158
    iget-object v3, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aput-object v2, v3, v1

    .line 157
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 160
    .end local v1    # "i":I
    :cond_2
    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    sub-int v3, v0, v1

    .line 161
    .local v3, "removed":I
    sub-int/2addr p1, v3

    .line 162
    add-int/2addr v1, v3

    iget v4, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v1, v4

    iput v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    .line 163
    if-lez p1, :cond_4

    .line 165
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_2
    if-ge v1, p1, :cond_3

    .line 166
    iget-object v4, p0, Landroid/support/v4/util/CircularArray;->mElements:[Ljava/lang/Object;

    aput-object v2, v4, v1

    .line 165
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 168
    .end local v1    # "i":I
    :cond_3
    iput p1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    goto :goto_3

    .line 163
    :cond_4
    nop

    .line 170
    :goto_3
    return-void

    .line 151
    .end local v0    # "end":I
    .end local v3    # "removed":I
    :cond_5
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    return-void
.end method

.method public size()I
    .locals 2

    .line 249
    .local p0, "this":Landroid/support/v4/util/CircularArray;, "Landroid/support/v4/util/CircularArray<TE;>;"
    iget v0, p0, Landroid/support/v4/util/CircularArray;->mTail:I

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mHead:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroid/support/v4/util/CircularArray;->mCapacityBitmask:I

    and-int/2addr v0, v1

    return v0
.end method
