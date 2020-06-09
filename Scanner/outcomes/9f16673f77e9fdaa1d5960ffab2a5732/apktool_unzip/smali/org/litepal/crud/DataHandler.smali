.class abstract Lorg/litepal/crud/DataHandler;
.super Lorg/litepal/LitePalBase;
.source "DataHandler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/litepal/crud/DataHandler$QueryInfoCache;
    }
.end annotation


# static fields
.field public static final TAG:Ljava/lang/String; = "DataHandler"


# instance fields
.field private fkInCurrentModel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation
.end field

.field private fkInOtherModel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation
.end field

.field mDatabase:Landroid/database/sqlite/SQLiteDatabase;

.field private tempEmptyModel:Lorg/litepal/crud/DataSupport;


# direct methods
.method constructor <init>()V
    .locals 0

    .line 50
    invoke-direct {p0}, Lorg/litepal/LitePalBase;-><init>()V

    .line 1274
    return-void
.end method

.method private analyzeAssociations(Ljava/lang/String;)V
    .locals 5
    .param p1, "className"    # Ljava/lang/String;

    .line 1151
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DataHandler;->getAssociationInfo(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    .line 1152
    .local v0, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    iget-object v1, p0, Lorg/litepal/crud/DataHandler;->fkInCurrentModel:Ljava/util/List;

    if-nez v1, :cond_0

    .line 1153
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lorg/litepal/crud/DataHandler;->fkInCurrentModel:Ljava/util/List;

    goto :goto_0

    .line 1155
    :cond_0
    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 1157
    :goto_0
    iget-object v1, p0, Lorg/litepal/crud/DataHandler;->fkInOtherModel:Ljava/util/List;

    if-nez v1, :cond_1

    .line 1158
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lorg/litepal/crud/DataHandler;->fkInOtherModel:Ljava/util/List;

    goto :goto_1

    .line 1160
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 1162
    :goto_1
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/crud/model/AssociationsInfo;

    .line 1163
    .local v2, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v3

    const/4 v4, 0x2

    if-eq v3, v4, :cond_4

    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    goto :goto_3

    .line 1170
    :cond_2
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v3

    const/4 v4, 0x3

    if-ne v3, v4, :cond_3

    .line 1171
    iget-object v3, p0, Lorg/litepal/crud/DataHandler;->fkInOtherModel:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1170
    :cond_3
    goto :goto_4

    .line 1163
    :cond_4
    :goto_3
    nop

    .line 1165
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getClassHoldsForeignKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1166
    iget-object v3, p0, Lorg/litepal/crud/DataHandler;->fkInCurrentModel:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1168
    :cond_5
    iget-object v3, p0, Lorg/litepal/crud/DataHandler;->fkInOtherModel:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1173
    .end local v2    # "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    :goto_4
    goto :goto_2

    .line 1162
    :cond_6
    nop

    .line 1174
    .end local v1    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private genGetColumnMethod(Ljava/lang/Class;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 1082
    .local p1, "fieldType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->isPrimitive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1083
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->capitalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1085
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 1087
    .local v0, "typeName":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "get"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1088
    .local v1, "methodName":Ljava/lang/String;
    const-string v2, "getBoolean"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1089
    const-string v1, "getInt"

    goto :goto_2

    .line 1090
    :cond_1
    const-string v2, "getChar"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    const-string v2, "getCharacter"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_1

    .line 1092
    :cond_2
    const-string v2, "getDate"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1093
    const-string v1, "getLong"

    goto :goto_2

    .line 1094
    :cond_3
    const-string v2, "getInteger"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1095
    const-string v1, "getInt"

    goto :goto_2

    .line 1096
    :cond_4
    const-string v2, "getbyte[]"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1097
    const-string v1, "getBlob"

    goto :goto_2

    .line 1096
    :cond_5
    goto :goto_2

    .line 1090
    :cond_6
    :goto_1
    nop

    .line 1091
    const-string v1, "getString"

    .line 1099
    :goto_2
    return-object v1
.end method

.method private genGetColumnMethod(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 1066
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/litepal/crud/DataHandler;->genGetColumnMethod(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getCustomizedColumns([Ljava/lang/String;Ljava/util/List;)[Ljava/lang/String;
    .locals 6
    .param p1, "columns"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 1115
    .local p2, "foreignKeyAssociations":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/crud/model/AssociationsInfo;>;"
    if-eqz p1, :cond_5

    .line 1116
    const/4 v0, 0x0

    if-eqz p2, :cond_1

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 1117
    array-length v1, p1

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v1, v2

    new-array v1, v1, [Ljava/lang/String;

    .line 1118
    .local v1, "tempColumns":[Ljava/lang/String;
    array-length v2, p1

    invoke-static {p1, v0, v1, v0, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1119
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 1120
    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/litepal/crud/model/AssociationsInfo;

    invoke-virtual {v3}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1123
    .local v3, "associatedTable":Ljava/lang/String;
    array-length v4, p1

    add-int/2addr v4, v2

    invoke-virtual {p0, v3}, Lorg/litepal/crud/DataHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    .line 1119
    .end local v3    # "associatedTable":Ljava/lang/String;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1125
    .end local v2    # "i":I
    :cond_0
    move-object p1, v1

    goto :goto_1

    .line 1116
    .end local v1    # "tempColumns":[Ljava/lang/String;
    :cond_1
    nop

    .line 1127
    :goto_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_2
    array-length v2, p1

    if-ge v1, v2, :cond_4

    .line 1128
    aget-object v2, p1, v1

    .line 1129
    .local v2, "columnName":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/litepal/crud/DataHandler;->isIdColumn(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1130
    const-string v0, "_id"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1131
    const-string v0, "id"

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, p1, v1

    goto :goto_3

    .line 1130
    :cond_2
    nop

    .line 1133
    :goto_3
    return-object p1

    .line 1129
    :cond_3
    nop

    .line 1127
    .end local v2    # "columnName":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 1136
    .end local v1    # "i":I
    :cond_4
    array-length v1, p1

    add-int/lit8 v1, v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    .line 1137
    .local v1, "customizedColumns":[Ljava/lang/String;
    array-length v2, p1

    invoke-static {p1, v0, v1, v0, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1138
    array-length v0, p1

    const-string v2, "id"

    invoke-static {v2}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v0

    .line 1139
    return-object v1

    .line 1141
    .end local v1    # "customizedColumns":[Ljava/lang/String;
    :cond_5
    const/4 v0, 0x0

    return-object v0
.end method

.method private getInitParamValue(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 861
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "paramType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 862
    .local v0, "paramTypeName":Ljava/lang/String;
    const-string v1, "boolean"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_11

    const-string v1, "java.lang.Boolean"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto/16 :goto_7

    .line 865
    :cond_0
    const-string v1, "float"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_10

    const-string v1, "java.lang.Float"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    goto/16 :goto_6

    .line 868
    :cond_1
    const-string v1, "double"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    const-string v1, "java.lang.Double"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    goto/16 :goto_5

    .line 871
    :cond_2
    const-string v1, "int"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_e

    const-string v1, "java.lang.Integer"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    goto/16 :goto_4

    .line 874
    :cond_3
    const-string v1, "long"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_d

    const-string v1, "java.lang.Long"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    goto :goto_3

    .line 877
    :cond_4
    const-string v1, "short"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_c

    const-string v1, "java.lang.Short"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    goto :goto_2

    .line 880
    :cond_5
    const-string v1, "char"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    const-string v1, "java.lang.Character"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    goto :goto_1

    .line 883
    :cond_6
    const-string v1, "[B"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_a

    const-string v1, "[Ljava.lang.Byte;"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    goto :goto_0

    .line 886
    :cond_7
    const-string v1, "java.lang.String"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 887
    const-string v1, ""

    return-object v1

    .line 889
    :cond_8
    if-ne p1, p2, :cond_9

    .line 890
    const/4 v1, 0x0

    return-object v1

    .line 892
    :cond_9
    invoke-virtual {p0, p2}, Lorg/litepal/crud/DataHandler;->createInstanceFromClass(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 883
    :cond_a
    :goto_0
    nop

    .line 884
    new-array v1, v2, [B

    return-object v1

    .line 880
    :cond_b
    :goto_1
    nop

    .line 881
    const/16 v1, 0x20

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v1

    return-object v1

    .line 877
    :cond_c
    :goto_2
    nop

    .line 878
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    return-object v1

    .line 874
    :cond_d
    :goto_3
    nop

    .line 875
    const-wide/16 v1, 0x0

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    return-object v1

    .line 871
    :cond_e
    :goto_4
    nop

    .line 872
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    return-object v1

    .line 868
    :cond_f
    :goto_5
    nop

    .line 869
    const-wide/16 v1, 0x0

    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    return-object v1

    .line 865
    :cond_10
    :goto_6
    nop

    .line 866
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    return-object v1

    .line 862
    :cond_11
    :goto_7
    nop

    .line 863
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    return-object v1
.end method

.method private getObjectType(Ljava/lang/Class;)Ljava/lang/Class;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation

    .line 826
    .local p1, "primitiveType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p1, :cond_8

    .line 827
    invoke-virtual {p1}, Ljava/lang/Class;->isPrimitive()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 828
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 829
    .local v0, "basicTypeName":Ljava/lang/String;
    const-string v1, "int"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 830
    const-class v1, Ljava/lang/Integer;

    return-object v1

    .line 831
    :cond_0
    const-string v1, "short"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 832
    const-class v1, Ljava/lang/Short;

    return-object v1

    .line 833
    :cond_1
    const-string v1, "long"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 834
    const-class v1, Ljava/lang/Long;

    return-object v1

    .line 835
    :cond_2
    const-string v1, "float"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 836
    const-class v1, Ljava/lang/Float;

    return-object v1

    .line 837
    :cond_3
    const-string v1, "double"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 838
    const-class v1, Ljava/lang/Double;

    return-object v1

    .line 839
    :cond_4
    const-string v1, "boolean"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 840
    const-class v1, Ljava/lang/Boolean;

    return-object v1

    .line 841
    :cond_5
    const-string v1, "char"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 842
    const-class v1, Ljava/lang/Character;

    return-object v1

    .line 841
    :cond_6
    goto :goto_0

    .line 827
    .end local v0    # "basicTypeName":Ljava/lang/String;
    :cond_7
    goto :goto_0

    .line 826
    :cond_8
    nop

    .line 846
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method private getParameterTypes(Ljava/lang/reflect/Field;Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Class;
    .locals 5
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "fieldValue"    # Ljava/lang/Object;
    .param p3, "parameters"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Field;",
            "Ljava/lang/Object;",
            "[",
            "Ljava/lang/Object;",
            ")[",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation

    .line 800
    invoke-direct {p0, p1}, Lorg/litepal/crud/DataHandler;->isCharType(Ljava/lang/reflect/Field;)Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x2

    const/4 v3, 0x1

    if-eqz v0, :cond_0

    .line 801
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, p3, v3

    .line 802
    new-array v0, v2, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    aput-object v2, v0, v1

    const-class v1, Ljava/lang/String;

    aput-object v1, v0, v3

    goto :goto_0

    .line 804
    :cond_0
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 805
    new-array v0, v2, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    invoke-direct {p0, v1}, Lorg/litepal/crud/DataHandler;->getObjectType(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    aput-object v1, v0, v3

    goto :goto_0

    .line 806
    :cond_1
    const-string v0, "java.util.Date"

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 807
    new-array v0, v2, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    aput-object v2, v0, v1

    const-class v1, Ljava/lang/Long;

    aput-object v1, v0, v3

    goto :goto_0

    .line 809
    :cond_2
    new-array v0, v2, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    aput-object v1, v0, v3

    .line 812
    .local v0, "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    :goto_0
    return-object v0
.end method

.method private isCharType(Ljava/lang/reflect/Field;)Z
    .locals 2
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 903
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 904
    .local v0, "type":Ljava/lang/String;
    const-string v1, "char"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "Character"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v1, 0x1

    :goto_1
    return v1
.end method

.method private isFieldWithDefaultValue(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Z
    .locals 6
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 998
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DataHandler;->getEmptyModel(Lorg/litepal/crud/DataSupport;)Lorg/litepal/crud/DataSupport;

    move-result-object v0

    .line 999
    .local v0, "emptyModel":Lorg/litepal/crud/DataSupport;
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v1

    .line 1000
    .local v1, "realReturn":Ljava/lang/Object;
    invoke-virtual {p0, v0, p2}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v2

    .line 1001
    .local v2, "defaultReturn":Ljava/lang/Object;
    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 1002
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1003
    .local v3, "realFieldValue":Ljava/lang/String;
    invoke-virtual {p0, v0, p2}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1004
    .local v4, "defaultFieldValue":Ljava/lang/String;
    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    return v5

    .line 1001
    .end local v3    # "realFieldValue":Ljava/lang/String;
    .end local v4    # "defaultFieldValue":Ljava/lang/String;
    :cond_0
    nop

    .line 1006
    if-ne v1, v2, :cond_1

    const/4 v3, 0x1

    goto :goto_0

    :cond_1
    const/4 v3, 0x0

    :goto_0
    return v3
.end method

.method private isPrimitiveBooleanType(Ljava/lang/reflect/Field;)Z
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 918
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    .line 919
    .local v0, "fieldType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v1, "boolean"

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 920
    const/4 v1, 0x1

    return v1

    .line 922
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method private isSaving()Z
    .locals 2

    .line 973
    const-class v0, Lorg/litepal/crud/SaveHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isUpdating()Z
    .locals 2

    .line 963
    const-class v0, Lorg/litepal/crud/UpdateHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private makeGetterMethodName(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 4
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 1018
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v0

    .line 1019
    .local v0, "fieldName":Ljava/lang/String;
    invoke-direct {p0, p1}, Lorg/litepal/crud/DataHandler;->isPrimitiveBooleanType(Ljava/lang/reflect/Field;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1020
    const-string v1, "^is[A-Z]{1}.*$"

    invoke-virtual {v0, v1}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1021
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1020
    :cond_0
    nop

    .line 1023
    :goto_0
    const-string v1, "is"

    goto :goto_1

    .line 1025
    :cond_1
    const-string v1, "get"

    .line 1027
    .local v1, "getterMethodPrefix":Ljava/lang/String;
    :goto_1
    const-string v2, "^[a-z]{1}[A-Z]{1}.*"

    invoke-virtual {v0, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1028
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 1030
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->capitalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private makeSetterMethodName(Ljava/lang/reflect/Field;)Ljava/lang/String;
    .locals 4
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .line 1043
    const-string v0, "set"

    .line 1044
    .local v0, "setterMethodPrefix":Ljava/lang/String;
    invoke-direct {p0, p1}, Lorg/litepal/crud/DataHandler;->isPrimitiveBooleanType(Ljava/lang/reflect/Field;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "^is[A-Z]{1}.*$"

    invoke-virtual {v1, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1045
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 1044
    :cond_0
    nop

    .line 1046
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "^[a-z]{1}[A-Z]{1}.*"

    invoke-virtual {v1, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1047
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 1049
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/litepal/util/BaseUtility;->capitalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1051
    .local v1, "setterMethodName":Ljava/lang/String;
    :goto_0
    return-object v1
.end method

.method private putFieldsValueDependsOnSaveOrUpdate(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 946
    invoke-direct {p0}, Lorg/litepal/crud/DataHandler;->isUpdating()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 947
    invoke-direct {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->isFieldWithDefaultValue(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 948
    invoke-virtual {p0, p1, p2, p3}, Lorg/litepal/crud/DataHandler;->putContentValuesForUpdate(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V

    goto :goto_0

    .line 947
    :cond_0
    goto :goto_0

    .line 950
    :cond_1
    invoke-direct {p0}, Lorg/litepal/crud/DataHandler;->isSaving()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 951
    invoke-virtual {p0, p1, p2, p3}, Lorg/litepal/crud/DataHandler;->putContentValuesForSave(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V

    goto :goto_0

    .line 950
    :cond_2
    nop

    .line 953
    :goto_0
    return-void
.end method

.method private setAssociatedModel(Lorg/litepal/crud/DataSupport;)V
    .locals 25
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 1184
    move-object/from16 v7, p0

    move-object/from16 v8, p1

    iget-object v0, v7, Lorg/litepal/crud/DataHandler;->fkInOtherModel:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1185
    return-void

    .line 1187
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v10, v0

    check-cast v10, Lorg/litepal/crud/model/AssociationsInfo;

    .line 1188
    .local v10, "info":Lorg/litepal/crud/model/AssociationsInfo;
    const/4 v1, 0x0

    .line 1189
    .local v1, "cursor":Landroid/database/Cursor;
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v11

    .line 1190
    .local v11, "associatedClassName":Ljava/lang/String;
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v0

    const/4 v2, 0x3

    const/4 v4, 0x0

    if-ne v0, v2, :cond_1

    const/4 v0, 0x1

    goto :goto_1

    :cond_1
    const/4 v0, 0x0

    :goto_1
    move v13, v0

    .line 1192
    .local v13, "isM2M":Z
    :try_start_0
    invoke-virtual {v7, v11}, Lorg/litepal/crud/DataHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 1193
    .local v3, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    const/4 v0, 0x2

    if-eqz v13, :cond_2

    .line 1194
    invoke-virtual/range {p1 .. p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v2

    .line 1195
    .local v2, "tableName":Ljava/lang/String;
    invoke-static {v11}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1197
    .local v5, "associatedTableName":Ljava/lang/String;
    invoke-static {v2, v5}, Lorg/litepal/util/DBUtility;->getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1199
    .local v6, "intermediateTableName":Ljava/lang/String;
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    .line 1200
    .local v14, "sql":Ljava/lang/StringBuilder;
    const-string v15, "select * from "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v14, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v15, " a inner join "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v14, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v15, " b on a.id = b."

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v12, "_id"

    invoke-virtual {v15, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v12, " where b."

    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v14, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v12, "_id = ?"

    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1204
    new-array v12, v0, [Ljava/lang/String;

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    aput-object v15, v12, v4

    invoke-virtual/range {p1 .. p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v16

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    const/4 v15, 0x1

    aput-object v4, v12, v15

    invoke-static {v12}, Lorg/litepal/crud/DataSupport;->findBySQL([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    move-object v1, v4

    .line 1206
    .end local v2    # "tableName":Ljava/lang/String;
    .end local v5    # "associatedTableName":Ljava/lang/String;
    .end local v6    # "intermediateTableName":Ljava/lang/String;
    .end local v14    # "sql":Ljava/lang/StringBuilder;
    move-object v12, v1

    goto :goto_2

    .line 1207
    :cond_2
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getSelfClassName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v2}, Lorg/litepal/crud/DataHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1209
    .local v2, "foreignKeyColumn":Ljava/lang/String;
    invoke-static {v11}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1211
    .restart local v5    # "associatedTableName":Ljava/lang/String;
    iget-object v6, v7, Lorg/litepal/crud/DataHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v5}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x0

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v14, "=?"

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    const/4 v12, 0x1

    new-array v14, v12, [Ljava/lang/String;

    invoke-virtual/range {p1 .. p1}, Lorg/litepal/crud/DataSupport;->getBaseObjId()J

    move-result-wide v20

    invoke-static/range {v20 .. v21}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v14, v4

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    move-object/from16 v16, v6

    move-object/from16 v20, v14

    invoke-virtual/range {v16 .. v24}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-object v1, v4

    move-object v12, v1

    .line 1216
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v2    # "foreignKeyColumn":Ljava/lang/String;
    .end local v5    # "associatedTableName":Ljava/lang/String;
    .local v12, "cursor":Landroid/database/Cursor;
    :goto_2
    if-eqz v12, :cond_7

    :try_start_1
    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 1217
    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6}, Landroid/util/SparseArray;-><init>()V

    .line 1219
    .local v6, "queryInfoCacheSparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lorg/litepal/crud/DataHandler$QueryInfoCache;>;"
    :goto_3
    invoke-static {v11}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v7, v1}, Lorg/litepal/crud/DataHandler;->createInstanceFromClass(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/crud/DataSupport;

    move-object v14, v1

    .line 1220
    .local v14, "modelInstance":Lorg/litepal/crud/DataSupport;
    const-string v1, "id"

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    invoke-virtual {v7, v14, v1, v2}, Lorg/litepal/crud/DataHandler;->giveBaseObjIdValue(Lorg/litepal/crud/DataSupport;J)V

    .line 1222
    const/4 v4, 0x0

    move-object/from16 v1, p0

    move-object v2, v14

    move-object v5, v12

    invoke-virtual/range {v1 .. v6}, Lorg/litepal/crud/DataHandler;->setValueToModel(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Landroid/database/Cursor;Landroid/util/SparseArray;)V

    .line 1223
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v1

    if-eq v1, v0, :cond_5

    if-eqz v13, :cond_3

    const/4 v2, 0x1

    goto :goto_5

    .line 1227
    :cond_3
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_4

    .line 1228
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;

    move-result-object v1

    invoke-virtual {v7, v8, v1, v14}, Lorg/litepal/crud/DataHandler;->putSetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Ljava/lang/Object;)V

    goto :goto_6

    .line 1227
    :cond_4
    :goto_4
    goto :goto_6

    .line 1223
    :cond_5
    const/4 v2, 0x1

    .line 1224
    :goto_5
    invoke-virtual {v10}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;

    move-result-object v1

    invoke-virtual {v7, v8, v1}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Collection;

    .line 1226
    .local v1, "collection":Ljava/util/Collection;
    invoke-interface {v1, v14}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1231
    .end local v1    # "collection":Ljava/util/Collection;
    .end local v14    # "modelInstance":Lorg/litepal/crud/DataSupport;
    :goto_6
    invoke-interface {v12}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_6

    .line 1232
    invoke-virtual {v6}, Landroid/util/SparseArray;->clear()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_7

    .line 1231
    :cond_6
    goto :goto_3

    .line 1237
    .end local v3    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    .end local v6    # "queryInfoCacheSparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lorg/litepal/crud/DataHandler$QueryInfoCache;>;"
    :catchall_0
    move-exception v0

    move-object v1, v12

    goto :goto_a

    .line 1234
    :catch_0
    move-exception v0

    move-object v1, v12

    goto :goto_9

    .line 1216
    .restart local v3    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    :cond_7
    nop

    .line 1237
    .end local v3    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    :goto_7
    if-eqz v12, :cond_8

    .line 1238
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    goto :goto_8

    .line 1237
    :cond_8
    nop

    .line 1241
    .end local v10    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    .end local v11    # "associatedClassName":Ljava/lang/String;
    .end local v12    # "cursor":Landroid/database/Cursor;
    .end local v13    # "isM2M":Z
    :goto_8
    goto/16 :goto_0

    .line 1237
    .local v1, "cursor":Landroid/database/Cursor;
    .restart local v10    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    .restart local v11    # "associatedClassName":Ljava/lang/String;
    .restart local v13    # "isM2M":Z
    :catchall_1
    move-exception v0

    goto :goto_a

    .line 1234
    :catch_1
    move-exception v0

    .line 1235
    .local v0, "e":Ljava/lang/Exception;
    :goto_9
    :try_start_2
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    .end local v11    # "associatedClassName":Ljava/lang/String;
    .end local v13    # "isM2M":Z
    .end local p1    # "baseObj":Lorg/litepal/crud/DataSupport;
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1237
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "cursor":Landroid/database/Cursor;
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v10    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    .restart local v11    # "associatedClassName":Ljava/lang/String;
    .restart local v13    # "isM2M":Z
    .restart local p1    # "baseObj":Lorg/litepal/crud/DataSupport;
    :goto_a
    if-eqz v1, :cond_9

    .line 1238
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_b

    .line 1237
    :cond_9
    nop

    .line 1238
    :goto_b
    throw v0

    .line 1187
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v10    # "info":Lorg/litepal/crud/model/AssociationsInfo;
    .end local v11    # "associatedClassName":Ljava/lang/String;
    .end local v13    # "isM2M":Z
    :cond_a
    nop

    .line 1242
    .end local v9    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method private setToModelByReflection(Ljava/lang/Object;Ljava/lang/reflect/Field;ILjava/lang/String;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "modelInstance"    # Ljava/lang/Object;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "columnIndex"    # I
    .param p4, "getMethodName"    # Ljava/lang/String;
    .param p5, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .line 1246
    invoke-virtual {p5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 1247
    .local v0, "cursorClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, p4, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 1248
    .local v2, "method":Ljava/lang/reflect/Method;
    new-array v3, v1, [Ljava/lang/Object;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v2, p5, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 1249
    .local v3, "value":Ljava/lang/Object;
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-eq v5, v6, :cond_5

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    const-class v6, Ljava/lang/Boolean;

    if-ne v5, v6, :cond_0

    goto :goto_1

    .line 1255
    :cond_0
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    sget-object v5, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    if-eq v1, v5, :cond_4

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    const-class v5, Ljava/lang/Character;

    if-ne v1, v5, :cond_1

    goto :goto_0

    .line 1257
    :cond_1
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    const-class v4, Ljava/util/Date;

    if-ne v1, v4, :cond_3

    .line 1258
    move-object v1, v3

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 1259
    .local v4, "date":J
    const-wide/16 v6, 0x0

    cmp-long v1, v4, v6

    if-gtz v1, :cond_2

    .line 1260
    const/4 v3, 0x0

    goto :goto_2

    .line 1262
    :cond_2
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1, v4, v5}, Ljava/util/Date;-><init>(J)V

    move-object v3, v1

    goto :goto_2

    .line 1257
    .end local v4    # "date":J
    :cond_3
    goto :goto_2

    .line 1255
    :cond_4
    :goto_0
    nop

    .line 1256
    move-object v1, v3

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v3

    goto :goto_2

    .line 1249
    :cond_5
    :goto_1
    nop

    .line 1250
    const-string v5, "0"

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1251
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    goto :goto_2

    .line 1252
    :cond_6
    const-string v4, "1"

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 1253
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    goto :goto_2

    .line 1252
    :cond_7
    nop

    .line 1265
    :goto_2
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {p1, v1, v3, v4}, Lorg/litepal/crud/DynamicExecutor;->setField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V

    .line 1267
    return-void
.end method


# virtual methods
.method protected analyzeAssociatedModels(Lorg/litepal/crud/DataSupport;Ljava/util/Collection;)V
    .locals 4
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

    .line 364
    .local p2, "associationInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/litepal/crud/model/AssociationsInfo;>;"
    :try_start_0
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/litepal/crud/model/AssociationsInfo;

    .line 365
    .local v1, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 366
    new-instance v2, Lorg/litepal/crud/Many2OneAnalyzer;

    invoke-direct {v2}, Lorg/litepal/crud/Many2OneAnalyzer;-><init>()V

    invoke-virtual {v2, p1, v1}, Lorg/litepal/crud/Many2OneAnalyzer;->analyze(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V

    goto :goto_1

    .line 367
    :cond_0
    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    .line 368
    new-instance v2, Lorg/litepal/crud/One2OneAnalyzer;

    invoke-direct {v2}, Lorg/litepal/crud/One2OneAnalyzer;-><init>()V

    invoke-virtual {v2, p1, v1}, Lorg/litepal/crud/One2OneAnalyzer;->analyze(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V

    goto :goto_1

    .line 369
    :cond_1
    invoke-virtual {v1}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_2

    .line 370
    new-instance v2, Lorg/litepal/crud/Many2ManyAnalyzer;

    invoke-direct {v2}, Lorg/litepal/crud/Many2ManyAnalyzer;-><init>()V

    invoke-virtual {v2, p1, v1}, Lorg/litepal/crud/Many2ManyAnalyzer;->analyze(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 369
    :cond_2
    nop

    .line 372
    .end local v1    # "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    :goto_1
    goto :goto_0

    .line 364
    :cond_3
    nop

    .line 375
    .end local v0    # "i$":Ljava/util/Iterator;
    nop

    .line 376
    return-void

    .line 373
    :catch_0
    move-exception v0

    .line 374
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    return-void
.end method

.method protected createInstanceFromClass(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 635
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :try_start_0
    invoke-virtual {p0, p1}, Lorg/litepal/crud/DataHandler;->findBestSuitConstructor(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 636
    .local v0, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/DataHandler;->getConstructorParams(Ljava/lang/Class;Ljava/lang/reflect/Constructor;)[Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 637
    .end local v0    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    :catch_0
    move-exception v0

    .line 638
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected findBestSuitConstructor(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/reflect/Constructor<",
            "*>;"
        }
    .end annotation

    .line 652
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredConstructors()[Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 653
    .local v0, "constructors":[Ljava/lang/reflect/Constructor;, "[Ljava/lang/reflect/Constructor<*>;"
    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    .line 654
    .local v1, "map":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Ljava/lang/reflect/Constructor<*>;>;"
    const v2, 0x7fffffff

    .line 655
    .local v2, "minKey":I
    move-object v3, v0

    .local v3, "arr$":[Ljava/lang/reflect/Constructor;
    array-length v4, v3

    .local v4, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v4, :cond_4

    aget-object v6, v3, v5

    .line 656
    .local v6, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    invoke-virtual {v6}, Ljava/lang/reflect/Constructor;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v7

    array-length v7, v7

    .line 657
    .local v7, "key":I
    invoke-virtual {v6}, Ljava/lang/reflect/Constructor;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v8

    .line 658
    .local v8, "types":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    move-object v9, v8

    .local v9, "arr$":[Ljava/lang/Class;
    array-length v10, v9

    .local v10, "len$":I
    const/4 v11, 0x0

    .local v11, "i$":I
    :goto_1
    if-ge v11, v10, :cond_1

    aget-object v12, v9, v11

    .line 659
    .local v12, "parameterType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-ne v12, p1, :cond_0

    .line 660
    add-int/lit16 v7, v7, 0x2710

    goto :goto_2

    .line 659
    :cond_0
    nop

    .line 658
    .end local v12    # "parameterType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_2
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 663
    .end local v9    # "arr$":[Ljava/lang/Class;
    .end local v10    # "len$":I
    .end local v11    # "i$":I
    :cond_1
    invoke-virtual {v1, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v9

    if-nez v9, :cond_2

    .line 664
    invoke-virtual {v1, v7, v6}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_3

    .line 663
    :cond_2
    nop

    .line 666
    :goto_3
    if-ge v7, v2, :cond_3

    .line 667
    move v2, v7

    goto :goto_4

    .line 666
    :cond_3
    nop

    .line 655
    .end local v6    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v7    # "key":I
    .end local v8    # "types":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    :goto_4
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 670
    .end local v3    # "arr$":[Ljava/lang/reflect/Constructor;
    .end local v4    # "len$":I
    .end local v5    # "i$":I
    :cond_4
    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/reflect/Constructor;

    .line 671
    .local v3, "bestSuitConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    if-eqz v3, :cond_5

    .line 672
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    goto :goto_5

    .line 671
    :cond_5
    nop

    .line 674
    :goto_5
    return-object v3
.end method

.method protected findDataSupportClass(Lorg/litepal/crud/DataSupport;)Ljava/lang/Class;
    .locals 4
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            ")",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 568
    const/4 v0, 0x0

    .line 570
    .local v0, "superClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    .line 571
    if-eqz v0, :cond_1

    const-class v1, Lorg/litepal/crud/DataSupport;

    if-ne v1, v0, :cond_0

    .line 572
    goto :goto_1

    .line 571
    :cond_0
    goto :goto_0

    .line 575
    :cond_1
    :goto_1
    if-eqz v0, :cond_2

    .line 579
    return-object v0

    .line 576
    :cond_2
    new-instance v1, Lorg/litepal/exceptions/DataSupportException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " should be inherited from DataSupport"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;)V

    throw v1

    return-void
.end method

.method protected getAssociatedModel(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Lorg/litepal/crud/DataSupport;
    .locals 1
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

    .line 396
    invoke-virtual {p2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/litepal/crud/DataSupport;

    return-object v0
.end method

.method protected getAssociatedModels(Lorg/litepal/crud/DataSupport;Lorg/litepal/crud/model/AssociationsInfo;)Ljava/util/Collection;
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associationInfo"    # Lorg/litepal/crud/model/AssociationsInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/litepal/crud/DataSupport;",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ")",
            "Ljava/util/Collection<",
            "Lorg/litepal/crud/DataSupport;",
            ">;"
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

    .line 420
    invoke-virtual {p2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;

    return-object v0
.end method

.method protected getConstructorParams(Ljava/lang/Class;Ljava/lang/reflect/Constructor;)[Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/reflect/Constructor<",
            "*>;)[",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 689
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    invoke-virtual {p2}, Ljava/lang/reflect/Constructor;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 690
    .local v0, "paramTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    array-length v1, v0

    new-array v1, v1, [Ljava/lang/Object;

    .line 691
    .local v1, "params":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, v0

    if-ge v2, v3, :cond_0

    .line 692
    aget-object v3, v0, v2

    invoke-direct {p0, p1, v3}, Lorg/litepal/crud/DataHandler;->getInitParamValue(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v2

    .line 691
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 694
    .end local v2    # "i":I
    :cond_0
    return-object v1
.end method

.method protected getEmptyModel(Lorg/litepal/crud/DataSupport;)Lorg/litepal/crud/DataSupport;
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;

    .line 434
    iget-object v0, p0, Lorg/litepal/crud/DataHandler;->tempEmptyModel:Lorg/litepal/crud/DataSupport;

    if-eqz v0, :cond_0

    .line 435
    return-object v0

    .line 437
    :cond_0
    const/4 v0, 0x0

    .line 439
    .local v0, "className":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getClassName()Ljava/lang/String;

    move-result-object v1

    move-object v0, v1

    .line 440
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 441
    .local v1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/litepal/crud/DataSupport;

    iput-object v2, p0, Lorg/litepal/crud/DataHandler;->tempEmptyModel:Lorg/litepal/crud/DataSupport;

    .line 442
    iget-object v2, p0, Lorg/litepal/crud/DataHandler;->tempEmptyModel:Lorg/litepal/crud/DataSupport;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 448
    .end local v1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v1

    .line 449
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 446
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 447
    .local v1, "e":Ljava/lang/InstantiationException;
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " needs a default constructor."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 443
    .end local v1    # "e":Ljava/lang/InstantiationException;
    :catch_2
    move-exception v1

    .line 444
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    new-instance v2, Lorg/litepal/exceptions/DatabaseGenerateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "can not find a class named "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/DatabaseGenerateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method protected getForeignKeyAssociations(Ljava/lang/String;Z)Ljava/util/List;
    .locals 1
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "isEager"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;"
        }
    .end annotation

    .line 777
    if-eqz p2, :cond_0

    .line 778
    invoke-direct {p0, p1}, Lorg/litepal/crud/DataHandler;->analyzeAssociations(Ljava/lang/String;)V

    .line 779
    iget-object v0, p0, Lorg/litepal/crud/DataHandler;->fkInCurrentModel:Ljava/util/List;

    return-object v0

    .line 781
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getIntermediateTableName(Lorg/litepal/crud/DataSupport;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "associatedTableName"    # Ljava/lang/String;

    .line 607
    invoke-virtual {p1}, Lorg/litepal/crud/DataSupport;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p2}, Lorg/litepal/util/DBUtility;->getIntermediateTableName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTableName(Ljava/lang/Class;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 620
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs getWhereArgs([Ljava/lang/String;)[Ljava/lang/String;
    .locals 4
    .param p1, "conditions"    # [Ljava/lang/String;

    .line 483
    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p0, v1}, Lorg/litepal/crud/DataHandler;->isAffectAllLines([Ljava/lang/Object;)Z

    move-result v1

    const/4 v3, 0x0

    if-eqz v1, :cond_0

    .line 484
    return-object v3

    .line 486
    :cond_0
    if-eqz p1, :cond_1

    array-length v1, p1

    if-le v1, v0, :cond_1

    .line 487
    array-length v1, p1

    sub-int/2addr v1, v0

    new-array v1, v1, [Ljava/lang/String;

    .line 488
    .local v1, "whereArgs":[Ljava/lang/String;
    array-length v3, p1

    sub-int/2addr v3, v0

    invoke-static {p1, v0, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 489
    return-object v1

    .line 486
    .end local v1    # "whereArgs":[Ljava/lang/String;
    :cond_1
    nop

    .line 491
    return-object v3
.end method

.method protected varargs getWhereClause([Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "conditions"    # [Ljava/lang/String;

    .line 463
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lorg/litepal/crud/DataHandler;->isAffectAllLines([Ljava/lang/Object;)Z

    move-result v0

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    .line 464
    return-object v2

    .line 466
    :cond_0
    if-eqz p1, :cond_1

    array-length v0, p1

    if-lez v0, :cond_1

    .line 467
    aget-object v0, p1, v1

    return-object v0

    .line 466
    :cond_1
    nop

    .line 469
    return-object v2
.end method

.method protected getWhereOfIdsWithOr(Ljava/util/Collection;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Ljava/lang/Long;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 518
    .local p1, "ids":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Long;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 519
    .local v0, "whereClause":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 520
    .local v1, "needOr":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 521
    .local v3, "id":J
    if-eqz v1, :cond_0

    .line 522
    const-string v5, " or "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 521
    :cond_0
    nop

    .line 524
    :goto_1
    const/4 v1, 0x1

    .line 525
    const-string v5, "id = "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 526
    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 527
    .end local v3    # "id":J
    goto :goto_0

    .line 520
    :cond_1
    nop

    .line 528
    .end local v2    # "i$":Ljava/util/Iterator;
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method protected varargs getWhereOfIdsWithOr([J)Ljava/lang/String;
    .locals 8
    .param p1, "ids"    # [J

    .line 539
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 540
    .local v0, "whereClause":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 541
    .local v1, "needOr":Z
    move-object v2, p1

    .local v2, "arr$":[J
    array-length v3, v2

    .local v3, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v3, :cond_1

    aget-wide v5, v2, v4

    .line 542
    .local v5, "id":J
    if-eqz v1, :cond_0

    .line 543
    const-string v7, " or "

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 542
    :cond_0
    nop

    .line 545
    :goto_1
    const/4 v1, 0x1

    .line 546
    const-string v7, "id = "

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 547
    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 541
    .end local v5    # "id":J
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 549
    .end local v2    # "arr$":[J
    .end local v3    # "len$":I
    .end local v4    # "i$":I
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method protected giveBaseObjIdValue(Lorg/litepal/crud/DataSupport;J)V
    .locals 3
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "id"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/NoSuchFieldException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .line 200
    const-wide/16 v0, 0x0

    cmp-long v2, p2, v0

    if-lez v2, :cond_0

    .line 201
    const-string v0, "baseObjId"

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-class v2, Lorg/litepal/crud/DataSupport;

    invoke-static {p1, v0, v1, v2}, Lorg/litepal/crud/DynamicExecutor;->set(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V

    goto :goto_0

    .line 200
    :cond_0
    nop

    .line 203
    :goto_0
    return-void
.end method

.method protected varargs isAffectAllLines([Ljava/lang/Object;)Z
    .locals 1
    .param p1, "conditions"    # [Ljava/lang/Object;

    .line 503
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_0

    .line 504
    const/4 v0, 0x1

    return v0

    .line 503
    :cond_0
    nop

    .line 506
    const/4 v0, 0x0

    return v0
.end method

.method protected mathQuery(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 10
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "columns"    # [Ljava/lang/String;
    .param p3, "conditions"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 168
    .local p4, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-static {p3}, Lorg/litepal/util/BaseUtility;->checkConditionsCorrect([Ljava/lang/String;)V

    .line 169
    const/4 v0, 0x0

    .line 170
    .local v0, "cursor":Landroid/database/Cursor;
    const/4 v1, 0x0

    .line 172
    .local v1, "result":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v2, p0, Lorg/litepal/crud/DataHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {p0, p3}, Lorg/litepal/crud/DataHandler;->getWhereClause([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, p3}, Lorg/litepal/crud/DataHandler;->getWhereArgs([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v3, p1

    move-object v4, p2

    invoke-virtual/range {v2 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move-object v0, v2

    .line 174
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 175
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 176
    .local v2, "cursorClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p4}, Lorg/litepal/crud/DataHandler;->genGetColumnMethod(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v5, v4, [Ljava/lang/Class;

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    const/4 v7, 0x0

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 177
    .local v3, "method":Ljava/lang/reflect/Method;
    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v3, v0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v1, v4

    goto :goto_0

    .line 174
    .end local v2    # "cursorClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "method":Ljava/lang/reflect/Method;
    :cond_0
    nop

    .line 182
    :goto_0
    if-eqz v0, :cond_1

    .line 183
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 182
    :cond_1
    nop

    .line 186
    :goto_1
    return-object v1

    .line 182
    :catchall_0
    move-exception v2

    goto :goto_2

    .line 179
    :catch_0
    move-exception v2

    .line 180
    .local v2, "e":Ljava/lang/Exception;
    :try_start_1
    new-instance v3, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v0    # "cursor":Landroid/database/Cursor;
    .end local v1    # "result":Ljava/lang/Object;, "TT;"
    .end local p1    # "tableName":Ljava/lang/String;
    .end local p2    # "columns":[Ljava/lang/String;
    .end local p3    # "conditions":[Ljava/lang/String;
    .end local p4    # "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 182
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "result":Ljava/lang/Object;, "TT;"
    .restart local p1    # "tableName":Ljava/lang/String;
    .restart local p2    # "columns":[Ljava/lang/String;
    .restart local p3    # "conditions":[Ljava/lang/String;
    .restart local p4    # "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :goto_2
    if-eqz v0, :cond_2

    .line 183
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 182
    :cond_2
    nop

    .line 183
    :goto_3
    throw v2
.end method

.method protected putContentValuesForSave(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 253
    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lorg/litepal/crud/DynamicExecutor;->getField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 254
    .local v0, "fieldValue":Ljava/lang/Object;
    if-eqz v0, :cond_1

    .line 256
    const-string v1, "java.util.Date"

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 257
    move-object v1, v0

    check-cast v1, Ljava/util/Date;

    .line 258
    .local v1, "date":Ljava/util/Date;
    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_0

    .line 256
    .end local v1    # "date":Ljava/util/Date;
    :cond_0
    nop

    .line 260
    :goto_0
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object v0, v1, v2

    .line 261
    .local v1, "parameters":[Ljava/lang/Object;
    invoke-direct {p0, p2, v0, v1}, Lorg/litepal/crud/DataHandler;->getParameterTypes(Ljava/lang/reflect/Field;Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Class;

    move-result-object v2

    .line 262
    .local v2, "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    const-string v3, "put"

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {p3, v3, v1, v4, v2}, Lorg/litepal/crud/DynamicExecutor;->send(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;

    goto :goto_1

    .line 254
    .end local v1    # "parameters":[Ljava/lang/Object;
    .end local v2    # "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    :cond_1
    nop

    .line 264
    :goto_1
    return-void
.end method

.method protected putContentValuesForUpdate(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "baseObj"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 290
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;

    move-result-object v0

    .line 291
    .local v0, "fieldValue":Ljava/lang/Object;
    const-string v1, "java.util.Date"

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 292
    move-object v1, v0

    check-cast v1, Ljava/util/Date;

    .line 293
    .local v1, "date":Ljava/util/Date;
    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_0

    .line 291
    .end local v1    # "date":Ljava/util/Date;
    :cond_0
    nop

    .line 295
    :goto_0
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object v0, v1, v2

    .line 296
    .local v1, "parameters":[Ljava/lang/Object;
    invoke-direct {p0, p2, v0, v1}, Lorg/litepal/crud/DataHandler;->getParameterTypes(Ljava/lang/reflect/Field;Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Class;

    move-result-object v2

    .line 297
    .local v2, "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    const-string v3, "put"

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {p3, v3, v1, v4, v2}, Lorg/litepal/crud/DynamicExecutor;->send(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;

    .line 298
    return-void
.end method

.method protected putFieldsValue(Lorg/litepal/crud/DataSupport;Ljava/util/List;Landroid/content/ContentValues;)V
    .locals 3
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

    .line 224
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/reflect/Field;

    .line 225
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lorg/litepal/crud/DataHandler;->isIdColumn(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 226
    invoke-direct {p0, p1, v1, p3}, Lorg/litepal/crud/DataHandler;->putFieldsValueDependsOnSaveOrUpdate(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Landroid/content/ContentValues;)V

    goto :goto_1

    .line 225
    :cond_0
    nop

    .line 228
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :goto_1
    goto :goto_0

    .line 224
    :cond_1
    nop

    .line 229
    .end local v0    # "i$":Ljava/util/Iterator;
    return-void
.end method

.method protected putSetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Ljava/lang/Object;)V
    .locals 6
    .param p1, "dataSupport"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "parameter"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 347
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->shouldGetOrSet(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 348
    invoke-direct {p0, p2}, Lorg/litepal/crud/DataHandler;->makeSetterMethodName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v0

    .line 349
    .local v0, "setMethodName":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    new-array v1, v1, [Ljava/lang/Class;

    invoke-virtual {p2}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    aput-object v5, v1, v3

    invoke-static {p1, v0, v2, v4, v1}, Lorg/litepal/crud/DynamicExecutor;->send(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;

    goto :goto_0

    .line 347
    .end local v0    # "setMethodName":Ljava/lang/String;
    :cond_0
    nop

    .line 352
    :goto_0
    return-void
.end method

.method protected query(Ljava/lang/Class;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .locals 19
    .param p2, "columns"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "groupBy"    # Ljava/lang/String;
    .param p6, "having"    # Ljava/lang/String;
    .param p7, "orderBy"    # Ljava/lang/String;
    .param p8, "limit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;[",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .line 118
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p9, "foreignKeyAssociations":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/crud/model/AssociationsInfo;>;"
    move-object/from16 v7, p0

    move-object/from16 v8, p9

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    move-object v9, v0

    .line 119
    .local v9, "dataList":Ljava/util/List;, "Ljava/util/List<TT;>;"
    const/4 v1, 0x0

    .line 121
    .local v1, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Lorg/litepal/crud/DataHandler;->getSupportedFields(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 122
    .local v3, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    invoke-virtual/range {p0 .. p1}, Lorg/litepal/crud/DataHandler;->getTableName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v11

    .line 123
    .local v11, "tableName":Ljava/lang/String;
    move-object/from16 v5, p2

    invoke-direct {v7, v5, v8}, Lorg/litepal/crud/DataHandler;->getCustomizedColumns([Ljava/lang/String;Ljava/util/List;)[Ljava/lang/String;

    move-result-object v12

    .line 124
    .local v12, "customizedColumns":[Ljava/lang/String;
    iget-object v10, v7, Lorg/litepal/crud/DataHandler;->mDatabase:Landroid/database/sqlite/SQLiteDatabase;

    move-object/from16 v13, p3

    move-object/from16 v14, p4

    move-object/from16 v15, p5

    move-object/from16 v16, p6

    move-object/from16 v17, p7

    move-object/from16 v18, p8

    invoke-virtual/range {v10 .. v18}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-object v10, v0

    .line 126
    .end local v1    # "cursor":Landroid/database/Cursor;
    .local v10, "cursor":Landroid/database/Cursor;
    :try_start_1
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 127
    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6}, Landroid/util/SparseArray;-><init>()V

    .line 129
    .local v6, "queryInfoCacheSparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lorg/litepal/crud/DataHandler$QueryInfoCache;>;"
    :goto_0
    invoke-virtual/range {p0 .. p1}, Lorg/litepal/crud/DataHandler;->createInstanceFromClass(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 130
    .local v0, "modelInstance":Ljava/lang/Object;, "TT;"
    move-object v1, v0

    check-cast v1, Lorg/litepal/crud/DataSupport;

    const-string v2, "id"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v13

    invoke-virtual {v7, v1, v13, v14}, Lorg/litepal/crud/DataHandler;->giveBaseObjIdValue(Lorg/litepal/crud/DataSupport;J)V

    .line 132
    move-object/from16 v1, p0

    move-object v2, v0

    move-object/from16 v4, p9

    move-object v5, v10

    invoke-virtual/range {v1 .. v6}, Lorg/litepal/crud/DataHandler;->setValueToModel(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Landroid/database/Cursor;Landroid/util/SparseArray;)V

    .line 133
    if-eqz v8, :cond_0

    .line 134
    move-object v1, v0

    check-cast v1, Lorg/litepal/crud/DataSupport;

    invoke-direct {v7, v1}, Lorg/litepal/crud/DataHandler;->setAssociatedModel(Lorg/litepal/crud/DataSupport;)V

    goto :goto_1

    .line 133
    :cond_0
    nop

    .line 136
    :goto_1
    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    nop

    .end local v0    # "modelInstance":Ljava/lang/Object;, "TT;"
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_1

    .line 138
    invoke-virtual {v6}, Landroid/util/SparseArray;->clear()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 137
    :cond_1
    move-object/from16 v5, p2

    goto :goto_0

    .line 126
    .end local v6    # "queryInfoCacheSparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lorg/litepal/crud/DataHandler$QueryInfoCache;>;"
    :cond_2
    nop

    .line 140
    :goto_2
    nop

    .line 144
    if-eqz v10, :cond_3

    .line 145
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 144
    :cond_3
    nop

    .line 145
    :goto_3
    return-object v9

    .line 144
    .end local v3    # "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    .end local v11    # "tableName":Ljava/lang/String;
    .end local v12    # "customizedColumns":[Ljava/lang/String;
    :catchall_0
    move-exception v0

    goto :goto_5

    .line 141
    :catch_0
    move-exception v0

    move-object v1, v10

    goto :goto_4

    .line 144
    .end local v10    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "cursor":Landroid/database/Cursor;
    :catchall_1
    move-exception v0

    move-object v10, v1

    goto :goto_5

    .line 141
    :catch_1
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    :goto_4
    :try_start_2
    new-instance v2, Lorg/litepal/exceptions/DataSupportException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v9    # "dataList":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "columns":[Ljava/lang/String;
    .end local p3    # "selection":Ljava/lang/String;
    .end local p4    # "selectionArgs":[Ljava/lang/String;
    .end local p5    # "groupBy":Ljava/lang/String;
    .end local p6    # "having":Ljava/lang/String;
    .end local p7    # "orderBy":Ljava/lang/String;
    .end local p8    # "limit":Ljava/lang/String;
    .end local p9    # "foreignKeyAssociations":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/crud/model/AssociationsInfo;>;"
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 144
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v9    # "dataList":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .restart local v10    # "cursor":Landroid/database/Cursor;
    .restart local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .restart local p2    # "columns":[Ljava/lang/String;
    .restart local p3    # "selection":Ljava/lang/String;
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    .restart local p5    # "groupBy":Ljava/lang/String;
    .restart local p6    # "having":Ljava/lang/String;
    .restart local p7    # "orderBy":Ljava/lang/String;
    .restart local p8    # "limit":Ljava/lang/String;
    .restart local p9    # "foreignKeyAssociations":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/crud/model/AssociationsInfo;>;"
    :goto_5
    if-eqz v10, :cond_4

    .line 145
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 144
    :cond_4
    nop

    .line 145
    :goto_6
    throw v0

    return-void
.end method

.method protected setValueToModel(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Landroid/database/Cursor;Landroid/util/SparseArray;)V
    .locals 16
    .param p1, "modelInstance"    # Ljava/lang/Object;
    .param p4, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;",
            "Ljava/util/List<",
            "Lorg/litepal/crud/model/AssociationsInfo;",
            ">;",
            "Landroid/database/Cursor;",
            "Landroid/util/SparseArray<",
            "Lorg/litepal/crud/DataHandler$QueryInfoCache;",
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

    .line 722
    .local p2, "supportedFields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/reflect/Field;>;"
    .local p3, "foreignKeyAssociations":Ljava/util/List;, "Ljava/util/List<Lorg/litepal/crud/model/AssociationsInfo;>;"
    .local p5, "sparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lorg/litepal/crud/DataHandler$QueryInfoCache;>;"
    move-object/from16 v7, p0

    move-object/from16 v8, p4

    move-object/from16 v9, p5

    invoke-virtual/range {p5 .. p5}, Landroid/util/SparseArray;->size()I

    move-result v10

    .line 723
    .local v10, "cacheSize":I
    const/4 v11, -0x1

    if-lez v10, :cond_1

    .line 724
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v10, :cond_0

    .line 725
    invoke-virtual {v9, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v12

    .line 726
    .local v12, "columnIndex":I
    invoke-virtual {v9, v12}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    move-object v13, v1

    check-cast v13, Lorg/litepal/crud/DataHandler$QueryInfoCache;

    .line 727
    .local v13, "cache":Lorg/litepal/crud/DataHandler$QueryInfoCache;
    iget-object v3, v13, Lorg/litepal/crud/DataHandler$QueryInfoCache;->field:Ljava/lang/reflect/Field;

    iget-object v5, v13, Lorg/litepal/crud/DataHandler$QueryInfoCache;->getMethodName:Ljava/lang/String;

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move v4, v12

    move-object/from16 v6, p4

    invoke-direct/range {v1 .. v6}, Lorg/litepal/crud/DataHandler;->setToModelByReflection(Ljava/lang/Object;Ljava/lang/reflect/Field;ILjava/lang/String;Landroid/database/Cursor;)V

    .line 724
    .end local v12    # "columnIndex":I
    .end local v13    # "cache":Lorg/litepal/crud/DataHandler$QueryInfoCache;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    goto :goto_4

    .line 730
    .end local v0    # "i":I
    :cond_1
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v12, v1

    check-cast v12, Ljava/lang/reflect/Field;

    .line 731
    .local v12, "field":Ljava/lang/reflect/Field;
    invoke-direct {v7, v12}, Lorg/litepal/crud/DataHandler;->genGetColumnMethod(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v13

    .line 732
    .local v13, "getMethodName":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Lorg/litepal/crud/DataHandler;->isIdColumn(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "id"

    goto :goto_2

    :cond_2
    invoke-virtual {v12}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v1

    :goto_2
    move-object v14, v1

    .line 733
    .local v14, "columnName":Ljava/lang/String;
    invoke-static {v14}, Lorg/litepal/util/BaseUtility;->changeCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v15

    .line 734
    .local v15, "columnIndex":I
    if-eq v15, v11, :cond_3

    .line 735
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object v3, v12

    move v4, v15

    move-object v5, v13

    move-object/from16 v6, p4

    invoke-direct/range {v1 .. v6}, Lorg/litepal/crud/DataHandler;->setToModelByReflection(Ljava/lang/Object;Ljava/lang/reflect/Field;ILjava/lang/String;Landroid/database/Cursor;)V

    .line 736
    new-instance v1, Lorg/litepal/crud/DataHandler$QueryInfoCache;

    invoke-direct {v1, v7}, Lorg/litepal/crud/DataHandler$QueryInfoCache;-><init>(Lorg/litepal/crud/DataHandler;)V

    .line 737
    .local v1, "cache":Lorg/litepal/crud/DataHandler$QueryInfoCache;
    iput-object v13, v1, Lorg/litepal/crud/DataHandler$QueryInfoCache;->getMethodName:Ljava/lang/String;

    .line 738
    iput-object v12, v1, Lorg/litepal/crud/DataHandler$QueryInfoCache;->field:Ljava/lang/reflect/Field;

    .line 739
    invoke-virtual {v9, v15, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_3

    .line 734
    .end local v1    # "cache":Lorg/litepal/crud/DataHandler$QueryInfoCache;
    :cond_3
    nop

    .line 741
    .end local v12    # "field":Ljava/lang/reflect/Field;
    .end local v13    # "getMethodName":Ljava/lang/String;
    .end local v14    # "columnName":Ljava/lang/String;
    .end local v15    # "columnIndex":I
    :goto_3
    goto :goto_1

    .line 730
    :cond_4
    nop

    .line 744
    .end local v0    # "i$":Ljava/util/Iterator;
    :goto_4
    if-eqz p3, :cond_8

    .line 745
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Lorg/litepal/crud/model/AssociationsInfo;

    .line 746
    .local v2, "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/litepal/util/DBUtility;->getTableNameByClassName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Lorg/litepal/crud/DataHandler;->getForeignKeyColumnName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 748
    .local v3, "foreignKeyColumn":Ljava/lang/String;
    invoke-interface {v8, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    .line 749
    .local v4, "columnIndex":I
    if-eq v4, v11, :cond_6

    .line 750
    invoke-interface {v8, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    .line 752
    .local v5, "associatedClassId":J
    :try_start_0
    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0, v5, v6}, Lorg/litepal/crud/DataSupport;->find(Ljava/lang/Class;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/litepal/crud/DataSupport;

    .line 755
    .local v0, "associatedObj":Lorg/litepal/crud/DataSupport;
    if-eqz v0, :cond_5

    .line 756
    move-object/from16 v12, p1

    check-cast v12, Lorg/litepal/crud/DataSupport;

    invoke-virtual {v2}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;

    move-result-object v13

    invoke-virtual {v7, v12, v13, v0}, Lorg/litepal/crud/DataHandler;->putSetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_6

    .line 755
    :cond_5
    nop

    .line 761
    .end local v0    # "associatedObj":Lorg/litepal/crud/DataSupport;
    :goto_6
    goto :goto_7

    .line 759
    :catch_0
    move-exception v0

    .line 760
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->printStackTrace()V

    goto :goto_7

    .line 749
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    .end local v5    # "associatedClassId":J
    :cond_6
    nop

    .line 763
    .end local v2    # "associationInfo":Lorg/litepal/crud/model/AssociationsInfo;
    .end local v3    # "foreignKeyColumn":Ljava/lang/String;
    .end local v4    # "columnIndex":I
    :goto_7
    goto :goto_5

    .line 745
    :cond_7
    goto :goto_8

    .line 744
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_8
    nop

    .line 765
    :goto_8
    return-void
.end method

.method protected shouldGetOrSet(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Z
    .locals 1
    .param p1, "dataSupport"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;

    .line 594
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected takeGetMethodValueByField(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    .locals 3
    .param p1, "dataSupport"    # Lorg/litepal/crud/DataSupport;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .line 319
    invoke-virtual {p0, p1, p2}, Lorg/litepal/crud/DataHandler;->shouldGetOrSet(Lorg/litepal/crud/DataSupport;Ljava/lang/reflect/Field;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 320
    invoke-direct {p0, p2}, Lorg/litepal/crud/DataHandler;->makeGetterMethodName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v0

    .line 321
    .local v0, "getMethodName":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {p1, v0, v1, v2, v1}, Lorg/litepal/crud/DynamicExecutor;->send(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 324
    .end local v0    # "getMethodName":Ljava/lang/String;
    :cond_0
    return-object v1
.end method
