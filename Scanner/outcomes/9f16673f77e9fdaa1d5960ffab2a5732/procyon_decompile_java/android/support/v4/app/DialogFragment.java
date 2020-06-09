// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.content.Context;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;

public class DialogFragment extends Fragment implements DialogInterface$OnCancelListener, DialogInterface$OnDismissListener
{
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int mBackStackId;
    boolean mCancelable;
    Dialog mDialog;
    boolean mDismissed;
    boolean mShownByMe;
    boolean mShowsDialog;
    int mStyle;
    int mTheme;
    boolean mViewDestroyed;
    
    public DialogFragment() {
        this.mStyle = 0;
        this.mTheme = 0;
        final boolean b = true;
        this.mCancelable = b;
        this.mShowsDialog = b;
        this.mBackStackId = -1;
    }
    
    public void dismiss() {
        this.dismissInternal(false);
    }
    
    public void dismissAllowingStateLoss() {
        this.dismissInternal(true);
    }
    
    void dismissInternal(final boolean b) {
        if (this.mDismissed) {
            return;
        }
        final int n = 1;
        this.mDismissed = (n != 0);
        this.mShownByMe = false;
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.dismiss();
            this.mDialog = null;
        }
        this.mViewDestroyed = (n != 0);
        if (this.mBackStackId >= 0) {
            this.getFragmentManager().popBackStack(this.mBackStackId, n);
            this.mBackStackId = -1;
        }
        else {
            final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            if (b) {
                beginTransaction.commitAllowingStateLoss();
            }
            else {
                beginTransaction.commit();
            }
        }
    }
    
    public Dialog getDialog() {
        return this.mDialog;
    }
    
    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }
    
    public int getTheme() {
        return this.mTheme;
    }
    
    public boolean isCancelable() {
        return this.mCancelable;
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.mShowsDialog) {
            return;
        }
        final View view = this.getView();
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            this.mDialog.setContentView(view);
        }
        final FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.mDialog.setOwnerActivity((Activity)activity);
        }
        this.mDialog.setCancelable(this.mCancelable);
        this.mDialog.setOnCancelListener((DialogInterface$OnCancelListener)this);
        this.mDialog.setOnDismissListener((DialogInterface$OnDismissListener)this);
        if (bundle != null) {
            final Bundle bundle2 = bundle.getBundle("android:savedDialogState");
            if (bundle2 != null) {
                this.mDialog.onRestoreInstanceState(bundle2);
            }
        }
    }
    
    public void onAttach(final Context context) {
        super.onAttach(context);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final int mContainerId = this.mContainerId;
        final boolean b = true;
        this.mShowsDialog = (mContainerId == 0);
        if (bundle != null) {
            this.mStyle = bundle.getInt("android:style", 0);
            this.mTheme = bundle.getInt("android:theme", 0);
            this.mCancelable = bundle.getBoolean("android:cancelable", b);
            this.mShowsDialog = bundle.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }
    
    public Dialog onCreateDialog(final Bundle bundle) {
        return new Dialog((Context)this.getActivity(), this.getTheme());
    }
    
    public void onDestroyView() {
        super.onDestroyView();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            this.mViewDestroyed = true;
            mDialog.dismiss();
            this.mDialog = null;
        }
    }
    
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            this.dismissInternal(true);
        }
    }
    
    public LayoutInflater onGetLayoutInflater(final Bundle bundle) {
        if (!this.mShowsDialog) {
            return super.onGetLayoutInflater(bundle);
        }
        this.mDialog = this.onCreateDialog(bundle);
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            this.setupDialog(mDialog, this.mStyle);
            return (LayoutInflater)this.mDialog.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater)this.mHost.getContext().getSystemService("layout_inflater");
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            final Bundle onSaveInstanceState = mDialog.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        final int mStyle = this.mStyle;
        if (mStyle != 0) {
            bundle.putInt("android:style", mStyle);
        }
        final int mTheme = this.mTheme;
        if (mTheme != 0) {
            bundle.putInt("android:theme", mTheme);
        }
        final boolean mCancelable = this.mCancelable;
        if (!mCancelable) {
            bundle.putBoolean("android:cancelable", mCancelable);
        }
        final boolean mShowsDialog = this.mShowsDialog;
        if (!mShowsDialog) {
            bundle.putBoolean("android:showsDialog", mShowsDialog);
        }
        final int mBackStackId = this.mBackStackId;
        if (mBackStackId != -1) {
            bundle.putInt("android:backStackId", mBackStackId);
        }
    }
    
    public void onStart() {
        super.onStart();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            this.mViewDestroyed = false;
            mDialog.show();
        }
    }
    
    public void onStop() {
        super.onStop();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.hide();
        }
    }
    
    public void setCancelable(final boolean b) {
        this.mCancelable = b;
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.setCancelable(b);
        }
    }
    
    public void setShowsDialog(final boolean mShowsDialog) {
        this.mShowsDialog = mShowsDialog;
    }
    
    public void setStyle(final int mStyle, final int mTheme) {
        this.mStyle = mStyle;
        final int mStyle2 = this.mStyle;
        if (mStyle2 == 2 || mStyle2 == 3) {
            this.mTheme = 16973913;
        }
        if (mTheme != 0) {
            this.mTheme = mTheme;
        }
    }
    
    public void setupDialog(final Dialog dialog, final int n) {
        switch (n) {
            case 3: {
                dialog.getWindow().addFlags(24);
            }
            case 1:
            case 2: {
                dialog.requestWindowFeature(1);
                break;
            }
        }
    }
    
    public int show(final FragmentTransaction fragmentTransaction, final String s) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add(this, s);
        this.mViewDestroyed = false;
        return this.mBackStackId = fragmentTransaction.commit();
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        this.mDismissed = false;
        this.mShownByMe = true;
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, s);
        beginTransaction.commit();
    }
}
