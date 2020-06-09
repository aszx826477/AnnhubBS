// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.file;

import java.io.InputStream;
import java.io.IOException;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public class FileToStreamDecoder implements ResourceDecoder
{
    private static final FileToStreamDecoder$FileOpener DEFAULT_FILE_OPENER;
    private final FileToStreamDecoder$FileOpener fileOpener;
    private ResourceDecoder streamDecoder;
    
    static {
        DEFAULT_FILE_OPENER = new FileToStreamDecoder$FileOpener();
    }
    
    public FileToStreamDecoder(final ResourceDecoder resourceDecoder) {
        this(resourceDecoder, FileToStreamDecoder.DEFAULT_FILE_OPENER);
    }
    
    FileToStreamDecoder(final ResourceDecoder streamDecoder, final FileToStreamDecoder$FileOpener fileOpener) {
        this.streamDecoder = streamDecoder;
        this.fileOpener = fileOpener;
    }
    
    public Resource decode(final File file, final int n, final int n2) {
        InputStream open = null;
        try {
            open = this.fileOpener.open(file);
            final Resource decode = this.streamDecoder.decode(open, n, n2);
            if (open != null) {
                try {
                    open.close();
                }
                catch (IOException ex) {}
            }
            return decode;
        }
        finally {
            if (open != null) {
                try {
                    open.close();
                }
                catch (IOException ex2) {}
            }
        }
    }
    
    public String getId() {
        return "";
    }
}
