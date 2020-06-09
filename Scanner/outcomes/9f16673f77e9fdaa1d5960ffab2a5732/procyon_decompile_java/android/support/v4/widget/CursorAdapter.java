// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.database.ContentObserver;
import android.widget.Filter;
import android.view.ViewGroup;
import android.view.View;
import android.widget.FilterQueryProvider;
import android.database.DataSetObserver;
import android.database.Cursor;
import android.content.Context;
import android.widget.Filterable;
import android.widget.BaseAdapter;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter$CursorFilterClient
{
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected CursorAdapter$ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;
    
    public CursorAdapter(final Context context, final Cursor cursor) {
        this.init(context, cursor, 1);
    }
    
    public CursorAdapter(final Context context, final Cursor cursor, final int n) {
        this.init(context, cursor, n);
    }
    
    public CursorAdapter(final Context context, final Cursor cursor, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        this.init(context, cursor, n);
    }
    
    public abstract void bindView(final View p0, final Context p1, final Cursor p2);
    
    public void changeCursor(final Cursor cursor) {
        final Cursor swapCursor = this.swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }
    
    public CharSequence convertToString(final Cursor cursor) {
        String string;
        if (cursor == null) {
            string = "";
        }
        else {
            string = cursor.toString();
        }
        return string;
    }
    
    public int getCount() {
        if (this.mDataValid) {
            final Cursor mCursor = this.mCursor;
            if (mCursor != null) {
                return mCursor.getCount();
            }
        }
        return 0;
    }
    
    public Cursor getCursor() {
        return this.mCursor;
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        if (this.mDataValid) {
            this.mCursor.moveToPosition(n);
            View dropDownView;
            if (view == null) {
                dropDownView = this.newDropDownView(this.mContext, this.mCursor, viewGroup);
            }
            else {
                dropDownView = view;
            }
            this.bindView(dropDownView, this.mContext, this.mCursor);
            return dropDownView;
        }
        return null;
    }
    
    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }
    
    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }
    
    public Object getItem(final int n) {
        if (this.mDataValid) {
            final Cursor mCursor = this.mCursor;
            if (mCursor != null) {
                mCursor.moveToPosition(n);
                return this.mCursor;
            }
        }
        return null;
    }
    
    public long getItemId(final int n) {
        final boolean mDataValid = this.mDataValid;
        final long n2 = 0L;
        if (mDataValid) {
            final Cursor mCursor = this.mCursor;
            if (mCursor != null) {
                if (mCursor.moveToPosition(n)) {
                    return this.mCursor.getLong(this.mRowIDColumn);
                }
                return n2;
            }
        }
        return n2;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.mCursor.moveToPosition(n)) {
            View view2;
            if (view == null) {
                view2 = this.newView(this.mContext, this.mCursor, viewGroup);
            }
            else {
                view2 = view;
            }
            this.bindView(view2, this.mContext, this.mCursor);
            return view2;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("couldn't move cursor to position ");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }
    
    public boolean hasStableIds() {
        return true;
    }
    
    void init(final Context mContext, final Cursor mCursor, int n) {
        final int n2 = n & 0x1;
        boolean mDataValid = false;
        final boolean mAutoRequery = true;
        if (n2 == (mAutoRequery ? 1 : 0)) {
            n |= 0x2;
            this.mAutoRequery = mAutoRequery;
        }
        else {
            this.mAutoRequery = false;
        }
        if (mCursor != null) {
            mDataValid = true;
        }
        final boolean b = mDataValid;
        this.mCursor = mCursor;
        this.mDataValid = mDataValid;
        this.mContext = mContext;
        int columnIndexOrThrow;
        if (mDataValid) {
            columnIndexOrThrow = mCursor.getColumnIndexOrThrow("_id");
        }
        else {
            columnIndexOrThrow = -1;
        }
        this.mRowIDColumn = columnIndexOrThrow;
        if ((n & 0x2) == 0x2) {
            this.mChangeObserver = new CursorAdapter$ChangeObserver(this);
            this.mDataSetObserver = new CursorAdapter$MyDataSetObserver(this);
        }
        else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (b) {
            final CursorAdapter$ChangeObserver mChangeObserver = this.mChangeObserver;
            if (mChangeObserver != null) {
                mCursor.registerContentObserver((ContentObserver)mChangeObserver);
            }
            final DataSetObserver mDataSetObserver = this.mDataSetObserver;
            if (mDataSetObserver != null) {
                mCursor.registerDataSetObserver(mDataSetObserver);
            }
        }
    }
    
    protected void init(final Context context, final Cursor cursor, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        this.init(context, cursor, n);
    }
    
    public View newDropDownView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return this.newView(context, cursor, viewGroup);
    }
    
    public abstract View newView(final Context p0, final Cursor p1, final ViewGroup p2);
    
    protected void onContentChanged() {
        if (this.mAutoRequery) {
            final Cursor mCursor = this.mCursor;
            if (mCursor != null && !mCursor.isClosed()) {
                this.mDataValid = this.mCursor.requery();
            }
        }
    }
    
    public Cursor runQueryOnBackgroundThread(final CharSequence charSequence) {
        final FilterQueryProvider mFilterQueryProvider = this.mFilterQueryProvider;
        if (mFilterQueryProvider != null) {
            return mFilterQueryProvider.runQuery(charSequence);
        }
        return this.mCursor;
    }
    
    public void setFilterQueryProvider(final FilterQueryProvider mFilterQueryProvider) {
        this.mFilterQueryProvider = mFilterQueryProvider;
    }
    
    public Cursor swapCursor(final Cursor mCursor) {
        if (mCursor == this.mCursor) {
            return null;
        }
        final Cursor mCursor2 = this.mCursor;
        if (mCursor2 != null) {
            final CursorAdapter$ChangeObserver mChangeObserver = this.mChangeObserver;
            if (mChangeObserver != null) {
                mCursor2.unregisterContentObserver((ContentObserver)mChangeObserver);
            }
            final DataSetObserver mDataSetObserver = this.mDataSetObserver;
            if (mDataSetObserver != null) {
                mCursor2.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        if ((this.mCursor = mCursor) != null) {
            final CursorAdapter$ChangeObserver mChangeObserver2 = this.mChangeObserver;
            if (mChangeObserver2 != null) {
                mCursor.registerContentObserver((ContentObserver)mChangeObserver2);
            }
            final DataSetObserver mDataSetObserver2 = this.mDataSetObserver;
            if (mDataSetObserver2 != null) {
                mCursor.registerDataSetObserver(mDataSetObserver2);
            }
            this.mRowIDColumn = mCursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            this.notifyDataSetChanged();
        }
        else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            this.notifyDataSetInvalidated();
        }
        return mCursor2;
    }
}
