// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import java.net.SocketImpl;
import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;

class DatagramSocketWrapper extends Socket
{
    public DatagramSocketWrapper(final DatagramSocket datagramSocket, final FileDescriptor fileDescriptor) {
        super(new DatagramSocketWrapper$DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}
