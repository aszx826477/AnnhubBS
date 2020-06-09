// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.io.IOException;
import okio.ByteString;
import java.util.Map;

final class Hpack
{
    private static final Map NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final Header[] STATIC_HEADER_TABLE;
    
    static {
        STATIC_HEADER_TABLE = new Header[] { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }
    
    private static ByteString checkLowercase(final ByteString byteString) {
        for (int i = 0; i < byteString.size(); ++i) {
            final byte byte1 = byteString.getByte(i);
            if (byte1 >= 65 && byte1 <= 90) {
                final StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(byteString.utf8());
                throw new IOException(sb.toString());
            }
        }
        return byteString;
    }
    
    private static Map nameToFirstIndex() {
        final LinkedHashMap<ByteString, Integer> linkedHashMap = new LinkedHashMap<ByteString, Integer>(Hpack.STATIC_HEADER_TABLE.length);
        int n = 0;
        while (true) {
            final Header[] static_HEADER_TABLE = Hpack.STATIC_HEADER_TABLE;
            if (n >= static_HEADER_TABLE.length) {
                break;
            }
            if (!linkedHashMap.containsKey(static_HEADER_TABLE[n].name)) {
                linkedHashMap.put(Hpack.STATIC_HEADER_TABLE[n].name, n);
            }
            ++n;
        }
        return Collections.unmodifiableMap((Map<?, ?>)linkedHashMap);
    }
}
