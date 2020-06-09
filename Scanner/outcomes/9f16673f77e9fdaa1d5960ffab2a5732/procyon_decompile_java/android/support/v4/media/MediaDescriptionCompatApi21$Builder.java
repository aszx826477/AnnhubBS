// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.media.MediaDescription$Builder;

class MediaDescriptionCompatApi21$Builder
{
    public static Object build(final Object o) {
        return ((MediaDescription$Builder)o).build();
    }
    
    public static Object newInstance() {
        return new MediaDescription$Builder();
    }
    
    public static void setDescription(final Object o, final CharSequence description) {
        ((MediaDescription$Builder)o).setDescription(description);
    }
    
    public static void setExtras(final Object o, final Bundle extras) {
        ((MediaDescription$Builder)o).setExtras(extras);
    }
    
    public static void setIconBitmap(final Object o, final Bitmap iconBitmap) {
        ((MediaDescription$Builder)o).setIconBitmap(iconBitmap);
    }
    
    public static void setIconUri(final Object o, final Uri iconUri) {
        ((MediaDescription$Builder)o).setIconUri(iconUri);
    }
    
    public static void setMediaId(final Object o, final String mediaId) {
        ((MediaDescription$Builder)o).setMediaId(mediaId);
    }
    
    public static void setSubtitle(final Object o, final CharSequence subtitle) {
        ((MediaDescription$Builder)o).setSubtitle(subtitle);
    }
    
    public static void setTitle(final Object o, final CharSequence title) {
        ((MediaDescription$Builder)o).setTitle(title);
    }
}
