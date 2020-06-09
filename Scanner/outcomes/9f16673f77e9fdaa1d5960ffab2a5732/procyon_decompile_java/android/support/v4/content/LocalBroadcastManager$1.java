// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import java.util.Set;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import java.util.ArrayList;
import android.content.Context;
import java.util.HashMap;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

class LocalBroadcastManager$1 extends Handler
{
    final /* synthetic */ LocalBroadcastManager this$0;
    
    LocalBroadcastManager$1(final LocalBroadcastManager this$0, final Looper looper) {
        this.this$0 = this$0;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        }
        else {
            this.this$0.executePendingBroadcasts();
        }
    }
}
