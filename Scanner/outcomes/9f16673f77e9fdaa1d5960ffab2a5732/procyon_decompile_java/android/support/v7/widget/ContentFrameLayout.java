// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;
import android.util.TypedValue;
import android.graphics.Rect;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout
{
    private ContentFrameLayout$OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;
    
    public ContentFrameLayout(final Context context) {
        this(context, null);
    }
    
    public ContentFrameLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ContentFrameLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mDecorPadding = new Rect();
    }
    
    public void dispatchFitSystemWindows(final Rect rect) {
        this.fitSystemWindows(rect);
    }
    
    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }
    
    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }
    
    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }
    
    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }
    
    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }
    
    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ContentFrameLayout$OnAttachListener mAttachListener = this.mAttachListener;
        if (mAttachListener != null) {
            mAttachListener.onAttachedFromWindow();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ContentFrameLayout$OnAttachListener mAttachListener = this.mAttachListener;
        if (mAttachListener != null) {
            mAttachListener.onDetachedFromWindow();
        }
    }
    
    protected void onMeasure(int n, int measureSpec) {
        final DisplayMetrics displayMetrics = this.getContext().getResources().getDisplayMetrics();
        final boolean b = displayMetrics.widthPixels < displayMetrics.heightPixels;
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(measureSpec);
        boolean b2 = false;
        final int n2 = 6;
        final int n3 = 5;
        final int n4 = -1 << -1;
        final int n5 = 1073741824;
        if (mode == n4) {
            TypedValue typedValue;
            if (b) {
                typedValue = this.mFixedWidthMinor;
            }
            else {
                typedValue = this.mFixedWidthMajor;
            }
            if (typedValue != null && typedValue.type != 0) {
                int n6 = 0;
                if (typedValue.type == n3) {
                    n6 = (int)typedValue.getDimension(displayMetrics);
                }
                else if (typedValue.type == n2) {
                    n6 = (int)typedValue.getFraction((float)displayMetrics.widthPixels, (float)displayMetrics.widthPixels);
                }
                if (n6 > 0) {
                    n = View$MeasureSpec.makeMeasureSpec(Math.min(n6 - (this.mDecorPadding.left + this.mDecorPadding.right), View$MeasureSpec.getSize(n)), n5);
                    b2 = true;
                }
            }
        }
        if (mode2 == n4) {
            TypedValue typedValue2;
            if (b) {
                typedValue2 = this.mFixedHeightMajor;
            }
            else {
                typedValue2 = this.mFixedHeightMinor;
            }
            if (typedValue2 != null && typedValue2.type != 0) {
                int n7 = 0;
                if (typedValue2.type == n3) {
                    n7 = (int)typedValue2.getDimension(displayMetrics);
                }
                else if (typedValue2.type == n2) {
                    n7 = (int)typedValue2.getFraction((float)displayMetrics.heightPixels, (float)displayMetrics.heightPixels);
                }
                if (n7 > 0) {
                    measureSpec = View$MeasureSpec.makeMeasureSpec(Math.min(n7 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View$MeasureSpec.getSize(measureSpec)), n5);
                }
            }
        }
        super.onMeasure(n, measureSpec);
        final int measuredWidth = this.getMeasuredWidth();
        boolean b3 = false;
        n = View$MeasureSpec.makeMeasureSpec(measuredWidth, n5);
        if (!b2 && mode == n4) {
            TypedValue typedValue3;
            if (b) {
                typedValue3 = this.mMinWidthMinor;
            }
            else {
                typedValue3 = this.mMinWidthMajor;
            }
            if (typedValue3 != null && typedValue3.type != 0) {
                int n8 = 0;
                if (typedValue3.type == n3) {
                    n8 = (int)typedValue3.getDimension(displayMetrics);
                }
                else if (typedValue3.type == n2) {
                    n8 = (int)typedValue3.getFraction((float)displayMetrics.widthPixels, (float)displayMetrics.widthPixels);
                }
                if (n8 > 0) {
                    n8 -= this.mDecorPadding.left + this.mDecorPadding.right;
                }
                if (measuredWidth < n8) {
                    n = View$MeasureSpec.makeMeasureSpec(n8, n5);
                    b3 = true;
                }
            }
        }
        if (b3) {
            super.onMeasure(n, measureSpec);
        }
    }
    
    public void setAttachListener(final ContentFrameLayout$OnAttachListener mAttachListener) {
        this.mAttachListener = mAttachListener;
    }
    
    public void setDecorPadding(final int n, final int n2, final int n3, final int n4) {
        this.mDecorPadding.set(n, n2, n3, n4);
        if (ViewCompat.isLaidOut((View)this)) {
            this.requestLayout();
        }
    }
}
