// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.JsonNull;
import java.util.Map;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonToken;
import com.google.gson.JsonElement;
import java.io.Reader;
import com.google.gson.stream.JsonReader;

public final class JsonTreeReader extends JsonReader
{
    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;
    
    static {
        UNREADABLE_READER = new JsonTreeReader$1();
        SENTINEL_CLOSED = new Object();
    }
    
    public JsonTreeReader(final JsonElement jsonElement) {
        super(JsonTreeReader.UNREADABLE_READER);
        final int n = 32;
        this.stack = new Object[n];
        this.stackSize = 0;
        this.pathNames = new String[n];
        this.pathIndices = new int[n];
        this.push(jsonElement);
    }
    
    private void expect(final JsonToken jsonToken) {
        if (this.peek() == jsonToken) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(jsonToken);
        sb.append(" but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    private String locationString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" at path ");
        sb.append(this.getPath());
        return sb.toString();
    }
    
    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }
    
    private Object popStack() {
        final Object[] stack = this.stack;
        final int stackSize = this.stackSize - 1;
        this.stackSize = stackSize;
        final Object o = stack[stackSize];
        stack[this.stackSize] = null;
        return o;
    }
    
    private void push(final Object o) {
        final int stackSize = this.stackSize;
        final Object[] stack = this.stack;
        if (stackSize == stack.length) {
            final Object[] stack2 = new Object[stackSize * 2];
            final int[] pathIndices = new int[stackSize * 2];
            final String[] pathNames = new String[stackSize * 2];
            System.arraycopy(stack, 0, stack2, 0, stackSize);
            System.arraycopy(this.pathIndices, 0, pathIndices, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, pathNames, 0, this.stackSize);
            this.stack = stack2;
            this.pathIndices = pathIndices;
            this.pathNames = pathNames;
        }
        this.stack[this.stackSize++] = o;
    }
    
    public void beginArray() {
        this.expect(JsonToken.BEGIN_ARRAY);
        this.push(((JsonArray)this.peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }
    
    public void beginObject() {
        this.expect(JsonToken.BEGIN_OBJECT);
        this.push(((JsonObject)this.peekStack()).entrySet().iterator());
    }
    
    public void close() {
        final int stackSize = 1;
        final Object[] stack = new Object[stackSize];
        stack[0] = JsonTreeReader.SENTINEL_CLOSED;
        this.stack = stack;
        this.stackSize = stackSize;
    }
    
    public void endArray() {
        this.expect(JsonToken.END_ARRAY);
        this.popStack();
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    public void endObject() {
        this.expect(JsonToken.END_OBJECT);
        this.popStack();
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    public String getPath() {
        final StringBuilder append = new StringBuilder().append('$');
        for (int i = 0; i < this.stackSize; ++i) {
            final Object[] stack = this.stack;
            if (stack[i] instanceof JsonArray) {
                ++i;
                if (stack[i] instanceof Iterator) {
                    append.append('[');
                    append.append(this.pathIndices[i]);
                    append.append(']');
                }
            }
            else if (stack[i] instanceof JsonObject) {
                ++i;
                if (stack[i] instanceof Iterator) {
                    append.append('.');
                    final String[] pathNames = this.pathNames;
                    if (pathNames[i] != null) {
                        append.append(pathNames[i]);
                    }
                }
            }
        }
        return append.toString();
    }
    
    public boolean hasNext() {
        final JsonToken peek = this.peek();
        return peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY;
    }
    
    public boolean nextBoolean() {
        this.expect(JsonToken.BOOLEAN);
        final boolean asBoolean = ((JsonPrimitive)this.popStack()).getAsBoolean();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
        return asBoolean;
    }
    
    public double nextDouble() {
        final JsonToken peek = this.peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(JsonToken.NUMBER);
            sb.append(" but was ");
            sb.append(peek);
            sb.append(this.locationString());
            throw new IllegalStateException(sb.toString());
        }
        final double asDouble = ((JsonPrimitive)this.peekStack()).getAsDouble();
        if (!this.isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("JSON forbids NaN and infinities: ");
            sb2.append(asDouble);
            throw new NumberFormatException(sb2.toString());
        }
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
        return asDouble;
    }
    
    public int nextInt() {
        final JsonToken peek = this.peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(JsonToken.NUMBER);
            sb.append(" but was ");
            sb.append(peek);
            sb.append(this.locationString());
            throw new IllegalStateException(sb.toString());
        }
        final int asInt = ((JsonPrimitive)this.peekStack()).getAsInt();
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
        return asInt;
    }
    
    public long nextLong() {
        final JsonToken peek = this.peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(JsonToken.NUMBER);
            sb.append(" but was ");
            sb.append(peek);
            sb.append(this.locationString());
            throw new IllegalStateException(sb.toString());
        }
        final long asLong = ((JsonPrimitive)this.peekStack()).getAsLong();
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
        return asLong;
    }
    
    public String nextName() {
        this.expect(JsonToken.NAME);
        final Map.Entry<String, V> entry = ((Iterator)this.peekStack()).next();
        final String s = entry.getKey();
        this.pathNames[this.stackSize - 1] = s;
        this.push(entry.getValue());
        return s;
    }
    
    public void nextNull() {
        this.expect(JsonToken.NULL);
        this.popStack();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    public String nextString() {
        final JsonToken peek = this.peek();
        if (peek != JsonToken.STRING && peek != JsonToken.NUMBER) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(JsonToken.STRING);
            sb.append(" but was ");
            sb.append(peek);
            sb.append(this.locationString());
            throw new IllegalStateException(sb.toString());
        }
        final String asString = ((JsonPrimitive)this.popStack()).getAsString();
        final int stackSize = this.stackSize;
        if (stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = stackSize - 1;
            ++pathIndices[n];
        }
        return asString;
    }
    
    public JsonToken peek() {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        final Object peekStack = this.peekStack();
        if (peekStack instanceof Iterator) {
            final boolean b = this.stack[this.stackSize - 2] instanceof JsonObject;
            final Iterator<Object> iterator = (Iterator<Object>)peekStack;
            if (!iterator.hasNext()) {
                JsonToken jsonToken;
                if (b) {
                    jsonToken = JsonToken.END_OBJECT;
                }
                else {
                    jsonToken = JsonToken.END_ARRAY;
                }
                return jsonToken;
            }
            if (b) {
                return JsonToken.NAME;
            }
            this.push(iterator.next());
            return this.peek();
        }
        else {
            if (peekStack instanceof JsonObject) {
                return JsonToken.BEGIN_OBJECT;
            }
            if (peekStack instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (peekStack instanceof JsonPrimitive) {
                final JsonPrimitive jsonPrimitive = (JsonPrimitive)peekStack;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            }
            else {
                if (peekStack instanceof JsonNull) {
                    return JsonToken.NULL;
                }
                if (peekStack == JsonTreeReader.SENTINEL_CLOSED) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }
    
    public void promoteNameToValue() {
        this.expect(JsonToken.NAME);
        final Map.Entry<K, Object> entry = ((Iterator)this.peekStack()).next();
        this.push(entry.getValue());
        this.push(new JsonPrimitive((String)entry.getKey()));
    }
    
    public void skipValue() {
        if (this.peek() == JsonToken.NAME) {
            this.nextName();
            this.pathNames[this.stackSize - 2] = "null";
        }
        else {
            this.popStack();
            this.pathNames[this.stackSize - 1] = "null";
        }
        final int[] pathIndices = this.pathIndices;
        final int n = this.stackSize - 1;
        ++pathIndices[n];
    }
    
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
