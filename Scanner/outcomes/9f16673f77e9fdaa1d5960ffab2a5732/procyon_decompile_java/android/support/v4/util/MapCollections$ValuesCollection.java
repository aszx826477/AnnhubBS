// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;

final class MapCollections$ValuesCollection implements Collection
{
    final /* synthetic */ MapCollections this$0;
    
    MapCollections$ValuesCollection(final MapCollections this$0) {
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
        return this.this$0.colIndexOfValue(o) >= 0;
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
    
    public boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }
    
    public Iterator iterator() {
        return new MapCollections$ArrayIterator(this.this$0, 1);
    }
    
    public boolean remove(final Object o) {
        final int colIndexOfValue = this.this$0.colIndexOfValue(o);
        if (colIndexOfValue >= 0) {
            this.this$0.colRemoveAt(colIndexOfValue);
            return true;
        }
        return false;
    }
    
    public boolean removeAll(final Collection collection) {
        int colGetSize = this.this$0.colGetSize();
        boolean b = false;
        int n;
        for (int i = 0; i < colGetSize; i += n) {
            final MapCollections this$0 = this.this$0;
            n = 1;
            if (collection.contains(this$0.colGetEntry(i, n))) {
                this.this$0.colRemoveAt(i);
                --i;
                --colGetSize;
                b = true;
            }
        }
        return b;
    }
    
    public boolean retainAll(final Collection collection) {
        int colGetSize = this.this$0.colGetSize();
        boolean b = false;
        int n;
        for (int i = 0; i < colGetSize; i += n) {
            final MapCollections this$0 = this.this$0;
            n = 1;
            if (!collection.contains(this$0.colGetEntry(i, n))) {
                this.this$0.colRemoveAt(i);
                --i;
                --colGetSize;
                b = true;
            }
        }
        return b;
    }
    
    public int size() {
        return this.this$0.colGetSize();
    }
    
    public Object[] toArray() {
        return this.this$0.toArrayHelper(1);
    }
    
    public Object[] toArray(final Object[] array) {
        return this.this$0.toArrayHelper(array, 1);
    }
}
