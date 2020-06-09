// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.content.res;

import android.content.res.XmlResourceParser;
import android.content.res.Resources;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import android.util.TypedValue;
import android.support.v7.widget.AppCompatDrawableManager;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.os.Build$VERSION;
import android.util.SparseArray;
import android.content.res.ColorStateList;
import android.content.Context;
import java.util.WeakHashMap;

public final class AppCompatResources
{
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal TL_TYPED_VALUE;
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap sColorStateCaches;
    
    static {
        TL_TYPED_VALUE = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }
    
    private static void addColorStateListToCache(final Context context, final int n, final ColorStateList list) {
        synchronized (AppCompatResources.sColorStateCacheLock) {
            SparseArray sparseArray = AppCompatResources.sColorStateCaches.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                AppCompatResources.sColorStateCaches.put(context, sparseArray);
            }
            sparseArray.append(n, (Object)new AppCompatResources$ColorStateListCacheEntry(list, context.getResources().getConfiguration()));
        }
    }
    
    private static ColorStateList getCachedColorStateList(final Context context, final int n) {
        synchronized (AppCompatResources.sColorStateCacheLock) {
            final SparseArray sparseArray = AppCompatResources.sColorStateCaches.get(context);
            if (sparseArray != null && sparseArray.size() > 0) {
                final AppCompatResources$ColorStateListCacheEntry appCompatResources$ColorStateListCacheEntry = (AppCompatResources$ColorStateListCacheEntry)sparseArray.get(n);
                if (appCompatResources$ColorStateListCacheEntry != null) {
                    if (appCompatResources$ColorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                        return appCompatResources$ColorStateListCacheEntry.value;
                    }
                    sparseArray.remove(n);
                }
            }
            return null;
        }
    }
    
    public static ColorStateList getColorStateList(final Context context, final int n) {
        if (Build$VERSION.SDK_INT >= 23) {
            return context.getColorStateList(n);
        }
        final ColorStateList cachedColorStateList = getCachedColorStateList(context, n);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        final ColorStateList inflateColorStateList = inflateColorStateList(context, n);
        if (inflateColorStateList != null) {
            addColorStateListToCache(context, n, inflateColorStateList);
            return inflateColorStateList;
        }
        return ContextCompat.getColorStateList(context, n);
    }
    
    public static Drawable getDrawable(final Context context, final int n) {
        return AppCompatDrawableManager.get().getDrawable(context, n);
    }
    
    private static TypedValue getTypedValue() {
        TypedValue typedValue = AppCompatResources.TL_TYPED_VALUE.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            AppCompatResources.TL_TYPED_VALUE.set(typedValue);
        }
        return typedValue;
    }
    
    private static ColorStateList inflateColorStateList(final Context context, final int n) {
        if (isColorInt(context, n)) {
            return null;
        }
        final Resources resources = context.getResources();
        final XmlResourceParser xml = resources.getXml(n);
        try {
            return AppCompatColorStateListInflater.createFromXml(resources, (XmlPullParser)xml, context.getTheme());
        }
        catch (Exception ex) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", (Throwable)ex);
            return null;
        }
    }
    
    private static boolean isColorInt(final Context context, final int n) {
        final Resources resources = context.getResources();
        final TypedValue typedValue = getTypedValue();
        boolean b = true;
        resources.getValue(n, typedValue, b);
        if (typedValue.type < 28 || typedValue.type > 31) {
            b = false;
        }
        return b;
    }
}
