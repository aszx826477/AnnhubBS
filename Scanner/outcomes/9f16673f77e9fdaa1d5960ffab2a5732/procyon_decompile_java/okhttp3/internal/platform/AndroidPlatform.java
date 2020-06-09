// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import javax.net.ssl.SSLSocketFactory;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import okhttp3.internal.Util;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.security.cert.X509Certificate;
import okhttp3.internal.tls.CertificateChainCleaner;
import javax.net.ssl.X509TrustManager;

class AndroidPlatform extends Platform
{
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod getAlpnSelectedProtocol;
    private final OptionalMethod setAlpnProtocols;
    private final OptionalMethod setHostname;
    private final OptionalMethod setUseSessionTickets;
    private final Class sslParametersClass;
    
    public AndroidPlatform(final Class sslParametersClass, final OptionalMethod setUseSessionTickets, final OptionalMethod setHostname, final OptionalMethod getAlpnSelectedProtocol, final OptionalMethod setAlpnProtocols) {
        this.sslParametersClass = sslParametersClass;
        this.setUseSessionTickets = setUseSessionTickets;
        this.setHostname = setHostname;
        this.getAlpnSelectedProtocol = getAlpnSelectedProtocol;
        this.setAlpnProtocols = setAlpnProtocols;
    }
    
