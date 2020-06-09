// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import java.util.ArrayList;
import android.content.Intent;

class LocalBroadcastManager$BroadcastRecord
{
    final Intent intent;
    final ArrayList receivers;
    
    LocalBroadcastManager$BroadcastRecord(final Intent intent, final ArrayList receivers) {
        this.intent = intent;
        this.receivers = receivers;
    }
}
