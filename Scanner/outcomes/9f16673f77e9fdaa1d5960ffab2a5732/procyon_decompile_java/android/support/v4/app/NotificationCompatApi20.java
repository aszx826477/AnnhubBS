// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.app.Notification$Action;
import android.app.Notification;
import android.app.RemoteInput;
import android.os.Bundle;
import android.app.Notification$Action$Builder;
import android.app.Notification$Builder;

class NotificationCompatApi20
{
    public static void addAction(final Notification$Builder notification$Builder, final NotificationCompatBase$Action notificationCompatBase$Action) {
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(notificationCompatBase$Action.getIcon(), notificationCompatBase$Action.getTitle(), notificationCompatBase$Action.getActionIntent());
        if (notificationCompatBase$Action.getRemoteInputs() != null) {
            final RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(notificationCompatBase$Action.getRemoteInputs());
            for (int length = fromCompat.length, i = 0; i < length; ++i) {
                notification$Action$Builder.addRemoteInput(fromCompat[i]);
            }
        }
        Bundle bundle;
        if (notificationCompatBase$Action.getExtras() != null) {
            bundle = new Bundle(notificationCompatBase$Action.getExtras());
        }
        else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompatBase$Action.getAllowGeneratedReplies());
        notification$Action$Builder.addExtras(bundle);
        notification$Builder.addAction(notification$Action$Builder.build());
    }
    
    public static NotificationCompatBase$Action getAction(final Notification notification, final int n, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        return getActionCompatFromAction(notification.actions[n], notificationCompatBase$Action$Factory, remoteInputCompatBase$RemoteInput$Factory);
    }
    
    private static NotificationCompatBase$Action getActionCompatFromAction(final Notification$Action notification$Action, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        return notificationCompatBase$Action$Factory.build(notification$Action.icon, notification$Action.title, notification$Action.actionIntent, notification$Action.getExtras(), RemoteInputCompatApi20.toCompat(notification$Action.getRemoteInputs(), remoteInputCompatBase$RemoteInput$Factory), notification$Action.getExtras().getBoolean("android.support.allowGeneratedReplies"));
    }
    
    private static Notification$Action getActionFromActionCompat(final NotificationCompatBase$Action notificationCompatBase$Action) {
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(notificationCompatBase$Action.getIcon(), notificationCompatBase$Action.getTitle(), notificationCompatBase$Action.getActionIntent());
        Bundle bundle;
        if (notificationCompatBase$Action.getExtras() != null) {
            bundle = new Bundle(notificationCompatBase$Action.getExtras());
        }
        else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompatBase$Action.getAllowGeneratedReplies());
        notification$Action$Builder.addExtras(bundle);
        final RemoteInputCompatBase$RemoteInput[] remoteInputs = notificationCompatBase$Action.getRemoteInputs();
        if (remoteInputs != null) {
            final RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(remoteInputs);
            for (int length = fromCompat.length, i = 0; i < length; ++i) {
                notification$Action$Builder.addRemoteInput(fromCompat[i]);
            }
        }
        return notification$Action$Builder.build();
    }
    
    public static NotificationCompatBase$Action[] getActionsFromParcelableArrayList(final ArrayList list, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        if (list == null) {
            return null;
        }
        final NotificationCompatBase$Action[] array = notificationCompatBase$Action$Factory.newArray(list.size());
        for (int i = 0; i < array.length; ++i) {
            array[i] = getActionCompatFromAction(list.get(i), notificationCompatBase$Action$Factory, remoteInputCompatBase$RemoteInput$Factory);
        }
        return array;
    }
    
    public static String getGroup(final Notification notification) {
        return notification.getGroup();
    }
    
    public static boolean getLocalOnly(final Notification notification) {
        return (notification.flags & 0x100) != 0x0;
    }
    
    public static ArrayList getParcelableArrayListForActions(final NotificationCompatBase$Action[] array) {
        if (array == null) {
            return null;
        }
        final ArrayList<Notification$Action> list = new ArrayList<Notification$Action>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(getActionFromActionCompat(array[i]));
        }
        return list;
    }
    
    public static String getSortKey(final Notification notification) {
        return notification.getSortKey();
    }
    
    public static boolean isGroupSummary(final Notification notification) {
        return (notification.flags & 0x200) != 0x0;
    }
}
