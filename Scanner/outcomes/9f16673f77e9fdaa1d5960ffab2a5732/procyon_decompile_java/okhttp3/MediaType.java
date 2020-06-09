// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.Locale;
import java.util.regex.Pattern;

public final class MediaType
{
    private static final Pattern PARAMETER;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;
    
    static {
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }
    
    private MediaType(final String mediaType, final String type, final String subtype, final String charset) {
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.charset = charset;
    }
    
    public static MediaType parse(final String s) {
        final Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(s);
        if (!matcher.lookingAt()) {
            return null;
        }
        final int n = 1;
        final String lowerCase = matcher.group(n).toLowerCase(Locale.US);
        final int n2 = 2;
        final String lowerCase2 = matcher.group(n2).toLowerCase(Locale.US);
        String s2 = null;
        final Matcher matcher2 = MediaType.PARAMETER.matcher(s);
        for (int i = matcher.end(); i < s.length(); i = matcher2.end()) {
            matcher2.region(i, s.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            final String group = matcher2.group(n);
            if (group != null) {
                if (group.equalsIgnoreCase("charset")) {
                    String s3;
                    if (matcher2.group(n2) != null) {
                        s3 = matcher2.group(n2);
                    }
                    else {
                        s3 = matcher2.group(3);
                    }
                    if (s2 != null && !s3.equalsIgnoreCase(s2)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Multiple different charsets: ");
                        sb.append(s);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    s2 = s3;
                }
            }
        }
        return new MediaType(s, lowerCase, lowerCase2, s2);
    }
    
    public Charset charset() {
        final String charset = this.charset;
        Charset forName;
        if (charset != null) {
            forName = Charset.forName(charset);
        }
        else {
            forName = null;
        }
        return forName;
    }
    
    public Charset charset(final Charset charset) {
        final String charset2 = this.charset;
        Charset forName;
        if (charset2 != null) {
            forName = Charset.forName(charset2);
        }
        else {
            forName = charset;
        }
        return forName;
    }
    
    public boolean equals(final Object o) {
        return o instanceof MediaType && ((MediaType)o).mediaType.equals(this.mediaType);
    }
    
    public int hashCode() {
        return this.mediaType.hashCode();
    }
    
    public String subtype() {
        return this.subtype;
    }
    
    public String toString() {
        return this.mediaType;
    }
    
    public String type() {
        return this.type;
    }
}
