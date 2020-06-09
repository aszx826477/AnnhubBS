// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.text.method.TransformationMethod;
import android.widget.TextView;

class PagerTitleStripIcs
{
    public static void setSingleLineAllCaps(final TextView textView) {
        textView.setTransformationMethod((TransformationMethod)new PagerTitleStripIcs$SingleLineAllCapsTransform(textView.getContext()));
    }
}
