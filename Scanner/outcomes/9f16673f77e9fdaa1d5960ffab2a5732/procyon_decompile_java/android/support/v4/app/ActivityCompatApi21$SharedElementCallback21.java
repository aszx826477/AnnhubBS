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

public abstract class ActivityCompatApi21$SharedElementCallback21
{
    public abstract Parcelable onCaptureSharedElementSnapshot(final View p0, final Matrix p1, final RectF p2);
    
    public abstract View onCreateSnapshotView(final Context p0, final Parcelable p1);
    
    public abstract void onMapSharedElements(final List p0, final Map p1);
    
    public abstract void onRejectSharedElements(final List p0);
    
    public abstract void onSharedElementEnd(final List p0, final List p1, final List p2);
    
    public abstract void onSharedElementStart(final List p0, final List p1, final List p2);
}
