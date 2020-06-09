// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import com.baidu.android.bbalbs.common.util.CommonParam;
import android.text.TextUtils;
import java.util.Map;
import java.util.HashMap;
import android.os.Message;
import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Iterator;
import java.util.List;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.os.Process;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import org.json.JSONException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
import android.os.Looper;
import android.os.Handler;
import android.content.Context;
import java.util.Hashtable;

class j implements Runnable
{
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;
    
    j(final LBSAuthManager f, final int a, final boolean b, final String c, final String d, final Hashtable e) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public void run() {
        if (com.baidu.lbsapi.auth.a.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.a);
            sb.append("; forced = ");
            sb.append(this.b);
            sb.append("checkAK = ");
            sb.append(this.f.b(this.c));
            com.baidu.lbsapi.auth.a.a(sb.toString());
        }
        final int a = this.a;
        if (a != 601 && !this.b && a != -1 && !this.f.b(this.c)) {
            if (602 == this.a) {
                if (com.baidu.lbsapi.auth.a.a) {
                    com.baidu.lbsapi.auth.a.a("authenticate wait  ");
                }
                if (LBSAuthManager.d != null) {
                    LBSAuthManager.d.b();
                }
            }
            else if (com.baidu.lbsapi.auth.a.a) {
                com.baidu.lbsapi.auth.a.a("authenticate else  ");
            }
            this.f.a(null, this.c);
        }
        else {
            if (com.baidu.lbsapi.auth.a.a) {
                com.baidu.lbsapi.auth.a.a("authenticate sendAuthRequest");
            }
            final String[] b = com.baidu.lbsapi.auth.b.b(LBSAuthManager.a);
            if (com.baidu.lbsapi.auth.a.a) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("authStrings.length:");
                sb2.append(b.length);
                com.baidu.lbsapi.auth.a.a(sb2.toString());
            }
            if (b != null && b.length > 1) {
                if (com.baidu.lbsapi.auth.a.a) {
                    com.baidu.lbsapi.auth.a.a("more sha1 auth");
                }
                this.f.a(this.b, this.d, this.e, b, this.c);
            }
            else {
                this.f.a(this.b, this.d, this.e, this.c);
            }
        }
    }
}
