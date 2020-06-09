.class Landroid/support/graphics/drawable/PathParser;
.super Ljava/lang/Object;
.source "PathParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/graphics/drawable/PathParser$PathDataNode;,
        Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;
    }
.end annotation


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "PathParser"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 297
    return-void
.end method

.method private static addNode(Ljava/util/ArrayList;C[F)V
    .locals 1
    .param p1, "cmd"    # C
    .param p2, "val"    # [F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/graphics/drawable/PathParser$PathDataNode;",
            ">;C[F)V"
        }
    .end annotation

    .line 180
    .local p0, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/graphics/drawable/PathParser$PathDataNode;>;"
    new-instance v0, Landroid/support/graphics/drawable/PathParser$PathDataNode;

    invoke-direct {v0, p1, p2}, Landroid/support/graphics/drawable/PathParser$PathDataNode;-><init>(C[F)V

    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 181
    return-void
.end method

.method public static canMorph([Landroid/support/graphics/drawable/PathParser$PathDataNode;[Landroid/support/graphics/drawable/PathParser$PathDataNode;)Z
    .locals 4
    .param p0, "nodesFrom"    # [Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .param p1, "nodesTo"    # [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    .line 128
    const/4 v0, 0x0

    if-eqz p0, :cond_5

    if-nez p1, :cond_0

    goto :goto_2

    .line 132
    :cond_0
    array-length v1, p0

    array-length v2, p1

    if-eq v1, v2, :cond_1

    .line 133
    return v0

    .line 136
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_4

    .line 137
    aget-object v2, p0, v1

    iget-char v2, v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mType:C

    aget-object v3, p1, v1

    iget-char v3, v3, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mType:C

    if-ne v2, v3, :cond_3

    aget-object v2, p0, v1

    iget-object v2, v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mParams:[F

    array-length v2, v2

    aget-object v3, p1, v1

    iget-object v3, v3, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mParams:[F

    array-length v3, v3

    if-eq v2, v3, :cond_2

    goto :goto_1

    .line 136
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 137
    :cond_3
    :goto_1
    nop

    .line 139
    return v0

    .line 136
    :cond_4
    nop

    .line 142
    .end local v1    # "i":I
    const/4 v0, 0x1

    return v0

    .line 128
    :cond_5
    :goto_2
    nop

    .line 129
    return v0
.end method

.method static copyOfRange([FII)[F
    .locals 5
    .param p0, "original"    # [F
    .param p1, "start"    # I
    .param p2, "end"    # I

    .line 46
    if-gt p1, p2, :cond_1

    .line 49
    array-length v0, p0

    .line 50
    .local v0, "originalLength":I
    if-ltz p1, :cond_0

    if-gt p1, v0, :cond_0

    .line 53
    sub-int v1, p2, p1

    .line 54
    .local v1, "resultLength":I
    sub-int v2, v0, p1

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 55
    .local v2, "copyLength":I
    new-array v3, v1, [F

    .line 56
    .local v3, "result":[F
    const/4 v4, 0x0

    invoke-static {p0, p1, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 57
    return-object v3

    .line 50
    .end local v1    # "resultLength":I
    .end local v2    # "copyLength":I
    .end local v3    # "result":[F
    :cond_0
    nop

    .line 51
    new-instance v1, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v1

    .line 47
    .end local v0    # "originalLength":I
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method

.method public static createNodesFromPathData(Ljava/lang/String;)[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .locals 6
    .param p0, "pathData"    # Ljava/lang/String;

    .line 83
    if-nez p0, :cond_0

    .line 84
    const/4 v0, 0x0

    return-object v0

    .line 86
    :cond_0
    const/4 v0, 0x0

    .line 87
    .local v0, "start":I
    const/4 v1, 0x1

    .line 89
    .local v1, "end":I
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 90
    .local v2, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/graphics/drawable/PathParser$PathDataNode;>;"
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x0

    if-ge v1, v3, :cond_2

    .line 91
    invoke-static {p0, v1}, Landroid/support/graphics/drawable/PathParser;->nextStart(Ljava/lang/String;I)I

    move-result v1

    .line 92
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 93
    .local v3, "s":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_1

    .line 94
    invoke-static {v3}, Landroid/support/graphics/drawable/PathParser;->getFloats(Ljava/lang/String;)[F

    move-result-object v5

    .line 95
    .local v5, "val":[F
    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v2, v4, v5}, Landroid/support/graphics/drawable/PathParser;->addNode(Ljava/util/ArrayList;C[F)V

    goto :goto_1

    .line 93
    .end local v5    # "val":[F
    :cond_1
    nop

    .line 98
    :goto_1
    move v0, v1

    .line 99
    nop

    .end local v3    # "s":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    .line 100
    goto :goto_0

    .line 101
    :cond_2
    sub-int v3, v1, v0

    const/4 v5, 0x1

    if-ne v3, v5, :cond_3

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v0, v3, :cond_3

    .line 102
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    new-array v4, v4, [F

    invoke-static {v2, v3, v4}, Landroid/support/graphics/drawable/PathParser;->addNode(Ljava/util/ArrayList;C[F)V

    goto :goto_2

    .line 101
    :cond_3
    nop

    .line 104
    :goto_2
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    return-object v3
.end method

.method public static createPathFromPathData(Ljava/lang/String;)Landroid/graphics/Path;
    .locals 6
    .param p0, "pathData"    # Ljava/lang/String;

    .line 65
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 66
    .local v0, "path":Landroid/graphics/Path;
    invoke-static {p0}, Landroid/support/graphics/drawable/PathParser;->createNodesFromPathData(Ljava/lang/String;)[Landroid/support/graphics/drawable/PathParser$PathDataNode;

    move-result-object v1

    .line 67
    .local v1, "nodes":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    if-eqz v1, :cond_0

    .line 69
    :try_start_0
    invoke-static {v1, v0}, Landroid/support/graphics/drawable/PathParser$PathDataNode;->nodesToPath([Landroid/support/graphics/drawable/PathParser$PathDataNode;Landroid/graphics/Path;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    nop

    .line 73
    return-object v0

    .line 70
    :catch_0
    move-exception v2

    .line 71
    .local v2, "e":Ljava/lang/RuntimeException;
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error in parsing "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 75
    .end local v2    # "e":Ljava/lang/RuntimeException;
    :cond_0
    const/4 v2, 0x0

    return-object v2
.end method

.method public static deepCopyNodes([Landroid/support/graphics/drawable/PathParser$PathDataNode;)[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .locals 4
    .param p0, "source"    # [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    .line 112
    if-nez p0, :cond_0

    .line 113
    const/4 v0, 0x0

    return-object v0

    .line 115
    :cond_0
    array-length v0, p0

    new-array v0, v0, [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    .line 116
    .local v0, "copy":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_1

    .line 117
    new-instance v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;

    aget-object v3, p0, v1

    invoke-direct {v2, v3}, Landroid/support/graphics/drawable/PathParser$PathDataNode;-><init>(Landroid/support/graphics/drawable/PathParser$PathDataNode;)V

    aput-object v2, v0, v1

    .line 116
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 119
    .end local v1    # "i":I
    :cond_1
    return-object v0
.end method

.method private static extract(Ljava/lang/String;ILandroid/support/graphics/drawable/PathParser$ExtractFloatResult;)V
    .locals 7
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "start"    # I
    .param p2, "result"    # Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;

    .line 248
    move v0, p1

    .line 249
    .local v0, "currentIndex":I
    const/4 v1, 0x0

    .line 250
    .local v1, "foundSeparator":Z
    const/4 v2, 0x0

    iput-boolean v2, p2, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndWithNegOrDot:Z

    .line 251
    const/4 v2, 0x0

    .line 252
    .local v2, "secondDot":Z
    const/4 v3, 0x0

    .line 253
    .local v3, "isExponential":Z
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v0, v4, :cond_5

    .line 254
    move v4, v3

    .line 255
    .local v4, "isPrevExponential":Z
    const/4 v3, 0x0

    .line 256
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 257
    .local v5, "currentChar":C
    const/16 v6, 0x20

    if-eq v5, v6, :cond_3

    const/16 v6, 0x45

    if-eq v5, v6, :cond_2

    const/16 v6, 0x65

    if-eq v5, v6, :cond_2

    const/4 v6, 0x1

    packed-switch v5, :pswitch_data_0

    goto :goto_1

    .line 270
    :pswitch_0
    if-nez v2, :cond_0

    .line 271
    const/4 v2, 0x1

    goto :goto_1

    .line 274
    :cond_0
    const/4 v1, 0x1

    .line 275
    iput-boolean v6, p2, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndWithNegOrDot:Z

    .line 277
    goto :goto_1

    .line 264
    :pswitch_1
    if-eq v0, p1, :cond_1

    if-nez v4, :cond_1

    .line 265
    const/4 v1, 0x1

    .line 266
    iput-boolean v6, p2, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndWithNegOrDot:Z

    goto :goto_1

    .line 264
    :cond_1
    goto :goto_1

    .line 280
    :cond_2
    const/4 v3, 0x1

    goto :goto_1

    .line 260
    :cond_3
    :pswitch_2
    const/4 v1, 0x1

    .line 261
    nop

    .line 283
    :goto_1
    if-eqz v1, :cond_4

    .line 284
    goto :goto_2

    .line 283
    :cond_4
    nop

    .line 253
    .end local v4    # "isPrevExponential":Z
    .end local v5    # "currentChar":C
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 289
    :cond_5
    :goto_2
    iput v0, p2, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndPosition:I

    .line 290
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x2c
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static getFloats(Ljava/lang/String;)[F
    .locals 9
    .param p0, "s"    # Ljava/lang/String;

    .line 201
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/4 v2, 0x1

    const/16 v3, 0x7a

    if-ne v1, v3, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x5a

    if-ne v3, v4, :cond_1

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    :goto_1
    or-int/2addr v1, v2

    if-eqz v1, :cond_2

    .line 202
    new-array v0, v0, [F

    return-object v0

    .line 205
    :cond_2
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    new-array v1, v1, [F

    .line 206
    .local v1, "results":[F
    const/4 v2, 0x0

    .line 207
    .local v2, "count":I
    const/4 v3, 0x1

    .line 208
    .local v3, "startPosition":I
    const/4 v4, 0x0

    .line 210
    .local v4, "endPosition":I
    new-instance v5, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;

    invoke-direct {v5}, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;-><init>()V

    .line 211
    .local v5, "result":Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    .line 216
    .local v6, "totalLength":I
    :goto_2
    if-ge v3, v6, :cond_5

    .line 217
    invoke-static {p0, v3, v5}, Landroid/support/graphics/drawable/PathParser;->extract(Ljava/lang/String;ILandroid/support/graphics/drawable/PathParser$ExtractFloatResult;)V

    .line 218
    iget v7, v5, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndPosition:I

    move v4, v7

    .line 220
    if-ge v3, v4, :cond_3

    .line 221
    add-int/lit8 v7, v2, 0x1

    .line 222
    .end local v2    # "count":I
    .local v7, "count":I
    invoke-virtual {p0, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    .line 221
    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v8

    aput v8, v1, v2

    move v2, v7

    goto :goto_3

    .line 220
    .end local v7    # "count":I
    .restart local v2    # "count":I
    :cond_3
    nop

    .line 225
    :goto_3
    iget-boolean v7, v5, Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;->mEndWithNegOrDot:Z

    if-eqz v7, :cond_4

    .line 227
    move v3, v4

    goto :goto_2

    .line 229
    :cond_4
    add-int/lit8 v3, v4, 0x1

    goto :goto_2

    .line 232
    :cond_5
    invoke-static {v1, v0, v2}, Landroid/support/graphics/drawable/PathParser;->copyOfRange([FII)[F

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 233
    .end local v1    # "results":[F
    .end local v2    # "count":I
    .end local v3    # "startPosition":I
    .end local v4    # "endPosition":I
    .end local v5    # "result":Landroid/support/graphics/drawable/PathParser$ExtractFloatResult;
    .end local v6    # "totalLength":I
    :catch_0
    move-exception v0

    .line 234
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "error in parsing \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    return-void
.end method

.method private static nextStart(Ljava/lang/String;I)I
    .locals 3
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "end"    # I

    .line 164
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p1, v0, :cond_2

    .line 165
    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 170
    .local v0, "c":C
    add-int/lit8 v1, v0, -0x41

    add-int/lit8 v2, v0, -0x5a

    mul-int v1, v1, v2

    if-lez v1, :cond_0

    add-int/lit8 v1, v0, -0x61

    add-int/lit8 v2, v0, -0x7a

    mul-int v1, v1, v2

    if-gtz v1, :cond_1

    :cond_0
    const/16 v1, 0x65

    if-eq v0, v1, :cond_1

    const/16 v1, 0x45

    if-eq v0, v1, :cond_1

    .line 172
    return p1

    .line 170
    :cond_1
    nop

    .line 174
    nop

    .end local v0    # "c":C
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 176
    :cond_2
    return p1
.end method

.method public static updateNodes([Landroid/support/graphics/drawable/PathParser$PathDataNode;[Landroid/support/graphics/drawable/PathParser$PathDataNode;)V
    .locals 4
    .param p0, "target"    # [Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .param p1, "source"    # [Landroid/support/graphics/drawable/PathParser$PathDataNode;

    .line 153
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_1

    .line 154
    aget-object v1, p0, v0

    aget-object v2, p1, v0

    iget-char v2, v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mType:C

    iput-char v2, v1, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mType:C

    .line 155
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    aget-object v2, p1, v0

    iget-object v2, v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mParams:[F

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 156
    aget-object v2, p0, v0

    iget-object v2, v2, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mParams:[F

    aget-object v3, p1, v0

    iget-object v3, v3, Landroid/support/graphics/drawable/PathParser$PathDataNode;->mParams:[F

    aget v3, v3, v1

    aput v3, v2, v1

    .line 155
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 153
    .end local v1    # "j":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 159
    .end local v0    # "i":I
    :cond_1
    return-void
.end method
