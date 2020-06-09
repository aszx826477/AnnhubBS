// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.os.Message;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.view.ViewGroup;
import android.content.DialogInterface$OnKeyListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.ListAdapter;

public class AlertController$AlertParams
{
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public int mIconAttrId;
    public int mIconId;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public DialogInterface$OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public DialogInterface$OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface$OnCancelListener mOnCancelListener;
    public DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface$OnClickListener mOnClickListener;
    public DialogInterface$OnDismissListener mOnDismissListener;
    public AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface$OnKeyListener mOnKeyListener;
    public AlertController$AlertParams$OnPrepareListViewListener mOnPrepareListViewListener;
    public DialogInterface$OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified;
    public int mViewSpacingTop;
    
    public AlertController$AlertParams(final Context mContext) {
        this.mIconId = 0;
        this.mIconAttrId = 0;
        this.mViewSpacingSpecified = false;
        this.mCheckedItem = -1;
        final boolean b = true;
        this.mRecycleOnMeasure = b;
        this.mContext = mContext;
        this.mCancelable = b;
        this.mInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    }
    
    private void createListView(final AlertController alertController) {
        final AlertController$RecycleListView mListView = (AlertController$RecycleListView)this.mInflater.inflate(alertController.mListLayout, (ViewGroup)null);
        final boolean mIsMultiChoice = this.mIsMultiChoice;
        final int choiceMode = 1;
        Object mAdapter;
        if (mIsMultiChoice) {
            final Cursor mCursor = this.mCursor;
            if (mCursor == null) {
                final Context mContext;
                final int mMultiChoiceItemLayout;
                final int n;
                final CharSequence[] mItems;
                final AlertController$AlertParams$1 alertController$AlertParams$1 = new AlertController$AlertParams$1(this, mContext, mMultiChoiceItemLayout, n, mItems, mListView);
                mContext = this.mContext;
                mMultiChoiceItemLayout = alertController.mMultiChoiceItemLayout;
                n = 16908308;
                mItems = this.mItems;
                mAdapter = alertController$AlertParams$1;
            }
            else {
                final Context mContext2;
                final AlertController$AlertParams$2 alertController$AlertParams$2 = new AlertController$AlertParams$2(this, mContext2, mCursor, false, mListView, alertController);
                mContext2 = this.mContext;
                mAdapter = alertController$AlertParams$2;
            }
        }
        else {
            int n2;
            if (this.mIsSingleChoice) {
                n2 = alertController.mSingleChoiceItemLayout;
            }
            else {
                n2 = alertController.mListItemLayout;
            }
            final Cursor mCursor2 = this.mCursor;
            final int n3 = 16908308;
            if (mCursor2 != null) {
                final Context mContext3 = this.mContext;
                final String[] array = new String[choiceMode];
                array[0] = this.mLabelColumn;
                final int[] array2 = new int[choiceMode];
                array2[0] = n3;
                mAdapter = new SimpleCursorAdapter(mContext3, n2, mCursor2, array, array2);
            }
            else if (this.mAdapter != null) {
                mAdapter = this.mAdapter;
            }
            else {
                mAdapter = new AlertController$CheckedItemAdapter(this.mContext, n2, n3, this.mItems);
            }
        }
        final AlertController$AlertParams$OnPrepareListViewListener mOnPrepareListViewListener = this.mOnPrepareListViewListener;
        if (mOnPrepareListViewListener != null) {
            mOnPrepareListViewListener.onPrepareListView(mListView);
        }
        alertController.mAdapter = (ListAdapter)mAdapter;
        alertController.mCheckedItem = this.mCheckedItem;
        if (this.mOnClickListener != null) {
            mListView.setOnItemClickListener((AdapterView$OnItemClickListener)new AlertController$AlertParams$3(this, alertController));
        }
        else if (this.mOnCheckboxClickListener != null) {
            mListView.setOnItemClickListener((AdapterView$OnItemClickListener)new AlertController$AlertParams$4(this, mListView, alertController));
        }
        final AdapterView$OnItemSelectedListener mOnItemSelectedListener = this.mOnItemSelectedListener;
        if (mOnItemSelectedListener != null) {
            mListView.setOnItemSelectedListener(mOnItemSelectedListener);
        }
        if (this.mIsSingleChoice) {
            mListView.setChoiceMode(choiceMode);
        }
        else if (this.mIsMultiChoice) {
            mListView.setChoiceMode(2);
        }
        alertController.mListView = mListView;
    }
    
    public void apply(final AlertController alertController) {
        final View mCustomTitleView = this.mCustomTitleView;
        if (mCustomTitleView != null) {
            alertController.setCustomTitle(mCustomTitleView);
        }
        else {
            final CharSequence mTitle = this.mTitle;
            if (mTitle != null) {
                alertController.setTitle(mTitle);
            }
            final Drawable mIcon = this.mIcon;
            if (mIcon != null) {
                alertController.setIcon(mIcon);
            }
            final int mIconId = this.mIconId;
            if (mIconId != 0) {
                alertController.setIcon(mIconId);
            }
            final int mIconAttrId = this.mIconAttrId;
            if (mIconAttrId != 0) {
                alertController.setIcon(alertController.getIconAttributeResId(mIconAttrId));
            }
        }
        final CharSequence mMessage = this.mMessage;
        if (mMessage != null) {
            alertController.setMessage(mMessage);
        }
        final CharSequence mPositiveButtonText = this.mPositiveButtonText;
        if (mPositiveButtonText != null) {
            alertController.setButton(-1, mPositiveButtonText, this.mPositiveButtonListener, null);
        }
        final CharSequence mNegativeButtonText = this.mNegativeButtonText;
        if (mNegativeButtonText != null) {
            alertController.setButton(-2, mNegativeButtonText, this.mNegativeButtonListener, null);
        }
        final CharSequence mNeutralButtonText = this.mNeutralButtonText;
        if (mNeutralButtonText != null) {
            alertController.setButton(-3, mNeutralButtonText, this.mNeutralButtonListener, null);
        }
        if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            this.createListView(alertController);
        }
        final View mView = this.mView;
        if (mView != null) {
            if (this.mViewSpacingSpecified) {
                alertController.setView(mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            else {
                alertController.setView(mView);
            }
        }
        else {
            final int mViewLayoutResId = this.mViewLayoutResId;
            if (mViewLayoutResId != 0) {
                alertController.setView(mViewLayoutResId);
            }
        }
    }
}
