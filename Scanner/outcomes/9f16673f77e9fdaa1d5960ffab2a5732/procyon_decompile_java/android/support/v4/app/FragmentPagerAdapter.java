// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.PagerAdapter;

public abstract class FragmentPagerAdapter extends PagerAdapter
{
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    
    public FragmentPagerAdapter(final FragmentManager mFragmentManager) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = mFragmentManager;
    }
    
    private static String makeFragmentName(final int n, final long n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(n);
        sb.append(":");
        sb.append(n2);
        return sb.toString();
    }
    
    public void destroyItem(final ViewGroup viewGroup, final int n, final Object o) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach((Fragment)o);
    }
    
    public void finishUpdate(final ViewGroup viewGroup) {
        final FragmentTransaction mCurTransaction = this.mCurTransaction;
        if (mCurTransaction != null) {
            mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }
    
    public abstract Fragment getItem(final int p0);
    
    public long getItemId(final int n) {
        return n;
    }
    
    public Object instantiateItem(final ViewGroup viewGroup, final int n) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        final long itemId = this.getItemId(n);
        Fragment fragment = this.mFragmentManager.findFragmentByTag(makeFragmentName(viewGroup.getId(), itemId));
        if (fragment != null) {
            this.mCurTransaction.attach(fragment);
        }
        else {
            fragment = this.getItem(n);
            this.mCurTransaction.add(viewGroup.getId(), fragment, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (fragment != this.mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }
    
    public boolean isViewFromObject(final View view, final Object o) {
        return ((Fragment)o).getView() == view;
    }
    
    public void restoreState(final Parcelable parcelable, final ClassLoader classLoader) {
    }
    
    public Parcelable saveState() {
        return null;
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
