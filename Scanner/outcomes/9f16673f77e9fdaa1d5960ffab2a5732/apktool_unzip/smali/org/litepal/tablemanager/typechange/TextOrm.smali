.class public Lorg/litepal/tablemanager/typechange/TextOrm;
.super Lorg/litepal/tablemanager/typechange/OrmChange;
.source "TextOrm.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25
    invoke-direct {p0}, Lorg/litepal/tablemanager/typechange/OrmChange;-><init>()V

    return-void
.end method


# virtual methods
.method public object2Relation(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "fieldType"    # Ljava/lang/String;

    .line 33
    if-eqz p1, :cond_3

    .line 34
    const-string v0, "char"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    const-string v0, "java.lang.Character"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 37
    :cond_0
    const-string v0, "java.lang.String"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 38
    const-string v0, "text"

    return-object v0

    .line 37
    :cond_1
    goto :goto_1

    .line 34
    :cond_2
    :goto_0
    nop

    .line 35
    const-string v0, "text"

    return-object v0

    .line 33
    :cond_3
    nop

    .line 41
    :goto_1
    const/4 v0, 0x0

    return-object v0
.end method
