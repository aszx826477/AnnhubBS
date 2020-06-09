// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;

interface GestureDetectorCompat$GestureDetectorCompatImpl
{
    boolean isLongpressEnabled();
    
    boolean onTouchEvent(final MotionEvent p0);
    
    void setIsLongpressEnabled(final boolean p0);
    
    void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener p0);
}
