// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.KeyEvent;

interface KeyEventCompat$KeyEventVersionImpl
{
    boolean isCtrlPressed(final KeyEvent p0);
    
    boolean metaStateHasModifiers(final int p0, final int p1);
    
    boolean metaStateHasNoModifiers(final int p0);
    
    int normalizeMetaState(final int p0);
}
