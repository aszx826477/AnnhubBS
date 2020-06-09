// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.Arrays;

public final class Settings
{
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values;
    
    public Settings() {
        this.values = new int[10];
    }
    
    void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }
    
    int flags(final int n) {
        int n2 = 0;
        if (this.isPersisted(n)) {
            n2 = (0x0 | 0x2);
        }
        if (this.persistValue(n)) {
            n2 |= 0x1;
        }
        return n2;
    }
    
    int get(final int n) {
        return this.values[n];
    }
    
    int getClientCertificateVectorSize(final int n) {
        int n2;
        if ((this.set & 0x100) != 0x0) {
            n2 = this.values[8];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getCurrentCwnd(final int n) {
        int n2;
        if ((this.set & 0x20) != 0x0) {
            n2 = this.values[5];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getDownloadBandwidth(final int n) {
        int n2;
        if ((this.set & 0x4) != 0x0) {
            n2 = this.values[2];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getDownloadRetransRate(final int n) {
        int n2;
        if ((this.set & 0x40) != 0x0) {
            n2 = this.values[6];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    boolean getEnablePush(final boolean b) {
        final int n = this.set & 0x4;
        boolean b2 = false;
        final boolean b3 = true;
        int n2;
        if (n != 0) {
            n2 = this.values[2];
        }
        else if (b) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n2 == (b3 ? 1 : 0)) {
            b2 = true;
        }
        return b2;
    }
    
    int getHeaderTableSize() {
        int n;
        if ((this.set & 0x2) != 0x0) {
            n = this.values[1];
        }
        else {
            n = -1;
        }
        return n;
    }
    
    int getInitialWindowSize(final int n) {
        int n2;
        if ((this.set & 0x80) != 0x0) {
            n2 = this.values[7];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getMaxConcurrentStreams(final int n) {
        int n2;
        if ((this.set & 0x10) != 0x0) {
            n2 = this.values[4];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getMaxFrameSize(final int n) {
        int n2;
        if ((this.set & 0x20) != 0x0) {
            n2 = this.values[5];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getMaxHeaderListSize(final int n) {
        int n2;
        if ((this.set & 0x40) != 0x0) {
            n2 = this.values[6];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getRoundTripTime(final int n) {
        int n2;
        if ((this.set & 0x8) != 0x0) {
            n2 = this.values[3];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    int getUploadBandwidth(final int n) {
        int n2;
        if ((this.set & 0x2) != 0x0) {
            n2 = this.values[1];
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    boolean isFlowControlDisabled() {
        final int n = this.set & 0x400;
        boolean b = false;
        int n2;
        if (n != 0) {
            n2 = this.values[10];
        }
        else {
            n2 = 0;
        }
        if ((n2 & 0x1) != 0x0) {
            b = true;
        }
        return b;
    }
    
    boolean isPersisted(final int n) {
        int n2 = 1;
        if ((this.persisted & n2 << n) == 0x0) {
            n2 = 0;
        }
        return n2 != 0;
    }
    
    boolean isSet(final int n) {
        int n2 = 1;
        if ((this.set & n2 << n) == 0x0) {
            n2 = 0;
        }
        return n2 != 0;
    }
    
    void merge(final Settings settings) {
        for (int i = 0; i < 10; ++i) {
            if (settings.isSet(i)) {
                this.set(i, settings.flags(i), settings.get(i));
            }
        }
    }
    
    boolean persistValue(final int n) {
        int n2 = 1;
        if ((this.persistValue & n2 << n) == 0x0) {
            n2 = 0;
        }
        return n2 != 0;
    }
    
    Settings set(final int n, final int n2, final int n3) {
        if (n >= this.values.length) {
            return this;
        }
        final int n4 = 1 << n;
        this.set |= n4;
        if ((n2 & 0x1) != 0x0) {
            this.persistValue |= n4;
        }
        else {
            this.persistValue &= ~n4;
        }
        if ((n2 & 0x2) != 0x0) {
            this.persisted |= n4;
        }
        else {
            this.persisted &= ~n4;
        }
        this.values[n] = n3;
        return this;
    }
    
    int size() {
        return Integer.bitCount(this.set);
    }
}
