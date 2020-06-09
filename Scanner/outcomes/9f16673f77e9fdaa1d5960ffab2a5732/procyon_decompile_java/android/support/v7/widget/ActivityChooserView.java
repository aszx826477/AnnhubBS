// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.appcompat.R$string;
import android.view.View$MeasureSpec;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.view.ViewTreeObserver;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$dimen;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$layout;
import android.view.LayoutInflater;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;
import android.database.DataSetObserver;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModel$ActivityChooserModelClient
{
    private static final String LOG_TAG = "ActivityChooserView";
    private final LinearLayoutCompat mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserView$ActivityChooserViewAdapter mAdapter;
    private final ActivityChooserView$Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow$OnDismissListener mOnDismissListener;
    private final ViewTreeObserver$OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;
    
    public ActivityChooserView(final Context context) {
        this(context, null);
    }
    
    public ActivityChooserView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActivityChooserView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mModelDataSetObserver = new ActivityChooserView$1(this);
        this.mOnGlobalLayoutListener = (ViewTreeObserver$OnGlobalLayoutListener)new ActivityChooserView$2(this);
        final int mInitialActivityCount = 4;
        this.mInitialActivityCount = mInitialActivityCount;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.ActivityChooserView, n, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, mInitialActivityCount);
        final Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(this.getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup)this, true);
        this.mCallbacks = new ActivityChooserView$Callbacks(this);
        this.mActivityChooserContent = (LinearLayoutCompat)this.findViewById(R$id.activity_chooser_view_content);
        this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
        (this.mDefaultActivityButton = (FrameLayout)this.findViewById(R$id.default_activity_button)).setOnClickListener((View$OnClickListener)this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener((View$OnLongClickListener)this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView)this.mDefaultActivityButton.findViewById(R$id.image);
        final FrameLayout mExpandActivityOverflowButton = (FrameLayout)this.findViewById(R$id.expand_activities_button);
        mExpandActivityOverflowButton.setOnClickListener((View$OnClickListener)this.mCallbacks);
        mExpandActivityOverflowButton.setOnTouchListener((View$OnTouchListener)new ActivityChooserView$3(this, (View)mExpandActivityOverflowButton));
        this.mExpandActivityOverflowButton = mExpandActivityOverflowButton;
        (this.mExpandActivityOverflowButtonImage = (ImageView)mExpandActivityOverflowButton.findViewById(R$id.image)).setImageDrawable(drawable);
        (this.mAdapter = new ActivityChooserView$ActivityChooserViewAdapter(this)).registerDataSetObserver((DataSetObserver)new ActivityChooserView$4(this));
        final Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
    
    public boolean dismissPopup() {
        if (this.isShowingPopup()) {
            this.getListPopupWindow().dismiss();
            final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
        }
        return true;
    }
    
    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }
    
    ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            (this.mListPopupWindow = new ListPopupWindow(this.getContext())).setAdapter((ListAdapter)this.mAdapter);
            this.mListPopupWindow.setAnchorView((View)this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener((AdapterView$OnItemClickListener)this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener((PopupWindow$OnDismissListener)this.mCallbacks);
        }
        return this.mListPopupWindow;
    }
    
    public boolean isShowingPopup() {
        return this.getListPopupWindow().isShowing();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver((Object)this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver((Object)this.mModelDataSetObserver);
        }
        final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (this.isShowingPopup()) {
            this.dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.mActivityChooserContent.layout(0, 0, n3 - n, n4 - n2);
        if (!this.isShowingPopup()) {
            this.dismissPopup();
        }
    }
    
    protected void onMeasure(final int n, int measureSpec) {
        final LinearLayoutCompat mActivityChooserContent = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(measureSpec), 1073741824);
        }
        this.measureChild((View)mActivityChooserContent, n, measureSpec);
        this.setMeasuredDimension(((View)mActivityChooserContent).getMeasuredWidth(), ((View)mActivityChooserContent).getMeasuredHeight());
    }
    
    public void setActivityChooserModel(final ActivityChooserModel dataModel) {
        this.mAdapter.setDataModel(dataModel);
        if (this.isShowingPopup()) {
            this.dismissPopup();
            this.showPopup();
        }
    }
    
    public void setDefaultActionButtonContentDescription(final int mDefaultActionButtonContentDescription) {
        this.mDefaultActionButtonContentDescription = mDefaultActionButtonContentDescription;
    }
    
    public void setExpandActivityOverflowButtonContentDescription(final int n) {
        this.mExpandActivityOverflowButtonImage.setContentDescription((CharSequence)this.getContext().getString(n));
    }
    
    public void setExpandActivityOverflowButtonDrawable(final Drawable imageDrawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(imageDrawable);
    }
    
    public void setInitialActivityCount(final int mInitialActivityCount) {
        this.mInitialActivityCount = mInitialActivityCount;
    }
    
    public void setOnDismissListener(final PopupWindow$OnDismissListener mOnDismissListener) {
        this.mOnDismissListener = mOnDismissListener;
    }
    
    public void setProvider(final ActionProvider mProvider) {
        this.mProvider = mProvider;
    }
    
    public boolean showPopup() {
        if (!this.isShowingPopup() && this.mIsAttachedToWindow) {
            this.mIsSelectingDefaultActivity = false;
            this.showPopupUnchecked(this.mInitialActivityCount);
            return true;
        }
        return false;
    }
    
    void showPopupUnchecked(final int maxActivityCount) {
        if (this.mAdapter.getDataModel() != null) {
            this.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            final int visibility = this.mDefaultActivityButton.getVisibility();
            final boolean showFooterView = true;
            final boolean b = visibility == 0;
            final int activityCount = this.mAdapter.getActivityCount();
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (maxActivityCount != -1 >>> 1 && activityCount > maxActivityCount + n) {
                this.mAdapter.setShowFooterView(showFooterView);
                this.mAdapter.setMaxActivityCount(maxActivityCount - 1);
            }
            else {
                this.mAdapter.setShowFooterView(false);
                this.mAdapter.setMaxActivityCount(maxActivityCount);
            }
            final ListPopupWindow listPopupWindow = this.getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (!this.mIsSelectingDefaultActivity && b) {
                    this.mAdapter.setShowDefaultActivity(false, false);
                }
                else {
                    this.mAdapter.setShowDefaultActivity(showFooterView, b);
                }
                listPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
                listPopupWindow.show();
                final ActionProvider mProvider = this.mProvider;
                if (mProvider != null) {
                    mProvider.subUiVisibilityChanged(showFooterView);
                }
                listPopupWindow.getListView().setContentDescription((CharSequence)this.getContext().getString(R$string.abc_activitychooserview_choose_application));
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    
    void updateAppearance() {
        final int count = this.mAdapter.getCount();
        final int enabled = 1;
        if (count > 0) {
            this.mExpandActivityOverflowButton.setEnabled((boolean)(enabled != 0));
        }
        else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        final int activityCount = this.mAdapter.getActivityCount();
        final int historySize = this.mAdapter.getHistorySize();
        if (activityCount != enabled && (activityCount <= enabled || historySize <= 0)) {
            this.mDefaultActivityButton.setVisibility(8);
        }
        else {
            this.mDefaultActivityButton.setVisibility(0);
            final ResolveInfo defaultActivity = this.mAdapter.getDefaultActivity();
            final PackageManager packageManager = this.getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                final CharSequence loadLabel = defaultActivity.loadLabel(packageManager);
                final Context context = this.getContext();
                final int mDefaultActionButtonContentDescription = this.mDefaultActionButtonContentDescription;
                final Object[] array = new Object[enabled];
                array[0] = loadLabel;
                this.mDefaultActivityButton.setContentDescription((CharSequence)context.getString(mDefaultActionButtonContentDescription, array));
            }
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        }
        else {
            this.mActivityChooserContent.setBackgroundDrawable((Drawable)null);
        }
    }
}
