// 
// Decompiled by Procyon v0.5.30
// 

package okio;

final class AsyncTimeout$Watchdog extends Thread
{
    public AsyncTimeout$Watchdog() {
        super("Okio Watchdog");
        this.setDaemon(true);
    }
    
    public void run() {
        while (true) {
            while (true) {
                Label_0019: {
                    try {
                        AsyncTimeout awaitTimeout;
                        do {
                            awaitTimeout = AsyncTimeout.awaitTimeout();
                        } while (awaitTimeout == null);
                        awaitTimeout.timedOut();
                        break Label_0019;
                    }
                    catch (InterruptedException ex) {}
                }
                continue;
            }
        }
    }
}
