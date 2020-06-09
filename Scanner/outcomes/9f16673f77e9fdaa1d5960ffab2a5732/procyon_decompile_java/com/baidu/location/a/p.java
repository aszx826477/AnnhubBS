// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.d.c;
import org.json.JSONObject;
import com.baidu.location.Jni;
import android.os.Build$VERSION;
import android.os.Build;
import java.io.RandomAccessFile;
import com.baidu.location.d.i;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import com.baidu.location.d.j;
import android.net.NetworkInfo;
import com.baidu.location.b.d;
import com.baidu.location.b.b;
import android.net.ConnectivityManager;
import android.content.Context;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import android.os.Handler;
import com.baidu.location.d.e;
import com.baidu.location.f;
import com.baidu.location.b.h;

class p implements Runnable
{
    final /* synthetic */ o a;
    
    p(final o a) {
        this.a = a;
    }
    
    public void run() {
        if (h.i() || this.a.a(f.getServiceContext())) {
            this.a.d();
        }
    }
}
