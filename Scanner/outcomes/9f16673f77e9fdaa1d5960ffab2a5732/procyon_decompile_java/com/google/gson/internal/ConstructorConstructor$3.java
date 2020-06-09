// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

class ConstructorConstructor$3 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ Constructor val$constructor;
    
    ConstructorConstructor$3(final ConstructorConstructor this$0, final Constructor val$constructor) {
        this.this$0 = this$0;
        this.val$constructor = val$constructor;
    }
    
    public Object construct() {
        try {
            return this.val$constructor.newInstance((Object[])null);
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError((Object)ex);
        }
        catch (InvocationTargetException ex2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke ");
            sb.append(this.val$constructor);
            sb.append(" with no args");
            throw new RuntimeException(sb.toString(), ex2.getTargetException());
        }
        catch (InstantiationException ex3) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to invoke ");
            sb2.append(this.val$constructor);
            sb2.append(" with no args");
            throw new RuntimeException(sb2.toString(), ex3);
        }
    }
}
