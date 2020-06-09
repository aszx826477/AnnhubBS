// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View$OnTouchListener;
import android.os.Build$VERSION;

public final class PopupMenuCompat
{
    static final PopupMenuCompat$PopupMenuImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = new PopupMenuCompat$KitKatPopupMenuImpl();
        }
        else {
            IMPL = new PopupMenuCompat$BasePopupMenuImpl();
        }
    }
    
    public static View$OnTouchListener getDragToOpenListener(final Object o) {
        return PopupMenuCompat.IMPL.getDragToOpenListener(o);
    }
}
