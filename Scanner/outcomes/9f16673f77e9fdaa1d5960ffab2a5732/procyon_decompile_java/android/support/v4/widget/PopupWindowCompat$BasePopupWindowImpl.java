// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompat$BasePopupWindowImpl implements PopupWindowCompat$PopupWindowImpl
{
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;
    
    public boolean getOverlapAnchor(final PopupWindow popupWindow) {
        return false;
    }
    
    public int getWindowLayoutType(final PopupWindow popupWindow) {
        if (!PopupWindowCompat$BasePopupWindowImpl.sGetWindowLayoutTypeMethodAttempted) {
            final boolean b = true;
            final Class<PopupWindow> clazz = PopupWindow.class;
            final String s = "getWindowLayoutType";
            try {
                final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])new Class[0]);
                try {
                    (PopupWindowCompat$BasePopupWindowImpl.sGetWindowLayoutTypeMethod = declaredMethod).setAccessible(b);
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
            PopupWindowCompat$BasePopupWindowImpl.sGetWindowLayoutTypeMethodAttempted = b;
        }
        final Method sGetWindowLayoutTypeMethod = PopupWindowCompat$BasePopupWindowImpl.sGetWindowLayoutTypeMethod;
        if (sGetWindowLayoutTypeMethod != null) {
            try {
                final Object invoke = sGetWindowLayoutTypeMethod.invoke(popupWindow, new Object[0]);
                try {
                    final Integer n = (Integer)invoke;
                    try {
                        return n;
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
        return 0;
    }
    
    public void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
    }
    
    public void setWindowLayoutType(final PopupWindow popupWindow, final int n) {
        final boolean sSetWindowLayoutTypeMethodAttempted = PopupWindowCompat$BasePopupWindowImpl.sSetWindowLayoutTypeMethodAttempted;
        final int n2 = 1;
        if (!sSetWindowLayoutTypeMethodAttempted) {
            final Class<PopupWindow> clazz = PopupWindow.class;
            final String s = "setWindowLayoutType";
            try {
                final Class[] array = new Class[n2];
                try {
                    array[0] = Integer.TYPE;
                    final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                    try {
                        (PopupWindowCompat$BasePopupWindowImpl.sSetWindowLayoutTypeMethod = declaredMethod).setAccessible(n2 != 0);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
            PopupWindowCompat$BasePopupWindowImpl.sSetWindowLayoutTypeMethodAttempted = (n2 != 0);
        }
        final Method sSetWindowLayoutTypeMethod = PopupWindowCompat$BasePopupWindowImpl.sSetWindowLayoutTypeMethod;
        if (sSetWindowLayoutTypeMethod != null) {
            try {
                final Object[] array2 = new Object[n2];
                try {
                    array2[0] = n;
                    sSetWindowLayoutTypeMethod.invoke(popupWindow, array2);
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
    }
    
    public void showAsDropDown(final PopupWindow popupWindow, final View view, int n, final int n2, final int n3) {
        if ((GravityCompat.getAbsoluteGravity(n3, ViewCompat.getLayoutDirection(view)) & 0x7) == 0x5) {
            n -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, n, n2);
    }
}
