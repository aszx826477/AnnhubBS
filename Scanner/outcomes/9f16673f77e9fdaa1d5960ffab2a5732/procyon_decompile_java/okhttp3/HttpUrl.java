// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collection;
import okhttp3.internal.Util;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.net.UnknownHostException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import okio.Buffer;
import java.util.List;

public final class HttpUrl
{
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS;
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List pathSegments;
    private final int port;
    private final List queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    
    static {
        final char[] array;
        final char[] hex_DIGITS = array = new char[16];
        array[0] = '0';
        array[1] = '1';
        array[2] = '2';
        array[3] = '3';
        array[4] = '4';
        array[5] = '5';
        array[6] = '6';
        array[7] = '7';
        array[8] = '8';
        array[9] = '9';
        array[10] = 'A';
        array[11] = 'B';
        array[12] = 'C';
        array[13] = 'D';
        array[14] = 'E';
        array[15] = 'F';
        HEX_DIGITS = hex_DIGITS;
    }
    
    private HttpUrl(final HttpUrl$Builder httpUrl$Builder) {
        this.scheme = httpUrl$Builder.scheme;
        this.username = percentDecode(httpUrl$Builder.encodedUsername, false);
        this.password = percentDecode(httpUrl$Builder.encodedPassword, false);
        this.host = httpUrl$Builder.host;
        this.port = httpUrl$Builder.effectivePort();
        this.pathSegments = this.percentDecode(httpUrl$Builder.encodedPathSegments, false);
        final List encodedQueryNamesAndValues = httpUrl$Builder.encodedQueryNamesAndValues;
        String percentDecode = null;
        List percentDecode2;
        if (encodedQueryNamesAndValues != null) {
            percentDecode2 = this.percentDecode(httpUrl$Builder.encodedQueryNamesAndValues, true);
        }
        else {
            percentDecode2 = null;
        }
        this.queryNamesAndValues = percentDecode2;
        if (httpUrl$Builder.encodedFragment != null) {
            percentDecode = percentDecode(httpUrl$Builder.encodedFragment, false);
        }
        this.fragment = percentDecode;
        this.url = httpUrl$Builder.toString();
    }
    
