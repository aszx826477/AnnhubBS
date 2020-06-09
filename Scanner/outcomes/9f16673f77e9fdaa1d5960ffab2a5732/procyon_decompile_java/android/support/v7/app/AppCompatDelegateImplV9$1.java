// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

class AppCompatDelegateImplV9$1 implements Runnable
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$1(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1) != 0x0) {
            this.this$0.doInvalidatePanelMenu(0);
        }
        if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1000) != 0x0) {
            this.this$0.doInvalidatePanelMenu(108);
        }
        final AppCompatDelegateImplV9 this$0 = this.this$0;
        this$0.mInvalidatePanelMenuPosted = false;
        this$0.mInvalidatePanelMenuFeatures = 0;
    }
}
