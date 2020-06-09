// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.BufferedSink;
import okio.BufferedSource;
import okhttp3.Protocol;

public interface Variant
{
    Protocol getProtocol();
    
    FrameReader newReader(final BufferedSource p0, final boolean p1);
    
    FrameWriter newWriter(final BufferedSink p0, final boolean p1);
}
