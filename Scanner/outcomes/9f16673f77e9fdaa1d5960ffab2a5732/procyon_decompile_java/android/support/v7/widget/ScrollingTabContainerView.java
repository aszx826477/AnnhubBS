// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View$MeasureSpec;
import android.widget.AdapterView;
import android.content.res.Configuration;
import android.view.View$OnClickListener;
import android.widget.AbsListView$LayoutParams;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar$Tab;
import android.widget.SpinnerAdapter;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.support.v7.view.ActionBarPolicy;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.widget.Spinner;
import android.view.animation.Interpolator;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.HorizontalScrollView;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView$OnItemSelectedListener
{
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator;
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private ScrollingTabContainerView$TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final ScrollingTabContainerView$VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;
    
    static {
        sAlphaInterpolator = (Interpolator)new DecelerateInterpolator();
    }
    
    public ScrollingTabContainerView(final Context context) {
        super(context);
        this.mVisAnimListener = new ScrollingTabContainerView$VisibilityAnimListener(this);
        this.setHorizontalScrollBarEnabled(false);
        final ActionBarPolicy value = ActionBarPolicy.get(context);
        this.setContentHeight(value.getTabContainerHeight());
        this.mStackedTabMaxWidth = value.getStackedTabMaxWidth();
        this.addView((View)(this.mTabLayout = this.createTabLayout()), new ViewGroup$LayoutParams(-2, -1));
    }
    
    private Spinner createSpinner() {
        final AppCompatSpinner appCompatSpinner = new AppCompatSpinner(this.getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams((ViewGroup$LayoutParams)new LinearLayoutCompat$LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)this);
        return appCompatSpinner;
    }
    
    private LinearLayoutCompat createTabLayout() {
        final LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams((ViewGroup$LayoutParams)new LinearLayoutCompat$LayoutParams(-2, -1));
        return linearLayoutCompat;
    }
    
    private boolean isCollapsed() {
        final Spinner mTabSpinner = this.mTabSpinner;
        return mTabSpinner != null && mTabSpinner.getParent() == this;
    }
    
    private void performCollapse() {
        if (this.isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
        }
        this.removeView((View)this.mTabLayout);
        this.addView((View)this.mTabSpinner, new ViewGroup$LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((SpinnerAdapter)new ScrollingTabContainerView$TabAdapter(this));
        }
        final Runnable mTabSelector = this.mTabSelector;
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }
    
    private boolean performExpand() {
        if (!this.isCollapsed()) {
            return false;
        }
        this.removeView((View)this.mTabSpinner);
        this.addView((View)this.mTabLayout, new ViewGroup$LayoutParams(-2, -1));
        this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        final ScrollingTabContainerView$TabView tabView = this.createTabView(actionBar$Tab, false);
        this.mTabLayout.addView((View)tabView, n, (ViewGroup$LayoutParams)new LinearLayoutCompat$LayoutParams(0, -1, 1.0f));
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        final ScrollingTabContainerView$TabView tabView = this.createTabView(actionBar$Tab, false);
        this.mTabLayout.addView((View)tabView, (ViewGroup$LayoutParams)new LinearLayoutCompat$LayoutParams(0, -1, 1.0f));
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void animateToTab(final int n) {
        final View child = this.mTabLayout.getChildAt(n);
        final Runnable mTabSelector = this.mTabSelector;
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
        }
        this.post(this.mTabSelector = new ScrollingTabContainerView$1(this, child));
    }
    
    public void animateToVisibility(final int n) {
        final ViewPropertyAnimatorCompat mVisibilityAnim = this.mVisibilityAnim;
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        final long n2 = 200L;
        if (n == 0) {
            if (this.getVisibility() != 0) {
                ViewCompat.setAlpha((View)this, 0.0f);
            }
            final ViewPropertyAnimatorCompat alpha = ViewCompat.animate((View)this).alpha(1.0f);
            alpha.setDuration(n2);
            alpha.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, n));
            alpha.start();
        }
        else {
            final ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate((View)this).alpha(0.0f);
            alpha2.setDuration(n2);
            alpha2.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
            alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, n));
            alpha2.start();
        }
    }
    
    ScrollingTabContainerView$TabView createTabView(final ActionBar$Tab actionBar$Tab, final boolean b) {
        final ScrollingTabContainerView$TabView scrollingTabContainerView$TabView = new ScrollingTabContainerView$TabView(this, this.getContext(), actionBar$Tab, b);
        if (b) {
            scrollingTabContainerView$TabView.setBackgroundDrawable((Drawable)null);
            scrollingTabContainerView$TabView.setLayoutParams((ViewGroup$LayoutParams)new AbsListView$LayoutParams(-1, this.mContentHeight));
        }
        else {
            scrollingTabContainerView$TabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new ScrollingTabContainerView$TabClickListener(this);
            }
            scrollingTabContainerView$TabView.setOnClickListener((View$OnClickListener)this.mTabClickListener);
        }
        return scrollingTabContainerView$TabView;
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Runnable mTabSelector = this.mTabSelector;
        if (mTabSelector != null) {
            this.post(mTabSelector);
        }
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final ActionBarPolicy value = ActionBarPolicy.get(this.getContext());
        this.setContentHeight(value.getTabContainerHeight());
        this.mStackedTabMaxWidth = value.getStackedTabMaxWidth();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Runnable mTabSelector = this.mTabSelector;
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
        }
    }
    
    public void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        ((ScrollingTabContainerView$TabView)view).getTab().select();
    }
    
    public void onMeasure(final int n, int measureSpec) {
        final int mode = View$MeasureSpec.getMode(n);
        int n2 = 1;
        final int n3 = 1073741824;
        final boolean fillViewport = mode == n3;
        this.setFillViewport(fillViewport);
        final int childCount = this.mTabLayout.getChildCount();
        if (childCount > n2 && (mode == n3 || mode == -1 << -1)) {
            final int n4 = 2;
            if (childCount > n4) {
                this.mMaxTabWidth = (int)(View$MeasureSpec.getSize(n) * 0.4f);
            }
            else {
                this.mMaxTabWidth = View$MeasureSpec.getSize(n) / n4;
            }
            this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        }
        else {
            this.mMaxTabWidth = -1;
        }
        measureSpec = View$MeasureSpec.makeMeasureSpec(this.mContentHeight, n3);
        if (fillViewport || !this.mAllowCollapse) {
            n2 = 0;
        }
        if (n2 != 0) {
            this.mTabLayout.measure(0, measureSpec);
            if (this.mTabLayout.getMeasuredWidth() > View$MeasureSpec.getSize(n)) {
                this.performCollapse();
            }
            else {
                this.performExpand();
            }
        }
        else {
            this.performExpand();
        }
        final int measuredWidth = this.getMeasuredWidth();
        super.onMeasure(n, measureSpec);
        final int measuredWidth2 = this.getMeasuredWidth();
        if (fillViewport && measuredWidth != measuredWidth2) {
            this.setTabSelected(this.mSelectedTabIndex);
        }
    }
    
    public void onNothingSelected(final AdapterView adapterView) {
    }
    
    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void removeTabAt(final int n) {
        this.mTabLayout.removeViewAt(n);
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void setAllowCollapse(final boolean mAllowCollapse) {
        this.mAllowCollapse = mAllowCollapse;
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setTabSelected(final int n) {
        this.mSelectedTabIndex = n;
        for (int childCount = this.mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.mTabLayout.getChildAt(i);
            final boolean selected = i == n;
            child.setSelected(selected);
            if (selected) {
                this.animateToTab(n);
            }
        }
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null && n >= 0) {
            mTabSpinner.setSelection(n);
        }
    }
    
    public void updateTab(final int n) {
        ((ScrollingTabContainerView$TabView)this.mTabLayout.getChildAt(n)).update();
        final Spinner mTabSpinner = this.mTabSpinner;
        if (mTabSpinner != null) {
            ((ScrollingTabContainerView$TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            this.requestLayout();
        }
    }
}
