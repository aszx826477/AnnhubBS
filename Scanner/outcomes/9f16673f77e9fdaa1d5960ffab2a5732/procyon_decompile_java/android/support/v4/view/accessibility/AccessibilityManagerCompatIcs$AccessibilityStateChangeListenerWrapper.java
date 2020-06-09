// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;

public class AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper implements AccessibilityManager$AccessibilityStateChangeListener
{
    Object mListener;
    AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge mListenerBridge;
    
    public AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper(final Object mListener, final AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge mListenerBridge) {
        this.mListener = mListener;
        this.mListenerBridge = mListenerBridge;
    }
    
    public boolean equals(final Object o) {
        boolean equals = true;
        if (this == o) {
            return equals;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper accessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper = (AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper)o;
            final Object mListener = this.mListener;
            if (mListener == null) {
                if (accessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper.mListener != null) {
                    equals = false;
                }
            }
            else {
                equals = mListener.equals(accessibilityManagerCompatIcs$AccessibilityStateChangeListenerWrapper.mListener);
            }
            return equals;
        }
        return false;
    }
    
    public int hashCode() {
        final Object mListener = this.mListener;
        int hashCode;
        if (mListener == null) {
            hashCode = 0;
        }
        else {
            hashCode = mListener.hashCode();
        }
        return hashCode;
    }
    
    public void onAccessibilityStateChanged(final boolean b) {
        this.mListenerBridge.onAccessibilityStateChanged(b);
    }
}
