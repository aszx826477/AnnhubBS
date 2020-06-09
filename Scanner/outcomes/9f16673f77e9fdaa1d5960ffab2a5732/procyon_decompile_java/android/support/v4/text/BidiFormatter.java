// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter
{
    private static final int DEFAULT_FLAGS = 2;
    private static final BidiFormatter DEFAULT_LTR_INSTANCE;
    private static final BidiFormatter DEFAULT_RTL_INSTANCE;
    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = 255;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;
    
    static {
        BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString('\u200e');
        RLM_STRING = Character.toString('\u200f');
        final TextDirectionHeuristicCompat default_TEXT_DIRECTION_HEURISTIC = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
        final int n = 2;
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, n, default_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, n, BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
    }
    
    private BidiFormatter(final boolean mIsRtlContext, final int mFlags, final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat) {
        this.mIsRtlContext = mIsRtlContext;
        this.mFlags = mFlags;
        this.mDefaultTextDirectionHeuristicCompat = mDefaultTextDirectionHeuristicCompat;
    }
    
    private static int getEntryDir(final CharSequence charSequence) {
        return new BidiFormatter$DirectionalityEstimator(charSequence, false).getEntryDir();
    }
    
    private static int getExitDir(final CharSequence charSequence) {
        return new BidiFormatter$DirectionalityEstimator(charSequence, false).getExitDir();
    }
    
    public static BidiFormatter getInstance() {
        return new BidiFormatter$Builder().build();
    }
    
    public static BidiFormatter getInstance(final Locale locale) {
        return new BidiFormatter$Builder(locale).build();
    }
    
    public static BidiFormatter getInstance(final boolean b) {
        return new BidiFormatter$Builder(b).build();
    }
    
    private static boolean isRtlLocale(final Locale locale) {
        final int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
        boolean b = true;
        if (layoutDirectionFromLocale != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    private String markAfter(final CharSequence charSequence, final TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        final boolean rtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (rtl || getExitDir(charSequence) == 1)) {
            return BidiFormatter.LRM_STRING;
        }
        if (this.mIsRtlContext && (!rtl || getExitDir(charSequence) == -1)) {
            return BidiFormatter.RLM_STRING;
        }
        return "";
    }
    
    private String markBefore(final CharSequence charSequence, final TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        final boolean rtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (rtl || getEntryDir(charSequence) == 1)) {
            return BidiFormatter.LRM_STRING;
        }
        if (this.mIsRtlContext && (!rtl || getEntryDir(charSequence) == -1)) {
            return BidiFormatter.RLM_STRING;
        }
        return "";
    }
    
    public boolean getStereoReset() {
        return (this.mFlags & 0x2) != 0x0;
    }
    
    public boolean isRtl(final CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }
    
    public boolean isRtl(final String s) {
        return this.isRtl((CharSequence)s);
    }
    
    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }
    
    public CharSequence unicodeWrap(final CharSequence charSequence) {
        return this.unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
    
    public CharSequence unicodeWrap(final CharSequence charSequence, final TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }
    
    public CharSequence unicodeWrap(final CharSequence charSequence, final TextDirectionHeuristicCompat textDirectionHeuristicCompat, final boolean b) {
        if (charSequence == null) {
            return null;
        }
        final boolean rtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.getStereoReset() && b) {
            TextDirectionHeuristicCompat textDirectionHeuristicCompat2;
            if (rtl) {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.RTL;
            }
            else {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.LTR;
            }
            spannableStringBuilder.append((CharSequence)this.markBefore(charSequence, textDirectionHeuristicCompat2));
        }
        if (rtl != this.mIsRtlContext) {
            char c;
            if (rtl) {
                c = '\u202b';
            }
            else {
                c = '\u202a';
            }
            spannableStringBuilder.append(c);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        }
        else {
            spannableStringBuilder.append(charSequence);
        }
        if (b) {
            TextDirectionHeuristicCompat textDirectionHeuristicCompat3;
            if (rtl) {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.RTL;
            }
            else {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.LTR;
            }
            spannableStringBuilder.append((CharSequence)this.markAfter(charSequence, textDirectionHeuristicCompat3));
        }
        return (CharSequence)spannableStringBuilder;
    }
    
    public CharSequence unicodeWrap(final CharSequence charSequence, final boolean b) {
        return this.unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, b);
    }
    
    public String unicodeWrap(final String s) {
        return this.unicodeWrap(s, this.mDefaultTextDirectionHeuristicCompat, true);
    }
    
    public String unicodeWrap(final String s, final TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(s, textDirectionHeuristicCompat, true);
    }
    
    public String unicodeWrap(final String s, final TextDirectionHeuristicCompat textDirectionHeuristicCompat, final boolean b) {
        if (s == null) {
            return null;
        }
        return this.unicodeWrap((CharSequence)s, textDirectionHeuristicCompat, b).toString();
    }
    
    public String unicodeWrap(final String s, final boolean b) {
        return this.unicodeWrap(s, this.mDefaultTextDirectionHeuristicCompat, b);
    }
}
