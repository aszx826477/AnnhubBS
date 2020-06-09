// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import java.nio.channels.spi.AbstractInterruptibleChannel;
import android.content.SharedPreferences;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import android.os.Environment;
import com.baidu.location.f;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import com.baidu.location.d.j;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import com.baidu.location.d.i;
import com.baidu.location.d.b;
import java.util.Calendar;
import java.util.Random;
import java.util.Iterator;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.content.Context;
import java.io.OutputStream;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.io.File;
import android.location.Location;
import java.util.List;
import android.os.Handler;

public class d
{
    public static String f;
    private static d j;
    private d$a A;
    private boolean B;
    private boolean C;
    private int D;
    private float E;
    private float F;
    private long G;
    private int H;
    private Handler I;
    private byte[] J;
    private byte[] K;
    private int L;
    private List M;
    private boolean N;
    long a;
    Location b;
    Location c;
    StringBuilder d;
    long e;
    int g;
    double h;
    double i;
    private int k;
    private double l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private double r;
    private double s;
    private double t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private long z;
    
    static {
        d.j = null;
        d.f = "0";
    }
    
    private d() {
        final boolean q = true;
        this.k = (q ? 1 : 0);
        this.l = 0.699999988079071;
        this.m = "3G|4G";
        this.n = (q ? 1 : 0);
        this.o = 307200;
        this.p = 15;
        this.q = (q ? 1 : 0);
        this.r = 3.5;
        this.s = 3.0;
        this.t = 0.5;
        this.u = 300;
        final int n = 60;
        this.v = n;
        this.w = 0;
        this.x = n;
        this.y = 0;
        final long n2 = 0L;
        this.z = n2;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = n2;
        this.H = 500;
        this.a = n2;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = n2;
        this.I = null;
        this.J = new byte[4];
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.g = 0;
        this.h = 116.22345545;
        this.i = 40.245667323;
        this.I = new Handler();
    }
    
    public static d a() {
        if (d.j == null) {
            d.j = new d();
        }
        return d.j;
    }
    
