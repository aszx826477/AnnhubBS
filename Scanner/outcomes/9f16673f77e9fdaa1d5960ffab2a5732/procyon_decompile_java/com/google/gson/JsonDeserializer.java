// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializer
{
    Object deserialize(final JsonElement p0, final Type p1, final JsonDeserializationContext p2);
}
