// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;
import android.os.Build$VERSION;

public final class PopupWindowCompat
{
    static final PopupWindowCompat$PopupWindowImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = new PopupWindowCompat$Api23PopupWindowImpl();
        }
        else if (sdk_INT >= 21) {
            IMPL = new PopupWindowCompat$Api21PopupWindowImpl();
        }
        else if (sdk_INT >= 19) {
            IMPL = new PopupWindowCompat$KitKatPopupWindowImpl();
        }
        else {
            IMPL = new PopupWindowCompat$BasePopupWindowImpl();
        }
    }
    
    public static boolean getOverlapAnchor(final PopupWindow popupWindow) {
        return PopupWindowCompat.IMPL.getOverlapAnchor(popupWindow);
    }
    
    public static int getWindowLayoutType(final PopupWindow popupWindow) {
        return PopupWindowCompat.IMPL.getWindowLayoutType(popupWindow);
    }
    
    public static void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
        PopupWindowCompat.IMPL.setOverlapAnchor(popupWindow, b);
    }
    
    public static void setWindowLayoutType(final PopupWindow popupWindow, final int n) {
        PopupWindowCompat.IMPL.setWindowLayoutType(popupWindow, n);
    }
    
    public static void showAsDropDown(final PopupWindow popupWindow, final View view, final int n, final int n2, final int n3) {
        PopupWindowCompat.IMPL.showAsDropDown(popupWindow, view, n, n2, n3);
    }
}
