// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Context;
import android.util.Log;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;
    
    static {
        CREATOR = (Parcelable$Creator)new FragmentState$1();
    }
    
    public FragmentState(final Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        final int int1 = parcel.readInt();
        boolean mHidden = true;
        this.mFromLayout = (int1 != 0);
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = (parcel.readInt() != 0);
        this.mDetached = (parcel.readInt() != 0);
        this.mArguments = parcel.readBundle();
        if (parcel.readInt() == 0) {
            mHidden = false;
        }
        this.mHidden = mHidden;
        this.mSavedFragmentState = parcel.readBundle();
    }
    
    public FragmentState(final Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Fragment instantiate(final FragmentHostCallback fragmentHostCallback, final Fragment fragment, final FragmentManagerNonConfig mChildNonConfig) {
        if (this.mInstance == null) {
            final Context context = fragmentHostCallback.getContext();
            final Bundle mArguments = this.mArguments;
            if (mArguments != null) {
                mArguments.setClassLoader(context.getClassLoader());
            }
            this.mInstance = Fragment.instantiate(context, this.mClassName, this.mArguments);
            final Bundle mSavedFragmentState = this.mSavedFragmentState;
            if (mSavedFragmentState != null) {
                mSavedFragmentState.setClassLoader(context.getClassLoader());
                this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
            }
            this.mInstance.setIndex(this.mIndex, fragment);
            final Fragment mInstance = this.mInstance;
            mInstance.mFromLayout = this.mFromLayout;
            mInstance.mRestored = true;
            mInstance.mFragmentId = this.mFragmentId;
            mInstance.mContainerId = this.mContainerId;
            mInstance.mTag = this.mTag;
            mInstance.mRetainInstance = this.mRetainInstance;
            mInstance.mDetached = this.mDetached;
            mInstance.mHidden = this.mHidden;
            mInstance.mFragmentManager = fragmentHostCallback.mFragmentManager;
            if (FragmentManagerImpl.DEBUG) {
                final String s = "FragmentManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Instantiated fragment ");
                sb.append(this.mInstance);
                Log.v(s, sb.toString());
            }
        }
        final Fragment mInstance2 = this.mInstance;
        mInstance2.mChildNonConfig = mChildNonConfig;
        return mInstance2;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.mClassName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt((int)(this.mFromLayout ? 1 : 0));
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt((int)(this.mRetainInstance ? 1 : 0));
        parcel.writeInt((int)(this.mDetached ? 1 : 0));
        parcel.writeBundle(this.mArguments);
        parcel.writeInt((int)(this.mHidden ? 1 : 0));
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
