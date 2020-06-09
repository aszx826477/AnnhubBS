// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Context;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListView;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;

public class ListFragment extends Fragment
{
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView$OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;
    
    public ListFragment() {
        this.mHandler = new Handler();
        this.mRequestFocus = new ListFragment$1(this);
        this.mOnClickListener = (AdapterView$OnItemClickListener)new ListFragment$2(this);
    }
    
    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        final View view = this.getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.mList = (ListView)view;
            }
            else {
                this.mStandardEmptyView = (TextView)view.findViewById(16711681);
                final TextView mStandardEmptyView = this.mStandardEmptyView;
                if (mStandardEmptyView == null) {
                    this.mEmptyView = view.findViewById(16908292);
                }
                else {
                    mStandardEmptyView.setVisibility(8);
                }
                this.mProgressContainer = view.findViewById(16711682);
                this.mListContainer = view.findViewById(16711683);
                final View viewById = view.findViewById(16908298);
                if (!(viewById instanceof ListView)) {
                    if (viewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                else {
                    this.mList = (ListView)viewById;
                    final View mEmptyView = this.mEmptyView;
                    if (mEmptyView != null) {
                        this.mList.setEmptyView(mEmptyView);
                    }
                    else {
                        final CharSequence mEmptyText = this.mEmptyText;
                        if (mEmptyText != null) {
                            this.mStandardEmptyView.setText(mEmptyText);
                            this.mList.setEmptyView((View)this.mStandardEmptyView);
                        }
                    }
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            if (this.mAdapter != null) {
                final ListAdapter mAdapter = this.mAdapter;
                this.mAdapter = null;
                this.setListAdapter(mAdapter);
            }
            else if (this.mProgressContainer != null) {
                this.setListShown(false, false);
            }
            this.mHandler.post(this.mRequestFocus);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }
    
    private void setListShown(final boolean mListShown, final boolean b) {
        this.ensureList();
        final View mProgressContainer = this.mProgressContainer;
        if (mProgressContainer == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.mListShown == mListShown) {
            return;
        }
        this.mListShown = mListShown;
        final int n = 8;
        final int n2 = 17432577;
        final int n3 = 17432576;
        if (mListShown) {
            if (b) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), n2));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), n3));
            }
            else {
                mProgressContainer.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(n);
            this.mListContainer.setVisibility(0);
        }
        else {
            if (b) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), n3));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), n2));
            }
            else {
                mProgressContainer.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(n);
        }
    }
    
    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }
    
    public ListView getListView() {
        this.ensureList();
        return this.mList;
    }
    
    public long getSelectedItemId() {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }
    
    public int getSelectedItemPosition() {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final Context context = this.getContext();
        final FrameLayout frameLayout = new FrameLayout(context);
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        final int n = 17;
        linearLayout.setGravity(n);
        final ProgressBar progressBar = new ProgressBar(context, (AttributeSet)null, 16842874);
        final int n2 = -2;
        linearLayout.addView((View)progressBar, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n2, n2));
        final int n3 = -1;
        frameLayout.addView((View)linearLayout, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n3, n3));
        final FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(16711683);
        final TextView textView = new TextView(context);
        textView.setId(16711681);
        textView.setGravity(n);
        frameLayout2.addView((View)textView, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n3, n3));
        final ListView listView = new ListView(context);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView((View)listView, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n3, n3));
        frameLayout.addView((View)frameLayout2, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n3, n3));
        frameLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n3, n3));
        return (View)frameLayout;
    }
    
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }
    
    public void onListItemClick(final ListView listView, final View view, final int n, final long n2) {
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ensureList();
    }
    
    public void setEmptyText(final CharSequence charSequence) {
        this.ensureList();
        final TextView mStandardEmptyView = this.mStandardEmptyView;
        if (mStandardEmptyView != null) {
            mStandardEmptyView.setText(charSequence);
            if (this.mEmptyText == null) {
                this.mList.setEmptyView((View)this.mStandardEmptyView);
            }
            this.mEmptyText = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }
    
    public void setListAdapter(final ListAdapter listAdapter) {
        final ListAdapter mAdapter = this.mAdapter;
        boolean b = false;
        final boolean b2 = true;
        final boolean b3 = mAdapter != null;
        this.mAdapter = listAdapter;
        final ListView mList = this.mList;
        if (mList != null) {
            mList.setAdapter(listAdapter);
            if (!this.mListShown && !b3) {
                if (this.getView().getWindowToken() != null) {
                    b = true;
                }
                this.setListShown(b2, b);
            }
        }
    }
    
    public void setListShown(final boolean b) {
        this.setListShown(b, true);
    }
    
    public void setListShownNoAnimation(final boolean b) {
        this.setListShown(b, false);
    }
    
    public void setSelection(final int selection) {
        this.ensureList();
        this.mList.setSelection(selection);
    }
}
