.class public Lcom/baidu/location/c/a$a;
.super Landroid/os/Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/c/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field private final a:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Lcom/baidu/location/c/a;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/os/Looper;Lcom/baidu/location/c/a;)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance p1, Ljava/lang/ref/WeakReference;

    invoke-direct {p1, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lcom/baidu/location/c/a$a;->a:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4

    iget-object v0, p0, Lcom/baidu/location/c/a$a;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/baidu/location/c/a;

    if-nez v0, :cond_0

    return-void

    :cond_0
    sget-boolean v1, Lcom/baidu/location/f;->isServing:Z

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    iget v1, p1, Landroid/os/Message;->what:I

    sparse-switch v1, :sswitch_data_0

    goto :goto_0

    :sswitch_0
    invoke-static {}, Lcom/baidu/location/a/h;->a()Lcom/baidu/location/a/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/a/h;->e()V

    goto :goto_0

    :sswitch_1
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "errorid"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getByteArray(Ljava/lang/String;)[B

    move-result-object v1

    if-eqz v1, :cond_1

    array-length v3, v1

    if-lez v3, :cond_1

    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v1}, Ljava/lang/String;-><init>([B)V

    goto :goto_0

    :sswitch_2
    :try_start_0
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0

    :sswitch_3
    invoke-static {}, Lcom/baidu/location/a/l;->c()Lcom/baidu/location/a/l;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/a/l;->h()V

    goto :goto_0

    :sswitch_4
    invoke-static {}, Lcom/baidu/location/a/l;->c()Lcom/baidu/location/a/l;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/baidu/location/a/l;->b(Landroid/os/Message;)V

    goto :goto_0

    :sswitch_5
    invoke-static {v0, p1}, Lcom/baidu/location/c/a;->c(Lcom/baidu/location/c/a;Landroid/os/Message;)V

    goto :goto_0

    :sswitch_6
    invoke-static {v0, p1}, Lcom/baidu/location/c/a;->b(Lcom/baidu/location/c/a;Landroid/os/Message;)V

    goto :goto_0

    :sswitch_7
    invoke-static {v0, p1}, Lcom/baidu/location/c/a;->a(Lcom/baidu/location/c/a;Landroid/os/Message;)V

    :cond_1
    :goto_0
    :sswitch_8
    iget v1, p1, Landroid/os/Message;->what:I

    if-ne v1, v2, :cond_2

    invoke-static {v0}, Lcom/baidu/location/c/a;->a(Lcom/baidu/location/c/a;)V

    :cond_2
    iget v1, p1, Landroid/os/Message;->what:I

    if-nez v1, :cond_3

    invoke-static {v0}, Lcom/baidu/location/c/a;->b(Lcom/baidu/location/c/a;)V

    :cond_3
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    return-void

    :sswitch_data_0
    .sparse-switch
        0xb -> :sswitch_7
        0xc -> :sswitch_6
        0xf -> :sswitch_5
        0x16 -> :sswitch_4
        0x1c -> :sswitch_8
        0x29 -> :sswitch_3
        0x6e -> :sswitch_8
        0x6f -> :sswitch_8
        0x70 -> :sswitch_8
        0x12e -> :sswitch_8
        0x191 -> :sswitch_2
        0x192 -> :sswitch_8
        0x193 -> :sswitch_8
        0x195 -> :sswitch_1
        0x196 -> :sswitch_0
        0x197 -> :sswitch_8
    .end sparse-switch
.end method
