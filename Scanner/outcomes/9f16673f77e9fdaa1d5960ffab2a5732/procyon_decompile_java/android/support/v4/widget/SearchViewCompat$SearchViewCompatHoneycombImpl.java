// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

class SearchViewCompat$SearchViewCompatHoneycombImpl extends SearchViewCompat$SearchViewCompatStubImpl
{
    protected void checkIfLegalArg(final View view) {
        SearchViewCompatHoneycomb.checkIfLegalArg(view);
    }
    
    public CharSequence getQuery(final View view) {
        this.checkIfLegalArg(view);
        return SearchViewCompatHoneycomb.getQuery(view);
    }
    
    public boolean isIconified(final View view) {
        this.checkIfLegalArg(view);
        return SearchViewCompatHoneycomb.isIconified(view);
    }
    
    public boolean isQueryRefinementEnabled(final View view) {
        this.checkIfLegalArg(view);
        return SearchViewCompatHoneycomb.isQueryRefinementEnabled(view);
    }
    
    public boolean isSubmitButtonEnabled(final View view) {
        this.checkIfLegalArg(view);
        return SearchViewCompatHoneycomb.isSubmitButtonEnabled(view);
    }
    
    public Object newOnCloseListener(final SearchViewCompat$OnCloseListener searchViewCompat$OnCloseListener) {
        return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompat$SearchViewCompatHoneycombImpl$2(this, searchViewCompat$OnCloseListener));
    }
    
    public Object newOnQueryTextListener(final SearchViewCompat$OnQueryTextListener searchViewCompat$OnQueryTextListener) {
        return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompat$SearchViewCompatHoneycombImpl$1(this, searchViewCompat$OnQueryTextListener));
    }
    
    public View newSearchView(final Context context) {
        return SearchViewCompatHoneycomb.newSearchView(context);
    }
    
    public void setIconified(final View view, final boolean b) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setIconified(view, b);
    }
    
    public void setMaxWidth(final View view, final int n) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setMaxWidth(view, n);
    }
    
    public void setOnCloseListener(final View view, final SearchViewCompat$OnCloseListener searchViewCompat$OnCloseListener) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setOnCloseListener(view, this.newOnCloseListener(searchViewCompat$OnCloseListener));
    }
    
    public void setOnQueryTextListener(final View view, final SearchViewCompat$OnQueryTextListener searchViewCompat$OnQueryTextListener) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setOnQueryTextListener(view, this.newOnQueryTextListener(searchViewCompat$OnQueryTextListener));
    }
    
    public void setQuery(final View view, final CharSequence charSequence, final boolean b) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setQuery(view, charSequence, b);
    }
    
    public void setQueryHint(final View view, final CharSequence charSequence) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setQueryHint(view, charSequence);
    }
    
    public void setQueryRefinementEnabled(final View view, final boolean b) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setQueryRefinementEnabled(view, b);
    }
    
    public void setSearchableInfo(final View view, final ComponentName componentName) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setSearchableInfo(view, componentName);
    }
    
    public void setSubmitButtonEnabled(final View view, final boolean b) {
        this.checkIfLegalArg(view);
        SearchViewCompatHoneycomb.setSubmitButtonEnabled(view, b);
    }
}
