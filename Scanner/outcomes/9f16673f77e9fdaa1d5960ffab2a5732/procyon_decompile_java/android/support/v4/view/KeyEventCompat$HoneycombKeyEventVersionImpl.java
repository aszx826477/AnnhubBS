// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompat$HoneycombKeyEventVersionImpl extends KeyEventCompat$BaseKeyEventVersionImpl
{
    public boolean isCtrlPressed(final KeyEvent keyEvent) {
        return KeyEventCompatHoneycomb.isCtrlPressed(keyEvent);
    }
    
    public boolean metaStateHasModifiers(final int n, final int n2) {
        return KeyEventCompatHoneycomb.metaStateHasModifiers(n, n2);
    }
    
    public boolean metaStateHasNoModifiers(final int n) {
        return KeyEventCompatHoneycomb.metaStateHasNoModifiers(n);
    }
    
    public int normalizeMetaState(final int n) {
        return KeyEventCompatHoneycomb.normalizeMetaState(n);
    }
}
