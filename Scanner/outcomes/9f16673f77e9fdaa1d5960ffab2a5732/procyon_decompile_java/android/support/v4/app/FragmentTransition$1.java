// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.graphics.Rect;
import android.view.ViewGroup;
import java.util.Map;
import java.util.List;
import android.util.SparseArray;
import android.support.v4.view.ViewCompat;
import java.util.Collection;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

final class FragmentTransition$1 implements Runnable
{
    final /* synthetic */ ArrayList val$exitingViews;
    
    FragmentTransition$1(final ArrayList val$exitingViews) {
        this.val$exitingViews = val$exitingViews;
    }
    
    public void run() {
        setViewVisibility(this.val$exitingViews, 4);
    }
}
