// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.view.animation.Animation$AnimationListener;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.LinearInterpolator;
import android.content.res.Resources;
import android.view.View;
import android.graphics.drawable.Drawable$Callback;
import java.util.ArrayList;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

class MaterialProgressDrawable extends Drawable implements Animatable
{
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final int[] COLORS;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR;
    static final Interpolator MATERIAL_INTERPOLATOR;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animation mAnimation;
    private final ArrayList mAnimators;
    private final Drawable$Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final MaterialProgressDrawable$Ring mRing;
    private float mRotation;
    float mRotationCount;
    private double mWidth;
    
    static {
        LINEAR_INTERPOLATOR = (Interpolator)new LinearInterpolator();
        MATERIAL_INTERPOLATOR = (Interpolator)new FastOutSlowInInterpolator();
        COLORS = new int[] { -16777216 };
    }
    
    MaterialProgressDrawable(final Context context, final View mParent) {
        this.mAnimators = new ArrayList();
        this.mCallback = (Drawable$Callback)new MaterialProgressDrawable$3(this);
        this.mParent = mParent;
        this.mResources = context.getResources();
        (this.mRing = new MaterialProgressDrawable$Ring(this.mCallback)).setColors(MaterialProgressDrawable.COLORS);
        this.updateSizes(1);
        this.setupAnimators();
    }
    
    private int evaluateColorChange(final float n, final int n2, final int n3) {
        final int intValue = Integer.valueOf(n2);
        final int n4 = intValue >> 24 & 0xFF;
        final int n5 = intValue >> 16 & 0xFF;
        final int n6 = intValue >> 8 & 0xFF;
        final int n7 = intValue & 0xFF;
        final int intValue2 = Integer.valueOf(n3);
        return (int)(((intValue2 >> 24 & 0xFF) - n4) * n) + n4 << 24 | (int)(((intValue2 >> 16 & 0xFF) - n5) * n) + n5 << 16 | (int)(((intValue2 >> 8 & 0xFF) - n6) * n) + n6 << 8 | (int)(((intValue2 & 0xFF) - n7) * n) + n7;
    }
    
    private float getRotation() {
        return this.mRotation;
    }
    
    private void setSizeParameters(final double n, final double n2, final double n3, final double n4, final float n5, final float n6) {
        final MaterialProgressDrawable$Ring mRing = this.mRing;
        final float density = this.mResources.getDisplayMetrics().density;
        final double n7 = density;
        Double.isNaN(n7);
        this.mWidth = n7 * n;
        final double n8 = density;
        Double.isNaN(n8);
        this.mHeight = n8 * n2;
        mRing.setStrokeWidth((float)n4 * density);
        final double n9 = density;
        Double.isNaN(n9);
        mRing.setCenterRadius(n9 * n3);
        mRing.setColorIndex(0);
        mRing.setArrowDimensions(n5 * density, n6 * density);
        mRing.setInsets((int)this.mWidth, (int)this.mHeight);
    }
    
    private void setupAnimators() {
        final MaterialProgressDrawable$Ring mRing = this.mRing;
        final MaterialProgressDrawable$1 mAnimation = new MaterialProgressDrawable$1(this, mRing);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(1);
        mAnimation.setInterpolator(MaterialProgressDrawable.LINEAR_INTERPOLATOR);
        mAnimation.setAnimationListener((Animation$AnimationListener)new MaterialProgressDrawable$2(this, mRing));
        this.mAnimation = mAnimation;
    }
    
    void applyFinishTranslation(final float n, final MaterialProgressDrawable$Ring materialProgressDrawable$Ring) {
        this.updateRingColor(n, materialProgressDrawable$Ring);
        final float n2 = (float)(Math.floor(materialProgressDrawable$Ring.getStartingRotation() / 0.8f) + 1.0);
        materialProgressDrawable$Ring.setStartTrim(materialProgressDrawable$Ring.getStartingStartTrim() + (materialProgressDrawable$Ring.getStartingEndTrim() - this.getMinProgressArc(materialProgressDrawable$Ring) - materialProgressDrawable$Ring.getStartingStartTrim()) * n);
        materialProgressDrawable$Ring.setEndTrim(materialProgressDrawable$Ring.getStartingEndTrim());
        materialProgressDrawable$Ring.setRotation(materialProgressDrawable$Ring.getStartingRotation() + (n2 - materialProgressDrawable$Ring.getStartingRotation()) * n);
    }
    
    public void draw(final Canvas canvas) {
        final Rect bounds = this.getBounds();
        final int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }
    
    public int getAlpha() {
        return this.mRing.getAlpha();
    }
    
    public int getIntrinsicHeight() {
        return (int)this.mHeight;
    }
    
    public int getIntrinsicWidth() {
        return (int)this.mWidth;
    }
    
    float getMinProgressArc(final MaterialProgressDrawable$Ring materialProgressDrawable$Ring) {
        final double n = materialProgressDrawable$Ring.getStrokeWidth();
        final double n2 = materialProgressDrawable$Ring.getCenterRadius() * 6.283185307179586;
        Double.isNaN(n);
        return (float)Math.toRadians(n / n2);
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public boolean isRunning() {
        final ArrayList mAnimators = this.mAnimators;
        for (int size = mAnimators.size(), i = 0; i < size; ++i) {
            final Animation animation = mAnimators.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }
    
    public void setAlpha(final int alpha) {
        this.mRing.setAlpha(alpha);
    }
    
    public void setArrowScale(final float arrowScale) {
        this.mRing.setArrowScale(arrowScale);
    }
    
    public void setBackgroundColor(final int backgroundColor) {
        this.mRing.setBackgroundColor(backgroundColor);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }
    
    public void setColorSchemeColors(final int... colors) {
        this.mRing.setColors(colors);
        this.mRing.setColorIndex(0);
    }
    
    public void setProgressRotation(final float rotation) {
        this.mRing.setRotation(rotation);
    }
    
    void setRotation(final float mRotation) {
        this.mRotation = mRotation;
        this.invalidateSelf();
    }
    
    public void setStartEndTrim(final float startTrim, final float endTrim) {
        this.mRing.setStartTrim(startTrim);
        this.mRing.setEndTrim(endTrim);
    }
    
    public void showArrow(final boolean showArrow) {
        this.mRing.setShowArrow(showArrow);
    }
    
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
        }
        else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimation.setDuration(1332L);
            this.mParent.startAnimation(this.mAnimation);
        }
    }
    
    public void stop() {
        this.mParent.clearAnimation();
        this.setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }
    
    void updateRingColor(final float n, final MaterialProgressDrawable$Ring materialProgressDrawable$Ring) {
        final float n2 = 0.75f;
        if (n > n2) {
            materialProgressDrawable$Ring.setColor(this.evaluateColorChange((n - n2) / 0.25f, materialProgressDrawable$Ring.getStartingColor(), materialProgressDrawable$Ring.getNextColor()));
        }
    }
    
    public void updateSizes(final int n) {
        if (n == 0) {
            this.setSizeParameters(56.0, 56.0, 12.5, 3.0, 12.0f, 6.0f);
        }
        else {
            this.setSizeParameters(40.0, 40.0, 8.75, 2.5, 10.0f, 5.0f);
        }
    }
}
