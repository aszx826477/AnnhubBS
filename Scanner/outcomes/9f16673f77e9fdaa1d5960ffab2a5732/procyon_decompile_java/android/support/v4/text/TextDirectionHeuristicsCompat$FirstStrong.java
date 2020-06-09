// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

class TextDirectionHeuristicsCompat$FirstStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm
{
    public static final TextDirectionHeuristicsCompat$FirstStrong INSTANCE;
    
    static {
        INSTANCE = new TextDirectionHeuristicsCompat$FirstStrong();
    }
    
    public int checkRtl(final CharSequence charSequence, final int n, final int n2) {
        int rtlTextOrFormat = 2;
        for (int n3 = n; n3 < n + n2 && rtlTextOrFormat == 2; rtlTextOrFormat = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(n3))), ++n3) {}
        return rtlTextOrFormat;
    }
}
