// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

class LinkedTreeMap$KeySet$1 extends LinkedTreeMap$LinkedTreeMapIterator
{
    final /* synthetic */ LinkedTreeMap$KeySet this$1;
    
    LinkedTreeMap$KeySet$1(final LinkedTreeMap$KeySet this$1) {
        this.this$1 = this$1;
        super(this$1.this$0);
    }
    
    public Object next() {
        return this.nextNode().key;
    }
}
