// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;

class MediaBrowserCompat$MediaBrowserImplApi23 extends MediaBrowserCompat$MediaBrowserImplApi21
{
    public MediaBrowserCompat$MediaBrowserImplApi23(final Context context, final ComponentName componentName, final MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, final Bundle bundle) {
        super(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
    }
    
    public void getItem(final String s, final MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        if (this.mServiceBinderWrapper == null) {
            MediaBrowserCompatApi23.getItem(this.mBrowserObj, s, mediaBrowserCompat$ItemCallback.mItemCallbackObj);
        }
        else {
            super.getItem(s, mediaBrowserCompat$ItemCallback);
        }
    }
}
