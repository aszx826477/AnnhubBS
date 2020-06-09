// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.HashSet;
import com.bumptech.glide.request.ResourceCallback;
import java.util.ArrayList;
import android.os.Looper;
import com.bumptech.glide.load.Key;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import android.os.Handler$Callback;

class EngineJob$MainThreadCallback implements Handler$Callback
{
    public boolean handleMessage(final Message message) {
        final int what = message.what;
        final boolean b = true;
        if ((b ? 1 : 0) != what && 2 != message.what) {
            return false;
        }
        final EngineJob engineJob = (EngineJob)message.obj;
        if ((b ? 1 : 0) == message.what) {
            engineJob.handleResultOnMainThread();
        }
        else {
            engineJob.handleExceptionOnMainThread();
        }
        return b;
    }
}
