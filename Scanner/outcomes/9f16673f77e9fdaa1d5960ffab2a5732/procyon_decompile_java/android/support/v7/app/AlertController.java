// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.DialogInterface$OnClickListener;
import android.view.KeyEvent;
import android.content.res.Resources$Theme;
import android.util.TypedValue;
import android.support.v7.widget.LinearLayoutCompat$LayoutParams;
import android.widget.FrameLayout;
import android.view.LayoutInflater;
import android.text.TextUtils;
import android.widget.AbsListView$OnScrollListener;
import android.support.v4.widget.NestedScrollView$OnScrollChangeListener;
import android.os.Build$VERSION;
import android.support.v7.appcompat.R$id;
import android.view.ViewParent;
import android.view.ViewStub;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.content.DialogInterface;
import android.view.Window;
import android.support.v4.widget.NestedScrollView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.content.Context;
import android.os.Message;
import android.widget.Button;
import android.view.View$OnClickListener;
import android.widget.ListAdapter;

class AlertController
{
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View$OnClickListener mButtonHandler;
    Button mButtonNegative;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;
    
    public AlertController(final Context mContext, final AppCompatDialog mDialog, final Window mWindow) {
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = (View$OnClickListener)new AlertController$1(this);
        this.mContext = mContext;
        this.mDialog = mDialog;
        this.mWindow = mWindow;
        this.mHandler = new AlertController$ButtonHandler((DialogInterface)mDialog);
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes((AttributeSet)null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        final int alertDialog_showTitle = R$styleable.AlertDialog_showTitle;
        final int n = 1;
        this.mShowTitle = obtainStyledAttributes.getBoolean(alertDialog_showTitle, (boolean)(n != 0));
        obtainStyledAttributes.recycle();
        mDialog.supportRequestWindowFeature(n);
    }
    
    static boolean canTextInput(View child) {
        final boolean onCheckIsTextEditor = child.onCheckIsTextEditor();
        final boolean b = true;
        if (onCheckIsTextEditor) {
            return b;
        }
        if (!(child instanceof ViewGroup)) {
            return false;
        }
        final ViewGroup viewGroup = (ViewGroup)child;
        int i = viewGroup.getChildCount();
        while (i > 0) {
            --i;
            child = viewGroup.getChildAt(i);
            if (canTextInput(child)) {
                return b;
            }
        }
        return false;
    }
    
    private void centerButton(final Button button) {
        final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    static void manageScrollIndicators(final View view, final View view2, final View view3) {
        int visibility = 0;
        if (view2 != null) {
            int visibility2;
            if (ViewCompat.canScrollVertically(view, -1)) {
                visibility2 = 0;
            }
            else {
                visibility2 = 4;
            }
            view2.setVisibility(visibility2);
        }
        if (view3 != null) {
            if (!ViewCompat.canScrollVertically(view, 1)) {
                visibility = 4;
            }
            view3.setVisibility(visibility);
        }
    }
    
    private ViewGroup resolvePanel(View inflate, View inflate2) {
        if (inflate == null) {
            if (inflate2 instanceof ViewStub) {
                inflate2 = ((ViewStub)inflate2).inflate();
            }
            return (ViewGroup)inflate2;
        }
        if (inflate2 != null) {
            final ViewParent parent = inflate2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(inflate2);
            }
        }
        if (inflate instanceof ViewStub) {
            inflate = ((ViewStub)inflate).inflate();
        }
        return (ViewGroup)inflate;
    }
    
    private int selectContentView() {
        final int mButtonPanelSideLayout = this.mButtonPanelSideLayout;
        if (mButtonPanelSideLayout == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return mButtonPanelSideLayout;
        }
        return this.mAlertDialogLayout;
    }
    
    private void setScrollIndicators(final ViewGroup viewGroup, final View view, final int n, final int n2) {
        View viewById = this.mWindow.findViewById(R$id.scrollIndicatorUp);
        View viewById2 = this.mWindow.findViewById(R$id.scrollIndicatorDown);
        if (Build$VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, n, n2);
            if (viewById != null) {
                viewGroup.removeView(viewById);
            }
            if (viewById2 != null) {
                viewGroup.removeView(viewById2);
            }
        }
        else {
            if (viewById != null && (n & 0x1) == 0x0) {
                viewGroup.removeView(viewById);
                viewById = null;
            }
            if (viewById2 != null && (n & 0x2) == 0x0) {
                viewGroup.removeView(viewById2);
                viewById2 = null;
            }
            if (viewById != null || viewById2 != null) {
                final View view2 = viewById2;
                if (this.mMessage != null) {
                    this.mScrollView.setOnScrollChangeListener(new AlertController$2(this, viewById, viewById2));
                    this.mScrollView.post((Runnable)new AlertController$3(this, viewById, viewById2));
                }
                else {
                    final ListView mListView = this.mListView;
                    if (mListView != null) {
                        mListView.setOnScrollListener((AbsListView$OnScrollListener)new AlertController$4(this, viewById, viewById2));
                        this.mListView.post((Runnable)new AlertController$5(this, viewById, viewById2));
                    }
                    else {
                        if (viewById != null) {
                            viewGroup.removeView(viewById);
                        }
                        if (view2 != null) {
                            viewGroup.removeView(view2);
                        }
                    }
                }
            }
        }
    }
    
