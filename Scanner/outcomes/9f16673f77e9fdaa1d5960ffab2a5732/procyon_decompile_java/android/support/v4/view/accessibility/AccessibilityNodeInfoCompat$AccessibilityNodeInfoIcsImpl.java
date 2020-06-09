// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.graphics.Rect;
import java.util.List;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl
{
    public void addAction(final Object o, final int n) {
        AccessibilityNodeInfoCompatIcs.addAction(o, n);
    }
    
    public void addChild(final Object o, final View view) {
        AccessibilityNodeInfoCompatIcs.addChild(o, view);
    }
    
    public List findAccessibilityNodeInfosByText(final Object o, final String s) {
        return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(o, s);
    }
    
    public int getActions(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getActions(o);
    }
    
    public void getBoundsInParent(final Object o, final Rect rect) {
        AccessibilityNodeInfoCompatIcs.getBoundsInParent(o, rect);
    }
    
    public void getBoundsInScreen(final Object o, final Rect rect) {
        AccessibilityNodeInfoCompatIcs.getBoundsInScreen(o, rect);
    }
    
    public Object getChild(final Object o, final int n) {
        return AccessibilityNodeInfoCompatIcs.getChild(o, n);
    }
    
    public int getChildCount(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getChildCount(o);
    }
    
    public CharSequence getClassName(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getClassName(o);
    }
    
    public CharSequence getContentDescription(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getContentDescription(o);
    }
    
    public CharSequence getPackageName(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getPackageName(o);
    }
    
    public Object getParent(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getParent(o);
    }
    
    public CharSequence getText(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getText(o);
    }
    
    public int getWindowId(final Object o) {
        return AccessibilityNodeInfoCompatIcs.getWindowId(o);
    }
    
    public boolean isCheckable(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isCheckable(o);
    }
    
    public boolean isChecked(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isChecked(o);
    }
    
    public boolean isClickable(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isClickable(o);
    }
    
    public boolean isEnabled(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isEnabled(o);
    }
    
    public boolean isFocusable(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isFocusable(o);
    }
    
    public boolean isFocused(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isFocused(o);
    }
    
    public boolean isLongClickable(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isLongClickable(o);
    }
    
    public boolean isPassword(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isPassword(o);
    }
    
    public boolean isScrollable(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isScrollable(o);
    }
    
    public boolean isSelected(final Object o) {
        return AccessibilityNodeInfoCompatIcs.isSelected(o);
    }
    
    public Object obtain() {
        return AccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(final View view) {
        return AccessibilityNodeInfoCompatIcs.obtain(view);
    }
    
    public Object obtain(final Object o) {
        return AccessibilityNodeInfoCompatIcs.obtain(o);
    }
    
    public boolean performAction(final Object o, final int n) {
        return AccessibilityNodeInfoCompatIcs.performAction(o, n);
    }
    
    public void recycle(final Object o) {
        AccessibilityNodeInfoCompatIcs.recycle(o);
    }
    
    public void setBoundsInParent(final Object o, final Rect rect) {
        AccessibilityNodeInfoCompatIcs.setBoundsInParent(o, rect);
    }
    
    public void setBoundsInScreen(final Object o, final Rect rect) {
        AccessibilityNodeInfoCompatIcs.setBoundsInScreen(o, rect);
    }
    
    public void setCheckable(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setCheckable(o, b);
    }
    
    public void setChecked(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setChecked(o, b);
    }
    
    public void setClassName(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatIcs.setClassName(o, charSequence);
    }
    
    public void setClickable(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setClickable(o, b);
    }
    
    public void setContentDescription(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatIcs.setContentDescription(o, charSequence);
    }
    
    public void setEnabled(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setEnabled(o, b);
    }
    
    public void setFocusable(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setFocusable(o, b);
    }
    
    public void setFocused(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setFocused(o, b);
    }
    
    public void setLongClickable(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setLongClickable(o, b);
    }
    
    public void setPackageName(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatIcs.setPackageName(o, charSequence);
    }
    
    public void setParent(final Object o, final View view) {
        AccessibilityNodeInfoCompatIcs.setParent(o, view);
    }
    
    public void setPassword(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setPassword(o, b);
    }
    
    public void setScrollable(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setScrollable(o, b);
    }
    
    public void setSelected(final Object o, final boolean b) {
        AccessibilityNodeInfoCompatIcs.setSelected(o, b);
    }
    
    public void setSource(final Object o, final View view) {
        AccessibilityNodeInfoCompatIcs.setSource(o, view);
    }
    
    public void setText(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatIcs.setText(o, charSequence);
    }
}
