// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.accessibility.AccessibilityNodeInfo;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.View$MeasureSpec;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class LinearLayoutCompat extends ViewGroup
{
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;
    
    public LinearLayoutCompat(final Context context) {
        this(context, null);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final boolean mBaselineAligned = true;
        this.mBaselineAligned = mBaselineAligned;
        final int mBaselineAlignedChildIndex = -1;
        this.mBaselineAlignedChildIndex = mBaselineAlignedChildIndex;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.LinearLayoutCompat, n, 0);
        final int int1 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_orientation, mBaselineAlignedChildIndex);
        if (int1 >= 0) {
            this.setOrientation(int1);
        }
        final int int2 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_gravity, mBaselineAlignedChildIndex);
        if (int2 >= 0) {
            this.setGravity(int2);
        }
        final boolean boolean1 = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, mBaselineAligned);
        if (!boolean1) {
            this.setBaselineAligned(boolean1);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, mBaselineAlignedChildIndex);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(obtainStyledAttributes.getDrawable(R$styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }
    
    private void forceUniformHeight(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild.getVisibility() != 8) {
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                if (linearLayoutCompat$LayoutParams.height == -1) {
                    final int width = linearLayoutCompat$LayoutParams.width;
                    linearLayoutCompat$LayoutParams.width = virtualChild.getMeasuredWidth();
                    this.measureChildWithMargins(virtualChild, n2, 0, measureSpec, 0);
                    linearLayoutCompat$LayoutParams.width = width;
                }
            }
        }
    }
    
    private void forceUniformWidth(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild.getVisibility() != 8) {
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                if (linearLayoutCompat$LayoutParams.width == -1) {
                    final int height = linearLayoutCompat$LayoutParams.height;
                    linearLayoutCompat$LayoutParams.height = virtualChild.getMeasuredHeight();
                    this.measureChildWithMargins(virtualChild, measureSpec, 0, n2, 0);
                    linearLayoutCompat$LayoutParams.height = height;
                }
            }
        }
    }
    
    private void setChildFrame(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n + n3, n2 + n4);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LinearLayoutCompat$LayoutParams;
    }
    
    void drawDividersHorizontal(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild != null && virtualChild.getVisibility() != 8) {
                if (this.hasDividerBeforeChildAt(i)) {
                    final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                    int n;
                    if (layoutRtl) {
                        n = virtualChild.getRight() + linearLayoutCompat$LayoutParams.rightMargin;
                    }
                    else {
                        n = virtualChild.getLeft() - linearLayoutCompat$LayoutParams.leftMargin - this.mDividerWidth;
                    }
                    this.drawVerticalDivider(canvas, n);
                }
            }
        }
        if (this.hasDividerBeforeChildAt(virtualChildCount)) {
            final View virtualChild2 = this.getVirtualChildAt(virtualChildCount - 1);
            int paddingLeft;
            if (virtualChild2 == null) {
                if (layoutRtl) {
                    paddingLeft = this.getPaddingLeft();
                }
                else {
                    paddingLeft = this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
                }
            }
            else {
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams2 = (LinearLayoutCompat$LayoutParams)virtualChild2.getLayoutParams();
                if (layoutRtl) {
                    paddingLeft = virtualChild2.getLeft() - linearLayoutCompat$LayoutParams2.leftMargin - this.mDividerWidth;
                }
                else {
                    paddingLeft = virtualChild2.getRight() + linearLayoutCompat$LayoutParams2.rightMargin;
                }
            }
            this.drawVerticalDivider(canvas, paddingLeft);
        }
    }
    
    void drawDividersVertical(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; ++i) {
            final View virtualChild = this.getVirtualChildAt(i);
            if (virtualChild != null && virtualChild.getVisibility() != 8) {
                if (this.hasDividerBeforeChildAt(i)) {
                    this.drawHorizontalDivider(canvas, virtualChild.getTop() - ((LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams()).topMargin - this.mDividerHeight);
                }
            }
        }
        if (this.hasDividerBeforeChildAt(virtualChildCount)) {
            final View virtualChild2 = this.getVirtualChildAt(virtualChildCount - 1);
            int n;
            if (virtualChild2 == null) {
                n = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
            }
            else {
                n = virtualChild2.getBottom() + ((LinearLayoutCompat$LayoutParams)virtualChild2.getLayoutParams()).bottomMargin;
            }
            this.drawHorizontalDivider(canvas, n);
        }
    }
    
    void drawHorizontalDivider(final Canvas canvas, final int n) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, n, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, this.mDividerHeight + n);
        this.mDivider.draw(canvas);
    }
    
    void drawVerticalDivider(final Canvas canvas, final int n) {
        this.mDivider.setBounds(n, this.getPaddingTop() + this.mDividerPadding, this.mDividerWidth + n, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }
    
    protected LinearLayoutCompat$LayoutParams generateDefaultLayoutParams() {
        final int mOrientation = this.mOrientation;
        final int n = -2;
        if (mOrientation == 0) {
            return new LinearLayoutCompat$LayoutParams(n, n);
        }
        if (mOrientation == 1) {
            return new LinearLayoutCompat$LayoutParams(-1, n);
        }
        return null;
    }
    
    public LinearLayoutCompat$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LinearLayoutCompat$LayoutParams(this.getContext(), set);
    }
    
    protected LinearLayoutCompat$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return new LinearLayoutCompat$LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        final int childCount = this.getChildCount();
        final int mBaselineAlignedChildIndex = this.mBaselineAlignedChildIndex;
        if (childCount <= mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        final View child = this.getChildAt(mBaselineAlignedChildIndex);
        final int baseline = child.getBaseline();
        final int n = -1;
        if (baseline != n) {
            int mBaselineChildTop = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                final int n2 = this.mGravity & 0x70;
                if (n2 != 48) {
                    if (n2 != 16) {
                        if (n2 == 80) {
                            mBaselineChildTop = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength;
                        }
                    }
                    else {
                        mBaselineChildTop += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
                    }
                }
            }
            return ((LinearLayoutCompat$LayoutParams)child.getLayoutParams()).topMargin + mBaselineChildTop + baseline;
        }
        if (this.mBaselineAlignedChildIndex == 0) {
            return n;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    }
    
    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }
    
    int getChildrenSkipCount(final View view, final int n) {
        return 0;
    }
    
    public Drawable getDividerDrawable() {
        return this.mDivider;
    }
    
    public int getDividerPadding() {
        return this.mDividerPadding;
    }
    
    public int getDividerWidth() {
        return this.mDividerWidth;
    }
    
    public int getGravity() {
        return this.mGravity;
    }
    
    int getLocationOffset(final View view) {
        return 0;
    }
    
    int getNextLocationOffset(final View view) {
        return 0;
    }
    
    public int getOrientation() {
        return this.mOrientation;
    }
    
    public int getShowDividers() {
        return this.mShowDividers;
    }
    
    View getVirtualChildAt(final int n) {
        return this.getChildAt(n);
    }
    
    int getVirtualChildCount() {
        return this.getChildCount();
    }
    
    public float getWeightSum() {
        return this.mWeightSum;
    }
    
    protected boolean hasDividerBeforeChildAt(final int n) {
        boolean b = false;
        final boolean b2 = true;
        if (n == 0) {
            if ((this.mShowDividers & (b2 ? 1 : 0)) != 0x0) {
                b = true;
            }
            return b;
        }
        if (n == this.getChildCount()) {
            if ((this.mShowDividers & 0x4) != 0x0) {
                b = true;
            }
            return b;
        }
        if ((this.mShowDividers & 0x2) != 0x0) {
            boolean b3 = false;
            for (int i = n - 1; i >= 0; --i) {
                if (this.getChildAt(i).getVisibility() != 8) {
                    b3 = true;
                    break;
                }
            }
            return b3;
        }
        return false;
    }
    
    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }
    
    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }
    
    void layoutHorizontal(final int n, final int n2, final int n3, final int n4) {
        int layoutRtl = ViewUtils.isLayoutRtl((View)this) ? 1 : 0;
        int paddingTop = this.getPaddingTop();
        int n5 = n4 - n2;
        final int n6 = n5 - this.getPaddingBottom();
        final int n7 = n5 - paddingTop - this.getPaddingBottom();
        int virtualChildCount = this.getVirtualChildCount();
        final int mGravity = this.mGravity;
        final int n8 = mGravity & 0x800007;
        final int n9 = mGravity & 0x70;
        final boolean mBaselineAligned = this.mBaselineAligned;
        int[] mMaxAscent = this.mMaxAscent;
        int[] mMaxDescent = this.mMaxDescent;
        int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n8, layoutDirection);
        final int n10 = 2;
        int paddingLeft;
        if (absoluteGravity != 1) {
            if (absoluteGravity != 5) {
                paddingLeft = this.getPaddingLeft();
            }
            else {
                paddingLeft = this.getPaddingLeft() + n3 - n - this.mTotalLength;
            }
        }
        else {
            paddingLeft = this.getPaddingLeft() + (n3 - n - this.mTotalLength) / 2;
        }
        final int n11 = 1;
        int n14;
        int n15;
        if (layoutRtl != 0) {
            final int n12 = virtualChildCount - 1;
            final int n13 = -1;
            n14 = n12;
            n15 = n13;
        }
        else {
            n14 = 0;
            n15 = n11;
        }
        int n17;
        int n18;
        int[] array;
        int[] array2;
        int n19;
        int n20;
        int n21;
        for (int i = 0; i < virtualChildCount; ++i, layoutRtl = n17, layoutDirection = n18, n5 = n20, virtualChildCount = n21, paddingTop = n19, mMaxDescent = array, mMaxAscent = array2) {
            final int n16 = n14 + n15 * i;
            n17 = layoutRtl;
            final View virtualChild = this.getVirtualChildAt(n16);
            if (virtualChild == null) {
                paddingLeft += this.measureNullChild(n16);
                n18 = layoutDirection;
                array = mMaxDescent;
                array2 = mMaxAscent;
                n19 = paddingTop;
                n20 = n5;
                n21 = virtualChildCount;
            }
            else {
                final int n22 = i;
                final int visibility = virtualChild.getVisibility();
                n18 = layoutDirection;
                if (visibility != 8) {
                    final int measuredWidth = virtualChild.getMeasuredWidth();
                    final int measuredHeight = virtualChild.getMeasuredHeight();
                    final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                    final int n23 = -1;
                    final int n24 = -1;
                    int baseline = 0;
                    Label_0435: {
                        if (mBaselineAligned) {
                            n20 = n5;
                            if (linearLayoutCompat$LayoutParams.height != n24) {
                                baseline = virtualChild.getBaseline();
                                break Label_0435;
                            }
                        }
                        else {
                            n20 = n5;
                        }
                        baseline = n23;
                    }
                    final int gravity = linearLayoutCompat$LayoutParams.gravity;
                    int n25;
                    if (gravity < 0) {
                        n25 = n9;
                    }
                    else {
                        n25 = gravity;
                    }
                    final int n26 = n25 & 0x70;
                    n21 = virtualChildCount;
                    int n27;
                    if (n26 != 16) {
                        if (n26 != 48) {
                            if (n26 != 80) {
                                n27 = paddingTop;
                            }
                            else {
                                final int n28 = n6 - measuredHeight - linearLayoutCompat$LayoutParams.bottomMargin;
                                if (baseline != -1) {
                                    n27 = n28 - (mMaxDescent[n10] - (virtualChild.getMeasuredHeight() - baseline));
                                }
                                else {
                                    n27 = n28;
                                }
                            }
                        }
                        else {
                            final int n29 = linearLayoutCompat$LayoutParams.topMargin + paddingTop;
                            if (baseline != -1) {
                                n27 = n29 + (mMaxAscent[1] - baseline);
                            }
                            else {
                                n27 = n29;
                            }
                        }
                    }
                    else {
                        n27 = (n7 - measuredHeight) / 2 + paddingTop + linearLayoutCompat$LayoutParams.topMargin - linearLayoutCompat$LayoutParams.bottomMargin;
                    }
                    if (this.hasDividerBeforeChildAt(n16)) {
                        paddingLeft += this.mDividerWidth;
                    }
                    final int n30 = paddingLeft + linearLayoutCompat$LayoutParams.leftMargin;
                    final int n31 = n30 + this.getLocationOffset(virtualChild);
                    n19 = paddingTop;
                    final int n32 = n16;
                    final int n33 = n22;
                    array = mMaxDescent;
                    array2 = mMaxAscent;
                    this.setChildFrame(virtualChild, n31, n27, measuredWidth, measuredHeight);
                    final int n34 = n30 + (measuredWidth + linearLayoutCompat$LayoutParams.rightMargin + this.getNextLocationOffset(virtualChild));
                    i = n33 + this.getChildrenSkipCount(virtualChild, n32);
                    paddingLeft = n34;
                }
                else {
                    array = mMaxDescent;
                    array2 = mMaxAscent;
                    n19 = paddingTop;
                    n20 = n5;
                    n21 = virtualChildCount;
                    i = n22;
                }
            }
        }
    }
    
    void layoutVertical(final int n, final int n2, final int n3, final int n4) {
        int paddingLeft = this.getPaddingLeft();
        final int n5 = n3 - n;
        final int n6 = n5 - this.getPaddingRight();
        final int n7 = n5 - paddingLeft - this.getPaddingRight();
        final int virtualChildCount = this.getVirtualChildCount();
        final int mGravity = this.mGravity;
        final int n8 = mGravity & 0x70;
        final int n9 = mGravity & 0x800007;
        int paddingTop;
        if (n8 != 16) {
            if (n8 != 80) {
                paddingTop = this.getPaddingTop();
            }
            else {
                paddingTop = this.getPaddingTop() + n4 - n2 - this.mTotalLength;
            }
        }
        else {
            paddingTop = this.getPaddingTop() + (n4 - n2 - this.mTotalLength) / 2;
        }
        int n10;
        for (int i = 0; i < virtualChildCount; ++i, paddingLeft = n10) {
            final View virtualChild = this.getVirtualChildAt(i);
            final boolean b = true;
            if (virtualChild == null) {
                paddingTop += this.measureNullChild(i);
                n10 = paddingLeft;
            }
            else if (virtualChild.getVisibility() != 8) {
                final int measuredWidth = virtualChild.getMeasuredWidth();
                final int measuredHeight = virtualChild.getMeasuredHeight();
                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                final int gravity = linearLayoutCompat$LayoutParams.gravity;
                int n11;
                if (gravity < 0) {
                    n11 = n9;
                }
                else {
                    n11 = gravity;
                }
                final int n12 = GravityCompat.getAbsoluteGravity(n11, ViewCompat.getLayoutDirection((View)this)) & 0x7;
                int n13;
                if (n12 != (b ? 1 : 0)) {
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
                if (this.hasDividerBeforeChildAt(i)) {
                    paddingTop += this.mDividerHeight;
                }
                final int n14 = paddingTop + linearLayoutCompat$LayoutParams.topMargin;
                final int n15 = n14 + this.getLocationOffset(virtualChild);
                n10 = paddingLeft;
                this.setChildFrame(virtualChild, n13, n15, measuredWidth, measuredHeight);
                final int n16 = n14 + (measuredHeight + linearLayoutCompat$LayoutParams.bottomMargin + this.getNextLocationOffset(virtualChild));
                i += this.getChildrenSkipCount(virtualChild, i);
                paddingTop = n16;
            }
            else {
                n10 = paddingLeft;
            }
        }
    }
    
    void measureChildBeforeLayout(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }
    
    void measureHorizontal(final int n, final int n2) {
        this.mTotalLength = 0;
        final boolean b = true;
        int virtualChildCount = this.getVirtualChildCount();
        int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            final int n3 = 4;
            this.mMaxAscent = new int[n3];
            this.mMaxDescent = new int[n3];
        }
        final int[] mMaxAscent = this.mMaxAscent;
        final int[] mMaxDescent = this.mMaxDescent;
        final int n4 = 3;
        final int n5 = -1;
        mMaxAscent[n4] = n5;
        final int n6 = 2;
        mMaxAscent[n6] = n5;
        final int n7 = 1;
        mMaxAscent[0] = (mMaxAscent[n7] = n5);
        mMaxDescent[n6] = (mMaxDescent[n4] = n5);
        mMaxDescent[0] = (mMaxDescent[n7] = n5);
        int mBaselineAligned = this.mBaselineAligned ? 1 : 0;
        boolean b2 = false;
        int mUseLargestChild = this.mUseLargestChild ? 1 : 0;
        final boolean b3 = mode == 1073741824;
        int n8 = 0;
        int n9 = -1 << -1;
        boolean b4 = false;
        int n10 = b ? 1 : 0;
        int n11 = 0;
        float n12 = 0.0f;
        int i = 0;
        int n13 = 0;
        int n14 = 0;
        while (i < virtualChildCount) {
            final View virtualChild = this.getVirtualChildAt(i);
            int n16;
            int n17;
            int n18;
            if (virtualChild == null) {
                final int n15 = n9;
                this.mTotalLength += this.measureNullChild(i);
                n16 = mBaselineAligned;
                n17 = n8;
                n9 = n15;
                n18 = mode;
            }
            else {
                final int n19 = n9;
                final int visibility = virtualChild.getVisibility();
                final int n20 = n14;
                if (visibility == 8) {
                    i += this.getChildrenSkipCount(virtualChild, i);
                    n16 = mBaselineAligned;
                    n17 = n8;
                    n9 = n19;
                    n14 = n20;
                    n18 = mode;
                }
                else {
                    if (this.hasDividerBeforeChildAt(i)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                    final float n21 = n12 + linearLayoutCompat$LayoutParams.weight;
                    LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams2;
                    int n23;
                    int n24;
                    int max;
                    int n25;
                    int n26;
                    int n27;
                    if (mode == 1073741824 && linearLayoutCompat$LayoutParams.width == 0 && linearLayoutCompat$LayoutParams.weight > 0.0f) {
                        int n22;
                        if (b3) {
                            final int mTotalLength = this.mTotalLength;
                            final int leftMargin = linearLayoutCompat$LayoutParams.leftMargin;
                            n22 = n13;
                            this.mTotalLength = mTotalLength + (leftMargin + linearLayoutCompat$LayoutParams.rightMargin);
                        }
                        else {
                            n22 = n13;
                            final int mTotalLength2 = this.mTotalLength;
                            this.mTotalLength = Math.max(mTotalLength2, linearLayoutCompat$LayoutParams.leftMargin + mTotalLength2 + linearLayoutCompat$LayoutParams.rightMargin);
                        }
                        if (mBaselineAligned != 0) {
                            final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChild.measure(measureSpec, measureSpec);
                            linearLayoutCompat$LayoutParams2 = linearLayoutCompat$LayoutParams;
                            n23 = n11;
                            n24 = i;
                            n16 = mBaselineAligned;
                            max = n19;
                            n25 = n20;
                            n26 = n22;
                            n18 = mode;
                            n27 = -1;
                        }
                        else {
                            b2 = true;
                            linearLayoutCompat$LayoutParams2 = linearLayoutCompat$LayoutParams;
                            n23 = n11;
                            n24 = i;
                            n16 = mBaselineAligned;
                            max = n19;
                            n25 = n20;
                            n26 = n22;
                            n18 = mode;
                            n27 = -1;
                        }
                    }
                    else {
                        final int n28 = n13;
                        final int n29 = -1 << -1;
                        int n30;
                        if (linearLayoutCompat$LayoutParams.width == 0 && linearLayoutCompat$LayoutParams.weight > 0.0f) {
                            linearLayoutCompat$LayoutParams.width = -2;
                            n30 = 0;
                        }
                        else {
                            n30 = n29;
                        }
                        int mTotalLength3;
                        if (n21 == 0.0f) {
                            mTotalLength3 = this.mTotalLength;
                        }
                        else {
                            mTotalLength3 = 0;
                        }
                        final int n31 = n19;
                        n25 = n20;
                        final int n32 = i;
                        final int width = n30;
                        n26 = n28;
                        n23 = n11;
                        n24 = i;
                        n16 = mBaselineAligned;
                        n18 = mode;
                        n27 = -1;
                        this.measureChildBeforeLayout(virtualChild, n32, n, mTotalLength3, n2, 0);
                        if (width != -1 << -1) {
                            linearLayoutCompat$LayoutParams2 = linearLayoutCompat$LayoutParams;
                            linearLayoutCompat$LayoutParams.width = width;
                        }
                        else {
                            linearLayoutCompat$LayoutParams2 = linearLayoutCompat$LayoutParams;
                        }
                        final int measuredWidth = virtualChild.getMeasuredWidth();
                        if (b3) {
                            this.mTotalLength += linearLayoutCompat$LayoutParams2.leftMargin + measuredWidth + linearLayoutCompat$LayoutParams2.rightMargin + this.getNextLocationOffset(virtualChild);
                        }
                        else {
                            final int mTotalLength4 = this.mTotalLength;
                            this.mTotalLength = Math.max(mTotalLength4, mTotalLength4 + measuredWidth + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin + this.getNextLocationOffset(virtualChild));
                        }
                        if (mUseLargestChild != 0) {
                            max = Math.max(measuredWidth, n31);
                        }
                        else {
                            max = n31;
                        }
                    }
                    boolean b5 = false;
                    if (mode2 != 1073741824 && linearLayoutCompat$LayoutParams2.height == n27) {
                        b4 = true;
                        b5 = true;
                    }
                    final int n33 = linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin;
                    final int n34 = virtualChild.getMeasuredHeight() + n33;
                    final int combineMeasuredStates = ViewUtils.combineMeasuredStates(n8, ViewCompat.getMeasuredState(virtualChild));
                    int n37;
                    int n39;
                    if (n16 != 0) {
                        final int baseline = virtualChild.getBaseline();
                        if (baseline != n27) {
                            int n35;
                            if (linearLayoutCompat$LayoutParams2.gravity < 0) {
                                n35 = this.mGravity;
                            }
                            else {
                                n35 = linearLayoutCompat$LayoutParams2.gravity;
                            }
                            final int n36 = ((n35 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                            n37 = n33;
                            mMaxAscent[n36] = Math.max(mMaxAscent[n36], baseline);
                            final int n38 = mMaxDescent[n36];
                            n39 = max;
                            mMaxDescent[n36] = Math.max(n38, n34 - baseline);
                        }
                        else {
                            n37 = n33;
                            n39 = max;
                        }
                    }
                    else {
                        n37 = n33;
                        n39 = max;
                    }
                    final int max2 = Math.max(n23, n34);
                    final boolean b6 = n10 != 0 && linearLayoutCompat$LayoutParams2.height == -1;
                    int max3;
                    int max4;
                    if (linearLayoutCompat$LayoutParams2.weight > 0.0f) {
                        int n40;
                        if (b5) {
                            n40 = n37;
                        }
                        else {
                            n40 = n34;
                        }
                        max3 = Math.max(n25, n40);
                        max4 = n26;
                    }
                    else {
                        final int n41 = n25;
                        int n42;
                        if (b5) {
                            n42 = n37;
                        }
                        else {
                            n42 = n34;
                        }
                        max4 = Math.max(n26, n42);
                        max3 = n41;
                    }
                    final int n43 = n24 + this.getChildrenSkipCount(virtualChild, n24);
                    n11 = max2;
                    n10 = (b6 ? 1 : 0);
                    n14 = max3;
                    n12 = n21;
                    n13 = max4;
                    n17 = combineMeasuredStates;
                    i = n43;
                    n9 = n39;
                }
            }
            ++i;
            n8 = n17;
            mBaselineAligned = n16;
            mode = n18;
        }
        final int n44 = mBaselineAligned;
        final int n45 = mode;
        final int n46 = n8;
        int n47 = n14;
        int max5 = n11;
        final int n48 = n13;
        int n49 = n9;
        final int n50 = n48;
        if (this.mTotalLength > 0 && this.hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        final int n51 = mMaxAscent[n7];
        final int n52 = -1;
        int n53;
        if (n51 == n52 && mMaxAscent[0] == n52 && mMaxAscent[n6] == n52 && mMaxAscent[n4] == n52) {
            n53 = n46;
        }
        else {
            final int max6 = Math.max(mMaxAscent[n4], Math.max(mMaxAscent[0], Math.max(mMaxAscent[n7], mMaxAscent[n6])));
            final int n54 = mMaxDescent[n4];
            final int n55 = mMaxDescent[0];
            final int n56 = mMaxDescent[n7];
            n53 = n46;
            max5 = Math.max(max5, max6 + Math.max(n54, Math.max(n55, Math.max(n56, mMaxDescent[n6]))));
        }
        int n57;
        int n58;
        if (mUseLargestChild != 0) {
            n57 = n45;
            if (n45 != -1 << -1 && n45 != 0) {
                n58 = max5;
            }
            else {
                this.mTotalLength = 0;
                int n59;
                int n60;
                for (int j = 0; j < virtualChildCount; j = n60 + 1, max5 = n59) {
                    final View virtualChild2 = this.getVirtualChildAt(j);
                    if (virtualChild2 == null) {
                        this.mTotalLength += this.measureNullChild(j);
                        n59 = max5;
                        n60 = j;
                    }
                    else if (virtualChild2.getVisibility() == 8) {
                        final int n61 = j + this.getChildrenSkipCount(virtualChild2, j);
                        n59 = max5;
                        n60 = n61;
                    }
                    else {
                        final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams3 = (LinearLayoutCompat$LayoutParams)virtualChild2.getLayoutParams();
                        if (b3) {
                            final int mTotalLength5 = this.mTotalLength;
                            n59 = max5;
                            final int n62 = linearLayoutCompat$LayoutParams3.leftMargin + n49;
                            n60 = j;
                            this.mTotalLength = mTotalLength5 + (n62 + linearLayoutCompat$LayoutParams3.rightMargin + this.getNextLocationOffset(virtualChild2));
                        }
                        else {
                            n59 = max5;
                            n60 = j;
                            final int mTotalLength6 = this.mTotalLength;
                            this.mTotalLength = Math.max(mTotalLength6, mTotalLength6 + n49 + linearLayoutCompat$LayoutParams3.leftMargin + linearLayoutCompat$LayoutParams3.rightMargin + this.getNextLocationOffset(virtualChild2));
                        }
                    }
                }
                n58 = max5;
            }
        }
        else {
            n58 = max5;
            n57 = n45;
        }
        this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, this.getSuggestedMinimumWidth()), n, 0);
        int n63 = resolveSizeAndState & 0xFFFFFF;
        int n64 = n63 - this.mTotalLength;
        int n70 = 0;
        int n71 = 0;
        int n72 = 0;
        int combineMeasuredStates2 = 0;
        int n73 = 0;
        int n74 = 0;
        Label_4149: {
            float n75;
            int n76;
            if (!b2) {
                if (n64 == 0 || n12 <= 0.0f) {
                    int max7 = Math.max(n50, n47);
                    if (mUseLargestChild != 0 && n57 != 1073741824) {
                        float n65;
                        int n66;
                        int n67;
                        int n68;
                        for (int k = 0; k < virtualChildCount; ++k, max7 = n66, n12 = n65, n63 = n67, n49 = n68) {
                            n65 = n12;
                            final View virtualChild3 = this.getVirtualChildAt(k);
                            if (virtualChild3 != null) {
                                n66 = max7;
                                final int visibility2 = virtualChild3.getVisibility();
                                n67 = n63;
                                if (visibility2 == 8) {
                                    n68 = n49;
                                }
                                else if (((LinearLayoutCompat$LayoutParams)virtualChild3.getLayoutParams()).weight > 0.0f) {
                                    final int n69 = 1073741824;
                                    final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(n49, n69);
                                    n68 = n49;
                                    virtualChild3.measure(measureSpec2, View$MeasureSpec.makeMeasureSpec(virtualChild3.getMeasuredHeight(), n69));
                                }
                                else {
                                    n68 = n49;
                                }
                            }
                            else {
                                n66 = max7;
                                n67 = n63;
                                n68 = n49;
                            }
                        }
                        n70 = max7;
                    }
                    else {
                        n70 = max7;
                    }
                    n71 = resolveSizeAndState;
                    n72 = n58;
                    combineMeasuredStates2 = n53;
                    n73 = n2;
                    n74 = virtualChildCount;
                    break Label_4149;
                }
                n75 = n12;
                n76 = n50;
            }
            else {
                n75 = n12;
                n76 = n50;
            }
            float mWeightSum = this.mWeightSum;
            if (mWeightSum <= 0.0f) {
                mWeightSum = n75;
            }
            final int n77 = -1;
            mMaxAscent[n6] = (mMaxAscent[n4] = n77);
            mMaxAscent[0] = (mMaxAscent[n7] = n77);
            mMaxDescent[n6] = (mMaxDescent[n4] = n77);
            mMaxDescent[0] = (mMaxDescent[n7] = n77);
            n72 = -1;
            this.mTotalLength = 0;
            int l = 0;
            int n78 = n76;
            combineMeasuredStates2 = n53;
            while (l < virtualChildCount) {
                final int n79 = n47;
                final View virtualChild4 = this.getVirtualChildAt(l);
                int n80;
                int n81;
                int n82;
                int n83;
                int n84;
                if (virtualChild4 != null) {
                    n80 = mUseLargestChild;
                    if (virtualChild4.getVisibility() == 8) {
                        n81 = n57;
                        n82 = n64;
                        n83 = resolveSizeAndState;
                        n84 = virtualChildCount;
                    }
                    else {
                        final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams4 = (LinearLayoutCompat$LayoutParams)virtualChild4.getLayoutParams();
                        final float weight = linearLayoutCompat$LayoutParams4.weight;
                        if (weight > 0.0f) {
                            n84 = virtualChildCount;
                            final int n85 = (int)(n64 * weight / mWeightSum);
                            final float n86 = mWeightSum - weight;
                            final int n87 = n64 - n85;
                            final int n88 = this.getPaddingTop() + this.getPaddingBottom();
                            final float n89 = n86;
                            final int n90 = n88 + linearLayoutCompat$LayoutParams4.topMargin + linearLayoutCompat$LayoutParams4.bottomMargin;
                            final int height = linearLayoutCompat$LayoutParams4.height;
                            final int n91 = n87;
                            n83 = resolveSizeAndState;
                            final int n92 = 1073741824;
                            final int childMeasureSpec = getChildMeasureSpec(n2, n90, height);
                            if (linearLayoutCompat$LayoutParams4.width == 0 && n57 == n92) {
                                int n93;
                                if (n85 > 0) {
                                    n93 = n85;
                                }
                                else {
                                    n93 = 0;
                                }
                                virtualChild4.measure(View$MeasureSpec.makeMeasureSpec(n93, n92), childMeasureSpec);
                                n81 = n57;
                            }
                            else {
                                int n94 = virtualChild4.getMeasuredWidth() + n85;
                                if (n94 < 0) {
                                    n94 = 0;
                                }
                                n81 = n57;
                                virtualChild4.measure(View$MeasureSpec.makeMeasureSpec(n94, n92), childMeasureSpec);
                            }
                            combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates2, ViewCompat.getMeasuredState(virtualChild4) & 0xFF000000);
                            mWeightSum = n89;
                            n82 = n91;
                        }
                        else {
                            n81 = n57;
                            n82 = n64;
                            n83 = resolveSizeAndState;
                            n84 = virtualChildCount;
                        }
                        if (b3) {
                            this.mTotalLength += virtualChild4.getMeasuredWidth() + linearLayoutCompat$LayoutParams4.leftMargin + linearLayoutCompat$LayoutParams4.rightMargin + this.getNextLocationOffset(virtualChild4);
                        }
                        else {
                            final int mTotalLength7 = this.mTotalLength;
                            this.mTotalLength = Math.max(mTotalLength7, virtualChild4.getMeasuredWidth() + mTotalLength7 + linearLayoutCompat$LayoutParams4.leftMargin + linearLayoutCompat$LayoutParams4.rightMargin + this.getNextLocationOffset(virtualChild4));
                        }
                        final boolean b7 = mode2 != 1073741824 && linearLayoutCompat$LayoutParams4.height == -1;
                        final int n95 = linearLayoutCompat$LayoutParams4.topMargin + linearLayoutCompat$LayoutParams4.bottomMargin;
                        final int n96 = virtualChild4.getMeasuredHeight() + n95;
                        n72 = Math.max(n72, n96);
                        float n97;
                        int n98;
                        if (b7) {
                            n97 = mWeightSum;
                            n98 = n95;
                        }
                        else {
                            n97 = mWeightSum;
                            n98 = n96;
                        }
                        final int max8 = Math.max(n78, n98);
                        int n99 = 0;
                        boolean b8 = false;
                        Label_3645: {
                            if (n10 != 0) {
                                final int height2 = linearLayoutCompat$LayoutParams4.height;
                                n99 = max8;
                                if (height2 == -1) {
                                    b8 = true;
                                    break Label_3645;
                                }
                            }
                            else {
                                n99 = max8;
                            }
                            b8 = false;
                        }
                        int n103;
                        if (n44 != 0) {
                            final int baseline2 = virtualChild4.getBaseline();
                            n10 = (b8 ? 1 : 0);
                            if (baseline2 != -1) {
                                int n100;
                                if (linearLayoutCompat$LayoutParams4.gravity < 0) {
                                    n100 = this.mGravity;
                                }
                                else {
                                    n100 = linearLayoutCompat$LayoutParams4.gravity;
                                }
                                final int n101 = ((n100 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                                mMaxAscent[n101] = Math.max(mMaxAscent[n101], baseline2);
                                final int n102 = mMaxDescent[n101];
                                n103 = combineMeasuredStates2;
                                mMaxDescent[n101] = Math.max(n102, n96 - baseline2);
                            }
                            else {
                                n103 = combineMeasuredStates2;
                            }
                        }
                        else {
                            n10 = (b8 ? 1 : 0);
                            n103 = combineMeasuredStates2;
                        }
                        mWeightSum = n97;
                        n78 = n99;
                        combineMeasuredStates2 = n103;
                    }
                }
                else {
                    n81 = n57;
                    n82 = n64;
                    n83 = resolveSizeAndState;
                    n84 = virtualChildCount;
                    n80 = mUseLargestChild;
                }
                ++l;
                n64 = n82;
                resolveSizeAndState = n83;
                mUseLargestChild = n80;
                virtualChildCount = n84;
                n47 = n79;
                n57 = n81;
            }
            n71 = resolveSizeAndState;
            n74 = virtualChildCount;
            n73 = n2;
            this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
            final int n104 = mMaxAscent[n7];
            final int n105 = -1;
            if (n104 != n105 || mMaxAscent[0] != n105 || mMaxAscent[n6] != n105 || mMaxAscent[n4] != n105) {
                n72 = Math.max(n72, Math.max(mMaxAscent[n4], Math.max(mMaxAscent[0], Math.max(mMaxAscent[n7], mMaxAscent[n6]))) + Math.max(mMaxDescent[n4], Math.max(mMaxDescent[0], Math.max(mMaxDescent[n7], mMaxDescent[n6]))));
            }
            n70 = n78;
        }
        if (n10 == 0 && mode2 != 1073741824) {
            n72 = n70;
        }
        this.setMeasuredDimension(n71 | (0xFF000000 & combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(n72 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n73, combineMeasuredStates2 << 16));
        if (b4) {
            this.forceUniformHeight(n74, n);
        }
    }
    
    int measureNullChild(final int n) {
        return 0;
    }
    
    void measureVertical(final int n, final int n2) {
        this.mTotalLength = 0;
        int n3 = 0;
        float n4 = 0.0f;
        int virtualChildCount = this.getVirtualChildCount();
        final int mode = View$MeasureSpec.getMode(n);
        int mode2 = View$MeasureSpec.getMode(n2);
        int mBaselineAlignedChildIndex = this.mBaselineAlignedChildIndex;
        int mUseLargestChild = this.mUseLargestChild ? 1 : 0;
        boolean b = false;
        int n5 = 0;
        int n6 = 0;
        final boolean b2 = true;
        int n7 = 0;
        int n8 = -1 << -1;
        boolean b3 = false;
        int n9 = 0;
        int n10 = b2 ? 1 : 0;
        while (true) {
            final int n11 = n7;
            int n12 = 8;
            if (n9 >= virtualChildCount) {
                int combineMeasuredStates = n3;
                final int n13 = mode2;
                final int n14 = -1 << -1;
                int n15 = n8;
                final int n16 = n5;
                int n17 = n6;
                final int n18 = n16;
                final int n19 = virtualChildCount;
                int n20 = n7;
                int n21;
                if (this.mTotalLength > 0) {
                    n21 = n19;
                    if (this.hasDividerBeforeChildAt(n19)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                }
                else {
                    n21 = n19;
                }
                int n22;
                if (mUseLargestChild != 0) {
                    n22 = n13;
                    if (n13 == n14 || n13 == 0) {
                        this.mTotalLength = 0;
                        int n24;
                        for (int i = 0; i < n21; i = n24 + 1, n12 = 8) {
                            final View virtualChild = this.getVirtualChildAt(i);
                            int n23;
                            if (virtualChild == null) {
                                this.mTotalLength += this.measureNullChild(i);
                                n23 = i;
                            }
                            else {
                                if (virtualChild.getVisibility() == n12) {
                                    n24 = i + this.getChildrenSkipCount(virtualChild, i);
                                    continue;
                                }
                                final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)virtualChild.getLayoutParams();
                                final int mTotalLength = this.mTotalLength;
                                final int n25 = mTotalLength + n15;
                                n23 = i;
                                this.mTotalLength = Math.max(mTotalLength, n25 + linearLayoutCompat$LayoutParams.topMargin + linearLayoutCompat$LayoutParams.bottomMargin + this.getNextLocationOffset(virtualChild));
                            }
                            n24 = n23;
                        }
                    }
                }
                else {
                    n22 = n13;
                }
                this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
                final int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, this.getSuggestedMinimumHeight()), n2, 0);
                int n26 = (resolveSizeAndState & 0xFFFFFF) - this.mTotalLength;
                int n32 = 0;
                int n33 = 0;
                int n34 = 0;
                Label_2760: {
                    int n35;
                    float n36;
                    int n37;
                    if (!b3) {
                        if (n26 == 0 || n4 <= 0.0f) {
                            int max = Math.max(n18, n20);
                            if (mUseLargestChild != 0) {
                                if (n22 != 1073741824) {
                                    int n27;
                                    int n28;
                                    float n29;
                                    int n30;
                                    for (int j = 0; j < n21; ++j, max = n27, n26 = n28, n4 = n29, n17 = n30) {
                                        n27 = max;
                                        final View virtualChild2 = this.getVirtualChildAt(j);
                                        if (virtualChild2 != null) {
                                            n28 = n26;
                                            final int visibility = virtualChild2.getVisibility();
                                            n29 = n4;
                                            if (visibility == 8) {
                                                n30 = n17;
                                            }
                                            else if (((LinearLayoutCompat$LayoutParams)virtualChild2.getLayoutParams()).weight > 0.0f) {
                                                final int measuredWidth = virtualChild2.getMeasuredWidth();
                                                final int n31 = 1073741824;
                                                final int measureSpec = View$MeasureSpec.makeMeasureSpec(measuredWidth, n31);
                                                n30 = n17;
                                                virtualChild2.measure(measureSpec, View$MeasureSpec.makeMeasureSpec(n15, n31));
                                            }
                                            else {
                                                n30 = n17;
                                            }
                                        }
                                        else {
                                            n28 = n26;
                                            n29 = n4;
                                            n30 = n17;
                                        }
                                    }
                                    n32 = max;
                                    n33 = n17;
                                }
                                else {
                                    n32 = max;
                                    n33 = n17;
                                }
                            }
                            else {
                                n32 = max;
                                n33 = n17;
                            }
                            n34 = n;
                            break Label_2760;
                        }
                        n35 = n26;
                        n36 = n4;
                        n37 = n17;
                    }
                    else {
                        n35 = n26;
                        n36 = n4;
                        n37 = n17;
                    }
                    float mWeightSum = this.mWeightSum;
                    if (mWeightSum <= 0.0f) {
                        mWeightSum = n36;
                    }
                    float n38 = mWeightSum;
                    this.mTotalLength = 0;
                    int k = 0;
                    int max2 = n18;
                    int n39 = n35;
                    int n40 = n37;
                    while (k < n21) {
                        final int n41 = mUseLargestChild;
                        final View virtualChild3 = this.getVirtualChildAt(k);
                        final int n42 = n20;
                        final int visibility2 = virtualChild3.getVisibility();
                        final int n43 = n15;
                        int n44;
                        int n45;
                        if (visibility2 == 8) {
                            n44 = n22;
                            n45 = mBaselineAlignedChildIndex;
                        }
                        else {
                            final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams2 = (LinearLayoutCompat$LayoutParams)virtualChild3.getLayoutParams();
                            final float weight = linearLayoutCompat$LayoutParams2.weight;
                            float n50;
                            int n52;
                            if (weight > 0.0f) {
                                n45 = mBaselineAlignedChildIndex;
                                final int n46 = (int)(n39 * weight / n38);
                                final float n47 = n38 - weight;
                                final int n48 = n39 - n46;
                                final int n49 = this.getPaddingLeft() + this.getPaddingRight();
                                n50 = n47;
                                final int n51 = n49 + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin;
                                n52 = n48;
                                final int childMeasureSpec = getChildMeasureSpec(n, n51, linearLayoutCompat$LayoutParams2.width);
                                Label_2361: {
                                    if (linearLayoutCompat$LayoutParams2.height == 0) {
                                        if (n22 == 1073741824) {
                                            int n53;
                                            if (n46 > 0) {
                                                n53 = n46;
                                            }
                                            else {
                                                n53 = 0;
                                            }
                                            n44 = n22;
                                            virtualChild3.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n53, 1073741824));
                                            break Label_2361;
                                        }
                                        n44 = n22;
                                    }
                                    else {
                                        n44 = n22;
                                    }
                                    int n54 = virtualChild3.getMeasuredHeight() + n46;
                                    if (n54 < 0) {
                                        n54 = 0;
                                    }
                                    virtualChild3.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n54, 1073741824));
                                }
                                combineMeasuredStates = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(virtualChild3) & 0xFFFFFF00);
                            }
                            else {
                                n44 = n22;
                                n45 = mBaselineAlignedChildIndex;
                                n50 = n38;
                                n52 = n39;
                            }
                            final int n55 = linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin;
                            final int n56 = virtualChild3.getMeasuredWidth() + n55;
                            final int max3 = Math.max(n40, n56);
                            int n57;
                            if (mode != 1073741824 && linearLayoutCompat$LayoutParams2.width == -1) {
                                n57 = n55;
                            }
                            else {
                                n57 = n56;
                            }
                            max2 = Math.max(max2, n57);
                            int n58 = 0;
                            Label_2564: {
                                if (n10 != 0) {
                                    if (linearLayoutCompat$LayoutParams2.width == -1) {
                                        n58 = 1;
                                        break Label_2564;
                                    }
                                }
                                n58 = 0;
                            }
                            final int mTotalLength2 = this.mTotalLength;
                            final int n59 = mTotalLength2 + virtualChild3.getMeasuredHeight();
                            final int n60 = max3;
                            this.mTotalLength = Math.max(mTotalLength2, n59 + linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin + this.getNextLocationOffset(virtualChild3));
                            n10 = n58;
                            n39 = n52;
                            n38 = n50;
                            n40 = n60;
                        }
                        ++k;
                        mUseLargestChild = n41;
                        n20 = n42;
                        n15 = n43;
                        mBaselineAlignedChildIndex = n45;
                        n22 = n44;
                    }
                    n34 = n;
                    this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
                    n33 = n40;
                    n32 = max2;
                }
                if (n10 == 0 && mode != 1073741824) {
                    n33 = n32;
                }
                this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(n33 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n34, combineMeasuredStates), resolveSizeAndState);
                if (b) {
                    this.forceUniformWidth(n21, n2);
                }
                return;
            }
            final View virtualChild4 = this.getVirtualChildAt(n9);
            int n61;
            int n62;
            if (virtualChild4 == null) {
                this.mTotalLength += this.measureNullChild(n9);
                n61 = mode2;
                n62 = virtualChildCount;
            }
            else {
                final int n63 = n3;
                if (virtualChild4.getVisibility() == n12) {
                    n9 += this.getChildrenSkipCount(virtualChild4, n9);
                    n61 = mode2;
                    n3 = n63;
                    n62 = virtualChildCount;
                }
                else {
                    if (this.hasDividerBeforeChildAt(n9)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    final LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams3 = (LinearLayoutCompat$LayoutParams)virtualChild4.getLayoutParams();
                    final float n64 = n4 + linearLayoutCompat$LayoutParams3.weight;
                    LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams4;
                    int n67;
                    int n68;
                    int n69;
                    int n70;
                    int max4;
                    View view;
                    if (mode2 == 1073741824 && linearLayoutCompat$LayoutParams3.height == 0 && linearLayoutCompat$LayoutParams3.weight > 0.0f) {
                        final int mTotalLength3 = this.mTotalLength;
                        final int n65 = linearLayoutCompat$LayoutParams3.topMargin + mTotalLength3;
                        final int n66 = n6;
                        this.mTotalLength = Math.max(mTotalLength3, n65 + linearLayoutCompat$LayoutParams3.bottomMargin);
                        b3 = true;
                        linearLayoutCompat$LayoutParams4 = linearLayoutCompat$LayoutParams3;
                        n67 = n5;
                        n61 = mode2;
                        n68 = n11;
                        n69 = n63;
                        n70 = n66;
                        max4 = n8;
                        view = virtualChild4;
                        n62 = virtualChildCount;
                    }
                    else {
                        final int n71 = n6;
                        final int n72 = -1 << -1;
                        int n73;
                        if (linearLayoutCompat$LayoutParams3.height == 0 && linearLayoutCompat$LayoutParams3.weight > 0.0f) {
                            linearLayoutCompat$LayoutParams3.height = -2;
                            n73 = 0;
                        }
                        else {
                            n73 = n72;
                        }
                        int mTotalLength4;
                        if (n64 == 0.0f) {
                            mTotalLength4 = this.mTotalLength;
                        }
                        else {
                            mTotalLength4 = 0;
                        }
                        linearLayoutCompat$LayoutParams4 = linearLayoutCompat$LayoutParams3;
                        n69 = n63;
                        final View view2 = virtualChild4;
                        n70 = n71;
                        n61 = mode2;
                        max4 = n8;
                        final View view3 = virtualChild4;
                        n68 = n11;
                        n62 = virtualChildCount;
                        final int height = n73;
                        n67 = n5;
                        this.measureChildBeforeLayout(view2, n9, n, 0, n2, mTotalLength4);
                        if (height != -1 << -1) {
                            linearLayoutCompat$LayoutParams4.height = height;
                        }
                        final int measuredHeight = view3.getMeasuredHeight();
                        final int mTotalLength5 = this.mTotalLength;
                        final int n74 = mTotalLength5 + measuredHeight + linearLayoutCompat$LayoutParams4.topMargin + linearLayoutCompat$LayoutParams4.bottomMargin;
                        view = view3;
                        this.mTotalLength = Math.max(mTotalLength5, n74 + this.getNextLocationOffset(view3));
                        if (mUseLargestChild != 0) {
                            max4 = Math.max(measuredHeight, max4);
                        }
                    }
                    if (mBaselineAlignedChildIndex >= 0 && mBaselineAlignedChildIndex == n9 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (n9 < mBaselineAlignedChildIndex && linearLayoutCompat$LayoutParams4.weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    boolean b4 = false;
                    int n75;
                    if (mode != 1073741824) {
                        final int width = linearLayoutCompat$LayoutParams4.width;
                        n75 = -1;
                        if (width == n75) {
                            b = true;
                            b4 = true;
                        }
                    }
                    else {
                        n75 = -1;
                    }
                    final int n76 = linearLayoutCompat$LayoutParams4.leftMargin + linearLayoutCompat$LayoutParams4.rightMargin;
                    final int n77 = view.getMeasuredWidth() + n76;
                    final int max5 = Math.max(n70, n77);
                    final int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(n69, ViewCompat.getMeasuredState(view));
                    final boolean b5 = n10 != 0 && linearLayoutCompat$LayoutParams4.width == n75;
                    int max6;
                    int max7;
                    if (linearLayoutCompat$LayoutParams4.weight > 0.0f) {
                        int n78;
                        if (b4) {
                            n78 = n76;
                        }
                        else {
                            n78 = n77;
                        }
                        max6 = Math.max(n68, n78);
                        n10 = (b5 ? 1 : 0);
                        max7 = n67;
                    }
                    else {
                        final int n79 = n68;
                        int n80;
                        if (b4) {
                            n80 = n76;
                        }
                        else {
                            n80 = n77;
                        }
                        n10 = (b5 ? 1 : 0);
                        max7 = Math.max(n67, n80);
                        max6 = n79;
                    }
                    n9 += this.getChildrenSkipCount(view, n9);
                    n3 = combineMeasuredStates2;
                    n7 = max6;
                    n8 = max4;
                    n5 = max7;
                    n6 = max5;
                    n4 = n64;
                }
            }
            ++n9;
            virtualChildCount = n62;
            mode2 = n61;
        }
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            this.drawDividersVertical(canvas);
        }
        else {
            this.drawDividersHorizontal(canvas);
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)LinearLayoutCompat.class.getName());
        }
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)LinearLayoutCompat.class.getName());
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (this.mOrientation == 1) {
            this.layoutVertical(n, n2, n3, n4);
        }
        else {
            this.layoutHorizontal(n, n2, n3, n4);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.mOrientation == 1) {
            this.measureVertical(n, n2);
        }
        else {
            this.measureHorizontal(n, n2);
        }
    }
    
    public void setBaselineAligned(final boolean mBaselineAligned) {
        this.mBaselineAligned = mBaselineAligned;
    }
    
    public void setBaselineAlignedChildIndex(final int mBaselineAlignedChildIndex) {
        if (mBaselineAlignedChildIndex >= 0 && mBaselineAlignedChildIndex < this.getChildCount()) {
            this.mBaselineAlignedChildIndex = mBaselineAlignedChildIndex;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("base aligned child index out of range (0, ");
        sb.append(this.getChildCount());
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setDividerDrawable(final Drawable mDivider) {
        if (mDivider == this.mDivider) {
            return;
        }
        this.mDivider = mDivider;
        boolean willNotDraw = false;
        if (mDivider != null) {
            this.mDividerWidth = mDivider.getIntrinsicWidth();
            this.mDividerHeight = mDivider.getIntrinsicHeight();
        }
        else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (mDivider == null) {
            willNotDraw = true;
        }
        this.setWillNotDraw(willNotDraw);
        this.requestLayout();
    }
    
    public void setDividerPadding(final int mDividerPadding) {
        this.mDividerPadding = mDividerPadding;
    }
    
    public void setGravity(int mGravity) {
        if (this.mGravity != mGravity) {
            if ((0x800007 & mGravity) == 0x0) {
                mGravity |= 0x800003;
            }
            if ((mGravity & 0x70) == 0x0) {
                mGravity |= 0x30;
            }
            this.mGravity = mGravity;
            this.requestLayout();
        }
    }
    
    public void setHorizontalGravity(final int n) {
        final int n2 = 8388615;
        final int n3 = n & n2;
        final int mGravity = this.mGravity;
        if ((n2 & mGravity) != n3) {
            this.mGravity = ((0xFF7FFFF8 & mGravity) | n3);
            this.requestLayout();
        }
    }
    
    public void setMeasureWithLargestChildEnabled(final boolean mUseLargestChild) {
        this.mUseLargestChild = mUseLargestChild;
    }
    
    public void setOrientation(final int mOrientation) {
        if (this.mOrientation != mOrientation) {
            this.mOrientation = mOrientation;
            this.requestLayout();
        }
    }
    
    public void setShowDividers(final int mShowDividers) {
        if (mShowDividers != this.mShowDividers) {
            this.requestLayout();
        }
        this.mShowDividers = mShowDividers;
    }
    
    public void setVerticalGravity(final int n) {
        final int n2 = n & 0x70;
        final int mGravity = this.mGravity;
        if ((mGravity & 0x70) != n2) {
            this.mGravity = ((mGravity & 0xFFFFFF8F) | n2);
            this.requestLayout();
        }
    }
    
    public void setWeightSum(final float n) {
        this.mWeightSum = Math.max(0.0f, n);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
