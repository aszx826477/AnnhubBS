// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.http.HttpDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import java.util.regex.Pattern;

public final class Cookie
{
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    
    static {
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }
    
    private Cookie(final String name, final String value, final long expiresAt, final String domain, final String path, final boolean secure, final boolean httpOnly, final boolean hostOnly, final boolean persistent) {
        this.name = name;
        this.value = value;
        this.expiresAt = expiresAt;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.hostOnly = hostOnly;
        this.persistent = persistent;
    }
    
    private Cookie(final Cookie$Builder cookie$Builder) {
        if (cookie$Builder.name == null) {
            throw new NullPointerException("builder.name == null");
        }
        if (cookie$Builder.value == null) {
            throw new NullPointerException("builder.value == null");
        }
        if (cookie$Builder.domain != null) {
            this.name = cookie$Builder.name;
            this.value = cookie$Builder.value;
            this.expiresAt = cookie$Builder.expiresAt;
            this.domain = cookie$Builder.domain;
            this.path = cookie$Builder.path;
            this.secure = cookie$Builder.secure;
            this.httpOnly = cookie$Builder.httpOnly;
            this.persistent = cookie$Builder.persistent;
            this.hostOnly = cookie$Builder.hostOnly;
            return;
        }
        throw new NullPointerException("builder.domain == null");
    }
    
    private static int dateCharacterOffset(final String s, final int n, final int n2, final boolean b) {
        for (int i = n; i < n2; ++i) {
            final char char1 = s.charAt(i);
            if (((char1 < ' ' && char1 != '\t') || char1 >= '\u007f' || (char1 >= '0' && char1 <= '9') || (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || char1 == ':') == (b ^ true)) {
                return i;
            }
        }
        return n2;
    }
    
    private static boolean domainMatch(final HttpUrl httpUrl, final String s) {
        final String host = httpUrl.host();
        final boolean equals = host.equals(s);
        final int n = 1;
        if (equals) {
            return n != 0;
        }
        if (host.endsWith(s)) {
            if (host.charAt(host.length() - s.length() - n) == '.') {
                if (!Util.verifyAsIpAddress(host)) {
                    return n != 0;
                }
            }
        }
        return false;
    }
    
    static Cookie parse(final long n, final HttpUrl httpUrl, final String s) {
        final int length = s.length();
        char c = ';';
        final int delimiterOffset = Util.delimiterOffset(s, 0, length, c);
        char c2 = '=';
        final int delimiterOffset2 = Util.delimiterOffset(s, 0, delimiterOffset, c2);
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        final String trimSubstring = Util.trimSubstring(s, 0, delimiterOffset2);
        if (trimSubstring.isEmpty()) {
            return null;
        }
        final String trimSubstring2 = Util.trimSubstring(s, delimiterOffset2 + 1, delimiterOffset);
        long expires = 253402300799999L;
        final long n2 = -1;
        String s2 = null;
        String s3 = null;
        final boolean b = true;
        final int n3 = delimiterOffset + 1;
        long maxAge = n2;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = b;
        boolean b5 = false;
        int delimiterOffset3;
        int delimiterOffset4;
        String trimSubstring3;
        String trimSubstring4;
        String domain;
        Label_0446:Label_0317_Outer:
        for (int i = n3; i < length; i = delimiterOffset3 + 1, c = ';', c2 = '=') {
            delimiterOffset3 = Util.delimiterOffset(s, i, length, c);
            delimiterOffset4 = Util.delimiterOffset(s, i, delimiterOffset3, c2);
            trimSubstring3 = Util.trimSubstring(s, i, delimiterOffset4);
            if (delimiterOffset4 < delimiterOffset3) {
                trimSubstring4 = Util.trimSubstring(s, delimiterOffset4 + 1, delimiterOffset3);
            }
            else {
                trimSubstring4 = "";
            }
            if (trimSubstring3.equalsIgnoreCase("expires")) {
                while (true) {
                    try {
                        expires = parseExpires(trimSubstring4, 0, trimSubstring4.length());
                        b5 = true;
                        continue Label_0446;
                    }
                    catch (IllegalArgumentException ex) {
                        continue;
                    }
                    break;
                }
            }
            if (trimSubstring3.equalsIgnoreCase("max-age")) {
                while (true) {
                    try {
                        maxAge = parseMaxAge(trimSubstring4);
                        b5 = true;
                        continue Label_0317_Outer;
                    }
                    catch (NumberFormatException ex2) {
                        continue;
                    }
                    break;
                }
            }
            if (trimSubstring3.equalsIgnoreCase("domain")) {
                try {
                    domain = parseDomain(trimSubstring4);
                    b4 = false;
                    s2 = domain;
                }
                catch (IllegalArgumentException ex3) {}
            }
            else if (trimSubstring3.equalsIgnoreCase("path")) {
                s3 = trimSubstring4;
            }
            else if (trimSubstring3.equalsIgnoreCase("secure")) {
                b2 = true;
            }
            else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                b3 = true;
            }
        }
        long n4;
        if (maxAge == Long.MIN_VALUE) {
            n4 = Long.MIN_VALUE;
        }
        else if (maxAge != -1) {
            long n5;
            if (maxAge <= 9223372036854775L) {
                n5 = 1000L * maxAge;
            }
            else {
                n5 = Long.MAX_VALUE;
            }
            final long n6 = n + n5;
            if (n6 >= n && n6 <= 253402300799999L) {
                n4 = n6;
            }
            else {
                n4 = 253402300799999L;
            }
        }
        else {
            n4 = expires;
        }
        String host;
        if (s2 == null) {
            host = httpUrl.host();
        }
        else {
            if (!domainMatch(httpUrl, s2)) {
                return null;
            }
            host = s2;
        }
        String substring;
        if (s3 != null && s3.startsWith("/")) {
            substring = s3;
        }
        else {
            final String encodedPath = httpUrl.encodedPath();
            final int lastIndex = encodedPath.lastIndexOf(47);
            if (lastIndex != 0) {
                substring = encodedPath.substring(0, lastIndex);
            }
            else {
                substring = "/";
            }
        }
        return new Cookie(trimSubstring, trimSubstring2, n4, host, substring, b2, b3, b4, b5);
    }
    
