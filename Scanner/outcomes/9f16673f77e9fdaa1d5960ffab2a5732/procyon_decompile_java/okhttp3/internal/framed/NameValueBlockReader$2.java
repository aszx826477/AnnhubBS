// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.zip.Inflater;

class NameValueBlockReader$2 extends Inflater
{
    final /* synthetic */ NameValueBlockReader this$0;
    
    NameValueBlockReader$2(final NameValueBlockReader this$0) {
        this.this$0 = this$0;
    }
    
    public int inflate(final byte[] array, final int n, final int n2) {
        int n3 = super.inflate(array, n, n2);
        if (n3 == 0 && this.needsDictionary()) {
            this.setDictionary(Spdy3.DICTIONARY);
            n3 = super.inflate(array, n, n2);
        }
        return n3;
    }
}
