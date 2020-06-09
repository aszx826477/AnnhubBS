.class public abstract Lorg/litepal/tablemanager/Generator;
.super Lorg/litepal/LitePalBase;
.source "Generator.java"


# static fields
.field public static final TAG:Ljava/lang/String; = "Generator"


# instance fields
.field private mAllRelationModels:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/AssociationsModel;",
            ">;"
        }
    .end annotation
.end field

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

    .line 43
    invoke-direct {p0}, Lorg/litepal/LitePalBase;-><init>()V

    return-void
.end method

.method private static addAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 1
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "force"    # Z

    .line 129
    new-instance v0, Lorg/litepal/tablemanager/Creator;

    invoke-direct {v0}, Lorg/litepal/tablemanager/Creator;-><init>()V

    .line 130
    .local v0, "associationsCreator":Lorg/litepal/tablemanager/AssociationCreator;
    invoke-virtual {v0, p0, p1}, Lorg/litepal/tablemanager/AssociationCreator;->addOrUpdateAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 131
    return-void
.end method

.method private canUseCache()Z
    .locals 3

    .line 192
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 193
    return v1

    .line 195
    :cond_0
    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v0

    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v2

    invoke-virtual {v2}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ne v0, v2, :cond_1

    const/4 v1, 0x1

    nop

    :cond_1
    return v1
.end method

.method static create(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 207
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lorg/litepal/tablemanager/Generator;->create(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 208
    invoke-static {p0, v0}, Lorg/litepal/tablemanager/Generator;->addAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 209
    return-void
.end method

.method private static create(Landroid/database/sqlite/SQLiteDatabase;Z)V
    .locals 1
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "force"    # Z

    .line 168
    new-instance v0, Lorg/litepal/tablemanager/Creator;

    invoke-direct {v0}, Lorg/litepal/tablemanager/Creator;-><init>()V

    .line 169
    .local v0, "creator":Lorg/litepal/tablemanager/Creator;
    invoke-virtual {v0, p0, p1}, Lorg/litepal/tablemanager/Creator;->createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 170
    return-void
.end method

.method private static drop(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 180
    new-instance v0, Lorg/litepal/tablemanager/Dropper;

    invoke-direct {v0}, Lorg/litepal/tablemanager/Dropper;-><init>()V

    .line 181
    .local v0, "dropper":Lorg/litepal/tablemanager/Dropper;
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lorg/litepal/tablemanager/Dropper;->createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 182
    return-void
.end method

.method private static updateAssociations(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 141
    new-instance v0, Lorg/litepal/tablemanager/Upgrader;

    invoke-direct {v0}, Lorg/litepal/tablemanager/Upgrader;-><init>()V

    .line 142
    .local v0, "associationUpgrader":Lorg/litepal/tablemanager/AssociationUpdater;
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lorg/litepal/tablemanager/AssociationUpdater;->addOrUpdateAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 143
    return-void
.end method

.method static upgrade(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 220
    invoke-static {p0}, Lorg/litepal/tablemanager/Generator;->drop(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 221
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lorg/litepal/tablemanager/Generator;->create(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 222
    invoke-static {p0}, Lorg/litepal/tablemanager/Generator;->updateAssociations(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 223
    invoke-static {p0}, Lorg/litepal/tablemanager/Generator;->upgradeTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 224
    invoke-static {p0, v0}, Lorg/litepal/tablemanager/Generator;->addAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 225
    return-void
.end method

.method private static upgradeTables(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 153
    new-instance v0, Lorg/litepal/tablemanager/Upgrader;

    invoke-direct {v0}, Lorg/litepal/tablemanager/Upgrader;-><init>()V

    .line 154
    .local v0, "upgrader":Lorg/litepal/tablemanager/Upgrader;
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lorg/litepal/tablemanager/Upgrader;->createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V

    .line 155
    return-void
.end method


# virtual methods
.method protected abstract addOrUpdateAssociation(Landroid/database/sqlite/SQLiteDatabase;Z)V
.end method

.method protected abstract createOrUpgradeTable(Landroid/database/sqlite/SQLiteDatabase;Z)V
.end method

.method protected execute([Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 6
    .param p1, "sqls"    # [Ljava/lang/String;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .line 106
    const-string v0, ""

    .line 108
    .local v0, "throwSQL":Ljava/lang/String;
    if-eqz p1, :cond_1

    .line 109
    move-object v1, p1

    .local v1, "arr$":[Ljava/lang/String;
    :try_start_0
    array-length v2, v1

    .local v2, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v2, :cond_0

    aget-object v4, v1, v3

    .line 110
    .local v4, "sql":Ljava/lang/String;
    move-object v0, v4

    .line 111
    invoke-static {v4}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 109
    .end local v4    # "sql":Ljava/lang/String;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 114
    .end local v1    # "arr$":[Ljava/lang/String;
    .end local v2    # "len$":I
    .end local v3    # "i$":I
    :catch_0
    move-exception v1

    .line 115
    .local v1, "e":Landroid/database/SQLException;
    new-instance v2, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "An exception that indicates there was an error with SQL parsing or execution. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 108
    .end local v1    # "e":Landroid/database/SQLException;
    :cond_1
    nop

    .line 116
    :goto_1
    nop

    .line 117
    return-void
.end method

.method protected getAllAssociations()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/AssociationsModel;",
            ">;"
        }
    .end annotation

    .line 87
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mAllRelationModels:Ljava/util/Collection;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 88
    :cond_1
    :goto_0
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/litepal/tablemanager/Generator;->getAssociations(Ljava/util/List;)Ljava/util/Collection;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/tablemanager/Generator;->mAllRelationModels:Ljava/util/Collection;

    .line 90
    :goto_1
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mAllRelationModels:Ljava/util/Collection;

    return-object v0
.end method

.method protected getAllTableModels()Ljava/util/Collection;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/TableModel;",
            ">;"
        }
    .end annotation

    .line 66
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    if-nez v0, :cond_0

    .line 67
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    goto :goto_0

    .line 66
    :cond_0
    nop

    .line 69
    :goto_0
    invoke-direct {p0}, Lorg/litepal/tablemanager/Generator;->canUseCache()Z

    move-result v0

    if-nez v0, :cond_2

    .line 70
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    invoke-interface {v0}, Ljava/util/Collection;->clear()V

    .line 71
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 72
    .local v1, "className":Ljava/lang/String;
    iget-object v2, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    invoke-virtual {p0, v1}, Lorg/litepal/tablemanager/Generator;->getTableModel(Ljava/lang/String;)Lorg/litepal/tablemanager/model/TableModel;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 73
    .end local v1    # "className":Ljava/lang/String;
    goto :goto_1

    .line 71
    :cond_1
    goto :goto_2

    .line 69
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    nop

    .line 75
    :goto_2
    iget-object v0, p0, Lorg/litepal/tablemanager/Generator;->mTableModels:Ljava/util/Collection;

    return-object v0
.end method
