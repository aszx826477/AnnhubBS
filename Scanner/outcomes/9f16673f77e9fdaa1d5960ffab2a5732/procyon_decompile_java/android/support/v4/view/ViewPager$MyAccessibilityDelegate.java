// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class ViewPager$MyAccessibilityDelegate extends AccessibilityDelegateCompat
{
    final /* synthetic */ ViewPager this$0;
    
    ViewPager$MyAccessibilityDelegate(final ViewPager this$0) {
        this.this$0 = this$0;
    }
    
    private boolean canScroll() {
        final PagerAdapter mAdapter = this.this$0.mAdapter;
        int n = 1;
        if (mAdapter == null || this.this$0.mAdapter.getCount() <= n) {
            n = 0;
        }
        return n != 0;
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
        final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(accessibilityEvent);
        record.setScrollable(this.canScroll());
        if (accessibilityEvent.getEventType() == 4096 && this.this$0.mAdapter != null) {
            record.setItemCount(this.this$0.mAdapter.getCount());
            record.setFromIndex(this.this$0.mCurItem);
            record.setToIndex(this.this$0.mCurItem);
        }
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
        accessibilityNodeInfoCompat.setScrollable(this.canScroll());
        if (this.this$0.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.addAction(4096);
        }
        if (this.this$0.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.addAction(8192);
        }
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        final boolean performAccessibilityAction = super.performAccessibilityAction(view, n, bundle);
        final int n2 = 1;
        if (performAccessibilityAction) {
            return n2 != 0;
        }
        if (n != 4096) {
            if (n != 8192) {
                return false;
            }
            if (this.this$0.canScrollHorizontally(-1)) {
                final ViewPager this$0 = this.this$0;
                this$0.setCurrentItem(this$0.mCurItem - n2);
                return n2 != 0;
            }
            return false;
        }
        else {
            if (this.this$0.canScrollHorizontally(n2)) {
                final ViewPager this$2 = this.this$0;
                this$2.setCurrentItem(this$2.mCurItem + n2);
                return n2 != 0;
            }
            return false;
        }
    }
}
