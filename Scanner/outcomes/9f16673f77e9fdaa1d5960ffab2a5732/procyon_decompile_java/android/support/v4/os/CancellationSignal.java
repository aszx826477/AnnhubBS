// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Build$VERSION;

public final class CancellationSignal
{
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private CancellationSignal$OnCancelListener mOnCancelListener;
    
    private void waitForCancelFinishedLocked() {
    Label_0013_Outer:
        while (this.mCancelInProgress) {
            while (true) {
                try {
                    this.wait();
                    continue Label_0013_Outer;
                }
                catch (InterruptedException ex) {
                    continue;
                }
                break;
            }
            break;
        }
    }
    
    public void cancel() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aconst_null    
        //     3: astore_1       
        //     4: aload_0        
        //     5: getfield        android/support/v4/os/CancellationSignal.mIsCanceled:Z
        //     8: istore_2       
        //     9: iload_2        
        //    10: ifeq            16
        //    13: aload_0        
        //    14: monitorexit    
        //    15: return         
        //    16: iconst_1       
        //    17: istore_2       
        //    18: aload_0        
        //    19: iload_2        
        //    20: putfield        android/support/v4/os/CancellationSignal.mIsCanceled:Z
        //    23: aload_0        
        //    24: iload_2        
        //    25: putfield        android/support/v4/os/CancellationSignal.mCancelInProgress:Z
        //    28: aload_0        
        //    29: getfield        android/support/v4/os/CancellationSignal.mOnCancelListener:Landroid/support/v4/os/CancellationSignal$OnCancelListener;
        //    32: astore_3       
        //    33: aload_3        
        //    34: astore          4
        //    36: aload_0        
        //    37: getfield        android/support/v4/os/CancellationSignal.mCancellationSignalObj:Ljava/lang/Object;
        //    40: astore_1       
        //    41: aload_0        
        //    42: monitorexit    
        //    43: iconst_0       
        //    44: istore_2       
        //    45: aconst_null    
        //    46: astore_3       
        //    47: aload           4
        //    49: ifnull          67
        //    52: aload           4
        //    54: invokeinterface android/support/v4/os/CancellationSignal$OnCancelListener.onCancel:()V
        //    59: goto            67
        //    62: astore          5
        //    64: goto            78
        //    67: aload_1        
        //    68: ifnull          99
        //    71: aload_1        
        //    72: invokestatic    android/support/v4/os/CancellationSignalCompatJellybean.cancel:(Ljava/lang/Object;)V
        //    75: goto            99
        //    78: aload_0        
        //    79: monitorenter   
        //    80: aload_0        
        //    81: iconst_0       
        //    82: putfield        android/support/v4/os/CancellationSignal.mCancelInProgress:Z
        //    85: aload_0        
        //    86: invokevirtual   java/lang/Object.notifyAll:()V
        //    89: aload_0        
        //    90: monitorexit    
        //    91: aload           5
        //    93: athrow         
        //    94: astore_3       
        //    95: aload_0        
        //    96: monitorexit    
        //    97: aload_3        
        //    98: athrow         
        //    99: aload_0        
        //   100: monitorenter   
        //   101: aload_0        
        //   102: iconst_0       
        //   103: putfield        android/support/v4/os/CancellationSignal.mCancelInProgress:Z
        //   106: aload_0        
        //   107: invokevirtual   java/lang/Object.notifyAll:()V
        //   110: aload_0        
        //   111: monitorexit    
        //   112: return         
        //   113: astore_3       
        //   114: aload_0        
        //   115: monitorexit    
        //   116: aload_3        
        //   117: athrow         
        //   118: astore_3       
        //   119: aconst_null    
        //   120: astore          4
        //   122: aload_0        
        //   123: monitorexit    
        //   124: aload_3        
        //   125: athrow         
        //   126: astore_3       
        //   127: goto            122
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  4      8      118    122    Any
        //  13     15     118    122    Any
        //  19     23     118    122    Any
        //  24     28     118    122    Any
        //  28     32     118    122    Any
        //  36     40     126    130    Any
        //  41     43     126    130    Any
        //  52     59     62     99     Any
        //  71     75     62     99     Any
        //  81     85     94     99     Any
        //  85     89     94     99     Any
        //  89     91     94     99     Any
        //  95     97     94     99     Any
        //  102    106    113    118    Any
        //  106    110    113    118    Any
        //  110    112    113    118    Any
        //  114    116    113    118    Any
        //  122    124    126    130    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
    
    public Object getCancellationSignalObject() {
        if (Build$VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                if (this.mIsCanceled) {
                    CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                }
            }
            return this.mCancellationSignalObj;
        }
    }
    
    public boolean isCanceled() {
        synchronized (this) {
            return this.mIsCanceled;
        }
    }
    
    public void setOnCancelListener(final CancellationSignal$OnCancelListener mOnCancelListener) {
        synchronized (this) {
            this.waitForCancelFinishedLocked();
            if (this.mOnCancelListener == mOnCancelListener) {
                return;
            }
            this.mOnCancelListener = mOnCancelListener;
            if (this.mIsCanceled && mOnCancelListener != null) {
                // monitorexit(this)
                mOnCancelListener.onCancel();
            }
        }
    }
    
    public void throwIfCanceled() {
        if (!this.isCanceled()) {
            return;
        }
        throw new OperationCanceledException();
    }
}
