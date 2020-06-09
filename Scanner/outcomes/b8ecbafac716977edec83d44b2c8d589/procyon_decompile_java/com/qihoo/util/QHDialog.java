// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo.util;

import android.os.Build$VERSION;
import android.content.Context;

public class QHDialog
{
    public static void showDialog(final Context context, final String s) {
        final Thread thread = new Thread(new \u1d62\u02cb(context, s));
        synchronized (thread) {
            try {
                thread.start();
                if (Build$VERSION.SDK_INT >= 19) {
                    thread.wait();
                }
                else {
                    Thread.sleep(3000L);
                }
            }
            catch (InterruptedException ex) {}
        }
    }
}
