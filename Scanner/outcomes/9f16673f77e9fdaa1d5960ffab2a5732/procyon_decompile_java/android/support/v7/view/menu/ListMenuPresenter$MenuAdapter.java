// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.ViewGroup;
import android.view.View;
import java.util.ArrayList;
import android.widget.BaseAdapter;

class ListMenuPresenter$MenuAdapter extends BaseAdapter
{
    private int mExpandedIndex;
    final /* synthetic */ ListMenuPresenter this$0;
    
    public ListMenuPresenter$MenuAdapter(final ListMenuPresenter this$0) {
        this.this$0 = this$0;
        this.mExpandedIndex = -1;
        this.findExpandedIndex();
    }
    
    void findExpandedIndex() {
        final MenuItemImpl expandedItem = this.this$0.mMenu.getExpandedItem();
        if (expandedItem != null) {
            final ArrayList nonActionItems = this.this$0.mMenu.getNonActionItems();
            for (int size = nonActionItems.size(), i = 0; i < size; ++i) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.mExpandedIndex = i;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }
    
    public int getCount() {
        final int n = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
        if (this.mExpandedIndex < 0) {
            return n;
        }
        return n - 1;
    }
    
    public MenuItemImpl getItem(int n) {
        final ArrayList nonActionItems = this.this$0.mMenu.getNonActionItems();
        n += this.this$0.mItemIndexOffset;
        final int mExpandedIndex = this.mExpandedIndex;
        if (mExpandedIndex >= 0 && n >= mExpandedIndex) {
            ++n;
        }
        return nonActionItems.get(n);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, View inflate, final ViewGroup viewGroup) {
        if (inflate == null) {
            inflate = this.this$0.mInflater.inflate(this.this$0.mItemLayoutRes, viewGroup, false);
        }
        ((MenuView$ItemView)inflate).initialize(this.getItem(n), 0);
        return inflate;
    }
    
    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }
}
