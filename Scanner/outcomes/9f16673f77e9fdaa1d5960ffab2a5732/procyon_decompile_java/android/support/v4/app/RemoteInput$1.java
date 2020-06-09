// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;

final class RemoteInput$1 implements RemoteInputCompatBase$RemoteInput$Factory
{
    public RemoteInput build(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle) {
        return new RemoteInput(s, charSequence, array, b, bundle);
    }
    
    public RemoteInput[] newArray(final int n) {
        return new RemoteInput[n];
    }
}
