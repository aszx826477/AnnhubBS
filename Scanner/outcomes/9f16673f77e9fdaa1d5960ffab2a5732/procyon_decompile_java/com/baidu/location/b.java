// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.location.Location;
import android.text.TextUtils;
import com.baidu.location.a.j;
import android.webkit.WebView;
import com.baidu.location.a.k;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.app.Notification;
import java.util.Iterator;
import android.content.Intent;
import android.os.Looper;
import java.util.ArrayList;
import android.content.Context;
import com.baidu.location.a.c;
import com.baidu.location.a.c$a;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.os.Messenger;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

class b implements ServiceConnection
{
    final /* synthetic */ LocationClient a;
    
    b(final LocationClient a) {
        this.a = a;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.a.g = new Messenger(binder);
        if (this.a.g == null) {
            return;
        }
        final LocationClient a = this.a;
        final boolean b = true;
        a.e = b;
        Log.d("baidu_location_client", "baidu location connected ...");
        if (this.a.x) {
            this.a.h.obtainMessage(2).sendToTarget();
        }
        else {
            final int n = 11;
            final Handler handler = null;
            try {
                final Message obtain = Message.obtain(handler, n);
                try {
                    final LocationClient a2 = this.a;
                    try {
                        obtain.replyTo = a2.i;
                        final LocationClient a3 = this.a;
                        try {
                            obtain.setData(a3.c());
                            final LocationClient a4 = this.a;
                            try {
                                a4.g.send(obtain);
                                this.a.e = b;
                                final LocationClient a5 = this.a;
                                try {
                                    if (a5.c == null) {
                                        return;
                                    }
                                    final LocationClient a6 = this.a;
                                    try {
                                        final Boolean g = a6.A;
                                        try {
                                            g;
                                            final LocationClient a7 = this.a;
                                            try {
                                                final Message obtainMessage = a7.h.obtainMessage(4);
                                                try {
                                                    obtainMessage.sendToTarget();
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
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.a.g = null;
        this.a.e = false;
    }
}
