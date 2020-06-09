// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

class AlertController$CheckedItemAdapter extends ArrayAdapter
{
    public AlertController$CheckedItemAdapter(final Context context, final int n, final int n2, final CharSequence[] array) {
        super(context, n, n2, (Object[])array);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public boolean hasStableIds() {
        return true;
    }
}
