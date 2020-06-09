// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewParent;
import android.view.WindowManager;
import android.view.Display;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.View;
import java.lang.reflect.Field;

class ViewCompatBase
{
    private static final String TAG = "ViewCompatBase";
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    
    static ColorStateList getBackgroundTintList(final View view) {
        ColorStateList supportBackgroundTintList;
        if (view instanceof TintableBackgroundView) {
            supportBackgroundTintList = ((TintableBackgroundView)view).getSupportBackgroundTintList();
        }
        else {
            supportBackgroundTintList = null;
        }
        return supportBackgroundTintList;
    }
    
    static PorterDuff$Mode getBackgroundTintMode(final View view) {
        PorterDuff$Mode supportBackgroundTintMode;
        if (view instanceof TintableBackgroundView) {
            supportBackgroundTintMode = ((TintableBackgroundView)view).getSupportBackgroundTintMode();
        }
        else {
            supportBackgroundTintMode = null;
        }
        return supportBackgroundTintMode;
    }
    
    static Display getDisplay(final View view) {
        if (isAttachedToWindow(view)) {
            return ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }
    
    static int getMinimumHeight(final View view) {
        if (!ViewCompatBase.sMinHeightFieldFetched) {
            final boolean b = true;
            final Class<View> clazz = View.class;
            final String s = "mMinHeight";
            final Class<View> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (ViewCompatBase.sMinHeightField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {}
            }
            catch (NoSuchFieldException ex2) {}
            ViewCompatBase.sMinHeightFieldFetched = b;
        }
        final Field sMinHeightField = ViewCompatBase.sMinHeightField;
        if (sMinHeightField != null) {
            final Field field = sMinHeightField;
            try {
                final Object value = field.get(view);
                try {
                    final Integer n = (Integer)value;
                    try {
                        return n;
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
        return 0;
    }
    
    static int getMinimumWidth(final View view) {
        if (!ViewCompatBase.sMinWidthFieldFetched) {
            final boolean b = true;
            final Class<View> clazz = View.class;
            final String s = "mMinWidth";
            final Class<View> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (ViewCompatBase.sMinWidthField = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {}
            }
            catch (NoSuchFieldException ex2) {}
            ViewCompatBase.sMinWidthFieldFetched = b;
        }
        final Field sMinWidthField = ViewCompatBase.sMinWidthField;
        if (sMinWidthField != null) {
            final Field field = sMinWidthField;
            try {
                final Object value = field.get(view);
                try {
                    final Integer n = (Integer)value;
                    try {
                        return n;
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
        return 0;
    }
    
    static boolean isAttachedToWindow(final View view) {
        return view.getWindowToken() != null;
    }
    
    static boolean isLaidOut(final View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }
    
    static void offsetLeftAndRight(final View view, final int n) {
        final int left = view.getLeft();
        view.offsetLeftAndRight(n);
        if (n != 0) {
            final ViewParent parent = view.getParent();
            if (parent instanceof View) {
                final int abs = Math.abs(n);
                ((View)parent).invalidate(left - abs, view.getTop(), view.getWidth() + left + abs, view.getBottom());
            }
            else {
                view.invalidate();
            }
        }
    }
    
    static void offsetTopAndBottom(final View view, final int n) {
        final int top = view.getTop();
        view.offsetTopAndBottom(n);
        if (n != 0) {
            final ViewParent parent = view.getParent();
            if (parent instanceof View) {
                final int abs = Math.abs(n);
                ((View)parent).invalidate(view.getLeft(), top - abs, view.getRight(), view.getHeight() + top + abs);
            }
            else {
                view.invalidate();
            }
        }
    }
    
    static void setBackgroundTintList(final View view, final ColorStateList supportBackgroundTintList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView)view).setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    static void setBackgroundTintMode(final View view, final PorterDuff$Mode supportBackgroundTintMode) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView)view).setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
}
