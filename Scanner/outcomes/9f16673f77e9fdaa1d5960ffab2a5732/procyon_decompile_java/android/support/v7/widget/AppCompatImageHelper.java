// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.content.res.AppCompatResources;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class AppCompatImageHelper
{
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;
    
    public AppCompatImageHelper(final ImageView mView) {
        this.mView = mView;
    }
    
    private boolean applyFrameworkTintUsingColorFilter(final Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        final TintInfo mTmpInfo = this.mTmpInfo;
        mTmpInfo.clear();
        final ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.mView);
        final boolean b = true;
        if (imageTintList != null) {
            mTmpInfo.mHasTintList = b;
            mTmpInfo.mTintList = imageTintList;
        }
        final PorterDuff$Mode imageTintMode = ImageViewCompat.getImageTintMode(this.mView);
        if (imageTintMode != null) {
            mTmpInfo.mHasTintMode = b;
            mTmpInfo.mTintMode = imageTintMode;
        }
        if (!mTmpInfo.mHasTintList && !mTmpInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable, mTmpInfo, this.mView.getDrawableState());
        return b;
    }
    
    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = true;
        final int n = 21;
        if (sdk_INT > n) {
            if (this.mInternalImageTint == null) {
                b = false;
            }
            return b;
        }
        return sdk_INT == n && b;
    }
    
    void applySupportImageTint() {
        final Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null) {
            if (this.shouldApplyFrameworkTintUsingColorFilter() && this.applyFrameworkTintUsingColorFilter(drawable)) {
                return;
            }
            final TintInfo mImageTint = this.mImageTint;
            if (mImageTint != null) {
                AppCompatDrawableManager.tintDrawable(drawable, mImageTint, this.mView.getDrawableState());
            }
            else {
                final TintInfo mInternalImageTint = this.mInternalImageTint;
                if (mInternalImageTint != null) {
                    AppCompatDrawableManager.tintDrawable(drawable, mInternalImageTint, this.mView.getDrawableState());
                }
            }
        }
    }
    
    ColorStateList getSupportImageTintList() {
        final TintInfo mImageTint = this.mImageTint;
        ColorStateList mTintList;
        if (mImageTint != null) {
            mTintList = mImageTint.mTintList;
        }
        else {
            mTintList = null;
        }
        return mTintList;
    }
    
    PorterDuff$Mode getSupportImageTintMode() {
        final TintInfo mImageTint = this.mImageTint;
        PorterDuff$Mode mTintMode;
        if (mImageTint != null) {
            mTintMode = mImageTint.mTintMode;
        }
        else {
            mTintMode = null;
        }
        return mTintMode;
    }
    
    boolean hasOverlappingRendering() {
        final Drawable background = this.mView.getBackground();
        return Build$VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable);
    }
    
    public void loadFromAttributes(final AttributeSet set, final int n) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), set, R$styleable.AppCompatImageView, n, 0);
        try {
            Drawable imageDrawable = this.mView.getDrawable();
            final int n2 = -1;
            if (imageDrawable == null) {
                final int resourceId = obtainStyledAttributes.getResourceId(R$styleable.AppCompatImageView_srcCompat, n2);
                if (resourceId != n2) {
                    if ((imageDrawable = AppCompatResources.getDrawable(this.mView.getContext(), resourceId)) != null) {
                        this.mView.setImageDrawable(imageDrawable);
                    }
                }
            }
            if (imageDrawable != null) {
                DrawableUtils.fixDrawable(imageDrawable);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.mView, obtainStyledAttributes.getColorStateList(R$styleable.AppCompatImageView_tint));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.AppCompatImageView_tintMode, n2), null));
            }
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    public void setImageResource(final int n) {
        if (n != 0) {
            final Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), n);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
        }
        else {
            this.mView.setImageDrawable((Drawable)null);
        }
        this.applySupportImageTint();
    }
    
    void setInternalImageTint(final ColorStateList mTintList) {
        if (mTintList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            final TintInfo mInternalImageTint = this.mInternalImageTint;
            mInternalImageTint.mTintList = mTintList;
            mInternalImageTint.mHasTintList = true;
        }
        else {
            this.mInternalImageTint = null;
        }
        this.applySupportImageTint();
    }
    
    void setSupportImageTintList(final ColorStateList mTintList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        final TintInfo mImageTint = this.mImageTint;
        mImageTint.mTintList = mTintList;
        mImageTint.mHasTintList = true;
        this.applySupportImageTint();
    }
    
    void setSupportImageTintMode(final PorterDuff$Mode mTintMode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        final TintInfo mImageTint = this.mImageTint;
        mImageTint.mTintMode = mTintMode;
        mImageTint.mHasTintMode = true;
        this.applySupportImageTint();
    }
}
