// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

class ConnectionPool$1 implements Runnable
{
    final /* synthetic */ ConnectionPool this$0;
    
    ConnectionPool$1(final ConnectionPool this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        while (true) {
            final long cleanup = this.this$0.cleanup(System.nanoTime());
            if (cleanup == -1) {
                break;
            }
            if (cleanup <= 0L) {
                continue;
            }
            final long n = 1000000L;
            final long n2 = cleanup / n;
            final long n3 = cleanup - n * n2;
            final ConnectionPool this$0 = this.this$0;
            // monitorenter(this$0)
            try {
                try {
                    this.this$0.wait(n2, (int)n3);
                }
                finally {
                }
                // monitorexit(this$0)
                // monitorexit(this$0)
            }
            catch (InterruptedException ex) {}
        }
    }
}
