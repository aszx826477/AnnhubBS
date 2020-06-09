// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.app.PendingIntent;
import android.os.Bundle;

public final class NotificationCompat$Action$Builder
{
    private boolean mAllowGeneratedReplies;
    private final Bundle mExtras;
    private final int mIcon;
    private final PendingIntent mIntent;
    private ArrayList mRemoteInputs;
    private final CharSequence mTitle;
    
    public NotificationCompat$Action$Builder(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this(n, charSequence, pendingIntent, new Bundle(), null, true);
    }
    
    private NotificationCompat$Action$Builder(final int mIcon, final CharSequence charSequence, final PendingIntent mIntent, final Bundle mExtras, final RemoteInput[] array, final boolean mAllowGeneratedReplies) {
        this.mAllowGeneratedReplies = true;
        this.mIcon = mIcon;
        this.mTitle = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mIntent = mIntent;
        this.mExtras = mExtras;
        ArrayList mRemoteInputs;
        if (array == null) {
            mRemoteInputs = null;
        }
        else {
            mRemoteInputs = new ArrayList((Collection<? extends E>)Arrays.asList(array));
        }
        this.mRemoteInputs = mRemoteInputs;
        this.mAllowGeneratedReplies = mAllowGeneratedReplies;
    }
    
    public NotificationCompat$Action$Builder(final NotificationCompat$Action notificationCompat$Action) {
        this(notificationCompat$Action.icon, notificationCompat$Action.title, notificationCompat$Action.actionIntent, new Bundle(notificationCompat$Action.mExtras), notificationCompat$Action.getRemoteInputs(), notificationCompat$Action.getAllowGeneratedReplies());
    }
    
    public NotificationCompat$Action$Builder addExtras(final Bundle bundle) {
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        return this;
    }
    
    public NotificationCompat$Action$Builder addRemoteInput(final RemoteInput remoteInput) {
        if (this.mRemoteInputs == null) {
            this.mRemoteInputs = new ArrayList();
        }
        this.mRemoteInputs.add(remoteInput);
        return this;
    }
    
    public NotificationCompat$Action build() {
        final ArrayList mRemoteInputs = this.mRemoteInputs;
        RemoteInput[] array;
        if (mRemoteInputs != null) {
            array = mRemoteInputs.toArray(new RemoteInput[mRemoteInputs.size()]);
        }
        else {
            array = null;
        }
        return new NotificationCompat$Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, array, this.mAllowGeneratedReplies);
    }
    
    public NotificationCompat$Action$Builder extend(final NotificationCompat$Action$Extender notificationCompat$Action$Extender) {
        notificationCompat$Action$Extender.extend(this);
        return this;
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public NotificationCompat$Action$Builder setAllowGeneratedReplies(final boolean mAllowGeneratedReplies) {
        this.mAllowGeneratedReplies = mAllowGeneratedReplies;
        return this;
    }
}
