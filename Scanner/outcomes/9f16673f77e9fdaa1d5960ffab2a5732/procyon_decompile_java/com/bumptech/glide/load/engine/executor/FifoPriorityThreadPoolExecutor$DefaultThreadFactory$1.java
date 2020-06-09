// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.executor;

import android.os.Process;

class FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1 extends Thread
{
    final /* synthetic */ FifoPriorityThreadPoolExecutor$DefaultThreadFactory this$0;
    
    FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1(final FifoPriorityThreadPoolExecutor$DefaultThreadFactory this$0, final Runnable runnable, final String s) {
        this.this$0 = this$0;
        super(runnable, s);
    }
    
    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
