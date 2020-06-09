// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.widget.PopupWindowCompat;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.widget.ListView;
import android.view.View$OnTouchListener;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.util.Log;
import android.widget.PopupWindow;
import android.database.DataSetObserver;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.os.Handler;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Context;
import android.widget.ListAdapter;
import java.lang.reflect.Method;
import android.support.v7.view.menu.ShowableListMenu;

public class ListPopupWindow implements ShowableListMenu
{
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = 255;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = 254;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListPopupWindow$ListSelectorHider mHideSelector;
    private boolean mIsAnimatedFromAnchor;
    private AdapterView$OnItemClickListener mItemClickListener;
    private AdapterView$OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ListPopupWindow$ResizePopupRunnable mResizePopupRunnable;
    private final ListPopupWindow$PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final ListPopupWindow$PopupTouchInterceptor mTouchInterceptor;
    
    static {
        final int n = 1;
        final Class<PopupWindow> clazz = PopupWindow.class;
        final String s = "setClipToScreenEnabled";
        try {
            final Class[] array = new Class[n];
            try {
                array[0] = Boolean.TYPE;
                final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                try {
                    ListPopupWindow.sClipToWindowEnabledMethod = declaredMethod;
                }
                catch (NoSuchMethodException ex) {
                    Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
            catch (NoSuchMethodException ex2) {}
        }
        catch (NoSuchMethodException ex3) {}
        final Class<PopupWindow> clazz2 = PopupWindow.class;
        final String s2 = "getMaxAvailableHeight";
        final int n2 = 3;
        try {
            final Class[] array2 = new Class[n2];
            array2[0] = View.class;
            array2[n] = Integer.TYPE;
            array2[2] = Boolean.TYPE;
            final Method declaredMethod2 = clazz2.getDeclaredMethod(s2, (Class[])array2);
            try {
                ListPopupWindow.sGetMaxAvailableHeightMethod = declaredMethod2;
            }
            catch (NoSuchMethodException ex4) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
        catch (NoSuchMethodException ex5) {}
        final Class<PopupWindow> clazz3 = PopupWindow.class;
        final String s3 = "setEpicenterBounds";
        try {
            final Class[] array3 = new Class[n];
            array3[0] = Rect.class;
            final Method declaredMethod3 = clazz3.getDeclaredMethod(s3, (Class[])array3);
            try {
                ListPopupWindow.sSetEpicenterBoundsMethod = declaredMethod3;
            }
            catch (NoSuchMethodException ex6) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        catch (NoSuchMethodException ex7) {}
    }
    
    public ListPopupWindow(final Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }
    
    public ListPopupWindow(final Context context, final AttributeSet set) {
        this(context, set, R$attr.listPopupWindowStyle);
    }
    
    public ListPopupWindow(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public ListPopupWindow(final Context mContext, final AttributeSet set, final int n, final int n2) {
        final int n3 = -2;
        this.mDropDownHeight = n3;
        this.mDropDownWidth = n3;
        this.mDropDownWindowLayoutType = 1002;
        final int inputMethodMode = 1;
        this.mIsAnimatedFromAnchor = (inputMethodMode != 0);
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = -1 >>> 1;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ListPopupWindow$ResizePopupRunnable(this);
        this.mTouchInterceptor = new ListPopupWindow$PopupTouchInterceptor(this);
        this.mScrollListener = new ListPopupWindow$PopupScrollListener(this);
        this.mHideSelector = new ListPopupWindow$ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = mContext;
        this.mHandler = new Handler(mContext.getMainLooper());
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes(set, R$styleable.ListPopupWindow, n, n2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = (inputMethodMode != 0);
        }
        obtainStyledAttributes.recycle();
        if (Build$VERSION.SDK_INT >= 11) {
            this.mPopup = new AppCompatPopupWindow(mContext, set, n, n2);
        }
        else {
            this.mPopup = new AppCompatPopupWindow(mContext, set, n);
        }
        this.mPopup.setInputMethodMode(inputMethodMode);
    }
    
    private int buildDropDown() {
        int n = 0;
        final DropDownListView mDropDownList = this.mDropDownList;
        final int n2 = -1;
        boolean b = false;
        final int orientation = 1;
        if (mDropDownList == null) {
            final Context mContext = this.mContext;
            this.mShowDropDownRunnable = new ListPopupWindow$2(this);
            this.mDropDownList = this.createDropDownListView(mContext, ((this.mModal ? 1 : 0) ^ orientation) != 0x0);
            final Drawable mDropDownListHighlight = this.mDropDownListHighlight;
            if (mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable((boolean)(orientation != 0));
            this.mDropDownList.setFocusableInTouchMode((boolean)(orientation != 0));
            this.mDropDownList.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new ListPopupWindow$3(this));
            this.mDropDownList.setOnScrollListener((AbsListView$OnScrollListener)this.mScrollListener);
            final AdapterView$OnItemSelectedListener mItemSelectedListener = this.mItemSelectedListener;
            if (mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            }
            Object mDropDownList2 = this.mDropDownList;
            final View mPromptView = this.mPromptView;
            if (mPromptView != null) {
                final LinearLayout linearLayout = new LinearLayout(mContext);
                linearLayout.setOrientation(orientation);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(n2, 0, 1.0f);
                switch (this.mPromptPosition) {
                    default: {
                        final String s = "ListPopupWindow";
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid hint position ");
                        sb.append(this.mPromptPosition);
                        Log.e(s, sb.toString());
                        break;
                    }
                    case 1: {
                        linearLayout.addView((View)mDropDownList2, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        linearLayout.addView(mPromptView);
                        break;
                    }
                    case 0: {
                        linearLayout.addView(mPromptView);
                        linearLayout.addView((View)mDropDownList2, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        break;
                    }
                }
                int n3;
                int mDropDownWidth;
                if (this.mDropDownWidth >= 0) {
                    n3 = -1 << -1;
                    mDropDownWidth = this.mDropDownWidth;
                }
                else {
                    n3 = 0;
                    mDropDownWidth = 0;
                }
                mPromptView.measure(View$MeasureSpec.makeMeasureSpec(mDropDownWidth, n3), 0);
                final LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams)mPromptView.getLayoutParams();
                final int n4 = mPromptView.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
                mDropDownList2 = linearLayout;
                n = n4;
            }
            this.mPopup.setContentView((View)mDropDownList2);
        }
        else {
            final ViewGroup viewGroup = (ViewGroup)this.mPopup.getContentView();
            final View mPromptView2 = this.mPromptView;
            if (mPromptView2 != null) {
                final LinearLayout$LayoutParams linearLayout$LayoutParams3 = (LinearLayout$LayoutParams)mPromptView2.getLayoutParams();
                n = mPromptView2.getMeasuredHeight() + linearLayout$LayoutParams3.topMargin + linearLayout$LayoutParams3.bottomMargin;
            }
        }
        final Drawable background = this.mPopup.getBackground();
        int n5;
        if (background != null) {
            background.getPadding(this.mTempRect);
            n5 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
        }
        else {
            this.mTempRect.setEmpty();
            n5 = 0;
        }
        if (this.mPopup.getInputMethodMode() == 2) {
            b = true;
        }
        final int maxAvailableHeight = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, b);
        if (!this.mDropDownAlwaysVisible && this.mDropDownHeight != n2) {
            final int mDropDownWidth2 = this.mDropDownWidth;
            final int n6 = 1073741824;
            int n7 = 0;
            switch (mDropDownWidth2) {
                default: {
                    n7 = View$MeasureSpec.makeMeasureSpec(mDropDownWidth2, n6);
                    break;
                }
                case -1: {
                    n7 = View$MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), n6);
                    break;
                }
                case -2: {
                    n7 = View$MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -1 << -1);
                    break;
                }
            }
            final int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(n7, 0, -1, maxAvailableHeight - n, -1);
            if (measureHeightOfChildrenCompat > 0) {
                n += n5 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom());
            }
            return measureHeightOfChildrenCompat + n;
        }
        return maxAvailableHeight + n5;
    }
    
    private int getMaxAvailableHeight(final View view, final int n, final boolean b) {
        final Method sGetMaxAvailableHeightMethod = ListPopupWindow.sGetMaxAvailableHeightMethod;
        if (sGetMaxAvailableHeightMethod != null) {
            try {
                final Object invoke = sGetMaxAvailableHeightMethod.invoke(this.mPopup, view, n, b);
                try {
                    final Integer n2 = (Integer)invoke;
                    try {
                        return n2;
                    }
                    catch (Exception ex) {
                        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        return this.mPopup.getMaxAvailableHeight(view, n);
    }
    
    private static boolean isConfirmKey(final int n) {
        return n == 66 || n == 23;
    }
    
    private void removePromptView() {
        final View mPromptView = this.mPromptView;
        if (mPromptView != null) {
            final ViewParent parent = mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(this.mPromptView);
            }
        }
    }
    
    private void setPopupClipToScreenEnabled(final boolean b) {
        final Method sClipToWindowEnabledMethod = ListPopupWindow.sClipToWindowEnabledMethod;
        if (sClipToWindowEnabledMethod != null) {
            try {
                final PopupWindow mPopup = this.mPopup;
                final Object[] array = { null };
                try {
                    array[0] = b;
                    sClipToWindowEnabledMethod.invoke(mPopup, array);
                }
                catch (Exception ex) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
            catch (Exception ex2) {}
        }
    }
    
    public void clearListSelection() {
        final DropDownListView mDropDownList = this.mDropDownList;
        if (mDropDownList != null) {
            mDropDownList.setListSelectionHidden(true);
            mDropDownList.requestLayout();
        }
    }
    
    public View$OnTouchListener createDragToOpenListener(final View view) {
        return (View$OnTouchListener)new ListPopupWindow$1(this, view);
    }
    
    DropDownListView createDropDownListView(final Context context, final boolean b) {
        return new DropDownListView(context, b);
    }
    
    public void dismiss() {
        this.mPopup.dismiss();
        this.removePromptView();
        this.mPopup.setContentView((View)null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks((Runnable)this.mResizePopupRunnable);
    }
    
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }
    
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }
    
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }
    
    public int getHeight() {
        return this.mDropDownHeight;
    }
    
    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }
    
    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }
    
    public ListView getListView() {
        return this.mDropDownList;
    }
    
    public int getPromptPosition() {
        return this.mPromptPosition;
    }
    
    public Object getSelectedItem() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }
    
