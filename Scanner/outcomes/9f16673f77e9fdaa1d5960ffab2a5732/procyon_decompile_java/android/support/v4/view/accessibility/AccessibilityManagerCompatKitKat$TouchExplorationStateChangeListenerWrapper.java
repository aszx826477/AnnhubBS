// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;

public class AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper implements AccessibilityManager$TouchExplorationStateChangeListener
{
    final Object mListener;
    final AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge mListenerBridge;
    
    public AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper(final Object mListener, final AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerBridge mListenerBridge) {
        this.mListener = mListener;
        this.mListenerBridge = mListenerBridge;
    }
    
    public boolean equals(final Object o) {
        boolean equals = true;
        if (this == o) {
            return equals;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper accessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper = (AccessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper)o;
            final Object mListener = this.mListener;
            if (mListener == null) {
                if (accessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper.mListener != null) {
                    equals = false;
                }
            }
            else {
                equals = mListener.equals(accessibilityManagerCompatKitKat$TouchExplorationStateChangeListenerWrapper.mListener);
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
    
    public void onTouchExplorationStateChanged(final boolean b) {
        this.mListenerBridge.onTouchExplorationStateChanged(b);
    }
}
