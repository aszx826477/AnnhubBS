// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.Matrix;
import android.view.View;

class ViewCompat$HCViewCompatImpl extends ViewCompat$BaseViewCompatImpl
{
    public int combineMeasuredStates(final int n, final int n2) {
        return ViewCompatHC.combineMeasuredStates(n, n2);
    }
    
    public float getAlpha(final View view) {
        return ViewCompatHC.getAlpha(view);
    }
    
    long getFrameTime() {
        return ViewCompatHC.getFrameTime();
    }
    
    public int getLayerType(final View view) {
        return ViewCompatHC.getLayerType(view);
    }
    
    public Matrix getMatrix(final View view) {
        return ViewCompatHC.getMatrix(view);
    }
    
    public int getMeasuredHeightAndState(final View view) {
        return ViewCompatHC.getMeasuredHeightAndState(view);
    }
    
    public int getMeasuredState(final View view) {
        return ViewCompatHC.getMeasuredState(view);
    }
    
    public int getMeasuredWidthAndState(final View view) {
        return ViewCompatHC.getMeasuredWidthAndState(view);
    }
    
    public float getPivotX(final View view) {
        return ViewCompatHC.getPivotX(view);
    }
    
    public float getPivotY(final View view) {
        return ViewCompatHC.getPivotY(view);
    }
    
    public float getRotation(final View view) {
        return ViewCompatHC.getRotation(view);
    }
    
    public float getRotationX(final View view) {
        return ViewCompatHC.getRotationX(view);
    }
    
    public float getRotationY(final View view) {
        return ViewCompatHC.getRotationY(view);
    }
    
    public float getScaleX(final View view) {
        return ViewCompatHC.getScaleX(view);
    }
    
    public float getScaleY(final View view) {
        return ViewCompatHC.getScaleY(view);
    }
    
    public float getTranslationX(final View view) {
        return ViewCompatHC.getTranslationX(view);
    }
    
    public float getTranslationY(final View view) {
        return ViewCompatHC.getTranslationY(view);
    }
    
    public float getX(final View view) {
        return ViewCompatHC.getX(view);
    }
    
    public float getY(final View view) {
        return ViewCompatHC.getY(view);
    }
    
    public void jumpDrawablesToCurrentState(final View view) {
        ViewCompatHC.jumpDrawablesToCurrentState(view);
    }
    
    public void offsetLeftAndRight(final View view, final int n) {
        ViewCompatHC.offsetLeftAndRight(view, n);
    }
    
    public void offsetTopAndBottom(final View view, final int n) {
        ViewCompatHC.offsetTopAndBottom(view, n);
    }
    
    public int resolveSizeAndState(final int n, final int n2, final int n3) {
        return ViewCompatHC.resolveSizeAndState(n, n2, n3);
    }
    
    public void setActivated(final View view, final boolean b) {
        ViewCompatHC.setActivated(view, b);
    }
    
    public void setAlpha(final View view, final float n) {
        ViewCompatHC.setAlpha(view, n);
    }
    
    public void setLayerPaint(final View view, final Paint paint) {
        this.setLayerType(view, this.getLayerType(view), paint);
        view.invalidate();
    }
    
    public void setLayerType(final View view, final int n, final Paint paint) {
        ViewCompatHC.setLayerType(view, n, paint);
    }
    
    public void setPivotX(final View view, final float n) {
        ViewCompatHC.setPivotX(view, n);
    }
    
    public void setPivotY(final View view, final float n) {
        ViewCompatHC.setPivotY(view, n);
    }
    
    public void setRotation(final View view, final float n) {
        ViewCompatHC.setRotation(view, n);
    }
    
    public void setRotationX(final View view, final float n) {
        ViewCompatHC.setRotationX(view, n);
    }
    
    public void setRotationY(final View view, final float n) {
        ViewCompatHC.setRotationY(view, n);
    }
    
    public void setSaveFromParentEnabled(final View view, final boolean b) {
        ViewCompatHC.setSaveFromParentEnabled(view, b);
    }
    
    public void setScaleX(final View view, final float n) {
        ViewCompatHC.setScaleX(view, n);
    }
    
    public void setScaleY(final View view, final float n) {
        ViewCompatHC.setScaleY(view, n);
    }
    
    public void setTranslationX(final View view, final float n) {
        ViewCompatHC.setTranslationX(view, n);
    }
    
    public void setTranslationY(final View view, final float n) {
        ViewCompatHC.setTranslationY(view, n);
    }
    
    public void setX(final View view, final float n) {
        ViewCompatHC.setX(view, n);
    }
    
    public void setY(final View view, final float n) {
        ViewCompatHC.setY(view, n);
    }
}
