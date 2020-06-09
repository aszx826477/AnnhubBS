.class public Lorg/litepal/crud/DataSupport;
.super Ljava/lang/Object;
.source "DataSupport.java"


# instance fields
.field private associatedModelsMapForJoinTable:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation
.end field

.field private associatedModelsMapWithFK:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation
.end field

.field private associatedModelsMapWithoutFK:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private baseObjId:J

.field private fieldsToSetToDefault:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private listToClearAssociatedFK:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private listToClearSelfFK:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .locals 0

    .line 1207
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1208
    return-void
.end method

.method public static declared-synchronized average(Ljava/lang/Class;Ljava/lang/String;)D
    .locals 3
    .param p1, "column"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            ")D"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 284
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1}, Lorg/litepal/crud/DataSupport;->average(Ljava/lang/String;Ljava/lang/String;)D

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "column":Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized average(Ljava/lang/String;Ljava/lang/String;)D
    .locals 4
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "column"    # Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 307
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 308
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-virtual {v1, p0, p1}, Lorg/litepal/crud/ClusterQuery;->average(Ljava/lang/String;Ljava/lang/String;)D

    move-result-wide v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-wide v2

    .line 306
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "column":Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method private clearFKNameList()V
    .locals 1

    .line 1462
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getListToClearSelfFK()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 1463
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getListToClearAssociatedFK()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 1464
    return-void
.end method

.method private clearIdOfModelForJoinTable()V
    .locals 3

    .line 1452
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapForJoinTable()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1453
    .local v1, "associatedModelName":Ljava/lang/String;
    iget-object v2, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->clear()V

    .line 1454
    .end local v1    # "associatedModelName":Ljava/lang/String;
    goto :goto_0

    .line 1452
    :cond_0
    nop

    .line 1455
    .end local v0    # "i$":Ljava/util/Iterator;
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1456
    return-void
.end method

.method private clearIdOfModelWithFK()V
    .locals 3

    .line 1435
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithFK()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1436
    .local v1, "associatedModelName":Ljava/lang/String;
    iget-object v2, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->clear()V

    .line 1437
    .end local v1    # "associatedModelName":Ljava/lang/String;
    goto :goto_0

    .line 1435
    :cond_0
    nop

    .line 1438
    .end local v0    # "i$":Ljava/util/Iterator;
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1439
    return-void
.end method

.method private clearIdOfModelWithoutFK()V
    .locals 1

    .line 1445
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithoutFK()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1446
    return-void
.end method

