// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.lang.reflect.Method;
import android.app.ActionBar;
import android.util.Log;
import android.os.Build$VERSION;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.app.Activity;

class ActionBarDrawerToggleHoneycomb
{
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS;
    
    static {
        THEME_ATTRS = new int[] { 16843531 };
    }
    
    public static Drawable getThemeUpIndicator(final Activity activity) {
        final TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    public static Object setActionBarDescription(Object o, final Activity activity, final int n) {
        if (o == null) {
            o = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(activity);
        }
        final ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)o;
        if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                final ActionBar actionBar = activity.getActionBar();
                try {
                    final Method setHomeActionContentDescription = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription;
                    final Object[] array = { null };
                    try {
                        array[0] = n;
                        setHomeActionContentDescription.invoke(actionBar, array);
                        if (Build$VERSION.SDK_INT <= 19) {
                            actionBar.setSubtitle(actionBar.getSubtitle());
                        }
                        return o;
                    }
                    catch (Exception ex) {
                        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", (Throwable)ex);
                        return o;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        return o;
    }
    
    public static Object setActionBarUpIndicator(Object o, final Activity activity, final Drawable imageDrawable, final int n) {
        if (o == null) {
            o = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(activity);
        }
        final ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo = (ActionBarDrawerToggleHoneycomb$SetIndicatorInfo)o;
        if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                final ActionBar actionBar = activity.getActionBar();
                try {
                    final Method setHomeAsUpIndicator = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator;
                    final int n2 = 1;
                    final Object[] array = new Object[n2];
                    array[0] = imageDrawable;
                    setHomeAsUpIndicator.invoke(actionBar, array);
                    final Method setHomeActionContentDescription = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription;
                    try {
                        final Object[] array2 = new Object[n2];
                        try {
                            array2[0] = n;
                            setHomeActionContentDescription.invoke(actionBar, array2);
                            return o;
                        }
                        catch (Exception ex) {
                            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", (Throwable)ex);
                            return o;
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo.upIndicatorView != null) {
            actionBarDrawerToggleHoneycomb$SetIndicatorInfo.upIndicatorView.setImageDrawable(imageDrawable);
        }
        else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return o;
    }
}
