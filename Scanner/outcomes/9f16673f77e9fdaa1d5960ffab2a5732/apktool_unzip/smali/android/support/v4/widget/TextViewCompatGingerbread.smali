.class Landroid/support/v4/widget/TextViewCompatGingerbread;
.super Ljava/lang/Object;
.source "TextViewCompatGingerbread.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x9
.end annotation

.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x9
.end annotation


# static fields
.field private static final LINES:I = 0x1

.field private static final LOG_TAG:Ljava/lang/String; = "TextViewCompatGingerbread"

.field private static sMaxModeField:Ljava/lang/reflect/Field;

.field private static sMaxModeFieldFetched:Z

.field private static sMaximumField:Ljava/lang/reflect/Field;

.field private static sMaximumFieldFetched:Z

.field private static sMinModeField:Ljava/lang/reflect/Field;

.field private static sMinModeFieldFetched:Z

.field private static sMinimumField:Ljava/lang/reflect/Field;

.field private static sMinimumFieldFetched:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "textView"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 107
    invoke-virtual {p0}, Landroid/widget/TextView;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method static getMaxLines(Landroid/widget/TextView;)I
    .locals 2
    .param p0, "textView"    # Landroid/widget/TextView;

    .line 47
    sget-boolean v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaxModeFieldFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 48
    const-string v0, "mMaxMode"

    invoke-static {v0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaxModeField:Ljava/lang/reflect/Field;

    .line 49
    sput-boolean v1, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaxModeFieldFetched:Z

    goto :goto_0

    .line 47
    :cond_0
    nop

    .line 51
    :goto_0
    sget-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaxModeField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_3

    invoke-static {v0, p0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveIntFromField(Ljava/lang/reflect/Field;Landroid/widget/TextView;)I

    move-result v0

    if-ne v0, v1, :cond_3

    .line 53
    sget-boolean v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaximumFieldFetched:Z

    if-nez v0, :cond_1

    .line 54
    const-string v0, "mMaximum"

    invoke-static {v0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaximumField:Ljava/lang/reflect/Field;

    .line 55
    sput-boolean v1, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaximumFieldFetched:Z

    goto :goto_1

    .line 53
    :cond_1
    nop

    .line 57
    :goto_1
    sget-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMaximumField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_2

    .line 58
    invoke-static {v0, p0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveIntFromField(Ljava/lang/reflect/Field;Landroid/widget/TextView;)I

    move-result v0

    return v0

    .line 57
    :cond_2
    goto :goto_2

    .line 51
    :cond_3
    nop

    .line 61
    :goto_2
    const/4 v0, -0x1

    return v0
.end method

.method static getMinLines(Landroid/widget/TextView;)I
    .locals 2
    .param p0, "textView"    # Landroid/widget/TextView;

    .line 65
    sget-boolean v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinModeFieldFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 66
    const-string v0, "mMinMode"

    invoke-static {v0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinModeField:Ljava/lang/reflect/Field;

    .line 67
    sput-boolean v1, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinModeFieldFetched:Z

    goto :goto_0

    .line 65
    :cond_0
    nop

    .line 69
    :goto_0
    sget-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinModeField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_3

    invoke-static {v0, p0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveIntFromField(Ljava/lang/reflect/Field;Landroid/widget/TextView;)I

    move-result v0

    if-ne v0, v1, :cond_3

    .line 71
    sget-boolean v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinimumFieldFetched:Z

    if-nez v0, :cond_1

    .line 72
    const-string v0, "mMinimum"

    invoke-static {v0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinimumField:Ljava/lang/reflect/Field;

    .line 73
    sput-boolean v1, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinimumFieldFetched:Z

    goto :goto_1

    .line 71
    :cond_1
    nop

    .line 75
    :goto_1
    sget-object v0, Landroid/support/v4/widget/TextViewCompatGingerbread;->sMinimumField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_2

    .line 76
    invoke-static {v0, p0}, Landroid/support/v4/widget/TextViewCompatGingerbread;->retrieveIntFromField(Ljava/lang/reflect/Field;Landroid/widget/TextView;)I

    move-result v0

    return v0

    .line 75
    :cond_2
    goto :goto_2

    .line 69
    :cond_3
    nop

    .line 79
    :goto_2
    const/4 v0, -0x1

    return v0
.end method

.method private static retrieveField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 5
    .param p0, "fieldName"    # Ljava/lang/String;

    .line 83
    const/4 v0, 0x0

    .line 85
    .local v0, "field":Ljava/lang/reflect/Field;
    :try_start_0
    const-class v1, Landroid/widget/TextView;

    invoke-virtual {v1, p0}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    move-object v0, v1

    .line 86
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    .line 89
    goto :goto_0

    .line 87
    :catch_0
    move-exception v1

    .line 88
    .local v1, "e":Ljava/lang/NoSuchFieldException;
    const-string v2, "TextViewCompatGingerbread"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not retrieve "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " field."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    .end local v1    # "e":Ljava/lang/NoSuchFieldException;
    :goto_0
    return-object v0
.end method

.method private static retrieveIntFromField(Ljava/lang/reflect/Field;Landroid/widget/TextView;)I
    .locals 4
    .param p0, "field"    # Ljava/lang/reflect/Field;
    .param p1, "textView"    # Landroid/widget/TextView;

    .line 95
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v0
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0

    return v0

    .line 96
    :catch_0
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/IllegalAccessException;
    const-string v1, "TextViewCompatGingerbread"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not retrieve value of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " field."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    const/4 v0, -0x1

    return v0
.end method

.method static setTextAppearance(Landroid/widget/TextView;I)V
    .locals 1
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "resId"    # I

    .line 103
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 104
    return-void
.end method
