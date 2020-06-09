// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.PorterDuff$Mode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.util.Log;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.ScaleDrawable;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.DrawableContainer$DrawableContainerState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.graphics.Rect;

public class DrawableUtils
{
    public static final Rect INSETS_NONE;
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class sInsetsClazz;
    
    static {
        INSETS_NONE = new Rect();
        if (Build$VERSION.SDK_INT >= 18) {
            final String s = "android.graphics.Insets";
            try {
                final Class<?> forName = Class.forName(s);
                try {
                    DrawableUtils.sInsetsClazz = forName;
                }
                catch (ClassNotFoundException ex) {}
            }
            catch (ClassNotFoundException ex2) {}
        }
    }
    
    public static boolean canSafelyMutateDrawable(final Drawable drawable) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n = 15;
        if (sdk_INT < n && drawable instanceof InsetDrawable) {
            return false;
        }
        if (Build$VERSION.SDK_INT < n && drawable instanceof GradientDrawable) {
            return false;
        }
        if (Build$VERSION.SDK_INT < 17 && drawable instanceof LayerDrawable) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            final Drawable$ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer$DrawableContainerState) {
                final Drawable[] children = ((DrawableContainer$DrawableContainerState)constantState).getChildren();
                for (int length = children.length, i = 0; i < length; ++i) {
                    if (!canSafelyMutateDrawable(children[i])) {
                        return false;
                    }
                }
            }
        }
        else {
            if (drawable instanceof DrawableWrapper) {
                return canSafelyMutateDrawable(((DrawableWrapper)drawable).getWrappedDrawable());
            }
            if (drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper) {
                return canSafelyMutateDrawable(((android.support.v7.graphics.drawable.DrawableWrapper)drawable).getWrappedDrawable());
            }
            if (drawable instanceof ScaleDrawable) {
                return canSafelyMutateDrawable(((ScaleDrawable)drawable).getDrawable());
            }
        }
        return true;
    }
    
    static void fixDrawable(final Drawable drawable) {
        if (Build$VERSION.SDK_INT == 21) {
            if ("android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                fixVectorDrawableTinting(drawable);
            }
        }
    }
    
    private static void fixVectorDrawableTinting(final Drawable drawable) {
        final int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(ThemeUtils.EMPTY_STATE_SET);
        }
        else {
            drawable.setState(ThemeUtils.CHECKED_STATE_SET);
        }
        drawable.setState(state);
    }
    
    public static Rect getOpticalBounds(Drawable unwrap) {
        if (DrawableUtils.sInsetsClazz != null) {
            try {
                final Method method = (unwrap = DrawableCompat.unwrap(unwrap)).getClass().getMethod("getOpticalInsets", (Class<?>[])new Class[0]);
                try {
                    final Object invoke = method.invoke(unwrap, new Object[0]);
                    Label_0380: {
                        if (invoke == null) {
                            break Label_0380;
                        }
                        try {
                            final Rect rect = new Rect();
                            final Class sInsetsClazz = DrawableUtils.sInsetsClazz;
                            try {
                                final Field[] fields = sInsetsClazz.getFields();
                                try {
                                    final int length = fields.length;
                                    int n = 0;
                                    while (true) {
                                        if (n >= length) {
                                            return rect;
                                        }
                                        final Field field = fields[n];
                                        try {
                                            final String name = field.getName();
                                            try {
                                                final int hashCode = name.hashCode();
                                                int n2;
                                                if ((hashCode == -1383228885) ? name.equals("bottom") : ((hashCode == 115029) ? name.equals("top") : ((hashCode == 3317767) ? name.equals("left") : (hashCode == 108511772 && name.equals("right"))))) {
                                                    n2 = 2;
                                                }
                                                else {
                                                    n2 = -1;
                                                }
                                                switch (n2) {
                                                    case 3: {
                                                        rect.bottom = field.getInt(invoke);
                                                        break;
                                                    }
                                                    case 2: {
                                                        rect.right = field.getInt(invoke);
                                                        break;
                                                    }
                                                    case 1: {
                                                        rect.top = field.getInt(invoke);
                                                        break;
                                                    }
                                                    case 0: {
                                                        rect.left = field.getInt(invoke);
                                                        break;
                                                    }
                                                }
                                                ++n;
                                                continue;
                                                return DrawableUtils.INSETS_NONE;
                                            }
                                            catch (Exception ex) {
                                                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                                                return DrawableUtils.INSETS_NONE;
                                            }
                                        }
                                        catch (Exception ex2) {}
                                    }
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                        catch (Exception ex5) {}
                    }
                }
                catch (Exception ex6) {}
            }
            catch (Exception ex7) {}
        }
        return DrawableUtils.INSETS_NONE;
    }
    
    static PorterDuff$Mode parseTintMode(final int n, final PorterDuff$Mode porterDuff$Mode) {
        if (n == 3) {
            return PorterDuff$Mode.SRC_OVER;
        }
        if (n == 5) {
            return PorterDuff$Mode.SRC_IN;
        }
        if (n == 9) {
            return PorterDuff$Mode.SRC_ATOP;
        }
        switch (n) {
            default: {
                return porterDuff$Mode;
            }
            case 16: {
                PorterDuff$Mode value;
                if (Build$VERSION.SDK_INT >= 11) {
                    value = PorterDuff$Mode.valueOf("ADD");
                }
                else {
                    value = porterDuff$Mode;
                }
                return value;
            }
            case 15: {
                return PorterDuff$Mode.SCREEN;
            }
            case 14: {
                return PorterDuff$Mode.MULTIPLY;
            }
        }
    }
}
