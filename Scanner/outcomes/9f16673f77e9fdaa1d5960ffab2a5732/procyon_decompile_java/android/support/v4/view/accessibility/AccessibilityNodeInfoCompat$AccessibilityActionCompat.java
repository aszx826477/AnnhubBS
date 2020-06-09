// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat
{
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COLLAPSE;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DISMISS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_PROGRESS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_TEXT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    final Object mAction;
    
    static {
        ACTION_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1, null);
        ACTION_CLEAR_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2, null);
        ACTION_SELECT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4, null);
        ACTION_CLEAR_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8, null);
        ACTION_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16, null);
        ACTION_LONG_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32, null);
        ACTION_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(64, null);
        ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(128, null);
        ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(256, null);
        ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(512, null);
        ACTION_NEXT_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1024, null);
        ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2048, null);
        ACTION_SCROLL_FORWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4096, null);
        ACTION_SCROLL_BACKWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8192, null);
        ACTION_COPY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16384, null);
        ACTION_PASTE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32768, null);
        ACTION_CUT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(65536, null);
        ACTION_SET_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(131072, null);
        ACTION_EXPAND = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(262144, null);
        ACTION_COLLAPSE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(524288, null);
        ACTION_DISMISS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1048576, null);
        ACTION_SET_TEXT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2097152, null);
        ACTION_SHOW_ON_SCREEN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
        ACTION_SCROLL_TO_POSITION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
        ACTION_SCROLL_UP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
        ACTION_SCROLL_LEFT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
        ACTION_SCROLL_DOWN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
        ACTION_SCROLL_RIGHT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
        ACTION_CONTEXT_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
        ACTION_SET_PROGRESS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());
    }
    
    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(final int n, final CharSequence charSequence) {
        this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(n, charSequence));
    }
    
    AccessibilityNodeInfoCompat$AccessibilityActionCompat(final Object mAction) {
        this.mAction = mAction;
    }
    
    public int getId() {
        return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
    }
    
    public CharSequence getLabel() {
        return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
    }
}
