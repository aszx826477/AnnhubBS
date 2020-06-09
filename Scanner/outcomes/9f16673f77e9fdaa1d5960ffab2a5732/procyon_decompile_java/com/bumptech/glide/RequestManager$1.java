// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.Lifecycle;

class RequestManager$1 implements Runnable
{
    final /* synthetic */ RequestManager this$0;
    final /* synthetic */ Lifecycle val$lifecycle;
    
    RequestManager$1(final RequestManager this$0, final Lifecycle val$lifecycle) {
        this.this$0 = this$0;
        this.val$lifecycle = val$lifecycle;
    }
    
    public void run() {
        this.val$lifecycle.addListener(this.this$0);
    }
}
