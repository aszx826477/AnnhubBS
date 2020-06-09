.class public Lcom/qihoo360/replugin/Entry;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static cl:Ljava/lang/ClassLoader;

.field static context:Landroid/content/Context;

.field static fakeBinder:Lcom/qihoo360/replugin/Entry$Stub;

.field static manager:Landroid/os/IBinder;

.field static realEntryBinder:Landroid/os/IBinder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 40
    sput-object v0, Lcom/qihoo360/replugin/Entry;->context:Landroid/content/Context;

    .line 41
    sput-object v0, Lcom/qihoo360/replugin/Entry;->cl:Ljava/lang/ClassLoader;

    .line 42
    sput-object v0, Lcom/qihoo360/replugin/Entry;->manager:Landroid/os/IBinder;

    .line 43
    sput-object v0, Lcom/qihoo360/replugin/Entry;->realEntryBinder:Landroid/os/IBinder;

    .line 44
    sput-object v0, Lcom/qihoo360/replugin/Entry;->fakeBinder:Lcom/qihoo360/replugin/Entry$Stub;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final create(Landroid/content/Context;Ljava/lang/ClassLoader;Landroid/os/IBinder;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 57
    sput-object p0, Lcom/qihoo360/replugin/Entry;->context:Landroid/content/Context;

    .line 58
    sput-object p1, Lcom/qihoo360/replugin/Entry;->cl:Ljava/lang/ClassLoader;

    .line 59
    sput-object p2, Lcom/qihoo360/replugin/Entry;->manager:Landroid/os/IBinder;

    .line 60
    new-instance v0, Lcom/qihoo360/replugin/Entry$Stub;

    invoke-direct {v0}, Lcom/qihoo360/replugin/Entry$Stub;-><init>()V

    .line 61
    sput-object v0, Lcom/qihoo360/replugin/Entry;->fakeBinder:Lcom/qihoo360/replugin/Entry$Stub;

    return-object v0
.end method

.method public static init()V
    .locals 5

    .prologue
    .line 47
    :try_start_0
    const-string v0, "com.qihoo360.replugin.Entry_Jiagu"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 48
    const-string v1, "create"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/Context;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-class v4, Ljava/lang/ClassLoader;

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-class v4, Landroid/os/IBinder;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 49
    const/4 v1, 0x0

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Lcom/qihoo360/replugin/Entry;->context:Landroid/content/Context;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/qihoo360/replugin/Entry;->cl:Ljava/lang/ClassLoader;

    aput-object v4, v2, v3

    const/4 v3, 0x2

    sget-object v4, Lcom/qihoo360/replugin/Entry;->manager:Landroid/os/IBinder;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/IBinder;

    .line 50
    sput-object v0, Lcom/qihoo360/replugin/Entry;->realEntryBinder:Landroid/os/IBinder;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/qihoo360/replugin/Entry;->fakeBinder:Lcom/qihoo360/replugin/Entry$Stub;

    if-eqz v0, :cond_0

    .line 51
    sget-object v0, Lcom/qihoo360/replugin/Entry;->fakeBinder:Lcom/qihoo360/replugin/Entry$Stub;

    sget-object v1, Lcom/qihoo360/replugin/Entry;->realEntryBinder:Landroid/os/IBinder;

    invoke-virtual {v0, v1}, Lcom/qihoo360/replugin/Entry$Stub;->setRemote(Landroid/os/IBinder;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 55
    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
