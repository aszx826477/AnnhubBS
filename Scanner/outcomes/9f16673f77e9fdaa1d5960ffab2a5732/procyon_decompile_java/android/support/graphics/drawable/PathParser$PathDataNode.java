// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.util.Log;
import android.graphics.Path;

public class PathParser$PathDataNode
{
    float[] mParams;
    char mType;
    
    PathParser$PathDataNode(final char mType, final float[] mParams) {
        this.mType = mType;
        this.mParams = mParams;
    }
    
    PathParser$PathDataNode(final PathParser$PathDataNode pathParser$PathDataNode) {
        this.mType = pathParser$PathDataNode.mType;
        final float[] mParams = pathParser$PathDataNode.mParams;
        this.mParams = PathParser.copyOfRange(mParams, 0, mParams.length);
    }
    
    private static void addCommand(final Path path, final float[] array, final char c, final char c2, final float[] array2) {
        final int n = 2;
        float n2 = array[0];
        float n3 = array[1];
        float n4 = array[2];
        float n5 = array[3];
        final int n6 = 4;
        final float n7 = array[n6];
        final int n8 = 5;
        final float n9 = array[n8];
        int n10 = 0;
        switch (c2) {
            default: {
                n10 = n;
                break;
            }
            case 'Z':
            case 'z': {
                path.close();
                n2 = n7;
                n3 = n9;
                n4 = n7;
                n5 = n9;
                path.moveTo(n7, n9);
                n10 = n;
                break;
            }
            case 'Q':
            case 'S':
            case 'q':
            case 's': {
                n10 = 4;
                break;
            }
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't': {
                n10 = 2;
                break;
            }
            case 'H':
            case 'V':
            case 'h':
            case 'v': {
                n10 = 1;
                break;
            }
            case 'C':
            case 'c': {
                n10 = 6;
                break;
            }
            case 'A':
            case 'a': {
                n10 = 7;
                break;
            }
        }
        int i = 0;
        float n11 = n2;
        float n12 = n3;
        float n13 = n4;
        float n14 = n5;
        float n15 = n7;
        float n16 = n9;
        char c3 = c;
        while (i < array2.length) {
            final char c4 = 'Q';
            final char c5 = 'C';
            final char c6 = 't';
            final char c7 = 's';
            final char c8 = 'q';
            final char c9 = 'c';
            final float n17 = 2.0f;
            int n18 = 0;
            switch (c2) {
                default: {
                    n18 = i;
                    break;
                }
                case 'v': {
                    path.rLineTo(0.0f, array2[i + 0]);
                    n12 += array2[i + 0];
                    n18 = i;
                    break;
                }
                case 't': {
                    float n19 = 0.0f;
                    float n20 = 0.0f;
                    if (c3 == c8 || c3 == c6 || c3 == c4 || c3 == 'T') {
                        n19 = n11 - n13;
                        n20 = n12 - n14;
                    }
                    path.rQuadTo(n19, n20, array2[i + 0], array2[i + 1]);
                    final float n21 = n11 + n19;
                    final float n22 = n12 + n20;
                    n11 += array2[i + 0];
                    n12 += array2[i + 1];
                    n13 = n21;
                    n14 = n22;
                    n18 = i;
                    break;
                }
                case 's': {
                    float n23;
                    float n24;
                    if (c3 != c9 && c3 != c7 && c3 != c5 && c3 != 'S') {
                        n23 = 0.0f;
                        n24 = 0.0f;
                    }
                    else {
                        final float n25 = n11 - n13;
                        final float n26 = n12 - n14;
                        n23 = n25;
                        n24 = n26;
                    }
                    path.rCubicTo(n23, n24, array2[i + 0], array2[i + 1], array2[i + 2], array2[i + 3]);
                    final float n27 = array2[i + 0] + n11;
                    final float n28 = array2[i + 1] + n12;
                    n11 += array2[i + 2];
                    n12 += array2[i + 3];
                    n13 = n27;
                    n14 = n28;
                    n18 = i;
                    break;
                }
                case 'q': {
                    path.rQuadTo(array2[i + 0], array2[i + 1], array2[i + 2], array2[i + 3]);
                    final float n29 = array2[i + 0] + n11;
                    final float n30 = array2[i + 1] + n12;
                    n11 += array2[i + 2];
                    n12 += array2[i + 3];
                    n13 = n29;
                    n14 = n30;
                    n18 = i;
                    break;
                }
                case 'm': {
                    n11 += array2[i + 0];
                    n12 += array2[i + 1];
                    if (i > 0) {
                        path.rLineTo(array2[i + 0], array2[i + 1]);
                        n18 = i;
                        break;
                    }
                    path.rMoveTo(array2[i + 0], array2[i + 1]);
                    n15 = n11;
                    n16 = n12;
                    n18 = i;
                    break;
                }
                case 'l': {
                    path.rLineTo(array2[i + 0], array2[i + 1]);
                    n11 += array2[i + 0];
                    n12 += array2[i + 1];
                    n18 = i;
                    break;
                }
                case 'h': {
                    path.rLineTo(array2[i + 0], 0.0f);
                    n11 += array2[i + 0];
                    n18 = i;
                    break;
                }
                case 'c': {
                    path.rCubicTo(array2[i + 0], array2[i + 1], array2[i + 2], array2[i + 3], array2[i + 4], array2[i + 5]);
                    final float n31 = array2[i + 2] + n11;
                    final float n32 = array2[i + 3] + n12;
                    n11 += array2[i + 4];
                    n12 += array2[i + 5];
                    n13 = n31;
                    n14 = n32;
                    n18 = i;
                    break;
                }
                case 'a': {
                    final float n33 = array2[i + 5] + n11;
                    final float n34 = array2[i + 6] + n12;
                    final float n35 = array2[i + 0];
                    final float n36 = array2[i + 1];
                    final float n37 = array2[i + 2];
                    final boolean b = array2[i + 3] != 0.0f;
                    final boolean b2 = array2[i + 4] != 0.0f;
                    final float n38 = n11;
                    final float n39 = n12;
                    final boolean b3 = b;
                    n18 = i;
                    drawArc(path, n38, n39, n33, n34, n35, n36, n37, b3, b2);
                    n11 = n38 + array2[n18 + 5];
                    n12 = n39 + array2[n18 + 6];
                    n13 = n11;
                    n14 = n12;
                    break;
                }
                case 'V': {
                    n18 = i;
                    path.lineTo(n11, array2[i + 0]);
                    n12 = array2[n18 + 0];
                    break;
                }
                case 'T': {
                    final float n40 = n12;
                    final float n41 = n11;
                    n18 = i;
                    float n42 = n11;
                    float n43 = n12;
                    if (c3 == c8 || c3 == c6 || c3 == c4 || c3 == 'T') {
                        n42 = n41 * n17 - n13;
                        n43 = n40 * n17 - n14;
                    }
                    path.quadTo(n42, n43, array2[n18 + 0], array2[n18 + 1]);
                    n11 = array2[n18 + 0];
                    n12 = array2[n18 + 1];
                    n13 = n42;
                    n14 = n43;
                    break;
                }
                case 'S': {
                    final float n44 = n12;
                    final float n45 = n11;
                    n18 = i;
                    if (c3 == c9 || c3 == c7 || c3 == c5 || c3 == 'S') {
                        n11 = n45 * n17 - n13;
                        n12 = n44 * n17 - n14;
                    }
                    path.cubicTo(n11, n12, array2[n18 + 0], array2[n18 + 1], array2[n18 + 2], array2[n18 + 3]);
                    final float n46 = array2[n18 + 0];
                    final float n47 = array2[n18 + 1];
                    final float n48 = array2[n18 + 2];
                    final float n49 = array2[n18 + 3];
                    n13 = n46;
                    n14 = n47;
                    n11 = n48;
                    n12 = n49;
                    break;
                }
                case 'Q': {
                    n18 = i;
                    path.quadTo(array2[i + 0], array2[n18 + 1], array2[n18 + 2], array2[n18 + 3]);
                    final float n50 = array2[n18 + 0];
                    final float n51 = array2[n18 + 1];
                    n11 = array2[n18 + 2];
                    n12 = array2[n18 + 3];
                    n13 = n50;
                    n14 = n51;
                    break;
                }
                case 'M': {
                    n18 = i;
                    n11 = array2[i + 0];
                    n12 = array2[n18 + 1];
                    if (n18 > 0) {
                        path.lineTo(array2[n18 + 0], array2[n18 + 1]);
                        break;
                    }
                    path.moveTo(array2[n18 + 0], array2[n18 + 1]);
                    n15 = n11;
                    n16 = n12;
                    break;
                }
                case 'L': {
                    n18 = i;
                    path.lineTo(array2[i + 0], array2[n18 + 1]);
                    n11 = array2[n18 + 0];
                    n12 = array2[n18 + 1];
                    break;
                }
                case 'H': {
                    n18 = i;
                    path.lineTo(array2[i + 0], n12);
                    n11 = array2[n18 + 0];
                    break;
                }
                case 'C': {
                    n18 = i;
                    path.cubicTo(array2[i + 0], array2[n18 + 1], array2[n18 + 2], array2[n18 + 3], array2[n18 + 4], array2[n18 + 5]);
                    n11 = array2[n18 + 4];
                    n12 = array2[n18 + 5];
                    final float n52 = array2[n18 + 2];
                    final float n53 = array2[n18 + 3];
                    n13 = n52;
                    n14 = n53;
                    break;
                }
                case 'A': {
                    final float n54 = n12;
                    final float n55 = n11;
                    n18 = i;
                    drawArc(path, n55, n54, array2[i + 5], array2[n18 + 6], array2[n18 + 0], array2[n18 + 1], array2[n18 + 2], array2[n18 + 3] != 0.0f, array2[n18 + 4] != 0.0f);
                    n11 = array2[n18 + 5];
                    n12 = array2[n18 + 6];
                    n13 = n11;
                    n14 = n12;
                    break;
                }
            }
            c3 = c2;
            i = n18 + n10;
        }
        array[0] = n11;
        array[1] = n12;
        array[2] = n13;
        array[3] = n14;
        array[n6] = n15;
        array[n8] = n16;
    }
    
