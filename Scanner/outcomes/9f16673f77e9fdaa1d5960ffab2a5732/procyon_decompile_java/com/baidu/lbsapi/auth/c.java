// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.HashMap;
import android.content.Context;

class c
{
    private Context a;
    private HashMap b;
    private c$a c;
    
    protected c(final Context a) {
        this.b = null;
        this.c = null;
        this.a = a;
    }
    
    private HashMap a(final HashMap hashMap) {
        final HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        final Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            final String string = iterator.next().toString();
            hashMap2.put(string, hashMap.get(string));
        }
        return hashMap2;
    }
    
    private void a(String s) {
        if (s == null) {
            s = "";
        }
        final int n = -1;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(s);
            s = "status";
            if (!jsonObject.has(s)) {
                s = "status";
                jsonObject.put(s, n);
            }
        }
        catch (JSONException ex2) {
            jsonObject = new JSONObject();
            s = "status";
            final JSONObject jsonObject2 = jsonObject;
            final String s2 = s;
            try {
                jsonObject2.put(s2, n);
            }
            catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        final c$a c = this.c;
        if (c != null) {
            c.a(jsonObject.toString());
        }
    }
    
    protected void a(HashMap a, final c$a c) {
        a = this.a(a);
        this.b = a;
        this.c = c;
        new Thread(new d(this)).start();
    }
}
