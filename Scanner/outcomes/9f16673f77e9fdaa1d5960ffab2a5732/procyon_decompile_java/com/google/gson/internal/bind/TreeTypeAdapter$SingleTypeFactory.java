// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapterFactory;

final class TreeTypeAdapter$SingleTypeFactory implements TypeAdapterFactory
{
    private final JsonDeserializer deserializer;
    private final TypeToken exactType;
    private final Class hierarchyType;
    private final boolean matchRawType;
    private final JsonSerializer serializer;
    
    TreeTypeAdapter$SingleTypeFactory(final Object o, final TypeToken exactType, final boolean matchRawType, final Class hierarchyType) {
        final boolean b = o instanceof JsonSerializer;
        JsonDeserializer deserializer = null;
        JsonSerializer serializer;
        if (b) {
            serializer = (JsonSerializer)o;
        }
        else {
            serializer = null;
        }
        this.serializer = serializer;
        if (o instanceof JsonDeserializer) {
            deserializer = (JsonDeserializer)o;
        }
        this.deserializer = deserializer;
        $Gson$Preconditions.checkArgument(this.serializer != null || this.deserializer != null);
        this.exactType = exactType;
        this.matchRawType = matchRawType;
        this.hierarchyType = hierarchyType;
    }
    
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final TypeToken exactType = this.exactType;
        boolean assignable;
        if (exactType != null) {
            assignable = (exactType.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType()));
        }
        else {
            assignable = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
        }
        TypeAdapter typeAdapter;
        if (assignable) {
            typeAdapter = new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
        }
        else {
            typeAdapter = null;
        }
        return typeAdapter;
    }
}
