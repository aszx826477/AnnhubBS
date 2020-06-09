// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.List;
import android.net.Uri;

public final class NotificationCompat$MessagingStyle$Message
{
    static final String KEY_DATA_MIME_TYPE = "type";
    static final String KEY_DATA_URI = "uri";
    static final String KEY_SENDER = "sender";
    static final String KEY_TEXT = "text";
    static final String KEY_TIMESTAMP = "time";
    private String mDataMimeType;
    private Uri mDataUri;
    private final CharSequence mSender;
    private final CharSequence mText;
    private final long mTimestamp;
    
    public NotificationCompat$MessagingStyle$Message(final CharSequence mText, final long mTimestamp, final CharSequence mSender) {
        this.mText = mText;
        this.mTimestamp = mTimestamp;
        this.mSender = mSender;
    }
    
    static Bundle[] getBundleArrayForMessages(final List list) {
        final Bundle[] array = new Bundle[list.size()];
        for (int size = list.size(), i = 0; i < size; ++i) {
            array[i] = list.get(i).toBundle();
        }
        return array;
    }
    
    static NotificationCompat$MessagingStyle$Message getMessageFromBundle(final Bundle bundle) {
        final String s = "text";
        try {
            Label_0149: {
                if (!bundle.containsKey(s) || !bundle.containsKey("time")) {
                    break Label_0149;
                }
                final NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = new NotificationCompat$MessagingStyle$Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.getCharSequence("sender"));
                if (!bundle.containsKey("type")) {
                    return notificationCompat$MessagingStyle$Message;
                }
                Label_0144: {
                    if (!bundle.containsKey("uri")) {
                        break Label_0144;
                    }
                    final String string = bundle.getString("type");
                    final Parcelable parcelable = bundle.getParcelable("uri");
                    try {
                        notificationCompat$MessagingStyle$Message.setData(string, (Uri)parcelable);
                        return notificationCompat$MessagingStyle$Message;
                        return null;
                    }
                    catch (ClassCastException ex) {
                        return null;
                    }
                }
            }
        }
        catch (ClassCastException ex2) {}
    }
    
    static List getMessagesFromBundleArray(final Parcelable[] array) {
        final ArrayList<NotificationCompat$MessagingStyle$Message> list = new ArrayList<NotificationCompat$MessagingStyle$Message>(array.length);
        for (int i = 0; i < array.length; ++i) {
            if (array[i] instanceof Bundle) {
                final NotificationCompat$MessagingStyle$Message messageFromBundle = getMessageFromBundle((Bundle)array[i]);
                if (messageFromBundle != null) {
                    list.add(messageFromBundle);
                }
            }
        }
        return list;
    }
    
    private Bundle toBundle() {
        final Bundle bundle = new Bundle();
        final CharSequence mText = this.mText;
        if (mText != null) {
            bundle.putCharSequence("text", mText);
        }
        bundle.putLong("time", this.mTimestamp);
        final CharSequence mSender = this.mSender;
        if (mSender != null) {
            bundle.putCharSequence("sender", mSender);
        }
        final String mDataMimeType = this.mDataMimeType;
        if (mDataMimeType != null) {
            bundle.putString("type", mDataMimeType);
        }
        final Uri mDataUri = this.mDataUri;
        if (mDataUri != null) {
            bundle.putParcelable("uri", (Parcelable)mDataUri);
        }
        return bundle;
    }
    
    public String getDataMimeType() {
        return this.mDataMimeType;
    }
    
    public Uri getDataUri() {
        return this.mDataUri;
    }
    
    public CharSequence getSender() {
        return this.mSender;
    }
    
    public CharSequence getText() {
        return this.mText;
    }
    
    public long getTimestamp() {
        return this.mTimestamp;
    }
    
    public NotificationCompat$MessagingStyle$Message setData(final String mDataMimeType, final Uri mDataUri) {
        this.mDataMimeType = mDataMimeType;
        this.mDataUri = mDataUri;
        return this;
    }
}
