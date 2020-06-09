// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

public interface Interceptor$Chain
{
    Connection connection();
    
    Response proceed(final Request p0);
    
    Request request();
}
