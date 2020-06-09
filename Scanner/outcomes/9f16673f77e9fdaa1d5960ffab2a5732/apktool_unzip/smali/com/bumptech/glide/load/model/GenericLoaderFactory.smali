.class public Lcom/bumptech/glide/load/model/GenericLoaderFactory;
.super Ljava/lang/Object;
.source "GenericLoaderFactory.java"


# static fields
.field private static final NULL_MODEL_LOADER:Lcom/bumptech/glide/load/model/ModelLoader;


# instance fields
.field private final cachedModelLoaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Class;",
            "Ljava/util/Map<",
            "Ljava/lang/Class;",
            "Lcom/bumptech/glide/load/model/ModelLoader;",
            ">;>;"
        }
    .end annotation
.end field

.field private final context:Landroid/content/Context;

.field private final modelClassToResourceFactories:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Class;",
            "Ljava/util/Map<",
            "Ljava/lang/Class;",
            "Lcom/bumptech/glide/load/model/ModelLoaderFactory;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 22
    new-instance v0, Lcom/bumptech/glide/load/model/GenericLoaderFactory$1;

    invoke-direct {v0}, Lcom/bumptech/glide/load/model/GenericLoaderFactory$1;-><init>()V

    sput-object v0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->NULL_MODEL_LOADER:Lcom/bumptech/glide/load/model/ModelLoader;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    .line 19
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    .line 37
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->context:Landroid/content/Context;

    .line 38
    return-void
.end method

.method private cacheModelLoader(Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TT;TY;>;)V"
        }
    .end annotation

    .line 154
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    .local p3, "modelLoader":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TT;TY;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 155
    .local v0, "resourceToLoaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;>;"
    if-nez v0, :cond_0

    .line 156
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    move-object v0, v1

    .line 157
    iget-object v1, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 155
    :cond_0
    nop

    .line 159
    :goto_0
    invoke-interface {v0, p2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 160
    return-void
.end method

.method private cacheNullLoader(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;)V"
        }
    .end annotation

    .line 150
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    sget-object v0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->NULL_MODEL_LOADER:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-direct {p0, p1, p2, v0}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cacheModelLoader(Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;)V

    .line 151
    return-void
.end method

.method private getCachedLoader(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoader;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;)",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TT;TY;>;"
        }
    .end annotation

    .line 163
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 164
    .local v0, "resourceToLoaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;>;"
    const/4 v1, 0x0

    .line 165
    .local v1, "result":Lcom/bumptech/glide/load/model/ModelLoader;
    if-eqz v0, :cond_0

    .line 166
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v1, v2

    check-cast v1, Lcom/bumptech/glide/load/model/ModelLoader;

    goto :goto_0

    .line 165
    :cond_0
    nop

    .line 169
    :goto_0
    return-object v1
.end method

