// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class c
{
    static c c;
    String a;
    int b;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    
    public c() {
        this.a = "firll.dat";
        this.b = 3164;
        this.d = 0;
        this.e = 20;
        this.f = 40;
        this.g = 60;
        this.h = 80;
        this.i = 100;
    }
    
    private long a(int int1) {
        final String h = j.h();
        final long n = -1;
        if (h == null) {
            return n;
        }
        while (true) {
            final StringBuilder sb = new StringBuilder();
            sb.append(h);
            sb.append(File.separator);
            sb.append(this.a);
            final String string = sb.toString();
            while (true) {
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(string, "rw");
                    final long n2 = int1;
                    final RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.seek(n2);
                        int1 = randomAccessFile.readInt();
                        try {
                            final long long1 = randomAccessFile.readLong();
                            try {
                                if (int1 == randomAccessFile.readInt()) {
                                    try {
                                        randomAccessFile.close();
                                    }
                                    catch (IOException ex) {}
                                    return long1;
                                }
                                try {
                                    randomAccessFile.close();
                                }
                                catch (IOException ex2) {}
                                break;
                            }
                            catch (Exception ex3) {}
                        }
                        catch (Exception ex4) {}
                    }
                    catch (Exception ex5) {}
                }
                catch (Exception ex6) {
                    randomAccessFile = null;
                }
                finally {
                    randomAccessFile = null;
                }
                try {
                    randomAccessFile.close();
                    goto Label_0171;
                }
                catch (IOException ex7) {}
                if (randomAccessFile != null) {
                    continue;
                }
                break;
            }
            break;
        }
        return n;
    }
    
    public static c a() {
        if (com.baidu.location.d.c.c == null) {
            com.baidu.location.d.c.c = new c();
        }
        return com.baidu.location.d.c.c;
    }
    
    private void a(int n, final long n2) {
        final String h = j.h();
        if (h == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(h);
        sb.append(File.separator);
        sb.append(this.a);
        final String string = sb.toString();
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(string, "rw");
            randomAccessFile.seek(n);
            n = this.b;
            randomAccessFile.writeInt(n);
            final RandomAccessFile randomAccessFile2 = randomAccessFile;
            try {
                randomAccessFile2.writeLong(n2);
                n = this.b;
                randomAccessFile.writeInt(n);
                randomAccessFile.close();
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
    }
    
    public void a(final long n) {
        this.a(this.d, n);
    }
    
    public long b() {
        return this.a(this.d);
    }
}
