// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.io.Writer;

final class Streams$AppendableWriter extends Writer
{
    private final Appendable appendable;
    private final Streams$AppendableWriter$CurrentWrite currentWrite;
    
    Streams$AppendableWriter(final Appendable appendable) {
        this.currentWrite = new Streams$AppendableWriter$CurrentWrite();
        this.appendable = appendable;
    }
    
    public void close() {
    }
    
    public void flush() {
    }
    
    public void write(final int n) {
        this.appendable.append((char)n);
    }
    
    public void write(final char[] chars, final int n, final int n2) {
        final Streams$AppendableWriter$CurrentWrite currentWrite = this.currentWrite;
        currentWrite.chars = chars;
        this.appendable.append(currentWrite, n, n + n2);
    }
}
