// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.RemoteInput$Builder;
import android.app.RemoteInput;
import android.os.Bundle;
import android.content.Intent;

class RemoteInputCompatApi20
{
    static void addResultsToIntent(final RemoteInputCompatBase$RemoteInput[] array, final Intent intent, final Bundle bundle) {
        RemoteInput.addResultsToIntent(fromCompat(array), intent, bundle);
    }
    
    static RemoteInput[] fromCompat(final RemoteInputCompatBase$RemoteInput[] array) {
        if (array == null) {
            return null;
        }
        final RemoteInput[] array2 = new RemoteInput[array.length];
        for (int i = 0; i < array.length; ++i) {
            final RemoteInputCompatBase$RemoteInput remoteInputCompatBase$RemoteInput = array[i];
            array2[i] = new RemoteInput$Builder(remoteInputCompatBase$RemoteInput.getResultKey()).setLabel(remoteInputCompatBase$RemoteInput.getLabel()).setChoices(remoteInputCompatBase$RemoteInput.getChoices()).setAllowFreeFormInput(remoteInputCompatBase$RemoteInput.getAllowFreeFormInput()).addExtras(remoteInputCompatBase$RemoteInput.getExtras()).build();
        }
        return array2;
    }
    
    static Bundle getResultsFromIntent(final Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }
    
    static RemoteInputCompatBase$RemoteInput[] toCompat(final RemoteInput[] array, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        if (array == null) {
            return null;
        }
        final RemoteInputCompatBase$RemoteInput[] array2 = remoteInputCompatBase$RemoteInput$Factory.newArray(array.length);
        for (int i = 0; i < array.length; ++i) {
            final RemoteInput remoteInput = array[i];
            array2[i] = remoteInputCompatBase$RemoteInput$Factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
        }
        return array2;
    }
}
