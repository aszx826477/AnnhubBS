// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;
import android.content.res.Resources$Theme;

class VectorDrawableCompat$VPath
{
    int mChangingConfigurations;
    protected PathParser$PathDataNode[] mNodes;
    String mPathName;
    
    public VectorDrawableCompat$VPath() {
        this.mNodes = null;
    }
    
    public VectorDrawableCompat$VPath(final VectorDrawableCompat$VPath vectorDrawableCompat$VPath) {
        this.mNodes = null;
        this.mPathName = vectorDrawableCompat$VPath.mPathName;
        this.mChangingConfigurations = vectorDrawableCompat$VPath.mChangingConfigurations;
        this.mNodes = PathParser.deepCopyNodes(vectorDrawableCompat$VPath.mNodes);
    }
    
    public void applyTheme(final Resources$Theme resources$Theme) {
    }
    
    public boolean canApplyTheme() {
        return false;
    }
    
    public PathParser$PathDataNode[] getPathData() {
        return this.mNodes;
    }
    
    public String getPathName() {
        return this.mPathName;
    }
    
    public boolean isClipPath() {
        return false;
    }
    
    public String nodesToString(final PathParser$PathDataNode[] array) {
        String s = " ";
        for (int i = 0; i < array.length; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(array[i].mType);
            sb.append(":");
            s = sb.toString();
            final float[] mParams = array[i].mParams;
            for (int j = 0; j < mParams.length; ++j) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append(mParams[j]);
                sb2.append(",");
                s = sb2.toString();
            }
        }
        return s;
    }
    
    public void printVPath(final int n) {
        String string = "";
        for (int i = 0; i < n; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("    ");
            string = sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("current path is :");
        sb2.append(this.mPathName);
        sb2.append(" pathData is ");
        sb2.append(this.nodesToString(this.mNodes));
        Log.v("VectorDrawableCompat", sb2.toString());
    }
    
    public void setPathData(final PathParser$PathDataNode[] array) {
        if (!PathParser.canMorph(this.mNodes, array)) {
            this.mNodes = PathParser.deepCopyNodes(array);
        }
        else {
            PathParser.updateNodes(this.mNodes, array);
        }
    }
    
    public void toPath(final Path path) {
        path.reset();
        final PathParser$PathDataNode[] mNodes = this.mNodes;
        if (mNodes != null) {
            PathParser$PathDataNode.nodesToPath(mNodes, path);
        }
    }
}
