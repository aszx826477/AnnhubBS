// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.animation.AnimationUtils;
import android.graphics.Canvas;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Rect;
import android.view.animation.Interpolator;

final class SwipeProgressBar
{
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR;
    private Rect mBounds;
    private final RectF mClipRect;
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint;
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;
    
    static {
        INTERPOLATOR = (Interpolator)new FastOutSlowInInterpolator();
    }
    
    SwipeProgressBar(final View mParent) {
        this.mPaint = new Paint();
        this.mClipRect = new RectF();
        this.mBounds = new Rect();
        this.mParent = mParent;
        this.mColor1 = -1291845632;
        this.mColor2 = -1 << -1;
        this.mColor3 = 1291845632;
        this.mColor4 = 436207616;
    }
    
    private void drawCircle(final Canvas canvas, final float n, final float n2, final int color, final float n3) {
        this.mPaint.setColor(color);
        canvas.save();
        canvas.translate(n, n2);
        final float interpolation = SwipeProgressBar.INTERPOLATOR.getInterpolation(n3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, n, this.mPaint);
        canvas.restore();
    }
    
    private void drawTrigger(final Canvas canvas, final int n, final int n2) {
        this.mPaint.setColor(this.mColor1);
        canvas.drawCircle((float)n, (float)n2, n * this.mTriggerPercentage, this.mPaint);
    }
    
    void draw(final Canvas canvas) {
        final int width = this.mBounds.width();
        final int height = this.mBounds.height();
        final int n = width / 2;
        final int n2 = height / 2;
        int save = canvas.save();
        canvas.clipRect(this.mBounds);
        final boolean mRunning = this.mRunning;
        final long n3 = 0L;
        if (!mRunning && this.mFinishTime <= n3) {
            final float mTriggerPercentage = this.mTriggerPercentage;
            if (mTriggerPercentage > 0.0f && mTriggerPercentage <= 1.0) {
                this.drawTrigger(canvas, n, n2);
            }
        }
        else {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            final long mStartTime = this.mStartTime;
            final long n4 = currentAnimationTimeMillis - mStartTime;
            final long n5 = 2000L;
            final long n6 = n4 % n5;
            final long n7 = (currentAnimationTimeMillis - mStartTime) / n5;
            final float n8 = n6 / 20.0f;
            final boolean mRunning2 = this.mRunning;
            final float n9 = 100.0f;
            boolean b;
            if (!mRunning2) {
                final long mFinishTime = this.mFinishTime;
                final long n10 = currentAnimationTimeMillis - mFinishTime;
                final long n11 = 1000L;
                if (n10 >= n11) {
                    this.mFinishTime = 0L;
                    return;
                }
                final float n12 = width / 2 * SwipeProgressBar.INTERPOLATOR.getInterpolation((currentAnimationTimeMillis - mFinishTime) % n11 / 10.0f / n9);
                this.mClipRect.set(n - n12, 0.0f, n + n12, (float)height);
                canvas.saveLayerAlpha(this.mClipRect, 0, 0);
                b = true;
            }
            else {
                b = false;
            }
            final float n13 = 75.0f;
            final float n14 = 50.0f;
            final float n15 = 25.0f;
            if (n7 == 0L) {
                canvas.drawColor(this.mColor1);
            }
            else if (n8 >= 0.0f && n8 < n15) {
                canvas.drawColor(this.mColor4);
            }
            else if (n8 >= n15 && n8 < n14) {
                canvas.drawColor(this.mColor1);
            }
            else if (n8 >= n14 && n8 < n13) {
                canvas.drawColor(this.mColor2);
            }
            else {
                canvas.drawColor(this.mColor3);
            }
            final float n16 = 2.0f;
            if (n8 >= 0.0f && n8 <= n15) {
                this.drawCircle(canvas, n, n2, this.mColor1, (n8 + n15) * n16 / n9);
            }
            if (n8 >= 0.0f && n8 <= n14) {
                this.drawCircle(canvas, n, n2, this.mColor2, n8 * n16 / n9);
            }
            if (n8 >= n15 && n8 <= n13) {
                this.drawCircle(canvas, n, n2, this.mColor3, (n8 - n15) * n16 / n9);
            }
            if (n8 >= n14 && n8 <= n9) {
                this.drawCircle(canvas, n, n2, this.mColor4, (n8 - n14) * n16 / n9);
            }
            if (n8 >= n13 && n8 <= n9) {
                this.drawCircle(canvas, n, n2, this.mColor1, (n8 - n13) * n16 / n9);
            }
            if (this.mTriggerPercentage > 0.0f && b) {
                canvas.restoreToCount(save);
                final int save2 = canvas.save();
                canvas.clipRect(this.mBounds);
                this.drawTrigger(canvas, n, n2);
                save = save2;
            }
            ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
        }
        canvas.restoreToCount(save);
    }
    
    boolean isRunning() {
        return this.mRunning || this.mFinishTime > 0L;
    }
    
    void setBounds(final int left, final int top, final int right, final int bottom) {
        final Rect mBounds = this.mBounds;
        mBounds.left = left;
        mBounds.top = top;
        mBounds.right = right;
        mBounds.bottom = bottom;
    }
    
    void setColorScheme(final int mColor1, final int mColor2, final int mColor3, final int mColor4) {
        this.mColor1 = mColor1;
        this.mColor2 = mColor2;
        this.mColor3 = mColor3;
        this.mColor4 = mColor4;
    }
    
    void setTriggerPercentage(final float mTriggerPercentage) {
        this.mTriggerPercentage = mTriggerPercentage;
        this.mStartTime = 0L;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }
    
    void start() {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }
    
    void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }
}
