// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class FramedConnection$Reader$3 extends NamedRunnable
{
    final /* synthetic */ FramedConnection$Reader this$1;
    final /* synthetic */ Settings val$peerSettings;
    
    FramedConnection$Reader$3(final FramedConnection$Reader this$1, final String s, final Object[] array, final Settings val$peerSettings) {
        this.this$1 = this$1;
        this.val$peerSettings = val$peerSettings;
        super(s, array);
    }
    
    public void execute() {
        try {
            final FramedConnection$Reader this$1 = this.this$1;
            try {
                final FramedConnection this$2 = this$1.this$0;
                try {
                    final FrameWriter frameWriter = this$2.frameWriter;
                    try {
                        frameWriter.applyAndAckSettings(this.val$peerSettings);
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
