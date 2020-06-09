// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.View;

class Fragment$AnimationInfo
{
    private Boolean mAllowEnterTransitionOverlap;
    private Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    private Object mEnterTransition;
    SharedElementCallback mEnterTransitionCallback;
    boolean mEnterTransitionPostponed;
    private Object mExitTransition;
    SharedElementCallback mExitTransitionCallback;
    boolean mIsHideReplaced;
    int mNextAnim;
    int mNextTransition;
    int mNextTransitionStyle;
    private Object mReenterTransition;
    private Object mReturnTransition;
    private Object mSharedElementEnterTransition;
    private Object mSharedElementReturnTransition;
    Fragment$OnStartEnterTransitionListener mStartEnterTransitionListener;
    int mStateAfterAnimating;
    
    Fragment$AnimationInfo() {
        this.mEnterTransition = null;
        this.mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        this.mExitTransition = null;
        this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
        this.mSharedElementEnterTransition = null;
        this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        this.mEnterTransitionCallback = null;
        this.mExitTransitionCallback = null;
    }
}
