// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.graphics.Rect;
import java.util.Collections;
import java.util.List;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl
{
    public void addAction(final Object o, final int n) {
    }
    
    public void addAction(final Object o, final Object o2) {
    }
    
    public void addChild(final Object o, final View view) {
    }
    
    public void addChild(final Object o, final View view, final int n) {
    }
    
    public boolean canOpenPopup(final Object o) {
        return false;
    }
    
    public List findAccessibilityNodeInfosByText(final Object o, final String s) {
        return Collections.emptyList();
    }
    
    public List findAccessibilityNodeInfosByViewId(final Object o, final String s) {
        return Collections.emptyList();
    }
    
    public Object findFocus(final Object o, final int n) {
        return null;
    }
    
    public Object focusSearch(final Object o, final int n) {
        return null;
    }
    
    public int getAccessibilityActionId(final Object o) {
        return 0;
    }
    
    public CharSequence getAccessibilityActionLabel(final Object o) {
        return null;
    }
    
    public Object getActionContextClick() {
        return null;
    }
    
    public List getActionList(final Object o) {
        return null;
    }
    
    public Object getActionScrollDown() {
        return null;
    }
    
    public Object getActionScrollLeft() {
        return null;
    }
    
    public Object getActionScrollRight() {
        return null;
    }
    
    public Object getActionScrollToPosition() {
        return null;
    }
    
    public Object getActionScrollUp() {
        return null;
    }
    
    public Object getActionSetProgress() {
        return null;
    }
    
    public Object getActionShowOnScreen() {
        return null;
    }
    
    public int getActions(final Object o) {
        return 0;
    }
    
    public void getBoundsInParent(final Object o, final Rect rect) {
    }
    
    public void getBoundsInScreen(final Object o, final Rect rect) {
    }
    
    public Object getChild(final Object o, final int n) {
        return null;
    }
    
    public int getChildCount(final Object o) {
        return 0;
    }
    
    public CharSequence getClassName(final Object o) {
        return null;
    }
    
    public Object getCollectionInfo(final Object o) {
        return null;
    }
    
    public int getCollectionInfoColumnCount(final Object o) {
        return 0;
    }
    
    public int getCollectionInfoRowCount(final Object o) {
        return 0;
    }
    
    public int getCollectionInfoSelectionMode(final Object o) {
        return 0;
    }
    
    public int getCollectionItemColumnIndex(final Object o) {
        return 0;
    }
    
    public int getCollectionItemColumnSpan(final Object o) {
        return 0;
    }
    
    public Object getCollectionItemInfo(final Object o) {
        return null;
    }
    
    public int getCollectionItemRowIndex(final Object o) {
        return 0;
    }
    
    public int getCollectionItemRowSpan(final Object o) {
        return 0;
    }
    
    public CharSequence getContentDescription(final Object o) {
        return null;
    }
    
    public int getDrawingOrder(final Object o) {
        return 0;
    }
    
    public CharSequence getError(final Object o) {
        return null;
    }
    
    public Bundle getExtras(final Object o) {
        return new Bundle();
    }
    
    public int getInputType(final Object o) {
        return 0;
    }
    
    public Object getLabelFor(final Object o) {
        return null;
    }
    
    public Object getLabeledBy(final Object o) {
        return null;
    }
    
    public int getLiveRegion(final Object o) {
        return 0;
    }
    
    public int getMaxTextLength(final Object o) {
        return -1;
    }
    
    public int getMovementGranularities(final Object o) {
        return 0;
    }
    
    public CharSequence getPackageName(final Object o) {
        return null;
    }
    
    public Object getParent(final Object o) {
        return null;
    }
    
    public Object getRangeInfo(final Object o) {
        return null;
    }
    
    public CharSequence getRoleDescription(final Object o) {
        return null;
    }
    
    public CharSequence getText(final Object o) {
        return null;
    }
    
    public int getTextSelectionEnd(final Object o) {
        return -1;
    }
    
    public int getTextSelectionStart(final Object o) {
        return -1;
    }
    
    public Object getTraversalAfter(final Object o) {
        return null;
    }
    
    public Object getTraversalBefore(final Object o) {
        return null;
    }
    
    public String getViewIdResourceName(final Object o) {
        return null;
    }
    
    public Object getWindow(final Object o) {
        return null;
    }
    
    public int getWindowId(final Object o) {
        return 0;
    }
    
    public boolean isAccessibilityFocused(final Object o) {
        return false;
    }
    
    public boolean isCheckable(final Object o) {
        return false;
    }
    
    public boolean isChecked(final Object o) {
        return false;
    }
    
    public boolean isClickable(final Object o) {
        return false;
    }
    
    public boolean isCollectionInfoHierarchical(final Object o) {
        return false;
    }
    
    public boolean isCollectionItemHeading(final Object o) {
        return false;
    }
    
    public boolean isCollectionItemSelected(final Object o) {
        return false;
    }
    
    public boolean isContentInvalid(final Object o) {
        return false;
    }
    
    public boolean isContextClickable(final Object o) {
        return false;
    }
    
    public boolean isDismissable(final Object o) {
        return false;
    }
    
    public boolean isEditable(final Object o) {
        return false;
    }
    
    public boolean isEnabled(final Object o) {
        return false;
    }
    
    public boolean isFocusable(final Object o) {
        return false;
    }
    
    public boolean isFocused(final Object o) {
        return false;
    }
    
    public boolean isImportantForAccessibility(final Object o) {
        return true;
    }
    
    public boolean isLongClickable(final Object o) {
        return false;
    }
    
    public boolean isMultiLine(final Object o) {
        return false;
    }
    
    public boolean isPassword(final Object o) {
        return false;
    }
    
    public boolean isScrollable(final Object o) {
        return false;
    }
    
    public boolean isSelected(final Object o) {
        return false;
    }
    
    public boolean isVisibleToUser(final Object o) {
        return false;
    }
    
    public Object newAccessibilityAction(final int n, final CharSequence charSequence) {
        return null;
    }
    
    public Object obtain() {
        return null;
    }
    
    public Object obtain(final View view) {
        return null;
    }
    
    public Object obtain(final View view, final int n) {
        return null;
    }
    
    public Object obtain(final Object o) {
        return null;
    }
    
    public Object obtainCollectionInfo(final int n, final int n2, final boolean b) {
        return null;
    }
    
    public Object obtainCollectionInfo(final int n, final int n2, final boolean b, final int n3) {
        return null;
    }
    
    public Object obtainCollectionItemInfo(final int n, final int n2, final int n3, final int n4, final boolean b) {
        return null;
    }
    
    public Object obtainCollectionItemInfo(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
        return null;
    }
    
    public Object obtainRangeInfo(final int n, final float n2, final float n3, final float n4) {
        return null;
    }
    
    public boolean performAction(final Object o, final int n) {
        return false;
    }
    
    public boolean performAction(final Object o, final int n, final Bundle bundle) {
        return false;
    }
    
    public void recycle(final Object o) {
    }
    
    public boolean refresh(final Object o) {
        return false;
    }
    
    public boolean removeAction(final Object o, final Object o2) {
        return false;
    }
    
    public boolean removeChild(final Object o, final View view) {
        return false;
    }
    
    public boolean removeChild(final Object o, final View view, final int n) {
        return false;
    }
    
    public void setAccessibilityFocused(final Object o, final boolean b) {
    }
    
    public void setBoundsInParent(final Object o, final Rect rect) {
    }
    
    public void setBoundsInScreen(final Object o, final Rect rect) {
    }
    
    public void setCanOpenPopup(final Object o, final boolean b) {
    }
    
    public void setCheckable(final Object o, final boolean b) {
    }
    
    public void setChecked(final Object o, final boolean b) {
    }
    
    public void setClassName(final Object o, final CharSequence charSequence) {
    }
    
    public void setClickable(final Object o, final boolean b) {
    }
    
    public void setCollectionInfo(final Object o, final Object o2) {
    }
    
    public void setCollectionItemInfo(final Object o, final Object o2) {
    }
    
    public void setContentDescription(final Object o, final CharSequence charSequence) {
    }
    
    public void setContentInvalid(final Object o, final boolean b) {
    }
    
    public void setContextClickable(final Object o, final boolean b) {
    }
    
    public void setDismissable(final Object o, final boolean b) {
    }
    
    public void setDrawingOrder(final Object o, final int n) {
    }
    
    public void setEditable(final Object o, final boolean b) {
    }
    
    public void setEnabled(final Object o, final boolean b) {
    }
    
    public void setError(final Object o, final CharSequence charSequence) {
    }
    
    public void setFocusable(final Object o, final boolean b) {
    }
    
    public void setFocused(final Object o, final boolean b) {
    }
    
    public void setImportantForAccessibility(final Object o, final boolean b) {
    }
    
    public void setInputType(final Object o, final int n) {
    }
    
    public void setLabelFor(final Object o, final View view) {
    }
    
    public void setLabelFor(final Object o, final View view, final int n) {
    }
    
    public void setLabeledBy(final Object o, final View view) {
    }
    
    public void setLabeledBy(final Object o, final View view, final int n) {
    }
    
    public void setLiveRegion(final Object o, final int n) {
    }
    
    public void setLongClickable(final Object o, final boolean b) {
    }
    
    public void setMaxTextLength(final Object o, final int n) {
    }
    
    public void setMovementGranularities(final Object o, final int n) {
    }
    
    public void setMultiLine(final Object o, final boolean b) {
    }
    
    public void setPackageName(final Object o, final CharSequence charSequence) {
    }
    
    public void setParent(final Object o, final View view) {
    }
    
    public void setParent(final Object o, final View view, final int n) {
    }
    
    public void setPassword(final Object o, final boolean b) {
    }
    
    public void setRangeInfo(final Object o, final Object o2) {
    }
    
    public void setRoleDescription(final Object o, final CharSequence charSequence) {
    }
    
    public void setScrollable(final Object o, final boolean b) {
    }
    
    public void setSelected(final Object o, final boolean b) {
    }
    
    public void setSource(final Object o, final View view) {
    }
    
    public void setSource(final Object o, final View view, final int n) {
    }
    
    public void setText(final Object o, final CharSequence charSequence) {
    }
    
    public void setTextSelection(final Object o, final int n, final int n2) {
    }
    
    public void setTraversalAfter(final Object o, final View view) {
    }
    
    public void setTraversalAfter(final Object o, final View view, final int n) {
    }
    
    public void setTraversalBefore(final Object o, final View view) {
    }
    
    public void setTraversalBefore(final Object o, final View view, final int n) {
    }
    
    public void setViewIdResourceName(final Object o, final String s) {
    }
    
    public void setVisibleToUser(final Object o, final boolean b) {
    }
}
