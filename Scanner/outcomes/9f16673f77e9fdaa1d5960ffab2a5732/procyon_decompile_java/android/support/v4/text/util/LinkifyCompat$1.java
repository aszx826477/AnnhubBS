// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text.util;

import java.util.Comparator;

final class LinkifyCompat$1 implements Comparator
{
    public final int compare(final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec, final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2) {
        final int start = linkifyCompat$LinkSpec.start;
        final int start2 = linkifyCompat$LinkSpec2.start;
        final int n = -1;
        if (start < start2) {
            return n;
        }
        final int start3 = linkifyCompat$LinkSpec.start;
        final int start4 = linkifyCompat$LinkSpec2.start;
        final boolean b = true;
        if (start3 > start4) {
            return b ? 1 : 0;
        }
        if (linkifyCompat$LinkSpec.end < linkifyCompat$LinkSpec2.end) {
            return b ? 1 : 0;
        }
        if (linkifyCompat$LinkSpec.end > linkifyCompat$LinkSpec2.end) {
            return n;
        }
        return 0;
    }
}
