.class public abstract Lcom/baidu/location/a/i;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baidu/location/a/i$b;,
        Lcom/baidu/location/a/i$a;
    }
.end annotation


# static fields
.field public static c:Ljava/lang/String;


# instance fields
.field public a:Lcom/baidu/location/b/g;

.field public b:Lcom/baidu/location/b/a;

.field final d:Landroid/os/Handler;

.field private e:Z

.field private f:Z

.field private g:Z

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/a/i;->c:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    iput-object v0, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/baidu/location/a/i;->e:Z

    iput-boolean v1, p0, Lcom/baidu/location/a/i;->f:Z

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/baidu/location/a/i;->g:Z

    new-instance v1, Lcom/baidu/location/a/i$a;

    invoke-direct {v1, p0}, Lcom/baidu/location/a/i$a;-><init>(Lcom/baidu/location/a/i;)V

    iput-object v1, p0, Lcom/baidu/location/a/i;->d:Landroid/os/Handler;

    iput-object v0, p0, Lcom/baidu/location/a/i;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/baidu/location/a/i;->i:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/i;)Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/a/i;->h:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic b(Lcom/baidu/location/a/i;)Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lcom/baidu/location/a/i;->i:Ljava/lang/String;

    return-object p0
.end method


# virtual methods
.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    iget-object p1, p0, Lcom/baidu/location/a/i;->h:Ljava/lang/String;

    if-nez p1, :cond_0

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object p1

    invoke-static {p1}, Lcom/baidu/location/a/j;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/i;->h:Ljava/lang/String;

    :cond_0
    iget-object p1, p0, Lcom/baidu/location/a/i;->i:Ljava/lang/String;

    if-nez p1, :cond_1

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object p1

    invoke-static {p1}, Lcom/baidu/location/a/j;->c(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/i;->i:Ljava/lang/String;

    :cond_1
    iget-object p1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/baidu/location/b/a;->a()Z

    move-result p1

    if-nez p1, :cond_3

    :cond_2
    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/b;->f()Lcom/baidu/location/b/a;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    :cond_3
    iget-object p1, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    if-eqz p1, :cond_4

    invoke-virtual {p1}, Lcom/baidu/location/b/g;->i()Z

    move-result p1

    if-nez p1, :cond_5

    :cond_4
    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/h;->o()Lcom/baidu/location/b/g;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    :cond_5
    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/e;->i()Z

    move-result p1

    const/4 v0, 0x0

    if-eqz p1, :cond_6

    invoke-static {}, Lcom/baidu/location/b/e;->a()Lcom/baidu/location/b/e;

    move-result-object p1

    invoke-virtual {p1}, Lcom/baidu/location/b/e;->g()Landroid/location/Location;

    move-result-object p1

    move-object v3, p1

    goto :goto_0

    :cond_6
    move-object v3, v0

    :goto_0
    iget-object p1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    if-eqz p1, :cond_7

    invoke-virtual {p1}, Lcom/baidu/location/b/a;->d()Z

    move-result p1

    if-nez p1, :cond_7

    iget-object p1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    invoke-virtual {p1}, Lcom/baidu/location/b/a;->c()Z

    move-result p1

    if-eqz p1, :cond_9

    :cond_7
    iget-object p1, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    if-eqz p1, :cond_8

    invoke-virtual {p1}, Lcom/baidu/location/b/g;->a()I

    move-result p1

    if-nez p1, :cond_9

    :cond_8
    if-nez v3, :cond_9

    return-object v0

    :cond_9
    invoke-virtual {p0}, Lcom/baidu/location/a/i;->b()Ljava/lang/String;

    move-result-object p1

    invoke-static {}, Lcom/baidu/location/a/h;->a()Lcom/baidu/location/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/h;->d()I

    move-result v0

    const/4 v1, -0x2

    if-ne v0, v1, :cond_a

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "&imo=1"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_a
    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/baidu/location/d/j;->b(Landroid/content/Context;)I

    move-result v0

    if-ltz v0, :cond_b

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "&lmd="

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_b
    iget-object v0, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Lcom/baidu/location/b/g;->a()I

    move-result v0

    if-nez v0, :cond_d

    :cond_c
    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/b/h;->l()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_d
    move-object v4, p1

    iget-boolean p1, p0, Lcom/baidu/location/a/i;->f:Z

    const/4 v0, 0x0

    if-eqz p1, :cond_e

    iput-boolean v0, p0, Lcom/baidu/location/a/i;->f:Z

    iget-object v1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    iget-object v2, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static/range {v1 .. v6}, Lcom/baidu/location/d/j;->a(Lcom/baidu/location/b/a;Lcom/baidu/location/b/g;Landroid/location/Location;Ljava/lang/String;IZ)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_e
    iget-object p1, p0, Lcom/baidu/location/a/i;->b:Lcom/baidu/location/b/a;

    iget-object v1, p0, Lcom/baidu/location/a/i;->a:Lcom/baidu/location/b/g;

    invoke-static {p1, v1, v3, v4, v0}, Lcom/baidu/location/d/j;->a(Lcom/baidu/location/b/a;Lcom/baidu/location/b/g;Landroid/location/Location;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public abstract a()V
.end method

.method public abstract a(Landroid/os/Message;)V
.end method

.method public b()Ljava/lang/String;
    .locals 8

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/baidu/location/a/a;->c()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/baidu/location/b/h;->i()Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-eqz v1, :cond_0

    const-string v1, "&cn=32"

    goto :goto_0

    :cond_0
    sget-object v1, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v4, "&cn=%d"

    new-array v5, v3, [Ljava/lang/Object;

    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v6

    invoke-virtual {v6}, Lcom/baidu/location/b/b;->e()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v1, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    :goto_0
    iget-boolean v4, p0, Lcom/baidu/location/a/i;->e:Z

    if-eqz v4, :cond_2

    iput-boolean v2, p0, Lcom/baidu/location/a/i;->e:Z

    invoke-static {}, Lcom/baidu/location/b/h;->a()Lcom/baidu/location/b/h;

    move-result-object v4

    invoke-virtual {v4}, Lcom/baidu/location/b/h;->q()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    const-string v5, "02:00:00:00:00:00"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    const-string v5, ":"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    const-string v6, "%s&mac=%s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v1, v7, v2

    aput-object v4, v7, v3

    invoke-static {v5, v6, v7}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    :cond_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    goto :goto_1

    :cond_2
    iget-boolean v2, p0, Lcom/baidu/location/a/i;->g:Z

    if-nez v2, :cond_4

    invoke-static {}, Lcom/baidu/location/a/v;->f()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_3
    iput-boolean v3, p0, Lcom/baidu/location/a/i;->g:Z

    :cond_4
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
