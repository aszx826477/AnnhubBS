// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;
import com.bumptech.glide.load.Key;

public interface DiskCache
{
    void clear();
    
    void delete(final Key p0);
    
    File get(final Key p0);
    
    void put(final Key p0, final DiskCache$Writer p1);
}
