// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.io;

import okio.Source;
import okio.Sink;
import java.io.File;

public interface FileSystem
{
    public static final FileSystem SYSTEM = new FileSystem$1();
    
    Sink appendingSink(final File p0);
    
    void delete(final File p0);
    
    void deleteContents(final File p0);
    
    boolean exists(final File p0);
    
    void rename(final File p0, final File p1);
    
    Sink sink(final File p0);
    
    long size(final File p0);
    
    Source source(final File p0);
}
