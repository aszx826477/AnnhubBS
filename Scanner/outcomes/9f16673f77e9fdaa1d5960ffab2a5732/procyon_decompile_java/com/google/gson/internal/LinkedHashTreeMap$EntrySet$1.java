// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Map;

class LinkedHashTreeMap$EntrySet$1 extends LinkedHashTreeMap$LinkedTreeMapIterator
{
    final /* synthetic */ LinkedHashTreeMap$EntrySet this$1;
    
    LinkedHashTreeMap$EntrySet$1(final LinkedHashTreeMap$EntrySet this$1) {
        this.this$1 = this$1;
        super(this$1.this$0);
    }
    
    public Map.Entry next() {
        return this.nextNode();
    }
}
