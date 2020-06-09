.class public Lorg/litepal/crud/DeleteHandler;
.super Lorg/litepal/crud/DataHandler;
.source "DeleteHandler.java"


# instance fields
.field private foreignKeyTableToDelete:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 58
    invoke-direct {p0}, Lorg/litepal/crud/DataHandler;-><init>()V

    .line 59
    iput-object p1, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    .line 60
    return-void
.end method

.method private analyzeAssociations(Lorg/litepal/crud/DataSupport;)Ljava/util/Collection;
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            ")",
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation

    .line 227
    :try_start_0
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/DeleteHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    .line 229
    .local v0, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/DeleteHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    return-object v0

    .line 231
    .end local v0    # "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    :catch_0
    move-exception v0

    .line 232
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private analyzeAssociations(Ljava/lang/Class;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)V"
        }
    .end annotation

    .line 145
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/DeleteHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    .line 147
    .local v0, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/crud/model/AssociationsInfo;

    .line 148
    .local v2, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 151
    .local v3, "associatedTableName":Ljava/lang/String;
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v4

    const/4 v5, 0x2

    if-eq v4, v5, :cond_1

    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    goto :goto_1

    .line 158
    :cond_0
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_3

    .line 159
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DeleteHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3}, Lorg/litepal/util/DBUtility;->getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 161
    .local v4, "joinTableName":Ljava/lang/String;
    invoke-static {v4}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 162
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 151
    .end local v4    # "joinTableName":Ljava/lang/String;
    :cond_1
    :goto_1
    nop

    .line 153
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getClassHoldsForeignKey()Ljava/lang/String;

    move-result-object v4

    .line 155
    .local v4, "classHoldsForeignKey":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 156
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 155
    :cond_2
    nop

    .line 158
    .end local v4    # "classHoldsForeignKey":Ljava/lang/String;
    :cond_3
    :goto_2
    nop

    .line 164
    .end local v2    # "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    .end local v3    # "associatedTableName":Ljava/lang/String;
    :goto_3
    goto :goto_0

    .line 147
    :cond_4
    nop

    .line 165
    .end local v1    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private varargs buildConditionString([Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "conditions"    # [Ljava/lang/String;

    .line 210
    array-length v0, p1

    add-int/lit8 v0, v0, -0x1

    .line 211
    .local v0, "argCount":I
    const/4 v1, 0x0

    aget-object v1, p1, v1

    .line 212
    .local v1, "whereClause":Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_0

    .line 213
    const-string v3, "\\?"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v5, v2, 0x1

    aget-object v5, p1, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 212
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 215
    .end local v2    # "i":I
    :cond_0
    return-object v1
.end method

.method private clearAssociatedModelSaveState(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;)V"
        }
    .end annotation

    .line 249
    .local p2, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    :try_start_0
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/crud/model/AssociationsInfo;

    .line 250
    .local v1, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_3

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getClassHoldsForeignKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 253
    invoke-virtual {p0, p1, v1}, Lorg/litepal/crud/DeleteHandler;->getAssociatedModels(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Ljava/util/Collection;

    move-result-object v2

    .line 255
    .local v2, "associatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    if-eqz v2, :cond_2

    invoke-interface {v2}, Ljava/util/Collection;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 256
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/litepal/crud/DataSupport;

    .line 257
    .local v4, "model":Lorg/litepal/crud/DataSupport;
    if-eqz v4, :cond_0

    .line 258
    invoke-virtual {v4}, Lorg/litepal/crud/DataSupport;->clearSavedState()V

    goto :goto_2

    .line 257
    :cond_0
    nop

    .line 260
    .end local v4    # "model":Lorg/litepal/crud/DataSupport;
    :goto_2
    goto :goto_1

    .line 256
    :cond_1
    goto :goto_3

    .line 255
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    goto :goto_3

    .line 250
    .end local v2    # "associatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/DataSupport;>;"
    :cond_3
    nop

    .line 262
    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_5

    .line 263
    invoke-virtual {p0, p1, v1}, Lorg/litepal/crud/DeleteHandler;->getAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Lorg/litepal/crud/DataSupport;

    move-result-object v2

    .line 265
    .local v2, "model":Lorg/litepal/crud/DataSupport;
    if-eqz v2, :cond_4

    .line 266
    invoke-virtual {v2}, Lorg/litepal/crud/DataSupport;->clearSavedState()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_4

    .line 265
    :cond_4
    goto :goto_4

    .line 262
    .end local v2    # "model":Lorg/litepal/crud/DataSupport;
    :cond_5
    :goto_3
    nop

    .line 269
    .end local v1    # "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    :goto_4
    goto :goto_0

    .line 249
    :cond_6
    nop

    .line 272
    .end local v0    # "i$":Ljava/util/Iterator;
    nop

    .line 273
    return-void

    .line 270
    :catch_0
    move-exception v0

    .line 271
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    return-void
.end method

.method private varargs deleteAllCascade(Ljava/lang/Class;[Ljava/lang/String;)I
    .locals 9
    .param p2, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;[",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .line 192
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x0

    .line 193
    .local v0, "rowsAffected":I
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 194
    .local v2, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DeleteHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v3

    .line 195
    .local v3, "tableName":Ljava/lang/String;
    invoke-virtual {p0, v3}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 196
    .local v4, "fkName":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 197
    .local v5, "whereClause":Ljava/lang/StringBuilder;
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, " in (select id from "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 199
    if-eqz p2, :cond_0

    array-length v6, p2

    if-lez v6, :cond_0

    .line 200
    const-string v6, " where "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0, p2}, Lorg/litepal/crud/DeleteHandler;->buildConditionString([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 199
    :cond_0
    nop

    .line 202
    :goto_1
    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 203
    iget-object v6, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v2, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    add-int/2addr v0, v6

    .line 205
    .end local v2    # "associatedTableName":Ljava/lang/String;
    .end local v3    # "tableName":Ljava/lang/String;
    .end local v4    # "fkName":Ljava/lang/String;
    .end local v5    # "whereClause":Ljava/lang/StringBuilder;
    goto :goto_0

    .line 193
    :cond_1
    nop

    .line 206
    .end local v1    # "i$":Ljava/util/Iterator;
    return v0
.end method

.method private deleteAssociatedForeignKeyRows(Lorg/litepal/crud/DataSupport;)I
    .locals 9
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 303
    const/4 v0, 0x0

    .line 304
    .local v0, "rowsAffected":I
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithFK()Ljava/util/Map;

    move-result-object v1

    .line 306
    .local v1, "associatedModelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Set<Ljava/lang/Long;>;>;"
    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 307
    .local v3, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 308
    .local v4, "fkName":Ljava/lang/String;
    iget-object v5, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, " = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v7

    invoke-virtual {v6, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, v3, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    add-int/2addr v0, v5

    .line 310
    .end local v3    # "associatedTableName":Ljava/lang/String;
    .end local v4    # "fkName":Ljava/lang/String;
    goto :goto_0

    .line 306
    :cond_0
    nop

    .line 311
    .end local v2    # "i$":Ljava/util/Iterator;
    return v0
.end method

.method private deleteAssociatedJoinTableRows(Lorg/litepal/crud/DataSupport;)I
    .locals 10
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 323
    const/4 v0, 0x0

    .line 324
    .local v0, "rowsAffected":I
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapForJoinTable()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 326
    .local v1, "associatedTableNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 327
    .local v3, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3}, Lorg/litepal/util/DBUtility;->getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 329
    .local v4, "joinTableName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 330
    .local v5, "fkName":Ljava/lang/String;
    iget-object v6, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v8, " = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v4, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    add-int/2addr v0, v6

    .line 332
    .end local v3    # "associatedTableName":Ljava/lang/String;
    .end local v4    # "joinTableName":Ljava/lang/String;
    .end local v5    # "fkName":Ljava/lang/String;
    goto :goto_0

    .line 326
    :cond_0
    nop

    .line 333
    .end local v2    # "i$":Ljava/util/Iterator;
    return v0
.end method

.method private deleteCascade(Ljava/lang/Class;J)I
    .locals 7
    .param p2, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;J)I"
        }
    .end annotation

    .line 182
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x0

    .line 183
    .local v0, "rowsAffected":I
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 184
    .local v2, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DeleteHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 185
    .local v3, "fkName":Ljava/lang/String;
    iget-object v4, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, " = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v4

    add-int/2addr v0, v4

    .line 187
    .end local v2    # "associatedTableName":Ljava/lang/String;
    .end local v3    # "fkName":Ljava/lang/String;
    goto :goto_0

    .line 183
    :cond_0
    nop

    .line 188
    .end local v1    # "i$":Ljava/util/Iterator;
    return v0
.end method

.method private deleteCascade(Lorg/litepal/crud/DataSupport;)I
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 289
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->deleteAssociatedForeignKeyRows(Lorg/litepal/crud/DataSupport;)I

    move-result v0

    .line 290
    .local v0, "rowsAffected":I
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->deleteAssociatedJoinTableRows(Lorg/litepal/crud/DataSupport;)I

    move-result v1

    add-int/2addr v0, v1

    .line 291
    return v0
.end method

.method private getForeignKeyTableToDelete()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 343
    iget-object v0, p0, Lorg/litepal/crud/DeleteHandler;->foreignKeyTableToDelete:Ljava/util/List;

    if-nez v0, :cond_0

    .line 344
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/DeleteHandler;->foreignKeyTableToDelete:Ljava/util/List;

    goto :goto_0

    .line 343
    :cond_0
    nop

    .line 346
    :goto_0
    iget-object v0, p0, Lorg/litepal/crud/DeleteHandler;->foreignKeyTableToDelete:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method onDelete(Ljava/lang/Class;J)I
    .locals 5
    .param p2, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;J)I"
        }
    .end annotation

    .line 100
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->analyzeAssociations(Ljava/lang/Class;)V

    .line 101
    invoke-direct {p0, p1, p2, p3}, Lorg/litepal/crud/DeleteHandler;->deleteCascade(Ljava/lang/Class;J)I

    move-result v0

    .line 102
    .local v0, "rowsAffected":I
    iget-object v1, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p1}, Lorg/litepal/crud/DeleteHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "id = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    add-int/2addr v0, v1

    .line 104
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 105
    return v0
