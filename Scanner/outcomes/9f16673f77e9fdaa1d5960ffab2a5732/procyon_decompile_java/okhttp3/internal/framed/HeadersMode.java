// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

public enum HeadersMode
{
    HTTP_20_HEADERS("HTTP_20_HEADERS", n3), 
    SPDY_HEADERS("SPDY_HEADERS", n2), 
    SPDY_REPLY("SPDY_REPLY", n), 
    SPDY_SYN_STREAM("SPDY_SYN_STREAM", 0);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final HeadersMode[] $values = new HeadersMode[4];
        $values[0] = HeadersMode.SPDY_SYN_STREAM;
        $values[n] = HeadersMode.SPDY_REPLY;
        $values[n2] = HeadersMode.SPDY_HEADERS;
        $values[n3] = HeadersMode.HTTP_20_HEADERS;
        $VALUES = $values;
    }
    
    private HeadersMode(final String s, final int n) {
    }
    
    public boolean failIfHeadersAbsent() {
        return this == HeadersMode.SPDY_HEADERS;
    }
    
    public boolean failIfHeadersPresent() {
        return this == HeadersMode.SPDY_REPLY;
    }
    
    public boolean failIfStreamAbsent() {
        return this == HeadersMode.SPDY_REPLY || this == HeadersMode.SPDY_HEADERS;
    }
    
    public boolean failIfStreamPresent() {
        return this == HeadersMode.SPDY_SYN_STREAM;
    }
}
