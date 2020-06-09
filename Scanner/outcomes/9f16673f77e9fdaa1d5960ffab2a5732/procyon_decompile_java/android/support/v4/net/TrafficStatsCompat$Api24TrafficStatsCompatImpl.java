// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import java.net.DatagramSocket;

class TrafficStatsCompat$Api24TrafficStatsCompatImpl extends TrafficStatsCompat$IcsTrafficStatsCompatImpl
{
    public void tagDatagramSocket(final DatagramSocket datagramSocket) {
        TrafficStatsCompatApi24.tagDatagramSocket(datagramSocket);
    }
    
    public void untagDatagramSocket(final DatagramSocket datagramSocket) {
        TrafficStatsCompatApi24.untagDatagramSocket(datagramSocket);
    }
}
