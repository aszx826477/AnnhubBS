// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.widget.ContentFrameLayout$OnAttachListener;

class AppCompatDelegateImplV9$4 implements ContentFrameLayout$OnAttachListener
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$4(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public void onAttachedFromWindow() {
    }
    
    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }
}
