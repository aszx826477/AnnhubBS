// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.View;
import android.content.Context;
import android.widget.TabHost$TabContentFactory;

class FragmentTabHost$DummyTabFactory implements TabHost$TabContentFactory
{
    private final Context mContext;
    
    public FragmentTabHost$DummyTabFactory(final Context mContext) {
        this.mContext = mContext;
    }
    
    public View createTabContent(final String s) {
        final View view = new View(this.mContext);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
