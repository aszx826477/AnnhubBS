// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

public final class HttpMethod
{
    public static boolean invalidatesCache(final String s) {
        if (!s.equals("POST")) {
            if (!s.equals("PATCH")) {
                if (!s.equals("PUT")) {
                    if (!s.equals("DELETE")) {
                        if (!s.equals("MOVE")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean permitsRequestBody(final String s) {
        if (!requiresRequestBody(s)) {
            if (!s.equals("OPTIONS")) {
                if (!s.equals("DELETE")) {
                    if (!s.equals("PROPFIND")) {
                        if (!s.equals("MKCOL")) {
                            if (!s.equals("LOCK")) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean redirectsToGet(final String s) {
        return s.equals("PROPFIND") ^ true;
    }
    
    public static boolean requiresRequestBody(final String s) {
        if (!s.equals("POST")) {
            if (!s.equals("PUT")) {
                if (!s.equals("PATCH")) {
                    if (!s.equals("PROPPATCH")) {
                        if (!s.equals("REPORT")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
