// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Build$VERSION;
import android.text.TextUtils;
import android.os.Parcel;
import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaDescriptionCompat implements Parcelable
{
    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable$Creator CREATOR;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;
    
    static {
        CREATOR = (Parcelable$Creator)new MediaDescriptionCompat$1();
    }
    
    MediaDescriptionCompat(final Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = (Bitmap)parcel.readParcelable((ClassLoader)null);
        this.mIconUri = (Uri)parcel.readParcelable((ClassLoader)null);
        this.mExtras = parcel.readBundle();
        this.mMediaUri = (Uri)parcel.readParcelable((ClassLoader)null);
    }
    
    MediaDescriptionCompat(final String mMediaId, final CharSequence mTitle, final CharSequence mSubtitle, final CharSequence mDescription, final Bitmap mIcon, final Uri mIconUri, final Bundle mExtras, final Uri mMediaUri) {
        this.mMediaId = mMediaId;
        this.mTitle = mTitle;
        this.mSubtitle = mSubtitle;
        this.mDescription = mDescription;
        this.mIcon = mIcon;
        this.mIconUri = mIconUri;
        this.mExtras = mExtras;
        this.mMediaUri = mMediaUri;
    }
    
    public static MediaDescriptionCompat fromMediaDescription(final Object mDescriptionObj) {
        Uri mediaUri = null;
        if (mDescriptionObj != null && Build$VERSION.SDK_INT >= 21) {
            final MediaDescriptionCompat$Builder mediaDescriptionCompat$Builder = new MediaDescriptionCompat$Builder();
            mediaDescriptionCompat$Builder.setMediaId(MediaDescriptionCompatApi21.getMediaId(mDescriptionObj));
            mediaDescriptionCompat$Builder.setTitle(MediaDescriptionCompatApi21.getTitle(mDescriptionObj));
            mediaDescriptionCompat$Builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(mDescriptionObj));
            mediaDescriptionCompat$Builder.setDescription(MediaDescriptionCompatApi21.getDescription(mDescriptionObj));
            mediaDescriptionCompat$Builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(mDescriptionObj));
            mediaDescriptionCompat$Builder.setIconUri(MediaDescriptionCompatApi21.getIconUri(mDescriptionObj));
            Bundle extras = MediaDescriptionCompatApi21.getExtras(mDescriptionObj);
            if (extras != null) {
                mediaUri = (Uri)extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
            }
            if (mediaUri != null) {
                if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    extras = null;
                }
                else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
            }
            mediaDescriptionCompat$Builder.setExtras(extras);
            if (mediaUri != null) {
                mediaDescriptionCompat$Builder.setMediaUri(mediaUri);
            }
            else if (Build$VERSION.SDK_INT >= 23) {
                mediaDescriptionCompat$Builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(mDescriptionObj));
            }
            final MediaDescriptionCompat build = mediaDescriptionCompat$Builder.build();
            build.mDescriptionObj = mDescriptionObj;
            return build;
        }
        return null;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public CharSequence getDescription() {
        return this.mDescription;
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public Bitmap getIconBitmap() {
        return this.mIcon;
    }
    
    public Uri getIconUri() {
        return this.mIconUri;
    }
    
    public Object getMediaDescription() {
        if (this.mDescriptionObj == null && Build$VERSION.SDK_INT >= 21) {
            final Object instance = MediaDescriptionCompatApi21$Builder.newInstance();
            MediaDescriptionCompatApi21$Builder.setMediaId(instance, this.mMediaId);
            MediaDescriptionCompatApi21$Builder.setTitle(instance, this.mTitle);
            MediaDescriptionCompatApi21$Builder.setSubtitle(instance, this.mSubtitle);
            MediaDescriptionCompatApi21$Builder.setDescription(instance, this.mDescription);
            MediaDescriptionCompatApi21$Builder.setIconBitmap(instance, this.mIcon);
            MediaDescriptionCompatApi21$Builder.setIconUri(instance, this.mIconUri);
            Bundle mExtras = this.mExtras;
            final int sdk_INT = Build$VERSION.SDK_INT;
            final int n = 23;
            if (sdk_INT < n && this.mMediaUri != null) {
                if (mExtras == null) {
                    mExtras = new Bundle();
                    mExtras.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                mExtras.putParcelable("android.support.v4.media.description.MEDIA_URI", (Parcelable)this.mMediaUri);
            }
            MediaDescriptionCompatApi21$Builder.setExtras(instance, mExtras);
            if (Build$VERSION.SDK_INT >= n) {
                MediaDescriptionCompatApi23$Builder.setMediaUri(instance, this.mMediaUri);
            }
            return this.mDescriptionObj = MediaDescriptionCompatApi21$Builder.build(instance);
        }
        return this.mDescriptionObj;
    }
    
    public String getMediaId() {
        return this.mMediaId;
    }
    
    public Uri getMediaUri() {
        return this.mMediaUri;
    }
    
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append((Object)this.mTitle);
        sb.append(", ");
        sb.append((Object)this.mSubtitle);
        sb.append(", ");
        sb.append((Object)this.mDescription);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (Build$VERSION.SDK_INT < 21) {
            parcel.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, parcel, n);
            TextUtils.writeToParcel(this.mSubtitle, parcel, n);
            TextUtils.writeToParcel(this.mDescription, parcel, n);
            parcel.writeParcelable((Parcelable)this.mIcon, n);
            parcel.writeParcelable((Parcelable)this.mIconUri, n);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable((Parcelable)this.mMediaUri, n);
        }
        else {
            MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), parcel, n);
        }
    }
}
