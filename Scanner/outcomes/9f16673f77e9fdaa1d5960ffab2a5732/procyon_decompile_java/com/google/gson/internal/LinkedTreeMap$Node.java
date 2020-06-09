// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Map;

final class LinkedTreeMap$Node implements Entry
{
    int height;
    final Object key;
    LinkedTreeMap$Node left;
    LinkedTreeMap$Node next;
    LinkedTreeMap$Node parent;
    LinkedTreeMap$Node prev;
    LinkedTreeMap$Node right;
    Object value;
    
    LinkedTreeMap$Node() {
        this.key = null;
        this.prev = this;
        this.next = this;
    }
    
    LinkedTreeMap$Node(final LinkedTreeMap$Node parent, final Object key, final LinkedTreeMap$Node next, final LinkedTreeMap$Node prev) {
        this.parent = parent;
        this.key = key;
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
    
    public LinkedTreeMap$Node first() {
        LinkedTreeMap$Node linkedTreeMap$Node = this;
        for (LinkedTreeMap$Node linkedTreeMap$Node2 = this.left; linkedTreeMap$Node2 != null; linkedTreeMap$Node2 = linkedTreeMap$Node2.left) {
            linkedTreeMap$Node = linkedTreeMap$Node2;
        }
        return linkedTreeMap$Node;
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
    
    public LinkedTreeMap$Node last() {
        LinkedTreeMap$Node linkedTreeMap$Node = this;
        for (LinkedTreeMap$Node linkedTreeMap$Node2 = this.right; linkedTreeMap$Node2 != null; linkedTreeMap$Node2 = linkedTreeMap$Node2.right) {
            linkedTreeMap$Node = linkedTreeMap$Node2;
        }
        return linkedTreeMap$Node;
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