.method public static declared-synchronized count(Ljava/lang/Class;)I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)I"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 238
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/crud/DataSupport;->count(Ljava/lang/String;)I

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized count(Ljava/lang/String;)I
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 260
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 261
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-virtual {v1, p0}, Lorg/litepal/crud/ClusterQuery;->count(Ljava/lang/String;)I

    move-result v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v2

    .line 259
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "tableName":Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized delete(Ljava/lang/Class;J)I
    .locals 5
    .param p1, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;J)I"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 684
    const/4 v1, 0x0

    .line 685
    .local v1, "rowsAffected":I
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 686
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 688
    :try_start_1
    new-instance v3, Lorg/litepal/crud/DeleteHandler;

    invoke-direct {v3, v2}, Lorg/litepal/crud/DeleteHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 689
    .local v3, "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    invoke-virtual {v3, p0, p1, p2}, Lorg/litepal/crud/DeleteHandler;->onDelete(Ljava/lang/Class;J)I

    move-result v4

    move v1, v4

    .line 690
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 691
    nop

    .line 693
    :try_start_2
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit v0

    return v1

    .end local v3    # "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    :catchall_0
    move-exception v3

    :try_start_3
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 683
    .end local v1    # "rowsAffected":I
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "id":J
    :catchall_1
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized deleteAll(Ljava/lang/Class;[Ljava/lang/String;)I
    .locals 3
    .param p1, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;[",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 722
    :try_start_0
    new-instance v1, Lorg/litepal/crud/DeleteHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/DeleteHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 723
    .local v1, "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    invoke-virtual {v1, p0, p1}, Lorg/litepal/crud/DeleteHandler;->onDeleteAll(Ljava/lang/Class;[Ljava/lang/String;)I

    move-result v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v2

    .line 721
    .end local v1    # "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized deleteAll(Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "conditions"    # [Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 754
    :try_start_0
    new-instance v1, Lorg/litepal/crud/DeleteHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/DeleteHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 755
    .local v1, "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    invoke-virtual {v1, p0, p1}, Lorg/litepal/crud/DeleteHandler;->onDeleteAll(Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v2

    .line 753
    .end local v1    # "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized find(Ljava/lang/Class;J)Ljava/lang/Object;
    .locals 2
    .param p1, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;J)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 491
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, p1, p2, v1}, Lorg/litepal/crud/DataSupport;->find(Ljava/lang/Class;JZ)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "id":J
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized find(Ljava/lang/Class;JZ)Ljava/lang/Object;
    .locals 3
    .param p1, "id"    # J
    .param p3, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;JZ)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 507
    :try_start_0
    new-instance v1, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 508
    .local v1, "queryHandler":Lorg/litepal/crud/QueryHandler;
    invoke-virtual {v1, p0, p1, p2, p3}, Lorg/litepal/crud/QueryHandler;->onFind(Ljava/lang/Class;JZ)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 506
    .end local v1    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "id":J
    .end local p3    # "isEager":Z
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized findAll(Ljava/lang/Class;Z[J)Ljava/util/List;
    .locals 3
    .param p1, "isEager"    # Z
    .param p2, "ids"    # [J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z[J)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 628
    :try_start_0
    new-instance v1, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 629
    .local v1, "queryHandler":Lorg/litepal/crud/QueryHandler;
    invoke-virtual {v1, p0, p1, p2}, Lorg/litepal/crud/QueryHandler;->onFindAll(Ljava/lang/Class;Z[J)Ljava/util/List;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 627
    .end local v1    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "isEager":Z
    .end local p2    # "ids":[J
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized findAll(Ljava/lang/Class;[J)Ljava/util/List;
    .locals 2
    .param p1, "ids"    # [J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;[J)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 610
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1, p1}, Lorg/litepal/crud/DataSupport;->findAll(Ljava/lang/Class;Z[J)Ljava/util/List;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "ids":[J
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized findBySQL([Ljava/lang/String;)Landroid/database/Cursor;
    .locals 5
    .param p0, "sql"    # [Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 649
    :try_start_0
    invoke-static {p0}, Lorg/litepal/util/BaseUtility;->checkConditionsCorrect([Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 650
    const/4 v1, 0x0

    if-nez p0, :cond_0

    .line 651
    monitor-exit v0

    return-object v1

    .line 653
    :cond_0
    :try_start_1
    array-length v2, p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-gtz v2, :cond_1

    .line 654
    monitor-exit v0

    return-object v1

    .line 657
    :cond_1
    :try_start_2
    array-length v1, p0

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-ne v1, v3, :cond_2

    .line 658
    const/4 v1, 0x0

    goto :goto_0

    .line 660
    :cond_2
    array-length v1, p0

    sub-int/2addr v1, v3

    new-array v1, v1, [Ljava/lang/String;

    .line 661
    .local v1, "selectionArgs":[Ljava/lang/String;
    array-length v4, p0

    sub-int/2addr v4, v3

    invoke-static {p0, v3, v1, v2, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 663
    :goto_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    aget-object v2, p0, v2

    invoke-virtual {v3, v2, v1}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit v0

    return-object v2

    .line 648
    .end local v1    # "selectionArgs":[Ljava/lang/String;
    .end local p0    # "sql":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized findFirst(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 527
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lorg/litepal/crud/DataSupport;->findFirst(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized findFirst(Ljava/lang/Class;Z)Ljava/lang/Object;
    .locals 3
    .param p1, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 541
    :try_start_0
    new-instance v1, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 542
    .local v1, "queryHandler":Lorg/litepal/crud/QueryHandler;
    invoke-virtual {v1, p0, p1}, Lorg/litepal/crud/QueryHandler;->onFindFirst(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 540
    .end local v1    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "isEager":Z
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized findLast(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 561
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lorg/litepal/crud/DataSupport;->findLast(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized findLast(Ljava/lang/Class;Z)Ljava/lang/Object;
    .locals 3
    .param p1, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;Z)TT;"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 575
    :try_start_0
    new-instance v1, Lorg/litepal/crud/QueryHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/QueryHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 576
    .local v1, "queryHandler":Lorg/litepal/crud/QueryHandler;
    invoke-virtual {v1, p0, p1}, Lorg/litepal/crud/QueryHandler;->onFindLast(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 574
    .end local v1    # "queryHandler":Lorg/litepal/crud/QueryHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p1    # "isEager":Z
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs isExist(Ljava/lang/Class;[Ljava/lang/String;)Z
    .locals 2
    .param p1, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;[",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .line 918
    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 919
    return v0

    .line 921
    :cond_0
    invoke-static {p1}, Lorg/litepal/crud/DataSupport;->where([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;

    move-result-object v1

    invoke-virtual {v1, p0}, Lorg/litepal/crud/ClusterQuery;->count(Ljava/lang/Class;)I

    move-result v1

    if-lez v1, :cond_1

    const/4 v0, 0x1

    nop

    :cond_1
    return v0
.end method

.method public static declared-synchronized limit(I)Lorg/litepal/crud/ClusterQuery;
    .locals 3
    .param p0, "value"    # I

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 194
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 195
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lorg/litepal/crud/ClusterQuery;->mLimit:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 196
    monitor-exit v0

    return-object v1

    .line 193
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "value":I
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static markAsDeleted(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lorg/litepal/crud/DataSupport;",
            ">(",
            "Ljava/util/Collection<",
            "TT;>;)V"
        }
    .end annotation

    .line 902
    .local p0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/crud/DataSupport;

    .line 903
    .local v1, "t":Lorg/litepal/crud/DataSupport;, "TT;"
    invoke-virtual {v1}, Lorg/litepal/crud/DataSupport;->clearSavedState()V

    .line 904
    .end local v1    # "t":Lorg/litepal/crud/DataSupport;, "TT;"
    goto :goto_0

    .line 902
    :cond_0
    nop

    .line 905
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method public static declared-synchronized max(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 334
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1, p2}, Lorg/litepal/crud/DataSupport;->max(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized max(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 360
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 361
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-virtual {v1, p0, p1, p2}, Lorg/litepal/crud/ClusterQuery;->max(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 359
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized min(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 387
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1, p2}, Lorg/litepal/crud/DataSupport;->min(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized min(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 413
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 414
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-virtual {v1, p0, p1, p2}, Lorg/litepal/crud/ClusterQuery;->min(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 412
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized offset(I)Lorg/litepal/crud/ClusterQuery;
    .locals 3
    .param p0, "value"    # I

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 214
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 215
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lorg/litepal/crud/ClusterQuery;->mOffset:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 216
    monitor-exit v0

    return-object v1

    .line 213
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "value":I
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized order(Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 2
    .param p0, "column"    # Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 174
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 175
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    iput-object p0, v1, Lorg/litepal/crud/ClusterQuery;->mOrderBy:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 176
    monitor-exit v0

    return-object v1

    .line 173
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "column":Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized saveAll(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lorg/litepal/crud/DataSupport;",
            ">(",
            "Ljava/util/Collection<",
            "TT;>;)V"
        }
    .end annotation

    .local p0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 881
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 882
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 884
    :try_start_1
    new-instance v2, Lorg/litepal/crud/SaveHandler;

    invoke-direct {v2, v1}, Lorg/litepal/crud/SaveHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 885
    .local v2, "saveHandler":Lorg/litepal/crud/SaveHandler;
    invoke-virtual {v2, p0}, Lorg/litepal/crud/SaveHandler;->onSaveAll(Ljava/util/Collection;)V

    .line 886
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 890
    .end local v2    # "saveHandler":Lorg/litepal/crud/SaveHandler;
    :try_start_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 891
    nop

    .line 892
    monitor-exit v0

    return-void

    .line 890
    :catchall_0
    move-exception v2

    goto :goto_0

    .line 887
    :catch_0
    move-exception v2

    .line 888
    .local v2, "e":Ljava/lang/Exception;
    :try_start_3
    new-instance v3, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local p0    # "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 890
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local p0    # "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    :goto_0
    :try_start_4
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 880
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local p0    # "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    :catchall_1
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized select([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 2
    .param p0, "columns"    # [Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 131
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 132
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    iput-object p0, v1, Lorg/litepal/crud/ClusterQuery;->mColumns:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 133
    monitor-exit v0

    return-object v1

    .line 130
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "columns":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized sum(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 440
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1, p2}, Lorg/litepal/crud/DataSupport;->sum(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized sum(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "columnName"    # Ljava/lang/String;
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

    .local p2, "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 466
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 467
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    invoke-virtual {v1, p0, p1, p2}, Lorg/litepal/crud/ClusterQuery;->sum(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v2

    .line 465
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "columnName":Ljava/lang/String;
    .end local p2    # "columnType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized update(Ljava/lang/Class;Landroid/content/ContentValues;J)I
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Landroid/content/ContentValues;",
            "J)I"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 780
    :try_start_0
    new-instance v1, Lorg/litepal/crud/UpdateHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/UpdateHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 781
    .local v1, "updateHandler":Lorg/litepal/crud/UpdateHandler;
    invoke-virtual {v1, p0, p2, p3, p1}, Lorg/litepal/crud/UpdateHandler;->onUpdate(Ljava/lang/Class;JLandroid/content/ContentValues;)I

    move-result v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v2

    .line 779
    .end local v1    # "updateHandler":Lorg/litepal/crud/UpdateHandler;
    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "values":Landroid/content/ContentValues;
    .end local p2    # "id":J
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized updateAll(Ljava/lang/Class;Landroid/content/ContentValues;[Ljava/lang/String;)I
    .locals 2
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Landroid/content/ContentValues;",
            "[",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .local p0, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 815
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1, p2}, Lorg/litepal/crud/DataSupport;->updateAll(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    .end local p0    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local p1    # "values":Landroid/content/ContentValues;
    .end local p2    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized updateAll(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "conditions"    # [Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 850
    :try_start_0
    new-instance v1, Lorg/litepal/crud/UpdateHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/crud/UpdateHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 851
    .local v1, "updateHandler":Lorg/litepal/crud/UpdateHandler;
    invoke-virtual {v1, p0, p1, p2}, Lorg/litepal/crud/UpdateHandler;->onUpdateAll(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I

    move-result v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v2

    .line 849
    .end local v1    # "updateHandler":Lorg/litepal/crud/UpdateHandler;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "values":Landroid/content/ContentValues;
    .end local p2    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static varargs declared-synchronized where([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;
    .locals 2
    .param p0, "conditions"    # [Ljava/lang/String;

    const-class v0, Lorg/litepal/crud/DataSupport;

    monitor-enter v0

    .line 152
    :try_start_0
    new-instance v1, Lorg/litepal/crud/ClusterQuery;

    invoke-direct {v1}, Lorg/litepal/crud/ClusterQuery;-><init>()V

    .line 153
    .local v1, "cQuery":Lorg/litepal/crud/ClusterQuery;
    iput-object p0, v1, Lorg/litepal/crud/ClusterQuery;->mConditions:[Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 154
    monitor-exit v0

    return-object v1

    .line 151
    .end local v1    # "cQuery":Lorg/litepal/crud/ClusterQuery;
    .end local p0    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method


# virtual methods
.method addAssociatedModelForJoinTable(Ljava/lang/String;J)V
    .locals 2
    .param p1, "associatedModelName"    # Ljava/lang/String;
    .param p2, "associatedId"    # J

    .line 1297
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapForJoinTable()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    .line 1299
    .local v0, "associatedIdsM2MSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-nez v0, :cond_0

    .line 1300
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    move-object v0, v1

    .line 1301
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1302
    iget-object v1, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1304
    :cond_0
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1306
    :goto_0
    return-void
.end method

.method addAssociatedModelWithFK(Ljava/lang/String;J)V
    .locals 2
    .param p1, "associatedTableName"    # Ljava/lang/String;
    .param p2, "associatedId"    # J

    .line 1263
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithFK()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    .line 1264
    .local v0, "associatedIdsWithFKSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-nez v0, :cond_0

    .line 1265
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    move-object v0, v1

    .line 1266
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1267
    iget-object v1, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1269
    :cond_0
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1271
    :goto_0
    return-void
.end method

.method addAssociatedModelWithoutFK(Ljava/lang/String;J)V
    .locals 2
    .param p1, "associatedTableName"    # Ljava/lang/String;
    .param p2, "associatedId"    # J

    .line 1352
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithoutFK()Ljava/util/Map;

    move-result-object v0

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1353
    return-void
.end method

.method addAssociatedTableNameToClearFK(Ljava/lang/String;)V
    .locals 2
    .param p1, "associatedTableName"    # Ljava/lang/String;

    .line 1402
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getListToClearAssociatedFK()Ljava/util/List;

    move-result-object v0

    .line 1403
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1404
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1403
    :cond_0
    nop

    .line 1406
    :goto_0
    return-void
.end method

.method addEmptyModelForJoinTable(Ljava/lang/String;)V
    .locals 2
    .param p1, "associatedModelName"    # Ljava/lang/String;

    .line 1317
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapForJoinTable()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    .line 1319
    .local v0, "associatedIdsM2MSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-nez v0, :cond_0

    .line 1320
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    move-object v0, v1

    .line 1321
    iget-object v1, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1319
    :cond_0
    nop

    .line 1323
    :goto_0
    return-void
.end method

.method addFKNameToClearSelf(Ljava/lang/String;)V
    .locals 2
    .param p1, "foreignKeyName"    # Ljava/lang/String;

    .line 1376
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getListToClearSelfFK()Ljava/util/List;

    move-result-object v0

    .line 1377
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1378
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1377
    :cond_0
    nop

    .line 1380
    :goto_0
    return-void
.end method

.method public assignBaseObjId(I)V
    .locals 2
    .param p1, "baseObjId"    # I

    .line 1200
    int-to-long v0, p1

    iput-wide v0, p0, Lorg/litepal/crud/DataSupport;->baseObjId:J

    .line 1201
    return-void
.end method

.method clearAssociatedData()V
    .locals 0

    .line 1425
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;->clearIdOfModelWithFK()V

    .line 1426
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;->clearIdOfModelWithoutFK()V

    .line 1427
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;->clearIdOfModelForJoinTable()V

    .line 1428
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;->clearFKNameList()V

    .line 1429
    return-void
.end method

.method public clearSavedState()V
    .locals 2

    .line 1179
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/litepal/crud/DataSupport;->baseObjId:J

    .line 1180
    return-void
.end method

.method public declared-synchronized delete()I
    .locals 5

    monitor-enter p0

    .line 940
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 941
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 943
    :try_start_1
    new-instance v1, Lorg/litepal/crud/DeleteHandler;

    invoke-direct {v1, v0}, Lorg/litepal/crud/DeleteHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 944
    .local v1, "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    invoke-virtual {v1, p0}, Lorg/litepal/crud/DeleteHandler;->onDelete(Lorg/litepal/crud/DataSupport;)I

    move-result v2

    .line 945
    .local v2, "rowsAffected":I
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lorg/litepal/crud/DataSupport;->baseObjId:J

    .line 946
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 947
    nop

    .line 949
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return v2

    .end local v1    # "deleteHandler":Lorg/litepal/crud/DeleteHandler;
    .end local v2    # "rowsAffected":I
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 939
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method getAssociatedModelsMapForJoinTable()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation

    .line 1334
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1335
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    goto :goto_0

    .line 1334
    :cond_0
    nop

    .line 1337
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapForJoinTable:Ljava/util/Map;

    return-object v0
.end method

.method getAssociatedModelsMapWithFK()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/Set<",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation

    .line 1282
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1283
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    goto :goto_0

    .line 1282
    :cond_0
    nop

    .line 1285
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithFK:Ljava/util/Map;

    return-object v0
.end method

.method getAssociatedModelsMapWithoutFK()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .line 1363
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithoutFK:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 1364
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithoutFK:Ljava/util/Map;

    goto :goto_0

    .line 1363
    :cond_0
    nop

    .line 1366
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->associatedModelsMapWithoutFK:Ljava/util/Map;

    return-object v0
.end method

.method protected getBaseObjId()J
    .locals 2

    .line 1217
    iget-wide v0, p0, Lorg/litepal/crud/DataSupport;->baseObjId:J

    return-wide v0
.end method

.method protected getClassName()Ljava/lang/String;
    .locals 1

    .line 1226
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getFieldsToSetToDefault()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1246
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->fieldsToSetToDefault:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1247
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->fieldsToSetToDefault:Ljava/util/List;

    goto :goto_0

    .line 1246
    :cond_0
    nop

    .line 1249
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->fieldsToSetToDefault:Ljava/util/List;

    return-object v0
.end method

.method getListToClearAssociatedFK()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1415
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearAssociatedFK:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1416
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearAssociatedFK:Ljava/util/List;

    goto :goto_0

    .line 1415
    :cond_0
    nop

    .line 1418
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearAssociatedFK:Ljava/util/List;

    return-object v0
.end method

.method getListToClearSelfFK()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1389
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearSelfFK:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1390
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearSelfFK:Ljava/util/List;

    goto :goto_0

    .line 1389
    :cond_0
    nop

    .line 1392
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DataSupport;->listToClearSelfFK:Ljava/util/List;

    return-object v0
.end method

.method protected getTableName()Ljava/lang/String;
    .locals 1

    .line 1235
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isSaved()Z
    .locals 5

    .line 1172
    iget-wide v0, p0, Lorg/litepal/crud/DataSupport;->baseObjId:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public declared-synchronized save()Z
    .locals 2

    monitor-enter p0

    .line 1051
    :try_start_0
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->saveThrows()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1052
    const/4 v0, 0x1

    monitor-exit p0

    return v0

    .line 1050
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    :catchall_0
    move-exception v0

    goto :goto_0

    .line 1053
    :catch_0
    move-exception v0

    .line 1054
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1055
    const/4 v1, 0x0

    monitor-exit p0

    return v1

    .line 1050
    .end local v0    # "e":Ljava/lang/Exception;
    :goto_0
    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized saveFast()Z
    .locals 3

    monitor-enter p0

    .line 1151
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1152
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1154
    :try_start_1
    new-instance v1, Lorg/litepal/crud/SaveHandler;

    invoke-direct {v1, v0}, Lorg/litepal/crud/SaveHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1155
    .local v1, "saveHandler":Lorg/litepal/crud/SaveHandler;
    invoke-virtual {v1, p0}, Lorg/litepal/crud/SaveHandler;->onSaveFast(Lorg/litepal/crud/DataSupport;)V

    .line 1156
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1157
    const/4 v2, 0x1

    .line 1162
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return v2

    .end local v1    # "saveHandler":Lorg/litepal/crud/SaveHandler;
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    :catchall_0
    move-exception v1

    goto :goto_0

    .line 1158
    :catch_0
    move-exception v1

    .line 1159
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1160
    const/4 v2, 0x0

    .line 1162
    :try_start_4
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    monitor-exit p0

    return v2

    .end local v1    # "e":Ljava/lang/Exception;
    :goto_0
    :try_start_5
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1150
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public varargs declared-synchronized saveIfNotExist([Ljava/lang/String;)Z
    .locals 1
    .param p1, "conditions"    # [Ljava/lang/String;

    monitor-enter p0

    .line 1122
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0, p1}, Lorg/litepal/crud/DataSupport;->isExist(Ljava/lang/Class;[Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1123
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->save()Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 1125
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    :cond_0
    const/4 v0, 0x0

    monitor-exit p0

    return v0

    .line 1121
    .end local p1    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized saveThrows()V
    .locals 4

    monitor-enter p0

    .line 1084
    :try_start_0
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1085
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1087
    :try_start_1
    new-instance v1, Lorg/litepal/crud/SaveHandler;

    invoke-direct {v1, v0}, Lorg/litepal/crud/SaveHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1088
    .local v1, "saveHandler":Lorg/litepal/crud/SaveHandler;
    invoke-virtual {v1, p0}, Lorg/litepal/crud/SaveHandler;->onSave(Lorg/litepal/crud/DataSupport;)V

    .line 1089
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->clearAssociatedData()V

    .line 1090
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1094
    .end local v1    # "saveHandler":Lorg/litepal/crud/SaveHandler;
    :try_start_2
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1095
    nop

    .line 1096
    monitor-exit p0

    return-void

    .line 1094
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    :catchall_0
    move-exception v1

    goto :goto_0

    .line 1091
    :catch_0
    move-exception v1

    .line 1092
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1094
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    :try_start_4
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1083
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setToDefault(Ljava/lang/String;)V
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .line 1191
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getFieldsToSetToDefault()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1192
    return-void
.end method

.method public declared-synchronized update(J)I
    .locals 3
    .param p1, "id"    # J

    monitor-enter p0

    .line 976
    :try_start_0
    new-instance v0, Lorg/litepal/crud/UpdateHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/UpdateHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 977
    .local v0, "updateHandler":Lorg/litepal/crud/UpdateHandler;
    invoke-virtual {v0, p0, p1, p2}, Lorg/litepal/crud/UpdateHandler;->onUpdate(Lorg/litepal/crud/DataSupport;J)I

    move-result v1

    .line 978
    .local v1, "rowsAffected":I
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getFieldsToSetToDefault()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 979
    monitor-exit p0

    return v1

    .line 975
    .end local v0    # "updateHandler":Lorg/litepal/crud/UpdateHandler;
    .end local v1    # "rowsAffected":I
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    .end local p1    # "id":J
    :catchall_0
    move-exception p1

    goto :goto_0

    .line 980
    .restart local p1    # "id":J
    :catch_0
    move-exception v0

    .line 981
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 975
    .end local v0    # "e":Ljava/lang/Exception;
    .end local p1    # "id":J
    :goto_0
    monitor-exit p0

    throw p1
.end method

.method public varargs declared-synchronized updateAll([Ljava/lang/String;)I
    .locals 3
    .param p1, "conditions"    # [Ljava/lang/String;

    monitor-enter p0

    .line 1016
    :try_start_0
    new-instance v0, Lorg/litepal/crud/UpdateHandler;

    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/crud/UpdateHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 1017
    .local v0, "updateHandler":Lorg/litepal/crud/UpdateHandler;
    invoke-virtual {v0, p0, p1}, Lorg/litepal/crud/UpdateHandler;->onUpdateAll(Lorg/litepal/crud/DataSupport;[Ljava/lang/String;)I

    move-result v1

    .line 1018
    .local v1, "rowsAffected":I
    invoke-virtual {p0}, Lorg/litepal/crud/DataSupport;->getFieldsToSetToDefault()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1019
    monitor-exit p0

    return v1

    .line 1015
    .end local v0    # "updateHandler":Lorg/litepal/crud/UpdateHandler;
    .end local v1    # "rowsAffected":I
    .end local p0    # "this":Lorg/litepal/crud/DataSupport;
    .end local p1    # "conditions":[Ljava/lang/String;
    :catchall_0
    move-exception p1

    goto :goto_0

    .line 1020
    .restart local p1    # "conditions":[Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 1021
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1015
    .end local v0    # "e":Ljava/lang/Exception;
    .end local p1    # "conditions":[Ljava/lang/String;
    :goto_0
    monitor-exit p0

    throw p1
.end method
