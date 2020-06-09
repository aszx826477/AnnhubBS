// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Map;

class ArraySet$1 extends MapCollections
{
    final /* synthetic */ ArraySet this$0;
    
    ArraySet$1(final ArraySet this$0) {
        this.this$0 = this$0;
    }
    
    protected void colClear() {
        this.this$0.clear();
    }
    
    protected Object colGetEntry(final int n, final int n2) {
        return this.this$0.mArray[n];
    }
    
    protected Map colGetMap() {
        throw new UnsupportedOperationException("not a map");
    }
    
    protected int colGetSize() {
        return this.this$0.mSize;
    }
    
    protected int colIndexOfKey(final Object o) {
        return this.this$0.indexOf(o);
    }
    
    protected int colIndexOfValue(final Object o) {
        return this.this$0.indexOf(o);
    }
    
    protected void colPut(final Object o, final Object o2) {
        this.this$0.add(o);
    }
    
    protected void colRemoveAt(final int n) {
        this.this$0.removeAt(n);
    }
    
    protected Object colSetValue(final int n, final Object o) {
        throw new UnsupportedOperationException("not a map");
    }
}
