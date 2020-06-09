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

public class k
{
    private static long j;
    public k$e a;
    private Context b;
    private WebView c;
    private LocationClient d;
    private k$a e;
    private List f;
    private boolean g;
    private long h;
    private BDLocation i;
    private k$f k;
    private boolean l;
    
    static {
        k.j = 12000L;
    }
    
    private k() {
        this.b = null;
        this.d = null;
        this.a = new k$e(this);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }
    
    public static k a() {
        return k$c.a;
    }
    
    private void a(final WebView webView) {
        webView.addJavascriptInterface((Object)new k$d(this, null), "BaiduLocAssistant");
    }
    
    public void a(final Context b, final WebView c, final LocationClient d) {
        if (this.g) {
            return;
        }
        if (Integer.valueOf(Build$VERSION.SDK_INT) < 17) {
            return;
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = new k$a(this, Looper.getMainLooper());
        this.e.obtainMessage(3).sendToTarget();
        final WebSettings settings = c.getSettings();
        final boolean b2 = true;
        settings.setJavaScriptEnabled(b2);
        this.a(this.c);
        this.g = b2;
    }
    
    public void b() {
        if (!this.g) {
            return;
        }
        this.e.obtainMessage(4).sendToTarget();
        this.g = false;
    }
}
