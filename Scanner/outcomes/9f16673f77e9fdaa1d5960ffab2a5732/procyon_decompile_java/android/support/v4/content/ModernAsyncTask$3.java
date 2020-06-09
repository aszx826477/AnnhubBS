// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class ModernAsyncTask$3 extends FutureTask
{
    final /* synthetic */ ModernAsyncTask this$0;
    
    ModernAsyncTask$3(final ModernAsyncTask this$0, final Callable callable) {
        this.this$0 = this$0;
        super(callable);
    }
    
    protected void done() {
        try {
            final Object value = this.get();
            try {
                this.this$0.postResultIfNotInvoked(value);
            }
            catch (CancellationException ex3) {
                this.this$0.postResultIfNotInvoked(null);
            }
            catch (ExecutionException ex) {
                throw new RuntimeException("An error occurred while executing doInBackground()", ex.getCause());
            }
            catch (InterruptedException ex2) {
                Log.w("AsyncTask", (Throwable)ex2);
            }
        }
        catch (CancellationException ex4) {}
        catch (ExecutionException ex5) {}
        catch (InterruptedException ex6) {}
    }
}
