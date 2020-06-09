// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.view.View$OnClickListener;

class SearchView$7 implements View$OnClickListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$7(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        if (view == this.this$0.mSearchButton) {
            this.this$0.onSearchClicked();
        }
        else if (view == this.this$0.mCloseButton) {
            this.this$0.onCloseClicked();
        }
        else if (view == this.this$0.mGoButton) {
            this.this$0.onSubmitQuery();
        }
        else if (view == this.this$0.mVoiceButton) {
            this.this$0.onVoiceClicked();
        }
        else if (view == this.this$0.mSearchSrcTextView) {
            this.this$0.forceSuggestionQuery();
        }
    }
}
