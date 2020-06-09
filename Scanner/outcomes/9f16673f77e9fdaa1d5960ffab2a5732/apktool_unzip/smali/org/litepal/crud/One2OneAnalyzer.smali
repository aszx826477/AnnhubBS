.class public Lorg/litepal/crud/One2OneAnalyzer;
.super Lorg/litepal/crud/AssociationsAnalyzer;
.source "One2OneAnalyzer.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32
    invoke-direct {p0}, Lorg/litepal/crud/AssociationsAnalyzer;-><init>()V

    return-void
.end method

.method private bidirectionalCondition(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 105
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->isSaved()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 107
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v1

    invoke-virtual {p1, v0, v1, v2}, Lorg/litepal/crud/DataSupport;->addAssociatedModelWithFK(Ljava/lang/String;J)V

    .line 110
    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v1

    invoke-virtual {p1, v0, v1, v2}, Lorg/litepal/crud/DataSupport;->addAssociatedModelWithoutFK(Ljava/lang/String;J)V

    goto :goto_0

    .line 105
    :cond_0
    nop

    .line 113
    :goto_0
    return-void
.end method

.method private dealAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;
    .param p3, "associationInfo"    # Lorg/litepal/crud/model/AssociationsInfo;

    .line 85
    invoke-virtual {p3}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateSelfFromOtherModel()Ljava/lang/reflect/Field;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 86
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/One2OneAnalyzer;->bidirectionalCondition(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V

    goto :goto_0

    .line 88
    :cond_0
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/One2OneAnalyzer;->unidirectionalCondition(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V

    .line 90
    :goto_0
    return-void
.end method

.method private unidirectionalCondition(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V
    .locals 0
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedModel"    # Lorg/litepal/crud/DataSupport;

    .line 124
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/One2OneAnalyzer;->dealsAssociationsOnTheSideWithoutFK(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;)V

    .line 125
    return-void
.end method


# virtual methods
.method analyze(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V
    .locals 2
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

    .line 58
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/One2OneAnalyzer;->getAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Lorg/litepal/crud/DataSupport;

    move-result-object v0

    .line 59
    .local v0, "associatedModel":Lorg/litepal/crud/DataSupport;
    if-eqz v0, :cond_0

    .line 60
    invoke-virtual {p0, p1, v0, p2}, Lorg/litepal/crud/One2OneAnalyzer;->buildBidirectionalAssociations(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V

    .line 61
    invoke-direct {p0, p1, v0, p2}, Lorg/litepal/crud/One2OneAnalyzer;->dealAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V

    goto :goto_0

    .line 63
    :cond_0
    invoke-virtual {p2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    .local v1, "tableName":Ljava/lang/String;
    invoke-virtual {p1, v1}, Lorg/litepal/crud/DataSupport;->addAssociatedTableNameToClearFK(Ljava/lang/String;)V

    .line 67
    .end local v1    # "tableName":Ljava/lang/String;
    :goto_0
    return-void
.end method
