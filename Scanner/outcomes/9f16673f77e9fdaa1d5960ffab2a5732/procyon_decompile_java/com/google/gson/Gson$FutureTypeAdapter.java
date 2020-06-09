// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;

class Gson$FutureTypeAdapter extends TypeAdapter
{
    private TypeAdapter delegate;
    
    public Object read(final JsonReader jsonReader) {
        final TypeAdapter delegate = this.delegate;
        if (delegate != null) {
            return delegate.read(jsonReader);
        }
        throw new IllegalStateException();
    }
    
    public void setDelegate(final TypeAdapter delegate) {
        if (this.delegate == null) {
            this.delegate = delegate;
            return;
        }
        throw new AssertionError();
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        final TypeAdapter delegate = this.delegate;
        if (delegate != null) {
            delegate.write(jsonWriter, o);
            return;
        }
        throw new IllegalStateException();
    }
}
