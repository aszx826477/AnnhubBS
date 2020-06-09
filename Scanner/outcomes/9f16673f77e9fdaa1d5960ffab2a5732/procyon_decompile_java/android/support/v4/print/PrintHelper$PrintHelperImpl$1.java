// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

class PrintHelper$PrintHelperImpl$1 implements PrintHelperKitkat$OnPrintFinishCallback
{
    final /* synthetic */ PrintHelper$PrintHelperImpl this$0;
    final /* synthetic */ PrintHelper$OnPrintFinishCallback val$callback;
    
    PrintHelper$PrintHelperImpl$1(final PrintHelper$PrintHelperImpl this$0, final PrintHelper$OnPrintFinishCallback val$callback) {
        this.this$0 = this$0;
        this.val$callback = val$callback;
    }
    
    public void onFinish() {
        this.val$callback.onFinish();
    }
}
