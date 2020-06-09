// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.View;
import java.util.List;
import android.os.Parcelable;

class AccessibilityRecordCompat$AccessibilityRecordIcsImpl extends AccessibilityRecordCompat$AccessibilityRecordStubImpl
{
    public int getAddedCount(final Object o) {
        return AccessibilityRecordCompatIcs.getAddedCount(o);
    }
    
    public CharSequence getBeforeText(final Object o) {
        return AccessibilityRecordCompatIcs.getBeforeText(o);
    }
    
    public CharSequence getClassName(final Object o) {
        return AccessibilityRecordCompatIcs.getClassName(o);
    }
    
    public CharSequence getContentDescription(final Object o) {
        return AccessibilityRecordCompatIcs.getContentDescription(o);
    }
    
    public int getCurrentItemIndex(final Object o) {
        return AccessibilityRecordCompatIcs.getCurrentItemIndex(o);
    }
    
    public int getFromIndex(final Object o) {
        return AccessibilityRecordCompatIcs.getFromIndex(o);
    }
    
    public int getItemCount(final Object o) {
        return AccessibilityRecordCompatIcs.getItemCount(o);
    }
    
    public Parcelable getParcelableData(final Object o) {
        return AccessibilityRecordCompatIcs.getParcelableData(o);
    }
    
    public int getRemovedCount(final Object o) {
        return AccessibilityRecordCompatIcs.getRemovedCount(o);
    }
    
    public int getScrollX(final Object o) {
        return AccessibilityRecordCompatIcs.getScrollX(o);
    }
    
    public int getScrollY(final Object o) {
        return AccessibilityRecordCompatIcs.getScrollY(o);
    }
    
    public AccessibilityNodeInfoCompat getSource(final Object o) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityRecordCompatIcs.getSource(o));
    }
    
    public List getText(final Object o) {
        return AccessibilityRecordCompatIcs.getText(o);
    }
    
    public int getToIndex(final Object o) {
        return AccessibilityRecordCompatIcs.getToIndex(o);
    }
    
    public int getWindowId(final Object o) {
        return AccessibilityRecordCompatIcs.getWindowId(o);
    }
    
    public boolean isChecked(final Object o) {
        return AccessibilityRecordCompatIcs.isChecked(o);
    }
    
    public boolean isEnabled(final Object o) {
        return AccessibilityRecordCompatIcs.isEnabled(o);
    }
    
    public boolean isFullScreen(final Object o) {
        return AccessibilityRecordCompatIcs.isFullScreen(o);
    }
    
    public boolean isPassword(final Object o) {
        return AccessibilityRecordCompatIcs.isPassword(o);
    }
    
    public boolean isScrollable(final Object o) {
        return AccessibilityRecordCompatIcs.isScrollable(o);
    }
    
    public Object obtain() {
        return AccessibilityRecordCompatIcs.obtain();
    }
    
    public Object obtain(final Object o) {
        return AccessibilityRecordCompatIcs.obtain(o);
    }
    
    public void recycle(final Object o) {
        AccessibilityRecordCompatIcs.recycle(o);
    }
    
    public void setAddedCount(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setAddedCount(o, n);
    }
    
    public void setBeforeText(final Object o, final CharSequence charSequence) {
        AccessibilityRecordCompatIcs.setBeforeText(o, charSequence);
    }
    
    public void setChecked(final Object o, final boolean b) {
        AccessibilityRecordCompatIcs.setChecked(o, b);
    }
    
    public void setClassName(final Object o, final CharSequence charSequence) {
        AccessibilityRecordCompatIcs.setClassName(o, charSequence);
    }
    
    public void setContentDescription(final Object o, final CharSequence charSequence) {
        AccessibilityRecordCompatIcs.setContentDescription(o, charSequence);
    }
    
    public void setCurrentItemIndex(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setCurrentItemIndex(o, n);
    }
    
    public void setEnabled(final Object o, final boolean b) {
        AccessibilityRecordCompatIcs.setEnabled(o, b);
    }
    
    public void setFromIndex(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setFromIndex(o, n);
    }
    
    public void setFullScreen(final Object o, final boolean b) {
        AccessibilityRecordCompatIcs.setFullScreen(o, b);
    }
    
    public void setItemCount(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setItemCount(o, n);
    }
    
    public void setParcelableData(final Object o, final Parcelable parcelable) {
        AccessibilityRecordCompatIcs.setParcelableData(o, parcelable);
    }
    
    public void setPassword(final Object o, final boolean b) {
        AccessibilityRecordCompatIcs.setPassword(o, b);
    }
    
    public void setRemovedCount(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setRemovedCount(o, n);
    }
    
    public void setScrollX(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setScrollX(o, n);
    }
    
    public void setScrollY(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setScrollY(o, n);
    }
    
    public void setScrollable(final Object o, final boolean b) {
        AccessibilityRecordCompatIcs.setScrollable(o, b);
    }
    
    public void setSource(final Object o, final View view) {
        AccessibilityRecordCompatIcs.setSource(o, view);
    }
    
    public void setToIndex(final Object o, final int n) {
        AccessibilityRecordCompatIcs.setToIndex(o, n);
    }
}
