// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.c;

import android.os.Handler;
import com.baidu.location.a.u;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.content.Intent;
import android.os.Process;
import com.baidu.location.a.d;
import com.baidu.location.a.v;
import com.baidu.location.a.o;
import android.util.Log;
import android.os.Message;
import com.baidu.location.a.l;
import com.baidu.location.b.b;
import com.baidu.location.b.e;
import com.baidu.location.a.h;
import com.baidu.location.a.m;
import com.baidu.location.f;
import com.baidu.location.a.j;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Messenger;
import com.baidu.location.LLSInterface;
import android.app.Service;

public class a extends Service implements LLSInterface
{
    static a$a a;
    private static long f;
    Messenger b;
    private Looper c;
    private HandlerThread d;
    private boolean e;
    
    static {
        com.baidu.location.c.a.a = null;
        com.baidu.location.c.a.f = 0L;
    }
    
    public a() {
        this.b = null;
        this.e = false;
    }
    
    private void a() {
        j.a().a(com.baidu.location.f.getServiceContext());
        m.a().b();
        h.a().b();
        com.baidu.location.b.e.a().b();
        com.baidu.location.b.b.a().b();
        com.baidu.location.d.b.a();
        l.c().d();
        com.baidu.location.b.h.a().c();
    }
    
    private void a(final Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.a().a(message);
        o.b().c();
    }
    
    private void b() {
        com.baidu.location.b.h.a().d();
        com.baidu.location.b.e.a().e();
        com.baidu.location.b.b.a().c();
        l.c().e();
        h.a().c();
        v.e();
        com.baidu.location.a.a.a().b();
        com.baidu.location.a.d.a().b();
        m.a().c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (!this.e) {
            Process.killProcess(Process.myPid());
        }
    }
    
    private void b(final Message message) {
        com.baidu.location.a.a.a().b(message);
    }
    
    private void c(final Message message) {
        com.baidu.location.a.a.a().c(message);
    }
    
    public double getVersion() {
        return 7.519999980926514;
    }
    
    public IBinder onBind(final Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.d.b.g = extras.getString("key");
            com.baidu.location.d.b.f = extras.getString("sign");
            this.e = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
        }
        return this.b.getBinder();
    }
    
    public void onCreate(final Context context) {
        com.baidu.location.c.a.f = System.currentTimeMillis();
        this.d = u.a();
        this.c = this.d.getLooper();
        final Looper c = this.c;
        if (c == null) {
            com.baidu.location.c.a.a = new a$a(Looper.getMainLooper(), this);
        }
        else {
            com.baidu.location.c.a.a = new a$a(c, this);
        }
        this.b = new Messenger((Handler)com.baidu.location.c.a.a);
        com.baidu.location.c.a.a.sendEmptyMessage(0);
        final StringBuilder sb = new StringBuilder();
        sb.append("baidu location service start1 ...20171027...");
        sb.append(Process.myPid());
        Log.d("baidu_location_service", sb.toString());
    }
    
    public void onDestroy() {
        try {
            com.baidu.location.c.a.a.sendEmptyMessage(1);
        }
        catch (Exception ex) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.b();
            Process.killProcess(Process.myPid());
        }
        Log.d("baidu_location_service", "baidu location service stop ...");
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        return 1;
    }
    
    public void onTaskRemoved(final Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }
    
    public boolean onUnBind(final Intent intent) {
        return false;
    }
}
