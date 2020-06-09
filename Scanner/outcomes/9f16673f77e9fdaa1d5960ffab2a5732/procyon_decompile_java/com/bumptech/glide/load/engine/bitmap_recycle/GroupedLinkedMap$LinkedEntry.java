// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.List;

class GroupedLinkedMap$LinkedEntry
{
    private final Object key;
    GroupedLinkedMap$LinkedEntry next;
    GroupedLinkedMap$LinkedEntry prev;
    private List values;
    
    public GroupedLinkedMap$LinkedEntry() {
        this(null);
    }
    
    public GroupedLinkedMap$LinkedEntry(final Object key) {
        this.prev = this;
        this.next = this;
        this.key = key;
    }
    
    public void add(final Object o) {
        if (this.values == null) {
            this.values = new ArrayList();
        }
        this.values.add(o);
    }
    
    public Object removeLast() {
        final int size = this.size();
        Object remove;
        if (size > 0) {
            remove = this.values.remove(size - 1);
        }
        else {
            remove = null;
        }
        return remove;
    }
    
    public int size() {
        final List values = this.values;
        int size;
        if (values != null) {
            size = values.size();
        }
        else {
            size = 0;
        }
        return size;
    }
}
