// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SlidingPaneLayout$SlidingPanelLayoutImplJB extends SlidingPaneLayout$SlidingPanelLayoutImplBase
{
    private Method mGetDisplayList;
    private Field mRecreateDisplayList;
    
    SlidingPaneLayout$SlidingPanelLayoutImplJB() {
        final Class<View> clazz = View.class;
        final String s = "getDisplayList";
        try {
            final Class[] array = null;
            this.mGetDisplayList = clazz.getDeclaredMethod(s, (Class[])null);
        }
        catch (NoSuchMethodException ex) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", (Throwable)ex);
        }
        final Class<View> clazz2 = View.class;
        final String s2 = "mRecreateDisplayList";
        final Class<View> clazz3 = clazz2;
        try {
            (this.mRecreateDisplayList = clazz3.getDeclaredField(s2)).setAccessible(true);
        }
        catch (NoSuchFieldException ex2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", (Throwable)ex2);
        }
    }
    
    public void invalidateChildRegion(final SlidingPaneLayout slidingPaneLayout, final View view) {
        if (this.mGetDisplayList != null) {
            final Field mRecreateDisplayList = this.mRecreateDisplayList;
            if (mRecreateDisplayList != null) {
                final boolean b = true;
                final Field field = mRecreateDisplayList;
                try {
                    field.setBoolean(view, b);
                    final Method mGetDisplayList = this.mGetDisplayList;
                    final Object[] array = null;
                    mGetDisplayList.invoke(view, (Object[])null);
                }
                catch (Exception ex) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", (Throwable)ex);
                }
                super.invalidateChildRegion(slidingPaneLayout, view);
                return;
            }
        }
        view.invalidate();
    }
}
