// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.concurrent.ConcurrentSkipListMap;

class ConstructorConstructor$9 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    
    ConstructorConstructor$9(final ConstructorConstructor this$0) {
        this.this$0 = this$0;
    }
    
    public Object construct() {
        return new ConcurrentSkipListMap();
    }
}
