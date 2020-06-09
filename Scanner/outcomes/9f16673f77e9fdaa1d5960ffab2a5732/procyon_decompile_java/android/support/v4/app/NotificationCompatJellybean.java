// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification$Builder;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.util.Log;
import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.List;
import java.util.Iterator;
import android.app.Notification$InboxStyle;
import java.util.ArrayList;
import android.app.Notification$BigTextStyle;
import android.app.Notification$BigPictureStyle;
import android.graphics.Bitmap;
import java.lang.reflect.Field;

class NotificationCompatJellybean
{
    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOW_GENERATED_REPLIES = "allowGeneratedReplies";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;
    
    static {
        sExtrasLock = new Object();
        sActionsLock = new Object();
    }
    
    public static void addBigPictureStyle(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final CharSequence bigContentTitle, final boolean b, final CharSequence summaryText, final Bitmap bitmap, final Bitmap bitmap2, final boolean b2) {
        final Notification$BigPictureStyle bigPicture = new Notification$BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(bigContentTitle).bigPicture(bitmap);
        if (b2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (b) {
            bigPicture.setSummaryText(summaryText);
        }
    }
    
    public static void addBigTextStyle(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final CharSequence bigContentTitle, final boolean b, final CharSequence summaryText, final CharSequence charSequence) {
        final Notification$BigTextStyle bigText = new Notification$BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(bigContentTitle).bigText(charSequence);
        if (b) {
            bigText.setSummaryText(summaryText);
        }
    }
    
    public static void addInboxStyle(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final CharSequence bigContentTitle, final boolean b, final CharSequence summaryText, final ArrayList list) {
        final Notification$InboxStyle setBigContentTitle = new Notification$InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(bigContentTitle);
        if (b) {
            setBigContentTitle.setSummaryText(summaryText);
        }
        final Iterator<CharSequence> iterator = list.iterator();
        while (iterator.hasNext()) {
            setBigContentTitle.addLine((CharSequence)iterator.next());
        }
    }
    
    public static SparseArray buildActionExtrasMap(final List list) {
        SparseArray sparseArray = null;
        for (int i = 0; i < list.size(); ++i) {
            final Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, (Object)bundle);
            }
        }
        return sparseArray;
    }
    
    private static boolean ensureActionReflectionReadyLocked() {
        if (NotificationCompatJellybean.sActionsAccessFailed) {
            return false;
        }
        final boolean sActionsAccessFailed = true;
        try {
            Label_0111: {
                if (NotificationCompatJellybean.sActionsField != null) {
                    break Label_0111;
                }
                final Class<?> forName = Class.forName("android.app.Notification$Action");
                try {
                    NotificationCompatJellybean.sActionClass = forName;
                    final Field declaredField = NotificationCompatJellybean.sActionClass.getDeclaredField("icon");
                    try {
                        NotificationCompatJellybean.sActionIconField = declaredField;
                        final Field declaredField2 = NotificationCompatJellybean.sActionClass.getDeclaredField("title");
                        try {
                            NotificationCompatJellybean.sActionTitleField = declaredField2;
                            final Field declaredField3 = NotificationCompatJellybean.sActionClass.getDeclaredField("actionIntent");
                            try {
                                NotificationCompatJellybean.sActionIntentField = declaredField3;
                                final Field declaredField4 = Notification.class.getDeclaredField("actions");
                                try {
                                    (NotificationCompatJellybean.sActionsField = declaredField4).setAccessible(sActionsAccessFailed);
                                    return sActionsAccessFailed ^ NotificationCompatJellybean.sActionsAccessFailed;
                                }
                                catch (NoSuchFieldException ex) {
                                    Log.e("NotificationCompat", "Unable to access notification actions", (Throwable)ex);
                                    NotificationCompatJellybean.sActionsAccessFailed = sActionsAccessFailed;
                                }
                                catch (ClassNotFoundException ex2) {
                                    Log.e("NotificationCompat", "Unable to access notification actions", (Throwable)ex2);
                                    NotificationCompatJellybean.sActionsAccessFailed = sActionsAccessFailed;
                                }
                            }
                            catch (NoSuchFieldException ex3) {}
                            catch (ClassNotFoundException ex4) {}
                        }
                        catch (NoSuchFieldException ex5) {}
                        catch (ClassNotFoundException ex6) {}
                    }
                    catch (NoSuchFieldException ex7) {}
                    catch (ClassNotFoundException ex8) {}
                }
                catch (NoSuchFieldException ex9) {}
                catch (ClassNotFoundException ex10) {}
            }
        }
        catch (NoSuchFieldException ex11) {}
        catch (ClassNotFoundException ex12) {}
        return sActionsAccessFailed ^ NotificationCompatJellybean.sActionsAccessFailed;
    }
    
    public static NotificationCompatBase$Action getAction(final Notification notification, final int n, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        final Object sActionsLock = NotificationCompatJellybean.sActionsLock;
        // monitorenter(sActionsLock)
        try {
            final Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            Label_0173: {
                if (actionObjectsLocked == null) {
                    break Label_0173;
                }
                final Object o = actionObjectsLocked[n];
                Bundle bundle = null;
                final Bundle extras = getExtras(notification);
                Label_0082: {
                    if (extras == null) {
                        break Label_0082;
                    }
                    final SparseArray sparseParcelableArray = extras.getSparseParcelableArray("android.support.actionExtras");
                    Label_0079: {
                        if (sparseParcelableArray == null) {
                            break Label_0079;
                        }
                        final Object value = sparseParcelableArray.get(n);
                        try {
                            bundle = (Bundle)value;
                            final int int1 = NotificationCompatJellybean.sActionIconField.getInt(o);
                            try {
                                final CharSequence charSequence = (CharSequence)NotificationCompatJellybean.sActionTitleField.get(o);
                                try {
                                    // monitorexit(sActionsLock)
                                    return readAction(notificationCompatBase$Action$Factory, remoteInputCompatBase$RemoteInput$Factory, int1, charSequence, (PendingIntent)NotificationCompatJellybean.sActionIntentField.get(o), bundle);
                                }
                                catch (IllegalAccessException ex) {
                                    Log.e("NotificationCompat", "Unable to access notification actions", (Throwable)ex);
                                    NotificationCompatJellybean.sActionsAccessFailed = true;
                                }
                            }
                            catch (IllegalAccessException ex2) {}
                        }
                        catch (IllegalAccessException ex3) {}
                    }
                }
            }
        }
        catch (IllegalAccessException ex4) {}
        finally {
            // monitorexit(sActionsLock)
            return null;
        }
    }
    
    public static int getActionCount(final Notification notification) {
        synchronized (NotificationCompatJellybean.sActionsLock) {
            final Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            int length;
            if (actionObjectsLocked != null) {
                length = actionObjectsLocked.length;
            }
            else {
                length = 0;
            }
            return length;
        }
    }
    
    private static NotificationCompatBase$Action getActionFromBundle(final Bundle bundle, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        final Bundle bundle2 = bundle.getBundle("extras");
        boolean boolean1 = false;
        if (bundle2 != null) {
            boolean1 = bundle2.getBoolean("android.support.allowGeneratedReplies", false);
        }
        return notificationCompatBase$Action$Factory.build(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent)bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "remoteInputs"), remoteInputCompatBase$RemoteInput$Factory), boolean1);
    }
    
    private static Object[] getActionObjectsLocked(final Notification notification) {
        final Object sActionsLock = NotificationCompatJellybean.sActionsLock;
        // monitorenter(sActionsLock)
        try {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                final Object value = NotificationCompatJellybean.sActionsField.get(notification);
                try {
                    final Object[] array = (Object[])value;
                    try {
                        return array;
                    }
                    catch (IllegalAccessException ex) {
                        Log.e("NotificationCompat", "Unable to access notification actions", (Throwable)ex);
                        NotificationCompatJellybean.sActionsAccessFailed = true;
                        return null;
                    }
                }
                catch (IllegalAccessException ex2) {}
                finally {
                }
                // monitorexit(sActionsLock)
            }
            catch (IllegalAccessException ex3) {}
        }
        finally {}
    }
    
    public static NotificationCompatBase$Action[] getActionsFromParcelableArrayList(final ArrayList list, final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        if (list == null) {
            return null;
        }
        final NotificationCompatBase$Action[] array = notificationCompatBase$Action$Factory.newArray(list.size());
        for (int i = 0; i < array.length; ++i) {
            array[i] = getActionFromBundle(list.get(i), notificationCompatBase$Action$Factory, remoteInputCompatBase$RemoteInput$Factory);
        }
        return array;
    }
    
    private static Bundle getBundleForAction(final NotificationCompatBase$Action notificationCompatBase$Action) {
        final Bundle bundle = new Bundle();
        bundle.putInt("icon", notificationCompatBase$Action.getIcon());
        bundle.putCharSequence("title", notificationCompatBase$Action.getTitle());
        bundle.putParcelable("actionIntent", (Parcelable)notificationCompatBase$Action.getActionIntent());
        Bundle bundle2;
        if (notificationCompatBase$Action.getExtras() != null) {
            bundle2 = new Bundle(notificationCompatBase$Action.getExtras());
        }
        else {
            bundle2 = new Bundle();
        }
        bundle2.putBoolean("android.support.allowGeneratedReplies", notificationCompatBase$Action.getAllowGeneratedReplies());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", (Parcelable[])RemoteInputCompatJellybean.toBundleArray(notificationCompatBase$Action.getRemoteInputs()));
        return bundle;
    }
    
    public static Bundle getExtras(final Notification notification) {
        final Object sExtrasLock = NotificationCompatJellybean.sExtrasLock;
        // monitorenter(sExtrasLock)
        try {
            boolean sExtrasFieldAccessFailed = NotificationCompatJellybean.sExtrasFieldAccessFailed;
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            sExtrasFieldAccessFailed = true;
            try {
                if (NotificationCompatJellybean.sExtrasField == null) {
                    final Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        NotificationCompatJellybean.sExtrasFieldAccessFailed = sExtrasFieldAccessFailed;
                        return null;
                    }
                    declaredField.setAccessible(sExtrasFieldAccessFailed);
                    NotificationCompatJellybean.sExtrasField = declaredField;
                }
                final Object value = NotificationCompatJellybean.sExtrasField.get(notification);
                try {
                    Bundle bundle = (Bundle)value;
                    if (bundle != null) {
                        return bundle;
                    }
                    try {
                        bundle = new Bundle();
                        NotificationCompatJellybean.sExtrasField.set(notification, bundle);
                        return bundle;
                    }
                    catch (NoSuchFieldException ex) {
                        Log.e("NotificationCompat", "Unable to access notification extras", (Throwable)ex);
                    }
                    catch (IllegalAccessException ex2) {
                        Log.e("NotificationCompat", "Unable to access notification extras", (Throwable)ex2);
                    }
                }
                catch (NoSuchFieldException ex3) {}
                catch (IllegalAccessException ex4) {
                    NotificationCompatJellybean.sExtrasFieldAccessFailed = sExtrasFieldAccessFailed;
                    return null;
                }
                finally {
                }
                // monitorexit(sExtrasLock)
            }
            catch (NoSuchFieldException ex5) {}
            catch (IllegalAccessException ex6) {}
        }
        finally {}
    }
    
    public static String getGroup(final Notification notification) {
        return getExtras(notification).getString("android.support.groupKey");
    }
    
    public static boolean getLocalOnly(final Notification notification) {
        return getExtras(notification).getBoolean("android.support.localOnly");
    }
    
    public static ArrayList getParcelableArrayListForActions(final NotificationCompatBase$Action[] array) {
        if (array == null) {
            return null;
        }
        final ArrayList<Bundle> list = new ArrayList<Bundle>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(getBundleForAction(array[i]));
        }
        return list;
    }
    
    public static String getSortKey(final Notification notification) {
        return getExtras(notification).getString("android.support.sortKey");
    }
    
    public static boolean isGroupSummary(final Notification notification) {
        return getExtras(notification).getBoolean("android.support.isGroupSummary");
    }
    
    public static NotificationCompatBase$Action readAction(final NotificationCompatBase$Action$Factory notificationCompatBase$Action$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory, final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle) {
        RemoteInputCompatBase$RemoteInput[] fromBundleArray = null;
        boolean boolean1 = false;
        if (bundle != null) {
            fromBundleArray = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "android.support.remoteInputs"), remoteInputCompatBase$RemoteInput$Factory);
            boolean1 = bundle.getBoolean("android.support.allowGeneratedReplies");
        }
        return notificationCompatBase$Action$Factory.build(n, charSequence, pendingIntent, bundle, fromBundleArray, boolean1);
    }
    
    public static Bundle writeActionAndGetExtras(final Notification$Builder notification$Builder, final NotificationCompatBase$Action notificationCompatBase$Action) {
        notification$Builder.addAction(notificationCompatBase$Action.getIcon(), notificationCompatBase$Action.getTitle(), notificationCompatBase$Action.getActionIntent());
        final Bundle bundle = new Bundle(notificationCompatBase$Action.getExtras());
        if (notificationCompatBase$Action.getRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", (Parcelable[])RemoteInputCompatJellybean.toBundleArray(notificationCompatBase$Action.getRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompatBase$Action.getAllowGeneratedReplies());
        return bundle;
    }
}
