// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.Jni;
import java.util.Locale;
import android.location.Location;
import com.baidu.location.d.j;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.baidu.location.d.b;
import com.baidu.location.d.i;
import java.io.File;

public class g
{
    private static g a;
    private static String b;
    private static File c;
    private static StringBuffer d;
    private static boolean e;
    private static int f;
    private static int g;
    private static long h;
    private static long i;
    private static long j;
    private static double k;
    private static double l;
    private static int m;
    private static int n;
    private static int o;
    private String p;
    private boolean q;
    
    static {
        com.baidu.location.a.g.a = null;
        com.baidu.location.a.g.b = "Temp_in.dat";
        com.baidu.location.a.g.c = new File(com.baidu.location.d.i.a, com.baidu.location.a.g.b);
        com.baidu.location.a.g.d = null;
        com.baidu.location.a.g.e = true;
        com.baidu.location.a.g.f = 0;
        com.baidu.location.a.g.g = 0;
        com.baidu.location.a.g.j = (com.baidu.location.a.g.i = (com.baidu.location.a.g.h = 0L));
        com.baidu.location.a.g.l = (com.baidu.location.a.g.k = 0.0);
        com.baidu.location.a.g.m = 0;
        com.baidu.location.a.g.n = 0;
        com.baidu.location.a.g.o = 0;
    }
    
    private g(String substring) {
        this.p = null;
        this.q = true;
        if (substring != null) {
            final int length = substring.length();
            final int n = 100;
            if (length > n) {
                substring = substring.substring(0, n);
            }
        }
        else {
            substring = "";
        }
        this.p = substring;
    }
    
    public static g a() {
        if (com.baidu.location.a.g.a == null) {
            com.baidu.location.a.g.a = new g(com.baidu.location.d.b.a().c());
        }
        return com.baidu.location.a.g.a;
    }
    
    private String a(int int1) {
        if (!com.baidu.location.a.g.c.exists()) {
            return null;
        }
        try {
            try {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(com.baidu.location.a.g.c, "rw");
                randomAccessFile.seek(0L);
                final int int2 = randomAccessFile.readInt();
                try {
                    final int int3 = randomAccessFile.readInt();
                    try {
                        if (!a(int2, int3, randomAccessFile.readInt())) {
                            randomAccessFile.close();
                            d();
                            return null;
                        }
                        Label_0214: {
                            if (int1 == 0 || int1 == int2 + 1) {
                                break Label_0214;
                            }
                            int1 = (int1 - 1) * 1024;
                            final long n = 12 + int1;
                            randomAccessFile.seek(n);
                            int1 = randomAccessFile.readInt();
                            try {
                                final byte[] array = new byte[int1];
                                randomAccessFile.seek(n + 4);
                                for (int i = 0; i < int1; ++i) {
                                    array[i] = randomAccessFile.readByte();
                                }
                                randomAccessFile.close();
                                return new String(array);
                                randomAccessFile.close();
                                return null;
                            }
                            catch (IOException ex) {
                                return null;
                            }
                        }
                    }
                    catch (IOException ex2) {}
                }
                catch (IOException ex3) {}
            }
            catch (IOException ex4) {}
        }
        catch (IOException ex5) {}
    }
    
