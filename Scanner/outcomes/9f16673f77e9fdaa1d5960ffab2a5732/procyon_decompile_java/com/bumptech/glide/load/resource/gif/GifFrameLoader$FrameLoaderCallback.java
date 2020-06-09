// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.Glide;
import android.os.Message;
import android.os.Handler$Callback;

class GifFrameLoader$FrameLoaderCallback implements Handler$Callback
{
    public static final int MSG_CLEAR = 2;
    public static final int MSG_DELAY = 1;
    final /* synthetic */ GifFrameLoader this$0;
    
    private GifFrameLoader$FrameLoaderCallback(final GifFrameLoader this$0) {
        this.this$0 = this$0;
    }
    
    public boolean handleMessage(final Message message) {
        final int what = message.what;
        final boolean b = true;
        if (what == (b ? 1 : 0)) {
            this.this$0.onFrameReady((GifFrameLoader$DelayTarget)message.obj);
            return b;
        }
        if (message.what == 2) {
            Glide.clear((Target)message.obj);
        }
        return false;
    }
}
