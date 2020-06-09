// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.sql.Timestamp;
import java.lang.reflect.Type;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.DateFormat;

final class DefaultDateTypeAdapter implements JsonSerializer, JsonDeserializer
{
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;
    
    DefaultDateTypeAdapter() {
        final Locale us = Locale.US;
        final int n = 2;
        this(DateFormat.getDateTimeInstance(n, n, us), DateFormat.getDateTimeInstance(n, n));
    }
    
    DefaultDateTypeAdapter(final int n) {
        this(DateFormat.getDateInstance(n, Locale.US), DateFormat.getDateInstance(n));
    }
    
    public DefaultDateTypeAdapter(final int n, final int n2) {
        this(DateFormat.getDateTimeInstance(n, n2, Locale.US), DateFormat.getDateTimeInstance(n, n2));
    }
    
    DefaultDateTypeAdapter(final String s) {
        this(new SimpleDateFormat(s, Locale.US), new SimpleDateFormat(s));
    }
    
    DefaultDateTypeAdapter(final DateFormat enUsFormat, final DateFormat localFormat) {
        this.enUsFormat = enUsFormat;
        this.localFormat = localFormat;
    }
    
    private Date deserializeToDate(final JsonElement p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/gson/DefaultDateTypeAdapter.localFormat:Ljava/text/DateFormat;
        //     4: astore_2       
        //     5: aload_2        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/gson/DefaultDateTypeAdapter.localFormat:Ljava/text/DateFormat;
        //    11: astore_3       
        //    12: aload_1        
        //    13: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    16: astore          4
        //    18: aload_3        
        //    19: aload           4
        //    21: invokevirtual   java/text/DateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //    24: astore_3       
        //    25: aload_2        
        //    26: monitorexit    
        //    27: aload_3        
        //    28: areturn        
        //    29: astore_3       
        //    30: goto            110
        //    33: astore_3       
        //    34: aload_0        
        //    35: getfield        com/google/gson/DefaultDateTypeAdapter.enUsFormat:Ljava/text/DateFormat;
        //    38: astore_3       
        //    39: aload_1        
        //    40: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    43: astore          4
        //    45: aload_3        
        //    46: aload           4
        //    48: invokevirtual   java/text/DateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //    51: astore_3       
        //    52: aload_2        
        //    53: monitorexit    
        //    54: aload_3        
        //    55: areturn        
        //    56: astore_3       
        //    57: aload_1        
        //    58: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    61: astore_3       
        //    62: new             Ljava/text/ParsePosition;
        //    65: astore          4
        //    67: aconst_null    
        //    68: astore          5
        //    70: aload           4
        //    72: iconst_0       
        //    73: invokespecial   java/text/ParsePosition.<init>:(I)V
        //    76: aload_3        
        //    77: aload           4
        //    79: invokestatic    com/google/gson/internal/bind/util/ISO8601Utils.parse:(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
        //    82: astore_3       
        //    83: aload_2        
        //    84: monitorexit    
        //    85: aload_3        
        //    86: areturn        
        //    87: astore_3       
        //    88: new             Lcom/google/gson/JsonSyntaxException;
        //    91: astore          4
        //    93: aload_1        
        //    94: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    97: astore          5
        //    99: aload           4
        //   101: aload           5
        //   103: aload_3        
        //   104: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   107: aload           4
        //   109: athrow         
        //   110: aload_2        
        //   111: monitorexit    
        //   112: aload_3        
        //   113: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                      
        //  -----  -----  -----  -----  --------------------------
        //  7      11     33     110    Ljava/text/ParseException;
        //  7      11     29     114    Any
        //  12     16     33     110    Ljava/text/ParseException;
        //  12     16     29     114    Any
        //  19     24     33     110    Ljava/text/ParseException;
        //  19     24     29     114    Any
        //  25     27     29     114    Any
        //  34     38     56     110    Ljava/text/ParseException;
        //  34     38     29     114    Any
        //  39     43     56     110    Ljava/text/ParseException;
        //  39     43     29     114    Any
        //  46     51     56     110    Ljava/text/ParseException;
        //  46     51     29     114    Any
        //  52     54     29     114    Any
        //  57     61     87     110    Ljava/text/ParseException;
        //  57     61     29     114    Any
        //  62     65     87     110    Ljava/text/ParseException;
        //  62     65     29     114    Any
        //  72     76     87     110    Ljava/text/ParseException;
        //  72     76     29     114    Any
        //  77     82     87     110    Ljava/text/ParseException;
        //  77     82     29     114    Any
        //  83     85     29     114    Any
        //  88     91     29     114    Any
        //  93     97     29     114    Any
        //  103    107    29     114    Any
        //  107    110    29     114    Any
        //  110    112    29     114    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 71, Size: 71
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Date deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        if (!(jsonElement instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be a string value");
        }
        final Date deserializeToDate = this.deserializeToDate(jsonElement);
        if (type == Date.class) {
            return deserializeToDate;
        }
        if (type == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass());
        sb.append(" cannot deserialize to ");
        sb.append(type);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public JsonElement serialize(final Date date, final Type type, final JsonSerializationContext jsonSerializationContext) {
        synchronized (this.localFormat) {
            return new JsonPrimitive(this.enUsFormat.format(date));
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(DefaultDateTypeAdapter.class.getSimpleName());
        sb.append('(');
        sb.append(this.localFormat.getClass().getSimpleName());
        sb.append(')');
        return sb.toString();
    }
}
