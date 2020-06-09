// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

class LinkedHashTreeMap$KeySet$1 extends LinkedHashTreeMap$LinkedTreeMapIterator
{
    final /* synthetic */ LinkedHashTreeMap$KeySet this$1;
    
    LinkedHashTreeMap$KeySet$1(final LinkedHashTreeMap$KeySet this$1) {
        this.this$1 = this$1;
        super(this$1.this$0);
    }
    
    public Object next() {
        return this.nextNode().key;
    }
}
