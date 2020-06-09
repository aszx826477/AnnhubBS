// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

interface SearchViewCompat$SearchViewCompatImpl
{
    CharSequence getQuery(final View p0);
    
    boolean isIconified(final View p0);
    
    boolean isQueryRefinementEnabled(final View p0);
    
    boolean isSubmitButtonEnabled(final View p0);
    
    Object newOnCloseListener(final SearchViewCompat$OnCloseListener p0);
    
    Object newOnQueryTextListener(final SearchViewCompat$OnQueryTextListener p0);
    
    View newSearchView(final Context p0);
    
    void setIconified(final View p0, final boolean p1);
    
    void setImeOptions(final View p0, final int p1);
    
    void setInputType(final View p0, final int p1);
    
    void setMaxWidth(final View p0, final int p1);
    
    void setOnCloseListener(final View p0, final SearchViewCompat$OnCloseListener p1);
    
    void setOnQueryTextListener(final View p0, final SearchViewCompat$OnQueryTextListener p1);
    
    void setQuery(final View p0, final CharSequence p1, final boolean p2);
    
    void setQueryHint(final View p0, final CharSequence p1);
    
    void setQueryRefinementEnabled(final View p0, final boolean p1);
    
    void setSearchableInfo(final View p0, final ComponentName p1);
    
    void setSubmitButtonEnabled(final View p0, final boolean p1);
}
