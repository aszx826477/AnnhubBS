// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;

interface PopupWindowCompat$PopupWindowImpl
{
    boolean getOverlapAnchor(final PopupWindow p0);
    
    int getWindowLayoutType(final PopupWindow p0);
    
    void setOverlapAnchor(final PopupWindow p0, final boolean p1);
    
    void setWindowLayoutType(final PopupWindow p0, final int p1);
    
    void showAsDropDown(final PopupWindow p0, final View p1, final int p2, final int p3, final int p4);
}
