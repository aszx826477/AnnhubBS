.class Lcom/baidu/location/c;
.super Ljava/lang/Thread;


# instance fields
.field final synthetic a:Lcom/baidu/location/LocationClient;


# direct methods
.method constructor <init>(Lcom/baidu/location/LocationClient;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    invoke-static {v0}, Lcom/baidu/location/LocationClient;->h(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/a/c;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    new-instance v1, Lcom/baidu/location/a/c;

    invoke-static {v0}, Lcom/baidu/location/LocationClient;->i(Lcom/baidu/location/LocationClient;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    invoke-static {v3}, Lcom/baidu/location/LocationClient;->j(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/LocationClientOption;

    move-result-object v3

    iget-object v4, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    invoke-direct {v1, v2, v3, v4}, Lcom/baidu/location/a/c;-><init>(Landroid/content/Context;Lcom/baidu/location/LocationClientOption;Lcom/baidu/location/a/c$a;)V

    invoke-static {v0, v1}, Lcom/baidu/location/LocationClient;->a(Lcom/baidu/location/LocationClient;Lcom/baidu/location/a/c;)Lcom/baidu/location/a/c;

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/c;->a:Lcom/baidu/location/LocationClient;

    invoke-static {v0}, Lcom/baidu/location/LocationClient;->h(Lcom/baidu/location/LocationClient;)Lcom/baidu/location/a/c;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/c;->c()V

    return-void
.end method
