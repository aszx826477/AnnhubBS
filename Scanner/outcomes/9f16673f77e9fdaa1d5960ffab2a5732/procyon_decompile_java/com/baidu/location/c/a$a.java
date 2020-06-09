// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.c;

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
import com.baidu.location.b.b;
import com.baidu.location.b.e;
import com.baidu.location.a.m;
import com.baidu.location.a.j;
import android.os.HandlerThread;
import android.os.Messenger;
import com.baidu.location.LLSInterface;
import android.app.Service;
import com.baidu.location.a.l;
import com.baidu.location.a.h;
import com.baidu.location.f;
import android.os.Message;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.os.Handler;

public class a$a extends Handler
{
    private final WeakReference a;
    
    public a$a(final Looper looper, final a a) {
        super(looper);
        this.a = new WeakReference((T)a);
    }
    
    public void handleMessage(final Message message) {
        final a a = (a)this.a.get();
        if (a == null) {
            return;
        }
        final boolean isServing = f.isServing;
        final boolean b = true;
        if (isServing == b) {
            switch (message.what) {
                case 405: {
                    final byte[] byteArray = message.getData().getByteArray("errorid");
                    if (byteArray != null && byteArray.length > 0) {
                        final String s = new String(byteArray);
                        break;
                    }
                    break;
                }
                case 406: {
                    h.a().e();
                    break;
                }
                case 401: {
                    try {
                        message.getData();
                    }
                    catch (Exception ex) {}
                    break;
                }
                case 41: {
                    l.c().h();
                    break;
                }
                case 22: {
                    l.c().b(message);
                    break;
                }
                case 15: {
                    a.c(message);
                    break;
                }
                case 12: {
                    a.b(message);
                    break;
                }
                case 11: {
                    a.a(message);
                    break;
                }
            }
        }
        if (message.what == (b ? 1 : 0)) {
            a.b();
        }
        if (message.what == 0) {
            a.a();
        }
        super.handleMessage(message);
    }
}
