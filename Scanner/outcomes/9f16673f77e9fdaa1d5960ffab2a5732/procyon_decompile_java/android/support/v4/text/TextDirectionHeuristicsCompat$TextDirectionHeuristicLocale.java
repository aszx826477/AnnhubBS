// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.util.Locale;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
{
    public static final TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale INSTANCE;
    
    static {
        INSTANCE = new TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale();
    }
    
    public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale() {
        super(null);
    }
    
    protected boolean defaultIsRtl() {
        final int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault());
        boolean b = true;
        if (layoutDirectionFromLocale != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
}
