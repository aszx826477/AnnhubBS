// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.IOException;

public enum Protocol
{
    HTTP_1_0("HTTP_1_0", 0, "http/1.0"), 
    HTTP_1_1("HTTP_1_1", n, "http/1.1"), 
    HTTP_2("HTTP_2", n3, "h2"), 
    SPDY_3("SPDY_3", n2, "spdy/3.1");
    
    private final String protocol;
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final Protocol[] $values = new Protocol[4];
        $values[0] = Protocol.HTTP_1_0;
        $values[n] = Protocol.HTTP_1_1;
        $values[n2] = Protocol.SPDY_3;
        $values[n3] = Protocol.HTTP_2;
        $VALUES = $values;
    }
    
    private Protocol(final String s, final int n, final String protocol) {
        this.protocol = protocol;
    }
    
    public static Protocol get(final String s) {
        if (s.equals(Protocol.HTTP_1_0.protocol)) {
            return Protocol.HTTP_1_0;
        }
        if (s.equals(Protocol.HTTP_1_1.protocol)) {
            return Protocol.HTTP_1_1;
        }
        if (s.equals(Protocol.HTTP_2.protocol)) {
            return Protocol.HTTP_2;
        }
        if (s.equals(Protocol.SPDY_3.protocol)) {
            return Protocol.SPDY_3;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected protocol: ");
        sb.append(s);
        throw new IOException(sb.toString());
    }
    
    public String toString() {
        return this.protocol;
    }
}
