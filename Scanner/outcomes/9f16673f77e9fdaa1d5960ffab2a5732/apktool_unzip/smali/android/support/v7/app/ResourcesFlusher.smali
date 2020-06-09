.class Landroid/support/v7/app/ResourcesFlusher;
.super Ljava/lang/Object;
.source "ResourcesFlusher.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "ResourcesFlusher"

.field private static sDrawableCacheField:Ljava/lang/reflect/Field;

.field private static sDrawableCacheFieldFetched:Z

.field private static sResourcesImplField:Ljava/lang/reflect/Field;

.field private static sResourcesImplFieldFetched:Z

.field private static sThemedResourceCacheClazz:Ljava/lang/Class;

.field private static sThemedResourceCacheClazzFetched:Z

.field private static sThemedResourceCache_mUnthemedEntriesField:Ljava/lang/reflect/Field;

.field private static sThemedResourceCache_mUnthemedEntriesFieldFetched:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static flush(Landroid/content/res/Resources;)Z
    .locals 2
    .param p0, "resources"    # Landroid/content/res/Resources;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 44
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 45
    .local v0, "sdk":I
    const/16 v1, 0x18

    if-lt v0, v1, :cond_0

    .line 46
    invoke-static {p0}, Landroid/support/v7/app/ResourcesFlusher;->flushNougats(Landroid/content/res/Resources;)Z

    move-result v1

    return v1

    .line 47
    :cond_0
    const/16 v1, 0x17

    if-lt v0, v1, :cond_1

    .line 48
    invoke-static {p0}, Landroid/support/v7/app/ResourcesFlusher;->flushMarshmallows(Landroid/content/res/Resources;)Z

    move-result v1

    return v1

    .line 49
    :cond_1
    const/16 v1, 0x15

    if-lt v0, v1, :cond_2

    .line 50
    invoke-static {p0}, Landroid/support/v7/app/ResourcesFlusher;->flushLollipops(Landroid/content/res/Resources;)Z

    move-result v1

    return v1

    .line 52
    :cond_2
    const/4 v1, 0x0

    return v1
.end method

