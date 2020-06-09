// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import java.util.Comparator;

final class ViewPager$1 implements Comparator
{
    public int compare(final ViewPager$ItemInfo viewPager$ItemInfo, final ViewPager$ItemInfo viewPager$ItemInfo2) {
        return viewPager$ItemInfo.position - viewPager$ItemInfo2.position;
    }
}
