// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

class ViewPager$3 implements Runnable
{
    final /* synthetic */ ViewPager this$0;
    
    ViewPager$3(final ViewPager this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.setScrollState(0);
        this.this$0.populate();
    }
}
