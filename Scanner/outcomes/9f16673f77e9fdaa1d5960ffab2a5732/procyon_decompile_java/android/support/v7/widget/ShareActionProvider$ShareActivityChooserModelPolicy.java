// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.Intent;

class ShareActionProvider$ShareActivityChooserModelPolicy implements ActivityChooserModel$OnChooseActivityListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    ShareActionProvider$ShareActivityChooserModelPolicy(final ShareActionProvider this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onChooseActivity(final ActivityChooserModel activityChooserModel, final Intent intent) {
        if (this.this$0.mOnShareTargetSelectedListener != null) {
            this.this$0.mOnShareTargetSelectedListener.onShareTargetSelected(this.this$0, intent);
        }
        return false;
    }
}
