// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.app.FragmentTransaction;

public interface ActionBar$TabListener
{
    void onTabReselected(final ActionBar$Tab p0, final FragmentTransaction p1);
    
    void onTabSelected(final ActionBar$Tab p0, final FragmentTransaction p1);
    
    void onTabUnselected(final ActionBar$Tab p0, final FragmentTransaction p1);
}
