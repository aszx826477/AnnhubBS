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
import android.os.Handler;
import android.content.Context;
import java.util.HashMap;

public final class LocalBroadcastManager
{
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList mPendingBroadcasts;
    private final HashMap mReceivers;
    
    static {
        mLock = new Object();
    }
    
    private LocalBroadcastManager(final Context mAppContext) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = mAppContext;
        this.mHandler = new LocalBroadcastManager$1(this, mAppContext.getMainLooper());
    }
    
    private void executePendingBroadcasts() {
        while (true) {
            synchronized (this.mReceivers) {
                final int size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                final LocalBroadcastManager$BroadcastRecord[] array = new LocalBroadcastManager$BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(array);
                this.mPendingBroadcasts.clear();
                // monitorexit(this.mReceivers)
                for (int i = 0; i < array.length; ++i) {
                    final LocalBroadcastManager$BroadcastRecord localBroadcastManager$BroadcastRecord = array[i];
                    for (int j = 0; j < localBroadcastManager$BroadcastRecord.receivers.size(); ++j) {
                        ((LocalBroadcastManager$ReceiverRecord)localBroadcastManager$BroadcastRecord.receivers.get(j)).receiver.onReceive(this.mAppContext, localBroadcastManager$BroadcastRecord.intent);
                    }
                }
            }
        }
    }
    
    public static LocalBroadcastManager getInstance(final Context context) {
        synchronized (LocalBroadcastManager.mLock) {
            if (LocalBroadcastManager.mInstance == null) {
                LocalBroadcastManager.mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return LocalBroadcastManager.mInstance;
        }
    }
    
    public void registerReceiver(final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            final LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = new LocalBroadcastManager$ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<?> list = this.mReceivers.get(broadcastReceiver);
            final boolean b = true;
            if (list == null) {
                list = new ArrayList<IntentFilter>(b ? 1 : 0);
                this.mReceivers.put(broadcastReceiver, list);
            }
            list.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); ++i) {
                final String action = intentFilter.getAction(i);
                ArrayList<?> list2 = this.mActions.get(action);
                if (list2 == null) {
                    list2 = new ArrayList<Object>(b ? 1 : 0);
                    this.mActions.put(action, list2);
                }
                list2.add(localBroadcastManager$ReceiverRecord);
            }
        }
    }
    
    public boolean sendBroadcast(final Intent intent) {
        synchronized (this.mReceivers) {
            final String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            final Uri data = intent.getData();
            final String scheme = intent.getScheme();
            final Set categories = intent.getCategories();
            final boolean b;
            if (b = ((intent.getFlags() & 0x8) != 0x0)) {
                final String s = "LocalBroadcastManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Resolving type ");
                sb.append(resolveTypeIfNeeded);
                sb.append(" scheme ");
                sb.append(scheme);
                sb.append(" of intent ");
                sb.append(intent);
                Log.v(s, sb.toString());
            }
            final ArrayList<Object> list;
            if ((list = this.mActions.get(intent.getAction())) != null) {
                if (b) {
                    final String s2 = "LocalBroadcastManager";
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Action list: ");
                    sb2.append(list);
                    Log.v(s2, sb2.toString());
                }
                ArrayList<LocalBroadcastManager$ReceiverRecord> list2 = null;
                String s4;
                int n;
                for (int i = 0; i < list.size(); i = n + 1, resolveTypeIfNeeded = s4) {
                    final LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = list.get(i);
                    if (b) {
                        final String s3 = "LocalBroadcastManager";
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Matching against filter ");
                        sb3.append(localBroadcastManager$ReceiverRecord.filter);
                        Log.v(s3, sb3.toString());
                    }
                    ArrayList<LocalBroadcastManager$ReceiverRecord> list3;
                    if (localBroadcastManager$ReceiverRecord.broadcasting) {
                        if (b) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            s4 = resolveTypeIfNeeded;
                            list3 = list2;
                            n = i;
                        }
                        else {
                            s4 = resolveTypeIfNeeded;
                            list3 = list2;
                            n = i;
                        }
                    }
                    else {
                        final IntentFilter filter = localBroadcastManager$ReceiverRecord.filter;
                        final String s5 = "LocalBroadcastManager";
                        final LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord2 = localBroadcastManager$ReceiverRecord;
                        final String s6 = resolveTypeIfNeeded;
                        s4 = resolveTypeIfNeeded;
                        list3 = list2;
                        n = i;
                        final int match = filter.match(action, s6, scheme, data, categories, s5);
                        if (match >= 0) {
                            if (b) {
                                final String s7 = "LocalBroadcastManager";
                                final StringBuilder sb4 = new StringBuilder();
                                sb4.append("  Filter matched!  match=0x");
                                sb4.append(Integer.toHexString(match));
                                Log.v(s7, sb4.toString());
                            }
                            if (list3 == null) {
                                list3 = new ArrayList<LocalBroadcastManager$ReceiverRecord>();
                            }
                            list3.add(localBroadcastManager$ReceiverRecord2);
                            localBroadcastManager$ReceiverRecord2.broadcasting = true;
                            list2 = list3;
                            continue;
                        }
                        if (b) {
                            String s8 = null;
                            switch (match) {
                                default: {
                                    s8 = "unknown reason";
                                    break;
                                }
                                case -1: {
                                    s8 = "type";
                                    break;
                                }
                                case -2: {
                                    s8 = "data";
                                    break;
                                }
                                case -3: {
                                    s8 = "action";
                                    break;
                                }
                                case -4: {
                                    s8 = "category";
                                    break;
                                }
                            }
                            final String s9 = "LocalBroadcastManager";
                            final StringBuilder sb5 = new StringBuilder();
                            sb5.append("  Filter did not match: ");
                            sb5.append(s8);
                            Log.v(s9, sb5.toString());
                        }
                    }
                    list2 = list3;
                }
                final ArrayList<LocalBroadcastManager$ReceiverRecord> list4;
                if ((list4 = list2) != null) {
                    for (int j = 0; j < list4.size(); ++j) {
                        list4.get(j).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new LocalBroadcastManager$BroadcastRecord(intent, list4));
                    final Handler mHandler = this.mHandler;
                    final int n2 = 1;
                    if (!mHandler.hasMessages(n2)) {
                        this.mHandler.sendEmptyMessage(n2);
                    }
                    return true;
                }
            }
            return false;
        }
    }
    
    public void sendBroadcastSync(final Intent intent) {
        if (this.sendBroadcast(intent)) {
            this.executePendingBroadcasts();
        }
    }
    
    public void unregisterReceiver(final BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            final ArrayList<Object> list = this.mReceivers.remove(broadcastReceiver);
            if (list == null) {
                return;
            }
            for (int i = 0; i < list.size(); ++i) {
                final IntentFilter intentFilter = list.get(i);
                for (int j = 0; j < intentFilter.countActions(); ++j) {
                    final String action = intentFilter.getAction(j);
                    final ArrayList<Object> list2 = this.mActions.get(action);
                    if (list2 != null) {
                        for (int k = 0; k < list2.size(); ++k) {
                            if (list2.get(k).receiver == broadcastReceiver) {
                                list2.remove(k);
                                --k;
                            }
                        }
                        if (list2.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
