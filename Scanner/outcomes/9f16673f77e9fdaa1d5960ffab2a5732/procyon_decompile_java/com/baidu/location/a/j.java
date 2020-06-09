// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import org.json.JSONObject;
import android.util.Log;
import com.baidu.location.d.a;
import java.util.Hashtable;
import com.baidu.lbsapi.auth.LBSAuthManager;
import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;

public class j implements LBSAuthManagerListener
{
    private static Object a;
    private static j b;
    private int c;
    private Context d;
    private long e;
    private String f;
    
    static {
        j.a = new Object();
        j.b = null;
    }
    
    public j() {
        this.c = 0;
        this.d = null;
        this.e = 0L;
        this.f = null;
    }
    
    public static j a() {
        synchronized (j.a) {
            if (j.b == null) {
                j.b = new j();
            }
            return j.b;
        }
    }
    
    public static String b(final Context context) {
        String publicKey;
        try {
            publicKey = LBSAuthManager.getInstance(context).getPublicKey(context);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            publicKey = null;
        }
        return publicKey;
    }
    
    public static String c(final Context context) {
        String mCode = null;
        try {
            final LBSAuthManager instance = LBSAuthManager.getInstance(context);
            try {
                mCode = instance.getMCode();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                mCode = null;
            }
        }
        catch (Exception ex2) {}
        return mCode;
    }
    
    public void a(final Context d) {
        this.d = d;
        LBSAuthManager.getInstance(this.d).authenticate(false, "lbs_locsdk", null, this);
        this.e = System.currentTimeMillis();
    }
    
    public boolean b() {
        final int c = this.c;
        final boolean b = c == 0 || c == 602 || c == 601 || c == -10 || c == -11;
        if (this.d != null) {
            final long n = System.currentTimeMillis() - this.e;
            if (b) {
                if (n <= 86400000L) {
                    return b;
                }
            }
            else if (n >= 0L && n <= 10000L) {
                return b;
            }
            LBSAuthManager.getInstance(this.d).authenticate(false, "lbs_locsdk", null, this);
            this.e = System.currentTimeMillis();
        }
        return b;
    }
    
    public void onAuthResult(final int c, String string) {
        this.c = c;
        if (this.c == 0) {
            Log.i(com.baidu.location.d.a.a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        }
        else {
            final String a = com.baidu.location.d.a.a;
            final StringBuilder sb = new StringBuilder();
            sb.append("LocationAuthManager Authentication Error errorcode = ");
            sb.append(c);
            sb.append(" , msg = ");
            sb.append(string);
            Log.i(a, sb.toString());
        }
        if (string != null) {
            try {
                final JSONObject jsonObject = new JSONObject(string);
                string = "token";
                string = jsonObject.getString(string);
                if (string != null) {
                    string = "token";
                    this.f = jsonObject.getString(string);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
