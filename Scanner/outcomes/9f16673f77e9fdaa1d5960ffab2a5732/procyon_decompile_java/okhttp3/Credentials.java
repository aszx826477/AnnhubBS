// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials
{
    public static String basic(final String s, final String s2) {
        try {
            try {
                final StringBuilder sb2;
                final StringBuilder sb = sb2 = new StringBuilder();
                try {
                    sb2.append(s);
                    sb.append(":");
                    final StringBuilder sb3 = sb;
                    try {
                        sb3.append(s2);
                        final byte[] bytes = sb.toString().getBytes("ISO-8859-1");
                        try {
                            final ByteString of = ByteString.of(bytes);
                            try {
                                final String base64 = of.base64();
                                try {
                                    try {
                                        final StringBuilder sb4 = new StringBuilder();
                                        sb4.append("Basic ");
                                        final StringBuilder sb5 = sb4;
                                        try {
                                            sb5.append(base64);
                                            return sb4.toString();
                                        }
                                        catch (UnsupportedEncodingException ex) {
                                            throw new AssertionError();
                                        }
                                    }
                                    catch (UnsupportedEncodingException ex2) {}
                                }
                                catch (UnsupportedEncodingException ex3) {}
                            }
                            catch (UnsupportedEncodingException ex4) {}
                        }
                        catch (UnsupportedEncodingException ex5) {}
                    }
                    catch (UnsupportedEncodingException ex6) {}
                }
                catch (UnsupportedEncodingException ex7) {}
            }
            catch (UnsupportedEncodingException ex8) {}
        }
        catch (UnsupportedEncodingException ex9) {}
    }
}
