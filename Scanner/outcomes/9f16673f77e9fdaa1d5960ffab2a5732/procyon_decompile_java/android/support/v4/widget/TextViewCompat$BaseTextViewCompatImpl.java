// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompat$BaseTextViewCompatImpl implements TextViewCompat$TextViewCompatImpl
{
    public Drawable[] getCompoundDrawablesRelative(final TextView textView) {
        return TextViewCompatGingerbread.getCompoundDrawablesRelative(textView);
    }
    
    public int getMaxLines(final TextView textView) {
        return TextViewCompatGingerbread.getMaxLines(textView);
    }
    
    public int getMinLines(final TextView textView) {
        return TextViewCompatGingerbread.getMinLines(textView);
    }
    
    public void setCompoundDrawablesRelative(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final int n, final int n2, final int n3, final int n4) {
        textView.setCompoundDrawablesWithIntrinsicBounds(n, n2, n3, n4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
    
    public void setTextAppearance(final TextView textView, final int n) {
        TextViewCompatGingerbread.setTextAppearance(textView, n);
    }
}
