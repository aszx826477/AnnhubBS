// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import com.baidu.location.f;
import android.os.Environment;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.util.Enumeration;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import android.os.Process;
import android.provider.Settings$Secure;
import android.os.Build$VERSION;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.math.BigInteger;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.io.File;
import com.baidu.location.b.e;
import com.baidu.location.b.b;
import android.location.Location;
import com.baidu.location.b.g;
import com.baidu.location.b.a;
import java.util.Locale;
import java.util.Calendar;
import java.lang.reflect.Method;
import android.provider.Settings$System;
import android.content.Context;

public class j
{
    public static float A;
    public static float B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public static int I;
    public static float J;
    public static float K;
    public static float L;
    public static float M;
    public static int N;
    public static float O;
    public static int P;
    public static float Q;
    public static float R;
    public static float S;
    public static int T;
    public static int U;
    public static int V;
    public static int W;
    public static int X;
    public static int Y;
    public static boolean Z;
    public static boolean a;
    private static String aA;
    private static String aB;
    public static boolean aa;
    public static int ab;
    public static int ac;
    public static int ad;
    public static int ae;
    public static long af;
    public static long ag;
    public static long ah;
    public static long ai;
    public static long aj;
    public static long ak;
    public static int al;
    public static int am;
    public static int an;
    public static int ao;
    public static float ap;
    public static float aq;
    public static float ar;
    public static int as;
    public static int at;
    public static int au;
    private static String av;
    private static String aw;
    private static String ax;
    private static String ay;
    private static String az;
    public static boolean b;
    public static boolean c;
    public static int d;
    public static String e;
    public static String f;
    public static String g;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public static String m;
    public static String n;
    public static boolean o;
    public static int p;
    public static double q;
    public static double r;
    public static double s;
    public static double t;
    public static int u;
    public static byte[] v;
    public static boolean w;
    public static int x;
    public static float y;
    public static float z;
    
    static {
        com.baidu.location.d.j.a = false;
        com.baidu.location.d.j.b = false;
        com.baidu.location.d.j.c = false;
        com.baidu.location.d.j.d = 0;
        com.baidu.location.d.j.av = "http://loc.map.baidu.com/sdk.php";
        com.baidu.location.d.j.e = "http://loc.map.baidu.com/sdk_ep.php";
        com.baidu.location.d.j.aw = "http://loc.map.baidu.com/user_err.php";
        com.baidu.location.d.j.ax = "http://loc.map.baidu.com/oqur.php";
        com.baidu.location.d.j.ay = "http://loc.map.baidu.com/tcu.php";
        com.baidu.location.d.j.az = "http://loc.map.baidu.com/rtbu.php";
        com.baidu.location.d.j.aA = "http://loc.map.baidu.com/iofd.php";
        com.baidu.location.d.j.aB = "http://loc.map.baidu.com/wloc";
        com.baidu.location.d.j.f = "https://loc.map.baidu.com/sdk.php";
        com.baidu.location.d.j.g = "no";
        com.baidu.location.d.j.h = false;
        com.baidu.location.d.j.i = false;
        com.baidu.location.d.j.j = false;
        com.baidu.location.d.j.k = false;
        com.baidu.location.d.j.l = false;
        com.baidu.location.d.j.m = "gcj02";
        com.baidu.location.d.j.n = "";
        final boolean b = com.baidu.location.d.j.o = true;
        final int c = com.baidu.location.d.j.p = 3;
        com.baidu.location.d.j.t = (com.baidu.location.d.j.s = (com.baidu.location.d.j.r = (com.baidu.location.d.j.q = 0.0)));
        com.baidu.location.d.j.u = 0;
        com.baidu.location.d.j.v = null;
        com.baidu.location.d.j.w = false;
        com.baidu.location.d.j.x = 0;
        com.baidu.location.d.j.y = 1.1f;
        com.baidu.location.d.j.z = 2.2f;
        com.baidu.location.d.j.A = 2.3f;
        com.baidu.location.d.j.B = 3.8f;
        com.baidu.location.d.j.C = c;
        com.baidu.location.d.j.D = 10;
        com.baidu.location.d.j.E = 2;
        com.baidu.location.d.j.F = 7;
        final int ab = com.baidu.location.d.j.G = 20;
        final int at = com.baidu.location.d.j.H = 70;
        com.baidu.location.d.j.I = 120;
        com.baidu.location.d.j.J = 2.0f;
        final float n = com.baidu.location.d.j.K = 10.0f;
        com.baidu.location.d.j.L = 50.0f;
        com.baidu.location.d.j.M = 200.0f;
        com.baidu.location.d.j.N = 16;
        com.baidu.location.d.j.O = 0.9f;
        com.baidu.location.d.j.P = 10000;
        com.baidu.location.d.j.Q = 0.5f;
        com.baidu.location.d.j.R = 0.0f;
        com.baidu.location.d.j.S = 0.1f;
        com.baidu.location.d.j.T = 30;
        com.baidu.location.d.j.U = 100;
        com.baidu.location.d.j.V = 0;
        com.baidu.location.d.j.W = 0;
        com.baidu.location.d.j.X = 0;
        com.baidu.location.d.j.Y = 420000;
        com.baidu.location.d.j.Z = b;
        com.baidu.location.d.j.aa = b;
        com.baidu.location.d.j.ab = ab;
        com.baidu.location.d.j.ac = 300;
        final int al = com.baidu.location.d.j.ad = 1000;
        com.baidu.location.d.j.ae = -1 >>> 1;
        com.baidu.location.d.j.af = 900000L;
        com.baidu.location.d.j.ag = 420000L;
        com.baidu.location.d.j.ah = 180000L;
        com.baidu.location.d.j.ai = 0L;
        com.baidu.location.d.j.aj = 15;
        com.baidu.location.d.j.ak = 300000L;
        com.baidu.location.d.j.al = al;
        com.baidu.location.d.j.am = 0;
        com.baidu.location.d.j.ao = (com.baidu.location.d.j.an = 30000);
        com.baidu.location.d.j.ap = n;
        com.baidu.location.d.j.aq = 6.0f;
        com.baidu.location.d.j.ar = n;
        com.baidu.location.d.j.as = 60;
        com.baidu.location.d.j.at = at;
        com.baidu.location.d.j.au = 6;
    }
    
