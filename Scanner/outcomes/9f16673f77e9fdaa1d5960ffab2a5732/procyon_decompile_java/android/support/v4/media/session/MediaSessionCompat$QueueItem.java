// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaSessionCompat$QueueItem implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    public static final int UNKNOWN_ID = 255;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private Object mItem;
    
    static {
        CREATOR = (Parcelable$Creator)new MediaSessionCompat$QueueItem$1();
    }
    
    MediaSessionCompat$QueueItem(final Parcel parcel) {
        this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = parcel.readLong();
    }
    
    public MediaSessionCompat$QueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final long n) {
        this(null, mediaDescriptionCompat, n);
    }
    
    private MediaSessionCompat$QueueItem(final Object mItem, final MediaDescriptionCompat mDescription, final long mId) {
        if (mDescription == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        if (mId != -1) {
            this.mDescription = mDescription;
            this.mId = mId;
            this.mItem = mItem;
            return;
        }
        throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
    }
    
    public static MediaSessionCompat$QueueItem fromQueueItem(final Object o) {
        if (o != null && Build$VERSION.SDK_INT >= 21) {
            return new MediaSessionCompat$QueueItem(o, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21$QueueItem.getDescription(o)), MediaSessionCompatApi21$QueueItem.getQueueId(o));
        }
        return null;
    }
    
    public static List fromQueueItemList(final List list) {
        if (list != null && Build$VERSION.SDK_INT >= 21) {
            final ArrayList<MediaSessionCompat$QueueItem> list2 = new ArrayList<MediaSessionCompat$QueueItem>();
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(fromQueueItem(iterator.next()));
            }
            return list2;
        }
        return null;
    }
    
    public static MediaSessionCompat$QueueItem obtain(final Object o) {
        return fromQueueItem(o);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public MediaDescriptionCompat getDescription() {
        return this.mDescription;
    }
    
    public long getQueueId() {
        return this.mId;
    }
    
    public Object getQueueItem() {
        if (this.mItem == null && Build$VERSION.SDK_INT >= 21) {
            return this.mItem = MediaSessionCompatApi21$QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
        }
        return this.mItem;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MediaSession.QueueItem {Description=");
        sb.append(this.mDescription);
        sb.append(", Id=");
        sb.append(this.mId);
        sb.append(" }");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        this.mDescription.writeToParcel(parcel, n);
        parcel.writeLong(this.mId);
    }
}
