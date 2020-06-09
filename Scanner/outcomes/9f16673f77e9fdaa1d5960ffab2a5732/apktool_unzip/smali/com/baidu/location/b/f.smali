.class Lcom/baidu/location/b/f;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcom/baidu/location/b/e;


# direct methods
.method constructor <init>(Lcom/baidu/location/b/e;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/b/f;->a:Lcom/baidu/location/b/e;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2

    sget-boolean v0, Lcom/baidu/location/f;->isServing:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    packed-switch v0, :pswitch_data_0

    goto :goto_1

    :pswitch_0
    iget-object v0, p0, Lcom/baidu/location/b/f;->a:Lcom/baidu/location/b/e;

    const-string v1, "&og=2"

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/baidu/location/b/f;->a:Lcom/baidu/location/b/e;

    const-string v1, "&og=1"

    :goto_0
    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Landroid/location/Location;

    invoke-static {v0, v1, p1}, Lcom/baidu/location/b/e;->a(Lcom/baidu/location/b/e;Ljava/lang/String;Landroid/location/Location;)V

    goto :goto_1

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/b/f;->a:Lcom/baidu/location/b/e;

    iget-object p1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p1, Landroid/location/Location;

    invoke-static {v0, p1}, Lcom/baidu/location/b/e;->a(Lcom/baidu/location/b/e;Landroid/location/Location;)V

    :goto_1
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
