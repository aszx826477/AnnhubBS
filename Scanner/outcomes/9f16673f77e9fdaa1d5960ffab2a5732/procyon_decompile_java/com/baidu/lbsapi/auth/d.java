// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.HashMap;
import android.content.Context;

class d implements Runnable
{
    final /* synthetic */ c a;
    
    d(final c a) {
        this.a = a;
    }
    
    public void run() {
        final StringBuilder sb = new StringBuilder();
        sb.append("postWithHttps start Thread id = ");
        sb.append(String.valueOf(Thread.currentThread().getId()));
        com.baidu.lbsapi.auth.a.a(sb.toString());
        this.a.a(new g(this.a.a).a(this.a.b));
    }
}
