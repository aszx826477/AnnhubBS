// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

class TaskStackBuilder$TaskStackBuilderImplBase implements TaskStackBuilder$TaskStackBuilderImpl
{
    public PendingIntent getPendingIntent(final Context context, final Intent[] array, final int n, final int n2, final Bundle bundle) {
        final Intent intent = new Intent(array[array.length - 1]);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, n, intent, n2);
    }
}
