// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class PopupWindowCompatApi21
{
    private static final String TAG = "PopupWindowCompatApi21";
    private static Field sOverlapAnchorField;
    
    static {
        final Class<PopupWindow> clazz = PopupWindow.class;
        final String s = "mOverlapAnchor";
        final Class<PopupWindow> clazz2 = clazz;
        try {
            final Field declaredField = clazz2.getDeclaredField(s);
            try {
                (PopupWindowCompatApi21.sOverlapAnchorField = declaredField).setAccessible(true);
            }
            catch (NoSuchFieldException ex) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", (Throwable)ex);
            }
        }
        catch (NoSuchFieldException ex2) {}
    }
    
    static boolean getOverlapAnchor(final PopupWindow popupWindow) {
        final Field sOverlapAnchorField = PopupWindowCompatApi21.sOverlapAnchorField;
        if (sOverlapAnchorField != null) {
            final Field field = sOverlapAnchorField;
            try {
                final Object value = field.get(popupWindow);
                try {
                    final Boolean b = (Boolean)value;
                    try {
                        return b;
                    }
                    catch (IllegalAccessException ex) {
                        Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", (Throwable)ex);
                    }
                }
                catch (IllegalAccessException ex2) {}
            }
            catch (IllegalAccessException ex3) {}
        }
        return false;
    }
    
    static void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
        final Field sOverlapAnchorField = PopupWindowCompatApi21.sOverlapAnchorField;
        if (sOverlapAnchorField != null) {
            try {
                sOverlapAnchorField.set(popupWindow, b);
            }
            catch (IllegalAccessException ex) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", (Throwable)ex);
            }
        }
    }
}
