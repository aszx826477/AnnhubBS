// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo.util;

import android.os.Build$VERSION;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

final class \u1d62\u02ce implements DialogInterface$OnClickListener
{
    \u1d62\u02ce(final \u1d62\u02cb \u1d62\u02cb) {
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final Thread currentThread = Thread.currentThread();
        synchronized (currentThread) {
            if (Build$VERSION.SDK_INT >= 19) {
                currentThread.notify();
            }
        }
    }
}
