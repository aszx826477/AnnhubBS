// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.database.DataSetObserver;

class PagerTitleStrip$PageListener extends DataSetObserver implements ViewPager$OnPageChangeListener, ViewPager$OnAdapterChangeListener
{
    private int mScrollState;
    final /* synthetic */ PagerTitleStrip this$0;
    
    PagerTitleStrip$PageListener(final PagerTitleStrip this$0) {
        this.this$0 = this$0;
    }
    
    public void onAdapterChanged(final ViewPager viewPager, final PagerAdapter pagerAdapter, final PagerAdapter pagerAdapter2) {
        this.this$0.updateAdapter(pagerAdapter, pagerAdapter2);
    }
    
    public void onChanged() {
        final PagerTitleStrip this$0 = this.this$0;
        this$0.updateText(this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
        final float mLastKnownPositionOffset = this.this$0.mLastKnownPositionOffset;
        float mLastKnownPositionOffset2 = 0.0f;
        if (mLastKnownPositionOffset >= 0.0f) {
            mLastKnownPositionOffset2 = this.this$0.mLastKnownPositionOffset;
        }
        final PagerTitleStrip this$2 = this.this$0;
        this$2.updateTextPositions(this$2.mPager.getCurrentItem(), mLastKnownPositionOffset2, true);
    }
    
    public void onPageScrollStateChanged(final int mScrollState) {
        this.mScrollState = mScrollState;
    }
    
    public void onPageScrolled(int n, final float n2, final int n3) {
        if (n2 > 0.5f) {
            ++n;
        }
        this.this$0.updateTextPositions(n, n2, false);
    }
    
    public void onPageSelected(final int n) {
        if (this.mScrollState == 0) {
            final PagerTitleStrip this$0 = this.this$0;
            this$0.updateText(this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            final float mLastKnownPositionOffset = this.this$0.mLastKnownPositionOffset;
            float mLastKnownPositionOffset2 = 0.0f;
            if (mLastKnownPositionOffset >= 0.0f) {
                mLastKnownPositionOffset2 = this.this$0.mLastKnownPositionOffset;
            }
            final PagerTitleStrip this$2 = this.this$0;
            this$2.updateTextPositions(this$2.mPager.getCurrentItem(), mLastKnownPositionOffset2, true);
        }
    }
}
