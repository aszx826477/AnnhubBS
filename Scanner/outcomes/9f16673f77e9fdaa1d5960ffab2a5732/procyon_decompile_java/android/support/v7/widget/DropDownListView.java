// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.ListView;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.view.View;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.content.Context;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class DropDownListView extends ListViewCompat
{
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;
    
    public DropDownListView(final Context context, final boolean mHijackFocus) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.mHijackFocus = mHijackFocus;
        this.setCacheColorHint(0);
    }
    
    private void clearPressedItem() {
        this.setPressed(this.mDrawsInPressedState = false);
        this.drawableStateChanged();
        final View child = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
        if (child != null) {
            child.setPressed(false);
        }
        final ViewPropertyAnimatorCompat mClickAnimation = this.mClickAnimation;
        if (mClickAnimation != null) {
            mClickAnimation.cancel();
            this.mClickAnimation = null;
        }
    }
    
    private void clickPressedItem(final View view, final int n) {
        this.performItemClick(view, n, this.getItemIdAtPosition(n));
    }
    
    private void setPressedItem(final View view, final int mMotionPosition, final float n, final float n2) {
        final boolean pressed = true;
        this.mDrawsInPressedState = pressed;
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n3 = 21;
        if (sdk_INT >= n3) {
            this.drawableHotspotChanged(n, n2);
        }
        if (!this.isPressed()) {
            this.setPressed(pressed);
        }
        this.layoutChildren();
        if (this.mMotionPosition != -1) {
            final View child = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
            if (child != null && child != view && child.isPressed()) {
                child.setPressed(false);
            }
        }
        this.mMotionPosition = mMotionPosition;
        final float n4 = n - view.getLeft();
        final float n5 = n2 - view.getTop();
        if (Build$VERSION.SDK_INT >= n3) {
            view.drawableHotspotChanged(n4, n5);
        }
        if (!view.isPressed()) {
            view.setPressed(pressed);
        }
        this.positionSelectorLikeTouchCompat(mMotionPosition, view, n, n2);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }
    
    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }
    
    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }
    
    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }
    
    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }
    
    public boolean onForwardedEvent(final MotionEvent motionEvent, final int n) {
        boolean b = true;
        boolean b2 = false;
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final boolean enabled = true;
        Label_0189: {
            switch (actionMasked) {
                default: {
                    break Label_0189;
                }
                case 3: {
                    b = false;
                    break Label_0189;
                }
                case 2: {
                    break;
                }
                case 1: {
                    b = false;
                    break;
                }
            }
            final int pointerIndex = motionEvent.findPointerIndex(n);
            if (pointerIndex < 0) {
                b = false;
            }
            else {
                final int n2 = (int)motionEvent.getX(pointerIndex);
                final int n3 = (int)motionEvent.getY(pointerIndex);
                final int pointToPosition = this.pointToPosition(n2, n3);
                if (pointToPosition == -1) {
                    b2 = true;
                }
                else {
                    final View child = this.getChildAt(pointToPosition - this.getFirstVisiblePosition());
                    this.setPressedItem(child, pointToPosition, n2, n3);
                    b = true;
                    if (actionMasked == (enabled ? 1 : 0)) {
                        this.clickPressedItem(child, pointToPosition);
                    }
                }
            }
        }
        if (!b || b2) {
            this.clearPressedItem();
        }
        if (b) {
            if (this.mScrollHelper == null) {
                this.mScrollHelper = new ListViewAutoScrollHelper(this);
            }
            this.mScrollHelper.setEnabled(enabled);
            this.mScrollHelper.onTouch((View)this, motionEvent);
        }
        else {
            final ListViewAutoScrollHelper mScrollHelper = this.mScrollHelper;
            if (mScrollHelper != null) {
                mScrollHelper.setEnabled(false);
            }
        }
        return b;
    }
    
    void setListSelectionHidden(final boolean mListSelectionHidden) {
        this.mListSelectionHidden = mListSelectionHidden;
    }
    
    protected boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
    }
}
