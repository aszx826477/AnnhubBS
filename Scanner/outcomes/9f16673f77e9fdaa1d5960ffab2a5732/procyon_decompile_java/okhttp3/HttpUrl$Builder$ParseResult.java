// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

enum HttpUrl$Builder$ParseResult
{
    INVALID_HOST("INVALID_HOST", n4), 
    INVALID_PORT("INVALID_PORT", n3), 
    MISSING_SCHEME("MISSING_SCHEME", n), 
    SUCCESS("SUCCESS", 0), 
    UNSUPPORTED_SCHEME("UNSUPPORTED_SCHEME", n2);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final HttpUrl$Builder$ParseResult[] $values = new HttpUrl$Builder$ParseResult[5];
        $values[0] = HttpUrl$Builder$ParseResult.SUCCESS;
        $values[n] = HttpUrl$Builder$ParseResult.MISSING_SCHEME;
        $values[n2] = HttpUrl$Builder$ParseResult.UNSUPPORTED_SCHEME;
        $values[n3] = HttpUrl$Builder$ParseResult.INVALID_PORT;
        $values[n4] = HttpUrl$Builder$ParseResult.INVALID_HOST;
        $VALUES = $values;
    }
    
    private HttpUrl$Builder$ParseResult(final String s, final int n) {
    }
}
