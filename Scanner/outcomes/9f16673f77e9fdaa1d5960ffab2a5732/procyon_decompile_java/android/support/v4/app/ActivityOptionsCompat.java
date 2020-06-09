// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.support.v4.util.Pair;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.os.Build$VERSION;

public class ActivityOptionsCompat
{
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
    
    public static ActivityOptionsCompat makeBasic() {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic());
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic());
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeClipRevealAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(view, n, n2, n3, n4));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(view, n, n2, n3, n4));
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeCustomAnimation(final Context context, final int n, final int n2) {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(context, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(context, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(context, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, n, n2));
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeScaleUpAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(view, n, n2, n3, n4));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(view, n, n2, n3, n4));
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(view, n, n2, n3, n4));
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(view, n, n2, n3, n4));
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeSceneTransitionAnimation(final Activity activity, final View view, final String s) {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(activity, view, s));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(activity, view, s));
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, view, s));
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeSceneTransitionAnimation(final Activity activity, final Pair... array) {
        if (Build$VERSION.SDK_INT < 21) {
            return new ActivityOptionsCompat();
        }
        View[] array2 = null;
        String[] array3 = null;
        if (array != null) {
            array2 = new View[array.length];
            array3 = new String[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = (View)array[i].first;
                array3[i] = (String)array[i].second;
            }
        }
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(activity, array2, array3));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(activity, array2, array3));
        }
        return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, array2, array3));
    }
    
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind());
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind());
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind());
        }
        return new ActivityOptionsCompat();
    }
    
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(final View view, final Bitmap bitmap, final int n, final int n2) {
        if (Build$VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat$ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(view, bitmap, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat$ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(view, bitmap, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(view, bitmap, n, n2));
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(view, bitmap, n, n2));
        }
        return new ActivityOptionsCompat();
    }
    
    public Rect getLaunchBounds() {
        return null;
    }
    
    public void requestUsageTimeReport(final PendingIntent pendingIntent) {
    }
    
    public ActivityOptionsCompat setLaunchBounds(final Rect rect) {
        return null;
    }
    
    public Bundle toBundle() {
        return null;
    }
    
    public void update(final ActivityOptionsCompat activityOptionsCompat) {
    }
}
