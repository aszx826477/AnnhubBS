// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.animation.TypeEvaluator;

class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator
{
    private PathParser$PathDataNode[] mNodeArray;
    
    private AnimatorInflaterCompat$PathDataEvaluator() {
    }
    
    AnimatorInflaterCompat$PathDataEvaluator(final PathParser$PathDataNode[] mNodeArray) {
        this.mNodeArray = mNodeArray;
    }
    
    public PathParser$PathDataNode[] evaluate(final float n, final PathParser$PathDataNode[] array, final PathParser$PathDataNode[] array2) {
        if (PathParser.canMorph(array, array2)) {
            final PathParser$PathDataNode[] mNodeArray = this.mNodeArray;
            if (mNodeArray == null || PathParser.canMorph(mNodeArray, array)) {
                this.mNodeArray = PathParser.deepCopyNodes(array);
            }
            for (int i = 0; i < array.length; ++i) {
                this.mNodeArray[i].interpolatePathDataNode(array[i], array2[i], n);
            }
            return this.mNodeArray;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
