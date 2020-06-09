// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.SystemClock;
import android.view.ViewParent;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;

class ForwardingListener$1 implements View$OnAttachStateChangeListener
{
    final /* synthetic */ ForwardingListener this$0;
    
    ForwardingListener$1(final ForwardingListener this$0) {
        this.this$0 = this$0;
    }
    
    public void onViewAttachedToWindow(final View view) {
    }
    
    public void onViewDetachedFromWindow(final View view) {
        this.this$0.onDetachedFromWindow();
    }
}
