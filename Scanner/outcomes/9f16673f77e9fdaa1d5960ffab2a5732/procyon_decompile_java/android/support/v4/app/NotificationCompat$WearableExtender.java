// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcelable;
import java.util.List;
import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import java.util.ArrayList;

public final class NotificationCompat$WearableExtender implements NotificationCompat$Extender
{
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = 255;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = 255;
    private ArrayList mActions;
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex;
    private int mContentIcon;
    private int mContentIconGravity;
    private int mCustomContentHeight;
    private int mCustomSizePreset;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags;
    private int mGravity;
    private int mHintScreenTimeout;
    private ArrayList mPages;
    
    public NotificationCompat$WearableExtender() {
        this.mActions = new ArrayList();
        this.mFlags = 1;
        this.mPages = new ArrayList();
        this.mContentIconGravity = 8388613;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
    }
    
    public NotificationCompat$WearableExtender(final Notification notification) {
        this.mActions = new ArrayList();
        final int mFlags = 1;
        this.mFlags = mFlags;
        this.mPages = new ArrayList();
        final int mContentIconGravity = 8388613;
        this.mContentIconGravity = mContentIconGravity;
        final int mContentActionIndex = -1;
        this.mContentActionIndex = mContentActionIndex;
        this.mCustomSizePreset = 0;
        final int mGravity = 80;
        this.mGravity = mGravity;
        final Bundle extras = NotificationCompat.getExtras(notification);
        Bundle bundle;
        if (extras != null) {
            bundle = extras.getBundle("android.wearable.EXTENSIONS");
        }
        else {
            bundle = null;
        }
        if (bundle != null) {
            final NotificationCompat$Action[] actionsFromParcelableArrayList = NotificationCompat.IMPL.getActionsFromParcelableArrayList(bundle.getParcelableArrayList("actions"));
            if (actionsFromParcelableArrayList != null) {
                Collections.addAll(this.mActions, actionsFromParcelableArrayList);
            }
            this.mFlags = bundle.getInt("flags", mFlags);
            this.mDisplayIntent = (PendingIntent)bundle.getParcelable("displayIntent");
            final Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, "pages");
            if (notificationArrayFromBundle != null) {
                Collections.addAll(this.mPages, notificationArrayFromBundle);
            }
            this.mBackground = (Bitmap)bundle.getParcelable("background");
            this.mContentIcon = bundle.getInt("contentIcon");
            this.mContentIconGravity = bundle.getInt("contentIconGravity", mContentIconGravity);
            this.mContentActionIndex = bundle.getInt("contentActionIndex", mContentActionIndex);
            this.mCustomSizePreset = bundle.getInt("customSizePreset", 0);
            this.mCustomContentHeight = bundle.getInt("customContentHeight");
            this.mGravity = bundle.getInt("gravity", mGravity);
            this.mHintScreenTimeout = bundle.getInt("hintScreenTimeout");
            this.mDismissalId = bundle.getString("dismissalId");
            this.mBridgeTag = bundle.getString("bridgeTag");
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
    
    public NotificationCompat$WearableExtender addAction(final NotificationCompat$Action notificationCompat$Action) {
        this.mActions.add(notificationCompat$Action);
        return this;
    }
    
    public NotificationCompat$WearableExtender addActions(final List list) {
        this.mActions.addAll(list);
        return this;
    }
    
    public NotificationCompat$WearableExtender addPage(final Notification notification) {
        this.mPages.add(notification);
        return this;
    }
    
    public NotificationCompat$WearableExtender addPages(final List list) {
        this.mPages.addAll(list);
        return this;
    }
    
    public NotificationCompat$WearableExtender clearActions() {
        this.mActions.clear();
        return this;
    }
    
    public NotificationCompat$WearableExtender clearPages() {
        this.mPages.clear();
        return this;
    }
    
    public NotificationCompat$WearableExtender clone() {
        final NotificationCompat$WearableExtender notificationCompat$WearableExtender = new NotificationCompat$WearableExtender();
        notificationCompat$WearableExtender.mActions = new ArrayList(this.mActions);
        notificationCompat$WearableExtender.mFlags = this.mFlags;
        notificationCompat$WearableExtender.mDisplayIntent = this.mDisplayIntent;
        notificationCompat$WearableExtender.mPages = new ArrayList(this.mPages);
        notificationCompat$WearableExtender.mBackground = this.mBackground;
        notificationCompat$WearableExtender.mContentIcon = this.mContentIcon;
        notificationCompat$WearableExtender.mContentIconGravity = this.mContentIconGravity;
        notificationCompat$WearableExtender.mContentActionIndex = this.mContentActionIndex;
        notificationCompat$WearableExtender.mCustomSizePreset = this.mCustomSizePreset;
        notificationCompat$WearableExtender.mCustomContentHeight = this.mCustomContentHeight;
        notificationCompat$WearableExtender.mGravity = this.mGravity;
        notificationCompat$WearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
        notificationCompat$WearableExtender.mDismissalId = this.mDismissalId;
        notificationCompat$WearableExtender.mBridgeTag = this.mBridgeTag;
        return notificationCompat$WearableExtender;
    }
    
    public NotificationCompat$Builder extend(final NotificationCompat$Builder notificationCompat$Builder) {
        final Bundle bundle = new Bundle();
        if (!this.mActions.isEmpty()) {
            final String s = "actions";
            final NotificationCompat$NotificationCompatImpl impl = NotificationCompat.IMPL;
            final ArrayList mActions = this.mActions;
            bundle.putParcelableArrayList(s, impl.getParcelableArrayListForActions(mActions.toArray(new NotificationCompat$Action[mActions.size()])));
        }
        final int mFlags = this.mFlags;
        if (mFlags != 1) {
            bundle.putInt("flags", mFlags);
        }
        final PendingIntent mDisplayIntent = this.mDisplayIntent;
        if (mDisplayIntent != null) {
            bundle.putParcelable("displayIntent", (Parcelable)mDisplayIntent);
        }
        if (!this.mPages.isEmpty()) {
            final String s2 = "pages";
            final ArrayList mPages = this.mPages;
            bundle.putParcelableArray(s2, (Parcelable[])mPages.toArray(new Notification[mPages.size()]));
        }
        final Bitmap mBackground = this.mBackground;
        if (mBackground != null) {
            bundle.putParcelable("background", (Parcelable)mBackground);
        }
        final int mContentIcon = this.mContentIcon;
        if (mContentIcon != 0) {
            bundle.putInt("contentIcon", mContentIcon);
        }
        final int mContentIconGravity = this.mContentIconGravity;
        if (mContentIconGravity != 8388613) {
            bundle.putInt("contentIconGravity", mContentIconGravity);
        }
        final int mContentActionIndex = this.mContentActionIndex;
        if (mContentActionIndex != -1) {
            bundle.putInt("contentActionIndex", mContentActionIndex);
        }
        final int mCustomSizePreset = this.mCustomSizePreset;
        if (mCustomSizePreset != 0) {
            bundle.putInt("customSizePreset", mCustomSizePreset);
        }
        final int mCustomContentHeight = this.mCustomContentHeight;
        if (mCustomContentHeight != 0) {
            bundle.putInt("customContentHeight", mCustomContentHeight);
        }
        final int mGravity = this.mGravity;
        if (mGravity != 80) {
            bundle.putInt("gravity", mGravity);
        }
        final int mHintScreenTimeout = this.mHintScreenTimeout;
        if (mHintScreenTimeout != 0) {
            bundle.putInt("hintScreenTimeout", mHintScreenTimeout);
        }
        final String mDismissalId = this.mDismissalId;
        if (mDismissalId != null) {
            bundle.putString("dismissalId", mDismissalId);
        }
        final String mBridgeTag = this.mBridgeTag;
        if (mBridgeTag != null) {
            bundle.putString("bridgeTag", mBridgeTag);
        }
        notificationCompat$Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return notificationCompat$Builder;
    }
    
    public List getActions() {
        return this.mActions;
    }
    
    public Bitmap getBackground() {
        return this.mBackground;
    }
    
    public String getBridgeTag() {
        return this.mBridgeTag;
    }
    
    public int getContentAction() {
        return this.mContentActionIndex;
    }
    
    public int getContentIcon() {
        return this.mContentIcon;
    }
    
    public int getContentIconGravity() {
        return this.mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline() {
        final int mFlags = this.mFlags;
        boolean b = true;
        if ((mFlags & (b ? 1 : 0)) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public int getCustomContentHeight() {
        return this.mCustomContentHeight;
    }
    
    public int getCustomSizePreset() {
        return this.mCustomSizePreset;
    }
    
    public String getDismissalId() {
        return this.mDismissalId;
    }
    
    public PendingIntent getDisplayIntent() {
        return this.mDisplayIntent;
    }
    
    public int getGravity() {
        return this.mGravity;
    }
    
    public boolean getHintAmbientBigPicture() {
        return (this.mFlags & 0x20) != 0x0;
    }
    
    public boolean getHintAvoidBackgroundClipping() {
        return (this.mFlags & 0x10) != 0x0;
    }
    
    public boolean getHintContentIntentLaunchesActivity() {
        return (this.mFlags & 0x40) != 0x0;
    }
    
    public boolean getHintHideIcon() {
        return (this.mFlags & 0x2) != 0x0;
    }
    
    public int getHintScreenTimeout() {
        return this.mHintScreenTimeout;
    }
    
    public boolean getHintShowBackgroundOnly() {
        return (this.mFlags & 0x4) != 0x0;
    }
    
    public List getPages() {
        return this.mPages;
    }
    
    public boolean getStartScrollBottom() {
        return (this.mFlags & 0x8) != 0x0;
    }
    
    public NotificationCompat$WearableExtender setBackground(final Bitmap mBackground) {
        this.mBackground = mBackground;
        return this;
    }
    
    public NotificationCompat$WearableExtender setBridgeTag(final String mBridgeTag) {
        this.mBridgeTag = mBridgeTag;
        return this;
    }
    
    public NotificationCompat$WearableExtender setContentAction(final int mContentActionIndex) {
        this.mContentActionIndex = mContentActionIndex;
        return this;
    }
    
    public NotificationCompat$WearableExtender setContentIcon(final int mContentIcon) {
        this.mContentIcon = mContentIcon;
        return this;
    }
    
    public NotificationCompat$WearableExtender setContentIconGravity(final int mContentIconGravity) {
        this.mContentIconGravity = mContentIconGravity;
        return this;
    }
    
    public NotificationCompat$WearableExtender setContentIntentAvailableOffline(final boolean b) {
        this.setFlag(1, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setCustomContentHeight(final int mCustomContentHeight) {
        this.mCustomContentHeight = mCustomContentHeight;
        return this;
    }
    
    public NotificationCompat$WearableExtender setCustomSizePreset(final int mCustomSizePreset) {
        this.mCustomSizePreset = mCustomSizePreset;
        return this;
    }
    
    public NotificationCompat$WearableExtender setDismissalId(final String mDismissalId) {
        this.mDismissalId = mDismissalId;
        return this;
    }
    
    public NotificationCompat$WearableExtender setDisplayIntent(final PendingIntent mDisplayIntent) {
        this.mDisplayIntent = mDisplayIntent;
        return this;
    }
    
    public NotificationCompat$WearableExtender setGravity(final int mGravity) {
        this.mGravity = mGravity;
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintAmbientBigPicture(final boolean b) {
        this.setFlag(32, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(final boolean b) {
        this.setFlag(16, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintContentIntentLaunchesActivity(final boolean b) {
        this.setFlag(64, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintHideIcon(final boolean b) {
        this.setFlag(2, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintScreenTimeout(final int mHintScreenTimeout) {
        this.mHintScreenTimeout = mHintScreenTimeout;
        return this;
    }
    
    public NotificationCompat$WearableExtender setHintShowBackgroundOnly(final boolean b) {
        this.setFlag(4, b);
        return this;
    }
    
    public NotificationCompat$WearableExtender setStartScrollBottom(final boolean b) {
        this.setFlag(8, b);
        return this;
    }
}
