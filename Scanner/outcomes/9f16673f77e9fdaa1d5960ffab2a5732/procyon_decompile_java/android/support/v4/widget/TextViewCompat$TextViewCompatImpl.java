// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

interface TextViewCompat$TextViewCompatImpl
{
    Drawable[] getCompoundDrawablesRelative(final TextView p0);
    
    int getMaxLines(final TextView p0);
    
    int getMinLines(final TextView p0);
    
    void setCompoundDrawablesRelative(final TextView p0, final Drawable p1, final Drawable p2, final Drawable p3, final Drawable p4);
    
    void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView p0, final int p1, final int p2, final int p3, final int p4);
    
    void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView p0, final Drawable p1, final Drawable p2, final Drawable p3, final Drawable p4);
    
    void setTextAppearance(final TextView p0, final int p1);
}
