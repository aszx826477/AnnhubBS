// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable
{
    private final List elements;
    
    public JsonArray() {
        this.elements = new ArrayList();
    }
    
    public void add(JsonElement instance) {
        if (instance == null) {
            instance = JsonNull.INSTANCE;
        }
        this.elements.add(instance);
    }
    
    public void add(final Boolean b) {
        final List elements = this.elements;
        JsonElement instance;
        if (b == null) {
            instance = JsonNull.INSTANCE;
        }
        else {
            instance = new JsonPrimitive(b);
        }
        elements.add(instance);
    }
    
    public void add(final Character c) {
        final List elements = this.elements;
        JsonElement instance;
        if (c == null) {
            instance = JsonNull.INSTANCE;
        }
        else {
            instance = new JsonPrimitive(c);
        }
        elements.add(instance);
    }
    
    public void add(final Number n) {
        final List elements = this.elements;
        JsonElement instance;
        if (n == null) {
            instance = JsonNull.INSTANCE;
        }
        else {
            instance = new JsonPrimitive(n);
        }
        elements.add(instance);
    }
    
    public void add(final String s) {
        final List elements = this.elements;
        JsonElement instance;
        if (s == null) {
            instance = JsonNull.INSTANCE;
        }
        else {
            instance = new JsonPrimitive(s);
        }
        elements.add(instance);
    }
    
    public void addAll(final JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }
    
    public boolean contains(final JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }
    
    JsonArray deepCopy() {
        final JsonArray jsonArray = new JsonArray();
        final Iterator<JsonElement> iterator = this.elements.iterator();
        while (iterator.hasNext()) {
            jsonArray.add(iterator.next().deepCopy());
        }
        return jsonArray;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof JsonArray && ((JsonArray)o).elements.equals(this.elements));
    }
    
    public JsonElement get(final int n) {
        return this.elements.get(n);
    }
    
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }
    
    public BigInteger getAsBigInteger() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }
    
    public boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }
    
    public byte getAsByte() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }
    
    public char getAsCharacter() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }
    
    public double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }
    
    public float getAsFloat() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }
    
    public int getAsInt() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }
    
    public long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }
    
    public Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }
    
    public short getAsShort() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }
    
    public String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new IllegalStateException();
    }
    
    public int hashCode() {
        return this.elements.hashCode();
    }
    
    public Iterator iterator() {
        return this.elements.iterator();
    }
    
    public JsonElement remove(final int n) {
        return this.elements.remove(n);
    }
    
    public boolean remove(final JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }
    
    public JsonElement set(final int n, final JsonElement jsonElement) {
        return this.elements.set(n, jsonElement);
    }
    
    public int size() {
        return this.elements.size();
    }
}