    public static int a(final Context context) {
        int int1;
        try {
            int1 = Settings$System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        }
        catch (Exception ex) {
            int1 = 2;
        }
        return int1;
    }
    
    public static int a(String substring, String s, final String s2) {
        final int n = -1 << -1;
        if (substring != null) {
            if (!substring.equals("")) {
                final int index = substring.indexOf(s);
                final int n2 = -1;
                if (index == n2) {
                    return n;
                }
                final int n3 = index + s.length();
                final int index2 = substring.indexOf(s2, n3);
                if (index2 == n2) {
                    return n;
                }
                substring = substring.substring(n3, index2);
                if (substring != null) {
                    s = "";
                    if (!substring.equals(s)) {
                        try {
                            return Integer.parseInt(substring);
                        }
                        catch (NumberFormatException ex) {}
                    }
                }
            }
        }
        return n;
    }
    
    public static Object a(Context applicationContext, final String s) {
        Object systemService = null;
        if (applicationContext == null) {
            return null;
        }
        try {
            applicationContext = applicationContext.getApplicationContext();
            systemService = applicationContext.getSystemService(s);
        }
        finally {}
        return systemService;
    }
    
    public static Object a(final Object o, final String s, final Object... array) {
        final Class<?> class1 = o.getClass();
        final Class[] array2 = new Class[array.length];
        for (int length = array.length, i = 0; i < length; ++i) {
            array2[i] = array[i].getClass();
            if (array2[i] == Integer.class) {
                array2[i] = Integer.TYPE;
            }
        }
        final Method declaredMethod = class1.getDeclaredMethod(s, (Class<?>[])array2);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(o, array);
    }
    
    public static String a() {
        final Calendar instance = Calendar.getInstance();
        final int n = 5;
        final int value = instance.get(n);
        final int n2 = 1;
        final int value2 = instance.get(n2);
        final int n3 = 2;
        final int n4 = instance.get(n3) + n2;
        final int value3 = instance.get(11);
        final int value4 = instance.get(12);
        final int value5 = instance.get(13);
        final Locale china = Locale.CHINA;
        final Object[] array = new Object[6];
        array[0] = value2;
        array[n2] = n4;
        array[n3] = value;
        array[3] = value3;
        array[4] = value4;
        array[n] = value5;
        return String.format(china, "%d-%02d-%02d %02d:%02d:%02d", array);
    }
    
    public static String a(final a a, final g g, final Location location, final String s, final int n) {
        return a(a, g, location, s, n, false);
    }
    
