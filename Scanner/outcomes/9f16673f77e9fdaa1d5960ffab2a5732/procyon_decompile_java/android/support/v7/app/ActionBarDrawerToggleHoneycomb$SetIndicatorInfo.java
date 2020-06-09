// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.app.ActionBar;
import android.app.Activity;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
{
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;
    
    ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(final Activity activity) {
        final int n = 1;
        final Class<ActionBar> clazz = ActionBar.class;
        final String s = "setHomeAsUpIndicator";
        try {
            final Class[] array = new Class[n];
            array[0] = Drawable.class;
            this.setHomeAsUpIndicator = clazz.getDeclaredMethod(s, (Class[])array);
            final Class<ActionBar> clazz2 = ActionBar.class;
            final String s2 = "setHomeActionContentDescription";
            final Class[] array2 = new Class[n];
            try {
                array2[0] = Integer.TYPE;
                this.setHomeActionContentDescription = clazz2.getDeclaredMethod(s2, (Class[])array2);
            }
            catch (NoSuchMethodException ex) {
                final int n2 = 16908332;
                final View viewById = activity.findViewById(n2);
                if (viewById == null) {
                    return;
                }
                final ViewGroup viewGroup = (ViewGroup)viewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                final View child = viewGroup.getChildAt(0);
                final View child2 = viewGroup.getChildAt(n);
                Object o;
                if (child.getId() == n2) {
                    o = child2;
                }
                else {
                    o = child;
                }
                if (o instanceof ImageView) {
                    this.upIndicatorView = (ImageView)o;
                }
            }
        }
        catch (NoSuchMethodException ex2) {}
    }
}
