// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

public interface Call
{
    void cancel();
    
    void enqueue(final Callback p0);
    
    Response execute();
    
    boolean isCanceled();
    
    boolean isExecuted();
    
    Request request();
}
