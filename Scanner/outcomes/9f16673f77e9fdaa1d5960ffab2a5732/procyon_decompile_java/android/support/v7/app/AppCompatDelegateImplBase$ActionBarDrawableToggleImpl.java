// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.util.AttributeSet;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.appcompat.R$attr;
import android.graphics.drawable.Drawable;
import android.content.Context;

class AppCompatDelegateImplBase$ActionBarDrawableToggleImpl implements ActionBarDrawerToggle$Delegate
{
    final /* synthetic */ AppCompatDelegateImplBase this$0;
    
    AppCompatDelegateImplBase$ActionBarDrawableToggleImpl(final AppCompatDelegateImplBase this$0) {
        this.this$0 = this$0;
    }
    
    public Context getActionBarThemedContext() {
        return this.this$0.getActionBarThemedContext();
    }
    
    public Drawable getThemeUpIndicator() {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), null, new int[] { R$attr.homeAsUpIndicator });
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    public boolean isNavigationVisible() {
        final ActionBar supportActionBar = this.this$0.getSupportActionBar();
        return supportActionBar != null && (supportActionBar.getDisplayOptions() & 0x4) != 0x0;
    }
    
    public void setActionBarDescription(final int homeActionContentDescription) {
        final ActionBar supportActionBar = this.this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
    
    public void setActionBarUpIndicator(final Drawable homeAsUpIndicator, final int homeActionContentDescription) {
        final ActionBar supportActionBar = this.this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(homeAsUpIndicator);
            supportActionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
}
