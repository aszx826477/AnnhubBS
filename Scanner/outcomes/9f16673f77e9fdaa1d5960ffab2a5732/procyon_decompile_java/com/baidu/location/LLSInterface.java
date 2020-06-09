// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.content.Context;
import android.os.IBinder;
import android.content.Intent;

public interface LLSInterface
{
    double getVersion();
    
    IBinder onBind(final Intent p0);
    
    void onCreate(final Context p0);
    
    void onDestroy();
    
    int onStartCommand(final Intent p0, final int p1, final int p2);
    
    void onTaskRemoved(final Intent p0);
    
    boolean onUnBind(final Intent p0);
}
