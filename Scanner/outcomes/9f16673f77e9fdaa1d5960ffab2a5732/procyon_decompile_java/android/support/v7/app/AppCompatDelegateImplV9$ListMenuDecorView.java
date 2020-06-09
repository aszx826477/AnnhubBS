// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.content.res.AppCompatResources;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;

class AppCompatDelegateImplV9$ListMenuDecorView extends ContentFrameLayout
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    public AppCompatDelegateImplV9$ListMenuDecorView(final AppCompatDelegateImplV9 this$0, final Context context) {
        this.this$0 = this$0;
        super(context);
    }
    
    private boolean isOutOfBounds(final int n, final int n2) {
        final int n3 = -5;
        return n < n3 || n2 < n3 || n > this.getWidth() + 5 || n2 > this.getHeight() + 5;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.isOutOfBounds((int)motionEvent.getX(), (int)motionEvent.getY())) {
            this.this$0.closePanel(0);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
    
    public void setBackgroundResource(final int n) {
        this.setBackgroundDrawable(AppCompatResources.getDrawable(this.getContext(), n));
    }
}
