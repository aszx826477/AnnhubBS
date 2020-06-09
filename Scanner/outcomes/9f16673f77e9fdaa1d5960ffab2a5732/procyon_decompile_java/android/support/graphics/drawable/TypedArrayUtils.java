// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.util.TypedValue;
import android.util.AttributeSet;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;

class TypedArrayUtils
{
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
    
    public static boolean getNamedBoolean(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n, final boolean b) {
        if (!hasAttribute(xmlPullParser, s)) {
            return b;
        }
        return typedArray.getBoolean(n, b);
    }
    
    public static int getNamedColor(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n, final int n2) {
        if (!hasAttribute(xmlPullParser, s)) {
            return n2;
        }
        return typedArray.getColor(n, n2);
    }
    
    public static float getNamedFloat(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n, final float n2) {
        if (!hasAttribute(xmlPullParser, s)) {
            return n2;
        }
        return typedArray.getFloat(n, n2);
    }
    
    public static int getNamedInt(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n, final int n2) {
        if (!hasAttribute(xmlPullParser, s)) {
            return n2;
        }
        return typedArray.getInt(n, n2);
    }
    
    public static int getNamedResId(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n, final int n2) {
        if (!hasAttribute(xmlPullParser, s)) {
            return n2;
        }
        return typedArray.getResourceId(n, n2);
    }
    
    public static String getNamedString(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n) {
        if (!hasAttribute(xmlPullParser, s)) {
            return null;
        }
        return typedArray.getString(n);
    }
    
    public static boolean hasAttribute(final XmlPullParser xmlPullParser, final String s) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", s) != null;
    }
    
    public static TypedArray obtainAttributes(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final int[] array) {
        if (resources$Theme == null) {
            return resources.obtainAttributes(set, array);
        }
        return resources$Theme.obtainStyledAttributes(set, array, 0, 0);
    }
    
    public static TypedValue peekNamedValue(final TypedArray typedArray, final XmlPullParser xmlPullParser, final String s, final int n) {
        if (!hasAttribute(xmlPullParser, s)) {
            return null;
        }
        return typedArray.peekValue(n);
    }
}
