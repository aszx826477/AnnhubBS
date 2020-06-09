// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import java.io.OutputStream;
import java.io.InputStream;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.SocketImpl;

class DatagramSocketWrapper$DatagramSocketImplWrapper extends SocketImpl
{
    public DatagramSocketWrapper$DatagramSocketImplWrapper(final DatagramSocket datagramSocket, final FileDescriptor fd) {
        this.localport = datagramSocket.getLocalPort();
        this.fd = fd;
    }
    
    protected void accept(final SocketImpl socketImpl) {
        throw new UnsupportedOperationException();
    }
    
    protected int available() {
        throw new UnsupportedOperationException();
    }
    
    protected void bind(final InetAddress inetAddress, final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected void close() {
        throw new UnsupportedOperationException();
    }
    
    protected void connect(final String s, final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected void connect(final InetAddress inetAddress, final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected void connect(final SocketAddress socketAddress, final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected void create(final boolean b) {
        throw new UnsupportedOperationException();
    }
    
    protected InputStream getInputStream() {
        throw new UnsupportedOperationException();
    }
    
    public Object getOption(final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected OutputStream getOutputStream() {
        throw new UnsupportedOperationException();
    }
    
    protected void listen(final int n) {
        throw new UnsupportedOperationException();
    }
    
    protected void sendUrgentData(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public void setOption(final int n, final Object o) {
        throw new UnsupportedOperationException();
    }
}
