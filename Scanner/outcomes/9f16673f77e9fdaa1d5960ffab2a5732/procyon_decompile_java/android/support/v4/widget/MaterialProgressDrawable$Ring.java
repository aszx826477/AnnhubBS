// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.Path$FillType;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint$Cap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.Paint;
import android.graphics.Path;

class MaterialProgressDrawable$Ring
{
    private int mAlpha;
    private Path mArrow;
    private int mArrowHeight;
    private final Paint mArrowPaint;
    private float mArrowScale;
    private int mArrowWidth;
    private int mBackgroundColor;
    private final Drawable$Callback mCallback;
    private final Paint mCirclePaint;
    private int mColorIndex;
    private int[] mColors;
    private int mCurrentColor;
    private float mEndTrim;
    private final Paint mPaint;
    private double mRingCenterRadius;
    private float mRotation;
    private boolean mShowArrow;
    private float mStartTrim;
    private float mStartingEndTrim;
    private float mStartingRotation;
    private float mStartingStartTrim;
    private float mStrokeInset;
    private float mStrokeWidth;
    private final RectF mTempBounds;
    
    MaterialProgressDrawable$Ring(final Drawable$Callback mCallback) {
        this.mTempBounds = new RectF();
        this.mPaint = new Paint();
        this.mArrowPaint = new Paint();
        this.mStartTrim = 0.0f;
        this.mEndTrim = 0.0f;
        this.mRotation = 0.0f;
        this.mStrokeWidth = 5.0f;
        this.mStrokeInset = 2.5f;
        final boolean b = true;
        this.mCirclePaint = new Paint((int)(b ? 1 : 0));
        this.mCallback = mCallback;
        this.mPaint.setStrokeCap(Paint$Cap.SQUARE);
        this.mPaint.setAntiAlias(b);
        this.mPaint.setStyle(Paint$Style.STROKE);
        this.mArrowPaint.setStyle(Paint$Style.FILL);
        this.mArrowPaint.setAntiAlias(b);
    }
    
