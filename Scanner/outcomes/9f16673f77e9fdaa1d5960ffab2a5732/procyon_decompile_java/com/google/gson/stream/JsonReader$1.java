// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.stream;

import java.io.IOException;
import java.io.EOFException;
import java.io.Reader;
import java.io.Closeable;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.JsonReaderInternalAccess;

final class JsonReader$1 extends JsonReaderInternalAccess
{
    public void promoteNameToValue(final JsonReader jsonReader) {
        if (jsonReader instanceof JsonTreeReader) {
            ((JsonTreeReader)jsonReader).promoteNameToValue();
            return;
        }
        int n = jsonReader.peeked;
        if (n == 0) {
            n = jsonReader.doPeek();
        }
        if (n == 13) {
            jsonReader.peeked = 9;
        }
        else if (n == 12) {
            jsonReader.peeked = 8;
        }
        else {
            if (n != 14) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a name but was ");
                sb.append(jsonReader.peek());
                sb.append(jsonReader.locationString());
                throw new IllegalStateException(sb.toString());
            }
            jsonReader.peeked = 10;
        }
    }
}
