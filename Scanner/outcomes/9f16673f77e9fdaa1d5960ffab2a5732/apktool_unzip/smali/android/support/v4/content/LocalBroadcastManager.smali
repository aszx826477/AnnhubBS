.class public final Landroid/support/v4/content/LocalBroadcastManager;
.super Ljava/lang/Object;
.source "LocalBroadcastManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;,
        Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field static final MSG_EXEC_PENDING_BROADCASTS:I = 0x1

.field private static final TAG:Ljava/lang/String; = "LocalBroadcastManager"

.field private static mInstance:Landroid/support/v4/content/LocalBroadcastManager;

.field private static final mLock:Ljava/lang/Object;


# instance fields
.field private final mActions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mAppContext:Landroid/content/Context;

.field private final mHandler:Landroid/os/Handler;

.field private final mPendingBroadcasts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;",
            ">;"
        }
    .end annotation
.end field

.field private final mReceivers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Landroid/content/BroadcastReceiver;",
            "Ljava/util/ArrayList<",
            "Landroid/content/IntentFilter;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 96
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/support/v4/content/LocalBroadcastManager;->mLock:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    .line 86
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    .line 89
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    .line 109
    iput-object p1, p0, Landroid/support/v4/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    .line 110
    new-instance v0, Landroid/support/v4/content/LocalBroadcastManager$1;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v4/content/LocalBroadcastManager$1;-><init>(Landroid/support/v4/content/LocalBroadcastManager;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    .line 123
    return-void
.end method

.method static synthetic access$000(Landroid/support/v4/content/LocalBroadcastManager;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v4/content/LocalBroadcastManager;

    .line 46
    invoke-direct {p0}, Landroid/support/v4/content/LocalBroadcastManager;->executePendingBroadcasts()V

    return-void
.end method

.method private executePendingBroadcasts()V
    .locals 7

    .line 284
    :goto_0
    const/4 v0, 0x0

    .line 285
    .local v0, "brs":[Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;
    iget-object v1, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v1

    .line 286
    :try_start_0
    iget-object v2, p0, Landroid/support/v4/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 287
    .local v2, "N":I
    if-gtz v2, :cond_0

    .line 288
    monitor-exit v1

    return-void

    .line 290
    :cond_0
    new-array v3, v2, [Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;

    move-object v0, v3

    .line 291
    iget-object v3, p0, Landroid/support/v4/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 292
    iget-object v3, p0, Landroid/support/v4/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 293
    .end local v2    # "N":I
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 294
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v2, v0

    if-ge v1, v2, :cond_2

    .line 295
    aget-object v2, v0, v1

    .line 296
    .local v2, "br":Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_2
    iget-object v4, v2, Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v3, v4, :cond_1

    .line 297
    iget-object v4, v2, Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;

    iget-object v4, v4, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->receiver:Landroid/content/BroadcastReceiver;

    iget-object v5, p0, Landroid/support/v4/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    iget-object v6, v2, Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;->intent:Landroid/content/Intent;

    invoke-virtual {v4, v5, v6}, Landroid/content/BroadcastReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 296
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 294
    .end local v2    # "br":Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;
    .end local v3    # "j":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 300
    .end local v0    # "brs":[Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;
    .end local v1    # "i":I
    :cond_2
    goto :goto_0

    .line 293
    .restart local v0    # "brs":[Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .line 100
    sget-object v0, Landroid/support/v4/content/LocalBroadcastManager;->mLock:Ljava/lang/Object;

    monitor-enter v0

    .line 101
    :try_start_0
    sget-object v1, Landroid/support/v4/content/LocalBroadcastManager;->mInstance:Landroid/support/v4/content/LocalBroadcastManager;

    if-nez v1, :cond_0

    .line 102
    new-instance v1, Landroid/support/v4/content/LocalBroadcastManager;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/support/v4/content/LocalBroadcastManager;-><init>(Landroid/content/Context;)V

    sput-object v1, Landroid/support/v4/content/LocalBroadcastManager;->mInstance:Landroid/support/v4/content/LocalBroadcastManager;

    goto :goto_0

    .line 101
    :cond_0
    nop

    .line 104
    :goto_0
    sget-object v1, Landroid/support/v4/content/LocalBroadcastManager;->mInstance:Landroid/support/v4/content/LocalBroadcastManager;

    monitor-exit v0

    return-object v1

    .line 105
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    .locals 8
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;
    .param p2, "filter"    # Landroid/content/IntentFilter;

    .line 134
    iget-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v0

    .line 135
    :try_start_0
    new-instance v1, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;

    invoke-direct {v1, p2, p1}, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;-><init>(Landroid/content/IntentFilter;Landroid/content/BroadcastReceiver;)V

    .line 136
    .local v1, "entry":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    iget-object v2, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 137
    .local v2, "filters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/IntentFilter;>;"
    const/4 v3, 0x1

    if-nez v2, :cond_0

    .line 138
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v3}, Ljava/util/ArrayList;-><init>(I)V

    move-object v2, v4

    .line 139
    iget-object v4, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v4, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 137
    :cond_0
    nop

    .line 141
    :goto_0
    invoke-virtual {v2, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 142
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    invoke-virtual {p2}, Landroid/content/IntentFilter;->countActions()I

    move-result v5

    if-ge v4, v5, :cond_2

    .line 143
    invoke-virtual {p2, v4}, Landroid/content/IntentFilter;->getAction(I)Ljava/lang/String;

    move-result-object v5

    .line 144
    .local v5, "action":Ljava/lang/String;
    iget-object v6, p0, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v6, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    .line 145
    .local v6, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    if-nez v6, :cond_1

    .line 146
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7, v3}, Ljava/util/ArrayList;-><init>(I)V

    move-object v6, v7

    .line 147
    iget-object v7, p0, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v7, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 145
    :cond_1
    nop

    .line 149
    :goto_2
    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 142
    nop

    .end local v5    # "action":Ljava/lang/String;
    .end local v6    # "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 151
    .end local v1    # "entry":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    .end local v2    # "filters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/IntentFilter;>;"
    .end local v4    # "i":I
    :cond_2
    monitor-exit v0

    .line 152
    return-void

    .line 151
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    return-void
.end method

.method public sendBroadcast(Landroid/content/Intent;)Z
    .locals 18
    .param p1, "intent"    # Landroid/content/Intent;

    .line 201
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    iget-object v3, v1, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v3

    .line 202
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    .line 203
    .local v5, "action":Ljava/lang/String;
    iget-object v0, v1, Landroid/support/v4/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    .line 204
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 203
    invoke-virtual {v2, v0}, Landroid/content/Intent;->resolveTypeIfNeeded(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v0

    .line 205
    .local v0, "type":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v8

    .line 206
    .local v8, "data":Landroid/net/Uri;
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getScheme()Ljava/lang/String;

    move-result-object v4

    move-object v11, v4

    .line 207
    .local v11, "scheme":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getCategories()Ljava/util/Set;

    move-result-object v9

    .line 209
    .local v9, "categories":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    nop

    .line 210
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getFlags()I

    move-result v4

    and-int/lit8 v4, v4, 0x8

    const/4 v12, 0x0

    if-eqz v4, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :cond_0
    const/4 v4, 0x0

    :goto_0
    move v14, v4

    .line 211
    .local v14, "debug":Z
    if-eqz v14, :cond_1

    const-string v4, "LocalBroadcastManager"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Resolving type "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, " scheme "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, " of intent "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 215
    :cond_1
    iget-object v4, v1, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    move-object v15, v4

    .line 216
    .local v15, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    if-eqz v15, :cond_e

    .line 217
    if-eqz v14, :cond_2

    const-string v4, "LocalBroadcastManager"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Action list: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    :cond_2
    const/4 v4, 0x0

    .line 220
    .local v4, "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    nop

    move v6, v12

    move-object v7, v4

    move v10, v6

    .end local v4    # "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .local v7, "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .local v10, "i":I
    :goto_1
    nop

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v4

    nop

    if-ge v10, v4, :cond_a

    .line 221
    nop

    invoke-virtual {v15, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    nop

    check-cast v4, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;

    nop

    move-object v6, v4

    .line 222
    .local v6, "receiver":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    nop

    if-eqz v14, :cond_3

    nop

    const-string v4, "LocalBroadcastManager"

    nop

    new-instance v12, Ljava/lang/StringBuilder;

    nop

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    nop

    const-string v13, "Matching against filter "

    nop

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    iget-object v13, v6, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    nop

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    nop

    invoke-static {v4, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3
    nop

    .line 224
    nop

    iget-boolean v4, v6, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    nop

    if-eqz v4, :cond_5

    .line 225
    nop

    if-eqz v14, :cond_4

    .line 226
    nop

    const-string v4, "LocalBroadcastManager"

    nop

    const-string v12, "  Filter\'s target already added"

    nop

    invoke-static {v4, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    nop

    move-object/from16 v16, v0

    move-object v0, v7

    move/from16 v17, v10

    goto/16 :goto_5

    .line 225
    :cond_4
    nop

    move-object/from16 v16, v0

    move-object v0, v7

    move/from16 v17, v10

    goto/16 :goto_5

    .line 231
    :cond_5
    nop

    iget-object v4, v6, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    nop

    const-string v12, "LocalBroadcastManager"

    nop

    move-object v13, v6

    .end local v6    # "receiver":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    .local v13, "receiver":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    move-object v6, v0

    move-object/from16 v16, v0

    move-object v0, v7

    .end local v7    # "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .local v0, "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .local v16, "type":Ljava/lang/String;
    move-object v7, v11

    move/from16 v17, v10

    .end local v10    # "i":I
    .local v17, "i":I
    move-object v10, v12

    invoke-virtual/range {v4 .. v10}, Landroid/content/IntentFilter;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Set;Ljava/lang/String;)I

    move-result v4

    nop

    .line 233
    .local v4, "match":I
    nop

    if-ltz v4, :cond_8

    .line 234
    nop

    if-eqz v14, :cond_6

    nop

    const-string v6, "LocalBroadcastManager"

    nop

    new-instance v7, Ljava/lang/StringBuilder;

    nop

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    nop

    const-string v10, "  Filter matched!  match=0x"

    nop

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 235
    nop

    invoke-static {v4}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v10

    nop

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 234
    nop

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_6
    nop

    .line 236
    nop

    if-nez v0, :cond_7

    .line 237
    nop

    new-instance v6, Ljava/util/ArrayList;

    nop

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    nop

    move-object v7, v6

    move-object v0, v7

    goto :goto_2

    .line 236
    :cond_7
    nop

    .line 239
    :goto_2
    nop

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 240
    nop

    const/4 v6, 0x1

    iput-boolean v6, v13, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    nop

    move-object v7, v0

    goto :goto_6

    .line 242
    :cond_8
    nop

    if-eqz v14, :cond_9

    .line 244
    nop

    packed-switch v4, :pswitch_data_0

    .line 249
    nop

    const-string v6, "unknown reason"

    goto :goto_3

    .line 248
    :pswitch_0
    nop

    const-string v6, "type"

    nop

    goto :goto_4

    .line 247
    :pswitch_1
    nop

    const-string v6, "data"

    nop

    goto :goto_4

    .line 245
    :pswitch_2
    nop

    const-string v6, "action"

    nop

    goto :goto_4

    .line 246
    :pswitch_3
    nop

    const-string v6, "category"

    nop

    goto :goto_4

    .line 249
    :goto_3
    nop

    nop

    .line 251
    .local v6, "reason":Ljava/lang/String;
    :goto_4
    nop

    const-string v7, "LocalBroadcastManager"

    nop

    new-instance v10, Ljava/lang/StringBuilder;

    nop

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    nop

    const-string v12, "  Filter did not match: "

    nop

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    nop

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    nop

    invoke-static {v7, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    nop

    goto :goto_5

    .line 242
    .end local v6    # "reason":Ljava/lang/String;
    :cond_9
    nop

    .line 220
    .end local v4    # "match":I
    .end local v13    # "receiver":Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;
    .end local v16    # "type":Ljava/lang/String;
    .end local v17    # "i":I
    .local v0, "type":Ljava/lang/String;
    .restart local v7    # "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .restart local v10    # "i":I
    :goto_5
    move-object v7, v0

    .end local v0    # "type":Ljava/lang/String;
    .end local v10    # "i":I
    .restart local v16    # "type":Ljava/lang/String;
    .restart local v17    # "i":I
    :goto_6
    nop

    add-int/lit8 v10, v17, 0x1

    move-object/from16 v0, v16

    const/4 v12, 0x0

    goto/16 :goto_1

    .end local v16    # "type":Ljava/lang/String;
    .end local v17    # "i":I
    .restart local v0    # "type":Ljava/lang/String;
    .restart local v10    # "i":I
    :cond_a
    move-object/from16 v16, v0

    move-object v0, v7

    move/from16 v17, v10

    .end local v7    # "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .end local v10    # "i":I
    .local v0, "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .restart local v16    # "type":Ljava/lang/String;
    .restart local v17    # "i":I
    nop

    .line 256
    .end local v17    # "i":I
    nop

    if-eqz v0, :cond_d

    .line 257
    nop

    nop

    const/4 v4, 0x0

    move v6, v4

    .local v6, "i":I
    :goto_7
    nop

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    nop

    if-ge v6, v4, :cond_b

    .line 258
    nop

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    nop

    check-cast v4, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;

    nop

    const/4 v7, 0x0

    iput-boolean v7, v4, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    .line 257
    nop

    add-int/lit8 v6, v6, 0x1

    goto :goto_7

    :cond_b
    nop

    .line 260
    .end local v6    # "i":I
    nop

    iget-object v4, v1, Landroid/support/v4/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    nop

    new-instance v6, Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;

    nop

    invoke-direct {v6, v2, v0}, Landroid/support/v4/content/LocalBroadcastManager$BroadcastRecord;-><init>(Landroid/content/Intent;Ljava/util/ArrayList;)V

    nop

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 261
    nop

    iget-object v4, v1, Landroid/support/v4/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    nop

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v4

    nop

    if-nez v4, :cond_c

    .line 262
    nop

    iget-object v4, v1, Landroid/support/v4/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    nop

    invoke-virtual {v4, v6}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    nop

    goto :goto_8

    .line 261
    :cond_c
    nop

    .line 264
    :goto_8
    nop

    monitor-exit v3

    nop

    const/4 v3, 0x1

    return v3

    .line 256
    :cond_d
    nop

    goto :goto_9

    .line 216
    .end local v16    # "type":Ljava/lang/String;
    .local v0, "type":Ljava/lang/String;
    :cond_e
    move-object/from16 v16, v0

    .end local v0    # "type":Ljava/lang/String;
    .restart local v16    # "type":Ljava/lang/String;
    nop

    .line 267
    .end local v5    # "action":Ljava/lang/String;
    .end local v8    # "data":Landroid/net/Uri;
    .end local v9    # "categories":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v11    # "scheme":Ljava/lang/String;
    .end local v14    # "debug":Z
    .end local v15    # "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    .end local v16    # "type":Ljava/lang/String;
    :goto_9
    nop

    monitor-exit v3

    nop

    .line 268
    nop

    const/4 v0, 0x0

    return v0

    .line 267
    :catchall_0
    move-exception v0

    nop

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    nop

    throw v0

    return-void

    :pswitch_data_0
    .packed-switch -0x4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public sendBroadcastSync(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .line 277
    invoke-virtual {p0, p1}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 278
    invoke-direct {p0}, Landroid/support/v4/content/LocalBroadcastManager;->executePendingBroadcasts()V

    goto :goto_0

    .line 277
    :cond_0
    nop

    .line 280
    :goto_0
    return-void
.end method

.method public unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 10
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;

    .line 164
    iget-object v0, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v0

    .line 165
    :try_start_0
    iget-object v1, p0, Landroid/support/v4/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 166
    .local v1, "filters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/IntentFilter;>;"
    if-nez v1, :cond_0

    .line 167
    monitor-exit v0

    return-void

    .line 169
    :cond_0
    nop

    const/4 v2, 0x0

    move v3, v2

    .local v3, "i":I
    :goto_0
    nop

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v4

    nop

    if-ge v3, v4, :cond_6

    .line 170
    nop

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    nop

    check-cast v4, Landroid/content/IntentFilter;

    nop

    .line 171
    .local v4, "filter":Landroid/content/IntentFilter;
    nop

    nop

    move v5, v2

    .local v5, "j":I
    :goto_1
    nop

    invoke-virtual {v4}, Landroid/content/IntentFilter;->countActions()I

    move-result v6

    nop

    if-ge v5, v6, :cond_5

    .line 172
    nop

    invoke-virtual {v4, v5}, Landroid/content/IntentFilter;->getAction(I)Ljava/lang/String;

    move-result-object v6

    nop

    .line 173
    .local v6, "action":Ljava/lang/String;
    nop

    iget-object v7, p0, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    nop

    invoke-virtual {v7, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    nop

    check-cast v7, Ljava/util/ArrayList;

    nop

    .line 174
    .local v7, "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    nop

    if-eqz v7, :cond_4

    .line 175
    nop

    nop

    move v8, v2

    .local v8, "k":I
    :goto_2
    nop

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v9

    nop

    if-ge v8, v9, :cond_2

    .line 176
    nop

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    nop

    check-cast v9, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;

    nop

    iget-object v9, v9, Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;->receiver:Landroid/content/BroadcastReceiver;

    nop

    if-ne v9, p1, :cond_1

    .line 177
    nop

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 178
    nop

    add-int/lit8 v8, v8, -0x1

    goto :goto_3

    .line 176
    :cond_1
    nop

    .line 175
    :goto_3
    nop

    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    :cond_2
    nop

    .line 181
    .end local v8    # "k":I
    nop

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v8

    nop

    if-gtz v8, :cond_3

    .line 182
    nop

    iget-object v8, p0, Landroid/support/v4/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    nop

    invoke-virtual {v8, v6}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    nop

    goto :goto_4

    .line 181
    :cond_3
    nop

    goto :goto_4

    .line 174
    :cond_4
    nop

    .line 171
    .end local v6    # "action":Ljava/lang/String;
    .end local v7    # "receivers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/content/LocalBroadcastManager$ReceiverRecord;>;"
    :goto_4
    nop

    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    :cond_5
    nop

    .line 169
    .end local v4    # "filter":Landroid/content/IntentFilter;
    .end local v5    # "j":I
    nop

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_6
    nop

    .line 187
    .end local v1    # "filters":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/IntentFilter;>;"
    .end local v3    # "i":I
    nop

    monitor-exit v0

    nop

    .line 188
    nop

    return-void

    .line 187
    :catchall_0
    move-exception v1

    nop

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    nop

    throw v1

    return-void
.end method
