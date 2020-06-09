// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$2 implements SearchViewCompatHoneycomb$OnCloseListenerCompatBridge
{
    final /* synthetic */ SearchViewCompat$SearchViewCompatHoneycombImpl this$0;
    final /* synthetic */ SearchViewCompat$OnCloseListener val$listener;
    
    SearchViewCompat$SearchViewCompatHoneycombImpl$2(final SearchViewCompat$SearchViewCompatHoneycombImpl this$0, final SearchViewCompat$OnCloseListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public boolean onClose() {
        return this.val$listener.onClose();
    }
}
