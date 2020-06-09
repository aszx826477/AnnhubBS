// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;

class RemoteInput$ImplBase implements RemoteInput$Impl
{
    public void addResultsToIntent(final RemoteInput[] array, final Intent intent, final Bundle bundle) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }
    
    public Bundle getResultsFromIntent(final Intent intent) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return null;
    }
}
