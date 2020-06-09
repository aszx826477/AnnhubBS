// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Header
{
    public static final ByteString RESPONSE_STATUS;
    public static final ByteString TARGET_AUTHORITY;
    public static final ByteString TARGET_HOST;
    public static final ByteString TARGET_METHOD;
    public static final ByteString TARGET_PATH;
    public static final ByteString TARGET_SCHEME;
    public static final ByteString VERSION;
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    
    static {
        RESPONSE_STATUS = ByteString.encodeUtf8(":status");
        TARGET_METHOD = ByteString.encodeUtf8(":method");
        TARGET_PATH = ByteString.encodeUtf8(":path");
        TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
        TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
        TARGET_HOST = ByteString.encodeUtf8(":host");
        VERSION = ByteString.encodeUtf8(":version");
    }
    
    public Header(final String s, final String s2) {
        this(ByteString.encodeUtf8(s), ByteString.encodeUtf8(s2));
    }
    
    public Header(final ByteString byteString, final String s) {
        this(byteString, ByteString.encodeUtf8(s));
    }
    
    public Header(final ByteString name, final ByteString value) {
        this.name = name;
        this.value = value;
        this.hpackSize = name.size() + 32 + value.size();
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Header;
        boolean b2 = false;
        if (b) {
            final Header header = (Header)o;
            if (this.name.equals(header.name)) {
                if (this.value.equals(header.value)) {
                    b2 = true;
                }
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        return (17 * 31 + this.name.hashCode()) * 31 + this.value.hashCode();
    }
    
    public String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }
}
