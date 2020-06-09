// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal;

public abstract class NamedRunnable implements Runnable
{
    protected final String name;
    
    public NamedRunnable(final String s, final Object... array) {
        this.name = Util.format(s, array);
    }
    
    protected abstract void execute();
    
    public final void run() {
        final String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            this.execute();
        }
        finally {
            Thread.currentThread().setName(name);
        }
    }
}
