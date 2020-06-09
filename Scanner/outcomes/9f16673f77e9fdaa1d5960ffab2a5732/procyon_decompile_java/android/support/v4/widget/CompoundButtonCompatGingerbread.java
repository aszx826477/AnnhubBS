// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class CompoundButtonCompatGingerbread
{
    private static final String TAG = "CompoundButtonCompatGingerbread";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;
    
    static Drawable getButtonDrawable(final CompoundButton compoundButton) {
        if (!CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched) {
            final boolean b = true;
            final Class<CompoundButton> clazz = CompoundButton.class;
            final String s = "mButtonDrawable";
            final Class<CompoundButton> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (CompoundButtonCompatGingerbread.sButtonDrawableField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {
                    Log.i("CompoundButtonCompatGingerbread", "Failed to retrieve mButtonDrawable field", (Throwable)ex);
                }
            }
            catch (NoSuchFieldException ex3) {}
            CompoundButtonCompatGingerbread.sButtonDrawableFieldFetched = b;
        }
        final Field sButtonDrawableField = CompoundButtonCompatGingerbread.sButtonDrawableField;
        if (sButtonDrawableField != null) {
            final Field field = sButtonDrawableField;
            try {
                final Object value = field.get(compoundButton);
                try {
                    return (Drawable)value;
                }
                catch (IllegalAccessException ex2) {
                    Log.i("CompoundButtonCompatGingerbread", "Failed to get button drawable via reflection", (Throwable)ex2);
                    CompoundButtonCompatGingerbread.sButtonDrawableField = null;
                }
            }
            catch (IllegalAccessException ex4) {}
        }
        return null;
    }
    
    static ColorStateList getButtonTintList(final CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton)compoundButton).getSupportButtonTintList();
        }
        return null;
    }
    
    static PorterDuff$Mode getButtonTintMode(final CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton)compoundButton).getSupportButtonTintMode();
        }
        return null;
    }
    
    static void setButtonTintList(final CompoundButton compoundButton, final ColorStateList supportButtonTintList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton)compoundButton).setSupportButtonTintList(supportButtonTintList);
        }
    }
    
    static void setButtonTintMode(final CompoundButton compoundButton, final PorterDuff$Mode supportButtonTintMode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton)compoundButton).setSupportButtonTintMode(supportButtonTintMode);
        }
    }
}
