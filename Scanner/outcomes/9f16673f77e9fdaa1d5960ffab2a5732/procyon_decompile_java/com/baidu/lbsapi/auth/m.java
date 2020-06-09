// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import android.os.Looper;
import android.os.Handler;

class m extends Thread
{
    Handler a;
    private Object b;
    private boolean c;
    
    m() {
        this.a = null;
        this.b = new Object();
        this.c = false;
    }
    
    m(final String s) {
        super(s);
        this.a = null;
        this.b = new Object();
        this.c = false;
    }
    
    public void a() {
        if (com.baidu.lbsapi.auth.a.a) {
            com.baidu.lbsapi.auth.a.a("Looper thread quit()");
        }
        this.a.getLooper().quit();
    }
    
    public void b() {
        final Object b = this.b;
        // monitorenter(b)
        while (true) {
            Object o = null;
            try {
                if (!this.c) {
                    final Object b2;
                    o = (b2 = this.b);
                    b2.wait();
                }
                break Label_0037;
            }
            catch (InterruptedException ex) {}
            finally {
                // monitorexit(b)
                // monitorexit(b)
                return;
            }
            try {
                final Object b2 = o;
                b2.wait();
                continue;
            }
            catch (InterruptedException ex2) {}
            break;
        }
    }
    
    public void c() {
        final Object b = this.b;
        // monitorenter(b)
        final boolean c = true;
        try {
            this.c = c;
            this.b.notifyAll();
        }
        finally {
        }
        // monitorexit(b)
    }
    
    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (com.baidu.lbsapi.auth.a.a) {
            com.baidu.lbsapi.auth.a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (com.baidu.lbsapi.auth.a.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("LooperThread run() thread id:");
            sb.append(String.valueOf(Thread.currentThread().getId()));
            com.baidu.lbsapi.auth.a.a(sb.toString());
        }
    }
}
