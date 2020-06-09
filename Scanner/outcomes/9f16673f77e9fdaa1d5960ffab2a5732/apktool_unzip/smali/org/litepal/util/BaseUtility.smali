.class public Lorg/litepal/util/BaseUtility;
.super Ljava/lang/Object;
.source "BaseUtility.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    return-void
.end method

.method public static capitalize(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "string"    # Ljava/lang/String;

    .line 105
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 106
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 108
    :cond_0
    if-nez p0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const-string v0, ""

    :goto_0
    return-object v0
.end method

.method public static changeCase(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "string"    # Ljava/lang/String;

    .line 53
    if-eqz p0, :cond_2

    .line 54
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    .line 55
    .local v0, "litePalAttr":Lorg/litepal/parser/LitePalAttr;
    invoke-virtual {v0}, Lorg/litepal/parser/LitePalAttr;->getCases()Ljava/lang/String;

    move-result-object v1

    .line 56
    .local v1, "cases":Ljava/lang/String;
    const-string v2, "keep"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 57
    return-object p0

    .line 58
    :cond_0
    const-string v2, "upper"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 59
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 61
    :cond_1
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 63
    .end local v0    # "litePalAttr":Lorg/litepal/parser/LitePalAttr;
    .end local v1    # "cases":Ljava/lang/String;
    :cond_2
    const/4 v0, 0x0

    return-object v0
.end method

.method public static varargs checkConditionsCorrect([Ljava/lang/String;)V
    .locals 5
    .param p0, "conditions"    # [Ljava/lang/String;

    .line 145
    if-eqz p0, :cond_2

    .line 146
    array-length v0, p0

    .line 147
    .local v0, "conditionsSize":I
    if-lez v0, :cond_1

    .line 148
    const/4 v1, 0x0

    aget-object v1, p0, v1

    .line 149
    .local v1, "whereClause":Ljava/lang/String;
    const-string v2, "?"

    invoke-static {v1, v2}, Lorg/litepal/util/BaseUtility;->count(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 150
    .local v2, "placeHolderSize":I
    add-int/lit8 v3, v2, 0x1

    if-ne v0, v3, :cond_0

    goto :goto_0

    .line 151
    :cond_0
    new-instance v3, Lorg/litepal/exceptions/DataSupportException;

    const-string v4, "The parameters in conditions are incorrect."

    invoke-direct {v3, v4}, Lorg/litepal/exceptions/DataSupportException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 147
    .end local v1    # "whereClause":Ljava/lang/String;
    .end local v2    # "placeHolderSize":I
    :cond_1
    goto :goto_0

    .line 145
    .end local v0    # "conditionsSize":I
    :cond_2
    nop

    .line 155
    :goto_0
    return-void
.end method

.method public static containsIgnoreCases(Ljava/util/Collection;Ljava/lang/String;)Z
    .locals 4
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .line 81
    .local p0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    if-nez p0, :cond_0

    .line 82
    const/4 v0, 0x0

    return v0

    .line 84
    :cond_0
    if-nez p1, :cond_1

    .line 85
    const/4 v0, 0x0

    invoke-interface {p0, v0}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0

    .line 87
    :cond_1
    const/4 v0, 0x0

    .line 88
    .local v0, "contains":Z
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 89
    .local v2, "element":Ljava/lang/String;
    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 90
    const/4 v0, 0x1

    .line 91
    goto :goto_1

    .line 89
    :cond_2
    nop

    .line 93
    .end local v2    # "element":Ljava/lang/String;
    goto :goto_0

    .line 88
    :cond_3
    nop

    .line 94
    .end local v1    # "i$":Ljava/util/Iterator;
    :goto_1
    return v0
.end method

.method public static count(Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "mark"    # Ljava/lang/String;

    .line 121
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 122
    const/4 v0, 0x0

    .line 123
    .local v0, "count":I
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 124
    .local v1, "index":I
    :goto_0
    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 125
    add-int/lit8 v0, v0, 0x1

    .line 126
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v1

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 127
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    goto :goto_0

    .line 129
    :cond_0
    return v0

    .line 121
    .end local v0    # "count":I
    .end local v1    # "index":I
    :cond_1
    nop

    .line 131
    const/4 v0, 0x0

    return v0
.end method

.method public static isFieldTypeSupported(Ljava/lang/String;)Z
    .locals 2
    .param p0, "fieldType"    # Ljava/lang/String;

    .line 166
    const-string v0, "boolean"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_11

    const-string v0, "java.lang.Boolean"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_8

    .line 169
    :cond_0
    const-string v0, "float"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    const-string v0, "java.lang.Float"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    goto/16 :goto_7

    .line 172
    :cond_1
    const-string v0, "double"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_f

    const-string v0, "java.lang.Double"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto/16 :goto_6

    .line 175
    :cond_2
    const-string v0, "int"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    const-string v0, "java.lang.Integer"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    goto :goto_5

    .line 178
    :cond_3
    const-string v0, "long"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    const-string v0, "java.lang.Long"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    goto :goto_4

    .line 181
    :cond_4
    const-string v0, "short"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_c

    const-string v0, "java.lang.Short"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    goto :goto_3

    .line 184
    :cond_5
    const-string v0, "char"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "java.lang.Character"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    goto :goto_2

    .line 187
    :cond_6
    const-string v0, "[B"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "[Ljava.lang.Byte;"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    goto :goto_1

    .line 190
    :cond_7
    const-string v0, "java.lang.String"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "java.util.Date"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    goto :goto_0

    .line 193
    :cond_8
    const/4 v0, 0x0

    return v0

    .line 190
    :cond_9
    :goto_0
    nop

    .line 191
    return v1

    .line 187
    :cond_a
    :goto_1
    nop

    .line 188
    return v1

    .line 184
    :cond_b
    :goto_2
    nop

    .line 185
    return v1

    .line 181
    :cond_c
    :goto_3
    nop

    .line 182
    return v1

    .line 178
    :cond_d
    :goto_4
    nop

    .line 179
    return v1

    .line 175
    :cond_e
    :goto_5
    nop

    .line 176
    return v1

    .line 172
    :cond_f
    :goto_6
    nop

    .line 173
    return v1

    .line 169
    :cond_10
    :goto_7
    nop

    .line 170
    return v1

    .line 166
    :cond_11
    :goto_8
    nop

    .line 167
    return v1
.end method
