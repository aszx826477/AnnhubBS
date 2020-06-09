// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.os.Build$VERSION;

public final class TextViewCompat
{
    static final TextViewCompat$TextViewCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = new TextViewCompat$Api23TextViewCompatImpl();
        }
        else if (sdk_INT >= 18) {
            IMPL = new TextViewCompat$JbMr2TextViewCompatImpl();
        }
        else if (sdk_INT >= 17) {
            IMPL = new TextViewCompat$JbMr1TextViewCompatImpl();
        }
        else if (sdk_INT >= 16) {
            IMPL = new TextViewCompat$JbTextViewCompatImpl();
        }
        else {
            IMPL = new TextViewCompat$BaseTextViewCompatImpl();
        }
    }
    
    public static Drawable[] getCompoundDrawablesRelative(final TextView textView) {
        return TextViewCompat.IMPL.getCompoundDrawablesRelative(textView);
    }
    
    public static int getMaxLines(final TextView textView) {
        return TextViewCompat.IMPL.getMaxLines(textView);
    }
    
    public static int getMinLines(final TextView textView) {
        return TextViewCompat.IMPL.getMinLines(textView);
    }
    
    public static void setCompoundDrawablesRelative(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        TextViewCompat.IMPL.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final int n, final int n2, final int n3, final int n4) {
        TextViewCompat.IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, n, n2, n3, n4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        TextViewCompat.IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void setTextAppearance(final TextView textView, final int n) {
        TextViewCompat.IMPL.setTextAppearance(textView, n);
    }
}
