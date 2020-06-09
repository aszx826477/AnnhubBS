// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

final class FramedConnection$Listener$1 extends FramedConnection$Listener
{
    public void onStream(final FramedStream framedStream) {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }
}
