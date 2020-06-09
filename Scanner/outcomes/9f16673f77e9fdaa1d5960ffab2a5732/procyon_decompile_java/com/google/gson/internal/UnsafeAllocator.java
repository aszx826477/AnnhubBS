// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator
{
    private static void assertInstantiable(final Class clazz) {
        final int modifiers = clazz.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Interface can't be instantiated! Interface name: ");
            sb.append(clazz.getName());
            throw new UnsupportedOperationException(sb.toString());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Abstract class can't be instantiated! Class name: ");
        sb2.append(clazz.getName());
        throw new UnsupportedOperationException(sb2.toString());
    }
    
    public static UnsafeAllocator create() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_0       
        //     2: aconst_null    
        //     3: astore_1       
        //     4: aconst_null    
        //     5: astore_2       
        //     6: iconst_1       
        //     7: istore_3       
        //     8: ldc             "sun.misc.Unsafe"
        //    10: astore          4
        //    12: aload           4
        //    14: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    17: astore          4
        //    19: ldc             "theUnsafe"
        //    21: astore          5
        //    23: aload           4
        //    25: aload           5
        //    27: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    30: astore          5
        //    32: aload           5
        //    34: iload_3        
        //    35: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    38: aload           5
        //    40: aconst_null    
        //    41: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    44: astore          6
        //    46: ldc             "allocateInstance"
        //    48: astore          7
        //    50: iload_3        
        //    51: anewarray       Ljava/lang/Class;
        //    54: astore          8
        //    56: ldc             Ljava/lang/Class;.class
        //    58: astore          9
        //    60: aload           8
        //    62: iconst_0       
        //    63: aload           9
        //    65: aastore        
        //    66: aload           4
        //    68: aload           7
        //    70: aload           8
        //    72: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    75: astore          7
        //    77: new             Lcom/google/gson/internal/UnsafeAllocator$1;
        //    80: astore          8
        //    82: aload           8
        //    84: aload           7
        //    86: aload           6
        //    88: invokespecial   com/google/gson/internal/UnsafeAllocator$1.<init>:(Ljava/lang/reflect/Method;Ljava/lang/Object;)V
        //    91: aload           8
        //    93: areturn        
        //    94: astore          4
        //    96: iconst_2       
        //    97: istore          10
        //    99: ldc             Ljava/io/ObjectStreamClass;.class
        //   101: astore          5
        //   103: ldc             "getConstructorId"
        //   105: astore          6
        //   107: iload_3        
        //   108: anewarray       Ljava/lang/Class;
        //   111: astore          7
        //   113: ldc             Ljava/lang/Class;.class
        //   115: astore          8
        //   117: aload           7
        //   119: iconst_0       
        //   120: aload           8
        //   122: aastore        
        //   123: aload           5
        //   125: aload           6
        //   127: aload           7
        //   129: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   132: astore          5
        //   134: aload           5
        //   136: iload_3        
        //   137: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   140: iload_3        
        //   141: anewarray       Ljava/lang/Object;
        //   144: astore          6
        //   146: ldc             Ljava/lang/Object;.class
        //   148: astore          7
        //   150: aload           6
        //   152: iconst_0       
        //   153: aload           7
        //   155: aastore        
        //   156: aload           5
        //   158: aconst_null    
        //   159: aload           6
        //   161: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   164: astore_1       
        //   165: aload_1        
        //   166: checkcast       Ljava/lang/Integer;
        //   169: astore_1       
        //   170: aload_1        
        //   171: invokevirtual   java/lang/Integer.intValue:()I
        //   174: istore_0       
        //   175: ldc             Ljava/io/ObjectStreamClass;.class
        //   177: astore          6
        //   179: ldc             "newInstance"
        //   181: astore          7
        //   183: iload           10
        //   185: anewarray       Ljava/lang/Class;
        //   188: astore          8
        //   190: ldc             Ljava/lang/Class;.class
        //   192: astore          9
        //   194: aload           8
        //   196: iconst_0       
        //   197: aload           9
        //   199: aastore        
        //   200: getstatic       java/lang/Integer.TYPE:Ljava/lang/Class;
        //   203: astore          9
        //   205: aload           8
        //   207: iload_3        
        //   208: aload           9
        //   210: aastore        
        //   211: aload           6
        //   213: aload           7
        //   215: aload           8
        //   217: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   220: astore          6
        //   222: aload           6
        //   224: iload_3        
        //   225: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   228: new             Lcom/google/gson/internal/UnsafeAllocator$2;
        //   231: astore          7
        //   233: aload           7
        //   235: aload           6
        //   237: iload_0        
        //   238: invokespecial   com/google/gson/internal/UnsafeAllocator$2.<init>:(Ljava/lang/reflect/Method;I)V
        //   241: aload           7
        //   243: areturn        
        //   244: astore_1       
        //   245: ldc             Ljava/io/ObjectInputStream;.class
        //   247: astore_1       
        //   248: ldc             "newInstance"
        //   250: astore          5
        //   252: iload           10
        //   254: anewarray       Ljava/lang/Class;
        //   257: astore          4
        //   259: ldc             Ljava/lang/Class;.class
        //   261: astore          6
        //   263: aload           4
        //   265: iconst_0       
        //   266: aload           6
        //   268: aastore        
        //   269: ldc             Ljava/lang/Class;.class
        //   271: astore_2       
        //   272: aload           4
        //   274: iload_3        
        //   275: aload_2        
        //   276: aastore        
        //   277: aload_1        
        //   278: aload           5
        //   280: aload           4
        //   282: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   285: astore_1       
        //   286: aload_1        
        //   287: iload_3        
        //   288: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   291: new             Lcom/google/gson/internal/UnsafeAllocator$3;
        //   294: astore_2       
        //   295: aload_2        
        //   296: aload_1        
        //   297: invokespecial   com/google/gson/internal/UnsafeAllocator$3.<init>:(Ljava/lang/reflect/Method;)V
        //   300: aload_2        
        //   301: areturn        
        //   302: astore_1       
        //   303: new             Lcom/google/gson/internal/UnsafeAllocator$4;
        //   306: astore_1       
        //   307: aload_1        
        //   308: invokespecial   com/google/gson/internal/UnsafeAllocator$4.<init>:()V
        //   311: aload_1        
        //   312: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  12     17     94     313    Ljava/lang/Exception;
        //  25     30     94     313    Ljava/lang/Exception;
        //  34     38     94     313    Ljava/lang/Exception;
        //  40     44     94     313    Ljava/lang/Exception;
        //  50     54     94     313    Ljava/lang/Exception;
        //  63     66     94     313    Ljava/lang/Exception;
        //  70     75     94     313    Ljava/lang/Exception;
        //  77     80     94     313    Ljava/lang/Exception;
        //  86     91     94     313    Ljava/lang/Exception;
        //  107    111    244    313    Ljava/lang/Exception;
        //  120    123    244    313    Ljava/lang/Exception;
        //  127    132    244    313    Ljava/lang/Exception;
        //  136    140    244    313    Ljava/lang/Exception;
        //  140    144    244    313    Ljava/lang/Exception;
        //  153    156    244    313    Ljava/lang/Exception;
        //  159    164    244    313    Ljava/lang/Exception;
        //  165    169    244    313    Ljava/lang/Exception;
        //  170    174    244    313    Ljava/lang/Exception;
        //  183    188    244    313    Ljava/lang/Exception;
        //  197    200    244    313    Ljava/lang/Exception;
        //  200    203    244    313    Ljava/lang/Exception;
        //  208    211    244    313    Ljava/lang/Exception;
        //  215    220    244    313    Ljava/lang/Exception;
        //  224    228    244    313    Ljava/lang/Exception;
        //  228    231    244    313    Ljava/lang/Exception;
        //  237    241    244    313    Ljava/lang/Exception;
        //  252    257    302    313    Ljava/lang/Exception;
        //  266    269    302    313    Ljava/lang/Exception;
        //  275    277    302    313    Ljava/lang/Exception;
        //  280    285    302    313    Ljava/lang/Exception;
        //  287    291    302    313    Ljava/lang/Exception;
        //  291    294    302    313    Ljava/lang/Exception;
        //  296    300    302    313    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 171, Size: 171
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
    
    public abstract Object newInstance(final Class p0);
}
