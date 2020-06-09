// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

public enum ErrorCode
{
    CANCEL("CANCEL", 11, 8, 5, n2), 
    COMPRESSION_ERROR("COMPRESSION_ERROR", 12, 9, n4, n3), 
    CONNECT_ERROR("CONNECT_ERROR", 13, 10, n5, n2), 
    ENHANCE_YOUR_CALM("ENHANCE_YOUR_CALM", 14, 11, n4, n3), 
    FLOW_CONTROL_ERROR("FLOW_CONTROL_ERROR", 7, 3, 7, n2), 
    FRAME_TOO_LARGE("FRAME_TOO_LARGE", 9, 6, 11, n2), 
    HTTP_1_1_REQUIRED("HTTP_1_1_REQUIRED", 16, 13, n4, n3), 
    INADEQUATE_SECURITY("INADEQUATE_SECURITY", 15, 12, n5, n2), 
    INTERNAL_ERROR("INTERNAL_ERROR", 6, 2, 6, 2), 
    INVALID_CREDENTIALS("INVALID_CREDENTIALS", 17, -1, 10, n2), 
    INVALID_STREAM("INVALID_STREAM", 2, (int)(b2 ? 1 : 0), 2, n), 
    NO_ERROR("NO_ERROR", 0, 0, -1, 0), 
    PROTOCOL_ERROR("PROTOCOL_ERROR", 1, (int)(b ? 1 : 0), 1, 1), 
    REFUSED_STREAM("REFUSED_STREAM", 10, 7, 3, n3), 
    STREAM_ALREADY_CLOSED("STREAM_ALREADY_CLOSED", 5, (int)(b ? 1 : 0), 9, n2), 
    STREAM_CLOSED("STREAM_CLOSED", 8, 5, -1, n3), 
    STREAM_IN_USE("STREAM_IN_USE", 4, (int)(b2 ? 1 : 0), 8, n), 
    UNSUPPORTED_VERSION("UNSUPPORTED_VERSION", 3, (int)(b ? 1 : 0), 4, n2);
    
    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;
    
    static {
        final boolean b = true;
        final boolean b2 = true;
        final int n = -1;
        final int n2 = -1;
        final int n3 = -1;
        final int n4 = -1;
        final int n5 = -1;
    }
    
    private ErrorCode(final String s, final int n, final int httpCode, final int spdyRstCode, final int spdyGoAwayCode) {
        this.httpCode = httpCode;
        this.spdyRstCode = spdyRstCode;
        this.spdyGoAwayCode = spdyGoAwayCode;
    }
    
    public static ErrorCode fromHttp2(final int n) {
        final ErrorCode[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final ErrorCode errorCode = values[i];
            if (errorCode.httpCode == n) {
                return errorCode;
            }
        }
        return null;
    }
    
    public static ErrorCode fromSpdy3Rst(final int n) {
        final ErrorCode[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final ErrorCode errorCode = values[i];
            if (errorCode.spdyRstCode == n) {
                return errorCode;
            }
        }
        return null;
    }
    
    public static ErrorCode fromSpdyGoAway(final int n) {
        final ErrorCode[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final ErrorCode errorCode = values[i];
            if (errorCode.spdyGoAwayCode == n) {
                return errorCode;
            }
        }
        return null;
    }
}
