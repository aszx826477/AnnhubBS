// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.WindowInsets;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;

class DrawerLayoutCompatApi21$InsetsListener implements View$OnApplyWindowInsetsListener
{
    public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
        ((DrawerLayoutImpl)view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
