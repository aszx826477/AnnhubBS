// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.database.DataSetObserver;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.text.TextUtils$TruncateAt;
import android.support.v4.widget.TextViewCompat;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.widget.TextView;
import android.view.ViewGroup;

public class PagerTitleStrip extends ViewGroup
{
    private static final int[] ATTRS;
    private static final PagerTitleStrip$PagerTitleStripImpl IMPL;
    private static final float SIDE_ALPHA = 0.6f;
    private static final String TAG = "PagerTitleStrip";
    private static final int[] TEXT_ATTRS;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PagerTitleStrip$PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference mWatchingAdapter;
    
    static {
        final int[] array;
        final int[] attrs = array = new int[4];
        array[0] = 16842804;
        array[1] = 16842901;
        array[2] = 16842904;
        array[3] = 16842927;
        ATTRS = attrs;
        TEXT_ATTRS = new int[] { 16843660 };
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new PagerTitleStrip$PagerTitleStripImplIcs();
        }
        else {
            IMPL = new PagerTitleStrip$PagerTitleStripImplBase();
        }
    }
    
    public PagerTitleStrip(final Context context) {
        this(context, null);
    }
    
    public PagerTitleStrip(final Context context, final AttributeSet set) {
        super(context, set);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PagerTitleStrip$PageListener(this);
        this.addView((View)(this.mPrevText = new TextView(context)));
        this.addView((View)(this.mCurrText = new TextView(context)));
        this.addView((View)(this.mNextText = new TextView(context)));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, PagerTitleStrip.ATTRS);
        final int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            this.setTextSize(0, dimensionPixelSize);
        }
        final int n = 2;
        if (obtainStyledAttributes.hasValue(n)) {
            final int color = obtainStyledAttributes.getColor(n, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        this.setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils$TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils$TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils$TruncateAt.END);
        boolean boolean1 = false;
        if (resourceId != 0) {
            final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, PagerTitleStrip.TEXT_ATTRS);
            boolean1 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (boolean1) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        }
        else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int)(16.0f * context.getResources().getDisplayMetrics().density);
    }
    
    private static void setSingleLineAllCaps(final TextView singleLineAllCaps) {
        PagerTitleStrip.IMPL.setSingleLineAllCaps(singleLineAllCaps);
    }
    
    int getMinHeight() {
        int intrinsicHeight = 0;
        final Drawable background = this.getBackground();
        if (background != null) {
            intrinsicHeight = background.getIntrinsicHeight();
        }
        return intrinsicHeight;
    }
    
    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewParent parent = this.getParent();
        if (parent instanceof ViewPager) {
            final ViewPager mPager = (ViewPager)parent;
            final PagerAdapter adapter = mPager.getAdapter();
            mPager.setInternalPageChangeListener(this.mPageListener);
            mPager.addOnAdapterChangeListener(this.mPageListener);
            this.mPager = mPager;
            final WeakReference mWatchingAdapter = this.mWatchingAdapter;
            PagerAdapter pagerAdapter;
            if (mWatchingAdapter != null) {
                pagerAdapter = mWatchingAdapter.get();
            }
            else {
                pagerAdapter = null;
            }
            this.updateAdapter(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ViewPager mPager = this.mPager;
        if (mPager != null) {
            this.updateAdapter(mPager.getAdapter(), null);
            this.mPager.setInternalPageChangeListener(null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (this.mPager != null) {
            float mLastKnownPositionOffset = this.mLastKnownPositionOffset;
            if (mLastKnownPositionOffset < 0.0f) {
                mLastKnownPositionOffset = 0.0f;
            }
            this.updateTextPositions(this.mLastKnownCurrentPage, mLastKnownPositionOffset, true);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int n3 = 1073741824;
        if (mode == n3) {
            final int n4 = this.getPaddingTop() + this.getPaddingBottom();
            final int n5 = -2;
            final int childMeasureSpec = getChildMeasureSpec(n2, n4, n5);
            final int size = View$MeasureSpec.getSize(n);
            final int childMeasureSpec2 = getChildMeasureSpec(n, (int)(size * 0.2f), n5);
            this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
            this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
            this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
            int n6;
            if (View$MeasureSpec.getMode(n2) == n3) {
                n6 = View$MeasureSpec.getSize(n2);
            }
            else {
                n6 = Math.max(this.getMinHeight(), this.mCurrText.getMeasuredHeight() + n4);
            }
            this.setMeasuredDimension(size, ViewCompat.resolveSizeAndState(n6, n2, ViewCompat.getMeasuredState((View)this.mCurrText) << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }
    
    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }
    
    public void setGravity(final int mGravity) {
        this.mGravity = mGravity;
        this.requestLayout();
    }
    
    public void setNonPrimaryAlpha(final float n) {
        this.mNonPrimaryAlpha = ((int)(255.0f * n) & 0xFF);
        final int n2 = this.mNonPrimaryAlpha << 24 | (this.mTextColor & 0xFFFFFF);
        this.mPrevText.setTextColor(n2);
        this.mNextText.setTextColor(n2);
    }
    
    public void setTextColor(final int n) {
        this.mTextColor = n;
        this.mCurrText.setTextColor(n);
        final int n2 = this.mNonPrimaryAlpha << 24 | (this.mTextColor & 0xFFFFFF);
        this.mPrevText.setTextColor(n2);
        this.mNextText.setTextColor(n2);
    }
    
    public void setTextSize(final int n, final float n2) {
        this.mPrevText.setTextSize(n, n2);
        this.mCurrText.setTextSize(n, n2);
        this.mNextText.setTextSize(n, n2);
    }
    
    public void setTextSpacing(final int mScaledTextSpacing) {
        this.mScaledTextSpacing = mScaledTextSpacing;
        this.requestLayout();
    }
    
    void updateAdapter(final PagerAdapter pagerAdapter, final PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference((T)pagerAdapter2);
        }
        final ViewPager mPager = this.mPager;
        if (mPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            this.updateText(mPager.getCurrentItem(), pagerAdapter2);
            this.requestLayout();
        }
    }
    
    void updateText(final int mLastKnownCurrentPage, final PagerAdapter pagerAdapter) {
        int count;
        if (pagerAdapter != null) {
            count = pagerAdapter.getCount();
        }
        else {
            count = 0;
        }
        final int mUpdatingText = 1;
        this.mUpdatingText = (mUpdatingText != 0);
        CharSequence pageTitle = null;
        if (mLastKnownCurrentPage >= mUpdatingText && pagerAdapter != null) {
            pageTitle = pagerAdapter.getPageTitle(mLastKnownCurrentPage - 1);
        }
        this.mPrevText.setText(pageTitle);
        final TextView mCurrText = this.mCurrText;
        CharSequence pageTitle2;
        if (pagerAdapter != null && mLastKnownCurrentPage < count) {
            pageTitle2 = pagerAdapter.getPageTitle(mLastKnownCurrentPage);
        }
        else {
            pageTitle2 = null;
        }
        mCurrText.setText(pageTitle2);
        CharSequence pageTitle3 = null;
        if (mLastKnownCurrentPage + 1 < count && pagerAdapter != null) {
            pageTitle3 = pagerAdapter.getPageTitle(mLastKnownCurrentPage + 1);
        }
        this.mNextText.setText(pageTitle3);
        final int max = Math.max(0, (int)((this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()) * 0.8f));
        final int n = -1 << -1;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(max, n);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), n);
        this.mPrevText.measure(measureSpec, measureSpec2);
        this.mCurrText.measure(measureSpec, measureSpec2);
        this.mNextText.measure(measureSpec, measureSpec2);
        this.mLastKnownCurrentPage = mLastKnownCurrentPage;
        if (!this.mUpdatingPositions) {
            this.updateTextPositions(mLastKnownCurrentPage, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }
    
    void updateTextPositions(final int n, final float mLastKnownPositionOffset, final boolean b) {
        if (n != this.mLastKnownCurrentPage) {
            this.updateText(n, this.mPager.getAdapter());
        }
        else if (!b && mLastKnownPositionOffset == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        final int measuredWidth = this.mPrevText.getMeasuredWidth();
        final int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        final int measuredWidth3 = this.mNextText.getMeasuredWidth();
        final int n2 = measuredWidth2 / 2;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int n3 = paddingLeft + n2;
        final int n4 = paddingRight + n2;
        final int n5 = width - n3 - n4;
        float n6 = mLastKnownPositionOffset + 0.5f;
        final float n7 = 1.0f;
        if (n6 > n7) {
            n6 -= n7;
        }
        final int n8 = width - n4 - (int)(n5 * n6) - measuredWidth2 / 2;
        final int n9 = n8 + measuredWidth2;
        final int baseline = this.mPrevText.getBaseline();
        final int baseline2 = this.mCurrText.getBaseline();
        final int baseline3 = this.mNextText.getBaseline();
        final int max = Math.max(Math.max(baseline, baseline2), baseline3);
        final int n10 = max - baseline;
        final int n11 = max - baseline2;
        final int n12 = max - baseline3;
        final int max2 = Math.max(Math.max(n10 + this.mPrevText.getMeasuredHeight(), n11 + this.mCurrText.getMeasuredHeight()), n12 + this.mNextText.getMeasuredHeight());
        final int n13 = this.mGravity & 0x70;
        int n17;
        int n18;
        int n19;
        if (n13 != 16) {
            if (n13 != 80) {
                final int n14 = paddingTop + n10;
                final int n15 = paddingTop + n11;
                final int n16 = paddingTop + n12;
                n17 = n14;
                n18 = n15;
                n19 = n16;
            }
            else {
                final int n20 = height - paddingBottom - max2;
                final int n21 = n20 + n10;
                final int n22 = n20 + n11;
                final int n23 = n20 + n12;
                n17 = n21;
                n18 = n22;
                n19 = n23;
            }
        }
        else {
            final int n24 = (height - paddingTop - paddingBottom - max2) / 2;
            final int n25 = n24 + n10;
            final int n26 = n24 + n11;
            final int n27 = n24 + n12;
            n17 = n25;
            n18 = n26;
            n19 = n27;
        }
        final TextView mCurrText = this.mCurrText;
        mCurrText.layout(n8, n18, n9, n18 + mCurrText.getMeasuredHeight());
        final int min = Math.min(paddingLeft, n8 - this.mScaledTextSpacing - measuredWidth);
        final TextView mPrevText = this.mPrevText;
        mPrevText.layout(min, n17, min + measuredWidth, n17 + mPrevText.getMeasuredHeight());
        final int max3 = Math.max(width - paddingRight - measuredWidth3, this.mScaledTextSpacing + n9);
        final TextView mNextText = this.mNextText;
        mNextText.layout(max3, n19, max3 + measuredWidth3, n19 + mNextText.getMeasuredHeight());
        this.mLastKnownPositionOffset = mLastKnownPositionOffset;
        this.mUpdatingPositions = false;
    }
}
