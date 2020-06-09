// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.MediaDescription$Builder;
import android.net.Uri;

class MediaDescriptionCompatApi23$Builder extends MediaDescriptionCompatApi21$Builder
{
    public static void setMediaUri(final Object o, final Uri mediaUri) {
        ((MediaDescription$Builder)o).setMediaUri(mediaUri);
    }
}
