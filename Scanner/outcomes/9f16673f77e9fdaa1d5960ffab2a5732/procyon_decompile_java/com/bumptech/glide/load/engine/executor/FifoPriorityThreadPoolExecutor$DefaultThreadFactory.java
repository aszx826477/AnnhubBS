// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.executor;

import java.util.concurrent.ThreadFactory;

public class FifoPriorityThreadPoolExecutor$DefaultThreadFactory implements ThreadFactory
{
    int threadNum;
    
    public FifoPriorityThreadPoolExecutor$DefaultThreadFactory() {
        this.threadNum = 0;
    }
    
    public Thread newThread(final Runnable runnable) {
        final StringBuilder sb = new StringBuilder();
        sb.append("fifo-pool-thread-");
        sb.append(this.threadNum);
        final FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1 fifoPriorityThreadPoolExecutor$DefaultThreadFactory$1 = new FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1(this, runnable, sb.toString());
        ++this.threadNum;
        return fifoPriorityThreadPoolExecutor$DefaultThreadFactory$1;
    }
}