    public static String a(a string, final g g, final Location location, final String s, int n, final boolean b) {
        final StringBuffer sb = new StringBuffer(1024);
        if (string != null) {
            final String b2 = b.a().b(string);
            if (b2 != null) {
                sb.append(b2);
            }
        }
        if (g != null) {
            String s2;
            if (n == 0) {
                if (b) {
                    s2 = g.b();
                }
                else {
                    s2 = g.c();
                }
            }
            else {
                s2 = g.d();
            }
            if (s2 != null) {
                sb.append(s2);
            }
        }
        if (location != null) {
            String s3;
            if (com.baidu.location.d.j.d != 0 && n != 0) {
                s3 = com.baidu.location.b.e.c(location);
            }
            else {
                s3 = com.baidu.location.b.e.b(location);
            }
            if (s3 != null) {
                sb.append(s3);
            }
        }
        boolean b3 = false;
        final boolean p6 = true;
        if (n == 0) {
            b3 = true;
        }
        final String a = b.a().a(b3);
        if (a != null) {
            sb.append(a);
        }
        if (s != null) {
            sb.append(s);
        }
        if (string != null) {
            final String a2 = b.a().a(string);
            if (a2 != null) {
                final int length = a2.length();
                n = sb.length();
                final int n2 = length + n;
                n = 750;
                if (n2 < n) {
                    sb.append(a2);
                }
            }
        }
        string = (a)sb.toString();
        final int n3 = 3;
        while (true) {
            if (location != null && g != null) {
                try {
                    final float speed = location.getSpeed();
                    try {
                        n = com.baidu.location.d.j.d;
                        try {
                            final int g2 = g.g();
                            try {
                                final int a3 = g.a();
                                try {
                                    final boolean h = g.h();
                                    try {
                                        if (speed < com.baidu.location.d.j.aq && (n == (p6 ? 1 : 0) || n == 0) && (g2 < com.baidu.location.d.j.as || h == p6)) {
                                            com.baidu.location.d.j.p = (p6 ? 1 : 0);
                                            return (String)string;
                                        }
                                        if (speed < com.baidu.location.d.j.ar && (n == (p6 ? 1 : 0) || n == 0 || n == n3) && (g2 < com.baidu.location.d.j.at || a3 > com.baidu.location.d.j.au)) {
                                            com.baidu.location.d.j.p = 2;
                                            return (String)string;
                                        }
                                        com.baidu.location.d.j.p = n3;
                                        return (String)string;
                                    }
                                    catch (Exception ex) {
                                        com.baidu.location.d.j.p = n3;
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
                catch (Exception ex6) {}
                return (String)string;
            }
            continue;
        }
    }
    
    public static String a(final File file, final String s) {
        if (!file.isFile()) {
            return null;
        }
        final int n = 1024;
        final byte[] array = new byte[n];
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                final FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    final int read = fileInputStream.read(array, 0, n);
                    if (read == -1) {
                        break;
                    }
                    instance.update(array, 0, read);
                }
                fileInputStream.close();
                return new BigInteger(1, instance.digest()).toString(16);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        catch (Exception ex2) {}
    }
    
    public static String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.location.d.j.n);
        sb.append(";");
        sb.append(s);
        return Jni.en1(sb.toString());
    }
    
    public static boolean a(final BDLocation bdLocation) {
        final int locType = bdLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }
    
    public static int b(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        int int1 = -1;
        if (sdk_INT >= 19) {
            try {
                int1 = Settings$Secure.getInt(context.getContentResolver(), "location_mode", int1);
            }
            catch (Exception ex) {}
        }
        else {
            int1 = -2;
        }
        return int1;
    }
    
    private static int b(final Context context, final String s) {
        final boolean b = true;
        Label_0038: {
            try {
                final int myPid = Process.myPid();
                try {
                    if (context.checkPermission(s, myPid, Process.myUid()) == 0) {
                        break Label_0038;
                    }
                    final boolean b2 = false;
                    return (b2 && b) ? 1 : 0;
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
        }
        final boolean b2 = true;
        return (b2 && b) ? 1 : 0;
    }
    
    public static int b(final Object o, final String s, final Object... array) {
        final Class<?> class1 = o.getClass();
        final Class[] array2 = new Class[array.length];
        for (int length = array.length, i = 0; i < length; ++i) {
            array2[i] = array[i].getClass();
            if (array2[i] == Integer.class) {
                array2[i] = Integer.TYPE;
            }
        }
        final Method declaredMethod = class1.getDeclaredMethod(s, (Class<?>[])array2);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return (int)declaredMethod.invoke(o, array);
    }
    
    public static String b() {
        try {
            final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            try {
                while (networkInterfaces.hasMoreElements()) {
                    final NetworkInterface nextElement = networkInterfaces.nextElement();
                    try {
                        final NetworkInterface networkInterface = nextElement;
                        try {
                            final Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                            try {
                                while (inetAddresses.hasMoreElements()) {
                                    final InetAddress nextElement2 = inetAddresses.nextElement();
                                    try {
                                        final InetAddress inetAddress = nextElement2;
                                        try {
                                            if (inetAddress.isLoopbackAddress() || !(inetAddress instanceof Inet4Address)) {
                                                continue;
                                            }
                                            final byte[] address = inetAddress.getAddress();
                                            String string = "";
                                            int n = 0;
                                            while (true) {
                                                if (n >= address.length) {
                                                    return string;
                                                }
                                                String s = Integer.toHexString(address[n] & 0xFF);
                                                try {
                                                    Label_0179: {
                                                        if (s.length() != 1) {
                                                            break Label_0179;
                                                        }
                                                        try {
                                                            final StringBuilder sb = new StringBuilder();
                                                            sb.append('0');
                                                            final StringBuilder sb2 = sb;
                                                            try {
                                                                sb2.append(s);
                                                                s = sb.toString();
                                                                try {
                                                                    try {
                                                                        final StringBuilder sb4;
                                                                        final StringBuilder sb3 = sb4 = new StringBuilder();
                                                                        try {
                                                                            sb4.append(string);
                                                                            final StringBuilder sb5 = sb3;
                                                                            try {
                                                                                sb5.append(s);
                                                                                string = sb3.toString();
                                                                                ++n;
                                                                                continue;
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
                                                }
                                                catch (Exception ex7) {}
                                            }
                                        }
                                        catch (Exception ex8) {}
                                    }
                                    catch (Exception ex9) {}
                                }
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
        catch (Exception ex14) {}
        return null;
    }
    
    public static boolean b(final String s, final String s2, final String s3) {
        final String s4 = "RSA";
        try {
            final KeyFactory instance = KeyFactory.getInstance(s4);
            try {
                final byte[] bytes = s3.getBytes();
                try {
                    final byte[] a = com.baidu.android.bbalbs.common.a.b.a(bytes);
                    try {
                        final X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(a);
                        final KeyFactory keyFactory = instance;
                        try {
                            final PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
                            final Signature instance2 = Signature.getInstance("SHA1WithRSA");
                            instance2.initVerify(generatePublic);
                            instance2.update(s.getBytes());
                            final byte[] bytes2 = s2.getBytes();
                            try {
                                return instance2.verify(com.baidu.android.bbalbs.common.a.b.a(bytes2));
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
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
        catch (Exception ex6) {}
    }
    
    public static String c() {
        return com.baidu.location.d.j.av;
    }
    
    public static String c(final Context context) {
        final int b = b(context, "android.permission.ACCESS_COARSE_LOCATION");
        final int b2 = b(context, "android.permission.ACCESS_FINE_LOCATION");
        final int b3 = b(context, "android.permission.READ_PHONE_STATE");
        final StringBuilder sb = new StringBuilder();
        sb.append("&per=");
        sb.append(b);
        sb.append("|");
        sb.append(b2);
        sb.append("|");
        sb.append(b3);
        return sb.toString();
    }
    
    public static String d() {
        return com.baidu.location.d.j.ay;
    }
    
    public static String d(final Context context) {
        int type = -1;
        if (context != null) {
            final String s = "connectivity";
            try {
                final Object systemService = context.getSystemService(s);
                try {
                    final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                    try {
                        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            type = activeNetworkInfo.getType();
                        }
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("&netc=");
        sb.append(type);
        return sb.toString();
    }
    
    public static String e() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }
    
    public static String f() {
        try {
            Label_0083: {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    break Label_0083;
                }
                final File externalStorageDirectory = Environment.getExternalStorageDirectory();
                try {
                    final String path = externalStorageDirectory.getPath();
                    try {
                        try {
                            final StringBuilder sb2;
                            final StringBuilder sb = sb2 = new StringBuilder();
                            try {
                                sb2.append(path);
                                sb.append("/baidu/tempdata");
                                final String string = sb.toString();
                                try {
                                    final File file = new File(string);
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    return path;
                                    return null;
                                }
                                catch (Exception ex) {
                                    return null;
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
    
    public static String g() {
        final String f = f();
        if (f == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append("/baidu/tempdata");
        return sb.toString();
    }
    
    public static String h() {
        try {
            try {
                try {
                    final StringBuilder sb = new StringBuilder();
                    final Context serviceContext = com.baidu.location.f.getServiceContext();
                    try {
                        sb.append(serviceContext.getFilesDir());
                        sb.append(File.separator);
                        sb.append("lldt");
                        final File file = new File(sb.toString());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        return file.getAbsolutePath();
                    }
                    catch (Exception ex) {
                        return null;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
}
