// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;

public final class NotificationCompat$Action$WearableExtender implements NotificationCompat$Action$Extender
{
    private static final int DEFAULT_FLAGS = 1;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_DISPLAY_INLINE = 4;
    private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    private CharSequence mCancelLabel;
    private CharSequence mConfirmLabel;
    private int mFlags;
    private CharSequence mInProgressLabel;
    
    public NotificationCompat$Action$WearableExtender() {
        this.mFlags = 1;
    }
    
    public NotificationCompat$Action$WearableExtender(final NotificationCompat$Action notificationCompat$Action) {
        final int mFlags = 1;
        this.mFlags = mFlags;
        final Bundle bundle = notificationCompat$Action.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (bundle != null) {
            this.mFlags = bundle.getInt("flags", mFlags);
            this.mInProgressLabel = bundle.getCharSequence("inProgressLabel");
            this.mConfirmLabel = bundle.getCharSequence("confirmLabel");
            this.mCancelLabel = bundle.getCharSequence("cancelLabel");
        }
    }
    
    private void setFlag(final int n, final boolean b) {
        if (b) {
            this.mFlags |= n;
        }
        else {
            this.mFlags &= ~n;
        }
    }
    
    public NotificationCompat$Action$WearableExtender clone() {
        final NotificationCompat$Action$WearableExtender notificationCompat$Action$WearableExtender = new NotificationCompat$Action$WearableExtender();
        notificationCompat$Action$WearableExtender.mFlags = this.mFlags;
        notificationCompat$Action$WearableExtender.mInProgressLabel = this.mInProgressLabel;
        notificationCompat$Action$WearableExtender.mConfirmLabel = this.mConfirmLabel;
        notificationCompat$Action$WearableExtender.mCancelLabel = this.mCancelLabel;
        return notificationCompat$Action$WearableExtender;
    }
    
    public NotificationCompat$Action$Builder extend(final NotificationCompat$Action$Builder notificationCompat$Action$Builder) {
        final Bundle bundle = new Bundle();
        final int mFlags = this.mFlags;
        if (mFlags != 1) {
            bundle.putInt("flags", mFlags);
        }
        final CharSequence mInProgressLabel = this.mInProgressLabel;
        if (mInProgressLabel != null) {
            bundle.putCharSequence("inProgressLabel", mInProgressLabel);
        }
        final CharSequence mConfirmLabel = this.mConfirmLabel;
        if (mConfirmLabel != null) {
            bundle.putCharSequence("confirmLabel", mConfirmLabel);
        }
        final CharSequence mCancelLabel = this.mCancelLabel;
        if (mCancelLabel != null) {
            bundle.putCharSequence("cancelLabel", mCancelLabel);
        }
        notificationCompat$Action$Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return notificationCompat$Action$Builder;
    }
    
    public CharSequence getCancelLabel() {
        return this.mCancelLabel;
    }
    
    public CharSequence getConfirmLabel() {
        return this.mConfirmLabel;
    }
    
    public boolean getHintDisplayActionInline() {
        return (this.mFlags & 0x4) != 0x0;
    }
    
    public boolean getHintLaunchesActivity() {
        return (this.mFlags & 0x2) != 0x0;
    }
    
    public CharSequence getInProgressLabel() {
        return this.mInProgressLabel;
    }
    
    public boolean isAvailableOffline() {
        final int mFlags = this.mFlags;
        boolean b = true;
        if ((mFlags & (b ? 1 : 0)) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public NotificationCompat$Action$WearableExtender setAvailableOffline(final boolean b) {
        this.setFlag(1, b);
        return this;
    }
    
    public NotificationCompat$Action$WearableExtender setCancelLabel(final CharSequence mCancelLabel) {
        this.mCancelLabel = mCancelLabel;
        return this;
    }
    
    public NotificationCompat$Action$WearableExtender setConfirmLabel(final CharSequence mConfirmLabel) {
        this.mConfirmLabel = mConfirmLabel;
        return this;
    }
    
    public NotificationCompat$Action$WearableExtender setHintDisplayActionInline(final boolean b) {
        this.setFlag(4, b);
        return this;
    }
    
    public NotificationCompat$Action$WearableExtender setHintLaunchesActivity(final boolean b) {
        this.setFlag(2, b);
        return this;
    }
    
    public NotificationCompat$Action$WearableExtender setInProgressLabel(final CharSequence mInProgressLabel) {
        this.mInProgressLabel = mInProgressLabel;
        return this;
    }
}
