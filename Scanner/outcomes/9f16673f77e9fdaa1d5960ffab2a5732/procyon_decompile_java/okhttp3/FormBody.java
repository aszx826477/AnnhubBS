// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.Buffer;
import okio.BufferedSink;
import okhttp3.internal.Util;
import java.util.List;

public final class FormBody extends RequestBody
{
    private static final MediaType CONTENT_TYPE;
    private final List encodedNames;
    private final List encodedValues;
    
    static {
        CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    }
    
    private FormBody(final List list, final List list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }
    
    private long writeOrCountBytes(final BufferedSink bufferedSink, final boolean b) {
        long size = 0L;
        Buffer buffer;
        if (b) {
            buffer = new Buffer();
        }
        else {
            buffer = bufferedSink.buffer();
        }
        for (int i = 0; i < this.encodedNames.size(); ++i) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8((String)this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8((String)this.encodedValues.get(i));
        }
        if (b) {
            size = buffer.size();
            buffer.clear();
        }
        return size;
    }
    
    public long contentLength() {
        return this.writeOrCountBytes(null, true);
    }
    
    public MediaType contentType() {
        return FormBody.CONTENT_TYPE;
    }
    
    public String encodedName(final int n) {
        return this.encodedNames.get(n);
    }
    
    public String encodedValue(final int n) {
        return this.encodedValues.get(n);
    }
    
    public String name(final int n) {
        return HttpUrl.percentDecode(this.encodedName(n), true);
    }
    
    public int size() {
        return this.encodedNames.size();
    }
    
    public String value(final int n) {
        return HttpUrl.percentDecode(this.encodedValue(n), true);
    }
    
    public void writeTo(final BufferedSink bufferedSink) {
        this.writeOrCountBytes(bufferedSink, false);
    }
}
