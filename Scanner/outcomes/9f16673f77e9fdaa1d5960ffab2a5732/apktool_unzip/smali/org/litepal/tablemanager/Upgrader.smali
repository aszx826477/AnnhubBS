.class public Lorg/litepal/tablemanager/Upgrader;
.super Lorg/litepal/tablemanager/AssociationUpdater;
.source "Upgrader.java"


# instance fields
.field private hasConstraintChanged:Z

.field protected mTableModel:Lorg/litepal/tablemanager/model/TableModel;

.field protected mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42
    invoke-direct {p0}, Lorg/litepal/tablemanager/AssociationUpdater;-><init>()V

    return-void
.end method

.method private addColumns(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;)V"
        }
    .end annotation

    .line 275
    .local p1, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    const-string v0, "AssociationUpdater"

    const-string v1, "do addColumn"

    invoke-static {v0, v1}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 276
    invoke-direct {p0, p1}, Lorg/litepal/tablemanager/Upgrader;->getAddColumnSQLs(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v0, v1}, Lorg/litepal/tablemanager/Upgrader;->execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 277
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 278
    .local v1, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    iget-object v2, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v2, v1}, Lorg/litepal/tablemanager/model/TableModel;->addColumnModel(Lorg/litepal/tablemanager/model/ColumnModel;)V

    .line 279
    .end local v1    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    goto :goto_0

    .line 277
    :cond_0
    nop

    .line 280
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private changeColumnsConstraints()V
    .locals 2

    .line 306
    iget-boolean v0, p0, Lorg/litepal/tablemanager/Upgrader;->hasConstraintChanged:Z

    if-eqz v0, :cond_0

    .line 307
    const-string v0, "AssociationUpdater"

    const-string v1, "do changeColumnsConstraints"

    invoke-static {v0, v1}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->getChangeColumnsConstraintsSQL()[Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v0, v1}, Lorg/litepal/tablemanager/Upgrader;->execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_0

    .line 306
    :cond_0
    nop

    .line 310
    :goto_0
    return-void
.end method

.method private changeColumnsType(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;)V"
        }
    .end annotation

    .line 290
    .local p1, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    const-string v0, "AssociationUpdater"

    const-string v1, "do changeColumnsType"

    invoke-static {v0, v1}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 292
    .local v0, "columnNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 293
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 294
    .local v2, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 295
    .end local v2    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    goto :goto_0

    .line 293
    :cond_0
    goto :goto_1

    .line 292
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    nop

    .line 297
    :goto_1
    invoke-direct {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->removeColumns(Ljava/util/List;)V

    .line 298
    invoke-direct {p0, p1}, Lorg/litepal/tablemanager/Upgrader;->addColumns(Ljava/util/List;)V

    .line 299
    return-void
.end method

.method private findColumnTypesToChange()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;"
        }
    .end annotation

    .line 174
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 175
    .local v0, "columnsToChangeType":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 176
    .local v2, "columnModelDB":Lorg/litepal/tablemanager/model/ColumnModel;
    iget-object v3, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 177
    .local v4, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 178
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 180
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 178
    :cond_0
    nop

    .line 182
    :goto_2
    iget-boolean v5, p0, Lorg/litepal/tablemanager/Upgrader;->hasConstraintChanged:Z

    if-nez v5, :cond_3

    .line 184
    const-string v5, "AssociationUpdater"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "default value db is:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, ", default value is:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v5

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v6

    if-ne v5, v6, :cond_2

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->getDefaultValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v5

    if-nez v5, :cond_1

    goto :goto_3

    :cond_1
    goto :goto_4

    .line 188
    :cond_2
    :goto_3
    const/4 v5, 0x1

    iput-boolean v5, p0, Lorg/litepal/tablemanager/Upgrader;->hasConstraintChanged:Z

    goto :goto_4

    .line 182
    :cond_3
    goto :goto_4

    .line 177
    :cond_4
    nop

    .line 192
    .end local v4    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    :goto_4
    goto/16 :goto_1

    .line 176
    :cond_5
    nop

    .line 193
    .end local v2    # "columnModelDB":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v3    # "i$":Ljava/util/Iterator;
    goto/16 :goto_0

    .line 175
    :cond_6
    nop

    .line 194
    .end local v1    # "i$":Ljava/util/Iterator;
    return-object v0
