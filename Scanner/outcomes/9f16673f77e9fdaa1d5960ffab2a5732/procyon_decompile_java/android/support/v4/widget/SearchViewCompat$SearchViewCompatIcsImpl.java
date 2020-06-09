// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;
import android.content.Context;

class SearchViewCompat$SearchViewCompatIcsImpl extends SearchViewCompat$SearchViewCompatHoneycombImpl
{
    public View newSearchView(final Context context) {
        return SearchViewCompatIcs.newSearchView(context);
    }
    
    public void setImeOptions(final View view, final int n) {
        this.checkIfLegalArg(view);
        SearchViewCompatIcs.setImeOptions(view, n);
    }
    
    public void setInputType(final View view, final int n) {
        this.checkIfLegalArg(view);
        SearchViewCompatIcs.setInputType(view, n);
    }
}
