// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.io.IOException;
import com.google.gson.internal.Streams;
import java.io.Writer;
import com.google.gson.stream.JsonWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.math.BigDecimal;

public abstract class JsonElement
{
    abstract JsonElement deepCopy();
    
    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    Boolean getAsBooleanWrapper() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public byte getAsByte() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public char getAsCharacter() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public double getAsDouble() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public float getAsFloat() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public int getAsInt() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public JsonArray getAsJsonArray() {
        if (this.isJsonArray()) {
            return (JsonArray)this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }
    
    public JsonNull getAsJsonNull() {
        if (this.isJsonNull()) {
            return (JsonNull)this;
        }
        throw new IllegalStateException("This is not a JSON Null.");
    }
    
    public JsonObject getAsJsonObject() {
        if (this.isJsonObject()) {
            return (JsonObject)this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Object: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
    
    public JsonPrimitive getAsJsonPrimitive() {
        if (this.isJsonPrimitive()) {
            return (JsonPrimitive)this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }
    
    public long getAsLong() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public Number getAsNumber() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public short getAsShort() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public String getAsString() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }
    
    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }
    
    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }
    
    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }
    
    public String toString() {
        try {
            try {
                final StringWriter stringWriter = new StringWriter();
                final JsonWriter jsonWriter = new JsonWriter(stringWriter);
                jsonWriter.setLenient(true);
                try {
                    Streams.write(this, jsonWriter);
                    return stringWriter.toString();
                }
                catch (IOException ex) {
                    throw new AssertionError((Object)ex);
                }
            }
            catch (IOException ex2) {}
        }
        catch (IOException ex3) {}
    }
}
