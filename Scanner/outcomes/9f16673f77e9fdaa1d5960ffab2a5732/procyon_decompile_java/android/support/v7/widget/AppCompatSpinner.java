// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.content.res.AppCompatResources;
import android.widget.ListAdapter;
import android.widget.Adapter;
import android.view.MotionEvent;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$layout;
import android.widget.ArrayAdapter;
import android.os.Build$VERSION;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.support.v7.appcompat.R$styleable;
import android.content.res.Resources$Theme;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.graphics.Rect;
import android.widget.SpinnerAdapter;
import android.content.Context;
import android.support.v4.view.TintableBackgroundView;
import android.widget.Spinner;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView
{
    private static final int[] ATTRS_ANDROID_SPINNERMODE;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = 255;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private AppCompatSpinner$DropdownPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    private final Rect mTempRect;
    
    static {
        ATTRS_ANDROID_SPINNERMODE = new int[] { 16843505 };
    }
    
    public AppCompatSpinner(final Context context) {
        this(context, null);
    }
    
    public AppCompatSpinner(final Context context, final int n) {
        this(context, null, R$attr.spinnerStyle, n);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set) {
        this(context, set, R$attr.spinnerStyle);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, -1);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n, final int n2) {
        this(context, set, n, n2, null);
    }
    
    public AppCompatSpinner(final Context context, final AttributeSet set, final int n, int int1, final Resources$Theme resources$Theme) {
        super(context, set, n);
        this.mTempRect = new Rect();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.Spinner, n, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
        if (resources$Theme != null) {
            this.mPopupContext = (Context)new ContextThemeWrapper(context, resources$Theme);
        }
        else {
            final int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.mPopupContext = (Context)new ContextThemeWrapper(context, resourceId);
            }
            else {
                Context mPopupContext;
                if (Build$VERSION.SDK_INT < 23) {
                    mPopupContext = context;
                }
                else {
                    mPopupContext = null;
                }
                this.mPopupContext = mPopupContext;
            }
        }
        final Context mPopupContext2 = this.mPopupContext;
        final boolean mPopupSet = true;
        if (mPopupContext2 != null) {
            Label_0337: {
                if (int1 == -1) {
                    if (Build$VERSION.SDK_INT >= 11) {
                        TypedArray obtainStyledAttributes2 = null;
                        try {
                            Label_0312: {
                                try {
                                    final TypedArray typedArray = obtainStyledAttributes2 = context.obtainStyledAttributes(set, AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE, n, 0);
                                    if (typedArray.hasValue(0)) {
                                        int1 = typedArray.getInt(0, 0);
                                    }
                                    if (obtainStyledAttributes2 != null) {
                                        obtainStyledAttributes2.recycle();
                                    }
                                    break Label_0312;
                                }
                                finally {
                                    if (obtainStyledAttributes2 != null) {
                                        obtainStyledAttributes2.recycle();
                                    }
                                    break Label_0337;
                                }
                            }
                        }
                        catch (Exception ex) {}
                    }
                    int1 = 1;
                }
            }
            if (int1 == (mPopupSet ? 1 : 0)) {
                final AppCompatSpinner$DropdownPopup mPopup = new AppCompatSpinner$DropdownPopup(this, this.mPopupContext, set, n);
                final TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, set, R$styleable.Spinner, n, 0);
                this.mDropDownWidth = obtainStyledAttributes3.getLayoutDimension(R$styleable.Spinner_android_dropDownWidth, -2);
                mPopup.setBackgroundDrawable(obtainStyledAttributes3.getDrawable(R$styleable.Spinner_android_popupBackground));
                mPopup.setPromptText(obtainStyledAttributes.getString(R$styleable.Spinner_android_prompt));
                obtainStyledAttributes3.recycle();
                this.mPopup = mPopup;
                this.mForwardingListener = new AppCompatSpinner$1(this, (View)this, mPopup);
            }
        }
        final CharSequence[] textArray = obtainStyledAttributes.getTextArray(R$styleable.Spinner_android_entries);
        if (textArray != null) {
            final ArrayAdapter adapter = new ArrayAdapter(context, 17367048, (Object[])textArray);
            adapter.setDropDownViewResource(R$layout.support_simple_spinner_dropdown_item);
            this.setAdapter((SpinnerAdapter)adapter);
        }
        obtainStyledAttributes.recycle();
        this.mPopupSet = mPopupSet;
        final SpinnerAdapter mTempAdapter = this.mTempAdapter;
        if (mTempAdapter != null) {
            this.setAdapter(mTempAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(set, n);
    }
    
    int compatMeasureContentWidth(final SpinnerAdapter spinnerAdapter, final Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int max = 0;
        View view = null;
        int n = 0;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
        final int max2 = Math.max(0, this.getSelectedItemPosition());
        for (int min = Math.min(spinnerAdapter.getCount(), max2 + 15), i = Math.max(0, max2 - (15 - (min - max2))); i < min; ++i) {
            final int itemViewType = spinnerAdapter.getItemViewType(i);
            if (itemViewType != n) {
                n = itemViewType;
                view = null;
            }
            view = spinnerAdapter.getView(i, view, (ViewGroup)this);
            if (view.getLayoutParams() == null) {
                final int n2 = -2;
                view.setLayoutParams(new ViewGroup$LayoutParams(n2, n2));
            }
            view.measure(measureSpec, measureSpec2);
            max = Math.max(max, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            max += this.mTempRect.left + this.mTempRect.right;
        }
        return max;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySupportBackgroundTint();
        }
    }
    
    public int getDropDownHorizontalOffset() {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            return mPopup.getHorizontalOffset();
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }
    
    public int getDropDownVerticalOffset() {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            return mPopup.getVerticalOffset();
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }
    
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }
    
    public Drawable getPopupBackground() {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            return mPopup.getBackground();
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }
    
    public Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        if (Build$VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }
    
    public CharSequence getPrompt() {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        CharSequence charSequence;
        if (mPopup != null) {
            charSequence = mPopup.getHintText();
        }
        else {
            charSequence = super.getPrompt();
        }
        return charSequence;
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        ColorStateList supportBackgroundTintList;
        if (mBackgroundTintHelper != null) {
            supportBackgroundTintList = mBackgroundTintHelper.getSupportBackgroundTintList();
        }
        else {
            supportBackgroundTintList = null;
        }
        return supportBackgroundTintList;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        PorterDuff$Mode supportBackgroundTintMode;
        if (mBackgroundTintHelper != null) {
            supportBackgroundTintMode = mBackgroundTintHelper.getSupportBackgroundTintMode();
        }
        else {
            supportBackgroundTintMode = null;
        }
        return supportBackgroundTintMode;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null && mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mPopup != null && View$MeasureSpec.getMode(n) == -1 << -1) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(n)), this.getMeasuredHeight());
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final ForwardingListener mForwardingListener = this.mForwardingListener;
        return (mForwardingListener != null && mForwardingListener.onTouch((View)this, motionEvent)) || super.onTouchEvent(motionEvent);
    }
    
    public boolean performClick() {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            if (!mPopup.isShowing()) {
                this.mPopup.show();
            }
            return true;
        }
        return super.performClick();
    }
    
    public void setAdapter(final SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = this.getContext();
            }
            this.mPopup.setAdapter((ListAdapter)new AppCompatSpinner$DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundDrawable(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(backgroundResource);
        }
    }
    
    public void setDropDownHorizontalOffset(final int n) {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            mPopup.setHorizontalOffset(n);
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(n);
        }
    }
    
    public void setDropDownVerticalOffset(final int n) {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            mPopup.setVerticalOffset(n);
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(n);
        }
    }
    
    public void setDropDownWidth(final int n) {
        if (this.mPopup != null) {
            this.mDropDownWidth = n;
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(n);
        }
    }
    
    public void setPopupBackgroundDrawable(final Drawable drawable) {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            mPopup.setBackgroundDrawable(drawable);
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }
    
    public void setPopupBackgroundResource(final int n) {
        this.setPopupBackgroundDrawable(AppCompatResources.getDrawable(this.getPopupContext(), n));
    }
    
    public void setPrompt(final CharSequence charSequence) {
        final AppCompatSpinner$DropdownPopup mPopup = this.mPopup;
        if (mPopup != null) {
            mPopup.setPromptText(charSequence);
        }
        else {
            super.setPrompt(charSequence);
        }
    }
    
    public void setSupportBackgroundTintList(final ColorStateList supportBackgroundTintList) {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode supportBackgroundTintMode) {
        final AppCompatBackgroundHelper mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
}
