// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.IntentSender;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;

class ActivityCompatJB
{
    public static void finishAffinity(final Activity activity) {
        activity.finishAffinity();
    }
    
    public static void startActivityForResult(final Activity activity, final Intent intent, final int n, final Bundle bundle) {
        activity.startActivityForResult(intent, n, bundle);
    }
    
    public static void startIntentSenderForResult(final Activity activity, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }
}
