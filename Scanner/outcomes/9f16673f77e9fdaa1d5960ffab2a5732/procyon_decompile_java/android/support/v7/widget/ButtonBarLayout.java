// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.LinearLayout$LayoutParams;
import android.support.v4.view.ViewCompat;
import android.os.Build$VERSION;
import android.view.View$MeasureSpec;
import android.view.View;
import android.support.v7.appcompat.R$id;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.support.v4.content.res.ConfigurationHelper;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout
{
    private static final int ALLOW_STACKING_MIN_HEIGHT_DP = 320;
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private int mMinimumHeight;
    
    public ButtonBarLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.mLastWidthSize = -1;
        boolean b = false;
        this.mMinimumHeight = 0;
        if (ConfigurationHelper.getScreenHeightDp(this.getResources()) >= 320) {
            b = true;
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.ButtonBarLayout);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, b);
        obtainStyledAttributes.recycle();
    }
    
    private int getNextVisibleChildIndex(final int n) {
        for (int i = n; i < this.getChildCount(); ++i) {
            if (this.getChildAt(i).getVisibility() == 0) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isStacked() {
        final int orientation = this.getOrientation();
        boolean b = true;
        if (orientation != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    private void setStacked(final boolean orientation) {
        this.setOrientation((int)(orientation ? 1 : 0));
        int gravity;
        if ((orientation ? 1 : 0) != 0) {
            gravity = 5;
        }
        else {
            gravity = 80;
        }
        this.setGravity(gravity);
        final View viewById = this.findViewById(R$id.spacer);
        if (viewById != null) {
            int visibility;
            if ((orientation ? 1 : 0) != 0) {
                visibility = 8;
            }
            else {
                visibility = 4;
            }
            viewById.setVisibility(visibility);
        }
        for (int i = this.getChildCount() - 2; i >= 0; --i) {
            this.bringChildToFront(this.getChildAt(i));
        }
    }
    
    public int getMinimumHeight() {
        return Math.max(this.mMinimumHeight, super.getMinimumHeight());
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int size = View$MeasureSpec.getSize(n);
        if (this.mAllowStacking) {
            if (size > this.mLastWidthSize && this.isStacked()) {
                this.setStacked(false);
            }
            this.mLastWidthSize = size;
        }
        boolean b = false;
        int measureSpec;
        if (!this.isStacked() && View$MeasureSpec.getMode(n) == 1073741824) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(size, -1 << -1);
            b = true;
        }
        else {
            measureSpec = n;
        }
        super.onMeasure(measureSpec, n2);
        if (this.mAllowStacking && !this.isStacked()) {
            final int sdk_INT = Build$VERSION.SDK_INT;
            final int n3 = 11;
            final boolean stacked = true;
            boolean b2;
            if (sdk_INT >= n3) {
                b2 = ((0xFF000000 & ViewCompat.getMeasuredWidthAndState((View)this)) == 0x1000000);
            }
            else {
                int n4 = 0;
                for (int i = 0; i < this.getChildCount(); ++i) {
                    n4 += this.getChildAt(i).getMeasuredWidth();
                }
                b2 = (this.getPaddingLeft() + n4 + this.getPaddingRight() > size);
            }
            if (b2) {
                this.setStacked(stacked);
                b = true;
            }
        }
        if (b) {
            super.onMeasure(n, n2);
        }
        int minimumHeight = 0;
        final int nextVisibleChildIndex = this.getNextVisibleChildIndex(0);
        if (nextVisibleChildIndex >= 0) {
            final View child = this.getChildAt(nextVisibleChildIndex);
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)child.getLayoutParams();
            minimumHeight = 0 + (this.getPaddingTop() + child.getMeasuredHeight() + linearLayout$LayoutParams.topMargin + linearLayout$LayoutParams.bottomMargin);
            if (this.isStacked()) {
                final int nextVisibleChildIndex2 = this.getNextVisibleChildIndex(nextVisibleChildIndex + 1);
                if (nextVisibleChildIndex2 >= 0) {
                    minimumHeight += (int)(this.getChildAt(nextVisibleChildIndex2).getPaddingTop() + this.getResources().getDisplayMetrics().density * 16.0f);
                }
            }
            else {
                minimumHeight += this.getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight((View)this) != minimumHeight) {
            this.setMinimumHeight(minimumHeight);
        }
    }
    
    public void setAllowStacking(final boolean mAllowStacking) {
        if (this.mAllowStacking != mAllowStacking) {
            if (!(this.mAllowStacking = mAllowStacking) && this.getOrientation() == 1) {
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }
}
