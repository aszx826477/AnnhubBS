// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import java.util.Iterator;
import android.os.Build$VERSION;
import android.graphics.Bitmap;
import android.os.Bundle;

public final class MediaMetadataCompat$Builder
{
    private final Bundle mBundle;
    
    public MediaMetadataCompat$Builder() {
        this.mBundle = new Bundle();
    }
    
    public MediaMetadataCompat$Builder(final MediaMetadataCompat mediaMetadataCompat) {
        this.mBundle = new Bundle(mediaMetadataCompat.mBundle);
    }
    
    public MediaMetadataCompat$Builder(final MediaMetadataCompat mediaMetadataCompat, final int n) {
        this(mediaMetadataCompat);
        for (final String s : this.mBundle.keySet()) {
            final Object value = this.mBundle.get(s);
            if (value != null && value instanceof Bitmap) {
                final Bitmap bitmap = (Bitmap)value;
                if (bitmap.getHeight() <= n && bitmap.getWidth() <= n) {
                    if (Build$VERSION.SDK_INT < 14) {
                        continue;
                    }
                    if (!s.equals("android.media.metadata.ART") && !s.equals("android.media.metadata.ALBUM_ART")) {
                        continue;
                    }
                    this.putBitmap(s, bitmap.copy(bitmap.getConfig(), false));
                }
                else {
                    this.putBitmap(s, this.scaleBitmap(bitmap, n));
                }
            }
        }
    }
    
    private Bitmap scaleBitmap(final Bitmap bitmap, final int n) {
        final float n2 = n;
        final float min = Math.min(n2 / bitmap.getWidth(), n2 / bitmap.getHeight());
        return Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * min), (int)(bitmap.getHeight() * min), true);
    }
    
    public MediaMetadataCompat build() {
        return new MediaMetadataCompat(this.mBundle);
    }
    
    public MediaMetadataCompat$Builder putBitmap(final String s, final Bitmap bitmap) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && (int)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s) != 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(s);
            sb.append(" key cannot be used to put a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
        this.mBundle.putParcelable(s, (Parcelable)bitmap);
        return this;
    }
    
    public MediaMetadataCompat$Builder putLong(final String s, final long n) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && (int)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s) != 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(s);
            sb.append(" key cannot be used to put a long");
            throw new IllegalArgumentException(sb.toString());
        }
        this.mBundle.putLong(s, n);
        return this;
    }
    
    public MediaMetadataCompat$Builder putRating(final String s, final RatingCompat ratingCompat) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && (int)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s) != 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(s);
            sb.append(" key cannot be used to put a Rating");
            throw new IllegalArgumentException(sb.toString());
        }
        if (Build$VERSION.SDK_INT >= 19) {
            this.mBundle.putParcelable(s, (Parcelable)ratingCompat.getRating());
        }
        else {
            this.mBundle.putParcelable(s, (Parcelable)ratingCompat);
        }
        return this;
    }
    
    public MediaMetadataCompat$Builder putString(final String s, final String s2) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && (int)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s) != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(s);
            sb.append(" key cannot be used to put a String");
            throw new IllegalArgumentException(sb.toString());
        }
        this.mBundle.putCharSequence(s, (CharSequence)s2);
        return this;
    }
    
    public MediaMetadataCompat$Builder putText(final String s, final CharSequence charSequence) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && (int)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s) != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(s);
            sb.append(" key cannot be used to put a CharSequence");
            throw new IllegalArgumentException(sb.toString());
        }
        this.mBundle.putCharSequence(s, charSequence);
        return this;
    }
}
