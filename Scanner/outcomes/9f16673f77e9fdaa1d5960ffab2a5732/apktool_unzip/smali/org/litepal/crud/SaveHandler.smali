.class Lorg/litepal/crud/SaveHandler;
.super Lorg/litepal/crud/DataHandler;
.source "SaveHandler.java"


# instance fields
.field ignoreAssociations:Z

.field values:Landroid/content/ContentValues;


# direct methods
.method constructor <init>(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 59
    invoke-direct {p0}, Lorg/litepal/crud/DataHandler;-><init>()V

    .line 48
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    .line 60
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    iput-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    .line 61
    iput-object p1, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    .line 62
    return-void
.end method

.method private afterSave(Lorg/litepal/crud/DataSupport;Ljava/util/List;J)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p3, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;J)V"
        }
    .end annotation

    .line 239
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-direct {p0, p3, p4}, Lorg/litepal/crud/SaveHandler;->throwIfSaveFailed(J)V

    .line 240
    invoke-direct {p0, p2}, Lorg/litepal/crud/SaveHandler;->getIdField(Ljava/util/List;)Ljava/lang/reflect/Field;

    move-result-object v0

    invoke-direct {p0, p1, v0, p3, p4}, Lorg/litepal/crud/SaveHandler;->assignIdValue(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;J)V

    .line 241
    iget-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v0, :cond_0

    .line 242
    invoke-direct {p0, p1}, Lorg/litepal/crud/SaveHandler;->updateAssociatedTableWithFK(Lorg/litepal/crud/DataSupport;)V

    .line 243
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/litepal/crud/SaveHandler;->insertIntermediateJoinTableValue(Lorg/litepal/crud/DataSupport;Z)V

    goto :goto_0

    .line 241
    :cond_0
    nop

    .line 245
    :goto_0
    return-void
.end method

