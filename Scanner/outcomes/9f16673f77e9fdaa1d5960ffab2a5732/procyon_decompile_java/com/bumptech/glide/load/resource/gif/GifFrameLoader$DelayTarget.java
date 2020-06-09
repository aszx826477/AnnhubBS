// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.Bitmap;
import android.os.Handler;
import com.bumptech.glide.request.target.SimpleTarget;

class GifFrameLoader$DelayTarget extends SimpleTarget
{
    private final Handler handler;
    private final int index;
    private Bitmap resource;
    private final long targetTime;
    
    public GifFrameLoader$DelayTarget(final Handler handler, final int index, final long targetTime) {
        this.handler = handler;
        this.index = index;
        this.targetTime = targetTime;
    }
    
    public Bitmap getResource() {
        return this.resource;
    }
    
    public void onResourceReady(final Bitmap resource, final GlideAnimation glideAnimation) {
        this.resource = resource;
        this.handler.sendMessageAtTime(this.handler.obtainMessage(1, (Object)this), this.targetTime);
    }
}
