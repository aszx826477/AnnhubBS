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
import org.json.JSONObject;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import com.baidu.location.d.i;
import com.baidu.location.d.b;
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
import java.util.List;
import android.os.Handler;
import android.location.Location;

class e implements Runnable
{
    final /* synthetic */ Location a;
    final /* synthetic */ d b;
    
    e(final d b, final Location a) {
        this.b = b;
        this.a = a;
    }
    
    public void run() {
        this.b.b(this.a);
    }
}
