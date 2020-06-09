// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

public class NotificationCompat$BigTextStyle extends NotificationCompat$Style
{
    CharSequence mBigText;
    
    public NotificationCompat$BigTextStyle() {
    }
    
    public NotificationCompat$BigTextStyle(final NotificationCompat$Builder builder) {
        this.setBuilder(builder);
    }
    
    public NotificationCompat$BigTextStyle bigText(final CharSequence charSequence) {
        this.mBigText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$BigTextStyle setBigContentTitle(final CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$BigTextStyle setSummaryText(final CharSequence charSequence) {
        this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
