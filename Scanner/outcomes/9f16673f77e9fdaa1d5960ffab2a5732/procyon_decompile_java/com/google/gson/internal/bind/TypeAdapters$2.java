// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.util.BitSet;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

final class TypeAdapters$2 extends TypeAdapter
{
    public BitSet read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        final BitSet set = new BitSet();
        jsonReader.beginArray();
        int n = 0;
        for (JsonToken jsonToken = jsonReader.peek(); jsonToken != JsonToken.END_ARRAY; jsonToken = jsonReader.peek()) {
            final int n2 = TypeAdapters$36.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            boolean nextBoolean = false;
            switch (n2) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid bitset value type: ");
                    sb.append(jsonToken);
                    throw new JsonSyntaxException(sb.toString());
                }
                case 3: {
                    final String nextString = jsonReader.nextString();
                    try {
                        if (Integer.parseInt(nextString) != 0) {
                            nextBoolean = true;
                        }
                        break;
                    }
                    catch (NumberFormatException ex) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error: Expecting: bitset number value (1, 0), Found: ");
                        sb2.append(nextString);
                        throw new JsonSyntaxException(sb2.toString());
                    }
                }
                case 2: {
                    nextBoolean = jsonReader.nextBoolean();
                    break;
                }
                case 1: {
                    if (jsonReader.nextInt() != 0) {
                        nextBoolean = true;
                        break;
                    }
                    break;
                }
            }
            if (nextBoolean) {
                set.set(n);
            }
            ++n;
        }
        jsonReader.endArray();
        return set;
    }
    
    public void write(final JsonWriter jsonWriter, final BitSet set) {
        if (set == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        for (int i = 0; i < set.length(); ++i) {
            jsonWriter.value(set.get(i) ? 1 : 0);
        }
        jsonWriter.endArray();
    }
}
