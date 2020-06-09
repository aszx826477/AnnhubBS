// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import android.os.Binder;
import android.os.Process;

class ModernAsyncTask$2 extends ModernAsyncTask$WorkerRunnable
{
    final /* synthetic */ ModernAsyncTask this$0;
    
    ModernAsyncTask$2(final ModernAsyncTask this$0) {
        this.this$0 = this$0;
    }
    
    public Object call() {
        final AtomicBoolean access$000 = this.this$0.mTaskInvoked;
        final boolean b = true;
        access$000.set(b);
        Object doInBackground = null;
        final int threadPriority = 10;
        try {
            Process.setThreadPriority(threadPriority);
            final Object o = doInBackground = this.this$0.doInBackground(this.mParams);
            Binder.flushPendingCommands();
            this.this$0.postResult(o);
            return o;
        }
        finally {
            this.this$0.mCancelled.set(b);
            this.this$0.postResult(doInBackground);
            throw;
        }
    }
}
