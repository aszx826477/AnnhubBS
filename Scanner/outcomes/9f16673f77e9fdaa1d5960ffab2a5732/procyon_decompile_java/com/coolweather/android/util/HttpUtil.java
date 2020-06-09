// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.util;

import okhttp3.Request$Builder;
import okhttp3.OkHttpClient;
import okhttp3.Callback;

public class HttpUtil
{
    public static void sendOkHttpRequest(final String s, final Callback callback) {
        new OkHttpClient().newCall(new Request$Builder().url(s).build()).enqueue(callback);
    }
}
