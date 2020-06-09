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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

abstract class ModernAsyncTask
{
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static ModernAsyncTask$InternalHandler sHandler;
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final AtomicBoolean mCancelled;
    private final FutureTask mFuture;
    private volatile ModernAsyncTask$Status mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final ModernAsyncTask$WorkerRunnable mWorker;
    
    static {
        sThreadFactory = new ModernAsyncTask$1();
        sPoolWorkQueue = new LinkedBlockingQueue(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, ModernAsyncTask.sPoolWorkQueue, ModernAsyncTask.sThreadFactory);
        ModernAsyncTask.sDefaultExecutor = ModernAsyncTask.THREAD_POOL_EXECUTOR;
    }
    
    public ModernAsyncTask() {
        this.mStatus = ModernAsyncTask$Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        this.mWorker = new ModernAsyncTask$2(this);
        this.mFuture = new ModernAsyncTask$3(this, this.mWorker);
    }
    
    public static void execute(final Runnable runnable) {
        ModernAsyncTask.sDefaultExecutor.execute(runnable);
    }
    
    private static Handler getHandler() {
        synchronized (ModernAsyncTask.class) {
            if (ModernAsyncTask.sHandler == null) {
                ModernAsyncTask.sHandler = new ModernAsyncTask$InternalHandler();
            }
            return ModernAsyncTask.sHandler;
        }
    }
    
    public static void setDefaultExecutor(final Executor sDefaultExecutor) {
        ModernAsyncTask.sDefaultExecutor = sDefaultExecutor;
    }
    
    public final boolean cancel(final boolean b) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(b);
    }
    
    protected abstract Object doInBackground(final Object... p0);
    
    public final ModernAsyncTask execute(final Object... array) {
        return this.executeOnExecutor(ModernAsyncTask.sDefaultExecutor, array);
    }
    
    public final ModernAsyncTask executeOnExecutor(final Executor executor, final Object... mParams) {
        if (this.mStatus != ModernAsyncTask$Status.PENDING) {
            switch (ModernAsyncTask$4.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[this.mStatus.ordinal()]) {
                case 2: {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                case 1: {
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                }
            }
        }
        this.mStatus = ModernAsyncTask$Status.RUNNING;
        this.onPreExecute();
        this.mWorker.mParams = mParams;
        executor.execute(this.mFuture);
        return this;
    }
    
    void finish(final Object o) {
        if (this.isCancelled()) {
            this.onCancelled(o);
        }
        else {
            this.onPostExecute(o);
        }
        this.mStatus = ModernAsyncTask$Status.FINISHED;
    }
    
    public final Object get() {
        return this.mFuture.get();
    }
    
    public final Object get(final long n, final TimeUnit timeUnit) {
        return this.mFuture.get(n, timeUnit);
    }
    
    public final ModernAsyncTask$Status getStatus() {
        return this.mStatus;
    }
    
    public final boolean isCancelled() {
        return this.mCancelled.get();
    }
    
    protected void onCancelled() {
    }
    
    protected void onCancelled(final Object o) {
        this.onCancelled();
    }
    
    protected void onPostExecute(final Object o) {
    }
    
    protected void onPreExecute() {
    }
    
    protected void onProgressUpdate(final Object... array) {
    }
    
    Object postResult(final Object o) {
        final Handler handler = getHandler();
        final int n = 1;
        final Object[] array = new Object[n];
        array[0] = o;
        handler.obtainMessage(n, (Object)new ModernAsyncTask$AsyncTaskResult(this, array)).sendToTarget();
        return o;
    }
    
    void postResultIfNotInvoked(final Object o) {
        if (!this.mTaskInvoked.get()) {
            this.postResult(o);
        }
    }
    
    protected final void publishProgress(final Object... array) {
        if (!this.isCancelled()) {
            getHandler().obtainMessage(2, (Object)new ModernAsyncTask$AsyncTaskResult(this, array)).sendToTarget();
        }
    }
}
