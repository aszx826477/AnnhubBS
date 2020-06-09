// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import java.net.Socket;
import java.net.DatagramSocket;

class TrafficStatsCompat$BaseTrafficStatsCompatImpl implements TrafficStatsCompat$TrafficStatsCompatImpl
{
    private ThreadLocal mThreadSocketTags;
    
    TrafficStatsCompat$BaseTrafficStatsCompatImpl() {
        this.mThreadSocketTags = new TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(this);
    }
    
    public void clearThreadStatsTag() {
        this.mThreadSocketTags.get().statsTag = -1;
    }
    
    public int getThreadStatsTag() {
        return this.mThreadSocketTags.get().statsTag;
    }
    
    public void incrementOperationCount(final int n) {
    }
    
    public void incrementOperationCount(final int n, final int n2) {
    }
    
    public void setThreadStatsTag(final int statsTag) {
        this.mThreadSocketTags.get().statsTag = statsTag;
    }
    
    public void tagDatagramSocket(final DatagramSocket datagramSocket) {
    }
    
    public void tagSocket(final Socket socket) {
    }
    
    public void untagDatagramSocket(final DatagramSocket datagramSocket) {
    }
    
    public void untagSocket(final Socket socket) {
    }
}
