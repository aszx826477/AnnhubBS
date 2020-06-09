// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

public interface Authenticator
{
    public static final Authenticator NONE = new Authenticator$1();
    
    Request authenticate(final Route p0, final Response p1);
}
