// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewParent;

class ForwardingListener$DisallowIntercept implements Runnable
{
    final /* synthetic */ ForwardingListener this$0;
    
    ForwardingListener$DisallowIntercept(final ForwardingListener this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final ViewParent parent = this.this$0.mSrc.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
