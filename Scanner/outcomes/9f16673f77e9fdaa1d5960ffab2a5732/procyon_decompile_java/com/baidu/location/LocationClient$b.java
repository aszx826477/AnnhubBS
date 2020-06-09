// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.location.Location;
import android.text.TextUtils;
import com.baidu.location.a.j;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.a.k;
import android.os.Bundle;
import android.os.Message;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.app.Notification;
import java.util.Iterator;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.location.a.c;
import com.baidu.location.a.c$a;
import java.util.ArrayList;

class LocationClient$b implements Runnable
{
    final /* synthetic */ LocationClient a;
    
    private LocationClient$b(final LocationClient a) {
        this.a = a;
    }
    
    public void run() {
        synchronized (this.a.r) {
            this.a.o = false;
            if (this.a.g == null || this.a.i == null) {
                return;
            }
            final ArrayList l = this.a.j;
            final int n = 1;
            if ((l == null || this.a.j.size() < n) && (this.a.k == null || this.a.k.size() < n)) {
                return;
            }
            if (this.a.n) {
                if (this.a.p == null) {
                    this.a.p = new LocationClient$b(this.a);
                }
                this.a.h.postDelayed((Runnable)this.a.p, (long)this.a.c.scanSpan);
                return;
            }
            this.a.h.obtainMessage(4).sendToTarget();
        }
    }
}
