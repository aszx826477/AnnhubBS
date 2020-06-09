// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import android.os.Looper;
import android.content.IntentSender;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.animation.Animation;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.LayoutInflaterCompat;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.view.View$OnCreateContextMenuListener;
import android.content.ComponentCallbacks;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener
{
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION;
    private static final SimpleArrayMap sClassMap;
    boolean mAdded;
    Fragment$AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    FragmentManagerImpl mChildFragmentManager;
    FragmentManagerNonConfig mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    int mIndex;
    View mInnerView;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    Fragment mParentFragment;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    SparseArray mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;
    
    static {
        sClassMap = new SimpleArrayMap();
        USE_DEFAULT_TRANSITION = new Object();
    }
    
    public Fragment() {
        this.mState = 0;
        final int n = -1;
        this.mIndex = n;
        this.mTargetIndex = n;
        final boolean b = true;
        this.mMenuVisible = b;
        this.mUserVisibleHint = b;
    }
    
    private void callStartTransitionListener() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        Fragment$OnStartEnterTransitionListener mStartEnterTransitionListener;
        if (mAnimationInfo == null) {
            mStartEnterTransitionListener = null;
        }
        else {
            mAnimationInfo.mEnterTransitionPostponed = false;
            mStartEnterTransitionListener = mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = null;
        }
        if (mStartEnterTransitionListener != null) {
            mStartEnterTransitionListener.onStartEnterTransition();
        }
    }
    
    private Fragment$AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new Fragment$AnimationInfo();
        }
        return this.mAnimationInfo;
    }
    
    public static Fragment instantiate(final Context context, final String s) {
        return instantiate(context, s, null);
    }
    
    public static Fragment instantiate(final Context context, final String s, final Bundle mArguments) {
        try {
            final Object value = Fragment.sClassMap.get(s);
            try {
                Class<?> loadClass = (Class<Object>)value;
                if (loadClass == null) {
                    loadClass = context.getClassLoader().loadClass(s);
                    Fragment.sClassMap.put(s, loadClass);
                }
                final Object instance = loadClass.newInstance();
                try {
                    final Fragment fragment = (Fragment)instance;
                    if (mArguments == null) {
                        return fragment;
                    }
                    final Class<? extends Fragment> class1 = fragment.getClass();
                    try {
                        mArguments.setClassLoader(class1.getClassLoader());
                        final Fragment fragment2 = fragment;
                        try {
                            fragment2.mArguments = mArguments;
                            return fragment;
                        }
                        catch (IllegalAccessException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Unable to instantiate fragment ");
                            sb.append(s);
                            sb.append(": make sure class name exists, is public, and has an");
                            sb.append(" empty constructor that is public");
                            throw new Fragment$InstantiationException(sb.toString(), ex);
                        }
                        catch (InstantiationException ex2) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unable to instantiate fragment ");
                            sb2.append(s);
                            sb2.append(": make sure class name exists, is public, and has an");
                            sb2.append(" empty constructor that is public");
                            throw new Fragment$InstantiationException(sb2.toString(), ex2);
                        }
                        catch (ClassNotFoundException ex3) {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unable to instantiate fragment ");
                            sb3.append(s);
                            sb3.append(": make sure class name exists, is public, and has an");
                            sb3.append(" empty constructor that is public");
                            throw new Fragment$InstantiationException(sb3.toString(), ex3);
                        }
                    }
                    catch (IllegalAccessException ex4) {}
                    catch (InstantiationException ex5) {}
                    catch (ClassNotFoundException ex6) {}
                }
                catch (IllegalAccessException ex7) {}
                catch (InstantiationException ex8) {}
                catch (ClassNotFoundException ex9) {}
            }
            catch (IllegalAccessException ex10) {}
            catch (InstantiationException ex11) {}
            catch (ClassNotFoundException ex12) {}
        }
        catch (IllegalAccessException ex13) {}
        catch (InstantiationException ex14) {}
        catch (ClassNotFoundException ex15) {}
    }
    
    static boolean isSupportFragmentClass(final Context context, final String s) {
        try {
            final Object value = Fragment.sClassMap.get(s);
            try {
                Class<?> loadClass = (Class<?>)value;
                if (loadClass == null) {
                    loadClass = context.getClassLoader().loadClass(s);
                    Fragment.sClassMap.put(s, loadClass);
                }
                return Fragment.class.isAssignableFrom(loadClass);
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        catch (ClassNotFoundException ex2) {}
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(s);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(s);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(s);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(s);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(s);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(s);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(s);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(s);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(s);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(s);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(s);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (this.getNextAnim() != 0) {
            printWriter.print(s);
            printWriter.print("mNextAnim=");
            printWriter.println(this.getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(s);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(s);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(s);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.getAnimatingAway() != null) {
            printWriter.print(s);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.getAnimatingAway());
            printWriter.print(s);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.getStateAfterAnimating());
        }
        if (this.mLoaderManager != null) {
            printWriter.print(s);
            printWriter.println("Loader Manager:");
            final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("  ");
            mLoaderManager.dump(sb.toString(), fileDescriptor, printWriter, array);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(s);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Child ");
            sb2.append(this.mChildFragmentManager);
            sb2.append(":");
            printWriter.println(sb2.toString());
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s);
            sb3.append("  ");
            mChildFragmentManager.dump(sb3.toString(), fileDescriptor, printWriter, array);
        }
    }
    
    public final boolean equals(final Object o) {
        return super.equals(o);
    }
    
    Fragment findFragmentByWho(final String s) {
        if (s.equals(this.mWho)) {
            return this;
        }
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            return mChildFragmentManager.findFragmentByWho(s);
        }
        return null;
    }
    
    public final FragmentActivity getActivity() {
        final FragmentHostCallback mHost = this.mHost;
        FragmentActivity fragmentActivity;
        if (mHost == null) {
            fragmentActivity = null;
        }
        else {
            fragmentActivity = (FragmentActivity)mHost.getActivity();
        }
        return fragmentActivity;
    }
    
    public boolean getAllowEnterTransitionOverlap() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo == null || mAnimationInfo.mAllowEnterTransitionOverlap == null || this.mAnimationInfo.mAllowEnterTransitionOverlap;
    }
    
    public boolean getAllowReturnTransitionOverlap() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo == null || mAnimationInfo.mAllowReturnTransitionOverlap == null || this.mAnimationInfo.mAllowReturnTransitionOverlap;
    }
    
    View getAnimatingAway() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mAnimatingAway;
    }
    
    public final Bundle getArguments() {
        return this.mArguments;
    }
    
    public final FragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            this.instantiateChildFragmentManager();
            final int mState = this.mState;
            if (mState >= 5) {
                this.mChildFragmentManager.dispatchResume();
            }
            else if (mState >= 4) {
                this.mChildFragmentManager.dispatchStart();
            }
            else if (mState >= 2) {
                this.mChildFragmentManager.dispatchActivityCreated();
            }
            else if (mState >= 1) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }
        return this.mChildFragmentManager;
    }
    
    public Context getContext() {
        final FragmentHostCallback mHost = this.mHost;
        Context context;
        if (mHost == null) {
            context = null;
        }
        else {
            context = mHost.getContext();
        }
        return context;
    }
    
    public Object getEnterTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mEnterTransition;
    }
    
    SharedElementCallback getEnterTransitionCallback() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mEnterTransitionCallback;
    }
    
    public Object getExitTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mExitTransition;
    }
    
    SharedElementCallback getExitTransitionCallback() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mExitTransitionCallback;
    }
    
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }
    
    public final Object getHost() {
        final FragmentHostCallback mHost = this.mHost;
        Object onGetHost;
        if (mHost == null) {
            onGetHost = null;
        }
        else {
            onGetHost = mHost.onGetHost();
        }
        return onGetHost;
    }
    
    public final int getId() {
        return this.mFragmentId;
    }
    
    public final LayoutInflater getLayoutInflater() {
        final LayoutInflater mLayoutInflater = this.mLayoutInflater;
        if (mLayoutInflater == null) {
            return this.performGetLayoutInflater(null);
        }
        return mLayoutInflater;
    }
    
    public LayoutInflater getLayoutInflater(final Bundle bundle) {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            final LayoutInflater onGetLayoutInflater = mHost.onGetLayoutInflater();
            this.getChildFragmentManager();
            LayoutInflaterCompat.setFactory(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
            return onGetLayoutInflater;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    
    public LoaderManager getLoaderManager() {
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            final boolean mCheckedForLoaderManager = true;
            this.mCheckedForLoaderManager = mCheckedForLoaderManager;
            return this.mLoaderManager = mHost.getLoaderManager(this.mWho, this.mLoadersStarted, mCheckedForLoaderManager);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    int getNextAnim() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.mNextAnim;
    }
    
    int getNextTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.mNextTransition;
    }
    
    int getNextTransitionStyle() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.mNextTransitionStyle;
    }
    
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }
    
    public Object getReenterTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if (mAnimationInfo.mReenterTransition == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getExitTransition();
        }
        else {
            o = this.mAnimationInfo.mReenterTransition;
        }
        return o;
    }
    
    public final Resources getResources() {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            return mHost.getContext().getResources();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }
    
    public Object getReturnTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if (mAnimationInfo.mReturnTransition == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getEnterTransition();
        }
        else {
            o = this.mAnimationInfo.mReturnTransition;
        }
        return o;
    }
    
    public Object getSharedElementEnterTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.mSharedElementEnterTransition;
    }
    
    public Object getSharedElementReturnTransition() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if (mAnimationInfo.mSharedElementReturnTransition == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getSharedElementEnterTransition();
        }
        else {
            o = this.mAnimationInfo.mSharedElementReturnTransition;
        }
        return o;
    }
    
    int getStateAfterAnimating() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.mStateAfterAnimating;
    }
    
    public final String getString(final int n) {
        return this.getResources().getString(n);
    }
    
    public final String getString(final int n, final Object... array) {
        return this.getResources().getString(n, array);
    }
    
    public final String getTag() {
        return this.mTag;
    }
    
    public final Fragment getTargetFragment() {
        return this.mTarget;
    }
    
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }
    
    public final CharSequence getText(final int n) {
        return this.getResources().getText(n);
    }
    
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }
    
    public View getView() {
        return this.mView;
    }
    
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }
    
    public final int hashCode() {
        return super.hashCode();
    }
    
    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }
    
    void instantiateChildFragmentManager() {
        if (this.mHost != null) {
            (this.mChildFragmentManager = new FragmentManagerImpl()).attachController(this.mHost, new Fragment$2(this), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }
    
    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }
    
    public final boolean isDetached() {
        return this.mDetached;
    }
    
    public final boolean isHidden() {
        return this.mHidden;
    }
    
    boolean isHideReplaced() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo != null && mAnimationInfo.mIsHideReplaced;
    }
    
    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }
    
    public final boolean isInLayout() {
        return this.mInLayout;
    }
    
    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }
    
    boolean isPostponed() {
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo != null && mAnimationInfo.mEnterTransitionPostponed;
    }
    
    public final boolean isRemoving() {
        return this.mRemoving;
    }
    
    public final boolean isResumed() {
        return this.mState >= 5;
    }
    
    public final boolean isVisible() {
        if (this.isAdded() && !this.isHidden()) {
            final View mView = this.mView;
            if (mView != null) {
                if (mView.getWindowToken() != null && this.mView.getVisibility() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    void noteStateNotSaved() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
    }
    
    public void onActivityCreated(final Bundle bundle) {
        this.mCalled = true;
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
    }
    
    public void onAttach(final Activity activity) {
        this.mCalled = true;
    }
    
    public void onAttach(final Context context) {
        this.mCalled = true;
        final FragmentHostCallback mHost = this.mHost;
        Activity activity;
        if (mHost == null) {
            activity = null;
        }
        else {
            activity = mHost.getActivity();
        }
        if (activity != null) {
            this.mCalled = false;
            this.onAttach(activity);
        }
    }
    
    public void onAttachFragment(final Fragment fragment) {
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.mCalled = true;
    }
    
    public boolean onContextItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onCreate(final Bundle bundle) {
        final int mCalled = 1;
        this.mCalled = (mCalled != 0);
        this.restoreChildFragmentState(bundle);
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            if (!mChildFragmentManager.isStateAtLeast(mCalled)) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }
    
    public Animation onCreateAnimation(final int n, final boolean b, final int n2) {
        return null;
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        this.getActivity().onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
    }
    
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return null;
    }
    
    public void onDestroy() {
        final boolean b = true;
        this.mCalled = b;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = b;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
        }
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }
    
    public void onDestroyOptionsMenu() {
    }
    
    public void onDestroyView() {
        this.mCalled = true;
    }
    
    public void onDetach() {
        this.mCalled = true;
    }
    
    public LayoutInflater onGetLayoutInflater(final Bundle bundle) {
        return this.getLayoutInflater(bundle);
    }
    
    public void onHiddenChanged(final boolean b) {
    }
    
    public void onInflate(final Activity activity, final AttributeSet set, final Bundle bundle) {
        this.mCalled = true;
    }
    
    public void onInflate(final Context context, final AttributeSet set, final Bundle bundle) {
        this.mCalled = true;
        final FragmentHostCallback mHost = this.mHost;
        Activity activity;
        if (mHost == null) {
            activity = null;
        }
        else {
            activity = mHost.getActivity();
        }
        if (activity != null) {
            this.mCalled = false;
            this.onInflate(activity, set, bundle);
        }
    }
    
    public void onLowMemory() {
        this.mCalled = true;
    }
    
    public void onMultiWindowModeChanged(final boolean b) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onOptionsMenuClosed(final Menu menu) {
    }
    
    public void onPause() {
        this.mCalled = true;
    }
    
    public void onPictureInPictureModeChanged(final boolean b) {
    }
    
    public void onPrepareOptionsMenu(final Menu menu) {
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
    }
    
    public void onResume() {
        this.mCalled = true;
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    public void onStart() {
        final boolean mCheckedForLoaderManager = true;
        this.mCalled = mCheckedForLoaderManager;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = mCheckedForLoaderManager;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = mCheckedForLoaderManager;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }
            else {
                final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
                if (mLoaderManager != null) {
                    mLoaderManager.doStart();
                }
            }
        }
    }
    
    public void onStop() {
        this.mCalled = true;
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
    }
    
    public void onViewStateRestored(final Bundle bundle) {
        this.mCalled = true;
    }
    
    FragmentManager peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }
    
    void performActivityCreated(final Bundle bundle) {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        this.mState = 2;
        this.mCalled = false;
        this.onActivityCreated(bundle);
        if (this.mCalled) {
            final FragmentManagerImpl mChildFragmentManager2 = this.mChildFragmentManager;
            if (mChildFragmentManager2 != null) {
                mChildFragmentManager2.dispatchActivityCreated();
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onActivityCreated()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performConfigurationChanged(final Configuration configuration) {
        this.onConfigurationChanged(configuration);
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }
    
    boolean performContextItemSelected(final MenuItem menuItem) {
        if (!this.mHidden) {
            final boolean onContextItemSelected = this.onContextItemSelected(menuItem);
            final boolean b = true;
            if (onContextItemSelected) {
                return b;
            }
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                if (mChildFragmentManager.dispatchContextItemSelected(menuItem)) {
                    return b;
                }
            }
        }
        return false;
    }
    
    void performCreate(final Bundle bundle) {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        this.mState = 1;
        this.mCalled = false;
        this.onCreate(bundle);
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onCreate()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    boolean performCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        boolean b = false;
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                b = true;
                this.onCreateOptionsMenu(menu, menuInflater);
            }
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                b |= mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
            }
        }
        return b;
    }
    
    View performCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        return this.onCreateView(layoutInflater, viewGroup, bundle);
    }
    
    void performDestroy() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchDestroy();
        }
        this.mState = 0;
        this.mCalled = false;
        this.onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroy()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performDestroyView() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchDestroyView();
        }
        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if (this.mCalled) {
            final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
            if (mLoaderManager != null) {
                mLoaderManager.doReportNextStart();
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroyView()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performDetach() {
        this.mCalled = false;
        this.onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                if (!this.mRetaining) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Child FragmentManager of ");
                    sb.append(this);
                    sb.append(" was not ");
                    sb.append(" destroyed and this fragment is not retaining instance");
                    throw new IllegalStateException(sb.toString());
                }
                mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = null;
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(this);
        sb2.append(" did not call through to super.onDetach()");
        throw new SuperNotCalledException(sb2.toString());
    }
    
    LayoutInflater performGetLayoutInflater(final Bundle bundle) {
        return this.mLayoutInflater = this.onGetLayoutInflater(bundle);
    }
    
    void performLowMemory() {
        this.onLowMemory();
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchLowMemory();
        }
    }
    
    void performMultiWindowModeChanged(final boolean b) {
        this.onMultiWindowModeChanged(b);
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchMultiWindowModeChanged(b);
        }
    }
    
    boolean performOptionsItemSelected(final MenuItem menuItem) {
        if (!this.mHidden) {
            final boolean mHasMenu = this.mHasMenu;
            final boolean b = true;
            if (mHasMenu && this.mMenuVisible && this.onOptionsItemSelected(menuItem)) {
                return b;
            }
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                if (mChildFragmentManager.dispatchOptionsItemSelected(menuItem)) {
                    return b;
                }
            }
        }
        return false;
    }
    
    void performOptionsMenuClosed(final Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                this.onOptionsMenuClosed(menu);
            }
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            }
        }
    }
    
    void performPause() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchPause();
        }
        this.mState = 4;
        this.mCalled = false;
        this.onPause();
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onPause()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performPictureInPictureModeChanged(final boolean b) {
        this.onPictureInPictureModeChanged(b);
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchPictureInPictureModeChanged(b);
        }
    }
    
    boolean performPrepareOptionsMenu(final Menu menu) {
        boolean b = false;
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                b = true;
                this.onPrepareOptionsMenu(menu);
            }
            final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
            if (mChildFragmentManager != null) {
                b |= mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            }
        }
        return b;
    }
    
    void performReallyStop() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchReallyStop();
        }
        this.mState = 2;
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                if (this.mHost.getRetainLoaders()) {
                    this.mLoaderManager.doRetain();
                }
                else {
                    this.mLoaderManager.doStop();
                }
            }
        }
    }
    
    void performResume() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mState = 5;
        this.mCalled = false;
        this.onResume();
        if (this.mCalled) {
            final FragmentManagerImpl mChildFragmentManager2 = this.mChildFragmentManager;
            if (mChildFragmentManager2 != null) {
                mChildFragmentManager2.dispatchResume();
                this.mChildFragmentManager.execPendingActions();
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onResume()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performSaveInstanceState(final Bundle bundle) {
        this.onSaveInstanceState(bundle);
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            final Parcelable saveAllState = mChildFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }
    
    void performStart() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mState = 4;
        this.mCalled = false;
        this.onStart();
        if (this.mCalled) {
            final FragmentManagerImpl mChildFragmentManager2 = this.mChildFragmentManager;
            if (mChildFragmentManager2 != null) {
                mChildFragmentManager2.dispatchStart();
            }
            final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
            if (mLoaderManager != null) {
                mLoaderManager.doReportStart();
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStart()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performStop() {
        final FragmentManagerImpl mChildFragmentManager = this.mChildFragmentManager;
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchStop();
        }
        this.mState = 3;
        this.mCalled = false;
        this.onStop();
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStop()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }
    
    public void registerForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
    }
    
    public final void requestPermissions(final String[] array, final int n) {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            mHost.onRequestPermissionsFromFragment(this, array, n);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    void restoreChildFragmentState(final Bundle bundle) {
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    this.instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.restoreAllState(parcelable, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }
    
    final void restoreViewState(final Bundle bundle) {
        final SparseArray mSavedViewState = this.mSavedViewState;
        if (mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        this.onViewStateRestored(bundle);
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onViewStateRestored()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    public void setAllowEnterTransitionOverlap(final boolean b) {
        this.ensureAnimationInfo().mAllowEnterTransitionOverlap = b;
    }
    
    public void setAllowReturnTransitionOverlap(final boolean b) {
        this.ensureAnimationInfo().mAllowReturnTransitionOverlap = b;
    }
    
    void setAnimatingAway(final View mAnimatingAway) {
        this.ensureAnimationInfo().mAnimatingAway = mAnimatingAway;
    }
    
    public void setArguments(final Bundle mArguments) {
        if (this.mIndex < 0) {
            this.mArguments = mArguments;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }
    
    public void setEnterSharedElementCallback(final SharedElementCallback mEnterTransitionCallback) {
        this.ensureAnimationInfo().mEnterTransitionCallback = mEnterTransitionCallback;
    }
    
    public void setEnterTransition(final Object o) {
        this.ensureAnimationInfo().mEnterTransition = o;
    }
    
    public void setExitSharedElementCallback(final SharedElementCallback mExitTransitionCallback) {
        this.ensureAnimationInfo().mExitTransitionCallback = mExitTransitionCallback;
    }
    
    public void setExitTransition(final Object o) {
        this.ensureAnimationInfo().mExitTransition = o;
    }
    
    public void setHasOptionsMenu(final boolean mHasMenu) {
        if (this.mHasMenu != mHasMenu) {
            this.mHasMenu = mHasMenu;
            if (this.isAdded() && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }
    
    void setHideReplaced(final boolean mIsHideReplaced) {
        this.ensureAnimationInfo().mIsHideReplaced = mIsHideReplaced;
    }
    
    final void setIndex(final int mIndex, final Fragment fragment) {
        this.mIndex = mIndex;
        if (fragment != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(fragment.mWho);
            sb.append(":");
            sb.append(this.mIndex);
            this.mWho = sb.toString();
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("android:fragment:");
            sb2.append(this.mIndex);
            this.mWho = sb2.toString();
        }
    }
    
    public void setInitialSavedState(final Fragment$SavedState fragment$SavedState) {
        if (this.mIndex < 0) {
            Bundle mState;
            if (fragment$SavedState != null && fragment$SavedState.mState != null) {
                mState = fragment$SavedState.mState;
            }
            else {
                mState = null;
            }
            this.mSavedFragmentState = mState;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }
    
    public void setMenuVisibility(final boolean mMenuVisible) {
        if (this.mMenuVisible != mMenuVisible) {
            this.mMenuVisible = mMenuVisible;
            if (this.mHasMenu && this.isAdded() && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }
    
    void setNextAnim(final int mNextAnim) {
        if (this.mAnimationInfo == null && mNextAnim == 0) {
            return;
        }
        this.ensureAnimationInfo().mNextAnim = mNextAnim;
    }
    
    void setNextTransition(final int mNextTransition, final int mNextTransitionStyle) {
        if (this.mAnimationInfo == null && mNextTransition == 0 && mNextTransitionStyle == 0) {
            return;
        }
        this.ensureAnimationInfo();
        final Fragment$AnimationInfo mAnimationInfo = this.mAnimationInfo;
        mAnimationInfo.mNextTransition = mNextTransition;
        mAnimationInfo.mNextTransitionStyle = mNextTransitionStyle;
    }
    
    void setOnStartEnterTransitionListener(final Fragment$OnStartEnterTransitionListener mStartEnterTransitionListener) {
        this.ensureAnimationInfo();
        if (mStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener) {
            return;
        }
        if (mStartEnterTransitionListener != null && this.mAnimationInfo.mStartEnterTransitionListener != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Trying to set a replacement startPostponedEnterTransition on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        if (this.mAnimationInfo.mEnterTransitionPostponed) {
            this.mAnimationInfo.mStartEnterTransitionListener = mStartEnterTransitionListener;
        }
        if (mStartEnterTransitionListener != null) {
            mStartEnterTransitionListener.startListening();
        }
    }
    
    public void setReenterTransition(final Object o) {
        this.ensureAnimationInfo().mReenterTransition = o;
    }
    
    public void setRetainInstance(final boolean mRetainInstance) {
        this.mRetainInstance = mRetainInstance;
    }
    
    public void setReturnTransition(final Object o) {
        this.ensureAnimationInfo().mReturnTransition = o;
    }
    
    public void setSharedElementEnterTransition(final Object o) {
        this.ensureAnimationInfo().mSharedElementEnterTransition = o;
    }
    
    public void setSharedElementReturnTransition(final Object o) {
        this.ensureAnimationInfo().mSharedElementReturnTransition = o;
    }
    
    void setStateAfterAnimating(final int mStateAfterAnimating) {
        this.ensureAnimationInfo().mStateAfterAnimating = mStateAfterAnimating;
    }
    
    public void setTargetFragment(final Fragment mTarget, final int mTargetRequestCode) {
        this.mTarget = mTarget;
        this.mTargetRequestCode = mTargetRequestCode;
    }
    
    public void setUserVisibleHint(final boolean mUserVisibleHint) {
        final boolean mUserVisibleHint2 = this.mUserVisibleHint;
        final int n = 4;
        if (!mUserVisibleHint2 && mUserVisibleHint && this.mState < n && this.mFragmentManager != null) {
            if (this.isAdded()) {
                this.mFragmentManager.performPendingDeferredStart(this);
            }
        }
        this.mUserVisibleHint = mUserVisibleHint;
        this.mDeferStart = (this.mState < n && !mUserVisibleHint);
    }
    
    public boolean shouldShowRequestPermissionRationale(final String s) {
        final FragmentHostCallback mHost = this.mHost;
        return mHost != null && mHost.onShouldShowRequestPermissionRationale(s);
    }
    
    public void startActivity(final Intent intent) {
        this.startActivity(intent, null);
    }
    
    public void startActivity(final Intent intent, final Bundle bundle) {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            mHost.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    public void startActivityForResult(final Intent intent, final int n) {
        this.startActivityForResult(intent, n, null);
    }
    
    public void startActivityForResult(final Intent intent, final int n, final Bundle bundle) {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            mHost.onStartActivityFromFragment(this, intent, n, bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    public void startIntentSenderForResult(final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) {
        final FragmentHostCallback mHost = this.mHost;
        if (mHost != null) {
            mHost.onStartIntentSenderFromFragment(this, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    public void startPostponedEnterTransition() {
        final FragmentManagerImpl mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null && mFragmentManager.mHost != null) {
            if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper()) {
                this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue((Runnable)new Fragment$1(this));
            }
            else {
                this.callStartTransitionListener();
            }
        }
        else {
            this.ensureAnimationInfo().mEnterTransitionPostponed = false;
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }
    
    public void unregisterForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
    }
}
