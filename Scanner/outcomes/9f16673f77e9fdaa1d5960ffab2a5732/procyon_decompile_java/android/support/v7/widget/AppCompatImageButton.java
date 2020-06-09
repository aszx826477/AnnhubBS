// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.net.Uri;
import android.graphics.drawable.Icon;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.view.View;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v4.view.TintableBackgroundView;
import android.widget.ImageButton;

public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView
{
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;
    
    public AppCompatImageButton(final Context context) {
        this(context, null);
    }
    
    public AppCompatImageButton(final Context context, final AttributeSet set) {
        this(context, set, R$attr.imageButtonStyle);
    }
    
    public AppCompatImageButton(final Context context, final AttributeSet set, final int n) {
        super(TintContextWrapper.wrap(context), set, n);
        (this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this)).loadFromAttributes(set, n);
        (this.mImageHelper = new AppCompatImageHelper((ImageView)this)).loadFromAttributes(set, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySupportBackgroundTint();
        }
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.applySupportImageTint();
        }
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        ColorStateList supportBackgroundTintList;
        if (mBackgroundTintHelper != null) {
            supportBackgroundTintList = mBackgroundTintHelper.getSupportBackgroundTintList();
        }
        else {
            supportBackgroundTintList = null;
        }
        return supportBackgroundTintList;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        PorterDuff$Mode supportBackgroundTintMode;
        if (mBackgroundTintHelper != null) {
            supportBackgroundTintMode = mBackgroundTintHelper.getSupportBackgroundTintMode();
        }
        else {
            supportBackgroundTintMode = null;
        }
        return supportBackgroundTintMode;
    }
    
    public ColorStateList getSupportImageTintList() {
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        ColorStateList supportImageTintList;
        if (mImageHelper != null) {
            supportImageTintList = mImageHelper.getSupportImageTintList();
        }
        else {
            supportImageTintList = null;
        }
        return supportImageTintList;
    }
    
    public PorterDuff$Mode getSupportImageTintMode() {
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        PorterDuff$Mode supportImageTintMode;
        if (mImageHelper != null) {
            supportImageTintMode = mImageHelper.getSupportImageTintMode();
        }
        else {
            supportImageTintMode = null;
        }
        return supportImageTintMode;
    }
    
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundDrawable(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(backgroundResource);
        }
    }
    
    public void setImageBitmap(final Bitmap imageBitmap) {
        super.setImageBitmap(imageBitmap);
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.applySupportImageTint();
        }
    }
    
    public void setImageDrawable(final Drawable imageDrawable) {
        super.setImageDrawable(imageDrawable);
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.applySupportImageTint();
        }
    }
    
    public void setImageIcon(final Icon imageIcon) {
        super.setImageIcon(imageIcon);
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.applySupportImageTint();
        }
    }
    
    public void setImageResource(final int imageResource) {
        this.mImageHelper.setImageResource(imageResource);
    }
    
    public void setImageURI(final Uri imageURI) {
        super.setImageURI(imageURI);
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.applySupportImageTint();
        }
    }
    
    public void setSupportBackgroundTintList(final ColorStateList supportBackgroundTintList) {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode supportBackgroundTintMode) {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
    
    public void setSupportImageTintList(final ColorStateList supportImageTintList) {
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.setSupportImageTintList(supportImageTintList);
        }
    }
    
    public void setSupportImageTintMode(final PorterDuff$Mode supportImageTintMode) {
        final AppCompatImageHelper mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.setSupportImageTintMode(supportImageTintMode);
        }
    }
}
