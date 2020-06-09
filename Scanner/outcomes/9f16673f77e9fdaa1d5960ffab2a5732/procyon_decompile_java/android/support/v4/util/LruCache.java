// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Map;
import java.util.LinkedHashMap;

public class LruCache
{
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
    
    public LruCache(final int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            this.map = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }
    
    private int safeSizeOf(final Object o, final Object o2) {
        final int size = this.sizeOf(o, o2);
        if (size >= 0) {
            return size;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Negative size: ");
        sb.append(o);
        sb.append("=");
        sb.append(o2);
        throw new IllegalStateException(sb.toString());
    }
    
    protected Object create(final Object o) {
        return null;
    }
    
    public final int createCount() {
        synchronized (this) {
            return this.createCount;
        }
    }
    
    protected void entryRemoved(final boolean b, final Object o, final Object o2, final Object o3) {
    }
    
    public final void evictAll() {
        this.trimToSize(-1);
    }
    
    public final int evictionCount() {
        synchronized (this) {
            return this.evictionCount;
        }
    }
    
    public final Object get(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: ifnull          204
        //     4: aload_0        
        //     5: monitorenter   
        //     6: iconst_0       
        //     7: istore_2       
        //     8: aconst_null    
        //     9: astore_3       
        //    10: aload_0        
        //    11: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    14: astore          4
        //    16: aload           4
        //    18: aload_1        
        //    19: invokevirtual   java/util/LinkedHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    22: astore          4
        //    24: aload           4
        //    26: ifnull          46
        //    29: aload_0        
        //    30: getfield        android/support/v4/util/LruCache.hitCount:I
        //    33: iconst_1       
        //    34: iadd           
        //    35: istore_2       
        //    36: aload_0        
        //    37: iload_2        
        //    38: putfield        android/support/v4/util/LruCache.hitCount:I
        //    41: aload_0        
        //    42: monitorexit    
        //    43: aload           4
        //    45: areturn        
        //    46: aload_0        
        //    47: getfield        android/support/v4/util/LruCache.missCount:I
        //    50: iconst_1       
        //    51: iadd           
        //    52: istore          5
        //    54: aload_0        
        //    55: iload           5
        //    57: putfield        android/support/v4/util/LruCache.missCount:I
        //    60: aload_0        
        //    61: monitorexit    
        //    62: aload_0        
        //    63: aload_1        
        //    64: invokevirtual   android/support/v4/util/LruCache.create:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: astore          6
        //    69: aload           6
        //    71: ifnonnull       76
        //    74: aconst_null    
        //    75: areturn        
        //    76: aload_0        
        //    77: monitorenter   
        //    78: aload_0        
        //    79: getfield        android/support/v4/util/LruCache.createCount:I
        //    82: iconst_1       
        //    83: iadd           
        //    84: istore_2       
        //    85: aload_0        
        //    86: iload_2        
        //    87: putfield        android/support/v4/util/LruCache.createCount:I
        //    90: aload_0        
        //    91: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    94: astore_3       
        //    95: aload_3        
        //    96: aload_1        
        //    97: aload           6
        //    99: invokevirtual   java/util/LinkedHashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: astore_3       
        //   103: aload_3        
        //   104: astore          4
        //   106: aload_3        
        //   107: ifnull          126
        //   110: aload_0        
        //   111: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //   114: astore_3       
        //   115: aload_3        
        //   116: aload_1        
        //   117: aload           4
        //   119: invokevirtual   java/util/LinkedHashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   122: pop            
        //   123: goto            150
        //   126: aload_0        
        //   127: getfield        android/support/v4/util/LruCache.size:I
        //   130: istore_2       
        //   131: aload_0        
        //   132: aload_1        
        //   133: aload           6
        //   135: invokespecial   android/support/v4/util/LruCache.safeSizeOf:(Ljava/lang/Object;Ljava/lang/Object;)I
        //   138: istore          7
        //   140: iload_2        
        //   141: iload           7
        //   143: iadd           
        //   144: istore_2       
        //   145: aload_0        
        //   146: iload_2        
        //   147: putfield        android/support/v4/util/LruCache.size:I
        //   150: aload_0        
        //   151: monitorexit    
        //   152: aload           4
        //   154: ifnull          170
        //   157: aload_0        
        //   158: iconst_0       
        //   159: aload_1        
        //   160: aload           6
        //   162: aload           4
        //   164: invokevirtual   android/support/v4/util/LruCache.entryRemoved:(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   167: aload           4
        //   169: areturn        
        //   170: aload_0        
        //   171: getfield        android/support/v4/util/LruCache.maxSize:I
        //   174: istore_2       
        //   175: aload_0        
        //   176: iload_2        
        //   177: invokevirtual   android/support/v4/util/LruCache.trimToSize:(I)V
        //   180: aload           6
        //   182: areturn        
        //   183: astore_3       
        //   184: aload_0        
        //   185: monitorexit    
        //   186: aload_3        
        //   187: athrow         
        //   188: astore          8
        //   190: aconst_null    
        //   191: astore          4
        //   193: aload           8
        //   195: astore_3       
        //   196: aload_0        
        //   197: monitorexit    
        //   198: aload_3        
        //   199: athrow         
        //   200: astore_3       
        //   201: goto            196
        //   204: new             Ljava/lang/NullPointerException;
        //   207: astore_3       
        //   208: aload_3        
        //   209: ldc             "key == null"
        //   211: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   214: aload_3        
        //   215: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     14     188    196    Any
        //  18     22     188    196    Any
        //  29     33     200    204    Any
        //  37     41     200    204    Any
        //  41     43     200    204    Any
        //  46     50     200    204    Any
        //  55     60     200    204    Any
        //  60     62     200    204    Any
        //  78     82     183    188    Any
        //  86     90     183    188    Any
        //  90     94     183    188    Any
        //  97     102    183    188    Any
        //  110    114    183    188    Any
        //  117    123    183    188    Any
        //  126    130    183    188    Any
        //  133    138    183    188    Any
        //  146    150    183    188    Any
        //  150    152    183    188    Any
        //  184    186    183    188    Any
        //  196    198    200    204    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0046:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public final int hitCount() {
        synchronized (this) {
            return this.hitCount;
        }
    }
    
    public final int maxSize() {
        synchronized (this) {
            return this.maxSize;
        }
    }
    
    public final int missCount() {
        synchronized (this) {
            return this.missCount;
        }
    }
    
    public final Object put(final Object o, final Object o2) {
        if (o != null && o2 != null) {
            synchronized (this) {
                ++this.putCount;
                this.size += this.safeSizeOf(o, o2);
                final Object put = this.map.put(o, o2);
                if (put != null) {
                    this.size -= this.safeSizeOf(o, put);
                }
                // monitorexit(this)
                if (put != null) {
                    this.entryRemoved(false, o, put, o2);
                }
                this.trimToSize(this.maxSize);
                return put;
            }
        }
        throw new NullPointerException("key == null || value == null");
    }
    
    public final int putCount() {
        synchronized (this) {
            return this.putCount;
        }
    }
    
    public final Object remove(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: ifnull          90
        //     4: aload_0        
        //     5: monitorenter   
        //     6: aconst_null    
        //     7: astore_2       
        //     8: aload_0        
        //     9: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    12: astore_3       
        //    13: aload_3        
        //    14: aload_1        
        //    15: invokevirtual   java/util/LinkedHashMap.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_3        
        //    20: ifnull          53
        //    23: aload_0        
        //    24: getfield        android/support/v4/util/LruCache.size:I
        //    27: istore          4
        //    29: aload_0        
        //    30: aload_1        
        //    31: aload_3        
        //    32: invokespecial   android/support/v4/util/LruCache.safeSizeOf:(Ljava/lang/Object;Ljava/lang/Object;)I
        //    35: istore          5
        //    37: iload           4
        //    39: iload           5
        //    41: isub           
        //    42: istore          4
        //    44: aload_0        
        //    45: iload           4
        //    47: putfield        android/support/v4/util/LruCache.size:I
        //    50: goto            53
        //    53: aload_0        
        //    54: monitorexit    
        //    55: aload_3        
        //    56: ifnull          73
        //    59: iconst_0       
        //    60: istore          4
        //    62: aload_0        
        //    63: iconst_0       
        //    64: aload_1        
        //    65: aload_3        
        //    66: aconst_null    
        //    67: invokevirtual   android/support/v4/util/LruCache.entryRemoved:(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    70: goto            73
        //    73: aload_3        
        //    74: areturn        
        //    75: astore          6
        //    77: aconst_null    
        //    78: astore_3       
        //    79: aload           6
        //    81: astore_2       
        //    82: aload_0        
        //    83: monitorexit    
        //    84: aload_2        
        //    85: athrow         
        //    86: astore_2       
        //    87: goto            82
        //    90: new             Ljava/lang/NullPointerException;
        //    93: astore_2       
        //    94: aload_2        
        //    95: ldc             "key == null"
        //    97: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   100: aload_2        
        //   101: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  8      12     75     82     Any
        //  14     18     75     82     Any
        //  23     27     86     90     Any
        //  31     35     86     90     Any
        //  45     50     86     90     Any
        //  53     55     86     90     Any
        //  82     84     86     90     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public void resize(final int maxSize) {
        if (maxSize > 0) {
            synchronized (this) {
                this.maxSize = maxSize;
                // monitorexit(this)
                this.trimToSize(maxSize);
                return;
            }
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }
    
    public final int size() {
        synchronized (this) {
            return this.size;
        }
    }
    
    protected int sizeOf(final Object o, final Object o2) {
        return 1;
    }
    
    public final Map snapshot() {
        synchronized (this) {
            return new LinkedHashMap(this.map);
        }
    }
    
    public final String toString() {
        synchronized (this) {
            final int n = this.hitCount + this.missCount;
            int n2;
            if (n != 0) {
                n2 = this.hitCount * 100 / n;
            }
            else {
                n2 = 0;
            }
            return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.maxSize, this.hitCount, this.missCount, n2);
        }
    }
    
    public void trimToSize(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aconst_null    
        //     3: astore_3       
        //     4: aconst_null    
        //     5: astore          4
        //     7: aload_0        
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        android/support/v4/util/LruCache.size:I
        //    13: istore          5
        //    15: iload           5
        //    17: iflt            218
        //    20: aload_0        
        //    21: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    24: astore          6
        //    26: aload           6
        //    28: invokevirtual   java/util/LinkedHashMap.isEmpty:()Z
        //    31: istore          5
        //    33: iload           5
        //    35: ifeq            49
        //    38: aload_0        
        //    39: getfield        android/support/v4/util/LruCache.size:I
        //    42: istore          5
        //    44: iload           5
        //    46: ifne            218
        //    49: aload_0        
        //    50: getfield        android/support/v4/util/LruCache.size:I
        //    53: istore          5
        //    55: iload           5
        //    57: iload_1        
        //    58: if_icmple       215
        //    61: aload_0        
        //    62: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    65: astore          6
        //    67: aload           6
        //    69: invokevirtual   java/util/LinkedHashMap.isEmpty:()Z
        //    72: istore          5
        //    74: iload           5
        //    76: ifeq            82
        //    79: goto            215
        //    82: aload_0        
        //    83: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //    86: astore          6
        //    88: aload           6
        //    90: invokevirtual   java/util/LinkedHashMap.entrySet:()Ljava/util/Set;
        //    93: astore          6
        //    95: aload           6
        //    97: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   102: astore          6
        //   104: aload           6
        //   106: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   111: astore          6
        //   113: aload           6
        //   115: checkcast       Ljava/util/Map$Entry;
        //   118: astore          6
        //   120: aload           6
        //   122: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   127: astore_3       
        //   128: aload           6
        //   130: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   135: astore          4
        //   137: aload_0        
        //   138: getfield        android/support/v4/util/LruCache.map:Ljava/util/LinkedHashMap;
        //   141: astore          7
        //   143: aload           7
        //   145: aload_3        
        //   146: invokevirtual   java/util/LinkedHashMap.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   149: pop            
        //   150: aload_0        
        //   151: getfield        android/support/v4/util/LruCache.size:I
        //   154: istore          8
        //   156: aload_0        
        //   157: aload_3        
        //   158: aload           4
        //   160: invokespecial   android/support/v4/util/LruCache.safeSizeOf:(Ljava/lang/Object;Ljava/lang/Object;)I
        //   163: istore          9
        //   165: iload           8
        //   167: iload           9
        //   169: isub           
        //   170: istore          8
        //   172: aload_0        
        //   173: iload           8
        //   175: putfield        android/support/v4/util/LruCache.size:I
        //   178: aload_0        
        //   179: getfield        android/support/v4/util/LruCache.evictionCount:I
        //   182: istore          8
        //   184: iconst_1       
        //   185: istore          9
        //   187: iload           8
        //   189: iload           9
        //   191: iadd           
        //   192: istore          8
        //   194: aload_0        
        //   195: iload           8
        //   197: putfield        android/support/v4/util/LruCache.evictionCount:I
        //   200: aload_0        
        //   201: monitorexit    
        //   202: aload_0        
        //   203: iload           9
        //   205: aload_3        
        //   206: aload           4
        //   208: aconst_null    
        //   209: invokevirtual   android/support/v4/util/LruCache.entryRemoved:(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   212: goto            7
        //   215: aload_0        
        //   216: monitorexit    
        //   217: return         
        //   218: new             Ljava/lang/IllegalStateException;
        //   221: astore_2       
        //   222: new             Ljava/lang/StringBuilder;
        //   225: astore          6
        //   227: aload           6
        //   229: invokespecial   java/lang/StringBuilder.<init>:()V
        //   232: aload_0        
        //   233: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   236: astore          7
        //   238: aload           7
        //   240: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   243: astore          7
        //   245: aload           6
        //   247: aload           7
        //   249: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   252: pop            
        //   253: ldc             ".sizeOf() is reporting inconsistent results!"
        //   255: astore          7
        //   257: aload           6
        //   259: aload           7
        //   261: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   264: pop            
        //   265: aload           6
        //   267: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   270: astore          6
        //   272: aload_2        
        //   273: aload           6
        //   275: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   278: aload_2        
        //   279: athrow         
        //   280: astore_2       
        //   281: aload_0        
        //   282: monitorexit    
        //   283: aload_2        
        //   284: athrow         
        //   285: astore_2       
        //   286: goto            281
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      13     280    281    Any
        //  20     24     280    281    Any
        //  26     31     280    281    Any
        //  38     42     280    281    Any
        //  49     53     280    281    Any
        //  61     65     280    281    Any
        //  67     72     280    281    Any
        //  82     86     280    281    Any
        //  88     93     280    281    Any
        //  95     102    280    281    Any
        //  104    111    280    281    Any
        //  113    118    280    281    Any
        //  120    127    280    281    Any
        //  128    135    285    289    Any
        //  137    141    285    289    Any
        //  145    150    285    289    Any
        //  150    154    285    289    Any
        //  158    163    285    289    Any
        //  173    178    285    289    Any
        //  178    182    285    289    Any
        //  195    200    285    289    Any
        //  200    202    285    289    Any
        //  215    217    280    281    Any
        //  218    221    280    281    Any
        //  222    225    280    281    Any
        //  227    232    280    281    Any
        //  232    236    280    281    Any
        //  238    243    280    281    Any
        //  247    253    280    281    Any
        //  259    265    280    281    Any
        //  265    270    280    281    Any
        //  273    278    280    281    Any
        //  278    280    280    281    Any
        //  281    283    285    289    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0215:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
}
