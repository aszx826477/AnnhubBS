// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.media.MediaDescription;
import android.os.Parcel;

class MediaDescriptionCompatApi21
{
    public static Object fromParcel(final Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
    
    public static CharSequence getDescription(final Object o) {
        return ((MediaDescription)o).getDescription();
    }
    
    public static Bundle getExtras(final Object o) {
        return ((MediaDescription)o).getExtras();
    }
    
    public static Bitmap getIconBitmap(final Object o) {
        return ((MediaDescription)o).getIconBitmap();
    }
    
    public static Uri getIconUri(final Object o) {
        return ((MediaDescription)o).getIconUri();
    }
    
    public static String getMediaId(final Object o) {
        return ((MediaDescription)o).getMediaId();
    }
    
    public static CharSequence getSubtitle(final Object o) {
        return ((MediaDescription)o).getSubtitle();
    }
    
    public static CharSequence getTitle(final Object o) {
        return ((MediaDescription)o).getTitle();
    }
    
    public static void writeToParcel(final Object o, final Parcel parcel, final int n) {
        ((MediaDescription)o).writeToParcel(parcel, n);
    }
}
