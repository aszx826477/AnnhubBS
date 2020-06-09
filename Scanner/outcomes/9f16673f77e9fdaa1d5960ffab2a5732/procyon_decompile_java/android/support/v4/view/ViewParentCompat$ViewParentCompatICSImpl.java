// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatICSImpl extends ViewParentCompat$ViewParentCompatStubImpl
{
    public boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        return ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
