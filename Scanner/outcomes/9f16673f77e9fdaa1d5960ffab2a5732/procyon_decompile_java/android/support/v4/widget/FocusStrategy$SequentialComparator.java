// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

class FocusStrategy$SequentialComparator implements Comparator
{
    private final FocusStrategy$BoundsAdapter mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1;
    private final Rect mTemp2;
    
    FocusStrategy$SequentialComparator(final boolean mIsLayoutRtl, final FocusStrategy$BoundsAdapter mAdapter) {
        this.mTemp1 = new Rect();
        this.mTemp2 = new Rect();
        this.mIsLayoutRtl = mIsLayoutRtl;
        this.mAdapter = mAdapter;
    }
    
    public int compare(final Object o, final Object o2) {
        final Rect mTemp1 = this.mTemp1;
        final Rect mTemp2 = this.mTemp2;
        this.mAdapter.obtainBounds(o, mTemp1);
        this.mAdapter.obtainBounds(o2, mTemp2);
        final int top = mTemp1.top;
        final int top2 = mTemp2.top;
        int n = -1;
        if (top < top2) {
            return n;
        }
        final int top3 = mTemp1.top;
        final int top4 = mTemp2.top;
        final boolean b = true;
        if (top3 > top4) {
            return b ? 1 : 0;
        }
        if (mTemp1.left < mTemp2.left) {
            if (this.mIsLayoutRtl) {
                n = 1;
            }
            return n;
        }
        if (mTemp1.left > mTemp2.left) {
            if (!this.mIsLayoutRtl) {
                n = 1;
            }
            return n;
        }
        if (mTemp1.bottom < mTemp2.bottom) {
            return n;
        }
        if (mTemp1.bottom > mTemp2.bottom) {
            return b ? 1 : 0;
        }
        if (mTemp1.right < mTemp2.right) {
            if (this.mIsLayoutRtl) {
                n = 1;
            }
            return n;
        }
        if (mTemp1.right > mTemp2.right) {
            if (!this.mIsLayoutRtl) {
                n = 1;
            }
            return n;
        }
        return 0;
    }
}
