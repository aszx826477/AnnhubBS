// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.view.InflateException;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.content.res.TypedArray;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import android.content.Context;
import android.view.animation.Interpolator;

public class PathInterpolatorCompat implements Interpolator
{
    public static final double EPSILON = 1.0E-5;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;
    
    public PathInterpolatorCompat(final Context context, final AttributeSet set, final XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), set, xmlPullParser);
    }
    
    public PathInterpolatorCompat(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        this.parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
    
    private void initCubic(final float n, final float n2, final float n3, final float n4) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(n, n2, n3, n4, 1.0f, 1.0f);
        this.initPath(path);
    }
    
    private void initPath(final Path path) {
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float length = pathMeasure.getLength();
        final int n = (int)(length / 0.002f);
        final int n2 = 1;
        final int min = Math.min(3000, n + n2);
        if (min > 0) {
            this.mX = new float[min];
            this.mY = new float[min];
            final float[] array = new float[2];
            for (int i = 0; i < min; ++i) {
                pathMeasure.getPosTan(i * length / (min - 1), array, (float[])null);
                this.mX[i] = array[0];
                this.mY[i] = array[n2];
            }
            final double n3 = Math.abs(this.mX[0]);
            final double n4 = 1.0E-5;
            if (n3 <= n4 && Math.abs(this.mY[0]) <= n4) {
                final float n5 = this.mX[min - 1];
                final float n6 = 1.0f;
                if (Math.abs(n5 - n6) <= n4) {
                    if (Math.abs(this.mY[min - 1] - n6) <= n4) {
                        float n7 = 0.0f;
                        int n8 = 0;
                        int n9;
                        for (int j = 0; j < min; ++j, n8 = n9) {
                            final float[] mx = this.mX;
                            n9 = n8 + 1;
                            final float n10 = mx[n8];
                            if (n10 < n7) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("The Path cannot loop back on itself, x :");
                                sb.append(n10);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            mx[j] = n10;
                            n7 = n10;
                        }
                        if (!pathMeasure.nextContour()) {
                            return;
                        }
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.mX[0]);
            sb2.append(",");
            sb2.append(this.mY[0]);
            sb2.append(" end:");
            sb2.append(this.mX[min - 1]);
            sb2.append(",");
            sb2.append(this.mY[min - 1]);
            throw new IllegalArgumentException(sb2.toString());
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("The Path has a invalid length ");
        sb3.append(length);
        throw new IllegalArgumentException(sb3.toString());
    }
    
    private void initQuad(final float n, final float n2) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        final float n3 = 1.0f;
        path.quadTo(n, n2, n3, n3);
        this.initPath(path);
    }
    
    private void parseInterpolatorFromTypeArray(final TypedArray typedArray, final XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            final String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            final Path pathFromPathData = PathParser.createPathFromPathData(namedString);
            if (pathFromPathData == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The path is null, which is created from ");
                sb.append(namedString);
                throw new InflateException(sb.toString());
            }
            this.initPath(pathFromPathData);
        }
        else {
            if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
                throw new InflateException("pathInterpolator requires the controlX1 attribute");
            }
            if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
            final float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            final float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            final boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
            if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            if (!hasAttribute) {
                this.initQuad(namedFloat, namedFloat2);
            }
            else {
                this.initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        }
    }
    
    public float getInterpolation(final float n) {
        if (n <= 0.0f) {
            return 0.0f;
        }
        final float n2 = 1.0f;
        if (n >= n2) {
            return n2;
        }
        int n3 = 0;
        final int length = this.mX.length;
        final int n4 = 1;
        int n5 = length - n4;
        while (n5 - n3 > n4) {
            final int n6 = (n3 + n5) / 2;
            if (n < this.mX[n6]) {
                n5 = n6;
            }
            else {
                n3 = n6;
            }
        }
        final float[] mx = this.mX;
        final float n7 = mx[n5] - mx[n3];
        if (n7 == 0.0f) {
            return this.mY[n3];
        }
        final float n8 = (n - mx[n3]) / n7;
        final float[] my = this.mY;
        final float n9 = my[n3];
        return (my[n5] - n9) * n8 + n9;
    }
}
