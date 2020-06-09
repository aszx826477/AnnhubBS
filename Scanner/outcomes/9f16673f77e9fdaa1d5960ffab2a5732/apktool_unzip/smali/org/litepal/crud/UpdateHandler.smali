.class Lorg/litepal/crud/UpdateHandler;
.super Lorg/litepal/crud/DataHandler;
.source "UpdateHandler.java"


# direct methods
.method constructor <init>(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 50
    invoke-direct {p0}, Lorg/litepal/crud/DataHandler;-><init>()V

    .line 51
    iput-object p1, p0, Lorg/litepal/crud/UpdateHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    .line 52
    return-void
.end method

.method private analyzeAssociations(Lorg/litepal/crud/DataSupport;)V
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 226
    :try_start_0
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/UpdateHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    .line 228
    .local v0, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/UpdateHandler;->analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 231
    .end local v0    # "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    nop

    .line 232
    return-void

    .line 229
    :catch_0
    move-exception v0

    .line 230
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private varargs doUpdateAllAction(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I
    .locals 3
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "conditions"    # [Ljava/lang/String;

    .line 167
    invoke-static {p3}, Lorg/litepal/util/BaseUtility;->checkConditionsCorrect([Ljava/lang/String;)V

    .line 168
    invoke-virtual {p2}, Landroid/content/ContentValues;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 169
    iget-object v0, p0, Lorg/litepal/crud/UpdateHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p3}, Lorg/litepal/crud/UpdateHandler;->getWhereClause([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p3}, Lorg/litepal/crud/UpdateHandler;->getWhereArgs([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, p2, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0

    .line 172
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method private doUpdateAssociations(Lorg/litepal/crud/DataSupport;JLandroid/content/ContentValues;)I
    .locals 2
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "id"    # J
    .param p4, "values"    # Landroid/content/ContentValues;

    .line 209
    const/4 v0, 0x0

    .line 210
    .local v0, "rowsAffected":I
    invoke-direct {p0, p1}, Lorg/litepal/crud/UpdateHandler;->analyzeAssociations(Lorg/litepal/crud/DataSupport;)V

    .line 211
    invoke-direct {p0, p1, p4}, Lorg/litepal/crud/UpdateHandler;->updateSelfTableForeignKey(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V

    .line 212
    invoke-direct {p0, p1, p2, p3}, Lorg/litepal/crud/UpdateHandler;->updateAssociatedTableForeignKey(Lorg/litepal/crud/DataSupport;J)I

    move-result v1

    add-int/2addr v0, v1

    .line 213
    return v0
.end method

.method private putFieldsToDefaultValue(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V
    .locals 6
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "values"    # Landroid/content/ContentValues;

    .line 185
    const/4 v0, 0x0

    .line 187
    .local v0, "fieldName":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0, p1}, Lorg/litepal/crud/UpdateHandler;->getEmptyModel(Lorg/litepal/crud/DataSupport;)Lorg/litepal/crud/DataSupport;

    move-result-object v1

    .line 188
    .local v1, "emptyModel":Lorg/litepal/crud/DataSupport;
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 189
    .local v2, "emptyModelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getFieldsToSetToDefault()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 190
    .local v4, "name":Ljava/lang/String;
    invoke-virtual {p0, v4}, Lorg/litepal/crud/UpdateHandler;->isIdColumn(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 191
    move-object v0, v4

    .line 192
    invoke-virtual {v2, v0}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v5

    .line 193
    .local v5, "field":Ljava/lang/reflect/Field;
    invoke-virtual {p0, v1, v5, p2}, Lorg/litepal/crud/UpdateHandler;->putContentValuesForUpdate(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 190
    .end local v5    # "field":Ljava/lang/reflect/Field;
    :cond_0
    nop

    .line 195
    .end local v4    # "name":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .line 189
    :cond_1
    nop

    .line 201
    .end local v1    # "emptyModel":Lorg/litepal/crud/DataSupport;
    .end local v2    # "emptyModelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    nop

    .line 202
    return-void

    .line 199
    :catch_0
    move-exception v1

    .line 200
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 196
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 197
    .local v1, "e":Ljava/lang/NoSuchFieldException;
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v0}, Lorg/litepal/exceptions/DataSupportException;->noSuchFieldExceptioin(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    return-void
.end method

.method private updateAssociatedTableForeignKey(Lorg/litepal/crud/DataSupport;J)I
    .locals 9
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "id"    # J

    .line 249
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithFK()Ljava/util/Map;

    move-result-object v0

    .line 250
    .local v0, "associatedModelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Set<Ljava/lang/Long;>;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 251
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

    .line 252
    .local v3, "associatedTable":Ljava/lang/String;
    invoke-virtual {v1}, Landroid/content/ContentValues;->clear()V

    .line 253
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/litepal/crud/UpdateHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 254
    .local v4, "fkName":Ljava/lang/String;
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 255
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Set;

    .line 256
    .local v5, "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/util/Set;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 257
    iget-object v6, p0, Lorg/litepal/crud/UpdateHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v5}, Lorg/litepal/crud/UpdateHandler;->getWhereOfIdsWithOr(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v3, v1, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    return v6

    .line 256
    :cond_0
    nop

    .line 259
    .end local v3    # "associatedTable":Ljava/lang/String;
    .end local v4    # "fkName":Ljava/lang/String;
    .end local v5    # "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    goto :goto_0

    .line 251
    :cond_1
    nop

    .line 260
    .end local v2    # "i$":Ljava/util/Iterator;
    const/4 v2, 0x0

    return v2
.end method

.method private updateSelfTableForeignKey(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "values"    # Landroid/content/ContentValues;

    .line 238
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getAssociatedModelsMapWithoutFK()Ljava/util/Map;

    move-result-object v0

    .line 239
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

    .line 240
    .local v2, "associatedTable":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/litepal/crud/UpdateHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 241
    .local v3, "fkName":Ljava/lang/String;
    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    invoke-virtual {p2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 242
    .end local v2    # "associatedTable":Ljava/lang/String;
    .end local v3    # "fkName":Ljava/lang/String;
    goto :goto_0

    .line 239
    :cond_0
    nop

    .line 243
    .end local v1    # "i$":Ljava/util/Iterator;
    return-void
.end method


# virtual methods
.method onUpdate(Ljava/lang/Class;JLandroid/content/ContentValues;)I
    .locals 4
    .param p2, "id"    # J
    .param p4, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;J",
            "Landroid/content/ContentValues;",
            ")I"
        }
    .end annotation

    .line 97
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p4}, Landroid/content/ContentValues;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 98
    iget-object v0, p0, Lorg/litepal/crud/UpdateHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p1}, Lorg/litepal/crud/UpdateHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "id = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v1, p4, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0

    .line 100
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method onUpdate(Lorg/litepal/crud/DataSupport;J)I
    .locals 6
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "id"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 72
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/UpdateHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 73
    .local v0, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 74
    .local v1, "values":Landroid/content/ContentValues;
    invoke-virtual {p0, p1, v0, v1}, Lorg/litepal/crud/UpdateHandler;->putFieldsValue(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 75
    invoke-direct {p0, p1, v1}, Lorg/litepal/crud/UpdateHandler;->putFieldsToDefaultValue(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V

    .line 76
    invoke-virtual {v1}, Landroid/content/ContentValues;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 77
    iget-object v2, p0, Lorg/litepal/crud/UpdateHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "id = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    return v2

    .line 79
    :cond_0
    const/4 v2, 0x0

    return v2
.end method

.method varargs onUpdateAll(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I
    .locals 1
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "conditions"    # [Ljava/lang/String;

    .line 148
    invoke-direct {p0, p1, p2, p3}, Lorg/litepal/crud/UpdateHandler;->doUpdateAllAction(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method varargs onUpdateAll(Lorg/litepal/crud/DataSupport;[Ljava/lang/String;)I
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 124
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/crud/UpdateHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 125
    .local v0, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 126
    .local v1, "values":Landroid/content/ContentValues;
    invoke-virtual {p0, p1, v0, v1}, Lorg/litepal/crud/UpdateHandler;->putFieldsValue(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V

    .line 127
    invoke-direct {p0, p1, v1}, Lorg/litepal/crud/UpdateHandler;->putFieldsToDefaultValue(Lorg/litepal/crud/DataSupport;Landroid/content/ContentValues;)V

    .line 128
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2, v1, p2}, Lorg/litepal/crud/UpdateHandler;->doUpdateAllAction(Ljava/lang/String;Landroid/content/ContentValues;[Ljava/lang/String;)I

    move-result v2

    return v2
.end method
