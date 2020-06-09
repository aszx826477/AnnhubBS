.class public Lorg/litepal/crud/ClusterQuery;
.super Ljava/lang/Object;
.source "ClusterQuery.java"


# instance fields
.field mColumns:[Ljava/lang/String;

.field mConditions:[Ljava/lang/String;

.field mLimit:Ljava/lang/String;

.field mOffset:Ljava/lang/String;

.field mOrderBy:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    return-void
.end method


# virtual methods
.method public declared-synchronized average(Ljava/lang/Class;Ljava/lang/String;)D
    .locals 2
    .param p2, "column"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            ")D"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    monitor-enter p0

    .line 359
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lorg/litepal/crud/ClusterQuery;->average(Ljava/lang/String;Ljava/lang/String;)D

    move-result-wide v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p2    # "column":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized average(Ljava/lang/String;Ljava/lang/String;)D
    .locals 3
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "column"    # Ljava/lang/String;

    monitor-enter p0

    .line 382
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 383
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    invoke-virtual {v0, p1, p2, v1}, Lorg/litepal/crud/QueryHandler;->onAverage(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)D

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v1

    .line 381
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "tableName":Ljava/lang/String;
    .end local p2    # "column":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized count(Ljava/lang/Class;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)I"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    monitor-enter p0

    .line 313
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/ClusterQuery;->count(Ljava/lang/String;)I

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized count(Ljava/lang/String;)I
    .locals 2
    .param p1, "tableName"    # Ljava/lang/String;

    monitor-enter p0

    .line 335
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 336
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    invoke-virtual {v0, p1, v1}, Lorg/litepal/crud/QueryHandler;->onCount(Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v1

    .line 334
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "tableName":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public find(Ljava/lang/Class;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .line 188
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/ClusterQuery;->find(Ljava/lang/Class;Z)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized find(Ljava/lang/Class;Z)Ljava/util/List;
    .locals 8
    .param p2, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 202
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 204
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mOffset:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 205
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;

    move-object v7, v1

    goto :goto_1

    .line 207
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    :cond_0
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 208
    const-string v1, "0"

    iput-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;

    goto :goto_0

    .line 207
    :cond_1
    nop

    .line 210
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lorg/litepal/crud/ClusterQuery;->mOffset:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    move-object v7, v1

    .line 212
    .local v7, "limit":Ljava/lang/String;
    :goto_1
    iget-object v2, p0, Lorg/litepal/crud/ClusterQuery;->mColumns:[Ljava/lang/String;

    iget-object v3, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    iget-object v4, p0, Lorg/litepal/crud/ClusterQuery;->mOrderBy:Ljava/lang/String;

    move-object v1, p1

    move-object v5, v7

    move v6, p2

    invoke-virtual/range {v0 .. v6}, Lorg/litepal/crud/QueryHandler;->onFind(Ljava/lang/Class;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 201
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local v7    # "limit":Ljava/lang/String;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "isEager":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public findFirst(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 233
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/ClusterQuery;->findFirst(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public findFirst(Ljava/lang/Class;Z)Ljava/lang/Object;
    .locals 2
    .param p2, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z)TT;"
        }
    .end annotation

    .line 247
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/ClusterQuery;->find(Ljava/lang/Class;Z)Ljava/util/List;

    move-result-object v0

    .line 248
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 249
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 251
    :cond_0
    const/4 v1, 0x0

    return-object v1
.end method

.method public findLast(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 272
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/ClusterQuery;->findLast(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public findLast(Ljava/lang/Class;Z)Ljava/lang/Object;
    .locals 3
    .param p2, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z)TT;"
        }
    .end annotation

    .line 286
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/ClusterQuery;->find(Ljava/lang/Class;Z)Ljava/util/List;

    move-result-object v0

    .line 287
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    .line 288
    .local v1, "size":I
    if-lez v1, :cond_0

    .line 289
    add-int/lit8 v2, v1, -0x1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 291
    :cond_0
    const/4 v2, 0x0

    return-object v2
.end method

.method public limit(I)Lorg/litepal/crud/ClusterQuery;
    .locals 1
    .param p1, "value"    # I

    .line 139
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;

    .line 140
    return-object p0
.end method

.method public declared-synchronized max(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 409
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lorg/litepal/crud/ClusterQuery;->max(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized max(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 435
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 436
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    invoke-virtual {v0, p1, p2, v1, p3}, Lorg/litepal/crud/QueryHandler;->onMax(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 434
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "tableName":Ljava/lang/String;
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized min(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 462
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lorg/litepal/crud/ClusterQuery;->min(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized min(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 488
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 489
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    invoke-virtual {v0, p1, p2, v1, p3}, Lorg/litepal/crud/QueryHandler;->onMin(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 487
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "tableName":Ljava/lang/String;
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public offset(I)Lorg/litepal/crud/ClusterQuery;
    .locals 1
    .param p1, "value"    # I

    .line 158
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/crud/ClusterQuery;->mOffset:Ljava/lang/String;

    .line 159
    return-object p0
.end method

.method public order(Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 0
    .param p1, "column"    # Ljava/lang/String;

    .line 120
    iput-object p1, p0, Lorg/litepal/crud/ClusterQuery;->mOrderBy:Ljava/lang/String;

    .line 121
    return-object p0
.end method

.method public varargs select([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 0
    .param p1, "columns"    # [Ljava/lang/String;

    .line 79
    iput-object p1, p0, Lorg/litepal/crud/ClusterQuery;->mColumns:[Ljava/lang/String;

    .line 80
    return-object p0
.end method

.method public declared-synchronized sum(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 515
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lorg/litepal/crud/ClusterQuery;->sum(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized sum(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p3, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    monitor-enter p0

    .line 541
    :try_start_0
    new-instance v0, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 542
    .local v0, "queryHandler":Lorg/litepal/crud/QueryHandler;
    iget-object v1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    invoke-virtual {v0, p1, p2, v1, p3}, Lorg/litepal/crud/QueryHandler;->onSum(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 540
    .end local v0    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "this":Lorg/litepal/crud/ClusterQuery;
    .end local p1    # "tableName":Ljava/lang/String;
    .end local p2    # "columnName":Ljava/lang/String;
    .end local p3    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public varargs where([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 0
    .param p1, "conditions"    # [Ljava/lang/String;

    .line 99
    iput-object p1, p0, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;

    .line 100
    return-object p0
.end method
