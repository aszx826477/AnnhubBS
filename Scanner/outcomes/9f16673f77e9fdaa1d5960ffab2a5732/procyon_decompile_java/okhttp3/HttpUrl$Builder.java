// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Collections;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.util.Collection;
import okio.Buffer;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.net.InetAddress;
import okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.List;

public final class HttpUrl$Builder
{
    String encodedFragment;
    String encodedPassword;
    final List encodedPathSegments;
    List encodedQueryNamesAndValues;
    String encodedUsername;
    String host;
    int port;
    String scheme;
    
    public HttpUrl$Builder() {
        this.encodedUsername = "";
        this.encodedPassword = "";
        this.port = -1;
        (this.encodedPathSegments = new ArrayList()).add("");
    }
    
    private HttpUrl$Builder addPathSegments(final String s, final boolean b) {
        int n = 0;
        do {
            final int delimiterOffset = Util.delimiterOffset(s, n, s.length(), "/\\");
            this.push(s, n, delimiterOffset, delimiterOffset < s.length(), b);
            n = delimiterOffset + 1;
        } while (n <= s.length());
        return this;
    }
    
    private static String canonicalizeHost(final String s, final int n, final int n2) {
        final String percentDecode = HttpUrl.percentDecode(s, n, n2, false);
        if (!percentDecode.contains(":")) {
            return Util.domainToAscii(percentDecode);
        }
        InetAddress inetAddress;
        if (percentDecode.startsWith("[") && percentDecode.endsWith("]")) {
            final int length = percentDecode.length();
            final int n3 = 1;
            inetAddress = decodeIpv6(percentDecode, n3, length - n3);
        }
        else {
            inetAddress = decodeIpv6(percentDecode, 0, percentDecode.length());
        }
        if (inetAddress == null) {
            return null;
        }
        final byte[] address = inetAddress.getAddress();
        if (address.length == 16) {
            return inet6AddressToAscii(address);
        }
        throw new AssertionError();
    }
    
    private static boolean decodeIpv4Suffix(final String s, final int n, final int n2, final byte[] array, final int n3) {
        int n4 = n3;
        int i = n;
        while (i < n2) {
            if (n4 == array.length) {
                return false;
            }
            if (n4 != n3) {
                if (s.charAt(i) != '.') {
                    return false;
                }
                ++i;
            }
            int n5 = 0;
            final int n6 = i;
            while (i < n2) {
                final char char1 = s.charAt(i);
                if (char1 < '0' || char1 > '9') {
                    break;
                }
                if (n5 == 0 && n6 != i) {
                    return false;
                }
                n5 = n5 * 10 + char1 - 48;
                if (n5 > 255) {
                    return false;
                }
                ++i;
            }
            if (i - n6 == 0) {
                return false;
            }
            final int n7 = n4 + 1;
            array[n4] = (byte)n5;
            n4 = n7;
        }
        return n4 == n3 + 4;
    }
    
    private static InetAddress decodeIpv6(final String s, final int n, final int n2) {
        final byte[] array = new byte[16];
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        int i = n;
        int n6;
        while (true) {
            n6 = -1;
            if (i >= n2) {
                break;
            }
            if (n3 == array.length) {
                return null;
            }
            if (i + 2 <= n2 && s.regionMatches(i, "::", 0, 2)) {
                if (n4 != n6) {
                    return null;
                }
                i += 2;
                n3 = (n4 = n3 + 2);
                if (i == n2) {
                    break;
                }
            }
            else if (n3 != 0) {
                final String s2 = ":";
                final int n7 = 1;
                if (s.regionMatches(i, s2, 0, n7)) {
                    ++i;
                }
                else {
                    if (!s.regionMatches(i, ".", 0, n7)) {
                        return null;
                    }
                    if (!decodeIpv4Suffix(s, n5, n2, array, n3 - 2)) {
                        return null;
                    }
                    n3 += 2;
                    break;
                }
            }
            int n8 = 0;
            n5 = i;
            while (i < n2) {
                final int decodeHexDigit = HttpUrl.decodeHexDigit(s.charAt(i));
                if (decodeHexDigit == n6) {
                    break;
                }
                n8 = (n8 << 4) + decodeHexDigit;
                ++i;
            }
            final int n9 = i - n5;
            if (n9 == 0 || n9 > 4) {
                return null;
            }
            final int n10 = n3 + 1;
            array[n3] = (byte)(n8 >>> 8 & 0xFF);
            n3 = n10 + 1;
            array[n10] = (byte)(n8 & 0xFF);
        }
        if (n3 != array.length) {
            if (n4 == n6) {
                return null;
            }
            System.arraycopy(array, n4, array, array.length - (n3 - n4), n3 - n4);
            Arrays.fill(array, n4, array.length - n3 + n4, (byte)0);
        }
        try {
            return InetAddress.getByAddress(array);
        }
        catch (UnknownHostException ex) {
            throw new AssertionError();
        }
    }
    
