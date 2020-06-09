.class public Lcom/baidu/location/a/d;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baidu/location/a/d$a;
    }
.end annotation


# static fields
.field public static f:Ljava/lang/String;

.field private static j:Lcom/baidu/location/a/d;


# instance fields
.field private A:Lcom/baidu/location/a/d$a;

.field private B:Z

.field private C:Z

.field private D:I

.field private E:F

.field private F:F

.field private G:J

.field private H:I

.field private I:Landroid/os/Handler;

.field private J:[B

.field private K:[B

.field private L:I

.field private M:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation
.end field

.field private N:Z

.field a:J

.field b:Landroid/location/Location;

.field c:Landroid/location/Location;

.field d:Ljava/lang/StringBuilder;

.field e:J

.field g:I

.field h:D

.field i:D

.field private k:I

.field private l:D

.field private m:Ljava/lang/String;

.field private n:I

.field private o:I

.field private p:I

.field private q:I

.field private r:D

.field private s:D

.field private t:D

.field private u:I

.field private v:I

.field private w:I

.field private x:I

.field private y:I

.field private z:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/baidu/location/a/d;->j:Lcom/baidu/location/a/d;

    const-string v0, "0"

    sput-object v0, Lcom/baidu/location/a/d;->f:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/baidu/location/a/d;->k:I

    const-wide v1, 0x3fe6666660000000L    # 0.699999988079071

    iput-wide v1, p0, Lcom/baidu/location/a/d;->l:D

    const-string v1, "3G|4G"

    iput-object v1, p0, Lcom/baidu/location/a/d;->m:Ljava/lang/String;

    iput v0, p0, Lcom/baidu/location/a/d;->n:I

    const v1, 0x4b000

    iput v1, p0, Lcom/baidu/location/a/d;->o:I

    const/16 v1, 0xf

    iput v1, p0, Lcom/baidu/location/a/d;->p:I

    iput v0, p0, Lcom/baidu/location/a/d;->q:I

    const-wide/high16 v0, 0x400c000000000000L    # 3.5

    iput-wide v0, p0, Lcom/baidu/location/a/d;->r:D

    const-wide/high16 v0, 0x4008000000000000L    # 3.0

    iput-wide v0, p0, Lcom/baidu/location/a/d;->s:D

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    iput-wide v0, p0, Lcom/baidu/location/a/d;->t:D

    const/16 v0, 0x12c

    iput v0, p0, Lcom/baidu/location/a/d;->u:I

    const/16 v0, 0x3c

    iput v0, p0, Lcom/baidu/location/a/d;->v:I

    const/4 v1, 0x0

    iput v1, p0, Lcom/baidu/location/a/d;->w:I

    iput v0, p0, Lcom/baidu/location/a/d;->x:I

    iput v1, p0, Lcom/baidu/location/a/d;->y:I

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/baidu/location/a/d;->z:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/d;->A:Lcom/baidu/location/a/d$a;

    iput-boolean v1, p0, Lcom/baidu/location/a/d;->B:Z

    iput-boolean v1, p0, Lcom/baidu/location/a/d;->C:Z

    iput v1, p0, Lcom/baidu/location/a/d;->D:I

    const/4 v4, 0x0

    iput v4, p0, Lcom/baidu/location/a/d;->E:F

    iput v4, p0, Lcom/baidu/location/a/d;->F:F

    iput-wide v2, p0, Lcom/baidu/location/a/d;->G:J

    const/16 v4, 0x1f4

    iput v4, p0, Lcom/baidu/location/a/d;->H:I

    iput-wide v2, p0, Lcom/baidu/location/a/d;->a:J

    iput-object v0, p0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    iput-object v0, p0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    iput-object v0, p0, Lcom/baidu/location/a/d;->d:Ljava/lang/StringBuilder;

    iput-wide v2, p0, Lcom/baidu/location/a/d;->e:J

    iput-object v0, p0, Lcom/baidu/location/a/d;->I:Landroid/os/Handler;

    const/4 v2, 0x4

    new-array v2, v2, [B

    iput-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    iput-object v0, p0, Lcom/baidu/location/a/d;->K:[B

    iput v1, p0, Lcom/baidu/location/a/d;->L:I

    iput-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iput-boolean v1, p0, Lcom/baidu/location/a/d;->N:Z

    iput v1, p0, Lcom/baidu/location/a/d;->g:I

    const-wide v0, 0x405d0e4d1816773bL    # 116.22345545

    iput-wide v0, p0, Lcom/baidu/location/a/d;->h:D

    const-wide v0, 0x40441f7206defd8dL    # 40.245667323

    iput-wide v0, p0, Lcom/baidu/location/a/d;->i:D

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/a/d;->I:Landroid/os/Handler;

    return-void
.end method

.method public static a()Lcom/baidu/location/a/d;
    .locals 1

    sget-object v0, Lcom/baidu/location/a/d;->j:Lcom/baidu/location/a/d;

    if-nez v0, :cond_0

    new-instance v0, Lcom/baidu/location/a/d;

    invoke-direct {v0}, Lcom/baidu/location/a/d;-><init>()V

    sput-object v0, Lcom/baidu/location/a/d;->j:Lcom/baidu/location/a/d;

    :cond_0
    sget-object v0, Lcom/baidu/location/a/d;->j:Lcom/baidu/location/a/d;

    return-object v0
.end method

.method static synthetic a(Lcom/baidu/location/a/d;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/baidu/location/a/d;->a(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private a(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "--"

    const-string v2, "\r\n"

    const-string v3, "multipart/form-data"

    :try_start_0
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, p2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object p2

    check-cast p2, Ljava/net/HttpURLConnection;

    const/16 v4, 0x2710

    invoke-virtual {p2, v4}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    invoke-virtual {p2, v4}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    const/4 v4, 0x1

    invoke-virtual {p2, v4}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    invoke-virtual {p2, v4}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    const/4 v4, 0x0

    invoke-virtual {p2, v4}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    const-string v5, "POST"

    invoke-virtual {p2, v5}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    const-string v5, "Charset"

    const-string v6, "utf-8"

    invoke-virtual {p2, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "connection"

    const-string v6, "close"

    invoke-virtual {p2, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "Content-Type"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ";boundary="

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v5, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    new-instance v5, Ljava/io/DataOutputStream;

    invoke-direct {v5, v3}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Content-Disposition: form-data; name=\"location_dat\"; filename=\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v8, "\""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Content-Type: application/octet-stream; charset=utf-8"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/io/DataOutputStream;->write([B)V

    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const/16 p1, 0x400

    new-array p1, p1, [B

    :goto_0
    invoke-virtual {v6, p1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-eq v7, v8, :cond_0

    invoke-virtual {v5, p1, v4, v7}, Ljava/io/DataOutputStream;->write([BII)V

    goto :goto_0

    :cond_0
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-virtual {v5, p1}, Ljava/io/DataOutputStream;->write([B)V

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-virtual {v5, p1}, Ljava/io/DataOutputStream;->write([B)V

    invoke-virtual {v5}, Ljava/io/DataOutputStream;->flush()V

    invoke-virtual {v5}, Ljava/io/DataOutputStream;->close()V

    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result p1

    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V

    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->disconnect()V

    iget p2, p0, Lcom/baidu/location/a/d;->y:I

    add-int/lit16 p2, p2, 0x190

    iput p2, p0, Lcom/baidu/location/a/d;->y:I

    iget p2, p0, Lcom/baidu/location/a/d;->y:I

    invoke-direct {p0, p2}, Lcom/baidu/location/a/d;->c(I)V

    const/16 p2, 0xc8

    if-ne p1, p2, :cond_1

    const-string p1, "1"
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    goto :goto_1

    :catch_1
    move-exception p1

    :cond_1
    :goto_1
    const-string p1, "0"

    return-object p1
.end method

.method static synthetic a(Lcom/baidu/location/a/d;Landroid/location/Location;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->b(Landroid/location/Location;)V

    return-void
.end method

.method static synthetic a(Lcom/baidu/location/a/d;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->e(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Landroid/content/Context;)Z
    .locals 3

    const/4 v0, 0x0

    :try_start_0
    const-string v1, "activity"

    invoke-virtual {p2, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/app/ActivityManager;

    invoke-virtual {p2}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object p2

    if-eqz p2, :cond_2

    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_0
    :goto_0
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    iget-object v2, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget v1, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/16 v2, 0xc8

    if-eq v1, v2, :cond_1

    const/16 v2, 0x64

    if-ne v1, v2, :cond_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception p1

    :cond_2
    return v0
.end method

.method private a(I)[B
    .locals 3

    const/4 v0, 0x4

    new-array v0, v0, [B

    and-int/lit16 v1, p1, 0xff

    int-to-byte v1, v1

    const/4 v2, 0x0

    aput-byte v1, v0, v2

    const v1, 0xff00

    and-int/2addr v1, p1

    shr-int/lit8 v1, v1, 0x8

    int-to-byte v1, v1

    const/4 v2, 0x1

    aput-byte v1, v0, v2

    const/high16 v1, 0xff0000

    and-int/2addr v1, p1

    shr-int/lit8 v1, v1, 0x10

    int-to-byte v1, v1

    const/4 v2, 0x2

    aput-byte v1, v0, v2

    const/high16 v1, -0x1000000

    and-int/2addr p1, v1

    shr-int/lit8 p1, p1, 0x18

    int-to-byte p1, p1

    const/4 v1, 0x3

    aput-byte p1, v0, v1

    return-object v0
.end method

.method private a(Ljava/lang/String;)[B
    .locals 8

    if-nez p1, :cond_0

    const/4 p1, 0x0

    return-object p1

    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    const/16 v1, 0xff

    invoke-virtual {v0, v1}, Ljava/util/Random;->nextInt(I)I

    move-result v0

    int-to-byte v0, v0

    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    invoke-virtual {v2, v1}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    int-to-byte v1, v1

    array-length v2, p1

    add-int/lit8 v2, v2, 0x2

    new-array v2, v2, [B

    array-length v3, p1

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_0
    if-ge v4, v3, :cond_1

    aget-byte v6, p1, v4

    add-int/lit8 v7, v5, 0x1

    xor-int/2addr v6, v0

    int-to-byte v6, v6

    aput-byte v6, v2, v5

    add-int/lit8 v4, v4, 0x1

    move v5, v7

    goto :goto_0

    :cond_1
    add-int/lit8 p1, v5, 0x1

    aput-byte v0, v2, v5

    aput-byte v1, v2, p1

    return-object v2
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const/4 v4, 0x0

    aput-object v3, v1, v4

    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v4

    add-int/2addr v4, v2

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v1, v2

    const/4 v2, 0x5

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v1, v3

    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private b(I)V
    .locals 3

    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->a(I)[B

    move-result-object p1

    const/4 v0, 0x0

    :goto_0
    const/4 v1, 0x4

    if-ge v0, v1, :cond_0

    iget-object v1, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    aget-byte v2, p1, v0

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method private b(Landroid/location/Location;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->c(Landroid/location/Location;)V

    invoke-direct {p0}, Lcom/baidu/location/a/d;->h()V

    return-void
.end method

.method private c()V
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/a/d;->N:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/a/d;->N:Z

    sget-object v0, Lcom/baidu/location/d/b;->d:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/baidu/location/a/d;->d(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/baidu/location/a/d;->j()V

    invoke-direct {p0}, Lcom/baidu/location/a/d;->d()V

    return-void
.end method

.method private c(I)V
    .locals 7

    if-nez p1, :cond_0

    return-void

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/baidu/location/d/i;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "/grtcf.dat"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :try_start_0
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    const-wide/16 v2, 0x8

    if-nez v0, :cond_3

    new-instance v0, Ljava/io/File;

    sget-object v4, Lcom/baidu/location/d/i;->a:Ljava/lang/String;

    invoke-direct {v0, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    :cond_1
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v4, "rw"

    invoke-direct {v0, v1, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const-wide/16 v4, 0x2

    invoke-virtual {v0, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeInt(I)V

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    const-string v5, "1980_01_01:0"

    invoke-virtual {v5}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    array-length v6, v5

    invoke-virtual {v0, v6}, Ljava/io/RandomAccessFile;->writeInt(I)V

    invoke-virtual {v0, v5}, Ljava/io/RandomAccessFile;->write([B)V

    const-wide/16 v5, 0xc8

    invoke-virtual {v0, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeBoolean(Z)V

    const-wide/16 v5, 0x320

    invoke-virtual {v0, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeBoolean(Z)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_0

    :cond_2
    return-void

    :cond_3
    :goto_0
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v4, "rw"

    invoke-direct {v0, v1, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "%d_%02d_%02d"

    invoke-direct {p0, v2}, Lcom/baidu/location/a/d;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->writeInt(I)V

    invoke-virtual {v0, p1}, Ljava/io/RandomAccessFile;->write([B)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception p1

    :goto_1
    return-void
.end method

.method private c(Landroid/location/Location;)V
    .locals 5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/a/d;->a:J

    sub-long/2addr v0, v2

    iget v2, p0, Lcom/baidu/location/a/d;->H:I

    int-to-long v2, v2

    cmp-long v4, v0, v2

    if-ltz v4, :cond_3

    if-nez p1, :cond_0

    goto :goto_1

    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Landroid/location/Location;->hasSpeed()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Landroid/location/Location;->getSpeed()F

    move-result v0

    iget v1, p0, Lcom/baidu/location/a/d;->E:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    invoke-virtual {p1}, Landroid/location/Location;->getSpeed()F

    move-result v0

    iput v0, p0, Lcom/baidu/location/a/d;->E:F

    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    if-nez v0, :cond_2

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-direct {p0}, Lcom/baidu/location/a/d;->i()V

    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->d(Landroid/location/Location;)V

    goto :goto_0

    :cond_2
    invoke-direct {p0, p1}, Lcom/baidu/location/a/d;->e(Landroid/location/Location;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    :goto_0
    iget p1, p0, Lcom/baidu/location/a/d;->L:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/baidu/location/a/d;->L:I

    :cond_3
    :goto_1
    return-void
.end method

.method private c(Ljava/lang/String;)V
    .locals 3

    if-eqz p1, :cond_f

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string p1, "on"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    const-string p1, "on"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->k:I

    :cond_0
    const-string p1, "bash"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_1

    const-string p1, "bash"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/d;->l:D

    :cond_1
    const-string p1, "net"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_2

    const-string p1, "net"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/baidu/location/a/d;->m:Ljava/lang/String;

    :cond_2
    const-string p1, "tcon"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_3

    const-string p1, "tcon"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->n:I

    :cond_3
    const-string p1, "tcsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_4

    const-string p1, "tcsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->o:I

    :cond_4
    const-string p1, "per"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_5

    const-string p1, "per"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->p:I

    :cond_5
    const-string p1, "chdron"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_6

    const-string p1, "chdron"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->q:I

    :cond_6
    const-string p1, "spsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_7

    const-string p1, "spsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/d;->r:D

    :cond_7
    const-string p1, "acsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_8

    const-string p1, "acsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/d;->s:D

    :cond_8
    const-string p1, "stspsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_9

    const-string p1, "stspsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v1

    iput-wide v1, p0, Lcom/baidu/location/a/d;->t:D

    :cond_9
    const-string p1, "drstsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_a

    const-string p1, "drstsh"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->u:I

    :cond_a
    const-string p1, "stper"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_b

    const-string p1, "stper"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->v:I

    :cond_b
    const-string p1, "nondron"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_c

    const-string p1, "nondron"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->w:I

    :cond_c
    const-string p1, "nondrper"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_d

    const-string p1, "nondrper"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lcom/baidu/location/a/d;->x:I

    :cond_d
    const-string p1, "uptime"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_e

    const-string p1, "uptime"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/d;->z:J

    :cond_e
    invoke-direct {p0}, Lcom/baidu/location/a/d;->k()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    :cond_f
    :goto_0
    return-void
.end method

.method private d()V
    .locals 5

    const-string v0, "7.5.2"

    const-string v1, "\\."

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    const/4 v3, 0x0

    aput-byte v3, v2, v3

    const/4 v4, 0x1

    aput-byte v3, v2, v4

    const/4 v4, 0x2

    aput-byte v3, v2, v4

    const/4 v4, 0x3

    aput-byte v3, v2, v4

    const/4 v2, 0x4

    if-lt v1, v2, :cond_0

    const/4 v1, 0x4

    :cond_0
    :goto_0
    if-ge v3, v1, :cond_1

    :try_start_0
    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    aget-object v4, v0, v3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/baidu/location/d/b;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/baidu/location/d/b;->a()Lcom/baidu/location/d/b;

    move-result-object v1

    iget-object v1, v1, Lcom/baidu/location/d/b;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/baidu/location/a/d;->a(Ljava/lang/String;)[B

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/location/a/d;->K:[B

    return-void
.end method

.method private d(Landroid/location/Location;)V
    .locals 4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/d;->e:J

    invoke-virtual {p1}, Landroid/location/Location;->getTime()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    long-to-int v1, v0

    invoke-direct {p0, v1}, Lcom/baidu/location/a/d;->b(I)V

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v0

    const-wide v2, 0x412e848000000000L    # 1000000.0

    mul-double v0, v0, v2

    double-to-int v0, v0

    invoke-direct {p0, v0}, Lcom/baidu/location/a/d;->b(I)V

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    mul-double v0, v0, v2

    double-to-int v0, v0

    invoke-direct {p0, v0}, Lcom/baidu/location/a/d;->b(I)V

    invoke-virtual {p1}, Landroid/location/Location;->hasBearing()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    invoke-virtual {p1}, Landroid/location/Location;->hasSpeed()Z

    move-result v1

    xor-int/lit8 v1, v1, 0x1

    if-lez v0, :cond_0

    const/16 v0, 0x20

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Landroid/location/Location;->getBearing()F

    move-result v0

    const/high16 v2, 0x41700000    # 15.0f

    div-float/2addr v0, v2

    float-to-int v0, v0

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    and-int/lit8 v0, v0, -0x21

    int-to-byte v0, v0

    :goto_0
    iget-object v2, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-lez v1, :cond_1

    const/16 v0, -0x80

    goto :goto_1

    :cond_1
    invoke-virtual {p1}, Landroid/location/Location;->getSpeed()F

    move-result v0

    float-to-double v0, v0

    const-wide v2, 0x400ccccccccccccdL    # 3.6

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v0, v0, v2

    const-wide/high16 v2, 0x4010000000000000L    # 4.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    and-int/lit8 v0, v0, 0x7f

    int-to-byte v0, v0

    :goto_1
    iget-object v1, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iput-object p1, p0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    return-void
.end method

.method private d(Ljava/lang/String;)V
    .locals 6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/baidu/location/d/i;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "/grtcf.dat"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :try_start_0
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v2, "rw"

    invoke-direct {v0, v1, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const-wide/16 v1, 0x2

    invoke-virtual {v0, v1, v2}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v1

    const-wide/16 v2, 0x8

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v2

    new-array v3, v2, [B

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4, v2}, Ljava/io/RandomAccessFile;->read([BII)I

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    const-string v3, "%d_%02d_%02d"

    invoke-direct {p0, v3}, Lcom/baidu/location/a/d;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    const/4 v5, 0x1

    if-eqz v3, :cond_0

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    if-eqz v3, :cond_0

    :try_start_1
    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    if-le v3, v5, :cond_0

    aget-object v2, v2, v5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iput v2, p0, Lcom/baidu/location/a/d;->y:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    :catch_0
    move-exception v2

    :cond_0
    :goto_0
    if-gt v5, v1, :cond_2

    mul-int/lit16 v2, v5, 0x800

    int-to-long v2, v2

    :try_start_2
    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v2

    new-array v3, v2, [B

    invoke-virtual {v0, v3, v4, v2}, Ljava/io/RandomAccessFile;->read([BII)I

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    if-eqz p1, :cond_1

    invoke-virtual {v2, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-direct {p0, v2}, Lcom/baidu/location/a/d;->c(Ljava/lang/String;)V

    goto :goto_1

    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    :cond_2
    :goto_1
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_2

    :catch_1
    move-exception p1

    :cond_3
    :goto_2
    return-void
.end method

.method private e(Landroid/location/Location;)V
    .locals 21

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    if-nez v1, :cond_0

    return-void

    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    iget-object v4, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v4}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    sub-double/2addr v2, v4

    const-wide v4, 0x412e848000000000L    # 1000000.0

    mul-double v2, v2, v4

    double-to-int v2, v2

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    iget-object v3, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v3}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    sub-double/2addr v6, v8

    mul-double v6, v6, v4

    double-to-int v3, v6

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->hasBearing()Z

    move-result v4

    const/4 v5, 0x1

    xor-int/2addr v4, v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->hasSpeed()Z

    move-result v6

    xor-int/2addr v6, v5

    if-lez v2, :cond_1

    const/4 v8, 0x0

    goto :goto_0

    :cond_1
    const/4 v8, 0x1

    :goto_0
    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    if-lez v3, :cond_2

    const/4 v9, 0x0

    goto :goto_1

    :cond_2
    const/4 v9, 0x1

    :goto_1
    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v3

    iget v10, v0, Lcom/baidu/location/a/d;->L:I

    if-le v10, v5, :cond_3

    const/4 v5, 0x0

    iput-object v5, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    iget-object v5, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    iput-object v5, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    :cond_3
    iput-object v1, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    iget-object v5, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    if-eqz v5, :cond_4

    iget-object v10, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    if-eqz v10, :cond_4

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v10

    iget-object v5, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v12

    cmp-long v5, v10, v12

    if-lez v5, :cond_4

    iget-object v5, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v10

    iget-object v5, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v12

    sub-long/2addr v10, v12

    const-wide/16 v12, 0x1388

    cmp-long v5, v10, v12

    if-gez v5, :cond_4

    iget-object v5, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v10

    iget-object v5, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v5}, Landroid/location/Location;->getTime()J

    move-result-wide v12

    sub-long/2addr v10, v12

    const/4 v5, 0x2

    new-array v5, v5, [F

    iget-object v12, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v12}, Landroid/location/Location;->getAltitude()D

    move-result-wide v12

    iget-object v14, v0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    invoke-virtual {v14}, Landroid/location/Location;->getLongitude()D

    move-result-wide v14

    iget-object v7, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v7}, Landroid/location/Location;->getLatitude()D

    move-result-wide v16

    iget-object v7, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v7}, Landroid/location/Location;->getLongitude()D

    move-result-wide v18

    move-object/from16 v20, v5

    invoke-static/range {v12 .. v20}, Landroid/location/Location;->distanceBetween(DDDD[F)V

    const/high16 v7, 0x40000000    # 2.0f

    const/4 v12, 0x0

    aget v5, v5, v12

    iget-object v12, v0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    invoke-virtual {v12}, Landroid/location/Location;->getSpeed()F

    move-result v12

    long-to-float v13, v10

    mul-float v12, v12, v13

    sub-float/2addr v5, v12

    mul-float v5, v5, v7

    mul-long v10, v10, v10

    long-to-float v7, v10

    div-float/2addr v5, v7

    float-to-double v10, v5

    iget v5, v0, Lcom/baidu/location/a/d;->F:F

    float-to-double v12, v5

    cmpl-double v5, v10, v12

    if-lez v5, :cond_4

    double-to-float v5, v10

    iput v5, v0, Lcom/baidu/location/a/d;->F:F

    :cond_4
    iget-object v5, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    and-int/lit16 v7, v2, 0xff

    int-to-byte v7, v7

    invoke-static {v7}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v7

    invoke-interface {v5, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v5, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const v7, 0xff00

    and-int/2addr v2, v7

    shr-int/lit8 v2, v2, 0x8

    int-to-byte v2, v2

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v2, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    and-int/lit16 v5, v3, 0xff

    int-to-byte v5, v5

    invoke-static {v5}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v2, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    and-int/2addr v3, v7

    shr-int/lit8 v3, v3, 0x8

    int-to-byte v3, v3

    invoke-static {v3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-lez v4, :cond_6

    const/16 v2, 0x20

    if-lez v9, :cond_5

    const/16 v2, 0x60

    int-to-byte v2, v2

    :cond_5
    if-lez v8, :cond_8

    goto :goto_2

    :cond_6
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getBearing()F

    move-result v2

    const/high16 v3, 0x41700000    # 15.0f

    div-float/2addr v2, v3

    float-to-int v2, v2

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    and-int/lit8 v2, v2, 0x1f

    int-to-byte v2, v2

    if-lez v9, :cond_7

    or-int/lit8 v2, v2, 0x40

    int-to-byte v2, v2

    :cond_7
    if-lez v8, :cond_8

    :goto_2
    or-int/lit8 v2, v2, -0x80

    int-to-byte v2, v2

    :cond_8
    iget-object v3, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-lez v6, :cond_9

    iget-object v1, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const/16 v2, -0x80

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    :cond_9
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getSpeed()F

    move-result v1

    float-to-double v1, v1

    const-wide v3, 0x400ccccccccccccdL    # 3.6

    invoke-static {v1, v2}, Ljava/lang/Double;->isNaN(D)Z

    mul-double v1, v1, v3

    const-wide/high16 v3, 0x4010000000000000L    # 4.0

    div-double/2addr v1, v3

    double-to-int v1, v1

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    and-int/lit8 v1, v1, 0x7f

    int-to-byte v1, v1

    iget-object v2, v0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_3
    return-void
.end method

.method private e(Ljava/lang/String;)V
    .locals 8

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/baidu/location/d/i;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "/grtcf.dat"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :try_start_0
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    const-wide/16 v2, 0x2

    const/4 v4, 0x0

    if-nez v0, :cond_2

    new-instance v0, Ljava/io/File;

    sget-object v5, Lcom/baidu/location/d/i;->a:Ljava/lang/String;

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    :cond_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v5, "rw"

    invoke-direct {v0, v1, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeInt(I)V

    const-wide/16 v5, 0x8

    invoke-virtual {v0, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    const-string v5, "1980_01_01:0"

    invoke-virtual {v5}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    array-length v6, v5

    invoke-virtual {v0, v6}, Ljava/io/RandomAccessFile;->writeInt(I)V

    invoke-virtual {v0, v5}, Ljava/io/RandomAccessFile;->write([B)V

    const-wide/16 v5, 0xc8

    invoke-virtual {v0, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeBoolean(Z)V

    const-wide/16 v5, 0x320

    invoke-virtual {v0, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v4}, Ljava/io/RandomAccessFile;->writeBoolean(Z)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_0

    :cond_1
    return-void

    :cond_2
    :goto_0
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v5, "rw"

    invoke-direct {v0, v1, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v1

    const/4 v5, 0x1

    :goto_1
    if-gt v5, v1, :cond_4

    mul-int/lit16 v6, v5, 0x800

    int-to-long v6, v6

    invoke-virtual {v0, v6, v7}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v6

    new-array v7, v6, [B

    invoke-virtual {v0, v7, v4, v6}, Ljava/io/RandomAccessFile;->read([BII)I

    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, v7}, Ljava/lang/String;-><init>([B)V

    sget-object v7, Lcom/baidu/location/d/b;->d:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_3

    goto :goto_2

    :cond_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    :cond_4
    :goto_2
    if-lt v5, v1, :cond_5

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {v0, v5}, Ljava/io/RandomAccessFile;->writeInt(I)V

    :cond_5
    mul-int/lit16 v5, v5, 0x800

    int-to-long v1, v5

    invoke-virtual {v0, v1, v2}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->writeInt(I)V

    invoke-virtual {v0, p1}, Ljava/io/RandomAccessFile;->write([B)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_3

    :catch_0
    move-exception p1

    :goto_3
    return-void
.end method

.method private e()Z
    .locals 5

    const/4 v0, 0x0

    const/4 v1, 0x0

    :try_start_0
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/j;->g()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "gflk.dat"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v2}, Ljava/io/File;->createNewFile()Z

    :cond_0
    new-instance v3, Ljava/io/RandomAccessFile;

    const-string v4, "rw"

    invoke-direct {v3, v2, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v2
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->tryLock()Ljava/nio/channels/FileLock;

    move-result-object v0
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    move-object v0, v2

    goto :goto_2

    :catch_0
    move-exception v1

    const/4 v1, 0x1

    :goto_0
    if-eqz v0, :cond_1

    :try_start_3
    invoke-virtual {v0}, Ljava/nio/channels/FileLock;->release()V

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_6

    :cond_1
    :goto_1
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V

    :cond_2
    if-eqz v3, :cond_5

    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_6

    :catchall_1
    move-exception v1

    goto :goto_2

    :catch_2
    move-exception v0

    move-object v0, v3

    goto :goto_5

    :catchall_2
    move-exception v1

    move-object v3, v0

    :goto_2
    if-eqz v0, :cond_3

    :try_start_4
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V

    goto :goto_3

    :catch_3
    move-exception v0

    goto :goto_4

    :cond_3
    :goto_3
    if-eqz v3, :cond_4

    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    :cond_4
    :goto_4
    throw v1

    :catch_4
    move-exception v2

    :goto_5
    if-eqz v0, :cond_5

    :try_start_5
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    :cond_5
    :goto_6
    return v1
.end method

.method private f()Z
    .locals 7

    iget-boolean v0, p0, Lcom/baidu/location/a/d;->B:Z

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Lcom/baidu/location/a/d;->C:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/baidu/location/a/d;->E:F

    float-to-double v3, v0

    iget-wide v5, p0, Lcom/baidu/location/a/d;->t:D

    cmpg-double v0, v3, v5

    if-gez v0, :cond_0

    iget v0, p0, Lcom/baidu/location/a/d;->D:I

    iget v3, p0, Lcom/baidu/location/a/d;->p:I

    add-int/2addr v0, v3

    iput v0, p0, Lcom/baidu/location/a/d;->D:I

    iget v0, p0, Lcom/baidu/location/a/d;->D:I

    iget v3, p0, Lcom/baidu/location/a/d;->u:I

    if-le v0, v3, :cond_6

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Lcom/baidu/location/a/d;->G:J

    sub-long/2addr v3, v5

    iget v0, p0, Lcom/baidu/location/a/d;->v:I

    mul-int/lit16 v0, v0, 0x3e8

    int-to-long v5, v0

    cmp-long v0, v3, v5

    if-lez v0, :cond_4

    goto :goto_1

    :cond_0
    iput v1, p0, Lcom/baidu/location/a/d;->D:I

    iput-boolean v1, p0, Lcom/baidu/location/a/d;->C:Z

    goto :goto_1

    :cond_1
    iget v0, p0, Lcom/baidu/location/a/d;->E:F

    float-to-double v3, v0

    iget-wide v5, p0, Lcom/baidu/location/a/d;->t:D

    cmpg-double v0, v3, v5

    if-gez v0, :cond_6

    iput-boolean v2, p0, Lcom/baidu/location/a/d;->C:Z

    iput v1, p0, Lcom/baidu/location/a/d;->D:I

    iget v0, p0, Lcom/baidu/location/a/d;->D:I

    iget v1, p0, Lcom/baidu/location/a/d;->p:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/baidu/location/a/d;->D:I

    goto :goto_1

    :cond_2
    iget v0, p0, Lcom/baidu/location/a/d;->E:F

    float-to-double v3, v0

    iget-wide v5, p0, Lcom/baidu/location/a/d;->r:D

    cmpl-double v0, v3, v5

    if-gez v0, :cond_5

    iget v0, p0, Lcom/baidu/location/a/d;->F:F

    float-to-double v3, v0

    iget-wide v5, p0, Lcom/baidu/location/a/d;->s:D

    cmpl-double v0, v3, v5

    if-ltz v0, :cond_3

    goto :goto_0

    :cond_3
    iget v0, p0, Lcom/baidu/location/a/d;->w:I

    if-ne v0, v2, :cond_4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Lcom/baidu/location/a/d;->G:J

    sub-long/2addr v3, v5

    iget v0, p0, Lcom/baidu/location/a/d;->x:I

    mul-int/lit16 v0, v0, 0x3e8

    int-to-long v5, v0

    cmp-long v0, v3, v5

    if-lez v0, :cond_4

    goto :goto_1

    :cond_4
    const/4 v2, 0x0

    goto :goto_1

    :cond_5
    :goto_0
    iput-boolean v2, p0, Lcom/baidu/location/a/d;->B:Z

    :cond_6
    :goto_1
    return v2
.end method

.method private g()V
    .locals 3

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Lcom/baidu/location/a/d;->e:J

    const/4 v1, 0x0

    iput v1, p0, Lcom/baidu/location/a/d;->L:I

    iput-object v0, p0, Lcom/baidu/location/a/d;->b:Landroid/location/Location;

    iput-object v0, p0, Lcom/baidu/location/a/d;->c:Landroid/location/Location;

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/a/d;->E:F

    iput v0, p0, Lcom/baidu/location/a/d;->F:F

    return-void
.end method

.method private h()V
    .locals 5

    iget-wide v0, p0, Lcom/baidu/location/a/d;->e:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-eqz v4, :cond_9

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/a/d;->e:J

    sub-long/2addr v0, v2

    iget v2, p0, Lcom/baidu/location/a/d;->p:I

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    cmp-long v4, v0, v2

    if-gez v4, :cond_0

    goto/16 :goto_2

    :cond_0
    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "loc_navi_mode"

    const/4 v2, 0x4

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "is_navi_on"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    return-void

    :cond_1
    iget v0, p0, Lcom/baidu/location/a/d;->n:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    invoke-direct {p0}, Lcom/baidu/location/a/d;->f()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    return-void

    :cond_2
    sget-object v0, Lcom/baidu/location/d/b;->d:Ljava/lang/String;

    const-string v3, "com.ubercab.driver"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Lcom/baidu/location/d/b;->d:Ljava/lang/String;

    invoke-static {}, Lcom/baidu/location/f;->getServiceContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0, v0, v3}, Lcom/baidu/location/a/d;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_4

    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    return-void

    :cond_3
    invoke-direct {p0}, Lcom/baidu/location/a/d;->e()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    return-void

    :cond_4
    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    if-eqz v0, :cond_9

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v3, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    and-int/lit16 v4, v0, 0xff

    int-to-byte v4, v4

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v3, v2, v4}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    iget-object v3, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const v4, 0xff00

    and-int/2addr v4, v0

    shr-int/lit8 v4, v4, 0x8

    int-to-byte v4, v4

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v3, v1, v4}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const/4 v3, 0x3

    iget v4, p0, Lcom/baidu/location/a/d;->L:I

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    new-array v1, v0, [B

    :goto_0
    if-ge v2, v0, :cond_5

    iget-object v3, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Byte;

    invoke-virtual {v3}, Ljava/lang/Byte;->byteValue()B

    move-result v3

    aput-byte v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_5
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    const-string v2, "mounted"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    new-instance v2, Ljava/io/File;

    const-string v3, "baidu/tempdata"

    invoke-direct {v2, v0, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_6

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    :cond_6
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_8

    const-string v0, "intime.dat"

    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v2, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    :cond_7
    :try_start_0
    new-instance v0, Ljava/io/BufferedOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-virtual {v0, v1}, Ljava/io/BufferedOutputStream;->write([B)V

    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->flush()V

    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->close()V

    new-instance v0, Lcom/baidu/location/a/f;

    invoke-direct {v0, p0}, Lcom/baidu/location/a/f;-><init>(Lcom/baidu/location/a/d;)V

    invoke-virtual {v0}, Lcom/baidu/location/a/f;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    :cond_8
    :goto_1
    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/baidu/location/a/d;->G:J

    :cond_9
    :goto_2
    return-void
.end method

.method private i()V
    .locals 4

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcom/baidu/location/a/d;->f:Ljava/lang/String;

    const-string v2, "0"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const/16 v2, -0x52

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    const/16 v2, -0x42

    :goto_0
    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    aget-byte v2, v2, v1

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    const/4 v3, 0x1

    aget-byte v2, v2, v3

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    const/4 v3, 0x2

    aget-byte v2, v2, v3

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iget-object v2, p0, Lcom/baidu/location/a/d;->J:[B

    const/4 v3, 0x3

    aget-byte v2, v2, v3

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/baidu/location/a/d;->K:[B

    array-length v0, v0

    iget-object v2, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    add-int/lit8 v3, v0, 0x1

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    invoke-static {v3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_1
    if-ge v1, v0, :cond_1

    iget-object v2, p0, Lcom/baidu/location/a/d;->M:Ljava/util/List;

    iget-object v3, p0, Lcom/baidu/location/a/d;->K:[B

    aget-byte v3, v3, v1

    invoke-static {v3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    return-void
.end method

.method private j()V
    .locals 5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/baidu/location/a/d;->z:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    cmp-long v4, v0, v2

    if-lez v4, :cond_1

    iget-object v0, p0, Lcom/baidu/location/a/d;->A:Lcom/baidu/location/a/d$a;

    if-nez v0, :cond_0

    new-instance v0, Lcom/baidu/location/a/d$a;

    invoke-direct {v0, p0}, Lcom/baidu/location/a/d$a;-><init>(Lcom/baidu/location/a/d;)V

    iput-object v0, p0, Lcom/baidu/location/a/d;->A:Lcom/baidu/location/a/d$a;

    :cond_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    invoke-static {}, Lcom/baidu/location/d/b;->a()Lcom/baidu/location/d/b;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/baidu/location/d/b;->a(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-static {}, Lcom/baidu/location/a/a;->a()Lcom/baidu/location/a/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/baidu/location/a/a;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lcom/baidu/location/a/d;->A:Lcom/baidu/location/a/d$a;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/baidu/location/a/d$a;->a(Ljava/lang/String;)V

    :cond_1
    invoke-direct {p0}, Lcom/baidu/location/a/d;->k()V

    return-void
.end method

.method private k()V
    .locals 0

    return-void
.end method


# virtual methods
.method public a(Landroid/location/Location;)V
    .locals 3

    iget-boolean v0, p0, Lcom/baidu/location/a/d;->N:Z

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/baidu/location/a/d;->c()V

    :cond_0
    iget v0, p0, Lcom/baidu/location/a/d;->k:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/baidu/location/a/d;->m:Ljava/lang/String;

    invoke-static {}, Lcom/baidu/location/b/b;->a()Lcom/baidu/location/b/b;

    move-result-object v2

    invoke-virtual {v2}, Lcom/baidu/location/b/b;->e()I

    move-result v2

    invoke-static {v2}, Lcom/baidu/location/b/d;->a(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/baidu/location/a/d;->n:I

    if-ne v0, v1, :cond_1

    iget v0, p0, Lcom/baidu/location/a/d;->y:I

    iget v1, p0, Lcom/baidu/location/a/d;->o:I

    if-le v0, v1, :cond_1

    return-void

    :cond_1
    iget-object v0, p0, Lcom/baidu/location/a/d;->I:Landroid/os/Handler;

    new-instance v1, Lcom/baidu/location/a/e;

    invoke-direct {v1, p0, p1}, Lcom/baidu/location/a/e;-><init>(Lcom/baidu/location/a/d;Landroid/location/Location;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :cond_2
    return-void
.end method

.method public b()V
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/a/d;->N:Z

    if-nez v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baidu/location/a/d;->N:Z

    invoke-direct {p0}, Lcom/baidu/location/a/d;->g()V

    return-void
.end method
