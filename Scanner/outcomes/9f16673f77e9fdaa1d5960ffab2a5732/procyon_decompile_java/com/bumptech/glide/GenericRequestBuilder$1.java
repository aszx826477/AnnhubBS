// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.RequestFutureTarget;

class GenericRequestBuilder$1 implements Runnable
{
    final /* synthetic */ GenericRequestBuilder this$0;
    final /* synthetic */ RequestFutureTarget val$target;
    
    GenericRequestBuilder$1(final GenericRequestBuilder this$0, final RequestFutureTarget val$target) {
        this.this$0 = this$0;
        this.val$target = val$target;
    }
    
    public void run() {
        if (!this.val$target.isCancelled()) {
            this.this$0.into(this.val$target);
        }
    }
}