    private static String inet6AddressToAscii(final byte[] array) {
        int n = -1;
        int n2 = 0;
        int n3 = 0;
        int n4;
        while (true) {
            final int length = array.length;
            n4 = 16;
            if (n3 >= length) {
                break;
            }
            final int n5 = n3;
            while (n3 < n4 && array[n3] == 0 && array[n3 + 1] == 0) {
                n3 += 2;
            }
            final int n6 = n3 - n5;
            if (n6 > n2) {
                n = n5;
                n2 = n6;
            }
            n3 += 2;
        }
        final Buffer buffer = new Buffer();
        int i = 0;
        while (i < array.length) {
            final int n7 = 58;
            if (i == n) {
                buffer.writeByte(n7);
                i += n2;
                if (i != n4) {
                    continue;
                }
                buffer.writeByte(n7);
            }
            else {
                if (i > 0) {
                    buffer.writeByte(n7);
                }
                buffer.writeHexadecimalUnsignedLong((long)((array[i] & 0xFF) << 8 | (array[i + 1] & 0xFF)));
                i += 2;
            }
        }
        return buffer.readUtf8();
    }
    
    private boolean isDot(final String s) {
        return s.equals(".") || s.equalsIgnoreCase("%2e");
    }
    
    private boolean isDotDot(final String s) {
        if (!s.equals("..")) {
            if (!s.equalsIgnoreCase("%2e.")) {
                if (!s.equalsIgnoreCase(".%2e")) {
                    if (!s.equalsIgnoreCase("%2e%2e")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static int parsePort(final String s, final int n, final int n2) {
        final int n3 = -1;
        final String s2 = "";
        final boolean b = true;
        final String s3 = s2;
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        try {
            final String canonicalize = HttpUrl.canonicalize(s, n, n2, s3, b2, b3, b4, b);
            try {
                final int int1 = Integer.parseInt(canonicalize);
                if (int1 > '\0' && int1 <= (char)(-1)) {
                    return int1;
                }
                return n3;
            }
            catch (NumberFormatException ex) {
                return n3;
            }
        }
        catch (NumberFormatException ex2) {}
    }
    
    private void pop() {
        final List encodedPathSegments = this.encodedPathSegments;
        if (encodedPathSegments.remove(encodedPathSegments.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
            final List encodedPathSegments2 = this.encodedPathSegments;
            encodedPathSegments2.set(encodedPathSegments2.size() - 1, "");
        }
        else {
            this.encodedPathSegments.add("");
        }
    }
    
    private static int portColonOffset(final String s, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            final char char1 = s.charAt(i);
            if (char1 == ':') {
                return i;
            }
            if (char1 == '[') {
                do {
                    ++i;
                    if (i >= n2) {
                        break;
                    }
                } while (s.charAt(i) != ']');
            }
        }
        return n2;
    }
    
    private void push(final String s, final int n, final int n2, final boolean b, final boolean b2) {
        final String canonicalize = HttpUrl.canonicalize(s, n, n2, " \"<>^`{}|/\\?#", b2, false, false, true);
        if (this.isDot(canonicalize)) {
            return;
        }
        if (this.isDotDot(canonicalize)) {
            this.pop();
            return;
        }
        final List encodedPathSegments = this.encodedPathSegments;
        if (encodedPathSegments.get(encodedPathSegments.size() - 1).isEmpty()) {
            final List encodedPathSegments2 = this.encodedPathSegments;
            encodedPathSegments2.set(encodedPathSegments2.size() - 1, canonicalize);
        }
        else {
            this.encodedPathSegments.add(canonicalize);
        }
        if (b) {
            this.encodedPathSegments.add("");
        }
    }
    
    private void removeAllCanonicalQueryParameters(final String s) {
        for (int i = this.encodedQueryNamesAndValues.size() - 2; i >= 0; i -= 2) {
            if (s.equals(this.encodedQueryNamesAndValues.get(i))) {
                this.encodedQueryNamesAndValues.remove(i + 1);
                this.encodedQueryNamesAndValues.remove(i);
                if (this.encodedQueryNamesAndValues.isEmpty()) {
                    this.encodedQueryNamesAndValues = null;
                    return;
                }
            }
        }
    }
    
    private void resolvePath(final String s, int n, final int n2) {
        if (n == n2) {
            return;
        }
        final char char1 = s.charAt(n);
        final char c = '/';
        final int n3 = 1;
        if (char1 != c && char1 != '\\') {
            final List encodedPathSegments = this.encodedPathSegments;
            encodedPathSegments.set(encodedPathSegments.size() - n3, "");
        }
        else {
            this.encodedPathSegments.clear();
            this.encodedPathSegments.add("");
            ++n;
        }
        int delimiterOffset;
        for (int i = n; i < n2; i = delimiterOffset + 1) {
            delimiterOffset = Util.delimiterOffset(s, i, n2, "/\\");
            final boolean b = delimiterOffset < n2;
            this.push(s, i, delimiterOffset, b, true);
            i = delimiterOffset;
            if (b) {}
        }
    }
    
    private static int schemeDelimiterOffset(final String s, final int n, final int n2) {
        final int n3 = n2 - n;
        final int n4 = -1;
        if (n3 < 2) {
            return n4;
        }
        final char char1 = s.charAt(n);
        final char c = 'Z';
        final char c2 = 'z';
        final char c3 = 'A';
        final char c4 = 'a';
        if ((char1 < c4 || char1 > c2) && (char1 < c3 || char1 > c)) {
            return n4;
        }
        for (int i = n + 1; i < n2; ++i) {
            final char char2 = s.charAt(i);
            if ((char2 < c4 || char2 > c2) && (char2 < c3 || char2 > c) && (char2 < '0' || char2 > '9') && char2 != '+' && char2 != '-') {
                if (char2 != '.') {
                    if (char2 == ':') {
                        return i;
                    }
                    return n4;
                }
            }
        }
        return n4;
    }
    
    private static int slashCount(final String s, int i, final int n) {
        int n2 = 0;
        while (i < n) {
            final char char1 = s.charAt(i);
            if (char1 != '\\' && char1 != '/') {
                break;
            }
            ++n2;
            ++i;
        }
        return n2;
    }
    
    public HttpUrl$Builder addEncodedPathSegment(final String s) {
        if (s != null) {
            this.push(s, 0, s.length(), false, true);
            return this;
        }
        throw new NullPointerException("encodedPathSegment == null");
    }
    
    public HttpUrl$Builder addEncodedPathSegments(final String s) {
        if (s != null) {
            return this.addPathSegments(s, true);
        }
        throw new NullPointerException("encodedPathSegments == null");
    }
    
    public HttpUrl$Builder addEncodedQueryParameter(final String s, final String s2) {
        if (s != null) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(s, " \"'<>#&=", true, false, true, true));
            final List encodedQueryNamesAndValues = this.encodedQueryNamesAndValues;
            String canonicalize;
            if (s2 != null) {
                canonicalize = HttpUrl.canonicalize(s2, " \"'<>#&=", true, false, true, true);
            }
            else {
                canonicalize = null;
            }
            encodedQueryNamesAndValues.add(canonicalize);
            return this;
        }
        throw new NullPointerException("encodedName == null");
    }
    
    public HttpUrl$Builder addPathSegment(final String s) {
        if (s != null) {
            this.push(s, 0, s.length(), false, false);
            return this;
        }
        throw new NullPointerException("pathSegment == null");
    }
    
    public HttpUrl$Builder addPathSegments(final String s) {
        if (s != null) {
            return this.addPathSegments(s, false);
        }
        throw new NullPointerException("pathSegments == null");
    }
    
    public HttpUrl$Builder addQueryParameter(final String s, final String s2) {
        if (s != null) {
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(s, " \"'<>#&=", false, false, true, true));
            final List encodedQueryNamesAndValues = this.encodedQueryNamesAndValues;
            String canonicalize;
            if (s2 != null) {
                canonicalize = HttpUrl.canonicalize(s2, " \"'<>#&=", false, false, true, true);
            }
            else {
                canonicalize = null;
            }
            encodedQueryNamesAndValues.add(canonicalize);
            return this;
        }
        throw new NullPointerException("name == null");
    }
    
    public HttpUrl build() {
        if (this.scheme == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.host != null) {
            return new HttpUrl(this, null);
        }
        throw new IllegalStateException("host == null");
    }
    
    int effectivePort() {
        int n = this.port;
        if (n == -1) {
            n = HttpUrl.defaultPort(this.scheme);
        }
        return n;
    }
    
    public HttpUrl$Builder encodedFragment(final String s) {
        String canonicalize;
        if (s != null) {
            canonicalize = HttpUrl.canonicalize(s, "", true, false, false, false);
        }
        else {
            canonicalize = null;
        }
        this.encodedFragment = canonicalize;
        return this;
    }
    
    public HttpUrl$Builder encodedPassword(final String s) {
        if (s != null) {
            this.encodedPassword = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }
        throw new NullPointerException("encodedPassword == null");
    }
    
    public HttpUrl$Builder encodedPath(final String s) {
        if (s == null) {
            throw new NullPointerException("encodedPath == null");
        }
        if (s.startsWith("/")) {
            this.resolvePath(s, 0, s.length());
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected encodedPath: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public HttpUrl$Builder encodedQuery(final String s) {
        List queryStringToNamesAndValues;
        if (s != null) {
            queryStringToNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, " \"'<>#", true, false, true, true));
        }
        else {
            queryStringToNamesAndValues = null;
        }
        this.encodedQueryNamesAndValues = queryStringToNamesAndValues;
        return this;
    }
    
    public HttpUrl$Builder encodedUsername(final String s) {
        if (s != null) {
            this.encodedUsername = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }
        throw new NullPointerException("encodedUsername == null");
    }
    
    public HttpUrl$Builder fragment(final String s) {
        String canonicalize;
        if (s != null) {
            canonicalize = HttpUrl.canonicalize(s, "", false, false, false, false);
        }
        else {
            canonicalize = null;
        }
        this.encodedFragment = canonicalize;
        return this;
    }
    
    public HttpUrl$Builder host(final String s) {
        if (s == null) {
            throw new NullPointerException("host == null");
        }
        final String canonicalizeHost = canonicalizeHost(s, 0, s.length());
        if (canonicalizeHost != null) {
            this.host = canonicalizeHost;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected host: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    HttpUrl$Builder$ParseResult parse(final HttpUrl httpUrl, final String s) {
        int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(s, 0, s.length());
        final int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(s, skipLeadingAsciiWhitespace, s.length());
        final int schemeDelimiterOffset = schemeDelimiterOffset(s, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
        int n = -1;
        if (schemeDelimiterOffset != n) {
            if (s.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                this.scheme = "https";
                skipLeadingAsciiWhitespace += "https:".length();
            }
            else {
                if (!s.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                    return HttpUrl$Builder$ParseResult.UNSUPPORTED_SCHEME;
                }
                this.scheme = "http";
                skipLeadingAsciiWhitespace += "http:".length();
            }
        }
        else {
            if (httpUrl == null) {
                return HttpUrl$Builder$ParseResult.MISSING_SCHEME;
            }
            this.scheme = httpUrl.scheme;
        }
        final int slashCount = slashCount(s, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
        final int n2 = 2;
        char c = '#';
        if (slashCount < n2 && httpUrl != null && httpUrl.scheme.equals(this.scheme)) {
            this.encodedUsername = httpUrl.encodedUsername();
            this.encodedPassword = httpUrl.encodedPassword();
            this.host = httpUrl.host;
            this.port = httpUrl.port;
            this.encodedPathSegments.clear();
            this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
            if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || s.charAt(skipLeadingAsciiWhitespace) == c) {
                this.encodedQuery(httpUrl.encodedQuery());
            }
        }
        else {
            final int n3 = skipLeadingAsciiWhitespace + slashCount;
            int n4 = 0;
            int n5 = 0;
            int n6 = n3;
            int delimiterOffset = 0;
        Label_0886:
            while (true) {
                delimiterOffset = Util.delimiterOffset(s, n6, skipTrailingAsciiWhitespace, "@/\\?#");
                int char1;
                if (delimiterOffset != skipTrailingAsciiWhitespace) {
                    char1 = s.charAt(delimiterOffset);
                }
                else {
                    char1 = -1;
                }
                final int n7 = char1;
                if (char1 == n || char1 == c || n7 == 47 || n7 == 92) {
                    break;
                }
                switch (n7) {
                    case 64: {
                        int n10;
                        if (n5 == 0) {
                            final int delimiterOffset2 = Util.delimiterOffset(s, n6, delimiterOffset, ':');
                            final String s2 = " \"':;<=>@[]^`{}|/\\?#";
                            final boolean b = true;
                            final boolean b2 = true;
                            final int n8 = delimiterOffset2;
                            final int n9 = delimiterOffset2;
                            n10 = delimiterOffset;
                            final String canonicalize = HttpUrl.canonicalize(s, n6, n8, s2, b, false, false, b2);
                            String string;
                            if (n4 != 0) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append(this.encodedUsername);
                                sb.append("%40");
                                sb.append(canonicalize);
                                string = sb.toString();
                            }
                            else {
                                string = canonicalize;
                            }
                            this.encodedUsername = string;
                            if (n9 != n10) {
                                n5 = 1;
                                this.encodedPassword = HttpUrl.canonicalize(s, n9 + 1, n10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            n4 = 1;
                        }
                        else {
                            n10 = delimiterOffset;
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            sb2.append(HttpUrl.canonicalize(s, n6, n10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                            this.encodedPassword = sb2.toString();
                        }
                        n6 = n10 + 1;
                        break;
                    }
                    case 63: {
                        break Label_0886;
                    }
                }
                n = -1;
                c = '#';
            }
            final int n11 = delimiterOffset;
            final int portColonOffset = portColonOffset(s, n6, delimiterOffset);
            if (portColonOffset + 1 < delimiterOffset) {
                this.host = canonicalizeHost(s, n6, portColonOffset);
                this.port = parsePort(s, portColonOffset + 1, delimiterOffset);
                if (this.port == -1) {
                    return HttpUrl$Builder$ParseResult.INVALID_PORT;
                }
            }
            else {
                this.host = canonicalizeHost(s, n6, portColonOffset);
                this.port = HttpUrl.defaultPort(this.scheme);
            }
            if (this.host == null) {
                return HttpUrl$Builder$ParseResult.INVALID_HOST;
            }
            skipLeadingAsciiWhitespace = n11;
        }
        final int delimiterOffset3 = Util.delimiterOffset(s, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
        this.resolvePath(s, skipLeadingAsciiWhitespace, delimiterOffset3);
        int n12 = delimiterOffset3;
        if (delimiterOffset3 < skipTrailingAsciiWhitespace && s.charAt(delimiterOffset3) == '?') {
            final int delimiterOffset4 = Util.delimiterOffset(s, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
            this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, true));
            n12 = delimiterOffset4;
        }
        if (n12 < skipTrailingAsciiWhitespace && s.charAt(n12) == '#') {
            this.encodedFragment = HttpUrl.canonicalize(s, n12 + 1, skipTrailingAsciiWhitespace, "", true, false, false, false);
        }
        return HttpUrl$Builder$ParseResult.SUCCESS;
    }
    
    public HttpUrl$Builder password(final String s) {
        if (s != null) {
            this.encodedPassword = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
        throw new NullPointerException("password == null");
    }
    
    public HttpUrl$Builder port(final int port) {
        if (port > 0 && port <= (char)(-1)) {
            this.port = port;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected port: ");
        sb.append(port);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public HttpUrl$Builder query(final String s) {
        List queryStringToNamesAndValues;
        if (s != null) {
            queryStringToNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, " \"'<>#", false, false, true, true));
        }
        else {
            queryStringToNamesAndValues = null;
        }
        this.encodedQueryNamesAndValues = queryStringToNamesAndValues;
        return this;
    }
    
    HttpUrl$Builder reencodeForUri() {
        for (int i = 0; i < this.encodedPathSegments.size(); ++i) {
            this.encodedPathSegments.set(i, HttpUrl.canonicalize((String)this.encodedPathSegments.get(i), "[]", true, true, false, true));
        }
        final List encodedQueryNamesAndValues = this.encodedQueryNamesAndValues;
        if (encodedQueryNamesAndValues != null) {
            for (int j = 0; j < encodedQueryNamesAndValues.size(); ++j) {
                final String s = this.encodedQueryNamesAndValues.get(j);
                if (s != null) {
                    this.encodedQueryNamesAndValues.set(j, HttpUrl.canonicalize(s, "\\^`{|}", true, true, true, true));
                }
            }
        }
        final String encodedFragment = this.encodedFragment;
        if (encodedFragment != null) {
            this.encodedFragment = HttpUrl.canonicalize(encodedFragment, " \"#<>\\^`{|}", true, true, false, false);
        }
        return this;
    }
    
    public HttpUrl$Builder removeAllEncodedQueryParameters(final String s) {
        if (s == null) {
            throw new NullPointerException("encodedName == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            return this;
        }
        this.removeAllCanonicalQueryParameters(HttpUrl.canonicalize(s, " \"'<>#&=", true, false, true, true));
        return this;
    }
    
    public HttpUrl$Builder removeAllQueryParameters(final String s) {
        if (s == null) {
            throw new NullPointerException("name == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            return this;
        }
        this.removeAllCanonicalQueryParameters(HttpUrl.canonicalize(s, " \"'<>#&=", false, false, true, true));
        return this;
    }
    
    public HttpUrl$Builder removePathSegment(final int n) {
        this.encodedPathSegments.remove(n);
        if (this.encodedPathSegments.isEmpty()) {
            this.encodedPathSegments.add("");
        }
        return this;
    }
    
    public HttpUrl$Builder scheme(final String s) {
        if (s != null) {
            if (s.equalsIgnoreCase("http")) {
                this.scheme = "http";
            }
            else {
                if (!s.equalsIgnoreCase("https")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("unexpected scheme: ");
                    sb.append(s);
                    throw new IllegalArgumentException(sb.toString());
                }
                this.scheme = "https";
            }
            return this;
        }
        throw new NullPointerException("scheme == null");
    }
    
    public HttpUrl$Builder setEncodedPathSegment(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException("encodedPathSegment == null");
        }
        final String canonicalize = HttpUrl.canonicalize(s, 0, s.length(), " \"<>^`{}|/\\?#", true, false, false, true);
        this.encodedPathSegments.set(n, canonicalize);
        if (!this.isDot(canonicalize) && !this.isDotDot(canonicalize)) {
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected path segment: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public HttpUrl$Builder setEncodedQueryParameter(final String s, final String s2) {
        this.removeAllEncodedQueryParameters(s);
        this.addEncodedQueryParameter(s, s2);
        return this;
    }
    
    public HttpUrl$Builder setPathSegment(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException("pathSegment == null");
        }
        final String canonicalize = HttpUrl.canonicalize(s, 0, s.length(), " \"<>^`{}|/\\?#", false, false, false, true);
        if (!this.isDot(canonicalize) && !this.isDotDot(canonicalize)) {
            this.encodedPathSegments.set(n, canonicalize);
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected path segment: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public HttpUrl$Builder setQueryParameter(final String s, final String s2) {
        this.removeAllQueryParameters(s);
        this.addQueryParameter(s, s2);
        return this;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.scheme);
        sb.append("://");
        final boolean empty = this.encodedUsername.isEmpty();
        final char c = ':';
        if (!empty || !this.encodedPassword.isEmpty()) {
            sb.append(this.encodedUsername);
            if (!this.encodedPassword.isEmpty()) {
                sb.append(c);
                sb.append(this.encodedPassword);
            }
            sb.append('@');
        }
        if (this.host.indexOf(c) != -1) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        }
        else {
            sb.append(this.host);
        }
        final int effectivePort = this.effectivePort();
        if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
            sb.append(c);
            sb.append(effectivePort);
        }
        HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
        if (this.encodedQueryNamesAndValues != null) {
            sb.append('?');
            HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
        }
        if (this.encodedFragment != null) {
            sb.append('#');
            sb.append(this.encodedFragment);
        }
        return sb.toString();
    }
    
    public HttpUrl$Builder username(final String s) {
        if (s != null) {
            this.encodedUsername = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
        throw new NullPointerException("username == null");
    }
}
