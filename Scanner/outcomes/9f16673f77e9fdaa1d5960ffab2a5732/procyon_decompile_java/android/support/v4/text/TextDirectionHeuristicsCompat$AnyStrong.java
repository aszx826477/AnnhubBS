// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

class TextDirectionHeuristicsCompat$AnyStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm
{
    public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_LTR;
    public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL;
    private final boolean mLookForRtl;
    
    static {
        INSTANCE_RTL = new TextDirectionHeuristicsCompat$AnyStrong(true);
        INSTANCE_LTR = new TextDirectionHeuristicsCompat$AnyStrong(false);
    }
    
    private TextDirectionHeuristicsCompat$AnyStrong(final boolean mLookForRtl) {
        this.mLookForRtl = mLookForRtl;
    }
    
    public int checkRtl(final CharSequence charSequence, final int n, final int n2) {
        boolean b = false;
        for (int i = n; i < n + n2; ++i) {
            switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i)))) {
                case 1: {
                    if (!this.mLookForRtl) {
                        return 1;
                    }
                    b = true;
                    break;
                }
                case 0: {
                    if (this.mLookForRtl) {
                        return 0;
                    }
                    b = true;
                    break;
                }
            }
        }
        if (b) {
            return this.mLookForRtl ? 1 : 0;
        }
        return 2;
    }
}
