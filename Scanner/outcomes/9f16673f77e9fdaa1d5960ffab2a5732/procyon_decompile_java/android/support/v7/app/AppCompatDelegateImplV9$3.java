// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;

class AppCompatDelegateImplV9$3 implements FitWindowsViewGroup$OnFitSystemWindowsListener
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$3(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public void onFitSystemWindows(final Rect rect) {
        rect.top = this.this$0.updateStatusGuard(rect.top);
    }
}
