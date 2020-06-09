// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import android.os.Parcelable;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.animation.AnimationUtils;
import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;
import android.support.v4.util.Pair;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.animation.Animation$AnimationListener;
import java.util.List;
import android.view.animation.ScaleAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.content.Context;
import android.view.ViewGroup;
import java.util.Collection;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.View;
import android.support.v4.util.ArraySet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.os.Build$VERSION;
import android.os.Bundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import android.util.SparseArray;
import java.lang.reflect.Field;
import android.view.animation.Interpolator;
import android.support.v4.view.LayoutInflaterFactory;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory
{
    static final Interpolator ACCELERATE_CUBIC;
    static final Interpolator ACCELERATE_QUINT;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC;
    static final Interpolator DECELERATE_QUINT;
    static final boolean HONEYCOMB = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    SparseArray mActive;
    ArrayList mAdded;
    ArrayList mAvailBackStackIndices;
    ArrayList mBackStack;
    ArrayList mBackStackChangeListeners;
    ArrayList mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private CopyOnWriteArrayList mLifecycleCallbacks;
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList mPendingActions;
    ArrayList mPostponedTransactions;
    SparseArray mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    ArrayList mTmpAddedFragments;
    ArrayList mTmpIsPop;
    ArrayList mTmpRecords;
    
    static {
        boolean honeycomb = false;
        FragmentManagerImpl.DEBUG = false;
        if (Build$VERSION.SDK_INT >= 11) {
            honeycomb = true;
        }
        FragmentManagerImpl.sAnimationListenerField = null;
        final float n = 2.5f;
        DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(n);
        final float n2 = 1.5f;
        DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(n2);
        ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(n);
        ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(n2);
    }
    
    FragmentManagerImpl() {
        this.mNextFragmentIndex = 0;
        this.mCurState = 0;
        this.mStateBundle = null;
        this.mStateArray = null;
        this.mExecCommit = new FragmentManagerImpl$1(this);
    }
    
    private void addAddedFragments(final ArraySet set) {
        final int mCurState = this.mCurState;
        if (mCurState < 1) {
            return;
        }
        final int min = Math.min(mCurState, 4);
        final ArrayList mAdded = this.mAdded;
        int size;
        if (mAdded == null) {
            size = 0;
        }
        else {
            size = mAdded.size();
        }
        for (int i = 0; i < size; ++i) {
            final Fragment fragment = this.mAdded.get(i);
            if (fragment.mState < min) {
                this.moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    set.add(fragment);
                }
            }
        }
    }
    
    private void burpActive() {
        final SparseArray mActive = this.mActive;
        if (mActive != null) {
            for (int i = mActive.size() - 1; i >= 0; --i) {
                if (this.mActive.valueAt(i) == null) {
                    final SparseArray mActive2 = this.mActive;
                    mActive2.delete(mActive2.keyAt(i));
                }
            }
        }
    }
    
    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mNoTransactionsBecause == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can not perform this action inside of ");
        sb.append(this.mNoTransactionsBecause);
        throw new IllegalStateException(sb.toString());
    }
    
    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }
    
    private void completeExecute(final BackStackRecord backStackRecord, final boolean b, final boolean b2, final boolean b3) {
        final int n = 1;
        final ArrayList list = new ArrayList<BackStackRecord>(n);
        final ArrayList list2 = new ArrayList<Boolean>(n);
        list.add(backStackRecord);
        list2.add(b);
        executeOps(list, list2, 0, n);
        if (b2) {
            FragmentTransition.startTransitions(this, list, list2, 0, 1, true);
        }
        if (b3) {
            this.moveToState(this.mCurState, n != 0);
        }
        final SparseArray mActive = this.mActive;
        if (mActive != null) {
            for (int size = mActive.size(), i = 0; i < size; ++i) {
                final Fragment fragment = (Fragment)this.mActive.valueAt(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded) {
                    if (backStackRecord.interactsWith(fragment.mContainerId)) {
                        if (Build$VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0f) {
                            fragment.mView.setAlpha(fragment.mPostponedAlpha);
                        }
                        if (b3) {
                            fragment.mPostponedAlpha = 0.0f;
                        }
                        else {
                            fragment.mPostponedAlpha = -1.0f;
                            fragment.mIsNewlyAdded = false;
                        }
                    }
                }
            }
        }
    }
    
    private void endAnimatingAwayFragments() {
        final SparseArray mActive = this.mActive;
        int size;
        if (mActive == null) {
            size = 0;
        }
        else {
            size = mActive.size();
        }
        for (int i = 0; i < size; ++i) {
            final Fragment fragment = (Fragment)this.mActive.valueAt(i);
            if (fragment != null && fragment.getAnimatingAway() != null) {
                final int stateAfterAnimating = fragment.getStateAfterAnimating();
                final View animatingAway = fragment.getAnimatingAway();
                fragment.setAnimatingAway(null);
                final Animation animation = animatingAway.getAnimation();
                if (animation != null) {
                    animation.cancel();
                    animatingAway.clearAnimation();
                }
                this.moveToState(fragment, stateAfterAnimating, 0, 0, false);
            }
        }
    }
    
    private void ensureExecReady(final boolean b) {
        if (!this.mExecutingActions) {
            if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
                if (!b) {
                    this.checkStateLoss();
                }
                if (this.mTmpRecords == null) {
                    this.mTmpRecords = new ArrayList();
                    this.mTmpIsPop = new ArrayList();
                }
                this.mExecutingActions = true;
                final ArrayList list = null;
                try {
                    this.executePostponedTransaction(list, null);
                    return;
                }
                finally {
                    this.mExecutingActions = false;
                }
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    
    private static void executeOps(final ArrayList list, final ArrayList list2, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            final BackStackRecord backStackRecord = list.get(i);
            final boolean booleanValue = list2.get(i);
            int n3 = 1;
            if (booleanValue) {
                backStackRecord.bumpBackStackNesting(-1);
                if (i != n2 - 1) {
                    n3 = 0;
                }
                backStackRecord.executePopOps(n3 != 0);
            }
            else {
                backStackRecord.bumpBackStackNesting(n3);
                backStackRecord.executeOps();
            }
        }
    }
    
    private void executeOpsTogether(final ArrayList list, final ArrayList list2, final int n, final int n2) {
        final boolean mAllowOptimization = list.get(n).mAllowOptimization;
        boolean b = false;
        final ArrayList mTmpAddedFragments = this.mTmpAddedFragments;
        if (mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList();
        }
        else {
            mTmpAddedFragments.clear();
        }
        final ArrayList mAdded = this.mAdded;
        if (mAdded != null) {
            this.mTmpAddedFragments.addAll(mAdded);
        }
        int n3 = n;
        boolean b2;
        while (true) {
            b2 = true;
            if (n3 >= n2) {
                break;
            }
            final BackStackRecord backStackRecord = list.get(n3);
            if (!list2.get(n3)) {
                backStackRecord.expandReplaceOps(this.mTmpAddedFragments);
            }
            else {
                backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments);
            }
            if (!b) {
                if (!backStackRecord.mAddToBackStack) {
                    b2 = false;
                }
            }
            b = b2;
            ++n3;
        }
        this.mTmpAddedFragments.clear();
        if (!mAllowOptimization) {
            FragmentTransition.startTransitions(this, list, list2, n, n2, false);
        }
        executeOps(list, list2, n, n2);
        int postponePostponableTransactions = n2;
        if (mAllowOptimization) {
            final ArraySet set = new ArraySet();
            this.addAddedFragments(set);
            postponePostponableTransactions = this.postponePostponableTransactions(list, list2, n, n2, set);
            this.makeRemovedFragmentsInvisible(set);
        }
        if (postponePostponableTransactions != n && mAllowOptimization) {
            FragmentTransition.startTransitions(this, list, list2, n, postponePostponableTransactions, true);
            this.moveToState(this.mCurState, b2);
        }
        for (int i = n; i < n2; ++i) {
            final BackStackRecord backStackRecord2 = list.get(i);
            if (list2.get(i) && backStackRecord2.mIndex >= 0) {
                this.freeBackStackIndex(backStackRecord2.mIndex);
                backStackRecord2.mIndex = -1;
            }
        }
        if (b) {
            this.reportBackStackChanged();
        }
    }
    
    private void executePostponedTransaction(final ArrayList list, final ArrayList list2) {
        final ArrayList mPostponedTransactions = this.mPostponedTransactions;
        int size;
        if (mPostponedTransactions == null) {
            size = 0;
        }
        else {
            size = mPostponedTransactions.size();
        }
        for (int i = 0; i < size; ++i) {
            final FragmentManagerImpl$StartEnterTransitionListener fragmentManagerImpl$StartEnterTransitionListener = this.mPostponedTransactions.get(i);
            final int n = -1;
            if (list != null && !fragmentManagerImpl$StartEnterTransitionListener.mIsBack) {
                final int index = list.indexOf(fragmentManagerImpl$StartEnterTransitionListener.mRecord);
                if (index != n && list2.get(index)) {
                    fragmentManagerImpl$StartEnterTransitionListener.cancelTransaction();
                    continue;
                }
            }
            if (!fragmentManagerImpl$StartEnterTransitionListener.isReady()) {
                if (list == null) {
                    continue;
                }
                if (!fragmentManagerImpl$StartEnterTransitionListener.mRecord.interactsWith(list, 0, list.size())) {
                    continue;
                }
            }
            this.mPostponedTransactions.remove(i);
            --i;
            --size;
            if (list != null && !fragmentManagerImpl$StartEnterTransitionListener.mIsBack) {
                final int index2 = list.indexOf(fragmentManagerImpl$StartEnterTransitionListener.mRecord);
                if (index2 != n) {
                    if (list2.get(index2)) {
                        fragmentManagerImpl$StartEnterTransitionListener.cancelTransaction();
                        continue;
                    }
                }
            }
            fragmentManagerImpl$StartEnterTransitionListener.completeTransaction();
        }
    }
    
    private Fragment findFragmentUnder(final Fragment fragment) {
        final ViewGroup mContainer = fragment.mContainer;
        final View mView = fragment.mView;
        if (mContainer != null && mView != null) {
            for (int i = this.mAdded.indexOf(fragment) - 1; i >= 0; --i) {
                final Fragment fragment2 = this.mAdded.get(i);
                if (fragment2.mContainer == mContainer && fragment2.mView != null) {
                    return fragment2;
                }
            }
            return null;
        }
        return null;
    }
    
    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }
    
    private boolean generateOpsForPendingActions(final ArrayList p0, final ArrayList p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: iconst_0       
        //     3: istore_3       
        //     4: aconst_null    
        //     5: astore          4
        //     7: aload_0        
        //     8: getfield        android/support/v4/app/FragmentManagerImpl.mPendingActions:Ljava/util/ArrayList;
        //    11: astore          5
        //    13: aload           5
        //    15: ifnull          154
        //    18: aload_0        
        //    19: getfield        android/support/v4/app/FragmentManagerImpl.mPendingActions:Ljava/util/ArrayList;
        //    22: astore          5
        //    24: aload           5
        //    26: invokevirtual   java/util/ArrayList.size:()I
        //    29: istore          6
        //    31: iload           6
        //    33: ifne            39
        //    36: goto            154
        //    39: aload_0        
        //    40: getfield        android/support/v4/app/FragmentManagerImpl.mPendingActions:Ljava/util/ArrayList;
        //    43: astore          5
        //    45: aload           5
        //    47: invokevirtual   java/util/ArrayList.size:()I
        //    50: istore          6
        //    52: iconst_0       
        //    53: istore          7
        //    55: aconst_null    
        //    56: astore          8
        //    58: iload           7
        //    60: iload           6
        //    62: if_icmpge       106
        //    65: aload_0        
        //    66: getfield        android/support/v4/app/FragmentManagerImpl.mPendingActions:Ljava/util/ArrayList;
        //    69: astore          9
        //    71: aload           9
        //    73: iload           7
        //    75: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    78: astore          9
        //    80: aload           9
        //    82: checkcast       Landroid/support/v4/app/FragmentManagerImpl$OpGenerator;
        //    85: astore          9
        //    87: aload           9
        //    89: aload_1        
        //    90: aload_2        
        //    91: invokeinterface android/support/v4/app/FragmentManagerImpl$OpGenerator.generateOps:(Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
        //    96: pop            
        //    97: iload           7
        //    99: iconst_1       
        //   100: iadd           
        //   101: istore          7
        //   103: goto            58
        //   106: aload_0        
        //   107: getfield        android/support/v4/app/FragmentManagerImpl.mPendingActions:Ljava/util/ArrayList;
        //   110: astore          8
        //   112: aload           8
        //   114: invokevirtual   java/util/ArrayList.clear:()V
        //   117: aload_0        
        //   118: getfield        android/support/v4/app/FragmentManagerImpl.mHost:Landroid/support/v4/app/FragmentHostCallback;
        //   121: astore          8
        //   123: aload           8
        //   125: invokevirtual   android/support/v4/app/FragmentHostCallback.getHandler:()Landroid/os/Handler;
        //   128: astore          8
        //   130: aload_0        
        //   131: getfield        android/support/v4/app/FragmentManagerImpl.mExecCommit:Ljava/lang/Runnable;
        //   134: astore          9
        //   136: aload           8
        //   138: aload           9
        //   140: invokevirtual   android/os/Handler.removeCallbacks:(Ljava/lang/Runnable;)V
        //   143: aload_0        
        //   144: monitorexit    
        //   145: iload           6
        //   147: ifle            152
        //   150: iconst_1       
        //   151: istore_3       
        //   152: iload_3        
        //   153: ireturn        
        //   154: aload_0        
        //   155: monitorexit    
        //   156: iconst_0       
        //   157: ireturn        
        //   158: astore          10
        //   160: iconst_0       
        //   161: istore          6
        //   163: aconst_null    
        //   164: astore          5
        //   166: aload           10
        //   168: astore          4
        //   170: aload_0        
        //   171: monitorexit    
        //   172: aload           4
        //   174: athrow         
        //   175: astore          4
        //   177: goto            170
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      11     158    170    Any
        //  18     22     158    170    Any
        //  24     29     158    170    Any
        //  39     43     158    170    Any
        //  45     50     158    170    Any
        //  65     69     175    180    Any
        //  73     78     175    180    Any
        //  80     85     175    180    Any
        //  90     97     175    180    Any
        //  106    110    175    180    Any
        //  112    117    175    180    Any
        //  117    121    175    180    Any
        //  123    128    175    180    Any
        //  130    134    175    180    Any
        //  138    143    175    180    Any
        //  143    145    175    180    Any
        //  154    156    158    170    Any
        //  170    172    175    180    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Animation makeFadeAnimation(final Context context, final float n, final float n2) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n2);
        alphaAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        return (Animation)alphaAnimation;
    }
    
    static Animation makeOpenCloseAnimation(final Context context, final float n, final float n2, final float n3, final float n4) {
        final AnimationSet set = new AnimationSet(false);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(n, n2, n, n2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_QUINT);
        final long n5 = 220L;
        scaleAnimation.setDuration(n5);
        set.addAnimation((Animation)scaleAnimation);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n3, n4);
        alphaAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        alphaAnimation.setDuration(n5);
        set.addAnimation((Animation)alphaAnimation);
        return (Animation)set;
    }
    
    private void makeRemovedFragmentsInvisible(final ArraySet set) {
        for (int size = set.size(), i = 0; i < size; ++i) {
            final Fragment fragment = (Fragment)set.valueAt(i);
            if (!fragment.mAdded) {
                final View view = fragment.getView();
                if (Build$VERSION.SDK_INT < 11) {
                    fragment.getView().setVisibility(4);
                }
                else {
                    fragment.mPostponedAlpha = view.getAlpha();
                    view.setAlpha(0.0f);
                }
            }
        }
    }
    
    static boolean modifiesAlpha(final Animation animation) {
        final boolean b = animation instanceof AlphaAnimation;
        final boolean b2 = true;
        if (b) {
            return b2;
        }
        if (animation instanceof AnimationSet) {
            final List animations = ((AnimationSet)animation).getAnimations();
            for (int i = 0; i < animations.size(); ++i) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return b2;
                }
            }
        }
        return false;
    }
    
    private void optimizeAndExecuteOps(final ArrayList list, final ArrayList list2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list2 != null && list.size() == list2.size()) {
            this.executePostponedTransaction(list, list2);
            final int size = list.size();
            int n = 0;
            for (int i = 0; i < size; ++i) {
                if (!list.get(i).mAllowOptimization) {
                    if (n != i) {
                        this.executeOpsTogether(list, list2, n, i);
                    }
                    int j = i + 1;
                    if (list2.get(i)) {
                        while (j < size) {
                            if (!list2.get(j)) {
                                break;
                            }
                            if (list.get(j).mAllowOptimization) {
                                break;
                            }
                            ++j;
                        }
                    }
                    this.executeOpsTogether(list, list2, i, j);
                    n = j;
                    i = j - 1;
                }
            }
            if (n != size) {
                this.executeOpsTogether(list, list2, n, size);
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }
    
    private boolean popBackStackImmediate(final String s, final int n, final int n2) {
        this.execPendingActions();
        final boolean mExecutingActions = true;
        this.ensureExecReady(mExecutingActions);
        final boolean popBackStackState = this.popBackStackState(this.mTmpRecords, this.mTmpIsPop, s, n, n2);
        if (popBackStackState) {
            this.mExecutingActions = mExecutingActions;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.doPendingDeferredStart();
        this.burpActive();
        return popBackStackState;
    }
    
    private int postponePostponableTransactions(final ArrayList list, final ArrayList list2, final int n, final int n2, final ArraySet set) {
        int n3 = n2;
        for (int i = n2 - 1; i >= n; --i) {
            final BackStackRecord backStackRecord = list.get(i);
            final boolean booleanValue = list2.get(i);
            if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(list, i + 1, n2)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                final FragmentManagerImpl$StartEnterTransitionListener onStartPostponedListener = new FragmentManagerImpl$StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(onStartPostponedListener);
                backStackRecord.setOnStartPostponedListener(onStartPostponedListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                }
                else {
                    backStackRecord.executePopOps(false);
                }
                --n3;
                if (i != n3) {
                    list.remove(i);
                    list.add(n3, backStackRecord);
                }
                this.addAddedFragments(set);
            }
        }
        return n3;
    }
    
    public static int reverseTransit(final int n) {
        int n2 = 0;
        if (n != 4097) {
            if (n != 4099) {
                if (n == 8194) {
                    n2 = 4097;
                }
            }
            else {
                n2 = 4099;
            }
        }
        else {
            n2 = 8194;
        }
        return n2;
    }
    
    private void scheduleCommit() {
        synchronized (this) {
            final ArrayList mPostponedTransactions = this.mPostponedTransactions;
            boolean b = false;
            final boolean b2 = true;
            final boolean b3 = mPostponedTransactions != null && !this.mPostponedTransactions.isEmpty();
            if (this.mPendingActions != null && this.mPendingActions.size() == (b2 ? 1 : 0)) {
                b = true;
            }
            if (b3 || b) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }
    
    private void setHWLayerAnimListenerIfAlpha(final View view, final Animation animation) {
        if (view != null && animation != null) {
            if (shouldRunOnHWLayer(view, animation)) {
                Animation$AnimationListener animation$AnimationListener = null;
                try {
                    Label_0078: {
                        if (FragmentManagerImpl.sAnimationListenerField != null) {
                            break Label_0078;
                        }
                        final Field declaredField = Animation.class.getDeclaredField("mListener");
                        try {
                            (FragmentManagerImpl.sAnimationListenerField = declaredField).setAccessible(true);
                            final Object value = FragmentManagerImpl.sAnimationListenerField.get(animation);
                            try {
                                animation$AnimationListener = (Animation$AnimationListener)value;
                            }
                            catch (IllegalAccessException ex) {
                                Log.e("FragmentManager", "Cannot access Animation's mListener field", (Throwable)ex);
                            }
                            catch (NoSuchFieldException ex2) {
                                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", (Throwable)ex2);
                            }
                        }
                        catch (IllegalAccessException ex3) {}
                        catch (NoSuchFieldException ex4) {}
                    }
                }
                catch (IllegalAccessException ex5) {}
                catch (NoSuchFieldException ex6) {}
                ViewCompat.setLayerType(view, 2, null);
                animation.setAnimationListener((Animation$AnimationListener)new FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(view, animation, animation$AnimationListener));
            }
        }
    }
    
    static boolean shouldRunOnHWLayer(final View view, final Animation animation) {
        if (Build$VERSION.SDK_INT >= 19) {
            if (ViewCompat.getLayerType(view) == 0) {
                if (ViewCompat.hasOverlappingRendering(view)) {
                    if (modifiesAlpha(animation)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void throwException(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            final String s = "  ";
            try {
                mHost.onDump(s, null, printWriter, new String[0]);
            }
            catch (Exception ex2) {
                Log.e("FragmentManager", "Failed dumping state", (Throwable)ex2);
            }
        }
        else {
            final String s2 = "  ";
            try {
                this.dump(s2, null, printWriter, new String[0]);
            }
            catch (Exception ex3) {
                Log.e("FragmentManager", "Failed dumping state", (Throwable)ex3);
            }
        }
        throw ex;
    }
    
    public static int transitToStyleIndex(final int n, final boolean b) {
        int n2 = -1;
        if (n != 4097) {
            if (n != 4099) {
                if (n == 8194) {
                    int n3;
                    if (b) {
                        n3 = 3;
                    }
                    else {
                        n3 = 4;
                    }
                    n2 = n3;
                }
            }
            else {
                int n4;
                if (b) {
                    n4 = 5;
                }
                else {
                    n4 = 6;
                }
                n2 = n4;
            }
        }
        else {
            int n5;
            if (b) {
                n5 = 1;
            }
            else {
                n5 = 2;
            }
            n2 = n5;
        }
        return n2;
    }
    
    void addBackStackState(final BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }
    
    public void addFragment(final Fragment fragment, final boolean b) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList();
        }
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        this.makeActive(fragment);
        if (!fragment.mDetached) {
            if (!this.mAdded.contains(fragment)) {
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment);
                    // monitorexit(this.mAdded)
                    final boolean b2 = true;
                    fragment.mAdded = b2;
                    fragment.mRemoving = false;
                    if (fragment.mView == null) {
                        fragment.mHiddenChanged = false;
                    }
                    if (fragment.mHasMenu && fragment.mMenuVisible) {
                        this.mNeedMenuInvalidate = b2;
                    }
                    if (b) {
                        this.moveToState(fragment);
                    }
                    return;
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment already added: ");
            sb2.append(fragment);
            throw new IllegalStateException(sb2.toString());
        }
    }
    
    public void addOnBackStackChangedListener(final FragmentManager$OnBackStackChangedListener fragmentManager$OnBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(fragmentManager$OnBackStackChangedListener);
    }
    
    public int allocBackStackIndex(final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                final int intValue = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1);
                if (FragmentManagerImpl.DEBUG) {
                    final String s = "FragmentManager";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Adding back stack index ");
                    sb.append(intValue);
                    sb.append(" with ");
                    sb.append(backStackRecord);
                    Log.v(s, sb.toString());
                }
                this.mBackStackIndices.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            final int size = this.mBackStackIndices.size();
            if (FragmentManagerImpl.DEBUG) {
                final String s2 = "FragmentManager";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting back stack index ");
                sb2.append(size);
                sb2.append(" to ");
                sb2.append(backStackRecord);
                Log.v(s2, sb2.toString());
            }
            this.mBackStackIndices.add(backStackRecord);
            return size;
        }
    }
    
    public void attachController(final FragmentHostCallback mHost, final FragmentContainer mContainer, final Fragment mParent) {
        if (this.mHost == null) {
            this.mHost = mHost;
            this.mContainer = mContainer;
            this.mParent = mParent;
            return;
        }
        throw new IllegalStateException("Already attached");
    }
    
    public void attachFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList();
                }
                if (!this.mAdded.contains(fragment)) {
                    if (FragmentManagerImpl.DEBUG) {
                        final String s2 = "FragmentManager";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("add from attach: ");
                        sb2.append(fragment);
                        Log.v(s2, sb2.toString());
                    }
                    synchronized (this.mAdded) {
                        this.mAdded.add(fragment);
                        // monitorexit(this.mAdded)
                        final boolean b = true;
                        fragment.mAdded = b;
                        if (fragment.mHasMenu && fragment.mMenuVisible) {
                            this.mNeedMenuInvalidate = b;
                        }
                        return;
                    }
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Fragment already added: ");
                sb3.append(fragment);
                throw new IllegalStateException(sb3.toString());
            }
        }
    }
    
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }
    
    void completeShowHideFragment(final Fragment fragment) {
        final View mView = fragment.mView;
        final boolean mNeedMenuInvalidate = true;
        if (mView != null) {
            final Animation loadAnimation = this.loadAnimation(fragment, fragment.getNextTransition(), fragment.mHidden ^ mNeedMenuInvalidate, fragment.getNextTransitionStyle());
            if (loadAnimation != null) {
                this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                fragment.mView.startAnimation(loadAnimation);
                this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.start();
            }
            int visibility;
            if (fragment.mHidden && !fragment.isHideReplaced()) {
                visibility = 8;
            }
            else {
                visibility = 0;
            }
            fragment.mView.setVisibility(visibility);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = mNeedMenuInvalidate;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }
    
    public void detachFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        if (!fragment.mDetached) {
            final boolean b = true;
            fragment.mDetached = b;
            if (fragment.mAdded) {
                if (this.mAdded != null) {
                    if (FragmentManagerImpl.DEBUG) {
                        final String s2 = "FragmentManager";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("remove from detach: ");
                        sb2.append(fragment);
                        Log.v(s2, sb2.toString());
                    }
                    synchronized (this.mAdded) {
                        this.mAdded.remove(fragment);
                    }
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = b;
                }
                fragment.mAdded = false;
            }
        }
    }
    
    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchConfigurationChanged(final Configuration configuration) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }
    
    public boolean dispatchContextItemSelected(final MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchCreate() {
        this.mStateSaved = false;
        this.moveToState((this.mExecutingActions = true) ? 1 : 0, false);
        this.mExecutingActions = false;
    }
    
    public boolean dispatchCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        boolean b = false;
        ArrayList<Fragment> mCreatedMenus = null;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    if (fragment.performCreateOptionsMenu(menu, menuInflater)) {
                        b = true;
                        if (mCreatedMenus == null) {
                            mCreatedMenus = new ArrayList<Fragment>();
                        }
                        mCreatedMenus.add(fragment);
                    }
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int j = 0; j < this.mCreatedMenus.size(); ++j) {
                final Fragment fragment2 = this.mCreatedMenus.get(j);
                if (mCreatedMenus == null || mCreatedMenus.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = mCreatedMenus;
        return b;
    }
    
    public void dispatchDestroy() {
        final boolean b = true;
        this.mDestroyed = b;
        this.execPendingActions();
        this.mExecutingActions = b;
        this.moveToState(0, false);
        this.mExecutingActions = false;
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }
    
    public void dispatchDestroyView() {
        this.moveToState((this.mExecutingActions = true) ? 1 : 0, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchLowMemory() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }
    
    public void dispatchMultiWindowModeChanged(final boolean b) {
        final ArrayList mAdded = this.mAdded;
        if (mAdded == null) {
            return;
        }
        for (int i = mAdded.size() - 1; i >= 0; --i) {
            final Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(b);
            }
        }
    }
    
    void dispatchOnFragmentActivityCreated(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentActivityCreated(this, fragment, bundle);
        }
    }
    
    void dispatchOnFragmentAttached(final Fragment fragment, final Context context, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentAttached(this, fragment, context);
        }
    }
    
    void dispatchOnFragmentCreated(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentCreated(this, fragment, bundle);
        }
    }
    
    void dispatchOnFragmentDestroyed(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentDestroyed(this, fragment);
        }
    }
    
    void dispatchOnFragmentDetached(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentDetached(this, fragment);
        }
    }
    
    void dispatchOnFragmentPaused(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentPaused(this, fragment);
        }
    }
    
    void dispatchOnFragmentPreAttached(final Fragment fragment, final Context context, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentPreAttached(this, fragment, context);
        }
    }
    
    void dispatchOnFragmentResumed(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentResumed(this, fragment);
        }
    }
    
    void dispatchOnFragmentSaveInstanceState(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentSaveInstanceState(this, fragment, bundle);
        }
    }
    
    void dispatchOnFragmentStarted(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentStarted(this, fragment);
        }
    }
    
    void dispatchOnFragmentStopped(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentStopped(this, fragment);
        }
    }
    
    void dispatchOnFragmentViewCreated(final Fragment fragment, final View view, final Bundle bundle, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentViewCreated(this, fragment, view, bundle);
        }
    }
    
    void dispatchOnFragmentViewDestroyed(final Fragment fragment, final boolean b) {
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            final FragmentManager fragmentManager = mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        for (final Pair pair : mLifecycleCallbacks) {
            if (b && !(boolean)pair.second) {
                continue;
            }
            ((FragmentManager$FragmentLifecycleCallbacks)pair.first).onFragmentViewDestroyed(this, fragment);
        }
    }
    
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchOptionsMenuClosed(final Menu menu) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }
    
    public void dispatchPause() {
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchPictureInPictureModeChanged(final boolean b) {
        final ArrayList mAdded = this.mAdded;
        if (mAdded == null) {
            return;
        }
        for (int i = mAdded.size() - 1; i >= 0; --i) {
            final Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(b);
            }
        }
    }
    
    public boolean dispatchPrepareOptionsMenu(final Menu menu) {
        boolean b = false;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    if (fragment.performPrepareOptionsMenu(menu)) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    public void dispatchReallyStop() {
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchResume() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(5, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchStart() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchStop() {
        final boolean b = true;
        this.mStateSaved = b;
        this.mExecutingActions = b;
        this.moveToState(3, false);
        this.mExecutingActions = false;
    }
    
    void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            boolean b = false;
            for (int i = 0; i < this.mActive.size(); ++i) {
                final Fragment fragment = (Fragment)this.mActive.valueAt(i);
                if (fragment != null && fragment.mLoaderManager != null) {
                    b |= fragment.mLoaderManager.hasRunningLoaders();
                }
            }
            if (!b) {
                this.mHavePendingDeferredStart = false;
                this.startPendingDeferredFragments();
            }
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("    ");
        final String string = sb.toString();
        final SparseArray mActive = this.mActive;
        if (mActive != null) {
            final int size = mActive.size();
            if (size > 0) {
                printWriter.print(s);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i = 0; i < size; ++i) {
                    final Fragment fragment = (Fragment)this.mActive.valueAt(i);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(string, fileDescriptor, printWriter, array);
                    }
                }
            }
        }
        final ArrayList mAdded = this.mAdded;
        if (mAdded != null) {
            final int size2 = mAdded.size();
            if (size2 > 0) {
                printWriter.print(s);
                printWriter.println("Added Fragments:");
                for (int j = 0; j < size2; ++j) {
                    final Fragment fragment2 = this.mAdded.get(j);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(j);
                    printWriter.print(": ");
                    printWriter.println(fragment2.toString());
                }
            }
        }
        final ArrayList mCreatedMenus = this.mCreatedMenus;
        if (mCreatedMenus != null) {
            final int size3 = mCreatedMenus.size();
            if (size3 > 0) {
                printWriter.print(s);
                printWriter.println("Fragments Created Menus:");
                for (int k = 0; k < size3; ++k) {
                    final Fragment fragment3 = this.mCreatedMenus.get(k);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(k);
                    printWriter.print(": ");
                    printWriter.println(fragment3.toString());
                }
            }
        }
        final ArrayList mBackStack = this.mBackStack;
        if (mBackStack != null) {
            final int size4 = mBackStack.size();
            if (size4 > 0) {
                printWriter.print(s);
                printWriter.println("Back Stack:");
                for (int l = 0; l < size4; ++l) {
                    final BackStackRecord backStackRecord = this.mBackStack.get(l);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(l);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(string, fileDescriptor, printWriter, array);
                }
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null) {
                final int size5 = this.mBackStackIndices.size();
                if (size5 > 0) {
                    printWriter.print(s);
                    printWriter.println("Back Stack Indices:");
                    for (int n = 0; n < size5; ++n) {
                        final BackStackRecord backStackRecord2 = this.mBackStackIndices.get(n);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(s);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
            // monitorexit(this)
            final ArrayList mPendingActions = this.mPendingActions;
            if (mPendingActions != null) {
                final int size6 = mPendingActions.size();
                if (size6 > 0) {
                    printWriter.print(s);
                    printWriter.println("Pending Actions:");
                    for (int n2 = 0; n2 < size6; ++n2) {
                        final FragmentManagerImpl$OpGenerator fragmentManagerImpl$OpGenerator = this.mPendingActions.get(n2);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n2);
                        printWriter.print(": ");
                        printWriter.println(fragmentManagerImpl$OpGenerator);
                    }
                }
            }
            printWriter.print(s);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(s);
            printWriter.print("  mHost=");
            printWriter.println(this.mHost);
            printWriter.print(s);
            printWriter.print("  mContainer=");
            printWriter.println(this.mContainer);
            if (this.mParent != null) {
                printWriter.print(s);
                printWriter.print("  mParent=");
                printWriter.println(this.mParent);
            }
            printWriter.print(s);
            printWriter.print("  mCurState=");
            printWriter.print(this.mCurState);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.mStateSaved);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            if (this.mNeedMenuInvalidate) {
                printWriter.print(s);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.mNeedMenuInvalidate);
            }
            if (this.mNoTransactionsBecause != null) {
                printWriter.print(s);
                printWriter.print("  mNoTransactionsBecause=");
                printWriter.println(this.mNoTransactionsBecause);
            }
        }
    }
    
    public void enqueueAction(final FragmentManagerImpl$OpGenerator fragmentManagerImpl$OpGenerator, final boolean b) {
        if (!b) {
            this.checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed && this.mHost != null) {
                if (this.mPendingActions == null) {
                    this.mPendingActions = new ArrayList();
                }
                this.mPendingActions.add(fragmentManagerImpl$OpGenerator);
                this.scheduleCommit();
                return;
            }
            if (b) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }
    
    public boolean execPendingActions() {
        final boolean mExecutingActions = true;
        this.ensureExecReady(mExecutingActions);
        boolean b = false;
        while (this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = mExecutingActions;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
                this.cleanupExec();
                b = true;
                continue;
            }
            finally {
                this.cleanupExec();
            }
            break;
        }
        this.doPendingDeferredStart();
        this.burpActive();
        return b;
    }
    
    public void execSingleAction(final FragmentManagerImpl$OpGenerator fragmentManagerImpl$OpGenerator, final boolean b) {
        if (b && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        this.ensureExecReady(b);
        if (fragmentManagerImpl$OpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.doPendingDeferredStart();
        this.burpActive();
    }
    
    public boolean executePendingTransactions() {
        final boolean execPendingActions = this.execPendingActions();
        this.forcePostponedTransactions();
        return execPendingActions;
    }
    
    public Fragment findFragmentById(final int n) {
        final ArrayList mAdded = this.mAdded;
        if (mAdded != null) {
            for (int i = mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.mFragmentId == n) {
                    return fragment;
                }
            }
        }
        final SparseArray mActive = this.mActive;
        if (mActive != null) {
            for (int j = mActive.size() - 1; j >= 0; --j) {
                final Fragment fragment2 = (Fragment)this.mActive.valueAt(j);
                if (fragment2 != null && fragment2.mFragmentId == n) {
                    return fragment2;
                }
            }
        }
        return null;
    }
    
    public Fragment findFragmentByTag(final String s) {
        final ArrayList mAdded = this.mAdded;
        if (mAdded != null && s != null) {
            for (int i = mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        final SparseArray mActive = this.mActive;
        if (mActive != null && s != null) {
            for (int j = mActive.size() - 1; j >= 0; --j) {
                final Fragment fragment2 = (Fragment)this.mActive.valueAt(j);
                if (fragment2 != null && s.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }
    
    public Fragment findFragmentByWho(final String s) {
        final SparseArray mActive = this.mActive;
        if (mActive != null && s != null) {
            for (int i = mActive.size() - 1; i >= 0; --i) {
                final Fragment fragment = (Fragment)this.mActive.valueAt(i);
                if (fragment != null) {
                    final Fragment fragmentByWho = fragment.findFragmentByWho(s);
                    final Fragment fragment2;
                    if ((fragment2 = fragmentByWho) != null) {
                        return fragmentByWho;
                    }
                }
            }
        }
        return null;
    }
    
    public void freeBackStackIndex(final int n) {
        synchronized (this) {
            this.mBackStackIndices.set(n, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            if (FragmentManagerImpl.DEBUG) {
                final String s = "FragmentManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Freeing back stack index ");
                sb.append(n);
                Log.v(s, sb.toString());
            }
            this.mAvailBackStackIndices.add(n);
        }
    }
    
    int getActiveFragmentCount() {
        final SparseArray mActive = this.mActive;
        if (mActive == null) {
            return 0;
        }
        return mActive.size();
    }
    
    List getActiveFragments() {
        final SparseArray mActive = this.mActive;
        if (mActive == null) {
            return null;
        }
        final int size = mActive.size();
        final ArrayList list = new ArrayList<Object>(size);
        for (int i = 0; i < size; ++i) {
            list.add(this.mActive.valueAt(i));
        }
        return list;
    }
    
    public FragmentManager$BackStackEntry getBackStackEntryAt(final int n) {
        return this.mBackStack.get(n);
    }
    
    public int getBackStackEntryCount() {
        final ArrayList mBackStack = this.mBackStack;
        int size;
        if (mBackStack != null) {
            size = mBackStack.size();
        }
        else {
            size = 0;
        }
        return size;
    }
    
    public Fragment getFragment(final Bundle bundle, final String s) {
        final int n = -1;
        final int int1 = bundle.getInt(s, n);
        if (int1 == n) {
            return null;
        }
        final Fragment fragment = (Fragment)this.mActive.get(int1);
        if (fragment == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment no longer exists for key ");
            sb.append(s);
            sb.append(": index ");
            sb.append(int1);
            this.throwException(new IllegalStateException(sb.toString()));
        }
        return fragment;
    }
    
    public List getFragments() {
        final ArrayList mAdded = this.mAdded;
        if (mAdded == null) {
            return Collections.EMPTY_LIST;
        }
        synchronized (mAdded) {
            return (List)this.mAdded.clone();
        }
    }
    
    LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }
    
    public void hideFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        if (!fragment.mHidden) {
            final boolean mHidden = true;
            fragment.mHidden = mHidden;
            fragment.mHiddenChanged ^= mHidden;
        }
    }
    
    public boolean isDestroyed() {
        return this.mDestroyed;
    }
    
    boolean isStateAtLeast(final int n) {
        return this.mCurState >= n;
    }
    
    Animation loadAnimation(final Fragment fragment, final int n, final boolean b, int onGetWindowAnimations) {
        final Animation onCreateAnimation = fragment.onCreateAnimation(n, b, fragment.getNextAnim());
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.getNextAnim() != 0) {
            final Animation loadAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment.getNextAnim());
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (n == 0) {
            return null;
        }
        final int transitToStyleIndex = transitToStyleIndex(n, b);
        if (transitToStyleIndex < 0) {
            return null;
        }
        final float n2 = 0.975f;
        final float n3 = 1.0f;
        switch (transitToStyleIndex) {
            default: {
                if (onGetWindowAnimations == 0 && this.mHost.onHasWindowAnimations()) {
                    onGetWindowAnimations = this.mHost.onGetWindowAnimations();
                }
                if (onGetWindowAnimations == 0) {
                    return null;
                }
                return null;
            }
            case 6: {
                return makeFadeAnimation(this.mHost.getContext(), n3, 0.0f);
            }
            case 5: {
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, n3);
            }
            case 4: {
                return makeOpenCloseAnimation(this.mHost.getContext(), n3, 1.075f, n3, 0.0f);
            }
            case 3: {
                return makeOpenCloseAnimation(this.mHost.getContext(), n2, n3, 0.0f, n3);
            }
            case 2: {
                return makeOpenCloseAnimation(this.mHost.getContext(), n3, n2, n3, 0.0f);
            }
            case 1: {
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, n3, 0.0f, n3);
            }
        }
    }
    
    void makeActive(final Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        fragment.setIndex(this.mNextFragmentIndex++, this.mParent);
        if (this.mActive == null) {
            this.mActive = new SparseArray();
        }
        this.mActive.put(fragment.mIndex, (Object)fragment);
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Allocated fragment index ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
    }
    
    void makeInactive(final Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Freeing fragment index ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        this.mActive.put(fragment.mIndex, (Object)null);
        this.mHost.inactivateFragment(fragment.mWho);
        fragment.initState();
    }
    
    void moveFragmentToExpectedState(final Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int n = this.mCurState;
        final boolean mRemoving = fragment.mRemoving;
        final int n2 = 1;
        if (mRemoving) {
            if (fragment.isInBackStack()) {
                n = Math.min(n, n2);
            }
            else {
                n = Math.min(n, 0);
            }
        }
        this.moveToState(fragment, n, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            final Fragment fragmentUnder = this.findFragmentUnder(fragment);
            if (fragmentUnder != null) {
                final View mView = fragmentUnder.mView;
                final ViewGroup mContainer = fragment.mContainer;
                final int indexOfChild = mContainer.indexOfChild(mView);
                final int indexOfChild2 = mContainer.indexOfChild(fragment.mView);
                if (indexOfChild2 < indexOfChild) {
                    mContainer.removeViewAt(indexOfChild2);
                    mContainer.addView(fragment.mView, indexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                if (Build$VERSION.SDK_INT < 11) {
                    fragment.mView.setVisibility(0);
                }
                else if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                final Animation loadAnimation = this.loadAnimation(fragment, fragment.getNextTransition(), n2 != 0, fragment.getNextTransitionStyle());
                if (loadAnimation != null) {
                    this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation);
                }
            }
        }
        if (fragment.mHiddenChanged) {
            this.completeShowHideFragment(fragment);
        }
    }
    
    void moveToState(final int mCurState, final boolean b) {
        if (this.mHost == null && mCurState != 0) {
            throw new IllegalStateException("No activity");
        }
        if (!b && mCurState == this.mCurState) {
            return;
        }
        this.mCurState = mCurState;
        if (this.mActive != null) {
            boolean b2 = false;
            final ArrayList mAdded = this.mAdded;
            if (mAdded != null) {
                for (int size = mAdded.size(), i = 0; i < size; ++i) {
                    final Fragment fragment = this.mAdded.get(i);
                    this.moveFragmentToExpectedState(fragment);
                    if (fragment.mLoaderManager != null) {
                        b2 |= fragment.mLoaderManager.hasRunningLoaders();
                    }
                }
            }
            for (int size2 = this.mActive.size(), j = 0; j < size2; ++j) {
                final Fragment fragment2 = (Fragment)this.mActive.valueAt(j);
                if (fragment2 != null && (fragment2.mRemoving || fragment2.mDetached) && !fragment2.mIsNewlyAdded) {
                    this.moveFragmentToExpectedState(fragment2);
                    if (fragment2.mLoaderManager != null) {
                        b2 |= fragment2.mLoaderManager.hasRunningLoaders();
                    }
                }
            }
            if (!b2) {
                this.startPendingDeferredFragments();
            }
            if (this.mNeedMenuInvalidate) {
                final FragmentHostCallback mHost = this.mHost;
                if (mHost != null && this.mCurState == 5) {
                    mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }
    
    void moveToState(final Fragment fragment) {
        this.moveToState(fragment, this.mCurState, 0, 0, false);
    }
    
    void moveToState(final Fragment fragment, final int n, final int n2, final int n3, final boolean b) {
        final boolean mAdded = fragment.mAdded;
        int mIsNewlyAdded = 1;
        int mState;
        if (mAdded && !fragment.mDetached) {
            mState = n;
        }
        else if ((mState = n) > mIsNewlyAdded) {
            mState = 1;
        }
        if (fragment.mRemoving && mState > fragment.mState) {
            if (fragment.mState == 0 && fragment.isInBackStack()) {
                mState = 1;
            }
            else {
                mState = fragment.mState;
            }
        }
        final boolean mDeferStart = fragment.mDeferStart;
        final int n4 = 4;
        final int mState2 = 3;
        if (mDeferStart && fragment.mState < n4 && mState > mState2) {
            mState = 3;
        }
        final int mState3 = fragment.mState;
        final int n5 = 2;
        Label_3029: {
            if (mState3 < mState) {
                if (fragment.mFromLayout && !fragment.mInLayout) {
                    return;
                }
                if (fragment.getAnimatingAway() != null) {
                    fragment.setAnimatingAway(null);
                    this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
                }
                final int mState4 = fragment.mState;
                final int n6 = 8;
                final int n7 = 11;
                Label_2037: {
                    Label_1882: {
                        Label_1800: {
                            Label_1783: {
                                int n8 = 0;
                                switch (mState4) {
                                    default: {
                                        break Label_2037;
                                    }
                                    case 4: {
                                        break Label_1882;
                                    }
                                    case 3: {
                                        break Label_1800;
                                    }
                                    case 2: {
                                        break Label_1783;
                                    }
                                    case 1: {
                                        n8 = mState;
                                        break;
                                    }
                                    case 0: {
                                        if (FragmentManagerImpl.DEBUG) {
                                            final String s = "FragmentManager";
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append("moveto CREATED: ");
                                            sb.append(fragment);
                                            Log.v(s, sb.toString());
                                        }
                                        if (fragment.mSavedFragmentState != null) {
                                            fragment.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                                            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                                            fragment.mTarget = this.getFragment(fragment.mSavedFragmentState, "android:target_state");
                                            if (fragment.mTarget != null) {
                                                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                                            }
                                            if (!(fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", (boolean)(mIsNewlyAdded != 0)))) {
                                                fragment.mDeferStart = (mIsNewlyAdded != 0);
                                                if (mState > mState2) {
                                                    mState = 3;
                                                }
                                            }
                                        }
                                        final FragmentHostCallback mHost = this.mHost;
                                        fragment.mHost = mHost;
                                        final Fragment mParent = this.mParent;
                                        FragmentManagerImpl mFragmentManager;
                                        if ((fragment.mParentFragment = mParent) != null) {
                                            mFragmentManager = mParent.mChildFragmentManager;
                                        }
                                        else {
                                            mFragmentManager = mHost.getFragmentManagerImpl();
                                        }
                                        fragment.mFragmentManager = mFragmentManager;
                                        this.dispatchOnFragmentPreAttached(fragment, this.mHost.getContext(), false);
                                        fragment.mCalled = false;
                                        fragment.onAttach(this.mHost.getContext());
                                        if (fragment.mCalled) {
                                            if (fragment.mParentFragment == null) {
                                                this.mHost.onAttachFragment(fragment);
                                            }
                                            else {
                                                fragment.mParentFragment.onAttachFragment(fragment);
                                            }
                                            this.dispatchOnFragmentAttached(fragment, this.mHost.getContext(), false);
                                            if (!fragment.mRetaining) {
                                                fragment.performCreate(fragment.mSavedFragmentState);
                                                this.dispatchOnFragmentCreated(fragment, fragment.mSavedFragmentState, false);
                                            }
                                            else {
                                                fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                                                fragment.mState = mIsNewlyAdded;
                                            }
                                            fragment.mRetaining = false;
                                            if (fragment.mFromLayout) {
                                                fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
                                                if (fragment.mView != null) {
                                                    fragment.mInnerView = fragment.mView;
                                                    if (Build$VERSION.SDK_INT >= n7) {
                                                        ViewCompat.setSaveFromParentEnabled(fragment.mView, false);
                                                    }
                                                    else {
                                                        fragment.mView = (View)NoSaveStateFrameLayout.wrap(fragment.mView);
                                                    }
                                                    if (fragment.mHidden) {
                                                        fragment.mView.setVisibility(n6);
                                                    }
                                                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                                    this.dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                                                }
                                                else {
                                                    fragment.mInnerView = null;
                                                }
                                            }
                                            n8 = mState;
                                            break;
                                        }
                                        final StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Fragment ");
                                        sb2.append(fragment);
                                        sb2.append(" did not call through to super.onAttach()");
                                        throw new SuperNotCalledException(sb2.toString());
                                    }
                                }
                                if (n8 > mIsNewlyAdded) {
                                    if (FragmentManagerImpl.DEBUG) {
                                        final String s2 = "FragmentManager";
                                        final StringBuilder sb3 = new StringBuilder();
                                        sb3.append("moveto ACTIVITY_CREATED: ");
                                        sb3.append(fragment);
                                        Log.v(s2, sb3.toString());
                                    }
                                    if (!fragment.mFromLayout) {
                                        ViewGroup mContainer = null;
                                        if (fragment.mContainerId != 0) {
                                            if (fragment.mContainerId == -1) {
                                                final StringBuilder sb4 = new StringBuilder();
                                                sb4.append("Cannot create fragment ");
                                                sb4.append(fragment);
                                                sb4.append(" for a container view with no id");
                                                this.throwException(new IllegalArgumentException(sb4.toString()));
                                            }
                                            final ViewGroup viewGroup = (ViewGroup)this.mContainer.onFindViewById(fragment.mContainerId);
                                            if (viewGroup == null && !fragment.mRestored) {
                                                String resourceName = null;
                                                try {
                                                    final Resources resources = fragment.getResources();
                                                    try {
                                                        resourceName = resources.getResourceName(fragment.mContainerId);
                                                    }
                                                    catch (Resources$NotFoundException ex) {
                                                        resourceName = "unknown";
                                                    }
                                                }
                                                catch (Resources$NotFoundException ex2) {}
                                                final StringBuilder sb5 = new StringBuilder();
                                                sb5.append("No view found for id 0x");
                                                sb5.append(Integer.toHexString(fragment.mContainerId));
                                                sb5.append(" (");
                                                sb5.append(resourceName);
                                                sb5.append(") for fragment ");
                                                sb5.append(fragment);
                                                this.throwException(new IllegalArgumentException(sb5.toString()));
                                            }
                                            mContainer = viewGroup;
                                        }
                                        fragment.mContainer = mContainer;
                                        fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), mContainer, fragment.mSavedFragmentState);
                                        if (fragment.mView != null) {
                                            fragment.mInnerView = fragment.mView;
                                            if (Build$VERSION.SDK_INT >= n7) {
                                                ViewCompat.setSaveFromParentEnabled(fragment.mView, false);
                                            }
                                            else {
                                                fragment.mView = (View)NoSaveStateFrameLayout.wrap(fragment.mView);
                                            }
                                            if (mContainer != null) {
                                                mContainer.addView(fragment.mView);
                                            }
                                            if (fragment.mHidden) {
                                                fragment.mView.setVisibility(n6);
                                            }
                                            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                            this.dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                                            if (fragment.mView.getVisibility() != 0 || fragment.mContainer == null) {
                                                mIsNewlyAdded = 0;
                                            }
                                            fragment.mIsNewlyAdded = (mIsNewlyAdded != 0);
                                        }
                                        else {
                                            fragment.mInnerView = null;
                                        }
                                    }
                                    fragment.performActivityCreated(fragment.mSavedFragmentState);
                                    this.dispatchOnFragmentActivityCreated(fragment, fragment.mSavedFragmentState, false);
                                    if (fragment.mView != null) {
                                        fragment.restoreViewState(fragment.mSavedFragmentState);
                                    }
                                    fragment.mSavedFragmentState = null;
                                }
                                mState = n8;
                            }
                            if (mState > n5) {
                                fragment.mState = mState2;
                            }
                        }
                        if (mState > mState2) {
                            if (FragmentManagerImpl.DEBUG) {
                                final String s3 = "FragmentManager";
                                final StringBuilder sb6 = new StringBuilder();
                                sb6.append("moveto STARTED: ");
                                sb6.append(fragment);
                                Log.v(s3, sb6.toString());
                            }
                            fragment.performStart();
                            this.dispatchOnFragmentStarted(fragment, false);
                        }
                    }
                    if (mState > n4) {
                        if (FragmentManagerImpl.DEBUG) {
                            final String s4 = "FragmentManager";
                            final StringBuilder sb7 = new StringBuilder();
                            sb7.append("moveto RESUMED: ");
                            sb7.append(fragment);
                            Log.v(s4, sb7.toString());
                        }
                        fragment.performResume();
                        this.dispatchOnFragmentResumed(fragment, false);
                        fragment.mSavedFragmentState = null;
                        fragment.mSavedViewState = null;
                    }
                }
            }
            else if (fragment.mState > mState) {
                switch (fragment.mState) {
                    default: {
                        break Label_3029;
                    }
                    case 5: {
                        if (mState < 5) {
                            if (FragmentManagerImpl.DEBUG) {
                                final String s5 = "FragmentManager";
                                final StringBuilder sb8 = new StringBuilder();
                                sb8.append("movefrom RESUMED: ");
                                sb8.append(fragment);
                                Log.v(s5, sb8.toString());
                            }
                            fragment.performPause();
                            this.dispatchOnFragmentPaused(fragment, false);
                        }
                    }
                    case 4: {
                        if (mState < n4) {
                            if (FragmentManagerImpl.DEBUG) {
                                final String s6 = "FragmentManager";
                                final StringBuilder sb9 = new StringBuilder();
                                sb9.append("movefrom STARTED: ");
                                sb9.append(fragment);
                                Log.v(s6, sb9.toString());
                            }
                            fragment.performStop();
                            this.dispatchOnFragmentStopped(fragment, false);
                        }
                    }
                    case 3: {
                        if (mState < mState2) {
                            if (FragmentManagerImpl.DEBUG) {
                                final String s7 = "FragmentManager";
                                final StringBuilder sb10 = new StringBuilder();
                                sb10.append("movefrom STOPPED: ");
                                sb10.append(fragment);
                                Log.v(s7, sb10.toString());
                            }
                            fragment.performReallyStop();
                        }
                    }
                    case 2: {
                        if (mState < n5) {
                            if (FragmentManagerImpl.DEBUG) {
                                final String s8 = "FragmentManager";
                                final StringBuilder sb11 = new StringBuilder();
                                sb11.append("movefrom ACTIVITY_CREATED: ");
                                sb11.append(fragment);
                                Log.v(s8, sb11.toString());
                            }
                            if (fragment.mView != null) {
                                if (this.mHost.onShouldSaveFragmentState(fragment) && fragment.mSavedViewState == null) {
                                    this.saveFragmentViewState(fragment);
                                }
                            }
                            fragment.performDestroyView();
                            this.dispatchOnFragmentViewDestroyed(fragment, false);
                            if (fragment.mView != null && fragment.mContainer != null) {
                                Animation loadAnimation = null;
                                if (this.mCurState > 0 && !this.mDestroyed) {
                                    if (fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                        loadAnimation = this.loadAnimation(fragment, n2, false, n3);
                                    }
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                if (loadAnimation != null) {
                                    fragment.setAnimatingAway(fragment.mView);
                                    fragment.setStateAfterAnimating(mState);
                                    loadAnimation.setAnimationListener((Animation$AnimationListener)new FragmentManagerImpl$2(this, fragment.mView, loadAnimation, fragment));
                                    fragment.mView.startAnimation(loadAnimation);
                                }
                                fragment.mContainer.removeView(fragment.mView);
                            }
                            fragment.mContainer = null;
                            fragment.mView = null;
                            fragment.mInnerView = null;
                            break;
                        }
                        break;
                    }
                    case 1: {
                        break;
                    }
                }
                if (mState < mIsNewlyAdded) {
                    if (this.mDestroyed) {
                        if (fragment.getAnimatingAway() != null) {
                            final View animatingAway = fragment.getAnimatingAway();
                            fragment.setAnimatingAway(null);
                            animatingAway.clearAnimation();
                        }
                    }
                    if (fragment.getAnimatingAway() != null) {
                        fragment.setStateAfterAnimating(mState);
                        mState = 1;
                    }
                    else {
                        if (FragmentManagerImpl.DEBUG) {
                            final String s9 = "FragmentManager";
                            final StringBuilder sb12 = new StringBuilder();
                            sb12.append("movefrom CREATED: ");
                            sb12.append(fragment);
                            Log.v(s9, sb12.toString());
                        }
                        if (!fragment.mRetaining) {
                            fragment.performDestroy();
                            this.dispatchOnFragmentDestroyed(fragment, false);
                        }
                        else {
                            fragment.mState = 0;
                        }
                        fragment.performDetach();
                        this.dispatchOnFragmentDetached(fragment, false);
                        if (!b) {
                            if (!fragment.mRetaining) {
                                this.makeInactive(fragment);
                            }
                            else {
                                fragment.mHost = null;
                                fragment.mParentFragment = null;
                                fragment.mFragmentManager = null;
                            }
                        }
                    }
                }
            }
        }
        if (fragment.mState != mState) {
            final String s10 = "FragmentManager";
            final StringBuilder sb13 = new StringBuilder();
            sb13.append("moveToState: Fragment state for ");
            sb13.append(fragment);
            sb13.append(" not updated inline; ");
            sb13.append("expected state ");
            sb13.append(mState);
            sb13.append(" found ");
            sb13.append(fragment.mState);
            Log.w(s10, sb13.toString());
            fragment.mState = mState;
        }
    }
    
    public void noteStateNotSaved() {
        int size = 0;
        this.mStateSaved = false;
        final ArrayList mAdded = this.mAdded;
        if (mAdded != null) {
            size = mAdded.size();
        }
        for (int i = 0; i < size; ++i) {
            final Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }
    
    public View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        final boolean equals = "fragment".equals(s);
        Fragment fragment = null;
        if (!equals) {
            return null;
        }
        final String attributeValue = set.getAttributeValue((String)null, "class");
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, FragmentManagerImpl$FragmentTag.Fragment);
        int id = 0;
        String string;
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        }
        else {
            string = attributeValue;
        }
        final int n = -1;
        final int mInLayout = 1;
        final int resourceId = obtainStyledAttributes.getResourceId(mInLayout, n);
        final String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), string)) {
            return null;
        }
        if (view != null) {
            id = view.getId();
        }
        final int mContainerId = id;
        if (id == n && resourceId == n && string2 == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(set.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(string);
            throw new IllegalArgumentException(sb.toString());
        }
        if (resourceId != n) {
            fragment = this.findFragmentById(resourceId);
        }
        if (fragment == null && string2 != null) {
            fragment = this.findFragmentByTag(string2);
        }
        if (fragment == null && mContainerId != n) {
            fragment = this.findFragmentById(mContainerId);
        }
        if (FragmentManagerImpl.DEBUG) {
            final String s2 = "FragmentManager";
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateView: id=0x");
            sb2.append(Integer.toHexString(resourceId));
            sb2.append(" fname=");
            sb2.append(string);
            sb2.append(" existing=");
            sb2.append(fragment);
            Log.v(s2, sb2.toString());
        }
        Fragment fragment2;
        if (fragment == null) {
            final Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = (mInLayout != 0);
            int mFragmentId;
            if (resourceId != 0) {
                mFragmentId = resourceId;
            }
            else {
                mFragmentId = mContainerId;
            }
            instantiate.mFragmentId = mFragmentId;
            instantiate.mContainerId = mContainerId;
            instantiate.mTag = string2;
            instantiate.mInLayout = (mInLayout != 0);
            instantiate.mFragmentManager = this;
            final FragmentHostCallback mHost = this.mHost;
            instantiate.mHost = mHost;
            instantiate.onInflate(mHost.getContext(), set, instantiate.mSavedFragmentState);
            this.addFragment(instantiate, mInLayout != 0);
            fragment2 = instantiate;
        }
        else {
            if (fragment.mInLayout) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(set.getPositionDescription());
                sb3.append(": Duplicate id 0x");
                sb3.append(Integer.toHexString(resourceId));
                sb3.append(", tag ");
                sb3.append(string2);
                sb3.append(", or parent id 0x");
                sb3.append(Integer.toHexString(mContainerId));
                sb3.append(" with another fragment for ");
                sb3.append(string);
                throw new IllegalArgumentException(sb3.toString());
            }
            fragment.mInLayout = (mInLayout != 0);
            fragment.mHost = this.mHost;
            if (!fragment.mRetaining) {
                fragment.onInflate(this.mHost.getContext(), set, fragment.mSavedFragmentState);
            }
            fragment2 = fragment;
        }
        if (this.mCurState < mInLayout && fragment2.mFromLayout) {
            this.moveToState(fragment2, 1, 0, 0, false);
        }
        else {
            this.moveToState(fragment2);
        }
        if (fragment2.mView != null) {
            if (resourceId != 0) {
                fragment2.mView.setId(resourceId);
            }
            if (fragment2.mView.getTag() == null) {
                fragment2.mView.setTag((Object)string2);
            }
            return fragment2.mView;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(string);
        sb4.append(" did not create a view.");
        throw new IllegalStateException(sb4.toString());
    }
    
    public void performPendingDeferredStart(final Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            this.moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }
    
    public void popBackStack() {
        this.enqueueAction(new FragmentManagerImpl$PopBackStackState(this, null, -1, 0), false);
    }
    
    public void popBackStack(final int n, final int n2) {
        if (n >= 0) {
            this.enqueueAction(new FragmentManagerImpl$PopBackStackState(this, null, n, n2), false);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void popBackStack(final String s, final int n) {
        this.enqueueAction(new FragmentManagerImpl$PopBackStackState(this, s, -1, n), false);
    }
    
    public boolean popBackStackImmediate() {
        this.checkStateLoss();
        return this.popBackStackImmediate(null, -1, 0);
    }
    
    public boolean popBackStackImmediate(final int n, final int n2) {
        this.checkStateLoss();
        this.execPendingActions();
        if (n >= 0) {
            return this.popBackStackImmediate(null, n, n2);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean popBackStackImmediate(final String s, final int n) {
        this.checkStateLoss();
        return this.popBackStackImmediate(s, -1, n);
    }
    
    boolean popBackStackState(final ArrayList list, final ArrayList list2, final String s, final int n, final int n2) {
        final ArrayList mBackStack = this.mBackStack;
        if (mBackStack == null) {
            return false;
        }
        final int n3 = 1;
        if (s == null && n < 0 && (n2 & 0x1) == 0x0) {
            final int n4 = mBackStack.size() - n3;
            if (n4 < 0) {
                return false;
            }
            list.add(this.mBackStack.remove(n4));
            list2.add((boolean)(n3 != 0));
        }
        else {
            int i = -1;
            if (s != null || n >= 0) {
                for (i = this.mBackStack.size() - n3; i >= 0; --i) {
                    final BackStackRecord backStackRecord = this.mBackStack.get(i);
                    if (s != null && s.equals(backStackRecord.getName())) {
                        break;
                    }
                    if (n >= 0 && n == backStackRecord.mIndex) {
                        break;
                    }
                }
                if (i < 0) {
                    return false;
                }
                if ((n2 & 0x1) != 0x0) {
                    for (--i; i >= 0; --i) {
                        final BackStackRecord backStackRecord2 = this.mBackStack.get(i);
                        if ((s == null || s.equals(backStackRecord2.getName())) && (n < 0 || n != backStackRecord2.mIndex)) {
                            break;
                        }
                    }
                }
            }
            if (i == this.mBackStack.size() - n3) {
                return false;
            }
            for (int j = this.mBackStack.size() - n3; j > i; --j) {
                list.add(this.mBackStack.remove(j));
                list2.add((boolean)(n3 != 0));
            }
        }
        return n3 != 0;
    }
    
    public void putFragment(final Bundle bundle, final String s, final Fragment fragment) {
        if (fragment.mIndex < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            this.throwException(new IllegalStateException(sb.toString()));
        }
        bundle.putInt(s, fragment.mIndex);
    }
    
    public void registerFragmentLifecycleCallbacks(final FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks, final boolean b) {
        if (this.mLifecycleCallbacks == null) {
            this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        }
        this.mLifecycleCallbacks.add(new Pair(fragmentManager$FragmentLifecycleCallbacks, b));
    }
    
    public void removeFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
            Log.v(s, sb.toString());
        }
        final boolean inBackStack = fragment.isInBackStack();
        final boolean b = true;
        final boolean b2 = inBackStack ^ b;
        if (!fragment.mDetached || b2) {
            final ArrayList mAdded = this.mAdded;
            if (mAdded != null) {
                synchronized (mAdded) {
                    this.mAdded.remove(fragment);
                }
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = b;
            }
            fragment.mAdded = false;
            fragment.mRemoving = b;
        }
    }
    
    public void removeOnBackStackChangedListener(final FragmentManager$OnBackStackChangedListener fragmentManager$OnBackStackChangedListener) {
        final ArrayList mBackStackChangeListeners = this.mBackStackChangeListeners;
        if (mBackStackChangeListeners != null) {
            mBackStackChangeListeners.remove(fragmentManager$OnBackStackChangedListener);
        }
    }
    
    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); ++i) {
                ((FragmentManager$OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }
    
    void restoreAllState(final Parcelable parcelable, final FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable == null) {
            return;
        }
        final FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        List<FragmentManagerNonConfig> childNonConfigs = null;
        if (fragmentManagerNonConfig != null) {
            final List fragments = fragmentManagerNonConfig.getFragments();
            childNonConfigs = (List<FragmentManagerNonConfig>)fragmentManagerNonConfig.getChildNonConfigs();
            int size;
            if (fragments != null) {
                size = fragments.size();
            }
            else {
                size = 0;
            }
            for (int i = 0; i < size; ++i) {
                final Fragment mInstance = fragments.get(i);
                if (FragmentManagerImpl.DEBUG) {
                    final String s = "FragmentManager";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("restoreAllState: re-attaching retained ");
                    sb.append(mInstance);
                    Log.v(s, sb.toString());
                }
                int n;
                for (n = 0; n < fragmentManagerState.mActive.length && fragmentManagerState.mActive[n].mIndex != mInstance.mIndex; ++n) {}
                if (n == fragmentManagerState.mActive.length) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not find active fragment with index ");
                    sb2.append(mInstance.mIndex);
                    this.throwException(new IllegalStateException(sb2.toString()));
                }
                final FragmentState fragmentState = fragmentManagerState.mActive[n];
                fragmentState.mInstance = mInstance;
                mInstance.mSavedViewState = null;
                mInstance.mBackStackNesting = 0;
                mInstance.mInLayout = false;
                mInstance.mAdded = false;
                mInstance.mTarget = null;
                if (fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                    mInstance.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    mInstance.mSavedFragmentState = fragmentState.mSavedFragmentState;
                }
            }
        }
        this.mActive = new SparseArray(fragmentManagerState.mActive.length);
        for (int j = 0; j < fragmentManagerState.mActive.length; ++j) {
            final FragmentState fragmentState2 = fragmentManagerState.mActive[j];
            if (fragmentState2 != null) {
                FragmentManagerNonConfig fragmentManagerNonConfig2 = null;
                if (childNonConfigs != null && j < childNonConfigs.size()) {
                    fragmentManagerNonConfig2 = childNonConfigs.get(j);
                }
                final Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mParent, fragmentManagerNonConfig2);
                if (FragmentManagerImpl.DEBUG) {
                    final String s2 = "FragmentManager";
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("restoreAllState: active #");
                    sb3.append(j);
                    sb3.append(": ");
                    sb3.append(instantiate);
                    Log.v(s2, sb3.toString());
                }
                this.mActive.put(instantiate.mIndex, (Object)instantiate);
                fragmentState2.mInstance = null;
            }
        }
        if (fragmentManagerNonConfig != null) {
            final List fragments2 = fragmentManagerNonConfig.getFragments();
            int size2;
            if (fragments2 != null) {
                size2 = fragments2.size();
            }
            else {
                size2 = 0;
            }
            for (int k = 0; k < size2; ++k) {
                final Fragment fragment = fragments2.get(k);
                if (fragment.mTargetIndex >= 0) {
                    fragment.mTarget = (Fragment)this.mActive.get(fragment.mTargetIndex);
                    if (fragment.mTarget == null) {
                        final String s3 = "FragmentManager";
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Re-attaching retained fragment ");
                        sb4.append(fragment);
                        sb4.append(" target no longer exists: ");
                        sb4.append(fragment.mTargetIndex);
                        Log.w(s3, sb4.toString());
                    }
                }
            }
        }
        if (fragmentManagerState.mAdded != null) {
            this.mAdded = new ArrayList(fragmentManagerState.mAdded.length);
            int l = 0;
            while (l < fragmentManagerState.mAdded.length) {
                final Fragment fragment2 = (Fragment)this.mActive.get(fragmentManagerState.mAdded[l]);
                if (fragment2 == null) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("No instantiated fragment for index #");
                    sb5.append(fragmentManagerState.mAdded[l]);
                    this.throwException(new IllegalStateException(sb5.toString()));
                }
                fragment2.mAdded = true;
                if (FragmentManagerImpl.DEBUG) {
                    final String s4 = "FragmentManager";
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("restoreAllState: added #");
                    sb6.append(l);
                    sb6.append(": ");
                    sb6.append(fragment2);
                    Log.v(s4, sb6.toString());
                }
                if (!this.mAdded.contains(fragment2)) {
                    synchronized (this.mAdded) {
                        this.mAdded.add(fragment2);
                        // monitorexit(this.mAdded)
                        ++l;
                        continue;
                    }
                }
                throw new IllegalStateException("Already added!");
            }
        }
        else {
            this.mAdded = null;
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            for (int n2 = 0; n2 < fragmentManagerState.mBackStack.length; ++n2) {
                final BackStackRecord instantiate2 = fragmentManagerState.mBackStack[n2].instantiate(this);
                if (FragmentManagerImpl.DEBUG) {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append("restoreAllState: back stack #");
                    sb7.append(n2);
                    sb7.append(" (index ");
                    sb7.append(instantiate2.mIndex);
                    sb7.append("): ");
                    sb7.append(instantiate2);
                    Log.v("FragmentManager", sb7.toString());
                    final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    instantiate2.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(instantiate2);
                if (instantiate2.mIndex >= 0) {
                    this.setBackStackIndex(instantiate2.mIndex, instantiate2);
                }
            }
        }
        else {
            this.mBackStack = null;
        }
        this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
    }
    
    FragmentManagerNonConfig retainNonConfig() {
        ArrayList<Fragment> list = null;
        ArrayList<FragmentManagerNonConfig> list2 = null;
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); ++i) {
                final Fragment fragment = (Fragment)this.mActive.valueAt(i);
                if (fragment != null) {
                    if (fragment.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList<Fragment>();
                        }
                        list.add(fragment);
                        fragment.mRetaining = true;
                        int mIndex;
                        if (fragment.mTarget != null) {
                            mIndex = fragment.mTarget.mIndex;
                        }
                        else {
                            mIndex = -1;
                        }
                        fragment.mTargetIndex = mIndex;
                        if (FragmentManagerImpl.DEBUG) {
                            final String s = "FragmentManager";
                            final StringBuilder sb = new StringBuilder();
                            sb.append("retainNonConfig: keeping retained ");
                            sb.append(fragment);
                            Log.v(s, sb.toString());
                        }
                    }
                    boolean b = false;
                    if (fragment.mChildFragmentManager != null) {
                        final FragmentManagerNonConfig retainNonConfig = fragment.mChildFragmentManager.retainNonConfig();
                        if (retainNonConfig != null) {
                            if (list2 == null) {
                                list2 = new ArrayList<FragmentManagerNonConfig>();
                                for (int j = 0; j < i; ++j) {
                                    list2.add(null);
                                }
                            }
                            list2.add(retainNonConfig);
                            b = true;
                        }
                    }
                    if (list2 != null && !b) {
                        list2.add(null);
                    }
                }
            }
        }
        if (list == null && list2 == null) {
            return null;
        }
        return new FragmentManagerNonConfig(list, list2);
    }
    
    Parcelable saveAllState() {
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions();
        if (FragmentManagerImpl.HONEYCOMB) {
            this.mStateSaved = true;
        }
        final SparseArray mActive = this.mActive;
        if (mActive == null || mActive.size() <= 0) {
            return null;
        }
        final int size = this.mActive.size();
        final FragmentState[] mActive2 = new FragmentState[size];
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final Fragment fragment = (Fragment)this.mActive.valueAt(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failure saving state: active ");
                    sb.append(fragment);
                    sb.append(" has cleared index: ");
                    sb.append(fragment.mIndex);
                    this.throwException(new IllegalStateException(sb.toString()));
                }
                b = true;
                final FragmentState fragmentState = new FragmentState(fragment);
                mActive2[i] = fragmentState;
                if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = this.saveFragmentBasicState(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failure saving state: ");
                            sb2.append(fragment);
                            sb2.append(" has target not in fragment manager: ");
                            sb2.append(fragment.mTarget);
                            this.throwException(new IllegalStateException(sb2.toString()));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        this.putFragment(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if (FragmentManagerImpl.DEBUG) {
                    final String s = "FragmentManager";
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Saved state of ");
                    sb3.append(fragment);
                    sb3.append(": ");
                    sb3.append(fragmentState.mSavedFragmentState);
                    Log.v(s, sb3.toString());
                }
            }
        }
        if (!b) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int[] mAdded = null;
        BackStackState[] mBackStack = null;
        final ArrayList mAdded2 = this.mAdded;
        if (mAdded2 != null) {
            final int size2 = mAdded2.size();
            if (size2 > 0) {
                mAdded = new int[size2];
                for (int j = 0; j < size2; ++j) {
                    mAdded[j] = ((Fragment)this.mAdded.get(j)).mIndex;
                    if (mAdded[j] < 0) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Failure saving state: active ");
                        sb4.append(this.mAdded.get(j));
                        sb4.append(" has cleared index: ");
                        sb4.append(mAdded[j]);
                        this.throwException(new IllegalStateException(sb4.toString()));
                    }
                    if (FragmentManagerImpl.DEBUG) {
                        final String s2 = "FragmentManager";
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("saveAllState: adding fragment #");
                        sb5.append(j);
                        sb5.append(": ");
                        sb5.append(this.mAdded.get(j));
                        Log.v(s2, sb5.toString());
                    }
                }
            }
        }
        final ArrayList mBackStack2 = this.mBackStack;
        if (mBackStack2 != null) {
            final int size3 = mBackStack2.size();
            if (size3 > 0) {
                mBackStack = new BackStackState[size3];
                for (int k = 0; k < size3; ++k) {
                    mBackStack[k] = new BackStackState((BackStackRecord)this.mBackStack.get(k));
                    if (FragmentManagerImpl.DEBUG) {
                        final String s3 = "FragmentManager";
                        final StringBuilder sb6 = new StringBuilder();
                        sb6.append("saveAllState: adding back stack #");
                        sb6.append(k);
                        sb6.append(": ");
                        sb6.append(this.mBackStack.get(k));
                        Log.v(s3, sb6.toString());
                    }
                }
            }
        }
        final FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = mActive2;
        fragmentManagerState.mAdded = mAdded;
        fragmentManagerState.mBackStack = mBackStack;
        fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
        return (Parcelable)fragmentManagerState;
    }
    
    Bundle saveFragmentBasicState(final Fragment fragment) {
        Bundle mStateBundle = null;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        this.dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (!this.mStateBundle.isEmpty()) {
            mStateBundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            this.saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (mStateBundle == null) {
                mStateBundle = new Bundle();
            }
            mStateBundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (mStateBundle == null) {
                mStateBundle = new Bundle();
            }
            mStateBundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return mStateBundle;
    }
    
    public Fragment$SavedState saveFragmentInstanceState(final Fragment fragment) {
        if (fragment.mIndex < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            this.throwException(new IllegalStateException(sb.toString()));
        }
        final int mState = fragment.mState;
        Fragment$SavedState fragment$SavedState = null;
        if (mState > 0) {
            final Bundle saveFragmentBasicState = this.saveFragmentBasicState(fragment);
            if (saveFragmentBasicState != null) {
                fragment$SavedState = new Fragment$SavedState(saveFragmentBasicState);
            }
            return fragment$SavedState;
        }
        return null;
    }
    
    void saveFragmentViewState(final Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        final SparseArray mStateArray = this.mStateArray;
        if (mStateArray == null) {
            this.mStateArray = new SparseArray();
        }
        else {
            mStateArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.mStateArray);
        if (this.mStateArray.size() > 0) {
            fragment.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
        }
    }
    
    public void setBackStackIndex(final int n, final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int i = this.mBackStackIndices.size();
            if (n < i) {
                if (FragmentManagerImpl.DEBUG) {
                    final String s = "FragmentManager";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Setting back stack index ");
                    sb.append(n);
                    sb.append(" to ");
                    sb.append(backStackRecord);
                    Log.v(s, sb.toString());
                }
                this.mBackStackIndices.set(n, backStackRecord);
            }
            else {
                while (i < n) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    if (FragmentManagerImpl.DEBUG) {
                        final String s2 = "FragmentManager";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding available back stack index ");
                        sb2.append(i);
                        Log.v(s2, sb2.toString());
                    }
                    this.mAvailBackStackIndices.add(i);
                    ++i;
                }
                if (FragmentManagerImpl.DEBUG) {
                    final String s3 = "FragmentManager";
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Adding back stack index ");
                    sb3.append(n);
                    sb3.append(" with ");
                    sb3.append(backStackRecord);
                    Log.v(s3, sb3.toString());
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }
    
    public void showFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
            Log.v(s, sb.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= true;
        }
    }
    
    void startPendingDeferredFragments() {
        if (this.mActive == null) {
            return;
        }
        for (int i = 0; i < this.mActive.size(); ++i) {
            final Fragment fragment = (Fragment)this.mActive.valueAt(i);
            if (fragment != null) {
                this.performPendingDeferredStart(fragment);
            }
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        final Fragment mParent = this.mParent;
        if (mParent != null) {
            DebugUtils.buildShortClassTag(mParent, sb);
        }
        else {
            DebugUtils.buildShortClassTag(this.mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
    
    public void unregisterFragmentLifecycleCallbacks(final FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks) {
        final CopyOnWriteArrayList mLifecycleCallbacks = this.mLifecycleCallbacks;
        if (mLifecycleCallbacks == null) {
            return;
        }
        // monitorenter(mLifecycleCallbacks)
        int i = 0;
        try {
            while (i < this.mLifecycleCallbacks.size()) {
                if (((Pair)this.mLifecycleCallbacks.get(i)).first == fragmentManager$FragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
                ++i;
            }
        }
        finally {
        }
        // monitorexit(mLifecycleCallbacks)
    }
}
