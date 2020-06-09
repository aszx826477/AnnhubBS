// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.Build$VERSION;
import com.baidu.location.f;
import android.os.SystemClock;
import android.location.Location;
import com.baidu.location.d.j;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.b;
import java.util.List;
import com.baidu.location.Address;
import com.baidu.location.b.a;
import com.baidu.location.b.g;
import com.baidu.location.BDLocation;
import android.os.Handler;
import android.os.Message;

class l$b implements Runnable
{
    final /* synthetic */ l a;
    
    private l$b(final l a) {
        this.a = a;
    }
    
    public void run() {
        if (this.a.L) {
            this.a.L = false;
        }
        if (this.a.t) {
            this.a.t = false;
            this.a.h(null);
        }
    }
}
