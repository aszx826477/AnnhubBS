// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View$MeasureSpec;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View$OnClickListener;
import android.support.v7.view.ActionMode;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import android.support.v7.appcompat.R$id;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v7.appcompat.R$layout;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class ActionBarContextView extends AbsActionBarView
{
    private static final String TAG = "ActionBarContextView";
    private View mClose;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;
    
    public ActionBarContextView(final Context context) {
        this(context, null);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set) {
        this(context, set, R$attr.actionModeStyle);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.ActionMode, n, 0);
        ViewCompat.setBackground((View)this, obtainStyledAttributes.getDrawable(R$styleable.ActionMode_background));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
    
    private void initTitle() {
        if (this.mTitleLayout == null) {
            LayoutInflater.from(this.getContext()).inflate(R$layout.abc_action_bar_title_item, (ViewGroup)this);
            this.mTitleLayout = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
            this.mTitleView = (TextView)this.mTitleLayout.findViewById(R$id.action_bar_title);
            this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(R$id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        final boolean b = TextUtils.isEmpty(this.mTitle) ^ true;
        final boolean b2 = TextUtils.isEmpty(this.mSubtitle) ^ true;
        final TextView mSubtitleView = this.mSubtitleView;
        int visibility = 0;
        int visibility2;
        if (b2) {
            visibility2 = 0;
        }
        else {
            visibility2 = 8;
        }
        mSubtitleView.setVisibility(visibility2);
        final LinearLayout mTitleLayout = this.mTitleLayout;
        if (!b) {
            if (!b2) {
                visibility = 8;
            }
        }
        mTitleLayout.setVisibility(visibility);
        if (this.mTitleLayout.getParent() == null) {
            this.addView((View)this.mTitleLayout);
        }
    }
    
    public void closeMode() {
        if (this.mClose == null) {
            this.killMode();
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(-1, -2);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(this.getContext(), set);
    }
    
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    public boolean hideOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.hideOverflowMenu();
    }
    
    public void initForMode(final ActionMode actionMode) {
        final View mClose = this.mClose;
        if (mClose == null) {
            this.addView(this.mClose = LayoutInflater.from(this.getContext()).inflate(this.mCloseItemLayout, (ViewGroup)this, false));
        }
        else if (mClose.getParent() == null) {
            this.addView(this.mClose);
        }
        this.mClose.findViewById(R$id.action_mode_close_button).setOnClickListener((View$OnClickListener)new ActionBarContextView$1(this, actionMode));
        final MenuBuilder menuBuilder = (MenuBuilder)actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
        (this.mActionMenuPresenter = new ActionMenuPresenter(this.getContext())).setReserveOverflow(true);
        final ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ViewCompat.setBackground((View)(this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this)), null);
        this.addView((View)this.mMenuView, viewGroup$LayoutParams);
    }
    
    public boolean isOverflowMenuShowing() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    
    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }
    
    public void killMode() {
        this.removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (Build$VERSION.SDK_INT >= 14) {
            if (accessibilityEvent.getEventType() == 32) {
                accessibilityEvent.setSource((View)this);
                accessibilityEvent.setClassName((CharSequence)this.getClass().getName());
                accessibilityEvent.setPackageName((CharSequence)this.getContext().getPackageName());
                accessibilityEvent.setContentDescription(this.mTitle);
            }
            else {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
        int paddingLeft;
        if (layoutRtl) {
            paddingLeft = n3 - n - this.getPaddingRight();
        }
        else {
            paddingLeft = this.getPaddingLeft();
        }
        final int paddingTop = this.getPaddingTop();
        final int n5 = n4 - n2 - this.getPaddingTop() - this.getPaddingBottom();
        final View mClose = this.mClose;
        final int n6 = 8;
        int next2;
        if (mClose != null && mClose.getVisibility() != n6) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams();
            int n7;
            if (layoutRtl) {
                n7 = viewGroup$MarginLayoutParams.rightMargin;
            }
            else {
                n7 = viewGroup$MarginLayoutParams.leftMargin;
            }
            final int n8 = n7;
            int n9;
            if (layoutRtl) {
                n9 = viewGroup$MarginLayoutParams.leftMargin;
            }
            else {
                n9 = viewGroup$MarginLayoutParams.rightMargin;
            }
            final int next = AbsActionBarView.next(paddingLeft, n8, layoutRtl);
            next2 = AbsActionBarView.next(next + this.positionChild(this.mClose, next, paddingTop, n5, layoutRtl), n9, layoutRtl);
        }
        else {
            next2 = paddingLeft;
        }
        final LinearLayout mTitleLayout = this.mTitleLayout;
        if (mTitleLayout != null && this.mCustomView == null && mTitleLayout.getVisibility() != n6) {
            next2 += this.positionChild((View)this.mTitleLayout, next2, paddingTop, n5, layoutRtl);
        }
        final View mCustomView = this.mCustomView;
        if (mCustomView != null) {
            final int n10 = next2 + this.positionChild(mCustomView, next2, paddingTop, n5, layoutRtl);
        }
        int paddingLeft2;
        if (layoutRtl) {
            paddingLeft2 = this.getPaddingLeft();
        }
        else {
            paddingLeft2 = n3 - n - this.getPaddingRight();
        }
        final int n11 = paddingLeft2;
        if (this.mMenuView != null) {
            final int n12 = n11 + this.positionChild((View)this.mMenuView, paddingLeft2, paddingTop, n5, layoutRtl ^ true);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        int n3 = 1073741824;
        if (mode != n3) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getSimpleName());
            sb.append(" can only be used ");
            sb.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        }
        if (View$MeasureSpec.getMode(n2) != 0) {
            final int size = View$MeasureSpec.getSize(n);
            int n4;
            if (this.mContentHeight > 0) {
                n4 = this.mContentHeight;
            }
            else {
                n4 = View$MeasureSpec.getSize(n2);
            }
            final int n5 = this.getPaddingTop() + this.getPaddingBottom();
            int n6 = size - this.getPaddingLeft() - this.getPaddingRight();
            final int n7 = n4 - n5;
            final int measureSpec = View$MeasureSpec.makeMeasureSpec(n7, -1 << -1);
            final View mClose = this.mClose;
            int visibility = 0;
            if (mClose != null) {
                final int measureChildView = this.measureChildView(mClose, n6, measureSpec, 0);
                final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams();
                n6 = measureChildView - (viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin);
            }
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                n6 = this.measureChildView((View)this.mMenuView, n6, measureSpec, 0);
            }
            final LinearLayout mTitleLayout = this.mTitleLayout;
            if (mTitleLayout != null && this.mCustomView == null) {
                if (this.mTitleOptional) {
                    this.mTitleLayout.measure(View$MeasureSpec.makeMeasureSpec(0, 0), measureSpec);
                    final int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                    final boolean b = measuredWidth <= n6;
                    if (b) {
                        n6 -= measuredWidth;
                    }
                    final LinearLayout mTitleLayout2 = this.mTitleLayout;
                    if (!b) {
                        visibility = 8;
                    }
                    mTitleLayout2.setVisibility(visibility);
                }
                else {
                    n6 = this.measureChildView((View)mTitleLayout, n6, measureSpec, 0);
                }
            }
            final View mCustomView = this.mCustomView;
            if (mCustomView != null) {
                final ViewGroup$LayoutParams layoutParams = mCustomView.getLayoutParams();
                final int width = layoutParams.width;
                final int n8 = -2;
                int n9;
                if (width != n8) {
                    n9 = 1073741824;
                }
                else {
                    n9 = -1 << -1;
                }
                int min;
                if (layoutParams.width >= 0) {
                    min = Math.min(layoutParams.width, n6);
                }
                else {
                    min = n6;
                }
                if (layoutParams.height == n8) {
                    n3 = -1 << -1;
                }
                int min2;
                if (layoutParams.height >= 0) {
                    min2 = Math.min(layoutParams.height, n7);
                }
                else {
                    min2 = n7;
                }
                this.mCustomView.measure(View$MeasureSpec.makeMeasureSpec(min, n9), View$MeasureSpec.makeMeasureSpec(min2, n3));
            }
            if (this.mContentHeight <= 0) {
                int n10 = 0;
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final int n11 = this.getChildAt(i).getMeasuredHeight() + n5;
                    if (n11 > n10) {
                        n10 = n11;
                    }
                }
                this.setMeasuredDimension(size, n10);
            }
            else {
                this.setMeasuredDimension(size, n4);
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(this.getClass().getSimpleName());
        sb2.append(" can only be used ");
        sb2.append("with android:layout_height=\"wrap_content\"");
        throw new IllegalStateException(sb2.toString());
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
    }
    
    public void setCustomView(final View mCustomView) {
        final View mCustomView2 = this.mCustomView;
        if (mCustomView2 != null) {
            this.removeView(mCustomView2);
        }
        if ((this.mCustomView = mCustomView) != null) {
            final LinearLayout mTitleLayout = this.mTitleLayout;
            if (mTitleLayout != null) {
                this.removeView((View)mTitleLayout);
                this.mTitleLayout = null;
            }
        }
        if (mCustomView != null) {
            this.addView(mCustomView);
        }
        this.requestLayout();
    }
    
    public void setSubtitle(final CharSequence mSubtitle) {
        this.mSubtitle = mSubtitle;
        this.initTitle();
    }
    
    public void setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        this.initTitle();
    }
    
    public void setTitleOptional(final boolean mTitleOptional) {
        if (mTitleOptional != this.mTitleOptional) {
            this.requestLayout();
        }
        this.mTitleOptional = mTitleOptional;
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    public boolean showOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.showOverflowMenu();
    }
}
