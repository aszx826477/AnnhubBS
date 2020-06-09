// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.graphics.Bitmap;

public class NotificationCompat$BigPictureStyle extends NotificationCompat$Style
{
    Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    Bitmap mPicture;
    
    public NotificationCompat$BigPictureStyle() {
    }
    
    public NotificationCompat$BigPictureStyle(final NotificationCompat$Builder builder) {
        this.setBuilder(builder);
    }
    
    public NotificationCompat$BigPictureStyle bigLargeIcon(final Bitmap mBigLargeIcon) {
        this.mBigLargeIcon = mBigLargeIcon;
        this.mBigLargeIconSet = true;
        return this;
    }
    
    public NotificationCompat$BigPictureStyle bigPicture(final Bitmap mPicture) {
        this.mPicture = mPicture;
        return this;
    }
    
    public NotificationCompat$BigPictureStyle setBigContentTitle(final CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$BigPictureStyle setSummaryText(final CharSequence charSequence) {
        this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
