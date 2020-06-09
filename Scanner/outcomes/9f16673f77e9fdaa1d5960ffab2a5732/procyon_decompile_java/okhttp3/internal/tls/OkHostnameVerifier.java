// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import java.security.cert.Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;
import java.util.Locale;
import java.util.Iterator;
import java.security.cert.CertificateParsingException;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;

public final class OkHostnameVerifier implements HostnameVerifier
{
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE;
    
    static {
        INSTANCE = new OkHostnameVerifier();
    }
    
    public static List allSubjectAltNames(final X509Certificate x509Certificate) {
        final List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        final List subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
        final ArrayList list = new ArrayList(subjectAltNames.size() + subjectAltNames2.size());
        list.addAll(subjectAltNames);
        list.addAll(subjectAltNames2);
        return list;
    }
    
    private static List getSubjectAltNames(final X509Certificate x509Certificate, final int n) {
        final ArrayList<String> list = new ArrayList<String>();
        try {
            final Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            final Iterator<List<Object>> iterator = subjectAlternativeNames.iterator();
            try {
                while (true) {
                    if (!iterator.hasNext()) {
                        return list;
                    }
                    final List<Object> list2 = iterator.next();
                    Label_0178: {
                        if (list2 == null) {
                            break Label_0178;
                        }
                        if (list2.size() < 2) {
                            continue;
                        }
                        final Object value = list2.get(0);
                        try {
                            final Integer n2 = (Integer)value;
                            if (n2 == null) {
                                continue;
                            }
                            Label_0175: {
                                if (n2 != n) {
                                    break Label_0175;
                                }
                                final Object value2 = list2.get(1);
                                try {
                                    final String s = (String)value2;
                                    if (s == null) {
                                        continue;
                                    }
                                    list.add(s);
                                    continue;
                                }
                                catch (CertificateParsingException ex) {
                                    return Collections.emptyList();
                                }
                            }
                        }
                        catch (CertificateParsingException ex2) {}
                    }
                }
            }
            catch (CertificateParsingException ex3) {}
        }
        catch (CertificateParsingException ex4) {}
    }
    
    private boolean verifyHostname(String string, String s) {
        if (string == null || string.length() == 0 || string.startsWith(".") || string.endsWith("..")) {
            return false;
        }
        if (s == null || s.length() == 0 || s.startsWith(".") || s.endsWith("..")) {
            return false;
        }
        final boolean endsWith = string.endsWith(".");
        final char c = '.';
        if (!endsWith) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(c);
            string = sb.toString();
        }
        if (!s.endsWith(".")) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(c);
            s = sb2.toString();
        }
        s = s.toLowerCase(Locale.US);
        if (!s.contains("*")) {
            return string.equals(s);
        }
        if (s.startsWith("*.")) {
            final int n = 1;
            final int index = s.indexOf(42, n);
            final int n2 = -1;
            if (index == n2) {
                if (string.length() < s.length()) {
                    return false;
                }
                if ("*.".equals(s)) {
                    return false;
                }
                final String substring = s.substring(n);
                if (!string.endsWith(substring)) {
                    return false;
                }
                final int n3 = string.length() - substring.length();
                return (n3 <= 0 || string.lastIndexOf(c, n3 - 1) == n2) && n;
            }
        }
        return false;
    }
    
    private boolean verifyHostname(String lowerCase, final X509Certificate x509Certificate) {
        lowerCase = lowerCase.toLowerCase(Locale.US);
        boolean b = false;
        final List subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        for (int i = 0; i < subjectAltNames.size(); ++i) {
            b = true;
            if (this.verifyHostname(lowerCase, subjectAltNames.get(i))) {
                return true;
            }
        }
        if (!b) {
            final String mostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
            if (mostSpecific != null) {
                return this.verifyHostname(lowerCase, mostSpecific);
            }
        }
        return false;
    }
    
    private boolean verifyIpAddress(final String s, final X509Certificate x509Certificate) {
        final List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        for (int i = 0; i < subjectAltNames.size(); ++i) {
            if (s.equalsIgnoreCase(subjectAltNames.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verify(final String s, final X509Certificate x509Certificate) {
        boolean b;
        if (Util.verifyAsIpAddress(s)) {
            b = this.verifyIpAddress(s, x509Certificate);
        }
        else {
            b = this.verifyHostname(s, x509Certificate);
        }
        return b;
    }
    
    public boolean verify(final String s, final SSLSession sslSession) {
        try {
            final Certificate certificate = sslSession.getPeerCertificates()[0];
            try {
                return this.verify(s, (X509Certificate)certificate);
            }
            catch (SSLException ex) {
                return false;
            }
        }
        catch (SSLException ex2) {}
    }
}
