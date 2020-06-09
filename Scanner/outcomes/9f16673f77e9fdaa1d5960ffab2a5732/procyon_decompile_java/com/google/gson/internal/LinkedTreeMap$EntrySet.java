// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.AbstractSet;

class LinkedTreeMap$EntrySet extends AbstractSet
{
    final /* synthetic */ LinkedTreeMap this$0;
    
    LinkedTreeMap$EntrySet(final LinkedTreeMap this$0) {
        this.this$0 = this$0;
    }
    
    public void clear() {
        this.this$0.clear();
    }
    
    public boolean contains(final Object o) {
        return o instanceof Map.Entry && this.this$0.findByEntry((Map.Entry)o) != null;
    }
    
    public Iterator iterator() {
        return new LinkedTreeMap$EntrySet$1(this);
    }
    
    public boolean remove(final Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        final LinkedTreeMap$Node byEntry = this.this$0.findByEntry((Map.Entry)o);
        if (byEntry == null) {
            return false;
        }
        final LinkedTreeMap this$0 = this.this$0;
        final boolean b = true;
        this$0.removeInternal(byEntry, b);
        return b;
    }
    
    public int size() {
        return this.this$0.size;
    }
}
