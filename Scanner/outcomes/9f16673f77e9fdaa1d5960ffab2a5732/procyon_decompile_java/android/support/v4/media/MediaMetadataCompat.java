// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Set;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaMetadataCompat implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    static final ArrayMap METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;
    
    static {
        METADATA_KEYS_TYPE = new ArrayMap();
        final ArrayMap metadata_KEYS_TYPE = MediaMetadataCompat.METADATA_KEYS_TYPE;
        final int n = 1;
        metadata_KEYS_TYPE.put("android.media.metadata.TITLE", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DATE", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", n);
        final ArrayMap metadata_KEYS_TYPE2 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        final int n2 = 2;
        metadata_KEYS_TYPE2.put("android.media.metadata.ART", n2);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", n2);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", n);
        final ArrayMap metadata_KEYS_TYPE3 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        final int n3 = 3;
        metadata_KEYS_TYPE3.put("android.media.metadata.USER_RATING", n3);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.RATING", n3);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", n2);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", n);
        MediaMetadataCompat.METADATA_KEYS_TYPE.put("android.media.metadata.ADVERTISEMENT", 0);
        final String[] preferred_DESCRIPTION_ORDER = new String[7];
        preferred_DESCRIPTION_ORDER[0] = "android.media.metadata.TITLE";
        preferred_DESCRIPTION_ORDER[n] = "android.media.metadata.ARTIST";
        preferred_DESCRIPTION_ORDER[n2] = "android.media.metadata.ALBUM";
        preferred_DESCRIPTION_ORDER[n3] = "android.media.metadata.ALBUM_ARTIST";
        preferred_DESCRIPTION_ORDER[4] = "android.media.metadata.WRITER";
        preferred_DESCRIPTION_ORDER[5] = "android.media.metadata.AUTHOR";
        preferred_DESCRIPTION_ORDER[6] = "android.media.metadata.COMPOSER";
        PREFERRED_DESCRIPTION_ORDER = preferred_DESCRIPTION_ORDER;
        final String[] preferred_BITMAP_ORDER = new String[n3];
        preferred_BITMAP_ORDER[0] = "android.media.metadata.DISPLAY_ICON";
        preferred_BITMAP_ORDER[n] = "android.media.metadata.ART";
        preferred_BITMAP_ORDER[n2] = "android.media.metadata.ALBUM_ART";
        PREFERRED_BITMAP_ORDER = preferred_BITMAP_ORDER;
        final String[] preferred_URI_ORDER = new String[n3];
        preferred_URI_ORDER[0] = "android.media.metadata.DISPLAY_ICON_URI";
        preferred_URI_ORDER[n] = "android.media.metadata.ART_URI";
        preferred_URI_ORDER[n2] = "android.media.metadata.ALBUM_ART_URI";
        PREFERRED_URI_ORDER = preferred_URI_ORDER;
        CREATOR = (Parcelable$Creator)new MediaMetadataCompat$1();
    }
    
    MediaMetadataCompat(final Bundle bundle) {
        this.mBundle = new Bundle(bundle);
    }
    
    MediaMetadataCompat(final Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }
    
    public static MediaMetadataCompat fromMediaMetadata(final Object mMetadataObj) {
        if (mMetadataObj != null && Build$VERSION.SDK_INT >= 21) {
            final Parcel obtain = Parcel.obtain();
            MediaMetadataCompatApi21.writeToParcel(mMetadataObj, obtain, 0);
            obtain.setDataPosition(0);
            final MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            mediaMetadataCompat.mMetadataObj = mMetadataObj;
            return mediaMetadataCompat;
        }
        return null;
    }
    
    public boolean containsKey(final String s) {
        return this.mBundle.containsKey(s);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Bitmap getBitmap(final String s) {
        Bitmap bitmap = null;
        try {
            final Parcelable parcelable = this.mBundle.getParcelable(s);
            try {
                bitmap = (Bitmap)parcelable;
            }
            catch (Exception ex) {
                Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", (Throwable)ex);
            }
        }
        catch (Exception ex2) {}
        return bitmap;
    }
    
    public Bundle getBundle() {
        return this.mBundle;
    }
    
    public MediaDescriptionCompat getDescription() {
        final MediaDescriptionCompat mDescription = this.mDescription;
        if (mDescription != null) {
            return mDescription;
        }
        final String string = this.getString("android.media.metadata.MEDIA_ID");
        final CharSequence[] array = new CharSequence[3];
        Bitmap iconBitmap = null;
        Uri parse = null;
        final CharSequence text = this.getText("android.media.metadata.DISPLAY_TITLE");
        final boolean empty = TextUtils.isEmpty(text);
        final int n = 2;
        final int n2 = 1;
        if (!empty) {
            array[0] = text;
            array[n2] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            array[n] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        else {
            int i = 0;
            int n3 = 0;
            while (i < array.length) {
                final String[] preferred_DESCRIPTION_ORDER = MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER;
                if (n3 >= preferred_DESCRIPTION_ORDER.length) {
                    break;
                }
                final int n4 = n3 + 1;
                final CharSequence text2 = this.getText(preferred_DESCRIPTION_ORDER[n3]);
                if (!TextUtils.isEmpty(text2)) {
                    final int n5 = i + 1;
                    array[i] = text2;
                    i = n5;
                }
                n3 = n4;
            }
        }
        int n6 = 0;
        while (true) {
            final String[] preferred_BITMAP_ORDER = MediaMetadataCompat.PREFERRED_BITMAP_ORDER;
            if (n6 >= preferred_BITMAP_ORDER.length) {
                break;
            }
            final Bitmap bitmap = this.getBitmap(preferred_BITMAP_ORDER[n6]);
            if (bitmap != null) {
                iconBitmap = bitmap;
                break;
            }
            ++n6;
        }
        int n7 = 0;
        while (true) {
            final String[] preferred_URI_ORDER = MediaMetadataCompat.PREFERRED_URI_ORDER;
            if (n7 >= preferred_URI_ORDER.length) {
                break;
            }
            final String string2 = this.getString(preferred_URI_ORDER[n7]);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                parse = Uri.parse(string2);
                break;
            }
            ++n7;
        }
        Uri parse2 = null;
        final String string3 = this.getString("android.media.metadata.MEDIA_URI");
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            parse2 = Uri.parse(string3);
        }
        final MediaDescriptionCompat$Builder mediaDescriptionCompat$Builder = new MediaDescriptionCompat$Builder();
        mediaDescriptionCompat$Builder.setMediaId(string);
        mediaDescriptionCompat$Builder.setTitle(array[0]);
        mediaDescriptionCompat$Builder.setSubtitle(array[n2]);
        mediaDescriptionCompat$Builder.setDescription(array[n]);
        mediaDescriptionCompat$Builder.setIconBitmap(iconBitmap);
        mediaDescriptionCompat$Builder.setIconUri(parse);
        mediaDescriptionCompat$Builder.setMediaUri(parse2);
        if (this.mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            final Bundle extras = new Bundle();
            extras.putLong("android.media.extra.BT_FOLDER_TYPE", this.getLong("android.media.metadata.BT_FOLDER_TYPE"));
            mediaDescriptionCompat$Builder.setExtras(extras);
        }
        return this.mDescription = mediaDescriptionCompat$Builder.build();
    }
    
    public long getLong(final String s) {
        return this.mBundle.getLong(s, 0L);
    }
    
    public Object getMediaMetadata() {
        if (this.mMetadataObj == null && Build$VERSION.SDK_INT >= 21) {
            final Parcel obtain = Parcel.obtain();
            this.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(obtain);
            obtain.recycle();
            return this.mMetadataObj;
        }
        return this.mMetadataObj;
    }
    
    public RatingCompat getRating(final String s) {
        RatingCompat fromRating = null;
        try {
            Label_0043: {
                if (Build$VERSION.SDK_INT < 19) {
                    break Label_0043;
                }
                final Parcelable parcelable = this.mBundle.getParcelable(s);
                try {
                    fromRating = RatingCompat.fromRating(parcelable);
                    Label_0067: {
                        break Label_0067;
                        final Parcelable parcelable2 = this.mBundle.getParcelable(s);
                        try {
                            fromRating = (RatingCompat)parcelable2;
                        }
                        catch (Exception ex) {
                            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", (Throwable)ex);
                        }
                    }
                }
                catch (Exception ex2) {}
            }
        }
        catch (Exception ex3) {}
        return fromRating;
    }
    
    public String getString(final String s) {
        final CharSequence charSequence = this.mBundle.getCharSequence(s);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
    
    public CharSequence getText(final String s) {
        return this.mBundle.getCharSequence(s);
    }
    
    public Set keySet() {
        return this.mBundle.keySet();
    }
    
    public int size() {
        return this.mBundle.size();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeBundle(this.mBundle);
    }
}
