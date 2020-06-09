// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class GroupedLinkedMap
{
    private final GroupedLinkedMap$LinkedEntry head;
    private final Map keyToEntry;
    
    GroupedLinkedMap() {
        this.head = new GroupedLinkedMap$LinkedEntry();
        this.keyToEntry = new HashMap();
    }
    
    private void makeHead(final GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry) {
        removeEntry(groupedLinkedMap$LinkedEntry);
        final GroupedLinkedMap$LinkedEntry head = this.head;
        groupedLinkedMap$LinkedEntry.prev = head;
        groupedLinkedMap$LinkedEntry.next = head.next;
        updateEntry(groupedLinkedMap$LinkedEntry);
    }
    
    private void makeTail(final GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry) {
        removeEntry(groupedLinkedMap$LinkedEntry);
        groupedLinkedMap$LinkedEntry.prev = this.head.prev;
        groupedLinkedMap$LinkedEntry.next = this.head;
        updateEntry(groupedLinkedMap$LinkedEntry);
    }
    
    private static void removeEntry(final GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry) {
        groupedLinkedMap$LinkedEntry.prev.next = groupedLinkedMap$LinkedEntry.next;
        groupedLinkedMap$LinkedEntry.next.prev = groupedLinkedMap$LinkedEntry.prev;
    }
    
    private static void updateEntry(final GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry) {
        groupedLinkedMap$LinkedEntry.next.prev = groupedLinkedMap$LinkedEntry;
        groupedLinkedMap$LinkedEntry.prev.next = groupedLinkedMap$LinkedEntry;
    }
    
    public Object get(final Poolable poolable) {
        GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry = this.keyToEntry.get(poolable);
        if (groupedLinkedMap$LinkedEntry == null) {
            groupedLinkedMap$LinkedEntry = new GroupedLinkedMap$LinkedEntry(poolable);
            this.keyToEntry.put(poolable, groupedLinkedMap$LinkedEntry);
        }
        else {
            poolable.offer();
        }
        this.makeHead(groupedLinkedMap$LinkedEntry);
        return groupedLinkedMap$LinkedEntry.removeLast();
    }
    
    public void put(final Poolable poolable, final Object o) {
        GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry = this.keyToEntry.get(poolable);
        if (groupedLinkedMap$LinkedEntry == null) {
            this.makeTail(groupedLinkedMap$LinkedEntry = new GroupedLinkedMap$LinkedEntry(poolable));
            this.keyToEntry.put(poolable, groupedLinkedMap$LinkedEntry);
        }
        else {
            poolable.offer();
        }
        groupedLinkedMap$LinkedEntry.add(o);
    }
    
    public Object removeLast() {
        for (GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry = this.head.prev; !groupedLinkedMap$LinkedEntry.equals(this.head); groupedLinkedMap$LinkedEntry = groupedLinkedMap$LinkedEntry.prev) {
            final Object removeLast = groupedLinkedMap$LinkedEntry.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            removeEntry(groupedLinkedMap$LinkedEntry);
            this.keyToEntry.remove(groupedLinkedMap$LinkedEntry.key);
            ((Poolable)groupedLinkedMap$LinkedEntry.key).offer();
        }
        return null;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        GroupedLinkedMap$LinkedEntry groupedLinkedMap$LinkedEntry = this.head.next;
        boolean b = false;
        while (!groupedLinkedMap$LinkedEntry.equals(this.head)) {
            b = true;
            sb.append('{');
            sb.append(groupedLinkedMap$LinkedEntry.key);
            sb.append(':');
            sb.append(groupedLinkedMap$LinkedEntry.size());
            sb.append("}, ");
            groupedLinkedMap$LinkedEntry = groupedLinkedMap$LinkedEntry.next;
        }
        if (b) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
