.class public Lorg/litepal/tablemanager/model/ColumnModel;
.super Ljava/lang/Object;
.source "ColumnModel.java"


# instance fields
.field private columnName:Ljava/lang/String;

.field private columnType:Ljava/lang/String;

.field private defaultValue:Ljava/lang/String;

.field private isNullable:Z

.field private isUnique:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable:Z

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique:Z

    .line 52
    const-string v0, ""

    iput-object v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->defaultValue:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getColumnName()Ljava/lang/String;
    .locals 1

    .line 55
    iget-object v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnName:Ljava/lang/String;

    return-object v0
.end method

.method public getColumnType()Ljava/lang/String;
    .locals 1

    .line 63
    iget-object v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnType:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultValue()Ljava/lang/String;
    .locals 1

    .line 87
    iget-object v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->defaultValue:Ljava/lang/String;

    return-object v0
.end method

.method public isIdColumn()Z
    .locals 2

    .line 105
    const-string v0, "_id"

    iget-object v1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "id"

    iget-object v1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

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

.method public isNullable()Z
    .locals 1

    .line 71
    iget-boolean v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable:Z

    return v0
.end method

.method public isUnique()Z
    .locals 1

    .line 79
    iget-boolean v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique:Z

    return v0
.end method

.method public setColumnName(Ljava/lang/String;)V
    .locals 0
    .param p1, "columnName"    # Ljava/lang/String;

    .line 59
    iput-object p1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnName:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setColumnType(Ljava/lang/String;)V
    .locals 0
    .param p1, "columnType"    # Ljava/lang/String;

    .line 67
    iput-object p1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnType:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setDefaultValue(Ljava/lang/String;)V
    .locals 2
    .param p1, "defaultValue"    # Ljava/lang/String;

    .line 91
    const-string v0, "text"

    iget-object v1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->columnType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 92
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 93
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/tablemanager/model/ColumnModel;->defaultValue:Ljava/lang/String;

    goto :goto_0

    .line 92
    :cond_0
    goto :goto_0

    .line 96
    :cond_1
    iput-object p1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->defaultValue:Ljava/lang/String;

    .line 98
    :goto_0
    return-void
.end method

.method public setIsNullable(Z)V
    .locals 0
    .param p1, "isNullable"    # Z

    .line 75
    iput-boolean p1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isNullable:Z

    .line 76
    return-void
.end method

.method public setIsUnique(Z)V
    .locals 0
    .param p1, "isUnique"    # Z

    .line 83
    iput-boolean p1, p0, Lorg/litepal/tablemanager/model/ColumnModel;->isUnique:Z

    .line 84
    return-void
.end method
