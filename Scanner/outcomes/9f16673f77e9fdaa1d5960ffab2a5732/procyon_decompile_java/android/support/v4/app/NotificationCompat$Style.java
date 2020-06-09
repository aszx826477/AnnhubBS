// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;

public abstract class NotificationCompat$Style
{
    CharSequence mBigContentTitle;
    NotificationCompat$Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;
    
    public NotificationCompat$Style() {
        this.mSummaryTextSet = false;
    }
    
    public void addCompatExtras(final Bundle bundle) {
    }
    
    public Notification build() {
        Notification build = null;
        final NotificationCompat$Builder mBuilder = this.mBuilder;
        if (mBuilder != null) {
            build = mBuilder.build();
        }
        return build;
    }
    
    protected void restoreFromCompatExtras(final Bundle bundle) {
    }
    
    public void setBuilder(final NotificationCompat$Builder mBuilder) {
        if (this.mBuilder != mBuilder) {
            this.mBuilder = mBuilder;
            final NotificationCompat$Builder mBuilder2 = this.mBuilder;
            if (mBuilder2 != null) {
                mBuilder2.setStyle(this);
            }
        }
    }
}
