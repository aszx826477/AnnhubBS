// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class FileLoader implements ModelLoader
{
    private final ModelLoader uriLoader;
    
    public FileLoader(final ModelLoader uriLoader) {
        this.uriLoader = uriLoader;
    }
    
    public DataFetcher getResourceFetcher(final File file, final int n, final int n2) {
        return this.uriLoader.getResourceFetcher(Uri.fromFile(file), n, n2);
    }
}
