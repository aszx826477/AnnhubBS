// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.os.Handler;
import android.database.ContentObserver;

public final class Loader$ForceLoadContentObserver extends ContentObserver
{
    final /* synthetic */ Loader this$0;
    
    public Loader$ForceLoadContentObserver(final Loader this$0) {
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
