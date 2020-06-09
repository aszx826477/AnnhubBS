// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.List;
import android.util.Log;
import android.text.TextUtils;
import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class BackStackState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final boolean mAllowOptimization;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList mSharedElementSourceNames;
    final ArrayList mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;
    
    static {
        CREATOR = (Parcelable$Creator)new BackStackState$1();
    }
    
    public BackStackState(final Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mAllowOptimization = (parcel.readInt() != 0);
    }
    
    public BackStackState(final BackStackRecord backStackRecord) {
        final int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 6];
        if (backStackRecord.mAddToBackStack) {
            int n = 0;
            int n7;
            for (int i = 0; i < size; ++i, n = n7) {
                final BackStackRecord$Op backStackRecord$Op = backStackRecord.mOps.get(i);
                final int[] mOps = this.mOps;
                final int n2 = n + 1;
                mOps[n] = backStackRecord$Op.cmd;
                final int[] mOps2 = this.mOps;
                final int n3 = n2 + 1;
                int mIndex;
                if (backStackRecord$Op.fragment != null) {
                    mIndex = backStackRecord$Op.fragment.mIndex;
                }
                else {
                    mIndex = -1;
                }
                mOps2[n2] = mIndex;
                final int[] mOps3 = this.mOps;
                final int n4 = n3 + 1;
                mOps3[n3] = backStackRecord$Op.enterAnim;
                final int[] mOps4 = this.mOps;
                final int n5 = n4 + 1;
                mOps4[n4] = backStackRecord$Op.exitAnim;
                final int[] mOps5 = this.mOps;
                final int n6 = n5 + 1;
                mOps5[n5] = backStackRecord$Op.popEnterAnim;
                final int[] mOps6 = this.mOps;
                n7 = n6 + 1;
                mOps6[n6] = backStackRecord$Op.popExitAnim;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mTransitionStyle = backStackRecord.mTransitionStyle;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mAllowOptimization = backStackRecord.mAllowOptimization;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }
    
    public int describeContents() {
        return 0;
    }
    
    public BackStackRecord instantiate(final FragmentManagerImpl fragmentManagerImpl) {
        final BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int n = 0;
        while (i < this.mOps.length) {
            final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
            final int[] mOps = this.mOps;
            final int n2 = i + 1;
            backStackRecord$Op.cmd = mOps[i];
            if (FragmentManagerImpl.DEBUG) {
                final String s = "FragmentManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(backStackRecord);
                sb.append(" op #");
                sb.append(n);
                sb.append(" base fragment #");
                sb.append(this.mOps[n2]);
                Log.v(s, sb.toString());
            }
            final int[] mOps2 = this.mOps;
            final int n3 = n2 + 1;
            final int n4 = mOps2[n2];
            if (n4 >= 0) {
                backStackRecord$Op.fragment = (Fragment)fragmentManagerImpl.mActive.get(n4);
            }
            else {
                backStackRecord$Op.fragment = null;
            }
            final int[] mOps3 = this.mOps;
            final int n5 = n3 + 1;
            backStackRecord$Op.enterAnim = mOps3[n3];
            final int n6 = n5 + 1;
            backStackRecord$Op.exitAnim = mOps3[n5];
            final int n7 = n6 + 1;
            backStackRecord$Op.popEnterAnim = mOps3[n6];
            final int n8 = n7 + 1;
            backStackRecord$Op.popExitAnim = mOps3[n7];
            backStackRecord.mEnterAnim = backStackRecord$Op.enterAnim;
            backStackRecord.mExitAnim = backStackRecord$Op.exitAnim;
            backStackRecord.mPopEnterAnim = backStackRecord$Op.popEnterAnim;
            backStackRecord.mPopExitAnim = backStackRecord$Op.popExitAnim;
            backStackRecord.addOp(backStackRecord$Op);
            ++n;
            i = n8;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        final int mAddToBackStack = 1;
        backStackRecord.mAddToBackStack = (mAddToBackStack != 0);
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mAllowOptimization = this.mAllowOptimization;
        backStackRecord.bumpBackStackNesting(mAddToBackStack);
        return backStackRecord;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList((List)this.mSharedElementSourceNames);
        parcel.writeStringList((List)this.mSharedElementTargetNames);
        parcel.writeInt((int)(this.mAllowOptimization ? 1 : 0));
    }
}
