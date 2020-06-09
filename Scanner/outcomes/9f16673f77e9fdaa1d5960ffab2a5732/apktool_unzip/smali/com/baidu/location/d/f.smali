.class Lcom/baidu/location/d/f;
.super Ljava/lang/Thread;


# instance fields
.field final synthetic a:Lcom/baidu/location/d/e;


# direct methods
.method constructor <init>(Lcom/baidu/location/d/e;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    iget-object v0, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    invoke-static {}, Lcom/baidu/location/d/j;->c()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    iget-object v0, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    invoke-static {v0}, Lcom/baidu/location/d/e;->a(Lcom/baidu/location/d/e;)V

    iget-object v0, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    invoke-virtual {v0}, Lcom/baidu/location/d/e;->a()V

    iget-object v0, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    iget v0, v0, Lcom/baidu/location/d/e;->i:I

    const/4 v1, 0x0

    move-object v2, v1

    :goto_0
    const/4 v3, 0x1

    const/4 v4, 0x0

    if-lez v0, :cond_c

    :try_start_0
    new-instance v5, Ljava/net/URL;

    iget-object v6, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    iget-object v6, v6, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    invoke-direct {v5, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v5

    check-cast v5, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    :try_start_1
    const-string v2, "GET"

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    invoke-virtual {v5, v3}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    invoke-virtual {v5, v4}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    sget v2, Lcom/baidu/location/d/a;->b:I

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    sget v2, Lcom/baidu/location/d/a;->b:I

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    const-string v2, "Content-Type"

    const-string v6, "application/x-www-form-urlencoded; charset=utf-8"

    invoke-virtual {v5, v2, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "Accept-Charset"

    const-string v6, "UTF-8"

    invoke-virtual {v5, v2, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    const/16 v6, 0xc8

    if-ne v2, v6, :cond_1

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :try_start_2
    new-instance v6, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v6}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    const/16 v7, 0x400

    :try_start_3
    new-array v7, v7, [B

    :goto_1
    invoke-virtual {v2, v7}, Ljava/io/InputStream;->read([B)I

    move-result v8

    const/4 v9, -0x1

    if-eq v8, v9, :cond_0

    invoke-virtual {v6, v7, v4, v8}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_1

    :cond_0
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->close()V

    iget-object v7, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    new-instance v8, Ljava/lang/String;

    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v9

    const-string v10, "utf-8"

    invoke-direct {v8, v9, v10}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iput-object v8, v7, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-object v7, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    invoke-virtual {v7, v3}, Lcom/baidu/location/d/e;->a(Z)V

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    const/4 v7, 0x1

    goto :goto_4

    :catchall_0
    move-exception v0

    goto :goto_2

    :catch_0
    move-exception v7

    goto :goto_3

    :catchall_1
    move-exception v0

    move-object v6, v1

    :goto_2
    move-object v1, v2

    goto/16 :goto_c

    :catch_1
    move-exception v6

    move-object v6, v1

    :goto_3
    move-object v11, v5

    move-object v5, v2

    move-object v2, v11

    goto :goto_8

    :cond_1
    :try_start_4
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-object v2, v1

    move-object v6, v2

    const/4 v7, 0x0

    :goto_4
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_2
    if-eqz v2, :cond_3

    :try_start_5
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    goto :goto_5

    :catch_2
    move-exception v2

    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    :cond_3
    :goto_5
    if-eqz v6, :cond_4

    :try_start_6
    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_6

    :catch_3
    move-exception v2

    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    :cond_4
    :goto_6
    move-object v2, v5

    goto :goto_b

    :catchall_2
    move-exception v0

    move-object v6, v1

    goto :goto_c

    :catch_4
    move-exception v2

    move-object v6, v1

    move-object v2, v5

    move-object v5, v6

    goto :goto_8

    :catchall_3
    move-exception v0

    move-object v6, v1

    :goto_7
    move-object v5, v2

    goto :goto_c

    :catch_5
    move-exception v5

    move-object v5, v1

    move-object v6, v5

    :goto_8
    :try_start_7
    sget-object v7, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v8, "NetworkCommunicationException!"

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    if-eqz v2, :cond_5

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_5
    if-eqz v5, :cond_6

    :try_start_8
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_6

    goto :goto_9

    :catch_6
    move-exception v5

    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    :cond_6
    :goto_9
    if-eqz v6, :cond_7

    :try_start_9
    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_7

    goto :goto_a

    :catch_7
    move-exception v5

    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    :cond_7
    :goto_a
    const/4 v7, 0x0

    :goto_b
    if-eqz v7, :cond_8

    goto :goto_f

    :cond_8
    add-int/lit8 v0, v0, -0x1

    goto/16 :goto_0

    :catchall_4
    move-exception v0

    move-object v1, v5

    goto :goto_7

    :goto_c
    if-eqz v5, :cond_9

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_9
    if-eqz v1, :cond_a

    :try_start_a
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_8

    goto :goto_d

    :catch_8
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    :cond_a
    :goto_d
    if-eqz v6, :cond_b

    :try_start_b
    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_9

    goto :goto_e

    :catch_9
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    :cond_b
    :goto_e
    throw v0

    :cond_c
    :goto_f
    if-gtz v0, :cond_d

    sget v0, Lcom/baidu/location/d/e;->o:I

    add-int/2addr v0, v3

    sput v0, Lcom/baidu/location/d/e;->o:I

    iget-object v0, p0, Lcom/baidu/location/d/f;->a:Lcom/baidu/location/d/e;

    iput-object v1, v0, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    invoke-virtual {v0, v4}, Lcom/baidu/location/d/e;->a(Z)V

    goto :goto_10

    :cond_d
    sput v4, Lcom/baidu/location/d/e;->o:I

    :goto_10
    return-void
.end method
