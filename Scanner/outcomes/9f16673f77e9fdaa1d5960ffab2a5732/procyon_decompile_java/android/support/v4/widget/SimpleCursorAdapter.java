// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.database.Cursor;
import android.content.Context;

public class SimpleCursorAdapter extends ResourceCursorAdapter
{
    private SimpleCursorAdapter$CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private SimpleCursorAdapter$ViewBinder mViewBinder;
    
    public SimpleCursorAdapter(final Context context, final int n, final Cursor cursor, final String[] mOriginalFrom, final int[] mTo) {
        super(context, n, cursor);
        this.mStringConversionColumn = -1;
        this.mTo = mTo;
        this.findColumns(cursor, this.mOriginalFrom = mOriginalFrom);
    }
    
    public SimpleCursorAdapter(final Context context, final int n, final Cursor cursor, final String[] mOriginalFrom, final int[] mTo, final int n2) {
        super(context, n, cursor, n2);
        this.mStringConversionColumn = -1;
        this.mTo = mTo;
        this.findColumns(cursor, this.mOriginalFrom = mOriginalFrom);
    }
    
    private void findColumns(final Cursor cursor, final String[] array) {
        if (cursor != null) {
            final int length = array.length;
            final int[] mFrom = this.mFrom;
            if (mFrom == null || mFrom.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; ++i) {
                this.mFrom[i] = cursor.getColumnIndexOrThrow(array[i]);
            }
        }
        else {
            this.mFrom = null;
        }
    }
    
    public void bindView(final View view, final Context context, final Cursor cursor) {
        final SimpleCursorAdapter$ViewBinder mViewBinder = this.mViewBinder;
        final int length = this.mTo.length;
        final int[] mFrom = this.mFrom;
        final int[] mTo = this.mTo;
        for (int i = 0; i < length; ++i) {
            final View viewById = view.findViewById(mTo[i]);
            if (viewById != null) {
                boolean setViewValue = false;
                if (mViewBinder != null) {
                    setViewValue = mViewBinder.setViewValue(viewById, cursor, mFrom[i]);
                }
                if (!setViewValue) {
                    String string = cursor.getString(mFrom[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewById instanceof TextView) {
                        this.setViewText((TextView)viewById, string);
                    }
                    else {
                        if (!(viewById instanceof ImageView)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append(((ImageView)viewById).getClass().getName());
                            sb.append(" is not a ");
                            sb.append(" view that can be bounds by this SimpleCursorAdapter");
                            throw new IllegalStateException(sb.toString());
                        }
                        this.setViewImage((ImageView)viewById, string);
                    }
                }
            }
        }
    }
    
    public void changeCursorAndColumns(final Cursor cursor, final String[] mOriginalFrom, final int[] mTo) {
        this.mOriginalFrom = mOriginalFrom;
        this.mTo = mTo;
        this.findColumns(cursor, this.mOriginalFrom);
        super.changeCursor(cursor);
    }
    
    public CharSequence convertToString(final Cursor cursor) {
        final SimpleCursorAdapter$CursorToStringConverter mCursorToStringConverter = this.mCursorToStringConverter;
        if (mCursorToStringConverter != null) {
            return mCursorToStringConverter.convertToString(cursor);
        }
        final int mStringConversionColumn = this.mStringConversionColumn;
        if (mStringConversionColumn > -1) {
            return cursor.getString(mStringConversionColumn);
        }
        return super.convertToString(cursor);
    }
    
    public SimpleCursorAdapter$CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }
    
    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }
    
    public SimpleCursorAdapter$ViewBinder getViewBinder() {
        return this.mViewBinder;
    }
    
    public void setCursorToStringConverter(final SimpleCursorAdapter$CursorToStringConverter mCursorToStringConverter) {
        this.mCursorToStringConverter = mCursorToStringConverter;
    }
    
    public void setStringConversionColumn(final int mStringConversionColumn) {
        this.mStringConversionColumn = mStringConversionColumn;
    }
    
    public void setViewBinder(final SimpleCursorAdapter$ViewBinder mViewBinder) {
        this.mViewBinder = mViewBinder;
    }
    
    public void setViewImage(final ImageView imageView, final String s) {
        try {
            imageView.setImageResource(Integer.parseInt(s));
        }
        catch (NumberFormatException ex) {
            imageView.setImageURI(Uri.parse(s));
        }
    }
    
    public void setViewText(final TextView textView, final String text) {
        textView.setText((CharSequence)text);
    }
    
    public Cursor swapCursor(final Cursor cursor) {
        this.findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }
}
