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
import org.json.JSONObject;

class k$b
{
    final /* synthetic */ k a;
    private String b;
    private String c;
    private long d;
    
    k$b(final k a, String s) {
        this.a = a;
        this.b = null;
        this.c = null;
        this.d = 0L;
        try {
            final JSONObject jsonObject = new JSONObject(s);
            s = "action";
            if (jsonObject.has(s)) {
                s = "action";
                s = jsonObject.getString(s);
                this.b = s;
            }
            s = "callback";
            if (jsonObject.has(s)) {
                s = "callback";
                s = jsonObject.getString(s);
                this.c = s;
            }
            s = "timeout";
            if (jsonObject.has(s)) {
                s = "timeout";
                final long long1 = jsonObject.getLong(s);
                if (long1 >= 1000L) {
                    k.j = long1;
                }
            }
            this.d = System.currentTimeMillis();
        }
        catch (Exception ex) {
            this.b = null;
            this.c = null;
        }
    }
    
    public String a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
}
