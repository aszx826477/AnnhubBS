// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class LocalBroadcastManager$ReceiverRecord
{
    boolean broadcasting;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    LocalBroadcastManager$ReceiverRecord(final IntentFilter filter, final BroadcastReceiver receiver) {
        this.filter = filter;
        this.receiver = receiver;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.receiver);
        sb.append(" filter=");
        sb.append(this.filter);
        sb.append("}");
        return sb.toString();
    }
}
