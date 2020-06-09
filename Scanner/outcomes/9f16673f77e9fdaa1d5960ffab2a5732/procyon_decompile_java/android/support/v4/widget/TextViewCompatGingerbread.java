// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.util.Log;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.lang.reflect.Field;

class TextViewCompatGingerbread
{
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompatGingerbread";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;
    
    static Drawable[] getCompoundDrawablesRelative(final TextView textView) {
        return textView.getCompoundDrawables();
    }
    
    static int getMaxLines(final TextView textView) {
        final boolean sMaxModeFieldFetched = TextViewCompatGingerbread.sMaxModeFieldFetched;
        final boolean b = true;
        if (!sMaxModeFieldFetched) {
            TextViewCompatGingerbread.sMaxModeField = retrieveField("mMaxMode");
            TextViewCompatGingerbread.sMaxModeFieldFetched = b;
        }
        final Field sMaxModeField = TextViewCompatGingerbread.sMaxModeField;
        if (sMaxModeField != null && retrieveIntFromField(sMaxModeField, textView) == (b ? 1 : 0)) {
            if (!TextViewCompatGingerbread.sMaximumFieldFetched) {
                TextViewCompatGingerbread.sMaximumField = retrieveField("mMaximum");
                TextViewCompatGingerbread.sMaximumFieldFetched = b;
            }
            final Field sMaximumField = TextViewCompatGingerbread.sMaximumField;
            if (sMaximumField != null) {
                return retrieveIntFromField(sMaximumField, textView);
            }
        }
        return -1;
    }
    
    static int getMinLines(final TextView textView) {
        final boolean sMinModeFieldFetched = TextViewCompatGingerbread.sMinModeFieldFetched;
        final boolean b = true;
        if (!sMinModeFieldFetched) {
            TextViewCompatGingerbread.sMinModeField = retrieveField("mMinMode");
            TextViewCompatGingerbread.sMinModeFieldFetched = b;
        }
        final Field sMinModeField = TextViewCompatGingerbread.sMinModeField;
        if (sMinModeField != null && retrieveIntFromField(sMinModeField, textView) == (b ? 1 : 0)) {
            if (!TextViewCompatGingerbread.sMinimumFieldFetched) {
                TextViewCompatGingerbread.sMinimumField = retrieveField("mMinimum");
                TextViewCompatGingerbread.sMinimumFieldFetched = b;
            }
            final Field sMinimumField = TextViewCompatGingerbread.sMinimumField;
            if (sMinimumField != null) {
                return retrieveIntFromField(sMinimumField, textView);
            }
        }
        return -1;
    }
    
    private static Field retrieveField(final String s) {
        Field declaredField = null;
        final Class<TextView> clazz = TextView.class;
        try {
            (declaredField = clazz.getDeclaredField(s)).setAccessible(true);
        }
        catch (NoSuchFieldException ex) {
            final String s2 = "TextViewCompatGingerbread";
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve ");
            sb.append(s);
            sb.append(" field.");
            Log.e(s2, sb.toString());
        }
        return declaredField;
    }
    
    private static int retrieveIntFromField(final Field field, final TextView textView) {
        try {
            return field.getInt(textView);
        }
        catch (IllegalAccessException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            Log.d("TextViewCompatGingerbread", sb.toString());
            return -1;
        }
    }
    
    static void setTextAppearance(final TextView textView, final int n) {
        textView.setTextAppearance(textView.getContext(), n);
    }
}
