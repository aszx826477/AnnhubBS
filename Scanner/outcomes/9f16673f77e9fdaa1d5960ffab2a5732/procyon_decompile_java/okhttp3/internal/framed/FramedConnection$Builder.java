// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Okio;
import java.net.InetSocketAddress;
import okio.BufferedSource;
import java.net.Socket;
import okio.BufferedSink;
import okhttp3.Protocol;

public class FramedConnection$Builder
{
    private boolean client;
    private String hostname;
    private FramedConnection$Listener listener;
    private Protocol protocol;
    private PushObserver pushObserver;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    
    public FramedConnection$Builder(final boolean client) {
        this.listener = FramedConnection$Listener.REFUSE_INCOMING_STREAMS;
        this.protocol = Protocol.SPDY_3;
        this.pushObserver = PushObserver.CANCEL;
        this.client = client;
    }
    
    public FramedConnection build() {
        return new FramedConnection(this, null);
    }
    
    public FramedConnection$Builder listener(final FramedConnection$Listener listener) {
        this.listener = listener;
        return this;
    }
    
    public FramedConnection$Builder protocol(final Protocol protocol) {
        this.protocol = protocol;
        return this;
    }
    
    public FramedConnection$Builder pushObserver(final PushObserver pushObserver) {
        this.pushObserver = pushObserver;
        return this;
    }
    
    public FramedConnection$Builder socket(final Socket socket) {
        return this.socket(socket, ((InetSocketAddress)socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
    }
    
    public FramedConnection$Builder socket(final Socket socket, final String hostname, final BufferedSource source, final BufferedSink sink) {
        this.socket = socket;
        this.hostname = hostname;
        this.source = source;
        this.sink = sink;
        return this;
    }
}
