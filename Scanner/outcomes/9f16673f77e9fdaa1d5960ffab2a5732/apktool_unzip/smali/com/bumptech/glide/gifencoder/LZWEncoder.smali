.class Lcom/bumptech/glide/gifencoder/LZWEncoder;
.super Ljava/lang/Object;
.source "LZWEncoder.java"


# static fields
.field static final BITS:I = 0xc

.field private static final EOF:I = -0x1

.field static final HSIZE:I = 0x138b


# instance fields
.field ClearCode:I

.field EOFCode:I

.field a_count:I

.field accum:[B

.field clear_flg:Z

.field codetab:[I

.field private curPixel:I

.field cur_accum:I

.field cur_bits:I

.field free_ent:I

.field g_init_bits:I

.field hsize:I

.field htab:[I

.field private imgH:I

.field private imgW:I

.field private initCodeSize:I

.field masks:[I

.field maxbits:I

.field maxcode:I

.field maxmaxcode:I

.field n_bits:I

.field private pixAry:[B

.field private remaining:I


# direct methods
.method constructor <init>(II[BI)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "pixels"    # [B
    .param p4, "color_depth"    # I

    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const/16 v0, 0xc

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxbits:I

    .line 52
    const/16 v0, 0x1000

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxmaxcode:I

    .line 54
    const/16 v0, 0x138b

    new-array v1, v0, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->htab:[I

    .line 56
    new-array v1, v0, [I

    iput-object v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->codetab:[I

    .line 58
    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->hsize:I

    .line 60
    const/4 v0, 0x0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    .line 64
    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    .line 99
    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    .line 101
    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    .line 103
    const/16 v0, 0x11

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->masks:[I

    .line 110
    const/16 v0, 0x100

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->accum:[B

    .line 114
    iput p1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->imgW:I

    .line 115
    iput p2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->imgH:I

    .line 116
    iput-object p3, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->pixAry:[B

    .line 117
    const/4 v0, 0x2

    invoke-static {v0, p4}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->initCodeSize:I

    .line 118
    return-void

    nop

    :array_0
    .array-data 4
        0x0
        0x1
        0x3
        0x7
        0xf
        0x1f
        0x3f
        0x7f
        0xff
        0x1ff
        0x3ff
        0x7ff
        0xfff
        0x1fff
        0x3fff
        0x7fff
        0xffff
    .end array-data
.end method

.method private nextPixel()I
    .locals 3

    .line 245
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->remaining:I

    if-nez v0, :cond_0

    .line 246
    const/4 v0, -0x1

    return v0

    .line 248
    :cond_0
    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->remaining:I

    .line 250
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->pixAry:[B

    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->curPixel:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->curPixel:I

    aget-byte v0, v0, v1

    .line 252
    .local v0, "pix":B
    and-int/lit16 v1, v0, 0xff

    return v1
.end method


# virtual methods
.method final MAXCODE(I)I
    .locals 2
    .param p1, "n_bits"    # I

    .line 238
    const/4 v0, 0x1

    shl-int v1, v0, p1

    sub-int/2addr v1, v0

    return v1
.end method

.method char_out(BLjava/io/OutputStream;)V
    .locals 3
    .param p1, "c"    # B
    .param p2, "outs"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 123
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->accum:[B

    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    aput-byte p1, v0, v1

    .line 124
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    const/16 v1, 0xfe

    if-lt v0, v1, :cond_0

    .line 125
    invoke-virtual {p0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->flush_char(Ljava/io/OutputStream;)V

    goto :goto_0

    .line 124
    :cond_0
    nop

    .line 126
    :goto_0
    return-void
.end method

.method cl_block(Ljava/io/OutputStream;)V
    .locals 2
    .param p1, "outs"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 132
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->hsize:I

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cl_hash(I)V

    .line 133
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->ClearCode:I

    add-int/lit8 v1, v0, 0x2

    iput v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    .line 134
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    .line 136
    invoke-virtual {p0, v0, p1}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->output(ILjava/io/OutputStream;)V

    .line 137
    return-void
.end method

.method cl_hash(I)V
    .locals 3
    .param p1, "hsize"    # I

    .line 141
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_0

    .line 142
    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->htab:[I

    const/4 v2, -0x1

    aput v2, v1, v0

    .line 141
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 143
    .end local v0    # "i":I
    :cond_0
    return-void
.end method

.method compress(ILjava/io/OutputStream;)V
    .locals 9
    .param p1, "init_bits"    # I
    .param p2, "outs"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 155
    iput p1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->g_init_bits:I

    .line 158
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    .line 159
    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->g_init_bits:I

    iput v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    .line 160
    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    invoke-virtual {p0, v1}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->MAXCODE(I)I

    move-result v1

    iput v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxcode:I

    .line 162
    add-int/lit8 v1, p1, -0x1

    const/4 v2, 0x1

    shl-int v1, v2, v1

    iput v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->ClearCode:I

    .line 163
    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->ClearCode:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->EOFCode:I

    .line 164
    add-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    .line 166
    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    .line 168
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->nextPixel()I

    move-result v0

    .line 170
    .local v0, "ent":I
    const/4 v1, 0x0

    .line 171
    .local v1, "hshift":I
    iget v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->hsize:I

    .local v2, "fcode":I
    :goto_0
    const/high16 v3, 0x10000

    if-ge v2, v3, :cond_0

    .line 172
    add-int/lit8 v1, v1, 0x1

    .line 171
    mul-int/lit8 v2, v2, 0x2

    goto :goto_0

    .line 173
    :cond_0
    rsub-int/lit8 v1, v1, 0x8

    .line 175
    iget v3, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->hsize:I

    .line 176
    .local v3, "hsize_reg":I
    invoke-virtual {p0, v3}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cl_hash(I)V

    .line 178
    iget v4, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->ClearCode:I

    invoke-virtual {p0, v4, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->output(ILjava/io/OutputStream;)V

    .line 181
    :goto_1
    invoke-direct {p0}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->nextPixel()I

    move-result v4

    move v5, v4

    .local v5, "c":I
    const/4 v6, -0x1

    if-eq v4, v6, :cond_8

    .line 182
    iget v4, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxbits:I

    shl-int v4, v5, v4

    add-int v2, v4, v0

    .line 183
    shl-int v4, v5, v1

    xor-int/2addr v4, v0

    .line 185
    .local v4, "i":I
    iget-object v6, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->htab:[I

    aget v7, v6, v4

    if-ne v7, v2, :cond_1

    .line 186
    iget-object v6, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->codetab:[I

    aget v0, v6, v4

    .line 187
    goto :goto_1

    .line 188
    :cond_1
    aget v6, v6, v4

    if-ltz v6, :cond_6

    .line 190
    sub-int v6, v3, v4

    .line 191
    .local v6, "disp":I
    if-nez v4, :cond_2

    .line 192
    const/4 v6, 0x1

    goto :goto_2

    .line 191
    :cond_2
    nop

    .line 194
    :goto_2
    sub-int v7, v4, v6

    move v4, v7

    if-gez v7, :cond_3

    .line 195
    add-int/2addr v4, v3

    goto :goto_3

    .line 194
    :cond_3
    nop

    .line 197
    :goto_3
    iget-object v7, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->htab:[I

    aget v8, v7, v4

    if-ne v8, v2, :cond_4

    .line 198
    iget-object v7, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->codetab:[I

    aget v0, v7, v4

    .line 199
    goto :goto_1

    .line 201
    :cond_4
    aget v7, v7, v4

    if-gez v7, :cond_5

    goto :goto_4

    :cond_5
    goto :goto_2

    .line 188
    .end local v6    # "disp":I
    :cond_6
    nop

    .line 203
    :goto_4
    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->output(ILjava/io/OutputStream;)V

    .line 204
    move v0, v5

    .line 205
    iget v6, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    iget v7, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxmaxcode:I

    if-ge v6, v7, :cond_7

    .line 206
    iget-object v7, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->codetab:[I

    add-int/lit8 v8, v6, 0x1

    iput v8, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    aput v6, v7, v4

    .line 207
    iget-object v6, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->htab:[I

    aput v2, v6, v4

    goto :goto_1

    .line 209
    :cond_7
    invoke-virtual {p0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cl_block(Ljava/io/OutputStream;)V

    goto :goto_1

    .line 212
    .end local v4    # "i":I
    :cond_8
    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->output(ILjava/io/OutputStream;)V

    .line 213
    iget v4, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->EOFCode:I

    invoke-virtual {p0, v4, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->output(ILjava/io/OutputStream;)V

    .line 214
    return-void
.end method

.method encode(Ljava/io/OutputStream;)V
    .locals 2
    .param p1, "os"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 218
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->initCodeSize:I

    invoke-virtual {p1, v0}, Ljava/io/OutputStream;->write(I)V

    .line 220
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->imgW:I

    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->imgH:I

    mul-int v0, v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->remaining:I

    .line 221
    const/4 v0, 0x0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->curPixel:I

    .line 223
    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->initCodeSize:I

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v1, p1}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->compress(ILjava/io/OutputStream;)V

    .line 225
    invoke-virtual {p1, v0}, Ljava/io/OutputStream;->write(I)V

    .line 226
    return-void
.end method

.method flush_char(Ljava/io/OutputStream;)V
    .locals 3
    .param p1, "outs"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 230
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    if-lez v0, :cond_0

    .line 231
    invoke-virtual {p1, v0}, Ljava/io/OutputStream;->write(I)V

    .line 232
    iget-object v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->accum:[B

    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Ljava/io/OutputStream;->write([BII)V

    .line 233
    iput v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->a_count:I

    goto :goto_0

    .line 230
    :cond_0
    nop

    .line 235
    :goto_0
    return-void
.end method

.method output(ILjava/io/OutputStream;)V
    .locals 3
    .param p1, "code"    # I
    .param p2, "outs"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 256
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    iget-object v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->masks:[I

    iget v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    aget v1, v1, v2

    and-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    .line 258
    if-lez v2, :cond_0

    .line 259
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    shl-int v1, p1, v2

    or-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    goto :goto_0

    .line 261
    :cond_0
    iput p1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    .line 263
    :goto_0
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    iget v1, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    .line 265
    :goto_1
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_1

    .line 266
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->char_out(BLjava/io/OutputStream;)V

    .line 267
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    shr-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    .line 268
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    goto :goto_1

    .line 273
    :cond_1
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->free_ent:I

    iget v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxcode:I

    if-gt v0, v2, :cond_3

    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    if-eqz v0, :cond_2

    goto :goto_2

    :cond_2
    goto :goto_3

    .line 274
    :cond_3
    :goto_2
    iget-boolean v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    if-eqz v0, :cond_4

    .line 275
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->g_init_bits:I

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    invoke-virtual {p0, v0}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->MAXCODE(I)I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxcode:I

    .line 276
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->clear_flg:Z

    goto :goto_3

    .line 278
    :cond_4
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    .line 279
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->n_bits:I

    iget v2, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxbits:I

    if-ne v0, v2, :cond_5

    .line 280
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxmaxcode:I

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxcode:I

    goto :goto_3

    .line 282
    :cond_5
    invoke-virtual {p0, v0}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->MAXCODE(I)I

    move-result v0

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->maxcode:I

    .line 286
    :goto_3
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->EOFCode:I

    if-ne p1, v0, :cond_7

    .line 288
    :goto_4
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    if-lez v0, :cond_6

    .line 289
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    invoke-virtual {p0, v0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->char_out(BLjava/io/OutputStream;)V

    .line 290
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    shr-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_accum:I

    .line 291
    iget v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/bumptech/glide/gifencoder/LZWEncoder;->cur_bits:I

    goto :goto_4

    .line 294
    :cond_6
    invoke-virtual {p0, p2}, Lcom/bumptech/glide/gifencoder/LZWEncoder;->flush_char(Ljava/io/OutputStream;)V

    goto :goto_5

    .line 286
    :cond_7
    nop

    .line 296
    :goto_5
    return-void
.end method