    static String canonicalize(final String s, final int n, final int n2, final String s2, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        int i = n;
        while (i < n2) {
            final int codePoint = s.codePointAt(i);
            if (codePoint >= 32 && codePoint != 127) {
                if (codePoint < 128 || !b4) {
                    Label_0167: {
                        if (s2.indexOf(codePoint) == -1) {
                            Label_0147: {
                                if (codePoint == 37) {
                                    if (!b) {
                                        break Label_0167;
                                    }
                                    if (b2 && !percentEncoded(s, i, n2)) {
                                        break Label_0147;
                                    }
                                }
                                if (codePoint != 43 || !b3) {
                                    i += Character.charCount(codePoint);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            final Buffer buffer = new Buffer();
            buffer.writeUtf8(s, n, i);
            canonicalize(buffer, s, i, n2, s2, b, b2, b3, b4);
            return buffer.readUtf8();
        }
        return s.substring(n, n2);
    }
    
    static String canonicalize(final String s, final String s2, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        return canonicalize(s, 0, s.length(), s2, b, b2, b3, b4);
    }
    
    static void canonicalize(final Buffer buffer, final String s, final int n, final int n2, final String s2, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        Buffer buffer2 = null;
        int codePoint;
        for (int i = n; i < n2; i += Character.charCount(codePoint)) {
            codePoint = s.codePointAt(i);
            if (!b || (codePoint != 9 && codePoint != 10 && codePoint != 12 && codePoint != 13)) {
                if (codePoint == 43 && b3) {
                    String s3;
                    if (b) {
                        s3 = "+";
                    }
                    else {
                        s3 = "%2B";
                    }
                    buffer.writeUtf8(s3);
                }
                else {
                    final int n3 = 32;
                    final int n4 = 37;
                    Label_0226: {
                        if (codePoint >= n3 && codePoint != 127 && (codePoint < 128 || !b4)) {
                            Label_0223: {
                                if (s2.indexOf(codePoint) == -1) {
                                    if (codePoint == n4) {
                                        if (!b) {
                                            break Label_0223;
                                        }
                                        if (b2) {
                                            if (!percentEncoded(s, i, n2)) {
                                                break Label_0226;
                                            }
                                        }
                                    }
                                    buffer.writeUtf8CodePoint(codePoint);
                                    continue;
                                }
                            }
                        }
                    }
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePoint);
                    while (!buffer2.exhausted()) {
                        final int n5 = buffer2.readByte() & 0xFF;
                        buffer.writeByte(n4);
                        buffer.writeByte((int)HttpUrl.HEX_DIGITS[n5 >> 4 & 0xF]);
                        buffer.writeByte((int)HttpUrl.HEX_DIGITS[n5 & 0xF]);
                    }
                }
            }
        }
    }
    
    static int decodeHexDigit(final char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 97 + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 65 + 10;
        }
        return -1;
    }
    
    public static int defaultPort(final String s) {
        if (s.equals("http")) {
            return 80;
        }
        if (s.equals("https")) {
            return 443;
        }
        return -1;
    }
    
    public static HttpUrl get(final URI uri) {
        return parse(uri.toString());
    }
    
    public static HttpUrl get(final URL url) {
        return parse(url.toString());
    }
    
    static HttpUrl getChecked(final String s) {
        final HttpUrl$Builder httpUrl$Builder = new HttpUrl$Builder();
        final HttpUrl$Builder$ParseResult parse = httpUrl$Builder.parse(null, s);
        switch (HttpUrl$1.$SwitchMap$okhttp3$HttpUrl$Builder$ParseResult[parse.ordinal()]) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid URL: ");
                sb.append(parse);
                sb.append(" for ");
                sb.append(s);
                throw new MalformedURLException(sb.toString());
            }
            case 2: {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid host: ");
                sb2.append(s);
                throw new UnknownHostException(sb2.toString());
            }
            case 1: {
                return httpUrl$Builder.build();
            }
        }
    }
    
    static void namesAndValuesToQueryString(final StringBuilder sb, final List list) {
        for (int i = 0; i < list.size(); i += 2) {
            final String s = list.get(i);
            final String s2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(s);
            if (s2 != null) {
                sb.append('=');
                sb.append(s2);
            }
        }
    }
    
    public static HttpUrl parse(final String s) {
        final HttpUrl$Builder httpUrl$Builder = new HttpUrl$Builder();
        HttpUrl build = null;
        if (httpUrl$Builder.parse(null, s) == HttpUrl$Builder$ParseResult.SUCCESS) {
            build = httpUrl$Builder.build();
        }
        return build;
    }
    
    static void pathSegmentsToString(final StringBuilder sb, final List list) {
        for (int i = 0; i < list.size(); ++i) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }
    
    static String percentDecode(final String s, final int n, final int n2, final boolean b) {
        for (int i = n; i < n2; ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '%' || (char1 == '+' && b)) {
                final Buffer buffer = new Buffer();
                buffer.writeUtf8(s, n, i);
                percentDecode(buffer, s, i, n2, b);
                return buffer.readUtf8();
            }
        }
        return s.substring(n, n2);
    }
    
    static String percentDecode(final String s, final boolean b) {
        return percentDecode(s, 0, s.length(), b);
    }
    
    private List percentDecode(final List list, final boolean b) {
        final ArrayList<String> list2 = new ArrayList<String>(list.size());
        for (final String s : list) {
            String percentDecode;
            if (s != null) {
                percentDecode = percentDecode(s, b);
            }
            else {
                percentDecode = null;
            }
            list2.add(percentDecode);
        }
        return Collections.unmodifiableList((List<?>)list2);
    }
    
    static void percentDecode(final Buffer buffer, final String s, final int n, final int n2, final boolean b) {
        int codePoint;
        for (int i = n; i < n2; i += Character.charCount(codePoint)) {
            codePoint = s.codePointAt(i);
            if (codePoint == 37 && i + 2 < n2) {
                final int decodeHexDigit = decodeHexDigit(s.charAt(i + 1));
                final int decodeHexDigit2 = decodeHexDigit(s.charAt(i + 2));
                final int n3 = -1;
                if (decodeHexDigit != n3 && decodeHexDigit2 != n3) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i += 2;
                    continue;
                }
            }
            else if (codePoint == 43 && b) {
                buffer.writeByte(32);
                continue;
            }
            buffer.writeUtf8CodePoint(codePoint);
        }
    }
    
