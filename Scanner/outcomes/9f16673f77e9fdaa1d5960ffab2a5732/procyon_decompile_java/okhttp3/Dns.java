// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.List;

public interface Dns
{
    public static final Dns SYSTEM = new Dns$1();
    
    List lookup(final String p0);
}