    public static Platform buildIfSupported() {
        final String s = "com.android.org.conscrypt.SSLParametersImpl";
        Label_0022: {
            String s2;
            try {
                final Class<?> clazz = Class.forName(s);
                break Label_0022;
            }
            catch (ClassNotFoundException ex) {
                final String s3;
                s2 = (s3 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                final Class<?> forName = Class.forName(s3);
                final Class<?> clazz;
                final Class<?> clazz2 = clazz = forName;
            }
            try {
                final String s3 = s2;
                final Class<?> clazz;
                final Class<?> forName = clazz = Class.forName(s3);
                final String s4 = "setUseSessionTickets";
                final int n = 1;
                final Class[] array = new Class[n];
                try {
                    array[0] = Boolean.TYPE;
                    final OptionalMethod optionalMethod = new OptionalMethod(null, s4, array);
                    final String s5 = "setHostname";
                    final Class[] array2 = new Class[n];
                    array2[0] = String.class;
                    final OptionalMethod optionalMethod2 = new OptionalMethod(null, s5, array2);
                    OptionalMethod optionalMethod3 = null;
                    final String s6 = "android.net.Network";
                    OptionalMethod optionalMethod5;
                    OptionalMethod optionalMethod6;
                    try {
                        Class.forName(s6);
                        optionalMethod3 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                        final String s7 = "setAlpnProtocols";
                        final Class[] array3 = new Class[n];
                        array3[0] = byte[].class;
                        final OptionalMethod optionalMethod4 = new OptionalMethod(null, s7, array3);
                        optionalMethod5 = optionalMethod3;
                        optionalMethod6 = optionalMethod4;
                    }
                    catch (ClassNotFoundException ex2) {
                        optionalMethod5 = optionalMethod3;
                        optionalMethod6 = null;
                    }
                    return new AndroidPlatform(clazz, optionalMethod, optionalMethod2, optionalMethod5, optionalMethod6);
                }
                catch (ClassNotFoundException ex3) {
                    return null;
                }
            }
            catch (ClassNotFoundException ex4) {}
        }
    }
    
    public CertificateChainCleaner buildCertificateChainCleaner(final X509TrustManager x509TrustManager) {
        final String s = "android.net.http.X509TrustManagerExtensions";
        try {
            final Class<?> forName = Class.forName(s);
            final int n = 1;
            final Class[] array = new Class[n];
            array[0] = X509TrustManager.class;
            final Class<?> clazz = forName;
            try {
                final Constructor<?> constructor = clazz.getConstructor((Class<?>[])array);
                try {
                    final Object[] array2 = new Object[n];
                    array2[0] = x509TrustManager;
                    final Constructor<?> constructor2 = constructor;
                    try {
                        final Object instance = constructor2.newInstance(array2);
                        final String s2 = "checkServerTrusted";
                        final Class[] array3 = { X509Certificate[].class, null, null };
                        array3[2] = (array3[n] = String.class);
                        final Method method = forName.getMethod(s2, (Class<?>[])array3);
                        try {
                            return new AndroidPlatform$AndroidCertificateChainCleaner(instance, method);
                        }
                        catch (Exception ex) {
                            return super.buildCertificateChainCleaner(x509TrustManager);
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
    }
    
    public void configureTlsExtensions(final SSLSocket sslSocket, final String s, final List list) {
        final int n = 1;
        if (s != null) {
            final OptionalMethod setUseSessionTickets = this.setUseSessionTickets;
            final Object[] array = new Object[n];
            array[0] = (n != 0);
            setUseSessionTickets.invokeOptionalWithoutCheckedException(sslSocket, array);
            final OptionalMethod setHostname = this.setHostname;
            final Object[] array2 = new Object[n];
            array2[0] = s;
            setHostname.invokeOptionalWithoutCheckedException(sslSocket, array2);
        }
        final OptionalMethod setAlpnProtocols = this.setAlpnProtocols;
        if (setAlpnProtocols != null && setAlpnProtocols.isSupported(sslSocket)) {
            final Object[] array3 = new Object[n];
            array3[0] = Platform.concatLengthPrefixed(list);
            this.setAlpnProtocols.invokeWithoutCheckedException(sslSocket, array3);
        }
    }
    
    public void connectSocket(final Socket socket, final InetSocketAddress inetSocketAddress, final int n) {
        try {
            socket.connect(inetSocketAddress, n);
        }
        catch (SecurityException ex2) {
            final IOException ex = new IOException("Exception in connect");
            ex.initCause(ex2);
            throw ex;
        }
        catch (AssertionError assertionError) {
            if (Util.isAndroidGetsocknameError(assertionError)) {
                throw new IOException(assertionError);
            }
            throw assertionError;
        }
    }
    
    public String getSelectedProtocol(final SSLSocket sslSocket) {
        final OptionalMethod getAlpnSelectedProtocol = this.getAlpnSelectedProtocol;
        String s = null;
        if (getAlpnSelectedProtocol == null) {
            return null;
        }
        if (!getAlpnSelectedProtocol.isSupported(sslSocket)) {
            return null;
        }
        final byte[] array = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sslSocket, new Object[0]);
        if (array != null) {
            s = new String(array, Util.UTF_8);
        }
        return s;
    }
    
    public boolean isCleartextTrafficPermitted(final String s) {
        final String s2 = "android.security.NetworkSecurityPolicy";
        try {
            final Class<?> forName = Class.forName(s2);
            final Object invoke = forName.getMethod("getInstance", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            final String s3 = "isCleartextTrafficPermitted";
            final int n = 1;
            final Class[] array = new Class[n];
            array[0] = String.class;
            final Method method = forName.getMethod(s3, (Class<?>[])array);
            try {
                final Object[] array2 = new Object[n];
                array2[0] = s;
                final Object invoke2 = method.invoke(invoke, array2);
                try {
                    final Boolean b = (Boolean)invoke2;
                    try {
                        return b;
                    }
                    catch (InvocationTargetException ex) {}
                    catch (IllegalArgumentException ex2) {}
                    catch (IllegalAccessException ex3) {}
                    catch (NoSuchMethodException ex4) {}
                    catch (ClassNotFoundException ex5) {}
                }
                catch (InvocationTargetException ex6) {}
                catch (IllegalArgumentException ex7) {}
                catch (IllegalAccessException ex8) {}
                catch (NoSuchMethodException ex9) {}
                catch (ClassNotFoundException ex10) {}
            }
            catch (InvocationTargetException ex11) {}
            catch (IllegalArgumentException ex12) {}
            catch (IllegalAccessException ex13) {}
            catch (NoSuchMethodException ex14) {}
            catch (ClassNotFoundException ex15) {}
        }
        catch (InvocationTargetException ex16) {}
        catch (IllegalArgumentException ex17) {}
        catch (IllegalAccessException ex18) {}
        catch (NoSuchMethodException ex19) {}
        catch (ClassNotFoundException ex20) {}
        return super.isCleartextTrafficPermitted(s);
    }
    
    public void log(final int n, String string, final Throwable t) {
        int n2 = 5;
        if (n != n2) {
            n2 = 3;
        }
        final char c = '\n';
        if (t != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(c);
            sb.append(Log.getStackTraceString(t));
            string = sb.toString();
        }
        int min;
        for (int i = 0, length = string.length(); i < length; i = min + 1) {
            final int index = string.indexOf(c, i);
            int n3;
            if (index != -1) {
                n3 = index;
            }
            else {
                n3 = length;
            }
            final int n4 = n3;
            do {
                min = Math.min(n4, i + 4000);
                Log.println(n2, "OkHttp", string.substring(i, min));
                i = min;
            } while (min < n4);
        }
    }
    
    public X509TrustManager trustManager(final SSLSocketFactory sslSocketFactory) {
        Object o = Platform.readFieldOrNull(sslSocketFactory, this.sslParametersClass, "sslParameters");
        if (o == null) {
            final String s = "com.google.android.gms.org.conscrypt.SSLParametersImpl";
            try {
                final Class<? extends SSLSocketFactory> class1 = sslSocketFactory.getClass();
                try {
                    o = Platform.readFieldOrNull(sslSocketFactory, Class.forName(s, false, class1.getClassLoader()), "sslParameters");
                }
                catch (ClassNotFoundException ex) {
                    return super.trustManager(sslSocketFactory);
                }
            }
            catch (ClassNotFoundException ex2) {}
        }
        final X509TrustManager x509TrustManager = (X509TrustManager)Platform.readFieldOrNull(o, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager)Platform.readFieldOrNull(o, X509TrustManager.class, "trustManager");
    }
}
