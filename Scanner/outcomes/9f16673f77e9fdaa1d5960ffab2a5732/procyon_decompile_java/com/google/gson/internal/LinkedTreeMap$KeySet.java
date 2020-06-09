// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Iterator;
import java.util.AbstractSet;

final class LinkedTreeMap$KeySet extends AbstractSet
{
    final /* synthetic */ LinkedTreeMap this$0;
    
    LinkedTreeMap$KeySet(final LinkedTreeMap this$0) {
        this.this$0 = this$0;
    }
    
    public void clear() {
        this.this$0.clear();
    }
    
    public boolean contains(final Object o) {
        return this.this$0.containsKey(o);
    }
    
    public Iterator iterator() {
        return new LinkedTreeMap$KeySet$1(this);
    }
    
    public boolean remove(final Object o) {
        return this.this$0.removeInternalByKey(o) != null;
    }
    
    public int size() {
        return this.this$0.size;
    }
}
