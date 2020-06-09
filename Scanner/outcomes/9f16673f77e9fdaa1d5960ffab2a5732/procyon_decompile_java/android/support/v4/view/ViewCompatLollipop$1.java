// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.WindowInsets;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;

final class ViewCompatLollipop$1 implements View$OnApplyWindowInsetsListener
{
    final /* synthetic */ ViewCompatLollipop$OnApplyWindowInsetsListenerBridge val$bridge;
    
    ViewCompatLollipop$1(final ViewCompatLollipop$OnApplyWindowInsetsListenerBridge val$bridge) {
        this.val$bridge = val$bridge;
    }
    
    public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
        return (WindowInsets)this.val$bridge.onApplyWindowInsets(view, windowInsets);
    }
}
