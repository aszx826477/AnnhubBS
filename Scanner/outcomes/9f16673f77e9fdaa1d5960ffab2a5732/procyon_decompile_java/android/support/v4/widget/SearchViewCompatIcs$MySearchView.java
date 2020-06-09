// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class SearchViewCompatIcs$MySearchView extends SearchView
{
    public SearchViewCompatIcs$MySearchView(final Context context) {
        super(context);
    }
    
    public void onActionViewCollapsed() {
        this.setQuery((CharSequence)"", false);
        super.onActionViewCollapsed();
    }
}
