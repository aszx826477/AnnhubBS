// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.animation;

import android.graphics.PathMeasure;
import android.graphics.Path;
import android.view.animation.Interpolator;

class PathInterpolatorGingerbread implements Interpolator
{
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;
    
    public PathInterpolatorGingerbread(final float n, final float n2) {
        this(createQuad(n, n2));
    }
    
    public PathInterpolatorGingerbread(final float n, final float n2, final float n3, final float n4) {
        this(createCubic(n, n2, n3, n4));
    }
    
    public PathInterpolatorGingerbread(final Path path) {
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float length = pathMeasure.getLength();
        final int n = (int)(length / 0.002f);
        final int n2 = 1;
        final int n3 = n + n2;
        this.mX = new float[n3];
        this.mY = new float[n3];
        final float[] array = new float[2];
        for (int i = 0; i < n3; ++i) {
            pathMeasure.getPosTan(i * length / (n3 - 1), array, (float[])null);
            this.mX[i] = array[0];
            this.mY[i] = array[n2];
        }
    }
    
    private static Path createCubic(final float n, final float n2, final float n3, final float n4) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(n, n2, n3, n4, 1.0f, 1.0f);
        return path;
    }
    
    private static Path createQuad(final float n, final float n2) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        final float n3 = 1.0f;
        path.quadTo(n, n2, n3, n3);
        return path;
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
