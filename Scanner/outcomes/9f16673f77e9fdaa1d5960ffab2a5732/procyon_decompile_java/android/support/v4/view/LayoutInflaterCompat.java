// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.LayoutInflater;
import android.os.Build$VERSION;

public final class LayoutInflaterCompat
{
    static final LayoutInflaterCompat$LayoutInflaterCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplV21();
        }
        else if (sdk_INT >= 11) {
            IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplV11();
        }
        else {
            IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplBase();
        }
    }
    
    public static LayoutInflaterFactory getFactory(final LayoutInflater layoutInflater) {
        return LayoutInflaterCompat.IMPL.getFactory(layoutInflater);
    }
    
    public static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        LayoutInflaterCompat.IMPL.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
