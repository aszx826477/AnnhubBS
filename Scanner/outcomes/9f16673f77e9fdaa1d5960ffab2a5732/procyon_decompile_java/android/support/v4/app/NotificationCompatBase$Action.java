// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

public abstract class NotificationCompatBase$Action
{
    public abstract PendingIntent getActionIntent();
    
    public abstract boolean getAllowGeneratedReplies();
    
    public abstract Bundle getExtras();
    
    public abstract int getIcon();
    
    public abstract RemoteInputCompatBase$RemoteInput[] getRemoteInputs();
    
    public abstract CharSequence getTitle();
}
