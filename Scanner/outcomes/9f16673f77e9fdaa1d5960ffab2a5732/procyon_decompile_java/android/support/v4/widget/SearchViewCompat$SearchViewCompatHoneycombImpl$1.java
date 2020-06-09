// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$1 implements SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge
{
    final /* synthetic */ SearchViewCompat$SearchViewCompatHoneycombImpl this$0;
    final /* synthetic */ SearchViewCompat$OnQueryTextListener val$listener;
    
    SearchViewCompat$SearchViewCompatHoneycombImpl$1(final SearchViewCompat$SearchViewCompatHoneycombImpl this$0, final SearchViewCompat$OnQueryTextListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public boolean onQueryTextChange(final String s) {
        return this.val$listener.onQueryTextChange(s);
    }
    
    public boolean onQueryTextSubmit(final String s) {
        return this.val$listener.onQueryTextSubmit(s);
    }
}
