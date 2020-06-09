// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import com.baidu.android.bbalbs.common.util.CommonParam;
import android.text.TextUtils;
import java.util.Map;
import java.util.HashMap;
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
import java.util.Hashtable;
import android.content.Context;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

class i extends Handler
{
    final /* synthetic */ LBSAuthManager a;
    
    i(final LBSAuthManager a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (com.baidu.lbsapi.auth.a.a) {
            com.baidu.lbsapi.auth.a.a("handleMessage !!");
        }
        final LBSAuthManagerListener lbsAuthManagerListener = LBSAuthManager.f.get(message.getData().getString("listenerKey"));
        if (com.baidu.lbsapi.auth.a.a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("handleMessage listener = ");
            sb.append(lbsAuthManagerListener);
            com.baidu.lbsapi.auth.a.a(sb.toString());
        }
        if (lbsAuthManagerListener != null) {
            lbsAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
