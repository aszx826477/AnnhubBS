// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.MotionEvent;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import android.support.v4.view.ViewCompat;
import android.graphics.Rect;
import android.view.View;
import android.text.TextUtils;
import android.content.res.Configuration;
import android.support.v4.content.res.ConfigurationHelper;
import android.content.res.TypedArray;
import android.content.res.Resources;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.ActionMenuView$ActionMenuChildView;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.support.v7.widget.AppCompatTextView;

public class ActionMenuItemView extends AppCompatTextView implements MenuView$ItemView, View$OnClickListener, View$OnLongClickListener, ActionMenuView$ActionMenuChildView
{
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder$ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    ActionMenuItemView$PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;
    
    public ActionMenuItemView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final Resources resources = context.getResources();
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.ActionMenuItemView, n, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int)(32.0f * resources.getDisplayMetrics().density + 0.5f);
        this.setOnClickListener((View$OnClickListener)this);
        this.setOnLongClickListener((View$OnLongClickListener)this);
        this.mSavedPaddingLeft = -1;
        this.setSaveEnabled(false);
    }
    
    private boolean shouldAllowTextWithIcon() {
        final Configuration configuration = this.getContext().getResources().getConfiguration();
        final int screenWidthDp = ConfigurationHelper.getScreenWidthDp(this.getResources());
        final int screenHeightDp = ConfigurationHelper.getScreenHeightDp(this.getResources());
        final int n = 480;
        return screenWidthDp >= n || (screenWidthDp >= 640 && screenHeightDp >= n) || configuration.orientation == 2;
    }
    
    private void updateTextButtonVisibility() {
        final boolean empty = TextUtils.isEmpty(this.mTitle);
        boolean b = true;
        final boolean b2 = empty ^ b;
        if (this.mIcon != null) {
            if (!this.mItemData.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat)) {
                b = false;
            }
        }
        CharSequence mTitle;
        if (b2 & b) {
            mTitle = this.mTitle;
        }
        else {
            mTitle = null;
        }
        this.setText(mTitle);
    }
    
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
    
    public boolean hasText() {
        return TextUtils.isEmpty(this.getText()) ^ true;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        this.setIcon(mItemData.getIcon());
        this.setTitle(mItemData.getTitleForItemView(this));
        this.setId(mItemData.getItemId());
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setEnabled(mItemData.isEnabled());
        if (mItemData.hasSubMenu()) {
            if (this.mForwardingListener == null) {
                this.mForwardingListener = new ActionMenuItemView$ActionMenuItemForwardingListener(this);
            }
        }
    }
    
    public boolean needsDividerAfter() {
        return this.hasText();
    }
    
    public boolean needsDividerBefore() {
        return this.hasText() && this.mItemData.getIcon() == null;
    }
    
    public void onClick(final View view) {
        final MenuBuilder$ItemInvoker mItemInvoker = this.mItemInvoker;
        if (mItemInvoker != null) {
            mItemInvoker.invokeItem(this.mItemData);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        this.updateTextButtonVisibility();
    }
    
    public boolean onLongClick(final View view) {
        if (this.hasText()) {
            return false;
        }
        final int[] array = new int[2];
        final Rect rect = new Rect();
        this.getLocationOnScreen(array);
        this.getWindowVisibleDisplayFrame(rect);
        final Context context = this.getContext();
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int n = 1;
        final int n2 = array[n] + height / 2;
        int n3 = array[0] + width / 2;
        if (ViewCompat.getLayoutDirection(view) == 0) {
            n3 = context.getResources().getDisplayMetrics().widthPixels - n3;
        }
        final Toast text = Toast.makeText(context, this.mItemData.getTitle(), 0);
        if (n2 < rect.height()) {
            text.setGravity(8388661, n3, array[n] + height - rect.top);
        }
        else {
            text.setGravity(81, 0, height);
        }
        text.show();
        return n != 0;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final boolean hasText = this.hasText();
        if (hasText) {
            final int mSavedPaddingLeft = this.mSavedPaddingLeft;
            if (mSavedPaddingLeft >= 0) {
                super.setPadding(mSavedPaddingLeft, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
            }
        }
        super.onMeasure(n, n2);
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int measuredWidth = this.getMeasuredWidth();
        int n3;
        if (mode == -1 << -1) {
            n3 = Math.min(size, this.mMinWidth);
        }
        else {
            n3 = this.mMinWidth;
        }
        final int n4 = 1073741824;
        if (mode != n4 && this.mMinWidth > 0 && measuredWidth < n3) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(n3, n4), n2);
        }
        if (!hasText && this.mIcon != null) {
            super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable)null);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.mItemData.hasSubMenu()) {
            final ForwardingListener mForwardingListener = this.mForwardingListener;
            if (mForwardingListener != null) {
                if (mForwardingListener.onTouch((View)this, motionEvent)) {
                    return true;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public boolean prefersCondensedTitle() {
        return true;
    }
    
    public void setCheckable(final boolean b) {
    }
    
    public void setChecked(final boolean b) {
    }
    
    public void setExpandedFormat(final boolean mExpandedFormat) {
        if (this.mExpandedFormat != mExpandedFormat) {
            this.mExpandedFormat = mExpandedFormat;
            final MenuItemImpl mItemData = this.mItemData;
            if (mItemData != null) {
                mItemData.actionFormatChanged();
            }
        }
    }
    
    public void setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        if (mIcon != null) {
            int n = mIcon.getIntrinsicWidth();
            int n2 = mIcon.getIntrinsicHeight();
            final int mMaxIconSize = this.mMaxIconSize;
            if (n > mMaxIconSize) {
                final float n3 = mMaxIconSize / n;
                n = this.mMaxIconSize;
                n2 *= (int)n3;
            }
            final int mMaxIconSize2 = this.mMaxIconSize;
            if (n2 > mMaxIconSize2) {
                final float n4 = mMaxIconSize2 / n2;
                n2 = this.mMaxIconSize;
                n *= (int)n4;
            }
            mIcon.setBounds(0, 0, n, n2);
        }
        this.setCompoundDrawables(mIcon, (Drawable)null, (Drawable)null, (Drawable)null);
        this.updateTextButtonVisibility();
    }
    
    public void setItemInvoker(final MenuBuilder$ItemInvoker mItemInvoker) {
        this.mItemInvoker = mItemInvoker;
    }
    
    public void setPadding(final int mSavedPaddingLeft, final int n, final int n2, final int n3) {
        super.setPadding(this.mSavedPaddingLeft = mSavedPaddingLeft, n, n2, n3);
    }
    
    public void setPopupCallback(final ActionMenuItemView$PopupCallback mPopupCallback) {
        this.mPopupCallback = mPopupCallback;
    }
    
    public void setShortcut(final boolean b, final char c) {
    }
    
    public void setTitle(final CharSequence mTitle) {
        this.setContentDescription(this.mTitle = mTitle);
        this.updateTextButtonVisibility();
    }
    
    public boolean showsIcon() {
        return true;
    }
}
