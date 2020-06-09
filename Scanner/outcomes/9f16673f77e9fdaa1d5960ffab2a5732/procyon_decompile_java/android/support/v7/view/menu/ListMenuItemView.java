// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.widget.CompoundButton;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.support.v7.appcompat.R$id;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.appcompat.R$layout;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.TextView;
import android.widget.RadioButton;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.CheckBox;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class ListMenuItemView extends LinearLayout implements MenuView$ItemView
{
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private boolean mForceShowIcon;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private int mMenuType;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;
    
    public ListMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, R$attr.listMenuViewStyle);
    }
    
    public ListMenuItemView(final Context mTextAppearanceContext, final AttributeSet set, final int n) {
        super(mTextAppearanceContext, set);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, R$styleable.MenuView, n, 0);
        this.mBackground = obtainStyledAttributes.getDrawable(R$styleable.MenuView_android_itemBackground);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = obtainStyledAttributes.getBoolean(R$styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = mTextAppearanceContext;
        this.mSubMenuArrow = obtainStyledAttributes.getDrawable(R$styleable.MenuView_subMenuArrow);
        obtainStyledAttributes.recycle();
    }
    
    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.getContext());
        }
        return this.mInflater;
    }
    
    private void insertCheckBox() {
        this.addView((View)(this.mCheckBox = (CheckBox)this.getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup)this, false)));
    }
    
    private void insertIconView() {
        this.addView((View)(this.mIconView = (ImageView)this.getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup)this, false)), 0);
    }
    
    private void insertRadioButton() {
        this.addView((View)(this.mRadioButton = (RadioButton)this.getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup)this, false)));
    }
    
    private void setSubMenuArrowVisible(final boolean b) {
        final ImageView mSubMenuArrowView = this.mSubMenuArrowView;
        if (mSubMenuArrowView != null) {
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            mSubMenuArrowView.setVisibility(visibility);
        }
    }
    
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int mMenuType) {
        this.mItemData = mItemData;
        this.mMenuType = mMenuType;
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setTitle(mItemData.getTitleForItemView(this));
        this.setCheckable(mItemData.isCheckable());
        this.setShortcut(mItemData.shouldShowShortcut(), mItemData.getShortcut());
        this.setIcon(mItemData.getIcon());
        this.setEnabled(mItemData.isEnabled());
        this.setSubMenuArrowVisible(mItemData.hasSubMenu());
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground((View)this, this.mBackground);
        this.mTitleView = (TextView)this.findViewById(R$id.title);
        final int mTextAppearance = this.mTextAppearance;
        if (mTextAppearance != -1) {
            this.mTitleView.setTextAppearance(this.mTextAppearanceContext, mTextAppearance);
        }
        this.mShortcutView = (TextView)this.findViewById(R$id.shortcut);
        this.mSubMenuArrowView = (ImageView)this.findViewById(R$id.submenuarrow);
        final ImageView mSubMenuArrowView = this.mSubMenuArrowView;
        if (mSubMenuArrowView != null) {
            mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.mIconView.getLayoutParams();
            if (layoutParams.height > 0 && linearLayout$LayoutParams.width <= 0) {
                linearLayout$LayoutParams.width = layoutParams.height;
            }
        }
        super.onMeasure(n, n2);
    }
    
    public boolean prefersCondensedTitle() {
        return false;
    }
    
    public void setCheckable(final boolean b) {
        if (!b && this.mRadioButton == null && this.mCheckBox == null) {
            return;
        }
        Object o;
        Object o2;
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                this.insertRadioButton();
            }
            o = this.mRadioButton;
            o2 = this.mCheckBox;
        }
        else {
            if (this.mCheckBox == null) {
                this.insertCheckBox();
            }
            o = this.mCheckBox;
            o2 = this.mRadioButton;
        }
        final int visibility = 8;
        if (b) {
            ((CompoundButton)o).setChecked(this.mItemData.isChecked());
            int visibility2;
            if (b) {
                visibility2 = 0;
            }
            else {
                visibility2 = 8;
            }
            if (((CompoundButton)o).getVisibility() != visibility2) {
                ((CompoundButton)o).setVisibility(visibility2);
            }
            if (o2 != null && ((CompoundButton)o2).getVisibility() != visibility) {
                ((CompoundButton)o2).setVisibility(visibility);
            }
        }
        else {
            final CheckBox mCheckBox = this.mCheckBox;
            if (mCheckBox != null) {
                mCheckBox.setVisibility(visibility);
            }
            final RadioButton mRadioButton = this.mRadioButton;
            if (mRadioButton != null) {
                mRadioButton.setVisibility(visibility);
            }
        }
    }
    
    public void setChecked(final boolean checked) {
        Object o;
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                this.insertRadioButton();
            }
            o = this.mRadioButton;
        }
        else {
            if (this.mCheckBox == null) {
                this.insertCheckBox();
            }
            o = this.mCheckBox;
        }
        ((CompoundButton)o).setChecked(checked);
    }
    
    public void setForceShowIcon(final boolean b) {
        this.mForceShowIcon = b;
        this.mPreserveIconSpacing = b;
    }
    
    public void setIcon(final Drawable drawable) {
        final boolean b = this.mItemData.shouldShowIcon() || this.mForceShowIcon;
        if (!b && !this.mPreserveIconSpacing) {
            return;
        }
        if (this.mIconView == null && drawable == null && !this.mPreserveIconSpacing) {
            return;
        }
        if (this.mIconView == null) {
            this.insertIconView();
        }
        if (drawable == null && !this.mPreserveIconSpacing) {
            this.mIconView.setVisibility(8);
        }
        else {
            final ImageView mIconView = this.mIconView;
            Drawable imageDrawable;
            if (b) {
                imageDrawable = drawable;
            }
            else {
                imageDrawable = null;
            }
            mIconView.setImageDrawable(imageDrawable);
            if (this.mIconView.getVisibility() != 0) {
                this.mIconView.setVisibility(0);
            }
        }
    }
    
    public void setShortcut(final boolean b, final char c) {
        int visibility;
        if (b && this.mItemData.shouldShowShortcut()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        if (visibility == 0) {
            this.mShortcutView.setText((CharSequence)this.mItemData.getShortcutLabel());
        }
        if (this.mShortcutView.getVisibility() != visibility) {
            this.mShortcutView.setVisibility(visibility);
        }
    }
    
    public void setTitle(final CharSequence text) {
        if (text != null) {
            this.mTitleView.setText(text);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        }
        else {
            final int visibility = this.mTitleView.getVisibility();
            final int visibility2 = 8;
            if (visibility != visibility2) {
                this.mTitleView.setVisibility(visibility2);
            }
        }
    }
    
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}
