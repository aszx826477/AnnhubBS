// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.util;

import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import android.os.Process;
import android.os.SystemClock;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import android.provider.Settings$Secure;
import java.util.Iterator;
import android.os.Environment;
import java.util.UUID;
import android.os.Build$VERSION;
import android.util.Log;
import android.content.pm.Signature;
import java.security.Key;
import javax.crypto.Cipher;
import java.util.HashSet;
import android.provider.Settings$System;
import java.security.cert.Certificate;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.io.ByteArrayInputStream;
import org.json.JSONArray;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import com.baidu.android.bbalbs.common.a.d;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import java.io.File;
import java.security.PublicKey;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.TextUtils;

class b$b
{
    public String a;
    public String b;
    public int c;
    
    private b$b() {
        this.c = 2;
    }
    
    public static b$b a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        try {
            final JSONObject jsonObject = new JSONObject(string);
            string = "deviceid";
            string = jsonObject.getString(string);
            final String string2 = jsonObject.getString("imei");
            final int int1 = jsonObject.getInt("ver");
            try {
                if (TextUtils.isEmpty((CharSequence)string) || string2 == null) {
                    return null;
                }
                try {
                    final b$b b$b2;
                    final b$b b$b = b$b2 = new b$b();
                    try {
                        b$b2.a = string;
                        final b$b b$b3 = b$b;
                        try {
                            b$b3.b = string2;
                            final b$b b$b4 = b$b;
                            try {
                                b$b4.c = int1;
                                return b$b;
                            }
                            catch (JSONException ex) {
                                b((Throwable)ex);
                            }
                        }
                        catch (JSONException ex2) {}
                    }
                    catch (JSONException ex3) {}
                }
                catch (JSONException ex4) {}
            }
            catch (JSONException ex5) {}
        }
        catch (JSONException ex6) {}
        return null;
    }
    
    public String a() {
        try {
            try {
                final JSONObject put = new JSONObject().put("deviceid", (Object)this.a).put("imei", (Object)this.b).put("ver", this.c);
                try {
                    return put.toString();
                }
                catch (JSONException ex) {
                    b((Throwable)ex);
                    return null;
                }
            }
            catch (JSONException ex2) {}
        }
        catch (JSONException ex3) {}
    }
    
    public String b() {
        String b = this.b;
        if (TextUtils.isEmpty((CharSequence)b)) {
            b = "0";
        }
        final String string = new StringBuffer(b).reverse().toString();
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("|");
        sb.append(string);
        return sb.toString();
    }
}
