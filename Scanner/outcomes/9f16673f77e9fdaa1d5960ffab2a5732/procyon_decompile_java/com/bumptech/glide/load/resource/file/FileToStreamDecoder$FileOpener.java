// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

class FileToStreamDecoder$FileOpener
{
    public InputStream open(final File file) {
        return new FileInputStream(file);
    }
}
