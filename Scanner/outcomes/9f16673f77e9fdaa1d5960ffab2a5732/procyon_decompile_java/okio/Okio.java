// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.net.Socket;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.logging.Logger;

public final class Okio
{
    static final Logger logger;
    
    static {
        logger = Logger.getLogger(Okio.class.getName());
    }
    
    public static Sink appendingSink(final File file) {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }
    
    public static BufferedSink buffer(final Sink sink) {
        return new RealBufferedSink(sink);
    }
    
    public static BufferedSource buffer(final Source source) {
        return new RealBufferedSource(source);
    }
    
    static boolean isAndroidGetsocknameError(final AssertionError assertionError) {
        return assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains("getsockname failed");
    }
    
    public static Sink sink(final File file) {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
    
    public static Sink sink(final OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }
    
    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Okio$1(timeout, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }
    
    public static Sink sink(final Socket socket) {
        if (socket != null) {
            final AsyncTimeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }
    
    public static Sink sink(final Path path, final OpenOption... array) {
        if (path != null) {
            return sink(Files.newOutputStream(path, array));
        }
        throw new IllegalArgumentException("path == null");
    }
    
    public static Source source(final File file) {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
    
    public static Source source(final InputStream inputStream) {
        return source(inputStream, new Timeout());
    }
    
    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Okio$2(timeout, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }
    
    public static Source source(final Socket socket) {
        if (socket != null) {
            final AsyncTimeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }
    
    public static Source source(final Path path, final OpenOption... array) {
        if (path != null) {
            return source(Files.newInputStream(path, array));
        }
        throw new IllegalArgumentException("path == null");
    }
    
    private static AsyncTimeout timeout(final Socket socket) {
        return new Okio$3(socket);
    }
}
