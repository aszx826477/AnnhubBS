// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

class ShareActionProvider$ShareMenuItemOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    ShareActionProvider$ShareMenuItemOnMenuItemClickListener(final ShareActionProvider this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        final Intent chooseActivity = ActivityChooserModel.get(this.this$0.mContext, this.this$0.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
        if (chooseActivity != null) {
            final String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.this$0.updateIntent(chooseActivity);
            }
            this.this$0.mContext.startActivity(chooseActivity);
        }
        return true;
    }
}
