// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;
import java.io.ByteArrayOutputStream;

class StrictLineReader$1 extends ByteArrayOutputStream
{
    final /* synthetic */ StrictLineReader this$0;
    
    StrictLineReader$1(final StrictLineReader this$0, final int n) {
        this.this$0 = this$0;
        super(n);
    }
    
    public String toString() {
        int count;
        if (this.count > 0 && this.buf[this.count - 1] == 13) {
            count = this.count - 1;
        }
        else {
            count = this.count;
        }
        try {
            try {
                final byte[] buf = this.buf;
                try {
                    final StrictLineReader this$0 = this.this$0;
                    try {
                        final Charset access$000 = this$0.charset;
                        try {
                            return new String(buf, 0, count, access$000.name());
                        }
                        catch (UnsupportedEncodingException ex) {
                            throw new AssertionError((Object)ex);
                        }
                    }
                    catch (UnsupportedEncodingException ex2) {}
                }
                catch (UnsupportedEncodingException ex3) {}
            }
            catch (UnsupportedEncodingException ex4) {}
        }
        catch (UnsupportedEncodingException ex5) {}
    }
}
