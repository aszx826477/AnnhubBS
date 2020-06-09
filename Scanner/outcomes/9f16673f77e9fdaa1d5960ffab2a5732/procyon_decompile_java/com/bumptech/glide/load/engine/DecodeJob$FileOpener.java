// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;

class DecodeJob$FileOpener
{
    public OutputStream open(final File file) {
        return new BufferedOutputStream(new FileOutputStream(file));
    }
}
