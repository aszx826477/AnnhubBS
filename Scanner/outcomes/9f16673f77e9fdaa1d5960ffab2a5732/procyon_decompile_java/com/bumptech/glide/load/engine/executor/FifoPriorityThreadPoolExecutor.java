// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.executor;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadPoolExecutor;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor
{
    private static final String TAG = "PriorityExecutor";
    private final AtomicInteger ordering;
    private final FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy uncaughtThrowableStrategy;
    
    public FifoPriorityThreadPoolExecutor(final int n) {
        this(n, FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy.LOG);
    }
    
    public FifoPriorityThreadPoolExecutor(final int n, final int n2, final long n3, final TimeUnit timeUnit, final ThreadFactory threadFactory, final FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(n, n2, n3, timeUnit, new PriorityBlockingQueue<Runnable>(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }
    
    public FifoPriorityThreadPoolExecutor(final int n, final FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy fifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy) {
        this(n, n, 0L, TimeUnit.MILLISECONDS, new FifoPriorityThreadPoolExecutor$DefaultThreadFactory(), fifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy);
    }
    
    protected void afterExecute(final Runnable runnable, final Throwable t) {
        super.afterExecute(runnable, t);
        if (t == null && runnable instanceof Future) {
            final Future future = (Future)runnable;
            if (future.isDone() && !future.isCancelled()) {
                while (true) {
                    try {
                        future.get();
                    }
                    catch (ExecutionException ex) {
                        this.uncaughtThrowableStrategy.handle(ex);
                    }
                    catch (InterruptedException ex2) {
                        this.uncaughtThrowableStrategy.handle(ex2);
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    protected RunnableFuture newTaskFor(final Runnable runnable, final Object o) {
        return new FifoPriorityThreadPoolExecutor$LoadTask(runnable, o, this.ordering.getAndIncrement());
    }
}
