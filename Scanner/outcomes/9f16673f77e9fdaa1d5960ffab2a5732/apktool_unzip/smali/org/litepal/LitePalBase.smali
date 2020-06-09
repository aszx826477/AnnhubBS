.class public abstract Lorg/litepal/LitePalBase;
.super Ljava/lang/Object;
.source "LitePalBase.java"


# static fields
.field private static final GET_ASSOCIATIONS_ACTION:I = 0x1

.field private static final GET_ASSOCIATION_INFO_ACTION:I = 0x2

.field public static final TAG:Ljava/lang/String; = "LitePalBase"


# instance fields
.field private classFieldsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;>;"
        }
    .end annotation
.end field

.field private mAssociationInfos:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mAssociationModels:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/AssociationsModel;",
            ">;"
        }
    .end annotation
.end field

.field private typeChangeRules:[Lorg/litepal/tablemanager/typechange/OrmChange;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    const/4 v0, 0x6

    new-array v0, v0, [Lorg/litepal/tablemanager/typechange/OrmChange;

    new-instance v1, Lorg/litepal/tablemanager/typechange/NumericOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/NumericOrm;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    new-instance v1, Lorg/litepal/tablemanager/typechange/TextOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/TextOrm;-><init>()V

    const/4 v2, 0x1

    aput-object v1, v0, v2

    new-instance v1, Lorg/litepal/tablemanager/typechange/BooleanOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/BooleanOrm;-><init>()V

    const/4 v2, 0x2

    aput-object v1, v0, v2

    new-instance v1, Lorg/litepal/tablemanager/typechange/DecimalOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/DecimalOrm;-><init>()V

    const/4 v2, 0x3

    aput-object v1, v0, v2

    new-instance v1, Lorg/litepal/tablemanager/typechange/DateOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/DateOrm;-><init>()V

    const/4 v2, 0x4

    aput-object v1, v0, v2

    new-instance v1, Lorg/litepal/tablemanager/typechange/BlobOrm;

    invoke-direct {v1}, Lorg/litepal/tablemanager/typechange/BlobOrm;-><init>()V

    const/4 v2, 0x5

    aput-object v1, v0, v2

    iput-object v0, p0, Lorg/litepal/LitePalBase;->typeChangeRules:[Lorg/litepal/tablemanager/typechange/OrmChange;

    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/litepal/LitePalBase;->classFieldsMap:Ljava/util/Map;

    return-void
.end method

.method private addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V
    .locals 2
    .param p1, "selfClassName"    # Ljava/lang/String;
    .param p2, "associatedClassName"    # Ljava/lang/String;
    .param p3, "classHoldsForeignKey"    # Ljava/lang/String;
    .param p4, "associateOtherModelFromSelf"    # Ljava/lang/reflect/Field;
    .param p5, "associateSelfFromOtherModel"    # Ljava/lang/reflect/Field;
    .param p6, "associationType"    # I

    .line 523
    new-instance v0, Lorg/litepal/crud/model/AssociationsInfo;

    invoke-direct {v0}, Lorg/litepal/crud/model/AssociationsInfo;-><init>()V

    .line 524
    .local v0, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v0, p1}, Lorg/litepal/crud/model/AssociationsInfo;->setSelfClassName(Ljava/lang/String;)V

    .line 525
    invoke-virtual {v0, p2}, Lorg/litepal/crud/model/AssociationsInfo;->setAssociatedClassName(Ljava/lang/String;)V

    .line 526
    invoke-virtual {v0, p3}, Lorg/litepal/crud/model/AssociationsInfo;->setClassHoldsForeignKey(Ljava/lang/String;)V

    .line 527
    invoke-virtual {v0, p4}, Lorg/litepal/crud/model/AssociationsInfo;->setAssociateOtherModelFromSelf(Ljava/lang/reflect/Field;)V

    .line 528
    invoke-virtual {v0, p5}, Lorg/litepal/crud/model/AssociationsInfo;->setAssociateSelfFromOtherModel(Ljava/lang/reflect/Field;)V

    .line 529
    invoke-virtual {v0, p6}, Lorg/litepal/crud/model/AssociationsInfo;->setAssociationType(I)V

    .line 530
    iget-object v1, p0, Lorg/litepal/LitePalBase;->mAssociationInfos:Ljava/util/Collection;

    invoke-interface {v1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 531
    return-void
.end method

.method private addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 2
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "associatedClassName"    # Ljava/lang/String;
    .param p3, "classHoldsForeignKey"    # Ljava/lang/String;
    .param p4, "associationType"    # I

    .line 493
    new-instance v0, Lorg/litepal/tablemanager/model/AssociationsModel;

    invoke-direct {v0}, Lorg/litepal/tablemanager/model/AssociationsModel;-><init>()V

    .line 494
    .local v0, "associationModel":Lorg/litepal/tablemanager/model/AssociationsModel;
    invoke-static {p1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->setTableName(Ljava/lang/String;)V

    .line 495
    invoke-static {p2}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->setAssociatedTableName(Ljava/lang/String;)V

    .line 496
    invoke-static {p3}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/litepal/tablemanager/model/AssociationsModel;->setTableHoldsForeignKey(Ljava/lang/String;)V

    .line 497
    invoke-virtual {v0, p4}, Lorg/litepal/tablemanager/model/AssociationsModel;->setAssociationType(I)V

    .line 498
    iget-object v1, p0, Lorg/litepal/LitePalBase;->mAssociationModels:Ljava/util/Collection;

    invoke-interface {v1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 499
    return-void
.end method

.method private analyzeClassFields(Ljava/lang/String;I)V
    .locals 7
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "action"    # I

    .line 276
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 277
    .local v0, "dynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    .line 278
    .local v1, "fields":[Ljava/lang/reflect/Field;
    move-object v2, v1

    .local v2, "arr$":[Ljava/lang/reflect/Field;
    array-length v3, v2

    .local v3, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v3, :cond_1

    aget-object v5, v2, v4

    .line 279
    .local v5, "field":Ljava/lang/reflect/Field;
    invoke-direct {p0, v5}, Lorg/litepal/LitePalBase;->isPrivateAndNonPrimitive(Ljava/lang/reflect/Field;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 280
    invoke-direct {p0, p1, v5, p2}, Lorg/litepal/LitePalBase;->oneToAnyConditions(Ljava/lang/String;Ljava/lang/reflect/Field;I)V

    .line 281
    invoke-direct {p0, p1, v5, p2}, Lorg/litepal/LitePalBase;->manyToAnyConditions(Ljava/lang/String;Ljava/lang/reflect/Field;I)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 279
    :cond_0
    nop

    .line 278
    .end local v5    # "field":Ljava/lang/reflect/Field;
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 287
    .end local v0    # "dynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "fields":[Ljava/lang/reflect/Field;
    .end local v2    # "arr$":[Ljava/lang/reflect/Field;
    .end local v3    # "len$":I
    .end local v4    # "i$":I
    :cond_1
    nop

    .line 288
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "ex":Ljava/lang/ClassNotFoundException;
    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->printStackTrace()V

    .line 286
    new-instance v1, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "can not find a class named "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v1

    return-void
.end method

.method private convertFieldToColumnModel(Ljava/lang/reflect/Field;)Lorg/litepal/tablemanager/model/ColumnModel;
    .locals 8
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 561
    const/4 v0, 0x0

    .line 562
    .local v0, "columnType":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    .line 563
    .local v1, "fieldType":Ljava/lang/String;
    iget-object v2, p0, Lorg/litepal/LitePalBase;->typeChangeRules:[Lorg/litepal/tablemanager/typechange/OrmChange;

    .local v2, "arr$":[Lorg/litepal/tablemanager/typechange/OrmChange;
    array-length v3, v2

    .local v3, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v3, :cond_1

    aget-object v5, v2, v4

    .line 564
    .local v5, "ormChange":Lorg/litepal/tablemanager/typechange/OrmChange;
    invoke-virtual {v5, v1}, Lorg/litepal/tablemanager/typechange/OrmChange;->object2Relation(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 565
    if-eqz v0, :cond_0

    .line 566
    goto :goto_1

    .line 565
    :cond_0
    nop

    .line 563
    .end local v5    # "ormChange":Lorg/litepal/tablemanager/typechange/OrmChange;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 569
    .end local v2    # "arr$":[Lorg/litepal/tablemanager/typechange/OrmChange;
    .end local v3    # "len$":I
    .end local v4    # "i$":I
    :cond_1
    :goto_1
    const/4 v2, 0x1

    .line 570
    .local v2, "nullable":Z
    const/4 v3, 0x0

    .line 571
    .local v3, "unique":Z
    const-string v4, ""

    .line 572
    .local v4, "defaultValue":Ljava/lang/String;
    const-class v5, Lorg/litepal/annotation/Column;

    invoke-virtual {p1, v5}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v5

    check-cast v5, Lorg/litepal/annotation/Column;

    .line 573
    .local v5, "annotation":Lorg/litepal/annotation/Column;
    if-eqz v5, :cond_2

    .line 574
    invoke-interface {v5}, Lorg/litepal/annotation/Column;->nullable()Z

    move-result v2

    .line 575
    invoke-interface {v5}, Lorg/litepal/annotation/Column;->unique()Z

    move-result v3

    .line 576
    invoke-interface {v5}, Lorg/litepal/annotation/Column;->defaultValue()Ljava/lang/String;

    move-result-object v4

    goto :goto_2

    .line 573
    :cond_2
    nop

    .line 578
    :goto_2
    new-instance v6, Lorg/litepal/tablemanager/model/ColumnModel;

    invoke-direct {v6}, Lorg/litepal/tablemanager/model/ColumnModel;-><init>()V

    .line 579
    .local v6, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnName(Ljava/lang/String;)V

    .line 580
    invoke-virtual {v6, v0}, Lorg/litepal/tablemanager/model/ColumnModel;->setColumnType(Ljava/lang/String;)V

    .line 581
    invoke-virtual {v6, v2}, Lorg/litepal/tablemanager/model/ColumnModel;->setIsNullable(Z)V

    .line 582
    invoke-virtual {v6, v3}, Lorg/litepal/tablemanager/model/ColumnModel;->setIsUnique(Z)V

    .line 583
    invoke-virtual {v6, v4}, Lorg/litepal/tablemanager/model/ColumnModel;->setDefaultValue(Ljava/lang/String;)V

    .line 584
    return-object v6
.end method

.method private getGenericTypeName(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 4
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 542
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getGenericType()Ljava/lang/reflect/Type;

    move-result-object v0

    .line 543
    .local v0, "genericType":Ljava/lang/reflect/Type;
    if-eqz v0, :cond_1

    .line 544
    instance-of v1, v0, Ljava/lang/reflect/ParameterizedType;

    if-eqz v1, :cond_0

    .line 545
    move-object v1, v0

    check-cast v1, Ljava/lang/reflect/ParameterizedType;

    .line 546
    .local v1, "parameterizedType":Ljava/lang/reflect/ParameterizedType;
    invoke-interface {v1}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v2

    const/4 v3, 0x0

    aget-object v2, v2, v3

    check-cast v2, Ljava/lang/Class;

    .line 547
    .local v2, "genericArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 544
    .end local v1    # "parameterizedType":Ljava/lang/reflect/ParameterizedType;
    .end local v2    # "genericArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    goto :goto_0

    .line 543
    :cond_1
    nop

    .line 550
    :goto_0
    const/4 v1, 0x0

    return-object v1
.end method

.method private isPrivateAndNonPrimitive(Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 299
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v0

    invoke-static {v0}, Ljava/lang/reflect/Modifier;->isPrivate(I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private manyToAnyConditions(Ljava/lang/String;Ljava/lang/reflect/Field;I)V
    .locals 19
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "action"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .line 416
    move-object/from16 v7, p0

    move-object/from16 v8, p1

    move/from16 v9, p3

    invoke-virtual/range {p2 .. p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v7, v0}, Lorg/litepal/LitePalBase;->isCollection(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 417
    move-object/from16 v10, p2

    invoke-direct {v7, v10}, Lorg/litepal/LitePalBase;->getGenericTypeName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v11

    .line 420
    .local v11, "genericTypeName":Ljava/lang/String;
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v11}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 421
    invoke-static {v11}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v12

    .line 422
    .local v12, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v12}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v13

    .line 425
    .local v13, "reverseFields":[Ljava/lang/reflect/Field;
    const/4 v0, 0x0

    .line 426
    .local v0, "reverseAssociations":Z
    const/4 v1, 0x0

    move v15, v0

    move v14, v1

    .end local v0    # "reverseAssociations":Z
    .local v14, "i":I
    .local v15, "reverseAssociations":Z
    :goto_0
    array-length v0, v13

    const/4 v1, 0x1

    const/4 v2, 0x2

    if-ge v14, v0, :cond_8

    .line 427
    aget-object v6, v13, v14

    .line 429
    .local v6, "reverseField":Ljava/lang/reflect/Field;
    invoke-virtual {v6}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v0

    invoke-static {v0}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v0

    if-nez v0, :cond_7

    .line 430
    invoke-virtual {v6}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    .line 434
    .local v5, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 435
    if-ne v9, v1, :cond_0

    .line 436
    invoke-direct {v7, v8, v11, v11, v2}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    move-object v10, v5

    move-object/from16 v17, v12

    move-object v12, v6

    goto :goto_1

    .line 438
    :cond_0
    if-ne v9, v2, :cond_1

    .line 439
    const/16 v16, 0x2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object v2, v11

    move-object v3, v11

    move-object/from16 v4, p2

    move-object v10, v5

    .end local v5    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v10, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object v5, v6

    move-object/from16 v17, v12

    move-object v12, v6

    .end local v6    # "reverseField":Ljava/lang/reflect/Field;
    .local v12, "reverseField":Ljava/lang/reflect/Field;
    .local v17, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move/from16 v6, v16

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_1

    .line 438
    .end local v10    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v5    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v6    # "reverseField":Ljava/lang/reflect/Field;
    .local v12, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    move-object v10, v5

    move-object/from16 v17, v12

    move-object v12, v6

    .line 442
    .end local v5    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v6    # "reverseField":Ljava/lang/reflect/Field;
    .restart local v10    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v12, "reverseField":Ljava/lang/reflect/Field;
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_1
    const/4 v0, 0x1

    move v15, v0

    goto :goto_3

    .line 447
    .end local v10    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v5    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v6    # "reverseField":Ljava/lang/reflect/Field;
    .local v12, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_2
    move-object v10, v5

    move-object/from16 v17, v12

    move-object v12, v6

    .end local v5    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v6    # "reverseField":Ljava/lang/reflect/Field;
    .restart local v10    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v12, "reverseField":Ljava/lang/reflect/Field;
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7, v10}, Lorg/litepal/LitePalBase;->isCollection(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 448
    invoke-direct {v7, v12}, Lorg/litepal/LitePalBase;->getGenericTypeName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v6

    .line 449
    .local v6, "reverseGenericTypeName":Ljava/lang/String;
    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 450
    if-ne v9, v1, :cond_3

    .line 451
    const/4 v0, 0x0

    const/4 v1, 0x3

    invoke-direct {v7, v8, v11, v0, v1}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    move-object/from16 v18, v6

    goto :goto_2

    .line 453
    :cond_3
    if-ne v9, v2, :cond_4

    .line 454
    const/4 v3, 0x0

    const/16 v16, 0x3

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object v2, v11

    move-object/from16 v4, p2

    move-object v5, v12

    move-object/from16 v18, v6

    .end local v6    # "reverseGenericTypeName":Ljava/lang/String;
    .local v18, "reverseGenericTypeName":Ljava/lang/String;
    move/from16 v6, v16

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_2

    .line 453
    .end local v18    # "reverseGenericTypeName":Ljava/lang/String;
    .restart local v6    # "reverseGenericTypeName":Ljava/lang/String;
    :cond_4
    move-object/from16 v18, v6

    .line 457
    .end local v6    # "reverseGenericTypeName":Ljava/lang/String;
    .restart local v18    # "reverseGenericTypeName":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x1

    move v15, v0

    goto :goto_3

    .line 449
    .end local v18    # "reverseGenericTypeName":Ljava/lang/String;
    .restart local v6    # "reverseGenericTypeName":Ljava/lang/String;
    :cond_5
    move-object/from16 v18, v6

    .end local v6    # "reverseGenericTypeName":Ljava/lang/String;
    .restart local v18    # "reverseGenericTypeName":Ljava/lang/String;
    goto :goto_3

    .line 447
    .end local v18    # "reverseGenericTypeName":Ljava/lang/String;
    :cond_6
    goto :goto_3

    .line 429
    .end local v10    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v6, "reverseField":Ljava/lang/reflect/Field;
    .local v12, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_7
    move-object/from16 v17, v12

    move-object v12, v6

    .line 426
    .end local v6    # "reverseField":Ljava/lang/reflect/Field;
    .end local v12    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_3
    add-int/lit8 v14, v14, 0x1

    move-object/from16 v12, v17

    move-object/from16 v10, p2

    goto/16 :goto_0

    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v12    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_8
    move-object/from16 v17, v12

    .line 465
    .end local v12    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v14    # "i":I
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v15, :cond_b

    .line 466
    if-ne v9, v1, :cond_9

    .line 467
    invoke-direct {v7, v8, v11, v11, v2}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_4

    .line 469
    :cond_9
    if-ne v9, v2, :cond_a

    .line 470
    const/4 v5, 0x0

    const/4 v6, 0x2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object v2, v11

    move-object v3, v11

    move-object/from16 v4, p2

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_4

    .line 469
    :cond_a
    goto :goto_4

    .line 465
    :cond_b
    goto :goto_4

    .line 420
    .end local v13    # "reverseFields":[Ljava/lang/reflect/Field;
    .end local v15    # "reverseAssociations":Z
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_c
    goto :goto_4

    .line 416
    .end local v11    # "genericTypeName":Ljava/lang/String;
    :cond_d
    nop

    .line 476
    :goto_4
    return-void
.end method

.method private oneToAnyConditions(Ljava/lang/String;Ljava/lang/reflect/Field;I)V
    .locals 19
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "action"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .line 329
    move-object/from16 v7, p0

    move-object/from16 v8, p1

    move/from16 v9, p3

    invoke-virtual/range {p2 .. p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v10

    .line 332
    .local v10, "fieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 333
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v11

    .line 334
    .local v11, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v11}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v12

    .line 337
    .local v12, "reverseFields":[Ljava/lang/reflect/Field;
    const/4 v0, 0x0

    .line 340
    .local v0, "reverseAssociations":Z
    const/4 v1, 0x0

    move v14, v0

    move v13, v1

    .end local v0    # "reverseAssociations":Z
    .local v13, "i":I
    .local v14, "reverseAssociations":Z
    :goto_0
    array-length v0, v12

    const/4 v1, 0x2

    const/4 v2, 0x1

    if-ge v13, v0, :cond_8

    .line 341
    aget-object v15, v12, v13

    .line 342
    .local v15, "reverseField":Ljava/lang/reflect/Field;
    invoke-virtual {v15}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v0

    invoke-static {v0}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v0

    if-nez v0, :cond_7

    .line 343
    invoke-virtual {v15}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v6

    .line 347
    .local v6, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 348
    if-ne v9, v2, :cond_0

    .line 349
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v7, v8, v0, v1, v2}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    move-object/from16 v17, v11

    move-object v11, v6

    goto :goto_1

    .line 351
    :cond_0
    if-ne v9, v1, :cond_1

    .line 352
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    const/16 v16, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v4, p2

    move-object v5, v15

    move-object/from16 v17, v11

    move-object v11, v6

    .end local v6    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v17, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move/from16 v6, v16

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_1

    .line 351
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v6    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    move-object/from16 v17, v11

    move-object v11, v6

    .line 355
    .end local v6    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_1
    const/4 v0, 0x1

    move v14, v0

    goto :goto_3

    .line 360
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v6    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_2
    move-object/from16 v17, v11

    move-object v11, v6

    .end local v6    # "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseFieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7, v11}, Lorg/litepal/LitePalBase;->isCollection(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 361
    invoke-direct {v7, v15}, Lorg/litepal/LitePalBase;->getGenericTypeName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v6

    .line 362
    .local v6, "genericTypeName":Ljava/lang/String;
    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 363
    if-ne v9, v2, :cond_3

    .line 364
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v7, v8, v0, v8, v1}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    move-object/from16 v18, v6

    goto :goto_2

    .line 366
    :cond_3
    if-ne v9, v1, :cond_4

    .line 367
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    const/16 v16, 0x2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object v5, v15

    move-object/from16 v18, v6

    .end local v6    # "genericTypeName":Ljava/lang/String;
    .local v18, "genericTypeName":Ljava/lang/String;
    move/from16 v6, v16

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_2

    .line 366
    .end local v18    # "genericTypeName":Ljava/lang/String;
    .restart local v6    # "genericTypeName":Ljava/lang/String;
    :cond_4
    move-object/from16 v18, v6

    .line 370
    .end local v6    # "genericTypeName":Ljava/lang/String;
    .restart local v18    # "genericTypeName":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x1

    move v14, v0

    goto :goto_3

    .line 362
    .end local v18    # "genericTypeName":Ljava/lang/String;
    .restart local v6    # "genericTypeName":Ljava/lang/String;
    :cond_5
    move-object/from16 v18, v6

    .end local v6    # "genericTypeName":Ljava/lang/String;
    .restart local v18    # "genericTypeName":Ljava/lang/String;
    goto :goto_3

    .line 360
    .end local v18    # "genericTypeName":Ljava/lang/String;
    :cond_6
    goto :goto_3

    .line 342
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v11, "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_7
    move-object/from16 v17, v11

    .line 340
    .end local v11    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v15    # "reverseField":Ljava/lang/reflect/Field;
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_3
    add-int/lit8 v13, v13, 0x1

    move-object/from16 v11, v17

    goto/16 :goto_0

    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v11    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_8
    move-object/from16 v17, v11

    .line 377
    .end local v11    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v13    # "i":I
    .restart local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v14, :cond_b

    .line 378
    if-ne v9, v2, :cond_9

    .line 379
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v7, v8, v0, v1, v2}, Lorg/litepal/LitePalBase;->addIntoAssociationModelCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_4

    .line 381
    :cond_9
    if-ne v9, v1, :cond_a

    .line 382
    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v4, p2

    invoke-direct/range {v0 .. v6}, Lorg/litepal/LitePalBase;->addIntoAssociationInfoCollection(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;I)V

    goto :goto_4

    .line 381
    :cond_a
    goto :goto_4

    .line 377
    :cond_b
    goto :goto_4

    .line 332
    .end local v12    # "reverseFields":[Ljava/lang/reflect/Field;
    .end local v14    # "reverseAssociations":Z
    .end local v17    # "reverseDynamicClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_c
    nop

    .line 387
    :goto_4
    return-void
.end method

.method private recursiveSupportedFields(Ljava/lang/Class;Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;)V"
        }
    .end annotation

    .line 241
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    const-class v0, Lorg/litepal/crud/DataSupport;

    if-eq p1, v0, :cond_6

    const-class v0, Ljava/lang/Object;

    if-ne p1, v0, :cond_0

    goto :goto_3

    .line 244
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v0

    .line 245
    .local v0, "fields":[Ljava/lang/reflect/Field;
    if-eqz v0, :cond_5

    array-length v1, v0

    if-lez v1, :cond_5

    .line 246
    move-object v1, v0

    .local v1, "arr$":[Ljava/lang/reflect/Field;
    array-length v2, v1

    .local v2, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v2, :cond_4

    aget-object v4, v1, v3

    .line 247
    .local v4, "field":Ljava/lang/reflect/Field;
    const-class v5, Lorg/litepal/annotation/Column;

    invoke-virtual {v4, v5}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v5

    check-cast v5, Lorg/litepal/annotation/Column;

    .line 248
    .local v5, "annotation":Lorg/litepal/annotation/Column;
    if-eqz v5, :cond_1

    invoke-interface {v5}, Lorg/litepal/annotation/Column;->ignore()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 249
    goto :goto_1

    .line 248
    :cond_1
    nop

    .line 251
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v6

    .line 252
    .local v6, "modifiers":I
    invoke-static {v6}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v7

    if-nez v7, :cond_3

    .line 253
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v7

    .line 254
    .local v7, "fieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    .line 255
    .local v8, "fieldType":Ljava/lang/String;
    invoke-static {v8}, Lorg/litepal/util/BaseUtility;->isFieldTypeSupported(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 256
    invoke-interface {p2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 255
    :cond_2
    goto :goto_1

    .line 252
    .end local v7    # "fieldTypeClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v8    # "fieldType":Ljava/lang/String;
    :cond_3
    nop

    .line 246
    .end local v4    # "field":Ljava/lang/reflect/Field;
    .end local v5    # "annotation":Lorg/litepal/annotation/Column;
    .end local v6    # "modifiers":I
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_4
    goto :goto_2

    .line 245
    .end local v1    # "arr$":[Ljava/lang/reflect/Field;
    .end local v2    # "len$":I
    .end local v3    # "i$":I
    :cond_5
    nop

    .line 261
    :goto_2
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Lorg/litepal/LitePalBase;->recursiveSupportedFields(Ljava/lang/Class;Ljava/util/List;)V

    .line 262
    return-void

    .line 241
    .end local v0    # "fields":[Ljava/lang/reflect/Field;
    :cond_6
    :goto_3
    nop

    .line 242
    return-void
.end method


# virtual methods
.method protected getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;
    .locals 1
    .param p1, "className"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation

    .line 147
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationInfos:Ljava/util/Collection;

    if-nez v0, :cond_0

    .line 148
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationInfos:Ljava/util/Collection;

    goto :goto_0

    .line 147
    :cond_0
    nop

    .line 150
    :goto_0
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationInfos:Ljava/util/Collection;

    invoke-interface {v0}, Ljava/util/Collection;->clear()V

    .line 151
    const/4 v0, 0x2

    invoke-direct {p0, p1, v0}, Lorg/litepal/LitePalBase;->analyzeClassFields(Ljava/lang/String;I)V

    .line 152
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationInfos:Ljava/util/Collection;

    return-object v0
.end method

.method protected getAssociations(Ljava/util/List;)Ljava/util/Collection;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Collection<",
            "Lorg/litepal/tablemanager/model/AssociationsModel;",
            ">;"
        }
    .end annotation

    .line 129
    .local p1, "classNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationModels:Ljava/util/Collection;

    if-nez v0, :cond_0

    .line 130
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationModels:Ljava/util/Collection;

    goto :goto_0

    .line 129
    :cond_0
    nop

    .line 132
    :goto_0
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationModels:Ljava/util/Collection;

    invoke-interface {v0}, Ljava/util/Collection;->clear()V

    .line 133
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 134
    .local v1, "className":Ljava/lang/String;
    const/4 v2, 0x1

    invoke-direct {p0, v1, v2}, Lorg/litepal/LitePalBase;->analyzeClassFields(Ljava/lang/String;I)V

    .line 135
    .end local v1    # "className":Ljava/lang/String;
    goto :goto_1

    .line 133
    :cond_1
    nop

    .line 136
    .end local v0    # "i$":Ljava/util/Iterator;
    iget-object v0, p0, Lorg/litepal/LitePalBase;->mAssociationModels:Ljava/util/Collection;

    return-object v0
.end method

.method protected getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "associatedTableName"    # Ljava/lang/String;

    .line 237
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "_id"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getSupportedFields(Ljava/lang/String;)Ljava/util/List;
    .locals 7
    .param p1, "className"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;"
        }
    .end annotation

    .line 166
    iget-object v0, p0, Lorg/litepal/LitePalBase;->classFieldsMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 167
    .local v0, "fieldList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    if-nez v0, :cond_0

    .line 168
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 171
    .local v1, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 174
    .local v2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    nop

    .line 175
    invoke-direct {p0, v2, v1}, Lorg/litepal/LitePalBase;->recursiveSupportedFields(Ljava/lang/Class;Ljava/util/List;)V

    .line 176
    iget-object v3, p0, Lorg/litepal/LitePalBase;->classFieldsMap:Ljava/util/Map;

    invoke-interface {v3, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    return-object v1

    .line 172
    .end local v2    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v2

    const/4 v3, 0x0

    .line 173
    .local v2, "e":Ljava/lang/ClassNotFoundException;
    .local v3, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "can not find a class named "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 179
    .end local v1    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    .end local v2    # "e":Ljava/lang/ClassNotFoundException;
    .end local v3    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    return-object v0
.end method

.method protected getTableModel(Ljava/lang/String;)Lorg/litepal/tablemanager/model/TableModel;
    .locals 6
    .param p1, "className"    # Ljava/lang/String;

    .line 108
    invoke-static {p1}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 109
    .local v0, "tableName":Ljava/lang/String;
    new-instance v1, Lorg/litepal/tablemanager/model/TableModel;

    invoke-direct {v1}, Lorg/litepal/tablemanager/model/TableModel;-><init>()V

    .line 110
    .local v1, "tableModel":Lorg/litepal/tablemanager/model/TableModel;
    invoke-virtual {v1, v0}, Lorg/litepal/tablemanager/model/TableModel;->setTableName(Ljava/lang/String;)V

    .line 111
    invoke-virtual {v1, p1}, Lorg/litepal/tablemanager/model/TableModel;->setClassName(Ljava/lang/String;)V

    .line 112
    invoke-virtual {p0, p1}, Lorg/litepal/LitePalBase;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 113
    .local v2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/reflect/Field;

    .line 114
    .local v4, "field":Ljava/lang/reflect/Field;
    invoke-direct {p0, v4}, Lorg/litepal/LitePalBase;->convertFieldToColumnModel(Ljava/lang/reflect/Field;)Lorg/litepal/tablemanager/model/ColumnModel;

    move-result-object v5

    .line 115
    .local v5, "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    invoke-virtual {v1, v5}, Lorg/litepal/tablemanager/model/TableModel;->addColumnModel(Lorg/litepal/tablemanager/model/ColumnModel;)V

    .line 116
    .end local v4    # "field":Ljava/lang/reflect/Field;
    .end local v5    # "columnModel":Lorg/litepal/tablemanager/model/ColumnModel;
    goto :goto_0

    .line 113
    :cond_0
    nop

    .line 117
    .end local v3    # "i$":Ljava/util/Iterator;
    return-object v1
.end method

.method protected isCollection(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)Z"
        }
    .end annotation

    .line 190
    .local p1, "fieldType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0, p1}, Lorg/litepal/LitePalBase;->isList(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0, p1}, Lorg/litepal/LitePalBase;->isSet(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method protected isIdColumn(Ljava/lang/String;)Z
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;

    .line 224
    const-string v0, "_id"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "id"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method protected isList(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)Z"
        }
    .end annotation

    .line 201
    .local p1, "fieldType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Ljava/util/List;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    return v0
.end method

.method protected isSet(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)Z"
        }
    .end annotation

    .line 212
    .local p1, "fieldType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Ljava/util/Set;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    return v0
.end method
