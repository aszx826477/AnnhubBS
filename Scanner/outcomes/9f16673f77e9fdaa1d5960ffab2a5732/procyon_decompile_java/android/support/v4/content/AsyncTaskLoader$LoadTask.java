// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask extends ModernAsyncTask implements Runnable
{
    private final CountDownLatch mDone;
    final /* synthetic */ AsyncTaskLoader this$0;
    boolean waiting;
    
    AsyncTaskLoader$LoadTask(final AsyncTaskLoader this$0) {
        this.this$0 = this$0;
        this.mDone = new CountDownLatch(1);
    }
    
    protected Object doInBackground(final Void... array) {
        try {
            final AsyncTaskLoader this$0 = this.this$0;
            try {
                return this$0.onLoadInBackground();
            }
            catch (OperationCanceledException ex) {
                if (this.isCancelled()) {
                    return null;
                }
                throw ex;
            }
        }
        catch (OperationCanceledException ex2) {}
    }
    
    protected void onCancelled(final Object o) {
        try {
            this.this$0.dispatchOnCancelled(this, o);
        }
        finally {
            this.mDone.countDown();
        }
    }
    
    protected void onPostExecute(final Object o) {
        try {
            this.this$0.dispatchOnLoadComplete(this, o);
        }
        finally {
            this.mDone.countDown();
        }
    }
    
    public void run() {
        this.waiting = false;
        this.this$0.executePendingTask();
    }
    
    public void waitForLoader() {
        try {
            final CountDownLatch mDone = this.mDone;
            try {
                mDone.await();
            }
            catch (InterruptedException ex) {}
        }
        catch (InterruptedException ex2) {}
    }
}
