// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.Build$VERSION;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.SubMenu;
import android.support.v7.appcompat.R$string;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.view.View;
import android.content.Context;
import android.support.v4.view.ActionProvider;

public class ShareActionProvider extends ActionProvider
{
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel$OnChooseActivityListener mOnChooseActivityListener;
    private final ShareActionProvider$ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    ShareActionProvider$OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName;
    
    public ShareActionProvider(final Context mContext) {
        super(mContext);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareActionProvider$ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = "share_history.xml";
        this.mContext = mContext;
    }
    
    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActionProvider$ShareActivityChooserModelPolicy(this);
        }
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }
    
    public boolean hasSubMenu() {
        return true;
    }
    
    public View onCreateActionView() {
        final ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
        }
        final TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R$attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R$string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R$string.abc_shareactionprovider_share_with);
        return (View)activityChooserView;
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
        subMenu.clear();
        final ActivityChooserModel value = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        final PackageManager packageManager = this.mContext.getPackageManager();
        final int activityCount = value.getActivityCount();
        final int min = Math.min(activityCount, this.mMaxShownActivityCount);
        for (int i = 0; i < min; ++i) {
            final ResolveInfo activity = value.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this.mOnMenuItemClickListener);
        }
        if (min < activityCount) {
            final SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, (CharSequence)this.mContext.getString(R$string.abc_activity_chooser_view_see_all));
            for (int j = 0; j < activityCount; ++j) {
                final ResolveInfo activity2 = value.getActivity(j);
                addSubMenu.add(0, j, j, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this.mOnMenuItemClickListener);
            }
        }
    }
    
    public void setOnShareTargetSelectedListener(final ShareActionProvider$OnShareTargetSelectedListener mOnShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = mOnShareTargetSelectedListener;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareHistoryFileName(final String mShareHistoryFileName) {
        this.mShareHistoryFileName = mShareHistoryFileName;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareIntent(final Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.updateIntent(intent);
            }
        }
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(intent);
    }
    
    void updateIntent(final Intent intent) {
        if (Build$VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        }
        else {
            intent.addFlags(524288);
        }
    }
}
