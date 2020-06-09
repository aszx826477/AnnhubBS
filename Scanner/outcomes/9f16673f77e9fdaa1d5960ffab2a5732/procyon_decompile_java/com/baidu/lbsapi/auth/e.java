// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;

class e
{
    private Context a;
    private List b;
    private e$a c;
    
    protected e(final Context a) {
        this.b = null;
        this.c = null;
        this.a = a;
    }
    
    private List a(final HashMap hashMap, final String[] array) {
        final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; ++i) {
                final HashMap<String, String> hashMap2 = new HashMap<String, String>();
                final Iterator<String> iterator = hashMap.keySet().iterator();
                while (iterator.hasNext()) {
                    final String string = iterator.next().toString();
                    hashMap2.put(string, (String)hashMap.get(string));
                }
                hashMap2.put("mcode", array[i]);
                list.add(hashMap2);
            }
        }
        else {
            final HashMap<String, String> hashMap3 = new HashMap<String, String>();
            final Iterator<String> iterator2 = hashMap.keySet().iterator();
            while (iterator2.hasNext()) {
                final String string2 = iterator2.next().toString();
                hashMap3.put(string2, (String)hashMap.get(string2));
            }
            list.add(hashMap3);
        }
        return list;
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
        final e$a c = this.c;
        if (c != null) {
            c.a(jsonObject.toString());
        }
    }
    
    private void a(final List list) {
        final StringBuilder sb = new StringBuilder();
        sb.append("syncConnect start Thread id = ");
        sb.append(String.valueOf(Thread.currentThread().getId()));
        com.baidu.lbsapi.auth.a.a(sb.toString());
        if (list != null && list.size() != 0) {
            final ArrayList<String> list2 = new ArrayList<String>();
            int i;
            for (i = 0; i < list.size(); ++i) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("syncConnect resuest ");
                sb2.append(i);
                sb2.append("  start!!!");
                com.baidu.lbsapi.auth.a.a(sb2.toString());
                final HashMap hashMap = list.get(i);
                final g g = new g(this.a);
                Label_0365: {
                    if (g.a()) {
                        String a = g.a(hashMap);
                        if (a == null) {
                            a = "";
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("syncConnect resuest ");
                        sb3.append(i);
                        sb3.append("  result:");
                        sb3.append(a);
                        com.baidu.lbsapi.auth.a.a(sb3.toString());
                        list2.add(a);
                        try {
                            final JSONObject jsonObject = new JSONObject(a);
                            if (!jsonObject.has("status") || jsonObject.getInt("status") != 0) {
                                break Label_0365;
                            }
                            com.baidu.lbsapi.auth.a.a("auth end and break");
                            try {
                                this.a(a);
                                return;
                            }
                            catch (JSONException ex2) {
                                com.baidu.lbsapi.auth.a.a("continue-------------------------------");
                            }
                        }
                        catch (JSONException ex3) {}
                    }
                    com.baidu.lbsapi.auth.a.a("Current network is not available.");
                    list2.add(ErrorMessage.a("Current network is not available."));
                }
                com.baidu.lbsapi.auth.a.a("syncConnect end");
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("--iiiiii:");
            sb4.append(i);
            sb4.append("<><>paramList.size():");
            sb4.append(list.size());
            sb4.append("<><>authResults.size():");
            sb4.append(list2.size());
            com.baidu.lbsapi.auth.a.a(sb4.toString());
            if (list.size() > 0 && i == list.size() && list2.size() > 0 && i == list2.size()) {
                final int n = i - 1;
                if (n > 0) {
                    try {
                        final Object value = list2.get(n);
                        try {
                            final JSONObject jsonObject2 = new JSONObject((String)value);
                            if (!jsonObject2.has("status") || jsonObject2.getInt("status") == 0) {
                                return;
                            }
                            com.baidu.lbsapi.auth.a.a("i-1 result is not 0,return first result");
                            final ArrayList<String> list3 = list2;
                            try {
                                final Object value2 = list3.get(0);
                                try {
                                    this.a((String)value2);
                                }
                                catch (JSONException ex) {
                                    final StringBuilder sb5 = new StringBuilder();
                                    sb5.append("JSONException:");
                                    sb5.append(ex.getMessage());
                                    this.a(ErrorMessage.a(sb5.toString()));
                                }
                            }
                            catch (JSONException ex4) {}
                        }
                        catch (JSONException ex5) {}
                    }
                    catch (JSONException ex6) {}
                }
            }
            return;
        }
        com.baidu.lbsapi.auth.a.c("syncConnect failed,params list is null or size is 0");
    }
    
    protected void a(final HashMap hashMap, final String[] array, final e$a c) {
        this.b = this.a(hashMap, array);
        this.c = c;
        new Thread(new f(this)).start();
    }
}
