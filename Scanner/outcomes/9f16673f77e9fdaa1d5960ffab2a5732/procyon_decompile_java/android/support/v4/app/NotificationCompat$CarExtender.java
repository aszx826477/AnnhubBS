// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcelable;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.app.Notification;
import android.graphics.Bitmap;

public final class NotificationCompat$CarExtender implements NotificationCompat$Extender
{
    private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String TAG = "CarExtender";
    private int mColor;
    private Bitmap mLargeIcon;
    private NotificationCompat$CarExtender$UnreadConversation mUnreadConversation;
    
    public NotificationCompat$CarExtender() {
        this.mColor = 0;
    }
    
    public NotificationCompat$CarExtender(final Notification notification) {
        this.mColor = 0;
        if (Build$VERSION.SDK_INT < 21) {
            return;
        }
        Bundle bundle;
        if (NotificationCompat.getExtras(notification) == null) {
            bundle = null;
        }
        else {
            bundle = NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
        }
        if (bundle != null) {
            this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
            this.mColor = bundle.getInt("app_color", 0);
            this.mUnreadConversation = (NotificationCompat$CarExtender$UnreadConversation)NotificationCompat.IMPL.getUnreadConversationFromBundle(bundle.getBundle("car_conversation"), NotificationCompat$CarExtender$UnreadConversation.FACTORY, RemoteInput.FACTORY);
        }
    }
    
    public NotificationCompat$Builder extend(final NotificationCompat$Builder notificationCompat$Builder) {
        if (Build$VERSION.SDK_INT < 21) {
            return notificationCompat$Builder;
        }
        final Bundle bundle = new Bundle();
        final Bitmap mLargeIcon = this.mLargeIcon;
        if (mLargeIcon != null) {
            bundle.putParcelable("large_icon", (Parcelable)mLargeIcon);
        }
        final int mColor = this.mColor;
        if (mColor != 0) {
            bundle.putInt("app_color", mColor);
        }
        if (this.mUnreadConversation != null) {
            bundle.putBundle("car_conversation", NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
        }
        notificationCompat$Builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return notificationCompat$Builder;
    }
    
    public int getColor() {
        return this.mColor;
    }
    
    public Bitmap getLargeIcon() {
        return this.mLargeIcon;
    }
    
    public NotificationCompat$CarExtender$UnreadConversation getUnreadConversation() {
        return this.mUnreadConversation;
    }
    
    public NotificationCompat$CarExtender setColor(final int mColor) {
        this.mColor = mColor;
        return this;
    }
    
    public NotificationCompat$CarExtender setLargeIcon(final Bitmap mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
        return this;
    }
    
    public NotificationCompat$CarExtender setUnreadConversation(final NotificationCompat$CarExtender$UnreadConversation mUnreadConversation) {
        this.mUnreadConversation = mUnreadConversation;
        return this;
    }
}
