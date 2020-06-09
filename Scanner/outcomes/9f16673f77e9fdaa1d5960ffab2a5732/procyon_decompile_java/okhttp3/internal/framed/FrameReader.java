// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.Closeable;

public interface FrameReader extends Closeable
{
    boolean nextFrame(final FrameReader$Handler p0);
    
    void readConnectionPreface();
}
