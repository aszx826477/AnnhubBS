// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics;

import android.graphics.Color;

public final class ColorUtils
{
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal TEMP_ARRAY;
    private static final double XYZ_EPSILON = 0.008856;
    private static final double XYZ_KAPPA = 903.3;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883;
    
    static {
        TEMP_ARRAY = new ThreadLocal();
    }
    
    public static int HSLToColor(final float[] array) {
        final float n = array[0];
        final float n2 = array[1];
        final float n3 = array[2];
        final float n4 = 2.0f;
        final float n5 = n3 * n4;
        final float n6 = 1.0f;
        final float n7 = (n6 - Math.abs(n5 - n6)) * n2;
        final float n8 = n3 - 0.5f * n7;
        final float n9 = (n6 - Math.abs(n / 60.0f % n4 - n6)) * n7;
        final int n10 = (int)n / 60;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        final float n14 = 255.0f;
        switch (n10) {
            case 5:
            case 6: {
                n11 = Math.round((n7 + n8) * n14);
                n12 = Math.round(n8 * n14);
                n13 = Math.round((n9 + n8) * n14);
                break;
            }
            case 4: {
                n11 = Math.round((n9 + n8) * n14);
                n12 = Math.round(n8 * n14);
                n13 = Math.round((n7 + n8) * n14);
                break;
            }
            case 3: {
                n11 = Math.round(n8 * n14);
                n12 = Math.round((n9 + n8) * n14);
                n13 = Math.round((n7 + n8) * n14);
                break;
            }
            case 2: {
                n11 = Math.round(n8 * n14);
                n12 = Math.round((n7 + n8) * n14);
                n13 = Math.round((n9 + n8) * n14);
                break;
            }
            case 1: {
                n11 = Math.round((n9 + n8) * n14);
                n12 = Math.round((n7 + n8) * n14);
                n13 = Math.round(n14 * n8);
                break;
            }
            case 0: {
                n11 = Math.round((n7 + n8) * n14);
                n12 = Math.round((n9 + n8) * n14);
                n13 = Math.round(n14 * n8);
                break;
            }
        }
        final int n15 = 255;
        return Color.rgb(constrain(n11, 0, n15), constrain(n12, 0, n15), constrain(n13, 0, n15));
    }
    
