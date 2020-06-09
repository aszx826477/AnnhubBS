.class public Lorg/litepal/crud/Many2ManyAnalyzer;
.super Lorg/litepal/crud/AssociationsAnalyzer;
.source "Many2ManyAnalyzer.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38
    invoke-direct {p0}, Lorg/litepal/crud/AssociationsAnalyzer;-><init>()V

    return-void
.end method

.method private addNewModelForAssociatedModel(Ljava/util/Collection;Lorg/litepal/crud/DataSupport;)V
    .locals 1
    .param p2, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/DataSupport;",
            ">;",
            "Lorg/litepal/crud/DataSupport;",
            ")V"
        }
    .end annotation

    .line 104
    .local p1, "associatedModelCollection":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    invoke-interface {p1, p2}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 105
    invoke-interface {p1, p2}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 104
    :cond_0
    nop

    .line 107
    :goto_0
    return-void
.end method

.method private dealAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 121
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->isSaved()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v1

    invoke-virtual {p1, v0, v1, v2}, Lorg/litepal/crud/DataSupport;->addAssociatedModelForJoinTable(Ljava/lang/String;J)V

    goto :goto_0

    .line 121
    :cond_0
    nop

    .line 125
    :goto_0
    return-void
.end method

.method private declareAssociations(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associationInfo"    # Lorg/litepal/crud/model/AssociationsInfo;

    .line 89
    invoke-direct {p0, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getAssociatedTableName(Lorg/litepal/crud/model/AssociationsInfo;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lorg/litepal/crud/DataSupport;->addEmptyModelForJoinTable(Ljava/lang/String;)V

    .line 90
    return-void
.end method

.method private getAssociatedTableName(Lorg/litepal/crud/model/AssociationsInfo;)Ljava/lang/String;
    .locals 1
    .param p1, "associationInfo"    # Lorg/litepal/crud/model/AssociationsInfo;

    .line 136
    invoke-virtual {p1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getJoinTableName(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)Ljava/lang/String;
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 217
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/Many2ManyAnalyzer;->getIntermediateTableName(Lorg/litepal/crud/DataSupport;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSelection(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)Ljava/lang/String;
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 184
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 185
    .local v0, "where":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/litepal/crud/Many2ManyAnalyzer;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 186
    const-string v1, " = ? and "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 187
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/litepal/crud/Many2ManyAnalyzer;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    const-string v1, " = ?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getSelectionArgs(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)[Ljava/lang/String;
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 203
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    return-object v0
.end method

.method private isDataExists(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)Z
    .locals 12
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "exists":Z
    invoke-static {}, Lorg/litepal/tablemanager/Connector;->getDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v9

    .line 158
    .local v9, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v10, 0x0

    .line 160
    .local v10, "cursor":Landroid/database/Cursor;
    const/4 v11, 0x1

    :try_start_0
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getJoinTableName(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getSelection(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getSelectionArgs(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)[Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object v1, v9

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    move-object v10, v1

    .line 163
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-lez v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v11, 0x0

    :goto_0
    move v0, v11

    .line 168
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 169
    nop

    .line 170
    return v0

    .line 168
    :catchall_0
    move-exception v1

    goto :goto_1

    .line 164
    :catch_0
    move-exception v1

    .line 165
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 166
    nop

    .line 168
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    return v11

    .end local v1    # "e":Ljava/lang/Exception;
    :goto_1
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    throw v1
.end method


# virtual methods
.method analyze(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associationInfo"    # Lorg/litepal/crud/model/AssociationsInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 63
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getAssociatedModels(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Ljava/util/Collection;

    move-result-object v0

    .line 64
    .local v0, "associatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->declareAssociations(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V

    .line 65
    if-eqz v0, :cond_1

    .line 66
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/crud/DataSupport;

    .line 67
    .local v2, "associatedModel":Lorg/litepal/crud/DataSupport;
    invoke-virtual {p0, v2, p2}, Lorg/litepal/crud/Many2ManyAnalyzer;->getReverseAssociatedModels(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Ljava/util/Collection;

    move-result-object v3

    .line 69
    .local v3, "tempCollection":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    invoke-virtual {p2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateSelfFromOtherModel()Ljava/lang/reflect/Field;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lorg/litepal/crud/Many2ManyAnalyzer;->checkAssociatedModelCollection(Ljava/util/Collection;Ljava/lang/reflect/Field;)Ljava/util/Collection;

    move-result-object v4

    .line 71
    .local v4, "reverseAssociatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    invoke-direct {p0, v4, p1}, Lorg/litepal/crud/Many2ManyAnalyzer;->addNewModelForAssociatedModel(Ljava/util/Collection;Lorg/litepal/crud/DataSupport;)V

    .line 72
    invoke-virtual {p0, v2, p2, v4}, Lorg/litepal/crud/Many2ManyAnalyzer;->setReverseAssociatedModels(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;Ljava/util/Collection;)V

    .line 74
    invoke-direct {p0, p1, v2}, Lorg/litepal/crud/Many2ManyAnalyzer;->dealAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V

    .line 75
    .end local v2    # "associatedModel":Lorg/litepal/crud/DataSupport;
    .end local v3    # "tempCollection":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    .end local v4    # "reverseAssociatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    goto :goto_0

    .line 66
    :cond_0
    goto :goto_1

    .line 65
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    nop

    .line 77
    :goto_1
    return-void
.end method
