// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.util.AttributeSet;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.Shader;
import android.graphics.BitmapShader;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.Drawable;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.widget.ProgressBar;
import android.graphics.Bitmap;

class AppCompatProgressBarHelper
{
    private static final int[] TINT_ATTRS;
    private Bitmap mSampleTile;
    private final ProgressBar mView;
    
    static {
        final int[] array;
        final int[] tint_ATTRS = array = new int[2];
        array[0] = 16843067;
        array[1] = 16843068;
        TINT_ATTRS = tint_ATTRS;
    }
    
    AppCompatProgressBarHelper(final ProgressBar mView) {
        this.mView = mView;
    }
    
    private Shape getDrawableShape() {
        final float[] array2;
        final float[] array = array2 = new float[8];
        array2[1] = (array2[0] = 5.0f);
        array2[3] = (array2[2] = 5.0f);
        array2[5] = (array2[4] = 5.0f);
        array2[7] = (array2[6] = 5.0f);
        return (Shape)new RoundRectShape(array, (RectF)null, (float[])null);
    }
    
    private Drawable tileify(final Drawable drawable, final boolean b) {
        if (drawable instanceof DrawableWrapper) {
            final Drawable wrappedDrawable = ((DrawableWrapper)drawable).getWrappedDrawable();
            if (wrappedDrawable != null) {
                ((DrawableWrapper)drawable).setWrappedDrawable(this.tileify(wrappedDrawable, b));
            }
        }
        else {
            final boolean b2 = drawable instanceof LayerDrawable;
            final boolean b3 = true;
            if (b2) {
                final LayerDrawable layerDrawable = (LayerDrawable)drawable;
                final int numberOfLayers = layerDrawable.getNumberOfLayers();
                final Drawable[] array = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; ++i) {
                    final int id = layerDrawable.getId(i);
                    array[i] = this.tileify(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                final LayerDrawable layerDrawable2 = new LayerDrawable(array);
                for (int j = 0; j < numberOfLayers; ++j) {
                    layerDrawable2.setId(j, layerDrawable.getId(j));
                }
                return (Drawable)layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                final BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
                final Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.mSampleTile == null) {
                    this.mSampleTile = bitmap;
                }
                final ShapeDrawable shapeDrawable = new ShapeDrawable(this.getDrawableShape());
                shapeDrawable.getPaint().setShader((Shader)new BitmapShader(bitmap, Shader$TileMode.REPEAT, Shader$TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                Object o;
                if (b) {
                    o = new ClipDrawable((Drawable)shapeDrawable, 3, (int)(b3 ? 1 : 0));
                }
                else {
                    o = shapeDrawable;
                }
                return (Drawable)o;
            }
        }
        return drawable;
    }
    
    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            final AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            final Object o = new AnimationDrawable();
            ((AnimationDrawable)o).setOneShot(animationDrawable.isOneShot());
            int n = 0;
            int n2;
            while (true) {
                n2 = 10000;
                if (n >= numberOfFrames) {
                    break;
                }
                final Drawable tileify = this.tileify(animationDrawable.getFrame(n), true);
                tileify.setLevel(n2);
                ((AnimationDrawable)o).addFrame(tileify, animationDrawable.getDuration(n));
                ++n;
            }
            ((AnimationDrawable)o).setLevel(n2);
            drawable = (Drawable)o;
        }
        return drawable;
    }
    
    Bitmap getSampleTime() {
        return this.mSampleTile;
    }
    
    void loadFromAttributes(final AttributeSet set, final int n) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), set, AppCompatProgressBarHelper.TINT_ATTRS, n, 0);
        final Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mView.setIndeterminateDrawable(this.tileifyIndeterminate(drawableIfKnown));
        }
        final Drawable drawableIfKnown2 = obtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            this.mView.setProgressDrawable(this.tileify(drawableIfKnown2, false));
        }
        obtainStyledAttributes.recycle();
    }
}
