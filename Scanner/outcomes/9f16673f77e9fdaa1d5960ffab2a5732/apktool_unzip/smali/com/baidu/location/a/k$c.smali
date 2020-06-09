.class final Lcom/baidu/location/a/k$c;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/baidu/location/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "c"
.end annotation


# static fields
.field private static final a:Lcom/baidu/location/a/k;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/baidu/location/a/k;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/baidu/location/a/k;-><init>(Lcom/baidu/location/a/k$1;)V

    sput-object v0, Lcom/baidu/location/a/k$c;->a:Lcom/baidu/location/a/k;

    return-void
.end method

.method static synthetic a()Lcom/baidu/location/a/k;
    .locals 1

    sget-object v0, Lcom/baidu/location/a/k$c;->a:Lcom/baidu/location/a/k;

    return-object v0
.end method