    private static boolean a(int ad, final int n, final int n2) {
        if (ad >= 0) {
            if (ad <= com.baidu.location.d.j.ad) {
                if (n >= 0) {
                    final int n3 = 1;
                    ad += n3;
                    if (n <= ad) {
                        if (n2 >= n3 && n2 <= ad) {
                            ad = com.baidu.location.d.j.ad;
                            if (n2 <= ad) {
                                return n3 != 0;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private boolean a(final Location location, final int n, final int n2) {
        if (location == null || !com.baidu.location.d.j.Z || this.q) {
            return false;
        }
        final int ab = com.baidu.location.d.j.ab;
        int n3 = 5;
        if (ab < n3) {
            com.baidu.location.d.j.ab = n3;
        }
        else {
            final int ab2 = com.baidu.location.d.j.ab;
            final int ab3 = 1000;
            if (ab2 > ab3) {
                com.baidu.location.d.j.ab = ab3;
            }
        }
        Label_0116: {
            if (com.baidu.location.d.j.ac >= n3) {
                final int ac = com.baidu.location.d.j.ac;
                n3 = 3600;
                if (ac <= n3) {
                    break Label_0116;
                }
            }
            com.baidu.location.d.j.ac = n3;
        }
        final double longitude = location.getLongitude();
        final double latitude = location.getLatitude();
        final long h = location.getTime() / 1000L;
        final boolean e = com.baidu.location.a.g.e;
        final int n4 = 4;
        final int n5 = 3;
        final int n6 = 2;
        final double n7 = 0.5;
        final double n8 = 100000.0;
        final int f = 1;
        if (e) {
            com.baidu.location.a.g.f = f;
            com.baidu.location.a.g.d = new StringBuffer("");
            final StringBuffer d = com.baidu.location.a.g.d;
            final Locale china = Locale.CHINA;
            final Object[] array = new Object[n4];
            array[0] = this.p;
            array[f] = h;
            array[n6] = longitude;
            array[n5] = latitude;
            d.append(String.format(china, "&nr=%s&traj=%d,%.5f,%.5f|", array));
            com.baidu.location.a.g.g = com.baidu.location.a.g.d.length();
            com.baidu.location.a.g.h = h;
            com.baidu.location.a.g.k = longitude;
            com.baidu.location.a.g.l = latitude;
            com.baidu.location.a.g.i = (long)Math.floor(longitude * n8 + n7);
            com.baidu.location.a.g.j = (long)Math.floor(latitude * n8 + n7);
            com.baidu.location.a.g.e = false;
            return f != 0;
        }
        final float[] array2 = new float[f];
        final double l = com.baidu.location.a.g.l;
        final double k = com.baidu.location.a.g.k;
        final int n9 = 1;
        Location.distanceBetween(latitude, longitude, l, k, array2);
        final long n10 = h - com.baidu.location.a.g.h;
        if (array2[0] < com.baidu.location.d.j.ab && n10 < com.baidu.location.d.j.ac) {
            return false;
        }
        if (com.baidu.location.a.g.d == null) {
            ++com.baidu.location.a.g.f;
            com.baidu.location.a.g.g = 0;
            com.baidu.location.a.g.d = new StringBuffer("");
            final StringBuffer d2 = com.baidu.location.a.g.d;
            final Locale china2 = Locale.CHINA;
            final String s = "&nr=%s&traj=%d,%.5f,%.5f|";
            final Object[] array3 = new Object[4];
            array3[0] = this.p;
            array3[n9] = h;
            array3[n6] = longitude;
            array3[3] = latitude;
            d2.append(String.format(china2, s, array3));
            com.baidu.location.a.g.g = com.baidu.location.a.g.d.length();
            com.baidu.location.a.g.h = h;
            com.baidu.location.a.g.k = longitude;
            com.baidu.location.a.g.l = latitude;
            com.baidu.location.a.g.i = (long)Math.floor(longitude * n8 + n7);
            com.baidu.location.a.g.j = (long)Math.floor(latitude * n8 + n7);
        }
        else {
            final int n11 = 3;
            com.baidu.location.a.g.k = longitude;
            com.baidu.location.a.g.l = latitude;
            final long i = (long)Math.floor(longitude * n8 + n7);
            final long j = (long)Math.floor(latitude * n8 + n7);
            com.baidu.location.a.g.m = (int)(h - com.baidu.location.a.g.h);
            com.baidu.location.a.g.n = (int)(i - com.baidu.location.a.g.i);
            com.baidu.location.a.g.o = (int)(j - com.baidu.location.a.g.j);
            final StringBuffer d3 = com.baidu.location.a.g.d;
            final Locale china3 = Locale.CHINA;
            final String s2 = "%d,%d,%d|";
            final Object[] array4 = new Object[n11];
            array4[0] = com.baidu.location.a.g.m;
            array4[n9] = com.baidu.location.a.g.n;
            array4[n6] = com.baidu.location.a.g.o;
            d3.append(String.format(china3, s2, array4));
            com.baidu.location.a.g.g = com.baidu.location.a.g.d.length();
            com.baidu.location.a.g.h = h;
            com.baidu.location.a.g.i = i;
            com.baidu.location.a.g.j = j;
        }
        if (com.baidu.location.a.g.g + 15 > 750) {
            this.a(com.baidu.location.a.g.d.toString());
            com.baidu.location.a.g.d = null;
        }
        if (com.baidu.location.a.g.f >= com.baidu.location.d.j.ad) {
            this.q = false;
        }
        return n9 != 0;
    }
    
    private boolean a(String encode) {
        if (encode != null) {
            if (encode.startsWith("&nr")) {
                if (!com.baidu.location.a.g.c.exists() && !d()) {
                    return false;
                }
                try {
                    try {
                        final RandomAccessFile randomAccessFile = new RandomAccessFile(com.baidu.location.a.g.c, "rw");
                        final long n = 0L;
                        randomAccessFile.seek(n);
                        final int int1 = randomAccessFile.readInt();
                        try {
                            final int int2 = randomAccessFile.readInt();
                            try {
                                final int int3 = randomAccessFile.readInt();
                                if (!a(int1, int2, int3)) {
                                    randomAccessFile.close();
                                    d();
                                    return false;
                                }
                                final boolean aa = com.baidu.location.d.j.aa;
                                final int n2 = 1;
                                if (aa) {
                                    if (int1 != com.baidu.location.d.j.ad) {
                                        if (int3 > n2 && encode.equals(this.a(int3 - 1))) {
                                            randomAccessFile.close();
                                            return false;
                                        }
                                    }
                                    else {
                                        int ad;
                                        if (int3 == n2) {
                                            ad = com.baidu.location.d.j.ad;
                                        }
                                        else {
                                            ad = int3 - 1;
                                        }
                                        if (encode.equals(this.a(ad))) {
                                            randomAccessFile.close();
                                            return false;
                                        }
                                    }
                                }
                                randomAccessFile.seek((int3 - 1) * 1024 + 12 + n);
                                if (encode.length() > 750) {
                                    randomAccessFile.close();
                                    return false;
                                }
                                encode = Jni.encode(encode);
                                try {
                                    final int length = encode.length();
                                    if (length > 1020) {
                                        randomAccessFile.close();
                                        return false;
                                    }
                                    randomAccessFile.writeInt(length);
                                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                                    try {
                                        randomAccessFile2.writeBytes(encode);
                                        int n3 = 2;
                                        Label_0356: {
                                            if (int1 != 0) {
                                                break Label_0356;
                                            }
                                            randomAccessFile.seek(n);
                                            final RandomAccessFile randomAccessFile3 = randomAccessFile;
                                            try {
                                                randomAccessFile3.writeInt(n2);
                                                final RandomAccessFile randomAccessFile4 = randomAccessFile;
                                                try {
                                                    randomAccessFile4.writeInt(n2);
                                                    RandomAccessFile randomAccessFile5;
                                                    RandomAccessFile randomAccessFile6;
                                                    long n4;
                                                    RandomAccessFile randomAccessFile7;
                                                    RandomAccessFile randomAccessFile8;
                                                    long n5;
                                                    RandomAccessFile randomAccessFile9;
                                                    int n6;
                                                    int n7;
                                                    RandomAccessFile randomAccessFile10;
                                                    RandomAccessFile randomAccessFile11;
                                                    int n8;
                                                    Label_0540_Outer:Label_0516_Outer:
                                                    while (true) {
                                                        randomAccessFile5 = randomAccessFile;
                                                        try {
                                                            randomAccessFile5.writeInt(n3);
                                                            Label_0631: {
                                                                break Label_0631;
                                                                randomAccessFile.seek(n);
                                                                randomAccessFile.writeInt(int1 + 1);
                                                                randomAccessFile6 = randomAccessFile;
                                                                try {
                                                                    randomAccessFile6.seek(n4);
                                                                    randomAccessFile.writeInt(int1 + n3);
                                                                    break Label_0631;
                                                                    Label_0466: {
                                                                        randomAccessFile7 = randomAccessFile;
                                                                    }
                                                                    try {
                                                                        randomAccessFile7.seek(n4);
                                                                        randomAccessFile8 = randomAccessFile;
                                                                        try {
                                                                            randomAccessFile8.writeInt(n2);
                                                                            break Label_0631;
                                                                            // iftrue(Label_0534:, n3 != j.ad)
                                                                            while (true) {
                                                                            Label_0610_Outer:
                                                                                while (true) {
                                                                                    randomAccessFile.seek(n5);
                                                                                    randomAccessFile9 = randomAccessFile;
                                                                                    try {
                                                                                        randomAccessFile9.writeInt(n6);
                                                                                        continue Label_0540_Outer;
                                                                                        // iftrue(Label_0622:, n3 != int2)
                                                                                        // iftrue(Label_0573:, int3 != j.ad)
                                                                                        Block_47: {
                                                                                        Label_0610:
                                                                                            while (true) {
                                                                                                while (true) {
                                                                                                    n3 = 1;
                                                                                                    Label_0579: {
                                                                                                        break Label_0579;
                                                                                                        Label_0573:
                                                                                                        n3 = int3 + 1;
                                                                                                    }
                                                                                                    break Block_47;
                                                                                                    n7 = 1;
                                                                                                    break Label_0610;
                                                                                                    Label_0555:
                                                                                                    continue Label_0610_Outer;
                                                                                                }
                                                                                                randomAccessFile.seek(n5);
                                                                                                randomAccessFile10 = randomAccessFile;
                                                                                                try {
                                                                                                    randomAccessFile10.writeInt(n7);
                                                                                                    Label_0622:
                                                                                                    randomAccessFile11 = randomAccessFile;
                                                                                                    try {
                                                                                                        randomAccessFile11.seek(n4);
                                                                                                        continue Label_0540_Outer;
                                                                                                        randomAccessFile.close();
                                                                                                        return n2 != 0;
                                                                                                    }
                                                                                                    catch (IOException ex) {}
                                                                                                }
                                                                                                catch (IOException ex2) {}
                                                                                                Label_0604:
                                                                                                n7 = n3 + 1;
                                                                                                continue Label_0610;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    // iftrue(Label_0604:, n3 != j.ad)
                                                                                    catch (IOException ex3) {}
                                                                                    Block_43: {
                                                                                        break Block_43;
                                                                                        Label_0534:
                                                                                        n6 = n3 + 1;
                                                                                        continue Label_0516_Outer;
                                                                                    }
                                                                                    n6 = 1;
                                                                                    continue Label_0516_Outer;
                                                                                }
                                                                                Label_0510:
                                                                                n3 = int3 + 1;
                                                                                continue;
                                                                            }
                                                                            Label_0481:
                                                                            n5 = 4;
                                                                            // iftrue(Label_0555:, int3 != int2)
                                                                            // iftrue(Label_0510:, int3 != j.ad)
                                                                            n3 = 1;
                                                                        }
                                                                        catch (IOException ex4) {}
                                                                    }
                                                                    catch (IOException ex5) {}
                                                                    Label_0416:
                                                                    // iftrue(Label_0481:, int1 != j.ad - n2)
                                                                    randomAccessFile.seek(n);
                                                                    randomAccessFile.writeInt(com.baidu.location.d.j.ad);
                                                                    // iftrue(Label_0466:, int2 != 0 && int2 != n2)
                                                                    randomAccessFile.writeInt(n3);
                                                                }
                                                                catch (IOException ex6) {}
                                                            }
                                                            n8 = com.baidu.location.d.j.ad - n2;
                                                            n4 = 8;
                                                        }
                                                        // iftrue(Label_0416:, int1 >= n8)
                                                        catch (IOException ex7) {}
                                                    }
                                                }
                                                catch (IOException ex8) {}
                                            }
                                            catch (IOException ex9) {}
                                        }
                                    }
                                    catch (IOException ex10) {}
                                }
                                catch (IOException ex11) {}
                            }
                            catch (IOException ex12) {}
                        }
                        catch (IOException ex13) {}
                    }
                    catch (IOException ex14) {}
                }
                catch (IOException ex15) {}
            }
        }
        return false;
    }
    
    public static String b() {
        final File c = com.baidu.location.a.g.c;
        if (c == null) {
            return null;
        }
        if (!c.exists()) {
            return null;
        }
        try {
            try {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(com.baidu.location.a.g.c, "rw");
                final long n = 0L;
                randomAccessFile.seek(n);
                final int int1 = randomAccessFile.readInt();
                try {
                    final int int2 = randomAccessFile.readInt();
                    try {
                        final int int3 = randomAccessFile.readInt();
                        if (!a(int1, int2, int3)) {
                            randomAccessFile.close();
                            d();
                            return null;
                        }
                        Label_0273: {
                            if (int2 == 0 || int2 == int3) {
                                break Label_0273;
                            }
                            final long n2 = (int2 - 1) * 1024 + 12 + n;
                            randomAccessFile.seek(n2);
                            final int int4 = randomAccessFile.readInt();
                            try {
                                final byte[] array = new byte[int4];
                                final long n3 = 4;
                                randomAccessFile.seek(n2 + n3);
                                for (int i = 0; i < int4; ++i) {
                                    array[i] = randomAccessFile.readByte();
                                }
                                final String s = new String(array);
                                final int ad = com.baidu.location.d.j.ad;
                                final int n4 = 1;
                                int n5;
                                if (int1 < ad) {
                                    n5 = int2 + n4;
                                }
                                else if (int2 == com.baidu.location.d.j.ad) {
                                    n5 = 1;
                                }
                                else {
                                    n5 = n4 + int2;
                                }
                                randomAccessFile.seek(n3);
                                final RandomAccessFile randomAccessFile2 = randomAccessFile;
                                try {
                                    randomAccessFile2.writeInt(n5);
                                    randomAccessFile.close();
                                    return s;
                                    randomAccessFile.close();
                                    return null;
                                }
                                catch (IOException ex) {
                                    return null;
                                }
                            }
                            catch (IOException ex2) {}
                        }
                    }
                    catch (IOException ex3) {}
                }
                catch (IOException ex4) {}
            }
            catch (IOException ex5) {}
        }
        catch (IOException ex6) {}
    }
    
    private static void c() {
        com.baidu.location.a.g.e = true;
        com.baidu.location.a.g.d = null;
        com.baidu.location.a.g.f = 0;
        com.baidu.location.a.g.g = 0;
        com.baidu.location.a.g.j = (com.baidu.location.a.g.i = (com.baidu.location.a.g.h = 0L));
        com.baidu.location.a.g.l = (com.baidu.location.a.g.k = 0.0);
        com.baidu.location.a.g.m = 0;
        com.baidu.location.a.g.n = 0;
        com.baidu.location.a.g.o = 0;
    }
    
    private static boolean d() {
        if (com.baidu.location.a.g.c.exists()) {
            com.baidu.location.a.g.c.delete();
        }
        if (!com.baidu.location.a.g.c.getParentFile().exists()) {
            com.baidu.location.a.g.c.getParentFile().mkdirs();
        }
        try {
            final File c = com.baidu.location.a.g.c;
            try {
                c.createNewFile();
                try {
                    final RandomAccessFile randomAccessFile = new RandomAccessFile(com.baidu.location.a.g.c, "rw");
                    randomAccessFile.seek(0L);
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.writeInt(0);
                        final RandomAccessFile randomAccessFile3 = randomAccessFile;
                        try {
                            randomAccessFile3.writeInt(0);
                            randomAccessFile.writeInt(1);
                            randomAccessFile.close();
                            c();
                            return com.baidu.location.a.g.c.exists();
                        }
                        catch (IOException ex) {
                            return false;
                        }
                    }
                    catch (IOException ex2) {}
                }
                catch (IOException ex3) {}
            }
            catch (IOException ex4) {}
        }
        catch (IOException ex5) {}
    }
    
    public boolean a(final Location location) {
        return this.a(location, com.baidu.location.d.j.ab, com.baidu.location.d.j.ac);
    }
}
