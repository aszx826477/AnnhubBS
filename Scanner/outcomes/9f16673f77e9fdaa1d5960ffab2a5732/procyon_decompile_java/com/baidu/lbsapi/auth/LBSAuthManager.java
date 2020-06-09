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
import java.util.Hashtable;
import android.content.Context;

public class LBSAuthManager
{
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = 255;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = 245;
    public static final int CODE_NETWORK_INVALID = 246;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.22";
    private static Context a;
    private static m d;
    private static int e;
    private static Hashtable f;
    private static LBSAuthManager g;
    private c b;
    private e c;
    private final Handler h;
    
    static {
        LBSAuthManager.d = null;
        LBSAuthManager.e = 0;
        LBSAuthManager.f = new Hashtable();
    }
    
    private LBSAuthManager(final Context a) {
        this.b = null;
        this.c = null;
        this.h = new i(this, Looper.getMainLooper());
        LBSAuthManager.a = a;
        final m d = LBSAuthManager.d;
        if (d != null && !d.isAlive()) {
            LBSAuthManager.d = null;
        }
        com.baidu.lbsapi.auth.a.b("BaiduApiAuth SDK Version:1.0.22");
        this.d();
    }
    
    private int a(String format) {
        int int1 = -1;
        try {
            final JSONObject jsonObject = new JSONObject(format);
            format = "status";
            if (!jsonObject.has(format)) {
                format = "status";
                jsonObject.put(format, int1);
            }
            format = "status";
            int1 = jsonObject.getInt(format);
            format = "current";
            Label_0188: {
                if (!jsonObject.has(format) || int1 != 0) {
                    break Label_0188;
                }
                format = "current";
                final long long1 = jsonObject.getLong(format);
                try {
                    final long currentTimeMillis = System.currentTimeMillis();
                    final double n = currentTimeMillis - long1;
                    Double.isNaN(n);
                    while (true) {
                        Label_0129: {
                            if (n / 3600000.0 < 24.0) {
                                break Label_0129;
                            }
                            int1 = 601;
                            break Label_0188;
                        }
                        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        final String format2 = simpleDateFormat.format(currentTimeMillis);
                        try {
                            format = simpleDateFormat.format(long1);
                            if (!format2.equals(format)) {
                                continue;
                            }
                            format = "current";
                            if (!jsonObject.has(format) || int1 != 602) {
                                return int1;
                            }
                            format = "current";
                            final long long2 = jsonObject.getLong(format);
                            try {
                                if ((System.currentTimeMillis() - long2) / 1000L > 180.0) {
                                    int1 = 601;
                                    return int1;
                                }
                                return int1;
                            }
                            catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                        catch (JSONException ex2) {}
                        break;
                    }
                }
                catch (JSONException ex3) {}
            }
        }
        catch (JSONException ex4) {}
        return int1;
    }
    
    private String a(int n) {
        Object line;
        while (true) {
            line = null;
            while (true) {
                Object o = null;
                InputStreamReader inputStreamReader2 = null;
                try {
                    try {
                        try {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("/proc/");
                            final StringBuilder sb2 = sb;
                            try {
                                sb2.append(n);
                                sb.append("/cmdline");
                                o = new FileInputStream(new File(sb.toString()));
                                try {
                                    final InputStreamReader inputStreamReader = new InputStreamReader((InputStream)o);
                                    try {
                                        final Object o2 = new BufferedReader(inputStreamReader);
                                        try {
                                            line = ((BufferedReader)o2).readLine();
                                            ((BufferedReader)o2).close();
                                            inputStreamReader.close();
                                            ((FileInputStream)o).close();
                                        }
                                        catch (IOException ex) {}
                                        catch (FileNotFoundException ex2) {}
                                        finally {
                                            final BufferedReader bufferedReader = (BufferedReader)o2;
                                            o = line;
                                            line = bufferedReader;
                                        }
                                    }
                                    catch (IOException ex3) {}
                                    catch (FileNotFoundException ex4) {}
                                    finally {
                                        final BufferedReader bufferedReader2;
                                        o = bufferedReader2;
                                    }
                                }
                                catch (IOException ex5) {}
                                catch (FileNotFoundException ex6) {}
                                finally {
                                    final Object o2 = o;
                                    final BufferedReader bufferedReader3;
                                    o = bufferedReader3;
                                    inputStreamReader2 = null;
                                }
                            }
                            catch (IOException ex7) {
                                n = 0;
                                o = null;
                                inputStreamReader2 = null;
                                final Object o2 = null;
                                if (o2 != null) {
                                    ((BufferedReader)o2).close();
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (o != null) {
                                    continue;
                                }
                                break;
                            }
                            catch (FileNotFoundException ex8) {
                                n = 0;
                                o = null;
                                inputStreamReader2 = null;
                            }
                        }
                        catch (IOException ex9) {}
                        catch (FileNotFoundException ex10) {}
                    }
                    catch (IOException ex11) {}
                    catch (FileNotFoundException ex12) {}
                }
                catch (IOException ex13) {}
                catch (FileNotFoundException ex14) {}
                final Object o2 = null;
                if (o2 != null) {
                    ((BufferedReader)o2).close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (o != null) {
                    continue;
                }
                break;
            }
            break;
        }
        return (String)line;
    }
    
    private String a(Context a) {
        final int myPid = Process.myPid();
        final List runningAppProcesses = ((ActivityManager)a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                if (activityManager$RunningAppProcessInfo.pid == myPid) {
                    return activityManager$RunningAppProcessInfo.processName;
                }
            }
        }
        a = null;
        try {
            a = (Context)this.a(myPid);
        }
        catch (IOException ex) {}
        if (a != null) {
            return (String)a;
        }
        return LBSAuthManager.a.getPackageName();
    }
    
    private String a(final Context context, String a) {
        String string = "";
        final String packageName = context.getPackageName();
        final int n = 101;
        try {
            final ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 128);
            try {
                Label_0090: {
                    if (applicationInfo.metaData != null) {
                        break Label_0090;
                    }
                    final LBSAuthManagerListener value = LBSAuthManager.f.get(a);
                    try {
                        LBSAuthManagerListener lbsAuthManagerListener = value;
                        while (true) {
                            if (lbsAuthManagerListener != null) {
                                final String s = ErrorMessage.a(n, "AndroidManifest.xml\u7684application\u4e2d\u6ca1\u6709meta-data\u6807\u7b7e");
                                lbsAuthManagerListener.onAuthResult(n, s);
                                return string;
                            }
                            return string;
                            string = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
                            final LBSAuthManagerListener value2 = LBSAuthManager.f.get(a);
                            try {
                                lbsAuthManagerListener = value2;
                                if (lbsAuthManagerListener != null) {
                                    final String s = ErrorMessage.a(n, "\u65e0\u6cd5\u5728AndroidManifest.xml\u4e2d\u83b7\u53d6com.baidu.android.lbs.API_KEY\u7684\u503c");
                                    continue;
                                }
                                return string;
                            }
                            catch (PackageManager$NameNotFoundException ex) {
                                final LBSAuthManagerListener lbsAuthManagerListener2 = LBSAuthManager.f.get(a);
                                if (lbsAuthManagerListener2 == null) {
                                    return string;
                                }
                                a = ErrorMessage.a(n, "\u65e0\u6cd5\u5728AndroidManifest.xml\u4e2d\u83b7\u53d6com.baidu.android.lbs.API_KEY\u7684\u503c");
                                lbsAuthManagerListener2.onAuthResult(n, a);
                            }
                            break;
                        }
                    }
                    // iftrue(Label_0197:, string != null && !string.equals((Object)""))
                    catch (PackageManager$NameNotFoundException ex2) {}
                }
            }
            catch (PackageManager$NameNotFoundException ex3) {}
        }
        catch (PackageManager$NameNotFoundException ex4) {}
        Label_0197: {
            return string;
        }
    }
    
    private void a(String obj, String s) {
        // monitorenter(this)
        Label_0011: {
            if (obj != null) {
                break Label_0011;
            }
            try {
                obj = this.e();
                final Message obtainMessage = this.h.obtainMessage();
                int int1 = -1;
                try {
                    final JSONObject jsonObject = new JSONObject(obj);
                    obj = "status";
                    if (!jsonObject.has(obj)) {
                        obj = "status";
                        jsonObject.put(obj, int1);
                    }
                    obj = "current";
                    if (!jsonObject.has(obj)) {
                        obj = "current";
                        jsonObject.put(obj, System.currentTimeMillis());
                    }
                    obj = jsonObject.toString();
                    this.c(obj);
                    obj = "current";
                    if (jsonObject.has(obj)) {
                        obj = "current";
                        jsonObject.remove(obj);
                    }
                    obj = "status";
                    int1 = jsonObject.getInt(obj);
                    obtainMessage.what = int1;
                    obj = jsonObject.toString();
                    obtainMessage.obj = obj;
                    try {
                        final Bundle data = new Bundle();
                        data.putString("listenerKey", s);
                        final Message message = obtainMessage;
                        try {
                            message.setData(data);
                            this.h.sendMessage(obtainMessage);
                        }
                        catch (JSONException ex) {
                            ex.printStackTrace();
                            obtainMessage.what = int1;
                            obtainMessage.obj = new JSONObject();
                            final Bundle data2 = new Bundle();
                            data2.putString("listenerKey", s);
                            obtainMessage.setData(data2);
                            this.h.sendMessage(obtainMessage);
                        }
                    }
                    catch (JSONException ex2) {
                        if (LBSAuthManager.d != null) {
                            LBSAuthManager.d.c();
                        }
                        --LBSAuthManager.e;
                        if (com.baidu.lbsapi.auth.a.a) {
                            final StringBuilder sb = new StringBuilder();
                            s = "httpRequest called mAuthCounter-- = ";
                            sb.append(s);
                            sb.append(LBSAuthManager.e);
                            obj = sb.toString();
                            com.baidu.lbsapi.auth.a.a(obj);
                        }
                        if (LBSAuthManager.e == 0 && LBSAuthManager.d != null) {
                            LBSAuthManager.d.a();
                            LBSAuthManager.d = null;
                        }
                    }
                    finally {
                    }
                    // monitorexit(this)
                }
                catch (JSONException ex3) {}
            }
            finally {}
        }
    }
    
    private void a(final boolean b, String s, Hashtable s2, final String s3) {
        final String a = this.a(LBSAuthManager.a, s3);
        if (a != null) {
            if (!a.equals("")) {
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
                com.baidu.lbsapi.auth.a.a("url:https://api.map.baidu.com/sdkcs/verify");
                hashMap.put("output", "json");
                hashMap.put("ak", a);
                final StringBuilder sb = new StringBuilder();
                sb.append("ak:");
                sb.append(a);
                com.baidu.lbsapi.auth.a.a(sb.toString());
                hashMap.put("mcode", b.a(LBSAuthManager.a));
                hashMap.put("from", "lbs_yunsdk");
                if (s2 != null && ((Hashtable)s2).size() > 0) {
                    for (final Map.Entry<String, V> entry : ((Hashtable<String, V>)s2).entrySet()) {
                        final String s4 = entry.getKey();
                        final String s5 = (String)entry.getValue();
                        if (!TextUtils.isEmpty((CharSequence)s4) && !TextUtils.isEmpty((CharSequence)s5)) {
                            hashMap.put(s4, s5);
                        }
                    }
                }
                s2 = "";
                try {
                    final Context a2 = LBSAuthManager.a;
                    try {
                        s2 = CommonParam.a(a2);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("cuid:");
                sb2.append(s2);
                com.baidu.lbsapi.auth.a.a(sb2.toString());
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("cuid", s2);
                }
                else {
                    hashMap.put("cuid", "");
                }
                hashMap.put("pcn", LBSAuthManager.a.getPackageName());
                hashMap.put("version", "1.0.22");
                s2 = "";
                try {
                    final Context a3 = LBSAuthManager.a;
                    try {
                        s2 = b.c(a3);
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("macaddr", s2);
                }
                else {
                    hashMap.put("macaddr", "");
                }
                s2 = "";
                try {
                    s2 = b.a();
                }
                catch (Exception ex5) {}
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("language", s2);
                }
                else {
                    hashMap.put("language", "");
                }
                if (b) {
                    final String s6 = "force";
                    String s7;
                    if (b) {
                        s7 = "1";
                    }
                    else {
                        s7 = "0";
                    }
                    hashMap.put(s6, s7);
                }
                String s8;
                if (s == null) {
                    s8 = "from_service";
                    s = "";
                }
                else {
                    s8 = "from_service";
                }
                hashMap.put(s8, s);
                (this.b = new c(LBSAuthManager.a)).a(hashMap, new k(this, s3));
            }
        }
    }
    
    private void a(final boolean b, String s, Hashtable s2, final String[] array, final String s3) {
        final String a = this.a(LBSAuthManager.a, s3);
        if (a != null) {
            if (!a.equals("")) {
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
                hashMap.put("output", "json");
                hashMap.put("ak", a);
                hashMap.put("from", "lbs_yunsdk");
                if (s2 != null && ((Hashtable)s2).size() > 0) {
                    for (final Map.Entry<String, V> entry : ((Hashtable<String, V>)s2).entrySet()) {
                        final String s4 = entry.getKey();
                        final String s5 = (String)entry.getValue();
                        if (!TextUtils.isEmpty((CharSequence)s4) && !TextUtils.isEmpty((CharSequence)s5)) {
                            hashMap.put(s4, s5);
                        }
                    }
                }
                s2 = "";
                try {
                    final Context a2 = LBSAuthManager.a;
                    try {
                        s2 = CommonParam.a(a2);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("cuid", s2);
                }
                else {
                    hashMap.put("cuid", "");
                }
                hashMap.put("pcn", LBSAuthManager.a.getPackageName());
                hashMap.put("version", "1.0.22");
                s2 = "";
                try {
                    final Context a3 = LBSAuthManager.a;
                    try {
                        s2 = b.c(a3);
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("macaddr", s2);
                }
                else {
                    hashMap.put("macaddr", "");
                }
                s2 = "";
                try {
                    s2 = b.a();
                }
                catch (Exception ex5) {}
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    hashMap.put("language", s2);
                }
                else {
                    hashMap.put("language", "");
                }
                if (b) {
                    final String s6 = "force";
                    String s7;
                    if (b) {
                        s7 = "1";
                    }
                    else {
                        s7 = "0";
                    }
                    hashMap.put(s6, s7);
                }
                String s8;
                if (s == null) {
                    s8 = "from_service";
                    s = "";
                }
                else {
                    s8 = "from_service";
                }
                hashMap.put(s8, s);
                (this.c = new e(LBSAuthManager.a)).a(hashMap, array, new l(this, s3));
            }
        }
    }
    
    private boolean b(String a) {
        a = this.a(LBSAuthManager.a, a);
        final String e = this.e();
        String string = "";
        final boolean b = true;
        try {
            final JSONObject jsonObject = new JSONObject(e);
            if (!jsonObject.has("ak")) {
                return b;
            }
            string = jsonObject.getString("ak");
        }
        catch (JSONException ex) {
            ex.printStackTrace();
        }
        return a != null && string != null && !a.equals(string) && b;
    }
    
    private void c(final String s) {
        final Context a = LBSAuthManager.a;
        final StringBuilder sb = new StringBuilder();
        sb.append("authStatus_");
        sb.append(this.a(LBSAuthManager.a));
        a.getSharedPreferences(sb.toString(), 0).edit().putString("status", s).commit();
    }
    
    private void d() {
        synchronized (LBSAuthManager.class) {
            if (LBSAuthManager.d == null) {
                (LBSAuthManager.d = new m("auth")).start();
                while (LBSAuthManager.d.a == null) {
                    try {
                        if (com.baidu.lbsapi.auth.a.a) {
                            com.baidu.lbsapi.auth.a.a("wait for create auth thread.");
                        }
                        Thread.sleep(3);
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    
    private String e() {
        final Context a = LBSAuthManager.a;
        final StringBuilder sb = new StringBuilder();
        sb.append("authStatus_");
        sb.append(this.a(LBSAuthManager.a));
        return a.getSharedPreferences(sb.toString(), 0).getString("status", "{\"status\":601}");
    }
    
    public static LBSAuthManager getInstance(final Context a) {
        if (LBSAuthManager.g == null) {
            synchronized (LBSAuthManager.class) {
                if (LBSAuthManager.g == null) {
                    LBSAuthManager.g = new LBSAuthManager(a);
                }
                return LBSAuthManager.g;
            }
        }
        if (a == null) {
            if (a.a) {
                a.c("input context is null");
                new RuntimeException("here").printStackTrace();
            }
        }
        else {
            LBSAuthManager.a = a;
        }
        return LBSAuthManager.g;
    }
    
    public int authenticate(boolean b, final String s, final Hashtable hashtable, final LBSAuthManagerListener lbsAuthManagerListener) {
        final Class<LBSAuthManager> clazz = LBSAuthManager.class;
        // monitorenter(clazz)
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("");
            final String string = sb.toString();
            if (lbsAuthManagerListener != null) {
                LBSAuthManager.f.put(string, lbsAuthManagerListener);
            }
            final String a = this.a(LBSAuthManager.a, string);
            Label_0464: {
                if (a == null) {
                    break Label_0464;
                }
                int n = a.equals("") ? 1 : 0;
                if (n != 0) {
                    break Label_0464;
                }
                n = ++LBSAuthManager.e;
                n = (com.baidu.lbsapi.auth.a.a ? 1 : 0);
                if (n != 0) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(" mAuthCounter  ++ = ");
                    sb2.append(LBSAuthManager.e);
                    com.baidu.lbsapi.auth.a.a(sb2.toString());
                }
                final String e = this.e();
                if (com.baidu.lbsapi.auth.a.a) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("getAuthMessage from cache:");
                    sb3.append(e);
                    com.baidu.lbsapi.auth.a.a(sb3.toString());
                }
                n = this.a(e);
                Label_0314: {
                    if (n != 601) {
                        break Label_0314;
                    }
                    try {
                        try {
                            final JSONObject put = new JSONObject().put("status", 602);
                            try {
                                this.c(put.toString());
                            }
                            catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                        catch (JSONException ex2) {
                            this.d();
                            if (LBSAuthManager.d != null && LBSAuthManager.d.a != null) {
                                if (com.baidu.lbsapi.auth.a.a) {
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append("mThreadLooper.mHandler = ");
                                    sb4.append(LBSAuthManager.d.a);
                                    com.baidu.lbsapi.auth.a.a(sb4.toString());
                                }
                                LBSAuthManager.d.a.post((Runnable)new j(this, n, b, string, s, hashtable));
                                return n;
                            }
                            b = (-1 != 0);
                            return b ? 1 : 0;
                            b = (101 != 0);
                            return b ? 1 : 0;
                        }
                        finally {
                        }
                        // monitorexit(clazz)
                    }
                    catch (JSONException ex3) {}
                }
            }
        }
        finally {}
    }
    
    public String getCUID() {
        final Context a = LBSAuthManager.a;
        if (a == null) {
            return "";
        }
        String a2 = "";
        try {
            a2 = CommonParam.a(a);
        }
        catch (Exception ex) {
            if (com.baidu.lbsapi.auth.a.a) {
                ex.printStackTrace();
            }
        }
        return a2;
    }
    
    public String getKey() {
        final Context a = LBSAuthManager.a;
        if (a == null) {
            return "";
        }
        try {
            return this.getPublicKey(a);
        }
        catch (PackageManager$NameNotFoundException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    public String getMCode() {
        final Context a = LBSAuthManager.a;
        if (a == null) {
            return "";
        }
        return com.baidu.lbsapi.auth.b.a(a);
    }
    
    public String getPublicKey(final Context context) {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
