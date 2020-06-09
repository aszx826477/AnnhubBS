// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.os.Parcelable;
import android.app.Notification;
import dalvik.system.DexClassLoader;
import com.baidu.location.c.a;
import android.os.IBinder;
import android.content.Intent;
import java.io.RandomAccessFile;
import com.baidu.location.d.j;
import java.io.File;
import android.content.Context;
import android.app.Service;

public class f extends Service
{
    public static boolean isServing;
    public static boolean isStartedServing;
    public static Context mC;
    public static String replaceFileName;
    LLSInterface a;
    LLSInterface b;
    LLSInterface c;
    
    static {
        f.replaceFileName = "repll.jar";
        f.mC = null;
        f.isServing = false;
        f.isStartedServing = false;
    }
    
    public f() {
        this.a = null;
        this.b = null;
        this.c = null;
    }
    
    private boolean a(final File file) {
        final StringBuilder sb = new StringBuilder();
        sb.append(j.h());
        sb.append("/grtcfrsa.dat");
        final String string = sb.toString();
        boolean b = false;
        try {
            final File file2 = new File(string);
            if (file2.exists()) {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean()) {
                    final int int1 = randomAccessFile.readInt();
                    if (int1 != 0) {
                        final byte[] array = new byte[int1];
                        randomAccessFile.read(array, 0, int1);
                        final String s = new String(array);
                        final String a = j.a(file, "SHA-256");
                        if (a != null && j.b(a, s, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                            b = true;
                        }
                    }
                }
                randomAccessFile.close();
            }
        }
        catch (Exception ex) {}
        return b;
    }
    
    public static float getFrameVersion() {
        return 7.52f;
    }
    
    public static String getJarFileName() {
        return "app.jar";
    }
    
    public static Context getServiceContext() {
        return f.mC;
    }
    
    public IBinder onBind(final Intent intent) {
        return this.c.onBind(intent);
    }
    
    public void onCreate() {
        f.mC = this.getApplicationContext();
        System.currentTimeMillis();
        this.b = new a();
        Label_0368: {
            try {
                try {
                    try {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(j.h());
                        sb.append(File.separator);
                        sb.append(f.replaceFileName);
                        final File file = new File(sb.toString());
                        try {
                            try {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append(j.h());
                                sb2.append(File.separator);
                                sb2.append("app.jar");
                                final File file2 = new File(sb2.toString());
                                Label_0182: {
                                    if (!file.exists()) {
                                        break Label_0182;
                                    }
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    final File file3 = file;
                                    try {
                                        file3.renameTo(file2);
                                        if (!file2.exists()) {
                                            break Label_0368;
                                        }
                                        try {
                                            try {
                                                final StringBuilder sb3 = new StringBuilder();
                                                sb3.append(j.h());
                                                sb3.append(File.separator);
                                                sb3.append("app.jar");
                                                final File file4 = new File(sb3.toString());
                                                try {
                                                    if (!this.a(file4)) {
                                                        break Label_0368;
                                                    }
                                                    try {
                                                        try {
                                                            final StringBuilder sb4 = new StringBuilder();
                                                            sb4.append(j.h());
                                                            sb4.append(File.separator);
                                                            sb4.append("app.jar");
                                                            final String string = sb4.toString();
                                                            try {
                                                                final String h = j.h();
                                                                try {
                                                                    final Class loadClass = new DexClassLoader(string, h, (String)null, this.getClassLoader()).loadClass("com.baidu.serverLoc.LocationService");
                                                                    try {
                                                                        final LLSInterface instance = loadClass.newInstance();
                                                                        try {
                                                                            this.a = instance;
                                                                        }
                                                                        catch (Exception ex) {
                                                                            this.a = null;
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
                                                catch (Exception ex7) {}
                                            }
                                            catch (Exception ex8) {}
                                        }
                                        catch (Exception ex9) {}
                                    }
                                    catch (Exception ex10) {}
                                }
                            }
                            catch (Exception ex11) {}
                        }
                        catch (Exception ex12) {}
                    }
                    catch (Exception ex13) {}
                }
                catch (Exception ex14) {}
            }
            catch (Exception ex15) {}
        }
        final LLSInterface a = this.a;
        if (a != null && a.getVersion() >= this.b.getVersion()) {
            this.c = this.a;
            this.b = null;
        }
        else {
            this.c = this.b;
            this.a = null;
        }
        f.isServing = true;
        this.c.onCreate((Context)this);
    }
    
    public void onDestroy() {
        f.isServing = false;
        this.c.onDestroy();
        if (f.isStartedServing) {
            this.stopForeground(true);
        }
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        if (intent != null) {
            final String s = "command";
            try {
                final int intExtra = intent.getIntExtra(s, 0);
                final boolean isStartedServing = true;
                Label_0078: {
                    if (intExtra != (isStartedServing ? 1 : 0)) {
                        break Label_0078;
                    }
                    final int intExtra2 = intent.getIntExtra("id", 0);
                    final Parcelable parcelableExtra = intent.getParcelableExtra("notification");
                    try {
                        this.startForeground(intExtra2, (Notification)parcelableExtra);
                        f.isStartedServing = isStartedServing;
                        return this.c.onStartCommand(intent, n, n2);
                        this.stopForeground(intent.getBooleanExtra("removenotify", isStartedServing));
                        f.isStartedServing = false;
                        return this.c.onStartCommand(intent, n, n2);
                    }
                    // iftrue(Label_0122:, intExtra != 2)
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            catch (Exception ex2) {}
        }
        Label_0122: {
            return this.c.onStartCommand(intent, n, n2);
        }
    }
    
    public void onTaskRemoved(final Intent intent) {
        this.c.onTaskRemoved(intent);
    }
    
    public boolean onUnbind(final Intent intent) {
        return this.c.onUnBind(intent);
    }
}
