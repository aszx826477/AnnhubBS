// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class MapCollections$EntrySet implements Set
{
    final /* synthetic */ MapCollections this$0;
    
    MapCollections$EntrySet(final MapCollections this$0) {
        this.this$0 = this$0;
    }
    
    public boolean add(final Map.Entry entry) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final Collection collection) {
        final int colGetSize = this.this$0.colGetSize();
        for (final Map.Entry<Object, V> entry : collection) {
            this.this$0.colPut(entry.getKey(), entry.getValue());
        }
        return colGetSize != this.this$0.colGetSize();
    }
    
    public void clear() {
        this.this$0.colClear();
    }
    
    public boolean contains(final Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        final Map.Entry entry = (Map.Entry)o;
        final int colIndexOfKey = this.this$0.colIndexOfKey(entry.getKey());
        return colIndexOfKey >= 0 && ContainerHelpers.equal(this.this$0.colGetEntry(colIndexOfKey, 1), entry.getValue());
    }
    
    public boolean containsAll(final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean equals(final Object o) {
        return MapCollections.equalsSetHelper(this, o);
    }
    
    public int hashCode() {
        int n = 0;
        final int colGetSize = this.this$0.colGetSize();
        final int n2 = 1;
        for (int i = colGetSize - n2; i >= 0; --i) {
            final MapCollections this$0 = this.this$0;
            int hashCode = 0;
            final Object colGetEntry = this$0.colGetEntry(i, 0);
            final Object colGetEntry2 = this.this$0.colGetEntry(i, n2);
            int hashCode2;
            if (colGetEntry == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = colGetEntry.hashCode();
            }
            if (colGetEntry2 != null) {
                hashCode = colGetEntry2.hashCode();
            }
            n += (hashCode ^ hashCode2);
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }
    
    public Iterator iterator() {
        return new MapCollections$MapIterator(this.this$0);
    }
    
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public int size() {
        return this.this$0.colGetSize();
    }
    
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
    
    public Object[] toArray(final Object[] array) {
        throw new UnsupportedOperationException();
    }
}
