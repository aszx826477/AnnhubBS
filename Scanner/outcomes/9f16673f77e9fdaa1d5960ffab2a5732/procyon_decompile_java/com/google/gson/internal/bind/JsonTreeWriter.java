// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonNull;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonElement;
import java.io.Writer;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;

public final class JsonTreeWriter extends JsonWriter
{
    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;
    private String pendingName;
    private JsonElement product;
    private final List stack;
    
    static {
        UNWRITABLE_WRITER = new JsonTreeWriter$1();
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }
    
    public JsonTreeWriter() {
        super(JsonTreeWriter.UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }
    
    private JsonElement peek() {
        final List stack = this.stack;
        return stack.get(stack.size() - 1);
    }
    
    private void put(final JsonElement product) {
        if (this.pendingName != null) {
            if (!product.isJsonNull() || this.getSerializeNulls()) {
                ((JsonObject)this.peek()).add(this.pendingName, product);
            }
            this.pendingName = null;
        }
        else if (this.stack.isEmpty()) {
            this.product = product;
        }
        else {
            final JsonElement peek = this.peek();
            if (!(peek instanceof JsonArray)) {
                throw new IllegalStateException();
            }
            ((JsonArray)peek).add(product);
        }
    }
    
    public JsonWriter beginArray() {
        final JsonArray jsonArray = new JsonArray();
        this.put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }
    
    public JsonWriter beginObject() {
        final JsonObject jsonObject = new JsonObject();
        this.put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }
    
    public void close() {
        if (this.stack.isEmpty()) {
            this.stack.add(JsonTreeWriter.SENTINEL_CLOSED);
            return;
        }
        throw new IOException("Incomplete document");
    }
    
    public JsonWriter endArray() {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (this.peek() instanceof JsonArray) {
            final List stack = this.stack;
            stack.remove(stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }
    
    public JsonWriter endObject() {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (this.peek() instanceof JsonObject) {
            final List stack = this.stack;
            stack.remove(stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }
    
    public void flush() {
    }
    
    public JsonElement get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected one JSON element but was ");
        sb.append(this.stack);
        throw new IllegalStateException(sb.toString());
    }
    
    public JsonWriter name(final String pendingName) {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (this.peek() instanceof JsonObject) {
            this.pendingName = pendingName;
            return this;
        }
        throw new IllegalStateException();
    }
    
    public JsonWriter nullValue() {
        this.put(JsonNull.INSTANCE);
        return this;
    }
    
    public JsonWriter value(final double n) {
        if (!this.isLenient() && (Double.isNaN(n) || Double.isInfinite(n))) {
            final StringBuilder sb = new StringBuilder();
            sb.append("JSON forbids NaN and infinities: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        this.put(new JsonPrimitive(n));
        return this;
    }
    
    public JsonWriter value(final long n) {
        this.put(new JsonPrimitive(n));
        return this;
    }
    
    public JsonWriter value(final Boolean b) {
        if (b == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(b));
        return this;
    }
    
    public JsonWriter value(final Number n) {
        if (n == null) {
            return this.nullValue();
        }
        if (!this.isLenient()) {
            final double doubleValue = n.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("JSON forbids NaN and infinities: ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.put(new JsonPrimitive(n));
        return this;
    }
    
    public JsonWriter value(final String s) {
        if (s == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(s));
        return this;
    }
    
    public JsonWriter value(final boolean b) {
        this.put(new JsonPrimitive(Boolean.valueOf(b)));
        return this;
    }
}
