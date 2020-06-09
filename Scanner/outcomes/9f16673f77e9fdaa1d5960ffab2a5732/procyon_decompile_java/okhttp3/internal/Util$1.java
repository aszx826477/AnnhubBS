// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

final class Util$1 implements ThreadFactory
{
    final /* synthetic */ boolean val$daemon;
    final /* synthetic */ String val$name;
    
    Util$1(final String val$name, final boolean val$daemon) {
        this.val$name = val$name;
        this.val$daemon = val$daemon;
    }
    
    public Thread newThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable, this.val$name);
        thread.setDaemon(this.val$daemon);
        return thread;
    }
}
