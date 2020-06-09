// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.text.TextUtils;
import android.os.Bundle;

public final class PlaybackStateCompat$CustomAction$Builder
{
    private final String mAction;
    private Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;
    
    public PlaybackStateCompat$CustomAction$Builder(final String mAction, final CharSequence mName, final int mIcon) {
        if (TextUtils.isEmpty((CharSequence)mAction)) {
            throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
        }
        if (TextUtils.isEmpty(mName)) {
            throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
        }
        if (mIcon != 0) {
            this.mAction = mAction;
            this.mName = mName;
            this.mIcon = mIcon;
            return;
        }
        throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
    }
    
    public PlaybackStateCompat$CustomAction build() {
        return new PlaybackStateCompat$CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
    }
    
    public PlaybackStateCompat$CustomAction$Builder setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
        return this;
    }
}
