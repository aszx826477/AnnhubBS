// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.Gravity;
import android.graphics.Rect;

class GravityCompat$GravityCompatImplBase implements GravityCompat$GravityCompatImpl
{
    public void apply(final int n, final int n2, final int n3, final Rect rect, final int n4, final int n5, final Rect rect2, final int n6) {
        Gravity.apply(n, n2, n3, rect, n4, n5, rect2);
    }
    
    public void apply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2, final int n4) {
        Gravity.apply(n, n2, n3, rect, rect2);
    }
    
    public void applyDisplay(final int n, final Rect rect, final Rect rect2, final int n2) {
        Gravity.applyDisplay(n, rect, rect2);
    }
    
    public int getAbsoluteGravity(final int n, final int n2) {
        return 0xFF7FFFFF & n;
    }
}
