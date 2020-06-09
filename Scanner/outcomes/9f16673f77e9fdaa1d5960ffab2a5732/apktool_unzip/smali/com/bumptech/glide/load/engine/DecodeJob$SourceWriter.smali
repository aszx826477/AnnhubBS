.class Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;
.super Ljava/lang/Object;
.source "DecodeJob.java"

# interfaces
.implements Lcom/bumptech/glide/load/engine/cache/DiskCache$Writer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/load/engine/DecodeJob;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SourceWriter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<DataType:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/load/engine/cache/DiskCache$Writer;"
    }
.end annotation


# instance fields
.field private final data:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TDataType;"
        }
    .end annotation
.end field

.field private final encoder:Lcom/bumptech/glide/load/Encoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/load/Encoder<",
            "TDataType;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/bumptech/glide/load/engine/DecodeJob;


# direct methods
.method public constructor <init>(Lcom/bumptech/glide/load/engine/DecodeJob;Lcom/bumptech/glide/load/Encoder;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/Encoder<",
            "TDataType;>;TDataType;)V"
        }
    .end annotation

    .line 259
    .local p0, "this":Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;, "Lcom/bumptech/glide/load/engine/DecodeJob<TA;TT;TZ;>.SourceWriter<TDataType;>;"
    .local p2, "encoder":Lcom/bumptech/glide/load/Encoder;, "Lcom/bumptech/glide/load/Encoder<TDataType;>;"
    .local p3, "data":Ljava/lang/Object;, "TDataType;"
    iput-object p1, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->this$0:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 260
    iput-object p2, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->encoder:Lcom/bumptech/glide/load/Encoder;

    .line 261
    iput-object p3, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->data:Ljava/lang/Object;

    .line 262
    return-void
.end method


# virtual methods
.method public write(Ljava/io/File;)Z
    .locals 5
    .param p1, "file"    # Ljava/io/File;

    .line 266
    .local p0, "this":Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;, "Lcom/bumptech/glide/load/engine/DecodeJob<TA;TT;TZ;>.SourceWriter<TDataType;>;"
    const/4 v0, 0x0

    .line 267
    .local v0, "success":Z
    const/4 v1, 0x0

    .line 269
    .local v1, "os":Ljava/io/OutputStream;
    :try_start_0
    iget-object v2, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->this$0:Lcom/bumptech/glide/load/engine/DecodeJob;

    invoke-static {v2}, Lcom/bumptech/glide/load/engine/DecodeJob;->access$000(Lcom/bumptech/glide/load/engine/DecodeJob;)Lcom/bumptech/glide/load/engine/DecodeJob$FileOpener;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/bumptech/glide/load/engine/DecodeJob$FileOpener;->open(Ljava/io/File;)Ljava/io/OutputStream;

    move-result-object v2

    move-object v1, v2

    .line 270
    iget-object v2, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->encoder:Lcom/bumptech/glide/load/Encoder;

    iget-object v3, p0, Lcom/bumptech/glide/load/engine/DecodeJob$SourceWriter;->data:Ljava/lang/Object;

    invoke-interface {v2, v3, v1}, Lcom/bumptech/glide/load/Encoder;->encode(Ljava/lang/Object;Ljava/io/OutputStream;)Z

    move-result v2
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move v0, v2

    .line 276
    if-eqz v1, :cond_0

    .line 278
    :try_start_1
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 281
    :goto_0
    goto :goto_2

    .line 279
    :catch_0
    move-exception v2

    goto :goto_0

    .line 276
    :cond_0
    goto :goto_2

    :catchall_0
    move-exception v2

    goto :goto_3

    .line 271
    :catch_1
    move-exception v2

    .line 272
    .local v2, "e":Ljava/io/FileNotFoundException;
    :try_start_2
    const-string v3, "DecodeJob"

    const/4 v4, 0x3

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 273
    const-string v3, "DecodeJob"

    const-string v4, "Failed to find file to write to disk cache"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 272
    :cond_1
    nop

    .line 276
    .end local v2    # "e":Ljava/io/FileNotFoundException;
    :goto_1
    if-eqz v1, :cond_0

    .line 278
    :try_start_3
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    .line 284
    :goto_2
    return v0

    .line 276
    :goto_3
    if-eqz v1, :cond_2

    .line 278
    :try_start_4
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 281
    goto :goto_4

    .line 279
    :catch_2
    move-exception v3

    goto :goto_4

    .line 276
    :cond_2
    nop

    .line 281
    :goto_4
    throw v2

    return-void
.end method
