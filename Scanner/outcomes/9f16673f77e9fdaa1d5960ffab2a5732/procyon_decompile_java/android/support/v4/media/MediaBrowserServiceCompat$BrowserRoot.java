// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;

public final class MediaBrowserServiceCompat$BrowserRoot
{
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;
    
    public MediaBrowserServiceCompat$BrowserRoot(final String mRootId, final Bundle mExtras) {
        if (mRootId != null) {
            this.mRootId = mRootId;
            this.mExtras = mExtras;
            return;
        }
        throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public String getRootId() {
        return this.mRootId;
    }
}
