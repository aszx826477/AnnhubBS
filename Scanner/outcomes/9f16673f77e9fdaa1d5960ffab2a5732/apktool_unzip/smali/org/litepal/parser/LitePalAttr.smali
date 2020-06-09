.class public final Lorg/litepal/parser/LitePalAttr;
.super Ljava/lang/Object;
.source "LitePalAttr.java"


# static fields
.field private static litePalAttr:Lorg/litepal/parser/LitePalAttr;


# instance fields
.field private cases:Ljava/lang/String;

.field private classNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private dbName:Ljava/lang/String;

.field private storage:Ljava/lang/String;

.field private version:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    return-void
.end method

.method public static getInstance()Lorg/litepal/parser/LitePalAttr;
    .locals 2

    .line 81
    sget-object v0, Lorg/litepal/parser/LitePalAttr;->litePalAttr:Lorg/litepal/parser/LitePalAttr;

    if-nez v0, :cond_1

    .line 82
    const-class v0, Lorg/litepal/parser/LitePalAttr;

    monitor-enter v0

    .line 83
    :try_start_0
    sget-object v1, Lorg/litepal/parser/LitePalAttr;->litePalAttr:Lorg/litepal/parser/LitePalAttr;

    if-nez v1, :cond_0

    .line 84
    new-instance v1, Lorg/litepal/parser/LitePalAttr;

    invoke-direct {v1}, Lorg/litepal/parser/LitePalAttr;-><init>()V

    sput-object v1, Lorg/litepal/parser/LitePalAttr;->litePalAttr:Lorg/litepal/parser/LitePalAttr;

    goto :goto_0

    .line 83
    :cond_0
    nop

    .line 86
    :goto_0
    monitor-exit v0

    goto :goto_1

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 81
    :cond_1
    nop

    .line 88
    :goto_1
    sget-object v0, Lorg/litepal/parser/LitePalAttr;->litePalAttr:Lorg/litepal/parser/LitePalAttr;

    return-object v0
.end method


# virtual methods
.method addClassName(Ljava/lang/String;)V
    .locals 1
    .param p1, "className"    # Ljava/lang/String;

    .line 137
    invoke-virtual {p0}, Lorg/litepal/parser/LitePalAttr;->getClassNames()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    return-void
.end method

.method public checkSelfValid()Z
    .locals 3

    .line 160
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 164
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    const-string v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 165
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    goto :goto_0

    .line 164
    :cond_0
    nop

    .line 167
    :goto_0
    iget v0, p0, Lorg/litepal/parser/LitePalAttr;->version:I

    const/4 v1, 0x1

    if-lt v0, v1, :cond_5

    .line 171
    invoke-static {}, Lorg/litepal/util/SharedUtil;->getLastVersion()I

    move-result v2

    if-lt v0, v2, :cond_4

    .line 175
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 176
    const-string v0, "lower"

    iput-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    goto :goto_2

    .line 178
    :cond_1
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    const-string v2, "upper"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    const-string v2, "lower"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    const-string v2, "keep"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_1

    .line 181
    :cond_2
    new-instance v0, Lorg/litepal/exceptions/InvalidAttributesException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " is an invalid value for <cases></cases>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/InvalidAttributesException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_3
    :goto_1
    nop

    .line 185
    :goto_2
    return v1

    .line 172
    :cond_4
    new-instance v0, Lorg/litepal/exceptions/InvalidAttributesException;

    const-string v1, "the version in litepal.xml is earlier than the current version"

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/InvalidAttributesException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 168
    :cond_5
    new-instance v0, Lorg/litepal/exceptions/InvalidAttributesException;

    const-string v1, "the version of database can not be less than 1"

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/InvalidAttributesException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 161
    :cond_6
    new-instance v0, Lorg/litepal/exceptions/InvalidAttributesException;

    const-string v1, "dbname is empty or not defined in litepal.xml file"

    invoke-direct {v0, v1}, Lorg/litepal/exceptions/InvalidAttributesException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getCases()Ljava/lang/String;
    .locals 1

    .line 141
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    return-object v0
.end method

.method public getClassNames()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 121
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->classNames:Ljava/util/List;

    if-nez v0, :cond_0

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/litepal/parser/LitePalAttr;->classNames:Ljava/util/List;

    .line 123
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->classNames:Ljava/util/List;

    const-string v1, "org.litepal.model.Table_Schema"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 124
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 125
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->classNames:Ljava/util/List;

    const-string v1, "org.litepal.model.Table_Schema"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 124
    :cond_1
    nop

    .line 127
    :goto_0
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->classNames:Ljava/util/List;

    return-object v0
.end method

.method public getDbName()Ljava/lang/String;
    .locals 1

    .line 100
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    return-object v0
.end method

.method public getStorage()Ljava/lang/String;
    .locals 1

    .line 108
    iget-object v0, p0, Lorg/litepal/parser/LitePalAttr;->storage:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 92
    iget v0, p0, Lorg/litepal/parser/LitePalAttr;->version:I

    return v0
.end method

.method setCases(Ljava/lang/String;)V
    .locals 0
    .param p1, "cases"    # Ljava/lang/String;

    .line 145
    iput-object p1, p0, Lorg/litepal/parser/LitePalAttr;->cases:Ljava/lang/String;

    .line 146
    return-void
.end method

.method setDbName(Ljava/lang/String;)V
    .locals 0
    .param p1, "dbName"    # Ljava/lang/String;

    .line 104
    iput-object p1, p0, Lorg/litepal/parser/LitePalAttr;->dbName:Ljava/lang/String;

    .line 105
    return-void
.end method

.method setStorage(Ljava/lang/String;)V
    .locals 0
    .param p1, "storage"    # Ljava/lang/String;

    .line 112
    iput-object p1, p0, Lorg/litepal/parser/LitePalAttr;->storage:Ljava/lang/String;

    .line 113
    return-void
.end method

.method setVersion(I)V
    .locals 0
    .param p1, "version"    # I

    .line 96
    iput p1, p0, Lorg/litepal/parser/LitePalAttr;->version:I

    .line 97
    return-void
.end method
