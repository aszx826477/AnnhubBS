// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.pm.ActivityInfo;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;

interface NavUtils$NavUtilsImpl
{
    Intent getParentActivityIntent(final Activity p0);
    
    String getParentActivityName(final Context p0, final ActivityInfo p1);
    
    void navigateUpTo(final Activity p0, final Intent p1);
    
    boolean shouldUpRecreateTask(final Activity p0, final Intent p1);
}
