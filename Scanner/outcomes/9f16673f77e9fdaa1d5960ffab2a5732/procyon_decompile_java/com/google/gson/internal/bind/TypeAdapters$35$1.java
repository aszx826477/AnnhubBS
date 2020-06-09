// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

class TypeAdapters$35$1 extends TypeAdapter
{
    final /* synthetic */ TypeAdapters$35 this$0;
    final /* synthetic */ Class val$requestedType;
    
    TypeAdapters$35$1(final TypeAdapters$35 this$0, final Class val$requestedType) {
        this.this$0 = this$0;
        this.val$requestedType = val$requestedType;
    }
    
    public Object read(final JsonReader jsonReader) {
        final Object read = this.this$0.val$typeAdapter.read(jsonReader);
        if (read != null && !this.val$requestedType.isInstance(read)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected a ");
            sb.append(this.val$requestedType.getName());
            sb.append(" but was ");
            sb.append(read.getClass().getName());
            throw new JsonSyntaxException(sb.toString());
        }
        return read;
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        this.this$0.val$typeAdapter.write(jsonWriter, o);
    }
}
