// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompatJbMr1
{
    public static Drawable[] getCompoundDrawablesRelative(final TextView textView) {
        final int layoutDirection = textView.getLayoutDirection();
        int n = 1;
        if (layoutDirection != n) {
            n = 0;
        }
        final Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (n != 0) {
            final int n2 = 2;
            final Drawable drawable = compoundDrawables[n2];
            final Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[n2] = drawable2;
        }
        return compoundDrawables;
    }
    
    public static void setCompoundDrawablesRelative(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        final int layoutDirection = textView.getLayoutDirection();
        int n = 1;
        if (layoutDirection != n) {
            n = 0;
        }
        final int n2 = n;
        Drawable drawable5;
        if (n != 0) {
            drawable5 = drawable3;
        }
        else {
            drawable5 = drawable;
        }
        Drawable drawable6;
        if (n2 != 0) {
            drawable6 = drawable;
        }
        else {
            drawable6 = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable6, drawable4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final int n, final int n2, final int n3, final int n4) {
        final int layoutDirection = textView.getLayoutDirection();
        int n5 = 1;
        if (layoutDirection != n5) {
            n5 = 0;
        }
        final int n6 = n5;
        int n7;
        if (n5 != 0) {
            n7 = n3;
        }
        else {
            n7 = n;
        }
        int n8;
        if (n6 != 0) {
            n8 = n;
        }
        else {
            n8 = n3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(n7, n2, n8, n4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        final int layoutDirection = textView.getLayoutDirection();
        int n = 1;
        if (layoutDirection != n) {
            n = 0;
        }
        final int n2 = n;
        Drawable drawable5;
        if (n != 0) {
            drawable5 = drawable3;
        }
        else {
            drawable5 = drawable;
        }
        Drawable drawable6;
        if (n2 != 0) {
            drawable6 = drawable;
        }
        else {
            drawable6 = drawable3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
    }
}
