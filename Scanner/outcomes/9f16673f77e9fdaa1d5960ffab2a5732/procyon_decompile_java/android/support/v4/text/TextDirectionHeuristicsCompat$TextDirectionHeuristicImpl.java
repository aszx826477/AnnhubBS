// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.nio.CharBuffer;

abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat
{
    private final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;
    
    public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm) {
        this.mAlgorithm = mAlgorithm;
    }
    
    private boolean doCheck(final CharSequence charSequence, final int n, final int n2) {
        switch (this.mAlgorithm.checkRtl(charSequence, n, n2)) {
            default: {
                return this.defaultIsRtl();
            }
            case 1: {
                return false;
            }
            case 0: {
                return true;
            }
        }
    }
    
    protected abstract boolean defaultIsRtl();
    
    public boolean isRtl(final CharSequence charSequence, final int n, final int n2) {
        if (charSequence == null || n < 0 || n2 < 0 || charSequence.length() - n2 < n) {
            throw new IllegalArgumentException();
        }
        if (this.mAlgorithm == null) {
            return this.defaultIsRtl();
        }
        return this.doCheck(charSequence, n, n2);
    }
    
    public boolean isRtl(final char[] array, final int n, final int n2) {
        return this.isRtl(CharBuffer.wrap(array), n, n2);
    }
}
