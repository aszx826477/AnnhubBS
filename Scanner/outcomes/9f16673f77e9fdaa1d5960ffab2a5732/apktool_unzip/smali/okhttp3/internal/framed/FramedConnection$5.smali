.class Lokhttp3/internal/framed/FramedConnection$5;
.super Lokhttp3/internal/NamedRunnable;
.source "FramedConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lokhttp3/internal/framed/FramedConnection;->pushHeadersLater(ILjava/util/List;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lokhttp3/internal/framed/FramedConnection;

.field final synthetic val$inFinished:Z

.field final synthetic val$requestHeaders:Ljava/util/List;

.field final synthetic val$streamId:I


# direct methods
.method varargs constructor <init>(Lokhttp3/internal/framed/FramedConnection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;Z)V
    .locals 0
    .param p1, "this$0"    # Lokhttp3/internal/framed/FramedConnection;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "args"    # [Ljava/lang/Object;

    .line 844
    iput-object p1, p0, Lokhttp3/internal/framed/FramedConnection$5;->this$0:Lokhttp3/internal/framed/FramedConnection;

    iput p4, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$streamId:I

    iput-object p5, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$requestHeaders:Ljava/util/List;

    iput-boolean p6, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$inFinished:Z

    invoke-direct {p0, p2, p3}, Lokhttp3/internal/NamedRunnable;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 4

    .line 846
    iget-object v0, p0, Lokhttp3/internal/framed/FramedConnection$5;->this$0:Lokhttp3/internal/framed/FramedConnection;

    invoke-static {v0}, Lokhttp3/internal/framed/FramedConnection;->access$2700(Lokhttp3/internal/framed/FramedConnection;)Lokhttp3/internal/framed/PushObserver;

    move-result-object v0

    iget v1, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$streamId:I

    iget-object v2, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$requestHeaders:Ljava/util/List;

    iget-boolean v3, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$inFinished:Z

    invoke-interface {v0, v1, v2, v3}, Lokhttp3/internal/framed/PushObserver;->onHeaders(ILjava/util/List;Z)Z

    move-result v0

    .line 848
    .local v0, "cancel":Z
    if-eqz v0, :cond_0

    :try_start_0
    iget-object v1, p0, Lokhttp3/internal/framed/FramedConnection$5;->this$0:Lokhttp3/internal/framed/FramedConnection;

    iget-object v1, v1, Lokhttp3/internal/framed/FramedConnection;->frameWriter:Lokhttp3/internal/framed/FrameWriter;

    iget v2, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$streamId:I

    sget-object v3, Lokhttp3/internal/framed/ErrorCode;->CANCEL:Lokhttp3/internal/framed/ErrorCode;

    invoke-interface {v1, v2, v3}, Lokhttp3/internal/framed/FrameWriter;->rstStream(ILokhttp3/internal/framed/ErrorCode;)V

    goto :goto_0

    .line 854
    :catch_0
    move-exception v1

    goto :goto_3

    .line 848
    :cond_0
    :goto_0
    nop

    .line 849
    if-nez v0, :cond_2

    iget-boolean v1, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$inFinished:Z

    if-eqz v1, :cond_1

    goto :goto_1

    :cond_1
    goto :goto_2

    .line 850
    :cond_2
    :goto_1
    iget-object v1, p0, Lokhttp3/internal/framed/FramedConnection$5;->this$0:Lokhttp3/internal/framed/FramedConnection;

    monitor-enter v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 851
    :try_start_1
    iget-object v2, p0, Lokhttp3/internal/framed/FramedConnection$5;->this$0:Lokhttp3/internal/framed/FramedConnection;

    invoke-static {v2}, Lokhttp3/internal/framed/FramedConnection;->access$2800(Lokhttp3/internal/framed/FramedConnection;)Ljava/util/Set;

    move-result-object v2

    iget v3, p0, Lokhttp3/internal/framed/FramedConnection$5;->val$streamId:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 852
    monitor-exit v1

    .line 855
    :goto_2
    goto :goto_4

    .line 852
    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v0    # "cancel":Z
    :try_start_2
    throw v2
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 854
    .restart local v0    # "cancel":Z
    :goto_3
    nop

    .line 856
    :goto_4
    return-void
.end method
