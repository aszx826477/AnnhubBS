// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Message;
import java.util.List;
import android.content.pm.ResolveInfo;
import java.util.LinkedList;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.IBinder;
import android.content.ComponentName;
import java.util.Iterator;
import android.util.Log;
import android.content.Intent;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import android.os.HandlerThread;
import android.os.Handler;
import android.content.Context;
import java.util.Set;
import android.content.ServiceConnection;
import android.os.Handler$Callback;

class NotificationManagerCompat$SideChannelManager implements Handler$Callback, ServiceConnection
{
    private static final String KEY_BINDER = "binder";
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private Set mCachedEnabledPackages;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map mRecordMap;
    
    public NotificationManagerCompat$SideChannelManager(final Context mContext) {
        this.mRecordMap = new HashMap();
        this.mCachedEnabledPackages = new HashSet();
        this.mContext = mContext;
        (this.mHandlerThread = new HandlerThread("NotificationManagerCompat")).start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), (Handler$Callback)this);
    }
    
    private boolean ensureServiceBound(final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        if (notificationManagerCompat$SideChannelManager$ListenerRecord.bound) {
            return true;
        }
        notificationManagerCompat$SideChannelManager$ListenerRecord.bound = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName), (ServiceConnection)this, NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS);
        if (notificationManagerCompat$SideChannelManager$ListenerRecord.bound) {
            notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount = 0;
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to bind to listener ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName);
            Log.w("NotifManCompat", sb.toString());
            this.mContext.unbindService((ServiceConnection)this);
        }
        return notificationManagerCompat$SideChannelManager$ListenerRecord.bound;
    }
    
    private void ensureServiceUnbound(final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        if (notificationManagerCompat$SideChannelManager$ListenerRecord.bound) {
            this.mContext.unbindService((ServiceConnection)this);
            notificationManagerCompat$SideChannelManager$ListenerRecord.bound = false;
        }
        notificationManagerCompat$SideChannelManager$ListenerRecord.service = null;
    }
    
    private void handleQueueTask(final NotificationManagerCompat$Task notificationManagerCompat$Task) {
        this.updateListenerMap();
        for (final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord : this.mRecordMap.values()) {
            notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.add(notificationManagerCompat$Task);
            this.processListenerQueue(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }
    
    private void handleRetryListenerQueue(final ComponentName componentName) {
        final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord = this.mRecordMap.get(componentName);
        if (notificationManagerCompat$SideChannelManager$ListenerRecord != null) {
            this.processListenerQueue(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }
    
    private void handleServiceConnected(final ComponentName componentName, final IBinder binder) {
        final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord = this.mRecordMap.get(componentName);
        if (notificationManagerCompat$SideChannelManager$ListenerRecord != null) {
            notificationManagerCompat$SideChannelManager$ListenerRecord.service = INotificationSideChannel$Stub.asInterface(binder);
            notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount = 0;
            this.processListenerQueue(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }
    
    private void handleServiceDisconnected(final ComponentName componentName) {
        final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord = this.mRecordMap.get(componentName);
        if (notificationManagerCompat$SideChannelManager$ListenerRecord != null) {
            this.ensureServiceUnbound(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }
    
    private void processListenerQueue(final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        final String s = "NotifManCompat";
        final int n = 3;
        if (Log.isLoggable(s, n)) {
            final String s2 = "NotifManCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("Processing component ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName);
            sb.append(", ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.size());
            sb.append(" queued tasks");
            Log.d(s2, sb.toString());
        }
        if (notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.isEmpty()) {
            return;
        }
        if (this.ensureServiceBound(notificationManagerCompat$SideChannelManager$ListenerRecord) && notificationManagerCompat$SideChannelManager$ListenerRecord.service != null) {
            while (true) {
                final NotificationManagerCompat$Task notificationManagerCompat$Task = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.peek();
                if (notificationManagerCompat$Task == null) {
                    break;
                }
                final String s3 = "NotifManCompat";
                try {
                    Label_0233: {
                        if (!Log.isLoggable(s3, n)) {
                            break Label_0233;
                        }
                        final String s4 = "NotifManCompat";
                        try {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Sending task ");
                            final StringBuilder sb3 = sb2;
                            try {
                                sb3.append(notificationManagerCompat$Task);
                                Log.d(s4, sb2.toString());
                                notificationManagerCompat$Task.send(notificationManagerCompat$SideChannelManager$ListenerRecord.service);
                                final LinkedList taskQueue = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue;
                                try {
                                    taskQueue.remove();
                                }
                                catch (RemoteException ex) {
                                    final String s5 = "NotifManCompat";
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append("RemoteException communicating with ");
                                    sb4.append(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName);
                                    Log.w(s5, sb4.toString(), (Throwable)ex);
                                }
                                catch (DeadObjectException ex2) {
                                    if (Log.isLoggable("NotifManCompat", n)) {
                                        final String s6 = "NotifManCompat";
                                        final StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Remote service has died: ");
                                        sb5.append(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName);
                                        Log.d(s6, sb5.toString());
                                        break;
                                    }
                                    break;
                                }
                            }
                            catch (RemoteException ex3) {}
                            catch (DeadObjectException ex4) {}
                        }
                        catch (RemoteException ex5) {}
                        catch (DeadObjectException ex6) {}
                    }
                }
                catch (RemoteException ex7) {}
                catch (DeadObjectException ex8) {}
                break;
            }
            if (!notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.isEmpty()) {
                this.scheduleListenerRetry(notificationManagerCompat$SideChannelManager$ListenerRecord);
            }
            return;
        }
        this.scheduleListenerRetry(notificationManagerCompat$SideChannelManager$ListenerRecord);
    }
    
    private void scheduleListenerRetry(final NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        final Handler mHandler = this.mHandler;
        final ComponentName componentName = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
        final int n = 3;
        if (mHandler.hasMessages(n, (Object)componentName)) {
            return;
        }
        final int retryCount = notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount;
        final int n2 = 1;
        notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount = retryCount + n2;
        if (notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount > 6) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Giving up on delivering ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.size());
            sb.append(" tasks to ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.componentName);
            sb.append(" after ");
            sb.append(notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount);
            sb.append(" retries");
            Log.w("NotifManCompat", sb.toString());
            notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.clear();
            return;
        }
        final int n3 = (n2 << notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount - n2) * 1000;
        if (Log.isLoggable("NotifManCompat", n)) {
            final String s = "NotifManCompat";
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Scheduling retry for ");
            sb2.append(n3);
            sb2.append(" ms");
            Log.d(s, sb2.toString());
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(n, (Object)notificationManagerCompat$SideChannelManager$ListenerRecord.componentName), (long)n3);
    }
    
    private void updateListenerMap() {
        final Set enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
        if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
            return;
        }
        this.mCachedEnabledPackages = enabledListenerPackages;
        final List queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
        final HashSet<ComponentName> set = new HashSet<ComponentName>();
        for (final ResolveInfo resolveInfo : queryIntentServices) {
            if (!enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                continue;
            }
            final ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
            if (resolveInfo.serviceInfo.permission != null) {
                final String s = "NotifManCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append("Permission present on component ");
                sb.append(componentName);
                sb.append(", not adding listener record.");
                Log.w(s, sb.toString());
            }
            else {
                set.add(componentName);
            }
        }
        final Iterator<Object> iterator2 = set.iterator();
        int n;
        while (true) {
            final boolean hasNext = iterator2.hasNext();
            n = 3;
            if (!hasNext) {
                break;
            }
            final ComponentName componentName2 = iterator2.next();
            if (this.mRecordMap.containsKey(componentName2)) {
                continue;
            }
            if (Log.isLoggable("NotifManCompat", n)) {
                final String s2 = "NotifManCompat";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Adding listener record for ");
                sb2.append(componentName2);
                Log.d(s2, sb2.toString());
            }
            this.mRecordMap.put(componentName2, new NotificationManagerCompat$SideChannelManager$ListenerRecord(componentName2));
        }
        final Iterator<Map.Entry<Object, V>> iterator3 = this.mRecordMap.entrySet().iterator();
        while (iterator3.hasNext()) {
            final Map.Entry<Object, V> entry = iterator3.next();
            if (!set.contains(entry.getKey())) {
                if (Log.isLoggable("NotifManCompat", n)) {
                    final String s3 = "NotifManCompat";
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Removing listener record for ");
                    sb3.append(entry.getKey());
                    Log.d(s3, sb3.toString());
                }
                this.ensureServiceUnbound((NotificationManagerCompat$SideChannelManager$ListenerRecord)entry.getValue());
                iterator3.remove();
            }
        }
    }
    
    public boolean handleMessage(final Message message) {
        final int what = message.what;
        final boolean b = true;
        switch (what) {
            default: {
                return false;
            }
            case 3: {
                this.handleRetryListenerQueue((ComponentName)message.obj);
                return b;
            }
            case 2: {
                this.handleServiceDisconnected((ComponentName)message.obj);
                return b;
            }
            case 1: {
                final NotificationManagerCompat$ServiceConnectedEvent notificationManagerCompat$ServiceConnectedEvent = (NotificationManagerCompat$ServiceConnectedEvent)message.obj;
                this.handleServiceConnected(notificationManagerCompat$ServiceConnectedEvent.componentName, notificationManagerCompat$ServiceConnectedEvent.iBinder);
                return b;
            }
            case 0: {
                this.handleQueueTask((NotificationManagerCompat$Task)message.obj);
                return b;
            }
        }
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            final String s = "NotifManCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("Connected to service ");
            sb.append(componentName);
            Log.d(s, sb.toString());
        }
        this.mHandler.obtainMessage(1, (Object)new NotificationManagerCompat$ServiceConnectedEvent(componentName, binder)).sendToTarget();
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            final String s = "NotifManCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("Disconnected from service ");
            sb.append(componentName);
            Log.d(s, sb.toString());
        }
        this.mHandler.obtainMessage(2, (Object)componentName).sendToTarget();
    }
    
    public void queueTask(final NotificationManagerCompat$Task notificationManagerCompat$Task) {
        this.mHandler.obtainMessage(0, (Object)notificationManagerCompat$Task).sendToTarget();
    }
}
