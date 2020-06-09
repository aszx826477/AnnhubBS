// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.content.Loader;
import android.os.Bundle;

public interface LoaderManager$LoaderCallbacks
{
    Loader onCreateLoader(final int p0, final Bundle p1);
    
    void onLoadFinished(final Loader p0, final Object p1);
    
    void onLoaderReset(final Loader p0);
}
