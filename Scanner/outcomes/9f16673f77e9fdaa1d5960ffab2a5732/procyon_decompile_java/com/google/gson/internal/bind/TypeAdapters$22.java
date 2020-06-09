// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.net.URISyntaxException;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.net.URI;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$22 extends TypeAdapter
{
    public URI read(final JsonReader jsonReader) {
        final JsonToken peek = jsonReader.peek();
        final JsonToken null = JsonToken.NULL;
        URI uri = null;
        if (peek == null) {
            jsonReader.nextNull();
            return null;
        }
        try {
            final String nextString = jsonReader.nextString();
            if (!"null".equals(nextString)) {
                uri = new URI(nextString);
            }
            return uri;
        }
        catch (URISyntaxException ex) {
            throw new JsonIOException(ex);
        }
    }
    
    public void write(final JsonWriter jsonWriter, final URI uri) {
        String asciiString;
        if (uri == null) {
            asciiString = null;
        }
        else {
            asciiString = uri.toASCIIString();
        }
        jsonWriter.value(asciiString);
    }
}
