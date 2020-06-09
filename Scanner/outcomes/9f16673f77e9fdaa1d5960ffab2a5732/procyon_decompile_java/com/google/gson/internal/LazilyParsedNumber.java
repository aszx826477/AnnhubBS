// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number
{
    private final String value;
    
    public LazilyParsedNumber(final String value) {
        this.value = value;
    }
    
    private Object writeReplace() {
        return new BigDecimal(this.value);
    }
    
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }
    
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return b;
        }
        if (o instanceof LazilyParsedNumber) {
            final LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber)o;
            final String value = this.value;
            final String value2 = lazilyParsedNumber.value;
            if (value != value2) {
                if (!value.equals(value2)) {
                    b = false;
                }
            }
            return b;
        }
        return false;
    }
    
    public float floatValue() {
        return Float.parseFloat(this.value);
    }
    
    public int hashCode() {
        return this.value.hashCode();
    }
    
    public int intValue() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/gson/internal/LazilyParsedNumber.value:Ljava/lang/String;
        //     4: astore_1       
        //     5: aload_1        
        //     6: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //     9: ireturn        
        //    10: astore_1       
        //    11: aload_0        
        //    12: getfield        com/google/gson/internal/LazilyParsedNumber.value:Ljava/lang/String;
        //    15: astore_2       
        //    16: aload_2        
        //    17: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //    20: l2i            
        //    21: ireturn        
        //    22: astore_2       
        //    23: new             Ljava/math/BigDecimal;
        //    26: astore_3       
        //    27: aload_0        
        //    28: getfield        com/google/gson/internal/LazilyParsedNumber.value:Ljava/lang/String;
        //    31: astore          4
        //    33: aload_3        
        //    34: aload           4
        //    36: invokespecial   java/math/BigDecimal.<init>:(Ljava/lang/String;)V
        //    39: aload_3        
        //    40: invokevirtual   java/math/BigDecimal.intValue:()I
        //    43: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  0      4      10     44     Ljava/lang/NumberFormatException;
        //  5      9      10     44     Ljava/lang/NumberFormatException;
        //  11     15     22     44     Ljava/lang/NumberFormatException;
        //  16     20     22     44     Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 26, Size: 26
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
    
    public long longValue() {
        try {
            final String value = this.value;
            try {
                return Long.parseLong(value);
            }
            catch (NumberFormatException ex) {
                return new BigDecimal(this.value).longValue();
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    public String toString() {
        return this.value;
    }
}
