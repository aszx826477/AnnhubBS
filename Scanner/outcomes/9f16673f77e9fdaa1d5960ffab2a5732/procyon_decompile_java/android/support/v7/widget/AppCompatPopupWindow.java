// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v4.widget.PopupWindowCompat;
import java.lang.reflect.Field;
import android.util.Log;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.PopupWindow;

class AppCompatPopupWindow extends PopupWindow
{
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private static final String TAG = "AppCompatPopupWindow";
    private boolean mOverlapAnchor;
    
    public AppCompatPopupWindow(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init(context, set, n, 0);
    }
    
    public AppCompatPopupWindow(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.init(context, set, n, n2);
    }
    
    private void init(final Context context, final AttributeSet set, final int n, final int n2) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.PopupWindow, n, n2);
        if (obtainStyledAttributes.hasValue(R$styleable.PopupWindow_overlapAnchor)) {
            this.setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(R$styleable.PopupWindow_overlapAnchor, false));
        }
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R$styleable.PopupWindow_android_popupBackground));
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (n2 != 0 && sdk_INT < 11) {
            if (obtainStyledAttributes.hasValue(R$styleable.PopupWindow_android_popupAnimationStyle)) {
                this.setAnimationStyle(obtainStyledAttributes.getResourceId(R$styleable.PopupWindow_android_popupAnimationStyle, -1));
            }
        }
        obtainStyledAttributes.recycle();
        if (Build$VERSION.SDK_INT < 14) {
            wrapOnScrollChangedListener(this);
        }
    }
    
    private static void wrapOnScrollChangedListener(final PopupWindow popupWindow) {
        final Class<PopupWindow> clazz = PopupWindow.class;
        final String s = "mAnchor";
        final Class<PopupWindow> clazz2 = clazz;
        try {
            final Field declaredField = clazz2.getDeclaredField(s);
            final boolean b = true;
            declaredField.setAccessible(b);
            final Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(b);
            final Field field = declaredField2;
            try {
                final Object value = field.get(popupWindow);
                try {
                    final ViewTreeObserver$OnScrollChangedListener viewTreeObserver$OnScrollChangedListener = (ViewTreeObserver$OnScrollChangedListener)value;
                    try {
                        declaredField2.set(popupWindow, new AppCompatPopupWindow$1(declaredField, popupWindow, viewTreeObserver$OnScrollChangedListener));
                    }
                    catch (Exception ex) {
                        Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", (Throwable)ex);
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
    
    public boolean getSupportOverlapAnchor() {
        if (AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) {
            return this.mOverlapAnchor;
        }
        return PopupWindowCompat.getOverlapAnchor(this);
    }
    
    public void setSupportOverlapAnchor(final boolean mOverlapAnchor) {
        if (AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = mOverlapAnchor;
        }
        else {
            PopupWindowCompat.setOverlapAnchor(this, mOverlapAnchor);
        }
    }
    
    public void showAsDropDown(final View view, final int n, int n2) {
        if (AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.showAsDropDown(view, n, n2);
    }
    
    public void showAsDropDown(final View view, final int n, int n2, final int n3) {
        if (AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.showAsDropDown(view, n, n2, n3);
    }
    
    public void update(final View view, final int n, int n2, final int n3, final int n4) {
        if (AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.update(view, n, n2, n3, n4);
    }
}
