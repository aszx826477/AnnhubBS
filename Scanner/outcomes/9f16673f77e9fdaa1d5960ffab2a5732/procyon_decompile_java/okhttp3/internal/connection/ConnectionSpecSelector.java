// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import okhttp3.internal.Internal;
import okhttp3.ConnectionSpec;
import javax.net.ssl.SSLSocket;
import java.util.List;

public final class ConnectionSpecSelector
{
    private final List connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;
    
    public ConnectionSpecSelector(final List connectionSpecs) {
        this.nextModeIndex = 0;
        this.connectionSpecs = connectionSpecs;
    }
    
    private boolean isFallbackPossible(final SSLSocket sslSocket) {
        for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); ++i) {
            if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(sslSocket)) {
                return true;
            }
        }
        return false;
    }
    
    public ConnectionSpec configureSecureSocket(final SSLSocket sslSocket) {
        ConnectionSpec connectionSpec = null;
        for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); ++i) {
            final ConnectionSpec connectionSpec2 = this.connectionSpecs.get(i);
            if (connectionSpec2.isCompatible(sslSocket)) {
                connectionSpec = connectionSpec2;
                this.nextModeIndex = i + 1;
                break;
            }
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = this.isFallbackPossible(sslSocket);
            Internal.instance.apply(connectionSpec, sslSocket, this.isFallback);
            return connectionSpec;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(", modes=");
        sb.append(this.connectionSpecs);
        sb.append(", supported protocols=");
        sb.append(Arrays.toString(sslSocket.getEnabledProtocols()));
        throw new UnknownServiceException(sb.toString());
    }
    
    public boolean connectionFailed(final IOException ex) {
        boolean isFallback = true;
        this.isFallback = isFallback;
        if (!this.isFallbackPossible) {
            return false;
        }
        if (ex instanceof ProtocolException) {
            return false;
        }
        if (ex instanceof InterruptedIOException) {
            return false;
        }
        if (ex instanceof SSLHandshakeException && ex.getCause() instanceof CertificateException) {
            return false;
        }
        if (ex instanceof SSLPeerUnverifiedException) {
            return false;
        }
        if (!(ex instanceof SSLHandshakeException)) {
            if (!(ex instanceof SSLProtocolException)) {
                isFallback = false;
            }
        }
        return isFallback;
    }
}
