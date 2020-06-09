// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import java.net.Socket;
import java.net.DatagramSocket;

class TrafficStatsCompat$IcsTrafficStatsCompatImpl implements TrafficStatsCompat$TrafficStatsCompatImpl
{
    public void clearThreadStatsTag() {
        TrafficStatsCompatIcs.clearThreadStatsTag();
    }
    
    public int getThreadStatsTag() {
        return TrafficStatsCompatIcs.getThreadStatsTag();
    }
    
    public void incrementOperationCount(final int n) {
        TrafficStatsCompatIcs.incrementOperationCount(n);
    }
    
    public void incrementOperationCount(final int n, final int n2) {
        TrafficStatsCompatIcs.incrementOperationCount(n, n2);
    }
    
    public void setThreadStatsTag(final int threadStatsTag) {
        TrafficStatsCompatIcs.setThreadStatsTag(threadStatsTag);
    }
    
    public void tagDatagramSocket(final DatagramSocket datagramSocket) {
        TrafficStatsCompatIcs.tagDatagramSocket(datagramSocket);
    }
    
    public void tagSocket(final Socket socket) {
        TrafficStatsCompatIcs.tagSocket(socket);
    }
    
    public void untagDatagramSocket(final DatagramSocket datagramSocket) {
        TrafficStatsCompatIcs.untagDatagramSocket(datagramSocket);
    }
    
    public void untagSocket(final Socket socket) {
        TrafficStatsCompatIcs.untagSocket(socket);
    }
}