.end method

.method private findColumnsToAdd()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;"
        }
    .end annotation

    .line 129
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 130
    .local v0, "columnsToAdd":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

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

    check-cast v2, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 131
    .local v2, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v3

    .line 132
    .local v3, "columnName":Ljava/lang/String;
    iget-object v4, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v4, v3}, Lorg/litepal/tablemanager/model/TableModel;->containsColumn(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 134
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 132
    :cond_0
    nop

    .line 136
    .end local v2    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v3    # "columnName":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .line 130
    :cond_1
    nop

    .line 137
    .end local v1    # "i$":Ljava/util/Iterator;
    return-object v0
.end method

.method private findColumnsToRemove()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 152
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    .line 153
    .local v0, "tableName":Ljava/lang/String;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 154
    .local v1, "removeColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

    move-result-object v2

    .line 155
    .local v2, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 156
    .local v4, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v5

    .line 157
    .local v5, "dbColumnName":Ljava/lang/String;
    invoke-direct {p0, v5}, Lorg/litepal/tablemanager/Upgrader;->isNeedToRemove(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 158
    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 157
    :cond_0
    nop

    .line 160
    .end local v4    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v5    # "dbColumnName":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .line 155
    :cond_1
    nop

    .line 161
    .end local v3    # "i$":Ljava/util/Iterator;
    const-string v3, "AssociationUpdater"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "remove columns from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, " >> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    return-object v1
.end method

.method private generateAddColumnSQL(Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;
    .locals 1
    .param p1, "columnModel"    # Lorg/litepal/tablemanager/model/ColumnModel;

    .line 233
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lorg/litepal/tablemanager/Upgrader;->generateAddColumnSQL(Ljava/lang/String;Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private generateAddForeignKeySQL()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 344
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 345
    .local v0, "addForeignKeySQLs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {p0, v1}, Lorg/litepal/tablemanager/Upgrader;->getForeignKeyColumns(Lorg/litepal/tablemanager/model/TableModel;)Ljava/util/List;

    move-result-object v1

    .line 346
    .local v1, "foreignKeyColumns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 347
    .local v3, "foreignKeyColumn":Ljava/lang/String;
    iget-object v4, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v4, v3}, Lorg/litepal/tablemanager/model/TableModel;->containsColumn(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 348
    new-instance v4, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v4}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 349
    .local v4, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v4, v3}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 350
    const-string v5, "integer"

    invoke-virtual {v4, v5}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 351
    iget-object v5, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v5}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5, v4}, Lorg/litepal/tablemanager/Upgrader;->generateAddColumnSQL(Ljava/lang/String;Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 347
    .end local v4    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    :cond_0
    nop

    .line 353
    .end local v3    # "foreignKeyColumn":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .line 346
    :cond_1
    nop

    .line 354
    .end local v2    # "i$":Ljava/util/Iterator;
    return-object v0
.end method

.method private getAddColumnSQLs(Ljava/util/List;)[Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/litepal/tablemanager/model/ColumnModel;",
            ">;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 245
    .local p1, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 246
    .local v0, "sqls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 247
    .local v2, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-direct {p0, v2}, Lorg/litepal/tablemanager/Upgrader;->generateAddColumnSQL(Lorg/litepal/tablemanager/model/ColumnModel;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 248
    .end local v2    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    goto :goto_0

    .line 246
    :cond_0
    nop

    .line 249
    .end local v1    # "i$":Ljava/util/Iterator;
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    return-object v1
.end method

.method private getChangeColumnsConstraintsSQL()[Ljava/lang/String;
    .locals 9

    .line 318
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->generateAlterToTempTableSQL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 319
    .local v0, "alterToTempTableSQL":Ljava/lang/String;
    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {p0, v1}, Lorg/litepal/tablemanager/Upgrader;->generateCreateTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;

    move-result-object v1

    .line 320
    .local v1, "createNewTableSQL":Ljava/lang/String;
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->generateAddForeignKeySQL()Ljava/util/List;

    move-result-object v2

    .line 321
    .local v2, "addForeignKeySQLs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {p0, v3}, Lorg/litepal/tablemanager/Upgrader;->generateDataMigrationSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;

    move-result-object v3

    .line 322
    .local v3, "dataMigrationSQL":Ljava/lang/String;
    iget-object v4, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v4}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lorg/litepal/tablemanager/Upgrader;->generateDropTempTableSQL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 323
    .local v4, "dropTempTableSQL":Ljava/lang/String;
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 324
    .local v5, "sqls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 325
    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 326
    invoke-interface {v5, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 327
    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 328
    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 329
    const-string v6, "AssociationUpdater"

    const-string v7, "generateChangeConstraintSQL >> "

    invoke-static {v6, v7}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 331
    .local v7, "sql":Ljava/lang/String;
    const-string v8, "AssociationUpdater"

    invoke-static {v8, v7}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 332
    .end local v7    # "sql":Ljava/lang/String;
    goto :goto_0

    .line 330
    :cond_0
    nop

    .line 333
    .end local v6    # "i$":Ljava/util/Iterator;
    const-string v6, "AssociationUpdater"

    const-string v7, "<< generateChangeConstraintSQL"

    invoke-static {v6, v7}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/String;

    invoke-interface {v5, v6}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/String;

    return-object v6
.end method

.method private hasNewUniqueOrNotNullColumn()Z
    .locals 6

    .line 106
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

    move-result-object v0

    .line 107
    .local v0, "columnModelList":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/tablemanager/model/ColumnModel;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/tablemanager/model/ColumnModel;

    .line 108
    .local v2, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    iget-object v3, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->getColumnName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModelByName(Ljava/lang/String;)Lorg/litepal/tablemanager/model/ColumnModel;

    move-result-object v3

    .line 109
    .local v3, "columnModelDB":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v4

    const/4 v5, 0x1

    if-eqz v4, :cond_2

    .line 110
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique()Z

    move-result v4

    if-nez v4, :cond_0

    goto :goto_1

    :cond_0
    goto :goto_2

    .line 111
    :cond_1
    :goto_1
    return v5

    .line 109
    :cond_2
    nop

    .line 114
    :goto_2
    if-eqz v3, :cond_3

    invoke-virtual {v2}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v4

    if-nez v4, :cond_3

    invoke-virtual {v3}, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 115
    return v5

    .line 114
    :cond_3
    nop

    .line 117
    .end local v2    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    .end local v3    # "columnModelDB":Lorg/litepal/tablemanager/model/ColumnModel;
    goto :goto_0

    .line 107
    :cond_4
    nop

    .line 118
    .end local v1    # "i$":Ljava/util/Iterator;
    const/4 v1, 0x0

    return v1
.end method

.method private isNeedToRemove(Ljava/lang/String;)Z
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;

    .line 209
    invoke-direct {p0, p1}, Lorg/litepal/tablemanager/Upgrader;->isRemovedFromClass(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lorg/litepal/tablemanager/Upgrader;->isIdColumn(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {p0, v0, p1}, Lorg/litepal/tablemanager/Upgrader;->isForeignKeyColumn(Lorg/litepal/tablemanager/model/TableModel;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private isRemovedFromClass(Ljava/lang/String;)Z
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;

    .line 222
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0, p1}, Lorg/litepal/tablemanager/model/TableModel;->containsColumn(Ljava/lang/String;)Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private removeColumns(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 260
    .local p1, "removeColumnNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v0, "AssociationUpdater"

    const-string v1, "do addColumn"

    invoke-static {v0, v1}, Lorg/litepal/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/tablemanager/Upgrader;->removeColumns(Ljava/util/Collection;Ljava/lang/String;)V

    .line 262
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 263
    .local v1, "columnName":Ljava/lang/String;
    iget-object v2, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v2, v1}, Lorg/litepal/tablemanager/model/TableModel;->removeColumnModelByName(Ljava/lang/String;)V

    .line 264
    .end local v1    # "columnName":Ljava/lang/String;
    goto :goto_0

    .line 262
    :cond_0
    nop

    .line 265
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private upgradeTable()V
    .locals 8

    .line 78
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->hasNewUniqueOrNotNullColumn()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 80
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    iget-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lorg/litepal/tablemanager/Upgrader;->createOrUpgradeTable(Lorg/litepal/tablemanager/model/TableModel;Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 82
    iget-object v0, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v0}, Lorg/litepal/tablemanager/model/TableModel;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    .line 83
    .local v0, "associationsInfo":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/litepal/crud/model/AssociationsInfo;

    .line 84
    .local v3, "info":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v3}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v4

    const/4 v5, 0x2

    if-eq v4, v5, :cond_1

    invoke-virtual {v3}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v4

    if-ne v4, v2, :cond_0

    goto :goto_1

    :cond_0
    goto :goto_2

    .line 86
    :cond_1
    :goto_1
    invoke-virtual {v3}, Lorg/litepal/crud/model/AssociationsInfo;->getClassHoldsForeignKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v5}, Lorg/litepal/tablemanager/model/TableModel;->getClassName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 87
    invoke-virtual {v3}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 88
    .local v4, "associatedTableName":Ljava/lang/String;
    iget-object v5, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v5}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    invoke-virtual {v6}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lorg/litepal/tablemanager/Upgrader;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, v5, v4, v6, v7}, Lorg/litepal/tablemanager/Upgrader;->addForeignKeyColumn(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_2

    .line 86
    .end local v4    # "associatedTableName":Ljava/lang/String;
    :cond_2
    nop

    .line 91
    .end local v3    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    :goto_2
    goto :goto_0

    .line 83
    :cond_3
    nop

    .line 92
    .end local v0    # "associationsInfo":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    goto :goto_3

    .line 93
    :cond_4
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/litepal/tablemanager/Upgrader;->hasConstraintChanged:Z

    .line 94
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->findColumnsToRemove()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->removeColumns(Ljava/util/List;)V

    .line 95
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->findColumnsToAdd()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->addColumns(Ljava/util/List;)V

    .line 96
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->findColumnTypesToChange()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/litepal/tablemanager/Upgrader;->changeColumnsType(Ljava/util/List;)V

    .line 97
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->changeColumnsConstraints()V

    .line 99
    :goto_3
    return-void
.end method


# virtual methods
.method protected createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 3
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "force"    # Z

    .line 64
    iput-object p1, p0, Lorg/litepal/tablemanager/Upgrader;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 65
    invoke-virtual {p0}, Lorg/litepal/tablemanager/Upgrader;->getAllTableModels()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/tablemanager/model/TableModel;

    .line 66
    .local v1, "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    iput-object v1, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModel:Lorg/litepal/tablemanager/model/TableModel;

    .line 67
    invoke-virtual {v1}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/litepal/tablemanager/Upgrader;->getTableModelFromDB(Ljava/lang/String;)Lorg/litepal/tablemanager/model/TableModel;

    move-result-object v2

    iput-object v2, p0, Lorg/litepal/tablemanager/Upgrader;->mTableModelDB:Lorg/litepal/tablemanager/model/TableModel;

    .line 68
    invoke-direct {p0}, Lorg/litepal/tablemanager/Upgrader;->upgradeTable()V

    .line 69
    .end local v1    # "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    goto :goto_0

    .line 65
    :cond_0
    nop

    .line 70
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method
