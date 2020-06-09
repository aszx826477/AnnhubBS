// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.view.ViewParent;
import android.support.v4.util.SparseArrayCompat;
import java.util.List;
import java.util.ArrayList;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.AccessibilityManager;
import android.view.View;
import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat
{
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = 255;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final FocusStrategy$BoundsAdapter NODE_ADAPTER;
    private static final FocusStrategy$CollectionAdapter SPARSE_VALUES_ADAPTER;
    private int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    private int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private ExploreByTouchHelper$MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;
    
    static {
        final int n = -1 << -1;
        final int n2 = -1 >>> 1;
        INVALID_PARENT_BOUNDS = new Rect(n2, n2, n, n);
        NODE_ADAPTER = new ExploreByTouchHelper$1();
        SPARSE_VALUES_ADAPTER = new ExploreByTouchHelper$2();
    }
    
    public ExploreByTouchHelper(final View mHost) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        final int mHoveredVirtualViewId = -1 << -1;
        this.mAccessibilityFocusedVirtualViewId = mHoveredVirtualViewId;
        this.mKeyboardFocusedVirtualViewId = mHoveredVirtualViewId;
        this.mHoveredVirtualViewId = mHoveredVirtualViewId;
        if (mHost != null) {
            this.mHost = mHost;
            this.mManager = (AccessibilityManager)mHost.getContext().getSystemService("accessibility");
            final int focusable = 1;
            mHost.setFocusable((boolean)(focusable != 0));
            if (ViewCompat.getImportantForAccessibility(mHost) == 0) {
                ViewCompat.setImportantForAccessibility(mHost, focusable);
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }
    
    private boolean clearAccessibilityFocus(final int n) {
        if (this.mAccessibilityFocusedVirtualViewId == n) {
            this.mAccessibilityFocusedVirtualViewId = -1 << -1;
            this.mHost.invalidate();
            this.sendEventForVirtualView(n, 65536);
            return true;
        }
        return false;
    }
    
    private boolean clickKeyboardFocusedVirtualView() {
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        return mKeyboardFocusedVirtualViewId != -1 << -1 && this.onPerformActionForVirtualView(mKeyboardFocusedVirtualViewId, 16, null);
    }
    
    private AccessibilityEvent createEvent(final int n, final int n2) {
        if (n != -1) {
            return this.createEventForChild(n, n2);
        }
        return this.createEventForHost(n2);
    }
    
    private AccessibilityEvent createEventForChild(final int n, final int n2) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n2);
        final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(obtain);
        final AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = this.obtainAccessibilityNodeInfo(n);
        record.getText().add(obtainAccessibilityNodeInfo.getText());
        record.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        record.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        record.setPassword(obtainAccessibilityNodeInfo.isPassword());
        record.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        record.setChecked(obtainAccessibilityNodeInfo.isChecked());
        this.onPopulateEventForVirtualView(n, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        record.setClassName(obtainAccessibilityNodeInfo.getClassName());
        record.setSource(this.mHost, n);
        obtain.setPackageName((CharSequence)this.mHost.getContext().getPackageName());
        return obtain;
    }
    
    private AccessibilityEvent createEventForHost(final int n) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n);
        ViewCompat.onInitializeAccessibilityEvent(this.mHost, obtain);
        return obtain;
    }
    
    private AccessibilityNodeInfoCompat createNodeForChild(final int n) {
        final AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        final int n2 = 1;
        obtain.setEnabled(n2 != 0);
        obtain.setFocusable(n2 != 0);
        obtain.setClassName("android.view.View");
        obtain.setBoundsInParent(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
        obtain.setBoundsInScreen(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
        obtain.setParent(this.mHost);
        this.onPopulateNodeForVirtualView(n, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals((Object)ExploreByTouchHelper.INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        final int actions = obtain.getActions();
        if ((actions & 0x40) != 0x0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 0x80) == 0x0) {
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            obtain.setSource(this.mHost, n);
            if (this.mAccessibilityFocusedVirtualViewId == n) {
                obtain.setAccessibilityFocused(n2 != 0);
                obtain.addAction(128);
            }
            else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
            final boolean focused = this.mKeyboardFocusedVirtualViewId == n;
            if (focused) {
                obtain.addAction(2);
            }
            else if (obtain.isFocusable()) {
                obtain.addAction(n2);
            }
            obtain.setFocused(focused);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            obtain.getBoundsInScreen(this.mTempScreenRect);
            if (this.mTempScreenRect.equals((Object)ExploreByTouchHelper.INVALID_PARENT_BOUNDS)) {
                obtain.getBoundsInParent(this.mTempScreenRect);
                final int mParentVirtualDescendantId = obtain.mParentVirtualDescendantId;
                final int n3 = -1;
                if (mParentVirtualDescendantId != n3) {
                    final AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                    for (int i = obtain.mParentVirtualDescendantId; i != n3; i = obtain2.mParentVirtualDescendantId) {
                        obtain2.setParent(this.mHost, n3);
                        obtain2.setBoundsInParent(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
                        this.onPopulateNodeForVirtualView(i, obtain2);
                        obtain2.getBoundsInParent(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    obtain2.recycle();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[n2] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[n2] - this.mHost.getScrollY());
                this.mTempScreenRect.intersect(this.mTempVisibleRect);
                obtain.setBoundsInScreen(this.mTempScreenRect);
                if (this.isVisibleToUser(this.mTempScreenRect)) {
                    obtain.setVisibleToUser(n2 != 0);
                }
            }
            return obtain;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    
    private AccessibilityNodeInfoCompat createNodeForHost() {
        final AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        final ArrayList<Integer> list = new ArrayList<Integer>();
        this.getVisibleVirtualViews(list);
        if (obtain.getChildCount() > 0 && list.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        for (int i = 0; i < list.size(); ++i) {
            obtain.addChild(this.mHost, list.get(i));
        }
        return obtain;
    }
    
    private SparseArrayCompat getAllNodes() {
        final ArrayList list = new ArrayList();
        this.getVisibleVirtualViews(list);
        final SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i = 0; i < list.size(); ++i) {
            sparseArrayCompat.put(i, this.createNodeForChild(i));
        }
        return sparseArrayCompat;
    }
    
    private void getBoundsInParent(final int n, final Rect rect) {
        this.obtainAccessibilityNodeInfo(n).getBoundsInParent(rect);
    }
    
    private static Rect guessPreviouslyFocusedRect(final View view, final int n, final Rect rect) {
        final int width = view.getWidth();
        final int height = view.getHeight();
        if (n != 17) {
            if (n != 33) {
                final int n2 = 66;
                final int n3 = -1;
                if (n != n2) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect.set(0, n3, width, n3);
                }
                else {
                    rect.set(n3, 0, n3, height);
                }
            }
            else {
                rect.set(0, height, width, height);
            }
        }
        else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }
    
    private boolean isVisibleToUser(final Rect rect) {
        boolean b = false;
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent viewParent;
        View view;
        for (viewParent = this.mHost.getParent(); viewParent instanceof View; viewParent = view.getParent()) {
            view = (View)viewParent;
            if (ViewCompat.getAlpha(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
        }
        if (viewParent != null) {
            b = true;
        }
        return b;
    }
    
    private static int keyToDirection(final int n) {
        switch (n) {
            default: {
                return 130;
            }
            case 22: {
                return 66;
            }
            case 21: {
                return 17;
            }
            case 19: {
                return 33;
            }
        }
    }
    
    private boolean moveFocus(final int n, final Rect rect) {
        final SparseArrayCompat allNodes = this.getAllNodes();
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        final int n2 = -1 << -1;
        Object o;
        if (mKeyboardFocusedVirtualViewId == n2) {
            o = null;
        }
        else {
            o = allNodes.get(mKeyboardFocusedVirtualViewId);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = null;
        if (n != 17 && n != 33 && n != 66 && n != 130) {
            switch (n) {
                default: {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                case 1:
                case 2: {
                    accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(allNodes, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, o, n, ViewCompat.getLayoutDirection(this.mHost) == 1, false);
                    break;
                }
            }
        }
        else {
            final Rect rect2 = new Rect();
            final int mKeyboardFocusedVirtualViewId2 = this.mKeyboardFocusedVirtualViewId;
            if (mKeyboardFocusedVirtualViewId2 != n2) {
                this.getBoundsInParent(mKeyboardFocusedVirtualViewId2, rect2);
            }
            else if (rect != null) {
                rect2.set(rect);
            }
            else {
                guessPreviouslyFocusedRect(this.mHost, n, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, o, rect2, n);
        }
        int key;
        if (accessibilityNodeInfoCompat == null) {
            key = -1 << -1;
        }
        else {
            key = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat));
        }
        return this.requestKeyboardFocusForVirtualView(key);
    }
    
    private boolean performActionForChild(final int n, final int n2, final Bundle bundle) {
        if (n2 == 64) {
            return this.requestAccessibilityFocus(n);
        }
        if (n2 == 128) {
            return this.clearAccessibilityFocus(n);
        }
        switch (n2) {
            default: {
                return this.onPerformActionForVirtualView(n, n2, bundle);
            }
            case 2: {
                return this.clearKeyboardFocusForVirtualView(n);
            }
            case 1: {
                return this.requestKeyboardFocusForVirtualView(n);
            }
        }
    }
    
    private boolean performActionForHost(final int n, final Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, n, bundle);
    }
    
    private boolean requestAccessibilityFocus(final int mAccessibilityFocusedVirtualViewId) {
        if (!this.mManager.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
            return false;
        }
        final int mAccessibilityFocusedVirtualViewId2 = this.mAccessibilityFocusedVirtualViewId;
        if (mAccessibilityFocusedVirtualViewId2 != mAccessibilityFocusedVirtualViewId) {
            if (mAccessibilityFocusedVirtualViewId2 != -1 << -1) {
                this.clearAccessibilityFocus(mAccessibilityFocusedVirtualViewId2);
            }
            this.mAccessibilityFocusedVirtualViewId = mAccessibilityFocusedVirtualViewId;
            this.mHost.invalidate();
            this.sendEventForVirtualView(mAccessibilityFocusedVirtualViewId, 32768);
            return true;
        }
        return false;
    }
    
    private void updateHoveredVirtualView(final int mHoveredVirtualViewId) {
        if (this.mHoveredVirtualViewId == mHoveredVirtualViewId) {
            return;
        }
        final int mHoveredVirtualViewId2 = this.mHoveredVirtualViewId;
        this.sendEventForVirtualView(this.mHoveredVirtualViewId = mHoveredVirtualViewId, 128);
        this.sendEventForVirtualView(mHoveredVirtualViewId2, 256);
    }
    
    public final boolean clearKeyboardFocusForVirtualView(final int n) {
        if (this.mKeyboardFocusedVirtualViewId != n) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = -1 << -1;
        this.onVirtualViewKeyboardFocusChanged(n, false);
        this.sendEventForVirtualView(n, 8);
        return true;
    }
    
    public final boolean dispatchHoverEvent(final MotionEvent motionEvent) {
        final boolean enabled = this.mManager.isEnabled();
        boolean b = false;
        if (enabled && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
            final int action = motionEvent.getAction();
            final int n = 7;
            final boolean b2 = true;
            final int n2 = -1 << -1;
            if (action != n) {
                switch (action) {
                    default: {
                        return false;
                    }
                    case 10: {
                        if (this.mAccessibilityFocusedVirtualViewId != n2) {
                            this.updateHoveredVirtualView(n2);
                            return b2;
                        }
                        return false;
                    }
                    case 9: {
                        break;
                    }
                }
            }
            final int virtualView = this.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            this.updateHoveredVirtualView(virtualView);
            if (virtualView != n2) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    public final boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        boolean b = false;
        final int action = keyEvent.getAction();
        final int n = 1;
        if (action != n) {
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        default: {
                            return b;
                        }
                        case 19:
                        case 20:
                        case 21:
                        case 22: {
                            if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                                for (int keyToDirection = keyToDirection(keyCode), n2 = keyEvent.getRepeatCount() + n, n3 = 0; n3 < n2 && this.moveFocus(keyToDirection, null); ++n3) {
                                    b = true;
                                }
                                return b;
                            }
                            return b;
                        }
                        case 23: {
                            break;
                        }
                    }
                }
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    if (keyEvent.getRepeatCount() == 0) {
                        this.clickKeyboardFocusedVirtualView();
                        b = true;
                    }
                }
            }
            else if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                b = this.moveFocus(2, null);
            }
            else if (KeyEventCompat.hasModifiers(keyEvent, n)) {
                b = this.moveFocus(n, null);
            }
        }
        return b;
    }
    
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new ExploreByTouchHelper$MyNodeProvider(this);
        }
        return this.mNodeProvider;
    }
    
    public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }
    
    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }
    
    protected abstract int getVirtualViewAt(final float p0, final float p1);
    
    protected abstract void getVisibleVirtualViews(final List p0);
    
    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }
    
    public final void invalidateVirtualView(final int n) {
        this.invalidateVirtualView(n, 0);
    }
    
    public final void invalidateVirtualView(final int n, final int n2) {
        if (n != -1 << -1 && this.mManager.isEnabled()) {
            final ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                final AccessibilityEvent event = this.createEvent(n, 2048);
                AccessibilityEventCompat.setContentChangeTypes(event, n2);
                ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, event);
            }
        }
    }
    
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(final int n) {
        if (n == -1) {
            return this.createNodeForHost();
        }
        return this.createNodeForChild(n);
    }
    
    public final void onFocusChanged(final boolean b, final int n, final Rect rect) {
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        if (mKeyboardFocusedVirtualViewId != -1 << -1) {
            this.clearKeyboardFocusForVirtualView(mKeyboardFocusedVirtualViewId);
        }
        if (b) {
            this.moveFocus(n, rect);
        }
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        this.onPopulateEventForHost(accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        this.onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }
    
    protected abstract boolean onPerformActionForVirtualView(final int p0, final int p1, final Bundle p2);
    
    protected void onPopulateEventForHost(final AccessibilityEvent accessibilityEvent) {
    }
    
    protected void onPopulateEventForVirtualView(final int n, final AccessibilityEvent accessibilityEvent) {
    }
    
    protected void onPopulateNodeForHost(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
    
    protected abstract void onPopulateNodeForVirtualView(final int p0, final AccessibilityNodeInfoCompat p1);
    
    protected void onVirtualViewKeyboardFocusChanged(final int n, final boolean b) {
    }
    
    boolean performAction(final int n, final int n2, final Bundle bundle) {
        if (n != -1) {
            return this.performActionForChild(n, n2, bundle);
        }
        return this.performActionForHost(n2, bundle);
    }
    
    public final boolean requestKeyboardFocusForVirtualView(final int mKeyboardFocusedVirtualViewId) {
        if (!this.mHost.isFocused() && !this.mHost.requestFocus()) {
            return false;
        }
        final int mKeyboardFocusedVirtualViewId2 = this.mKeyboardFocusedVirtualViewId;
        if (mKeyboardFocusedVirtualViewId2 == mKeyboardFocusedVirtualViewId) {
            return false;
        }
        if (mKeyboardFocusedVirtualViewId2 != -1 << -1) {
            this.clearKeyboardFocusForVirtualView(mKeyboardFocusedVirtualViewId2);
        }
        this.mKeyboardFocusedVirtualViewId = mKeyboardFocusedVirtualViewId;
        final boolean b = true;
        this.onVirtualViewKeyboardFocusChanged(mKeyboardFocusedVirtualViewId, b);
        this.sendEventForVirtualView(mKeyboardFocusedVirtualViewId, 8);
        return b;
    }
    
    public final boolean sendEventForVirtualView(final int n, final int n2) {
        if (n != -1 << -1 && this.mManager.isEnabled()) {
            final ViewParent parent = this.mHost.getParent();
            return parent != null && ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, this.createEvent(n, n2));
        }
        return false;
    }
}
