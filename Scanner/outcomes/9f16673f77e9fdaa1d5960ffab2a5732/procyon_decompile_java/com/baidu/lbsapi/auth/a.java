// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import android.util.Log;

class a
{
    public static boolean a;
    private static String b;
    
    static {
        com.baidu.lbsapi.auth.a.a = false;
        com.baidu.lbsapi.auth.a.b = "BaiduApiAuth";
    }
    
    public static String a() {
        final StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        final StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getFileName());
        sb.append("[");
        sb.append(stackTraceElement.getLineNumber());
        sb.append("]");
        return sb.toString();
    }
    
    public static void a(String string) {
        if (com.baidu.lbsapi.auth.a.a) {
            if (Thread.currentThread().getStackTrace().length == 0) {
                return;
            }
            final String b = com.baidu.lbsapi.auth.a.b;
            final StringBuilder sb = new StringBuilder();
            sb.append(a());
            sb.append(";");
            sb.append(string);
            string = sb.toString();
            Log.d(b, string);
        }
    }
    
    public static void b(final String s) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(com.baidu.lbsapi.auth.a.b, s);
    }
    
    public static void c(String string) {
        if (com.baidu.lbsapi.auth.a.a) {
            if (Thread.currentThread().getStackTrace().length == 0) {
                return;
            }
            final String b = com.baidu.lbsapi.auth.a.b;
            final StringBuilder sb = new StringBuilder();
            sb.append(a());
            sb.append(";");
            sb.append(string);
            string = sb.toString();
            Log.e(b, string);
        }
    }
}
