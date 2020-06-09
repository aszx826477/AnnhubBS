// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;

abstract class MapCollections
{
    MapCollections$EntrySet mEntrySet;
    MapCollections$KeySet mKeySet;
    MapCollections$ValuesCollection mValues;
    
    public static boolean containsAllHelper(final Map map, final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!map.containsKey(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean equalsSetHelper(final Set set, final Object o) {
        boolean b = true;
        if (set == o) {
            return b;
        }
        if (o instanceof Set) {
            final Set set2 = (Set)o;
            try {
                final int size = set.size();
                try {
                    if (size != set2.size() || !set.containsAll(set2)) {
                        b = false;
                    }
                    return b;
                }
                catch (ClassCastException ex) {
                    return false;
                }
                catch (NullPointerException ex2) {
                    return false;
                }
            }
            catch (ClassCastException ex3) {}
            catch (NullPointerException ex4) {}
        }
        return false;
    }
    
    public static boolean removeAllHelper(final Map map, final Collection collection) {
        final int size = map.size();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }
        return size != map.size();
    }
    
    public static boolean retainAllHelper(final Map map, final Collection collection) {
        final int size = map.size();
        final Iterator<Object> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != map.size();
    }
    
    protected abstract void colClear();
    
    protected abstract Object colGetEntry(final int p0, final int p1);
    
    protected abstract Map colGetMap();
    
    protected abstract int colGetSize();
    
    protected abstract int colIndexOfKey(final Object p0);
    
    protected abstract int colIndexOfValue(final Object p0);
    
    protected abstract void colPut(final Object p0, final Object p1);
    
    protected abstract void colRemoveAt(final int p0);
    
    protected abstract Object colSetValue(final int p0, final Object p1);
    
    public Set getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new MapCollections$EntrySet(this);
        }
        return this.mEntrySet;
    }
    
    public Set getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new MapCollections$KeySet(this);
        }
        return this.mKeySet;
    }
    
    public Collection getValues() {
        if (this.mValues == null) {
            this.mValues = new MapCollections$ValuesCollection(this);
        }
        return this.mValues;
    }
    
    public Object[] toArrayHelper(final int n) {
        final int colGetSize = this.colGetSize();
        final Object[] array = new Object[colGetSize];
        for (int i = 0; i < colGetSize; ++i) {
            array[i] = this.colGetEntry(i, n);
        }
        return array;
    }
    
    public Object[] toArrayHelper(Object[] array, final int n) {
        final int colGetSize = this.colGetSize();
        if (array.length < colGetSize) {
            array = (Object[])Array.newInstance(array.getClass().getComponentType(), colGetSize);
        }
        for (int i = 0; i < colGetSize; ++i) {
            array[i] = this.colGetEntry(i, n);
        }
        if (array.length > colGetSize) {
            array[colGetSize] = null;
        }
        return array;
    }
}
