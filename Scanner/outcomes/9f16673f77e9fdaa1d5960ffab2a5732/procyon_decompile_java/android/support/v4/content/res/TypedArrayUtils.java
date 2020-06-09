// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content.res;

import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.content.Context;

public class TypedArrayUtils
{
    public static int getAttr(final Context context, final int n, final int n2) {
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        if (typedValue.resourceId != 0) {
            return n;
        }
        return n2;
    }
    
    public static boolean getBoolean(final TypedArray typedArray, final int n, final int n2, final boolean b) {
        return typedArray.getBoolean(n, typedArray.getBoolean(n2, b));
    }
    
    public static Drawable getDrawable(final TypedArray typedArray, final int n, final int n2) {
        Drawable drawable = typedArray.getDrawable(n);
        if (drawable == null) {
            drawable = typedArray.getDrawable(n2);
        }
        return drawable;
    }
    
    public static int getInt(final TypedArray typedArray, final int n, final int n2, final int n3) {
        return typedArray.getInt(n, typedArray.getInt(n2, n3));
    }
    
    public static int getResourceId(final TypedArray typedArray, final int n, final int n2, final int n3) {
        return typedArray.getResourceId(n, typedArray.getResourceId(n2, n3));
    }
    
    public static String getString(final TypedArray typedArray, final int n, final int n2) {
        String s = typedArray.getString(n);
        if (s == null) {
            s = typedArray.getString(n2);
        }
        return s;
    }
    
    public static CharSequence getText(final TypedArray typedArray, final int n, final int n2) {
        CharSequence charSequence = typedArray.getText(n);
        if (charSequence == null) {
            charSequence = typedArray.getText(n2);
        }
        return charSequence;
    }
    
    public static CharSequence[] getTextArray(final TypedArray typedArray, final int n, final int n2) {
        CharSequence[] array = typedArray.getTextArray(n);
        if (array == null) {
            array = typedArray.getTextArray(n2);
        }
        return array;
    }
}
