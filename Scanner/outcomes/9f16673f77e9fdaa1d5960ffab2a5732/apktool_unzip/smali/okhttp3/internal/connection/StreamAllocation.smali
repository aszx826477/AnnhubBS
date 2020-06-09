.class public final Lokhttp3/internal/connection/StreamAllocation;
.super Ljava/lang/Object;
.source "StreamAllocation.java"


# instance fields
.field public final address:Lokhttp3/Address;

.field private canceled:Z

.field private connection:Lokhttp3/internal/connection/RealConnection;

.field private final connectionPool:Lokhttp3/ConnectionPool;

.field private refusedStreamCount:I

.field private released:Z

.field private route:Lokhttp3/Route;

.field private final routeSelector:Lokhttp3/internal/connection/RouteSelector;

.field private stream:Lokhttp3/internal/http/HttpStream;


# direct methods
.method public constructor <init>(Lokhttp3/ConnectionPool;Lokhttp3/Address;)V
    .locals 2
    .param p1, "connectionPool"    # Lokhttp3/ConnectionPool;
    .param p2, "address"    # Lokhttp3/Address;

    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    iput-object p1, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    .line 87
    iput-object p2, p0, Lokhttp3/internal/connection/StreamAllocation;->address:Lokhttp3/Address;

    .line 88
    new-instance v0, Lokhttp3/internal/connection/RouteSelector;

    invoke-direct {p0}, Lokhttp3/internal/connection/StreamAllocation;->routeDatabase()Lokhttp3/internal/connection/RouteDatabase;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lokhttp3/internal/connection/RouteSelector;-><init>(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;)V

    iput-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->routeSelector:Lokhttp3/internal/connection/RouteSelector;

    .line 89
    return-void
.end method

