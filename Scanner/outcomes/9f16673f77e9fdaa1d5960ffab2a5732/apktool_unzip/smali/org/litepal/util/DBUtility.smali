.class public Lorg/litepal/util/DBUtility;
.super Ljava/lang/Object;
.source "DBUtility.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    return-void
.end method

.method public static findAllTableNames(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;
    .locals 6
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 242
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 243
    .local v0, "tableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 245
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v2, "select * from sqlite_master where type = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "table"

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move-object v1, v2

    .line 246
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 248
    :goto_0
    const-string v2, "tbl_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 249
    .local v2, "tableName":Ljava/lang/String;
    invoke-interface {v0, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 250
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 249
    :cond_0
    nop

    .line 252
    .end local v2    # "tableName":Ljava/lang/String;
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

    .line 246
    :cond_2
    nop

    .line 258
    :goto_2
    if-eqz v1, :cond_3

    .line 259
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 258
    :cond_3
    nop

    .line 262
    :goto_3
    return-object v0

    .line 258
    :catchall_0
    move-exception v2

    goto :goto_4

    .line 254
    :catch_0
    move-exception v2

    .line 255
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 256
    new-instance v3, Lorg/litepal/exceptions/DatabaseGenerateException;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "tableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 258
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "tableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v1    # "cursor":Landroid/database/Cursor;
    .restart local p0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_4
    if-eqz v1, :cond_4

    .line 259
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_5

    .line 258
    :cond_4
    nop

    .line 259
    :goto_5
    throw v2

    return-void
.end method

.method public static findPragmaTableInfo(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Lorg/litepal/tablemanager/model/TableModel;
    .locals 12
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 279
    invoke-static {p0, p1}, Lorg/litepal/util/DBUtility;->isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 280
    invoke-static {p0, p1}, Lorg/litepal/util/DBUtility;->findUniqueColumns(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;

    move-result-object v0

    .line 281
    .local v0, "uniqueColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Lorg/litepal/tablemanager/model/TableModel;

    invoke-direct {v1}, Lorg/litepal/tablemanager/model/TableModel;-><init>()V

    .line 282
    .local v1, "tableModelDB":Lorg/litepal/tablemanager/model/TableModel;
    invoke-virtual {v1, p0}, Lorg/litepal/tablemanager/model/TableModel;->setTableName(Ljava/lang/String;)V

    .line 283
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "pragma table_info("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 284
    .local v2, "checkingColumnSQL":Ljava/lang/String;
    const/4 v3, 0x0

    .line 286
    .local v3, "cursor":Landroid/database/Cursor;
    const/4 v4, 0x0

    :try_start_0
    invoke-virtual {p1, v2, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    move-object v3, v4

    .line 287
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 289
    :goto_0
    new-instance v4, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v4}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 290
    .local v4, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    const-string v5, "name"

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 291
    .local v5, "name":Ljava/lang/String;
    const-string v6, "type"

    invoke-interface {v3, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v3, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 292
    .local v6, "type":Ljava/lang/String;
    const-string v7, "notnull"

    invoke-interface {v3, v7}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v7

    invoke-interface {v3, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    const/4 v8, 0x1

    if-eq v7, v8, :cond_0

    goto :goto_1

    :cond_0
    const/4 v8, 0x0

    :goto_1
    move v7, v8

    .line 293
    .local v7, "nullable":Z
    invoke-interface {v0, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v8

    .line 294
    .local v8, "unique":Z
    const-string v9, "dflt_value"

    invoke-interface {v3, v9}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v9

    invoke-interface {v3, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 295
    .local v9, "defaultValue":Ljava/lang/String;
    invoke-virtual {v4, v5}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 296
    invoke-virtual {v4, v6}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 297
    invoke-virtual {v4, v7}, Lorg/litepal/tablemanager/model/ColumnModel;->setIsNullable(Z)V

    .line 298
    invoke-virtual {v4, v8}, Lorg/litepal/tablemanager/model/ColumnModel;->setIsUnique(Z)V

    .line 299
    if-eqz v9, :cond_1

    .line 300
    const-string v10, "\'"

    const-string v11, ""

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v10

    move-object v9, v10

    goto :goto_2

    .line 302
    :cond_1
    const-string v10, ""

    move-object v9, v10

    .line 304
    :goto_2
    invoke-virtual {v4, v9}, Lorg/litepal/tablemanager/model/ColumnModel;->setDefaultValue(Ljava/lang/String;)V

    .line 305
    invoke-virtual {v1, v4}, Lorg/litepal/tablemanager/model/TableModel;->addColumnModel(Lorg/litepal/tablemanager/model/ColumnModel;)V

    .line 306
    .end local v4    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v5    # "name":Ljava/lang/String;
    .end local v6    # "type":Ljava/lang/String;
    .end local v7    # "nullable":Z
    .end local v8    # "unique":Z
    .end local v9    # "defaultValue":Ljava/lang/String;
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v4, :cond_2

    goto :goto_3

    :cond_2
    goto :goto_0

    .line 287
    :cond_3
    nop

    .line 312
    :goto_3
    if-eqz v3, :cond_4

    .line 313
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    goto :goto_4

    .line 312
    :cond_4
    nop

    .line 316
    :goto_4
    return-object v1

    .line 312
    :catchall_0
    move-exception v4

    goto :goto_5

    .line 308
    :catch_0
    move-exception v4

    .line 309
    .local v4, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    .line 310
    new-instance v5, Lorg/litepal/exceptions/DatabaseGenerateException;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "uniqueColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "tableModelDB":Lorg/litepal/tablemanager/model/TableModel;
    .end local v2    # "checkingColumnSQL":Ljava/lang/String;
    .end local v3    # "cursor":Landroid/database/Cursor;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 312
    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v0    # "uniqueColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v1    # "tableModelDB":Lorg/litepal/tablemanager/model/TableModel;
    .restart local v2    # "checkingColumnSQL":Ljava/lang/String;
    .restart local v3    # "cursor":Landroid/database/Cursor;
    .restart local p0    # "tableName":Ljava/lang/String;
    .restart local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_5
    if-eqz v3, :cond_5

    .line 313
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 312
    :cond_5
    nop

    .line 313
    :goto_6
    throw v4

    .line 318
    .end local v0    # "uniqueColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "tableModelDB":Lorg/litepal/tablemanager/model/TableModel;
    .end local v2    # "checkingColumnSQL":Ljava/lang/String;
    .end local v3    # "cursor":Landroid/database/Cursor;
    :cond_6
    new-instance v0, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Table doesn\'t exist when executing "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v0

    return-void
.end method

.method public static findUniqueColumns(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;
    .locals 8
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/database/sqlite/SQLiteDatabase;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 332
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 333
    .local v0, "columns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 334
    .local v1, "cursor":Landroid/database/Cursor;
    const/4 v2, 0x0

    .line 336
    .local v2, "innerCursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "pragma index_list("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {p1, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    move-object v1, v3

    .line 337
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 339
    :goto_0
    const-string v3, "unique"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 340
    .local v3, "unique":I
    const/4 v5, 0x1

    if-ne v3, v5, :cond_1

    .line 341
    const-string v5, "name"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 342
    .local v5, "name":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "pragma index_info("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6, v4}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    move-object v2, v6

    .line 343
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 344
    const-string v6, "name"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 345
    .local v6, "columnName":Ljava/lang/String;
    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 343
    .end local v6    # "columnName":Ljava/lang/String;
    :cond_0
    goto :goto_1

    .line 340
    .end local v5    # "name":Ljava/lang/String;
    :cond_1
    nop

    .line 348
    .end local v3    # "unique":I
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v3, :cond_2

    goto :goto_2

    :cond_2
    goto :goto_0

    .line 337
    :cond_3
    nop

    .line 354
    :goto_2
    if-eqz v1, :cond_4

    .line 355
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 354
    :cond_4
    nop

    .line 357
    :goto_3
    if-eqz v2, :cond_5

    .line 358
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_4

    .line 357
    :cond_5
    nop

    .line 361
    :goto_4
    return-object v0

    .line 354
    :catchall_0
    move-exception v3

    goto :goto_5

    .line 350
    :catch_0
    move-exception v3

    .line 351
    .local v3, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    .line 352
    new-instance v4, Lorg/litepal/exceptions/DatabaseGenerateException;

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "columns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v2    # "innerCursor":Landroid/database/Cursor;
    .end local p0    # "tableName":Ljava/lang/String;
    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 354
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v0    # "columns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v1    # "cursor":Landroid/database/Cursor;
    .restart local v2    # "innerCursor":Landroid/database/Cursor;
    .restart local p0    # "tableName":Ljava/lang/String;
    .restart local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_5
    if-eqz v1, :cond_6

    .line 355
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 354
    :cond_6
    nop

    .line 357
    :goto_6
    if-eqz v2, :cond_7

    .line 358
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_7

    .line 357
    :cond_7
    nop

    .line 358
    :goto_7
    throw v3

    return-void
.end method

.method public static getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "associatedTableName"    # Ljava/lang/String;

    .line 117
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 118
    const/4 v0, 0x0

    .line 119
    .local v0, "intermediateTableName":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-gtz v1, :cond_0

    .line 120
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 122
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 124
    :goto_0
    return-object v0

    .line 117
    .end local v0    # "intermediateTableName":Ljava/lang/String;
    :cond_1
    nop

    .line 126
    const/4 v0, 0x0

    return-object v0
.end method

.method public static getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "className"    # Ljava/lang/String;

    .line 57
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 58
    const/16 v0, 0x2e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-ne v0, v2, :cond_0

    .line 59
    return-object v1

    .line 61
    :cond_0
    const-string v0, "."

    invoke-virtual {p0, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 64
    :cond_1
    return-object v1
.end method

.method public static getTableNameByForeignColumn(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "foreignColumnName"    # Ljava/lang/String;

    .line 95
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 96
    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v2, "_id"

    invoke-virtual {v0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    const/4 v0, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const-string v2, "_id"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 99
    :cond_0
    return-object v1

    .line 101
    :cond_1
    return-object v1
.end method

.method public static getTableNameListByClassNameList(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 77
    .local p0, "classNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 78
    .local v0, "tableNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p0, :cond_1

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 79
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 80
    .local v2, "className":Ljava/lang/String;
    invoke-static {v2}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 81
    .end local v2    # "className":Ljava/lang/String;
    goto :goto_0

    .line 79
    :cond_0
    goto :goto_1

    .line 78
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    nop

    .line 83
    :goto_1
    return-object v0
.end method

.method public static isColumnExists(Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    .locals 5
    .param p0, "columnName"    # Ljava/lang/String;
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 204
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_6

    .line 207
    :cond_0
    const/4 v0, 0x0

    .line 208
    .local v0, "exist":Z
    const/4 v1, 0x0

    .line 210
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "pragma table_info("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 211
    .local v2, "checkingColumnSQL":Ljava/lang/String;
    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    move-object v1, v3

    .line 212
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 214
    :goto_0
    const-string v3, "name"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 215
    .local v3, "name":Ljava/lang/String;
    invoke-virtual {p0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 216
    const/4 v0, 0x1

    .line 217
    goto :goto_1

    .line 215
    :cond_1
    nop

    .line 219
    .end local v3    # "name":Ljava/lang/String;
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v3, :cond_2

    goto :goto_1

    :cond_2
    goto :goto_0

    .line 212
    :cond_3
    nop

    .line 225
    .end local v2    # "checkingColumnSQL":Ljava/lang/String;
    :goto_1
    if-eqz v1, :cond_4

    .line 226
    :goto_2
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 225
    :cond_4
    goto :goto_3

    :catchall_0
    move-exception v2

    goto :goto_4

    .line 221
    :catch_0
    move-exception v2

    .line 222
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 223
    const/4 v0, 0x0

    .line 225
    .end local v2    # "e":Ljava/lang/Exception;
    if-eqz v1, :cond_4

    .line 226
    goto :goto_2

    .line 229
    :goto_3
    return v0

    .line 225
    :goto_4
    if-eqz v1, :cond_5

    .line 226
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_5

    .line 225
    :cond_5
    nop

    .line 226
    :goto_5
    throw v2

    .line 204
    .end local v0    # "exist":Z
    .end local v1    # "cursor":Landroid/database/Cursor;
    :cond_6
    :goto_6
    nop

    .line 205
    const/4 v0, 0x0

    return v0
.end method

.method public static isIntermediateTable(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    .locals 9
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 138
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 139
    const-string v0, "[0-9a-zA-Z]+_[0-9a-zA-Z]+"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 140
    const/4 v0, 0x0

    .line 142
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v2, "table_schema"

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object v1, p1

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    move-object v0, v1

    .line 144
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 146
    :goto_0
    const-string v1, "name"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, "tableNameDB":Ljava/lang/String;
    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 149
    const-string v2, "type"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 151
    .local v2, "tableType":I
    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    .line 152
    nop

    .line 161
    if-eqz v0, :cond_0

    .line 162
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 161
    :cond_0
    nop

    .line 162
    :goto_1
    return v3

    .line 151
    :cond_1
    goto :goto_2

    .line 148
    .end local v2    # "tableType":I
    :cond_2
    nop

    .line 156
    .end local v1    # "tableNameDB":Ljava/lang/String;
    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v1, :cond_3

    goto :goto_2

    :cond_3
    goto :goto_0

    .line 144
    :cond_4
    nop

    .line 161
    :goto_2
    if-eqz v0, :cond_5

    .line 162
    goto :goto_3

    .line 161
    :catchall_0
    move-exception v1

    goto :goto_4

    .line 158
    :catch_0
    move-exception v1

    .line 159
    .local v1, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 161
    .end local v1    # "e":Ljava/lang/Exception;
    if-eqz v0, :cond_5

    .line 162
    :goto_3
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 161
    :cond_5
    goto :goto_6

    :goto_4
    if-eqz v0, :cond_6

    .line 162
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_5

    .line 161
    :cond_6
    nop

    .line 162
    :goto_5
    throw v1

    .line 139
    .end local v0    # "cursor":Landroid/database/Cursor;
    :cond_7
    goto :goto_6

    .line 138
    :cond_8
    nop

    .line 167
    :goto_6
    const/4 v0, 0x0

    return v0
.end method

.method public static isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    .locals 2
    .param p0, "tableName"    # Ljava/lang/String;
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 182
    const/4 v0, 0x0

    :try_start_0
    invoke-static {p1}, Lorg/litepal/util/DBUtility;->findAllTableNames(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/List;

    move-result-object v1

    invoke-static {v1, p0}, Lorg/litepal/util/BaseUtility;->containsIgnoreCases(Ljava/util/Collection;Ljava/lang/String;)Z

    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 186
    .local v0, "exist":Z
    goto :goto_0

    .line 183
    .end local v0    # "exist":Z
    :catch_0
    move-exception v1

    .line 184
    .restart local v0    # "exist":Z
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 185
    const/4 v0, 0x0

    .line 187
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_0
    return v0
.end method
