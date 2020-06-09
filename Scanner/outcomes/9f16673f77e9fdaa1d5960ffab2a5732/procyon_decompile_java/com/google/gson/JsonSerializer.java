// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializer
{
    JsonElement serialize(final Object p0, final Type p1, final JsonSerializationContext p2);
}