    private void setupButtons(final ViewGroup viewGroup) {
        final boolean b = true;
        final int n = 2;
        final int n2 = 4;
        boolean b2 = false;
        (this.mButtonPositive = (Button)viewGroup.findViewById(16908313)).setOnClickListener(this.mButtonHandler);
        final boolean empty = TextUtils.isEmpty(this.mButtonPositiveText);
        final int n3 = 8;
        boolean b3 = false;
        if (empty) {
            this.mButtonPositive.setVisibility(n3);
        }
        else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            this.mButtonPositive.setVisibility(0);
            b2 = (false | b);
        }
        (this.mButtonNegative = (Button)viewGroup.findViewById(16908314)).setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText)) {
            this.mButtonNegative.setVisibility(n3);
        }
        else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            this.mButtonNegative.setVisibility(0);
            b2 |= (n != 0);
        }
        (this.mButtonNeutral = (Button)viewGroup.findViewById(16908315)).setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText)) {
            this.mButtonNeutral.setVisibility(n3);
        }
        else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            this.mButtonNeutral.setVisibility(0);
            b2 |= (n2 != 0);
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (b2 == b) {
                this.centerButton(this.mButtonPositive);
            }
            else if ((b2 ? 1 : 0) == n) {
                this.centerButton(this.mButtonNegative);
            }
            else if ((b2 ? 1 : 0) == n2) {
                this.centerButton(this.mButtonNeutral);
            }
        }
        if (b2) {
            b3 = true;
        }
        if (!b3) {
            viewGroup.setVisibility(n3);
        }
    }
    
    private void setupContent(final ViewGroup viewGroup) {
        (this.mScrollView = (NestedScrollView)this.mWindow.findViewById(R$id.scrollView)).setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        this.mMessageView = (TextView)viewGroup.findViewById(16908299);
        final TextView mMessageView = this.mMessageView;
        if (mMessageView == null) {
            return;
        }
        final CharSequence mMessage = this.mMessage;
        if (mMessage != null) {
            mMessageView.setText(mMessage);
        }
        else {
            final int n = 8;
            mMessageView.setVisibility(n);
            this.mScrollView.removeView((View)this.mMessageView);
            if (this.mListView != null) {
                final ViewGroup viewGroup2 = (ViewGroup)this.mScrollView.getParent();
                final int indexOfChild = viewGroup2.indexOfChild((View)this.mScrollView);
                viewGroup2.removeViewAt(indexOfChild);
                final ListView mListView = this.mListView;
                final int n2 = -1;
                viewGroup2.addView((View)mListView, indexOfChild, new ViewGroup$LayoutParams(n2, n2));
            }
            else {
                viewGroup.setVisibility(n);
            }
        }
    }
    
    private void setupCustomContent(final ViewGroup viewGroup) {
        final View mView = this.mView;
        boolean b = false;
        View view;
        if (mView != null) {
            view = this.mView;
        }
        else if (this.mViewLayoutResId != 0) {
            view = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
        }
        else {
            view = null;
        }
        if (view != null) {
            b = true;
        }
        if (!b || !canTextInput(view)) {
            final Window mWindow = this.mWindow;
            final int n = 131072;
            mWindow.setFlags(n, n);
        }
        if (b) {
            final FrameLayout frameLayout = (FrameLayout)this.mWindow.findViewById(R$id.custom);
            final int n2 = -1;
            frameLayout.addView(view, new ViewGroup$LayoutParams(n2, n2));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayoutCompat$LayoutParams)viewGroup.getLayoutParams()).weight = 0.0f;
            }
        }
        else {
            viewGroup.setVisibility(8);
        }
    }
    
    private void setupTitle(final ViewGroup viewGroup) {
        final View mCustomTitleView = this.mCustomTitleView;
        final int visibility = 8;
        if (mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup$LayoutParams(-1, -2));
            this.mWindow.findViewById(R$id.title_template).setVisibility(visibility);
        }
        else {
            this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
            if ((TextUtils.isEmpty(this.mTitle) ^ true) && this.mShowTitle) {
                (this.mTitleView = (TextView)this.mWindow.findViewById(R$id.alertTitle)).setText(this.mTitle);
                final int mIconId = this.mIconId;
                if (mIconId != 0) {
                    this.mIconView.setImageResource(mIconId);
                }
                else {
                    final Drawable mIcon = this.mIcon;
                    if (mIcon != null) {
                        this.mIconView.setImageDrawable(mIcon);
                    }
                    else {
                        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                        this.mIconView.setVisibility(visibility);
                    }
                }
            }
            else {
                this.mWindow.findViewById(R$id.title_template).setVisibility(visibility);
                this.mIconView.setVisibility(visibility);
                viewGroup.setVisibility(visibility);
            }
        }
    }
    
    private void setupView() {
        final View viewById = this.mWindow.findViewById(R$id.parentPanel);
        final View viewById2 = viewById.findViewById(R$id.topPanel);
        final View viewById3 = viewById.findViewById(R$id.contentPanel);
        final View viewById4 = viewById.findViewById(R$id.buttonPanel);
        final ViewGroup viewGroup = (ViewGroup)viewById.findViewById(R$id.customPanel);
        this.setupCustomContent(viewGroup);
        final View viewById5 = viewGroup.findViewById(R$id.topPanel);
        final View viewById6 = viewGroup.findViewById(R$id.contentPanel);
        final View viewById7 = viewGroup.findViewById(R$id.buttonPanel);
        final ViewGroup resolvePanel = this.resolvePanel(viewById5, viewById2);
        final ViewGroup resolvePanel2 = this.resolvePanel(viewById6, viewById3);
        final ViewGroup resolvePanel3 = this.resolvePanel(viewById7, viewById4);
        this.setupContent(resolvePanel2);
        this.setupButtons(resolvePanel3);
        this.setupTitle(resolvePanel);
        final int n = 8;
        final boolean b = viewGroup != null && viewGroup.getVisibility() != n;
        final boolean b2 = resolvePanel != null && resolvePanel.getVisibility() != n;
        final boolean b3 = resolvePanel3 != null && resolvePanel3.getVisibility() != n;
        if (!b3) {
            if (resolvePanel2 != null) {
                final View viewById8 = resolvePanel2.findViewById(R$id.textSpacerNoButtons);
                if (viewById8 != null) {
                    viewById8.setVisibility(0);
                }
            }
        }
        if (b2) {
            final NestedScrollView mScrollView = this.mScrollView;
            if (mScrollView != null) {
                mScrollView.setClipToPadding(true);
            }
            View viewById9 = null;
            if (this.mMessage != null || this.mListView != null || b) {
                if (!b) {
                    viewById9 = resolvePanel.findViewById(R$id.titleDividerNoCustom);
                }
            }
            if (viewById9 != null) {
                viewById9.setVisibility(0);
            }
        }
        else if (resolvePanel2 != null) {
            final View viewById10 = resolvePanel2.findViewById(R$id.textSpacerNoTitle);
            if (viewById10 != null) {
                viewById10.setVisibility(0);
            }
        }
        final ListView mListView = this.mListView;
        if (mListView instanceof AlertController$RecycleListView) {
            ((AlertController$RecycleListView)mListView).setHasDecor(b2, b3);
        }
        if (!b) {
            Object o = this.mListView;
            if (o == null) {
                o = this.mScrollView;
            }
            if (o != null) {
                final boolean b4 = b2;
                int n2;
                if (b3) {
                    n2 = 2;
                }
                else {
                    n2 = 0;
                }
                this.setScrollIndicators(resolvePanel2, (View)o, (b4 ? 1 : 0) | n2, 3);
            }
        }
        final ListView mListView2 = this.mListView;
        if (mListView2 != null) {
            final ListAdapter mAdapter = this.mAdapter;
            if (mAdapter != null) {
                mListView2.setAdapter(mAdapter);
                final int mCheckedItem = this.mCheckedItem;
                if (mCheckedItem > -1) {
                    mListView2.setItemChecked(mCheckedItem, true);
                    mListView2.setSelection(mCheckedItem);
                }
            }
        }
    }
    
    private static boolean shouldCenterSingleButton(final Context context) {
        final TypedValue typedValue = new TypedValue();
        final Resources$Theme theme = context.getTheme();
        final int alertDialogCenterButtons = R$attr.alertDialogCenterButtons;
        boolean b = true;
        theme.resolveAttribute(alertDialogCenterButtons, typedValue, b);
        if (typedValue.data == 0) {
            b = false;
        }
        return b;
    }
    
    public Button getButton(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case -1: {
                return this.mButtonPositive;
            }
            case -2: {
                return this.mButtonNegative;
            }
            case -3: {
                return this.mButtonNeutral;
            }
        }
    }
    
    public int getIconAttributeResId(final int n) {
        final TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.resourceId;
    }
    
    public ListView getListView() {
        return this.mListView;
    }
    
    public void installContent() {
        this.mDialog.setContentView(this.selectContentView());
        this.setupView();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        final NestedScrollView mScrollView = this.mScrollView;
        return mScrollView != null && mScrollView.executeKeyEvent(keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        final NestedScrollView mScrollView = this.mScrollView;
        return mScrollView != null && mScrollView.executeKeyEvent(keyEvent);
    }
    
    public void setButton(final int n, final CharSequence mButtonNeutralText, final DialogInterface$OnClickListener dialogInterface$OnClickListener, Message obtainMessage) {
        if (obtainMessage == null && dialogInterface$OnClickListener != null) {
            obtainMessage = this.mHandler.obtainMessage(n, (Object)dialogInterface$OnClickListener);
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException("Button does not exist");
            }
            case -1: {
                this.mButtonPositiveText = mButtonNeutralText;
                this.mButtonPositiveMessage = obtainMessage;
                break;
            }
            case -2: {
                this.mButtonNegativeText = mButtonNeutralText;
                this.mButtonNegativeMessage = obtainMessage;
                break;
            }
            case -3: {
                this.mButtonNeutralText = mButtonNeutralText;
                this.mButtonNeutralMessage = obtainMessage;
                break;
            }
        }
    }
    
    public void setButtonPanelLayoutHint(final int mButtonPanelLayoutHint) {
        this.mButtonPanelLayoutHint = mButtonPanelLayoutHint;
    }
    
    public void setCustomTitle(final View mCustomTitleView) {
        this.mCustomTitleView = mCustomTitleView;
    }
    
    public void setIcon(final int mIconId) {
        this.mIcon = null;
        this.mIconId = mIconId;
        final ImageView mIconView = this.mIconView;
        if (mIconView != null) {
            if (mIconId != 0) {
                mIconView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            }
            else {
                mIconView.setVisibility(8);
            }
        }
    }
    
    public void setIcon(final Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        final ImageView mIconView = this.mIconView;
        if (mIconView != null) {
            if (drawable != null) {
                mIconView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable);
            }
            else {
                mIconView.setVisibility(8);
            }
        }
    }
    
    public void setMessage(final CharSequence charSequence) {
        this.mMessage = charSequence;
        final TextView mMessageView = this.mMessageView;
        if (mMessageView != null) {
            mMessageView.setText(charSequence);
        }
    }
    
    public void setTitle(final CharSequence charSequence) {
        this.mTitle = charSequence;
        final TextView mTitleView = this.mTitleView;
        if (mTitleView != null) {
            mTitleView.setText(charSequence);
        }
    }
    
    public void setView(final int mViewLayoutResId) {
        this.mView = null;
        this.mViewLayoutResId = mViewLayoutResId;
        this.mViewSpacingSpecified = false;
    }
    
    public void setView(final View mView) {
        this.mView = mView;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }
    
    public void setView(final View mView, final int mViewSpacingLeft, final int mViewSpacingTop, final int mViewSpacingRight, final int mViewSpacingBottom) {
        this.mView = mView;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = mViewSpacingLeft;
        this.mViewSpacingTop = mViewSpacingTop;
        this.mViewSpacingRight = mViewSpacingRight;
        this.mViewSpacingBottom = mViewSpacingBottom;
    }
}
