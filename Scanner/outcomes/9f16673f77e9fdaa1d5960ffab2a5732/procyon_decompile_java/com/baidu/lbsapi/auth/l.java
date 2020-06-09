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

class l implements e$a
{
    final /* synthetic */ String a;
    final /* synthetic */ LBSAuthManager b;
    
    l(final LBSAuthManager b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final String s) {
        this.b.a(s, this.a);
    }
}
