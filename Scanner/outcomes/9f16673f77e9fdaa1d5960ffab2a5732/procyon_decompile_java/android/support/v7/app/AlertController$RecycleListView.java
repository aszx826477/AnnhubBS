// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ListView;

public class AlertController$RecycleListView extends ListView
{
    private final int mPaddingBottomNoButtons;
    private final int mPaddingTopNoTitle;
    
    public AlertController$RecycleListView(final Context context) {
        this(context, null);
    }
    
    public AlertController$RecycleListView(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.RecycleListView);
        final int recycleListView_paddingBottomNoButtons = R$styleable.RecycleListView_paddingBottomNoButtons;
        final int n = -1;
        this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(recycleListView_paddingBottomNoButtons, n);
        this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, n);
    }
    
    public void setHasDecor(final boolean b, final boolean b2) {
        if (!b2 || !b) {
            final int paddingLeft = this.getPaddingLeft();
            int n;
            if (b) {
                n = this.getPaddingTop();
            }
            else {
                n = this.mPaddingTopNoTitle;
            }
            final int paddingRight = this.getPaddingRight();
            int n2;
            if (b2) {
                n2 = this.getPaddingBottom();
            }
            else {
                n2 = this.mPaddingBottomNoButtons;
            }
            this.setPadding(paddingLeft, n, paddingRight, n2);
        }
    }
}
