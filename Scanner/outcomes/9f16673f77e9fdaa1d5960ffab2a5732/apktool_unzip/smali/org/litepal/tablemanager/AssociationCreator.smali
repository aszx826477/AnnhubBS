.class public abstract Lorg/litepal/tablemanager/AssociationCreator;
.super Lorg/litepal/tablemanager/Generator;
.source "AssociationCreator.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51
    invoke-direct {p0}, Lorg/litepal/tablemanager/Generator;-><init>()V

    return-void
.end method

.method private addAssociations(Ljava/util/Collection;Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 5
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "force"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/AssociationsModel;",
            ">;",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Z)V"
        }
    .end annotation

    .line 284
    .local p1, "associatedModels":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/tablemanager/model/AssociationsModel;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/tablemanager/model/AssociationsModel;

    .line 285
    .local v1, "associationModel":Lorg/litepal/tablemanager/model/AssociationsModel;
    const/4 v2, 0x2

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getAssociationType()I

    move-result v3

    if-eq v2, v3, :cond_2

    const/4 v2, 0x1

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getAssociationType()I

    move-result v3

    if-ne v2, v3, :cond_0

    goto :goto_1

    .line 290
    :cond_0
    const/4 v2, 0x3

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getAssociationType()I

    move-result v3

    if-ne v2, v3, :cond_1

    .line 291
    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getAssociatedTableName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3, p2, p3}, Lorg/litepal/tablemanager/AssociationCreator;->createIntermediateTable(Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Z)V

    goto :goto_2

    .line 290
    :cond_1
    goto :goto_2

    .line 285
    :cond_2
    :goto_1
    nop

    .line 287
    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getAssociatedTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->getTableHoldsForeignKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v2, v3, v4, p2}, Lorg/litepal/tablemanager/AssociationCreator;->addForeignKeyColumn(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 294
    .end local v1    # "associationModel":Lorg/litepal/tablemanager/model/AssociationsModel;
    :goto_2
    goto :goto_0

    .line 284
    :cond_3
    nop

    .line 295
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private createIntermediateTable(Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 7
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "associatedTableName"    # Ljava/lang/String;
    .param p3, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p4, "force"    # Z

    .line 314
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 315
    .local v0, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    new-instance v1, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v1}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 316
    .local v1, "column1":Lorg/litepal/tablemanager/model/ColumnModel;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 317
    const-string v2, "integer"

    invoke-virtual {v1, v2}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 318
    new-instance v2, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v2}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 319
    .local v2, "column2":Lorg/litepal/tablemanager/model/ColumnModel;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "_id"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 320
    const-string v3, "integer"

    invoke-virtual {v2, v3}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 321
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 322
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 323
    invoke-static {p1, p2}, Lorg/litepal/util/DBUtility;->getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 325
    .local v3, "intermediateTableName":Ljava/lang/String;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 326
    .local v4, "sqls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v3, p3}, Lorg/litepal/util/DBUtility;->isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v5

    const/4 v6, 0x0

    if-eqz v5, :cond_1

    .line 327
    if-eqz p4, :cond_0

    .line 328
    invoke-virtual {p0, v3}, Lorg/litepal/tablemanager/AssociationCreator;->generateDropTableSQL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 329
    invoke-virtual {p0, v3, v0, v6}, Lorg/litepal/tablemanager/AssociationCreator;->generateCreateTableSQL(Ljava/lang/String;Ljava/util/List;Z)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 327
    :cond_0
    goto :goto_0

    .line 332
    :cond_1
    invoke-virtual {p0, v3, v0, v6}, Lorg/litepal/tablemanager/AssociationCreator;->generateCreateTableSQL(Ljava/lang/String;Ljava/util/List;Z)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 334
    :goto_0
    new-array v5, v6, [Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/String;

    invoke-virtual {p0, v5, p3}, Lorg/litepal/tablemanager/AssociationCreator;->execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 335
    const/4 v5, 0x1

    invoke-virtual {p0, v3, v5, p3}, Lorg/litepal/tablemanager/AssociationCreator;->giveTableSchemaACopy(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase;)V

    .line 336
    return-void
.end method

.method private isNeedtoGiveACopy(Landroid/database/Cursor;Ljava/lang/String;)Z
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "tableName"    # Ljava/lang/String;

    .line 228
    invoke-direct {p0, p1, p2}, Lorg/litepal/tablemanager/AssociationCreator;->isValueExists(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0, p2}, Lorg/litepal/tablemanager/AssociationCreator;->isSpecialTable(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private isSpecialTable(Ljava/lang/String;)Z
    .locals 1
    .param p1, "tableName"    # Ljava/lang/String;

    .line 264
    const-string v0, "table_schema"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private isValueExists(Landroid/database/Cursor;Ljava/lang/String;)Z
    .locals 3
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "tableName"    # Ljava/lang/String;

    .line 241
    const/4 v0, 0x0

    .line 242
    .local v0, "exist":Z
    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 244
    :goto_0
    const-string v1, "name"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 246
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {v1, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 247
    const/4 v0, 0x1

    .line 248
    goto :goto_1

    .line 246
    :cond_0
    nop

    .line 250
    .end local v1    # "name":Ljava/lang/String;
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    goto :goto_0

    .line 242
    :cond_2
    nop

    .line 252
    :goto_1
    return v0
.end method


# virtual methods
.method protected addForeignKeyColumn(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "associatedTableName"    # Ljava/lang/String;
    .param p3, "tableHoldsForeignKey"    # Ljava/lang/String;
    .param p4, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 357
    invoke-static {p1, p4}, Lorg/litepal/util/DBUtility;->isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 358
    invoke-static {p2, p4}, Lorg/litepal/util/DBUtility;->isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 359
    const/4 v0, 0x0

    .line 360
    .local v0, "foreignKeyColumn":Ljava/lang/String;
    invoke-virtual {p1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 361
    invoke-virtual {p0, p2}, Lorg/litepal/tablemanager/AssociationCreator;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 362
    :cond_0
    invoke-virtual {p2, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 363
    invoke-virtual {p0, p1}, Lorg/litepal/tablemanager/AssociationCreator;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 362
    :cond_1
    nop

    .line 365
    :goto_0
    invoke-static {v0, p3, p4}, Lorg/litepal/util/DBUtility;->isColumnExists(Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 366
    new-instance v1, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v1}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 367
    .local v1, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v1, v0}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 368
    const-string v2, "integer"

    invoke-virtual {v1, v2}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 369
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {p0, p3, v1}, Lorg/litepal/tablemanager/AssociationCreator;->generateAddColumnSQL(Ljava/lang/String;Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 370
    .local v2, "sqls":[Ljava/lang/String;
    invoke-virtual {p0, v2, p4}, Lorg/litepal/tablemanager/AssociationCreator;->execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 371
    .end local v1    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v2    # "sqls":[Ljava/lang/String;
    goto :goto_1

    .line 372
    :cond_2
    const-string v1, "Generator"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " is already exist, no need to add one"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    .end local v0    # "foreignKeyColumn":Ljava/lang/String;
    :goto_1
    nop

    .line 383
    return-void

    .line 376
    :cond_3
    new-instance v0, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Table doesn\'t exist with the name of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 380
    :cond_4
    new-instance v0, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Table doesn\'t exist with the name of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected addOrUpdateAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "force"    # Z

    .line 62
    invoke-virtual {p0}, Lorg/litepal/tablemanager/AssociationCreator;->getAllAssociations()Ljava/util/Collection;

    move-result-object v0

    invoke-direct {p0, v0, p1, p2}, Lorg/litepal/tablemanager/AssociationCreator;->addAssociations(Ljava/util/Collection;Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 63
    return-void
.end method

.method protected abstract createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V
.end method

.method protected generateAddColumnSQL(Ljava/lang/String;Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;
    .locals 5
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "columnModel"    # Lorg/litepal/tablemanager/model/ColumnModel;

    .line 136
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 137
    .local v0, "addColumnSQL":Ljava/lang/StringBuilder;
    const-string v1, "alter table "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 138
    const-string v1, " add column "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v1

    if-nez v1, :cond_0

    .line 141
    const-string v1, " not null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 140
    :cond_0
    nop

    .line 143
    :goto_0
    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 144
    const-string v1, " unique"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 143
    :cond_1
    nop

    .line 146
    :goto_1
    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "defaultValue":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 148
    const-string v2, " default "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 150
    :cond_2
    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v2

    if-nez v2, :cond_6

    .line 151
    const-string v2, "integer"

    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 152
    const-string v1, "0"

    goto :goto_2

    .line 153
    :cond_3
    const-string v2, "text"

    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 154
    const-string v1, "\'\'"

    goto :goto_2

    .line 155
    :cond_4
    const-string v2, "real"

    invoke-virtual {p2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 156
    const-string v1, "0.0"

    goto :goto_2

    .line 155
    :cond_5
    nop

    .line 158
    :goto_2
    const-string v2, " default "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 150
    :cond_6
    nop

    .line 161
    :goto_3
    const-string v2, "Generator"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "add column sql is >> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method protected generateCreateTableSQL(Ljava/lang/String;Ljava/util/List;Z)Ljava/lang/String;
    .locals 6
    .param p1, "tableName"    # Ljava/lang/String;
    .param p3, "autoIncrementId"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;Z)",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 82
    .local p2, "columnModels":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "create table "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 83
    .local v0, "createTableSQL":Ljava/lang/StringBuilder;
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    if-eqz p3, :cond_0

    .line 85
    const-string v1, "id integer primary key autoincrement,"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 84
    :cond_0
    nop

    .line 87
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 88
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 87
    :cond_1
    nop

    .line 90
    :goto_1
    const/4 v1, 0x0

    .line 91
    .local v1, "needSeparator":Z
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 92
    .local v3, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->isIdColumn()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 93
    goto :goto_2

    .line 95
    :cond_2
    if-eqz v1, :cond_3

    .line 96
    const-string v4, ", "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 95
    :cond_3
    nop

    .line 98
    :goto_3
    const/4 v1, 0x1

    .line 99
    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v4

    if-nez v4, :cond_4

    .line 101
    const-string v4, " not null"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 100
    :cond_4
    nop

    .line 103
    :goto_4
    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 104
    const-string v4, " unique"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_5

    .line 103
    :cond_5
    nop

    .line 106
    :goto_5
    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v4

    .line 107
    .local v4, "defaultValue":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 108
    const-string v5, " default "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_6

    .line 107
    :cond_6
    nop

    .line 110
    .end local v3    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v4    # "defaultValue":Ljava/lang/String;
    :goto_6
    goto :goto_2

    .line 91
    :cond_7
    nop

    .line 111
    .end local v2    # "i$":Ljava/util/Iterator;
    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    const-string v2, "Generator"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "create table sql is >> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method protected generateDropTableSQL(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "tableName"    # Ljava/lang/String;

    .line 124
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "drop table if exists "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected giveTableSchemaACopy(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase;)V
    .locals 6
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "tableType"    # I
    .param p3, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 194
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "select * from "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 195
    .local v0, "sql":Ljava/lang/StringBuilder;
    const-string v1, "table_schema"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 196
    const-string v1, "Generator"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "giveTableSchemaACopy SQL is >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const/4 v1, 0x0

    .line 199
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p3, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move-object v1, v2

    .line 200
    invoke-direct {p0, v1, p1}, Lorg/litepal/tablemanager/AssociationCreator;->isNeedtoGiveACopy(Landroid/database/Cursor;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 201
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 202
    .local v2, "values":Landroid/content/ContentValues;
    const-string v4, "name"

    invoke-static {p1}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    const-string v4, "type"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 204
    const-string v4, "table_schema"

    invoke-virtual {p3, v4, v3, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 200
    .end local v2    # "values":Landroid/content/ContentValues;
    :cond_0
    nop

    .line 209
    :goto_0
    if-eqz v1, :cond_1

    .line 210
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 209
    :cond_1
    goto :goto_2

    :catchall_0
    move-exception v2

    goto :goto_3

    .line 206
    :catch_0
    move-exception v2

    .line 207
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 209
    .end local v2    # "e":Ljava/lang/Exception;
    if-eqz v1, :cond_1

    .line 210
    goto :goto_1

    .line 213
    :goto_2
    return-void

    .line 209
    :goto_3
    if-eqz v1, :cond_2

    .line 210
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_4

    .line 209
    :cond_2
    nop

    .line 210
    :goto_4
    throw v2

    return-void
.end method

.method protected isForeignKeyColumnFormat(Ljava/lang/String;)Z
    .locals 3
    .param p1, "columnName"    # Ljava/lang/String;

    .line 176
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_1

    .line 177
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v2, "_id"

    invoke-virtual {v0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "_id"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v1, 0x1

    nop

    :cond_0
    return v1

    .line 179
    :cond_1
    return v1
.end method
