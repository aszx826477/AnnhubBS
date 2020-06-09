// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.support.v4.util.LruCache;

class AppCompatDrawableManager$ColorFilterLruCache extends LruCache
{
    public AppCompatDrawableManager$ColorFilterLruCache(final int n) {
        super(n);
    }
    
    private static int generateCacheKey(final int n, final PorterDuff$Mode porterDuff$Mode) {
        return (1 * 31 + n) * 31 + porterDuff$Mode.hashCode();
    }
    
    PorterDuffColorFilter get(final int n, final PorterDuff$Mode porterDuff$Mode) {
        return (PorterDuffColorFilter)this.get(generateCacheKey(n, porterDuff$Mode));
    }
    
    PorterDuffColorFilter put(final int n, final PorterDuff$Mode porterDuff$Mode, final PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter)this.put(generateCacheKey(n, porterDuff$Mode), porterDuffColorFilter);
    }
}
