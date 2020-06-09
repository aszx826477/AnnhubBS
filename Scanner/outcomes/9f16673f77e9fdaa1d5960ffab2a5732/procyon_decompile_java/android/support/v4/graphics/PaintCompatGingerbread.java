// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics;

import android.support.v4.util.Pair;
import android.graphics.Rect;
import android.graphics.Paint;

class PaintCompatGingerbread
{
    private static final String TOFU_STRING = "\udb3f\udffd";
    private static final ThreadLocal sRectThreadLocal;
    
    static {
        sRectThreadLocal = new ThreadLocal();
    }
    
    static boolean hasGlyph(final Paint paint, final String s) {
        final int length = s.length();
        final int n = 1;
        if (length == n && Character.isWhitespace(s.charAt(0))) {
            return n != 0;
        }
        final float measureText = paint.measureText("\udb3f\udffd");
        final float measureText2 = paint.measureText(s);
        if (measureText2 == 0.0f) {
            return false;
        }
        if (s.codePointCount(0, s.length()) > n) {
            if (measureText2 > 2.0f * measureText) {
                return false;
            }
            float n2 = 0.0f;
            int charCount;
            for (int i = 0; i < length; i += charCount) {
                charCount = Character.charCount(s.codePointAt(i));
                n2 += paint.measureText(s, i, i + charCount);
            }
            if (measureText2 >= n2) {
                return false;
            }
        }
        if (measureText2 != measureText) {
            return n != 0;
        }
        final Pair obtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds("\udb3f\udffd", 0, "\udb3f\udffd".length(), (Rect)obtainEmptyRects.first);
        paint.getTextBounds(s, 0, length, (Rect)obtainEmptyRects.second);
        return (n ^ (((Rect)obtainEmptyRects.first).equals(obtainEmptyRects.second) ? 1 : 0)) != 0x0;
    }
    
    private static Pair obtainEmptyRects() {
        Pair pair = PaintCompatGingerbread.sRectThreadLocal.get();
        if (pair == null) {
            pair = new Pair(new Rect(), new Rect());
            PaintCompatGingerbread.sRectThreadLocal.set(pair);
        }
        else {
            ((Rect)pair.first).setEmpty();
            ((Rect)pair.second).setEmpty();
        }
        return pair;
    }
}
