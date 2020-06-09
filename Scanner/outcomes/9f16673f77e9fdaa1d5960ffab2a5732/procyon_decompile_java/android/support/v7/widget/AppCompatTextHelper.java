// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.text.method.TransformationMethod;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.TextView;

class AppCompatTextHelper
{
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableTopTint;
    final TextView mView;
    
    AppCompatTextHelper(final TextView mView) {
        this.mView = mView;
    }
    
    static AppCompatTextHelper create(final TextView textView) {
        if (Build$VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }
    
    protected static TintInfo createTintInfo(final Context context, final AppCompatDrawableManager appCompatDrawableManager, final int n) {
        final ColorStateList tintList = appCompatDrawableManager.getTintList(context, n);
        if (tintList != null) {
            final TintInfo tintInfo = new TintInfo();
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = tintList;
            return tintInfo;
        }
        return null;
    }
    
    final void applyCompoundDrawableTint(final Drawable drawable, final TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }
    
    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            final Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            this.applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            this.applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            this.applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            this.applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
    }
    
    void loadFromAttributes(final AttributeSet set, final int n) {
        final Context context = this.mView.getContext();
        final AppCompatDrawableManager value = AppCompatDrawableManager.get();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.AppCompatTextHelper, n, 0);
        final int appCompatTextHelper_android_textAppearance = R$styleable.AppCompatTextHelper_android_textAppearance;
        final int n2 = -1;
        final int resourceId = obtainStyledAttributes.getResourceId(appCompatTextHelper_android_textAppearance, n2);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = createTintInfo(context, value, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = createTintInfo(context, value, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = createTintInfo(context, value, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = createTintInfo(context, value, obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        obtainStyledAttributes.recycle();
        final boolean b = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean allCaps = false;
        boolean b2 = false;
        ColorStateList textColor = null;
        ColorStateList hintTextColor = null;
        final int n3 = 23;
        if (resourceId != n2) {
            final TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, R$styleable.TextAppearance);
            if (!b && obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_textAllCaps)) {
                final boolean b3 = true;
                allCaps = obtainStyledAttributes2.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
                b2 = b3;
            }
            if (Build$VERSION.SDK_INT < n3) {
                if (obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_android_textColor)) {
                    textColor = obtainStyledAttributes2.getColorStateList(R$styleable.TextAppearance_android_textColor);
                }
                if (obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_android_textColorHint)) {
                    hintTextColor = obtainStyledAttributes2.getColorStateList(R$styleable.TextAppearance_android_textColorHint);
                }
            }
            obtainStyledAttributes2.recycle();
        }
        final TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.TextAppearance, n, 0);
        if (!b && obtainStyledAttributes3.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            b2 = true;
            allCaps = obtainStyledAttributes3.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        }
        if (Build$VERSION.SDK_INT < n3) {
            if (obtainStyledAttributes3.hasValue(R$styleable.TextAppearance_android_textColor)) {
                textColor = obtainStyledAttributes3.getColorStateList(R$styleable.TextAppearance_android_textColor);
            }
            if (obtainStyledAttributes3.hasValue(R$styleable.TextAppearance_android_textColorHint)) {
                hintTextColor = obtainStyledAttributes3.getColorStateList(R$styleable.TextAppearance_android_textColorHint);
            }
        }
        obtainStyledAttributes3.recycle();
        if (textColor != null) {
            this.mView.setTextColor(textColor);
        }
        if (hintTextColor != null) {
            this.mView.setHintTextColor(hintTextColor);
        }
        if (!b && b2) {
            this.setAllCaps(allCaps);
        }
    }
    
    void onSetTextAppearance(final Context context, final int n) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, n, R$styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (Build$VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes.hasValue(R$styleable.TextAppearance_android_textColor)) {
                final ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R$styleable.TextAppearance_android_textColor);
                if (colorStateList != null) {
                    this.mView.setTextColor(colorStateList);
                }
            }
        }
        obtainStyledAttributes.recycle();
    }
    
    void setAllCaps(final boolean b) {
        final TextView mView = this.mView;
        Object transformationMethod;
        if (b) {
            transformationMethod = new AllCapsTransformationMethod(mView.getContext());
        }
        else {
            transformationMethod = null;
        }
        mView.setTransformationMethod((TransformationMethod)transformationMethod);
    }
}
