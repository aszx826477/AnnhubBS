// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import android.os.Message;
import android.os.Handler$Callback;

class ResourceRecycler$ResourceRecyclerCallback implements Handler$Callback
{
    public static final int RECYCLE_RESOURCE = 1;
    
    public boolean handleMessage(final Message message) {
        final int what = message.what;
        final boolean b = true;
        if (what == (b ? 1 : 0)) {
            ((Resource)message.obj).recycle();
            return b;
        }
        return false;
    }
}
