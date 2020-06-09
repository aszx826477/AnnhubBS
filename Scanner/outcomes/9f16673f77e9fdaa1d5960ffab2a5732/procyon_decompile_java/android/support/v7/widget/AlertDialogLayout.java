// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.R$id;
import android.view.ViewGroup;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;

public class AlertDialogLayout extends LinearLayoutCompat
{
    public AlertDialogLayout(final Context context) {
        super(context);
    }
    
    public AlertDialogLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    private void forceUniformWidth(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)child.getLayoutParams();
                if (linearLayoutCompat$LayoutParams.width == -1) {
                    final int height = linearLayoutCompat$LayoutParams.height;
                    linearLayoutCompat$LayoutParams.height = child.getMeasuredHeight();
                    this.measureChildWithMargins(child, measureSpec, 0, n2, 0);
                    linearLayoutCompat$LayoutParams.height = height;
                }
            }
        }
    }
    
    private static int resolveMinimumHeight(final View view) {
        final int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }
    
    private void setChildFrame(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n + n3, n2 + n4);
    }
    
    private boolean tryOnMeasure(final int n, final int n2) {
        View view = null;
        View view2 = null;
        View view3 = null;
        final int childCount = this.getChildCount();
        int n3 = 0;
        while (true) {
            final int n4 = 8;
            if (n3 >= childCount) {
                final int mode = View$MeasureSpec.getMode(n2);
                final int size = View$MeasureSpec.getSize(n2);
                final int mode2 = View$MeasureSpec.getMode(n);
                int n5 = 0;
                int n6 = this.getPaddingTop() + this.getPaddingBottom();
                if (view != null) {
                    view.measure(n, 0);
                    n6 += view.getMeasuredHeight();
                    n5 = ViewCompat.combineMeasuredStates(0, ViewCompat.getMeasuredState(view));
                }
                int resolveMinimumHeight = 0;
                int n7 = 0;
                if (view2 != null) {
                    view2.measure(n, 0);
                    resolveMinimumHeight = resolveMinimumHeight(view2);
                    n7 = view2.getMeasuredHeight() - resolveMinimumHeight;
                    n6 += resolveMinimumHeight;
                    n5 = ViewCompat.combineMeasuredStates(n5, ViewCompat.getMeasuredState(view2));
                }
                int measuredHeight = 0;
                if (view3 != null) {
                    int measureSpec;
                    if (mode == 0) {
                        measureSpec = 0;
                    }
                    else {
                        measureSpec = View$MeasureSpec.makeMeasureSpec(Math.max(0, size - n6), mode);
                    }
                    view3.measure(n, measureSpec);
                    measuredHeight = view3.getMeasuredHeight();
                    n6 += measuredHeight;
                    n5 = ViewCompat.combineMeasuredStates(n5, ViewCompat.getMeasuredState(view3));
                }
                int n8 = size - n6;
                final int n9 = 1073741824;
                if (view2 != null) {
                    final int n10 = n6 - resolveMinimumHeight;
                    final int min = Math.min(n8, n7);
                    if (min > 0) {
                        n8 -= min;
                        resolveMinimumHeight += min;
                    }
                    final int n11 = n8;
                    view2.measure(n, View$MeasureSpec.makeMeasureSpec(resolveMinimumHeight, n9));
                    n6 = n10 + view2.getMeasuredHeight();
                    n5 = ViewCompat.combineMeasuredStates(n5, ViewCompat.getMeasuredState(view2));
                    n8 = n11;
                }
                if (view3 != null && n8 > 0) {
                    final int n12 = n6 - measuredHeight;
                    final int n13 = n8;
                    final int n14 = n8 - n8;
                    final int n15 = measuredHeight + n13;
                    final int n16 = n14;
                    view3.measure(n, View$MeasureSpec.makeMeasureSpec(n15, mode));
                    n6 = n12 + view3.getMeasuredHeight();
                    n5 = ViewCompat.combineMeasuredStates(n5, ViewCompat.getMeasuredState(view3));
                    n8 = n16;
                }
                int max = 0;
                View view4;
                View view5;
                for (int i = 0; i < childCount; ++i, view2 = view4, view3 = view5) {
                    final View child = this.getChildAt(i);
                    view4 = view2;
                    final int visibility = child.getVisibility();
                    view5 = view3;
                    if (visibility != 8) {
                        max = Math.max(max, child.getMeasuredWidth());
                    }
                }
                this.setMeasuredDimension(ViewCompat.resolveSizeAndState(max + (this.getPaddingLeft() + this.getPaddingRight()), n, n5), ViewCompat.resolveSizeAndState(n6, n2, 0));
                if (mode2 != 1073741824) {
                    this.forceUniformWidth(childCount, n2);
                }
                return true;
            }
            final View child2 = this.getChildAt(n3);
            if (child2.getVisibility() != n4) {
                final int id = child2.getId();
                if (id == R$id.topPanel) {
                    view = child2;
                }
                else if (id == R$id.buttonPanel) {
                    view2 = child2;
                }
                else {
                    if (id != R$id.contentPanel && id != R$id.customPanel) {
                        return false;
                    }
                    if (view3 != null) {
                        return false;
                    }
                    view3 = child2;
                }
            }
            ++n3;
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        AlertDialogLayout alertDialogLayout = this;
        final int paddingLeft = this.getPaddingLeft();
        final int n5 = n3 - n;
        final int n6 = n5 - this.getPaddingRight();
        final int n7 = n5 - paddingLeft - this.getPaddingRight();
        final int measuredHeight = this.getMeasuredHeight();
        final int childCount = this.getChildCount();
        final int gravity = this.getGravity();
        final int n8 = gravity & 0x70;
        final int n9 = gravity & 0x800007;
        int paddingTop;
        if (n8 != 16) {
            if (n8 != 80) {
                paddingTop = this.getPaddingTop();
            }
            else {
                paddingTop = this.getPaddingTop() + n4 - n2 - measuredHeight;
            }
        }
        else {
            paddingTop = this.getPaddingTop() + (n4 - n2 - measuredHeight) / 2;
        }
        final Drawable dividerDrawable = this.getDividerDrawable();
        int intrinsicHeight;
        if (dividerDrawable == null) {
            intrinsicHeight = 0;
        }
        else {
            intrinsicHeight = dividerDrawable.getIntrinsicHeight();
        }
        final int n10 = intrinsicHeight;
        int n15;
        for (int i = 0; i < childCount; i = n15 + 1, alertDialogLayout = this) {
            final View child = alertDialogLayout.getChildAt(i);
            if (child != null && child.getVisibility() != 8) {
                final int measuredWidth = child.getMeasuredWidth();
                final int measuredHeight2 = child.getMeasuredHeight();
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)child.getLayoutParams();
                final int gravity2 = linearLayoutCompat$LayoutParams.gravity;
                int n11;
                if (gravity2 < 0) {
                    n11 = n9;
                }
                else {
                    n11 = gravity2;
                }
                final int n12 = GravityCompat.getAbsoluteGravity(n11, ViewCompat.getLayoutDirection((View)this)) & 0x7;
                int n13;
                if (n12 != 1) {
                    if (n12 != 5) {
                        n13 = linearLayoutCompat$LayoutParams.leftMargin + paddingLeft;
                    }
                    else {
                        n13 = n6 - measuredWidth - linearLayoutCompat$LayoutParams.rightMargin;
                    }
                }
                else {
                    n13 = (n7 - measuredWidth) / 2 + paddingLeft + linearLayoutCompat$LayoutParams.leftMargin - linearLayoutCompat$LayoutParams.rightMargin;
                }
                if (alertDialogLayout.hasDividerBeforeChildAt(i)) {
                    paddingTop += n10;
                }
                final int n14 = paddingTop + linearLayoutCompat$LayoutParams.topMargin;
                n15 = i;
                this.setChildFrame(child, n13, n14, measuredWidth, measuredHeight2);
                paddingTop = n14 + (measuredHeight2 + linearLayoutCompat$LayoutParams.bottomMargin);
            }
            else {
                n15 = i;
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (!this.tryOnMeasure(n, n2)) {
            super.onMeasure(n, n2);
        }
    }
}
