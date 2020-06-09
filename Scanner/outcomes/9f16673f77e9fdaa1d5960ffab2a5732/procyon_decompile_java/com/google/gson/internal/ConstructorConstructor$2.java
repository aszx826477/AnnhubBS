// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

class ConstructorConstructor$2 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ InstanceCreator val$rawTypeCreator;
    final /* synthetic */ Type val$type;
    
    ConstructorConstructor$2(final ConstructorConstructor this$0, final InstanceCreator val$rawTypeCreator, final Type val$type) {
        this.this$0 = this$0;
        this.val$rawTypeCreator = val$rawTypeCreator;
        this.val$type = val$type;
    }
    
    public Object construct() {
        return this.val$rawTypeCreator.createInstance(this.val$type);
    }
}
