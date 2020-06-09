// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$3 extends UnsafeAllocator
{
    final /* synthetic */ Method val$newInstance;
    
    UnsafeAllocator$3(final Method val$newInstance) {
        this.val$newInstance = val$newInstance;
    }
    
    public Object newInstance(final Class clazz) {
        UnsafeAllocator.access$000(clazz);
        return this.val$newInstance.invoke(null, clazz, Object.class);
    }
}
