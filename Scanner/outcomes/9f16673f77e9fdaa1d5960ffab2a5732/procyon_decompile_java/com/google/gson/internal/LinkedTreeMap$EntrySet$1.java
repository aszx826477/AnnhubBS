// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Map;

class LinkedTreeMap$EntrySet$1 extends LinkedTreeMap$LinkedTreeMapIterator
{
    final /* synthetic */ LinkedTreeMap$EntrySet this$1;
    
    LinkedTreeMap$EntrySet$1(final LinkedTreeMap$EntrySet this$1) {
        this.this$1 = this$1;
        super(this$1.this$0);
    }
    
    public Map.Entry next() {
        return this.nextNode();
    }
}
