// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

public class NotificationCompat$Action extends NotificationCompatBase$Action
{
    public static final NotificationCompatBase$Action$Factory FACTORY;
    public PendingIntent actionIntent;
    public int icon;
    private boolean mAllowGeneratedReplies;
    final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    public CharSequence title;
    
    static {
        FACTORY = new NotificationCompat$Action$1();
    }
    
    public NotificationCompat$Action(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this(n, charSequence, pendingIntent, new Bundle(), null, true);
    }
    
    NotificationCompat$Action(final int icon, final CharSequence charSequence, final PendingIntent actionIntent, final Bundle bundle, final RemoteInput[] mRemoteInputs, final boolean mAllowGeneratedReplies) {
        this.icon = icon;
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = actionIntent;
        Bundle mExtras;
        if (bundle != null) {
            mExtras = bundle;
        }
        else {
            mExtras = new Bundle();
        }
        this.mExtras = mExtras;
        this.mRemoteInputs = mRemoteInputs;
        this.mAllowGeneratedReplies = mAllowGeneratedReplies;
    }
    
    public PendingIntent getActionIntent() {
        return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies() {
        return this.mAllowGeneratedReplies;
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public int getIcon() {
        return this.icon;
    }
    
    public RemoteInput[] getRemoteInputs() {
        return this.mRemoteInputs;
    }
    
    public CharSequence getTitle() {
        return this.title;
    }
}
