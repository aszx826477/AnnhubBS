// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.executor;

import android.util.Log;

public enum FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy
{
    IGNORE("IGNORE", 0), 
    LOG("LOG", n) {
        FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$1(final String s, final int n) {
        }
        
        protected void handle(final Throwable t) {
            if (Log.isLoggable("PriorityExecutor", 6)) {
                Log.e("PriorityExecutor", "Request threw uncaught throwable", t);
            }
        }
    }, 
    THROW("THROW", n2) {
        FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$2(final String s, final int n) {
        }
        
        protected void handle(final Throwable t) {
            super.handle(t);
            throw new RuntimeException(t);
        }
    };
    
    static {
        final int n = 1;
        final int n2 = 2;
        final FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy[] $values = { FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy.IGNORE, null, null };
        $values[n] = FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy.LOG;
        $values[n2] = FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy.THROW;
        $VALUES = $values;
    }
    
    private FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy(final String s, final int n) {
    }
    
    protected void handle(final Throwable t) {
    }
}
