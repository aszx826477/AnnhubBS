// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.os.PowerManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.os.PowerManager$WakeLock;
import android.content.Intent;
import android.util.SparseArray;
import android.content.BroadcastReceiver;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver
{
    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
    private static final SparseArray mActiveWakeLocks;
    private static int mNextId;
    
    static {
        mActiveWakeLocks = new SparseArray();
        WakefulBroadcastReceiver.mNextId = 1;
    }
    
    public static boolean completeWakefulIntent(final Intent intent) {
        final int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (WakefulBroadcastReceiver.mActiveWakeLocks) {
            final PowerManager$WakeLock powerManager$WakeLock = (PowerManager$WakeLock)WakefulBroadcastReceiver.mActiveWakeLocks.get(intExtra);
            final boolean b = true;
            if (powerManager$WakeLock != null) {
                powerManager$WakeLock.release();
                WakefulBroadcastReceiver.mActiveWakeLocks.remove(intExtra);
                return b;
            }
            final String s = "WakefulBroadcastReceiver";
            final StringBuilder sb = new StringBuilder();
            sb.append("No active wake lock id #");
            sb.append(intExtra);
            Log.w(s, sb.toString());
            return b;
        }
    }
    
    public static ComponentName startWakefulService(final Context context, final Intent intent) {
        synchronized (WakefulBroadcastReceiver.mActiveWakeLocks) {
            final int mNextId = WakefulBroadcastReceiver.mNextId;
            final int mNextId2 = WakefulBroadcastReceiver.mNextId;
            final int mNextId3 = 1;
            WakefulBroadcastReceiver.mNextId = mNextId2 + mNextId3;
            if (WakefulBroadcastReceiver.mNextId <= 0) {
                WakefulBroadcastReceiver.mNextId = mNextId3;
            }
            intent.putExtra("android.support.content.wakelockid", mNextId);
            final ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            final PowerManager powerManager = (PowerManager)context.getSystemService("power");
            final StringBuilder sb = new StringBuilder();
            sb.append("wake:");
            sb.append(startService.flattenToShortString());
            final PowerManager$WakeLock wakeLock = powerManager.newWakeLock(mNextId3, sb.toString());
            wakeLock.setReferenceCounted(false);
            wakeLock.acquire(60000L);
            WakefulBroadcastReceiver.mActiveWakeLocks.put(mNextId, (Object)wakeLock);
            return startService;
        }
    }
}
