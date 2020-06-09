// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.EnumSet;
import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class ConstructorConstructor$5 implements ObjectConstructor
{
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ Type val$type;
    
    ConstructorConstructor$5(final ConstructorConstructor this$0, final Type val$type) {
        this.this$0 = this$0;
        this.val$type = val$type;
    }
    
    public Object construct() {
        final Type val$type = this.val$type;
        if (!(val$type instanceof ParameterizedType)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid EnumSet type: ");
            sb.append(this.val$type.toString());
            throw new JsonIOException(sb.toString());
        }
        final Type type = ((ParameterizedType)val$type).getActualTypeArguments()[0];
        if (type instanceof Class) {
            return EnumSet.noneOf((Class<Enum>)type);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid EnumSet type: ");
        sb2.append(this.val$type.toString());
        throw new JsonIOException(sb2.toString());
    }
}
