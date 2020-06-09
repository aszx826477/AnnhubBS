// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.support.v4.content.ContextCompat;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.widget.TextView;
import android.view.View$OnClickListener;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Paint;

public class PagerTabStrip extends PagerTitleStrip
{
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;
    
    public PagerTabStrip(final Context context) {
        this(context, null);
    }
    
    public PagerTabStrip(final Context context, final AttributeSet set) {
        super(context, set);
        this.mTabPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        this.mIndicatorColor = this.mTextColor;
        this.mTabPaint.setColor(this.mIndicatorColor);
        final float density = context.getResources().getDisplayMetrics().density;
        final float n = 3.0f * density;
        final float n2 = 0.5f;
        this.mIndicatorHeight = (int)(n + n2);
        this.mMinPaddingBottom = (int)(6.0f * density + n2);
        this.mMinTextSpacing = (int)(64.0f * density);
        this.mTabPadding = (int)(16.0f * density + n2);
        this.mFullUnderlineHeight = (int)(1.0f * density + n2);
        this.mMinStripHeight = (int)(32.0f * density + n2);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.setTextSpacing(this.getTextSpacing());
        this.setWillNotDraw(false);
        final TextView mPrevText = this.mPrevText;
        final boolean mDrawFullUnderline = true;
        mPrevText.setFocusable(mDrawFullUnderline);
        this.mPrevText.setOnClickListener((View$OnClickListener)new PagerTabStrip$1(this));
        this.mNextText.setFocusable(mDrawFullUnderline);
        this.mNextText.setOnClickListener((View$OnClickListener)new PagerTabStrip$2(this));
        if (this.getBackground() == null) {
            this.mDrawFullUnderline = mDrawFullUnderline;
        }
    }
    
    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }
    
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }
    
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final int height = this.getHeight();
        final int n = this.mCurrText.getLeft() - this.mTabPadding;
        final int n2 = this.mCurrText.getRight() + this.mTabPadding;
        final int n3 = height - this.mIndicatorHeight;
        final Paint mTabPaint = this.mTabPaint;
        final int n4 = this.mTabAlpha << 24;
        final int mIndicatorColor = this.mIndicatorColor;
        final int n5 = 16777215;
        mTabPaint.setColor(n4 | (mIndicatorColor & n5));
        canvas.drawRect((float)n, (float)n3, (float)n2, (float)height, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor(0xFF000000 | (this.mIndicatorColor & n5));
            canvas.drawRect((float)this.getPaddingLeft(), (float)(height - this.mFullUnderlineHeight), (float)(this.getWidth() - this.getPaddingRight()), (float)height, this.mTabPaint);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
        final int mIgnoreTap = 1;
        switch (action) {
            case 2: {
                if (Math.abs(x - this.mInitialMotionX) <= this.mTouchSlop && Math.abs(y - this.mInitialMotionY) <= this.mTouchSlop) {
                    break;
                }
                this.mIgnoreTap = (mIgnoreTap != 0);
                break;
            }
            case 1: {
                if (x < this.mCurrText.getLeft() - this.mTabPadding) {
                    this.mPager.setCurrentItem(this.mPager.getCurrentItem() - mIgnoreTap);
                    break;
                }
                if (x > this.mCurrText.getRight() + this.mTabPadding) {
                    this.mPager.setCurrentItem(this.mPager.getCurrentItem() + mIgnoreTap);
                    break;
                }
                break;
            }
            case 0: {
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.mIgnoreTap = false;
                break;
            }
        }
        return mIgnoreTap != 0;
    }
    
    public void setBackgroundColor(final int backgroundColor) {
        super.setBackgroundColor(backgroundColor);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = ((0xFF000000 & backgroundColor) == 0x0);
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = (backgroundDrawable == null);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (!this.mDrawFullUnderlineSet) {
            this.mDrawFullUnderline = (backgroundResource == 0);
        }
    }
    
    public void setDrawFullUnderline(final boolean mDrawFullUnderline) {
        this.mDrawFullUnderline = mDrawFullUnderline;
        this.mDrawFullUnderlineSet = true;
        this.invalidate();
    }
    
    public void setPadding(final int n, final int n2, final int n3, int mMinPaddingBottom) {
        if (mMinPaddingBottom < this.mMinPaddingBottom) {
            mMinPaddingBottom = this.mMinPaddingBottom;
        }
        super.setPadding(n, n2, n3, mMinPaddingBottom);
    }
    
    public void setTabIndicatorColor(final int mIndicatorColor) {
        this.mIndicatorColor = mIndicatorColor;
        this.mTabPaint.setColor(this.mIndicatorColor);
        this.invalidate();
    }
    
    public void setTabIndicatorColorResource(final int n) {
        this.setTabIndicatorColor(ContextCompat.getColor(this.getContext(), n));
    }
    
    public void setTextSpacing(int mMinTextSpacing) {
        if (mMinTextSpacing < this.mMinTextSpacing) {
            mMinTextSpacing = this.mMinTextSpacing;
        }
        super.setTextSpacing(mMinTextSpacing);
    }
    
    void updateTextPositions(final int n, final float n2, final boolean b) {
        final Rect mTempRect = this.mTempRect;
        final int height = this.getHeight();
        final int n3 = this.mCurrText.getLeft() - this.mTabPadding;
        final int n4 = this.mCurrText.getRight() + this.mTabPadding;
        final int n5 = height - this.mIndicatorHeight;
        mTempRect.set(n3, n5, n4, height);
        super.updateTextPositions(n, n2, b);
        this.mTabAlpha = (int)(Math.abs(n2 - 0.5f) * 2.0f * 255.0f);
        mTempRect.union(this.mCurrText.getLeft() - this.mTabPadding, n5, this.mCurrText.getRight() + this.mTabPadding, height);
        this.invalidate(mTempRect);
    }
}
