// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

class ListPopupWindow$PopupTouchInterceptor implements View$OnTouchListener
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$PopupTouchInterceptor(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = (int)motionEvent.getX();
        final int n2 = (int)motionEvent.getY();
        if (action == 0 && this.this$0.mPopup != null) {
            if (this.this$0.mPopup.isShowing() && n >= 0) {
                if (n < this.this$0.mPopup.getWidth() && n2 >= 0 && n2 < this.this$0.mPopup.getHeight()) {
                    this.this$0.mHandler.postDelayed((Runnable)this.this$0.mResizePopupRunnable, 250L);
                    return false;
                }
            }
        }
        if (action == 1) {
            this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
        }
        return false;
    }
}
