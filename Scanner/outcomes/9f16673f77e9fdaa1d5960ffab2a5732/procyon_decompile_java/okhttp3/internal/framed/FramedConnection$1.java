// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class FramedConnection$1 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ ErrorCode val$errorCode;
    final /* synthetic */ int val$streamId;
    
    FramedConnection$1(final FramedConnection this$0, final String s, final Object[] array, final int val$streamId, final ErrorCode val$errorCode) {
        this.this$0 = this$0;
        this.val$streamId = val$streamId;
        this.val$errorCode = val$errorCode;
        super(s, array);
    }
    
    public void execute() {
        try {
            final FramedConnection this$0 = this.this$0;
            try {
                final int val$streamId = this.val$streamId;
                try {
                    this$0.writeSynReset(val$streamId, this.val$errorCode);
                }
                catch (IOException ex) {}
            }
            catch (IOException ex2) {}
        }
        catch (IOException ex3) {}
    }
}
