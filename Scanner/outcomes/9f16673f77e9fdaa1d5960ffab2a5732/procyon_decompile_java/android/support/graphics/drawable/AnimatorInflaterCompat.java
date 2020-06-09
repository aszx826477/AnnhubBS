// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.animation.AnimatorInflater;
import android.os.Build$VERSION;
import android.animation.TypeEvaluator;
import android.view.InflateException;
import java.io.Serializable;
import android.util.Log;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.content.res.TypedArray;
import java.util.Iterator;
import java.util.ArrayList;
import android.animation.ValueAnimator;
import android.util.AttributeSet;
import android.animation.AnimatorSet;
import android.util.Xml;
import android.animation.Animator;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.Context;
import android.util.TypedValue;

public class AnimatorInflaterCompat
{
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int SEQUENTIALLY = 1;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;
    private static final TypedValue sTmpTypedValue;
    
    static {
        sTmpTypedValue = new TypedValue();
    }
    
    private static Animator createAnimatorFromXml(final Context context, final Resources resources, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser, final float n) {
        return createAnimatorFromXml(context, resources, resources$Theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, n);
    }
    
    private static Animator createAnimatorFromXml(final Context context, final Resources resources, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser, final AttributeSet set, final AnimatorSet set2, final int n, final float n2) {
        final int depth = xmlPullParser.getDepth();
        Object o = null;
        ArrayList<ValueAnimator> list = null;
        while (true) {
            int next;
            while ((next = xmlPullParser.next()) != 3 || xmlPullParser.getDepth() > depth) {
                if (next == 1) {
                    if (set2 != null && list != null) {
                        final Animator[] array = new Animator[list.size()];
                        int n3 = 0;
                        for (final Animator animator : list) {
                            final int n4 = n3 + 1;
                            array[n3] = animator;
                            n3 = n4;
                        }
                        if (n == 0) {
                            set2.playTogether(array);
                        }
                        else {
                            set2.playSequentially(array);
                        }
                    }
                    return (Animator)o;
                }
                if (next != 2) {
                    continue;
                }
                final String name = xmlPullParser.getName();
                boolean b = false;
                if (name.equals("objectAnimator")) {
                    o = loadObjectAnimator(context, resources, resources$Theme, set, n2, xmlPullParser);
                }
                else if (name.equals("animator")) {
                    o = loadAnimator(context, resources, resources$Theme, set, null, n2, xmlPullParser);
                }
                else if (name.equals("set")) {
                    final AnimatorSet set3 = new AnimatorSet();
                    final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_ANIMATOR_SET);
                    createAnimatorFromXml(context, resources, resources$Theme, xmlPullParser, set, set3, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), n2);
                    obtainAttributes.recycle();
                    o = set3;
                }
                else {
                    if (!name.equals("propertyValuesHolder")) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown animator name: ");
                        sb.append(xmlPullParser.getName());
                        throw new RuntimeException(sb.toString());
                    }
                    final PropertyValuesHolder[] loadValues = loadValues(context, resources, resources$Theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                    if (loadValues != null && o != null && o instanceof ValueAnimator) {
                        ((ValueAnimator)o).setValues(loadValues);
                    }
                    b = true;
                }
                if (set2 == null || b) {
                    continue;
                }
                if (list == null) {
                    list = new ArrayList<ValueAnimator>();
                }
                list.add((ValueAnimator)o);
            }
            continue;
        }
    }
    
    private static Keyframe createNewKeyframe(final Keyframe keyframe, final float n) {
        Keyframe keyframe2;
        if (keyframe.getType() == Float.TYPE) {
            keyframe2 = Keyframe.ofFloat(n);
        }
        else if (keyframe.getType() == Integer.TYPE) {
            keyframe2 = Keyframe.ofInt(n);
        }
        else {
            keyframe2 = Keyframe.ofObject(n);
        }
        return keyframe2;
    }
    
    private static void distributeKeyframes(final Keyframe[] array, final float n, final int n2, final int n3) {
        final float n4 = n / (n3 - n2 + 2);
        for (int i = n2; i <= n3; ++i) {
            array[i].setFraction(array[i - 1].getFraction() + n4);
        }
    }
    
    private static void dumpKeyframes(final Object[] array, final String s) {
        if (array != null && array.length != 0) {
            Log.d("AnimatorInflater", s);
            for (int length = array.length, i = 0; i < length; ++i) {
                final Keyframe keyframe = (Keyframe)array[i];
                final String s2 = "AnimatorInflater";
                final StringBuilder sb = new StringBuilder();
                sb.append("Keyframe ");
                sb.append(i);
                sb.append(": fraction ");
                Serializable value;
                if (keyframe.getFraction() < 0.0f) {
                    value = "null";
                }
                else {
                    value = keyframe.getFraction();
                }
                sb.append(value);
                sb.append(", ");
                sb.append(", value : ");
                Object value2;
                if (keyframe.hasValue()) {
                    value2 = keyframe.getValue();
                }
                else {
                    value2 = "null";
                }
                sb.append(value2);
                Log.d(s2, sb.toString());
            }
        }
    }
    
    private static PropertyValuesHolder getPVH(final TypedArray typedArray, final int n, final int n2, final int n3, final String s) {
        final TypedValue peekValue = typedArray.peekValue(n2);
        final boolean b = peekValue != null;
        int type;
        if (b) {
            type = peekValue.type;
        }
        else {
            type = 0;
        }
        final TypedValue peekValue2 = typedArray.peekValue(n3);
        final boolean b2 = peekValue2 != null;
        int type2;
        if (b2) {
            type2 = peekValue2.type;
        }
        else {
            type2 = 0;
        }
        int n4;
        if (n == 4) {
            if ((!b || !isColorType(type)) && (!b2 || !isColorType(type2))) {
                n4 = 0;
            }
            else {
                n4 = 3;
            }
        }
        else {
            n4 = n;
        }
        final boolean b3 = n4 == 0;
        PropertyValuesHolder propertyValuesHolder;
        if (n4 == 2) {
            final String string = typedArray.getString(n2);
            final String string2 = typedArray.getString(n3);
            final PathParser$PathDataNode[] nodesFromPathData = PathParser.createNodesFromPathData(string);
            final PathParser$PathDataNode[] nodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (nodesFromPathData != null || nodesFromPathData2 != null) {
                if (nodesFromPathData != null) {
                    final AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator((AnimatorInflaterCompat$1)null);
                    if (nodesFromPathData2 != null) {
                        if (!PathParser.canMorph(nodesFromPathData, nodesFromPathData2)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append(" Can't morph from ");
                            sb.append(string);
                            sb.append(" to ");
                            sb.append(string2);
                            throw new InflateException(sb.toString());
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofObject(s, (TypeEvaluator)animatorInflaterCompat$PathDataEvaluator, new Object[] { nodesFromPathData, nodesFromPathData2 });
                    }
                    else {
                        propertyValuesHolder = PropertyValuesHolder.ofObject(s, (TypeEvaluator)animatorInflaterCompat$PathDataEvaluator, new Object[] { nodesFromPathData });
                    }
                    return propertyValuesHolder;
                }
                if (nodesFromPathData2 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofObject(s, (TypeEvaluator)new AnimatorInflaterCompat$PathDataEvaluator((AnimatorInflaterCompat$1)null), new Object[] { nodesFromPathData2 });
                    return propertyValuesHolder;
                }
            }
            propertyValuesHolder = null;
        }
        else {
            final int n5 = type2;
            Object instance = null;
            if (n4 == 3) {
                instance = ArgbEvaluator.getInstance();
            }
            final int n6 = 5;
            if (b3) {
                if (b) {
                    float n7;
                    if (type == n6) {
                        n7 = typedArray.getDimension(n2, 0.0f);
                    }
                    else {
                        n7 = typedArray.getFloat(n2, 0.0f);
                    }
                    if (b2) {
                        float n8;
                        if (n5 == n6) {
                            n8 = typedArray.getDimension(n3, 0.0f);
                        }
                        else {
                            n8 = typedArray.getFloat(n3, 0.0f);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(s, new float[] { n7, n8 });
                    }
                    else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(s, new float[] { n7 });
                    }
                }
                else {
                    float n9;
                    if (n5 == n6) {
                        n9 = typedArray.getDimension(n3, 0.0f);
                    }
                    else {
                        n9 = typedArray.getFloat(n3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(s, new float[] { n9 });
                }
            }
            else {
                final int n10 = n5;
                if (b) {
                    int n11;
                    if (type == n6) {
                        n11 = (int)typedArray.getDimension(n2, 0.0f);
                    }
                    else if (isColorType(type)) {
                        n11 = typedArray.getColor(n2, 0);
                    }
                    else {
                        n11 = typedArray.getInt(n2, 0);
                    }
                    if (b2) {
                        int n12;
                        if (n10 == n6) {
                            n12 = (int)typedArray.getDimension(n3, 0.0f);
                        }
                        else if (isColorType(n10)) {
                            n12 = typedArray.getColor(n3, 0);
                        }
                        else {
                            n12 = typedArray.getInt(n3, 0);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofInt(s, new int[] { n11, n12 });
                    }
                    else {
                        propertyValuesHolder = PropertyValuesHolder.ofInt(s, new int[] { n11 });
                    }
                }
                else if (b2) {
                    int n13;
                    if (n5 == n6) {
                        n13 = (int)typedArray.getDimension(n3, 0.0f);
                    }
                    else if (isColorType(n5)) {
                        n13 = typedArray.getColor(n3, 0);
                    }
                    else {
                        n13 = typedArray.getInt(n3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(s, new int[] { n13 });
                }
                else {
                    propertyValuesHolder = null;
                }
            }
            if (propertyValuesHolder != null && instance != null) {
                propertyValuesHolder.setEvaluator((TypeEvaluator)instance);
            }
        }
        return propertyValuesHolder;
    }
    
    private static int inferValueTypeFromValues(final TypedArray typedArray, final int n, final int n2) {
        final TypedValue peekValue = typedArray.peekValue(n);
        boolean b = true;
        int type = 0;
        final boolean b2 = peekValue != null;
        int type2;
        if (b2) {
            type2 = peekValue.type;
        }
        else {
            type2 = 0;
        }
        final TypedValue peekValue2 = typedArray.peekValue(n2);
        if (peekValue2 == null) {
            b = false;
        }
        if (b) {
            type = peekValue2.type;
        }
        int n3;
        if ((!b2 || !isColorType(type2)) && (!b || !isColorType(type))) {
            n3 = 0;
        }
        else {
            n3 = 3;
        }
        return n3;
    }
    
    private static int inferValueTypeOfKeyframe(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_KEYFRAME);
        boolean b = false;
        final TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null) {
            b = true;
        }
        int n;
        if (b && isColorType(peekNamedValue.type)) {
            n = 3;
        }
        else {
            n = 0;
        }
        obtainAttributes.recycle();
        return n;
    }
    
    private static boolean isColorType(final int n) {
        return n >= 28 && n <= 31;
    }
    
    public static Animator loadAnimator(final Context context, final int n) {
        Animator animator;
        if (Build$VERSION.SDK_INT >= 24) {
            animator = AnimatorInflater.loadAnimator(context, n);
        }
        else {
            animator = loadAnimator(context, context.getResources(), context.getTheme(), n);
        }
        return animator;
    }
    
    public static Animator loadAnimator(final Context context, final Resources resources, final Resources$Theme resources$Theme, final int n) {
        return loadAnimator(context, resources, resources$Theme, n, 1.0f);
    }
    
    public static Animator loadAnimator(final Context context, final Resources resources, final Resources$Theme resources$Theme, final int n, final float n2) {
        XmlResourceParser animation = null;
        try {
            try {
                final Animator animatorFromXml = createAnimatorFromXml(context, resources, resources$Theme, (XmlPullParser)(animation = resources.getAnimation(n)), n2);
                if (animation != null) {
                    animation.close();
                }
                return animatorFromXml;
            }
            finally {
                if (animation != null) {
                    animation.close();
                }
            }
        }
        catch (IOException ex) {}
        catch (XmlPullParserException ex2) {}
    }
    
    private static ValueAnimator loadAnimator(final Context context, final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, ValueAnimator valueAnimator, final float n, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_ANIMATOR);
        final TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, n, xmlPullParser);
        final int namedResId = TypedArrayUtils.getNamedResId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResId > 0) {
            valueAnimator.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator(context, namedResId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }
    
    private static Keyframe loadKeyframe(final Context context, final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, int n, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_KEYFRAME);
        Keyframe keyframe = null;
        final String s = "fraction";
        final int n2 = 3;
        final float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, s, n2, -1.0f);
        final TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        final int n3 = 1;
        final boolean b = peekNamedValue != null;
        if (n == 4) {
            if (b && isColorType(peekNamedValue.type)) {
                n = 3;
            }
            else {
                n = 0;
            }
        }
        if (b) {
            Label_0223: {
                if (n != n2) {
                    switch (n) {
                        default: {
                            break Label_0223;
                        }
                        case 0: {
                            keyframe = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
                            break Label_0223;
                        }
                        case 1: {
                            break;
                        }
                    }
                }
                keyframe = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0));
            }
        }
        else {
            Keyframe keyframe2;
            if (n == 0) {
                keyframe2 = Keyframe.ofFloat(namedFloat);
            }
            else {
                keyframe2 = Keyframe.ofInt(namedFloat);
            }
            keyframe = keyframe2;
        }
        final int namedResId = TypedArrayUtils.getNamedResId(obtainAttributes, xmlPullParser, "interpolator", n3, 0);
        if (namedResId > 0) {
            keyframe.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator(context, namedResId));
        }
        obtainAttributes.recycle();
        return keyframe;
    }
    
    private static ObjectAnimator loadObjectAnimator(final Context context, final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final float n, final XmlPullParser xmlPullParser) {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, resources$Theme, set, (ValueAnimator)objectAnimator, n, xmlPullParser);
        return objectAnimator;
    }
    
    private static PropertyValuesHolder loadPvh(final Context context, final Resources resources, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser, final String s, final int n) {
        ArrayList<Keyframe> list = null;
        int inferValueTypeOfKeyframe = n;
        int next;
        while ((next = xmlPullParser.next()) != 3 && next != 1) {
            if (xmlPullParser.getName().equals("keyframe")) {
                if (inferValueTypeOfKeyframe == 4) {
                    inferValueTypeOfKeyframe = inferValueTypeOfKeyframe(resources, resources$Theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                final Keyframe loadKeyframe = loadKeyframe(context, resources, resources$Theme, Xml.asAttributeSet(xmlPullParser), inferValueTypeOfKeyframe, xmlPullParser);
                if (loadKeyframe != null) {
                    if (list == null) {
                        list = new ArrayList<Keyframe>();
                    }
                    list.add(loadKeyframe);
                }
                xmlPullParser.next();
            }
        }
        int size;
        PropertyValuesHolder ofKeyframe;
        if (list != null && (size = list.size()) > 0) {
            final Keyframe keyframe = list.get(0);
            final Keyframe keyframe2 = list.get(size - 1);
            final float fraction = keyframe2.getFraction();
            final float fraction2 = 1.0f;
            if (fraction < fraction2) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(fraction2);
                }
                else {
                    list.add(list.size(), createNewKeyframe(keyframe2, fraction2));
                    ++size;
                }
            }
            final float fraction3 = keyframe.getFraction();
            if (fraction3 != 0.0f) {
                if (fraction3 < 0.0f) {
                    keyframe.setFraction(0.0f);
                }
                else {
                    list.add(0, createNewKeyframe(keyframe, 0.0f));
                    ++size;
                }
            }
            final Keyframe[] array = new Keyframe[size];
            list.toArray(array);
            ArrayList<Keyframe> list2;
            int n2;
            for (int i = 0; i < size; ++i, list = list2, next = n2) {
                final Keyframe keyframe3 = array[i];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i == 0) {
                        keyframe3.setFraction(0.0f);
                        list2 = list;
                        n2 = next;
                    }
                    else if (i == size - 1) {
                        keyframe3.setFraction(1.0f);
                        list2 = list;
                        n2 = next;
                    }
                    else {
                        final int n3 = i;
                        int n4 = i + 1;
                        list2 = list;
                        int n5 = i;
                        while (true) {
                            n2 = next;
                            if (n4 >= size - 1) {
                                break;
                            }
                            if (array[n4].getFraction() >= 0.0f) {
                                break;
                            }
                            n5 = n4;
                            ++n4;
                            next = n2;
                        }
                        distributeKeyframes(array, array[n5 + 1].getFraction() - array[n3 - 1].getFraction(), n3, n5);
                    }
                }
                else {
                    list2 = list;
                    n2 = next;
                }
            }
            ofKeyframe = PropertyValuesHolder.ofKeyframe(s, array);
            if (inferValueTypeOfKeyframe == 3) {
                ofKeyframe.setEvaluator((TypeEvaluator)ArgbEvaluator.getInstance());
            }
        }
        else {
            ofKeyframe = null;
        }
        return ofKeyframe;
    }
    
    private static PropertyValuesHolder[] loadValues(final Context context, final Resources resources, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser, final AttributeSet set) {
        ArrayList<PropertyValuesHolder> list = null;
        while (true) {
            final int eventType;
            final int n = eventType = xmlPullParser.getEventType();
            final int n2 = 3;
            if (n == n2) {
                break;
            }
            final int n3 = 1;
            if (n == n3) {
                break;
            }
            final int n4 = 2;
            if (eventType != n4) {
                xmlPullParser.next();
            }
            else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    final String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "propertyName", n2);
                    final int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "valueType", n4, 4);
                    PropertyValuesHolder propertyValuesHolder = loadPvh(context, resources, resources$Theme, xmlPullParser, namedString, namedInt);
                    if (propertyValuesHolder == null) {
                        propertyValuesHolder = getPVH(obtainAttributes, namedInt, 0, n3, namedString);
                    }
                    if (propertyValuesHolder != null) {
                        if (list == null) {
                            list = new ArrayList<PropertyValuesHolder>();
                        }
                        list.add(propertyValuesHolder);
                    }
                    obtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        PropertyValuesHolder[] array = null;
        if (list != null) {
            final int size = list.size();
            array = new PropertyValuesHolder[size];
            for (int i = 0; i < size; ++i) {
                array[i] = list.get(i);
            }
        }
        return array;
    }
    
    private static void parseAnimatorFromTypeArray(final ValueAnimator valueAnimator, final TypedArray typedArray, final TypedArray typedArray2, final float n, final XmlPullParser xmlPullParser) {
        final int n2 = 1;
        final long duration = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", n2, 300);
        final long startDelay = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        final String s = "valueType";
        final int n3 = 4;
        int n4 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, s, 7, n3);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            final int n5 = 6;
            final int n6 = 5;
            if (n4 == n3) {
                n4 = inferValueTypeFromValues(typedArray, n6, n5);
            }
            final PropertyValuesHolder pvh = getPVH(typedArray, n4, n6, n5, "");
            if (pvh != null) {
                final PropertyValuesHolder[] values = new PropertyValuesHolder[n2];
                values[0] = pvh;
                valueAnimator.setValues(values);
            }
            valueAnimator.setDuration(duration);
            valueAnimator.setStartDelay(startDelay);
            valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
            valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", n3, n2));
            if (typedArray2 != null) {
                setupObjectAnimator(valueAnimator, typedArray2, n4, n, xmlPullParser);
            }
            return;
        }
        throw new IllegalArgumentException("no valueFrom or no valueTo");
    }
    
    private static void setupObjectAnimator(final ValueAnimator valueAnimator, final TypedArray typedArray, final int n, final float n2, final XmlPullParser xmlPullParser) {
        final ObjectAnimator objectAnimator = (ObjectAnimator)valueAnimator;
        if (TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1) != null) {
            Log.e("AnimatorInflater", "We don't support moving along path yet");
        }
        else {
            objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
        }
    }
}
