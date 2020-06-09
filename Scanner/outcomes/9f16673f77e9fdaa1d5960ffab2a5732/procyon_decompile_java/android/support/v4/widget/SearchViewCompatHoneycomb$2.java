// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.widget.SearchView$OnCloseListener;

final class SearchViewCompatHoneycomb$2 implements SearchView$OnCloseListener
{
    final /* synthetic */ SearchViewCompatHoneycomb$OnCloseListenerCompatBridge val$listener;
    
    SearchViewCompatHoneycomb$2(final SearchViewCompatHoneycomb$OnCloseListenerCompatBridge val$listener) {
        this.val$listener = val$listener;
    }
    
    public boolean onClose() {
        return this.val$listener.onClose();
    }
}
