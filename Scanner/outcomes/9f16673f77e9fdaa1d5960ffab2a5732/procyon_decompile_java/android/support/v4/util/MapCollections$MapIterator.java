// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Map;
import java.util.Iterator;

final class MapCollections$MapIterator implements Iterator, Entry
{
    int mEnd;
    boolean mEntryValid;
    int mIndex;
    final /* synthetic */ MapCollections this$0;
    
    MapCollections$MapIterator(final MapCollections this$0) {
        this.this$0 = this$0;
        this.mEntryValid = false;
        this.mEnd = this$0.colGetSize() - 1;
        this.mIndex = -1;
    }
    
    public final boolean equals(final Object o) {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        final boolean b = o instanceof Entry;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final Entry entry = (Entry)o;
        final boolean equal = ContainerHelpers.equal(entry.getKey(), this.this$0.colGetEntry(this.mIndex, 0));
        final int n = 1;
        if (equal) {
            if (ContainerHelpers.equal(entry.getValue(), this.this$0.colGetEntry(this.mIndex, n))) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public Object getKey() {
        if (this.mEntryValid) {
            return this.this$0.colGetEntry(this.mIndex, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Object getValue() {
        if (this.mEntryValid) {
            return this.this$0.colGetEntry(this.mIndex, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext() {
        return this.mIndex < this.mEnd;
    }
    
    public final int hashCode() {
        if (this.mEntryValid) {
            final MapCollections this$0 = this.this$0;
            final int mIndex = this.mIndex;
            int hashCode = 0;
            final Object colGetEntry = this$0.colGetEntry(mIndex, 0);
            final Object colGetEntry2 = this.this$0.colGetEntry(this.mIndex, 1);
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
            return hashCode ^ hashCode2;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Entry next() {
        final int mIndex = this.mIndex;
        final int mEntryValid = 1;
        this.mIndex = mIndex + mEntryValid;
        this.mEntryValid = (mEntryValid != 0);
        return this;
    }
    
    public void remove() {
        if (this.mEntryValid) {
            this.this$0.colRemoveAt(this.mIndex);
            --this.mIndex;
            --this.mEnd;
            this.mEntryValid = false;
            return;
        }
        throw new IllegalStateException();
    }
    
    public Object setValue(final Object o) {
        if (this.mEntryValid) {
            return this.this$0.colSetValue(this.mIndex, o);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getKey());
        sb.append("=");
        sb.append(this.getValue());
        return sb.toString();
    }
}
