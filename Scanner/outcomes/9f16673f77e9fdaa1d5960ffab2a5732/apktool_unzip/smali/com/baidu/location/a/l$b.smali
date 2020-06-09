.class Lcom/baidu/location/a/l$b;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/a/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Lcom/baidu/location/a/l;


# direct methods
.method private constructor <init>(Lcom/baidu/location/a/l;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/baidu/location/a/l;Lcom/baidu/location/a/l$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/l$b;-><init>(Lcom/baidu/location/a/l;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    invoke-static {v0}, Lcom/baidu/location/a/l;->a(Lcom/baidu/location/a/l;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    invoke-static {v0, v1}, Lcom/baidu/location/a/l;->a(Lcom/baidu/location/a/l;Z)Z

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    invoke-static {v0}, Lcom/baidu/location/a/l;->b(Lcom/baidu/location/a/l;)Z

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_1

    iget-object v0, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    invoke-static {v0, v1}, Lcom/baidu/location/a/l;->b(Lcom/baidu/location/a/l;Z)Z

    iget-object v0, p0, Lcom/baidu/location/a/l$b;->a:Lcom/baidu/location/a/l;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/baidu/location/a/l;->a(Lcom/baidu/location/a/l;Landroid/os/Message;)V

    :cond_1
    return-void
.end method
