// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.d.c;
import org.json.JSONObject;
import com.baidu.location.Jni;
import android.os.Build$VERSION;
import android.os.Build;
import com.baidu.location.f;
import java.io.RandomAccessFile;
import com.baidu.location.d.i;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import com.baidu.location.d.j;
import android.net.NetworkInfo;
import com.baidu.location.b.d;
import com.baidu.location.b.b;
import android.net.ConnectivityManager;
import android.content.Context;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import android.os.Handler;
import com.baidu.location.d.e;

public class o extends e
{
    private static o p;
    String a;
    String b;
    String c;
    String d;
    int e;
    Handler f;
    
    static {
        o.p = null;
    }
    
    private o() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 1;
        this.f = null;
        this.f = new Handler();
    }
    
    public static void a(final File file, final File file2) {
        FilterOutputStream filterOutputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                final int n = 5120;
                try {
                    final byte[] array = new byte[n];
                    while (true) {
                        final int read = bufferedInputStream.read(array);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(array, 0, read);
                    }
                    bufferedOutputStream.flush();
                    file.delete();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return;
                }
                finally {
                    filterOutputStream = bufferedOutputStream;
                }
            }
            finally {}
        }
        finally {
            bufferedInputStream2 = null;
        }
        if (bufferedInputStream2 != null) {
            bufferedInputStream2.close();
        }
        if (filterOutputStream != null) {
            filterOutputStream.close();
        }
    }
    
    private boolean a(final Context context) {
        final String s = "connectivity";
        try {
            final Object systemService = context.getSystemService(s);
            try {
                final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                try {
                    final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                        return false;
                    }
                    final b a = com.baidu.location.b.b.a();
                    try {
                        final int e = a.e();
                        try {
                            final String a2 = com.baidu.location.b.d.a(e);
                            if (a2.equals("3G") || a2.equals("4G")) {
                                return true;
                            }
                            return false;
                        }
                        catch (Exception ex) {}
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
        return false;
    }
    
    public static boolean a(final String s, String string) {
        final StringBuilder sb = new StringBuilder();
        sb.append(j.h());
        sb.append(File.separator);
        sb.append("tmp");
        final File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final byte[] array = new byte[4096];
            try {
                final URLConnection openConnection = new URL(s).openConnection();
                try {
                    final HttpURLConnection httpURLConnection = (HttpURLConnection)openConnection;
                    try {
                        try {
                            final BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            while (true) {
                                final BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                                try {
                                    final int read = bufferedInputStream2.read(array);
                                    if (read > 0) {
                                        fileOutputStream.write(array, 0, read);
                                        continue;
                                    }
                                    httpURLConnection.disconnect();
                                    fileOutputStream.close();
                                    bufferedInputStream.close();
                                    if (file.length() < 10240L) {
                                        file.delete();
                                        return false;
                                    }
                                    try {
                                        try {
                                            final StringBuilder sb2 = new StringBuilder();
                                            sb2.append(j.h());
                                            sb2.append(File.separator);
                                            final StringBuilder sb3 = sb2;
                                            try {
                                                sb3.append(string);
                                                string = sb2.toString();
                                                final File file2 = new File(string);
                                                final File file3 = file;
                                                try {
                                                    file3.renameTo(file2);
                                                    return true;
                                                }
                                                catch (Exception ex) {
                                                    file.delete();
                                                    return false;
                                                }
                                            }
                                            catch (Exception ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                    }
                                    catch (Exception ex4) {}
                                }
                                catch (Exception ex5) {}
                            }
                        }
                        catch (Exception ex6) {}
                    }
                    catch (Exception ex7) {}
                }
                catch (Exception ex8) {}
            }
            catch (Exception ex9) {}
        }
        catch (Exception ex10) {}
    }
    
    public static o b() {
        if (o.p == null) {
            o.p = new o();
        }
        return o.p;
    }
    
    private Handler f() {
        return this.f;
    }
    
    private void g() {
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.j.h());
        sb.append("/grtcfrsa.dat");
        final String string = sb.toString();
        try {
            final File file = new File(string);
            final boolean exists = file.exists();
            final long n = 200L;
            Label_0199: {
                if (exists) {
                    break Label_0199;
                }
                try {
                    final File file2 = new File(com.baidu.location.d.i.a);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.createNewFile()) {
                        return;
                    }
                    final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.writeInt(0);
                        randomAccessFile.seek(8);
                        final byte[] bytes = "1980_01_01:0".getBytes();
                        try {
                            randomAccessFile.writeInt(bytes.length);
                            final RandomAccessFile randomAccessFile3 = randomAccessFile;
                            try {
                                randomAccessFile3.write(bytes);
                                final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                try {
                                    randomAccessFile4.seek(n);
                                    final RandomAccessFile randomAccessFile5 = randomAccessFile;
                                    try {
                                        randomAccessFile5.writeBoolean(false);
                                        randomAccessFile.seek(800L);
                                        final RandomAccessFile randomAccessFile6 = randomAccessFile;
                                        try {
                                            randomAccessFile6.writeBoolean(false);
                                            randomAccessFile.close();
                                            final RandomAccessFile randomAccessFile8;
                                            final RandomAccessFile randomAccessFile7 = randomAccessFile8 = new RandomAccessFile(file, "rw");
                                            try {
                                                randomAccessFile8.seek(n);
                                                final boolean b = true;
                                                randomAccessFile7.writeBoolean(b);
                                                if (this.e == (b ? 1 : 0)) {
                                                    randomAccessFile7.writeBoolean(b);
                                                }
                                                else {
                                                    randomAccessFile7.writeBoolean(false);
                                                }
                                                Label_0297: {
                                                    if (this.d == null) {
                                                        break Label_0297;
                                                    }
                                                    final String d = this.d;
                                                    try {
                                                        final byte[] bytes2 = d.getBytes();
                                                        try {
                                                            randomAccessFile7.writeInt(bytes2.length);
                                                            final RandomAccessFile randomAccessFile9 = randomAccessFile7;
                                                            try {
                                                                randomAccessFile9.write(bytes2);
                                                                while (true) {
                                                                    randomAccessFile7.close();
                                                                    return;
                                                                    randomAccessFile7.writeInt(0);
                                                                    continue;
                                                                }
                                                            }
                                                            // iftrue(Label_0351:, Math.abs(f.getFrameVersion() - 7.52f) >= 1.0E-8f)
                                                            catch (Exception ex) {}
                                                        }
                                                        catch (Exception ex2) {}
                                                    }
                                                    catch (Exception ex3) {}
                                                }
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
                        }
                        catch (Exception ex9) {}
                    }
                    catch (Exception ex10) {}
                }
                catch (Exception ex11) {}
            }
        }
        catch (Exception ex12) {}
    }
    
    private void h() {
        if (this.a == null) {
            return;
        }
        new s(this).start();
    }
    
    private boolean i() {
        final String c = this.c;
        final boolean b = true;
        if (c == null) {
            return b;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.j.h());
        sb.append(File.separator);
        sb.append(this.c);
        if (new File(sb.toString()).exists()) {
            return b;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("http://");
        sb2.append(this.a);
        sb2.append("/");
        sb2.append(this.c);
        return a(sb2.toString(), this.c);
    }
    
    private void j() {
        if (this.b == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.j.h());
        sb.append(File.separator);
        sb.append(this.b);
        final File file = new File(sb.toString());
        if (!file.exists()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("http://");
            sb2.append(this.a);
            sb2.append("/");
            sb2.append(this.b);
            if (!a(sb2.toString(), this.b)) {
                return;
            }
            final String a = com.baidu.location.d.j.a(file, "SHA-256");
            final String d = this.d;
            if (d != null && a != null && com.baidu.location.d.j.b(a, d, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(com.baidu.location.d.j.h());
                sb3.append(File.separator);
                sb3.append(com.baidu.location.f.replaceFileName);
                final File file2 = new File(sb3.toString());
                if (file2.exists()) {
                    file2.delete();
                }
                final File file3 = file;
                try {
                    a(file3, file2);
                }
                catch (Exception ex) {
                    file2.delete();
                }
            }
        }
    }
    
    public void a() {
        final StringBuffer sb = new StringBuffer(128);
        sb.append("&sdk=");
        sb.append(7.52f);
        sb.append("&fw=");
        sb.append(com.baidu.location.f.getFrameVersion());
        sb.append("&suit=");
        sb.append(2);
        String s;
        if (com.baidu.location.d.b.a().b == null) {
            sb.append("&im=");
            s = com.baidu.location.d.b.a().a;
        }
        else {
            sb.append("&cu=");
            s = com.baidu.location.d.b.a().b;
        }
        sb.append(s);
        sb.append("&mb=");
        sb.append(Build.MODEL);
        sb.append("&sv=");
        String s2 = Build$VERSION.RELEASE;
        int n = 0;
        if (s2 != null) {
            final int length = s2.length();
            final int n2 = 10;
            if (length > n2) {
                s2 = s2.substring(0, n2);
            }
        }
        sb.append(s2);
        String cpu_ABI2 = null;
        Label_0381: {
            try {
                Label_0366: {
                    if (Build$VERSION.SDK_INT <= 20) {
                        break Label_0366;
                    }
                    final String[] supported_ABIS = Build.SUPPORTED_ABIS;
                    String s3 = null;
                    while (true) {
                        Label_0359: {
                            if (n >= supported_ABIS.length) {
                                break Label_0359;
                            }
                            Label_0297: {
                                if (n != 0) {
                                    break Label_0297;
                                }
                                try {
                                    final StringBuilder sb2 = new StringBuilder();
                                    final String[] array = supported_ABIS;
                                    try {
                                        sb2.append(array[n]);
                                        sb2.append(";");
                                        s3 = sb2.toString();
                                        Label_0350: {
                                            break Label_0350;
                                            try {
                                                final StringBuilder sb4;
                                                final StringBuilder sb3 = sb4 = new StringBuilder();
                                                try {
                                                    sb4.append(s3);
                                                    final String[] array2 = supported_ABIS;
                                                    try {
                                                        sb3.append(array2[n]);
                                                        sb3.append(";");
                                                        s3 = sb3.toString();
                                                        ++n;
                                                        continue;
                                                        cpu_ABI2 = s3;
                                                        break Label_0381;
                                                        cpu_ABI2 = Build.CPU_ABI2;
                                                    }
                                                    catch (Exception ex) {}
                                                    catch (Error error) {}
                                                }
                                                catch (Exception ex2) {}
                                                catch (Error error2) {}
                                            }
                                            catch (Exception ex3) {}
                                            catch (Error error3) {}
                                        }
                                    }
                                    catch (Exception ex4) {}
                                    catch (Error error4) {}
                                }
                                catch (Exception ex5) {}
                                catch (Error error5) {}
                            }
                        }
                        break;
                    }
                }
            }
            catch (Exception ex6) {}
            catch (Error error6) {}
        }
        if (cpu_ABI2 != null) {
            sb.append("&cpuabi=");
            sb.append(cpu_ABI2);
        }
        sb.append("&pack=");
        sb.append(com.baidu.location.d.b.d);
        final StringBuilder sb5 = new StringBuilder();
        sb5.append(com.baidu.location.d.j.d());
        sb5.append("?&it=");
        sb5.append(Jni.en1(sb.toString()));
        this.h = sb5.toString();
    }
    
    public void a(final boolean b) {
        if (b) {
            try {
                final String j = this.j;
                try {
                    final JSONObject jsonObject = new JSONObject(j);
                    Label_0169: {
                        if (!"up".equals(jsonObject.getString("res"))) {
                            break Label_0169;
                        }
                        this.a = jsonObject.getString("upath");
                        if (jsonObject.has("u1")) {
                            this.b = jsonObject.getString("u1");
                        }
                        if (jsonObject.has("u2")) {
                            this.c = jsonObject.getString("u2");
                        }
                        if (jsonObject.has("u1_rsa")) {
                            this.d = jsonObject.getString("u1_rsa");
                        }
                        final Handler f = this.f();
                        try {
                            final r r = new r(this);
                            final Handler handler = f;
                            try {
                                handler.post((Runnable)r);
                                if (jsonObject.has("ison")) {
                                    this.e = jsonObject.getInt("ison");
                                }
                                this.g();
                            }
                            catch (Exception ex) {}
                        }
                        catch (Exception ex2) {}
                    }
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        com.baidu.location.d.c.a().a(System.currentTimeMillis());
    }
    
    public void c() {
        if (System.currentTimeMillis() - com.baidu.location.d.c.a().b() > 86400000L) {
            this.f().postDelayed((Runnable)new p(this), 10000L);
            this.f().postDelayed((Runnable)new q(this), 5000L);
        }
    }
}
