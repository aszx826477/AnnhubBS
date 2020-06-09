// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$1 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ Type val$type;
    final /* synthetic */ InstanceCreator val$typeCreator;
    
    ConstructorConstructor$1(final ConstructorConstructor this$0, final InstanceCreator val$typeCreator, final Type val$type) {
        this.this$0 = this$0;
        this.val$typeCreator = val$typeCreator;
        this.val$type = val$type;
    }
    
    public Object construct() {
        return this.val$typeCreator.createInstance(this.val$type);
    }
}
