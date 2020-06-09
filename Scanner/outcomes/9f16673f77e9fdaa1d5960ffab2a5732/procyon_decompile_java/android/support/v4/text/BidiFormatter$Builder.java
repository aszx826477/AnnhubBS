// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter$Builder
{
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public BidiFormatter$Builder() {
        this.initialize(isRtlLocale(Locale.getDefault()));
    }
    
    public BidiFormatter$Builder(final Locale locale) {
        this.initialize(isRtlLocale(locale));
    }
    
    public BidiFormatter$Builder(final boolean b) {
        this.initialize(b);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(final boolean b) {
        BidiFormatter bidiFormatter;
        if (b) {
            bidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
        }
        else {
            bidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
        }
        return bidiFormatter;
    }
    
    private void initialize(final boolean mIsRtlContext) {
        this.mIsRtlContext = mIsRtlContext;
        this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
        this.mFlags = 2;
    }
    
    public BidiFormatter build() {
        if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
            return getDefaultInstanceFromContext(this.mIsRtlContext);
        }
        return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null);
    }
    
    public BidiFormatter$Builder setTextDirectionHeuristic(final TextDirectionHeuristicCompat mTextDirectionHeuristicCompat) {
        this.mTextDirectionHeuristicCompat = mTextDirectionHeuristicCompat;
        return this;
    }
    
    public BidiFormatter$Builder stereoReset(final boolean b) {
        if (b) {
            this.mFlags |= 0x2;
        }
        else {
            this.mFlags &= 0xFFFFFFFD;
        }
        return this;
    }
}
