// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.util.LongSparseArray;
import java.util.Map;
import android.util.Log;
import android.os.Build$VERSION;
import android.content.res.Resources;
import java.lang.reflect.Field;

class ResourcesFlusher
{
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
    
    static boolean flush(final Resources resources) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 24) {
            return flushNougats(resources);
        }
        if (sdk_INT >= 23) {
            return flushMarshmallows(resources);
        }
        return sdk_INT >= 21 && flushLollipops(resources);
    }
    
    private static boolean flushLollipops(final Resources resources) {
        final boolean sDrawableCacheFieldFetched = ResourcesFlusher.sDrawableCacheFieldFetched;
        final boolean b = true;
        if (!sDrawableCacheFieldFetched) {
            final Class<Resources> clazz = Resources.class;
            final String s = "mDrawableCache";
            final Class<Resources> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (ResourcesFlusher.sDrawableCacheField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {
                    Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", (Throwable)ex);
                }
            }
            catch (NoSuchFieldException ex3) {}
            ResourcesFlusher.sDrawableCacheFieldFetched = b;
        }
        final Field sDrawableCacheField = ResourcesFlusher.sDrawableCacheField;
        if (sDrawableCacheField != null) {
            Map map = null;
            final Field field = sDrawableCacheField;
            try {
                final Object value = field.get(resources);
                try {
                    map = (Map)value;
                }
                catch (IllegalAccessException ex2) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", (Throwable)ex2);
                }
            }
            catch (IllegalAccessException ex4) {}
            if (map != null) {
                map.clear();
                return b;
            }
        }
        return false;
    }
    
    private static boolean flushMarshmallows(final Resources resources) {
        final boolean sDrawableCacheFieldFetched = ResourcesFlusher.sDrawableCacheFieldFetched;
        boolean b = true;
        if (!sDrawableCacheFieldFetched) {
            final Class<Resources> clazz = Resources.class;
            final String s = "mDrawableCache";
            final Class<Resources> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (ResourcesFlusher.sDrawableCacheField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {
                    Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", (Throwable)ex);
                }
            }
            catch (NoSuchFieldException ex3) {}
            ResourcesFlusher.sDrawableCacheFieldFetched = b;
        }
        Object value = null;
        final Field sDrawableCacheField = ResourcesFlusher.sDrawableCacheField;
        if (sDrawableCacheField != null) {
            final Field field = sDrawableCacheField;
            try {
                value = field.get(resources);
            }
            catch (IllegalAccessException ex2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", (Throwable)ex2);
            }
        }
        if (value == null) {
            return false;
        }
        if (value == null || !flushThemedResourcesCache(value)) {
            b = false;
        }
        return b;
    }
    
    private static boolean flushNougats(final Resources resources) {
        final boolean sResourcesImplFieldFetched = ResourcesFlusher.sResourcesImplFieldFetched;
        boolean b = true;
        if (!sResourcesImplFieldFetched) {
            final Class<Resources> clazz = Resources.class;
            final String s = "mResourcesImpl";
            final Class<Resources> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (ResourcesFlusher.sResourcesImplField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {
                    Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", (Throwable)ex);
                }
            }
            catch (NoSuchFieldException ex5) {}
            ResourcesFlusher.sResourcesImplFieldFetched = b;
        }
        final Field sResourcesImplField = ResourcesFlusher.sResourcesImplField;
        if (sResourcesImplField == null) {
            return false;
        }
        Object value = null;
        final Field field = sResourcesImplField;
        try {
            value = field.get(resources);
        }
        catch (IllegalAccessException ex2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", (Throwable)ex2);
        }
        if (value == null) {
            return false;
        }
        if (!ResourcesFlusher.sDrawableCacheFieldFetched) {
            try {
                final Field declaredField2 = value.getClass().getDeclaredField("mDrawableCache");
                try {
                    (ResourcesFlusher.sDrawableCacheField = declaredField2).setAccessible(b);
                }
                catch (NoSuchFieldException ex3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", (Throwable)ex3);
                }
            }
            catch (NoSuchFieldException ex6) {}
            ResourcesFlusher.sDrawableCacheFieldFetched = b;
        }
        Object value2 = null;
        final Field sDrawableCacheField = ResourcesFlusher.sDrawableCacheField;
        if (sDrawableCacheField != null) {
            final Field field2 = sDrawableCacheField;
            try {
                value2 = field2.get(value);
            }
            catch (IllegalAccessException ex4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", (Throwable)ex4);
            }
        }
        if (value2 == null || !flushThemedResourcesCache(value2)) {
            b = false;
        }
        return b;
    }
    
    private static boolean flushThemedResourcesCache(final Object o) {
        final boolean sThemedResourceCacheClazzFetched = ResourcesFlusher.sThemedResourceCacheClazzFetched;
        final boolean sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        if (!sThemedResourceCacheClazzFetched) {
            final String s = "android.content.res.ThemedResourceCache";
            try {
                final Class<?> forName = Class.forName(s);
                try {
                    ResourcesFlusher.sThemedResourceCacheClazz = forName;
                }
                catch (ClassNotFoundException ex) {
                    Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", (Throwable)ex);
                }
            }
            catch (ClassNotFoundException ex4) {}
            ResourcesFlusher.sThemedResourceCacheClazzFetched = sThemedResourceCache_mUnthemedEntriesFieldFetched;
        }
        final Class sThemedResourceCacheClazz = ResourcesFlusher.sThemedResourceCacheClazz;
        if (sThemedResourceCacheClazz == null) {
            return false;
        }
        if (!ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            final String s2 = "mUnthemedEntries";
            final Class clazz = sThemedResourceCacheClazz;
            try {
                final Field declaredField = clazz.getDeclaredField(s2);
                try {
                    (ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField = declaredField).setAccessible(sThemedResourceCache_mUnthemedEntriesFieldFetched);
                }
                catch (NoSuchFieldException ex2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", (Throwable)ex2);
                }
            }
            catch (NoSuchFieldException ex5) {}
            ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched = sThemedResourceCache_mUnthemedEntriesFieldFetched;
        }
        final Field sThemedResourceCache_mUnthemedEntriesField = ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField;
        if (sThemedResourceCache_mUnthemedEntriesField == null) {
            return false;
        }
        LongSparseArray longSparseArray = null;
        final Field field = sThemedResourceCache_mUnthemedEntriesField;
        try {
            final Object value = field.get(o);
            try {
                longSparseArray = (LongSparseArray)value;
            }
            catch (IllegalAccessException ex3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)ex3);
            }
        }
        catch (IllegalAccessException ex6) {}
        if (longSparseArray != null) {
            longSparseArray.clear();
            return sThemedResourceCache_mUnthemedEntriesFieldFetched;
        }
        return false;
    }
}
