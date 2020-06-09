// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
{
    private final boolean mDefaultIsRtl;
    
    TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(final TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm, final boolean mDefaultIsRtl) {
        super(textDirectionHeuristicsCompat$TextDirectionAlgorithm);
        this.mDefaultIsRtl = mDefaultIsRtl;
    }
    
    protected boolean defaultIsRtl() {
        return this.mDefaultIsRtl;
    }
}
