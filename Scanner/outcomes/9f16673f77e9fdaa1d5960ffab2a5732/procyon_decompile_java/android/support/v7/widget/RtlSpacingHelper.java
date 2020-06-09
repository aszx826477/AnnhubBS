// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

class RtlSpacingHelper
{
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;
    
    RtlSpacingHelper() {
        this.mLeft = 0;
        this.mRight = 0;
        final int n = -1 << -1;
        this.mStart = n;
        this.mEnd = n;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }
    
    public int getEnd() {
        int n;
        if (this.mIsRtl) {
            n = this.mLeft;
        }
        else {
            n = this.mRight;
        }
        return n;
    }
    
    public int getLeft() {
        return this.mLeft;
    }
    
    public int getRight() {
        return this.mRight;
    }
    
    public int getStart() {
        int n;
        if (this.mIsRtl) {
            n = this.mRight;
        }
        else {
            n = this.mLeft;
        }
        return n;
    }
    
    public void setAbsolute(final int n, final int n2) {
        this.mIsRelative = false;
        final int n3 = -1 << -1;
        if (n != n3) {
            this.mExplicitLeft = n;
            this.mLeft = n;
        }
        if (n2 != n3) {
            this.mExplicitRight = n2;
            this.mRight = n2;
        }
    }
    
    public void setDirection(final boolean mIsRtl) {
        if (mIsRtl == this.mIsRtl) {
            return;
        }
        this.mIsRtl = mIsRtl;
        if (this.mIsRelative) {
            final int n = -1 << -1;
            if (mIsRtl) {
                int mLeft = this.mEnd;
                if (mLeft == n) {
                    mLeft = this.mExplicitLeft;
                }
                this.mLeft = mLeft;
                int mRight = this.mStart;
                if (mRight == n) {
                    mRight = this.mExplicitRight;
                }
                this.mRight = mRight;
            }
            else {
                int mLeft2 = this.mStart;
                if (mLeft2 == n) {
                    mLeft2 = this.mExplicitLeft;
                }
                this.mLeft = mLeft2;
                int mRight2 = this.mEnd;
                if (mRight2 == n) {
                    mRight2 = this.mExplicitRight;
                }
                this.mRight = mRight2;
            }
        }
        else {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
        }
    }
    
    public void setRelative(final int mLeft, final int mRight) {
        this.mStart = mLeft;
        this.mEnd = mRight;
        this.mIsRelative = true;
        final boolean mIsRtl = this.mIsRtl;
        final int n = -1 << -1;
        if (mIsRtl) {
            if (mRight != n) {
                this.mLeft = mRight;
            }
            if (mLeft != n) {
                this.mRight = mLeft;
            }
        }
        else {
            if (mLeft != n) {
                this.mLeft = mLeft;
            }
            if (mRight != n) {
                this.mRight = mRight;
            }
        }
    }
}