    public long getSelectedItemId() {
        if (!this.isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }
    
    public int getSelectedItemPosition() {
        if (!this.isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }
    
    public View getSelectedView() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }
    
    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }
    
    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }
    
    public int getWidth() {
        return this.mDropDownWidth;
    }
    
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }
    
    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }
    
    public boolean isModal() {
        return this.mModal;
    }
    
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (this.isShowing()) {
            if (n != 62) {
                if (this.mDropDownList.getSelectedItemPosition() >= 0 || isConfirmKey(n)) {
                    final int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
                    final boolean aboveAnchor = this.mPopup.isAboveAnchor();
                    final int inputMethodMode = 1;
                    final boolean b = ((aboveAnchor ? 1 : 0) ^ inputMethodMode) != 0x0;
                    final ListAdapter mAdapter = this.mAdapter;
                    int n2 = -1 >>> 1;
                    int n3 = -1 << -1;
                    if (mAdapter != null) {
                        final boolean allItemsEnabled = mAdapter.areAllItemsEnabled();
                        int lookForSelectablePosition;
                        if (allItemsEnabled) {
                            lookForSelectablePosition = 0;
                        }
                        else {
                            lookForSelectablePosition = this.mDropDownList.lookForSelectablePosition(0, inputMethodMode != 0);
                        }
                        n2 = lookForSelectablePosition;
                        int lookForSelectablePosition2;
                        if (allItemsEnabled) {
                            lookForSelectablePosition2 = mAdapter.getCount() - inputMethodMode;
                        }
                        else {
                            lookForSelectablePosition2 = this.mDropDownList.lookForSelectablePosition(mAdapter.getCount() - inputMethodMode, false);
                        }
                        n3 = lookForSelectablePosition2;
                    }
                    final int n4 = 19;
                    if (!b || n != n4 || selectedItemPosition > n2) {
                        final int n5 = 20;
                        if (b || n != n5 || selectedItemPosition < n3) {
                            this.mDropDownList.setListSelectionHidden(false);
                            if (this.mDropDownList.onKeyDown(n, keyEvent)) {
                                this.mPopup.setInputMethodMode(2);
                                this.mDropDownList.requestFocusFromTouch();
                                this.show();
                                if (n != 23 && n != 66) {
                                    switch (n) {
                                        default: {
                                            return false;
                                        }
                                        case 19:
                                        case 20: {
                                            break;
                                        }
                                    }
                                }
                                return inputMethodMode != 0;
                            }
                            if (b && n == n5) {
                                if (selectedItemPosition == n3) {
                                    return inputMethodMode != 0;
                                }
                                return false;
                            }
                            else {
                                if (!b && n == n4 && selectedItemPosition == n2) {
                                    return inputMethodMode != 0;
                                }
                                return false;
                            }
                        }
                    }
                    this.clearListSelection();
                    this.mPopup.setInputMethodMode(inputMethodMode);
                    this.show();
                    return inputMethodMode != 0;
                }
            }
        }
        return false;
    }
    
    public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.isShowing()) {
            final View mDropDownAnchorView = this.mDropDownAnchorView;
            final int action = keyEvent.getAction();
            final boolean b = true;
            if (action == 0 && keyEvent.getRepeatCount() == 0) {
                final KeyEvent$DispatcherState keyDispatcherState = mDropDownAnchorView.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, (Object)this);
                }
                return b;
            }
            if (keyEvent.getAction() == (b ? 1 : 0)) {
                final KeyEvent$DispatcherState keyDispatcherState2 = mDropDownAnchorView.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.dismiss();
                    return b;
                }
            }
        }
        return false;
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
            final boolean onKeyUp = this.mDropDownList.onKeyUp(n, keyEvent);
            if (onKeyUp && isConfirmKey(n)) {
                this.dismiss();
            }
            return onKeyUp;
        }
        return false;
    }
    
    public boolean performItemClick(final int n) {
        if (this.isShowing()) {
            if (this.mItemClickListener != null) {
                final DropDownListView mDropDownList = this.mDropDownList;
                this.mItemClickListener.onItemClick((AdapterView)mDropDownList, mDropDownList.getChildAt(n - mDropDownList.getFirstVisiblePosition()), n, mDropDownList.getAdapter().getItemId(n));
            }
            return true;
        }
        return false;
    }
    
    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }
    
    public void setAdapter(final ListAdapter mAdapter) {
        final DataSetObserver mObserver = this.mObserver;
        if (mObserver == null) {
            this.mObserver = new ListPopupWindow$PopupDataSetObserver(this);
        }
        else {
            final ListAdapter mAdapter2 = this.mAdapter;
            if (mAdapter2 != null) {
                mAdapter2.unregisterDataSetObserver(mObserver);
            }
        }
        this.mAdapter = mAdapter;
        if (this.mAdapter != null) {
            mAdapter.registerDataSetObserver(this.mObserver);
        }
        final DropDownListView mDropDownList = this.mDropDownList;
        if (mDropDownList != null) {
            mDropDownList.setAdapter(this.mAdapter);
        }
    }
    
    public void setAnchorView(final View mDropDownAnchorView) {
        this.mDropDownAnchorView = mDropDownAnchorView;
    }
    
    public void setAnimationStyle(final int animationStyle) {
        this.mPopup.setAnimationStyle(animationStyle);
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        this.mPopup.setBackgroundDrawable(backgroundDrawable);
    }
    
    public void setContentWidth(final int width) {
        final Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + width;
        }
        else {
            this.setWidth(width);
        }
    }
    
    public void setDropDownAlwaysVisible(final boolean mDropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = mDropDownAlwaysVisible;
    }
    
    public void setDropDownGravity(final int mDropDownGravity) {
        this.mDropDownGravity = mDropDownGravity;
    }
    
    public void setEpicenterBounds(final Rect mEpicenterBounds) {
        this.mEpicenterBounds = mEpicenterBounds;
    }
    
    public void setForceIgnoreOutsideTouch(final boolean mForceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = mForceIgnoreOutsideTouch;
    }
    
    public void setHeight(final int mDropDownHeight) {
        this.mDropDownHeight = mDropDownHeight;
    }
    
    public void setHorizontalOffset(final int mDropDownHorizontalOffset) {
        this.mDropDownHorizontalOffset = mDropDownHorizontalOffset;
    }
    
    public void setInputMethodMode(final int inputMethodMode) {
        this.mPopup.setInputMethodMode(inputMethodMode);
    }
    
    void setListItemExpandMax(final int mListItemExpandMaximum) {
        this.mListItemExpandMaximum = mListItemExpandMaximum;
    }
    
    public void setListSelector(final Drawable mDropDownListHighlight) {
        this.mDropDownListHighlight = mDropDownListHighlight;
    }
    
    public void setModal(final boolean b) {
        this.mModal = b;
        this.mPopup.setFocusable(b);
    }
    
    public void setOnDismissListener(final PopupWindow$OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }
    
    public void setOnItemClickListener(final AdapterView$OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
    
    public void setOnItemSelectedListener(final AdapterView$OnItemSelectedListener mItemSelectedListener) {
        this.mItemSelectedListener = mItemSelectedListener;
    }
    
    public void setPromptPosition(final int mPromptPosition) {
        this.mPromptPosition = mPromptPosition;
    }
    
    public void setPromptView(final View mPromptView) {
        final boolean showing = this.isShowing();
        if (showing) {
            this.removePromptView();
        }
        this.mPromptView = mPromptView;
        if (showing) {
            this.show();
        }
    }
    
    public void setSelection(final int selection) {
        final DropDownListView mDropDownList = this.mDropDownList;
        if (this.isShowing() && mDropDownList != null) {
            mDropDownList.setListSelectionHidden(false);
            mDropDownList.setSelection(selection);
            if (Build$VERSION.SDK_INT >= 11) {
                if (mDropDownList.getChoiceMode() != 0) {
                    mDropDownList.setItemChecked(selection, true);
                }
            }
        }
    }
    
    public void setSoftInputMode(final int softInputMode) {
        this.mPopup.setSoftInputMode(softInputMode);
    }
    
    public void setVerticalOffset(final int mDropDownVerticalOffset) {
        this.mDropDownVerticalOffset = mDropDownVerticalOffset;
        this.mDropDownVerticalOffsetSet = true;
    }
    
    public void setWidth(final int mDropDownWidth) {
        this.mDropDownWidth = mDropDownWidth;
    }
    
    public void setWindowLayoutType(final int mDropDownWindowLayoutType) {
        this.mDropDownWindowLayoutType = mDropDownWindowLayoutType;
    }
    
    public void show() {
        final int buildDropDown = this.buildDropDown();
        final boolean inputMethodNotNeeded = this.isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        final boolean showing = this.mPopup.isShowing();
        int n = 1;
        final int n2 = -2;
        final int n3 = -1;
        if (showing) {
            final int mDropDownWidth = this.mDropDownWidth;
            int n4;
            if (mDropDownWidth == n3) {
                n4 = -1;
            }
            else if (mDropDownWidth == n2) {
                n4 = this.getAnchorView().getWidth();
            }
            else {
                n4 = this.mDropDownWidth;
            }
            final int mDropDownHeight = this.mDropDownHeight;
            int mDropDownHeight2;
            if (mDropDownHeight == n3) {
                if (inputMethodNotNeeded) {
                    mDropDownHeight2 = buildDropDown;
                }
                else {
                    mDropDownHeight2 = -1;
                }
                if (inputMethodNotNeeded) {
                    final PopupWindow mPopup = this.mPopup;
                    int width;
                    if (this.mDropDownWidth == n3) {
                        width = -1;
                    }
                    else {
                        width = 0;
                    }
                    mPopup.setWidth(width);
                    this.mPopup.setHeight(0);
                }
                else {
                    final PopupWindow mPopup2 = this.mPopup;
                    int width2;
                    if (this.mDropDownWidth == n3) {
                        width2 = -1;
                    }
                    else {
                        width2 = 0;
                    }
                    mPopup2.setWidth(width2);
                    this.mPopup.setHeight(n3);
                }
            }
            else if (mDropDownHeight == n2) {
                mDropDownHeight2 = buildDropDown;
            }
            else {
                mDropDownHeight2 = this.mDropDownHeight;
            }
            final PopupWindow mPopup3 = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                n = 0;
            }
            mPopup3.setOutsideTouchable((boolean)(n != 0));
            final PopupWindow mPopup4 = this.mPopup;
            final View anchorView = this.getAnchorView();
            final int mDropDownHorizontalOffset = this.mDropDownHorizontalOffset;
            final int mDropDownVerticalOffset = this.mDropDownVerticalOffset;
            int n5;
            if (n4 < 0) {
                n5 = -1;
            }
            else {
                n5 = n4;
            }
            int n6;
            if (mDropDownHeight2 < 0) {
                n6 = -1;
            }
            else {
                n6 = mDropDownHeight2;
            }
            mPopup4.update(anchorView, mDropDownHorizontalOffset, mDropDownVerticalOffset, n5, n6);
        }
        else {
            final int mDropDownWidth2 = this.mDropDownWidth;
            int width3;
            if (mDropDownWidth2 == n3) {
                width3 = -1;
            }
            else if (mDropDownWidth2 == n2) {
                width3 = this.getAnchorView().getWidth();
            }
            else {
                width3 = this.mDropDownWidth;
            }
            final int mDropDownHeight3 = this.mDropDownHeight;
            int mDropDownHeight4;
            if (mDropDownHeight3 == n3) {
                mDropDownHeight4 = -1;
            }
            else if (mDropDownHeight3 == n2) {
                mDropDownHeight4 = buildDropDown;
            }
            else {
                mDropDownHeight4 = this.mDropDownHeight;
            }
            this.mPopup.setWidth(width3);
            this.mPopup.setHeight(mDropDownHeight4);
            this.setPopupClipToScreenEnabled(n != 0);
            this.mPopup.setOutsideTouchable(!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible);
            this.mPopup.setTouchInterceptor((View$OnTouchListener)this.mTouchInterceptor);
            final Method sSetEpicenterBoundsMethod = ListPopupWindow.sSetEpicenterBoundsMethod;
            if (sSetEpicenterBoundsMethod != null) {
                try {
                    final PopupWindow mPopup5 = this.mPopup;
                    try {
                        final Object[] array = new Object[n];
                        try {
                            array[0] = this.mEpicenterBounds;
                            sSetEpicenterBoundsMethod.invoke(mPopup5, array);
                        }
                        catch (Exception ex) {
                            Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", (Throwable)ex);
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            PopupWindowCompat.showAsDropDown(this.mPopup, this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(n3);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                this.clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post((Runnable)this.mHideSelector);
            }
        }
    }
}
