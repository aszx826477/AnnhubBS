// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

final class Huffman$Node
{
    private final Huffman$Node[] children;
    private final int symbol;
    private final int terminalBits;
    
    Huffman$Node() {
        this.children = new Huffman$Node[256];
        this.symbol = 0;
        this.terminalBits = 0;
    }
    
    Huffman$Node(final int symbol, final int n) {
        this.children = null;
        this.symbol = symbol;
        final int n2 = n & 0x7;
        int terminalBits;
        if (n2 == 0) {
            terminalBits = 8;
        }
        else {
            terminalBits = n2;
        }
        this.terminalBits = terminalBits;
    }
}
