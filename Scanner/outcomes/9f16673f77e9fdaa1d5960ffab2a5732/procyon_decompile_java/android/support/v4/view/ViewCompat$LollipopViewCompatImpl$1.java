// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;

class ViewCompat$LollipopViewCompatImpl$1 implements ViewCompatLollipop$OnApplyWindowInsetsListenerBridge
{
    final /* synthetic */ ViewCompat$LollipopViewCompatImpl this$0;
    final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    
    ViewCompat$LollipopViewCompatImpl$1(final ViewCompat$LollipopViewCompatImpl this$0, final OnApplyWindowInsetsListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public Object onApplyWindowInsets(final View view, final Object o) {
        return WindowInsetsCompat.unwrap(this.val$listener.onApplyWindowInsets(view, WindowInsetsCompat.wrap(o)));
    }
}
