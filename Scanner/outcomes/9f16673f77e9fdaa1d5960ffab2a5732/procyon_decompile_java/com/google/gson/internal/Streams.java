// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.io.Writer;
import com.google.gson.stream.JsonWriter;
import java.io.EOFException;
import com.google.gson.JsonNull;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

public final class Streams
{
    private Streams() {
        throw new UnsupportedOperationException();
    }
    
    public static JsonElement parse(final JsonReader jsonReader) {
        boolean b = true;
        try {
            jsonReader.peek();
            b = false;
            final Object read = TypeAdapters.JSON_ELEMENT.read(jsonReader);
            try {
                return (JsonElement)read;
            }
            catch (NumberFormatException ex) {
                throw new JsonSyntaxException(ex);
            }
            catch (IOException ex2) {
                throw new JsonIOException(ex2);
            }
            catch (MalformedJsonException ex3) {
                throw new JsonSyntaxException(ex3);
            }
            catch (EOFException ex4) {
                if (b) {
                    return JsonNull.INSTANCE;
                }
                throw new JsonSyntaxException(ex4);
            }
        }
        catch (NumberFormatException ex5) {}
        catch (IOException ex6) {}
        catch (MalformedJsonException ex7) {}
        catch (EOFException ex8) {}
    }
    
    public static void write(final JsonElement jsonElement, final JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }
    
    public static Writer writerForAppendable(final Appendable appendable) {
        Writer writer;
        if (appendable instanceof Writer) {
            writer = (Writer)appendable;
        }
        else {
            writer = new Streams$AppendableWriter(appendable);
        }
        return writer;
    }
}
