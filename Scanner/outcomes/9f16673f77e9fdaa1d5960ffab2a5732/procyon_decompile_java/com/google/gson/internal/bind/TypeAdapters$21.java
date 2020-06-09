// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import java.net.URL;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$21 extends TypeAdapter
{
    public URL read(final JsonReader jsonReader) {
        final JsonToken peek = jsonReader.peek();
        final JsonToken null = JsonToken.NULL;
        URL url = null;
        if (peek == null) {
            jsonReader.nextNull();
            return null;
        }
        final String nextString = jsonReader.nextString();
        if (!"null".equals(nextString)) {
            url = new URL(nextString);
        }
        return url;
    }
    
    public void write(final JsonWriter jsonWriter, final URL url) {
        String externalForm;
        if (url == null) {
            externalForm = null;
        }
        else {
            externalForm = url.toExternalForm();
        }
        jsonWriter.value(externalForm);
    }
}
