// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;
import java.util.ArrayList;
import android.graphics.Path$FillType;
import android.graphics.Paint$Style;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.support.v4.util.ArrayMap;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.Matrix;

class VectorDrawableCompat$VPathRenderer
{
    private static final Matrix IDENTITY_MATRIX;
    float mBaseHeight;
    float mBaseWidth;
    private int mChangingConfigurations;
    private Paint mFillPaint;
    private final Matrix mFinalPathMatrix;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha;
    final VectorDrawableCompat$VGroup mRootGroup;
    String mRootName;
    private Paint mStrokePaint;
    final ArrayMap mVGTargetsMap;
    float mViewportHeight;
    float mViewportWidth;
    
    static {
        IDENTITY_MATRIX = new Matrix();
    }
    
    public VectorDrawableCompat$VPathRenderer() {
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mVGTargetsMap = new ArrayMap();
        this.mRootGroup = new VectorDrawableCompat$VGroup();
        this.mPath = new Path();
        this.mRenderPath = new Path();
    }
    
    public VectorDrawableCompat$VPathRenderer(final VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer) {
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mVGTargetsMap = new ArrayMap();
        this.mRootGroup = new VectorDrawableCompat$VGroup(vectorDrawableCompat$VPathRenderer.mRootGroup, this.mVGTargetsMap);
        this.mPath = new Path(vectorDrawableCompat$VPathRenderer.mPath);
        this.mRenderPath = new Path(vectorDrawableCompat$VPathRenderer.mRenderPath);
        this.mBaseWidth = vectorDrawableCompat$VPathRenderer.mBaseWidth;
        this.mBaseHeight = vectorDrawableCompat$VPathRenderer.mBaseHeight;
        this.mViewportWidth = vectorDrawableCompat$VPathRenderer.mViewportWidth;
        this.mViewportHeight = vectorDrawableCompat$VPathRenderer.mViewportHeight;
        this.mChangingConfigurations = vectorDrawableCompat$VPathRenderer.mChangingConfigurations;
        this.mRootAlpha = vectorDrawableCompat$VPathRenderer.mRootAlpha;
        this.mRootName = vectorDrawableCompat$VPathRenderer.mRootName;
        final String mRootName = vectorDrawableCompat$VPathRenderer.mRootName;
        if (mRootName != null) {
            this.mVGTargetsMap.put(mRootName, this);
        }
    }
    
    private static float cross(final float n, final float n2, final float n3, final float n4) {
        return n * n4 - n2 * n3;
    }
    
    private void drawGroupTree(final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, final Matrix matrix, final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        vectorDrawableCompat$VGroup.mStackedMatrix.set(matrix);
        vectorDrawableCompat$VGroup.mStackedMatrix.preConcat(vectorDrawableCompat$VGroup.mLocalMatrix);
        canvas.save();
        for (int i = 0; i < vectorDrawableCompat$VGroup.mChildren.size(); ++i) {
            final Object value = vectorDrawableCompat$VGroup.mChildren.get(i);
            if (value instanceof VectorDrawableCompat$VGroup) {
                this.drawGroupTree((VectorDrawableCompat$VGroup)value, vectorDrawableCompat$VGroup.mStackedMatrix, canvas, n, n2, colorFilter);
            }
            else if (value instanceof VectorDrawableCompat$VPath) {
                this.drawPath(vectorDrawableCompat$VGroup, (VectorDrawableCompat$VPath)value, canvas, n, n2, colorFilter);
            }
        }
        canvas.restore();
    }
    
