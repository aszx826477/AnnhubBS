// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

class LinkedHashTreeMap$AvlIterator
{
    private LinkedHashTreeMap$Node stackTop;
    
    public LinkedHashTreeMap$Node next() {
        final LinkedHashTreeMap$Node stackTop = this.stackTop;
        if (stackTop == null) {
            return null;
        }
        final LinkedHashTreeMap$Node linkedHashTreeMap$Node = stackTop;
        LinkedHashTreeMap$Node parent = stackTop.parent;
        linkedHashTreeMap$Node.parent = null;
        for (LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.right; linkedHashTreeMap$Node2 != null; linkedHashTreeMap$Node2 = linkedHashTreeMap$Node2.left) {
            linkedHashTreeMap$Node2.parent = parent;
            parent = linkedHashTreeMap$Node2;
        }
        this.stackTop = parent;
        return linkedHashTreeMap$Node;
    }
    
    void reset(final LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = null;
        for (LinkedHashTreeMap$Node left = linkedHashTreeMap$Node; left != null; left = left.left) {
            left.parent = linkedHashTreeMap$Node2;
            linkedHashTreeMap$Node2 = left;
        }
        this.stackTop = linkedHashTreeMap$Node2;
    }
}
