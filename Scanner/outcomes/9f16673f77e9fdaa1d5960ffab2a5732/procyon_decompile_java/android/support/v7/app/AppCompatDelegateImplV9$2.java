// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.support.v4.view.OnApplyWindowInsetsListener;

class AppCompatDelegateImplV9$2 implements OnApplyWindowInsetsListener
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$2(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public WindowInsetsCompat onApplyWindowInsets(final View view, WindowInsetsCompat replaceSystemWindowInsets) {
        final int systemWindowInsetTop = replaceSystemWindowInsets.getSystemWindowInsetTop();
        final int updateStatusGuard = this.this$0.updateStatusGuard(systemWindowInsetTop);
        if (systemWindowInsetTop != updateStatusGuard) {
            replaceSystemWindowInsets = replaceSystemWindowInsets.replaceSystemWindowInsets(replaceSystemWindowInsets.getSystemWindowInsetLeft(), updateStatusGuard, replaceSystemWindowInsets.getSystemWindowInsetRight(), replaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        return ViewCompat.onApplyWindowInsets(view, replaceSystemWindowInsets);
    }
}
