// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;

class ViewCompat$Api24ViewCompatImpl extends ViewCompat$MarshmallowViewCompatImpl
{
    public void setPointerIcon(final View view, final PointerIconCompat pointerIconCompat) {
        Object pointerIcon;
        if (pointerIconCompat != null) {
            pointerIcon = pointerIconCompat.getPointerIcon();
        }
        else {
            pointerIcon = null;
        }
        ViewCompatApi24.setPointerIcon(view, pointerIcon);
    }
}
