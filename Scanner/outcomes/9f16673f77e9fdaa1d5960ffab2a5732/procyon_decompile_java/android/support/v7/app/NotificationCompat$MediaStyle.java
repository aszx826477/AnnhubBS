// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$Style;

public class NotificationCompat$MediaStyle extends NotificationCompat$Style
{
    int[] mActionsToShowInCompact;
    PendingIntent mCancelButtonIntent;
    boolean mShowCancelButton;
    MediaSessionCompat$Token mToken;
    
    public NotificationCompat$MediaStyle() {
        this.mActionsToShowInCompact = null;
    }
    
    public NotificationCompat$MediaStyle(final NotificationCompat$Builder builder) {
        this.mActionsToShowInCompact = null;
        this.setBuilder(builder);
    }
    
    public NotificationCompat$MediaStyle setCancelButtonIntent(final PendingIntent mCancelButtonIntent) {
        this.mCancelButtonIntent = mCancelButtonIntent;
        return this;
    }
    
    public NotificationCompat$MediaStyle setMediaSession(final MediaSessionCompat$Token mToken) {
        this.mToken = mToken;
        return this;
    }
    
    public NotificationCompat$MediaStyle setShowActionsInCompactView(final int... mActionsToShowInCompact) {
        this.mActionsToShowInCompact = mActionsToShowInCompact;
        return this;
    }
    
    public NotificationCompat$MediaStyle setShowCancelButton(final boolean mShowCancelButton) {
        this.mShowCancelButton = mShowCancelButton;
        return this;
    }
}
