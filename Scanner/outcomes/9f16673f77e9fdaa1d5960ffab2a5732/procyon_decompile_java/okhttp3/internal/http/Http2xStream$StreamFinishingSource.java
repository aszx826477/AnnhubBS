// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.util.concurrent.TimeUnit;
import okio.Okio;
import okhttp3.ResponseBody;
import okhttp3.Response;
import okio.Sink;
import okhttp3.internal.framed.ErrorCode;
import java.util.LinkedHashSet;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.internal.Internal;
import okhttp3.Headers$Builder;
import okhttp3.Response$Builder;
import okhttp3.Headers;
import java.util.Locale;
import java.util.ArrayList;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.framed.Header;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.OkHttpClient;
import java.util.List;
import okio.ByteString;
import okio.Source;
import okio.ForwardingSource;

class Http2xStream$StreamFinishingSource extends ForwardingSource
{
    final /* synthetic */ Http2xStream this$0;
    
    public Http2xStream$StreamFinishingSource(final Http2xStream this$0, final Source source) {
        this.this$0 = this$0;
        super(source);
    }
    
    public void close() {
        this.this$0.streamAllocation.streamFinished(false, this.this$0);
        super.close();
    }
}
