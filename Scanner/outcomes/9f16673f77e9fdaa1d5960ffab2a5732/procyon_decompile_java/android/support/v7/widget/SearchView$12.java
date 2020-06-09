// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class SearchView$12 implements TextWatcher
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$12(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void afterTextChanged(final Editable editable) {
    }
    
    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
    
    public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        this.this$0.onTextChanged(charSequence);
    }
}
