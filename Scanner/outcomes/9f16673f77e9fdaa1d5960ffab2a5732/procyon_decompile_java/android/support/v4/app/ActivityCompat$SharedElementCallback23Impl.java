// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.Map;
import java.util.List;
import android.content.Context;
import android.os.Parcelable;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;

class ActivityCompat$SharedElementCallback23Impl extends ActivityCompatApi23$SharedElementCallback23
{
    private SharedElementCallback mCallback;
    
    public ActivityCompat$SharedElementCallback23Impl(final SharedElementCallback mCallback) {
        this.mCallback = mCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(final View view, final Matrix matrix, final RectF rectF) {
        return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }
    
    public View onCreateSnapshotView(final Context context, final Parcelable parcelable) {
        return this.mCallback.onCreateSnapshotView(context, parcelable);
    }
    
    public void onMapSharedElements(final List list, final Map map) {
        this.mCallback.onMapSharedElements(list, map);
    }
    
    public void onRejectSharedElements(final List list) {
        this.mCallback.onRejectSharedElements(list);
    }
    
    public void onSharedElementEnd(final List list, final List list2, final List list3) {
        this.mCallback.onSharedElementEnd(list, list2, list3);
    }
    
    public void onSharedElementStart(final List list, final List list2, final List list3) {
        this.mCallback.onSharedElementStart(list, list2, list3);
    }
    
    public void onSharedElementsArrived(final List list, final List list2, final ActivityCompatApi23$OnSharedElementsReadyListenerBridge activityCompatApi23$OnSharedElementsReadyListenerBridge) {
        this.mCallback.onSharedElementsArrived(list, list2, new ActivityCompat$SharedElementCallback23Impl$1(this, activityCompatApi23$OnSharedElementsReadyListenerBridge));
    }
}
