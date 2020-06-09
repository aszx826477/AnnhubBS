// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;

public final class MediaDescriptionCompat$Builder
{
    private CharSequence mDescription;
    private Bundle mExtras;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private CharSequence mSubtitle;
    private CharSequence mTitle;
    
    public MediaDescriptionCompat build() {
        return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
    }
    
    public MediaDescriptionCompat$Builder setDescription(final CharSequence mDescription) {
        this.mDescription = mDescription;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setIconBitmap(final Bitmap mIcon) {
        this.mIcon = mIcon;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setIconUri(final Uri mIconUri) {
        this.mIconUri = mIconUri;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setMediaId(final String mMediaId) {
        this.mMediaId = mMediaId;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setMediaUri(final Uri mMediaUri) {
        this.mMediaUri = mMediaUri;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setSubtitle(final CharSequence mSubtitle) {
        this.mSubtitle = mSubtitle;
        return this;
    }
    
    public MediaDescriptionCompat$Builder setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        return this;
    }
}
