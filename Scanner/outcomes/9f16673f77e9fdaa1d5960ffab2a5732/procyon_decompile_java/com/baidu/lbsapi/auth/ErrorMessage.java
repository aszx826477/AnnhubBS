// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

class ErrorMessage
{
    static String a(final int n, final String s) {
        final JSONObject jsonObject = new JSONObject();
        final String s2 = "status";
        final JSONObject jsonObject2 = jsonObject;
        final String s3 = s2;
        try {
            jsonObject2.put(s3, n);
            jsonObject.put("message", (Object)s);
        }
        catch (JSONException ex) {}
        return jsonObject.toString();
    }
    
    static String a(final String s) {
        final JSONObject jsonObject = new JSONObject();
        final String s2 = "status";
        final int n = -1;
        final JSONObject jsonObject2 = jsonObject;
        final String s3 = s2;
        try {
            jsonObject2.put(s3, n);
            jsonObject.put("message", (Object)s);
        }
        catch (JSONException ex) {}
        return jsonObject.toString();
    }
}
