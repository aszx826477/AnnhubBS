// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter implements Runnable
{
    WeakReference mViewRef;
    ViewPropertyAnimatorCompat mVpa;
    final /* synthetic */ ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl this$0;
    
    ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter(final ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl this$0, final ViewPropertyAnimatorCompat mVpa, final View view) {
        this.this$0 = this$0;
        this.mViewRef = new WeakReference((T)view);
        this.mVpa = mVpa;
    }
    
    public void run() {
        final View view = (View)this.mViewRef.get();
        if (view != null) {
            this.this$0.startAnimation(this.mVpa, view);
        }
    }
}
