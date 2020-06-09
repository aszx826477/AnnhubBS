// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.Resources;
import android.content.res.TypedArray;

class VectorDrawableCompat$VClipPath extends VectorDrawableCompat$VPath
{
    public VectorDrawableCompat$VClipPath() {
    }
    
    public VectorDrawableCompat$VClipPath(final VectorDrawableCompat$VClipPath vectorDrawableCompat$VClipPath) {
        super(vectorDrawableCompat$VClipPath);
    }
    
    private void updateStateFromTypedArray(final TypedArray typedArray) {
        final String string = typedArray.getString(0);
        if (string != null) {
            this.mPathName = string;
        }
        final String string2 = typedArray.getString(1);
        if (string2 != null) {
            this.mNodes = PathParser.createNodesFromPathData(string2);
        }
    }
    
    public void inflate(final Resources resources, final AttributeSet set, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser) {
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            return;
        }
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
        this.updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
    }
    
    public boolean isClipPath() {
        return true;
    }
}
