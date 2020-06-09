// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.database.DataSetObserver;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ThemedSpinnerAdapter;
import android.os.Build$VERSION;
import android.content.res.Resources$Theme;
import android.widget.SpinnerAdapter;
import android.widget.ListAdapter;

class AppCompatSpinner$DropDownAdapter implements ListAdapter, SpinnerAdapter
{
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public AppCompatSpinner$DropDownAdapter(final SpinnerAdapter mAdapter, final Resources$Theme resources$Theme) {
        this.mAdapter = mAdapter;
        if (mAdapter instanceof ListAdapter) {
            this.mListAdapter = (ListAdapter)mAdapter;
        }
        if (resources$Theme != null) {
            if (Build$VERSION.SDK_INT >= 23 && mAdapter instanceof ThemedSpinnerAdapter) {
                final ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter)mAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != resources$Theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(resources$Theme);
                }
            }
            else if (mAdapter instanceof android.support.v7.widget.ThemedSpinnerAdapter) {
                final android.support.v7.widget.ThemedSpinnerAdapter themedSpinnerAdapter2 = (android.support.v7.widget.ThemedSpinnerAdapter)mAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(resources$Theme);
                }
            }
        }
    }
    
    public boolean areAllItemsEnabled() {
        final ListAdapter mListAdapter = this.mListAdapter;
        return mListAdapter == null || mListAdapter.areAllItemsEnabled();
    }
    
    public int getCount() {
        final SpinnerAdapter mAdapter = this.mAdapter;
        int count;
        if (mAdapter == null) {
            count = 0;
        }
        else {
            count = mAdapter.getCount();
        }
        return count;
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        final SpinnerAdapter mAdapter = this.mAdapter;
        View dropDownView;
        if (mAdapter == null) {
            dropDownView = null;
        }
        else {
            dropDownView = mAdapter.getDropDownView(n, view, viewGroup);
        }
        return dropDownView;
    }
    
    public Object getItem(final int n) {
        final SpinnerAdapter mAdapter = this.mAdapter;
        Object item;
        if (mAdapter == null) {
            item = null;
        }
        else {
            item = mAdapter.getItem(n);
        }
        return item;
    }
    
    public long getItemId(final int n) {
        final SpinnerAdapter mAdapter = this.mAdapter;
        long itemId;
        if (mAdapter == null) {
            itemId = -1;
        }
        else {
            itemId = mAdapter.getItemId(n);
        }
        return itemId;
    }
    
    public int getItemViewType(final int n) {
        return 0;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        return this.getDropDownView(n, view, viewGroup);
    }
    
    public int getViewTypeCount() {
        return 1;
    }
    
    public boolean hasStableIds() {
        final SpinnerAdapter mAdapter = this.mAdapter;
        return mAdapter != null && mAdapter.hasStableIds();
    }
    
    public boolean isEmpty() {
        return this.getCount() == 0;
    }
    
    public boolean isEnabled(final int n) {
        final ListAdapter mListAdapter = this.mListAdapter;
        return mListAdapter == null || mListAdapter.isEnabled(n);
    }
    
    public void registerDataSetObserver(final DataSetObserver dataSetObserver) {
        final SpinnerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            mAdapter.registerDataSetObserver(dataSetObserver);
        }
    }
    
    public void unregisterDataSetObserver(final DataSetObserver dataSetObserver) {
        final SpinnerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
