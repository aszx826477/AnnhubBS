// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import java.io.IOException;
import okio.Okio;
import java.util.zip.Inflater;
import okio.Source;
import okio.BufferedSource;
import okio.InflaterSource;

class NameValueBlockReader
{
    private int compressedLimit;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;
    
    public NameValueBlockReader(final BufferedSource bufferedSource) {
        this.inflaterSource = new InflaterSource(new NameValueBlockReader$1(this, bufferedSource), new NameValueBlockReader$2(this));
        this.source = Okio.buffer(this.inflaterSource);
    }
    
    private void doneReading() {
        if (this.compressedLimit > 0) {
            this.inflaterSource.refill();
            if (this.compressedLimit != 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("compressedLimit > 0: ");
                sb.append(this.compressedLimit);
                throw new IOException(sb.toString());
            }
        }
    }
    
    private ByteString readByteString() {
        return this.source.readByteString(this.source.readInt());
    }
    
    public void close() {
        this.source.close();
    }
    
    public List readNameValueBlock(final int n) {
        this.compressedLimit += n;
        final int int1 = this.source.readInt();
        if (int1 < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("numberOfPairs < 0: ");
            sb.append(int1);
            throw new IOException(sb.toString());
        }
        if (int1 <= 1024) {
            final ArrayList list = new ArrayList<Header>(int1);
            for (int i = 0; i < int1; ++i) {
                final ByteString asciiLowercase = this.readByteString().toAsciiLowercase();
                final ByteString byteString = this.readByteString();
                if (asciiLowercase.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                list.add(new Header(asciiLowercase, byteString));
            }
            this.doneReading();
            return list;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("numberOfPairs > 1024: ");
        sb2.append(int1);
        throw new IOException(sb2.toString());
    }
}
