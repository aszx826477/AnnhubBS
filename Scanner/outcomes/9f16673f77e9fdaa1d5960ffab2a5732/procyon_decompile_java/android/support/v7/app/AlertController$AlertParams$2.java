// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.CursorAdapter;

class AlertController$AlertParams$2 extends CursorAdapter
{
    private final int mIsCheckedIndex;
    private final int mLabelIndex;
    final /* synthetic */ AlertController$AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    final /* synthetic */ AlertController$RecycleListView val$listView;
    
    AlertController$AlertParams$2(final AlertController$AlertParams this$0, final Context context, final Cursor cursor, final boolean b, final AlertController$RecycleListView val$listView, final AlertController val$dialog) {
        this.this$0 = this$0;
        this.val$listView = val$listView;
        this.val$dialog = val$dialog;
        super(context, cursor, b);
        final Cursor cursor2 = this.getCursor();
        this.mLabelIndex = cursor2.getColumnIndexOrThrow(this.this$0.mLabelColumn);
        this.mIsCheckedIndex = cursor2.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
    }
    
    public void bindView(final View view, final Context context, final Cursor cursor) {
        ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(this.mLabelIndex));
        final AlertController$RecycleListView val$listView = this.val$listView;
        final int position = cursor.getPosition();
        final int int1 = cursor.getInt(this.mIsCheckedIndex);
        boolean b = true;
        if (int1 != (b ? 1 : 0)) {
            b = false;
        }
        val$listView.setItemChecked(position, b);
    }
    
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false);
    }
}
