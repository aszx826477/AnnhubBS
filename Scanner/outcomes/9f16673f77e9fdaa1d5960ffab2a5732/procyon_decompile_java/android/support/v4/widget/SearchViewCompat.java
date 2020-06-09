// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.ComponentName;
import android.view.View;
import android.content.Context;
import android.os.Build$VERSION;

public final class SearchViewCompat
{
    private static final SearchViewCompat$SearchViewCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new SearchViewCompat$SearchViewCompatIcsImpl();
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new SearchViewCompat$SearchViewCompatHoneycombImpl();
        }
        else {
            IMPL = new SearchViewCompat$SearchViewCompatStubImpl();
        }
    }
    
    private SearchViewCompat(final Context context) {
    }
    
    public static CharSequence getQuery(final View view) {
        return SearchViewCompat.IMPL.getQuery(view);
    }
    
    public static boolean isIconified(final View view) {
        return SearchViewCompat.IMPL.isIconified(view);
    }
    
    public static boolean isQueryRefinementEnabled(final View view) {
        return SearchViewCompat.IMPL.isQueryRefinementEnabled(view);
    }
    
    public static boolean isSubmitButtonEnabled(final View view) {
        return SearchViewCompat.IMPL.isSubmitButtonEnabled(view);
    }
    
    public static View newSearchView(final Context context) {
        return SearchViewCompat.IMPL.newSearchView(context);
    }
    
    public static void setIconified(final View view, final boolean b) {
        SearchViewCompat.IMPL.setIconified(view, b);
    }
    
    public static void setImeOptions(final View view, final int n) {
        SearchViewCompat.IMPL.setImeOptions(view, n);
    }
    
    public static void setInputType(final View view, final int n) {
        SearchViewCompat.IMPL.setInputType(view, n);
    }
    
    public static void setMaxWidth(final View view, final int n) {
        SearchViewCompat.IMPL.setMaxWidth(view, n);
    }
    
    public static void setOnCloseListener(final View view, final SearchViewCompat$OnCloseListener searchViewCompat$OnCloseListener) {
        SearchViewCompat.IMPL.setOnCloseListener(view, searchViewCompat$OnCloseListener);
    }
    
    public static void setOnQueryTextListener(final View view, final SearchViewCompat$OnQueryTextListener searchViewCompat$OnQueryTextListener) {
        SearchViewCompat.IMPL.setOnQueryTextListener(view, searchViewCompat$OnQueryTextListener);
    }
    
    public static void setQuery(final View view, final CharSequence charSequence, final boolean b) {
        SearchViewCompat.IMPL.setQuery(view, charSequence, b);
    }
    
    public static void setQueryHint(final View view, final CharSequence charSequence) {
        SearchViewCompat.IMPL.setQueryHint(view, charSequence);
    }
    
    public static void setQueryRefinementEnabled(final View view, final boolean b) {
        SearchViewCompat.IMPL.setQueryRefinementEnabled(view, b);
    }
    
    public static void setSearchableInfo(final View view, final ComponentName componentName) {
        SearchViewCompat.IMPL.setSearchableInfo(view, componentName);
    }
    
    public static void setSubmitButtonEnabled(final View view, final boolean b) {
        SearchViewCompat.IMPL.setSubmitButtonEnabled(view, b);
    }
}
