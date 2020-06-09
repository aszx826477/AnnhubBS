// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View$OnTouchListener;
import android.view.View;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.content.Context;

class ActionMenuPresenter$OverflowMenuButton extends AppCompatImageView implements ActionMenuView$ActionMenuChildView
{
    private final float[] mTempPts;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OverflowMenuButton(final ActionMenuPresenter this$0, final Context context) {
        this.this$0 = this$0;
        super(context, null, R$attr.actionOverflowButtonStyle);
        this.mTempPts = new float[2];
        final boolean enabled = true;
        this.setClickable(enabled);
        this.setFocusable(enabled);
        this.setVisibility(0);
        this.setEnabled(enabled);
        this.setOnTouchListener((View$OnTouchListener)new ActionMenuPresenter$OverflowMenuButton$1(this, (View)this, this$0));
    }
    
    public boolean needsDividerAfter() {
        return false;
    }
    
    public boolean needsDividerBefore() {
        return false;
    }
    
    public boolean performClick() {
        final boolean performClick = super.performClick();
        final boolean b = true;
        if (performClick) {
            return b;
        }
        this.playSoundEffect(0);
        this.this$0.showOverflowMenu();
        return b;
    }
    
    protected boolean setFrame(final int n, final int n2, final int n3, final int n4) {
        final boolean setFrame = super.setFrame(n, n2, n3, n4);
        final Drawable drawable = this.getDrawable();
        final Drawable background = this.getBackground();
        if (drawable != null && background != null) {
            final int width = this.getWidth();
            final int height = this.getHeight();
            final int n5 = Math.max(width, height) / 2;
            final int n6 = this.getPaddingLeft() - this.getPaddingRight();
            final int n7 = this.getPaddingTop() - this.getPaddingBottom();
            final int n8 = (width + n6) / 2;
            final int n9 = (height + n7) / 2;
            DrawableCompat.setHotspotBounds(background, n8 - n5, n9 - n5, n8 + n5, n9 + n5);
        }
        return setFrame;
    }
}
