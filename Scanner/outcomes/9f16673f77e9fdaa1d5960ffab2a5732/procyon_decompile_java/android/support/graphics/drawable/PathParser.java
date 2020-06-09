// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.Path;
import java.util.ArrayList;

class PathParser
{
    private static final String LOGTAG = "PathParser";
    
    private static void addNode(final ArrayList list, final char c, final float[] array) {
        list.add(new PathParser$PathDataNode(c, array));
    }
    
    public static boolean canMorph(final PathParser$PathDataNode[] array, final PathParser$PathDataNode[] array2) {
        if (array == null || array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i].mType != array2[i].mType || array[i].mParams.length != array2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }
    
    static float[] copyOfRange(final float[] array, final int n, final int n2) {
        if (n > n2) {
            throw new IllegalArgumentException();
        }
        final int length = array.length;
        if (n >= 0 && n <= length) {
            final int n3 = n2 - n;
            final int min = Math.min(n3, length - n);
            final float[] array2 = new float[n3];
            System.arraycopy(array, n, array2, 0, min);
            return array2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public static PathParser$PathDataNode[] createNodesFromPathData(final String s) {
        if (s == null) {
            return null;
        }
        int n = 0;
        int i = 1;
        final ArrayList list = new ArrayList();
        while (i < s.length()) {
            final int nextStart = nextStart(s, i);
            final String trim = s.substring(n, nextStart).trim();
            if (trim.length() > 0) {
                addNode(list, trim.charAt(0), getFloats(trim));
            }
            n = nextStart;
            i = nextStart + 1;
        }
        if (i - n == 1 && n < s.length()) {
            addNode(list, s.charAt(n), new float[0]);
        }
        return list.toArray(new PathParser$PathDataNode[list.size()]);
    }
    
    public static Path createPathFromPathData(final String s) {
        final Path path = new Path();
        final PathParser$PathDataNode[] nodesFromPathData = createNodesFromPathData(s);
        if (nodesFromPathData != null) {
            final PathParser$PathDataNode[] array = nodesFromPathData;
            try {
                PathParser$PathDataNode.nodesToPath(array, path);
                return path;
            }
            catch (RuntimeException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Error in parsing ");
                sb.append(s);
                throw new RuntimeException(sb.toString(), ex);
            }
        }
        return null;
    }
    
    public static PathParser$PathDataNode[] deepCopyNodes(final PathParser$PathDataNode[] array) {
        if (array == null) {
            return null;
        }
        final PathParser$PathDataNode[] array2 = new PathParser$PathDataNode[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new PathParser$PathDataNode(array[i]);
        }
        return array2;
    }
    
    private static void extract(final String s, final int n, final PathParser$ExtractFloatResult pathParser$ExtractFloatResult) {
        int i = n;
        boolean b = false;
        pathParser$ExtractFloatResult.mEndWithNegOrDot = false;
        int n2 = 0;
        int n3 = 0;
        while (i < s.length()) {
            final int n4 = n3;
            n3 = 0;
            final char char1 = s.charAt(i);
            Label_0168: {
                if (char1 != ' ') {
                    if (char1 == 'E' || char1 == 'e') {
                        n3 = 1;
                        break Label_0168;
                    }
                    final boolean b2 = true;
                    switch (char1) {
                        default: {
                            break Label_0168;
                        }
                        case 46: {
                            if (n2 == 0) {
                                n2 = 1;
                                break Label_0168;
                            }
                            b = true;
                            pathParser$ExtractFloatResult.mEndWithNegOrDot = b2;
                            break Label_0168;
                        }
                        case 45: {
                            if (i != n && n4 == 0) {
                                b = true;
                                pathParser$ExtractFloatResult.mEndWithNegOrDot = b2;
                            }
                            break Label_0168;
                        }
                        case 44: {
                            break;
                        }
                    }
                }
                b = true;
            }
            if (b) {
                break;
            }
            ++i;
        }
        pathParser$ExtractFloatResult.mEndPosition = i;
    }
    
    private static float[] getFloats(final String s) {
        final char char1 = s.charAt(0);
        int n = true ? 1 : 0;
        final boolean b = char1 == 'z';
        if (s.charAt(0) != 'Z') {
            n = (false ? 1 : 0);
        }
        if (((b ? 1 : 0) | n) != 0x0) {
            return new float[0];
        }
        try {
            final int length = s.length();
            try {
                final float[] array = new float[length];
                int n2 = 0;
                int n3 = 1;
                try {
                    final PathParser$ExtractFloatResult pathParser$ExtractFloatResult = new PathParser$ExtractFloatResult();
                    final int length2 = s.length();
                    while (true) {
                        Label_0200: {
                            if (n3 >= length2) {
                                break Label_0200;
                            }
                            extract(s, n3, pathParser$ExtractFloatResult);
                            Label_0172: {
                                final int mEndPosition;
                                if (n3 >= (mEndPosition = pathParser$ExtractFloatResult.mEndPosition)) {
                                    break Label_0172;
                                }
                                final int n4 = n2 + 1;
                                final String substring = s.substring(n3, mEndPosition);
                                try {
                                    array[n2] = Float.parseFloat(substring);
                                    n2 = n4;
                                    if (pathParser$ExtractFloatResult.mEndWithNegOrDot) {
                                        n3 = mEndPosition;
                                        continue;
                                    }
                                    n3 = mEndPosition + 1;
                                    continue;
                                    return copyOfRange(array, 0, n2);
                                }
                                catch (NumberFormatException ex) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("error in parsing \"");
                                    sb.append(s);
                                    sb.append("\"");
                                    throw new RuntimeException(sb.toString(), ex);
                                }
                            }
                        }
                    }
                }
                catch (NumberFormatException ex2) {}
            }
            catch (NumberFormatException ex3) {}
        }
        catch (NumberFormatException ex4) {}
    }
    
    private static int nextStart(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (((char1 - 65) * (char1 - 90) <= 0 || (char1 - 97) * (char1 - 122) <= 0) && char1 != 'e' && char1 != 'E') {
                return i;
            }
            ++i;
        }
        return i;
    }
    
    public static void updateNodes(final PathParser$PathDataNode[] array, final PathParser$PathDataNode[] array2) {
        for (int i = 0; i < array2.length; ++i) {
            array[i].mType = array2[i].mType;
            for (int j = 0; j < array2[i].mParams.length; ++j) {
                array[i].mParams[j] = array2[i].mParams[j];
            }
        }
    }
}
