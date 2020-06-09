// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.io.FileInputStream;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

public class AtomicFile
{
    private final File mBackupName;
    private final File mBaseName;
    
    public AtomicFile(final File mBaseName) {
        this.mBaseName = mBaseName;
        final StringBuilder sb = new StringBuilder();
        sb.append(mBaseName.getPath());
        sb.append(".bak");
        this.mBackupName = new File(sb.toString());
    }
    
    static boolean sync(final FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                final FileDescriptor fd = fileOutputStream.getFD();
                try {
                    fd.sync();
                }
                catch (IOException ex) {
                    return false;
                }
            }
            catch (IOException ex2) {}
        }
        return true;
    }
    
    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }
    
    public void failWrite(final FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                final File mBaseName = this.mBaseName;
                try {
                    mBaseName.delete();
                    final File mBackupName = this.mBackupName;
                    try {
                        mBackupName.renameTo(this.mBaseName);
                    }
                    catch (IOException ex) {
                        Log.w("AtomicFile", "failWrite: Got exception:", (Throwable)ex);
                    }
                }
                catch (IOException ex2) {}
            }
            catch (IOException ex3) {}
        }
    }
    
    public void finishWrite(final FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                final File mBackupName = this.mBackupName;
                try {
                    mBackupName.delete();
                }
                catch (IOException ex) {
                    Log.w("AtomicFile", "finishWrite: Got exception:", (Throwable)ex);
                }
            }
            catch (IOException ex2) {}
        }
    }
    
    public File getBaseFile() {
        return this.mBaseName;
    }
    
    public FileInputStream openRead() {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new FileInputStream(this.mBaseName);
    }
    
    public byte[] readFully() {
        final FileInputStream openRead = this.openRead();
        int n = 0;
        try {
            byte[] array = new byte[openRead.available()];
            while (true) {
                final int read = openRead.read(array, n, array.length - n);
                if (read <= 0) {
                    break;
                }
                n += read;
                final int available = openRead.available();
                if (available <= array.length - n) {
                    continue;
                }
                final byte[] array2 = new byte[n + available];
                System.arraycopy(array, 0, array2, 0, n);
                array = array2;
            }
            return array;
        }
        finally {
            openRead.close();
        }
    }
    
    public FileOutputStream startWrite() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //     4: astore_1       
        //     5: aload_1        
        //     6: invokevirtual   java/io/File.exists:()Z
        //     9: istore_2       
        //    10: iload_2        
        //    11: ifeq            129
        //    14: aload_0        
        //    15: getfield        android/support/v4/util/AtomicFile.mBackupName:Ljava/io/File;
        //    18: astore_1       
        //    19: aload_1        
        //    20: invokevirtual   java/io/File.exists:()Z
        //    23: istore_2       
        //    24: iload_2        
        //    25: ifne            116
        //    28: aload_0        
        //    29: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //    32: astore_1       
        //    33: aload_0        
        //    34: getfield        android/support/v4/util/AtomicFile.mBackupName:Ljava/io/File;
        //    37: astore_3       
        //    38: aload_1        
        //    39: aload_3        
        //    40: invokevirtual   java/io/File.renameTo:(Ljava/io/File;)Z
        //    43: istore_2       
        //    44: iload_2        
        //    45: ifne            113
        //    48: ldc             "AtomicFile"
        //    50: astore_1       
        //    51: new             Ljava/lang/StringBuilder;
        //    54: astore_3       
        //    55: aload_3        
        //    56: invokespecial   java/lang/StringBuilder.<init>:()V
        //    59: aload_3        
        //    60: ldc             "Couldn't rename file "
        //    62: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    65: pop            
        //    66: aload_0        
        //    67: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //    70: astore          4
        //    72: aload_3        
        //    73: aload           4
        //    75: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    78: pop            
        //    79: aload_3        
        //    80: ldc             " to backup file "
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: pop            
        //    86: aload_0        
        //    87: getfield        android/support/v4/util/AtomicFile.mBackupName:Ljava/io/File;
        //    90: astore          4
        //    92: aload_3        
        //    93: aload           4
        //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    98: pop            
        //    99: aload_3        
        //   100: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   103: astore_3       
        //   104: aload_1        
        //   105: aload_3        
        //   106: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   109: pop            
        //   110: goto            129
        //   113: goto            129
        //   116: aload_0        
        //   117: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   120: astore_1       
        //   121: aload_1        
        //   122: invokevirtual   java/io/File.delete:()Z
        //   125: pop            
        //   126: goto            129
        //   129: iconst_0       
        //   130: istore_2       
        //   131: aconst_null    
        //   132: astore_1       
        //   133: new             Ljava/io/FileOutputStream;
        //   136: astore_3       
        //   137: aload_0        
        //   138: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   141: astore          4
        //   143: aload_3        
        //   144: aload           4
        //   146: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   149: aload_3        
        //   150: astore_1       
        //   151: goto            197
        //   154: astore_3       
        //   155: aload_0        
        //   156: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   159: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   162: astore          4
        //   164: aload           4
        //   166: invokevirtual   java/io/File.mkdirs:()Z
        //   169: istore          5
        //   171: iload           5
        //   173: ifeq            255
        //   176: new             Ljava/io/FileOutputStream;
        //   179: astore          6
        //   181: aload_0        
        //   182: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   185: astore          7
        //   187: aload           6
        //   189: aload           7
        //   191: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   194: aload           6
        //   196: astore_1       
        //   197: aload_1        
        //   198: areturn        
        //   199: astore          6
        //   201: new             Ljava/io/IOException;
        //   204: astore          7
        //   206: new             Ljava/lang/StringBuilder;
        //   209: astore          8
        //   211: aload           8
        //   213: invokespecial   java/lang/StringBuilder.<init>:()V
        //   216: aload           8
        //   218: ldc             "Couldn't create "
        //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: pop            
        //   224: aload_0        
        //   225: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   228: astore          9
        //   230: aload           8
        //   232: aload           9
        //   234: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   237: pop            
        //   238: aload           8
        //   240: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   243: astore          8
        //   245: aload           7
        //   247: aload           8
        //   249: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   252: aload           7
        //   254: athrow         
        //   255: new             Ljava/io/IOException;
        //   258: astore          6
        //   260: new             Ljava/lang/StringBuilder;
        //   263: astore          7
        //   265: aload           7
        //   267: invokespecial   java/lang/StringBuilder.<init>:()V
        //   270: aload           7
        //   272: ldc             "Couldn't create directory "
        //   274: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: pop            
        //   278: aload_0        
        //   279: getfield        android/support/v4/util/AtomicFile.mBaseName:Ljava/io/File;
        //   282: astore          8
        //   284: aload           7
        //   286: aload           8
        //   288: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   291: pop            
        //   292: aload           7
        //   294: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   297: astore          7
        //   299: aload           6
        //   301: aload           7
        //   303: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   306: aload           6
        //   308: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  133    136    154    309    Ljava/io/FileNotFoundException;
        //  137    141    154    309    Ljava/io/FileNotFoundException;
        //  144    149    154    309    Ljava/io/FileNotFoundException;
        //  176    179    199    255    Ljava/io/FileNotFoundException;
        //  181    185    199    255    Ljava/io/FileNotFoundException;
        //  189    194    199    255    Ljava/io/FileNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 160, Size: 160
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
}
