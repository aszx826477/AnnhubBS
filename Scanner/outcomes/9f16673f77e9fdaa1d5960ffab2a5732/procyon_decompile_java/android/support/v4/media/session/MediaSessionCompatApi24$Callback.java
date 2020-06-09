// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

public interface MediaSessionCompatApi24$Callback extends MediaSessionCompatApi23$Callback
{
    void onPrepare();
    
    void onPrepareFromMediaId(final String p0, final Bundle p1);
    
    void onPrepareFromSearch(final String p0, final Bundle p1);
    
    void onPrepareFromUri(final Uri p0, final Bundle p1);
}
