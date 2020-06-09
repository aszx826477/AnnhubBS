// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.AsyncTask;

class AsyncTaskCompatHoneycomb
{
    static void executeParallel(final AsyncTask asyncTask, final Object... array) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, array);
    }
}