    private String a(final File file, final String s) {
        final String string = UUID.randomUUID().toString();
        final String s2 = "--";
        final String s3 = "\r\n";
        final String s4 = "multipart/form-data";
        try {
            final URLConnection openConnection = new URL(s).openConnection();
            try {
                final HttpURLConnection httpURLConnection = (HttpURLConnection)openConnection;
                final int n = 10000;
                httpURLConnection.setReadTimeout(n);
                final HttpURLConnection httpURLConnection2 = httpURLConnection;
                try {
                    httpURLConnection2.setConnectTimeout(n);
                    final boolean b = true;
                    httpURLConnection.setDoInput(b);
                    final HttpURLConnection httpURLConnection3 = httpURLConnection;
                    try {
                        httpURLConnection3.setDoOutput(b);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Charset", "utf-8");
                        httpURLConnection.setRequestProperty("connection", "close");
                        final String s5 = "Content-Type";
                        try {
                            final StringBuilder sb2;
                            final StringBuilder sb = sb2 = new StringBuilder();
                            try {
                                sb2.append(s4);
                                sb.append(";boundary=");
                                final StringBuilder sb3 = sb;
                                try {
                                    sb3.append(string);
                                    httpURLConnection.setRequestProperty(s5, sb.toString());
                                    if (file == null || !file.exists()) {
                                        return "0";
                                    }
                                    final OutputStream outputStream = httpURLConnection.getOutputStream();
                                    try {
                                        final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                                        try {
                                            final StringBuffer sb5;
                                            final StringBuffer sb4 = sb5 = new StringBuffer();
                                            try {
                                                sb5.append(s2);
                                                final StringBuffer sb6 = sb4;
                                                try {
                                                    sb6.append(string);
                                                    final StringBuffer sb7 = sb4;
                                                    try {
                                                        sb7.append(s3);
                                                        try {
                                                            final StringBuilder sb8 = new StringBuilder();
                                                            sb8.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"");
                                                            sb8.append(file.getName());
                                                            sb8.append("\"");
                                                            final StringBuilder sb9 = sb8;
                                                            try {
                                                                sb9.append(s3);
                                                                sb4.append(sb8.toString());
                                                                try {
                                                                    final StringBuilder sb10 = new StringBuilder();
                                                                    sb10.append("Content-Type: application/octet-stream; charset=utf-8");
                                                                    final StringBuilder sb11 = sb10;
                                                                    try {
                                                                        sb11.append(s3);
                                                                        sb4.append(sb10.toString());
                                                                        final StringBuffer sb12 = sb4;
                                                                        try {
                                                                            sb12.append(s3);
                                                                            final String string2 = sb4.toString();
                                                                            try {
                                                                                dataOutputStream.write(string2.getBytes());
                                                                                final FileInputStream fileInputStream = new FileInputStream(file);
                                                                                final byte[] array = new byte[1024];
                                                                                while (true) {
                                                                                    final int read = fileInputStream.read(array);
                                                                                    if (read == -1) {
                                                                                        break;
                                                                                    }
                                                                                    dataOutputStream.write(array, 0, read);
                                                                                }
                                                                                fileInputStream.close();
                                                                                dataOutputStream.write(s3.getBytes());
                                                                                try {
                                                                                    final StringBuilder sb14;
                                                                                    final StringBuilder sb13 = sb14 = new StringBuilder();
                                                                                    try {
                                                                                        sb14.append(s2);
                                                                                        final StringBuilder sb15 = sb13;
                                                                                        try {
                                                                                            sb15.append(string);
                                                                                            final StringBuilder sb16 = sb13;
                                                                                            try {
                                                                                                sb16.append(s2);
                                                                                                final StringBuilder sb17 = sb13;
                                                                                                try {
                                                                                                    sb17.append(s3);
                                                                                                    final String string3 = sb13.toString();
                                                                                                    try {
                                                                                                        dataOutputStream.write(string3.getBytes());
                                                                                                        dataOutputStream.flush();
                                                                                                        dataOutputStream.close();
                                                                                                        final int responseCode = httpURLConnection.getResponseCode();
                                                                                                        try {
                                                                                                            outputStream.close();
                                                                                                            httpURLConnection.disconnect();
                                                                                                            this.c(this.y += 400);
                                                                                                            if (responseCode == 200) {
                                                                                                                return "1";
                                                                                                            }
                                                                                                            return "0";
                                                                                                        }
                                                                                                        catch (IOException ex) {}
                                                                                                        catch (MalformedURLException ex2) {}
                                                                                                    }
                                                                                                    catch (IOException ex3) {}
                                                                                                    catch (MalformedURLException ex4) {}
                                                                                                }
                                                                                                catch (IOException ex5) {}
                                                                                                catch (MalformedURLException ex6) {}
                                                                                            }
                                                                                            catch (IOException ex7) {}
                                                                                            catch (MalformedURLException ex8) {}
                                                                                        }
                                                                                        catch (IOException ex9) {}
                                                                                        catch (MalformedURLException ex10) {}
                                                                                    }
                                                                                    catch (IOException ex11) {}
                                                                                    catch (MalformedURLException ex12) {}
                                                                                }
                                                                                catch (IOException ex13) {}
                                                                                catch (MalformedURLException ex14) {}
                                                                            }
                                                                            catch (IOException ex15) {}
                                                                            catch (MalformedURLException ex16) {}
                                                                        }
                                                                        catch (IOException ex17) {}
                                                                        catch (MalformedURLException ex18) {}
                                                                    }
                                                                    catch (IOException ex19) {}
                                                                    catch (MalformedURLException ex20) {}
                                                                }
                                                                catch (IOException ex21) {}
                                                                catch (MalformedURLException ex22) {}
                                                            }
                                                            catch (IOException ex23) {}
                                                            catch (MalformedURLException ex24) {}
                                                        }
                                                        catch (IOException ex25) {}
                                                        catch (MalformedURLException ex26) {}
                                                    }
                                                    catch (IOException ex27) {}
                                                    catch (MalformedURLException ex28) {}
                                                }
                                                catch (IOException ex29) {}
                                                catch (MalformedURLException ex30) {}
                                            }
                                            catch (IOException ex31) {}
                                            catch (MalformedURLException ex32) {}
                                        }
                                        catch (IOException ex33) {}
                                        catch (MalformedURLException ex34) {}
                                    }
                                    catch (IOException ex35) {}
                                    catch (MalformedURLException ex36) {}
                                }
                                catch (IOException ex37) {}
                                catch (MalformedURLException ex38) {}
                            }
                            catch (IOException ex39) {}
                            catch (MalformedURLException ex40) {}
                        }
                        catch (IOException ex41) {}
                        catch (MalformedURLException ex42) {}
                    }
                    catch (IOException ex43) {}
                    catch (MalformedURLException ex44) {}
                }
                catch (IOException ex45) {}
                catch (MalformedURLException ex46) {}
            }
            catch (IOException ex47) {}
            catch (MalformedURLException ex48) {}
        }
        catch (IOException ex49) {}
        catch (MalformedURLException ex50) {}
        return "0";
    }
    
    private boolean a(final String s, final Context context) {
        boolean b = false;
        final String s2 = "activity";
        try {
            final Object systemService = context.getSystemService(s2);
            try {
                final ActivityManager activityManager = (ActivityManager)systemService;
                try {
                    final List runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return b;
                    }
                    final Iterator<ActivityManager$RunningAppProcessInfo> iterator = runningAppProcesses.iterator();
                    try {
                        while (iterator.hasNext()) {
                            final ActivityManager$RunningAppProcessInfo next = iterator.next();
                            try {
                                final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo = next;
                                try {
                                    if (!activityManager$RunningAppProcessInfo.processName.equals(s)) {
                                        continue;
                                    }
                                    final int importance = activityManager$RunningAppProcessInfo.importance;
                                    if (importance == 200 || importance == 100) {
                                        b = true;
                                        continue;
                                    }
                                    continue;
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
            catch (Exception ex5) {}
        }
        catch (Exception ex6) {}
        return b;
    }
    
    private byte[] a(int n) {
        final byte[] array = { (byte)(n & 0xFF), (byte)((0xFF00 & n) >> 8), (byte)((0xFF0000 & n) >> 16), 0 };
        n = (byte)((n & 0xFF000000) >> 24);
        array[3] = (byte)n;
        return array;
    }
    
    private byte[] a(final String s) {
        if (s == null) {
            return null;
        }
        final byte[] bytes = s.getBytes();
        final Random random = new Random();
        final int n = 255;
        final byte b = (byte)random.nextInt(n);
        final byte b2 = (byte)new Random().nextInt(n);
        final byte[] array = new byte[bytes.length + 2];
        final int length = bytes.length;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            final byte b3 = bytes[i];
            final int n3 = n2 + 1;
            array[n2] = (byte)(b3 ^ b);
            ++i;
            n2 = n3;
        }
        final int n4 = n2 + 1;
        array[n2] = b;
        array[n4] = b2;
        return array;
    }
    
    private String b(final String s) {
        final Calendar instance = Calendar.getInstance();
        final Object[] array = new Object[3];
        final int n = 1;
        array[0] = instance.get(n);
        final int n2 = 2;
        array[n] = instance.get(n2) + n;
        array[n2] = instance.get(5);
        return String.format(s, array);
    }
    
    private void b(final int n) {
        final byte[] a = this.a(n);
        for (int i = 0; i < 4; ++i) {
            this.M.add(a[i]);
        }
    }
    
    private void b(final Location location) {
        this.c(location);
        this.h();
    }
    
    private void c() {
        if (this.N) {
            return;
        }
        this.N = true;
        this.d(com.baidu.location.d.b.d);
        this.j();
        this.d();
    }
    
    private void c(final int n) {
        if (n == 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.i.a);
        sb.append("/grtcf.dat");
        final String string = sb.toString();
        try {
            final File file = new File(string);
            final boolean exists = file.exists();
            final long n2 = 8;
            Label_0217: {
                if (exists) {
                    break Label_0217;
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
                    randomAccessFile.writeInt(0);
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.seek(n2);
                        final byte[] bytes = "1980_01_01:0".getBytes();
                        try {
                            randomAccessFile.writeInt(bytes.length);
                            final RandomAccessFile randomAccessFile3 = randomAccessFile;
                            try {
                                randomAccessFile3.write(bytes);
                                randomAccessFile.seek(200L);
                                final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                try {
                                    randomAccessFile4.writeBoolean(false);
                                    randomAccessFile.seek(800L);
                                    final RandomAccessFile randomAccessFile5 = randomAccessFile;
                                    try {
                                        randomAccessFile5.writeBoolean(false);
                                        randomAccessFile.close();
                                        final RandomAccessFile randomAccessFile7;
                                        final RandomAccessFile randomAccessFile6 = randomAccessFile7 = new RandomAccessFile(file, "rw");
                                        try {
                                            randomAccessFile7.seek(n2);
                                            try {
                                                final StringBuilder sb2 = new StringBuilder();
                                                sb2.append(this.b("%d_%02d_%02d"));
                                                sb2.append(":");
                                                final StringBuilder sb3 = sb2;
                                                try {
                                                    sb3.append(n);
                                                    final String string2 = sb2.toString();
                                                    try {
                                                        final byte[] bytes2 = string2.getBytes();
                                                        try {
                                                            randomAccessFile6.writeInt(bytes2.length);
                                                            final RandomAccessFile randomAccessFile8 = randomAccessFile6;
                                                            try {
                                                                randomAccessFile8.write(bytes2);
                                                                randomAccessFile6.close();
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
                catch (Exception ex12) {}
            }
        }
        catch (Exception ex13) {}
    }
    
    private void c(final Location location) {
        if (System.currentTimeMillis() - this.a >= this.H) {
            if (location != null) {
                if (location != null && location.hasSpeed() && location.getSpeed() > this.E) {
                    this.E = location.getSpeed();
                }
                Label_0143: {
                    try {
                        Label_0134: {
                            if (this.M != null) {
                                break Label_0134;
                            }
                            try {
                                final ArrayList m = new ArrayList();
                                try {
                                    this.M = m;
                                    this.i();
                                    try {
                                        this.d(location);
                                        break Label_0143;
                                        this.e(location);
                                    }
                                    catch (Exception ex) {}
                                }
                                catch (Exception ex2) {}
                            }
                            catch (Exception ex3) {}
                        }
                    }
                    catch (Exception ex4) {}
                }
                ++this.L;
            }
        }
    }
    
    private void c(String string) {
        if (string != null) {
            try {
                final JSONObject jsonObject = new JSONObject(string);
                string = "on";
                if (jsonObject.has(string)) {
                    string = "on";
                    this.k = jsonObject.getInt(string);
                }
                string = "bash";
                if (jsonObject.has(string)) {
                    string = "bash";
                    this.l = jsonObject.getDouble(string);
                }
                string = "net";
                if (jsonObject.has(string)) {
                    string = "net";
                    string = jsonObject.getString(string);
                    this.m = string;
                }
                string = "tcon";
                if (jsonObject.has(string)) {
                    string = "tcon";
                    this.n = jsonObject.getInt(string);
                }
                string = "tcsh";
                if (jsonObject.has(string)) {
                    string = "tcsh";
                    this.o = jsonObject.getInt(string);
                }
                string = "per";
                if (jsonObject.has(string)) {
                    string = "per";
                    this.p = jsonObject.getInt(string);
                }
                string = "chdron";
                if (jsonObject.has(string)) {
                    string = "chdron";
                    this.q = jsonObject.getInt(string);
                }
                string = "spsh";
                if (jsonObject.has(string)) {
                    string = "spsh";
                    this.r = jsonObject.getDouble(string);
                }
                string = "acsh";
                if (jsonObject.has(string)) {
                    string = "acsh";
                    this.s = jsonObject.getDouble(string);
                }
                string = "stspsh";
                if (jsonObject.has(string)) {
                    string = "stspsh";
                    this.t = jsonObject.getDouble(string);
                }
                string = "drstsh";
                if (jsonObject.has(string)) {
                    string = "drstsh";
                    this.u = jsonObject.getInt(string);
                }
                string = "stper";
                if (jsonObject.has(string)) {
                    string = "stper";
                    this.v = jsonObject.getInt(string);
                }
                string = "nondron";
                if (jsonObject.has(string)) {
                    string = "nondron";
                    this.w = jsonObject.getInt(string);
                }
                string = "nondrper";
                if (jsonObject.has(string)) {
                    string = "nondrper";
                    this.x = jsonObject.getInt(string);
                }
                string = "uptime";
                if (jsonObject.has(string)) {
                    string = "uptime";
                    this.z = jsonObject.getLong(string);
                }
                this.k();
            }
            catch (JSONException ex) {}
        }
    }
    
    private void d() {
        final String[] split = "7.5.2".split("\\.");
        int length = split.length;
        final byte[] j = this.J;
        int i = 0;
        j[1] = (j[0] = 0);
        j[3] = (j[2] = 0);
        if (length >= 4) {
            length = 4;
        }
        while (i < length) {
            try {
                final byte[] k = this.J;
                final String s = split[i];
                try {
                    final Integer value = Integer.valueOf(s);
                    try {
                        k[i] = (byte)(value & 0xFF);
                        ++i;
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
            break;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.b.d);
        sb.append(":");
        sb.append(com.baidu.location.d.b.a().b);
        this.K = this.a(sb.toString());
    }
    
    private void d(final Location b) {
        this.e = System.currentTimeMillis();
        this.b((int)(b.getTime() / 1000L));
        final double longitude = b.getLongitude();
        final double n = 1000000.0;
        this.b((int)(longitude * n));
        this.b((int)(b.getLatitude() * n));
        final int n2 = (b.hasBearing() ^ true) ? 1 : 0;
        final int n3 = (b.hasSpeed() ^ true) ? 1 : 0;
        byte b2;
        if (n2 > 0) {
            b2 = 32;
        }
        else {
            b2 = (byte)((byte)((int)(b.getBearing() / 15.0f) & 0xFF) & 0xFFFFFFDF);
        }
        this.M.add(b2);
        byte b3;
        if (n3 > 0) {
            b3 = -128;
        }
        else {
            final double n4 = b.getSpeed();
            Double.isNaN(n4);
            b3 = (byte)((byte)((int)(n4 * 3.6 / 4.0) & 0xFF) & 0x7F);
        }
        this.M.add(b3);
        this.b = b;
    }
    
    private void d(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.i.a);
        sb.append("/grtcf.dat");
        final String string = sb.toString();
        try {
            final File file = new File(string);
            if (file.exists()) {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2);
                final int int1 = randomAccessFile.readInt();
                randomAccessFile.seek(8);
                final int int2 = randomAccessFile.readInt();
                try {
                    final byte[] array = new byte[int2];
                    randomAccessFile.read(array, 0, int2);
                    final String s2 = new String(array);
                    final boolean contains = s2.contains(this.b("%d_%02d_%02d"));
                    int n = 1;
                    Label_0237: {
                        if (contains && s2.contains(":")) {
                            final String s3 = ":";
                            final String s4 = s2;
                            try {
                                final String[] split = s4.split(s3);
                                try {
                                    if (split.length <= n) {
                                        break Label_0237;
                                    }
                                    final String s5 = split[n];
                                    try {
                                        final Integer value = Integer.valueOf(s5);
                                        try {
                                            this.y = value;
                                        }
                                        catch (Exception ex) {}
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                    }
                    while (true) {
                        Label_0332: {
                            if (n > int1) {
                                break Label_0332;
                            }
                            randomAccessFile.seek(n * 2048);
                            final int int3 = randomAccessFile.readInt();
                            try {
                                final byte[] array2 = new byte[int3];
                                randomAccessFile.read(array2, 0, int3);
                                final String s6 = new String(array2);
                                if (s != null && s6.contains(s)) {
                                    this.c(s6);
                                    randomAccessFile.close();
                                    return;
                                }
                                ++n;
                                continue;
                            }
                            catch (Exception ex5) {}
                        }
                    }
                }
                catch (Exception ex6) {}
            }
        }
        catch (Exception ex7) {}
    }
    
    private void e(final Location b) {
        if (b == null) {
            return;
        }
        final double n = b.getLongitude() - this.b.getLongitude();
        final double n2 = 1000000.0;
        final int n3 = (int)(n * n2);
        final int n4 = (int)((b.getLatitude() - this.b.getLatitude()) * n2);
        final boolean hasBearing = b.hasBearing();
        final int n5 = 1;
        final int n6 = (hasBearing ? 1 : 0) ^ n5;
        final int n7 = (b.hasSpeed() ? 1 : 0) ^ n5;
        int n8;
        if (n3 > 0) {
            n8 = 0;
        }
        else {
            n8 = 1;
        }
        final int abs = Math.abs(n3);
        int n9;
        if (n4 > 0) {
            n9 = 0;
        }
        else {
            n9 = 1;
        }
        final int abs2 = Math.abs(n4);
        if (this.L > n5) {
            this.c = null;
            this.c = this.b;
        }
        this.b = b;
        final Location b2 = this.b;
        if (b2 != null && this.c != null && b2.getTime() > this.c.getTime() && this.b.getTime() - this.c.getTime() < 5000L) {
            final long n10 = this.b.getTime() - this.c.getTime();
            final float[] array = new float[2];
            Location.distanceBetween(this.b.getAltitude(), this.b.getLongitude(), this.c.getLatitude(), this.c.getLongitude(), array);
            final double n11 = (array[0] - this.c.getSpeed() * n10) * 2.0f / (n10 * n10);
            if (n11 > this.F) {
                this.F = (float)n11;
            }
        }
        this.M.add((byte)(abs & 0xFF));
        final List m = this.M;
        final int n12 = 65280;
        m.add((byte)((abs & n12) >> 8));
        this.M.add((byte)(abs2 & 0xFF));
        this.M.add((byte)((abs2 & n12) >> 8));
        byte b3 = 0;
        Label_0729: {
            if (n6 > 0) {
                b3 = 32;
                if (n9 > 0) {
                    b3 = 96;
                }
                if (n8 <= 0) {
                    break Label_0729;
                }
            }
            else {
                b3 = (byte)((byte)((int)(b.getBearing() / 15.0f) & 0xFF) & 0x1F);
                if (n9 > 0) {
                    b3 |= 0x40;
                }
                if (n8 <= 0) {
                    break Label_0729;
                }
            }
            b3 |= 0xFFFFFF80;
        }
        this.M.add(b3);
        if (n7 > 0) {
            this.M.add((byte)(-128));
        }
        else {
            final double n13 = b.getSpeed();
            Double.isNaN(n13);
            this.M.add((byte)((byte)((int)(n13 * 3.6 / 4.0) & 0xFF) & 0x7F));
        }
    }
    
    private void e(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.i.a);
        sb.append("/grtcf.dat");
        final String string = sb.toString();
        try {
            final File file = new File(string);
            final boolean exists = file.exists();
            final long n = 2;
            Label_0206: {
                if (exists) {
                    break Label_0206;
                }
                try {
                    final File file2 = new File(com.baidu.location.d.i.a);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.createNewFile()) {
                        return;
                    }
                    final RandomAccessFile randomAccessFile2;
                    final RandomAccessFile randomAccessFile = randomAccessFile2 = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile2.seek(n);
                        final RandomAccessFile randomAccessFile3 = randomAccessFile;
                        try {
                            randomAccessFile3.writeInt(0);
                            randomAccessFile.seek(8);
                            final byte[] bytes = "1980_01_01:0".getBytes();
                            try {
                                randomAccessFile.writeInt(bytes.length);
                                final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                try {
                                    randomAccessFile4.write(bytes);
                                    randomAccessFile.seek(200L);
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
                                                final int int1 = randomAccessFile7.readInt();
                                                int n2 = 1;
                                                while (true) {
                                                    Label_0328: {
                                                        if (n2 > int1) {
                                                            break Label_0328;
                                                        }
                                                        randomAccessFile7.seek(n2 * 2048);
                                                        final int int2 = randomAccessFile7.readInt();
                                                        try {
                                                            final byte[] array = new byte[int2];
                                                            randomAccessFile7.read(array, 0, int2);
                                                            if (!new String(array).contains(com.baidu.location.d.b.d)) {
                                                                ++n2;
                                                                continue;
                                                            }
                                                            Label_0347: {
                                                                if (n2 < int1) {
                                                                    break Label_0347;
                                                                }
                                                                randomAccessFile7.seek(n);
                                                                final RandomAccessFile randomAccessFile9 = randomAccessFile7;
                                                                try {
                                                                    randomAccessFile9.writeInt(n2);
                                                                    randomAccessFile7.seek(n2 * 2048);
                                                                    final byte[] bytes2 = s.getBytes();
                                                                    try {
                                                                        randomAccessFile7.writeInt(bytes2.length);
                                                                        final RandomAccessFile randomAccessFile10 = randomAccessFile7;
                                                                        try {
                                                                            randomAccessFile10.write(bytes2);
                                                                            randomAccessFile7.close();
                                                                        }
                                                                        catch (Exception ex) {}
                                                                    }
                                                                    catch (Exception ex2) {}
                                                                }
                                                                catch (Exception ex3) {}
                                                            }
                                                        }
                                                        catch (Exception ex4) {}
                                                    }
                                                }
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
                catch (Exception ex12) {}
            }
        }
        catch (Exception ex13) {}
    }
    
    private boolean e() {
        FileLock tryLock = null;
        boolean b = false;
        try {
            try {
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.location.d.j.g());
                    sb.append(File.separator);
                    sb.append("gflk.dat");
                    final File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        final FileChannel channel = randomAccessFile.getChannel();
                        try {
                            tryLock = channel.tryLock();
                        }
                        catch (Exception ex) {
                            b = true;
                        }
                        finally {
                            tryLock = (FileLock)channel;
                            goto Label_0193;
                        }
                        if (tryLock != null) {
                            try {
                                tryLock.release();
                            }
                            catch (Exception tryLock) {
                                return b;
                            }
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            return b;
                        }
                        return b;
                    }
                    catch (Exception tryLock) {
                        tryLock = (FileLock)randomAccessFile;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
        try {
            ((AbstractInterruptibleChannel)tryLock).close();
            goto Label_0208;
        }
        catch (Exception ex5) {}
        if (tryLock != null) {
            ((RandomAccessFile)tryLock).close();
        }
        return b;
    }
    
    private boolean f() {
        final boolean b = this.B;
        boolean b2 = true;
        if (b) {
            if (this.C) {
                if (this.E >= this.t) {
                    this.D = 0;
                    this.C = false;
                    return b2;
                }
                this.D += this.p;
                if (this.D <= this.u) {
                    return b2;
                }
                if (System.currentTimeMillis() - this.G > this.v * 1000) {
                    return b2;
                }
            }
            else {
                if (this.E < this.t) {
                    this.C = b2;
                    this.D = 0;
                    this.D += this.p;
                    return b2;
                }
                return b2;
            }
        }
        else {
            if (this.E >= this.r || this.F >= this.s) {
                this.B = b2;
                return b2;
            }
            if (this.w == (b2 ? 1 : 0) && System.currentTimeMillis() - this.G > this.x * 1000) {
                return b2;
            }
        }
        b2 = false;
        return b2;
    }
    
    private void g() {
        this.M = null;
        this.e = 0L;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }
    
    private void h() {
        if (this.e != 0L) {
            if (System.currentTimeMillis() - this.e >= this.p * 1000) {
                final SharedPreferences sharedPreferences = com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4);
                final String s = "is_navi_on";
                int i = 0;
                if (sharedPreferences.getBoolean(s, false)) {
                    this.g();
                    return;
                }
                final int n = this.n;
                final int n2 = 1;
                if (n == n2 && !this.f()) {
                    this.g();
                    return;
                }
                if (!com.baidu.location.d.b.d.equals("com.ubercab.driver")) {
                    if (!this.a(com.baidu.location.d.b.d, com.baidu.location.f.getServiceContext())) {
                        this.g();
                        return;
                    }
                }
                else if (this.e()) {
                    this.g();
                    return;
                }
                final List m = this.M;
                if (m != null) {
                    final int size = m.size();
                    this.M.set(0, (byte)(size & 0xFF));
                    this.M.set(n2, (byte)((0xFF00 & size) >> 8));
                    this.M.set(3, (byte)(this.L & 0xFF));
                    final byte[] array = new byte[size];
                    while (i < size) {
                        array[i] = this.M.get(i);
                        ++i;
                    }
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        final File file = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (file.exists()) {
                            final File file2 = new File(file, "intime.dat");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            try {
                                final BufferedOutputStream bufferedOutputStream = new(java.io.BufferedOutputStream.class);
                                try {
                                    final FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                    final BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                                    try {
                                        new BufferedOutputStream(fileOutputStream);
                                        final BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                                        try {
                                            bufferedOutputStream3.write(array);
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            new com.baidu.location.a.f(this).start();
                                        }
                                        catch (Exception ex) {}
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                    }
                    this.g();
                    this.G = System.currentTimeMillis();
                }
            }
        }
    }
    
    private void i() {
        final List m = this.M;
        int i = 0;
        m.add((byte)0);
        this.M.add((byte)0);
        List list;
        byte b;
        if (com.baidu.location.a.d.f.equals("0")) {
            list = this.M;
            b = -82;
        }
        else {
            list = this.M;
            b = -66;
        }
        list.add(b);
        this.M.add((byte)0);
        this.M.add(this.J[0]);
        this.M.add(this.J[1]);
        this.M.add(this.J[2]);
        this.M.add(this.J[3]);
        final int length = this.K.length;
        this.M.add((byte)(length + 1 & 0xFF));
        while (i < length) {
            this.M.add(this.K[i]);
            ++i;
        }
    }
    
    private void j() {
        if (System.currentTimeMillis() - this.z > 86400000L) {
            if (this.A == null) {
                this.A = new d$a(this);
            }
            final StringBuffer sb = new StringBuffer();
            sb.append(com.baidu.location.d.b.a().a(false));
            sb.append(com.baidu.location.a.a.a().c());
            this.A.a(sb.toString());
        }
        this.k();
    }
    
    private void k() {
    }
    
    public void a(final Location location) {
        if (!this.N) {
            this.c();
        }
        final int k = this.k;
        final boolean b = true;
        if (k == (b ? 1 : 0) && this.m.contains(com.baidu.location.b.d.a(com.baidu.location.b.b.a().e()))) {
            if (this.n == (b ? 1 : 0) && this.y > this.o) {
                return;
            }
            this.I.post((Runnable)new e(this, location));
        }
    }
    
    public void b() {
        if (!this.N) {
            return;
        }
        this.N = false;
        this.g();
    }
}
