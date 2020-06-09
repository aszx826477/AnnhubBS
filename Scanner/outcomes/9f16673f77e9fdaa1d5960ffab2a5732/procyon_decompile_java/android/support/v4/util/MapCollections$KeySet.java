// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;
import java.util.Set;

final class MapCollections$KeySet implements Set
{
    final /* synthetic */ MapCollections this$0;
    
    MapCollections$KeySet(final MapCollections this$0) {
        this.this$0 = this$0;
    }
    
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public void clear() {
        this.this$0.colClear();
    }
    
    public boolean contains(final Object o) {
        return this.this$0.colIndexOfKey(o) >= 0;
    }
    
    public boolean containsAll(final Collection collection) {
        return MapCollections.containsAllHelper(this.this$0.colGetMap(), collection);
    }
    
    public boolean equals(final Object o) {
        return MapCollections.equalsSetHelper(this, o);
    }
    
    public int hashCode() {
        int n = 0;
        for (int i = this.this$0.colGetSize() - 1; i >= 0; --i) {
            final MapCollections this$0 = this.this$0;
            int hashCode = 0;
            final Object colGetEntry = this$0.colGetEntry(i, 0);
            if (colGetEntry != null) {
                hashCode = colGetEntry.hashCode();
            }
            n += hashCode;
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }
    
    public Iterator iterator() {
        return new MapCollections$ArrayIterator(this.this$0, 0);
    }
    
    public boolean remove(final Object o) {
        final int colIndexOfKey = this.this$0.colIndexOfKey(o);
        if (colIndexOfKey >= 0) {
            this.this$0.colRemoveAt(colIndexOfKey);
            return true;
        }
        return false;
    }
    
    public boolean removeAll(final Collection collection) {
        return MapCollections.removeAllHelper(this.this$0.colGetMap(), collection);
    }
    
    public boolean retainAll(final Collection collection) {
        return MapCollections.retainAllHelper(this.this$0.colGetMap(), collection);
    }
    
    public int size() {
        return this.this$0.colGetSize();
    }
    
    public Object[] toArray() {
        return this.this$0.toArrayHelper(0);
    }
    
    public Object[] toArray(final Object[] array) {
        return this.this$0.toArrayHelper(array, 0);
    }
}
