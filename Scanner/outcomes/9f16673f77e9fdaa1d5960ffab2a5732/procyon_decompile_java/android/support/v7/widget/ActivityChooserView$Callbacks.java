// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.AdapterView;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow$OnDismissListener;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemClickListener;

class ActivityChooserView$Callbacks implements AdapterView$OnItemClickListener, View$OnClickListener, View$OnLongClickListener, PopupWindow$OnDismissListener
{
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$Callbacks(final ActivityChooserView this$0) {
        this.this$0 = this$0;
    }
    
    private void notifyOnDismissListener() {
        if (this.this$0.mOnDismissListener != null) {
            this.this$0.mOnDismissListener.onDismiss();
        }
    }
    
    public void onClick(final View view) {
        if (view == this.this$0.mDefaultActivityButton) {
            this.this$0.dismissPopup();
            final Intent chooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(this.this$0.mAdapter.getDataModel().getActivityIndex(this.this$0.mAdapter.getDefaultActivity()));
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                this.this$0.getContext().startActivity(chooseActivity);
            }
        }
        else {
            if (view != this.this$0.mExpandActivityOverflowButton) {
                throw new IllegalArgumentException();
            }
            final ActivityChooserView this$0 = this.this$0;
            this$0.mIsSelectingDefaultActivity = false;
            this$0.showPopupUnchecked(this$0.mInitialActivityCount);
        }
    }
    
    public void onDismiss() {
        this.notifyOnDismissListener();
        if (this.this$0.mProvider != null) {
            this.this$0.mProvider.subUiVisibilityChanged(false);
        }
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, int defaultActivity, final long n) {
        switch (((ActivityChooserView$ActivityChooserViewAdapter)adapterView.getAdapter()).getItemViewType(defaultActivity)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                this.this$0.showPopupUnchecked(-1 >>> 1);
                break;
            }
            case 0: {
                this.this$0.dismissPopup();
                if (this.this$0.mIsSelectingDefaultActivity) {
                    if (defaultActivity > 0) {
                        this.this$0.mAdapter.getDataModel().setDefaultActivity(defaultActivity);
                        break;
                    }
                    break;
                }
                else {
                    int n2;
                    if (this.this$0.mAdapter.getShowDefaultActivity()) {
                        n2 = defaultActivity;
                    }
                    else {
                        n2 = defaultActivity + 1;
                    }
                    defaultActivity = n2;
                    final Intent chooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(n2);
                    if (chooseActivity != null) {
                        chooseActivity.addFlags(524288);
                        this.this$0.getContext().startActivity(chooseActivity);
                        break;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public boolean onLongClick(final View view) {
        if (view == this.this$0.mDefaultActivityButton) {
            final int count = this.this$0.mAdapter.getCount();
            final boolean mIsSelectingDefaultActivity = true;
            if (count > 0) {
                final ActivityChooserView this$0 = this.this$0;
                this$0.mIsSelectingDefaultActivity = mIsSelectingDefaultActivity;
                this$0.showPopupUnchecked(this$0.mInitialActivityCount);
            }
            return mIsSelectingDefaultActivity;
        }
        throw new IllegalArgumentException();
    }
}