.method private deallocate(ZZZ)V
    .locals 6
    .param p1, "noNewStreams"    # Z
    .param p2, "released"    # Z
    .param p3, "streamFinished"    # Z

    .line 240
    const/4 v0, 0x0

    .line 241
    .local v0, "connectionToClose":Lokhttp3/internal/connection/RealConnection;
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v1

    .line 242
    const/4 v2, 0x0

    if-eqz p3, :cond_0

    .line 243
    :try_start_0
    iput-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    goto :goto_0

    .line 263
    :catchall_0
    move-exception v2

    goto :goto_6

    .line 242
    :cond_0
    nop

    .line 245
    :goto_0
    const/4 v3, 0x1

    if-eqz p2, :cond_1

    .line 246
    iput-boolean v3, p0, Lokhttp3/internal/connection/StreamAllocation;->released:Z

    goto :goto_1

    .line 245
    :cond_1
    nop

    .line 248
    :goto_1
    iget-object v4, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    if-eqz v4, :cond_7

    .line 249
    if-eqz p1, :cond_2

    .line 250
    iget-object v4, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    iput-boolean v3, v4, Lokhttp3/internal/connection/RealConnection;->noNewStreams:Z

    goto :goto_2

    .line 249
    :cond_2
    nop

    .line 252
    :goto_2
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    if-nez v3, :cond_6

    iget-boolean v3, p0, Lokhttp3/internal/connection/StreamAllocation;->released:Z

    if-nez v3, :cond_3

    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    iget-boolean v3, v3, Lokhttp3/internal/connection/RealConnection;->noNewStreams:Z

    if-eqz v3, :cond_6

    .line 253
    :cond_3
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    invoke-direct {p0, v3}, Lokhttp3/internal/connection/StreamAllocation;->release(Lokhttp3/internal/connection/RealConnection;)V

    .line 254
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    iget-object v3, v3, Lokhttp3/internal/connection/RealConnection;->allocations:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 255
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    iput-wide v4, v3, Lokhttp3/internal/connection/RealConnection;->idleAtNanos:J

    .line 256
    sget-object v3, Lokhttp3/internal/Internal;->instance:Lokhttp3/internal/Internal;

    iget-object v4, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    iget-object v5, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    invoke-virtual {v3, v4, v5}, Lokhttp3/internal/Internal;->connectionBecameIdle(Lokhttp3/ConnectionPool;Lokhttp3/internal/connection/RealConnection;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 257
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    move-object v0, v3

    goto :goto_3

    .line 256
    :cond_4
    goto :goto_3

    .line 254
    :cond_5
    nop

    .line 260
    :goto_3
    iput-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    goto :goto_4

    .line 252
    :cond_6
    goto :goto_4

    .line 248
    :cond_7
    nop

    .line 263
    :goto_4
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 264
    if-eqz v0, :cond_8

    .line 265
    invoke-virtual {v0}, Lokhttp3/internal/connection/RealConnection;->socket()Ljava/net/Socket;

    move-result-object v1

    invoke-static {v1}, Lokhttp3/internal/Util;->closeQuietly(Ljava/net/Socket;)V

    goto :goto_5

    .line 264
    :cond_8
    nop

    .line 267
    :goto_5
    return-void

    .line 263
    :goto_6
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method private findConnection(IIIZ)Lokhttp3/internal/connection/RealConnection;
    .locals 9
    .param p1, "connectTimeout"    # I
    .param p2, "readTimeout"    # I
    .param p3, "writeTimeout"    # I
    .param p4, "connectionRetryEnabled"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 157
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v0

    .line 158
    :try_start_0
    iget-boolean v1, p0, Lokhttp3/internal/connection/StreamAllocation;->released:Z

    if-nez v1, :cond_6

    .line 159
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    if-nez v1, :cond_5

    .line 160
    iget-boolean v1, p0, Lokhttp3/internal/connection/StreamAllocation;->canceled:Z

    if-nez v1, :cond_4

    .line 162
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    .line 163
    .local v1, "allocatedConnection":Lokhttp3/internal/connection/RealConnection;
    if-eqz v1, :cond_0

    iget-boolean v2, v1, Lokhttp3/internal/connection/RealConnection;->noNewStreams:Z

    if-nez v2, :cond_0

    .line 164
    monitor-exit v0

    return-object v1

    .line 163
    :cond_0
    nop

    .line 168
    sget-object v2, Lokhttp3/internal/Internal;->instance:Lokhttp3/internal/Internal;

    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    iget-object v4, p0, Lokhttp3/internal/connection/StreamAllocation;->address:Lokhttp3/Address;

    invoke-virtual {v2, v3, v4, p0}, Lokhttp3/internal/Internal;->get(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/connection/RealConnection;

    move-result-object v2

    .line 169
    .local v2, "pooledConnection":Lokhttp3/internal/connection/RealConnection;
    if-eqz v2, :cond_1

    .line 170
    iput-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    .line 171
    monitor-exit v0

    return-object v2

    .line 174
    :cond_1
    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    move-object v1, v3

    .line 175
    .end local v2    # "pooledConnection":Lokhttp3/internal/connection/RealConnection;
    .local v1, "selectedRoute":Lokhttp3/Route;
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 177
    if-nez v1, :cond_2

    .line 178
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->routeSelector:Lokhttp3/internal/connection/RouteSelector;

    invoke-virtual {v0}, Lokhttp3/internal/connection/RouteSelector;->next()Lokhttp3/Route;

    move-result-object v0

    .line 179
    .end local v1    # "selectedRoute":Lokhttp3/Route;
    .local v0, "selectedRoute":Lokhttp3/Route;
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v2

    .line 180
    :try_start_1
    iput-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    .line 181
    const/4 v1, 0x0

    iput v1, p0, Lokhttp3/internal/connection/StreamAllocation;->refusedStreamCount:I

    .line 182
    monitor-exit v2

    move-object v1, v0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 177
    .end local v0    # "selectedRoute":Lokhttp3/Route;
    .restart local v1    # "selectedRoute":Lokhttp3/Route;
    :cond_2
    nop

    .line 184
    :goto_0
    new-instance v0, Lokhttp3/internal/connection/RealConnection;

    invoke-direct {v0, v1}, Lokhttp3/internal/connection/RealConnection;-><init>(Lokhttp3/Route;)V

    move-object v8, v0

    .line 185
    .local v8, "newConnection":Lokhttp3/internal/connection/RealConnection;
    invoke-virtual {p0, v8}, Lokhttp3/internal/connection/StreamAllocation;->acquire(Lokhttp3/internal/connection/RealConnection;)V

    .line 187
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v2

    .line 188
    :try_start_2
    sget-object v0, Lokhttp3/internal/Internal;->instance:Lokhttp3/internal/Internal;

    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    invoke-virtual {v0, v3, v8}, Lokhttp3/internal/Internal;->put(Lokhttp3/ConnectionPool;Lokhttp3/internal/connection/RealConnection;)V

    .line 189
    iput-object v8, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    .line 190
    iget-boolean v0, p0, Lokhttp3/internal/connection/StreamAllocation;->canceled:Z

    if-nez v0, :cond_3

    .line 191
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 193
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->address:Lokhttp3/Address;

    invoke-virtual {v0}, Lokhttp3/Address;->connectionSpecs()Ljava/util/List;

    move-result-object v6

    move-object v2, v8

    move v3, p1

    move v4, p2

    move v5, p3

    move v7, p4

    invoke-virtual/range {v2 .. v7}, Lokhttp3/internal/connection/RealConnection;->connect(IIILjava/util/List;Z)V

    .line 195
    invoke-direct {p0}, Lokhttp3/internal/connection/StreamAllocation;->routeDatabase()Lokhttp3/internal/connection/RouteDatabase;

    move-result-object v0

    invoke-virtual {v8}, Lokhttp3/internal/connection/RealConnection;->route()Lokhttp3/Route;

    move-result-object v2

    invoke-virtual {v0, v2}, Lokhttp3/internal/connection/RouteDatabase;->connected(Lokhttp3/Route;)V

    .line 197
    return-object v8

    .line 190
    :cond_3
    :try_start_3
    new-instance v0, Ljava/io/IOException;

    const-string v3, "Canceled"

    invoke-direct {v0, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    .end local v1    # "selectedRoute":Lokhttp3/Route;
    .end local v8    # "newConnection":Lokhttp3/internal/connection/RealConnection;
    .end local p1    # "connectTimeout":I
    .end local p2    # "readTimeout":I
    .end local p3    # "writeTimeout":I
    .end local p4    # "connectionRetryEnabled":Z
    throw v0

    .line 191
    .restart local v1    # "selectedRoute":Lokhttp3/Route;
    .restart local v8    # "newConnection":Lokhttp3/internal/connection/RealConnection;
    .restart local p1    # "connectTimeout":I
    .restart local p2    # "readTimeout":I
    .restart local p3    # "writeTimeout":I
    .restart local p4    # "connectionRetryEnabled":Z
    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 160
    .end local v1    # "selectedRoute":Lokhttp3/Route;
    .end local v8    # "newConnection":Lokhttp3/internal/connection/RealConnection;
    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/IOException;

    const-string v2, "Canceled"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    .end local p1    # "connectTimeout":I
    .end local p2    # "readTimeout":I
    .end local p3    # "writeTimeout":I
    .end local p4    # "connectionRetryEnabled":Z
    throw v1

    .line 159
    .restart local p1    # "connectTimeout":I
    .restart local p2    # "readTimeout":I
    .restart local p3    # "writeTimeout":I
    .restart local p4    # "connectionRetryEnabled":Z
    :cond_5
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "stream != null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local p1    # "connectTimeout":I
    .end local p2    # "readTimeout":I
    .end local p3    # "writeTimeout":I
    .end local p4    # "connectionRetryEnabled":Z
    throw v1

    .line 158
    .restart local p1    # "connectTimeout":I
    .restart local p2    # "readTimeout":I
    .restart local p3    # "writeTimeout":I
    .restart local p4    # "connectionRetryEnabled":Z
    :cond_6
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "released"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local p1    # "connectTimeout":I
    .end local p2    # "readTimeout":I
    .end local p3    # "writeTimeout":I
    .end local p4    # "connectionRetryEnabled":Z
    throw v1

    .line 175
    .restart local p1    # "connectTimeout":I
    .restart local p2    # "readTimeout":I
    .restart local p3    # "writeTimeout":I
    .restart local p4    # "connectionRetryEnabled":Z
    :catchall_2
    move-exception v1

    monitor-exit v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v1
.end method

.method private findHealthyConnection(IIIZZ)Lokhttp3/internal/connection/RealConnection;
    .locals 3
    .param p1, "connectTimeout"    # I
    .param p2, "readTimeout"    # I
    .param p3, "writeTimeout"    # I
    .param p4, "connectionRetryEnabled"    # Z
    .param p5, "doExtensiveHealthChecks"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 129
    :goto_0
    invoke-direct {p0, p1, p2, p3, p4}, Lokhttp3/internal/connection/StreamAllocation;->findConnection(IIIZ)Lokhttp3/internal/connection/RealConnection;

    move-result-object v0

    .line 133
    .local v0, "candidate":Lokhttp3/internal/connection/RealConnection;
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v1

    .line 134
    :try_start_0
    iget v2, v0, Lokhttp3/internal/connection/RealConnection;->successCount:I

    if-nez v2, :cond_0

    .line 135
    monitor-exit v1

    return-object v0

    .line 137
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 141
    invoke-virtual {v0, p5}, Lokhttp3/internal/connection/RealConnection;->isHealthy(Z)Z

    move-result v1

    if-nez v1, :cond_1

    .line 142
    invoke-virtual {p0}, Lokhttp3/internal/connection/StreamAllocation;->noNewStreams()V

    .line 143
    goto :goto_0

    .line 146
    :cond_1
    return-object v0

    .line 137
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    return-void
.end method

.method private release(Lokhttp3/internal/connection/RealConnection;)V
    .locals 4
    .param p1, "connection"    # Lokhttp3/internal/connection/RealConnection;

    .line 325
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v1, p1, Lokhttp3/internal/connection/RealConnection;->allocations:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    .local v1, "size":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 326
    iget-object v2, p1, Lokhttp3/internal/connection/RealConnection;->allocations:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/Reference;

    .line 327
    .local v2, "reference":Ljava/lang/ref/Reference;, "Ljava/lang/ref/Reference<Lokhttp3/internal/connection/StreamAllocation;>;"
    invoke-virtual {v2}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v3

    if-ne v3, p0, :cond_0

    .line 328
    iget-object v3, p1, Lokhttp3/internal/connection/RealConnection;->allocations:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 329
    return-void

    .line 327
    :cond_0
    nop

    .line 325
    .end local v2    # "reference":Ljava/lang/ref/Reference;, "Ljava/lang/ref/Reference<Lokhttp3/internal/connection/StreamAllocation;>;"
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 332
    .end local v0    # "i":I
    .end local v1    # "size":I
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    return-void
.end method

.method private routeDatabase()Lokhttp3/internal/connection/RouteDatabase;
    .locals 2

    .line 219
    sget-object v0, Lokhttp3/internal/Internal;->instance:Lokhttp3/internal/Internal;

    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    invoke-virtual {v0, v1}, Lokhttp3/internal/Internal;->routeDatabase(Lokhttp3/ConnectionPool;)Lokhttp3/internal/connection/RouteDatabase;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public acquire(Lokhttp3/internal/connection/RealConnection;)V
    .locals 2
    .param p1, "connection"    # Lokhttp3/internal/connection/RealConnection;

    .line 320
    iget-object v0, p1, Lokhttp3/internal/connection/RealConnection;->allocations:Ljava/util/List;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 321
    return-void
.end method

.method public cancel()V
    .locals 3

    .line 272
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v0

    .line 273
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lokhttp3/internal/connection/StreamAllocation;->canceled:Z

    .line 274
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    .line 275
    .local v1, "streamToCancel":Lokhttp3/internal/http/HttpStream;
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    .line 276
    .local v2, "connectionToCancel":Lokhttp3/internal/connection/RealConnection;
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 277
    if-eqz v1, :cond_0

    .line 278
    invoke-interface {v1}, Lokhttp3/internal/http/HttpStream;->cancel()V

    goto :goto_0

    .line 279
    :cond_0
    if-eqz v2, :cond_1

    .line 280
    invoke-virtual {v2}, Lokhttp3/internal/connection/RealConnection;->cancel()V

    goto :goto_0

    .line 279
    :cond_1
    nop

    .line 282
    :goto_0
    return-void

    .line 276
    .end local v1    # "streamToCancel":Lokhttp3/internal/http/HttpStream;
    .end local v2    # "connectionToCancel":Lokhttp3/internal/connection/RealConnection;
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public declared-synchronized connection()Lokhttp3/internal/connection/RealConnection;
    .locals 1

    monitor-enter p0

    .line 223
    :try_start_0
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Lokhttp3/internal/connection/StreamAllocation;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public hasMoreRoutes()Z
    .locals 1

    .line 336
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    if-nez v0, :cond_1

    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->routeSelector:Lokhttp3/internal/connection/RouteSelector;

    invoke-virtual {v0}, Lokhttp3/internal/connection/RouteSelector;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public newStream(Lokhttp3/OkHttpClient;Z)Lokhttp3/internal/http/HttpStream;
    .locals 10
    .param p1, "client"    # Lokhttp3/OkHttpClient;
    .param p2, "doExtensiveHealthChecks"    # Z

    .line 92
    invoke-virtual {p1}, Lokhttp3/OkHttpClient;->connectTimeoutMillis()I

    move-result v6

    .line 93
    .local v6, "connectTimeout":I
    invoke-virtual {p1}, Lokhttp3/OkHttpClient;->readTimeoutMillis()I

    move-result v7

    .line 94
    .local v7, "readTimeout":I
    invoke-virtual {p1}, Lokhttp3/OkHttpClient;->writeTimeoutMillis()I

    move-result v8

    .line 95
    .local v8, "writeTimeout":I
    invoke-virtual {p1}, Lokhttp3/OkHttpClient;->retryOnConnectionFailure()Z

    move-result v9

    .line 98
    .local v9, "connectionRetryEnabled":Z
    move-object v0, p0

    move v1, v6

    move v2, v7

    move v3, v8

    move v4, v9

    move v5, p2

    :try_start_0
    invoke-direct/range {v0 .. v5}, Lokhttp3/internal/connection/StreamAllocation;->findHealthyConnection(IIIZZ)Lokhttp3/internal/connection/RealConnection;

    move-result-object v0

    .line 102
    .local v0, "resultConnection":Lokhttp3/internal/connection/RealConnection;
    iget-object v1, v0, Lokhttp3/internal/connection/RealConnection;->framedConnection:Lokhttp3/internal/framed/FramedConnection;

    if-eqz v1, :cond_0

    .line 103
    new-instance v1, Lokhttp3/internal/http/Http2xStream;

    iget-object v2, v0, Lokhttp3/internal/connection/RealConnection;->framedConnection:Lokhttp3/internal/framed/FramedConnection;

    invoke-direct {v1, p1, p0, v2}, Lokhttp3/internal/http/Http2xStream;-><init>(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/framed/FramedConnection;)V

    goto :goto_0

    .line 105
    :cond_0
    invoke-virtual {v0}, Lokhttp3/internal/connection/RealConnection;->socket()Ljava/net/Socket;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 106
    iget-object v1, v0, Lokhttp3/internal/connection/RealConnection;->source:Lokio/BufferedSource;

    invoke-interface {v1}, Lokio/BufferedSource;->timeout()Lokio/Timeout;

    move-result-object v1

    int-to-long v2, v7

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Lokio/Timeout;->timeout(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;

    .line 107
    iget-object v1, v0, Lokhttp3/internal/connection/RealConnection;->sink:Lokio/BufferedSink;

    invoke-interface {v1}, Lokio/BufferedSink;->timeout()Lokio/Timeout;

    move-result-object v1

    int-to-long v2, v8

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Lokio/Timeout;->timeout(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;

    .line 108
    new-instance v1, Lokhttp3/internal/http/Http1xStream;

    iget-object v2, v0, Lokhttp3/internal/connection/RealConnection;->source:Lokio/BufferedSource;

    iget-object v3, v0, Lokhttp3/internal/connection/RealConnection;->sink:Lokio/BufferedSink;

    invoke-direct {v1, p1, p0, v2, v3}, Lokhttp3/internal/http/Http1xStream;-><init>(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V

    .line 112
    .local v1, "resultStream":Lokhttp3/internal/http/HttpStream;
    :goto_0
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 113
    :try_start_1
    iput-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    .line 114
    monitor-exit v2

    return-object v1

    .line 115
    :catchall_0
    move-exception v3

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v6    # "connectTimeout":I
    .end local v7    # "readTimeout":I
    .end local v8    # "writeTimeout":I
    .end local v9    # "connectionRetryEnabled":Z
    .end local p1    # "client":Lokhttp3/OkHttpClient;
    .end local p2    # "doExtensiveHealthChecks":Z
    :try_start_2
    throw v3
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 116
    .end local v0    # "resultConnection":Lokhttp3/internal/connection/RealConnection;
    .end local v1    # "resultStream":Lokhttp3/internal/http/HttpStream;
    .restart local v6    # "connectTimeout":I
    .restart local v7    # "readTimeout":I
    .restart local v8    # "writeTimeout":I
    .restart local v9    # "connectionRetryEnabled":Z
    .restart local p1    # "client":Lokhttp3/OkHttpClient;
    .restart local p2    # "doExtensiveHealthChecks":Z
    :catch_0
    move-exception v0

    .line 117
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lokhttp3/internal/connection/RouteException;

    invoke-direct {v1, v0}, Lokhttp3/internal/connection/RouteException;-><init>(Ljava/io/IOException;)V

    throw v1
.end method

.method public noNewStreams()V
    .locals 2

    .line 232
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, v1, v0, v0}, Lokhttp3/internal/connection/StreamAllocation;->deallocate(ZZZ)V

    .line 233
    return-void
.end method

.method public release()V
    .locals 2

    .line 227
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1, v0}, Lokhttp3/internal/connection/StreamAllocation;->deallocate(ZZZ)V

    .line 228
    return-void
.end method

.method public stream()Lokhttp3/internal/http/HttpStream;
    .locals 2

    .line 213
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v0

    .line 214
    :try_start_0
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    monitor-exit v0

    return-object v1

    .line 215
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public streamFailed(Ljava/io/IOException;)V
    .locals 7
    .param p1, "e"    # Ljava/io/IOException;

    .line 285
    const/4 v0, 0x0

    .line 287
    .local v0, "noNewStreams":Z
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v1

    .line 288
    :try_start_0
    instance-of v2, p1, Lokhttp3/internal/framed/StreamResetException;

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-eqz v2, :cond_4

    .line 289
    move-object v2, p1

    check-cast v2, Lokhttp3/internal/framed/StreamResetException;

    .line 290
    .local v2, "streamResetException":Lokhttp3/internal/framed/StreamResetException;
    iget-object v5, v2, Lokhttp3/internal/framed/StreamResetException;->errorCode:Lokhttp3/internal/framed/ErrorCode;

    sget-object v6, Lokhttp3/internal/framed/ErrorCode;->REFUSED_STREAM:Lokhttp3/internal/framed/ErrorCode;

    if-ne v5, v6, :cond_0

    .line 291
    iget v5, p0, Lokhttp3/internal/connection/StreamAllocation;->refusedStreamCount:I

    add-int/2addr v5, v4

    iput v5, p0, Lokhttp3/internal/connection/StreamAllocation;->refusedStreamCount:I

    goto :goto_0

    .line 290
    :cond_0
    nop

    .line 295
    :goto_0
    iget-object v5, v2, Lokhttp3/internal/framed/StreamResetException;->errorCode:Lokhttp3/internal/framed/ErrorCode;

    sget-object v6, Lokhttp3/internal/framed/ErrorCode;->REFUSED_STREAM:Lokhttp3/internal/framed/ErrorCode;

    if-ne v5, v6, :cond_2

    iget v5, p0, Lokhttp3/internal/connection/StreamAllocation;->refusedStreamCount:I

    if-le v5, v4, :cond_1

    goto :goto_1

    :cond_1
    goto :goto_2

    .line 296
    :cond_2
    :goto_1
    const/4 v0, 0x1

    .line 297
    iput-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    .line 299
    .end local v2    # "streamResetException":Lokhttp3/internal/framed/StreamResetException;
    :cond_3
    :goto_2
    goto :goto_4

    :cond_4
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    invoke-virtual {v2}, Lokhttp3/internal/connection/RealConnection;->isMultiplexed()Z

    move-result v2

    if-nez v2, :cond_3

    .line 300
    const/4 v0, 0x1

    .line 303
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    iget v2, v2, Lokhttp3/internal/connection/RealConnection;->successCount:I

    if-nez v2, :cond_6

    .line 304
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    if-eqz v2, :cond_5

    if-eqz p1, :cond_5

    .line 305
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->routeSelector:Lokhttp3/internal/connection/RouteSelector;

    iget-object v5, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    invoke-virtual {v2, v5, p1}, Lokhttp3/internal/connection/RouteSelector;->connectFailed(Lokhttp3/Route;Ljava/io/IOException;)V

    goto :goto_3

    .line 304
    :cond_5
    nop

    .line 307
    :goto_3
    iput-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->route:Lokhttp3/Route;

    goto :goto_4

    .line 303
    :cond_6
    nop

    .line 310
    :goto_4
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 312
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, v4}, Lokhttp3/internal/connection/StreamAllocation;->deallocate(ZZZ)V

    .line 313
    return-void

    .line 310
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    return-void
.end method

.method public streamFinished(ZLokhttp3/internal/http/HttpStream;)V
    .locals 4
    .param p1, "noNewStreams"    # Z
    .param p2, "stream"    # Lokhttp3/internal/http/HttpStream;

    .line 201
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->connectionPool:Lokhttp3/ConnectionPool;

    monitor-enter v0

    .line 202
    if-eqz p2, :cond_1

    :try_start_0
    iget-object v1, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    if-ne p2, v1, :cond_1

    .line 205
    const/4 v1, 0x1

    if-nez p1, :cond_0

    .line 206
    iget-object v2, p0, Lokhttp3/internal/connection/StreamAllocation;->connection:Lokhttp3/internal/connection/RealConnection;

    iget v3, v2, Lokhttp3/internal/connection/RealConnection;->successCount:I

    add-int/2addr v3, v1

    iput v3, v2, Lokhttp3/internal/connection/RealConnection;->successCount:I

    goto :goto_0

    .line 205
    :cond_0
    nop

    .line 208
    :goto_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 209
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v1}, Lokhttp3/internal/connection/StreamAllocation;->deallocate(ZZZ)V

    .line 210
    return-void

    .line 202
    :cond_1
    nop

    .line 203
    :try_start_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lokhttp3/internal/connection/StreamAllocation;->stream:Lokhttp3/internal/http/HttpStream;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, " but was "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local p1    # "noNewStreams":Z
    .end local p2    # "stream":Lokhttp3/internal/http/HttpStream;
    throw v1

    .line 208
    .restart local p1    # "noNewStreams":Z
    .restart local p2    # "stream":Lokhttp3/internal/http/HttpStream;
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 340
    iget-object v0, p0, Lokhttp3/internal/connection/StreamAllocation;->address:Lokhttp3/Address;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
