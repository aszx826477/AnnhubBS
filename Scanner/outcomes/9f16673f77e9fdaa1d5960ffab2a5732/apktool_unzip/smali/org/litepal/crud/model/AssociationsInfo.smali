.class public Lorg/litepal/crud/model/AssociationsInfo;
.super Ljava/lang/Object;
.source "AssociationsInfo.java"


# instance fields
.field private associateOtherModelFromSelf:Ljava/lang/reflect/Field;

.field private associateSelfFromOtherModel:Ljava/lang/reflect/Field;

.field private associatedClassName:Ljava/lang/String;

.field private associationType:I

.field private classHoldsForeignKey:Ljava/lang/String;

.field private selfClassName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .line 189
    instance-of v0, p1, Lorg/litepal/crud/model/AssociationsInfo;

    if-eqz v0, :cond_4

    .line 190
    move-object v0, p1

    check-cast v0, Lorg/litepal/crud/model/AssociationsInfo;

    .line 191
    .local v0, "other":Lorg/litepal/crud/model/AssociationsInfo;
    if-eqz p1, :cond_3

    if-eqz v0, :cond_3

    .line 192
    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociationType()I

    move-result v1

    iget v2, p0, Lorg/litepal/crud/model/AssociationsInfo;->associationType:I

    if-ne v1, v2, :cond_2

    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getClassHoldsForeignKey()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lorg/litepal/crud/model/AssociationsInfo;->classHoldsForeignKey:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 194
    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getSelfClassName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lorg/litepal/crud/model/AssociationsInfo;->selfClassName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lorg/litepal/crud/model/AssociationsInfo;->associatedClassName:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 196
    return v2

    .line 194
    :cond_0
    nop

    .line 198
    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getSelfClassName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lorg/litepal/crud/model/AssociationsInfo;->associatedClassName:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lorg/litepal/crud/model/AssociationsInfo;->getAssociatedClassName()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lorg/litepal/crud/model/AssociationsInfo;->selfClassName:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 200
    return v2

    .line 198
    :cond_1
    goto :goto_0

    .line 192
    :cond_2
    goto :goto_0

    .line 191
    :cond_3
    goto :goto_0

    .line 189
    .end local v0    # "other":Lorg/litepal/crud/model/AssociationsInfo;
    :cond_4
    nop

    .line 205
    :goto_0
    const/4 v0, 0x0

    return v0
.end method

.method public getAssociateOtherModelFromSelf()Ljava/lang/reflect/Field;
    .locals 1

    .line 125
    iget-object v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->associateOtherModelFromSelf:Ljava/lang/reflect/Field;

    return-object v0
.end method

.method public getAssociateSelfFromOtherModel()Ljava/lang/reflect/Field;
    .locals 1

    .line 148
    iget-object v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->associateSelfFromOtherModel:Ljava/lang/reflect/Field;

    return-object v0
.end method

.method public getAssociatedClassName()Ljava/lang/String;
    .locals 1

    .line 86
    iget-object v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->associatedClassName:Ljava/lang/String;

    return-object v0
.end method

.method public getAssociationType()I
    .locals 1

    .line 169
    iget v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->associationType:I

    return v0
.end method

.method public getClassHoldsForeignKey()Ljava/lang/String;
    .locals 1

    .line 105
    iget-object v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->classHoldsForeignKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSelfClassName()Ljava/lang/String;
    .locals 1

    .line 67
    iget-object v0, p0, Lorg/litepal/crud/model/AssociationsInfo;->selfClassName:Ljava/lang/String;

    return-object v0
.end method

.method public setAssociateOtherModelFromSelf(Ljava/lang/reflect/Field;)V
    .locals 0
    .param p1, "associateOtherModelFromSelf"    # Ljava/lang/reflect/Field;

    .line 137
    iput-object p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->associateOtherModelFromSelf:Ljava/lang/reflect/Field;

    .line 138
    return-void
.end method

.method public setAssociateSelfFromOtherModel(Ljava/lang/reflect/Field;)V
    .locals 0
    .param p1, "associateSelfFromOtherModel"    # Ljava/lang/reflect/Field;

    .line 160
    iput-object p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->associateSelfFromOtherModel:Ljava/lang/reflect/Field;

    .line 161
    return-void
.end method

.method public setAssociatedClassName(Ljava/lang/String;)V
    .locals 0
    .param p1, "associatedClassName"    # Ljava/lang/String;

    .line 96
    iput-object p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->associatedClassName:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setAssociationType(I)V
    .locals 0
    .param p1, "associationType"    # I

    .line 179
    iput p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->associationType:I

    .line 180
    return-void
.end method

.method public setClassHoldsForeignKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "classHoldsForeignKey"    # Ljava/lang/String;

    .line 115
    iput-object p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->classHoldsForeignKey:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setSelfClassName(Ljava/lang/String;)V
    .locals 0
    .param p1, "selfClassName"    # Ljava/lang/String;

    .line 77
    iput-object p1, p0, Lorg/litepal/crud/model/AssociationsInfo;->selfClassName:Ljava/lang/String;

    .line 78
    return-void
.end method
