// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;
import android.support.v4.util.ArrayMap;
import android.graphics.Matrix;
import java.util.ArrayList;

class VectorDrawableCompat$VGroup
{
    int mChangingConfigurations;
    final ArrayList mChildren;
    private String mGroupName;
    private final Matrix mLocalMatrix;
    private float mPivotX;
    private float mPivotY;
    float mRotate;
    private float mScaleX;
    private float mScaleY;
    private final Matrix mStackedMatrix;
    private int[] mThemeAttrs;
    private float mTranslateX;
    private float mTranslateY;
    
    public VectorDrawableCompat$VGroup() {
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        final float n = 1.0f;
        this.mScaleX = n;
        this.mScaleY = n;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = new Matrix();
        this.mGroupName = null;
    }
    
    public VectorDrawableCompat$VGroup(final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, final ArrayMap arrayMap) {
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        final float n = 1.0f;
        this.mScaleX = n;
        this.mScaleY = n;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = new Matrix();
        this.mGroupName = null;
        this.mRotate = vectorDrawableCompat$VGroup.mRotate;
        this.mPivotX = vectorDrawableCompat$VGroup.mPivotX;
        this.mPivotY = vectorDrawableCompat$VGroup.mPivotY;
        this.mScaleX = vectorDrawableCompat$VGroup.mScaleX;
        this.mScaleY = vectorDrawableCompat$VGroup.mScaleY;
        this.mTranslateX = vectorDrawableCompat$VGroup.mTranslateX;
        this.mTranslateY = vectorDrawableCompat$VGroup.mTranslateY;
        this.mThemeAttrs = vectorDrawableCompat$VGroup.mThemeAttrs;
        this.mGroupName = vectorDrawableCompat$VGroup.mGroupName;
        this.mChangingConfigurations = vectorDrawableCompat$VGroup.mChangingConfigurations;
        final String mGroupName = this.mGroupName;
        if (mGroupName != null) {
            arrayMap.put(mGroupName, this);
        }
        this.mLocalMatrix.set(vectorDrawableCompat$VGroup.mLocalMatrix);
        final ArrayList mChildren = vectorDrawableCompat$VGroup.mChildren;
        for (int i = 0; i < mChildren.size(); ++i) {
            final VectorDrawableCompat$VGroup value = mChildren.get(i);
            if (value instanceof VectorDrawableCompat$VGroup) {
                this.mChildren.add(new VectorDrawableCompat$VGroup(value, arrayMap));
            }
            else {
                VectorDrawableCompat$VPath vectorDrawableCompat$VPath;
                if (value instanceof VectorDrawableCompat$VFullPath) {
                    vectorDrawableCompat$VPath = new VectorDrawableCompat$VFullPath((VectorDrawableCompat$VFullPath)value);
                }
                else {
                    if (!(value instanceof VectorDrawableCompat$VClipPath)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    vectorDrawableCompat$VPath = new VectorDrawableCompat$VClipPath((VectorDrawableCompat$VClipPath)value);
                }
                this.mChildren.add(vectorDrawableCompat$VPath);
                if (vectorDrawableCompat$VPath.mPathName != null) {
                    arrayMap.put(vectorDrawableCompat$VPath.mPathName, vectorDrawableCompat$VPath);
                }
            }
        }
    }
    
    private void updateLocalMatrix() {
        this.mLocalMatrix.reset();
        this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
        this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
        this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
        this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }
    
    private void updateStateFromTypedArray(final TypedArray typedArray, final XmlPullParser xmlPullParser) {
        this.mThemeAttrs = null;
        this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.mRotate);
        this.mPivotX = typedArray.getFloat(1, this.mPivotX);
        this.mPivotY = typedArray.getFloat(2, this.mPivotY);
        this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
        this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
        this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
        this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
        final String string = typedArray.getString(0);
        if (string != null) {
            this.mGroupName = string;
        }
        this.updateLocalMatrix();
    }
    
    public String getGroupName() {
        return this.mGroupName;
    }
    
    public Matrix getLocalMatrix() {
        return this.mLocalMatrix;
    }
    
    public float getPivotX() {
        return this.mPivotX;
    }
    
    public float getPivotY() {
        return this.mPivotY;
    }
    
    public float getRotation() {
        return this.mRotate;
    }
    
    public float getScaleX() {
        return this.mScaleX;
    }
    
    public float getScaleY() {
        return this.mScaleY;
    }
    
    public float getTranslateX() {
        return this.mTranslateX;
    }
    
    public float getTranslateY() {
        return this.mTranslateY;
    }
    
    public void inflate(final Resources resources, final AttributeSet set, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
        this.updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
    
    public void setPivotX(final float mPivotX) {
        if (mPivotX != this.mPivotX) {
            this.mPivotX = mPivotX;
            this.updateLocalMatrix();
        }
    }
    
    public void setPivotY(final float mPivotY) {
        if (mPivotY != this.mPivotY) {
            this.mPivotY = mPivotY;
            this.updateLocalMatrix();
        }
    }
    
    public void setRotation(final float mRotate) {
        if (mRotate != this.mRotate) {
            this.mRotate = mRotate;
            this.updateLocalMatrix();
        }
    }
    
    public void setScaleX(final float mScaleX) {
        if (mScaleX != this.mScaleX) {
            this.mScaleX = mScaleX;
            this.updateLocalMatrix();
        }
    }
    
    public void setScaleY(final float mScaleY) {
        if (mScaleY != this.mScaleY) {
            this.mScaleY = mScaleY;
            this.updateLocalMatrix();
        }
    }
    
    public void setTranslateX(final float mTranslateX) {
        if (mTranslateX != this.mTranslateX) {
            this.mTranslateX = mTranslateX;
            this.updateLocalMatrix();
        }
    }
    
    public void setTranslateY(final float mTranslateY) {
        if (mTranslateY != this.mTranslateY) {
            this.mTranslateY = mTranslateY;
            this.updateLocalMatrix();
        }
    }
}
