// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.executor;

import java.util.concurrent.FutureTask;

class FifoPriorityThreadPoolExecutor$LoadTask extends FutureTask implements Comparable
{
    private final int order;
    private final int priority;
    
    public FifoPriorityThreadPoolExecutor$LoadTask(final Runnable runnable, final Object o, final int order) {
        super(runnable, o);
        if (runnable instanceof Prioritized) {
            this.priority = ((Prioritized)runnable).getPriority();
            this.order = order;
            return;
        }
        throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
    }
    
    public int compareTo(final FifoPriorityThreadPoolExecutor$LoadTask fifoPriorityThreadPoolExecutor$LoadTask) {
        int n = this.priority - fifoPriorityThreadPoolExecutor$LoadTask.priority;
        if (n == 0) {
            n = this.order - fifoPriorityThreadPoolExecutor$LoadTask.order;
        }
        return n;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof FifoPriorityThreadPoolExecutor$LoadTask;
        boolean b2 = false;
        if (b) {
            final FifoPriorityThreadPoolExecutor$LoadTask fifoPriorityThreadPoolExecutor$LoadTask = (FifoPriorityThreadPoolExecutor$LoadTask)o;
            if (this.order == fifoPriorityThreadPoolExecutor$LoadTask.order && this.priority == fifoPriorityThreadPoolExecutor$LoadTask.priority) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        return this.priority * 31 + this.order;
    }
}
