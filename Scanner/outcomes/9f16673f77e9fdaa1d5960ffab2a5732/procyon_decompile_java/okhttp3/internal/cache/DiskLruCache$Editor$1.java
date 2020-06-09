// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$Editor$1 extends FaultHidingSink
{
    final /* synthetic */ DiskLruCache$Editor this$1;
    
    DiskLruCache$Editor$1(final DiskLruCache$Editor this$1, final Sink sink) {
        this.this$1 = this$1;
        super(sink);
    }
    
    protected void onException(final IOException ex) {
        synchronized (this.this$1.this$0) {
            this.this$1.detach();
        }
    }
}
