// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.content.Intent;

interface RemoteInput$Impl
{
    void addResultsToIntent(final RemoteInput[] p0, final Intent p1, final Bundle p2);
    
    Bundle getResultsFromIntent(final Intent p0);
}
