.class Lcom/baidu/location/d/h;
.super Ljava/lang/Thread;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/baidu/location/d/e;


# direct methods
.method constructor <init>(Lcom/baidu/location/d/e;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iput-object p2, p0, Lcom/baidu/location/d/h;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    iget-object v0, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-virtual {v0}, Lcom/baidu/location/d/e;->a()V

    iget-object v0, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-static {v0}, Lcom/baidu/location/d/e;->a(Lcom/baidu/location/d/e;)V

    iget-object v0, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iget-object v1, p0, Lcom/baidu/location/d/h;->a:Ljava/lang/String;

    iput-object v1, v0, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    const/4 v0, 0x0

    const/4 v1, 0x0

    :try_start_0
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    new-instance v3, Ljava/net/URL;

    iget-object v4, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iget-object v4, v4, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_f
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_c
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    :try_start_1
    invoke-virtual {v3}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v4

    check-cast v4, Ljavax/net/ssl/HttpsURLConnection;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_b
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_a
    .catchall {:try_start_1 .. :try_end_1} :catchall_4

    :try_start_2
    invoke-virtual {v4, v0}, Ljavax/net/ssl/HttpsURLConnection;->setInstanceFollowRedirects(Z)V

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Ljavax/net/ssl/HttpsURLConnection;->setDoOutput(Z)V

    invoke-virtual {v4, v5}, Ljavax/net/ssl/HttpsURLConnection;->setDoInput(Z)V

    sget v6, Lcom/baidu/location/d/a;->b:I

    invoke-virtual {v4, v6}, Ljavax/net/ssl/HttpsURLConnection;->setConnectTimeout(I)V

    sget v6, Lcom/baidu/location/d/a;->c:I

    invoke-virtual {v4, v6}, Ljavax/net/ssl/HttpsURLConnection;->setReadTimeout(I)V

    const-string v6, "POST"

    invoke-virtual {v4, v6}, Ljavax/net/ssl/HttpsURLConnection;->setRequestMethod(Ljava/lang/String;)V

    const-string v6, "Content-Type"

    const-string v7, "application/x-www-form-urlencoded; charset=utf-8"

    invoke-virtual {v4, v6, v7}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v6, "Accept-Encoding"

    const-string v7, "gzip"

    invoke-virtual {v4, v6, v7}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v6, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iget-object v6, v6, Lcom/baidu/location/d/e;->k:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v8, "="

    invoke-virtual {v2, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    const-string v7, "&"

    invoke-virtual {v2, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    if-lez v6, :cond_1

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    sub-int/2addr v6, v5

    invoke-virtual {v2, v6}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    :cond_1
    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v6
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_9
    .catch Ljava/lang/Error; {:try_start_2 .. :try_end_2} :catch_8
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    :try_start_3
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/io/OutputStream;->write([B)V

    invoke-virtual {v6}, Ljava/io/OutputStream;->flush()V

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v2

    const/16 v7, 0xc8

    if-ne v2, v7, :cond_4

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_7
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_6
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :try_start_4
    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_2

    const-string v8, "gzip"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_2

    new-instance v7, Ljava/util/zip/GZIPInputStream;

    new-instance v8, Ljava/io/BufferedInputStream;

    invoke-direct {v8, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v7, v8}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    move-object v2, v7

    :cond_2
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/Error; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    const/16 v8, 0x400

    :try_start_5
    new-array v8, v8, [B

    :goto_1
    invoke-virtual {v2, v8}, Ljava/io/InputStream;->read([B)I

    move-result v9

    const/4 v10, -0x1

    if-eq v9, v10, :cond_3

    invoke-virtual {v7, v8, v0, v9}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_1

    :cond_3
    iget-object v8, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    new-instance v9, Ljava/lang/String;

    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v10

    const-string v11, "utf-8"

    invoke-direct {v9, v10, v11}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iput-object v9, v8, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-object v8, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-virtual {v8, v5}, Lcom/baidu/location/d/e;->a(Z)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/Error; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-object v1, v2

    goto :goto_5

    :catchall_0
    move-exception v0

    goto :goto_2

    :catch_0
    move-exception v5

    goto :goto_3

    :catch_1
    move-exception v5

    goto :goto_4

    :catchall_1
    move-exception v0

    move-object v7, v1

    :goto_2
    move-object v1, v2

    goto/16 :goto_15

    :catch_2
    move-exception v5

    move-object v7, v1

    :goto_3
    move-object v12, v5

    move-object v5, v2

    move-object v2, v12

    goto/16 :goto_c

    :catch_3
    move-exception v5

    move-object v7, v1

    :goto_4
    move-object v12, v5

    move-object v5, v2

    move-object v2, v12

    goto/16 :goto_11

    :cond_4
    :try_start_6
    iget-object v2, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iput-object v1, v2, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-object v2, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-virtual {v2, v0}, Lcom/baidu/location/d/e;->a(Z)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_7
    .catch Ljava/lang/Error; {:try_start_6 .. :try_end_6} :catch_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    move-object v7, v1

    :goto_5
    if-eqz v4, :cond_5

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_5
    if-eqz v6, :cond_6

    :try_start_7
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4

    goto :goto_6

    :catch_4
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close os IOException!"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_6
    :goto_6
    if-eqz v1, :cond_7

    :try_start_8
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto :goto_7

    :catch_5
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close is IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7
    :goto_7
    if-eqz v7, :cond_e

    :try_start_9
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_12

    goto/16 :goto_14

    :catchall_2
    move-exception v0

    move-object v7, v1

    goto/16 :goto_15

    :catch_6
    move-exception v2

    move-object v5, v1

    move-object v7, v5

    goto :goto_c

    :catch_7
    move-exception v2

    move-object v5, v1

    move-object v7, v5

    goto/16 :goto_11

    :catchall_3
    move-exception v0

    move-object v6, v1

    goto :goto_9

    :catch_8
    move-exception v2

    move-object v5, v1

    goto :goto_b

    :catch_9
    move-exception v2

    move-object v5, v1

    goto/16 :goto_10

    :catchall_4
    move-exception v0

    move-object v4, v1

    goto :goto_8

    :catch_a
    move-exception v2

    move-object v4, v1

    goto :goto_a

    :catch_b
    move-exception v2

    move-object v4, v1

    goto :goto_f

    :catchall_5
    move-exception v0

    move-object v3, v1

    move-object v4, v3

    :goto_8
    move-object v6, v4

    :goto_9
    move-object v7, v6

    goto/16 :goto_15

    :catch_c
    move-exception v2

    move-object v3, v1

    move-object v4, v3

    :goto_a
    move-object v5, v4

    :goto_b
    move-object v6, v5

    move-object v7, v6

    :goto_c
    :try_start_a
    invoke-virtual {v2}, Ljava/lang/Error;->printStackTrace()V

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v8, "https NetworkCommunicationError!"

    invoke-static {v2, v8}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v2, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iput-object v1, v2, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-object v1, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-virtual {v1, v0}, Lcom/baidu/location/d/e;->a(Z)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_6

    if-eqz v4, :cond_8

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_8
    if-eqz v6, :cond_9

    :try_start_b
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_d

    goto :goto_d

    :catch_d
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close os IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_9
    :goto_d
    if-eqz v5, :cond_a

    :try_start_c
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_e

    goto :goto_e

    :catch_e
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close is IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_a
    :goto_e
    if-eqz v7, :cond_e

    :try_start_d
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_12

    goto :goto_14

    :catch_f
    move-exception v2

    move-object v3, v1

    move-object v4, v3

    :goto_f
    move-object v5, v4

    :goto_10
    move-object v6, v5

    move-object v7, v6

    :goto_11
    :try_start_e
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v8, "https NetworkCommunicationException!"

    invoke-static {v2, v8}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v2, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    iput-object v1, v2, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-object v1, p0, Lcom/baidu/location/d/h;->b:Lcom/baidu/location/d/e;

    invoke-virtual {v1, v0}, Lcom/baidu/location/d/e;->a(Z)V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    if-eqz v4, :cond_b

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_b
    if-eqz v6, :cond_c

    :try_start_f
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_10

    goto :goto_12

    :catch_10
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close os IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_c
    :goto_12
    if-eqz v5, :cond_d

    :try_start_10
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_11

    goto :goto_13

    :catch_11
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close is IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_d
    :goto_13
    if-eqz v7, :cond_e

    :try_start_11
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_12

    goto :goto_14

    :catch_12
    move-exception v0

    sget-object v0, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v1, "close baos IOException!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_e
    :goto_14
    return-void

    :catchall_6
    move-exception v0

    move-object v1, v5

    :goto_15
    if-eqz v4, :cond_f

    invoke-virtual {v4}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_f
    if-eqz v6, :cond_10

    :try_start_12
    invoke-virtual {v6}, Ljava/io/OutputStream;->close()V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_13

    goto :goto_16

    :catch_13
    move-exception v2

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v3, "close os IOException!"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_10
    :goto_16
    if-eqz v1, :cond_11

    :try_start_13
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_14

    goto :goto_17

    :catch_14
    move-exception v1

    sget-object v1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close is IOException!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_11
    :goto_17
    if-eqz v7, :cond_12

    :try_start_14
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_14} :catch_15

    goto :goto_18

    :catch_15
    move-exception v1

    sget-object v1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close baos IOException!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_12
    :goto_18
    throw v0

    return-void
.end method
