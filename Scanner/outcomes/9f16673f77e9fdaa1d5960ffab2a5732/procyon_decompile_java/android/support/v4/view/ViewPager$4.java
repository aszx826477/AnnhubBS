// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.graphics.Rect;

class ViewPager$4 implements OnApplyWindowInsetsListener
{
    private final Rect mTempRect;
    final /* synthetic */ ViewPager this$0;
    
    ViewPager$4(final ViewPager this$0) {
        this.this$0 = this$0;
        this.mTempRect = new Rect();
    }
    
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        final WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        if (onApplyWindowInsets.isConsumed()) {
            return onApplyWindowInsets;
        }
        final Rect mTempRect = this.mTempRect;
        mTempRect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
        mTempRect.top = onApplyWindowInsets.getSystemWindowInsetTop();
        mTempRect.right = onApplyWindowInsets.getSystemWindowInsetRight();
        mTempRect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
        for (int i = 0; i < this.this$0.getChildCount(); ++i) {
            final WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(this.this$0.getChildAt(i), onApplyWindowInsets);
            mTempRect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), mTempRect.left);
            mTempRect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), mTempRect.top);
            mTempRect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), mTempRect.right);
            mTempRect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), mTempRect.bottom);
        }
        return onApplyWindowInsets.replaceSystemWindowInsets(mTempRect.left, mTempRect.top, mTempRect.right, mTempRect.bottom);
    }
}
