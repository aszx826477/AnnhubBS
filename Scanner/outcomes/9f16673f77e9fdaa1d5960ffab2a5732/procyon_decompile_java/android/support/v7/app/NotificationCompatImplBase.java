// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v7.appcompat.R$layout;
import android.app.PendingIntent;
import java.util.List;
import android.support.v7.appcompat.R$color;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Bitmap$Config;
import android.support.v4.app.NotificationCompat$Action;
import java.util.ArrayList;
import android.content.res.Resources;
import android.os.SystemClock;
import java.text.NumberFormat;
import android.support.v7.appcompat.R$string;
import android.support.v7.appcompat.R$integer;
import android.support.v7.appcompat.R$dimen;
import android.support.v7.appcompat.R$drawable;
import android.support.v7.appcompat.R$id;
import android.os.Build$VERSION;
import android.widget.RemoteViews;
import android.graphics.Bitmap;
import android.content.Context;

class NotificationCompatImplBase
{
    private static final int MAX_ACTION_BUTTONS = 3;
    static final int MAX_MEDIA_BUTTONS = 5;
    static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    
    public static RemoteViews applyStandardTemplate(final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final int n2, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n3, final int n4, final int n5, final int n6, final boolean b2) {
        final Resources resources = context.getResources();
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), n6);
        final boolean b3 = n4 < -1;
        if (Build$VERSION.SDK_INT >= 16 && Build$VERSION.SDK_INT < 21) {
            if (b3) {
                remoteViews.setInt(R$id.notification_background, "setBackgroundResource", R$drawable.notification_bg_low);
                remoteViews.setInt(R$id.icon, "setBackgroundResource", R$drawable.notification_template_icon_low_bg);
            }
            else {
                remoteViews.setInt(R$id.notification_background, "setBackgroundResource", R$drawable.notification_bg);
                remoteViews.setInt(R$id.icon, "setBackgroundResource", R$drawable.notification_template_icon_bg);
            }
        }
        final int n7 = 8;
        if (bitmap != null) {
            if (Build$VERSION.SDK_INT >= 16) {
                remoteViews.setViewVisibility(R$id.icon, 0);
                remoteViews.setImageViewBitmap(R$id.icon, bitmap);
            }
            else {
                remoteViews.setViewVisibility(R$id.icon, n7);
            }
            if (n2 != 0) {
                final int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_right_icon_size);
                final int n8 = dimensionPixelSize - resources.getDimensionPixelSize(R$dimen.notification_small_icon_background_padding) * 2;
                if (Build$VERSION.SDK_INT >= 21) {
                    remoteViews.setImageViewBitmap(R$id.right_icon, createIconWithBackground(context, n2, dimensionPixelSize, n8, n5));
                }
                else {
                    remoteViews.setImageViewBitmap(R$id.right_icon, createColoredBitmap(context, n2, -1));
                }
                remoteViews.setViewVisibility(R$id.right_icon, 0);
            }
        }
        else if (n2 != 0) {
            remoteViews.setViewVisibility(R$id.icon, 0);
            if (Build$VERSION.SDK_INT >= 21) {
                remoteViews.setImageViewBitmap(R$id.icon, createIconWithBackground(context, n2, resources.getDimensionPixelSize(R$dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R$dimen.notification_big_circle_margin), resources.getDimensionPixelSize(R$dimen.notification_small_icon_size_as_large), n5));
            }
            else {
                remoteViews.setImageViewBitmap(R$id.icon, createColoredBitmap(context, n2, -1));
            }
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(R$id.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(R$id.text, charSequence2);
            final boolean b4 = true;
        }
        else {
            final boolean b4 = false;
        }
        boolean b5 = Build$VERSION.SDK_INT < 21 && bitmap != null;
        boolean b4;
        if (charSequence3 != null) {
            remoteViews.setTextViewText(R$id.info, charSequence3);
            remoteViews.setViewVisibility(R$id.info, 0);
            b4 = true;
            b5 = true;
        }
        else if (n > 0) {
            if (n > resources.getInteger(R$integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(R$id.info, (CharSequence)resources.getString(R$string.status_bar_notification_info_overflow));
            }
            else {
                remoteViews.setTextViewText(R$id.info, (CharSequence)NumberFormat.getIntegerInstance().format(n));
            }
            remoteViews.setViewVisibility(R$id.info, 0);
            b4 = true;
            b5 = true;
        }
        else {
            remoteViews.setViewVisibility(R$id.info, 8);
        }
        boolean b6 = false;
        Label_1009: {
            if (charSequence4 != null && Build$VERSION.SDK_INT >= 16) {
                remoteViews.setTextViewText(R$id.text, charSequence4);
                if (charSequence2 != null) {
                    remoteViews.setTextViewText(R$id.text2, charSequence2);
                    remoteViews.setViewVisibility(R$id.text2, 0);
                    b6 = true;
                    break Label_1009;
                }
                remoteViews.setViewVisibility(R$id.text2, 8);
            }
            b6 = false;
        }
        if (b6 && Build$VERSION.SDK_INT >= 16) {
            if (b2) {
                remoteViews.setTextViewTextSize(R$id.text, 0, (float)resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
        }
        int n9;
        if (n3 != 0L) {
            if (b && Build$VERSION.SDK_INT >= 16) {
                remoteViews.setViewVisibility(R$id.chronometer, 0);
                remoteViews.setLong(R$id.chronometer, "setBase", n3 + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                remoteViews.setBoolean(R$id.chronometer, "setStarted", true);
                n9 = 0;
            }
            else {
                final int time = R$id.time;
                n9 = 0;
                remoteViews.setViewVisibility(time, 0);
                remoteViews.setLong(R$id.time, "setTime", n3);
            }
            b5 = true;
        }
        else {
            n9 = 0;
        }
        final int right_side = R$id.right_side;
        int n10;
        if (b5) {
            n10 = 0;
        }
        else {
            n10 = 8;
        }
        remoteViews.setViewVisibility(right_side, n10);
        final int line3 = R$id.line3;
        if (!b4) {
            n9 = 8;
        }
        remoteViews.setViewVisibility(line3, n9);
        return remoteViews;
    }
    
    public static RemoteViews applyStandardTemplateWithActions(final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final int n2, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n3, final int n4, final int n5, final int n6, final boolean b2, final ArrayList list) {
        final RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, n, n2, bitmap, charSequence4, b, n3, n4, n5, n6, b2);
        applyStandardTemplate.removeAllViews(R$id.actions);
        boolean b3 = false;
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                b3 = true;
                if (size > 3) {
                    size = 3;
                }
                for (int i = 0; i < size; ++i) {
                    applyStandardTemplate.addView(R$id.actions, generateActionButton(context, list.get(i)));
                }
            }
        }
        int n7;
        if (b3) {
            n7 = 0;
        }
        else {
            n7 = 8;
        }
        applyStandardTemplate.setViewVisibility(R$id.actions, n7);
        applyStandardTemplate.setViewVisibility(R$id.action_divider, n7);
        return applyStandardTemplate;
    }
    
    public static void buildIntoRemoteViews(final Context context, final RemoteViews remoteViews, final RemoteViews remoteViews2) {
        hideNormalContent(remoteViews);
        remoteViews.removeAllViews(R$id.notification_main_column);
        remoteViews.addView(R$id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R$id.notification_main_column, 0);
        if (Build$VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(R$id.notification_main_column_container, 0, calculateTopPadding(context), 0, 0);
        }
    }
    
    public static int calculateTopPadding(final Context context) {
        final int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.notification_top_pad);
        final int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.notification_top_pad_large_text);
        final float fontScale = context.getResources().getConfiguration().fontScale;
        final float n = 1.0f;
        final float n2 = (constrain(fontScale, n, 1.3f) - n) / 0.29999995f;
        return Math.round((n - n2) * dimensionPixelSize + dimensionPixelSize2 * n2);
    }
    
    public static float constrain(final float n, final float n2, final float n3) {
        float n4;
        if (n < n2) {
            n4 = n2;
        }
        else if (n > n3) {
            n4 = n3;
        }
        else {
            n4 = n;
        }
        return n4;
    }
    
    private static Bitmap createColoredBitmap(final Context context, final int n, final int n2) {
        return createColoredBitmap(context, n, n2, 0);
    }
    
    private static Bitmap createColoredBitmap(final Context context, final int n, final int n2, final int n3) {
        final Drawable drawable = context.getResources().getDrawable(n);
        int intrinsicWidth;
        if (n3 == 0) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        else {
            intrinsicWidth = n3;
        }
        int intrinsicHeight;
        if (n3 == 0) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        else {
            intrinsicHeight = n3;
        }
        final Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap$Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        if (n2 != 0) {
            drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(n2, PorterDuff$Mode.SRC_IN));
        }
        drawable.draw(new Canvas(bitmap));
        return bitmap;
    }
    
    public static Bitmap createIconWithBackground(final Context context, final int n, final int n2, final int n3, final int n4) {
        final int notification_icon_background = R$drawable.notification_icon_background;
        int n5;
        if (n4 == 0) {
            n5 = 0;
        }
        else {
            n5 = n4;
        }
        final Bitmap coloredBitmap = createColoredBitmap(context, notification_icon_background, n5, n2);
        final Canvas canvas = new Canvas(coloredBitmap);
        final Drawable mutate = context.getResources().getDrawable(n).mutate();
        mutate.setFilterBitmap(true);
        final int n6 = (n2 - n3) / 2;
        mutate.setBounds(n6, n6, n3 + n6, n3 + n6);
        mutate.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff$Mode.SRC_ATOP));
        mutate.draw(canvas);
        return coloredBitmap;
    }
    
    private static RemoteViews generateActionButton(final Context context, final NotificationCompat$Action notificationCompat$Action) {
        final boolean b = notificationCompat$Action.actionIntent == null;
        final String packageName = context.getPackageName();
        int n;
        if (b) {
            n = getActionTombstoneLayoutResource();
        }
        else {
            n = getActionLayoutResource();
        }
        final RemoteViews remoteViews = new RemoteViews(packageName, n);
        remoteViews.setImageViewBitmap(R$id.action_image, createColoredBitmap(context, notificationCompat$Action.getIcon(), context.getResources().getColor(R$color.notification_action_color_filter)));
        remoteViews.setTextViewText(R$id.action_text, notificationCompat$Action.title);
        if (!b) {
            remoteViews.setOnClickPendingIntent(R$id.action_container, notificationCompat$Action.actionIntent);
        }
        if (Build$VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R$id.action_container, notificationCompat$Action.title);
        }
        return remoteViews;
    }
    
    private static RemoteViews generateContentViewMedia(final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n2, final int n3, final List list, final int[] array, final boolean b2, final PendingIntent pendingIntent, final boolean b3) {
        int n4;
        if (b3) {
            n4 = R$layout.notification_template_media_custom;
        }
        else {
            n4 = R$layout.notification_template_media;
        }
        final RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, n, 0, bitmap, charSequence4, b, n2, n3, 0, n4, true);
        final int size = list.size();
        int min;
        if (array == null) {
            min = 0;
        }
        else {
            min = Math.min(array.length, 3);
        }
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i = 0; i < min; ++i) {
                if (i >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", i, size - 1));
                }
                applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(context, list.get(array[i])));
            }
        }
        final int n5 = 8;
        if (b2) {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, n5);
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(R$id.cancel_action, pendingIntent);
            applyStandardTemplate.setInt(R$id.cancel_action, "setAlpha", context.getResources().getInteger(R$integer.cancel_button_image_alpha));
        }
        else {
            applyStandardTemplate.setViewVisibility(R$id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, n5);
        }
        return applyStandardTemplate;
    }
    
    private static RemoteViews generateMediaActionButton(final Context context, final NotificationCompatBase$Action notificationCompatBase$Action) {
        final boolean b = notificationCompatBase$Action.getActionIntent() == null;
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R$layout.notification_media_action);
        remoteViews.setImageViewResource(R$id.action0, notificationCompatBase$Action.getIcon());
        if (!b) {
            remoteViews.setOnClickPendingIntent(R$id.action0, notificationCompatBase$Action.getActionIntent());
        }
        if (Build$VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R$id.action0, notificationCompatBase$Action.getTitle());
        }
        return remoteViews;
    }
    
    public static RemoteViews generateMediaBigView(final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n2, final int n3, final int n4, final List list, final boolean b2, final PendingIntent pendingIntent, final boolean b3) {
        final int min = Math.min(list.size(), 5);
        final RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, n, 0, bitmap, charSequence4, b, n2, n3, n4, getBigMediaLayoutResource(b3, min), false);
        applyStandardTemplate.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i = 0; i < min; ++i) {
                applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(context, list.get(i)));
            }
        }
        if (b2) {
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 0);
            applyStandardTemplate.setInt(R$id.cancel_action, "setAlpha", context.getResources().getInteger(R$integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(R$id.cancel_action, pendingIntent);
        }
        else {
            applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }
    
    private static int getActionLayoutResource() {
        return R$layout.notification_action;
    }
    
    private static int getActionTombstoneLayoutResource() {
        return R$layout.notification_action_tombstone;
    }
    
    private static int getBigMediaLayoutResource(final boolean b, final int n) {
        if (n <= 3) {
            int n2;
            if (b) {
                n2 = R$layout.notification_template_big_media_narrow_custom;
            }
            else {
                n2 = R$layout.notification_template_big_media_narrow;
            }
            return n2;
        }
        int n3;
        if (b) {
            n3 = R$layout.notification_template_big_media_custom;
        }
        else {
            n3 = R$layout.notification_template_big_media;
        }
        return n3;
    }
    
    private static void hideNormalContent(final RemoteViews remoteViews) {
        final int title = R$id.title;
        final int n = 8;
        remoteViews.setViewVisibility(title, n);
        remoteViews.setViewVisibility(R$id.text2, n);
        remoteViews.setViewVisibility(R$id.text, n);
    }
    
    public static RemoteViews overrideContentViewMedia(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n2, final int n3, final List list, final int[] array, final boolean b2, final PendingIntent pendingIntent, final boolean b3) {
        final RemoteViews generateContentViewMedia = generateContentViewMedia(context, charSequence, charSequence2, charSequence3, n, bitmap, charSequence4, b, n2, n3, list, array, b2, pendingIntent, b3);
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(generateContentViewMedia);
        if (b2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
        return generateContentViewMedia;
    }
    
    public static void overrideMediaBigContentView(final Notification notification, final Context context, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final Bitmap bitmap, final CharSequence charSequence4, final boolean b, final long n2, final int n3, final int n4, final List list, final boolean b2, final PendingIntent pendingIntent, final boolean b3) {
        notification.bigContentView = generateMediaBigView(context, charSequence, charSequence2, charSequence3, n, bitmap, charSequence4, b, n2, n3, n4, list, b2, pendingIntent, b3);
        if (b2) {
            notification.flags |= 0x2;
        }
    }
}
