// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.os.Handler;
import android.database.ContentObserver;

class CursorAdapter$ChangeObserver extends ContentObserver
{
    final /* synthetic */ CursorAdapter this$0;
    
    CursorAdapter$ChangeObserver(final CursorAdapter this$0) {
        this.this$0 = this$0;
        super(new Handler());
    }
    
    public boolean deliverSelfNotifications() {
        return true;
    }
    
    public void onChange(final boolean b) {
        this.this$0.onContentChanged();
    }
}