.method private static flushLollipops(Landroid/content/res/Resources;)Z
    .locals 5
    .param p0, "resources"    # Landroid/content/res/Resources;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 56
    sget-boolean v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 58
    :try_start_0
    const-class v0, Landroid/content/res/Resources;

    const-string v2, "mDrawableCache"

    invoke-virtual {v0, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    .line 59
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    goto :goto_0

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    const-string v2, "ResourcesFlusher"

    const-string v3, "Could not retrieve Resources#mDrawableCache field"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 63
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :goto_0
    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    goto :goto_1

    .line 56
    :cond_0
    nop

    .line 65
    :goto_1
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_2

    .line 66
    const/4 v2, 0x0

    .line 68
    .local v2, "drawableCache":Ljava/util/Map;
    nop

    :try_start_1
    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    nop

    check-cast v0, Ljava/util/Map;
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1

    nop

    move-object v2, v0

    .line 71
    nop

    goto :goto_2

    .line 69
    :catch_1
    move-exception v0

    nop

    .line 70
    .local v0, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v3, "ResourcesFlusher"

    const-string v4, "Could not retrieve value from Resources#mDrawableCache"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 72
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :goto_2
    nop

    if-eqz v2, :cond_1

    .line 73
    nop

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 74
    nop

    return v1

    .line 72
    :cond_1
    nop

    goto :goto_3

    .line 65
    .end local v2    # "drawableCache":Ljava/util/Map;
    :cond_2
    nop

    .line 77
    :goto_3
    nop

    const/4 v0, 0x0

    return v0
.end method

.method private static flushMarshmallows(Landroid/content/res/Resources;)Z
    .locals 5
    .param p0, "resources"    # Landroid/content/res/Resources;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 81
    sget-boolean v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 83
    :try_start_0
    const-class v0, Landroid/content/res/Resources;

    const-string v2, "mDrawableCache"

    invoke-virtual {v0, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    .line 84
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    goto :goto_0

    .line 85
    :catch_0
    move-exception v0

    .line 86
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    const-string v2, "ResourcesFlusher"

    const-string v3, "Could not retrieve Resources#mDrawableCache field"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 88
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :goto_0
    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    goto :goto_1

    .line 81
    :cond_0
    nop

    .line 91
    :goto_1
    const/4 v0, 0x0

    .line 92
    .local v0, "drawableCache":Ljava/lang/Object;
    sget-object v2, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    if-eqz v2, :cond_1

    .line 94
    nop

    :try_start_1
    invoke-virtual {v2, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1

    nop

    move-object v0, v2

    .line 97
    nop

    goto :goto_2

    .line 95
    :catch_1
    move-exception v2

    nop

    .line 96
    .local v2, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v3, "ResourcesFlusher"

    const-string v4, "Could not retrieve value from Resources#mDrawableCache"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 92
    .end local v2    # "e":Ljava/lang/IllegalAccessException;
    :cond_1
    nop

    .line 100
    :goto_2
    nop

    const/4 v2, 0x0

    if-nez v0, :cond_2

    .line 102
    nop

    return v2

    .line 105
    :cond_2
    nop

    if-eqz v0, :cond_3

    nop

    invoke-static {v0}, Landroid/support/v7/app/ResourcesFlusher;->flushThemedResourcesCache(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    nop

    goto :goto_3

    :cond_3
    nop

    nop

    const/4 v1, 0x0

    :goto_3
    nop

    return v1
.end method

.method private static flushNougats(Landroid/content/res/Resources;)Z
    .locals 7
    .param p0, "resources"    # Landroid/content/res/Resources;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 109
    sget-boolean v0, Landroid/support/v7/app/ResourcesFlusher;->sResourcesImplFieldFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 111
    :try_start_0
    const-class v0, Landroid/content/res/Resources;

    const-string v2, "mResourcesImpl"

    invoke-virtual {v0, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sResourcesImplField:Ljava/lang/reflect/Field;

    .line 112
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sResourcesImplField:Ljava/lang/reflect/Field;

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    goto :goto_0

    .line 113
    :catch_0
    move-exception v0

    .line 114
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    const-string v2, "ResourcesFlusher"

    const-string v3, "Could not retrieve Resources#mResourcesImpl field"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 116
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :goto_0
    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sResourcesImplFieldFetched:Z

    goto :goto_1

    .line 109
    :cond_0
    nop

    .line 119
    :goto_1
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sResourcesImplField:Ljava/lang/reflect/Field;

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 121
    return v2

    .line 124
    :cond_1
    const/4 v3, 0x0

    .line 126
    .local v3, "resourcesImpl":Ljava/lang/Object;
    nop

    :try_start_1
    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1

    nop

    move-object v3, v0

    .line 129
    nop

    goto :goto_2

    .line 127
    :catch_1
    move-exception v0

    nop

    .line 128
    .local v0, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v4, "ResourcesFlusher"

    const-string v5, "Could not retrieve value from Resources#mResourcesImpl"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 131
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :goto_2
    nop

    if-nez v3, :cond_2

    .line 133
    nop

    return v2

    .line 136
    :cond_2
    nop

    sget-boolean v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    if-nez v0, :cond_3

    .line 138
    nop

    :try_start_2
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    nop

    const-string v4, "mDrawableCache"

    nop

    invoke-virtual {v0, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    nop

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    .line 139
    nop

    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    nop

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_2
    .catch Ljava/lang/NoSuchFieldException; {:try_start_2 .. :try_end_2} :catch_2

    .line 142
    nop

    goto :goto_3

    .line 140
    :catch_2
    move-exception v0

    nop

    .line 141
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    nop

    const-string v4, "ResourcesFlusher"

    const-string v5, "Could not retrieve ResourcesImpl#mDrawableCache field"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 143
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :goto_3
    nop

    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheFieldFetched:Z

    goto :goto_4

    .line 136
    :cond_3
    nop

    .line 146
    :goto_4
    nop

    const/4 v0, 0x0

    .line 147
    .local v0, "drawableCache":Ljava/lang/Object;
    nop

    sget-object v4, Landroid/support/v7/app/ResourcesFlusher;->sDrawableCacheField:Ljava/lang/reflect/Field;

    if-eqz v4, :cond_4

    .line 149
    nop

    nop

    :try_start_3
    invoke-virtual {v4, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4
    :try_end_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_3 .. :try_end_3} :catch_3

    nop

    move-object v0, v4

    .line 152
    nop

    goto :goto_5

    .line 150
    :catch_3
    move-exception v4

    nop

    .line 151
    .local v4, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v5, "ResourcesFlusher"

    const-string v6, "Could not retrieve value from ResourcesImpl#mDrawableCache"

    invoke-static {v5, v6, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5

    .line 147
    .end local v4    # "e":Ljava/lang/IllegalAccessException;
    :cond_4
    nop

    .line 155
    :goto_5
    nop

    if-eqz v0, :cond_5

    nop

    invoke-static {v0}, Landroid/support/v7/app/ResourcesFlusher;->flushThemedResourcesCache(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    nop

    goto :goto_6

    :cond_5
    nop

    nop

    const/4 v1, 0x0

    :goto_6
    nop

    return v1
.end method

.method private static flushThemedResourcesCache(Ljava/lang/Object;)Z
    .locals 6
    .param p0, "cache"    # Ljava/lang/Object;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 159
    sget-boolean v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCacheClazzFetched:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 161
    :try_start_0
    const-string v0, "android.content.res.ThemedResourceCache"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCacheClazz:Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 164
    goto :goto_0

    .line 162
    :catch_0
    move-exception v0

    .line 163
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const-string v2, "ResourcesFlusher"

    const-string v3, "Could not find ThemedResourceCache class"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 165
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCacheClazzFetched:Z

    goto :goto_1

    .line 159
    :cond_0
    nop

    .line 168
    :goto_1
    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCacheClazz:Ljava/lang/Class;

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 170
    return v2

    .line 173
    :cond_1
    sget-boolean v3, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCache_mUnthemedEntriesFieldFetched:Z

    if-nez v3, :cond_2

    .line 175
    nop

    :try_start_1
    const-string v3, "mUnthemedEntries"

    .line 176
    nop

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    nop

    sput-object v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCache_mUnthemedEntriesField:Ljava/lang/reflect/Field;

    .line 177
    nop

    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCache_mUnthemedEntriesField:Ljava/lang/reflect/Field;

    nop

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_1

    .line 180
    nop

    goto :goto_2

    .line 178
    :catch_1
    move-exception v0

    nop

    .line 179
    .local v0, "ee":Ljava/lang/NoSuchFieldException;
    nop

    const-string v3, "ResourcesFlusher"

    const-string v4, "Could not retrieve ThemedResourceCache#mUnthemedEntries field"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 181
    .end local v0    # "ee":Ljava/lang/NoSuchFieldException;
    :goto_2
    nop

    sput-boolean v1, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCache_mUnthemedEntriesFieldFetched:Z

    goto :goto_3

    .line 173
    :cond_2
    nop

    .line 184
    :goto_3
    nop

    sget-object v0, Landroid/support/v7/app/ResourcesFlusher;->sThemedResourceCache_mUnthemedEntriesField:Ljava/lang/reflect/Field;

    if-nez v0, :cond_3

    .line 186
    nop

    return v2

    .line 189
    :cond_3
    nop

    const/4 v3, 0x0

    .line 191
    .local v3, "unthemedEntries":Landroid/util/LongSparseArray;
    nop

    .line 192
    nop

    :try_start_2
    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    nop

    check-cast v0, Landroid/util/LongSparseArray;
    :try_end_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_2 .. :try_end_2} :catch_2

    nop

    move-object v3, v0

    .line 195
    nop

    goto :goto_4

    .line 193
    :catch_2
    move-exception v0

    nop

    .line 194
    .local v0, "e":Ljava/lang/IllegalAccessException;
    nop

    const-string v4, "ResourcesFlusher"

    const-string v5, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 197
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :goto_4
    nop

    if-eqz v3, :cond_4

    .line 198
    nop

    invoke-virtual {v3}, Landroid/util/LongSparseArray;->clear()V

    .line 199
    nop

    return v1

    .line 201
    :cond_4
    nop

    return v2
.end method
