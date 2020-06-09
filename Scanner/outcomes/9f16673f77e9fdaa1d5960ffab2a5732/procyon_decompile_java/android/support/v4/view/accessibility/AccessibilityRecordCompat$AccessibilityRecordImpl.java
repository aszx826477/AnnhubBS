// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.View;
import java.util.List;
import android.os.Parcelable;

interface AccessibilityRecordCompat$AccessibilityRecordImpl
{
    int getAddedCount(final Object p0);
    
    CharSequence getBeforeText(final Object p0);
    
    CharSequence getClassName(final Object p0);
    
    CharSequence getContentDescription(final Object p0);
    
    int getCurrentItemIndex(final Object p0);
    
    int getFromIndex(final Object p0);
    
    int getItemCount(final Object p0);
    
    int getMaxScrollX(final Object p0);
    
    int getMaxScrollY(final Object p0);
    
    Parcelable getParcelableData(final Object p0);
    
    int getRemovedCount(final Object p0);
    
    int getScrollX(final Object p0);
    
    int getScrollY(final Object p0);
    
    AccessibilityNodeInfoCompat getSource(final Object p0);
    
    List getText(final Object p0);
    
    int getToIndex(final Object p0);
    
    int getWindowId(final Object p0);
    
    boolean isChecked(final Object p0);
    
    boolean isEnabled(final Object p0);
    
    boolean isFullScreen(final Object p0);
    
    boolean isPassword(final Object p0);
    
    boolean isScrollable(final Object p0);
    
    Object obtain();
    
    Object obtain(final Object p0);
    
    void recycle(final Object p0);
    
    void setAddedCount(final Object p0, final int p1);
    
    void setBeforeText(final Object p0, final CharSequence p1);
    
    void setChecked(final Object p0, final boolean p1);
    
    void setClassName(final Object p0, final CharSequence p1);
    
    void setContentDescription(final Object p0, final CharSequence p1);
    
    void setCurrentItemIndex(final Object p0, final int p1);
    
    void setEnabled(final Object p0, final boolean p1);
    
    void setFromIndex(final Object p0, final int p1);
    
    void setFullScreen(final Object p0, final boolean p1);
    
    void setItemCount(final Object p0, final int p1);
    
    void setMaxScrollX(final Object p0, final int p1);
    
    void setMaxScrollY(final Object p0, final int p1);
    
    void setParcelableData(final Object p0, final Parcelable p1);
    
    void setPassword(final Object p0, final boolean p1);
    
    void setRemovedCount(final Object p0, final int p1);
    
    void setScrollX(final Object p0, final int p1);
    
    void setScrollY(final Object p0, final int p1);
    
    void setScrollable(final Object p0, final boolean p1);
    
    void setSource(final Object p0, final View p1);
    
    void setSource(final Object p0, final View p1, final int p2);
    
    void setToIndex(final Object p0, final int p1);
}
