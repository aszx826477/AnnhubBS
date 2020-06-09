.class final Lokhttp3/internal/framed/Huffman$Node;
.super Ljava/lang/Object;
.source "Huffman.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/framed/Huffman;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Node"
.end annotation


# instance fields
.field private final children:[Lokhttp3/internal/framed/Huffman$Node;

.field private final symbol:I

.field private final terminalBits:I


# direct methods
.method constructor <init>()V
    .locals 1

    .line 207
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 208
    const/16 v0, 0x100

    new-array v0, v0, [Lokhttp3/internal/framed/Huffman$Node;

    iput-object v0, p0, Lokhttp3/internal/framed/Huffman$Node;->children:[Lokhttp3/internal/framed/Huffman$Node;

    .line 209
    const/4 v0, 0x0

    iput v0, p0, Lokhttp3/internal/framed/Huffman$Node;->symbol:I

    .line 210
    iput v0, p0, Lokhttp3/internal/framed/Huffman$Node;->terminalBits:I

    .line 211
    return-void
.end method

.method constructor <init>(II)V
    .locals 2
    .param p1, "symbol"    # I
    .param p2, "bits"    # I

    .line 219
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 220
    const/4 v0, 0x0

    iput-object v0, p0, Lokhttp3/internal/framed/Huffman$Node;->children:[Lokhttp3/internal/framed/Huffman$Node;

    .line 221
    iput p1, p0, Lokhttp3/internal/framed/Huffman$Node;->symbol:I

    .line 222
    and-int/lit8 v0, p2, 0x7

    .line 223
    .local v0, "b":I
    if-nez v0, :cond_0

    const/16 v1, 0x8

    goto :goto_0

    :cond_0
    move v1, v0

    :goto_0
    iput v1, p0, Lokhttp3/internal/framed/Huffman$Node;->terminalBits:I

    .line 224
    return-void
.end method

.method static synthetic access$000(Lokhttp3/internal/framed/Huffman$Node;)[Lokhttp3/internal/framed/Huffman$Node;
    .locals 1
    .param p0, "x0"    # Lokhttp3/internal/framed/Huffman$Node;

    .line 195
    iget-object v0, p0, Lokhttp3/internal/framed/Huffman$Node;->children:[Lokhttp3/internal/framed/Huffman$Node;

    return-object v0
.end method

.method static synthetic access$100(Lokhttp3/internal/framed/Huffman$Node;)I
    .locals 1
    .param p0, "x0"    # Lokhttp3/internal/framed/Huffman$Node;

    .line 195
    iget v0, p0, Lokhttp3/internal/framed/Huffman$Node;->symbol:I

    return v0
.end method

.method static synthetic access$200(Lokhttp3/internal/framed/Huffman$Node;)I
    .locals 1
    .param p0, "x0"    # Lokhttp3/internal/framed/Huffman$Node;

    .line 195
    iget v0, p0, Lokhttp3/internal/framed/Huffman$Node;->terminalBits:I

    return v0
.end method