    static boolean percentEncoded(final String s, final int n, final int n2) {
        if (n + 2 < n2) {
            if (s.charAt(n) == '%') {
                final int decodeHexDigit = decodeHexDigit(s.charAt(n + 1));
                final int n3 = -1;
                if (decodeHexDigit != n3) {
                    if (decodeHexDigit(s.charAt(n + 2)) != n3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    static List queryStringToNamesAndValues(final String s) {
        final ArrayList<String> list = new ArrayList<String>();
        int n;
        for (int i = 0; i <= s.length(); i = n + 1) {
            n = s.indexOf(38, i);
            final int n2 = -1;
            if (n == n2) {
                n = s.length();
            }
            final int index = s.indexOf(61, i);
            if (index != n2 && index <= n) {
                list.add(s.substring(i, index));
                list.add(s.substring(index + 1, n));
            }
            else {
                list.add(s.substring(i, n));
                list.add(null);
            }
        }
        return list;
    }
    
    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }
    
    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }
    
    public String encodedPath() {
        final int index = this.url.indexOf(47, this.scheme.length() + 3);
        final String url = this.url;
        return this.url.substring(index, Util.delimiterOffset(url, index, url.length(), "?#"));
    }
    
    public List encodedPathSegments() {
        final String url = this.url;
        final int n = this.scheme.length() + 3;
        final char c = '/';
        final int index = url.indexOf(c, n);
        final String url2 = this.url;
        final int delimiterOffset = Util.delimiterOffset(url2, index, url2.length(), "?#");
        final ArrayList<String> list = new ArrayList<String>();
        int delimiterOffset2;
        for (int i = index; i < delimiterOffset; i = delimiterOffset2) {
            final int n2 = i + 1;
            delimiterOffset2 = Util.delimiterOffset(this.url, n2, delimiterOffset, c);
            list.add(this.url.substring(n2, delimiterOffset2));
        }
        return list;
    }
    
    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        final int n = this.url.indexOf(63) + 1;
        final String url = this.url;
        return this.url.substring(n, Util.delimiterOffset(url, n + 1, url.length(), '#'));
    }
    
    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        final int n = this.scheme.length() + 3;
        final String url = this.url;
        return this.url.substring(n, Util.delimiterOffset(url, n, url.length(), ":@"));
    }
    
    public boolean equals(final Object o) {
        return o instanceof HttpUrl && ((HttpUrl)o).url.equals(this.url);
    }
    
    public String fragment() {
        return this.fragment;
    }
    
    public int hashCode() {
        return this.url.hashCode();
    }
    
    public String host() {
        return this.host;
    }
    
    public boolean isHttps() {
        return this.scheme.equals("https");
    }
    
    public HttpUrl$Builder newBuilder() {
        final HttpUrl$Builder httpUrl$Builder = new HttpUrl$Builder();
        httpUrl$Builder.scheme = this.scheme;
        httpUrl$Builder.encodedUsername = this.encodedUsername();
        httpUrl$Builder.encodedPassword = this.encodedPassword();
        httpUrl$Builder.host = this.host;
        int port;
        if (this.port != defaultPort(this.scheme)) {
            port = this.port;
        }
        else {
            port = -1;
        }
        httpUrl$Builder.port = port;
        httpUrl$Builder.encodedPathSegments.clear();
        httpUrl$Builder.encodedPathSegments.addAll(this.encodedPathSegments());
        httpUrl$Builder.encodedQuery(this.encodedQuery());
        httpUrl$Builder.encodedFragment = this.encodedFragment();
        return httpUrl$Builder;
    }
    
    public HttpUrl$Builder newBuilder(final String s) {
        final HttpUrl$Builder httpUrl$Builder = new HttpUrl$Builder();
        HttpUrl$Builder httpUrl$Builder2;
        if (httpUrl$Builder.parse(this, s) == HttpUrl$Builder$ParseResult.SUCCESS) {
            httpUrl$Builder2 = httpUrl$Builder;
        }
        else {
            httpUrl$Builder2 = null;
        }
        return httpUrl$Builder2;
    }
    
    public String password() {
        return this.password;
    }
    
    public List pathSegments() {
        return this.pathSegments;
    }
    
    public int pathSize() {
        return this.pathSegments.size();
    }
    
    public int port() {
        return this.port;
    }
    
    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }
    
    public String queryParameter(final String s) {
        final List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues == null) {
            return null;
        }
        for (int i = 0; i < queryNamesAndValues.size(); i += 2) {
            if (s.equals(this.queryNamesAndValues.get(i))) {
                return (String)this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }
    
    public String queryParameterName(final int n) {
        final List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues != null) {
            return queryNamesAndValues.get(n * 2);
        }
        throw new IndexOutOfBoundsException();
    }
    
    public Set queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        final LinkedHashSet<Object> set = new LinkedHashSet<Object>();
        for (int i = 0; i < this.queryNamesAndValues.size(); i += 2) {
            set.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet((Set<?>)set);
    }
    
    public String queryParameterValue(final int n) {
        final List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues != null) {
            return queryNamesAndValues.get(n * 2 + 1);
        }
        throw new IndexOutOfBoundsException();
    }
    
    public List queryParameterValues(final String s) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.queryNamesAndValues.size(); i += 2) {
            if (s.equals(this.queryNamesAndValues.get(i))) {
                list.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public int querySize() {
        final List queryNamesAndValues = this.queryNamesAndValues;
        int n;
        if (queryNamesAndValues != null) {
            n = queryNamesAndValues.size() / 2;
        }
        else {
            n = 0;
        }
        return n;
    }
    
    public HttpUrl resolve(final String s) {
        final HttpUrl$Builder builder = this.newBuilder(s);
        HttpUrl build;
        if (builder != null) {
            build = builder.build();
        }
        else {
            build = null;
        }
        return build;
    }
    
    public String scheme() {
        return this.scheme;
    }
    
    public String toString() {
        return this.url;
    }
    
    public URI uri() {
        final String string = this.newBuilder().reencodeForUri().toString();
        try {
            return new URI(string);
        }
        catch (URISyntaxException ex) {
            final String s = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";
            final String s2 = "";
            final String s3 = string;
            final String s4 = s;
            try {
                final String replaceAll = s3.replaceAll(s4, s2);
                try {
                    return URI.create(replaceAll);
                }
                catch (Exception ex2) {
                    throw new RuntimeException(ex);
                }
            }
            catch (Exception ex3) {}
        }
    }
    
    public URL url() {
        try {
            try {
                return new URL(this.url);
            }
            catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        catch (MalformedURLException ex2) {}
    }
    
    public String username() {
        return this.username;
    }
}
