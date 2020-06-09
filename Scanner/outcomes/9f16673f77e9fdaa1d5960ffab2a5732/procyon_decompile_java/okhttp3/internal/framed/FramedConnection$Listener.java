// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

public abstract class FramedConnection$Listener
{
    public static final FramedConnection$Listener REFUSE_INCOMING_STREAMS;
    
    static {
        REFUSE_INCOMING_STREAMS = new FramedConnection$Listener$1();
    }
    
    public void onSettings(final FramedConnection framedConnection) {
    }
    
    public abstract void onStream(final FramedStream p0);
}
