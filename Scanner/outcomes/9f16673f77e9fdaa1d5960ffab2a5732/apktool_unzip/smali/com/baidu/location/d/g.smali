.class Lcom/baidu/location/d/g;
.super Ljava/lang/Thread;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Z

.field final synthetic c:Lcom/baidu/location/d/e;


# direct methods
.method constructor <init>(Lcom/baidu/location/d/e;Ljava/lang/String;Z)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    iput-object p2, p0, Lcom/baidu/location/d/g;->a:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/baidu/location/d/g;->b:Z

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    iget-object v0, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    invoke-static {}, Lcom/baidu/location/d/j;->c()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    iget-object v0, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    invoke-static {v0}, Lcom/baidu/location/d/e;->a(Lcom/baidu/location/d/e;)V

    iget-object v0, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    invoke-virtual {v0}, Lcom/baidu/location/d/e;->a()V

    iget-object v0, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    iget v0, v0, Lcom/baidu/location/d/e;->i:I

    const/4 v1, 0x0

    move-object v2, v1

    :goto_0
    const/4 v3, 0x0

    const/4 v4, 0x1

    if-lez v0, :cond_17

    :try_start_0
    new-instance v5, Ljava/net/URL;

    iget-object v6, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    iget-object v6, v6, Lcom/baidu/location/d/e;->h:Ljava/lang/String;

    invoke-direct {v5, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v7, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    iget-object v7, v7, Lcom/baidu/location/d/e;->k:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v9, "="

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    const-string v8, "&"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    :cond_0
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    if-lez v7, :cond_1

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    sub-int/2addr v7, v4

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    :cond_1
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v5

    check-cast v5, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_f
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_b
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    :try_start_1
    const-string v2, "POST"

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    invoke-virtual {v5, v4}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    invoke-virtual {v5, v3}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    sget v2, Lcom/baidu/location/d/a;->b:I

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    sget v2, Lcom/baidu/location/d/a;->b:I

    invoke-virtual {v5, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    const-string v2, "Content-Type"

    const-string v7, "application/x-www-form-urlencoded; charset=utf-8"

    invoke-virtual {v5, v2, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "Accept-Charset"

    const-string v7, "UTF-8"

    invoke-virtual {v5, v2, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "Accept-Encoding"

    const-string v7, "gzip"

    invoke-virtual {v5, v2, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/baidu/location/d/g;->a:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "Host"

    iget-object v7, p0, Lcom/baidu/location/d/g;->a:Ljava/lang/String;

    invoke-virtual {v5, v2, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_a
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_9
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    :try_start_2
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/io/OutputStream;->write([B)V

    invoke-virtual {v2}, Ljava/io/OutputStream;->flush()V

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v6

    const/16 v7, 0xc8

    if-ne v6, v7, :cond_6

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_8
    .catch Ljava/lang/Error; {:try_start_2 .. :try_end_2} :catch_7
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    :try_start_3
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_3

    const-string v8, "gzip"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_3

    new-instance v7, Ljava/util/zip/GZIPInputStream;

    new-instance v8, Ljava/io/BufferedInputStream;

    invoke-direct {v8, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v7, v8}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    move-object v6, v7

    :cond_3
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    const/16 v8, 0x400

    :try_start_4
    new-array v8, v8, [B

    :goto_2
    invoke-virtual {v6, v8}, Ljava/io/InputStream;->read([B)I

    move-result v9

    const/4 v10, -0x1

    if-eq v9, v10, :cond_4

    invoke-virtual {v7, v8, v3, v9}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_2

    :cond_4
    iget-object v8, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    new-instance v9, Ljava/lang/String;

    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v10

    const-string v11, "utf-8"

    invoke-direct {v9, v10, v11}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iput-object v9, v8, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    iget-boolean v8, p0, Lcom/baidu/location/d/g;->b:Z

    if-eqz v8, :cond_5

    iget-object v8, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v9

    iput-object v9, v8, Lcom/baidu/location/d/e;->m:[B

    :cond_5
    iget-object v8, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    invoke-virtual {v8, v4}, Lcom/baidu/location/d/e;->a(Z)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Error; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    const/4 v8, 0x1

    goto :goto_3

    :catchall_0
    move-exception v0

    goto :goto_7

    :catch_0
    move-exception v8

    goto :goto_8

    :catch_1
    move-exception v8

    goto/16 :goto_9

    :catchall_1
    move-exception v0

    move-object v7, v1

    goto :goto_7

    :catch_2
    move-exception v7

    move-object v7, v1

    goto :goto_8

    :catch_3
    move-exception v7

    move-object v7, v1

    goto :goto_9

    :cond_6
    move-object v6, v1

    move-object v7, v6

    const/4 v8, 0x0

    :goto_3
    if-eqz v5, :cond_7

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_7
    if-eqz v2, :cond_8

    :try_start_5
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    goto :goto_4

    :catch_4
    move-exception v2

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v9, "close os IOException!"

    invoke-static {v2, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_8
    :goto_4
    if-eqz v6, :cond_9

    :try_start_6
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    goto :goto_5

    :catch_5
    move-exception v2

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v6, "close is IOException!"

    invoke-static {v2, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_9
    :goto_5
    if-eqz v7, :cond_a

    :try_start_7
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    goto :goto_6

    :catch_6
    move-exception v2

    sget-object v2, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v6, "close baos IOException!"

    invoke-static {v2, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_a
    :goto_6
    move-object v2, v5

    goto/16 :goto_13

    :catchall_2
    move-exception v0

    move-object v6, v1

    move-object v7, v6

    :goto_7
    move-object v1, v2

    goto/16 :goto_14

    :catch_7
    move-exception v6

    move-object v6, v1

    move-object v7, v6

    :goto_8
    move-object v12, v5

    move-object v5, v2

    move-object v2, v12

    goto :goto_b

    :catch_8
    move-exception v6

    move-object v6, v1

    move-object v7, v6

    :goto_9
    move-object v12, v5

    move-object v5, v2

    move-object v2, v12

    goto/16 :goto_e

    :catchall_3
    move-exception v0

    move-object v6, v1

    move-object v7, v6

    goto/16 :goto_14

    :catch_9
    move-exception v2

    move-object v6, v1

    move-object v7, v6

    move-object v2, v5

    move-object v5, v7

    goto :goto_b

    :catch_a
    move-exception v2

    move-object v6, v1

    move-object v7, v6

    move-object v2, v5

    move-object v5, v7

    goto :goto_e

    :catchall_4
    move-exception v0

    move-object v6, v1

    move-object v7, v6

    :goto_a
    move-object v5, v2

    goto/16 :goto_14

    :catch_b
    move-exception v5

    move-object v5, v1

    move-object v6, v5

    move-object v7, v6

    :goto_b
    :try_start_8
    sget-object v8, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v9, "NetworkCommunicationError!"

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_5

    if-eqz v2, :cond_b

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_b
    if-eqz v5, :cond_c

    :try_start_9
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_c

    goto :goto_c

    :catch_c
    move-exception v5

    sget-object v5, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v8, "close os IOException!"

    invoke-static {v5, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_c
    :goto_c
    if-eqz v6, :cond_d

    :try_start_a
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_d

    goto :goto_d

    :catch_d
    move-exception v5

    sget-object v5, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v6, "close is IOException!"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_d
    :goto_d
    if-eqz v7, :cond_11

    :try_start_b
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_e

    goto :goto_12

    :catch_e
    move-exception v5

    goto :goto_11

    :catch_f
    move-exception v5

    move-object v5, v1

    move-object v6, v5

    move-object v7, v6

    :goto_e
    :try_start_c
    sget-object v8, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v9, "NetworkCommunicationException!"

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_5

    if-eqz v2, :cond_e

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_e
    if-eqz v5, :cond_f

    :try_start_d
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_10

    goto :goto_f

    :catch_10
    move-exception v5

    sget-object v5, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v8, "close os IOException!"

    invoke-static {v5, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_f
    :goto_f
    if-eqz v6, :cond_10

    :try_start_e
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_11

    goto :goto_10

    :catch_11
    move-exception v5

    sget-object v5, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v6, "close is IOException!"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_10
    :goto_10
    if-eqz v7, :cond_11

    :try_start_f
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_12

    goto :goto_12

    :catch_12
    move-exception v5

    :goto_11
    sget-object v5, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v6, "close baos IOException!"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_11
    :goto_12
    const/4 v8, 0x0

    :goto_13
    if-eqz v8, :cond_12

    goto :goto_18

    :cond_12
    add-int/lit8 v0, v0, -0x1

    goto/16 :goto_0

    :catchall_5
    move-exception v0

    move-object v1, v5

    goto :goto_a

    :goto_14
    if-eqz v5, :cond_13

    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_13
    if-eqz v1, :cond_14

    :try_start_10
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_13

    goto :goto_15

    :catch_13
    move-exception v1

    sget-object v1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close os IOException!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_14
    :goto_15
    if-eqz v6, :cond_15

    :try_start_11
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_14

    goto :goto_16

    :catch_14
    move-exception v1

    sget-object v1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close is IOException!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_15
    :goto_16
    if-eqz v7, :cond_16

    :try_start_12
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_15

    goto :goto_17

    :catch_15
    move-exception v1

    sget-object v1, Lcom/baidu/location/d/a;->a:Ljava/lang/String;

    const-string v2, "close baos IOException!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_16
    :goto_17
    throw v0

    :cond_17
    :goto_18
    if-gtz v0, :cond_18

    sget v0, Lcom/baidu/location/d/e;->o:I

    add-int/2addr v0, v4

    sput v0, Lcom/baidu/location/d/e;->o:I

    iget-object v0, p0, Lcom/baidu/location/d/g;->c:Lcom/baidu/location/d/e;

    iput-object v1, v0, Lcom/baidu/location/d/e;->j:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/baidu/location/d/e;->a(Z)V

    goto :goto_19

    :cond_18
    sput v3, Lcom/baidu/location/d/e;->o:I

    :goto_19
    return-void
.end method