.end method

.method onDelete(Lorg/litepal/crud/DataSupport;)I
    .locals 7
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 75
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->isSaved()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->analyzeAssociations(Lorg/litepal/crud/DataSupport;)Ljava/util/Collection;

    move-result-object v0

    .line 77
    .local v0, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->deleteCascade(Lorg/litepal/crud/DataSupport;)I

    move-result v1

    .line 78
    .local v1, "rowsAffected":I
    iget-object v2, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "id = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v5

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    add-int/2addr v1, v2

    .line 80
    invoke-direct {p0, p1, v0}, Lorg/litepal/crud/DeleteHandler;->clearAssociatedModelSaveState(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    .line 81
    return v1

    .line 83
    .end local v0    # "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    .end local v1    # "rowsAffected":I
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method varargs onDeleteAll(Ljava/lang/Class;[Ljava/lang/String;)I
    .locals 5
    .param p2, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;[",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .line 127
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p2}, Lorg/litepal/util/BaseUtility;->checkConditionsCorrect([Ljava/lang/String;)V

    .line 128
    invoke-direct {p0, p1}, Lorg/litepal/crud/DeleteHandler;->analyzeAssociations(Ljava/lang/Class;)V

    .line 129
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/DeleteHandler;->deleteAllCascade(Ljava/lang/Class;[Ljava/lang/String;)I

    move-result v0

    .line 130
    .local v0, "rowsAffected":I
    iget-object v1, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p1}, Lorg/litepal/crud/DeleteHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, p2}, Lorg/litepal/crud/DeleteHandler;->getWhereClause([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, p2}, Lorg/litepal/crud/DeleteHandler;->getWhereArgs([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    add-int/2addr v0, v1

    .line 132
    invoke-direct {p0}, Lorg/litepal/crud/DeleteHandler;->getForeignKeyTableToDelete()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 133
    return v0
.end method

.method varargs onDeleteAll(Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "conditions"    # [Ljava/lang/String;

    .line 121
    invoke-static {p2}, Lorg/litepal/util/BaseUtility;->checkConditionsCorrect([Ljava/lang/String;)V

    .line 122
    iget-object v0, p0, Lorg/litepal/crud/DeleteHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p2}, Lorg/litepal/crud/DeleteHandler;->getWhereClause([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p2}, Lorg/litepal/crud/DeleteHandler;->getWhereArgs([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method
