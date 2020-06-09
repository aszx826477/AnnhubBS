// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.net.ProtocolException;
import okhttp3.Response;
import okhttp3.Protocol;

public final class StatusLine
{
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;
    
    public StatusLine(final Protocol protocol, final int code, final String message) {
        this.protocol = protocol;
        this.code = code;
        this.message = message;
    }
    
    public static StatusLine get(final Response response) {
        return new StatusLine(response.protocol(), response.code(), response.message());
    }
    
    public static StatusLine parse(final String s) {
        final boolean startsWith = s.startsWith("HTTP/1.");
        final char c = ' ';
        int n2;
        Protocol protocol;
        if (startsWith) {
            if (s.length() < 9 || s.charAt(8) != c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected status line: ");
                sb.append(s);
                throw new ProtocolException(sb.toString());
            }
            final int n = s.charAt(7) - 48;
            n2 = 9;
            if (n == 0) {
                protocol = Protocol.HTTP_1_0;
            }
            else {
                if (n != 1) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unexpected status line: ");
                    sb2.append(s);
                    throw new ProtocolException(sb2.toString());
                }
                protocol = Protocol.HTTP_1_1;
            }
        }
        else {
            if (!s.startsWith("ICY ")) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unexpected status line: ");
                sb3.append(s);
                throw new ProtocolException(sb3.toString());
            }
            protocol = Protocol.HTTP_1_0;
            n2 = 4;
        }
        if (s.length() >= n2 + 3) {
            final int n3 = n2 + 3;
            final int n4 = n2;
            try {
                final String substring = s.substring(n4, n3);
                try {
                    final int int1 = Integer.parseInt(substring);
                    String substring2 = "";
                    if (s.length() > n2 + 3) {
                        if (s.charAt(n2 + 3) != c) {
                            final StringBuilder sb4 = new StringBuilder();
                            sb4.append("Unexpected status line: ");
                            sb4.append(s);
                            throw new ProtocolException(sb4.toString());
                        }
                        substring2 = s.substring(n2 + 4);
                    }
                    return new StatusLine(protocol, int1, substring2);
                }
                catch (NumberFormatException ex) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("Unexpected status line: ");
                    sb5.append(s);
                    throw new ProtocolException(sb5.toString());
                }
            }
            catch (NumberFormatException ex2) {}
        }
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("Unexpected status line: ");
        sb6.append(s);
        throw new ProtocolException(sb6.toString());
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        String s;
        if (this.protocol == Protocol.HTTP_1_0) {
            s = "HTTP/1.0";
        }
        else {
            s = "HTTP/1.1";
        }
        sb.append(s);
        final char c = ' ';
        sb.append(c);
        sb.append(this.code);
        if (this.message != null) {
            sb.append(c);
            sb.append(this.message);
        }
        return sb.toString();
    }
}
