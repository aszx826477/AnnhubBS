.class Lorg/litepal/tablemanager/Creator;
.super Lorg/litepal/tablemanager/AssociationCreator;
.source "Creator.java"


# static fields
.field public static final TAG:Ljava/lang/String; = "Creator"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 36
    invoke-direct {p0}, Lorg/litepal/tablemanager/AssociationCreator;-><init>()V

    return-void
.end method


# virtual methods
.method protected createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "force"    # Z

    .line 45
    invoke-virtual {p0}, Lorg/litepal/tablemanager/Creator;->getAllTableModels()Ljava/util/Collection;

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

    .line 46
    .local v1, "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    invoke-virtual {p0, v1, p1, p2}, Lorg/litepal/tablemanager/Creator;->createOrUpgradeTable(Lorg/litepal/tablemanager/model/TableModel;Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 47
    .end local v1    # "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    goto :goto_0

    .line 45
    :cond_0
    nop

    .line 48
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method protected createOrUpgradeTable(Lorg/litepal/tablemanager/model/TableModel;Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 2
    .param p1, "tableModel"    # Lorg/litepal/tablemanager/model/TableModel;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "force"    # Z

    .line 51
    invoke-virtual {p0, p1, p2, p3}, Lorg/litepal/tablemanager/Creator;->getCreateTableSQLs(Lorg/litepal/tablemanager/model/TableModel;Landroid/database/sqlite/SQLiteDatabase;Z)[Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lorg/litepal/tablemanager/Creator;->execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 52
    invoke-virtual {p1}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p2}, Lorg/litepal/tablemanager/Creator;->giveTableSchemaACopy(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase;)V

    .line 53
    return-void
.end method

.method protected generateCreateTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;
    .locals 3
    .param p1, "tableModel"    # Lorg/litepal/tablemanager/model/TableModel;

    .line 104
    invoke-virtual {p1}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lorg/litepal/tablemanager/model/TableModel;->getColumnModels()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lorg/litepal/tablemanager/Creator;->generateCreateTableSQL(Ljava/lang/String;Ljava/util/List;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected generateDropTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;
    .locals 1
    .param p1, "tableModel"    # Lorg/litepal/tablemanager/model/TableModel;

    .line 90
    invoke-virtual {p1}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/tablemanager/Creator;->generateDropTableSQL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getCreateTableSQLs(Lorg/litepal/tablemanager/model/TableModel;Landroid/database/sqlite/SQLiteDatabase;Z)[Ljava/lang/String;
    .locals 4
    .param p1, "tableModel"    # Lorg/litepal/tablemanager/model/TableModel;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "force"    # Z

    .line 70
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eqz p3, :cond_0

    .line 71
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lorg/litepal/tablemanager/Creator;->generateDropTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-virtual {p0, p1}, Lorg/litepal/tablemanager/Creator;->generateCreateTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v0

    return-object v2

    .line 74
    :cond_0
    invoke-virtual {p1}, Lorg/litepal/tablemanager/model/TableModel;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p2}, Lorg/litepal/util/DBUtility;->isTableExists(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 75
    const/4 v0, 0x0

    return-object v0

    .line 77
    :cond_1
    new-array v0, v0, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lorg/litepal/tablemanager/Creator;->generateCreateTableSQL(Lorg/litepal/tablemanager/model/TableModel;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    return-object v0
.end method
