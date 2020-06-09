// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$2 extends UnsafeAllocator
{
    final /* synthetic */ int val$constructorId;
    final /* synthetic */ Method val$newInstance;
    
    UnsafeAllocator$2(final Method val$newInstance, final int val$constructorId) {
        this.val$newInstance = val$newInstance;
        this.val$constructorId = val$constructorId;
    }
    
    public Object newInstance(final Class clazz) {
        UnsafeAllocator.access$000(clazz);
        return this.val$newInstance.invoke(null, clazz, this.val$constructorId);
    }
}
