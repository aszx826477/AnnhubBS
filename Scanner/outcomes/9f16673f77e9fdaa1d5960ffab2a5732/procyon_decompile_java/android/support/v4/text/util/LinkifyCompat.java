// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text.util;

import java.util.List;
import java.util.Collections;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import android.webkit.WebView;
import java.util.regex.Matcher;
import java.util.Locale;
import java.util.Iterator;
import android.support.v4.util.PatternsCompat;
import java.util.ArrayList;
import android.text.util.Linkify;
import android.text.style.URLSpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.util.Linkify$TransformFilter;
import android.text.util.Linkify$MatchFilter;
import java.util.regex.Pattern;
import android.text.method.MovementMethod;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import java.util.Comparator;

public final class LinkifyCompat
{
    private static final Comparator COMPARATOR;
    private static final String[] EMPTY_STRING;
    
    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new LinkifyCompat$1();
    }
    
    private static void addLinkMovementMethod(final TextView textView) {
        final MovementMethod movementMethod = textView.getMovementMethod();
        if (movementMethod == null || movementMethod instanceof LinkMovementMethod) {
            if (textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }
    
    public static final void addLinks(final TextView textView, final Pattern pattern, final String s) {
        addLinks(textView, pattern, s, null, null, null);
    }
    
    public static final void addLinks(final TextView textView, final Pattern pattern, final String s, final Linkify$MatchFilter linkify$MatchFilter, final Linkify$TransformFilter linkify$TransformFilter) {
        addLinks(textView, pattern, s, null, linkify$MatchFilter, linkify$TransformFilter);
    }
    
    public static final void addLinks(final TextView textView, final Pattern pattern, final String s, final String[] array, final Linkify$MatchFilter linkify$MatchFilter, final Linkify$TransformFilter linkify$TransformFilter) {
        final SpannableString value = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable)value, pattern, s, array, linkify$MatchFilter, linkify$TransformFilter)) {
            textView.setText((CharSequence)value);
            addLinkMovementMethod(textView);
        }
    }
    
    public static final boolean addLinks(final Spannable spannable, final int n) {
        if (n == 0) {
            return false;
        }
        final URLSpan[] array = (URLSpan[])spannable.getSpans(0, spannable.length(), (Class)URLSpan.class);
        final int length = array.length;
        final int n2 = 1;
        for (int i = length - n2; i >= 0; --i) {
            spannable.removeSpan((Object)array[i]);
        }
        if ((n & 0x4) != 0x0) {
            Linkify.addLinks(spannable, 4);
        }
        final ArrayList<LinkifyCompat$LinkSpec> list = new ArrayList<LinkifyCompat$LinkSpec>();
        if ((n & 0x1) != 0x0) {
            final Pattern autolink_WEB_URL = PatternsCompat.AUTOLINK_WEB_URL;
            final String[] array2 = { "http://", null, null };
            array2[n2] = "https://";
            array2[2] = "rtsp://";
            gatherLinks(list, spannable, autolink_WEB_URL, array2, Linkify.sUrlMatchFilter, null);
        }
        if ((n & 0x2) != 0x0) {
            final Pattern autolink_EMAIL_ADDRESS = PatternsCompat.AUTOLINK_EMAIL_ADDRESS;
            final String[] array3 = new String[n2];
            array3[0] = "mailto:";
            gatherLinks(list, spannable, autolink_EMAIL_ADDRESS, array3, null, null);
        }
        if ((n & 0x8) != 0x0) {
            gatherMapLinks(list, spannable);
        }
        pruneOverlaps(list, spannable);
        if (list.size() == 0) {
            return false;
        }
        for (final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec : list) {
            if (linkifyCompat$LinkSpec.frameworkAddedSpan == null) {
                applyLink(linkifyCompat$LinkSpec.url, linkifyCompat$LinkSpec.start, linkifyCompat$LinkSpec.end, spannable);
            }
        }
        return n2 != 0;
    }
    
    public static final boolean addLinks(final Spannable spannable, final Pattern pattern, final String s) {
        return addLinks(spannable, pattern, s, null, null, null);
    }
    
    public static final boolean addLinks(final Spannable spannable, final Pattern pattern, final String s, final Linkify$MatchFilter linkify$MatchFilter, final Linkify$TransformFilter linkify$TransformFilter) {
        return addLinks(spannable, pattern, s, null, linkify$MatchFilter, linkify$TransformFilter);
    }
    
    public static final boolean addLinks(final Spannable spannable, final Pattern pattern, String s, String[] empty_STRING, final Linkify$MatchFilter linkify$MatchFilter, final Linkify$TransformFilter linkify$TransformFilter) {
        if (s == null) {
            s = "";
        }
        final int n = 1;
        if (empty_STRING == null || empty_STRING.length < n) {
            empty_STRING = LinkifyCompat.EMPTY_STRING;
        }
        final String[] array = new String[empty_STRING.length + n];
        array[0] = s.toLowerCase(Locale.ROOT);
        for (int i = 0; i < empty_STRING.length; ++i) {
            final String s2 = empty_STRING[i];
            final int n2 = i + 1;
            String lowerCase;
            if (s2 == null) {
                lowerCase = "";
            }
            else {
                lowerCase = s2.toLowerCase(Locale.ROOT);
            }
            array[n2] = lowerCase;
        }
        boolean b = false;
        final Matcher matcher = pattern.matcher((CharSequence)spannable);
        while (matcher.find()) {
            final int start = matcher.start();
            final int end = matcher.end();
            boolean acceptMatch = true;
            if (linkify$MatchFilter != null) {
                acceptMatch = linkify$MatchFilter.acceptMatch((CharSequence)spannable, start, end);
            }
            if (acceptMatch) {
                applyLink(makeUrl(matcher.group(0), array, matcher, linkify$TransformFilter), start, end, spannable);
                b = true;
            }
        }
        return b;
    }
    
    public static final boolean addLinks(final TextView textView, final int n) {
        if (n == 0) {
            return false;
        }
        final CharSequence text = textView.getText();
        final boolean b = text instanceof Spannable;
        final boolean b2 = true;
        if (b) {
            if (addLinks((Spannable)text, n)) {
                addLinkMovementMethod(textView);
                return b2;
            }
            return false;
        }
        else {
            final SpannableString value = SpannableString.valueOf(text);
            if (addLinks((Spannable)value, n)) {
                addLinkMovementMethod(textView);
                textView.setText((CharSequence)value);
                return b2;
            }
            return false;
        }
    }
    
    private static void applyLink(final String s, final int n, final int n2, final Spannable spannable) {
        spannable.setSpan((Object)new URLSpan(s), n, n2, 33);
    }
    
    private static void gatherLinks(final ArrayList list, final Spannable spannable, final Pattern pattern, final String[] array, final Linkify$MatchFilter linkify$MatchFilter, final Linkify$TransformFilter linkify$TransformFilter) {
        final Matcher matcher = pattern.matcher((CharSequence)spannable);
        while (matcher.find()) {
            final int start = matcher.start();
            final int end = matcher.end();
            if (linkify$MatchFilter != null && !linkify$MatchFilter.acceptMatch((CharSequence)spannable, start, end)) {
                continue;
            }
            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
            linkifyCompat$LinkSpec.url = makeUrl(matcher.group(0), array, matcher, linkify$TransformFilter);
            linkifyCompat$LinkSpec.start = start;
            linkifyCompat$LinkSpec.end = end;
            list.add(linkifyCompat$LinkSpec);
        }
    }
    
    private static final void gatherMapLinks(final ArrayList list, final Spannable spannable) {
        String s = spannable.toString();
        int n = 0;
        try {
            while (true) {
                final String address = WebView.findAddress(s);
                if (address == null) {
                    return;
                }
                final int index = s.indexOf(address);
                if (index < 0) {
                    return;
                }
                try {
                    final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
                    final int n2 = index + address.length();
                    linkifyCompat$LinkSpec.start = n + index;
                    linkifyCompat$LinkSpec.end = n + n2;
                    final String s2 = s;
                    try {
                        s = s2.substring(n2);
                        n += n2;
                        final String s3 = "UTF-8";
                        final String s4 = address;
                        try {
                            final String encode = URLEncoder.encode(s4, s3);
                            final StringBuilder sb = new(java.lang.StringBuilder.class);
                            final StringBuilder sb2 = sb;
                            new StringBuilder();
                            final String s5 = "geo:0,0?q=";
                            final StringBuilder sb3 = sb;
                            final String s6 = s5;
                            sb3.append(s6);
                            final StringBuilder sb4 = sb;
                            final String s7 = encode;
                            sb4.append(s7);
                            final StringBuilder sb5 = sb;
                            final String s8 = sb5.toString();
                            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2 = linkifyCompat$LinkSpec;
                            final String s9 = s8;
                            linkifyCompat$LinkSpec2.url = s9;
                            final ArrayList<LinkifyCompat$LinkSpec> list2 = (ArrayList<LinkifyCompat$LinkSpec>)list;
                            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec3 = linkifyCompat$LinkSpec;
                            list2.add(linkifyCompat$LinkSpec3);
                        }
                        catch (UnsupportedEncodingException ex) {}
                        continue;
                        try {
                            final StringBuilder sb;
                            final StringBuilder sb2 = sb;
                            new StringBuilder();
                            final String s5 = "geo:0,0?q=";
                            final StringBuilder sb3 = sb;
                            final String s6 = s5;
                            sb3.append(s6);
                            final StringBuilder sb4 = sb;
                            try {
                                final String encode;
                                final String s7 = encode;
                                sb4.append(s7);
                                final StringBuilder sb5 = sb;
                                final String s8 = sb5.toString();
                                final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2 = linkifyCompat$LinkSpec;
                                final String s9 = s8;
                                linkifyCompat$LinkSpec2.url = s9;
                                final ArrayList<LinkifyCompat$LinkSpec> list2 = (ArrayList<LinkifyCompat$LinkSpec>)list;
                                try {
                                    final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec3 = linkifyCompat$LinkSpec;
                                    list2.add(linkifyCompat$LinkSpec3);
                                    continue;
                                }
                                catch (UnsupportedOperationException ex2) {}
                            }
                            catch (UnsupportedOperationException ex3) {}
                        }
                        catch (UnsupportedOperationException ex4) {}
                    }
                    catch (UnsupportedOperationException ex5) {}
                }
                catch (UnsupportedOperationException ex6) {}
            }
        }
        catch (UnsupportedOperationException ex7) {}
    }
    
    private static String makeUrl(String s, final String[] array, final Matcher matcher, final Linkify$TransformFilter linkify$TransformFilter) {
        if (linkify$TransformFilter != null) {
            s = linkify$TransformFilter.transformUrl(matcher, s);
        }
        boolean b = false;
        int i = 0;
        while (i < array.length) {
            if (s.regionMatches(true, 0, array[i], 0, array[i].length())) {
                b = true;
                if (!s.regionMatches(false, 0, array[i], 0, array[i].length())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(array[i]);
                    sb.append(s.substring(array[i].length()));
                    s = sb.toString();
                    break;
                }
                break;
            }
            else {
                ++i;
            }
        }
        if (!b && array.length > 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(array[0]);
            sb2.append(s);
            s = sb2.toString();
        }
        return s;
    }
    
    private static final void pruneOverlaps(final ArrayList list, final Spannable spannable) {
        final URLSpan[] array = (URLSpan[])spannable.getSpans(0, spannable.length(), (Class)URLSpan.class);
        for (int i = 0; i < array.length; ++i) {
            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
            linkifyCompat$LinkSpec.frameworkAddedSpan = array[i];
            linkifyCompat$LinkSpec.start = spannable.getSpanStart((Object)array[i]);
            linkifyCompat$LinkSpec.end = spannable.getSpanEnd((Object)array[i]);
            list.add(linkifyCompat$LinkSpec);
        }
        Collections.sort((List<Object>)list, LinkifyCompat.COMPARATOR);
        int size = list.size();
        int j = 0;
        while (j < size - 1) {
            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2 = list.get(j);
            final LinkifyCompat$LinkSpec linkifyCompat$LinkSpec3 = list.get(j + 1);
            int n = -1;
            if (linkifyCompat$LinkSpec2.start <= linkifyCompat$LinkSpec3.start && linkifyCompat$LinkSpec2.end > linkifyCompat$LinkSpec3.start) {
                if (linkifyCompat$LinkSpec3.end <= linkifyCompat$LinkSpec2.end) {
                    n = j + 1;
                }
                else if (linkifyCompat$LinkSpec2.end - linkifyCompat$LinkSpec2.start > linkifyCompat$LinkSpec3.end - linkifyCompat$LinkSpec3.start) {
                    n = j + 1;
                }
                else if (linkifyCompat$LinkSpec2.end - linkifyCompat$LinkSpec2.start < linkifyCompat$LinkSpec3.end - linkifyCompat$LinkSpec3.start) {
                    n = j;
                }
                if (n != -1) {
                    final URLSpan frameworkAddedSpan = list.get(n).frameworkAddedSpan;
                    if (frameworkAddedSpan != null) {
                        spannable.removeSpan((Object)frameworkAddedSpan);
                    }
                    list.remove(n);
                    --size;
                    continue;
                }
            }
            ++j;
        }
    }
}
