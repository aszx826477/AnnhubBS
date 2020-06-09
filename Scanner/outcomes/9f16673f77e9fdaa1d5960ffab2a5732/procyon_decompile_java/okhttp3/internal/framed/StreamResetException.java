// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.IOException;

public final class StreamResetException extends IOException
{
    public final ErrorCode errorCode;
    
    public StreamResetException(final ErrorCode errorCode) {
        final StringBuilder sb = new StringBuilder();
        sb.append("stream was reset: ");
        sb.append(errorCode);
        super(sb.toString());
        this.errorCode = errorCode;
    }
}
