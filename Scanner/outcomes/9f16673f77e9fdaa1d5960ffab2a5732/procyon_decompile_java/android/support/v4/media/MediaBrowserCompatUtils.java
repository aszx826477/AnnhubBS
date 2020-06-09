// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils
{
    public static boolean areSameOptions(final Bundle bundle, final Bundle bundle2) {
        boolean b = true;
        if (bundle == bundle2) {
            return b;
        }
        final int n = -1;
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", n) != n || bundle2.getInt("android.media.browse.extra.PAGE_SIZE", n) != n) {
                b = false;
            }
            return b;
        }
        if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", n) != n || bundle.getInt("android.media.browse.extra.PAGE_SIZE", n) != n) {
                b = false;
            }
            return b;
        }
        if (bundle.getInt("android.media.browse.extra.PAGE", n) != bundle2.getInt("android.media.browse.extra.PAGE", n) || bundle.getInt("android.media.browse.extra.PAGE_SIZE", n) != bundle2.getInt("android.media.browse.extra.PAGE_SIZE", n)) {
            b = false;
        }
        return b;
    }
    
    public static boolean hasDuplicatedItems(final Bundle bundle, final Bundle bundle2) {
        final int n = -1;
        int int1;
        if (bundle == null) {
            int1 = -1;
        }
        else {
            int1 = bundle.getInt("android.media.browse.extra.PAGE", n);
        }
        int int2;
        if (bundle2 == null) {
            int2 = -1;
        }
        else {
            int2 = bundle2.getInt("android.media.browse.extra.PAGE", n);
        }
        int int3;
        if (bundle == null) {
            int3 = -1;
        }
        else {
            int3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", n);
        }
        int int4;
        if (bundle2 == null) {
            int4 = -1;
        }
        else {
            int4 = bundle2.getInt("android.media.browse.extra.PAGE_SIZE", n);
        }
        final int n2 = 1;
        int n3;
        int n4;
        if (int1 != n && int3 != n) {
            n3 = int3 * int1;
            n4 = n3 + int3 - n2;
        }
        else {
            n3 = 0;
            n4 = -1 >>> 1;
        }
        int n5;
        int n6;
        if (int2 != n && int4 != n) {
            n5 = int4 * int2;
            n6 = n5 + int4 - n2;
        }
        else {
            n5 = 0;
            n6 = -1 >>> 1;
        }
        if (n3 <= n5 && n5 <= n4) {
            return n2 != 0;
        }
        return n3 <= n6 && n6 <= n4 && n2;
    }
}