.method private afterUpdate(Lorg/litepal/crud/DataSupport;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 319
    iget-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v0, :cond_0

    .line 320
    invoke-direct {p0, p1}, Lorg/litepal/crud/SaveHandler;->updateAssociatedTableWithFK(Lorg/litepal/crud/DataSupport;)V

    .line 321
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lorg/litepal/crud/SaveHandler;->insertIntermediateJoinTableValue(Lorg/litepal/crud/DataSupport;Z)V

    .line 322
    invoke-direct {p0, p1}, Lorg/litepal/crud/SaveHandler;->clearFKValueInAssociatedTable(Lorg/litepal/crud/DataSupport;)V

    goto :goto_0

    .line 319
    :cond_0
    nop

    .line 324
    :goto_0
    return-void
.end method

.method private assignIdValue(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;J)V
    .locals 6
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "idField"    # Ljava/lang/reflect/Field;
    .param p3, "id"    # J

    .line 371
    :try_start_0
    invoke-virtual {p0, p1, p3, p4}, Lorg/litepal/crud/SaveHandler;->giveBaseObjIdValue(Lorg/litepal/crud/DataSupport;J)V

    .line 372
    if-eqz p2, :cond_0

    .line 373
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v3

    move-object v0, p0

    move-object v1, p1

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lorg/litepal/crud/SaveHandler;->giveModelIdValue(Lorg/litepal/crud/DataSupport;Ljava/lang/String;Ljava/lang/Class;J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 372
    :cond_0
    nop

    .line 377
    :goto_0
    nop

    .line 378
    return-void

    .line 375
    :catch_0
    move-exception v0

    .line 376
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private beforeSave(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;",
            "Landroid/content/ContentValues;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 208
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0, p1, p2, p3}, Lorg/litepal/crud/SaveHandler;->putFieldsValue(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 209
    iget-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v0, :cond_0

    .line 210
    invoke-direct {p0, p3, p1}, Lorg/litepal/crud/SaveHandler;->putForeignKeyValue(Landroid/content/ContentValues;Lorg/litepal/crud/DataSupport;)V

    goto :goto_0

    .line 209
    :cond_0
    nop

    .line 212
    :goto_0
    return-void
.end method

.method private beforeUpdate(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;",
            "Landroid/content/ContentValues;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 288
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0, p1, p2, p3}, Lorg/litepal/crud/SaveHandler;->putFieldsValue(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 289
    iget-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v0, :cond_1

    .line 290
    invoke-direct {p0, p3, p1}, Lorg/litepal/crud/SaveHandler;->putForeignKeyValue(Landroid/content/ContentValues;Lorg/litepal/crud/DataSupport;)V

    .line 291
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getListToClearSelfFK()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 292
    .local v1, "fkName":Ljava/lang/String;
    invoke-virtual {p3, v1}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 293
    .end local v1    # "fkName":Ljava/lang/String;
    goto :goto_0

    .line 291
    :cond_0
    goto :goto_1

    .line 289
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    nop

    .line 295
    :goto_1
    return-void
.end method

.method private clearFKValueInAssociatedTable(Lorg/litepal/crud/DataSupport;)V
    .locals 8
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 456
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getListToClearAssociatedFK()Ljava/util/List;

    move-result-object v0

    .line 457
    .local v0, "associatedTableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 458
    .local v2, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 459
    .local v3, "fkColumnName":Ljava/lang/String;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 460
    .local v4, "values":Landroid/content/ContentValues;
    invoke-virtual {v4, v3}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 461
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, " = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 462
    .local v5, "whereClause":Ljava/lang/String;
    iget-object v6, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v7, 0x0

    invoke-virtual {v6, v2, v4, v5, v7}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 463
    .end local v2    # "associatedTableName":Ljava/lang/String;
    .end local v3    # "fkColumnName":Ljava/lang/String;
    .end local v4    # "values":Landroid/content/ContentValues;
    .end local v5    # "whereClause":Ljava/lang/String;
    goto :goto_0

    .line 457
    :cond_0
    nop

    .line 464
    .end local v1    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private doSaveAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 182
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-virtual {v0}, Landroid/content/ContentValues;->clear()V

    .line 183
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-direct {p0, p1, p2, v0}, Lorg/litepal/crud/SaveHandler;->beforeSave(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 184
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-direct {p0, p1, v0}, Lorg/litepal/crud/SaveHandler;->saving(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 185
    .local v0, "id":J
    invoke-direct {p0, p1, p2, v0, v1}, Lorg/litepal/crud/SaveHandler;->afterSave(Lorg/litepal/crud/DataSupport;Ljava/util/List;J)V

    .line 186
    return-void
.end method

.method private doUpdateAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 261
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-virtual {v0}, Landroid/content/ContentValues;->clear()V

    .line 262
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-direct {p0, p1, p2, v0}, Lorg/litepal/crud/SaveHandler;->beforeUpdate(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 263
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->values:Landroid/content/ContentValues;

    invoke-direct {p0, p1, v0}, Lorg/litepal/crud/SaveHandler;->updating(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V

    .line 264
    invoke-direct {p0, p1}, Lorg/litepal/crud/SaveHandler;->afterUpdate(Lorg/litepal/crud/DataSupport;)V

    .line 265
    return-void
.end method

.method private getIdField(Ljava/util/List;)Ljava/lang/reflect/Field;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;)",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    .line 334
    .local p1, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/reflect/Field;

    .line 335
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/litepal/crud/SaveHandler;->isIdColumn(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 336
    return-object v1

    .line 335
    :cond_0
    nop

    .line 338
    .end local v1    # "field":Ljava/lang/reflect/Field;
    goto :goto_0

    .line 334
    :cond_1
    nop

    .line 339
    .end local v0    # "i$":Ljava/util/Iterator;
    const/4 v0, 0x0

    return-object v0
.end method

.method private getWhereForJoinTableToDelete(Lorg/litepal/crud/DataSupport;)Ljava/lang/String;
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 503
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 504
    .local v0, "where":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 505
    const-string v1, " = ?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 506
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private giveModelIdValue(Lorg/litepal/crud/DataSupport;Ljava/lang/String;Ljava/lang/Class;J)V
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "idName"    # Ljava/lang/String;
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "*>;J)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/NoSuchFieldException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .line 400
    .local p3, "idType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p2, p3, p4, p5}, Lorg/litepal/crud/SaveHandler;->shouldGiveModelIdValue(Ljava/lang/String;Ljava/lang/Class;J)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 402
    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-eq p3, v0, :cond_3

    const-class v0, Ljava/lang/Integer;

    if-ne p3, v0, :cond_0

    goto :goto_1

    .line 404
    :cond_0
    sget-object v0, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-eq p3, v0, :cond_2

    const-class v0, Ljava/lang/Long;

    if-ne p3, v0, :cond_1

    goto :goto_0

    .line 407
    :cond_1
    new-instance v0, Lorg/litepal/exceptions/DataSupportException;

    const-string v1, "id type is not supported. Only int or long is acceptable for id"

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 404
    :cond_2
    :goto_0
    nop

    .line 405
    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_2

    .line 402
    :cond_3
    :goto_1
    nop

    .line 403
    long-to-int v0, p4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 409
    .local v0, "value":Ljava/lang/Object;
    :goto_2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {p1, p2, v0, v1}, Lorg/litepal/crud/DynamicExecutor;->setField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V

    goto :goto_3

    .line 400
    .end local v0    # "value":Ljava/lang/Object;
    :cond_4
    nop

    .line 411
    :goto_3
    return-void
.end method

.method private insertIntermediateJoinTableValue(Lorg/litepal/crud/DataSupport;Z)V
    .locals 12
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "isUpdate"    # Z

    .line 476
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapForJoinTable()Ljava/util/Map;

    move-result-object v0

    .line 477
    .local v0, "associatedIdsM2M":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Set<Ljava/lang/Long;>;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 478
    .local v1, "values":Landroid/content/ContentValues;
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 479
    .local v3, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p0, p1, v3}, Lorg/litepal/crud/SaveHandler;->getIntermediateTableName(Lorg/litepal/crud/DataSupport;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 480
    .local v4, "joinTableName":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 481
    iget-object v5, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-direct {p0, p1}, Lorg/litepal/crud/SaveHandler;->getWhereForJoinTableToDelete(Lorg/litepal/crud/DataSupport;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v5, v4, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1

    .line 480
    :cond_0
    nop

    .line 484
    :goto_1
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Set;

    .line 485
    .local v5, "associatedIdsM2MSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Long;

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    .line 486
    .local v7, "associatedId":J
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    .line 487
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v9}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 488
    invoke-virtual {p0, v3}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 489
    iget-object v9, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v10, 0x0

    invoke-virtual {v9, v4, v10, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 490
    .end local v7    # "associatedId":J
    goto :goto_2

    .line 485
    :cond_1
    nop

    .line 491
    .end local v3    # "associatedTableName":Ljava/lang/String;
    .end local v4    # "joinTableName":Ljava/lang/String;
    .end local v5    # "associatedIdsM2MSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v6    # "i$":Ljava/util/Iterator;
    goto :goto_0

    .line 478
    :cond_2
    nop

    .line 492
    .end local v2    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private putForeignKeyValue(Landroid/content/ContentValues;Lorg/litepal/crud/DataSupport;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 421
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithoutFK()Ljava/util/Map;

    move-result-object v0

    .line 422
    .local v0, "associatedModelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Long;>;"
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 423
    .local v2, "associatedTableName":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    invoke-virtual {p1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 425
    .end local v2    # "associatedTableName":Ljava/lang/String;
    goto :goto_0

    .line 422
    :cond_0
    nop

    .line 426
    .end local v1    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private saving(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)J
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "values"    # Landroid/content/ContentValues;

    .line 225
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0
.end method

.method private shouldGiveModelIdValue(Ljava/lang/String;Ljava/lang/Class;J)Z
    .locals 3
    .param p1, "idName"    # Ljava/lang/String;
    .param p3, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "*>;J)Z"
        }
    .end annotation

    .line 524
    .local p2, "idType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    const-wide/16 v0, 0x0

    cmp-long v2, p3, v0

    if-lez v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private throwIfSaveFailed(J)V
    .locals 3
    .param p1, "id"    # J

    .line 349
    const-wide/16 v0, -0x1

    cmp-long v2, p1, v0

    if-eqz v2, :cond_0

    .line 352
    return-void

    .line 350
    :cond_0
    new-instance v0, Lorg/litepal/exceptions/DataSupportException;

    const-string v1, "Save current model failed."

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private updateAssociatedTableWithFK(Lorg/litepal/crud/DataSupport;)V
    .locals 9
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 435
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithFK()Ljava/util/Map;

    move-result-object v0

    .line 436
    .local v0, "associatedModelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Set<Ljava/lang/Long;>;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 437
    .local v1, "values":Landroid/content/ContentValues;
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 438
    .local v3, "associatedTableName":Ljava/lang/String;
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    .line 439
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/litepal/crud/SaveHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 440
    .local v4, "fkName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 441
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Set;

    .line 442
    .local v5, "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/util/Set;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 443
    iget-object v6, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v5}, Lorg/litepal/crud/SaveHandler;->getWhereOfIdsWithOr(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v3, v1, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1

    .line 442
    :cond_0
    nop

    .line 445
    .end local v3    # "associatedTableName":Ljava/lang/String;
    .end local v4    # "fkName":Ljava/lang/String;
    .end local v5    # "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :goto_1
    goto :goto_0

    .line 437
    :cond_1
    nop

    .line 446
    .end local v2    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private updating(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V
    .locals 6
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "values"    # Landroid/content/ContentValues;

    .line 308
    iget-object v0, p0, Lorg/litepal/crud/SaveHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, p2, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 310
    return-void
.end method


# virtual methods
.method onSave(Lorg/litepal/crud/DataSupport;)V
    .locals 4
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 82
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    .line 83
    .local v0, "className":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lorg/litepal/crud/SaveHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 84
    .local v1, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0, v0}, Lorg/litepal/crud/SaveHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v2

    .line 85
    .local v2, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->isSaved()Z

    move-result v3

    if-nez v3, :cond_2

    .line 86
    iget-boolean v3, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v3, :cond_0

    .line 87
    invoke-virtual {p0, p1, v2}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    goto :goto_0

    .line 86
    :cond_0
    nop

    .line 89
    :goto_0
    invoke-direct {p0, p1, v1}, Lorg/litepal/crud/SaveHandler;->doSaveAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V

    .line 90
    iget-boolean v3, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v3, :cond_1

    .line 91
    invoke-virtual {p0, p1, v2}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    goto :goto_2

    .line 90
    :cond_1
    goto :goto_2

    .line 94
    :cond_2
    iget-boolean v3, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    if-nez v3, :cond_3

    .line 95
    invoke-virtual {p0, p1, v2}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    goto :goto_1

    .line 94
    :cond_3
    nop

    .line 97
    :goto_1
    invoke-direct {p0, p1, v1}, Lorg/litepal/crud/SaveHandler;->doUpdateAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V

    .line 99
    :goto_2
    return-void
.end method

.method onSaveAll(Ljava/util/Collection;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lorg/litepal/crud/DataSupport;",
            ">(",
            "Ljava/util/Collection<",
            "TT;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 140
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    if-eqz p1, :cond_2

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 141
    const/4 v0, 0x0

    new-array v1, v0, [Lorg/litepal/crud/DataSupport;

    invoke-interface {p1, v1}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lorg/litepal/crud/DataSupport;

    .line 142
    .local v1, "array":[Lorg/litepal/crud/DataSupport;
    aget-object v0, v1, v0

    .line 143
    .local v0, "firstObj":Lorg/litepal/crud/DataSupport;
    invoke-virtual {v0}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v2

    .line 144
    .local v2, "className":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/litepal/crud/SaveHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 145
    .local v3, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0, v2}, Lorg/litepal/crud/SaveHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v4

    .line 146
    .local v4, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    move-object v5, v1

    .local v5, "arr$":[Lorg/litepal/crud/DataSupport;
    array-length v6, v5

    .local v6, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_0
    if-ge v7, v6, :cond_1

    aget-object v8, v5, v7

    .line 147
    .local v8, "baseObj":Lorg/litepal/crud/DataSupport;
    invoke-virtual {v8}, Lorg/litepal/crud/DataSupport;->isSaved()Z

    move-result v9

    if-nez v9, :cond_0

    .line 148
    invoke-virtual {p0, v8, v4}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    .line 149
    invoke-direct {p0, v8, v3}, Lorg/litepal/crud/SaveHandler;->doSaveAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V

    .line 150
    invoke-virtual {p0, v8, v4}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    goto :goto_1

    .line 152
    :cond_0
    invoke-virtual {p0, v8, v4}, Lorg/litepal/crud/SaveHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V

    .line 153
    invoke-direct {p0, v8, v3}, Lorg/litepal/crud/SaveHandler;->doUpdateAction(Lorg/litepal/crud/DataSupport;Ljava/util/List;)V

    .line 155
    :goto_1
    invoke-virtual {v8}, Lorg/litepal/crud/DataSupport;->clearAssociatedData()V

    .line 146
    .end local v8    # "baseObj":Lorg/litepal/crud/DataSupport;
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    :cond_1
    goto :goto_2

    .line 140
    .end local v0    # "firstObj":Lorg/litepal/crud/DataSupport;
    .end local v1    # "array":[Lorg/litepal/crud/DataSupport;
    .end local v2    # "className":Ljava/lang/String;
    .end local v3    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    .end local v4    # "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    .end local v5    # "arr$":[Lorg/litepal/crud/DataSupport;
    .end local v6    # "len$":I
    .end local v7    # "i$":I
    :cond_2
    nop

    .line 158
    :goto_2
    return-void
.end method

.method onSaveFast(Lorg/litepal/crud/DataSupport;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/litepal/crud/SaveHandler;->ignoreAssociations:Z

    .line 118
    invoke-virtual {p0, p1}, Lorg/litepal/crud/SaveHandler;->onSave(Lorg/litepal/crud/DataSupport;)V

    .line 119
    return-void
.end method
