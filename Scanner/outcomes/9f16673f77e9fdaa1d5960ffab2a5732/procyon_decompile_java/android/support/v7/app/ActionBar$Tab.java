// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.view.View;

public abstract class ActionBar$Tab
{
    public static final int INVALID_POSITION = 255;
    
    public abstract CharSequence getContentDescription();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract int getPosition();
    
    public abstract Object getTag();
    
    public abstract CharSequence getText();
    
    public abstract void select();
    
    public abstract ActionBar$Tab setContentDescription(final int p0);
    
    public abstract ActionBar$Tab setContentDescription(final CharSequence p0);
    
    public abstract ActionBar$Tab setCustomView(final int p0);
    
    public abstract ActionBar$Tab setCustomView(final View p0);
    
    public abstract ActionBar$Tab setIcon(final int p0);
    
    public abstract ActionBar$Tab setIcon(final Drawable p0);
    
    public abstract ActionBar$Tab setTabListener(final ActionBar$TabListener p0);
    
    public abstract ActionBar$Tab setTag(final Object p0);
    
    public abstract ActionBar$Tab setText(final int p0);
    
    public abstract ActionBar$Tab setText(final CharSequence p0);
}
