// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompat$Api21PopupWindowImpl extends PopupWindowCompat$KitKatPopupWindowImpl
{
    public boolean getOverlapAnchor(final PopupWindow popupWindow) {
        return PopupWindowCompatApi21.getOverlapAnchor(popupWindow);
    }
    
    public void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
        PopupWindowCompatApi21.setOverlapAnchor(popupWindow, b);
    }
}
