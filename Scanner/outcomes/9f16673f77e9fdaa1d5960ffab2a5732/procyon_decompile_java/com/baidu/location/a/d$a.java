// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.content.SharedPreferences;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import android.os.Environment;
import com.baidu.location.f;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import com.baidu.location.d.j;
import org.json.JSONException;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import com.baidu.location.d.i;
import java.util.Calendar;
import java.util.Random;
import java.util.Iterator;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.content.Context;
import java.io.OutputStream;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.io.File;
import android.location.Location;
import java.util.List;
import android.os.Handler;
import com.baidu.location.d.b;
import org.json.JSONObject;
import com.baidu.location.Jni;
import java.util.HashMap;
import com.baidu.location.d.e;

class d$a extends e
{
    String a;
    final /* synthetic */ d b;
    
    public d$a(final d b) {
        this.b = b;
        this.a = null;
        this.k = new HashMap();
    }
    
    public void a() {
        this.h = "http://loc.map.baidu.com/cc.php";
        final String encode = Jni.encode(this.a);
        this.a = null;
        this.k.put("q", encode);
    }
    
    public void a(final String a) {
        this.a = a;
        this.e();
    }
    
    public void a(final boolean b) {
        if (b && this.j != null) {
            try {
                final String j = this.j;
                try {
                    final JSONObject jsonObject = new JSONObject(j);
                    jsonObject.put("prod", (Object)b.d);
                    jsonObject.put("uptime", System.currentTimeMillis());
                    final d b2 = this.b;
                    try {
                        b2.e(jsonObject.toString());
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        if (this.k != null) {
            this.k.clear();
        }
    }
}
