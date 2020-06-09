// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;

public abstract class ViewDragHelper$Callback
{
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        return 0;
    }
    
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return 0;
    }
    
    public int getOrderedChildIndex(final int n) {
        return n;
    }
    
    public int getViewHorizontalDragRange(final View view) {
        return 0;
    }
    
    public int getViewVerticalDragRange(final View view) {
        return 0;
    }
    
    public void onEdgeDragStarted(final int n, final int n2) {
    }
    
    public boolean onEdgeLock(final int n) {
        return false;
    }
    
    public void onEdgeTouched(final int n, final int n2) {
    }
    
    public void onViewCaptured(final View view, final int n) {
    }
    
    public void onViewDragStateChanged(final int n) {
    }
    
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
    }
    
    public void onViewReleased(final View view, final float n, final float n2) {
    }
    
    public abstract boolean tryCaptureView(final View p0, final int p1);
}
