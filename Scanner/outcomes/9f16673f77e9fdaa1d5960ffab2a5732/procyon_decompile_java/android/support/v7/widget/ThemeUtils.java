// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.graphics.ColorUtils;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.content.Context;
import android.content.res.ColorStateList;

class ThemeUtils
{
    static final int[] ACTIVATED_STATE_SET;
    static final int[] CHECKED_STATE_SET;
    static final int[] DISABLED_STATE_SET;
    static final int[] EMPTY_STATE_SET;
    static final int[] FOCUSED_STATE_SET;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
    static final int[] PRESSED_STATE_SET;
    static final int[] SELECTED_STATE_SET;
    private static final int[] TEMP_ARRAY;
    private static final ThreadLocal TL_TYPED_VALUE;
    
    static {
        TL_TYPED_VALUE = new ThreadLocal();
        final int n = 1;
        final int[] disabled_STATE_SET = new int[n];
        disabled_STATE_SET[0] = -16842910;
        DISABLED_STATE_SET = disabled_STATE_SET;
        final int[] focused_STATE_SET = new int[n];
        focused_STATE_SET[0] = 16842908;
        FOCUSED_STATE_SET = focused_STATE_SET;
        final int[] activated_STATE_SET = new int[n];
        activated_STATE_SET[0] = 16843518;
        ACTIVATED_STATE_SET = activated_STATE_SET;
        final int[] pressed_STATE_SET = new int[n];
        pressed_STATE_SET[0] = 16842919;
        PRESSED_STATE_SET = pressed_STATE_SET;
        final int[] checked_STATE_SET = new int[n];
        checked_STATE_SET[0] = 16842912;
        CHECKED_STATE_SET = checked_STATE_SET;
        final int[] selected_STATE_SET = new int[n];
        selected_STATE_SET[0] = 16842913;
        SELECTED_STATE_SET = selected_STATE_SET;
        final int[] array;
        final int[] not_PRESSED_OR_FOCUSED_STATE_SET = array = new int[2];
        array[0] = -16842919;
        array[1] = -16842908;
        NOT_PRESSED_OR_FOCUSED_STATE_SET = not_PRESSED_OR_FOCUSED_STATE_SET;
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[n];
    }
    
    public static ColorStateList createDisabledStateList(final int n, final int n2) {
        final int n3 = 2;
        final int[][] array = new int[n3][];
        final int[] array2 = new int[n3];
        array[0] = ThemeUtils.DISABLED_STATE_SET;
        array2[0] = n2;
        final int n4 = 0 + 1;
        array[n4] = ThemeUtils.EMPTY_STATE_SET;
        array2[n4] = n;
        return new ColorStateList(array, array2);
    }
    
    public static int getDisabledThemeAttrColor(final Context context, final int n) {
        final ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, n);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(ThemeUtils.DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        final TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return getThemeAttrColor(context, n, typedValue.getFloat());
    }
    
    public static int getThemeAttrColor(final Context context, final int n) {
        final int[] temp_ARRAY = ThemeUtils.TEMP_ARRAY;
        temp_ARRAY[0] = n;
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, temp_ARRAY);
        final int n2 = 0;
        try {
            return obtainStyledAttributes.getColor(n2, 0);
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    static int getThemeAttrColor(final Context context, final int n, final float n2) {
        final int themeAttrColor = getThemeAttrColor(context, n);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(Color.alpha(themeAttrColor) * n2));
    }
    
    public static ColorStateList getThemeAttrColorStateList(final Context context, final int n) {
        final int[] temp_ARRAY = ThemeUtils.TEMP_ARRAY;
        temp_ARRAY[0] = n;
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, temp_ARRAY);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    private static TypedValue getTypedValue() {
        TypedValue typedValue = ThemeUtils.TL_TYPED_VALUE.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            ThemeUtils.TL_TYPED_VALUE.set(typedValue);
        }
        return typedValue;
    }
}
