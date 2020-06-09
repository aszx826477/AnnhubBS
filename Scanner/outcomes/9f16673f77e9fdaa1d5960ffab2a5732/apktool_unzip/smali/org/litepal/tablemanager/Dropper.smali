.class public Lorg/litepal/tablemanager/Dropper;
.super Lorg/litepal/tablemanager/AssociationUpdater;
.source "Dropper.java"


# instance fields
.field private mTableModels:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/TableModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42
    invoke-direct {p0}, Lorg/litepal/tablemanager/AssociationUpdater;-><init>()V

    return-void
.end method

.method private dropTables()V
    .locals 2

    .line 65
    invoke-direct {p0}, Lorg/litepal/tablemanager/Dropper;->findTablesToDrop()Ljava/util/List;

    move-result-object v0

    .line 66
    .local v0, "tableNamesToDrop":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lorg/litepal/tablemanager/Dropper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v0, v1}, Lorg/litepal/tablemanager/Dropper;->dropTables(Ljava/util/List;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 67
    invoke-virtual {p0, v0}, Lorg/litepal/tablemanager/Dropper;->clearCopyInTableSchema(Ljava/util/List;)V

    .line 68
    return-void
.end method

.method private findTablesToDrop()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 78
    .local v0, "dropTableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 80
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v2, p0, Lorg/litepal/tablemanager/Dropper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "table_schema"

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move-object v1, v2

    .line 81
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 83
    :goto_0
    const-string v2, "name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 85
    .local v2, "tableName":Ljava/lang/String;
    const-string v3, "type"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 87
    .local v3, "tableType":I
    invoke-direct {p0, v2, v3}, Lorg/litepal/tablemanager/Dropper;->shouldDropThisTable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 89
    const-string v4, "AssociationUpdater"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "need to drop "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 87
    :cond_0
    nop

    .line 92
    .end local v2    # "tableName":Ljava/lang/String;
    .end local v3    # "tableType":I
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_1

    goto :goto_2

    :cond_1
    goto :goto_0

    .line 81
    :cond_2
    nop

    .line 97
    :goto_2
    if-eqz v1, :cond_3

    .line 98
    :goto_3
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_4

    .line 97
    :cond_3
    goto :goto_4

    :catchall_0
    move-exception v2

    goto :goto_5

    .line 94
    :catch_0
    move-exception v2

    .line 95
    .local v2, "ex":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 97
    .end local v2    # "ex":Ljava/lang/Exception;
    if-eqz v1, :cond_3

    .line 98
    goto :goto_3

    .line 101
    :goto_4
    return-object v0

    .line 97
    :goto_5
    if-eqz v1, :cond_4

    .line 98
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 97
    :cond_4
    nop

    .line 98
    :goto_6
    throw v2

    return-void
.end method

.method private pickTableNamesFromTableModels()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 110
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 111
    .local v0, "tableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lorg/litepal/tablemanager/Dropper;->mTableModels:Ljava/util/Collection;

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/tablemanager/model/TableModel;

    .line 112
    .local v2, "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 113
    .end local v2    # "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    goto :goto_0

    .line 111
    :cond_0
    nop

    .line 114
    .end local v1    # "i$":Ljava/util/Iterator;
    return-object v0
.end method

.method private shouldDropThisTable(Ljava/lang/String;I)Z
    .locals 1
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "tableType"    # I

    .line 132
    invoke-direct {p0}, Lorg/litepal/tablemanager/Dropper;->pickTableNamesFromTableModels()Ljava/util/List;

    move-result-object v0

    invoke-static {v0, p1}, Lorg/litepal/util/BaseUtility;->containsIgnoreCases(Ljava/util/Collection;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p2, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method


# virtual methods
.method protected createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "force"    # Z

    .line 55
    invoke-virtual {p0}, Lorg/litepal/tablemanager/Dropper;->getAllTableModels()Ljava/util/Collection;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/tablemanager/Dropper;->mTableModels:Ljava/util/Collection;

    .line 56
    iput-object p1, p0, Lorg/litepal/tablemanager/Dropper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 57
    invoke-direct {p0}, Lorg/litepal/tablemanager/Dropper;->dropTables()V

    .line 58
    return-void
.end method