.method private getFactory(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;)",
            "Lcom/bumptech/glide/load/model/ModelLoaderFactory<",
            "TT;TY;>;"
        }
    .end annotation

    .line 173
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 174
    .local v0, "resourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    const/4 v1, 0x0

    .line 175
    .local v1, "result":Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    if-eqz v0, :cond_0

    .line 176
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v1, v2

    check-cast v1, Lcom/bumptech/glide/load/model/ModelLoaderFactory;

    goto :goto_0

    .line 175
    :cond_0
    nop

    .line 179
    :goto_0
    if-nez v1, :cond_5

    .line 180
    iget-object v2, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Class;

    .line 186
    .local v3, "registeredModelClass":Ljava/lang/Class;, "Ljava/lang/Class<-TT;>;"
    invoke-virtual {v3, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 187
    iget-object v4, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 189
    .local v4, "currentResourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    if-eqz v4, :cond_2

    .line 190
    invoke-interface {v4, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v1, v5

    check-cast v1, Lcom/bumptech/glide/load/model/ModelLoaderFactory;

    .line 191
    if-eqz v1, :cond_1

    .line 192
    goto :goto_3

    .line 191
    :cond_1
    goto :goto_2

    .line 189
    :cond_2
    goto :goto_2

    .line 186
    .end local v4    # "currentResourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    :cond_3
    nop

    .line 195
    .end local v3    # "registeredModelClass":Ljava/lang/Class;, "Ljava/lang/Class<-TT;>;"
    :goto_2
    goto :goto_1

    .line 180
    :cond_4
    goto :goto_3

    .line 179
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_5
    nop

    .line 199
    :goto_3
    return-object v1
.end method


# virtual methods
.method public declared-synchronized buildModelLoader(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoader;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;)",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TT;TY;>;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    monitor-enter p0

    .line 126
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->getCachedLoader(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v0

    .line 127
    .local v0, "result":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TT;TY;>;"
    if-eqz v0, :cond_1

    .line 131
    sget-object v1, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->NULL_MODEL_LOADER:Lcom/bumptech/glide/load/model/ModelLoader;

    invoke-virtual {v1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 132
    const/4 v1, 0x0

    monitor-exit p0

    return-object v1

    .line 134
    :cond_0
    monitor-exit p0

    return-object v0

    .line 138
    .end local p0    # "this":Lcom/bumptech/glide/load/model/GenericLoaderFactory;
    :cond_1
    :try_start_1
    invoke-direct {p0, p1, p2}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->getFactory(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;

    move-result-object v1

    .line 139
    .local v1, "factory":Lcom/bumptech/glide/load/model/ModelLoaderFactory;, "Lcom/bumptech/glide/load/model/ModelLoaderFactory<TT;TY;>;"
    if-eqz v1, :cond_2

    .line 140
    iget-object v2, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->context:Landroid/content/Context;

    invoke-interface {v1, v2, p0}, Lcom/bumptech/glide/load/model/ModelLoaderFactory;->build(Landroid/content/Context;Lcom/bumptech/glide/load/model/GenericLoaderFactory;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v2

    move-object v0, v2

    .line 141
    invoke-direct {p0, p1, p2, v0}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cacheModelLoader(Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;)V

    goto :goto_0

    .line 144
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cacheNullLoader(Ljava/lang/Class;Ljava/lang/Class;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 146
    :goto_0
    monitor-exit p0

    return-object v0

    .line 125
    .end local v0    # "result":Lcom/bumptech/glide/load/model/ModelLoader;, "Lcom/bumptech/glide/load/model/ModelLoader<TT;TY;>;"
    .end local v1    # "factory":Lcom/bumptech/glide/load/model/ModelLoaderFactory;, "Lcom/bumptech/glide/load/model/ModelLoaderFactory<TT;TY;>;"
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized buildModelLoader(Ljava/lang/Class;Ljava/lang/Class;Landroid/content/Context;)Lcom/bumptech/glide/load/model/ModelLoader;
    .locals 1
    .param p3, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;",
            "Landroid/content/Context;",
            ")",
            "Lcom/bumptech/glide/load/model/ModelLoader<",
            "TT;TY;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    monitor-enter p0

    .line 112
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->buildModelLoader(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoader;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Lcom/bumptech/glide/load/model/GenericLoaderFactory;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    .end local p3    # "context":Landroid/content/Context;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized register(Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;",
            "Lcom/bumptech/glide/load/model/ModelLoaderFactory<",
            "TT;TY;>;)",
            "Lcom/bumptech/glide/load/model/ModelLoaderFactory<",
            "TT;TY;>;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    .local p3, "factory":Lcom/bumptech/glide/load/model/ModelLoaderFactory;, "Lcom/bumptech/glide/load/model/ModelLoaderFactory<TT;TY;>;"
    monitor-enter p0

    .line 73
    :try_start_0
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 75
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 76
    .local v0, "resourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    if-nez v0, :cond_0

    .line 77
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    move-object v0, v1

    .line 78
    iget-object v1, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 76
    .end local p0    # "this":Lcom/bumptech/glide/load/model/GenericLoaderFactory;
    :cond_0
    nop

    .line 81
    :goto_0
    invoke-interface {v0, p2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/load/model/ModelLoaderFactory;

    .line 83
    .local v1, "previous":Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    if-eqz v1, :cond_3

    .line 86
    iget-object v2, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    .line 87
    .local v3, "factories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    invoke-interface {v3, v1}, Ljava/util/Map;->containsValue(Ljava/lang/Object;)Z

    move-result v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v4, :cond_1

    .line 88
    const/4 v1, 0x0

    .line 89
    goto :goto_2

    .line 87
    :cond_1
    nop

    .line 89
    .end local v3    # "factories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    goto :goto_1

    .line 86
    :cond_2
    goto :goto_2

    .line 83
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_3
    nop

    .line 94
    :goto_2
    monitor-exit p0

    return-object v1

    .line 72
    .end local v0    # "resourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    .end local v1    # "previous":Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    .end local p3    # "factory":Lcom/bumptech/glide/load/model/ModelLoaderFactory;, "Lcom/bumptech/glide/load/model/ModelLoaderFactory<TT;TY;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1

    return-void
.end method

.method public declared-synchronized unregister(Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "Y:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Ljava/lang/Class<",
            "TY;>;)",
            "Lcom/bumptech/glide/load/model/ModelLoaderFactory<",
            "TT;TY;>;"
        }
    .end annotation

    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    monitor-enter p0

    .line 50
    :try_start_0
    iget-object v0, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->cachedModelLoaders:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 52
    const/4 v0, 0x0

    .line 53
    .local v0, "result":Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    iget-object v1, p0, Lcom/bumptech/glide/load/model/GenericLoaderFactory;->modelClassToResourceFactories:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 54
    .local v1, "resourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    if-eqz v1, :cond_0

    .line 55
    invoke-interface {v1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v0, v2

    goto :goto_0

    .line 54
    .end local p0    # "this":Lcom/bumptech/glide/load/model/GenericLoaderFactory;
    :cond_0
    nop

    .line 57
    :goto_0
    monitor-exit p0

    return-object v0

    .line 49
    .end local v0    # "result":Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    .end local v1    # "resourceToFactories":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;>;"
    .end local p1    # "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local p2    # "resourceClass":Ljava/lang/Class;, "Ljava/lang/Class<TY;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
