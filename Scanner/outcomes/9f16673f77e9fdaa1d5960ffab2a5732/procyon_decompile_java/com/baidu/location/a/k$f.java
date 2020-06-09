// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.webkit.WebSettings;
import android.os.Looper;
import android.os.Build$VERSION;
import com.baidu.location.BDLocation;
import java.util.List;
import com.baidu.location.LocationClient;
import android.webkit.WebView;
import android.content.Context;

class k$f implements Runnable
{
    final /* synthetic */ k a;
    
    private k$f(final k a) {
        this.a = a;
    }
    
    public void run() {
        this.a.l = false;
        this.a.e.obtainMessage(6).sendToTarget();
    }
}
