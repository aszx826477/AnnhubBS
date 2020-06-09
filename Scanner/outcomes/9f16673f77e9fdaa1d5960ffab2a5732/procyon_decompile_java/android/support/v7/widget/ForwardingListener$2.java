// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.SystemClock;
import android.view.ViewParent;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.view.View;
import android.view.View$OnTouchListener;
import android.support.v4.view.ViewCompat;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class ForwardingListener$2 implements ViewTreeObserver$OnGlobalLayoutListener
{
    boolean mIsAttached;
    final /* synthetic */ ForwardingListener this$0;
    
    ForwardingListener$2(final ForwardingListener this$0) {
        this.this$0 = this$0;
        this.mIsAttached = ViewCompat.isAttachedToWindow(this.this$0.mSrc);
    }
    
    public void onGlobalLayout() {
        final boolean mIsAttached = this.mIsAttached;
        this.mIsAttached = ViewCompat.isAttachedToWindow(this.this$0.mSrc);
        if (mIsAttached && !this.mIsAttached) {
            this.this$0.onDetachedFromWindow();
        }
    }
}
