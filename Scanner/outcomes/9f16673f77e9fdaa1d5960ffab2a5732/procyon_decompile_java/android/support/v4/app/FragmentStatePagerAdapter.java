// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.Iterator;
import android.util.Log;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.support.v4.view.PagerAdapter;

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;
    
    public FragmentStatePagerAdapter(final FragmentManager mFragmentManager) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = mFragmentManager;
    }
    
    public void destroyItem(final ViewGroup viewGroup, final int n, final Object o) {
        final Fragment fragment = (Fragment)o;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= n) {
            this.mSavedState.add(null);
        }
        final ArrayList mSavedState = this.mSavedState;
        Fragment$SavedState saveFragmentInstanceState;
        if (fragment.isAdded()) {
            saveFragmentInstanceState = this.mFragmentManager.saveFragmentInstanceState(fragment);
        }
        else {
            saveFragmentInstanceState = null;
        }
        mSavedState.set(n, saveFragmentInstanceState);
        this.mFragments.set(n, null);
        this.mCurTransaction.remove(fragment);
    }
    
    public void finishUpdate(final ViewGroup viewGroup) {
        final FragmentTransaction mCurTransaction = this.mCurTransaction;
        if (mCurTransaction != null) {
            mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }
    
    public abstract Fragment getItem(final int p0);
    
    public Object instantiateItem(final ViewGroup viewGroup, final int n) {
        if (this.mFragments.size() > n) {
            final Fragment fragment = this.mFragments.get(n);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        final Fragment item = this.getItem(n);
        if (this.mSavedState.size() > n) {
            final Fragment$SavedState initialSavedState = this.mSavedState.get(n);
            if (initialSavedState != null) {
                item.setInitialSavedState(initialSavedState);
            }
        }
        while (this.mFragments.size() <= n) {
            this.mFragments.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.mFragments.set(n, item);
        this.mCurTransaction.add(viewGroup.getId(), item);
        return item;
    }
    
    public boolean isViewFromObject(final View view, final Object o) {
        return ((Fragment)o).getView() == view;
    }
    
    public void restoreState(final Parcelable parcelable, final ClassLoader classLoader) {
        if (parcelable != null) {
            final Bundle bundle = (Bundle)parcelable;
            bundle.setClassLoader(classLoader);
            final Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (int i = 0; i < parcelableArray.length; ++i) {
                    this.mSavedState.add(parcelableArray[i]);
                }
            }
            for (final String s : bundle.keySet()) {
                if (s.startsWith("f")) {
                    final int int1 = Integer.parseInt(s.substring(1));
                    final Fragment fragment = this.mFragmentManager.getFragment(bundle, s);
                    if (fragment != null) {
                        while (this.mFragments.size() <= int1) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(int1, fragment);
                    }
                    else {
                        final String s2 = "FragmentStatePagerAdapter";
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(s);
                        Log.w(s2, sb.toString());
                    }
                }
            }
        }
    }
    
    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            final Fragment$SavedState[] array = new Fragment$SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(array);
            bundle.putParcelableArray("states", (Parcelable[])array);
        }
        for (int i = 0; i < this.mFragments.size(); ++i) {
            final Fragment fragment = this.mFragments.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("f");
                sb.append(i);
                this.mFragmentManager.putFragment(bundle, sb.toString(), fragment);
            }
        }
        return (Parcelable)bundle;
    }
    
    public void setPrimaryItem(final ViewGroup viewGroup, final int n, final Object o) {
        final Fragment mCurrentPrimaryItem = (Fragment)o;
        final Fragment mCurrentPrimaryItem2 = this.mCurrentPrimaryItem;
        if (mCurrentPrimaryItem != mCurrentPrimaryItem2) {
            if (mCurrentPrimaryItem2 != null) {
                mCurrentPrimaryItem2.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (mCurrentPrimaryItem != null) {
                final boolean b = true;
                mCurrentPrimaryItem.setMenuVisibility(b);
                mCurrentPrimaryItem.setUserVisibleHint(b);
            }
            this.mCurrentPrimaryItem = mCurrentPrimaryItem;
        }
    }
    
    public void startUpdate(final ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("ViewPager with adapter ");
        sb.append(this);
        sb.append(" requires a view id");
        throw new IllegalStateException(sb.toString());
    }
}
