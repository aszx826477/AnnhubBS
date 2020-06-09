// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.app.ActionBar$Tab;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter extends BaseAdapter
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    ScrollingTabContainerView$TabAdapter(final ScrollingTabContainerView this$0) {
        this.this$0 = this$0;
    }
    
    public int getCount() {
        return this.this$0.mTabLayout.getChildCount();
    }
    
    public Object getItem(final int n) {
        return ((ScrollingTabContainerView$TabView)this.this$0.mTabLayout.getChildAt(n)).getTab();
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, View tabView, final ViewGroup viewGroup) {
        if (tabView == null) {
            tabView = (View)this.this$0.createTabView((ActionBar$Tab)this.getItem(n), true);
        }
        else {
            ((ScrollingTabContainerView$TabView)tabView).bindTab((ActionBar$Tab)this.getItem(n));
        }
        return tabView;
    }
}
