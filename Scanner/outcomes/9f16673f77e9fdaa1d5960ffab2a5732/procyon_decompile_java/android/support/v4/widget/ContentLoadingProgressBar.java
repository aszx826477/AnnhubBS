// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar
{
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;
    
    public ContentLoadingProgressBar(final Context context) {
        this(context, null);
    }
    
    public ContentLoadingProgressBar(final Context context, final AttributeSet set) {
        super(context, set, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new ContentLoadingProgressBar$1(this);
        this.mDelayedShow = new ContentLoadingProgressBar$2(this);
    }
    
    private void removeCallbacks() {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
    }
    
    public void hide() {
        final boolean b = true;
        this.mDismissed = b;
        this.removeCallbacks(this.mDelayedShow);
        final long currentTimeMillis = System.currentTimeMillis();
        final long mStartTime = this.mStartTime;
        final long n = currentTimeMillis - mStartTime;
        final long n2 = 500L;
        if (n < n2 && mStartTime != -1) {
            if (!this.mPostedHide) {
                this.postDelayed(this.mDelayedHide, n2 - n);
                this.mPostedHide = b;
            }
        }
        else {
            this.setVisibility(8);
        }
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }
    
    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        this.removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            this.postDelayed(this.mDelayedShow, 500L);
            this.mPostedShow = true;
        }
    }
}