    public static int LABToColor(final double n, final double n2, final double n3) {
        final double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(n, n2, n3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }
    
    public static void LABToXYZ(final double n, final double n2, final double n3, final double[] array) {
        final double n4 = 16.0;
        final double n5 = n + n4;
        final double n6 = 116.0;
        final double n7 = n5 / n6;
        final double n8 = n2 / 500.0 + n7;
        final double n9 = n7 - n3 / 200.0;
        final double n10 = 3.0;
        final double pow = Math.pow(n8, n10);
        final double n11 = 0.008856;
        final double n12 = 903.3;
        double n13;
        if (pow > n11) {
            n13 = pow;
        }
        else {
            n13 = (n8 * n6 - n4) / n12;
        }
        double pow2;
        if (n > 7.9996247999999985) {
            pow2 = Math.pow(n7, n10);
        }
        else {
            pow2 = n / n12;
        }
        final double pow3 = Math.pow(n9, n10);
        double n14;
        if (pow3 > n11) {
            n14 = pow3;
        }
        else {
            n14 = (n6 * n9 - n4) / n12;
        }
        array[0] = 95.047 * n13;
        array[1] = 100.0 * pow2;
        array[2] = 108.883 * n14;
    }
    
    public static void RGBToHSL(final int n, final int n2, final int n3, final float[] array) {
        final float n4 = n;
        final float n5 = 255.0f;
        final float n6 = n4 / n5;
        final float n7 = n2 / n5;
        final float n8 = n3 / n5;
        final float max = Math.max(n6, Math.max(n7, n8));
        final float min = Math.min(n6, Math.min(n7, n8));
        final float n9 = max - min;
        final float n10 = max + min;
        final float n11 = 2.0f;
        final float n12 = n10 / n11;
        final float n13 = 1.0f;
        float n14;
        float n15;
        if (max == min) {
            n14 = 0.0f;
            n15 = 0.0f;
        }
        else {
            if (max == n6) {
                n15 = (n7 - n8) / n9 % 6.0f;
            }
            else if (max == n7) {
                n15 = (n8 - n6) / n9 + n11;
            }
            else {
                n15 = (n6 - n7) / n9 + 4.0f;
            }
            n14 = n9 / (n13 - Math.abs(n11 * n12 - n13));
        }
        final float n16 = 60.0f * n15;
        final float n17 = 360.0f;
        float n18 = n16 % n17;
        if (n18 < 0.0f) {
            n18 += n17;
        }
        array[0] = constrain(n18, 0.0f, n17);
        array[1] = constrain(n14, 0.0f, n13);
        array[2] = constrain(n12, 0.0f, n13);
    }
    
    public static void RGBToLAB(final int n, final int n2, final int n3, final double[] array) {
        RGBToXYZ(n, n2, n3, array);
        XYZToLAB(array[0], array[1], array[2], array);
    }
    
    public static void RGBToXYZ(final int n, final int n2, final int n3, final double[] array) {
        if (array.length == 3) {
            final double n4 = n;
            final double n5 = 255.0;
            Double.isNaN(n4);
            final double n6 = n4 / n5;
            final double n7 = 12.92;
            final double n8 = 2.4;
            final double n9 = 1.055;
            final double n10 = 0.055;
            final double n11 = 0.04045;
            double pow;
            if (n6 < n11) {
                pow = n6 / n7;
            }
            else {
                pow = Math.pow((n6 + n10) / n9, n8);
            }
            final double n12 = pow;
            final double n13 = n2;
            Double.isNaN(n13);
            final double n14 = n13 / n5;
            double pow2;
            if (n14 < n11) {
                pow2 = n14 / n7;
            }
            else {
                pow2 = Math.pow((n14 + 0.055) / n9, 2.4);
            }
            final double n15 = n3;
            Double.isNaN(n15);
            final double n16 = n15 / n5;
            double pow3;
            if (n16 < n11) {
                pow3 = n16 / 12.92;
            }
            else {
                pow3 = Math.pow((0.055 + n16) / 1.055, 2.4);
            }
            final double n17 = 0.4124 * n12 + 0.3576 * pow2 + 0.1805 * pow3;
            final double n18 = 100.0;
            array[0] = n17 * n18;
            array[1] = (0.2126 * n12 + 0.7152 * pow2 + 0.0722 * pow3) * n18;
            array[2] = (0.0193 * n12 + 0.1192 * pow2 + 0.9505 * pow3) * n18;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }
    
    public static int XYZToColor(final double n, final double n2, final double n3) {
        final double n4 = 3.2406 * n + -1.5372 * n2 + -0.4986 * n3;
        final double n5 = 100.0;
        final double n6 = n4 / n5;
        final double n7 = (-0.9689 * n + 1.8758 * n2 + 0.0415 * n3) / n5;
        final double n8 = (0.0557 * n + -0.204 * n2 + 1.057 * n3) / n5;
        final double n9 = 0.055;
        final double n10 = 0.4166666666666667;
        final double n11 = 1.055;
        final double n12 = 12.92;
        final double n13 = 0.0031308;
        double n14;
        if (n6 > n13) {
            n14 = Math.pow(n6, n10) * n11 - n9;
        }
        else {
            n14 = n6 * n12;
        }
        final double n15 = n14;
        double n16;
        if (n7 > n13) {
            n16 = Math.pow(n7, n10) * n11 - n9;
        }
        else {
            n16 = n7 * n12;
        }
        final double n17 = n16;
        double n18;
        if (n8 > n13) {
            n18 = Math.pow(n8, n10) * n11 - n9;
        }
        else {
            n18 = n8 * n12;
        }
        final double n19 = n18;
        final double n20 = 255.0;
        final int n21 = (int)Math.round(n15 * n20);
        final int n22 = 255;
        return Color.rgb(constrain(n21, 0, n22), constrain((int)Math.round(n17 * n20), 0, n22), constrain((int)Math.round(n20 * n19), 0, n22));
    }
    
    public static void XYZToLAB(double pivotXyzComponent, double pivotXyzComponent2, double pivotXyzComponent3, final double[] array) {
        if (array.length == 3) {
            pivotXyzComponent = pivotXyzComponent(pivotXyzComponent / 95.047);
            pivotXyzComponent2 = pivotXyzComponent(pivotXyzComponent2 / 100.0);
            pivotXyzComponent3 = pivotXyzComponent(pivotXyzComponent3 / 108.883);
            array[0] = Math.max(0.0, 116.0 * pivotXyzComponent2 - 16.0);
            array[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0;
            array[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }
    
    public static int blendARGB(final int n, final int n2, final float n3) {
        final float n4 = 1.0f - n3;
        return Color.argb((int)(Color.alpha(n) * n4 + Color.alpha(n2) * n3), (int)(Color.red(n) * n4 + Color.red(n2) * n3), (int)(Color.green(n) * n4 + Color.green(n2) * n3), (int)(Color.blue(n) * n4 + Color.blue(n2) * n3));
    }
    
    public static void blendHSL(final float[] array, final float[] array2, final float n, final float[] array3) {
        if (array3.length == 3) {
            final float n2 = 1.0f - n;
            array3[0] = circularInterpolate(array[0], array2[0], n);
            final int n3 = 1;
            array3[n3] = array[n3] * n2 + array2[n3] * n;
            final int n4 = 2;
            array3[n4] = array[n4] * n2 + array2[n4] * n;
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }
    
    public static void blendLAB(final double[] array, final double[] array2, final double n, final double[] array3) {
        if (array3.length == 3) {
            final double n2 = 1.0 - n;
            array3[0] = array[0] * n2 + array2[0] * n;
            final int n3 = 1;
            array3[n3] = array[n3] * n2 + array2[n3] * n;
            final int n4 = 2;
            array3[n4] = array[n4] * n2 + array2[n4] * n;
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }
    
    public static double calculateContrast(int compositeColors, final int n) {
        final int alpha = Color.alpha(n);
        final int n2 = 255;
        if (alpha == n2) {
            if (Color.alpha(compositeColors) < n2) {
                compositeColors = compositeColors(compositeColors, n);
            }
            final double calculateLuminance = calculateLuminance(compositeColors);
            final double n3 = 0.05;
            final double n4 = calculateLuminance + n3;
            final double n5 = calculateLuminance(n) + n3;
            return Math.max(n4, n5) / Math.min(n4, n5);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("background can not be translucent: #");
        sb.append(Integer.toHexString(n));
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static double calculateLuminance(final int n) {
        final double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(n, tempDouble3Array);
        return tempDouble3Array[1] / 100.0;
    }
    
    public static int calculateMinimumAlpha(final int n, final int n2, final float n3) {
        final int alpha = Color.alpha(n2);
        final int n4 = 255;
        if (alpha != n4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("background can not be translucent: #");
            sb.append(Integer.toHexString(n2));
            throw new IllegalArgumentException(sb.toString());
        }
        if (calculateContrast(setAlphaComponent(n, n4), n2) < n3) {
            return -1;
        }
        int n5;
        int n6;
        int n7;
        for (n5 = 0, n6 = 0, n7 = 255; n5 <= 10 && n7 - n6 > 1; ++n5) {
            final int n8 = (n6 + n7) / 2;
            if (calculateContrast(setAlphaComponent(n, n8), n2) < n3) {
                n6 = n8;
            }
            else {
                n7 = n8;
            }
        }
        return n7;
    }
    
    static float circularInterpolate(float n, float n2, final float n3) {
        final float abs = Math.abs(n2 - n);
        final float n4 = 360.0f;
        if (abs > 180.0f) {
            if (n2 > n) {
                n += n4;
            }
            else {
                n2 += n4;
            }
        }
        return ((n2 - n) * n3 + n) % n4;
    }
    
    public static void colorToHSL(final int n, final float[] array) {
        RGBToHSL(Color.red(n), Color.green(n), Color.blue(n), array);
    }
    
    public static void colorToLAB(final int n, final double[] array) {
        RGBToLAB(Color.red(n), Color.green(n), Color.blue(n), array);
    }
    
    public static void colorToXYZ(final int n, final double[] array) {
        RGBToXYZ(Color.red(n), Color.green(n), Color.blue(n), array);
    }
    
    private static int compositeAlpha(final int n, final int n2) {
        return 255 - (255 - n2) * (255 - n) / 255;
    }
    
    public static int compositeColors(final int n, final int n2) {
        final int alpha = Color.alpha(n2);
        final int alpha2 = Color.alpha(n);
        final int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(n), alpha2, Color.red(n2), alpha, compositeAlpha), compositeComponent(Color.green(n), alpha2, Color.green(n2), alpha, compositeAlpha), compositeComponent(Color.blue(n), alpha2, Color.blue(n2), alpha, compositeAlpha));
    }
    
    private static int compositeComponent(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {
            return 0;
        }
        return (n * 255 * n2 + n3 * n4 * (255 - n2)) / (n5 * 255);
    }
    
    private static float constrain(final float n, final float n2, final float n3) {
        float n4;
        if (n < n2) {
            n4 = n2;
        }
        else if (n > n3) {
            n4 = n3;
        }
        else {
            n4 = n;
        }
        return n4;
    }
    
    private static int constrain(final int n, final int n2, final int n3) {
        int n4;
        if (n < n2) {
            n4 = n2;
        }
        else if (n > n3) {
            n4 = n3;
        }
        else {
            n4 = n;
        }
        return n4;
    }
    
    public static double distanceEuclidean(final double[] array, final double[] array2) {
        final double n = array[0] - array2[0];
        final double n2 = 2.0;
        final double pow = Math.pow(n, n2);
        final int n3 = 1;
        final double n4 = pow + Math.pow(array[n3] - array2[n3], n2);
        final int n5 = 2;
        return Math.sqrt(n4 + Math.pow(array[n5] - array2[n5], n2));
    }
    
    private static double[] getTempDouble3Array() {
        double[] array = ColorUtils.TEMP_ARRAY.get();
        if (array == null) {
            array = new double[3];
            ColorUtils.TEMP_ARRAY.set(array);
        }
        return array;
    }
    
    private static double pivotXyzComponent(final double n) {
        double pow;
        if (n > 0.008856) {
            pow = Math.pow(n, 0.3333333333333333);
        }
        else {
            pow = (903.3 * n + 16.0) / 116.0;
        }
        return pow;
    }
    
    public static int setAlphaComponent(final int n, final int n2) {
        if (n2 >= 0 && n2 <= 255) {
            return (0xFFFFFF & n) | n2 << 24;
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
