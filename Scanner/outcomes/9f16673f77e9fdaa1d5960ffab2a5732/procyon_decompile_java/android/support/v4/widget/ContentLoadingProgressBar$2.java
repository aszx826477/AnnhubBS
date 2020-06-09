// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

class ContentLoadingProgressBar$2 implements Runnable
{
    final /* synthetic */ ContentLoadingProgressBar this$0;
    
    ContentLoadingProgressBar$2(final ContentLoadingProgressBar this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final ContentLoadingProgressBar this$0 = this.this$0;
        this$0.mPostedShow = false;
        if (!this$0.mDismissed) {
            this.this$0.mStartTime = System.currentTimeMillis();
            this.this$0.setVisibility(0);
        }
    }
}