    private void drawPath(final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, final VectorDrawableCompat$VPath vectorDrawableCompat$VPath, final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        final float n3 = n / this.mViewportWidth;
        final float n4 = n2 / this.mViewportHeight;
        final float min = Math.min(n3, n4);
        final Matrix access$200 = vectorDrawableCompat$VGroup.mStackedMatrix;
        this.mFinalPathMatrix.set(access$200);
        this.mFinalPathMatrix.postScale(n3, n4);
        final float matrixScale = this.getMatrixScale(access$200);
        if (matrixScale == 0.0f) {
            return;
        }
        vectorDrawableCompat$VPath.toPath(this.mPath);
        final Path mPath = this.mPath;
        this.mRenderPath.reset();
        if (vectorDrawableCompat$VPath.isClipPath()) {
            this.mRenderPath.addPath(mPath, this.mFinalPathMatrix);
            canvas.clipPath(this.mRenderPath);
        }
        else {
            final VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath = (VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath;
            if (vectorDrawableCompat$VFullPath.mTrimPathStart != 0.0f || vectorDrawableCompat$VFullPath.mTrimPathEnd != 1.0f) {
                final float n5 = vectorDrawableCompat$VFullPath.mTrimPathStart + vectorDrawableCompat$VFullPath.mTrimPathOffset;
                final float n6 = 1.0f;
                final float n7 = n5 % n6;
                final float n8 = (vectorDrawableCompat$VFullPath.mTrimPathEnd + vectorDrawableCompat$VFullPath.mTrimPathOffset) % n6;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                final float length = this.mPathMeasure.getLength();
                final float n9 = n7 * length;
                final float n10 = n8 * length;
                mPath.reset();
                if (n9 > n10) {
                    final PathMeasure mPathMeasure = this.mPathMeasure;
                    final boolean b = true;
                    mPathMeasure.getSegment(n9, length, mPath, b);
                    this.mPathMeasure.getSegment(0.0f, n10, mPath, b);
                }
                else {
                    this.mPathMeasure.getSegment(n9, n10, mPath, true);
                }
                mPath.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(mPath, this.mFinalPathMatrix);
            if (vectorDrawableCompat$VFullPath.mFillColor != 0) {
                if (this.mFillPaint == null) {
                    (this.mFillPaint = new Paint()).setStyle(Paint$Style.FILL);
                    this.mFillPaint.setAntiAlias(true);
                }
                final Paint mFillPaint = this.mFillPaint;
                mFillPaint.setColor(VectorDrawableCompat.applyAlpha(vectorDrawableCompat$VFullPath.mFillColor, vectorDrawableCompat$VFullPath.mFillAlpha));
                mFillPaint.setColorFilter(colorFilter);
                final Path mRenderPath = this.mRenderPath;
                Path$FillType fillType;
                if (vectorDrawableCompat$VFullPath.mFillRule == 0) {
                    fillType = Path$FillType.WINDING;
                }
                else {
                    fillType = Path$FillType.EVEN_ODD;
                }
                mRenderPath.setFillType(fillType);
                canvas.drawPath(this.mRenderPath, mFillPaint);
            }
            if (vectorDrawableCompat$VFullPath.mStrokeColor != 0) {
                if (this.mStrokePaint == null) {
                    (this.mStrokePaint = new Paint()).setStyle(Paint$Style.STROKE);
                    this.mStrokePaint.setAntiAlias(true);
                }
                final Paint mStrokePaint = this.mStrokePaint;
                if (vectorDrawableCompat$VFullPath.mStrokeLineJoin != null) {
                    mStrokePaint.setStrokeJoin(vectorDrawableCompat$VFullPath.mStrokeLineJoin);
                }
                if (vectorDrawableCompat$VFullPath.mStrokeLineCap != null) {
                    mStrokePaint.setStrokeCap(vectorDrawableCompat$VFullPath.mStrokeLineCap);
                }
                mStrokePaint.setStrokeMiter(vectorDrawableCompat$VFullPath.mStrokeMiterlimit);
                mStrokePaint.setColor(VectorDrawableCompat.applyAlpha(vectorDrawableCompat$VFullPath.mStrokeColor, vectorDrawableCompat$VFullPath.mStrokeAlpha));
                mStrokePaint.setColorFilter(colorFilter);
                mStrokePaint.setStrokeWidth(vectorDrawableCompat$VFullPath.mStrokeWidth * (min * matrixScale));
                canvas.drawPath(this.mRenderPath, mStrokePaint);
            }
        }
    }
    
    private float getMatrixScale(final Matrix matrix) {
        final float[] array2;
        final float[] array = array2 = new float[4];
        array2[0] = 0.0f;
        array2[2] = (array2[1] = 1.0f);
        array2[3] = 0.0f;
        matrix.mapVectors(array);
        final double n = array[0];
        final int n2 = 1;
        final float n3 = (float)Math.hypot(n, array[n2]);
        final int n4 = 2;
        final double n5 = array[n4];
        final int n6 = 3;
        final float n7 = (float)Math.hypot(n5, array[n6]);
        final float cross = cross(array[0], array[n2], array[n4], array[n6]);
        final float max = Math.max(n3, n7);
        float n8 = 0.0f;
        if (max > 0.0f) {
            n8 = Math.abs(cross) / max;
        }
        return n8;
    }
    
    public void draw(final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        this.drawGroupTree(this.mRootGroup, VectorDrawableCompat$VPathRenderer.IDENTITY_MATRIX, canvas, n, n2, colorFilter);
    }
    
    public float getAlpha() {
        return this.getRootAlpha() / 255.0f;
    }
    
    public int getRootAlpha() {
        return this.mRootAlpha;
    }
    
    public void setAlpha(final float n) {
        this.setRootAlpha((int)(255.0f * n));
    }
    
    public void setRootAlpha(final int mRootAlpha) {
        this.mRootAlpha = mRootAlpha;
    }
}
