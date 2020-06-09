// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent$Callback;
import android.view.KeyEvent;
import android.os.Build$VERSION;

public final class KeyEventCompat
{
    static final KeyEventCompat$KeyEventVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new KeyEventCompat$HoneycombKeyEventVersionImpl();
        }
        else {
            IMPL = new KeyEventCompat$BaseKeyEventVersionImpl();
        }
    }
    
    public static boolean dispatch(final KeyEvent keyEvent, final KeyEvent$Callback keyEvent$Callback, final Object o, final Object o2) {
        return keyEvent.dispatch(keyEvent$Callback, (KeyEvent$DispatcherState)o, o2);
    }
    
    public static Object getKeyDispatcherState(final View view) {
        return view.getKeyDispatcherState();
    }
    
    public static boolean hasModifiers(final KeyEvent keyEvent, final int n) {
        return KeyEventCompat.IMPL.metaStateHasModifiers(keyEvent.getMetaState(), n);
    }
    
    public static boolean hasNoModifiers(final KeyEvent keyEvent) {
        return KeyEventCompat.IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
    
    public static boolean isCtrlPressed(final KeyEvent keyEvent) {
        return KeyEventCompat.IMPL.isCtrlPressed(keyEvent);
    }
    
    public static boolean isTracking(final KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }
    
    public static boolean metaStateHasModifiers(final int n, final int n2) {
        return KeyEventCompat.IMPL.metaStateHasModifiers(n, n2);
    }
    
    public static boolean metaStateHasNoModifiers(final int n) {
        return KeyEventCompat.IMPL.metaStateHasNoModifiers(n);
    }
    
    public static int normalizeMetaState(final int n) {
        return KeyEventCompat.IMPL.normalizeMetaState(n);
    }
    
    public static void startTracking(final KeyEvent keyEvent) {
        keyEvent.startTracking();
    }
}
