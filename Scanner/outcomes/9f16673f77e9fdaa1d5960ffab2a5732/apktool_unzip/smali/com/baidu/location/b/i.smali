.class Lcom/baidu/location/b/i;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/baidu/location/b/h$a;


# direct methods
.method constructor <init>(Lcom/baidu/location/b/h$a;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/b/i;->a:Lcom/baidu/location/b/h$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/baidu/location/b/i;->a:Lcom/baidu/location/b/h$a;

    iget-object v0, v0, Lcom/baidu/location/b/h$a;->a:Lcom/baidu/location/b/h;

    invoke-static {v0}, Lcom/baidu/location/b/h;->a(Lcom/baidu/location/b/h;)V

    invoke-static {}, Lcom/baidu/location/a/l;->c()Lcom/baidu/location/a/l;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/l;->h()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {}, Lcom/baidu/location/a/t;->b()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x1388

    cmp-long v4, v0, v2

    if-gtz v4, :cond_0

    invoke-static {}, Lcom/baidu/location/a/t;->c()Lcom/baidu/location/b/a;

    move-result-object v0

    iget-object v1, p0, Lcom/baidu/location/b/i;->a:Lcom/baidu/location/b/h$a;

    iget-object v1, v1, Lcom/baidu/location/b/h$a;->a:Lcom/baidu/location/b/h;

    invoke-virtual {v1}, Lcom/baidu/location/b/h;->n()Lcom/baidu/location/b/g;

    move-result-object v1

    invoke-static {}, Lcom/baidu/location/a/t;->d()Landroid/location/Location;

    move-result-object v2

    invoke-static {}, Lcom/baidu/location/a/t;->a()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lcom/baidu/location/a/v;->a(Lcom/baidu/location/b/a;Lcom/baidu/location/b/g;Landroid/location/Location;Ljava/lang/String;)V

    :cond_0
    return-void
.end method
