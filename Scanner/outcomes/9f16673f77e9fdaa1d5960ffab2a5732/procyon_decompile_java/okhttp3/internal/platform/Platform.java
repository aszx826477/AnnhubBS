// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import javax.net.ssl.SSLSocketFactory;
import java.util.logging.Level;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocket;
import java.lang.reflect.Field;
import okio.Buffer;
import okhttp3.Protocol;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import java.util.logging.Logger;

public class Platform
{
    public static final int INFO = 4;
    private static final Platform PLATFORM;
    public static final int WARN = 5;
    private static final Logger logger;
    
    static {
        PLATFORM = findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }
    
    public static List alpnProtocolNames(final List list) {
        final ArrayList<String> list2 = new ArrayList<String>(list.size());
        for (int i = 0; i < list.size(); ++i) {
            final Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                list2.add(protocol.toString());
            }
        }
        return list2;
    }
    
    static byte[] concatLengthPrefixed(final List list) {
        final Buffer buffer = new Buffer();
        for (int i = 0; i < list.size(); ++i) {
            final Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }
    
    private static Platform findPlatform() {
        final Platform buildIfSupported = AndroidPlatform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        final Jdk9Platform buildIfSupported2 = Jdk9Platform.buildIfSupported();
        if (buildIfSupported2 != null) {
            return buildIfSupported2;
        }
        final Platform buildIfSupported3 = JdkWithJettyBootPlatform.buildIfSupported();
        if (buildIfSupported3 != null) {
            return buildIfSupported3;
        }
        return new Platform();
    }
    
    public static Platform get() {
        return Platform.PLATFORM;
    }
    
    static Object readFieldOrNull(final Object o, final Class clazz, final String s) {
        Class<?> clazz2 = o.getClass();
        while (clazz2 != Object.class) {
            final Class<Object> clazz3 = (Class<Object>)clazz2;
            try {
                final Field declaredField = clazz3.getDeclaredField(s);
                declaredField.setAccessible(true);
                final Field field = declaredField;
                try {
                    final Object value = field.get(o);
                    if (value != null && clazz.isInstance(value)) {
                        return clazz.cast(value);
                    }
                    return null;
                }
                catch (IllegalAccessException ex) {
                    throw new AssertionError();
                }
                catch (NoSuchFieldException ex2) {
                    clazz2 = clazz2.getSuperclass();
                }
            }
            catch (IllegalAccessException ex3) {}
            catch (NoSuchFieldException ex4) {}
            break;
        }
        if (!s.equals("delegate")) {
            final Object fieldOrNull = readFieldOrNull(o, Object.class, "delegate");
            if (fieldOrNull != null) {
                return readFieldOrNull(fieldOrNull, clazz, s);
            }
        }
        return null;
    }
    
    public void afterHandshake(final SSLSocket sslSocket) {
    }
    
    public CertificateChainCleaner buildCertificateChainCleaner(final X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(TrustRootIndex.get(x509TrustManager));
    }
    
    public void configureTlsExtensions(final SSLSocket sslSocket, final String s, final List list) {
    }
    
    public void connectSocket(final Socket socket, final InetSocketAddress inetSocketAddress, final int n) {
        socket.connect(inetSocketAddress, n);
    }
    
    public String getPrefix() {
        return "OkHttp";
    }
    
    public String getSelectedProtocol(final SSLSocket sslSocket) {
        return null;
    }
    
    public boolean isCleartextTrafficPermitted(final String s) {
        return true;
    }
    
    public void log(final int n, final String s, final Throwable t) {
        Level level;
        if (n == 5) {
            level = Level.WARNING;
        }
        else {
            level = Level.INFO;
        }
        Platform.logger.log(level, s, t);
    }
    
    public X509TrustManager trustManager(final SSLSocketFactory sslSocketFactory) {
        final String s = "sun.security.ssl.SSLContextImpl";
        try {
            final Object fieldOrNull = readFieldOrNull(sslSocketFactory, Class.forName(s), "context");
            if (fieldOrNull == null) {
                return null;
            }
            final Object fieldOrNull2 = readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
            try {
                return (X509TrustManager)fieldOrNull2;
            }
            catch (ClassNotFoundException ex) {
                return null;
            }
        }
        catch (ClassNotFoundException ex2) {}
    }
}
