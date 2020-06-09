// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonWriter;
import java.io.Writer;
import java.io.StringWriter;
import java.io.IOException;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.StringReader;
import com.google.gson.stream.JsonReader;
import java.io.Reader;

public abstract class TypeAdapter
{
    public final Object fromJson(final Reader reader) {
        return this.read(new JsonReader(reader));
    }
    
    public final Object fromJson(final String s) {
        return this.fromJson(new StringReader(s));
    }
    
    public final Object fromJsonTree(final JsonElement jsonElement) {
        try {
            final JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
            try {
                return this.read(jsonTreeReader);
            }
            catch (IOException ex) {
                throw new JsonIOException(ex);
            }
        }
        catch (IOException ex2) {}
    }
    
    public final TypeAdapter nullSafe() {
        return new TypeAdapter$1(this);
    }
    
    public abstract Object read(final JsonReader p0);
    
    public final String toJson(final Object o) {
        final StringWriter stringWriter = new StringWriter();
        try {
            this.toJson(stringWriter, o);
            return stringWriter.toString();
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public final void toJson(final Writer writer, final Object o) {
        this.write(new JsonWriter(writer), o);
    }
    
    public final JsonElement toJsonTree(final Object o) {
        try {
            try {
                final JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
                this.write(jsonTreeWriter, o);
                return jsonTreeWriter.get();
            }
            catch (IOException ex) {
                throw new JsonIOException(ex);
            }
        }
        catch (IOException ex2) {}
    }
    
    public abstract void write(final JsonWriter p0, final Object p1);
}
