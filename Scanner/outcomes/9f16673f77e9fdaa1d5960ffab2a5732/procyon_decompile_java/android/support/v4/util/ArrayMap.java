// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Map;

public class ArrayMap extends SimpleArrayMap implements Map
{
    MapCollections mCollections;
    
    public ArrayMap() {
    }
    
    public ArrayMap(final int n) {
        super(n);
    }
    
    public ArrayMap(final SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
    
    private MapCollections getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new ArrayMap$1(this);
        }
        return this.mCollections;
    }
    
    public boolean containsAll(final Collection collection) {
        return MapCollections.containsAllHelper(this, collection);
    }
    
    public Set entrySet() {
        return this.getCollection().getEntrySet();
    }
    
    public Set keySet() {
        return this.getCollection().getKeySet();
    }
    
    public void putAll(final Map map) {
        this.ensureCapacity(this.mSize + map.size());
        for (final Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    public boolean removeAll(final Collection collection) {
        return MapCollections.removeAllHelper(this, collection);
    }
    
    public boolean retainAll(final Collection collection) {
        return MapCollections.retainAllHelper(this, collection);
    }
    
    public Collection values() {
        return this.getCollection().getValues();
    }
}
