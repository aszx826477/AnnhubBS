// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import java.net.InetAddress;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$23 extends TypeAdapter
{
    public InetAddress read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return InetAddress.getByName(jsonReader.nextString());
    }
    
    public void write(final JsonWriter jsonWriter, final InetAddress inetAddress) {
        String hostAddress;
        if (inetAddress == null) {
            hostAddress = null;
        }
        else {
            hostAddress = inetAddress.getHostAddress();
        }
        jsonWriter.value(hostAddress);
    }
}
