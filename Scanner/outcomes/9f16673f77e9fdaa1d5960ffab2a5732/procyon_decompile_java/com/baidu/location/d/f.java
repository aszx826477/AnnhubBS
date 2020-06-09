// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import java.io.InputStream;
import android.net.ConnectivityManager;
import android.net.Proxy;
import android.net.NetworkInfo;
import android.content.Context;
import java.util.Map;
import java.net.URLConnection;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class f extends Thread
{
    final /* synthetic */ e a;
    
    f(final e a) {
        this.a = a;
    }
    
    public void run() {
        this.a.h = j.c();
        this.a.b();
        this.a.a();
        int i = this.a.i;
        Object o = null;
        Object inputStream = null;
        int n = 0;
        Label_0651: {
            ByteArrayOutputStream byteArrayOutputStream3 = null;
            Label_0615: {
                Object o2 = null;
                while (true) {
                    n = 1;
                    if (i <= 0) {
                        break Label_0651;
                    }
                    try {
                        o2 = new(java.net.URL.class);
                        try {
                            final e a = this.a;
                            try {
                                new URL(a.h);
                                final URLConnection openConnection = ((URL)o2).openConnection();
                                try {
                                    o2 = openConnection;
                                    inputStream = "GET";
                                    final URL url = (URL)o2;
                                    try {
                                        ((HttpURLConnection)url).setRequestMethod((String)inputStream);
                                        final URL url2 = (URL)o2;
                                        try {
                                            ((URLConnection)url2).setDoInput(n != 0);
                                            final URL url3 = (URL)o2;
                                            try {
                                                ((URLConnection)url3).setDoOutput(n != 0);
                                                final URL url4 = (URL)o2;
                                                try {
                                                    ((URLConnection)url4).setUseCaches(false);
                                                    ((URLConnection)o2).setConnectTimeout(com.baidu.location.d.a.b);
                                                    ((URLConnection)o2).setReadTimeout(com.baidu.location.d.a.b);
                                                    ((URLConnection)o2).setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                                                    ((URLConnection)o2).setRequestProperty("Accept-Charset", "UTF-8");
                                                    if (((HttpURLConnection)o2).getResponseCode() == 200) {
                                                        inputStream = ((URLConnection)o2).getInputStream();
                                                        try {
                                                            try {
                                                                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                                int n2 = 1024;
                                                                try {
                                                                    final byte[] array = new byte[n2];
                                                                    while (true) {
                                                                        final int read = ((InputStream)inputStream).read(array);
                                                                        if (read == -1) {
                                                                            break;
                                                                        }
                                                                        byteArrayOutputStream.write(array, 0, read);
                                                                    }
                                                                    ((InputStream)inputStream).close();
                                                                    byteArrayOutputStream.close();
                                                                    final e a2 = this.a;
                                                                    try {
                                                                        try {
                                                                            final String j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                                                            final e e = a2;
                                                                            try {
                                                                                e.j = j;
                                                                                this.a.a(n != 0);
                                                                                ((HttpURLConnection)o2).disconnect();
                                                                                n2 = 1;
                                                                            }
                                                                            catch (Exception ex3) {}
                                                                        }
                                                                        catch (Exception ex4) {}
                                                                    }
                                                                    catch (Exception ex5) {}
                                                                }
                                                                catch (Exception ex6) {}
                                                            }
                                                            catch (Exception ex7) {}
                                                        }
                                                        catch (Exception ex8) {}
                                                        final URLConnection urlConnection = (URLConnection)o2;
                                                        o2 = inputStream;
                                                        inputStream = urlConnection;
                                                    }
                                                    ((HttpURLConnection)o2).disconnect();
                                                    inputStream = null;
                                                    final ByteArrayOutputStream byteArrayOutputStream2 = null;
                                                    int n2 = 0;
                                                    if (o2 != null) {
                                                        ((HttpURLConnection)o2).disconnect();
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            ((InputStream)inputStream).close();
                                                        }
                                                        catch (Exception inputStream) {
                                                            ((Exception)inputStream).printStackTrace();
                                                        }
                                                    }
                                                    if (byteArrayOutputStream2 != null) {
                                                        try {
                                                            byteArrayOutputStream2.close();
                                                        }
                                                        catch (Exception inputStream) {
                                                            ((Exception)inputStream).printStackTrace();
                                                        }
                                                    }
                                                    inputStream = o2;
                                                }
                                                catch (Exception inputStream) {
                                                    inputStream = o2;
                                                    o2 = null;
                                                }
                                            }
                                            catch (Exception ex9) {}
                                        }
                                        catch (Exception ex10) {}
                                    }
                                    catch (Exception ex11) {}
                                }
                                catch (Exception o2) {
                                    o2 = null;
                                    byteArrayOutputStream3 = null;
                                }
                            }
                            catch (Exception ex12) {}
                        }
                        catch (Exception ex13) {}
                    }
                    catch (Exception ex14) {}
                    try {
                        Log.d(com.baidu.location.d.a.a, "NetworkCommunicationException!");
                        if (inputStream != null) {
                            ((HttpURLConnection)inputStream).disconnect();
                        }
                        if (o2 != null) {
                            try {
                                ((InputStream)o2).close();
                            }
                            catch (Exception o2) {
                                ((Exception)o2).printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.close();
                            }
                            catch (Exception o2) {
                                ((Exception)o2).printStackTrace();
                            }
                        }
                        final int n2 = 0;
                        if (n2 != 0) {
                            break Label_0651;
                        }
                        --i;
                        continue;
                    }
                    finally {
                        o = o2;
                        goto Label_0492;
                    }
                    if (o2 != null) {
                        break;
                    }
                    break Label_0615;
                }
                ((HttpURLConnection)o2).disconnect();
            }
            if (o != null) {
                try {
                    ((InputStream)o).close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                }
                catch (Exception ex2) {
                    ex2.printStackTrace();
                }
            }
            throw;
        }
        if (i <= 0) {
            e.o += n;
            final e a3 = this.a;
            a3.j = null;
            a3.a(false);
        }
        else {
            e.o = 0;
        }
    }
}
