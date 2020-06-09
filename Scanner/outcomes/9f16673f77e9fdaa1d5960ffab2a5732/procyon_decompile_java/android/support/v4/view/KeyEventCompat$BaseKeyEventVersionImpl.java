// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompat$BaseKeyEventVersionImpl implements KeyEventCompat$KeyEventVersionImpl
{
    private static final int META_ALL_MASK = 247;
    private static final int META_MODIFIER_MASK = 247;
    
    private static int metaStateFilterDirectionalModifiers(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = n2 & n3;
        boolean b = true;
        final boolean b2 = n6 != 0;
        final int n7 = n4 | n5;
        if ((n2 & n7) == 0x0) {
            b = false;
        }
        if (b2) {
            if (!b) {
                return ~n7 & n;
            }
            throw new IllegalArgumentException("bad arguments");
        }
        else {
            if (b) {
                return ~n3 & n;
            }
            return n;
        }
    }
    
    public boolean isCtrlPressed(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean metaStateHasModifiers(int n, final int n2) {
        n = (this.normalizeMetaState(n) & 0xF7);
        int n3 = 1;
        n = metaStateFilterDirectionalModifiers(n, n2, n3, 64, 128);
        n = metaStateFilterDirectionalModifiers(n, n2, 2, 16, 32);
        if (n != n2) {
            n3 = 0;
        }
        return n3 != 0;
    }
    
    public boolean metaStateHasNoModifiers(final int n) {
        return (this.normalizeMetaState(n) & 0xF7) == 0x0;
    }
    
    public int normalizeMetaState(int n) {
        if ((n & 0xC0) != 0x0) {
            n |= 0x1;
        }
        if ((n & 0x30) != 0x0) {
            n |= 0x2;
        }
        return n & 0xF7;
    }
}
