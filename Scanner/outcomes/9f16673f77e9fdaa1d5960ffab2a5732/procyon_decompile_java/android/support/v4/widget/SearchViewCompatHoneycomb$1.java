// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.widget.SearchView$OnQueryTextListener;

final class SearchViewCompatHoneycomb$1 implements SearchView$OnQueryTextListener
{
    final /* synthetic */ SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge val$listener;
    
    SearchViewCompatHoneycomb$1(final SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge val$listener) {
        this.val$listener = val$listener;
    }
    
    public boolean onQueryTextChange(final String s) {
        return this.val$listener.onQueryTextChange(s);
    }
    
    public boolean onQueryTextSubmit(final String s) {
        return this.val$listener.onQueryTextSubmit(s);
    }
}
