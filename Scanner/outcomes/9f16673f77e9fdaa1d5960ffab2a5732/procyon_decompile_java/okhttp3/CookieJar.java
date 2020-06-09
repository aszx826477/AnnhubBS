// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.List;

public interface CookieJar
{
    public static final CookieJar NO_COOKIES = new CookieJar$1();
    
    List loadForRequest(final HttpUrl p0);
    
    void saveFromResponse(final HttpUrl p0, final List p1);
}
