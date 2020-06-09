// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompat$JbMr2TextViewCompatImpl extends TextViewCompat$JbMr1TextViewCompatImpl
{
    public Drawable[] getCompoundDrawablesRelative(final TextView textView) {
        return TextViewCompatJbMr2.getCompoundDrawablesRelative(textView);
    }
    
    public void setCompoundDrawablesRelative(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        TextViewCompatJbMr2.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final int n, final int n2, final int n3, final int n4) {
        TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, n, n2, n3, n4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }
}
