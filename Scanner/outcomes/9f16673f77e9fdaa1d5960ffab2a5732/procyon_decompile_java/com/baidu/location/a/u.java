// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.HandlerThread;

public class u
{
    private static HandlerThread a;
    
    static {
        u.a = null;
    }
    
    public static HandlerThread a() {
        synchronized (u.class) {
            if (u.a == null) {
                (u.a = new HandlerThread("ServiceStartArguments", 10)).start();
            }
            return u.a;
        }
    }
}
