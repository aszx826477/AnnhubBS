// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Type;

class ConstructorConstructor$14 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    private final UnsafeAllocator unsafeAllocator;
    final /* synthetic */ Class val$rawType;
    final /* synthetic */ Type val$type;
    
    ConstructorConstructor$14(final ConstructorConstructor this$0, final Class val$rawType, final Type val$type) {
        this.this$0 = this$0;
        this.val$rawType = val$rawType;
        this.val$type = val$type;
        this.unsafeAllocator = UnsafeAllocator.create();
    }
    
    public Object construct() {
        try {
            final UnsafeAllocator unsafeAllocator = this.unsafeAllocator;
            try {
                return unsafeAllocator.newInstance(this.val$rawType);
            }
            catch (Exception ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to invoke no-args constructor for ");
                sb.append(this.val$type);
                sb.append(". ");
                sb.append("Register an InstanceCreator with Gson for this type may fix this problem.");
                throw new RuntimeException(sb.toString(), ex);
            }
        }
        catch (Exception ex2) {}
    }
}
