// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.os.Build$VERSION;

public final class CompoundButtonCompat
{
    private static final CompoundButtonCompat$CompoundButtonCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = new CompoundButtonCompat$Api23CompoundButtonImpl();
        }
        else if (sdk_INT >= 21) {
            IMPL = new CompoundButtonCompat$LollipopCompoundButtonImpl();
        }
        else {
            IMPL = new CompoundButtonCompat$BaseCompoundButtonCompat();
        }
    }
    
    public static Drawable getButtonDrawable(final CompoundButton compoundButton) {
        return CompoundButtonCompat.IMPL.getButtonDrawable(compoundButton);
    }
    
    public static ColorStateList getButtonTintList(final CompoundButton compoundButton) {
        return CompoundButtonCompat.IMPL.getButtonTintList(compoundButton);
    }
    
    public static PorterDuff$Mode getButtonTintMode(final CompoundButton compoundButton) {
        return CompoundButtonCompat.IMPL.getButtonTintMode(compoundButton);
    }
    
    public static void setButtonTintList(final CompoundButton compoundButton, final ColorStateList list) {
        CompoundButtonCompat.IMPL.setButtonTintList(compoundButton, list);
    }
    
    public static void setButtonTintMode(final CompoundButton compoundButton, final PorterDuff$Mode porterDuff$Mode) {
        CompoundButtonCompat.IMPL.setButtonTintMode(compoundButton, porterDuff$Mode);
    }
}