    private void drawTriangle(final Canvas canvas, final float n, final float n2, final Rect rect) {
        if (this.mShowArrow) {
            final Path mArrow = this.mArrow;
            if (mArrow == null) {
                (this.mArrow = new Path()).setFillType(Path$FillType.EVEN_ODD);
            }
            else {
                mArrow.reset();
            }
            final float n3 = (int)this.mStrokeInset / 2 * this.mArrowScale;
            final double mRingCenterRadius = this.mRingCenterRadius;
            final double n4 = 0.0;
            final double n5 = mRingCenterRadius * Math.cos(n4);
            final double n6 = rect.exactCenterX();
            Double.isNaN(n6);
            final float n7 = (float)(n5 + n6);
            final double n8 = this.mRingCenterRadius * Math.sin(n4);
            final double n9 = rect.exactCenterY();
            Double.isNaN(n9);
            final float n10 = (float)(n8 + n9);
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            final Path mArrow2 = this.mArrow;
            final float n11 = this.mArrowWidth;
            final float mArrowScale = this.mArrowScale;
            mArrow2.lineTo(n11 * mArrowScale / 2.0f, this.mArrowHeight * mArrowScale);
            this.mArrow.offset(n7 - n3, n10);
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            canvas.rotate(n + n2 - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(this.mArrow, this.mArrowPaint);
        }
    }
    
    private int getNextColorIndex() {
        return (this.mColorIndex + 1) % this.mColors.length;
    }
    
    private void invalidateSelf() {
        this.mCallback.invalidateDrawable((Drawable)null);
    }
    
    public void draw(final Canvas canvas, final Rect rect) {
        final RectF mTempBounds = this.mTempBounds;
        mTempBounds.set(rect);
        final float mStrokeInset = this.mStrokeInset;
        mTempBounds.inset(mStrokeInset, mStrokeInset);
        final float mStartTrim = this.mStartTrim;
        final float mRotation = this.mRotation;
        final float n = mStartTrim + mRotation;
        final float n2 = 360.0f;
        final float n3 = n * n2;
        final float n4 = (this.mEndTrim + mRotation) * n2 - n3;
        this.mPaint.setColor(this.mCurrentColor);
        canvas.drawArc(mTempBounds, n3, n4, false, this.mPaint);
        this.drawTriangle(canvas, n3, n4, rect);
        final int mAlpha = this.mAlpha;
        final int n5 = 255;
        if (mAlpha < n5) {
            this.mCirclePaint.setColor(this.mBackgroundColor);
            this.mCirclePaint.setAlpha(n5 - this.mAlpha);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float)(rect.width() / 2), this.mCirclePaint);
        }
    }
    
    public int getAlpha() {
        return this.mAlpha;
    }
    
    public double getCenterRadius() {
        return this.mRingCenterRadius;
    }
    
    public float getEndTrim() {
        return this.mEndTrim;
    }
    
    public float getInsets() {
        return this.mStrokeInset;
    }
    
    public int getNextColor() {
        return this.mColors[this.getNextColorIndex()];
    }
    
    public float getRotation() {
        return this.mRotation;
    }
    
    public float getStartTrim() {
        return this.mStartTrim;
    }
    
    public int getStartingColor() {
        return this.mColors[this.mColorIndex];
    }
    
    public float getStartingEndTrim() {
        return this.mStartingEndTrim;
    }
    
    public float getStartingRotation() {
        return this.mStartingRotation;
    }
    
    public float getStartingStartTrim() {
        return this.mStartingStartTrim;
    }
    
    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }
    
    public void goToNextColor() {
        this.setColorIndex(this.getNextColorIndex());
    }
    
    public void resetOriginals() {
        this.mStartingStartTrim = 0.0f;
        this.mStartingEndTrim = 0.0f;
        this.setStartTrim(this.mStartingRotation = 0.0f);
        this.setEndTrim(0.0f);
        this.setRotation(0.0f);
    }
    
    public void setAlpha(final int mAlpha) {
        this.mAlpha = mAlpha;
    }
    
    public void setArrowDimensions(final float n, final float n2) {
        this.mArrowWidth = (int)n;
        this.mArrowHeight = (int)n2;
    }
    
    public void setArrowScale(final float mArrowScale) {
        if (mArrowScale != this.mArrowScale) {
            this.mArrowScale = mArrowScale;
            this.invalidateSelf();
        }
    }
    
    public void setBackgroundColor(final int mBackgroundColor) {
        this.mBackgroundColor = mBackgroundColor;
    }
    
    public void setCenterRadius(final double mRingCenterRadius) {
        this.mRingCenterRadius = mRingCenterRadius;
    }
    
    public void setColor(final int mCurrentColor) {
        this.mCurrentColor = mCurrentColor;
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setColorIndex(final int mColorIndex) {
        this.mColorIndex = mColorIndex;
        this.mCurrentColor = this.mColors[this.mColorIndex];
    }
    
    public void setColors(final int[] mColors) {
        this.mColors = mColors;
        this.setColorIndex(0);
    }
    
    public void setEndTrim(final float mEndTrim) {
        this.mEndTrim = mEndTrim;
        this.invalidateSelf();
    }
    
    public void setInsets(final int n, final int n2) {
        final float n3 = Math.min(n, n2);
        final double mRingCenterRadius = this.mRingCenterRadius;
        final float n4 = 2.0f;
        float mStrokeInset;
        if (mRingCenterRadius > 0.0 && n3 >= 0.0f) {
            final double n5 = n3 / n4;
            Double.isNaN(n5);
            mStrokeInset = (float)(n5 - mRingCenterRadius);
        }
        else {
            mStrokeInset = (float)Math.ceil(this.mStrokeWidth / n4);
        }
        this.mStrokeInset = mStrokeInset;
    }
    
    public void setRotation(final float mRotation) {
        this.mRotation = mRotation;
        this.invalidateSelf();
    }
    
    public void setShowArrow(final boolean mShowArrow) {
        if (this.mShowArrow != mShowArrow) {
            this.mShowArrow = mShowArrow;
            this.invalidateSelf();
        }
    }
    
    public void setStartTrim(final float mStartTrim) {
        this.mStartTrim = mStartTrim;
        this.invalidateSelf();
    }
    
    public void setStrokeWidth(final float n) {
        this.mStrokeWidth = n;
        this.mPaint.setStrokeWidth(n);
        this.invalidateSelf();
    }
    
    public void storeOriginals() {
        this.mStartingStartTrim = this.mStartTrim;
        this.mStartingEndTrim = this.mEndTrim;
        this.mStartingRotation = this.mRotation;
    }
}
