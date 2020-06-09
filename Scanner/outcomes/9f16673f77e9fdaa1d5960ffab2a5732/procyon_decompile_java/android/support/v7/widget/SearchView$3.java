// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.database.Cursor;

class SearchView$3 implements Runnable
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$3(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        if (this.this$0.mSuggestionsAdapter != null && this.this$0.mSuggestionsAdapter instanceof SuggestionsAdapter) {
            this.this$0.mSuggestionsAdapter.changeCursor(null);
        }
    }
}
