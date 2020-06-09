// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.util.Util;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Handler;

class ResourceRecycler
{
    private final Handler handler;
    private boolean isRecycling;
    
    ResourceRecycler() {
        this.handler = new Handler(Looper.getMainLooper(), (Handler$Callback)new ResourceRecycler$ResourceRecyclerCallback(null));
    }
    
    public void recycle(final Resource resource) {
        Util.assertMainThread();
        final boolean isRecycling = this.isRecycling;
        final int isRecycling2 = 1;
        if (isRecycling) {
            this.handler.obtainMessage(isRecycling2, (Object)resource).sendToTarget();
        }
        else {
            this.isRecycling = (isRecycling2 != 0);
            resource.recycle();
            this.isRecycling = false;
        }
    }
}
