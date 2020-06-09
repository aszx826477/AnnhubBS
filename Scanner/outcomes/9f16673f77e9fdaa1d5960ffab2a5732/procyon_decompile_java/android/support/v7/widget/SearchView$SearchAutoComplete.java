// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.graphics.Rect;
import android.util.TypedValue;
import android.text.TextUtils;
import android.content.res.Configuration;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;

public class SearchView$SearchAutoComplete extends AppCompatAutoCompleteTextView
{
    private SearchView mSearchView;
    private int mThreshold;
    
    public SearchView$SearchAutoComplete(final Context context) {
        this(context, null);
    }
    
    public SearchView$SearchAutoComplete(final Context context, final AttributeSet set) {
        this(context, set, R$attr.autoCompleteTextViewStyle);
    }
    
    public SearchView$SearchAutoComplete(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mThreshold = this.getThreshold();
    }
    
    private int getSearchViewTextMinWidthDp() {
        final Configuration configuration = this.getResources().getConfiguration();
        final int screenWidthDp = ConfigurationHelper.getScreenWidthDp(this.getResources());
        final int screenHeightDp = ConfigurationHelper.getScreenHeightDp(this.getResources());
        if (screenWidthDp >= 960 && screenHeightDp >= 720 && configuration.orientation == 2) {
            return 256;
        }
        if (screenWidthDp < 600 && (screenWidthDp < 640 || screenHeightDp < 480)) {
            return 160;
        }
        return 192;
    }
    
    private boolean isEmpty() {
        return TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
    }
    
    public boolean enoughToFilter() {
        return this.mThreshold <= 0 || super.enoughToFilter();
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setMinWidth((int)TypedValue.applyDimension(1, (float)this.getSearchViewTextMinWidthDp(), this.getResources().getDisplayMetrics()));
    }
    
    protected void onFocusChanged(final boolean b, final int n, final Rect rect) {
        super.onFocusChanged(b, n, rect);
        this.mSearchView.onTextFocusChanged();
    }
    
    public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final int action = keyEvent.getAction();
            final boolean b = true;
            if (action == 0 && keyEvent.getRepeatCount() == 0) {
                final KeyEvent$DispatcherState keyDispatcherState = this.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, (Object)this);
                }
                return b;
            }
            if (keyEvent.getAction() == (b ? 1 : 0)) {
                final KeyEvent$DispatcherState keyDispatcherState2 = this.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.mSearchView.clearFocus();
                    this.mSearchView.setImeVisibility(false);
                    return b;
                }
            }
        }
        return super.onKeyPreIme(n, keyEvent);
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        if (b && this.mSearchView.hasFocus() && this.getVisibility() == 0) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
            if (SearchView.isLandscapeMode(this.getContext())) {
                SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
            }
        }
    }
    
    public void performCompletion() {
    }
    
    protected void replaceText(final CharSequence charSequence) {
    }
    
    void setSearchView(final SearchView mSearchView) {
        this.mSearchView = mSearchView;
    }
    
    public void setThreshold(final int n) {
        super.setThreshold(n);
        this.mThreshold = n;
    }
}