    private static void arcToBezier(final Path path, final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8, final double n9) {
        double n10 = n3;
        final int n11 = (int)Math.ceil(Math.abs(n9 * 4.0 / 3.141592653589793));
        final double cos = Math.cos(n7);
        final double sin = Math.sin(n7);
        double cos2 = Math.cos(n8);
        double sin2 = Math.sin(n8);
        final double n12 = -n3 * cos * sin2 - n4 * sin * cos2;
        final double n13 = -n3 * sin * sin2 + n4 * cos * cos2;
        final double n14 = n11;
        Double.isNaN(n14);
        double n15 = n9 / n14;
        double n16 = n12;
        double n17 = n13;
        double n18 = n5;
        double n19 = n6;
        int i = 0;
        double n20 = n8;
        while (i < n11) {
            final double n21 = n20 + n15;
            final double sin3 = Math.sin(n21);
            final double cos3 = Math.cos(n21);
            final double n22 = n + n10 * cos * cos3;
            final double n23 = n4 * sin * sin3;
            final double n24 = n15;
            final double n25 = n22 - n23;
            final double n26 = n2 + n10 * sin * cos3;
            final double n27 = n4 * cos * sin3;
            final double n28 = cos2;
            final double n29 = n26 + n27;
            final double n30 = sin2;
            final double n31 = -n10 * cos * sin3 - n4 * sin * cos3;
            final double n32 = -n10 * sin * sin3 + n4 * cos * cos3;
            final double tan = Math.tan((n21 - n20) / 2.0);
            final double sin4 = Math.sin(n21 - n20);
            final double n33 = 3.0;
            final double n34 = sin4 * (Math.sqrt(tan * n33 * tan + 4.0) - 1.0) / n33;
            final double n35 = n18 + n34 * n16;
            final double n36 = n19 + n34 * n17;
            final double n37 = n25 - n34 * n31;
            final double n38 = n34 * n32;
            final double n39 = n32;
            final double n40 = n29 - n38;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float)n35, (float)n36, (float)n37, (float)n40, (float)n25, (float)n29);
            n20 = n21;
            n18 = n25;
            n19 = n29;
            n16 = n31;
            n17 = n39;
            ++i;
            sin2 = n30;
            n15 = n24;
            cos2 = n28;
            n10 = n3;
        }
    }
    
    private static void drawArc(final Path path, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final boolean b, final boolean b2) {
        final double radians = Math.toRadians(n7);
        final double cos = Math.cos(radians);
        final double sin = Math.sin(radians);
        final double n8 = n;
        Double.isNaN(n8);
        final double n9 = n8 * cos;
        final double n10 = n2;
        Double.isNaN(n10);
        final double n11 = n9 + n10 * sin;
        final double n12 = n5;
        Double.isNaN(n12);
        final double n13 = n11 / n12;
        final double n14 = -n;
        Double.isNaN(n14);
        final double n15 = n14 * sin;
        final double n16 = n2;
        Double.isNaN(n16);
        final double n17 = n15 + n16 * cos;
        final double n18 = n6;
        Double.isNaN(n18);
        final double n19 = n17 / n18;
        final double n20 = n3;
        Double.isNaN(n20);
        final double n21 = n20 * cos;
        final double n22 = n4;
        Double.isNaN(n22);
        final double n23 = n21 + n22 * sin;
        final double n24 = n5;
        Double.isNaN(n24);
        final double n25 = n23 / n24;
        final double n26 = -n3;
        Double.isNaN(n26);
        final double n27 = n26 * sin;
        final double n28 = n4;
        Double.isNaN(n28);
        final double n29 = n27 + n28 * cos;
        final double n30 = n6;
        Double.isNaN(n30);
        final double n31 = n29 / n30;
        final double n32 = n13 - n25;
        final double n33 = n19 - n31;
        final double n34 = n13 + n25;
        final double n35 = 2.0;
        final double n36 = n34 / n35;
        final double n37 = (n19 + n31) / n35;
        final double n38 = n32 * n32 + n33 * n33;
        final double n39 = 0.0;
        if (n38 == n39) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        final double n40 = 1.0 / n38 - 0.25;
        if (n40 < n39) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Points are too far apart ");
            sb.append(n38);
            Log.w("PathParser", sb.toString());
            final float n41 = (float)(Math.sqrt(n38) / 1.99999);
            drawArc(path, n, n2, n3, n4, n5 * n41, n6 * n41, n7, b, b2);
            return;
        }
        final double sqrt = Math.sqrt(n40);
        final double n42 = sqrt * n32;
        final double n43 = sqrt * n33;
        double n44;
        double n45;
        if (b == b2) {
            n44 = n36 - n43;
            n45 = n37 + n42;
        }
        else {
            n44 = n36 + n43;
            n45 = n37 - n42;
        }
        final double atan2 = Math.atan2(n19 - n45, n13 - n44);
        double n46 = Math.atan2(n31 - n45, n25 - n44) - atan2;
        if (b2 != n46 >= 0.0) {
            final double n47 = 6.283185307179586;
            if (n46 > 0.0) {
                n46 -= n47;
            }
            else {
                n46 += n47;
            }
        }
        final double n48 = n5;
        Double.isNaN(n48);
        final double n49 = n44 * n48;
        final double n50 = n6;
        Double.isNaN(n50);
        final double n51 = n50 * n45;
        arcToBezier(path, n49 * cos - n51 * sin, n49 * sin + n51 * cos, n5, n6, n, n2, radians, atan2, n46);
    }
    
    public static void nodesToPath(final PathParser$PathDataNode[] array, final Path path) {
        final float[] array2 = new float[6];
        char mType = 'm';
        for (int i = 0; i < array.length; ++i) {
            addCommand(path, array2, mType, array[i].mType, array[i].mParams);
            mType = array[i].mType;
        }
    }
    
    public void interpolatePathDataNode(final PathParser$PathDataNode pathParser$PathDataNode, final PathParser$PathDataNode pathParser$PathDataNode2, final float n) {
        int n2 = 0;
        while (true) {
            final float[] mParams = pathParser$PathDataNode.mParams;
            if (n2 >= mParams.length) {
                break;
            }
            this.mParams[n2] = mParams[n2] * (1.0f - n) + pathParser$PathDataNode2.mParams[n2] * n;
            ++n2;
        }
    }
}
