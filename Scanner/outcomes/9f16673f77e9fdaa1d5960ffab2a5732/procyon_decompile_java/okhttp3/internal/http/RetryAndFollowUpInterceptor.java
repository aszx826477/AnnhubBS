// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.Interceptor$Chain;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import java.net.SocketTimeoutException;
import java.io.InterruptedIOException;
import java.io.IOException;
import okhttp3.Request$Builder;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.RequestBody;
import java.net.ProtocolException;
import java.net.Proxy;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.CertificatePinner;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.OkHttpClient;
import okhttp3.Interceptor;

public final class RetryAndFollowUpInterceptor implements Interceptor
{
    private static final int MAX_FOLLOW_UPS = 20;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private boolean forWebSocket;
    private StreamAllocation streamAllocation;
    
    public RetryAndFollowUpInterceptor(final OkHttpClient client) {
        this.client = client;
    }
    
    private Address createAddress(final HttpUrl httpUrl) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }
    
    private Request followUpRequest(final Response response) {
        if (response == null) {
            throw new IllegalStateException();
        }
        final RealConnection connection = this.streamAllocation.connection();
        Route route;
        if (connection != null) {
            route = connection.route();
        }
        else {
            route = null;
        }
        final int code = response.code();
        final String method = response.request().method();
        switch (code) {
            default: {
                return null;
            }
            case 408: {
                if (response.request().body() instanceof UnrepeatableRequestBody) {
                    return null;
                }
                return response.request();
            }
            case 407: {
                Proxy proxy;
                if (route != null) {
                    proxy = route.proxy();
                }
                else {
                    proxy = this.client.proxy();
                }
                if (proxy.type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            case 401: {
                return this.client.authenticator().authenticate(route, response);
            }
            case 307:
            case 308: {
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
            }
            case 300:
            case 301:
            case 302:
            case 303: {
                if (!this.client.followRedirects()) {
                    return null;
                }
                final String header = response.header("Location");
                if (header == null) {
                    return null;
                }
                final HttpUrl resolve = response.request().url().resolve(header);
                if (resolve == null) {
                    return null;
                }
                if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                    return null;
                }
                final Request$Builder builder = response.request().newBuilder();
                if (HttpMethod.permitsRequestBody(method)) {
                    if (HttpMethod.redirectsToGet(method)) {
                        builder.method("GET", null);
                    }
                    else {
                        builder.method(method, null);
                    }
                    builder.removeHeader("Transfer-Encoding");
                    builder.removeHeader("Content-Length");
                    builder.removeHeader("Content-Type");
                }
                if (!this.sameConnection(response, resolve)) {
                    builder.removeHeader("Authorization");
                }
                return builder.url(resolve).build();
            }
        }
    }
    
    private boolean isRecoverable(final IOException ex, final boolean b) {
        final boolean b2 = ex instanceof ProtocolException;
        boolean b3 = false;
        if (b2) {
            return false;
        }
        final boolean b4 = ex instanceof InterruptedIOException;
        final boolean b5 = true;
        if (b4) {
            if (ex instanceof SocketTimeoutException && b) {
                b3 = true;
            }
            return b3;
        }
        return (!(ex instanceof SSLHandshakeException) || !(ex.getCause() instanceof CertificateException)) && !(ex instanceof SSLPeerUnverifiedException) && b5;
    }
    
    private boolean recover(final IOException ex, final boolean b, final Request request) {
        this.streamAllocation.streamFailed(ex);
        return this.client.retryOnConnectionFailure() && (b || !(request.body() instanceof UnrepeatableRequestBody)) && this.isRecoverable(ex, b) && this.streamAllocation.hasMoreRoutes();
    }
    
    private boolean sameConnection(final Response response, final HttpUrl httpUrl) {
        final HttpUrl url = response.request().url();
        if (url.host().equals(httpUrl.host())) {
            if (url.port() == httpUrl.port()) {
                if (url.scheme().equals(httpUrl.scheme())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void cancel() {
        this.canceled = true;
        final StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }
    
    public OkHttpClient client() {
        return this.client;
    }
    
    public Response intercept(final Interceptor$Chain p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: invokeinterface okhttp3/Interceptor$Chain.request:()Lokhttp3/Request;
        //     6: astore_2       
        //     7: new             Lokhttp3/internal/connection/StreamAllocation;
        //    10: astore_3       
        //    11: aload_0        
        //    12: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.client:Lokhttp3/OkHttpClient;
        //    15: invokevirtual   okhttp3/OkHttpClient.connectionPool:()Lokhttp3/ConnectionPool;
        //    18: astore          4
        //    20: aload_2        
        //    21: invokevirtual   okhttp3/Request.url:()Lokhttp3/HttpUrl;
        //    24: astore          5
        //    26: aload_0        
        //    27: aload           5
        //    29: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.createAddress:(Lokhttp3/HttpUrl;)Lokhttp3/Address;
        //    32: astore          5
        //    34: aload_3        
        //    35: aload           4
        //    37: aload           5
        //    39: invokespecial   okhttp3/internal/connection/StreamAllocation.<init>:(Lokhttp3/ConnectionPool;Lokhttp3/Address;)V
        //    42: aload_0        
        //    43: aload_3        
        //    44: putfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //    47: iconst_0       
        //    48: istore          6
        //    50: aconst_null    
        //    51: astore_3       
        //    52: aconst_null    
        //    53: astore          4
        //    55: aload_0        
        //    56: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.canceled:Z
        //    59: istore          7
        //    61: iload           7
        //    63: ifne            664
        //    66: iconst_0       
        //    67: istore          7
        //    69: aconst_null    
        //    70: astore          5
        //    72: iconst_1       
        //    73: istore          8
        //    75: aconst_null    
        //    76: astore          9
        //    78: aload_1        
        //    79: astore          10
        //    81: aload_1        
        //    82: checkcast       Lokhttp3/internal/http/RealInterceptorChain;
        //    85: astore          10
        //    87: aload_0        
        //    88: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //    91: astore          11
        //    93: aload           10
        //    95: aload_2        
        //    96: aload           11
        //    98: aconst_null    
        //    99: aconst_null    
        //   100: invokevirtual   okhttp3/internal/http/RealInterceptorChain.proceed:(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpStream;Lokhttp3/Connection;)Lokhttp3/Response;
        //   103: astore          10
        //   105: aload           10
        //   107: astore          5
        //   109: iconst_0       
        //   110: istore          8
        //   112: iconst_0       
        //   113: ifeq            138
        //   116: aload_0        
        //   117: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   120: aconst_null    
        //   121: invokevirtual   okhttp3/internal/connection/StreamAllocation.streamFailed:(Ljava/io/IOException;)V
        //   124: aload_0        
        //   125: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   128: astore          10
        //   130: aload           10
        //   132: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   135: goto            138
        //   138: aload           4
        //   140: ifnull          187
        //   143: aload           5
        //   145: invokevirtual   okhttp3/Response.newBuilder:()Lokhttp3/Response$Builder;
        //   148: astore          10
        //   150: aload           4
        //   152: invokevirtual   okhttp3/Response.newBuilder:()Lokhttp3/Response$Builder;
        //   155: astore          11
        //   157: aload           11
        //   159: aconst_null    
        //   160: invokevirtual   okhttp3/Response$Builder.body:(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
        //   163: invokevirtual   okhttp3/Response$Builder.build:()Lokhttp3/Response;
        //   166: astore          9
        //   168: aload           10
        //   170: aload           9
        //   172: invokevirtual   okhttp3/Response$Builder.priorResponse:(Lokhttp3/Response;)Lokhttp3/Response$Builder;
        //   175: astore          9
        //   177: aload           9
        //   179: invokevirtual   okhttp3/Response$Builder.build:()Lokhttp3/Response;
        //   182: astore          5
        //   184: goto            187
        //   187: aload_0        
        //   188: aload           5
        //   190: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.followUpRequest:(Lokhttp3/Response;)Lokhttp3/Request;
        //   193: astore          9
        //   195: aload           9
        //   197: ifnonnull       228
        //   200: aload_0        
        //   201: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.forWebSocket:Z
        //   204: istore          12
        //   206: iload           12
        //   208: ifne            225
        //   211: aload_0        
        //   212: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   215: astore          10
        //   217: aload           10
        //   219: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   222: goto            225
        //   225: aload           5
        //   227: areturn        
        //   228: aload           5
        //   230: invokevirtual   okhttp3/Response.body:()Lokhttp3/ResponseBody;
        //   233: astore          10
        //   235: aload           10
        //   237: invokestatic    okhttp3/internal/Util.closeQuietly:(Ljava/io/Closeable;)V
        //   240: iload           6
        //   242: iconst_1       
        //   243: iadd           
        //   244: istore          6
        //   246: bipush          20
        //   248: istore          12
        //   250: iload           6
        //   252: iload           12
        //   254: if_icmpgt       459
        //   257: aload           9
        //   259: invokevirtual   okhttp3/Request.body:()Lokhttp3/RequestBody;
        //   262: astore          10
        //   264: aload           10
        //   266: instanceof      Lokhttp3/internal/http/UnrepeatableRequestBody;
        //   269: istore          12
        //   271: iload           12
        //   273: ifne            434
        //   276: aload           9
        //   278: invokevirtual   okhttp3/Request.url:()Lokhttp3/HttpUrl;
        //   281: astore          10
        //   283: aload_0        
        //   284: aload           5
        //   286: aload           10
        //   288: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.sameConnection:(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
        //   291: istore          12
        //   293: iload           12
        //   295: ifne            352
        //   298: aload_0        
        //   299: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   302: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   305: new             Lokhttp3/internal/connection/StreamAllocation;
        //   308: astore          10
        //   310: aload_0        
        //   311: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.client:Lokhttp3/OkHttpClient;
        //   314: invokevirtual   okhttp3/OkHttpClient.connectionPool:()Lokhttp3/ConnectionPool;
        //   317: astore          11
        //   319: aload           9
        //   321: invokevirtual   okhttp3/Request.url:()Lokhttp3/HttpUrl;
        //   324: astore          13
        //   326: aload_0        
        //   327: aload           13
        //   329: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.createAddress:(Lokhttp3/HttpUrl;)Lokhttp3/Address;
        //   332: astore          13
        //   334: aload           10
        //   336: aload           11
        //   338: aload           13
        //   340: invokespecial   okhttp3/internal/connection/StreamAllocation.<init>:(Lokhttp3/ConnectionPool;Lokhttp3/Address;)V
        //   343: aload_0        
        //   344: aload           10
        //   346: putfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   349: goto            366
        //   352: aload_0        
        //   353: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   356: invokevirtual   okhttp3/internal/connection/StreamAllocation.stream:()Lokhttp3/internal/http/HttpStream;
        //   359: astore          10
        //   361: aload           10
        //   363: ifnonnull       376
        //   366: aload           9
        //   368: astore_2       
        //   369: aload           5
        //   371: astore          4
        //   373: goto            55
        //   376: new             Ljava/lang/IllegalStateException;
        //   379: astore          10
        //   381: new             Ljava/lang/StringBuilder;
        //   384: astore          11
        //   386: aload           11
        //   388: invokespecial   java/lang/StringBuilder.<init>:()V
        //   391: aload           11
        //   393: ldc_w           "Closing the body of "
        //   396: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   399: pop            
        //   400: aload           11
        //   402: aload           5
        //   404: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   407: pop            
        //   408: aload           11
        //   410: ldc_w           " didn't close its backing stream. Bad interceptor?"
        //   413: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   416: pop            
        //   417: aload           11
        //   419: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   422: astore          11
        //   424: aload           10
        //   426: aload           11
        //   428: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   431: aload           10
        //   433: athrow         
        //   434: new             Ljava/net/HttpRetryException;
        //   437: astore          10
        //   439: aload           5
        //   441: invokevirtual   okhttp3/Response.code:()I
        //   444: istore          14
        //   446: aload           10
        //   448: ldc_w           "Cannot retry streamed HTTP body"
        //   451: iload           14
        //   453: invokespecial   java/net/HttpRetryException.<init>:(Ljava/lang/String;I)V
        //   456: aload           10
        //   458: athrow         
        //   459: aload_0        
        //   460: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   463: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   466: new             Ljava/net/ProtocolException;
        //   469: astore          10
        //   471: new             Ljava/lang/StringBuilder;
        //   474: astore          11
        //   476: aload           11
        //   478: invokespecial   java/lang/StringBuilder.<init>:()V
        //   481: aload           11
        //   483: ldc_w           "Too many follow-up requests: "
        //   486: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   489: pop            
        //   490: aload           11
        //   492: iload           6
        //   494: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   497: pop            
        //   498: aload           11
        //   500: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   503: astore          11
        //   505: aload           10
        //   507: aload           11
        //   509: invokespecial   java/net/ProtocolException.<init>:(Ljava/lang/String;)V
        //   512: aload           10
        //   514: athrow         
        //   515: astore          10
        //   517: goto            630
        //   520: astore          10
        //   522: iconst_0       
        //   523: istore          14
        //   525: aconst_null    
        //   526: astore          11
        //   528: aload_0        
        //   529: aload           10
        //   531: iconst_0       
        //   532: aload_2        
        //   533: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.recover:(Ljava/io/IOException;ZLokhttp3/Request;)Z
        //   536: istore          14
        //   538: iload           14
        //   540: ifeq            579
        //   543: iconst_0       
        //   544: istore          8
        //   546: iconst_0       
        //   547: ifeq            576
        //   550: aload_0        
        //   551: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   554: astore          11
        //   556: aload           11
        //   558: aconst_null    
        //   559: invokevirtual   okhttp3/internal/connection/StreamAllocation.streamFailed:(Ljava/io/IOException;)V
        //   562: aload_0        
        //   563: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   566: astore          9
        //   568: aload           9
        //   570: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   573: goto            55
        //   576: goto            55
        //   579: aload           10
        //   581: athrow         
        //   582: astore          10
        //   584: aload           10
        //   586: invokevirtual   okhttp3/internal/connection/RouteException.getLastConnectException:()Ljava/io/IOException;
        //   589: astore          11
        //   591: iconst_1       
        //   592: istore          15
        //   594: aload_0        
        //   595: aload           11
        //   597: iload           15
        //   599: aload_2        
        //   600: invokespecial   okhttp3/internal/http/RetryAndFollowUpInterceptor.recover:(Ljava/io/IOException;ZLokhttp3/Request;)Z
        //   603: istore          14
        //   605: iload           14
        //   607: ifeq            620
        //   610: iconst_0       
        //   611: istore          8
        //   613: iconst_0       
        //   614: ifeq            576
        //   617: goto            550
        //   620: aload           10
        //   622: invokevirtual   okhttp3/internal/connection/RouteException.getLastConnectException:()Ljava/io/IOException;
        //   625: astore          11
        //   627: aload           11
        //   629: athrow         
        //   630: iload           8
        //   632: ifeq            661
        //   635: aload_0        
        //   636: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   639: astore          11
        //   641: aload           11
        //   643: aconst_null    
        //   644: invokevirtual   okhttp3/internal/connection/StreamAllocation.streamFailed:(Ljava/io/IOException;)V
        //   647: aload_0        
        //   648: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   651: astore          9
        //   653: aload           9
        //   655: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   658: goto            661
        //   661: aload           10
        //   663: athrow         
        //   664: aload_0        
        //   665: getfield        okhttp3/internal/http/RetryAndFollowUpInterceptor.streamAllocation:Lokhttp3/internal/connection/StreamAllocation;
        //   668: invokevirtual   okhttp3/internal/connection/StreamAllocation.release:()V
        //   671: new             Ljava/io/IOException;
        //   674: astore          5
        //   676: aload           5
        //   678: ldc_w           "Canceled"
        //   681: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   684: aload           5
        //   686: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                        
        //  -----  -----  -----  -----  --------------------------------------------
        //  81     85     582    630    Lokhttp3/internal/connection/RouteException;
        //  81     85     520    550    Ljava/io/IOException;
        //  81     85     515    664    Any
        //  87     91     582    630    Lokhttp3/internal/connection/RouteException;
        //  87     91     520    550    Ljava/io/IOException;
        //  87     91     515    664    Any
        //  99     103    582    630    Lokhttp3/internal/connection/RouteException;
        //  99     103    520    550    Ljava/io/IOException;
        //  99     103    515    664    Any
        //  532    536    515    664    Any
        //  579    582    515    664    Any
        //  584    589    515    664    Any
        //  599    603    515    664    Any
        //  620    625    515    664    Any
        //  627    630    515    664    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0138:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isCanceled() {
        return this.canceled;
    }
    
    public boolean isForWebSocket() {
        return this.forWebSocket;
    }
    
    public void setForWebSocket(final boolean forWebSocket) {
        this.forWebSocket = forWebSocket;
    }
    
    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