    public static Cookie parse(final HttpUrl httpUrl, final String s) {
        return parse(System.currentTimeMillis(), httpUrl, s);
    }
    
    public static List parseAll(final HttpUrl httpUrl, final Headers headers) {
        final List values = headers.values("Set-Cookie");
        Object o = null;
        for (int i = 0; i < values.size(); ++i) {
            final Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (o == null) {
                    o = new ArrayList<Cookie>();
                }
                ((List<Cookie>)o).add(parse);
            }
        }
        List<Object> list;
        if (o != null) {
            list = Collections.unmodifiableList((List<?>)o);
        }
        else {
            list = Collections.emptyList();
        }
        return list;
    }
    
    private static String parseDomain(String substring) {
        if (substring.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (substring.startsWith(".")) {
            substring = substring.substring(1);
        }
        final String domainToAscii = Util.domainToAscii(substring);
        if (domainToAscii != null) {
            return domainToAscii;
        }
        throw new IllegalArgumentException();
    }
    
    private static long parseExpires(final String s, int n, final int n2) {
        n = dateCharacterOffset(s, n, n2, false);
        int int1 = -1;
        int int2 = -1;
        int int3 = -1;
        int int4 = -1;
        int n3 = -1;
        int int5 = -1;
        final Matcher matcher = Cookie.TIME_PATTERN.matcher(s);
        int n4;
        int n5;
        int n6;
        while (true) {
            n4 = 2;
            n5 = -1;
            n6 = 1;
            if (n >= n2) {
                break;
            }
            final int dateCharacterOffset = dateCharacterOffset(s, n + 1, n2, n6 != 0);
            matcher.region(n, dateCharacterOffset);
            if (int1 == n5 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                int1 = Integer.parseInt(matcher.group(n6));
                int2 = Integer.parseInt(matcher.group(n4));
                int3 = Integer.parseInt(matcher.group(3));
            }
            else if (int4 == n5 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                int4 = Integer.parseInt(matcher.group(n6));
            }
            else if (n3 == n5 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                n3 = Cookie.MONTH_PATTERN.pattern().indexOf(matcher.group(n6).toLowerCase(Locale.US)) / 4;
            }
            else if (int5 == n5 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                int5 = Integer.parseInt(matcher.group(n6));
            }
            n = dateCharacterOffset(s, dateCharacterOffset + 1, n2, false);
        }
        if (int5 >= 70 && int5 <= 99) {
            int5 += 1900;
        }
        if (int5 >= 0 && int5 <= 69) {
            int5 += 2000;
        }
        if (int5 < 1601) {
            throw new IllegalArgumentException();
        }
        if (n3 == n5) {
            throw new IllegalArgumentException();
        }
        if (int4 < n6 || int4 > 31) {
            throw new IllegalArgumentException();
        }
        if (int1 >= 0 && int1 <= 23) {
            if (int2 >= 0) {
                final int n7 = 59;
                if (int2 <= n7) {
                    if (int3 >= 0 && int3 <= n7) {
                        final GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(n6, int5);
                        gregorianCalendar.set(n4, n3 - 1);
                        gregorianCalendar.set(5, int4);
                        gregorianCalendar.set(11, int1);
                        gregorianCalendar.set(12, int2);
                        gregorianCalendar.set(13, int3);
                        gregorianCalendar.set(14, 0);
                        return gregorianCalendar.getTimeInMillis();
                    }
                    throw new IllegalArgumentException();
                }
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
    
    private static long parseMaxAge(final String s) {
        long n = Long.MIN_VALUE;
        try {
            final long long1 = Long.parseLong(s);
            if (long1 > 0L) {
                n = long1;
            }
            return n;
        }
        catch (NumberFormatException ex) {
            if (s.matches("-?\\d+")) {
                if (!s.startsWith("-")) {
                    n = Long.MAX_VALUE;
                }
                return n;
            }
            throw ex;
        }
    }
    
    private static boolean pathMatch(final HttpUrl httpUrl, final String s) {
        final String encodedPath = httpUrl.encodedPath();
        final boolean equals = encodedPath.equals(s);
        final boolean b = true;
        if (equals) {
            return b;
        }
        if (encodedPath.startsWith(s)) {
            if (s.endsWith("/")) {
                return b;
            }
            if (encodedPath.charAt(s.length()) == '/') {
                return b;
            }
        }
        return false;
    }
    
    public String domain() {
        return this.domain;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Cookie;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final Cookie cookie = (Cookie)o;
        if (cookie.name.equals(this.name)) {
            if (cookie.value.equals(this.value)) {
                if (cookie.domain.equals(this.domain)) {
                    if (cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public long expiresAt() {
        return this.expiresAt;
    }
    
    public int hashCode() {
        final int n = ((((17 * 31 + this.name.hashCode()) * 31 + this.value.hashCode()) * 31 + this.domain.hashCode()) * 31 + this.path.hashCode()) * 31;
        final long expiresAt = this.expiresAt;
        return ((((n + (int)(expiresAt ^ expiresAt >>> 32)) * 31 + ((this.secure ^ true) ? 1 : 0)) * 31 + ((this.httpOnly ^ true) ? 1 : 0)) * 31 + ((this.persistent ^ true) ? 1 : 0)) * 31 + ((this.hostOnly ^ true) ? 1 : 0);
    }
    
    public boolean hostOnly() {
        return this.hostOnly;
    }
    
    public boolean httpOnly() {
        return this.httpOnly;
    }
    
    public boolean matches(final HttpUrl httpUrl) {
        boolean b;
        if (this.hostOnly) {
            b = httpUrl.host().equals(this.domain);
        }
        else {
            b = domainMatch(httpUrl, this.domain);
        }
        return b && pathMatch(httpUrl, this.path) && (!this.secure || httpUrl.isHttps());
    }
    
    public String name() {
        return this.name;
    }
    
    public String path() {
        return this.path;
    }
    
    public boolean persistent() {
        return this.persistent;
    }
    
    public boolean secure() {
        return this.secure;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            }
            else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
    
    public String value() {
        return this.value;
    }
}
