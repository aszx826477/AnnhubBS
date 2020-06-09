// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.util.Iterator;
import okhttp3.internal.Util;
import okhttp3.Request;
import okhttp3.Headers$Builder;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Set;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.CookieJar;
import okhttp3.Challenge;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;
import okhttp3.Headers;

public final class HttpHeaders
{
    public static long contentLength(final Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }
    
    public static long contentLength(final Response response) {
        return contentLength(response.headers());
    }
    
    public static boolean hasBody(final Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        final int code = response.code();
        final int n = 100;
        final boolean b = true;
        if ((code < n || code >= 200) && code != 204 && code != 304) {
            return b;
        }
        return (contentLength(response) != -1 || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) && b;
    }
    
    public static boolean hasVaryAll(final Headers headers) {
        return varyFields(headers).contains("*");
    }
    
    public static boolean hasVaryAll(final Response response) {
        return hasVaryAll(response.headers());
    }
    
    public static List parseChallenges(final Headers headers, final String s) {
        final ArrayList<Challenge> list = new ArrayList<Challenge>();
        for (int i = 0; i < headers.size(); ++i) {
            if (s.equalsIgnoreCase(headers.name(i))) {
                final String value = headers.value(i);
                int skipWhitespace2;
                for (int j = 0; j < value.length(); j = skipWhitespace2) {
                    final int n = j;
                    final int skipUntil = skipUntil(value, j, " ");
                    final String trim = value.substring(n, skipUntil).trim();
                    final int skipWhitespace = skipWhitespace(value, skipUntil);
                    if (!value.regionMatches(true, skipWhitespace, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    final int n2 = skipWhitespace + "realm=\"".length();
                    final int skipUntil2 = skipUntil(value, n2, "\"");
                    final String substring = value.substring(n2, skipUntil2);
                    skipWhitespace2 = skipWhitespace(value, skipUntil(value, skipUntil2 + 1, ",") + 1);
                    list.add(new Challenge(trim, substring));
                }
            }
        }
        return list;
    }
    
    public static int parseSeconds(final String s, final int n) {
        try {
            final long long1 = Long.parseLong(s);
            if (long1 > 2147483647L) {
                return -1 >>> 1;
            }
            if (long1 < 0L) {
                return 0;
            }
            return (int)long1;
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public static void receiveHeaders(final CookieJar cookieJar, final HttpUrl httpUrl, final Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        final List all = Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }
    
    public static int skipUntil(final String s, int n, final String s2) {
        while (n < s.length() && s2.indexOf(s.charAt(n)) == -1) {
            ++n;
        }
        return n;
    }
    
    public static int skipWhitespace(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 != ' ' && char1 != '\t') {
                break;
            }
            ++i;
        }
        return i;
    }
    
    private static long stringToLong(final String s) {
        final long n = -1;
        if (s == null) {
            return n;
        }
        try {
            return Long.parseLong(s);
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public static Set varyFields(final Headers headers) {
        Set<String> emptySet = (Set<String>)Collections.emptySet();
        for (int i = 0; i < headers.size(); ++i) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                final String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                }
                final String[] split = value.split(",");
                for (int length = split.length, j = 0; j < length; ++j) {
                    emptySet.add(split[j].trim());
                }
            }
        }
        return emptySet;
    }
    
    private static Set varyFields(final Response response) {
        return varyFields(response.headers());
    }
    
    public static Headers varyHeaders(final Headers headers, final Headers headers2) {
        final Set varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers$Builder().build();
        }
        final Headers$Builder headers$Builder = new Headers$Builder();
        for (int i = 0; i < headers.size(); ++i) {
            final String name = headers.name(i);
            if (varyFields.contains(name)) {
                headers$Builder.add(name, headers.value(i));
            }
        }
        return headers$Builder.build();
    }
    
    public static Headers varyHeaders(final Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }
    
    public static boolean varyMatches(final Response response, final Headers headers, final Request request) {
        for (final String s : varyFields(response)) {
            if (!Util.equal(headers.values(s), request.headers(s))) {
                return false;
            }
        }
        return true;
    }
}
