// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.content.res;

import android.support.v4.graphics.ColorUtils;
import android.graphics.Color;
import android.content.res.TypedArray;
import android.util.StateSet;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Xml;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;

final class AppCompatColorStateListInflater
{
    private static final int DEFAULT_COLOR = 16711680;
    
    public static ColorStateList createFromXml(final Resources resources, final XmlPullParser xmlPullParser, final Resources$Theme resources$Theme) {
        final AttributeSet attributeSet = Xml.asAttributeSet(xmlPullParser);
        int next;
        int n;
        int n2;
        do {
            n = (next = xmlPullParser.next());
            n2 = 2;
        } while (n != n2 && next != 1);
        if (next == n2) {
            return createFromXmlInner(resources, xmlPullParser, attributeSet, resources$Theme);
        }
        throw new XmlPullParserException("No start tag found");
    }
    
    private static ColorStateList createFromXmlInner(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        final String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, set, resources$Theme);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(": invalid color state list tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }
    
    private static ColorStateList inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        final int depth = xmlPullParser.getDepth();
        int n = 1;
        int n2 = depth + n;
        int n3 = -65536;
        int[][] array = new int[20][];
        int[] append = new int[array.length];
        int n4 = 0;
        while (true) {
            int next;
            while ((next = xmlPullParser.next()) != n) {
                final int depth2;
                if ((depth2 = xmlPullParser.getDepth()) < n2 && next == 3) {
                    final int[] array2 = new int[n4];
                    final int[][] array3 = new int[n4][];
                    System.arraycopy(append, 0, array2, 0, n4);
                    System.arraycopy(array, 0, array3, 0, n4);
                    return new ColorStateList(array3, array2);
                }
                int n13;
                int n14;
                if (next == 2 && depth2 <= n2) {
                    if (xmlPullParser.getName().equals("item")) {
                        final TypedArray obtainAttributes = obtainAttributes(resources, resources$Theme, set, R$styleable.ColorStateListItem);
                        final int color = obtainAttributes.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                        float n5 = 1.0f;
                        if (obtainAttributes.hasValue(R$styleable.ColorStateListItem_android_alpha)) {
                            n5 = obtainAttributes.getFloat(R$styleable.ColorStateListItem_android_alpha, n5);
                        }
                        else if (obtainAttributes.hasValue(R$styleable.ColorStateListItem_alpha)) {
                            n5 = obtainAttributes.getFloat(R$styleable.ColorStateListItem_alpha, n5);
                        }
                        obtainAttributes.recycle();
                        int attributeCount = set.getAttributeCount();
                        final int[] array4 = new int[attributeCount];
                        final int n6 = n2;
                        int n7 = 0;
                        int n8;
                        int n9;
                        for (int i = 0; i < attributeCount; ++i, attributeCount = n8, n3 = n9) {
                            n8 = attributeCount;
                            final int attributeNameResource = set.getAttributeNameResource(i);
                            n9 = n3;
                            if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha) {
                                final int n10 = n7 + 1;
                                int n11;
                                if (set.getAttributeBooleanValue(i, false)) {
                                    n11 = attributeNameResource;
                                }
                                else {
                                    n11 = -attributeNameResource;
                                }
                                array4[n7] = n11;
                                n7 = n10;
                            }
                        }
                        int n12 = n3;
                        final int[] trimStateSet = StateSet.trimStateSet(array4, n7);
                        final int modulateColorAlpha = modulateColorAlpha(color, n5);
                        if (n4 == 0 || trimStateSet.length == 0) {
                            n12 = modulateColorAlpha;
                        }
                        append = GrowingArrayUtils.append(append, n4, modulateColorAlpha);
                        array = (int[][])GrowingArrayUtils.append(array, n4, trimStateSet);
                        ++n4;
                        n2 = n6;
                        n3 = n12;
                        n = 1;
                        continue;
                    }
                    n13 = n2;
                    n14 = n3;
                }
                else {
                    n13 = n2;
                    n14 = n3;
                }
                n2 = n13;
                n3 = n14;
                n = 1;
            }
            continue;
        }
    }
    
    private static int modulateColorAlpha(final int n, final float n2) {
        return ColorUtils.setAlphaComponent(n, Math.round(Color.alpha(n) * n2));
    }
    
    private static TypedArray obtainAttributes(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final int[] array) {
        TypedArray typedArray;
        if (resources$Theme == null) {
            typedArray = resources.obtainAttributes(set, array);
        }
        else {
            typedArray = resources$Theme.obtainStyledAttributes(set, array, 0, 0);
        }
        return typedArray;
    }
}
