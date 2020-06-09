// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;

public final class GestureDetectorCompat
{
    private final GestureDetectorCompat$GestureDetectorCompatImpl mImpl;
    
    public GestureDetectorCompat(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener) {
        this(context, gestureDetector$OnGestureListener, null);
    }
    
    public GestureDetectorCompat(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        if (Build$VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(context, gestureDetector$OnGestureListener, handler);
        }
        else {
            this.mImpl = new GestureDetectorCompat$GestureDetectorCompatImplBase(context, gestureDetector$OnGestureListener, handler);
        }
    }
    
    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }
    
    public void setIsLongpressEnabled(final boolean isLongpressEnabled) {
        this.mImpl.setIsLongpressEnabled(isLongpressEnabled);
    }
    
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
