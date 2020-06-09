// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.RandomAccess;
import java.util.AbstractList;

public final class Options extends AbstractList implements RandomAccess
{
    final ByteString[] byteStrings;
    
    private Options(final ByteString[] byteStrings) {
        this.byteStrings = byteStrings;
    }
    
    public static Options of(final ByteString... array) {
        return new Options(array.clone());
    }
    
    public ByteString get(final int n) {
        return this.byteStrings[n];
    }
    
    public int size() {
        return this.byteStrings.length;
    }
}
