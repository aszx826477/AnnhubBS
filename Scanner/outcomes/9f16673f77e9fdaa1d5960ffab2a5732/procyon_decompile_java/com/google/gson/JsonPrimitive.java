// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement
{
    private static final Class[] PRIMITIVE_TYPES;
    private Object value;
    
    static {
        PRIMITIVE_TYPES = new Class[] { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
    }
    
    public JsonPrimitive(final Boolean value) {
        this.setValue(value);
    }
    
    public JsonPrimitive(final Character value) {
        this.setValue(value);
    }
    
    public JsonPrimitive(final Number value) {
        this.setValue(value);
    }
    
    JsonPrimitive(final Object value) {
        this.setValue(value);
    }
    
    public JsonPrimitive(final String value) {
        this.setValue(value);
    }
    
    private static boolean isIntegral(final JsonPrimitive jsonPrimitive) {
        final Object value = jsonPrimitive.value;
        final boolean b = value instanceof Number;
        boolean b2 = false;
        if (b) {
            final Number n = (Number)value;
            if (n instanceof BigInteger || n instanceof Long || n instanceof Integer || n instanceof Short || n instanceof Byte) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    private static boolean isPrimitiveOrString(final Object o) {
        final boolean b = o instanceof String;
        final boolean b2 = true;
        if (b) {
            return b2;
        }
        final Class<?> class1 = o.getClass();
        final Class[] primitive_TYPES = JsonPrimitive.PRIMITIVE_TYPES;
        for (int length = primitive_TYPES.length, i = 0; i < length; ++i) {
            if (primitive_TYPES[i].isAssignableFrom(class1)) {
                return b2;
            }
        }
        return false;
    }
    
    JsonPrimitive deepCopy() {
        return this;
    }
    
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final JsonPrimitive jsonPrimitive = (JsonPrimitive)o;
        if (this.value == null) {
            if (jsonPrimitive.value != null) {
                b = false;
            }
            return b;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            if (this.getAsNumber().longValue() != jsonPrimitive.getAsNumber().longValue()) {
                b = false;
            }
            return b;
        }
        if (this.value instanceof Number && jsonPrimitive.value instanceof Number) {
            final double doubleValue = this.getAsNumber().doubleValue();
            final double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue != doubleValue2) {
                if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                    b = false;
                }
            }
            return b;
        }
        return this.value.equals(jsonPrimitive.value);
    }
    
    public BigDecimal getAsBigDecimal() {
        final Object value = this.value;
        BigDecimal bigDecimal;
        if (value instanceof BigDecimal) {
            bigDecimal = (BigDecimal)value;
        }
        else {
            bigDecimal = new BigDecimal(value.toString());
        }
        return bigDecimal;
    }
    
    public BigInteger getAsBigInteger() {
        final Object value = this.value;
        BigInteger bigInteger;
        if (value instanceof BigInteger) {
            bigInteger = (BigInteger)value;
        }
        else {
            bigInteger = new BigInteger(value.toString());
        }
        return bigInteger;
    }
    
    public boolean getAsBoolean() {
        if (this.isBoolean()) {
            return this.getAsBooleanWrapper();
        }
        return Boolean.parseBoolean(this.getAsString());
    }
    
    Boolean getAsBooleanWrapper() {
        return (Boolean)this.value;
    }
    
    public byte getAsByte() {
        byte b;
        if (this.isNumber()) {
            b = this.getAsNumber().byteValue();
        }
        else {
            b = Byte.parseByte(this.getAsString());
        }
        return b;
    }
    
    public char getAsCharacter() {
        return this.getAsString().charAt(0);
    }
    
    public double getAsDouble() {
        double n;
        if (this.isNumber()) {
            n = this.getAsNumber().doubleValue();
        }
        else {
            n = Double.parseDouble(this.getAsString());
        }
        return n;
    }
    
    public float getAsFloat() {
        float n;
        if (this.isNumber()) {
            n = this.getAsNumber().floatValue();
        }
        else {
            n = Float.parseFloat(this.getAsString());
        }
        return n;
    }
    
    public int getAsInt() {
        int n;
        if (this.isNumber()) {
            n = this.getAsNumber().intValue();
        }
        else {
            n = Integer.parseInt(this.getAsString());
        }
        return n;
    }
    
    public long getAsLong() {
        long n;
        if (this.isNumber()) {
            n = this.getAsNumber().longValue();
        }
        else {
            n = Long.parseLong(this.getAsString());
        }
        return n;
    }
    
    public Number getAsNumber() {
        final Object value = this.value;
        Number n;
        if (value instanceof String) {
            n = new LazilyParsedNumber((String)value);
        }
        else {
            n = (Number)value;
        }
        return n;
    }
    
    public short getAsShort() {
        short n;
        if (this.isNumber()) {
            n = this.getAsNumber().shortValue();
        }
        else {
            n = Short.parseShort(this.getAsString());
        }
        return n;
    }
    
    public String getAsString() {
        if (this.isNumber()) {
            return this.getAsNumber().toString();
        }
        if (this.isBoolean()) {
            return this.getAsBooleanWrapper().toString();
        }
        return (String)this.value;
    }
    
    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        final boolean integral = isIntegral(this);
        final int n = 32;
        if (integral) {
            final long longValue = this.getAsNumber().longValue();
            return (int)(longValue >>> n ^ longValue);
        }
        final Object value = this.value;
        if (value instanceof Number) {
            final long doubleToLongBits = Double.doubleToLongBits(this.getAsNumber().doubleValue());
            return (int)(doubleToLongBits >>> n ^ doubleToLongBits);
        }
        return value.hashCode();
    }
    
    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }
    
    public boolean isNumber() {
        return this.value instanceof Number;
    }
    
    public boolean isString() {
        return this.value instanceof String;
    }
    
    void setValue(final Object value) {
        if (value instanceof Character) {
            this.value = String.valueOf((char)value);
        }
        else {
            $Gson$Preconditions.checkArgument(value instanceof Number || isPrimitiveOrString(value));
            this.value = value;
        }
    }
}
