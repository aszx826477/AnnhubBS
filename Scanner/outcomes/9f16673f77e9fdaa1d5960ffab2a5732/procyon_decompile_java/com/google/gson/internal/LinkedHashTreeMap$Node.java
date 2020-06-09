// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Map;

final class LinkedHashTreeMap$Node implements Entry
{
    final int hash;
    int height;
    final Object key;
    LinkedHashTreeMap$Node left;
    LinkedHashTreeMap$Node next;
    LinkedHashTreeMap$Node parent;
    LinkedHashTreeMap$Node prev;
    LinkedHashTreeMap$Node right;
    Object value;
    
    LinkedHashTreeMap$Node() {
        this.key = null;
        this.hash = -1;
        this.prev = this;
        this.next = this;
    }
    
    LinkedHashTreeMap$Node(final LinkedHashTreeMap$Node parent, final Object key, final int hash, final LinkedHashTreeMap$Node next, final LinkedHashTreeMap$Node prev) {
        this.parent = parent;
        this.key = key;
        this.hash = hash;
        this.height = 1;
        this.next = next;
        this.prev = prev;
        prev.next = this;
        next.prev = this;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Entry;
        boolean b2 = false;
        if (b) {
            final Entry entry = (Entry)o;
            final Object key = this.key;
            if (key == null) {
                if (entry.getKey() != null) {
                    return b2;
                }
            }
            else if (!key.equals(entry.getKey())) {
                return b2;
            }
            final Object value = this.value;
            if (value == null) {
                if (entry.getValue() != null) {
                    return b2;
                }
            }
            else if (!value.equals(entry.getValue())) {
                return b2;
            }
            b2 = true;
            return b2;
        }
        return false;
    }
    
    public LinkedHashTreeMap$Node first() {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this;
        for (LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this.left; linkedHashTreeMap$Node2 != null; linkedHashTreeMap$Node2 = linkedHashTreeMap$Node2.left) {
            linkedHashTreeMap$Node = linkedHashTreeMap$Node2;
        }
        return linkedHashTreeMap$Node;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public int hashCode() {
        final Object key = this.key;
        int hashCode = 0;
        int hashCode2;
        if (key == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = key.hashCode();
        }
        final Object value = this.value;
        if (value != null) {
            hashCode = value.hashCode();
        }
        return hashCode2 ^ hashCode;
    }
    
    public LinkedHashTreeMap$Node last() {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this;
        for (LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this.right; linkedHashTreeMap$Node2 != null; linkedHashTreeMap$Node2 = linkedHashTreeMap$Node2.right) {
            linkedHashTreeMap$Node = linkedHashTreeMap$Node2;
        }
        return linkedHashTreeMap$Node;
    }
    
    public Object setValue(final Object value) {
        final Object value2 = this.value;
        this.value = value;
        return value2;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append("=");
        sb.append(this.value);
        return sb.toString();
    }
}
