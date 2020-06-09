// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.MotionEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.widget.AbsListView;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import java.lang.reflect.Field;
import android.widget.ListView;

public class ListViewCompat extends ListView
{
    public static final int INVALID_POSITION = 255;
    public static final int NO_POSITION = 255;
    private static final int[] STATE_SET_NOTHING;
    private Field mIsChildViewEnabled;
    protected int mMotionPosition;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private ListViewCompat$GateKeeperDrawable mSelector;
    final Rect mSelectorRect;
    
    static {
        STATE_SET_NOTHING = new int[] { 0 };
    }
    
    public ListViewCompat(final Context context) {
        this(context, null);
    }
    
    public ListViewCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ListViewCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        final Class<AbsListView> clazz = AbsListView.class;
        final String s = "mIsChildViewEnabled";
        final Class<AbsListView> clazz2 = clazz;
        try {
            (this.mIsChildViewEnabled = clazz2.getDeclaredField(s)).setAccessible(true);
        }
        catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void dispatchDraw(final Canvas canvas) {
        this.drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }
    
    protected void drawSelectorCompat(final Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            final Drawable selector = this.getSelector();
            if (selector != null) {
                selector.setBounds(this.mSelectorRect);
                selector.draw(canvas);
            }
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }
    
    public int lookForSelectablePosition(int n, final boolean b) {
        final ListAdapter adapter = this.getAdapter();
        final int n2 = -1;
        if (adapter == null || this.isInTouchMode()) {
            return n2;
        }
        final int count = adapter.getCount();
        if (!this.getAdapter().areAllItemsEnabled()) {
            if (b) {
                for (n = Math.max(0, n); n < count && !adapter.isEnabled(n); ++n) {}
            }
            else {
                for (n = Math.min(n, count - 1); n >= 0 && !adapter.isEnabled(n); --n) {}
            }
            if (n >= 0 && n < count) {
                return n;
            }
            return n2;
        }
        else {
            if (n >= 0 && n < count) {
                return n;
            }
            return n2;
        }
    }
    
    public int measureHeightOfChildrenCompat(final int n, final int n2, final int n3, final int n4, final int n5) {
        int listPaddingTop = this.getListPaddingTop();
        int listPaddingBottom = this.getListPaddingBottom();
        this.getListPaddingLeft();
        this.getListPaddingRight();
        final int dividerHeight = this.getDividerHeight();
        final Drawable divider = this.getDivider();
        final ListAdapter adapter = this.getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        final int n6 = listPaddingTop + listPaddingBottom;
        int n7;
        if (dividerHeight > 0 && divider != null) {
            n7 = dividerHeight;
        }
        else {
            n7 = 0;
        }
        View view = null;
        final int count = adapter.getCount();
        int n8 = 0;
        int n9 = 0;
        int n10 = n6;
        int n11;
        int n12;
        for (int i = 0; i < count; ++i, listPaddingTop = n11, listPaddingBottom = n12) {
            n11 = listPaddingTop;
            final int itemViewType = adapter.getItemViewType(i);
            if (itemViewType != n8) {
                view = null;
                n8 = itemViewType;
            }
            view = adapter.getView(i, view, (ViewGroup)this);
            final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup$LayoutParams generateDefaultLayoutParams;
            if (layoutParams == null) {
                generateDefaultLayoutParams = this.generateDefaultLayoutParams();
                view.setLayoutParams(generateDefaultLayoutParams);
            }
            else {
                generateDefaultLayoutParams = layoutParams;
            }
            n12 = listPaddingBottom;
            int n13;
            if (generateDefaultLayoutParams.height > 0) {
                n13 = View$MeasureSpec.makeMeasureSpec(generateDefaultLayoutParams.height, 1073741824);
            }
            else {
                n13 = View$MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(n, n13);
            view.forceLayout();
            if (i > 0) {
                n10 += n7;
            }
            n10 += view.getMeasuredHeight();
            if (n10 >= n4) {
                int n14;
                if (n5 >= 0 && i > n5 && n9 > 0 && n10 != n4) {
                    n14 = n9;
                }
                else {
                    n14 = n4;
                }
                return n14;
            }
            if (n5 >= 0 && i >= n5) {
                n9 = n10;
            }
        }
        return n10;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }
    
    protected void positionSelectorCompat(final int n, final View view) {
        final Rect mSelectorRect = this.mSelectorRect;
        mSelectorRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        mSelectorRect.left -= this.mSelectionLeftPadding;
        mSelectorRect.top -= this.mSelectionTopPadding;
        mSelectorRect.right += this.mSelectionRightPadding;
        mSelectorRect.bottom += this.mSelectionBottomPadding;
        try {
            final boolean boolean1 = this.mIsChildViewEnabled.getBoolean(this);
            try {
                if (view.isEnabled() != boolean1) {
                    this.mIsChildViewEnabled.set(this, !boolean1);
                    if (n != -1) {
                        this.refreshDrawableState();
                    }
                }
            }
            catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        catch (IllegalAccessException ex2) {}
    }
    
    protected void positionSelectorLikeFocusCompat(final int n, final View view) {
        final Drawable selector = this.getSelector();
        boolean b = true;
        final boolean b2 = selector != null && n != -1;
        if (b2) {
            selector.setVisible(false, false);
        }
        this.positionSelectorCompat(n, view);
        if (b2) {
            final Rect mSelectorRect = this.mSelectorRect;
            final float exactCenterX = mSelectorRect.exactCenterX();
            final float exactCenterY = mSelectorRect.exactCenterY();
            if (this.getVisibility() != 0) {
                b = false;
            }
            selector.setVisible(b, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }
    
    protected void positionSelectorLikeTouchCompat(final int n, final View view, final float n2, final float n3) {
        this.positionSelectorLikeFocusCompat(n, view);
        final Drawable selector = this.getSelector();
        if (selector != null && n != -1) {
            DrawableCompat.setHotspot(selector, n2, n3);
        }
    }
    
    public void setSelector(final Drawable drawable) {
        ListViewCompat$GateKeeperDrawable mSelector;
        if (drawable != null) {
            mSelector = new ListViewCompat$GateKeeperDrawable(drawable);
        }
        else {
            mSelector = null;
        }
        super.setSelector((Drawable)(this.mSelector = mSelector));
        final Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
    
    protected void setSelectorEnabled(final boolean enabled) {
        final ListViewCompat$GateKeeperDrawable mSelector = this.mSelector;
        if (mSelector != null) {
            mSelector.setEnabled(enabled);
        }
    }
    
    protected boolean shouldShowSelectorCompat() {
        return this.touchModeDrawsInPressedStateCompat() && this.isPressed();
    }
    
    protected boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }
    
    protected void updateSelectorStateCompat() {
        final Drawable selector = this.getSelector();
        if (selector != null && this.shouldShowSelectorCompat()) {
            selector.setState(this.getDrawableState());
        }
    }
}
