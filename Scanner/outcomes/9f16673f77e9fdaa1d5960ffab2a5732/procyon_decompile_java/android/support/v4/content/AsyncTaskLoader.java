// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.support.v4.util.TimeUtils;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.SystemClock;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader extends Loader
{
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader$LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader$LoadTask mTask;
    long mUpdateThrottle;
    
    public AsyncTaskLoader(final Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }
    
    private AsyncTaskLoader(final Context context, final Executor mExecutor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = mExecutor;
    }
    
    public void cancelLoadInBackground() {
    }
    
    void dispatchOnCancelled(final AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask, final Object o) {
        this.onCanceled(o);
        if (this.mCancellingTask == asyncTaskLoader$LoadTask) {
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            this.deliverCancellation();
            this.executePendingTask();
        }
    }
    
    void dispatchOnLoadComplete(final AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask, final Object o) {
        if (this.mTask != asyncTaskLoader$LoadTask) {
            this.dispatchOnCancelled(asyncTaskLoader$LoadTask, o);
        }
        else if (this.isAbandoned()) {
            this.onCanceled(o);
        }
        else {
            this.commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            this.deliverResult(o);
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        if (this.mTask != null) {
            printWriter.print(s);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(s);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0L) {
            printWriter.print(s);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
    
    void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks((Runnable)this.mTask);
            }
            if (this.mUpdateThrottle > 0L && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.waiting = true;
                this.mHandler.postAtTime((Runnable)this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                return;
            }
            final AsyncTaskLoader$LoadTask mTask = this.mTask;
            final Executor mExecutor = this.mExecutor;
            final Void[] array = null;
            mTask.executeOnExecutor(mExecutor, (Object[])null);
        }
    }
    
    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }
    
    public abstract Object loadInBackground();
    
    protected boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks((Runnable)this.mTask);
            }
            this.mTask = null;
            return false;
        }
        if (this.mTask.waiting) {
            this.mTask.waiting = false;
            this.mHandler.removeCallbacks((Runnable)this.mTask);
            this.mTask = null;
            return false;
        }
        final boolean cancel = this.mTask.cancel(false);
        if (cancel) {
            this.mCancellingTask = this.mTask;
            this.cancelLoadInBackground();
        }
        this.mTask = null;
        return cancel;
    }
    
    public void onCanceled(final Object o) {
    }
    
    protected void onForceLoad() {
        super.onForceLoad();
        this.cancelLoad();
        this.mTask = new AsyncTaskLoader$LoadTask(this);
        this.executePendingTask();
    }
    
    protected Object onLoadInBackground() {
        return this.loadInBackground();
    }
    
    public void setUpdateThrottle(final long mUpdateThrottle) {
        this.mUpdateThrottle = mUpdateThrottle;
        if (mUpdateThrottle != 0L) {
            this.mHandler = new Handler();
        }
    }
    
    public void waitForLoader() {
        final AsyncTaskLoader$LoadTask mTask = this.mTask;
        if (mTask != null) {
            mTask.waitForLoader();
        }
    }
}
