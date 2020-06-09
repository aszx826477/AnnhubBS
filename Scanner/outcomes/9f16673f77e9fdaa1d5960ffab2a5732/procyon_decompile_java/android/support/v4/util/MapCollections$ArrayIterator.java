// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Iterator;

final class MapCollections$ArrayIterator implements Iterator
{
    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final /* synthetic */ MapCollections this$0;
    
    MapCollections$ArrayIterator(final MapCollections this$0, final int mOffset) {
        this.this$0 = this$0;
        this.mCanRemove = false;
        this.mOffset = mOffset;
        this.mSize = this$0.colGetSize();
    }
    
    public boolean hasNext() {
        return this.mIndex < this.mSize;
    }
    
    public Object next() {
        final Object colGetEntry = this.this$0.colGetEntry(this.mIndex, this.mOffset);
        final int mIndex = this.mIndex;
        final int mCanRemove = 1;
        this.mIndex = mIndex + mCanRemove;
        this.mCanRemove = (mCanRemove != 0);
        return colGetEntry;
    }
    
    public void remove() {
        if (this.mCanRemove) {
            --this.mIndex;
            --this.mSize;
            this.mCanRemove = false;
            this.this$0.colRemoveAt(this.mIndex);
            return;
        }
        throw new IllegalStateException();
    }
}
