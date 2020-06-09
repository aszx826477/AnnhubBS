// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class FramedConnection$2 extends NamedRunnable
{
    final /* synthetic */ FramedConnection this$0;
    final /* synthetic */ int val$streamId;
    final /* synthetic */ long val$unacknowledgedBytesRead;
    
    FramedConnection$2(final FramedConnection this$0, final String s, final Object[] array, final int val$streamId, final long val$unacknowledgedBytesRead) {
        this.this$0 = this$0;
        this.val$streamId = val$streamId;
        this.val$unacknowledgedBytesRead = val$unacknowledgedBytesRead;
        super(s, array);
    }
    
    public void execute() {
        try {
            final FramedConnection this$0 = this.this$0;
            try {
                final FrameWriter frameWriter = this$0.frameWriter;
                try {
                    final int val$streamId = this.val$streamId;
                    try {
                        frameWriter.windowUpdate(val$streamId, this.val$unacknowledgedBytesRead);
                    }
                    catch (IOException ex) {}
                }
                catch (IOException ex2) {}
            }
            catch (IOException ex3) {}
        }
        catch (IOException ex4) {}
    }
}
