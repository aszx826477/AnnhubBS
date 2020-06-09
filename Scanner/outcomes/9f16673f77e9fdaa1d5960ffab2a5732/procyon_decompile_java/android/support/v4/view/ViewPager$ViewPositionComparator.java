// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator implements Comparator
{
    public int compare(final View view, final View view2) {
        final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)view.getLayoutParams();
        final ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams)view2.getLayoutParams();
        if (viewPager$LayoutParams.isDecor != viewPager$LayoutParams2.isDecor) {
            int n;
            if (viewPager$LayoutParams.isDecor) {
                n = 1;
            }
            else {
                n = -1;
            }
            return n;
        }
        return viewPager$LayoutParams.position - viewPager$LayoutParams2.position;
    }
}
