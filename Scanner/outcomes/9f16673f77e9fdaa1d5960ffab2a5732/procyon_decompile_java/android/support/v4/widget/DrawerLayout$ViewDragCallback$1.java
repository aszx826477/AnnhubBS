// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

class DrawerLayout$ViewDragCallback$1 implements Runnable
{
    final /* synthetic */ DrawerLayout$ViewDragCallback this$1;
    
    DrawerLayout$ViewDragCallback$1(final DrawerLayout$ViewDragCallback this$1) {
        this.this$1 = this$1;
    }
    
    public void run() {
        this.this$1.peekDrawer();
    }
}
