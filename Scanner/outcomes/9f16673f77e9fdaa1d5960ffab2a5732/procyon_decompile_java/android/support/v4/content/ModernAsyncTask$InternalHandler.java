// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;

class ModernAsyncTask$InternalHandler extends Handler
{
    public ModernAsyncTask$InternalHandler() {
        super(Looper.getMainLooper());
    }
    
    public void handleMessage(final Message message) {
        final ModernAsyncTask$AsyncTaskResult modernAsyncTask$AsyncTaskResult = (ModernAsyncTask$AsyncTaskResult)message.obj;
        switch (message.what) {
            case 2: {
                modernAsyncTask$AsyncTaskResult.mTask.onProgressUpdate(modernAsyncTask$AsyncTaskResult.mData);
                break;
            }
            case 1: {
                modernAsyncTask$AsyncTaskResult.mTask.finish(modernAsyncTask$AsyncTaskResult.mData[0]);
                break;
            }
        }
    }
}
