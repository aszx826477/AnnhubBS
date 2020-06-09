// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

public enum TlsVersion
{
    SSL_3_0("SSL_3_0", n3, "SSLv3"), 
    TLS_1_0("TLS_1_0", n2, "TLSv1"), 
    TLS_1_1("TLS_1_1", n, "TLSv1.1"), 
    TLS_1_2("TLS_1_2", 0, "TLSv1.2");
    
    final String javaName;
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final TlsVersion[] $values = new TlsVersion[4];
        $values[0] = TlsVersion.TLS_1_2;
        $values[n] = TlsVersion.TLS_1_1;
        $values[n2] = TlsVersion.TLS_1_0;
        $values[n3] = TlsVersion.SSL_3_0;
        $VALUES = $values;
    }
    
    private TlsVersion(final String s, final int n, final String javaName) {
        this.javaName = javaName;
    }
    
    public static TlsVersion forJavaName(final String s) {
        int n = 0;
        Label_0127: {
            switch (s.hashCode()) {
                case 79923350: {
                    if (s.equals("TLSv1")) {
                        n = 2;
                        break Label_0127;
                    }
                    break;
                }
                case 79201641: {
                    if (s.equals("SSLv3")) {
                        n = 3;
                        break Label_0127;
                    }
                    break;
                }
                case -503070502: {
                    if (s.equals("TLSv1.2")) {
                        n = 0;
                        break Label_0127;
                    }
                    break;
                }
                case -503070503: {
                    if (s.equals("TLSv1.1")) {
                        n = 1;
                        break Label_0127;
                    }
                    break;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected TLS version: ");
                sb.append(s);
                throw new IllegalArgumentException(sb.toString());
            }
            case 3: {
                return TlsVersion.SSL_3_0;
            }
            case 2: {
                return TlsVersion.TLS_1_0;
            }
            case 1: {
                return TlsVersion.TLS_1_1;
            }
            case 0: {
                return TlsVersion.TLS_1_2;
            }
        }
    }
    
    public String javaName() {
        return this.javaName;
    }
}
