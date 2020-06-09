// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.os.Build$VERSION;

public class AccessibilityNodeInfoCompat
{
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    static final AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl IMPL;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;
    public int mParentVirtualDescendantId;
    
    static {
        if (Build$VERSION.SDK_INT >= 24) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi24Impl();
        }
        else if (Build$VERSION.SDK_INT >= 23) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi23Impl();
        }
        else if (Build$VERSION.SDK_INT >= 22) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl();
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl();
        }
        else if (Build$VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl();
        }
        else if (Build$VERSION.SDK_INT >= 18) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl();
        }
        else if (Build$VERSION.SDK_INT >= 17) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl();
        }
        else {
            IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl();
        }
    }
    
    public AccessibilityNodeInfoCompat(final Object mInfo) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo = mInfo;
    }
    
    private static String getActionSymbolicName(final int n) {
        switch (n) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 1: {
                return "ACTION_FOCUS";
            }
        }
    }
    
    public static AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain());
    }
    
    public static AccessibilityNodeInfoCompat obtain(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }
    
    public static AccessibilityNodeInfoCompat obtain(final View view) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(view));
    }
    
    public static AccessibilityNodeInfoCompat obtain(final View view, final int n) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(view, n));
    }
    
    static AccessibilityNodeInfoCompat wrapNonNullInstance(final Object o) {
        if (o != null) {
            return new AccessibilityNodeInfoCompat(o);
        }
        return null;
    }
    
    public void addAction(final int n) {
        AccessibilityNodeInfoCompat.IMPL.addAction(this.mInfo, n);
    }
    
    public void addAction(final AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat) {
        AccessibilityNodeInfoCompat.IMPL.addAction(this.mInfo, accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction);
    }
    
    public void addChild(final View view) {
        AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, view);
    }
    
    public void addChild(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, view, n);
    }
    
    public boolean canOpenPopup() {
        return AccessibilityNodeInfoCompat.IMPL.canOpenPopup(this.mInfo);
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)o;
        final Object mInfo = this.mInfo;
        if (mInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        }
        else if (!mInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return b;
    }
    
    public List findAccessibilityNodeInfosByText(final String s) {
        final ArrayList<AccessibilityNodeInfoCompat> list = new ArrayList<AccessibilityNodeInfoCompat>();
        final List accessibilityNodeInfosByText = AccessibilityNodeInfoCompat.IMPL.findAccessibilityNodeInfosByText(this.mInfo, s);
        for (int size = accessibilityNodeInfosByText.size(), i = 0; i < size; ++i) {
            list.add(new AccessibilityNodeInfoCompat(accessibilityNodeInfosByText.get(i)));
        }
        return list;
    }
    
    public List findAccessibilityNodeInfosByViewId(final String s) {
        final List accessibilityNodeInfosByViewId = AccessibilityNodeInfoCompat.IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, s);
        if (accessibilityNodeInfosByViewId != null) {
            final ArrayList<AccessibilityNodeInfoCompat> list = new ArrayList<AccessibilityNodeInfoCompat>();
            final Iterator<Object> iterator = accessibilityNodeInfosByViewId.iterator();
            while (iterator.hasNext()) {
                list.add(new AccessibilityNodeInfoCompat(iterator.next()));
            }
            return list;
        }
        return Collections.emptyList();
    }
    
    public AccessibilityNodeInfoCompat findFocus(final int n) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.findFocus(this.mInfo, n));
    }
    
    public AccessibilityNodeInfoCompat focusSearch(final int n) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.focusSearch(this.mInfo, n));
    }
    
    public List getActionList() {
        final List actionList = AccessibilityNodeInfoCompat.IMPL.getActionList(this.mInfo);
        if (actionList != null) {
            final ArrayList<AccessibilityNodeInfoCompat$AccessibilityActionCompat> list = new ArrayList<AccessibilityNodeInfoCompat$AccessibilityActionCompat>();
            for (int size = actionList.size(), i = 0; i < size; ++i) {
                list.add(new AccessibilityNodeInfoCompat$AccessibilityActionCompat(actionList.get(i)));
            }
            return list;
        }
        return Collections.emptyList();
    }
    
    public int getActions() {
        return AccessibilityNodeInfoCompat.IMPL.getActions(this.mInfo);
    }
    
    public void getBoundsInParent(final Rect rect) {
        AccessibilityNodeInfoCompat.IMPL.getBoundsInParent(this.mInfo, rect);
    }
    
    public void getBoundsInScreen(final Rect rect) {
        AccessibilityNodeInfoCompat.IMPL.getBoundsInScreen(this.mInfo, rect);
    }
    
    public AccessibilityNodeInfoCompat getChild(final int n) {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getChild(this.mInfo, n));
    }
    
    public int getChildCount() {
        return AccessibilityNodeInfoCompat.IMPL.getChildCount(this.mInfo);
    }
    
    public CharSequence getClassName() {
        return AccessibilityNodeInfoCompat.IMPL.getClassName(this.mInfo);
    }
    
    public AccessibilityNodeInfoCompat$CollectionInfoCompat getCollectionInfo() {
        final Object collectionInfo = AccessibilityNodeInfoCompat.IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new AccessibilityNodeInfoCompat$CollectionInfoCompat(collectionInfo);
    }
    
    public AccessibilityNodeInfoCompat$CollectionItemInfoCompat getCollectionItemInfo() {
        final Object collectionItemInfo = AccessibilityNodeInfoCompat.IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(collectionItemInfo);
    }
    
    public CharSequence getContentDescription() {
        return AccessibilityNodeInfoCompat.IMPL.getContentDescription(this.mInfo);
    }
    
    public int getDrawingOrder() {
        return AccessibilityNodeInfoCompat.IMPL.getDrawingOrder(this.mInfo);
    }
    
    public CharSequence getError() {
        return AccessibilityNodeInfoCompat.IMPL.getError(this.mInfo);
    }
    
    public Bundle getExtras() {
        return AccessibilityNodeInfoCompat.IMPL.getExtras(this.mInfo);
    }
    
    public Object getInfo() {
        return this.mInfo;
    }
    
    public int getInputType() {
        return AccessibilityNodeInfoCompat.IMPL.getInputType(this.mInfo);
    }
    
    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getLabelFor(this.mInfo));
    }
    
    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getLabeledBy(this.mInfo));
    }
    
    public int getLiveRegion() {
        return AccessibilityNodeInfoCompat.IMPL.getLiveRegion(this.mInfo);
    }
    
    public int getMaxTextLength() {
        return AccessibilityNodeInfoCompat.IMPL.getMaxTextLength(this.mInfo);
    }
    
    public int getMovementGranularities() {
        return AccessibilityNodeInfoCompat.IMPL.getMovementGranularities(this.mInfo);
    }
    
    public CharSequence getPackageName() {
        return AccessibilityNodeInfoCompat.IMPL.getPackageName(this.mInfo);
    }
    
    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getParent(this.mInfo));
    }
    
    public AccessibilityNodeInfoCompat$RangeInfoCompat getRangeInfo() {
        final Object rangeInfo = AccessibilityNodeInfoCompat.IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new AccessibilityNodeInfoCompat$RangeInfoCompat(rangeInfo);
    }
    
    public CharSequence getRoleDescription() {
        return AccessibilityNodeInfoCompat.IMPL.getRoleDescription(this.mInfo);
    }
    
    public CharSequence getText() {
        return AccessibilityNodeInfoCompat.IMPL.getText(this.mInfo);
    }
    
    public int getTextSelectionEnd() {
        return AccessibilityNodeInfoCompat.IMPL.getTextSelectionEnd(this.mInfo);
    }
    
    public int getTextSelectionStart() {
        return AccessibilityNodeInfoCompat.IMPL.getTextSelectionStart(this.mInfo);
    }
    
    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getTraversalAfter(this.mInfo));
    }
    
    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getTraversalBefore(this.mInfo));
    }
    
    public String getViewIdResourceName() {
        return AccessibilityNodeInfoCompat.IMPL.getViewIdResourceName(this.mInfo);
    }
    
    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getWindow(this.mInfo));
    }
    
    public int getWindowId() {
        return AccessibilityNodeInfoCompat.IMPL.getWindowId(this.mInfo);
    }
    
    public int hashCode() {
        final Object mInfo = this.mInfo;
        int hashCode;
        if (mInfo == null) {
            hashCode = 0;
        }
        else {
            hashCode = mInfo.hashCode();
        }
        return hashCode;
    }
    
    public boolean isAccessibilityFocused() {
        return AccessibilityNodeInfoCompat.IMPL.isAccessibilityFocused(this.mInfo);
    }
    
    public boolean isCheckable() {
        return AccessibilityNodeInfoCompat.IMPL.isCheckable(this.mInfo);
    }
    
    public boolean isChecked() {
        return AccessibilityNodeInfoCompat.IMPL.isChecked(this.mInfo);
    }
    
    public boolean isClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isClickable(this.mInfo);
    }
    
    public boolean isContentInvalid() {
        return AccessibilityNodeInfoCompat.IMPL.isContentInvalid(this.mInfo);
    }
    
    public boolean isContextClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isContextClickable(this.mInfo);
    }
    
    public boolean isDismissable() {
        return AccessibilityNodeInfoCompat.IMPL.isDismissable(this.mInfo);
    }
    
    public boolean isEditable() {
        return AccessibilityNodeInfoCompat.IMPL.isEditable(this.mInfo);
    }
    
    public boolean isEnabled() {
        return AccessibilityNodeInfoCompat.IMPL.isEnabled(this.mInfo);
    }
    
    public boolean isFocusable() {
        return AccessibilityNodeInfoCompat.IMPL.isFocusable(this.mInfo);
    }
    
    public boolean isFocused() {
        return AccessibilityNodeInfoCompat.IMPL.isFocused(this.mInfo);
    }
    
    public boolean isImportantForAccessibility() {
        return AccessibilityNodeInfoCompat.IMPL.isImportantForAccessibility(this.mInfo);
    }
    
    public boolean isLongClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isLongClickable(this.mInfo);
    }
    
    public boolean isMultiLine() {
        return AccessibilityNodeInfoCompat.IMPL.isMultiLine(this.mInfo);
    }
    
    public boolean isPassword() {
        return AccessibilityNodeInfoCompat.IMPL.isPassword(this.mInfo);
    }
    
    public boolean isScrollable() {
        return AccessibilityNodeInfoCompat.IMPL.isScrollable(this.mInfo);
    }
    
    public boolean isSelected() {
        return AccessibilityNodeInfoCompat.IMPL.isSelected(this.mInfo);
    }
    
    public boolean isVisibleToUser() {
        return AccessibilityNodeInfoCompat.IMPL.isVisibleToUser(this.mInfo);
    }
    
    public boolean performAction(final int n) {
        return AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, n);
    }
    
    public boolean performAction(final int n, final Bundle bundle) {
        return AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, n, bundle);
    }
    
    public void recycle() {
        AccessibilityNodeInfoCompat.IMPL.recycle(this.mInfo);
    }
    
    public boolean refresh() {
        return AccessibilityNodeInfoCompat.IMPL.refresh(this.mInfo);
    }
    
    public boolean removeAction(final AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat) {
        return AccessibilityNodeInfoCompat.IMPL.removeAction(this.mInfo, accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction);
    }
    
    public boolean removeChild(final View view) {
        return AccessibilityNodeInfoCompat.IMPL.removeChild(this.mInfo, view);
    }
    
    public boolean removeChild(final View view, final int n) {
        return AccessibilityNodeInfoCompat.IMPL.removeChild(this.mInfo, view, n);
    }
    
    public void setAccessibilityFocused(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setAccessibilityFocused(this.mInfo, b);
    }
    
    public void setBoundsInParent(final Rect rect) {
        AccessibilityNodeInfoCompat.IMPL.setBoundsInParent(this.mInfo, rect);
    }
    
    public void setBoundsInScreen(final Rect rect) {
        AccessibilityNodeInfoCompat.IMPL.setBoundsInScreen(this.mInfo, rect);
    }
    
    public void setCanOpenPopup(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setCanOpenPopup(this.mInfo, b);
    }
    
    public void setCheckable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setCheckable(this.mInfo, b);
    }
    
    public void setChecked(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setChecked(this.mInfo, b);
    }
    
    public void setClassName(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setClassName(this.mInfo, charSequence);
    }
    
    public void setClickable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setClickable(this.mInfo, b);
    }
    
    public void setCollectionInfo(final Object o) {
        AccessibilityNodeInfoCompat.IMPL.setCollectionInfo(this.mInfo, ((AccessibilityNodeInfoCompat$CollectionInfoCompat)o).mInfo);
    }
    
    public void setCollectionItemInfo(final Object o) {
        AccessibilityNodeInfoCompat.IMPL.setCollectionItemInfo(this.mInfo, ((AccessibilityNodeInfoCompat$CollectionItemInfoCompat)o).mInfo);
    }
    
    public void setContentDescription(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setContentDescription(this.mInfo, charSequence);
    }
    
    public void setContentInvalid(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setContentInvalid(this.mInfo, b);
    }
    
    public void setContextClickable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setContextClickable(this.mInfo, b);
    }
    
    public void setDismissable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setDismissable(this.mInfo, b);
    }
    
    public void setDrawingOrder(final int n) {
        AccessibilityNodeInfoCompat.IMPL.setDrawingOrder(this.mInfo, n);
    }
    
    public void setEditable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setEditable(this.mInfo, b);
    }
    
    public void setEnabled(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setEnabled(this.mInfo, b);
    }
    
    public void setError(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setError(this.mInfo, charSequence);
    }
    
    public void setFocusable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setFocusable(this.mInfo, b);
    }
    
    public void setFocused(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setFocused(this.mInfo, b);
    }
    
    public void setImportantForAccessibility(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setImportantForAccessibility(this.mInfo, b);
    }
    
    public void setInputType(final int n) {
        AccessibilityNodeInfoCompat.IMPL.setInputType(this.mInfo, n);
    }
    
    public void setLabelFor(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setLabelFor(this.mInfo, view);
    }
    
    public void setLabelFor(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.setLabelFor(this.mInfo, view, n);
    }
    
    public void setLabeledBy(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setLabeledBy(this.mInfo, view);
    }
    
    public void setLabeledBy(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.setLabeledBy(this.mInfo, view, n);
    }
    
    public void setLiveRegion(final int n) {
        AccessibilityNodeInfoCompat.IMPL.setLiveRegion(this.mInfo, n);
    }
    
    public void setLongClickable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setLongClickable(this.mInfo, b);
    }
    
    public void setMaxTextLength(final int n) {
        AccessibilityNodeInfoCompat.IMPL.setMaxTextLength(this.mInfo, n);
    }
    
    public void setMovementGranularities(final int n) {
        AccessibilityNodeInfoCompat.IMPL.setMovementGranularities(this.mInfo, n);
    }
    
    public void setMultiLine(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setMultiLine(this.mInfo, b);
    }
    
    public void setPackageName(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setPackageName(this.mInfo, charSequence);
    }
    
    public void setParent(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, view);
    }
    
    public void setParent(final View view, final int mParentVirtualDescendantId) {
        this.mParentVirtualDescendantId = mParentVirtualDescendantId;
        AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, view, mParentVirtualDescendantId);
    }
    
    public void setPassword(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setPassword(this.mInfo, b);
    }
    
    public void setRangeInfo(final AccessibilityNodeInfoCompat$RangeInfoCompat accessibilityNodeInfoCompat$RangeInfoCompat) {
        AccessibilityNodeInfoCompat.IMPL.setRangeInfo(this.mInfo, accessibilityNodeInfoCompat$RangeInfoCompat.mInfo);
    }
    
    public void setRoleDescription(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setRoleDescription(this.mInfo, charSequence);
    }
    
    public void setScrollable(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setScrollable(this.mInfo, b);
    }
    
    public void setSelected(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setSelected(this.mInfo, b);
    }
    
    public void setSource(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, view);
    }
    
    public void setSource(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, view, n);
    }
    
    public void setText(final CharSequence charSequence) {
        AccessibilityNodeInfoCompat.IMPL.setText(this.mInfo, charSequence);
    }
    
    public void setTextSelection(final int n, final int n2) {
        AccessibilityNodeInfoCompat.IMPL.setTextSelection(this.mInfo, n, n2);
    }
    
    public void setTraversalAfter(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalAfter(this.mInfo, view);
    }
    
    public void setTraversalAfter(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalAfter(this.mInfo, view, n);
    }
    
    public void setTraversalBefore(final View view) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalBefore(this.mInfo, view);
    }
    
    public void setTraversalBefore(final View view, final int n) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalBefore(this.mInfo, view, n);
    }
    
    public void setViewIdResourceName(final String s) {
        AccessibilityNodeInfoCompat.IMPL.setViewIdResourceName(this.mInfo, s);
    }
    
    public void setVisibleToUser(final boolean b) {
        AccessibilityNodeInfoCompat.IMPL.setVisibleToUser(this.mInfo, b);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        final Rect rect = new Rect();
        this.getBoundsInParent(rect);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        this.getBoundsInScreen(rect);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(this.getPackageName());
        sb.append("; className: ");
        sb.append(this.getClassName());
        sb.append("; text: ");
        sb.append(this.getText());
        sb.append("; contentDescription: ");
        sb.append(this.getContentDescription());
        sb.append("; viewId: ");
        sb.append(this.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(this.isCheckable());
        sb.append("; checked: ");
        sb.append(this.isChecked());
        sb.append("; focusable: ");
        sb.append(this.isFocusable());
        sb.append("; focused: ");
        sb.append(this.isFocused());
        sb.append("; selected: ");
        sb.append(this.isSelected());
        sb.append("; clickable: ");
        sb.append(this.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.isEnabled());
        sb.append("; password: ");
        sb.append(this.isPassword());
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(this.isScrollable());
        sb.append(sb4.toString());
        sb.append("; [");
        int i = this.getActions();
        while (i != 0) {
            final int n = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~n;
            sb.append(getActionSymbolicName(n));
            if (i != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
